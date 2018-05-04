package Objects;

public class Food extends Item{
	private double restoreValue;
	
	public Food(String n, double hpRestore, Boolean takable) {
		super(n, takable);
		this.restoreValue=hpRestore;
		this.setType("food");
	}
	
	public double getRestoreValue() {
		return this.restoreValue;
	}
	
}
