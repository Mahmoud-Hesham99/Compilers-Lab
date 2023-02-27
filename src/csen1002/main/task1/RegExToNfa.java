package csen1002.main.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


/**
 * Write your info here
 * 
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class RegExToNfa {

	static final String epsilon = "e";
	String alphabet ;
	NFA resNFA ;
	ArrayList<State> states ;
	ArrayList<Transition> transitions ;
	/**
	 * Constructs an NFA corresponding to a regular expression based on Thompson's
	 * construction
	 * 
	 * @param input The alphabet and the regular expression in postfix notation for
	 *              which the NFA is to be constructed
	 */
	public RegExToNfa(String input) {
		int count = 0 ;
		Stack<NFA> stack = new Stack<>();
		String [] regExpression = input.split("#");
		this.alphabet = regExpression[0];
		String postfixEx = regExpression[1];
		this.states = new ArrayList<>();
		this.transitions = new ArrayList<>();

		for (int i = 0; i < postfixEx.length(); i++) {
			String s = String.valueOf(postfixEx.charAt(i));
				if (Character.isLetter(postfixEx.charAt(i))) {
				NFA singleNFA = new NFA(count, s);
				count +=2 ;
				stack.push(singleNFA);
				} else {
					switch (s) {
						case "*" -> {
							NFA tempNFA = stack.pop();
							tempNFA.starExpression(count);
							stack.push(tempNFA);
							count += 2;
						}
						case "|" -> {
							NFA tempNFA2 = stack.pop();
							NFA tempNFA1 = stack.pop();
							tempNFA1.unionExpression(tempNFA2, count);
							stack.push(tempNFA1);
							count += 2;
						}
						case "." -> {
							NFA tempNFA4 = stack.pop();
							NFA tempNFA3 = stack.pop();
							tempNFA3.concatExpression(tempNFA4);
							stack.push(tempNFA3);
						}
					}
			}
		}//end of parsing the string

		this.resNFA = stack.pop();
		this.states.add(this.resNFA.initial);

		ArrayList<State> temp = new ArrayList<>();
		temp.add(this.resNFA.initial);

		while (!temp.isEmpty()){
			State current = temp.remove(0);

			for (Transition t : current.transitions){
				transitions.add(t);
				if(!this.states.contains(t.nextState)){
					temp.add(t.nextState);
					this.states.add(t.nextState);
				}

			}
		}
		Collections.sort(this.states);
		Collections.sort(this.transitions);
		Collections.sort(this.resNFA.acceptStates);
	}

	/**
	 * @return Returns a formatted string representation of the NFA. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (State st : this.states) {
			s.append(st.toString());
		}
		s.deleteCharAt(s.length() - 1);

		StringBuilder t = new StringBuilder();
		for (Transition tr : this.transitions) {
			t.append(tr.toString());
		}
		t.deleteCharAt(t.length() - 1);

		String i = this.resNFA.initial.toString();
		i = i.substring(0,i.length()-1);

		StringBuilder a = new StringBuilder();
		for (State accS : this.resNFA.acceptStates){
			a.append(accS.toString());
		}
		a.deleteCharAt(a.length() - 1);

		return s+"#"+this.alphabet+"#"+t+"#"+i+"#"+a;
	}

	class State implements Comparable<State>{
		Integer ID ;
		boolean isAccept;
		ArrayList<Transition> transitions ;


		public State(Integer ID) {
			this.ID = ID;
			this.transitions = new ArrayList<>();
		}

		@Override
		public String toString() {
			return ID+";";
		}

		@Override
		public int compareTo(State s) {
			return this.ID.compareTo(s.ID);
		}

		public void setAccept(boolean accept) {
			this.isAccept = accept;
		}
		public void addTransition(String symbol , State s){
			this.transitions.add(new Transition(this.ID,symbol,s));
		}

	}
	class Transition implements Comparable<Transition>{
		Integer myID;
		String symbol;
		State nextState;

		Transition(Integer myID, String symbol, State nextState) {
			this.myID = myID;
			this.symbol = symbol;
			this.nextState = nextState;
		}

		@Override
		public String toString() {
			return myID+","+symbol+","+nextState.ID+";";
		}

		@Override
		public int compareTo(Transition t) {
			if(this.myID.compareTo(t.myID)!=0){
				return this.myID.compareTo(t.myID);
			}
			else if (this.symbol.compareTo(t.symbol)!=0){
				return this.symbol.compareTo(t.symbol);
			}
			else{
				return this.nextState.compareTo(t.nextState);
			}
		}
	}

	class NFA {
		State initial ;
		ArrayList<State> acceptStates;
		NFA(int startingIndex,String symbol){
			this.initial = new State(startingIndex++);
			this.acceptStates = new ArrayList<>();
			State nextState = new State(startingIndex);
			nextState.setAccept(true);
			acceptStates.add(nextState);
			initial.addTransition(symbol,nextState);
		}
		void starExpression(int startingIndex){
			State newStart = new State(startingIndex++);
			State newEnd = new State(startingIndex);
			newStart.addTransition(epsilon,this.initial);
			newStart.addTransition(epsilon,newEnd);

			while(!this.acceptStates.isEmpty()){
				State acceptState =this. acceptStates.remove(0);
				acceptState.addTransition(epsilon,this.initial);
				acceptState.addTransition(epsilon,newEnd);
				acceptState.setAccept(false);
			}
			acceptStates.add(newEnd);
			newEnd.setAccept(true);
			this.initial = newStart;
		}

		void unionExpression(NFA other ,int startingIndex){
			State newStart = new State(startingIndex++);
			State newEnd = new State(startingIndex);
			newStart.addTransition(epsilon,this.initial);
			newStart.addTransition(epsilon,other.initial);

			while(!this.acceptStates.isEmpty()){
				State acceptState = this.acceptStates.remove(0);
				acceptState.addTransition(epsilon,newEnd);
				acceptState.setAccept(false);
			}
			while(!other.acceptStates.isEmpty()){
				State acceptState = other.acceptStates.remove(0);
				acceptState.addTransition(epsilon,newEnd);
				acceptState.setAccept(false);
			}
			acceptStates.add(newEnd);
			newEnd.setAccept(true);
			this.initial = newStart;

		}

		void concatExpression(NFA other){
			while(!this.acceptStates.isEmpty()){
				State acceptState = this.acceptStates.remove(0);
				acceptState.setAccept(false);
				for (Transition t : other.initial.transitions){
					acceptState.addTransition(t.symbol,t.nextState);
				}
			}
			this.acceptStates = other.acceptStates;
		}
	}

}
