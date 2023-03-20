package csen1002.main.task2;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class NfaToDfa {
    static final String epsilon = "e";


    ArrayList<State> states;
    ArrayList<Transition> transitions;
    String alphabet;
    State startState;
    ArrayList<State> acceptStates;


    /**
     * Constructs a DFA corresponding to an NFA
     *
     * @param input A formatted string representation of the NFA for which an
     *              equivalent DFA is to be constructed. The string representation
     *              follows the one in the task description
     */
    public NfaToDfa(String input) {
        states = new ArrayList<>();
        transitions = new ArrayList<>();
        acceptStates = new ArrayList<>();

        String[] input_split = input.split("#");
        String states_input = input_split[0];
        String alphabet_input = input_split[1];
        alphabet = alphabet_input;
        String transitions_input = input_split[2];
        String startState_input = input_split[3];
        String acceptStates_input = input_split[4];
        String[] acceptStates_input_split = acceptStates_input.split(";");
        ArrayList<Integer> acceptState_input = new ArrayList<>();
        for (String acc : acceptStates_input_split) {
            acceptState_input.add(Integer.parseInt(acc));
        }

        Map<Integer, HashMap<String, ArrayList<Integer>>> transitionsMap = new HashMap<>();


        Map<Integer, ArrayList<Integer>> epsilon_closure = new HashMap<>();
        int[] states_input_split = Arrays.stream(states_input.split(";")).mapToInt(Integer::parseInt).toArray();
        for (int s : states_input_split) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(s);
            epsilon_closure.put(s, temp);
        }
        String[] alphabet_input_split = alphabet_input.split(";");
        String[] transitions_input_split = transitions_input.split(";");

        for (String t : transitions_input_split) {
            String[] temp = t.split(",");
            int cur = Integer.parseInt(temp[0]);
            String tt = temp[1];
            int next = Integer.parseInt(temp[2]);

            if (tt.equals(epsilon)) {
                ArrayList<Integer> temp_set = epsilon_closure.get(cur);
                temp_set.add(next);
                epsilon_closure.put(cur, temp_set);
            } else {
                if (transitionsMap.containsKey(cur) && transitionsMap.get(cur).containsKey(tt)) {
                    ArrayList<Integer> toAddTo = transitionsMap.get(cur).get(tt);
                    toAddTo.add(next);

                } else if (transitionsMap.containsKey(cur) && !transitionsMap.get(cur).containsKey(tt)) {
                    HashMap<String, ArrayList<Integer>> tempMap = transitionsMap.get(cur);
                    ArrayList<Integer> tempArr = new ArrayList<>();
                    tempArr.add(next);
                    tempMap.put(tt, tempArr);
                    transitionsMap.put(cur, tempMap);

                } else {
                    HashMap<String, ArrayList<Integer>> tempMap = new HashMap<>();
                    ArrayList<Integer> tempArr = new ArrayList<>();
                    tempArr.add(next);
                    tempMap.put(tt, tempArr);
                    transitionsMap.put(cur, tempMap);
                }
            }
        }

        while (true) {
            boolean flag = false;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : epsilon_closure.entrySet()) {
                int size_before = epsilon_closure.get(entry.getKey()).size();

                ArrayList<Integer> temp_set = entry.getValue();

                ArrayList<Integer> tempArray = new ArrayList<>(entry.getValue());
                for (int i : tempArray) {
                    ArrayList<Integer> to_add = epsilon_closure.get(i);
                    for (int d : to_add) {
                        if (!temp_set.contains(d))
                            temp_set.add(d);
                    }
                }
                if (temp_set.size() != size_before) {
                    flag = true;  //something changed in our table and we continue updating it
                }

                epsilon_closure.put(entry.getKey(), temp_set);
            }
            if (!flag) {
                break;
            }

        }
        ArrayList<Integer> deadSet = new ArrayList<>();
        deadSet.add(-1);
        State deadState = new State(deadSet);
        for (String symbol : alphabet_input_split) {
            deadState.addTransition(symbol, deadState);
        }
        State newStartSate = new State(epsilon_closure.get(Integer.parseInt(startState_input)));

        ArrayList<State> toDoStates = new ArrayList<>();
        toDoStates.add(newStartSate);
        startState = newStartSate;
        states.add(newStartSate);

        for (int acceptS : acceptState_input) {
            if (newStartSate.ID.contains(acceptS) && !acceptStates.contains(newStartSate)) {
                newStartSate.setAccept(true);
                acceptStates.add(newStartSate);
                break;
            }
        }

        while (!toDoStates.isEmpty()) {
            State curr = toDoStates.remove(0);
            for (String t : alphabet_input_split) {
                TreeSet<Integer> toGoTo = new TreeSet<>();
                for (int i : curr.ID) {
                    if (transitionsMap.containsKey(i) && transitionsMap.get(i).containsKey(t)) {
                        ArrayList<Integer> x = transitionsMap.get(i).get(t);
                        toGoTo.addAll(x);
                        for (int y : x) {
                            toGoTo.addAll(epsilon_closure.get(y));
                        }
                    }
                }
                if (toGoTo.size() == 0) {
                    if (!states.contains(deadState)) {
                        states.add(deadState);
                        transitions.addAll(deadState.transitions);
                    }
                    curr.addTransition(t, deadState);
                } else {
                    ArrayList<Integer> tempArr = new ArrayList<>(toGoTo);
                    State nextState = new State(tempArr);
                    for (int acceptS : acceptState_input) {

                        if (nextState.ID.contains(acceptS) && !acceptStates.contains(nextState)) {
                            nextState.setAccept(true);
                            acceptStates.add(nextState);
                            break;
                        }
                    }
                    curr.addTransition(t, nextState);
                    if (!states.contains(nextState)) {
                        toDoStates.add(nextState);
                        states.add(nextState);
                    }
                }
            }
            transitions.addAll(curr.transitions);
        }
    }

    /**
     * @return Returns a formatted string representation of the DFA. The string
     * representation follows the one in the task description
     */
    @Override
    public String toString() {
        Collections.sort(this.states);
        Collections.sort(this.transitions);
        Collections.sort(this.acceptStates);

        StringBuilder s = new StringBuilder();
        for (State st : this.states) {
            s.append(st.toString()).append(";");
        }
        s.deleteCharAt(s.length() - 1);

        StringBuilder t = new StringBuilder();
        for (Transition tr : this.transitions) {
            t.append(tr.toString());
        }
        t.deleteCharAt(t.length() - 1);

        StringBuilder a = new StringBuilder();
        for (State accS : this.acceptStates) {
            a.append(accS.toString()).append(";");
        }
        a.deleteCharAt(a.length() - 1);

        return s + "#" + this.alphabet + "#" + t + "#" + startState.toString() + "#" + a;
    }


    class State implements Comparable<State> {
        ArrayList<Integer> ID;
        boolean isAccept;
        ArrayList<Transition> transitions;


        public State(ArrayList<Integer> ID) {
            this.ID = ID;
            Collections.sort(this.ID);
            this.transitions = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder temp = new StringBuilder();
            for (int i : this.ID) {
                temp.append(i).append("/");
            }
            temp.deleteCharAt(temp.length() - 1);
            return temp + "";
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() != obj.getClass())
                return false;
            State s = (State) obj;
            return this.ID.equals(s.ID);
        }

        @Override
        public int compareTo(State s) {
            ArrayList<Integer> temp1 = new ArrayList<>(this.ID);
            ArrayList<Integer> temp2 = new ArrayList<>(s.ID);

            if (this.ID.size() < s.ID.size()) {
                while (!temp1.isEmpty()) {
                    Integer x = temp1.remove(0);
                    Integer y = temp2.remove(0);
                    if (x.equals(y))
                        continue;
                    return x.compareTo(y);
                }
                return -1;
            } else if (this.ID.size() == s.ID.size()) {
                while (!temp1.isEmpty()) {
                    Integer x = temp1.remove(0);
                    Integer y = temp2.remove(0);
                    if (x.equals(y))
                        continue;
                    return x.compareTo(y);
                }
                return 0;
            } else {
                while (!temp2.isEmpty()) {
                    Integer x = temp1.remove(0);
                    Integer y = temp2.remove(0);
                    if (x.equals(y))
                        continue;
                    return x.compareTo(y);
                }
                return 1;
            }
        }

        public void setAccept(boolean accept) {
            this.isAccept = accept;
        }

        public void addTransition(String symbol, State s) {
            this.transitions.add(new Transition(this, symbol, s));
        }

    }

    class Transition implements Comparable<Transition> {
        State currState;
        String symbol;
        State nextState;

        Transition(State currState, String symbol, State nextState) {
            this.currState = currState;
            this.symbol = symbol;
            this.nextState = nextState;
        }

        @Override
        public String toString() {
            return currState.toString() + "," + symbol + "," + nextState.toString() + ";";
        }

        @Override
        public int compareTo(Transition t) {
            if (this.currState.compareTo(t.currState) != 0) {
                return this.currState.compareTo(t.currState);
            } else if (this.symbol.compareTo(t.symbol) != 0) {
                return this.symbol.compareTo(t.symbol);
            } else {
                return this.nextState.compareTo(t.nextState);
            }
        }
    }


}
