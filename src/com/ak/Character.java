package com.ak;

public abstract class Character {

	private String name;
	private double health;
	private double power;

	public Character(String name, int health, int power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}

	public double getHealth() {
		return Math.round(this.health);
	}

	public double getPower() {
		return this.power;
	}

	public String getName() {
		return this.name;
	}

	abstract String strikeUpdate();

	abstract String getSummary();

	protected void boostHealth(double energy) {
		this.health += this.health * energy;
		if (this.health > 100) {
			this.health = 100;
		}
	}

	protected boolean decreaseHealth(Character c, int previewCheck) {
		if (previewCheck == 0) {
			if (this == c) {
				c.health -= c.getHealth() * (this.getPower() / 200);
			} else {

				c.health -= c.getHealth() * (this.getPower() / 100);
			}

			if (c.health <= .9999999) {
				c.health = 0;
				//System.out.println("\n\t" + c.getName() + "'s Health  : " + String.format("%.0f", c.getHealth()));
				return true;
			}
		//	System.out.println("\n\t" + c.getName() + "'s Health : " + String.format("%.0f", c.getHealth()));
			return false;
		} else {
			double preHealth;
			if (this == c) {
				preHealth = c.health - c.getHealth() * (this.getPower() / 200);
			} else {

				preHealth = c.health - c.getHealth() * (this.getPower() / 100);
			}

			if (preHealth <= 0) {
				preHealth = 0;
				//System.out.println("\n\t" + c.getName() + "'s Health  : " + String.format("%.0f", preHealth));
				return true;
			}
		//	System.out.println("\n\t" + c.getName() + "'s Health : " + String.format("%.0f", preHealth));
			return false;

		}
	}

	@Override
	public String toString() {

		return "<br/><br/> Name: " + getName() + "<br/>" + "         Health: " + String.format("%.0f", getHealth())
				+ "<br/>" + "         Power: " + getPower();
	}

}
