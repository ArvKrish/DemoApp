package com.model;

import java.util.*;

public class Player extends Character {
	
	public HashMap<Integer, Villain> villains = new HashMap<>();
	private HashSet<String> attributes = new HashSet<>();

	Player(String name, int power) {
		super(name, 100, power);
	}

	public void setAttributes(String attr) {
		attributes.add(attr);
	}

	public boolean addNewVillain(String name, int code) {
		if (villains.containsKey(code))
			return false;
		else
			villains.put(code, new Villain(name));
		return true;
	}

	public String getAttributes() {
		String allAttribute = "The Attributes of " + this.getName() + " are:\n";
		for (String attr : attributes) {
			allAttribute += attr + "\n";
		}
		return allAttribute;
	}

	public String strike(Villain v) {
		boolean healthChecker = (this.getHealth() - (this.getHealth() * (this.getPower() / 200))) > 0 ? true : false;
		if (healthChecker) {

			this.decreaseHealth(this, 0);

			boolean deathChecker = this.decreaseHealth(v, 0);

			if (deathChecker) {
				return "<br/>K.O.<br/>";
			} else {
				return this.strikeUpdate();
			}
		} else {
			return "<br/>Energy too low<br/>Please use powerups<br/>";
		}

	}

	public String strikeUpdate() {

		return "<br/> Whaat a strike!<br/>";
	}

	public String powerUp() {
		this.boostHealth(.10);
		return "\nDrinking Boost<br/>Restoring health:\t" + this.getHealth();
	}

	public String powerUp(int energy) {
		System.out.println();
		this.boostHealth(.25);
		return "\nDrinking Boost\nRestoring health:\t" + this.getHealth();
	}

	public String getSummary() {
		return "Player's " + (this.toString());
	}

}
