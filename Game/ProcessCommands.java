package Game;

public class ProcessCommands{
	
	public ProcessCommands() {
		
	}
	
	public static void process(String str) {
		String[] arrStr=str.split(" ");
		for(int i=0; i<arrStr.length; i++) {
			if(arrStr[i].equalsIgnoreCase("look")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("restart")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("verbose")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("score")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("diagnostic")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("quit")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("climp")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("enter")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("out")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("hi") || arrStr[i].equalsIgnoreCase("hello")) {
				Zork.textArea.appendText("Hi..\n");
			}
			else if(arrStr[i].equalsIgnoreCase("jump")) {
				Zork.textArea.appendText("Congrats, you jumped. Are you proud?\n");
			}
			else if(arrStr[i].equalsIgnoreCase("")) {
				Zork.textArea.appendText("Excuse me?\n");
			}
			else if((arrStr[i].equalsIgnoreCase("get") || arrStr[i].equalsIgnoreCase("take"))) {
				if(i+1<arrStr.length) {
					if(arrStr[i+1].equalsIgnoreCase("all")) {
						Zork.player.takeAllItems(Zork.gm.getCurrentRoom());
					}
					else if(arrStr[i+1].equalsIgnoreCase("")) {
						
					}
					else {
						Zork.textArea.appendText("What do you want to take?\n");
					}
				}
				else {
					Zork.textArea.appendText("What do you want to take?\n");
				}
				
			}
			else if(arrStr[i].equalsIgnoreCase("")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("")) {
				
			}
			else if(arrStr[i].equalsIgnoreCase("")) {
				
			}
			else {
				
			}
			
			
			
		}
		//Zork.textArea.appendText("Success at process");
		
		
		
		
	}
	
}