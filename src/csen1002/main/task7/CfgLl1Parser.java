package csen1002.main.task7;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class CfgLl1Parser {
	static final String epsilon = "e";

	ArrayList<String> variables;
	ArrayList <String> terminals;
	ArrayList<String> terminalsPlus ;

	Map<String, ArrayList<String>> rules ;
	Map<String, ArrayList<String>> first ;
	Map<String, ArrayList<String>> follow ;

	String [][] parsingTable ;

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param input A formatted string representation of the CFG, the First sets of
	 *            each right-hand side, and the Follow sets of each variable. The
	 *            string representation follows the one in the task description
	 */
	public CfgLl1Parser(String input) {
		String[] input_split = input.split("#");
		variables = new ArrayList<>(List.of(input_split[0].split(";")));
		terminals = new ArrayList<>(List.of(input_split[1].split(";")));
		ArrayList<String> rules_input = new ArrayList<>(List.of(input_split[2].split(";")));
		ArrayList<String> first_input = new ArrayList<>(List.of(input_split[3].split(";")));
		ArrayList<String> follow_input = new ArrayList<>(List.of(input_split[4].split(";")));
		rules = new LinkedHashMap<>();
		first = new LinkedHashMap<>();
		follow = new LinkedHashMap<>();
		for (String r : rules_input){
			rules.put(r.split("/")[0],new ArrayList<>(List.of(r.split("/")[1].split(","))));
		}
		for (String r : first_input){
			ArrayList<String> toAdd = new ArrayList<>(List.of(r.split("/")[1].split(",")));
			expandString(toAdd);
			first.put(r.split("/")[0],toAdd);
		}
		for (String r : follow_input){
			String[] arr = r.split("/")[1].split(",")[0].split("");
			ArrayList<String> toAdd =  new ArrayList<>(List.of(arr));
			follow.put(r.split("/")[0],toAdd);
		}

		terminalsPlus = (ArrayList<String>) terminals.clone();
		terminalsPlus.add("$");
		parsingTable = new String[variables.size()][terminalsPlus.size()];
		for (String v : variables){
			ArrayList<String> firstArray = first.get(v);
			ArrayList<String> followArray = follow.get(v);
			int rowIndex = variables.indexOf(v);
			for(String f : firstArray){
				ArrayList<String> varRules = rules.get(v);
				if(f.equals(epsilon)){
					for (String vR : varRules){
						if(isDriveEpsilon(vR)){
							for (String fA : followArray){
								int tempIndex = terminalsPlus.indexOf(fA);
								parsingTable[rowIndex][tempIndex] = vR;
							}
						}
					}
				}
				else{
					int colIndex = terminalsPlus.indexOf(f);
					for (String vR : varRules){
						if(vR.equals(epsilon))
							continue;
						if(checkDerivation(vR,f)){
							parsingTable[rowIndex][colIndex] = vR;
						}
					}
				}

			}
		}

	}

	/**
	 * @param input The string to be parsed by the LL(1) CFG.
	 * 
	 * @return A string encoding a left-most derivation.
	 */
	public String parse(String input) {
		Stack<String> stack = new Stack<>();
		stack.push("$");
		stack.push("S");
		String res = "S;";
		String derivation = "S";
		if(input.length()==0 && first.get("S").contains(epsilon)){
			return "S;";
		}
		if(input.length()==0 && !first.get("S").contains(epsilon)){
			return "S;ERROR";
		}
		int i = 0;
		while(i < input.length()){
			String curr = String.valueOf(input.charAt(i));
			String top = stack.peek();
			if(variables.contains(top)){
				int rowIndex = variables.indexOf(top);
				int colIndex = terminalsPlus.indexOf(curr);
				String rule = parsingTable[rowIndex][colIndex];
				if(rule==null){
					break;
				}
				else{
					if(!rule.equals(epsilon)){
						derivation = derivation.replaceFirst(top,rule);
						res += derivation + ";";
						stack.pop();
						addToStack(rule,stack);
					}
					else {
						derivation = derivation.replaceFirst(top,"");
						stack.pop();
						res += derivation + ";";
					}
				}
			}
			else {
				if(top.equals(curr)){
					i++;
					stack.pop();
				}
				else{
					break;
				}
			}
		}
		while(stack.size()>1){
			String top = stack.peek();
			int rowIndex = variables.indexOf(top);
			int colIndex = terminalsPlus.indexOf("$");
			if(variables.contains(top) && parsingTable[rowIndex][colIndex] == null)
				break;
			if(variables.contains(top) && parsingTable[rowIndex][colIndex].equals(epsilon)){
				derivation = derivation.replaceFirst(top,"");
				stack.pop();
				res += derivation + ";";
			}
			else break;
		}
		String end = stack.pop();
		if(!end.equals("$") || i < input.length()){
			res += "ERROR;";
		}
		res = res.substring(0, res.length() - 1);
		return res;
	}

	boolean checkDerivation(String rule, String s){
		for (int i = 0; i < rule.length(); i++) {
			String curr = String.valueOf(rule.charAt(i));
			if(terminals.contains(curr)){
				if(curr.equals(s))
					return true;
				else
					return false;
			}
			ArrayList<String> currFirst = first.get(curr);
			if(currFirst.contains(s))
				return true;
			if (!currFirst.contains(epsilon))
				break;
		}
		return false;
	}

	boolean isDriveEpsilon(String rule) {
		if (rule.equals(epsilon))
			return true;
		for (int i = 0; i < rule.length(); i++) {
			String curr = String.valueOf(rule.charAt(i));
			if (terminals.contains(curr))
				return false;
				ArrayList<String> currFirst = first.get(curr);
				if (!currFirst.contains(epsilon))
					return false;
			}
			return true;
		}

	static void expandString (ArrayList<String> originalList){
		ArrayList<String> newList = new ArrayList<>();
		for (String str : originalList) {
			for (char c : str.toCharArray()) {
				newList.add(Character.toString(c));
			}
		}
		originalList.clear();
		originalList.addAll(newList);
	}

	void addToStack (String input , Stack<String> stack){
		for (int i = input.length() - 1; i >= 0; i--) {
			String x = String.valueOf(input.charAt(i));
			stack.push(x);
		}
	}

}
