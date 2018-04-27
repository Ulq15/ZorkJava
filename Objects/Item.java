package Objects;

public abstract class Item {
	private String name;
	private Boolean isTakable;
	private Boolean isReadable;
	private String description;
	private String content;
	private String locationDescription;
	
	public Item(String n) {
		this.name=n;
		this.isTakable=false;
		this.isReadable=false;
	}
	
	public Item(String n, Boolean takable) {
		this.name=n;
		this.isTakable=takable;
		this.isReadable=false;
	}
	
	public Item(String n, Boolean takable, Boolean readable) {
		this.name=n;
		this.isTakable=takable;
		this.isReadable=readable;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String n) {
		this.name=n;
	}
	
	public Boolean isTakable() {
		return this.isTakable;
	}
	
	public Boolean isReadable() {
		return this.isReadable;
	}
	
	public void setReadContent(String str) {
		if(this.isReadable==false) {
			this.isReadable=true;
		}
		this.content=str;
	}
	
	public String getReadContent() {
		if(this.isReadable==true) {
			return this.content;
		}
		else {
			return "This item cannot be read.\n";
		}
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setLocDesc(String desc) {
		this.locationDescription=desc;
	}
	
	public String getLocDesc() {
		return this.locationDescription;
	}
	
	public Boolean compareTo(String str) {
		Boolean bool= false;
		if(this.name.equalsIgnoreCase(str)) {
			bool=true;
		}
		return bool;
	}
	
}
