package Game;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.Button;


import javafx.stage.Stage;


public class HelpStage extends Application{

    static Stage stage = new Stage();
    private ArrayList<Scene> sceneList;
    private int numPage = 3;
    private int page;

    @Override
    public void start(Stage primaryStage){


        this.page = 0;

        ArrayList<Scene> list = new ArrayList<Scene>();

        this.sceneList = list;

        list.add(helpStagePage1());
        list.add(helpStagePage2());
        list.add(helpStagePage3());

        stage = primaryStage;

        Scene scene = list.get(this.page);

        stage.setScene(scene);
        stage.show();

    }

    public void upPage(MouseEvent event){

        if(this.page < this.numPage -1 ) {

            this.page++;

            HelpStage.stage.setScene(sceneList.get(this.page));
        }
    }

    public void downPage(MouseEvent event){

        if(this.page > 0) {

            this.page--;

            HelpStage.stage.setScene(sceneList.get(this.page));
        }
    }

    public Scene helpStagePage1(){

        FlowPane flow = new FlowPane();

      //  GridLayout grid = new GridLayout();
        flow.setHgap(2);
        flow.setVgap(2);

        VBox column1 = new VBox();


        //Font header = new Font("san-serif", FontWeight.BOLD, 12);


        TextField command = new TextField("Command");
        command.setFont(new Font("san-serif", 12));
        command.setEditable(false);
        command.setMaxWidth(100);
        command.setAlignment(Pos.CENTER);
        column1.getChildren().add(command);

        /*TextField north = new TextField("north");
        north.setEditable(false);
        north.setMaxWidth(100);
        north.setAlignment(Pos.CENTER);
        column1.getChildren().add(north);

        TextField south = new TextField("south");
        south.setEditable(false);
        south.setMaxWidth(100);
        south.setAlignment(Pos.CENTER);
        column1.getChildren().add(south);

        TextField east = new TextField("east");
        east.setEditable(false);
        east.setMaxWidth(100);
        east.setAlignment(Pos.CENTER);
        column1.getChildren().add(east);

        TextField west = new TextField("west");
        west.setEditable(false);
        west.setMaxWidth(100);
        west.setAlignment(Pos.CENTER);
        column1.getChildren().add(west);

        TextField northEast = new TextField("northeast");
        northEast.setEditable(false);
        northEast.setMaxWidth(100);
        northEast.setAlignment(Pos.CENTER);
        column1.getChildren().add(northEast);

        TextField northWest = new TextField("northwest");
        northWest.setEditable(false);
        northWest.setMaxWidth(100);
        northWest.setAlignment(Pos.CENTER);
        column1.getChildren().add(northWest);

        TextField southEast = new TextField("southeast");
        southEast.setEditable(false);
        southEast.setMaxWidth(100);
        southEast.setAlignment(Pos.CENTER);
        column1.getChildren().add(southEast);

        TextField southWest = new TextField("southwest");
        southWest.setEditable(false);
        southWest.setMaxWidth(100);
        southWest.setAlignment(Pos.CENTER);
        column1.getChildren().add(southWest);

        TextField up = new TextField("up");
        up.setEditable(false);
        up.setMaxWidth(100);
        up.setAlignment(Pos.CENTER);
        column1.getChildren().add(up);

        TextField down = new TextField("down");
        down.setEditable(false);
        down.setMaxWidth(100);
        down.setAlignment(Pos.CENTER);
        column1.getChildren().add(down);*/

        TextField look = new TextField("look");
        look.setEditable(false);
        look.setMaxWidth(100);
        look.setAlignment(Pos.CENTER);
        column1.getChildren().add(look);

        TextField save = new TextField("save");
        save.setEditable(false);
        save.setMaxWidth(100);
        save.setAlignment(Pos.CENTER);
        column1.getChildren().add(save);

        TextField restore = new TextField("restore");
        restore.setEditable(false);
        restore.setMaxWidth(100);
        restore.setAlignment(Pos.CENTER);
        column1.getChildren().add(restore);

        TextField restart = new TextField("restart");
        restart.setEditable(false);
        restart.setMaxWidth(100);
        restart.setAlignment(Pos.CENTER);
        column1.getChildren().add(restart);

        TextField verbose = new TextField("verbose");
        verbose.setEditable(false);
        verbose.setMaxWidth(100);
        verbose.setAlignment(Pos.CENTER);
        column1.getChildren().add(verbose);

        TextField score = new TextField("score");
        score.setEditable(false);
        score.setMaxWidth(100);
        score.setAlignment(Pos.CENTER);
        column1.getChildren().add(score);

        TextField diagnostic = new TextField("diagnostic");
        diagnostic.setEditable(false);
        diagnostic.setMaxWidth(100);
        diagnostic.setAlignment(Pos.CENTER);
        column1.getChildren().add(diagnostic);

        TextField brief = new TextField("brief");
        brief.setEditable(false);
        brief.setMaxWidth(100);
        brief.setAlignment(Pos.CENTER);
        column1.getChildren().add(brief);

        TextField superbrief = new TextField("superbrief");
        superbrief.setEditable(false);
        superbrief.setMaxWidth(100);
        superbrief.setAlignment(Pos.CENTER);
        column1.getChildren().add(superbrief);

        TextField quit = new TextField("quit");
        quit.setEditable(false);
        quit.setMaxWidth(100);
        quit.setAlignment(Pos.CENTER);
        column1.getChildren().add(quit);

        TextField climb = new TextField("climb");
        climb.setEditable(false);
        climb.setMaxWidth(100);
        climb.setAlignment(Pos.CENTER);
        column1.getChildren().add(climb);

        TextField g = new TextField("g");
        g.setEditable(false);
        g.setMaxWidth(100);
        g.setAlignment(Pos.CENTER);
        column1.getChildren().add(g);

        TextField goDirection = new TextField("go(direction)");
        goDirection.setEditable(false);
        goDirection.setMaxWidth(100);
        goDirection.setAlignment(Pos.CENTER);
        column1.getChildren().add(goDirection);

        TextField enter = new TextField("enter");
        enter.setEditable(false);
        enter.setMaxWidth(100);
        enter.setAlignment(Pos.CENTER);
        column1.getChildren().add(enter);

        TextField out = new TextField("out");
        out.setEditable(false);
        out.setMaxWidth(100);
        out.setAlignment(Pos.CENTER);
        column1.getChildren().add(out);

        TextField hi_hello = new TextField("hi/hello");
        hi_hello.setEditable(false);
        hi_hello.setMaxWidth(100);
        hi_hello.setAlignment(Pos.CENTER);
        column1.getChildren().add(hi_hello);

        TextField jump = new TextField("Jump");
        jump.setEditable(false);
        jump.setMaxWidth(100);
        jump.setAlignment(Pos.CENTER);
        column1.getChildren().add(jump);

        TextField fuck_shit_damn = new TextField("fuck/shit/damn");
        fuck_shit_damn.setEditable(false);
        fuck_shit_damn.setMaxWidth(100);
        fuck_shit_damn.setAlignment(Pos.CENTER);
        column1.getChildren().add(fuck_shit_damn);

        TextField none = new TextField("(None)");
        none.setEditable(false);
        none.setMaxWidth(100);
        none.setAlignment(Pos.CENTER);
        column1.getChildren().add(none);

        Button next = new Button("Next Page");
        next.setMinSize(100,50);
        next.setAlignment(Pos.CENTER);
        next.setOnMouseClicked(this::upPage);
        column1.getChildren().add(next);

        VBox column2 = new VBox();

        TextField Shortcut = new TextField("Shortcut");
        Shortcut.setEditable(false);
        Shortcut.setMaxWidth(80);
        Shortcut.setAlignment(Pos.CENTER);
        column2.getChildren().add(Shortcut);

        /*TextField n = new TextField("n");
        n.setEditable(false);
        n.setMaxWidth(50);
        n.setAlignment(Pos.CENTER);
        column2.getChildren().add(n);

        TextField s = new TextField("s");
        s.setEditable(false);
        s.setMaxWidth(50);
        s.setAlignment(Pos.CENTER);
        column2.getChildren().add(s);

        TextField e = new TextField("e");
        e.setEditable(false);
        e.setMaxWidth(50);
        e.setAlignment(Pos.CENTER);
        column2.getChildren().add(e);

        TextField w = new TextField("w");
        w.setEditable(false);
        w.setMaxWidth(50);
        w.setAlignment(Pos.CENTER);
        column2.getChildren().add(w);

        TextField ne = new TextField("ne");
        ne.setEditable(false);
        ne.setMaxWidth(50);
        ne.setAlignment(Pos.CENTER);
        column2.getChildren().add(ne);

        TextField nw = new TextField("nw");
        nw.setEditable(false);
        nw.setMaxWidth(50);
        nw.setAlignment(Pos.CENTER);
        column2.getChildren().add(nw);

        TextField se = new TextField("se");
        se.setEditable(false);
        se.setMaxWidth(50);
        se.setAlignment(Pos.CENTER);
        column2.getChildren().add(se);

        TextField sw = new TextField("sw");
        sw.setEditable(false);
        sw.setMaxWidth(50);
        sw.setAlignment(Pos.CENTER);
        column2.getChildren().add(sw);

        TextField u = new TextField("u");
        u.setEditable(false);
        u.setMaxWidth(50);
        u.setAlignment(Pos.CENTER);
        column2.getChildren().add(u);

        TextField d = new TextField("d");
        d.setEditable(false);
        d.setMaxWidth(50);
        d.setAlignment(Pos.CENTER);
        column2.getChildren().add(d);*/

        TextField l = new TextField("l");
        l.setEditable(false);
        l.setMaxWidth(80);
        l.setAlignment(Pos.CENTER);
        column2.getChildren().add(l);

        TextField e1 = new TextField();
        e1.setMaxWidth(80);
        column2.getChildren().add(e1);

        TextField e2 = new TextField();
        e2.setMaxWidth(80);
        column2.getChildren().add(e2);

        TextField e3 = new TextField();
        e3.setMaxWidth(80);
        column2.getChildren().add(e3);

        TextField e4 = new TextField();
        e4.setMaxWidth(80);
        column2.getChildren().add(e4);

        TextField e5 = new TextField();
        e5.setMaxWidth(80);
        column2.getChildren().add(e5);

        TextField e6 = new TextField();
        e6.setMaxWidth(80);
        column2.getChildren().add(e6);

        TextField e7 = new TextField();
        e7.setMaxWidth(80);
        column2.getChildren().add(e7);

        TextField e8 = new TextField();
        e8.setMaxWidth(80);
        column2.getChildren().add(e8);

        TextField q = new TextField("q");
        q.setEditable(false);
        q.setMaxWidth(80);
        q.setAlignment(Pos.CENTER);
        column2.getChildren().add(q);

        TextField e9 = new TextField();
        e9.setMaxWidth(80);
        column2.getChildren().add(e9);

        TextField e10 = new TextField();
        e10.setMaxWidth(80);
        column2.getChildren().add(e10);

        TextField e11 = new TextField();
        e11.setMaxWidth(80);
        column2.getChildren().add(e11);

        TextField e12 = new TextField();
        e12.setMaxWidth(80);
        column2.getChildren().add(e12);

        TextField e13 = new TextField();
        e13.setMaxWidth(80);
        column2.getChildren().add(e13);

        TextField e14 = new TextField();
        e14.setMaxWidth(80);
        column2.getChildren().add(e14);

        TextField e15 = new TextField();
        e15.setMaxWidth(80);
        column2.getChildren().add(e15);

        TextField e16 = new TextField();
        e16.setMaxWidth(80);
        column2.getChildren().add(e16);

        TextField e17 = new TextField();
        e17.setMaxWidth(80);
        column2.getChildren().add(e17);

        VBox column3 = new VBox();

        TextField Action = new TextField("Action");
        Action.setEditable(false);
        Action.setMinWidth(500);
        Action.setAlignment(Pos.CENTER);
        column3.getChildren().add(Action);

        /*TextField MoveNorth = new TextField("Move North");
        MoveNorth.setEditable(false);
        MoveNorth.setMaxWidth(200);
        MoveNorth.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveNorth);

        TextField MoveSouth = new TextField("Move south");
        MoveSouth.setEditable(false);
        MoveSouth.setMaxWidth(200);
        MoveSouth.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveSouth);

        TextField MoveEast = new TextField("Move east");
        MoveEast.setEditable(false);
        MoveEast.setMaxWidth(200);
        MoveEast.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveEast);

        TextField MoveWest = new TextField("Move west");
        MoveWest.setEditable(false);
        MoveWest.setMaxWidth(200);
        MoveWest.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveWest);

        TextField MoveNortheast = new TextField("Move northeast");
        MoveNortheast.setEditable(false);
        MoveNortheast.setMaxWidth(200);
        MoveNortheast.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveNortheast);

        TextField MoveNorthwest = new TextField("Move northwest");
        MoveNorthwest.setEditable(false);
        MoveNorthwest.setMaxWidth(200);
        MoveNorthwest.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveNorthwest);

        TextField MoveSoutheast = new TextField("Move southeast");
        MoveSoutheast.setEditable(false);
        MoveSoutheast.setMaxWidth(200);
        MoveSoutheast.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveSoutheast);

        TextField MoveSouthwest = new TextField("Move southwest");
        MoveSouthwest.setEditable(false);
        MoveSouthwest.setMaxWidth(200);
        MoveSouthwest.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveSouthwest);

        TextField MoveUp = new TextField("Move up");
        MoveUp.setEditable(false);
        MoveUp.setMaxWidth(200);
        MoveUp.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveUp);

        TextField MoveDown = new TextField("Move down");
        MoveDown.setEditable(false);
        MoveDown.setMaxWidth(200);
        MoveDown.setAlignment(Pos.CENTER);
        column3.getChildren().add(MoveDown);*/

        TextField lookAround = new TextField("Looks around at current location");
        lookAround.setEditable(false);
        lookAround.setMinWidth(500);
        lookAround.setAlignment(Pos.CENTER);
        column3.getChildren().add(lookAround);

        TextField saveInfo = new TextField("Save state to a file");
        saveInfo.setEditable(false);
        saveInfo.setMinWidth(500);
        saveInfo.setAlignment(Pos.CENTER);
        column3.getChildren().add(saveInfo);

        TextField restoreSave = new TextField("Restores a saved state");
        restoreSave.setEditable(false);
        restoreSave.setMinWidth(500);
        restoreSave.setAlignment(Pos.CENTER);
        column3.getChildren().add(restoreSave);

        TextField restartInfo = new TextField("Restarts the game");
        restartInfo.setEditable(false);
        restartInfo.setMinWidth(500);
        restartInfo.setAlignment(Pos.CENTER);
        column3.getChildren().add(restartInfo);

        TextField fullDescription = new TextField("Gives full description after each command");
        fullDescription.setEditable(false);
        fullDescription.setMinWidth(500);
        fullDescription.setAlignment(Pos.CENTER);
        column3.getChildren().add(fullDescription);

        TextField scoreRank = new TextField("Displays score and ranking");
        scoreRank.setEditable(false);
        scoreRank.setMinWidth(500);
        scoreRank.setAlignment(Pos.CENTER);
        column3.getChildren().add(scoreRank);

        TextField health = new TextField("Give description of health");
        health.setEditable(false);
        health.setMinWidth(500);
        health.setAlignment(Pos.CENTER);
        column3.getChildren().add(health);

        TextField areaDescription = new TextField("Give a description upon first entering an area");
        areaDescription.setEditable(false);
        areaDescription.setMinWidth(500);
        areaDescription.setAlignment(Pos.CENTER);
        column3.getChildren().add(areaDescription);

        TextField describeOff = new TextField("Never describe an area");
        describeOff.setEditable(false);
        describeOff.setMinWidth(500);
        describeOff.setAlignment(Pos.CENTER);
        column3.getChildren().add(describeOff);

        TextField quitGame = new TextField("Quit game");
        quitGame.setEditable(false);
        quitGame.setMinWidth(500);
        quitGame.setAlignment(Pos.CENTER);
        column3.getChildren().add(quitGame);

        TextField climbUp = new TextField("climbs(up)");
        climbUp.setEditable(false);
        climbUp.setMinWidth(500);
        climbUp.setAlignment(Pos.CENTER);
        column3.getChildren().add(climbUp);

        TextField lastCommon = new TextField("last common");
        lastCommon.setEditable(false);
        lastCommon.setMinWidth(500);
        lastCommon.setAlignment(Pos.CENTER);
        column3.getChildren().add(lastCommon);

        TextField goDirectionInfo = new TextField("go towards direction(west/east/north/south/in/out/into)");
        goDirectionInfo.setEditable(false);
        goDirectionInfo.setMinWidth(500);
        goDirectionInfo.setAlignment(Pos.CENTER);
        column3.getChildren().add(goDirectionInfo);

        TextField throughWindow = new TextField("in to the place(window,...)");
        throughWindow.setEditable(false);
        throughWindow.setMinWidth(500);
        throughWindow.setAlignment(Pos.CENTER);
        column3.getChildren().add(throughWindow);

        TextField leaveKitchen = new TextField("go out of the place(kitchen,...)");
        leaveKitchen.setEditable(false);
        leaveKitchen.setMinWidth(500);
        leaveKitchen.setAlignment(Pos.CENTER);
        column3.getChildren().add(leaveKitchen);

        TextField sayHello = new TextField("say hello...");
        sayHello.setEditable(false);
        sayHello.setMinWidth(500);
        sayHello.setAlignment(Pos.CENTER);
        column3.getChildren().add(sayHello);

        TextField randComment1 = new TextField("Random Comment e.g.:Are you proud of yourself?");
        randComment1.setEditable(false);
        randComment1.setMinWidth(500);
        randComment1.setAlignment(Pos.CENTER);
        column3.getChildren().add(randComment1);

        TextField randComment2 = new TextField("Random Comment e.g.:Such language in a high-class establishment like this!");
        randComment2.setEditable(false);
        randComment2.setMinWidth(500);
        randComment2.setAlignment(Pos.CENTER);
        column3.getChildren().add(randComment2);

        TextField pardon = new TextField("I beg your pardon?");
        pardon.setEditable(false);
        pardon.setMinWidth(500);
        pardon.setAlignment(Pos.CENTER);
        column3.getChildren().add(pardon);



        flow.getChildren().addAll(column1, column3);



        return new Scene(flow, 700, 600);
    }

