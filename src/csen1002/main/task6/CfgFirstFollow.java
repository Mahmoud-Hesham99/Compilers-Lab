package csen1002.main.task6;

import java.util.*;

/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

public class CfgFirstFollow {
	static final String epsilon = "e";

	ArrayList<String> variables;
	ArrayList <String> terminals;

	Map<String, ArrayList<String>> rules ;
	Map<String, ArrayList<String>> first ;
	Map<String, ArrayList<String>> follow ;
	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */

	public CfgFirstFollow(String cfg) {
		String[] input_split = cfg.split("#");
		variables = new ArrayList<>(List.of(input_split[0].split(";")));
		terminals = new ArrayList<>(List.of(input_split[1].split(";")));
		ArrayList<String> rules_input = new ArrayList<>(List.of(input_split[2].split(";")));
		rules = new LinkedHashMap<>();
		first = new LinkedHashMap<>();
		follow = new LinkedHashMap<>();
		for (String r : rules_input){
			rules.put(r.split("/")[0],new ArrayList<>(List.of(r.split("/")[1].split(","))));
			first.put(r.split("/")[0],new ArrayList<>());
			follow.put(r.split("/")[0],new ArrayList<>());
		}
		for(String t : terminals){
			first.put(t,new ArrayList<>(Collections.singleton(t)));
		}
		follow.get(variables.get(0)).add("$");
	}

	/**
	 * Calculates the First Set of each variable in the CFG.
	 *
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {

		for(String entry : variables) {
			ArrayList<String> value = rules.get(entry);
			for(String rule : value ){
				if(terminals.contains(rule.charAt(0)+"")){
					ArrayList <String> temp = first.get(entry);
					temp.addAll(first.get(rule.charAt(0)+""));
				}
			}
		}

		boolean change;
		do {
			change = false;
			for(String entry : variables){
				ArrayList<String> value = rules.get(entry);
				for(String rule : value){
					boolean flag = true;
					for(int i = 0 ; i < rule.length() ; i++){
						if(rule.charAt(i) == epsilon.charAt(0)){
							continue;
						}
						if(!first.get(rule.charAt(i)+"").contains(epsilon)){
							flag = false;
							break;
						}
					}
					if (flag){
						ArrayList <String> temp = first.get(entry);
						if(!temp.contains(epsilon)){
							temp.add(epsilon);
							change = true;
						}
					}
					ArrayList <String> temp = first.get(entry);
					if (rule.length()==1){
						if(rule.equals(epsilon)){
							if(!temp.contains(epsilon)){
								temp.add(epsilon);
								change = true;
							}
						}
						else{
							ArrayList <String> tempFirst = first.get(rule);
							for(String t : tempFirst){
								if(t.equals(epsilon)){
									continue;
								}
								if(!temp.contains(t)){
									temp.add(t);
									change = true;
								}
							}
						}

					}
					else{
						ArrayList <String> tempFirst = first.get(rule.charAt(0)+"");
						for(String t : tempFirst){
							if(t.equals(epsilon)){
								continue;
							}
							if(!temp.contains(t)){
								temp.add(t);
								change = true;
							}
						}
						for(int i = 1; i < rule.length(); i++){
							if(rule.charAt(i) == epsilon.charAt(0)){
								continue;
							}
							if(rule.charAt(i-1) != epsilon.charAt(0) && !first.get(rule.charAt(i-1)+"").contains(epsilon)){
								break;
							}
							temp = first.get(entry);
							tempFirst = first.get(rule.charAt(i)+"");
							for(String t : tempFirst){
								if(t.equals(epsilon)){
									continue;
								}
								if(!temp.contains(t)){
									temp.add(t);
									change = true;
								}
							}
						}
					}
				}
			}
		} while (change);

		StringBuilder res = new StringBuilder();
		for (String v : variables){
			res.append(v).append("/");
			TreeSet<String> tempRes = new TreeSet<>(first.get(v));
			for (String t : tempRes){
				res.append(t);
			}
			res.append(";");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		this.first();
		boolean change;
		do {
			change = false;
				for(String entry : variables){
					ArrayList<String> value = rules.get(entry);
					for(String rule : value){
						for(int i = 0; i < rule.length();i++){
							String var = rule.charAt(i)+"";
							if(!variables.contains(var)){
								continue;
							}
							ArrayList<String> temp ;
							ArrayList<String> temp2 ;
							if(i == rule.length()-1){
								temp = follow.get(entry);
								for (String t : temp){
									if(!follow.get(var).contains(t)){
										follow.get(var).add(t);
										change = true;
									}
								}
							}
							else{
								boolean flag;
								for(int j = i ; j < rule.length()-1; j++){
									flag = false;
									temp = first.get(rule.charAt(j+1)+"");
									for (String t : temp){
										if(t.equals(epsilon)){
											flag = true;
											continue;
										}
										if(!follow.get(var).contains(t)){
											follow.get(var).add(t);
											change = true;
										}
									}
									if(!flag){
										break;
									}
								}
								boolean flag2 = true;
								for(int j = i ; j < rule.length()-1; j++){
									temp = first.get(rule.charAt(j+1)+"");
									if(!temp.contains(epsilon)){
										flag2 = false;
										break;
									}
								}
								if(flag2){
									temp2 = follow.get(entry);
									for (String t2 : temp2){
										if(!follow.get(var).contains(t2)){
											follow.get(var).add(t2);
											change = true;
										}
									}
								}
							}
						}
					}
				}
		} while (change);

		StringBuilder res = new StringBuilder();
		for (String v : variables){
			res.append(v).append("/");
			TreeSet<String> tempRes = new TreeSet<>(follow.get(v));
			for (String t : tempRes){
				res.append(t);
			}
			res.append(";");
		}
		res.deleteCharAt(res.length() - 1);

		return res.toString();
	}

    public static void main(String[] args) {
        

    }
}