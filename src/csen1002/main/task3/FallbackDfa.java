package csen1002.main.task3;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class FallbackDfa {
    State initial;


	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	public FallbackDfa(String fdfa) {
        Map<String,State> states;
        states = new HashMap<>();
        String[] input_split = fdfa.split("#");
        String states_input = input_split[0];
        String transitions_input = input_split[2];
        String startState_input = input_split[3];
        String acceptStates_input = input_split[4];

        String[] states_input_split = states_input.split(";");
        for (String s : states_input_split) {
            State tempState = new State(s);
            states.put(s,tempState);
        }

        String[] transitions_input_split = transitions_input.split(";");
        for(String t : transitions_input_split){
            String[] t_split = t.split(",");
            State cur = states.get(t_split[0]);
            String symbol = t_split[1];
            State next = states.get(t_split[2]);
            cur.addTransition(symbol,next);
        }

        String[] acceptStates_input_split = acceptStates_input.split(";");
        for(String acc : acceptStates_input_split){
            states.get(acc).setAccept(true);
        }

        initial = states.get(startState_input);
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 * 
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	public String run(String input) {
		StringBuilder res = new StringBuilder();
        State cur;
        State output;
        int counter ;

        while (input.length()>0){
            cur = initial;
            output = initial;
            counter = 0 ;
            for (int i = 0; i < input.length(); i++){
                String s = String.valueOf(input.charAt(i));
                cur = cur.transitions.get(s);
                if(cur.isAccept){
                    counter = i+1;
                    output =cur;
                }
            }
            if(counter>0){
                String accepted = input.substring(0,counter);
                input=input.substring(counter);
                res.append(accepted).append(",").append(output).append(";");
            }
            else{
                String rejected = input;
                input= "";
                res.append(rejected).append(",").append(cur).append(";");
            }

        }
        res.deleteCharAt(res.length() - 1);
		return String.valueOf(res);
	}

	 static class State  {
        String ID;
        boolean isAccept;
        Map<String,State> transitions;


        public State(String ID) {
            this.ID = ID;
            this.transitions = new HashMap<>();
        }

        @Override
        public String toString() {
            return this.ID;
        }


		 @Override
        public boolean equals(Object obj) {
            if (getClass() != obj.getClass())
                return false;
            State s = (State) obj;
            return this.ID.equals(s.ID);
        }


        public void setAccept(boolean accept) {
            this.isAccept = accept;
        }

        public void addTransition(String symbol, State s) {
            this.transitions.put(symbol, s);
        }

    }


	
}
