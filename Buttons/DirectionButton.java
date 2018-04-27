package Buttons;

public class DirectionButton extends MyButton{
	private Compass direction;
	
	public DirectionButton(Compass comp) {
		super(""+comp);
		this.direction=comp;
	
	}
	
	public Compass getDirection() {
		return this.direction;
	}
	
	public void setDirection(Compass comp) {
		this.direction=comp;
	}
	
	
}