package csen1002.main.task5;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class CfgLeftRecElim {
	static final String epsilon = "e";

	ArrayList<String> variables;
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
	public CfgLeftRecElim(String cfg) {
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
			//Collections.sort(value);
			if(value.contains(epsilon)){
				value.remove(epsilon);
				value.add(epsilon);
			}
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
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		HashMap<String, ArrayList<String>> newRules = new LinkedHashMap<>();
		ArrayList<String> lookUp = new ArrayList<>();
		for (String key : variables) {
			ArrayList<String> tempRules = rules.get(key);
			boolean change;
			do {
				change = false;
				for (String pastKey : lookUp) {
					ArrayList<String> newTempRules = new ArrayList<>();
					ArrayList<String> productionReplacement = new ArrayList<>(rules.get(pastKey));
					tempRules = rules.get(key);
					for (String tR : tempRules) {
						if (pastKey.equals(tR.charAt(0) + "")) {
							change = true;
							ArrayList<String> temp = new ArrayList<>(productionReplacement);
							temp.replaceAll(s -> s + tR.substring(1));
							newTempRules.addAll(temp);
						} else {
							newTempRules.add(tR);
						}
					}
					rules.put(key, newTempRules);
				}
			} while (change);

			lookUp.add(key);
			ArrayList<String> alpha = new ArrayList<>();
			ArrayList<String> beta = new ArrayList<>();
			for (String tR : tempRules) {
				if (key.equals(tR.charAt(0) + "")) {        //Left recursion
					alpha.add(tR.substring(1));
				} else {
					beta.add(tR);
				}
			}
			if (alpha.size() > 0) {
				String keyDash = key + "'";
				alpha.replaceAll(s -> s + keyDash);
				alpha.add(epsilon);
				newRules.put(keyDash, alpha);
				beta.replaceAll(s -> s + keyDash);
				rules.put(key, beta);
			}
		}
		variables.addAll(newRules.keySet());
		StringBuilder vars = new StringBuilder(toStringVariables);
		vars.append(";");
		for(String newK :newRules.keySet() ){
			vars.append(newK).append(";");
		}
		vars.deleteCharAt(vars.length() - 1);
		toStringVariables = vars.toString();
		rules.putAll(newRules);
	}
}