    public Scene helpStagePage2(){
        FlowPane flow = new FlowPane();

        //GridLayout grid = new GridLayout();
        flow.setHgap(2);
        flow.setVgap(2);

        VBox column1 = new VBox();


        TextField commandArguement = new TextField("Command (Argument)");
        //commandArguement.setStyle("-fx-font-weight: bold");
        //commandArguement.setStyle("-fx-background-color: gray;");
        commandArguement.setEditable(false);
        commandArguement.setMinWidth(100);
        commandArguement.setAlignment(Pos.CENTER);
        column1.getChildren().add(commandArguement);

        TextField getTakeItem = new TextField("get/take (item)");
        //getTakeItem.setStyle("-fx-background-color: gray;");
        getTakeItem.setEditable(false);
        getTakeItem.setMinWidth(100);
        getTakeItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(getTakeItem);

        TextField getTakeAll = new TextField("get/take all");
        getTakeAll.setEditable(false);
        getTakeAll.setMinWidth(100);
        getTakeAll.setAlignment(Pos.CENTER);
        column1.getChildren().add(getTakeAll);

        TextField throwItemAtLoc = new TextField("throw (item) at (location)");
        throwItemAtLoc.setEditable(false);
        throwItemAtLoc.setMinWidth(100);
        throwItemAtLoc.setAlignment(Pos.CENTER);
        column1.getChildren().add(throwItemAtLoc);

        TextField openContainer = new TextField("open (container)");
        openContainer.setEditable(false);
        openContainer.setMinWidth(100);
        openContainer.setAlignment(Pos.CENTER);
        column1.getChildren().add(openContainer);

        TextField openExit = new TextField("open (exit)");
        openExit.setEditable(false);
        openExit.setMinWidth(100);
        openExit.setAlignment(Pos.CENTER);
        column1.getChildren().add(openExit);

        TextField readItem = new TextField("read (item)");
        readItem.setEditable(false);
        readItem.setMinWidth(100);
        readItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(readItem);

        TextField dropItem = new TextField("drop (item)");
        dropItem.setEditable(false);
        dropItem.setMinWidth(100);
        dropItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(dropItem);

        TextField putItemInCont = new TextField("put (item) in (container)");
        putItemInCont.setEditable(false);
        putItemInCont.setMinWidth(100);
        putItemInCont.setAlignment(Pos.CENTER);
        column1.getChildren().add(putItemInCont);

        TextField turnControlWithItem = new TextField("turn (control) with (item)l");
        turnControlWithItem.setEditable(false);
        turnControlWithItem.setMinWidth(100);
        turnControlWithItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(turnControlWithItem);

        TextField turnOnItem = new TextField("turn on (item)");
        turnOnItem.setEditable(false);
        turnOnItem.setMinWidth(100);
        turnOnItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(turnOnItem);

        TextField turnOffItem = new TextField("turn off (item)");
        turnOffItem.setEditable(false);
        turnOffItem.setMinWidth(100);
        turnOffItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(turnOffItem);

        TextField moveObject = new TextField("move (object)");
        moveObject.setEditable(false);
        moveObject.setMinWidth(100);
        moveObject.setAlignment(Pos.CENTER);
        column1.getChildren().add(moveObject);

        TextField attackWithItem = new TextField("attack (creature) with (item)");
        attackWithItem.setEditable(false);
        attackWithItem.setMinWidth(100);
        attackWithItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(attackWithItem);

        TextField examineObj = new TextField("examine (object)");
        examineObj.setEditable(false);
        examineObj.setMinWidth(100);
        examineObj.setAlignment(Pos.CENTER);
        column1.getChildren().add(examineObj);

        HBox buttons = new HBox();

        Button prev = new Button("Prev Page");
        prev.setMinSize(50,50);
        prev.setAlignment(Pos.CENTER);
        prev.setOnMouseClicked(this::downPage);
        buttons.getChildren().add(prev);

        Button next = new Button("Next Page");
        next.setMinSize(50,50);
        next.setAlignment(Pos.CENTER);
        next.setOnMouseClicked(this::upPage);
        buttons.getChildren().add(next);

        column1.getChildren().add(buttons);

        VBox column2 = new VBox();

        TextField shortcut = new TextField("Shortcut");
        shortcut.setEditable(false);
        shortcut.setMaxWidth(80);
        shortcut.setAlignment(Pos.CENTER);
        column2.getChildren().add(shortcut);

        TextField e1 = new TextField();
        e1.setMaxWidth(80);
        column2.getChildren().add(e1);

        TextField e2 = new TextField();
        e2.setMaxWidth(80);
        column2.getChildren().add(e2);

        TextField e3 = new TextField();
        e3.setMaxWidth(80);
        column2.getChildren().add(e3);

        TextField e4 = new TextField();
        e4.setMaxWidth(80);
        column2.getChildren().add(e4);

        TextField e5 = new TextField();
        e5.setMaxWidth(80);
        column2.getChildren().add(e5);

        TextField e6 = new TextField();
        e6.setMaxWidth(80);
        column2.getChildren().add(e6);

        TextField e7 = new TextField();
        e7.setMaxWidth(80);
        column2.getChildren().add(e7);

        TextField e8 = new TextField();
        e8.setMaxWidth(80);
        column2.getChildren().add(e8);

        TextField e9 = new TextField();
        e9.setMaxWidth(80);
        column2.getChildren().add(e9);

        TextField e10 = new TextField();
        e10.setMaxWidth(80);
        column2.getChildren().add(e10);

        TextField e11 = new TextField();
        e11.setMaxWidth(80);
        column2.getChildren().add(e11);

        TextField e12 = new TextField();
        e12.setMaxWidth(80);
        column2.getChildren().add(e12);

        TextField e13 = new TextField();
        e13.setMaxWidth(80);
        column2.getChildren().add(e13);

        TextField e14 = new TextField();
        e14.setMaxWidth(80);
        column2.getChildren().add(e14);


        VBox column3 = new VBox();

        TextField action = new TextField("Action");
        action.setEditable(false);
        action.setMinWidth(500);
        action.setAlignment(Pos.CENTER);
        column3.getChildren().add(action);

        TextField a1 = new TextField("Removes item from current room; places it in your inventory");
        a1.setEditable(false);
        a1.setMinWidth(500);
        a1.setAlignment(Pos.CENTER);
        column3.getChildren().add(a1);

        TextField a2 = new TextField("takes all takeable objects in room");
        a2.setEditable(false);
        a2.setMinWidth(500);
        a2.setAlignment(Pos.CENTER);
        column3.getChildren().add(a2);

        TextField a3 = new TextField("Throws the item at something");
        a3.setEditable(false);
        a3.setMinWidth(500);
        a3.setAlignment(Pos.CENTER);
        column3.getChildren().add(a3);

        TextField a4 = new TextField("Opens the container, whether it is in the room or your inventory");
        a4.setEditable(false);
        a4.setMinWidth(500);
        a4.setAlignment(Pos.CENTER);
        column3.getChildren().add(a4);

        TextField a5 = new TextField("Opens the exit for travel");
        a5.setEditable(false);
        a5.setMinWidth(500);
        a5.setAlignment(Pos.CENTER);
        column3.getChildren().add(a5);

        TextField a6 = new TextField("Reads what is written on readable item");
        a6.setEditable(false);
        a6.setMinWidth(500);
        a6.setAlignment(Pos.CENTER);
        column3.getChildren().add(a6);

        TextField a7 = new TextField("Removes item from inventory; places it in current room");
        a7.setEditable(false);
        a7.setMinWidth(500);
        a7.setAlignment(Pos.CENTER);
        column3.getChildren().add(a7);

        TextField a8 = new TextField("Removes item from inventory; places it in container");
        a8.setEditable(false);
        a8.setMinWidth(500);
        a8.setAlignment(Pos.CENTER);
        column3.getChildren().add(a8);

        TextField a9 = new TextField("Attempts to operate the control with the item");
        a9.setEditable(false);
        a9.setMinWidth(500);
        a9.setAlignment(Pos.CENTER);
        column3.getChildren().add(a9);

        TextField a10 = new TextField("Turns on the item");
        a10.setEditable(false);
        a10.setMinWidth(500);
        a10.setAlignment(Pos.CENTER);
        column3.getChildren().add(a10);

        TextField a11 = new TextField("Turns the item off");
        a11.setEditable(false);
        a11.setMinWidth(500);
        a11.setAlignment(Pos.CENTER);
        column3.getChildren().add(a11);

        TextField a12 = new TextField("Moves a large object that cannot be picked up");
        a12.setEditable(false);
        a12.setMinWidth(500);
        a12.setAlignment(Pos.CENTER);
        column3.getChildren().add(a12);

        TextField a13 = new TextField("Attacks creature with the item");
        a13.setEditable(false);
        a13.setMinWidth(500);
        a13.setAlignment(Pos.CENTER);
        column3.getChildren().add(a13);

        TextField a14 = new TextField("Examines, or looks, at an object or item or location");
        a14.setEditable(false);
        a14.setMinWidth(500);
        a14.setAlignment(Pos.CENTER);
        column3.getChildren().add(a14);


        flow.getChildren().add(column1);
        //flow.getChildren().add(column2);
        flow.getChildren().add(column3);

        return new Scene(flow, 800, 600);
    }

