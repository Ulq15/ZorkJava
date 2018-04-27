package Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import Buttons.*;
import Map.GameMap;
import Map.Room;
import NPCs.Player;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.stage.Stage;

public class Zork extends Application{
	private Stage stage;
	public static TextArea textArea;
	private ArrayList<String> pastCommands=new ArrayList<String>();
	public static GameMap gm = new GameMap();
	public static Player player = new Player("Player");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage=primaryStage;
		Scene scene = openingScene(stage);
		stage.setTitle("Zork I");
        stage.setScene(scene);
        stage.show();
	}
	
	public Scene openingScene(Stage stg) {
		FlowPane left = new FlowPane(Orientation.VERTICAL);
		left.setAlignment(Pos.TOP_LEFT);
		
		FlowPane right= new FlowPane(Orientation.VERTICAL);
		right.setAlignment(Pos.TOP_RIGHT);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setWrapText(true);
		textArea.appendText(gm.getCurrentRoom().getDescription()+"\n");
		textArea.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String[] str = observable.getValue().split("\n");
				int last = str.length -1;
				if(str[last].startsWith(">")) {
					executeCommand(str[last]);
				}
				else {
					return;
				}
			}
		});
		left.getChildren().add(textArea);
		
		TextField textField = new TextField();
		textField.setPrefWidth(1);
		textField.setText("Enter command");
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER) {
					String txt = textField.getText();
					textArea.appendText(">"+txt+"\n");
					pastCommands.add(">"+txt+"\n");
					textField.setText("");
				}
			}
		});
		
		
		
		left.getChildren().add(textField);
		
		FlowPane saveLoad = new FlowPane(Orientation.HORIZONTAL);
		MyButton saveB = new MyButton("Save");
		saveB.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+saveB.getText()+"\n");
		    	pastCommands.add(">"+saveB.getText());
		    	try {
					saveFunction();
				} catch (IOException e) {
					textArea.appendText(e.getStackTrace().toString());
				}
		    }
		});
		
		MyButton loadB = new MyButton("Load");
		loadB.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+loadB.getText()+"\n");
		    	pastCommands.add(">"+loadB.getText());
		    	try {
					loadFunction();
				} catch (IOException e) {
					textArea.appendText(e.getStackTrace().toString());
				}
		    }
		});
		
		saveLoad.getChildren().add(saveB);
		saveLoad.getChildren().add(loadB);
		
		right.getChildren().add(saveLoad);
		
		
		
		GridPane compassButtons = new GridPane();
		DirectionButton nw= new DirectionButton(Compass.NORTHWEST);
		nw.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+nw.getText()+"\n");
		    	pastCommands.add(">"+nw.getText());
		    	
		    }
		});
		
		DirectionButton n= new DirectionButton(Compass.NORTH);
		n.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+n.getText()+"\n");
		    	pastCommands.add(">"+n.getText());
		    }
		});
		
		DirectionButton ne= new DirectionButton(Compass.NORTHEAST);
		ne.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+ne.getText()+"\n");
		    	pastCommands.add(">"+ne.getText());
		    }
		});
		
		DirectionButton e= new DirectionButton(Compass.EAST);
		e.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+e.getText()+"\n");
		    	pastCommands.add(">"+e.getText());
		    }
		});
		
		DirectionButton se= new DirectionButton(Compass.SOUTHEAST);
		se.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+se.getText()+"\n");
		    	pastCommands.add(">"+se.getText());
		    }
		});
		
		DirectionButton s= new DirectionButton(Compass.SOUTH);
		s.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+s.getText()+"\n");
		    	pastCommands.add(">"+s.getText());
		    }
		});
		
		DirectionButton sw= new DirectionButton(Compass.SOUTHWEST);
		sw.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+sw.getText()+"\n");
		    	pastCommands.add(">"+sw.getText());
		    }
		});
		
		DirectionButton w= new DirectionButton(Compass.WEST);
		w.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+w.getText()+"\n");
		    	pastCommands.add(">"+w.getText());
		    }
		});
		
		DirectionButton up= new DirectionButton(Compass.UP);
		up.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+up.getText()+"\n");
		    	pastCommands.add(">"+up.getText());
		    }
		});
		
		DirectionButton down= new DirectionButton(Compass.DOWN);
		down.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		    	textArea.appendText(">"+down.getText()+"\n");
		    	pastCommands.add(">"+down.getText());
		    }
		});
		
		FlowPane midCompass = new FlowPane(Orientation.HORIZONTAL);
		midCompass.getChildren().add(w);
		midCompass.getChildren().add(up);
		midCompass.getChildren().add(down);
		midCompass.getChildren().add(e);
		
		GridPane.setRowIndex(nw, 0);
	    GridPane.setColumnIndex(nw, 0);
	    compassButtons.getChildren().add(nw);
	    
	    GridPane.setRowIndex(n, 0);
	    GridPane.setColumnIndex(n, 1);
	    compassButtons.getChildren().add(n);
	    
	    GridPane.setRowIndex(ne, 0);
	    GridPane.setColumnIndex(ne, 2);
	    compassButtons.getChildren().add(ne);
	    
	    GridPane.setRowIndex(midCompass, 1);
	    GridPane.setColumnSpan(midCompass, 3);
	    compassButtons.getChildren().add(midCompass);
	    
	    GridPane.setRowIndex(sw, 2);
	    GridPane.setColumnIndex(sw, 0);
	    compassButtons.getChildren().add(sw);
	    
	    GridPane.setRowIndex(s, 2);
	    GridPane.setColumnIndex(s, 1);
	    compassButtons.getChildren().add(s);
	    
	    GridPane.setRowIndex(se, 2);
	    GridPane.setColumnIndex(se, 2);
	    compassButtons.getChildren().add(se);
	    right.getChildren().add(compassButtons);
		
		
		HBox root = new HBox();
		root.getChildren().add(left);
		root.getChildren().add(right);
		return new Scene(root, 710, 210);
	}
	
	public void executeCommand(String str) {
		String command = str.substring(1).toUpperCase();
		if(command.equalsIgnoreCase(Compass.values()[0].toString()) ||
				command.equalsIgnoreCase(Compass.values()[1].toString()) ||
				command.equalsIgnoreCase(Compass.values()[2].toString()) ||
				command.equalsIgnoreCase(Compass.values()[3].toString()) ||
				command.equalsIgnoreCase(Compass.values()[4].toString()) ||				
				command.equalsIgnoreCase(Compass.values()[5].toString()) ||
				command.equalsIgnoreCase(Compass.values()[6].toString()) ||
				command.equalsIgnoreCase(Compass.values()[7].toString()) ||
				command.equalsIgnoreCase(Compass.values()[8].toString()) ||
				command.equalsIgnoreCase(Compass.values()[9].toString())){
			Compass c = Compass.valueOf(command.toUpperCase());
			if(gm.getCurrentRoom().getAdjacentRoom(c)!=null && gm.getCurrentRoom().getAdjacentRoom(c).getAccessible()){
				gm.goToRoom(c);
				textArea.appendText(gm.getCurrentRoom().getDescription()+"\n");
			}
			else {
				textArea.appendText("Can NOT go that way! \n");
			}
		}
		else if (command.equalsIgnoreCase("load")){
			textArea.appendText("Loading...\n");
		}
		else if (command.equalsIgnoreCase("save")){
			textArea.appendText("Saving...\n");
		}
		else {
			ProcessCommands.process(command);
			//textArea.appendText("I don't understand what you mean by \""+command+"\".\n");
		}
	}

	public void saveFunction() throws IOException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd HH-mm-ss");
		File saveFile = new File("src/"+dtf.format(now)+" save.sav");
		
		if(!saveFile.exists()) {
			saveFile.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
		
		for(int i=0; i<pastCommands.size(); i++) {
			bw.write(pastCommands.get(i));
			bw.newLine();
		}
		bw.close();
	}
	
	public void loadFunction() throws IOException {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Save Files", "*.sav"));
		fc.setInitialDirectory(new File("src"));
		fc.setTitle("Open your save file");
		File loadFile = fc.showOpenDialog(stage);
		if(loadFile==null) {
			return;
		}
		String str="";
		pastCommands.clear();
		textArea.clear();
		gm.setCurrentRoom("West of House");
		textArea.appendText(gm.getCurrentRoom().getDescription()+"\n");
		Scanner scan = new Scanner(loadFile);
		while(scan.hasNextLine()) {
			str=scan.nextLine().toString();
			if(!str.equalsIgnoreCase(">save") && !str.equalsIgnoreCase(">load")) {
				textArea.appendText(str+"\n");
				pastCommands.add(str);
			}
			
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
