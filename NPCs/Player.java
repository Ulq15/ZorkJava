package NPCs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Game.Zork;
import Map.Room;
import Objects.*;

public class Player{
	private String name;
	private final static double maxHealth = 100.00;
	private double health;
	private Map<String, Item> itemsHeld;
	
	public Player(String n) {
		this.name=n;
		health=maxHealth;
		itemsHeld = new HashMap<String, Item>();
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
	
	public void  restoreHealth(Food food) {
		double restoreVal = food.getRestoreValue();
		this.health+=restoreVal;
		if(this.health>maxHealth) {
			this.health=maxHealth;
		}
	}
	public void takeDamage(double dmg) {
		double temp=this.health-dmg;
		this.health=temp;
	}
	
	public void dealDamage(Weapon weapon, NPC npc) {
		npc.takeDamage(weapon.getDamage());
	}
	
	public void takeItem(Item i) {
		if(itemsHeld.size()>=8){
			Zork.textArea.appendText("You can not hold anymore items due to the excess weight!\n");
		}
		if(!i.isTakable()) {
			Zork.textArea.appendText(this.name+" cannot be taken!\n");
		}
		if(itemsHeld.size()<8 && i.isTakable()) {
			itemsHeld.put(i.getName(), i);
			Zork.textArea.appendText("Took "+i.getName()+"\n");
		}
	}
	
	public void takeAllItems(Room room) {
		Map<String, Item> map = room.takeAllItems();
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			Zork.textArea.appendText(map.get(iter.next())+" taken.\n");
		}
		itemsHeld.putAll(map);
	}
	
	public void dropItem(String i) {
		if(itemsHeld.get(i)!=null) {
			Zork.gm.getCurrentRoom().addItem(this.itemsHeld.get(i));
			Zork.textArea.appendText("Dropped "+ i+" into "+Zork.gm.getCurrentRoom().getName()+".\n");
			itemsHeld.remove(i);
		}
	}
	
	public void getInventory() {
		if(itemsHeld.size()>0) {
			for(int i=0; i<itemsHeld.size(); i++) {
				Zork.textArea.appendText("-"+itemsHeld.values().toArray()[i]+"\n");
			}
		}
		else {
			Zork.textArea.appendText("You are not carrying anything!\n");
		}
	}
	
	public Map<String, Item> getItemsheld(){
		return this.itemsHeld;
	}
	
	public String listItemsHeld() {
		Set<String> str =this.itemsHeld.keySet();
		String list="These are the items held: \n";
		for(String s:str) {
			list=list+"-"+s+"\n";
		}
		return list;
	}
	
}