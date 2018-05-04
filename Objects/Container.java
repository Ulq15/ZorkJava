package Objects;

import java.util.ArrayList;

public class Container extends Item{
	private ArrayList<Item> itemHeld;
	
	public Container(String n) {
		super(n);
		this.itemHeld=new ArrayList<Item>();
		this.setType("container");
	}
	
	public Container(String n, Boolean takable) {
		super(n, takable, false);
		this.itemHeld=new ArrayList<Item>();
	}
	
	public ArrayList<Item> getItems() {
		return itemHeld;
	}
	
	public void addItem(Item item) {
		this.itemHeld.add(item);
	}
	
	
	
}
