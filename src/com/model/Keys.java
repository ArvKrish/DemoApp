package com.model;

import java.util.*;

public class Keys {

	static int count = 0;
	static HashMap<Integer, Player> players = new HashMap<>();

	public static int start(String pname, int power) {

		count++;
		players.put(count, new Player(pname, power));

		return count;

	}

	public static Player findPlayer(int key) {
		for (Map.Entry<Integer, Player> looper : players.entrySet()) {
			if (looper.getKey() == key) {
				return looper.getValue();
			}
		}
		return null;
	}

	public static boolean newVillain(int uKey, String name, int power) {

		Player p = findPlayer(uKey);
		return p.addNewVillain(name, power);

	}

	public static int villainSize(int uKey) {

		Player p = findPlayer(uKey);
		return p.villains.size();
	}

	public static String showList(int uKey) {
		String list = "";
		Player p = findPlayer(uKey);

		if(p.villains.size()>0) {
		list += "The list of Villains are:<br/>";

		for (Map.Entry<Integer, Villain> entry : p.villains.entrySet()) {

			list += " <br/>Code: &ensp;" + entry.getKey() + ". Name: &ensp; " + entry.getValue().getName() + "<br/>";
		}

		return list;
	}else {
		return "You have 0 villains so far. Add more to use this option.";
	}}

	public static String villainAction(int uKey, int method, String oName, int oKey, String compliment) {

		String status = "";
		Player p = findPlayer(uKey);
		if (p.villains.size() == 1) {

			for (Map.Entry<Integer, Villain> entry : p.villains.entrySet()) {
				if (method == 1) {
					status += "Villain Found - " + entry.getValue().getName() + "\n";

					status += p.strike(entry.getValue());

					status += "\n Health reduced to " + Math.round(entry.getValue().getHealth()) + ".<br/>";

					return status;
				}

				else if (method == 8) {

					return addCompliment(entry.getValue(), compliment);
				} else if (method == 10)
					return showCompliment(entry.getValue());

			}

		}

		else if (p.villains.size() > 1) {
			String name = oName;
			int key = oKey;

			for (Map.Entry<Integer, Villain> entry : p.villains.entrySet()) {
				if (key == 0) {
					Villain v = entry.getValue();
					if (v.getName().equals(name)) {
						if (method == 1) {
							status += "Villain Found - " + entry.getValue().getName() + "\n";

							status += p.strike(entry.getValue());

							status += "\n Health reduced to " + Math.round(v.getHealth()) + "<br/>.";

							return status;

						} else if (method == 8) {
							return addCompliment(entry.getValue(), compliment);

						} else if (method == 10)
							return showCompliment(entry.getValue());

					}

				} else if (key > 0) {

					if (entry.getKey() == (key)) {
						Villain v = p.villains.get(entry.getKey());
						if (method == 1) {
							status += "Villain Found - " + entry.getValue().getName() + "\n";

							status += p.strike(v);

							status += "\n Health reduced to " + Math.round(v.getHealth()) + ".";
							// System.out.println(status);
							return status;

						} else if (method == 8) {

							return addCompliment(entry.getValue(), compliment);
						} else if (method == 10)
							return showCompliment(entry.getValue());

					}
				}

			}

		}
		return "Opponent does not exist";

	}

	public static String villainActionAll(int uKey, int method) {
		Player p = findPlayer(uKey);
		String compliment = "";
		String str = "";
		if (p.villains.size() > 0) {
			for (Map.Entry<Integer, Villain> entry : p.villains.entrySet()) {

				if (method == 1) {

					str += "Villain Found - " + entry.getValue().getName() + "\n";
					str += p.strike(entry.getValue());

					str += "Health reduced to " + entry.getValue().getHealth();
					str += "<br/><br/>";
				}

				else if (method == 8)

					addCompliment(entry.getValue(), compliment);
				else if (method == 11)
					showCompliment(entry.getValue());
				else
					entry.getValue().getSummary();

			}
			return str;
		} else
			return "Opponent does not exist";
	}

	public static String boostEnergy(int uKey, int method) {

		Player p = findPlayer(uKey);

		if (method > 0)
			return p.powerUp(1);
		else
			return p.powerUp();
	}

	public static String addCompliment(Villain v, String compliment) {

		v.setCompliment(compliment.toLowerCase());

		return "<br/>You are my enemy and you're " + compliment + ", Mr." + v.getName() + ".<br/><br/>";

	}

	public static String showCompliment(Villain v) {

		return v.getCompliments();
	}

	public static String allSummary(int uKey) {
		Player p = findPlayer(uKey);
		String str = "";
		str += "<br/> " + p.getSummary() + "<br/><br/> ";

		for (Map.Entry<Integer, Villain> entry : p.villains.entrySet()) {

			str += "<br/> " + entry.getValue().getSummary() + "<br/><br/> ";
		}
		return str;

	}

}