    public Scene helpStagePage3(){

        FlowPane flow = new FlowPane();

        //GridLayout grid = new GridLayout();
        flow.setHgap(2);
        flow.setVgap(2);

        VBox column1 = new VBox();


        TextField commandArguement = new TextField("Command (Argument)");
        //commandArguement.setStyle("-fx-font-weight: bold");
        //commandArguement.setStyle("-fx-background-color: gray;");
        commandArguement.setEditable(false);
        commandArguement.setMinWidth(100);
        commandArguement.setAlignment(Pos.CENTER);
        column1.getChildren().add(commandArguement);

        TextField inventory = new TextField("inventory");
        inventory.setEditable(false);
        inventory.setMinWidth(100);
        inventory.setAlignment(Pos.CENTER);
        column1.getChildren().add(inventory);

        TextField eat = new TextField("eat");
        eat.setEditable(false);
        eat.setMinWidth(100);
        eat.setAlignment(Pos.CENTER);
        column1.getChildren().add(eat);

        TextField shout = new TextField("shout");
        shout.setEditable(false);
        shout.setMinWidth(100);
        shout.setAlignment(Pos.CENTER);
        column1.getChildren().add(shout);

        TextField closeDoor = new TextField("close [Door]");
        closeDoor.setEditable(false);
        closeDoor.setMinWidth(100);
        closeDoor.setAlignment(Pos.CENTER);
        column1.getChildren().add(closeDoor);

        TextField tieItemToObj = new TextField("tie (item) to (object)");
        tieItemToObj.setEditable(false);
        tieItemToObj.setMinWidth(100);
        tieItemToObj.setAlignment(Pos.CENTER);
        column1.getChildren().add(tieItemToObj);

        TextField pickItem = new TextField("pick (item)");
        pickItem.setEditable(false);
        pickItem.setMinWidth(100);
        pickItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(pickItem);

        TextField killSelf = new TextField("kill self with (weapon)");
        killSelf.setEditable(false);
        killSelf.setMinWidth(100);
        killSelf.setAlignment(Pos.CENTER);
        column1.getChildren().add(killSelf);

        TextField breakItem = new TextField("break (item) with (item)");
        breakItem.setEditable(false);
        breakItem.setMinWidth(100);
        breakItem.setAlignment(Pos.CENTER);
        column1.getChildren().add(breakItem);

        TextField killCreature = new TextField("kill (creature) with (item)");
        killCreature.setEditable(false);
        killCreature.setMinWidth(100);
        killCreature.setAlignment(Pos.CENTER);
        column1.getChildren().add(killCreature);

        TextField pray = new TextField("pray");
        pray.setEditable(false);
        pray.setMinWidth(100);
        pray.setAlignment(Pos.CENTER);
        column1.getChildren().add(pray);

        TextField drink = new TextField("drink");
        drink.setEditable(false);
        drink.setMinWidth(100);
        drink.setAlignment(Pos.CENTER);
        column1.getChildren().add(drink);

        TextField smell = new TextField("smell");
        smell.setEditable(false);
        smell.setMinWidth(100);
        smell.setAlignment(Pos.CENTER);
        column1.getChildren().add(smell);

        TextField cutObject = new TextField("cut(object/item) with(weapon)");
        cutObject.setEditable(false);
        cutObject.setMinWidth(100);
        cutObject.setAlignment(Pos.CENTER);
        column1.getChildren().add(cutObject);

        TextField listen = new TextField("listen(target)");
        listen.setEditable(false);
        listen.setMinWidth(100);
        listen.setAlignment(Pos.CENTER);
        column1.getChildren().add(listen);

        Button prev = new Button("Prev Page");
        prev.setMinSize(50,50);
        prev.setAlignment(Pos.CENTER);
        prev.setOnMouseClicked(this::downPage);
        column1.getChildren().add(prev);

        VBox column2 = new VBox();

        TextField shortcut = new TextField("Shortcut");
        shortcut.setEditable(false);
        shortcut.setMaxWidth(80);
        shortcut.setAlignment(Pos.CENTER);
        column2.getChildren().add(shortcut);

        TextField e13 = new TextField();
        e13.setMaxWidth(80);
        column2.getChildren().add(e13);

        TextField e14 = new TextField();
        e14.setMaxWidth(80);
        column2.getChildren().add(e14);

        TextField e15 = new TextField();
        e15.setMaxWidth(80);
        column2.getChildren().add(e15);

        TextField e16 = new TextField();
        e16.setMaxWidth(80);
        column2.getChildren().add(e16);

        TextField e17 = new TextField();
        e17.setMaxWidth(80);
        column2.getChildren().add(e17);

        TextField e18 = new TextField();
        e18.setMaxWidth(80);
        column2.getChildren().add(e18);

        TextField e19 = new TextField();
        e19.setMaxWidth(80);
        column2.getChildren().add(e19);

        TextField e20 = new TextField();
        e20.setMaxWidth(80);
        column2.getChildren().add(e20);

        TextField e21 = new TextField();
        e21.setMaxWidth(80);
        column2.getChildren().add(e21);

        TextField e22 = new TextField();
        e22.setMaxWidth(80);
        column2.getChildren().add(e22);

        TextField e23 = new TextField();
        e23.setMaxWidth(80);
        column2.getChildren().add(e23);

        TextField e24 = new TextField();
        e24.setMaxWidth(80);
        column2.getChildren().add(e24);

        TextField e25 = new TextField();
        e25.setMaxWidth(80);
        column2.getChildren().add(e25);

        TextField e26 = new TextField();
        e26.setMaxWidth(80);
        column2.getChildren().add(e26);

        VBox column3 = new VBox();

        TextField action = new TextField("Action");
        action.setEditable(false);
        action.setMinWidth(500);
        action.setAlignment(Pos.CENTER);
        column3.getChildren().add(action);

        TextField a15 = new TextField("Shows contents of Inventory");
        a15.setEditable(false);
        a15.setMinWidth(500);
        a15.setAlignment(Pos.CENTER);
        column3.getChildren().add(a15);

        TextField a16 = new TextField("Eats item (specifically food)");
        a16.setEditable(false);
        a16.setMinWidth(500);
        a16.setAlignment(Pos.CENTER);
        column3.getChildren().add(a16);

        TextField a18 = new TextField("Aaaarrrrgggghhhh!");
        a18.setEditable(false);
        a18.setMinWidth(500);
        a18.setAlignment(Pos.CENTER);
        column3.getChildren().add(a18);

        TextField a19 = new TextField("Closes door");
        a19.setEditable(false);
        a19.setMinWidth(500);
        a19.setAlignment(Pos.CENTER);
        column3.getChildren().add(a19);

        TextField a20 = new TextField("ties item to object");
        a20.setEditable(false);
        a20.setMinWidth(500);
        a20.setAlignment(Pos.CENTER);
        column3.getChildren().add(a20);

        TextField a21 = new TextField("take/get item");
        a21.setEditable(false);
        a21.setMinWidth(500);
        a21.setAlignment(Pos.CENTER);
        column3.getChildren().add(a21);

        TextField a22 = new TextField("Humorously commits suicide");
        a22.setEditable(false);
        a22.setMinWidth(500);
        a22.setAlignment(Pos.CENTER);
        column3.getChildren().add(a22);

        TextField a23 = new TextField("Breaks item");
        a23.setEditable(false);
        a23.setMinWidth(500);
        a23.setAlignment(Pos.CENTER);
        column3.getChildren().add(a23);

        TextField a24 = new TextField("Attacks creature with the item");
        a24.setEditable(false);
        a24.setMinWidth(500);
        a24.setAlignment(Pos.CENTER);
        column3.getChildren().add(a24);

        TextField a25 = new TextField("when you are in temples...");
        a25.setEditable(false);
        a25.setMinWidth(500);
        a25.setAlignment(Pos.CENTER);
        column3.getChildren().add(a25);

        TextField a26 = new TextField("drink an item");
        a26.setEditable(false);
        a26.setMinWidth(500);
        a26.setAlignment(Pos.CENTER);
        column3.getChildren().add(a26);

        TextField a27 = new TextField("smell an item");
        a27.setEditable(false);
        a27.setPrefWidth(500);
        a27.setAlignment(Pos.CENTER);
        column3.getChildren().add(a27);

        TextField a28 = new TextField("Comment: Strange concept, cutting the (object/item)\n" +
                "If (object/item)=self then you commit suicide");
        a28.setEditable(false);
        a28.setMinWidth(500);
        a28.setAlignment(Pos.CENTER);
        column3.getChildren().add(a28);

        TextField a29 = new TextField("Listens to a creature or item.");
        a29.setEditable(false);
        a29.setMinWidth(500);
        a29.setAlignment(Pos.CENTER);
        column3.getChildren().add(a29);

        flow.getChildren().add(column1);
        //flow.getChildren().add(column2);
        flow.getChildren().add(column3);


        return new Scene(flow, 800, 600);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
