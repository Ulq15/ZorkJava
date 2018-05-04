package Objects;

public class Weapon extends Item{
	private int damage;
	
	public Weapon(String n, int dmg, Boolean takable) {
		super(n, takable);
		this.damage=dmg;
		this.setType("weapon");
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	
}
