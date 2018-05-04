package Game;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Map.GameMap;
import Map.Room;
import NPCs.Player;
import Objects.Container;
import Objects.Item;
public class ProcessCommands {
	private Method method;
	public ProcessCommands() {
		this.method=null;
	}
	
	public void process(String str) {
		String[] arrStr=str.split(" ");
		String arg="";
		for(int i=1; i<arrStr.length; i++) {
			arg= arg+" "+arrStr[i];
		}
		try {
			this.method=this.getClass().getMethod(arrStr[0], String.class);
		} catch(NoSuchMethodException e){
			Zork.textArea.appendText("No such command: "+arrStr[0]+", check your spelling!\n");
		} catch(SecurityException e) {
			System.out.println("Security Exception :"+e);
		}
		
		try {
			method.invoke(this, arg);
		} catch(IllegalArgumentException e) {
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			//e.printStackTrace();
		} catch (InvocationTargetException e) {
			//e.printStackTrace();
		} catch (NullPointerException e) {
			//e.printStackTrace();
		}
	}
	
	public void look(String args) {
		Room cr= Zork.gm.getCurrentRoom();
		Zork.textArea.appendText(cr.getName()+"\n"+cr.getDescription()+"\n");
	}
	
	public void help(String args) {
		String commands = "You can use the following commands:\n";
		commands=commands+"north, south, east, west, northeast, northwest, southeast, nsouthwest, up, down\n";
		commands=commands+"-Results in going in said direction\n";
		commands=commands+"look\n-Results in location description\n";
		commands=commands+"help\n-Shows all commands and effects of commands\n";
		commands=commands+"restart\n-Restarts game\n";
		commands=commands+"diagnostic\n-Gives description of health\n";
		commands=commands+"quit\n-Quit game\n";
		commands=commands+"climb\n-Climbs up\n";
		commands=commands+"enter\n-Into the place(such as a window)\n";
		commands=commands+"out\n-Get out of place(such as kitchen through window)\n";
		commands=commands+"get/take (item)\n-Removes item from current room & places it in your inventory\n";
		commands=commands+"get/take all\n-Removes all items from current room & places it in your inventory\n";
		commands=commands+"open (container)\n-Opens the container from either room or inventory\n";
		//commands=commands+"open (path)\n-Opens path for travel\n";
		commands=commands+"read (item)\n-Reads what is written on readable item\n";
		commands=commands+"drop (item)\n-Drops item in current room\n";
		commands=commands+"put (item) in (container)\n-Places item from inventory into a container\n";
		commands=commands+"turn (control) with (item)\n-Attempts to operate the control with the item\n";
		commands=commands+"turnon/turnoff (item)\n-Turns on/off the item\n";
		commands=commands+"move (object)\n-Moves a large object that cannot be picked up\n";
		commands=commands+"attack (npc) with (item)\n-Attacks npc with the item\n";
		commands=commands+"examine (object)\n-Examines an object/item/location\n";
		commands=commands+"inventory/i\n-Shows contents of inventory\n";
		commands=commands+"eat (food item)\n-Eats food item\n";
		commands=commands+"close (door)\n-Closes door\n";
		commands=commands+"tie (item) to (object)\n-Ties item to object\n";
		commands=commands+"pick (item)\n-Takes item\n";
		commands=commands+"kill (npc) with (item)\n-Attacks npc with the item\n";
		commands=commands+"break (item) with (item)\n-Breaks item\n";
		commands=commands+"pray\n-When you are in temples...\n";
		commands=commands+"drink (item)\n-Drinks an item\n";
		commands=commands+"smell (item)\n-Smell an item\n";
		commands=commands+"cut (object/item) with (weapon)\n-Cuts the object/item\n";
		commands=commands+"listen (target)\n-Listens to a creature or item\n";
		Zork.textArea.appendText(commands);
	}
	
	public void restart(String args) {
		Zork.gm=new GameMap();
		Zork.player=new Player("Player");
		Zork.pastCommands.clear();
		Zork.textArea.clear();
		Zork.textArea.appendText(Zork.gm.getCurrentRoom().getDescription()+"\n");
		
	}
	
	public void diagnostic(String args) {
		String txt= Zork.player.getName()+"- Health:"+Zork.player.getHealth()+"\n";
		Zork.textArea.appendText(txt);
	}
	
	public void quit(String args) {
		System.exit(0);
	}
	
	public void climb(String args) {
		Zork.executeCommand(">up");
	}
	/*
	public void enter(String args) {
		
	}
	
	public void out(String args) {
		
	}
	*/
	public void hi(String args) {
		Zork.textArea.appendText("Hello...\n");
	}
	
	public void hello(String args) {
		Zork.textArea.appendText("Hello...\n");
	}
	
	public void jump(String args) {
		Zork.textArea.appendText("Wow, you can jump! Are you proud?\n");
	}
	
	public void get(String args) {
		String[] str=args.split(" ");
		if(str[0].equalsIgnoreCase("all")) {
			
		}
		else if(Zork.gm.getItemList().containsKey(str[0])) {
			if(Zork.gm.getItemList().get(str[0]).isTakable()) {
				Zork.player.takeItem(Zork.gm.getCurrentRoom().takeItem(str[0]));
			}
			else {
				Zork.textArea.appendText("Cannot take "+ Zork.gm.getCurrentRoom().getItemList().get(str[0])+"\n");
			}
		}
		else {
			Zork.textArea.appendText("I dont understand what you mean by take '"+args+"'\n");
		}
	}
	
	public void take(String args) {
		this.get(args);
	}
	
	public void open(String args) {
		String[] str = args.split(" ");
		if(Zork.gm.getCurrentRoom().getItemList().containsKey(str[0])) {
			Item i = Zork.gm.getCurrentRoom().getItemList().get(str[0]);
			if(i.getType().equalsIgnoreCase("container")) {
				Container c=(Container) i;
				ArrayList<Item> al = c.getItems();
				for(int j=0; j<al.size();j++) {
					Zork.textArea.appendText(al.get(j)+"\n");
				}
				
			}
			else {
				Zork.textArea.appendText("Can't open that\n");
			}
		}
		else if(Zork.player.getItemsheld().containsKey(str[0])) {
			Item i = Zork.player.getItemsheld().get(str[0]);
			if(i.getType().equalsIgnoreCase("container")) {
				Container c=(Container) i;
				ArrayList<Item> al = c.getItems();
				for(int j=0; j<al.size();j++) {
					Zork.textArea.appendText(al.get(j)+"\n");
				}
			}
			else {
				Zork.textArea.appendText("Can't open that\n");
			}
		}
		else {
			Zork.textArea.appendText(str[0]+" is not something that can be openned\n");
		}
	}
		
	
	
	
}