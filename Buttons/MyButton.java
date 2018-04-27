package Buttons;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MyButton extends Button{
	private String name;
	private EventHandler<MouseEvent> eventHandler;
	
	public MyButton(String n) {
		super(n);
		this.name=n;
	}
	
	public MyButton(String n, EventHandler<MouseEvent> event) {
		super(n);
		this.name=n;
		this.eventHandler=event;
		this.setOnMouseClicked(event);
	}
	
	public String getName() {
		return this.name;
	}
	
	public EventHandler<MouseEvent> getEventHandler() {
		return this.eventHandler;
	}
	
	
	
}