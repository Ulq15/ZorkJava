package Objects;

import java.util.HashMap;
import Game.Zork;

public class Container extends Item{
	private HashMap<String, Item> itemHeld;
	
	public Container(String n) {
		super(n);
		this.itemHeld=new HashMap<String, Item>();
		this.setType("Container");
	}
	
	public Container(String n, Boolean takable) {
		super(n, takable, false);
		this.itemHeld=new HashMap<String,Item>();
		this.setType("Container");
	}
	
	public HashMap<String,Item> getItems() {
		return this.itemHeld;
	}
	
	public void addItem(Item item) {
		this.itemHeld.put(item.getName(), item);
	}
	
	public void listItemsHeld() {
		String str="These are the items in "+this.getName()+": \n";
		for(String i: this.itemHeld.keySet()) {
			str=str+"-"+i+"\n";
		}
		Zork.textArea.appendText(str);
	}
	
	public Item removeItem(String str) {
		if(itemHeld.containsKey(str)) {
			Item i= itemHeld.get(str);
			itemHeld.remove(str);
			return i;
		}
		else {
			Zork.textArea.appendText("NOPE!!!");
			return null;
		}
	}
}
