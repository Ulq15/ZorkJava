package Map;

import java.util.HashMap;
import java.util.Map;

import Buttons.Compass;
import Game.Zork;
import NPCs.NPC;
import Objects.Item;

public class Room{
	private String name;
	private Map<Compass, Room> adjacent;
	private Map<String, Item> itemList;
	private NPC person;
	private String description;
	private Boolean isAccessible;
	
	public Room(String n) {
		this.name=n;
		this.adjacent=null;
		this.itemList=new HashMap<String, Item>();
		this.person=null;
		this.description=null;
		this.isAccessible=true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String str) {
		this.name=str;
	}
	
	public Map<Compass, Room> getAdjacentRooms(){
		return this.adjacent;
	}
	
	public Room getAdjacentRoom(Compass c) {
		return this.adjacent.get(c);
	}
	
	public void setAdjacentRooms(Map<Compass,Room> map) {
		this.adjacent=map;
	}
	
	public Map<String, Item> getItemList(){
		return this.itemList;
	}
	
	public void setItemList(Map<String, Item> items) {
		this.itemList=items;
	}
	
	public void addItem(Item item) {
		itemList.put(item.getName(), item);
	}
	
	public Item takeItem(String i) {
		if(itemList.get(i) != null) {
			Item item = itemList.get(i);
			if(item.isTakable()) {
				itemList.remove(i);
				return item;
			}
			else {
				Zork.textArea.appendText("Cannot take "+ item.getName()+"\n");
				return null;
			}
		}
		else {
			Zork.textArea.appendText("No such thing here.\n");
			return null;
		}
	}
	
	public  Map<String, Item> takeAllItems() {
		Map<String, Item> map = this.itemList;
		this.itemList=null;
		return map;
	}
	
	public NPC getNPC() {
		return this.person;
	}
	
	public void setNPC(NPC npc) {
		this.person=npc;
	}
	
	public void setDescription(String str) {
		this.description=str;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setAccessible(Boolean b) {
		this.isAccessible=b;
	}
	
	public Boolean getAccessible() {
		return this.isAccessible;
	}
}