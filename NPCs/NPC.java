package NPCs;

import Objects.*;

public class NPC{
	private String name;
	private double health;
	private boolean isHostile;
	private Item itemHeld;
	
	public NPC(String n, double hp) {
		this.name=n;
		this.health=hp;
		this.itemHeld=null;
	}
	
	public NPC(String n, double hp, Item item) {
		this.name=n;
		this.health=hp;
		this.itemHeld=item;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getHealth() {
		return this.health;
	}
	
	public void setHealth(double hp) {
		this.health=hp;
	}
	
	public void takeDamage(double dmg) {
		double temp=this.health-dmg;
		this.health=temp;
	}
	
	public boolean getHostile() {
		return this.isHostile;
	}
	
	public void setHotile(boolean hostility) {
		this.isHostile=hostility;
	}
	
	public Item getItem() {
		return this.itemHeld;
	}
	
	public void takeItem() {
		this.itemHeld=null;
	}
	
	public void setItem(Item i) {
		this.itemHeld= i;
	}
	
}
