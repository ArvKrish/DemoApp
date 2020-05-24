package com.ak;

import java.util.*;

public class Villain extends Character {
	private HashSet<String> compliments = new HashSet<>();

	Villain(String name) {
		super(name, 100, 0);
	}

	String strikeUpdate() {
		return "Does not apply\n Villians can't strike players(for now) :D";
	}

	public String getSummary() {
		return "&ensp; &ensp;&ensp;&ensp;" + this.toString();
	}

	public void setCompliment(String compliment) {
		compliments.add(compliment);
		System.out.println(compliment);
	}

	public String getCompliments() {
		if (compliments.isEmpty())
			return "No Compliments yet!";
		String allCompliments = "The Compliments offered to " + this.getName() + " are:<br/>";
		for (String comp : compliments) {
			allCompliments += comp + "<br/>";
		}

		System.out.println(allCompliments);
		return allCompliments;
	}

}
