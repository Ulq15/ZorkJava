package Objects;

import Game.Zork;

public class KeyItem extends Item{
	private Boolean breakable;
	private Boolean broken;
	private String brokenDescription;
	private Boolean isTreasure;
	
	public KeyItem(String n) {
		super(n);
		this.breakable=false;
	}
	
	public KeyItem(String n, Boolean takable) {
		super(n, takable);
		this.breakable=false;
		this.isTreasure=false;
	}
	
	public KeyItem(String n, Boolean takable, Boolean readable) {
		super(n, takable, readable);
		this.breakable=false;
		this.isTreasure=false;
	}
	
	public void setBreakable() {
		this.breakable=true;
	}
	
	public void setBroken() {
		this.breakable=true;
		this.broken= true;
	}
	
	public void setTreasure() {
		this.isTreasure=true;
	}
	
	public Boolean isTreasure() {
		return this.isTreasure;
	}
	
	public void breakItem() {
		if(this.breakable) {
			this.broken = true;
			Zork.textArea.appendText(this.getName()+" is now broken.\n");
			this.setName("Broken "+this.getName());
		}
		else {
			Zork.textArea.appendText("You can not break this item.\n");
		}
	}
	
	public Boolean getBroken() {
		return this.broken;
	}
	
	public void setBrokenDescription(String str) {
		this.brokenDescription=str;
	}
	
	@Override
	public String getDescription() {
		if(this.broken) {
			return this.brokenDescription;
		}
		else {
			return super.getDescription();
		}
		
	}
	
}
