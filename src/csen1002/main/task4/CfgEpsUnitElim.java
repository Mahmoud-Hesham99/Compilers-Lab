package csen1002.main.task4;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class CfgEpsUnitElim {
	static final String epsilon = "e";

	ArrayList <String> variables;
	ArrayList <String> terminals;
	String toStringVariables;
	String toStringTerminals;
	Map<String, ArrayList<String>> rules ;

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	public CfgEpsUnitElim(String cfg) {
		String[] input_split = cfg.split("#");
		toStringVariables = input_split[0];
		toStringTerminals = input_split[1];
		variables = new ArrayList<>(List.of(input_split[0].split(";")));
		terminals = new ArrayList<>(List.of(input_split[1].split(";")));
		ArrayList<String> rules_input = new ArrayList<>(List.of(input_split[2].split(";")));
		rules = new LinkedHashMap<>();
		for (String r : rules_input){
			rules.put(r.split("/")[0],new ArrayList<>(List.of(r.split("/")[1].split(","))));
		}
	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder(toStringVariables);
		res.append("#").append(toStringTerminals).append("#");
		for(String entry : variables) {
			ArrayList<String> value = rules.get(entry);
			Collections.sort(value);
			res.append(entry).append("/");
			for(String e : value){
				res.append(e).append(",");
			}
			res.deleteCharAt(res.length() - 1);
			res.append(";");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	/**
	 * Eliminates Epsilon Rules from the grammar
	 */
	public void eliminateEpsilonRules() {
		Set<String> nullVariables = new LinkedHashSet<>();
		Set<String> doneVariables = new LinkedHashSet<>();
		for (String variable : variables) {
			if (rules.get(variable).contains(epsilon)) {
				nullVariables.add(variable);
			}
		}
		Set<String> newNullVariables = new LinkedHashSet<>();
		while(!nullVariables.isEmpty()) {
			for (String n : nullVariables) {
				for (String entry : variables) {
					Set<String> temp = new LinkedHashSet<>(rules.get(entry));
					ArrayList<String> tempT = new ArrayList<>();
					for (String s : temp) {
						if (s.contains(n)) {
							ArrayList<String> res = perm(n.charAt(0), s);
							if (res.contains(epsilon) && !doneVariables.contains(entry)) {
								newNullVariables.add(entry);
							}
							tempT.addAll(res);
						}
					}
					temp.addAll(tempT);
					rules.put(entry, new ArrayList<>(temp));
				}
				doneVariables.add(n);
			}
			nullVariables = newNullVariables;
			newNullVariables = new HashSet<>();
		}
		for (String entry : variables) {
			if(entry.equals("S")){
				continue;
			}
			ArrayList<String> r = rules.get(entry);
			r.remove(epsilon);
		}
	}

	/**
	 * Eliminates Unit Rules from the grammar
	 */
	public void eliminateUnitRules() {
		Map<String, ArrayList<String>> processed = new LinkedHashMap<>();
		for (String entry : variables) {
			processed.put(entry,new ArrayList<>());
		}
		boolean change;
		do {
			change = false;
			for (String entry : variables) {
				ArrayList<String> temp = rules.get(entry);
				Set<String> tempT = new HashSet<>(temp);
				for(String r : temp){
					if(r.length()==1 && r.charAt(0)>='A' && r.charAt(0)<='Z' && !r.equals(epsilon)){
						tempT.removeAll(Collections.singleton(r));
						change = true;
						if(!processed.get(entry).contains(r)){
							tempT.addAll(rules.get(r));
							ArrayList<String> done = processed.get(entry);
							done.add(r);
						}
					}
				}
				rules.put(entry, new ArrayList<>(tempT));
			}
		} while(change);
	}

	private static ArrayList<String> perm (char c , String s){
		HashSet <String> temp = new HashSet<>();
		int len = 0 ;
		for (int i = 0 ; i <s.length(); i ++){
			if(s.charAt(i)==c){
				len++;
			}
		}
		for(int i = 0; i < Math.pow(2,len);i++){
			temp.add(maskString(s,c,i,len));
		}
	ArrayList<String> res = new ArrayList<>(temp);
	res.replaceAll(x -> x.equals("") ? epsilon : x);
	return res;
	}

	private static String maskString (String s , char c , int n , int len){
		StringBuilder res = new StringBuilder();
		int j = 0 ;
		String binary = String.format("%" + len + "s", Integer.toBinaryString(n)).replace(' ', '0');
		for (int i = 0 ; i <s.length(); i ++){
			char curr = s.charAt(i);
			if(curr != c){
				res.append(curr);
			}
			else{
				if(binary.charAt(j)=='1'){
					res.append(c);
				}
				j++;
			}
		}
		return res.toString();
	}
}