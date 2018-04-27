package Map;

import java.util.HashMap;
import java.util.Map;
import Buttons.Compass;
import Objects.*;

public class GameMap{
	
	private Map<String, Item> itemList;
	private Map<String, Room> roomList;
	private Room currentRoom;
	
	public GameMap() {
		roomList= new HashMap<String, Room>();
		itemList = new HashMap<String, Item>();
		createMap();
	}
	
	public Map<String, Room> getRoomList(){
		return this.roomList;
	}
	public Room getRoom(String roomName) {
		return roomList.get(roomName);
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public void setCurrentRoom(String roomName) {
		currentRoom=getRoom(roomName);
	}
	
	public void goToRoom(Compass comp) {
		currentRoom=currentRoom.getAdjacentRoom(comp);
	}
	
	public Map<String, Item> getItemList(){
		return this.itemList;
	}
	
	public Item getItem(String itemName) {
		return itemList.get(itemName);
	}
	
	public void createMap() {
		
		
		Room westOfHouse = new Room("West of House");
		westOfHouse.setDescription("You are standing in an open field west of a white house, with a boarded front door. There is a small mailbox.");
		Map<Compass, Room> mapWestOfHouse = new HashMap<Compass, Room>();
		
		
		Room northOfHouse = new Room("North of House");
		northOfHouse.setDescription("You are facing the north side of a white house. There is no door here, and all the windows are boarded up. To the north, a narrow panth winds through the trees.");
		Map<Compass, Room> mapNorthOfHouse = new HashMap<Compass, Room>();
		
		Room southOfHouse = new Room("South of House");
		southOfHouse.setDescription("You are facing the south side of a white house. There is no door here, and all the windows are boarded.");
		Map<Compass, Room> mapSouthOfHouse = new HashMap<Compass, Room>();
		
		Room behindTheHouse = new Room("Behind the House");
		behindTheHouse.setDescription("You are behind the white house. A path leads into the forest to the east. In one corner of the house there is a small window which is open.");
		Map<Compass, Room> mapBehindTheHouse = new HashMap<Compass, Room>();
		
		
		Room forest1 = new Room("Forest 1");
		forest1.setDescription("This is a forest, with trees in all directions. To the east, there appears to be sunlight.");
		Map<Compass, Room> mapForest1 = new HashMap<Compass, Room>();
		
		
		Room forestPath = new Room("Forest Path");
		forestPath.setDescription("This is a path winding through a dimly lit forest. The path heads north-south here. One particularly large tree with some low branches stands at the edge of the path.");
		Map<Compass, Room> mapForestPath = new HashMap<Compass, Room>();
		
		Room forest2 = new Room("Forest 2");
		forest2.setDescription("This is a dimly lit forest, with  large trees all around.");
		Map<Compass, Room> mapForest2 = new HashMap<Compass, Room>();
		
		Room clearing1 = new Room("Clearing");
		clearing1.setDescription("You are in a clearing, with a forest surrounding you on all sides.There is a pile of leaves at your feet.There is also a path leading south.");
		Map<Compass, Room> mapClearing1 = new HashMap<Compass, Room>();
		
		Room upATree = new Room("Up a Tree");
		upATree.setDescription("You are about 10 feet above the ground nestled among some large branches.The nearest branch above you is out of your reach. There is a bird's next in front of your face.");
		Map<Compass, Room> mapUpATree = new HashMap<Compass, Room>();
		
		mapForestPath.put(Compass.UP, upATree);
		mapForestPath.put(Compass.NORTH, clearing1);
		mapForestPath.put(Compass.SOUTH, northOfHouse);
		mapForestPath.put(Compass.WEST, forest1);
		mapForestPath.put(Compass.EAST, forest2);
		forestPath.setAdjacentRooms(mapForestPath);
		
		mapUpATree.put(Compass.DOWN, forestPath);
		upATree.setAdjacentRooms(mapUpATree);
		
		mapClearing1.put(Compass.SOUTH, forestPath);
		mapClearing1.put(Compass.NORTH, clearing1);
		mapClearing1.put(Compass.EAST, forest2);
		mapClearing1.put(Compass.WEST, forest1);
		
		mapWestOfHouse.put(Compass.NORTH, northOfHouse);
		mapWestOfHouse.put(Compass.NORTHEAST, northOfHouse);
		mapWestOfHouse.put(Compass.SOUTH, southOfHouse);
		mapWestOfHouse.put(Compass.SOUTHEAST, southOfHouse);
		mapWestOfHouse.put(Compass.WEST, forest1);
		
		mapNorthOfHouse.put(Compass.SOUTHWEST, westOfHouse);
		mapNorthOfHouse.put(Compass.WEST, westOfHouse);
		mapNorthOfHouse.put(Compass.NORTH, forestPath);
		mapNorthOfHouse.put(Compass.EAST, behindTheHouse);
		mapNorthOfHouse.put(Compass.SOUTHEAST, behindTheHouse);
		northOfHouse.setAdjacentRooms(mapNorthOfHouse);
		
		
		
		Room clearing2 = new Room("Clearing 2");
		clearing2.setDescription("You are in a small clearing in a well marked forest path that extends east and west.");
		Map<Compass, Room> mapClearing2 = new HashMap<Compass, Room>();
		
		Room forest3 = new Room("Forest 3");
		forest3.setDescription("This is a dimly lit forest, with large trees all around.");
		Map<Compass, Room> mapForest3 = new HashMap<Compass, Room>();
		
		Room canyonView = new Room("Canyon View");
		canyonView.setDescription("You are at the top of the Great Canyon on its south wall. From here there is a marvelous view of the canyon and parts of the Frigid River upstream. Across the canyon, the walls of the White Cliffs join the mighty ramparts of the Flathead Mountains to the east. White Cliffs still appear to loom far above. Following the Canyon upstream to the north and northwest, Aragain Falls may be seen, complete with rainbow. The mighty Frigid River flows out from a great dark cavern. Unfortunately, my vision is better than average and I can discern the top of the Flood Control Dam #3 far to the distant north. To the west and south can be seen an immense forest, stretching for miles around. A path leads northwest. It is possible to climb down into the canyon from here.");
		Map<Compass, Room> mapCanyonView = new HashMap<Compass, Room>();
		
		Room rockyLedge = new Room("Rocky Ledge");
		rockyLedge.setDescription("You are on a ledge about halfway up the wall of the river canyon. You can see from here that the main flow from Aragain Falls twists along a passage which it is impossible for you to enter. Below you is the canyon bottom. Above you is more cliff, which appears climbable.");
		Map<Compass, Room> mapRockyLedge = new HashMap<Compass, Room>();
		
		Room canyonBottom = new Room("Canyon Bottom");
		canyonBottom.setDescription("You are beneath the walls of the river canyon which may be climbable here. There is a small stream here, which is The lesser part of the runoff of Aragain Falls flows by below. To the north is a narrow path.");
		Map<Compass, Room> mapCanyonBottom = new HashMap<Compass, Room>();
		
		Room endOfRainbow = new Room("End of Rainbow");
		endOfRainbow.setDescription("You are on a small, rocky beach on the continuation of the Frigid River past the Falls. The beach is narrow due to the presence of the White Cliffs. The river canyon opens here and sunlight shines in from above. A rainbow crosses over the falls to the east and a narrow path continues to the southwest.");
		Map<Compass, Room> mapEndOfRainbow = new HashMap<Compass, Room>();
		
		Room onTheRainbow = new Room("On The Rainbow");
		onTheRainbow.setDescription("");
		Map<Compass, Room> mapOnTheRainbow = new HashMap<Compass, Room>();
		
		Room aragainFalls = new Room("Aragain Falls");
		aragainFalls.setDescription("");
		Map<Compass, Room> mapAragainFalls = new HashMap<Compass, Room>();
		
		mapSouthOfHouse.put(Compass.NORTHWEST, westOfHouse);
		mapSouthOfHouse.put(Compass.WEST, westOfHouse);
		mapSouthOfHouse.put(Compass.NORTHEAST, behindTheHouse);
		mapSouthOfHouse.put(Compass.EAST, behindTheHouse);
		mapSouthOfHouse.put(Compass.SOUTH, forest3);
		southOfHouse.setAdjacentRooms(mapSouthOfHouse);
		
		Room stoneBarrow = new Room("Stone Barrow");
		stoneBarrow.setDescription("You are standing in front of a massive barrow of stone. In the east face is a huge stone door which is open. You cannot see into the dark of the tomb.");
		Map<Compass, Room> mapStoneBarrow = new HashMap<Compass, Room>();
		
		Room insideTheBarrow = new Room("Inside the Barrow");
		insideTheBarrow.setDescription("As you enter the barrow, the door closes inexorably behind you. Around you it is dark, but ahead is an enormous cavern, brightly lit. Through its center runs a wide stream. Spanning the stream is a small wooden footbridge, and beyond a path leads into a dark tunnel. Above the bridge, floating in the air, is a large sign. It reads:  All ye who stand before this bridge have completed a great and perilous adventure which has tested your wit and courage. You have mastered the first part of the ZORK trilogy. Those who pass over this bridge must be prepared to undertake an even greater adventure that will severely test your skill and bravery! The ZORK trilogy continues with \"ZORK II: The Wizard of Frobozz\" and is completed in \"ZORK III: The Dungeon Master.\"");
		
		mapWestOfHouse.put(Compass.SOUTHWEST, stoneBarrow);
		westOfHouse.setAdjacentRooms(mapWestOfHouse);
				
		mapStoneBarrow.put(Compass.NORTHEAST, westOfHouse);
		mapStoneBarrow.put(Compass.WEST, insideTheBarrow);
		stoneBarrow.setAdjacentRooms(mapStoneBarrow);
				
		Room gratingRoom = new Room("Grating Room");
		gratingRoom.setDescription("You are in a small room near the maze. There are twisty passages in the immediate vicinity. Above you is an open grating with sunlight pouring in.");
		Map<Compass, Room> mapGratingRoom = new HashMap<Compass, Room>();
		
		mapClearing1.put(Compass.DOWN, gratingRoom);
		clearing1.setAdjacentRooms(mapClearing1);
		
		mapGratingRoom.put(Compass.UP, clearing1);
		
		
		Room forest4 = new Room("Forest (Mountains) 4");
		forest4.setDescription("The forest thins out, revealing impassable mountains. This is a large forest, with trees obstructing all views except to the east, where a small clearing may be seen through the trees.");
		Map<Compass, Room> mapForest4 = new HashMap<Compass, Room>();
		
		Room kitchen = new Room("Kitchen");
		kitchen.setDescription("You are in the kitchen of the white house. A table seems to have been used recently for the preparation of food. A passage leads to the west and a dark staircase can be seen leading upward. A dark chimney leads down and to the east is a small window which is open.");
		Map<Compass, Room> mapKitchen = new HashMap<Compass, Room>();

		mapBehindTheHouse.put(Compass.NORTH, northOfHouse);
		mapBehindTheHouse.put(Compass.NORTHWEST, northOfHouse);
		mapBehindTheHouse.put(Compass.WEST, kitchen);
		mapBehindTheHouse.put(Compass.EAST, clearing2);
		mapBehindTheHouse.put(Compass.SOUTH, southOfHouse);
		mapBehindTheHouse.put(Compass.SOUTHWEST, southOfHouse);
		behindTheHouse.setAdjacentRooms(mapBehindTheHouse);		
		
		mapForest1.put(Compass.NORTH, clearing1);
		mapForest1.put(Compass.WEST, forest1);
		mapForest1.put(Compass.EAST, forestPath);
		mapForest1.put(Compass.SOUTH, forest3);
		forest1.setAdjacentRooms(mapForest1);
		
		mapForest2.put(Compass.WEST, forestPath);
		mapForest2.put(Compass.EAST, forest4);
		mapForest2.put(Compass.SOUTH, clearing2);
		forest2.setAdjacentRooms(mapForest2);
		
		mapForest3.put(Compass.NORTH, clearing2);
		mapForest3.put(Compass.NORTHWEST, southOfHouse);
		mapForest3.put(Compass.WEST, forest1);
		mapForest3.put(Compass.SOUTH, forest3);
		forest3.setAdjacentRooms(mapForest3);
		
		mapForest4.put(Compass.NORTH, forest2);
		mapForest4.put(Compass.WEST, forest2);
		mapForest4.put(Compass.SOUTH, forest2);
		mapForest4.put(Compass.EAST, forest4);
		forest4.setAdjacentRooms(mapForest4);
		
		mapClearing2.put(Compass.NORTH, forest2);
		mapClearing2.put(Compass.SOUTH, forest3);
		mapClearing2.put(Compass.WEST, behindTheHouse);
		mapClearing2.put(Compass.EAST, canyonView);
		clearing2.setAdjacentRooms(mapClearing2);
		
		mapCanyonView.put(Compass.NORTHWEST, clearing2);
		mapCanyonView.put(Compass.WEST, forest3);
		mapCanyonView.put(Compass.EAST, rockyLedge);
		mapCanyonView.put(Compass.DOWN, rockyLedge);
		canyonView.setAdjacentRooms(mapCanyonView);
		
		mapRockyLedge.put(Compass.UP, canyonView);
		mapRockyLedge.put(Compass.DOWN, canyonBottom);
		rockyLedge.setAdjacentRooms(mapRockyLedge);
		
		mapCanyonBottom.put(Compass.UP, rockyLedge);
		mapCanyonBottom.put(Compass.NORTH, endOfRainbow);
		canyonBottom.setAdjacentRooms(mapCanyonBottom);
		
		mapEndOfRainbow.put(Compass.SOUTHWEST, canyonBottom);
		mapEndOfRainbow.put(Compass.EAST, onTheRainbow);
		endOfRainbow.setAdjacentRooms(mapEndOfRainbow);
				
		mapOnTheRainbow.put(Compass.WEST, endOfRainbow);
		mapOnTheRainbow.put(Compass.EAST, aragainFalls);
		onTheRainbow.setAdjacentRooms(mapOnTheRainbow);
		
		mapAragainFalls.put(Compass.WEST, onTheRainbow);
		
		
		
		Room attic = new Room("Attic");
		attic.setDescription("This is the attic. The only exit is a stairway leading down.");
		Map<Compass, Room> mapAttic = new HashMap<Compass, Room>();

		mapKitchen.put(Compass.UP, attic);
		mapKitchen.put(Compass.EAST, behindTheHouse);
		
		mapAttic.put(Compass.DOWN, kitchen);
		attic.setAdjacentRooms(mapAttic);
		
		Room livingRoom = new Room("Living Room");
		livingRoom.setDescription("You are in the living room. There is a doorway to the east, (a wooden door with strange gothic lettering to the west, which appears to be nailed shut,)/(To the west is a cyclops-shaped opening in an old wooden door, above which is some strange gothic lettering,) a trophy case, and (and a large oriental rug in the center of the room.) (and a rug lying beside an open trap door.) (and a closed trap door at your feet.) (and an open trap door at your feet.");
		Map<Compass, Room> mapLivingRoom = new HashMap<Compass, Room>();

		Room cellar = new Room("Cellar");
		cellar.setDescription("You are in a dark and damp cellar with a narrow passageway leading north{east}, and a crawlway to the south. On the west is the bottom of a steep metal ramp which is unclimbable");
		Map<Compass, Room> mapCellar = new HashMap<Compass, Room>();

		mapKitchen.put(Compass.WEST, livingRoom);
		kitchen.setAdjacentRooms(mapKitchen);
		
		
		mapLivingRoom.put(Compass.EAST, kitchen);
		mapLivingRoom.put(Compass.DOWN, cellar);
		livingRoom.setAdjacentRooms(mapLivingRoom);
		
		Room eastOfChasm = new Room("East of Chasm");
		eastOfChasm.setDescription("You are on the east edge of a chasm, the bottom of which cannot be seen. The east side is sheer rock, providing no exits. A narrow passage goes north, and the path you are on continues to the east.");
		Map<Compass, Room> mapEastOfChasm = new HashMap<Compass, Room>();

		
		Room gallery = new Room("Gallery");
		gallery.setDescription("This is an art gallery. Most of the paintings which were here have been stolen by vandals with exceptional taste. The vandals left through either the north, south, or west exits.");
		Map<Compass, Room> mapGallery = new HashMap<Compass, Room>();

		Room studio = new Room("Studio");
		studio.setDescription("This is what appears to have been an artist's studio. The walls and floors are splattered with paints of 69 different colors. Strangely enough, nothing of value is hanging here. At the south end of the room is an open door {At the north and northwest of the room are open doors} (also covered with paint). An extremely dark and narrow chimney leads up from a fireplace; although you might be able to get up it, it seems unlikely you could get back down.");
		Map<Compass, Room> mapStudio = new HashMap<Compass, Room>();

		Room trollRoom = new Room("Troll Room");
		trollRoom.setDescription("This is a small room with passages to the east and south and a forbidding hole leading west {passages off in all directions}. Bloodstains and deep scratches (perhaps made by an axe) mar the walls.");
		Map<Compass, Room> mapTrollRoom = new HashMap<Compass, Room>();

		mapCellar.put(Compass.UP, livingRoom);
		mapCellar.put(Compass.SOUTH, eastOfChasm);
		mapCellar.put(Compass.NORTH, trollRoom);
		
		mapEastOfChasm.put(Compass.NORTH, cellar);
		mapEastOfChasm.put(Compass.EAST, gallery);
		eastOfChasm.setAdjacentRooms(mapEastOfChasm);
		
		mapGallery.put(Compass.WEST, eastOfChasm);
		mapGallery.put(Compass.NORTH, studio);
		gallery.setAdjacentRooms(mapGallery);
		
		mapStudio.put(Compass.SOUTH, gallery);
		mapStudio.put(Compass.UP, kitchen);
		studio.setAdjacentRooms(mapStudio);
		
		Room eastWestPassage = new Room("East-West Passage");
		eastWestPassage.setDescription("This is a narrow east-west passageway. There is a narrow stairway leading down at the north end of the room.");
		Map<Compass, Room> mapEastWestPassage = new HashMap<Compass, Room>();

		Room chasm = new Room("Chasm");
		chasm.setDescription("A chasm runs southwest to northeast and the path follows it. You are on the south side of the chasm, where a crack opens into a passage.");
		Map<Compass, Room> mapChasm = new HashMap<Compass, Room>();

		Room roundRoom = new Room("Round Room");
		roundRoom.setDescription("This is a circular stone room with passages in all eight directions. Several of them have unfortunately been blocked by cave-ins.");
		Map<Compass, Room> mapRoundRoom = new HashMap<Compass, Room>();

		Room northSouthPassage = new Room("North-South Passage");
		northSouthPassage.setDescription("This is a high north-south passage, which forks to the northeast.");
		Map<Compass, Room> mapNorthSouthPassage = new HashMap<Compass, Room>();

		mapTrollRoom.put(Compass.SOUTH, cellar);
		mapTrollRoom.put(Compass.EAST, eastWestPassage);

		mapRoundRoom.put(Compass.NORTH, northSouthPassage);
		mapRoundRoom.put(Compass.WEST, eastWestPassage);

		mapEastWestPassage.put(Compass.NORTH, chasm);
		mapEastWestPassage.put(Compass.WEST, trollRoom);
		mapEastWestPassage.put(Compass.EAST, roundRoom);
		eastWestPassage.setAdjacentRooms(mapEastWestPassage);
		
		mapChasm.put(Compass.SOUTHWEST, eastWestPassage);
		mapChasm.put(Compass.SOUTH, northSouthPassage);

		mapNorthSouthPassage.put(Compass.NORTH, chasm);
		mapNorthSouthPassage.put(Compass.SOUTH, roundRoom);
		
		
		Room reservoirSouth = new Room("Reservoir South");
		reservoirSouth.setDescription("You are in a long room on the south shore of a large lake {reservoir}, far too deep and wide for crossing. \n" +
				"[You are in a long room. To the north is a large lake, too deep to cross. You notice, however, that the water level appears to be dropping at a rapid rate. Before long, it might be possible to cross to the other side from here.]\n" +
				"[You are in a long room, to the north of which was formerly a lake {reservoir}. However, with the water level lowered, there is merely a wide stream running through the center of the room.]\n" +
				"There is a path along the stream to the east or west, a steep pathway climbing southwest along the edge of a chasm, and a path leading into a canyon to the southeast. {There is a western exit, a passageway south, and a steep pathway climbing up along the edge of a cliff.}");
		Map<Compass, Room> mapReservoirSouth = new HashMap<Compass, Room>();

		Room reservoir = new Room("Reservoir");
		reservoir.setDescription("You are on the lake {reservoir}. Beaches can be seen north and south. Upstream a small stream enters the lake through a narrow cleft in the rocks. The dam can be seen downstream.\n" +
				"[You are on what used to be a large lake {reservoir}, but which is now a large mud pile. There are \"shores\" to the north and south.]");
		Map<Compass, Room> mapReservoir = new HashMap<Compass, Room>();

		Room streamView = new Room("Stream View");
		streamView.setDescription("You are standing on a path beside a gently flowing stream. The path follows the stream, which flows from west to east {The path travels to the north and the east}.");
		Map<Compass, Room> mapStreamView = new HashMap<Compass, Room>();

		Room stream = new Room("Stream");
		stream.setDescription("You are on the gently flowing stream. The upstream route is too narrow to navigate, and the downstream route is invisible due to twisting walls. There is a narrow beach to land on.");
		Map<Compass, Room> mapStream = new HashMap<Compass, Room>();

		mapChasm.put(Compass.NORTHEAST, reservoirSouth);
		chasm.setAdjacentRooms(mapChasm);
		
		mapReservoirSouth.put(Compass.SOUTHWEST, chasm);
		mapReservoirSouth.put(Compass.NORTH, reservoir);
		mapReservoirSouth.put(Compass.EAST, streamView);
		
		mapReservoir.put(Compass.WEST, stream);
		mapReservoir.put(Compass.SOUTH, reservoirSouth);
		
		
		mapStream.put(Compass.EAST, reservoir);
		mapStream.put(Compass.SOUTH, streamView);
		stream.setAdjacentRooms(mapStream);
		
		mapStreamView.put(Compass.NORTH, stream);
		mapStreamView.put(Compass.EAST, reservoirSouth);
		streamView.setAdjacentRooms(mapStreamView);
		
		Room reservoirNorth = new Room("Reservior");
		reservoirNorth.setDescription("You are in a large cavernous room, north of a large reservoir.\n" +
				"[You are in a large cavernous room, the south of which was formerly a lake {reservoir}. However, with the water level lowered, there is merely a wide stream running through there {through the center of the room}.]\n" +
				"[You are in a long room, to the north of which is a wide area which was formerly a reservoir, but now is merely a stream. You notice, however, that the level of the stream is rising quickly and that before long it will be impossible to cross here.]\n" +
				"[You are in a large cavernous area. To the south is a wide lake, whose water level appears to be falling rapidly.]\n" +
				"[You are in a cavernous area, to the south of which is a very wide stream. The level of the stream is rising rapidly, and it appears that before long it will be impossible to cross to the other side.]\n" +
				"There is a slimy stairway {a tunnel} leaving the room to the north.");
		Map<Compass, Room> mapReservoirNorth = new HashMap<Compass, Room>();

		Room atlantisRoom = new Room("Atlantis Room");
		atlantisRoom.setDescription("This is an ancient room, long under water. There is an exit here to the south and a staircase leading upward.");
		Map<Compass, Room> mapAtlantisRoom = new HashMap<Compass, Room>();

		Room cave1 = new Room("Cave");
		cave1.setDescription("This is a tiny cave with entrances west and north, and a staircase leading down.");
		Map<Compass, Room> mapCave1 = new HashMap<Compass, Room>();

		Room mirrorRoomNorth = new Room("Mirror Room");
		mirrorRoomNorth.setDescription("You are in a large square room with tall ceilings. On the south wall is an enormous mirror which fills the entire wall. There are exits on the other three sides of the room.\n" +
				"[Unfortunately, the mirror has been destroyed by your recklessness.]");
		Map<Compass, Room> mapMirrorRoomNorth = new HashMap<Compass, Room>();

		Room twistingPassage = new Room("Twisting Passage");
		twistingPassage.setDescription("This is a winding passage. It seems that there are only exits on the east and north.");
		Map<Compass, Room> mapTwistingPassage = new HashMap<Compass, Room>();

		Room coldPassage = new Room("Cold Passage");
		coldPassage.setDescription("This is a cold and damp corridor where a long east-west passageway turns into a southward path {passageway intersects with a northward path}.");
		Map<Compass, Room> mapColdPassage = new HashMap<Compass, Room>();

		Room slideRoom = new Room("Slide Room");
		slideRoom.setDescription("This is a small chamber, which appears to have been part of a coal mine. On the south wall of the chamber the letters \"Granite Wall\" are etched in the rock.\n" +
				"To the east is a long passage, and there is a steep metal slide twisting downward. To the north is a small opening.");
		Map<Compass, Room> mapSlideRoom = new HashMap<Compass, Room>();

		mapReservoirNorth.put(Compass.SOUTH, reservoir);
		mapReservoirNorth.put(Compass.NORTH, atlantisRoom);
		reservoirNorth.setAdjacentRooms(mapReservoirNorth);
		
		mapReservoir.put(Compass.NORTH, reservoirNorth);
		reservoir.setAdjacentRooms(mapReservoir);
		
		mapAtlantisRoom.put(Compass.SOUTH, reservoirNorth);
		mapAtlantisRoom.put(Compass.UP, cave1);
		atlantisRoom.setAdjacentRooms(mapAtlantisRoom);
		
		mapCave1.put(Compass.NORTH, mirrorRoomNorth);
		mapCave1.put(Compass.WEST, twistingPassage);
		cave1.setAdjacentRooms(mapCave1);
		
		mapTwistingPassage.put(Compass.EAST, cave1);
		mapTwistingPassage.put(Compass.NORTH, mirrorRoomNorth);
		twistingPassage.setAdjacentRooms(mapTwistingPassage);
		
		mapMirrorRoomNorth.put(Compass.EAST, cave1);
		mapMirrorRoomNorth.put(Compass.WEST, twistingPassage);
		mapMirrorRoomNorth.put(Compass.NORTH, coldPassage);
		mirrorRoomNorth.setAdjacentRooms(mapMirrorRoomNorth);
		
		mapColdPassage.put(Compass.SOUTH, mirrorRoomNorth);
		mapColdPassage.put(Compass.WEST, slideRoom);
		coldPassage.setAdjacentRooms(mapColdPassage);
		
		mapSlideRoom.put(Compass.DOWN, cellar);

		Room mineEntrance = new Room("Mine Entrance");
		mineEntrance.setDescription("You are standing at the entrance of what might have been a coal mine. The shaft enters the west wall {To the northeast and the northwest are entrances to the mine}, and there is another exit on the south end of the room.");
		Map<Compass, Room> mapMineEntance = new HashMap<Compass, Room>();

		Room squeakyRoom = new Room("Squeaky Room");
		squeakyRoom.setDescription("You are in a small room. Strange squeaky sounds may be heard coming from the passage at the north {west} end. You may also escape to the east {south}.");
		Map<Compass, Room> mapSqueakyRoom = new HashMap<Compass, Room>();

		Room batRoom = new Room("Bat Room");
		batRoom.setDescription("You are in a small room which has doors only to the east and south {which only has one door, to the east}.");
		Map<Compass, Room> mapBatRoom = new HashMap<Compass, Room>();

		Room shaftRoom = new Room("Shaft Room");
		shaftRoom.setDescription("This is a large room, in the middle of which is a small shaft descending through the floor into darkness below. To the west and the north are exits from this room. Constructed over the top of the shaft is a metal framework to which a heavy iron chain is attached.");
		Map<Compass, Room> mapShaftRoom = new HashMap<Compass, Room>();

		Room smellyRoom = new Room("Smelly Room");
		smellyRoom.setDescription("This is a small non-descript room. However, from the direction of a small descending staircase a foul odor can be detected. To the south {east} is a narrow tunnel {path}.");
		Map<Compass, Room> mapSmellyRoom = new HashMap<Compass, Room>();

		mapSlideRoom.put(Compass.NORTH, mineEntrance);
		slideRoom.setAdjacentRooms(mapSlideRoom);
		
		mapMineEntance.put(Compass.SOUTH, slideRoom);
		mapMineEntance.put(Compass.WEST, squeakyRoom);
		mineEntrance.setAdjacentRooms(mapMineEntance);
		
		mapSqueakyRoom.put(Compass.EAST, mineEntrance);
		mapSqueakyRoom.put(Compass.NORTH, batRoom);
		squeakyRoom.setAdjacentRooms(mapSqueakyRoom);
		
		mapBatRoom.put(Compass.SOUTH,squeakyRoom);
		mapBatRoom.put(Compass.EAST, shaftRoom);
		batRoom.setAdjacentRooms(mapBatRoom);
		
		mapShaftRoom.put(Compass.WEST, batRoom);
		mapShaftRoom.put(Compass.NORTH, smellyRoom);
		shaftRoom.setAdjacentRooms(mapShaftRoom);
		
		mapSmellyRoom.put(Compass.SOUTH, shaftRoom);

		Room gasRoom = new Room("Gas Room");
		gasRoom.setDescription("This is a small room which smells strongly of coal gas. There is a short climb up some stairs and a narrow tunnel leading east.");
		Map<Compass, Room> mapGasRoom = new HashMap<Compass, Room>();

		Room coalMine1 = new Room("Coal Mine 1");
		coalMine1.setDescription("This is a non-descript part of a coal mine.");
		Map<Compass, Room> mapCoalMine1 = new HashMap<Compass, Room>();

		Room coalMine2 = new Room("Coal Mine 2");
		coalMine2.setDescription("This is a non-descript part of a coal mine.");
		Map<Compass, Room> mapCoalMine2 = new HashMap<Compass, Room>();

		Room coalMine3 = new Room("Coal Mine 3");
		coalMine3.setDescription("This is a non-descript part of a coal mine.");
		Map<Compass, Room> mapCoalMine3 = new HashMap<Compass, Room>();

		Room coalMine4 = new Room("Coal Mine 4");
		coalMine4.setDescription("This is a non-descript part of a coal mine.");
		Map<Compass, Room> mapCoalMine4 = new HashMap<Compass, Room>();

		Room ladderTop = new Room("Ladder Top");
		ladderTop.setDescription("This is a very small room. In the corner is a rickety wooden ladder, leading downward. It might be safe to descend. There is also a staircase leading upward.");
		Map<Compass, Room> mapLadderTop = new HashMap<Compass, Room>();

		mapSmellyRoom.put(Compass.DOWN, gasRoom);
		smellyRoom.setAdjacentRooms(mapSmellyRoom);
		
		mapGasRoom.put(Compass.UP, smellyRoom);
		mapGasRoom.put(Compass.EAST, coalMine1);
		gasRoom.setAdjacentRooms(mapGasRoom);
		
		mapCoalMine1.put(Compass.NORTH, gasRoom);
		mapCoalMine1.put(Compass.EAST, coalMine1);
		mapCoalMine1.put(Compass.NORTHEAST, coalMine2);
		coalMine1.setAdjacentRooms(mapCoalMine1);
		
		mapCoalMine2.put(Compass.SOUTH, coalMine1);
		mapCoalMine2.put(Compass.NORTH, coalMine2);
		mapCoalMine2.put(Compass.SOUTHEAST, coalMine3);
		coalMine2.setAdjacentRooms(mapCoalMine2);
		
		mapCoalMine3.put(Compass.EAST, coalMine2);
		mapCoalMine3.put(Compass.SOUTH, coalMine3);
		mapCoalMine3.put(Compass.SOUTHWEST, coalMine4);
		coalMine3.setAdjacentRooms(mapCoalMine3);
		
		mapCoalMine4.put(Compass.NORTH, coalMine3);
		mapCoalMine4.put(Compass.WEST, coalMine4);
		mapCoalMine4.put(Compass.DOWN, ladderTop);
		coalMine4.setAdjacentRooms(mapCoalMine4);
		
		mapLadderTop.put(Compass.UP, coalMine4);

		Room ladderBottom = new Room("Ladder Bottom");
		ladderBottom.setDescription("This is a rather wide room. On one side is the bottom of a narrow wooden ladder. To the west {northeast} and the south are passages leaving the room.");
		Map<Compass, Room> mapLadderBottom = new HashMap<Compass, Room>();

		Room deadEnd = new Room("Dead End");
		deadEnd.setDescription("You have come to a dead end in the mine.");
		Map<Compass, Room> mapDeadEnd = new HashMap<Compass, Room>();

		Room timberRoom = new Room("Timber Room");
		timberRoom.setDescription("This is a long and narrow passage, which is cluttered with broken timbers. A wide passage comes from the east {north} and turns at the west {southwest} end {corner} of the room into a very narrow passageway.\n " +
				"From the west comes a strong draft.");
		Map<Compass, Room> mapTimberRoom = new HashMap<Compass, Room>();

		Room draftyRoom = new Room("Drafty Room");
		draftyRoom.setDescription("This is a small drafty {square} room in which is at the bottom of a long shaft. To the south {east} is a passageway and to the east {northeast} a very narrow passage. In the shaft can be seen a heavy iron chain.");
		Map<Compass, Room> mapDraftyRoom = new HashMap<Compass, Room>();

		Room machineRoom = new Room("Machine Room");
		machineRoom.setDescription("This is a large, cold room which seems to be air-conditioned whose sole exit is to the north. In one corner there is a machine (?) which is reminiscent of {is shaped somewhat like} a clothes dryer. On its face {‘panel’}\n " +
				"is a switch which is labeled in a dialect of Swahili. Fortunately, I know this dialect and the label translates to \"START\". The switch does not appear to be manipulable by any human hand (unless the fingers are about 1/16 by 1/4 inch). \n" +
				"On the front of the machine is a large lid, which is (closed)/(open).");
		Map<Compass, Room> mapMachineRoom = new HashMap<Compass, Room>();

		mapLadderTop.put(Compass.DOWN, ladderBottom);
		ladderTop.setAdjacentRooms(mapLadderTop);
		
		mapLadderBottom.put(Compass.UP, ladderTop);
		mapLadderBottom.put(Compass.SOUTH, deadEnd);
		mapLadderBottom.put(Compass.WEST, timberRoom);
		ladderBottom.setAdjacentRooms(mapLadderBottom);
		
		mapDeadEnd.put(Compass.NORTH, ladderBottom);
		deadEnd.setAdjacentRooms(mapDeadEnd);
		
		mapTimberRoom.put(Compass.EAST, ladderBottom);
		mapTimberRoom.put(Compass.WEST, draftyRoom);
		timberRoom.setAdjacentRooms(mapTimberRoom);
		
		mapDraftyRoom.put(Compass.EAST, timberRoom);
		mapDraftyRoom.put(Compass.SOUTH, machineRoom);
		draftyRoom.setAdjacentRooms(mapDraftyRoom);
		
		mapMachineRoom.put(Compass.NORTH, draftyRoom);
		machineRoom.setAdjacentRooms(mapMachineRoom);
		
		Room narrowPassage = new Room("Narrow Passage");
		narrowPassage.setDescription("This is a long and narrow corridor where a long north-south passageway briefly narrows even further.");
		Map<Compass, Room> mapNarrowPassage = new HashMap<Compass, Room>();

		Room mirrorRoomSouth = new Room("Mirror Room South");
		mirrorRoomSouth.setDescription("You are in a large square room with tall ceilings. On the south wall is an enormous mirror which fills the entire wall. There are exits on the other three sides of the room.\n" +
				"[Unfortunately, the mirror has been destroyed by your recklessness.]");
		Map<Compass, Room> mapMirrorRoomSouth = new HashMap<Compass, Room>();

		Room windingPassage = new Room("Winding Passage");
		windingPassage.setDescription("This is a winding passage. It seems that there are only exits on the east and north {there is only an exit on the east end although the whirring from the round room can be heard faintly to the north}");
		Map<Compass, Room> mapWindingPassage = new HashMap<Compass, Room>();

		Room cave2 = new Room("Tiny Cave");
		cave2.setDescription("This is a tiny cave with entrances west and north, and a dark, forbidding staircase leading down.");
		Map<Compass, Room> mapCave2 = new HashMap<Compass, Room>();

		Room entranceToHades = new Room("Entrance to Hades");
		entranceToHades.setDescription("You are outside a large gateway, on which is inscribed\n" +
				"\n" +
				"  Abandon every hope all ye who enter here!\n" +
				"\n" +
				"The gate is open; through it you can see a desolation, with a pile of mangled bodies {corpses} in one corner. Thousands of voices, lamenting some hideous fate, can be heard.");
		Map<Compass, Room> mapEntranceToHades = new HashMap<Compass, Room>();

		
		Room landOfTheLivingDead = new Room("Land of The Living Dead");
		landOfTheLivingDead.setDescription("You have entered the Land of the Living Dead, a large desolate room. Although it is apparently uninhabited, thousands of lost souls can be heard weeping and moaning. In the east corner are stacked the remains of dozens of previous adventurers who were less fortunate than yourself. To the east is an ornate passage, apparently recently constructed. A passage exits to the north {west}.");
		Map<Compass, Room> mapLandOfTheLivingDead = new HashMap<Compass, Room>();

		mapRoundRoom.put(Compass.SOUTH, narrowPassage);

		mapNarrowPassage.put(Compass.NORTH, roundRoom);
		mapNarrowPassage.put(Compass.SOUTH, mirrorRoomSouth);
		narrowPassage.setAdjacentRooms(mapNarrowPassage);
		
		mapMirrorRoomSouth.put(Compass.NORTH, narrowPassage);
		mapMirrorRoomSouth.put(Compass.EAST, cave2);
		mapMirrorRoomSouth.put(Compass.WEST, windingPassage);
		mirrorRoomSouth.setAdjacentRooms(mapMirrorRoomSouth);
		
		mapWindingPassage.put(Compass.NORTH, mirrorRoomSouth);
		mapWindingPassage.put(Compass.EAST, cave2);
		windingPassage.setAdjacentRooms(mapWindingPassage);
		
		mapCave2.put(Compass.NORTH, mirrorRoomSouth);
		mapCave2.put(Compass.DOWN, entranceToHades);
		mapCave2.put(Compass.WEST, windingPassage);
		cave2.setAdjacentRooms(mapCave2);
		
		mapEntranceToHades.put(Compass.UP, cave2);
		mapEntranceToHades.put(Compass.SOUTH, landOfTheLivingDead);
		entranceToHades.setAdjacentRooms(mapEntranceToHades);
		
		mapLandOfTheLivingDead.put(Compass.NORTH, entranceToHades);
		landOfTheLivingDead.setAdjacentRooms(mapLandOfTheLivingDead);
		
		Room engravingsCave = new Room("Engravings Cave");
		engravingsCave.setDescription("You have entered a low cave with passages leading northwest and east {leading north and southeast}.");
		Map<Compass, Room> mapEngravingsCave = new HashMap<Compass, Room>();

		Room domeRoom = new Room("Dome Room");
		domeRoom.setDescription("You are at the periphery of a large dome, which forms the ceiling of another room below. Protecting you from a precipitous drop is a wooden railing which circles the dome.\n" +
				"[Hanging down from the railing is a rope which ends about ten feet from the floor below.]");
		Map<Compass, Room> mapDomeRoom = new HashMap<Compass, Room>();

		Room torchRoom = new Room("Torch Room");
		torchRoom.setDescription("This is a large room with a prominent doorway leading to a down staircase. To the west is a narrow twisting tunnel, covered with a thin layer of dust. Above you is a large dome painted with scenes depicting elfin hacking rites. \n" +
				"Up around the edge of the dome (20 feet up) is a wooden railing. In the center of the room sits a white marble pedestal.\n" +
				"[A piece of rope descends from the railing above, ending some five feet above your head.]");
		Map<Compass, Room> mapTorchRoom = new HashMap<Compass, Room>();

		Room temple = new Room("West Temple");
		temple.setDescription("This is the north {west} end of a large temple. On the east {south} wall is an ancient inscription, probably a prayer in a long-forgotten language. Below the prayer is a staircase leading down. The west {north} wall is solid granite. \n" +
				"The exit to the north {The entrance at the west} end of the room is through huge marble pillars.");
		Map<Compass, Room> mapTemple = new HashMap<Compass, Room>();

		Room egyptianRoom = new Room("Egypt Room");
		egyptianRoom.setDescription("This is a room which looks like an Egyptian tomb. There is an ascending staircase in the room as well as doors to the west {east and south}.");
		Map<Compass, Room> mapEgyptianRoom = new HashMap<Compass, Room>();

		Room altar = new Room("East Temple");
		altar.setDescription("This is the south {east} end of a large temple. In front of you is what appears to be an altar. In one corner is a small hole in the floor which leads into darkness. \n" +
				"You probably could not get back up it.");
		Map<Compass, Room> mapAltar = new HashMap<Compass, Room>();

		mapRoundRoom.put(Compass.SOUTHEAST, engravingsCave);

		mapEngravingsCave.put(Compass.NORTHWEST, roundRoom);
		mapEngravingsCave.put(Compass.EAST, domeRoom);
		engravingsCave.setAdjacentRooms(mapEngravingsCave);
		
		mapDomeRoom.put(Compass.WEST, engravingsCave);
		mapDomeRoom.put(Compass.DOWN, torchRoom);
		domeRoom.setAdjacentRooms(mapDomeRoom);
		
		mapTorchRoom.put(Compass.SOUTH, temple);
		torchRoom.setAdjacentRooms(mapTorchRoom);
		
		mapTemple.put(Compass.NORTH, torchRoom);
		mapTemple.put(Compass.SOUTH, altar);
		mapTemple.put(Compass.EAST, egyptianRoom);
		temple.setAdjacentRooms(mapTemple);
		
		mapAltar.put(Compass.NORTH, temple);
		mapAltar.put(Compass.DOWN, cave2);
		mapAltar.put(Compass.UP, forest1);
		altar.setAdjacentRooms(mapAltar);
		
		mapEgyptianRoom.put(Compass.WEST, temple);
		egyptianRoom.setAdjacentRooms(mapEgyptianRoom);
		
		Room deepCanyon = new Room("Deep Canyon");
		deepCanyon.setDescription("Deep Canyon\n" +
				"You are on the south edge of a deep canyon. Passages lead off to the east, northwest and southwest {east, south, and northwest}. A stairway leads down. \n" +
				"(You can hear the sound of flowing water from below.)/(You can hear a loud roaring sound, like that of rushing water, from below.)\n");
		Map<Compass, Room> mapDeepCanyon = new HashMap<Compass, Room>();
		
		Room dam = new Room("Dam");
		dam.setDescription("You are standing on the top of the Flood Control Dam #3, which was quite a tourist attraction in times far distant. There are paths to the north, south, and west {east}, and a scramble down.\n" +
				"(The sluice gates on the dam are closed. Behind the dam, there can be seen a wide reservoir {lake}. Water is pouring over the top of the now abandoned dam. {A small stream is formed by the runoff from the lake.})\n" +
				"(The sluice gates are closed. The water level in the reservoir is quite low, but the level is rising quickly.)\n" +
				"(The sluice gates are open, and water rushes through the dam. The water level behind the dam is still high.)\n" +
				"(It appears that the dam has been opened since the water level behind the dam is low: The sluice gates have been opened. Water rushes through the dam and downstream. {Water is rushing downstream through the gates.})\n" +
				"CONTROL PANEL (There is a control panel here, on which a large metal bolt is mounted. Directly above the bolt is a small green plastic bubble [which is glowing serenely].)");
		Map<Compass, Room> mapDam = new HashMap<Compass, Room>();

		Room damLobby = new Room("Dam Lobby");
		damLobby.setDescription("This room appears to have been the waiting room for groups touring the dam. There are open doorways here to the north and east marked \"Private\", though the doors are open, and there is a path leading south over the top of the dam.");
		Map<Compass, Room> mapDamLobby = new HashMap<Compass, Room>();

		Room maintenanceRoom = new Room("Maintenance Room");
		maintenanceRoom.setDescription("This is what appears to have been the maintenance room for Flood Control Dam #3, judging by the assortment of tools chests around the room. Apparently, this room has been ransacked recently, for most of the valuable equipment is gone. \n" +
				"On the wall in front of you is a group {panel} of buttons which are labeled in EBCDIC. However, they are of different colors:  colored blue, yellow, brown, and red. There are doorways to the west and south.");
		Map<Compass, Room> mapMaintenanceRoom = new HashMap<Compass, Room>();
		
		//Frigid River 1-5, shore, sandyBeach, sandyCave
		Room frigidRiver1 = new Room("Frigid River 1");
		frigidRiver1.setDescription("You are on the Frigid River in the vicinity of the Dam. The river flows quietly here. There is a landing on the west shore.");
		Map<Compass, Room> mapFrigidRiver1 = new HashMap<Compass, Room>();
		
		Room frigidRiver2 = new Room("Frigid River 2");
		frigidRiver2.setDescription("The river turns a corner here making it impossible to see the Dam. The White Cliffs loom on the east bank and large rocks prevent landing on the west.");
		Map<Compass, Room> mapFrigidRiver2 = new HashMap<Compass, Room>();
		
		Room frigidRiver3 = new Room("Frigid River 3");
		frigidRiver3.setDescription("The river descends here into a valley. There is a narrow beach on the west shore below the cliffs and there is some shore on the west which may be suitable. In the distance a faint rumbling can be heard.");
		Map<Compass, Room> mapFrigidRiver3 = new HashMap<Compass, Room>();
		
		Room frigidRiver4 = new Room("Frigid River 4");
		frigidRiver4.setDescription("The river is running faster here and the sound ahead appears to be that of rushing water. On the east shore is a sandy beach. A small area of beach can also be seen below the cliffs on the west shore.");
		Map<Compass, Room> mapFrigidRiver4 = new HashMap<Compass, Room>();
		
		Room frigidRiver5 = new Room("Frigid River 5");
		frigidRiver5.setDescription("The sound of rushing water is nearly unbearable here. On the east shore is a large landing area.");
		Map<Compass, Room> mapFrigidRiver5 = new HashMap<Compass, Room>();
		
		Room overTheFalls = new Room("Over The Falls");
		overTheFalls.setDescription("Fighting the fierce currents of the Frigid River, you try to hold your own for a bit, but then you are carried over a waterfall and into some nasty rocks.\nAnd now you are dead.\nGAME OVER");
		
		Room sandyBeach = new Room("Sandy Beach");
		sandyBeach.setDescription("You are on a large sandy beach on the east shore of the river, which is flowing quickly by. A path runs beside the river to the south here, and a passage is partially buried in sand to the northeast.");
		Map<Compass, Room> mapSandyBeach = new HashMap<Compass, Room>();
		
		Room sandyCave = new Room("Sandy Cave");
		sandyCave.setDescription("This is a sand-filled cave whose exit is to the southwest. It seems like there is somethihng hidden beneath the sand, should I dig?");
		Map<Compass, Room> mapSandyCave = new HashMap<Compass, Room>();
		
		Room shore = new Room("Shore");
		shore.setDescription("You are on the east shore of the river. The water {river} here seems somewhat treacherous. A path travels from north to south here, the south end quickly turning around a sharp corner.");
		Map<Compass, Room> mapShore = new HashMap<Compass, Room>();
		
		mapSandyCave.put(Compass.SOUTHWEST, sandyBeach);
		sandyCave.setAdjacentRooms(mapSandyCave);
		
		mapSandyBeach.put(Compass.NORTHEAST, sandyCave);
		mapSandyBeach.put(Compass.SOUTH, shore);
		mapSandyBeach.put(Compass.WEST, frigidRiver4);
		sandyBeach.setAdjacentRooms(mapSandyBeach);
		
		mapShore.put(Compass.NORTH, sandyBeach);
		mapShore.put(Compass.SOUTH, aragainFalls);
		mapShore.put(Compass.WEST, frigidRiver5);
		shore.setAdjacentRooms(mapShore);
		
		mapAragainFalls.put(Compass.NORTH, shore);
		aragainFalls.setAdjacentRooms(mapAragainFalls);
		
		
		Room damBase = new Room("Dam Base");
		damBase.setDescription("You are at the base of Flood Control Dam #3, which looms above you and to the north. The river Frigid is flowing by here. Along the river are the White Cliffs which seem to form giant walls stretching from north to south along the east shores of the river as it winds its way downstream.");
		Map<Compass, Room> mapDamBase = new HashMap<Compass, Room>();
		
		mapDamBase.put(Compass.UP, dam);
		mapDamBase.put(Compass.NORTH, dam);
		mapDamBase.put(Compass.EAST, frigidRiver1);
		damBase.setAdjacentRooms(mapDamBase);
		
		mapFrigidRiver1.put(Compass.WEST, damBase);
		mapFrigidRiver1.put(Compass.DOWN, frigidRiver2);
		frigidRiver1.setAdjacentRooms(mapFrigidRiver1);
		
		mapFrigidRiver2.put(Compass.DOWN, frigidRiver3);
		frigidRiver2.setAdjacentRooms(mapFrigidRiver2);
		
		
		mapReservoirSouth.put(Compass.SOUTHEAST, deepCanyon);
		mapReservoirSouth.put(Compass.EAST, dam);
		reservoirSouth.setAdjacentRooms(mapReservoirSouth);
		
		mapDeepCanyon.put(Compass.NORTHWEST, reservoirSouth);
		mapDeepCanyon.put(Compass.SOUTHWEST, northSouthPassage);
		mapDeepCanyon.put(Compass.EAST, dam);
		
		mapNorthSouthPassage.put(Compass.NORTHEAST, deepCanyon);
		northSouthPassage.setAdjacentRooms(mapNorthSouthPassage);
		
		mapDam.put(Compass.NORTH, damLobby);
		mapDam.put(Compass.SOUTH, deepCanyon);
		mapDam.put(Compass.DOWN, damBase);
		mapDam.put(Compass.EAST, damBase);
		dam.setAdjacentRooms(mapDam);
		
		mapDamLobby.put(Compass.SOUTH, dam);
		mapDamLobby.put(Compass.EAST, maintenanceRoom);
		mapDamLobby.put(Compass.NORTH, maintenanceRoom);
		damLobby.setAdjacentRooms(mapDamLobby);
		
		mapMaintenanceRoom.put(Compass.SOUTH, damLobby);
		mapMaintenanceRoom.put(Compass.WEST, damLobby);
		maintenanceRoom.setAdjacentRooms(mapMaintenanceRoom);
		
		Room loudRoom = new Room("Echo Room");
		loudRoom.setDescription("This is a large room with a ceiling which cannot be detected from the ground. There is a narrow passage from east to west and a stone stairway leading upward. (The room is deafeningly loud with an undetermined rushing sound. The sound seems to reverberate from all of the walls, making it difficult even to think. \n" +
				"{The room is extremely noisy. In fact, it is difficult to hear yourself think.})/(The room is eerie in its quietness.)/(It is unbearably loud here, with an ear-splitting roar seeming to come from all around you. There is a pounding in your head which won't stop. With a tremendous effort, you scramble out of the room.)");
		Map<Compass, Room> mapLoudRoom = new HashMap<Compass, Room>();

		Room dampCave = new Room("Damp Cave");
		dampCave.setDescription("This cave has exits to the west and east, and narrows to a crack toward the south. {This is a cave. Passages exit to the south and to the east, but the cave narrows to a crack to the west.} The earth is particularly damp here.");
		Map<Compass, Room> mapDampCave = new HashMap<Compass, Room>();

		//dark room
		Room whiteCliffsBeachNorth = new Room("North White Cliffs Beach");
		whiteCliffsBeachNorth.setDescription("You are on a narrow strip of beach which runs along the base of the White\n" +
				" Cliffs. There is a narrow path heading south along the Cliffs and a tight passage leading west into the cliffs themselves. {The only path here is a narrow one, heading south along the Cliffs.}");
		Map<Compass, Room> mapWhiteCliffsBeachNorth = new HashMap<Compass, Room>();

		//dark room
		Room whiteCliffsBeachSouth = new Room("South White Cliffs Beach");
		whiteCliffsBeachSouth.setDescription("You are on a rocky, narrow strip of beach beside the Cliffs. A narrow path leads north along the shore.");
		Map<Compass, Room> mapWhiteCliffsBeachSouth = new HashMap<Compass, Room>();
		
		mapFrigidRiver3.put(Compass.DOWN, frigidRiver4);
		mapFrigidRiver3.put(Compass.WEST, whiteCliffsBeachNorth);
		frigidRiver3.setAdjacentRooms(mapFrigidRiver3);
		
		mapFrigidRiver4.put(Compass.DOWN, frigidRiver5);
		mapFrigidRiver4.put(Compass.WEST, whiteCliffsBeachSouth);
		mapFrigidRiver4.put(Compass.EAST, sandyBeach);
		frigidRiver4.setAdjacentRooms(mapFrigidRiver4);
		
		mapFrigidRiver5.put(Compass.EAST, shore);
		mapFrigidRiver5.put(Compass.DOWN, overTheFalls);
		frigidRiver5.setAdjacentRooms(mapFrigidRiver5);
		
		
		mapDeepCanyon.put(Compass.DOWN, loudRoom);
		deepCanyon.setAdjacentRooms(mapDeepCanyon);
		
		mapRoundRoom.put(Compass.EAST, loudRoom);
		roundRoom.setAdjacentRooms(mapRoundRoom);
		
		mapLoudRoom.put(Compass.WEST, roundRoom);
		mapLoudRoom.put(Compass.UP, deepCanyon);
		mapLoudRoom.put(Compass.EAST, dampCave);
		loudRoom.setAdjacentRooms(mapLoudRoom);
		
		mapDampCave.put(Compass.WEST, loudRoom);
		mapDampCave.put(Compass.EAST, whiteCliffsBeachNorth);
		dampCave.setAdjacentRooms(mapDampCave);
		
		mapWhiteCliffsBeachNorth.put(Compass.WEST, dampCave);
		mapWhiteCliffsBeachNorth.put(Compass.SOUTH, whiteCliffsBeachSouth);
		mapWhiteCliffsBeachNorth.put(Compass.EAST, frigidRiver3);
		whiteCliffsBeachNorth.setAdjacentRooms(mapWhiteCliffsBeachNorth);
		
		mapWhiteCliffsBeachSouth.put(Compass.NORTH, whiteCliffsBeachNorth);
		mapWhiteCliffsBeachSouth.put(Compass.EAST, frigidRiver4);
		whiteCliffsBeachSouth.setAdjacentRooms(mapWhiteCliffsBeachSouth);
		
		Room maze1 = new Room("Maze1");
		maze1.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze1 = new HashMap<Compass, Room>();

		Room maze2 = new Room("Maze2");
		maze2.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze2 = new HashMap<Compass, Room>();

		Room maze3 = new Room("Maze3");
		maze3.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze3 = new HashMap<Compass, Room>();

		Room maze4 = new Room("Maze4");
		maze4.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze4 = new HashMap<Compass, Room>();

		Room maze5 = new Room("Maze5");
		maze5.setDescription("This is part of a maze of twisty little passages, all alike. A skeleton, probably the remains of an unlucky adventurer, lies here.");
		Map<Compass, Room> mapMaze5 = new HashMap<Compass, Room>();

		Room maze6 = new Room("Maze6");
		maze6.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze6 = new HashMap<Compass, Room>();

		Room maze7 = new Room("Maze7");
		maze7.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze7 = new HashMap<Compass, Room>();

		Room maze8 = new Room("Maze8");
		maze8.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze8 = new HashMap<Compass, Room>();

		Room maze9 = new Room("Maze9");
		maze9.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze9 = new HashMap<Compass, Room>();

		Room maze10 = new Room("Maze10");
		maze10.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze10 = new HashMap<Compass, Room>();

		Room maze11 = new Room("Maze11");
		maze11.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze11 = new HashMap<Compass, Room>();

		Room maze12 = new Room("Maze12");
		maze12.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze12 = new HashMap<Compass, Room>();

		Room maze13 = new Room("Maze13");
		maze13.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze13 = new HashMap<Compass, Room>();

		Room maze14 = new Room("Maze14");
		maze14.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze14 = new HashMap<Compass, Room>();

		Room maze15 = new Room("Maze15");
		maze15.setDescription("This is part of a maze of twisty little passages, all alike.");
		Map<Compass, Room> mapMaze15 = new HashMap<Compass, Room>();

		Room deadEnd1 = new Room("Dead End");
		deadEnd1.setDescription("You have come to a dead end in the maze");
		Map<Compass, Room> mapDeadEnd1 = new HashMap<Compass, Room>();

		Room deadEnd2 = new Room("Dead End");
		deadEnd2.setDescription("You have come to a dead end in the maze");
		Map<Compass, Room> mapDeadEnd2 = new HashMap<Compass, Room>();

		Room deadEnd3 = new Room("Dead End");
		deadEnd3.setDescription("You have come to a dead end in the maze");
		Map<Compass, Room> mapDeadEnd3 = new HashMap<Compass, Room>();

		Room deadEnd4 = new Room("Dead End");
		deadEnd4.setDescription("You have come to a dead end in the maze");
		Map<Compass, Room> mapDeadEnd4 = new HashMap<Compass, Room>();
		
		Room strangePassage = new Room("Strange Passage");
		strangePassage.setDescription("This is a long passage. To the west {south} is one entrance. On the east there is an old wooden door, with a large opening in it (about cyclops sized).");
		Map<Compass, Room> mapStrangePassage = new HashMap<Compass, Room>();
		
		Room cyclopsRoom = new Room("Cyclops' Room");
		cyclopsRoom.setDescription("This room has an exit on the northwest {west} side, and a staircase leading up. [The east {north} wall, previously solid, now has a cyclops-sized opening {hole} in it.]" + 
				"");
		Map<Compass, Room> mapCyclopsRoom = new HashMap<Compass, Room>();
		
		Room treasureRoom = new Room("Treasure Room");
		treasureRoom.setDescription("This is a large room, whose east wall is solid granite. A number of discarded bags, which crumble at your touch, are scattered about on the floor. There is an exit down a staircase and what appears to be a newly created passage to the east.");
		Map<Compass, Room> mapTreasureRoom = new HashMap<Compass, Room>();
		
		mapTreasureRoom.put(Compass.DOWN, cyclopsRoom);
		treasureRoom.setAdjacentRooms(mapTreasureRoom);
		
		mapCyclopsRoom.put(Compass.UP, treasureRoom);
		mapCyclopsRoom.put(Compass.NORTHWEST,maze15);
		mapCyclopsRoom.put(Compass.EAST, strangePassage);
		cyclopsRoom.setAdjacentRooms(mapCyclopsRoom);
		
		mapStrangePassage.put(Compass.WEST, cyclopsRoom);
		mapStrangePassage.put(Compass.EAST, cellar);
		strangePassage.setAdjacentRooms(mapStrangePassage);

		mapCellar.put(Compass.WEST, strangePassage);
		cellar.setAdjacentRooms(mapCellar);
		
		mapTrollRoom.put(Compass.WEST, maze1);
		trollRoom.setAdjacentRooms(mapTrollRoom);
		
		mapMaze1.put(Compass.SOUTH, maze2);
		mapMaze1.put(Compass.NORTH, maze1);
		mapMaze1.put(Compass.EAST, trollRoom);
		mapMaze1.put(Compass.WEST, maze4);
		maze1.setAdjacentRooms(mapMaze1);
		
		mapMaze2.put(Compass.SOUTH, maze1);
		mapMaze2.put(Compass.EAST, maze3);
		mapMaze2.put(Compass.DOWN, maze4);
		maze2.setAdjacentRooms(mapMaze2);
		
		mapMaze3.put(Compass.UP, maze5);
		mapMaze3.put(Compass.NORTH, maze4);
		mapMaze3.put(Compass.WEST, maze2);
		maze3.setAdjacentRooms(mapMaze3);
		
		mapMaze4.put(Compass.EAST, deadEnd1);
		mapMaze4.put(Compass.WEST, maze3);
		mapMaze4.put(Compass.NORTH, maze1);
		maze4.setAdjacentRooms(mapMaze4);
		
		mapDeadEnd1.put(Compass.SOUTH, maze4);
		deadEnd1.setAdjacentRooms(mapDeadEnd1);
		
		mapMaze5.put(Compass.DOWN, maze3);
		mapMaze5.put(Compass.UP, maze6);
		mapMaze5.put(Compass.EAST, deadEnd2);
		maze5.setAdjacentRooms(mapMaze5);
		
		mapDeadEnd2.put(Compass.WEST, maze5);
		deadEnd2.setAdjacentRooms(mapDeadEnd2);
		
		mapMaze6.put(Compass.WEST, maze6);
		mapMaze6.put(Compass.DOWN, maze5);
		mapMaze6.put(Compass.EAST, maze7);
		mapMaze6.put(Compass.UP, maze9);
		maze6.setAdjacentRooms(mapMaze6);
		
		mapMaze7.put(Compass.WEST, maze6);
		mapMaze7.put(Compass.DOWN, maze1);
		mapMaze7.put(Compass.UP, maze14);
		mapMaze7.put(Compass.SOUTH, maze15);
		mapMaze7.put(Compass.EAST, maze8);
		maze7.setAdjacentRooms(mapMaze7);
		
		mapMaze8.put(Compass.NORTHEAST, maze7);
		mapMaze8.put(Compass.WEST, maze8);
		mapMaze8.put(Compass.SOUTHEAST, deadEnd3);
		maze8.setAdjacentRooms(mapMaze8);
		
		mapDeadEnd3.put(Compass.NORTH, maze8);
		deadEnd3.setAdjacentRooms(mapDeadEnd3);
		
		mapMaze14.put(Compass.NORTHEAST, maze7);
		mapMaze14.put(Compass.SOUTH, maze7);
		mapMaze14.put(Compass.NORTHWEST, maze14);
		mapMaze14.put(Compass.WEST, maze15);
		maze14.setAdjacentRooms(mapMaze14);
		
		mapMaze15.put(Compass.WEST, maze14);
		mapMaze15.put(Compass.SOUTH, maze7);
		mapMaze15.put(Compass.SOUTHEAST, cyclopsRoom);
		maze15.setAdjacentRooms(mapMaze15);
		
		mapMaze9.put(Compass.NORTH, maze6);
		mapMaze9.put(Compass.DOWN, maze11);
		mapMaze9.put(Compass.EAST, maze10);
		mapMaze9.put(Compass.SOUTH, maze13);
		mapMaze9.put(Compass.NORTHWEST, maze9);
		mapMaze9.put(Compass.WEST, maze12);
		maze9.setAdjacentRooms(mapMaze9);
		
		mapMaze10.put(Compass.EAST, maze9);
		mapMaze10.put(Compass.WEST, maze13);
		mapMaze10.put(Compass.UP, maze11);
		maze10.setAdjacentRooms(mapMaze10);
		
		mapMaze13.put(Compass.EAST, maze9);
		mapMaze13.put(Compass.SOUTH, maze10);
		mapMaze13.put(Compass.WEST, maze11);
		mapMaze13.put(Compass.DOWN, maze12);
		maze13.setAdjacentRooms(mapMaze13);
		
		mapMaze11.put(Compass.NORTHWEST, maze13);
		mapMaze11.put(Compass.NORTHEAST, gratingRoom);
		mapMaze11.put(Compass.DOWN, maze10);
		mapMaze11.put(Compass.SOUTHWEST, maze12);
		maze11.setAdjacentRooms(mapMaze11);
		
		mapGratingRoom.put(Compass.SOUTHWEST, maze11);
		gratingRoom.setAdjacentRooms(mapGratingRoom);
		
		mapMaze12.put(Compass.SOUTHWEST, maze11);
		mapMaze12.put(Compass.UP, maze13);
		mapMaze12.put(Compass.NORTHEAST, maze9);
		mapMaze12.put(Compass.NORTH, deadEnd4);
		mapMaze12.put(Compass.DOWN, maze5);
		maze12.setAdjacentRooms(mapMaze12);
		
		mapDeadEnd4.put(Compass.SOUTH, maze12);
		deadEnd4.setAdjacentRooms(mapDeadEnd4);
		
		//ADD GAME ITEMS & NPCS & ROOM ACCESS CONDITIONS ETC HERE
		//Create Items and put contained items in containers
		Container smallMailbox = new Container("SMALL MAILBOX", false);
		smallMailbox.setDescription("There is a small mailbox here.\n");
		
		KeyItem smallLeaflet = new KeyItem("SMALL LEAFLET", true, true);
		smallLeaflet.setDescription("This is a small leaflet.\n");
		smallLeaflet.setReadContent("WELCOME TO ZORK!\nZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortals. Hardened adventurers have run screaming from the terror within!\n"
				+ "In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasure guarded by fearsome monsters & diabolical traps!\n");
		
		Container smallBirdsNest = new Container("SMALL BIRDS NEST", false);
		smallBirdsNest.setDescription("Beside you on the branch is a small bird's nest.\n");
		
		KeyItem jewelEncrustedEgg = new KeyItem("JEWEL ENCRUSTED EGG", true, false);
		jewelEncrustedEgg.setDescription(") In the bird's nest is a large egg encrusted with precious jewels, apparently scavenged somewhere by a childless songbird. The egg is covered with fine gold inlay"
		+", and ornamented in lapis lazuli and mother-of-pearl. Unlike most eggs, this one is hinged and is being held closed with a delicate looking clasp. The egg appears extremely fragile.\n");
		jewelEncrustedEgg.setBreakable();
		jewelEncrustedEgg.setBrokenDescription("There is a somewhat ruined egg here.\n");
		
		smallMailbox.addItem(smallLeaflet);
		smallBirdsNest.addItem(jewelEncrustedEgg);
		
		KeyItem clockworkCanary = new KeyItem("CLOCKWORK CANARY", true);
		clockworkCanary.setDescription("There is a golden clockwork canary nestled in the egg. It has ruby eyes and a silver beak. Through a crystal window below its left wing you can see intricate machinery inside. It appears to have wound down.\n");
		clockworkCanary.setBreakable();
		clockworkCanary.setBrokenDescription("There is a golden clockwork canary nestled in the egg. It seems to have recently had a bad experience. The mountings for its jewel-like eyes are empty, and its silver beak is crumpled. Through a cracked crystal "
				+ "window below its left wing you can see the remains of intricate machinery. It is not clear what result winding it would have, as the mainspring seems sprung.\nThere is a non-functional canary here\n");
		
		KeyItem pileOfLeaves = new KeyItem("PILE OF LEAVES", false, false);
		pileOfLeaves.setBreakable();
		pileOfLeaves.setDescription("On the ground is a pile of leaves.\n");
		pileOfLeaves.setLocDesc("On the ground is a pile of leaves.\n");
		
		Container brownSack = new Container("BROWN SACK", true);
		brownSack.setDescription("There is an elongated brown sack, smelling of hot peppers.\n");
		brownSack.setLocDesc("On the table is an elongated brown sack, smelling of hot peppers.\n");
		
		Food cloveOfGarlic = new Food("CLOVE OF GARLIC", 20, true);
		cloveOfGarlic.setDescription("This is a smelly bunch of garlic, I dont think I should eat it.\n");
		
		Food lunch = new Food("LUNCH", 25, true);
		lunch.setDescription("A hot pepper sandwich is here.");
		
		brownSack.addItem(lunch);
		brownSack.addItem(cloveOfGarlic);
		
		Container glassBottle = new Container("GLASS BOTTLE", true);
		glassBottle.setDescription("A bottle that can hold water. "+glassBottle.getItems().toString()+" is in the bottle.\n");
		glassBottle.setLocDesc("A bottle is sitting on the table.\n");
		
		Food quantityOfWater = new Food("QUANTITY OF WATER", 10, true);
		quantityOfWater.setDescription("There is some water here. I need to use a bottle to contain it.\n");
		
		glassBottle.addItem(quantityOfWater);
		
		KeyItem brassLantern = new KeyItem("BRASS LANTERN", true);
		brassLantern.setDescription("There is a battery-powered brass lantern here.\n");
		brassLantern.setBreakable();
		brassLantern.setBrokenDescription("There is a broken brass lantern here.\n");
		brassLantern.setLocDesc("A battery powered brass lantern is on the trophy case.\n");
		
		Weapon sword = new Weapon("SWORD", 40, true);
		sword.setDescription("There is an elvish sword here.\n");
		sword.setLocDesc("Above the trophy case hangs an elvish sword of great antiquity.\n");
		
		KeyItem rope = new KeyItem("ROPE", true, false);
		rope.setLocDesc("A large coil of rope is lying in the corner.\n");
		rope.setDescription("There is a large coil of rope here.\n");
		
		Weapon nastyKnife = new Weapon("NASTY KNIFE", 20, true);
		nastyKnife.setLocDesc("On a table is a nasty looking knife.\n");
		nastyKnife.setDescription("This is a nasty looking knife.\n");
		
		KeyItem painting = new KeyItem("PAINTING", true, false);
		painting.setBreakable();
		painting.setLocDesc("Fortunately, there is still one chance for you to be a vandal, for on the far wall is a painting of unparalleled beauty.\n");
		painting.setDescription("A painting by a neglected genius is here.\n");
		painting.setBrokenDescription("There is a worthless piece of canvas here.\n");
		
		KeyItem zorkOwnerManual = new KeyItem("ZORK OWNERS MANUAL", true, true);
		zorkOwnerManual.setReadContent("Congratulations!\n" + 
				"You are the privileged owner of ZORK I: The Great Underground Empire, a " + 
				"self-contained and self-maintaining universe. If used and maintained in " + 
				"accordance with normal operating practices for small universes, ZORK will " + 
				"provide many months of trouble-free operation.\n");
		zorkOwnerManual.setLocDesc("Loosely attached to a wall is a small piece of paper.\n");
		zorkOwnerManual.setDescription("This is a piece of paper with words on it.\n");
		
		Weapon bloodyAxe = new Weapon("BLOODY AXE", 50, false);
		bloodyAxe.setLocDesc("The troll's axe seems white-hot. You can't hold on to it.\n");
		
		KeyItem burnedOutLantern = new KeyItem("BURNED OUT LANTERN", true, false);
		burnedOutLantern.setBroken();
		burnedOutLantern.setBrokenDescription("The deceased adventurer's useless lantern is here.\n");
		
		KeyItem skeletonKey = new KeyItem("SKELETON KEY", true, false);
		skeletonKey.setDescription("This is a key that can open any lock.\n");
		skeletonKey.setLocDesc("There is a skeleton key here.\n");
		
		KeyItem leatherBagOfCoins = new KeyItem("LEATHER BAG OF COINS", true, false);
		leatherBagOfCoins.setLocDesc("An old leather bag, bulging with coins, is here.\n");
		leatherBagOfCoins.setDescription("An old leather bag, filled with coins.\n");
		
		Weapon rustyKnife = new Weapon("RUSTY KNIFE", 15, true);
		rustyKnife.setDescription("This is a rusty knife.\n");
		rustyKnife.setLocDesc("Beside the skeleton is a rusty knife.\n");
		
		KeyItem chalice = new KeyItem("CHALICE", true, false);
		chalice.setDescription("This is an intricately engraved silver chalice.\n");
		chalice.setLocDesc("There is a silver chalice, intricately engraved, here.\n");
		chalice.setTreasure();
		
		Container thiefsSack = new Container("THIEFS SACK", false);
		
		
		
		
		//ADDING Items to Rooms and itemList
		//itemList.put(itemName, item);
		//room.addItem(item);
		
		//ADDING ROOMS TO ARRAYLIST
		//DONE
		currentRoom = westOfHouse;
		roomList.put(westOfHouse.getName(), westOfHouse);
		roomList.put(northOfHouse.getName(), northOfHouse);
		roomList.put(behindTheHouse.getName(), behindTheHouse);
		roomList.put(southOfHouse.getName(), southOfHouse);
		roomList.put(forestPath.getName(), forestPath);
		roomList.put(upATree.getName(), upATree);
		roomList.put(clearing1.getName(), clearing1);
		roomList.put(forest1.getName(), forest1);
		roomList.put(forest2.getName(), forest2);
		roomList.put(forest3.getName(), forest3);
		roomList.put(forest4.getName(), forest4);
		roomList.put(clearing2.getName(), clearing2);
		roomList.put(canyonView.getName(), canyonView);
		roomList.put(rockyLedge.getName(), rockyLedge);
		roomList.put(canyonBottom.getName(), canyonBottom);
		roomList.put(endOfRainbow.getName(), endOfRainbow);
		roomList.put(onTheRainbow.getName(), onTheRainbow);
		roomList.put(aragainFalls.getName(), aragainFalls);
		roomList.put(kitchen.getName(), kitchen);
		roomList.put(attic.getName(), attic);
		roomList.put(livingRoom.getName(), livingRoom);
		roomList.put(cellar.getName(), cellar);
		roomList.put(gratingRoom.getName(), gratingRoom);
		roomList.put(stoneBarrow.getName(), stoneBarrow);
		roomList.put(insideTheBarrow.getName(), insideTheBarrow);
		roomList.put(altar.getName(), altar);
		roomList.put(studio.getName(), studio);
		roomList.put(eastOfChasm.getName(), eastOfChasm);
		roomList.put(gallery.getName(), gallery);
		roomList.put(strangePassage.getName(), strangePassage);
		roomList.put(cyclopsRoom.getName(), cyclopsRoom);
		roomList.put(treasureRoom.getName(), treasureRoom);
		roomList.put(trollRoom.getName(), trollRoom);
		roomList.put(eastWestPassage.getName(), eastWestPassage);
		roomList.put(roundRoom.getName(), roundRoom);
		roomList.put(narrowPassage.getName(), narrowPassage);
		roomList.put(mirrorRoomSouth.getName(), mirrorRoomSouth);
		roomList.put(windingPassage.getName(), windingPassage);
		roomList.put(cave2.getName(), cave2);
		roomList.put(entranceToHades.getName(), entranceToHades);
		roomList.put(landOfTheLivingDead.getName(), landOfTheLivingDead);
		roomList.put(engravingsCave.getName(), engravingsCave);
		roomList.put(domeRoom.getName(), domeRoom);
		roomList.put(torchRoom.getName(), torchRoom);
		roomList.put(temple.getName(), temple);
		roomList.put(egyptianRoom.getName(), egyptianRoom);
		roomList.put(northSouthPassage.getName(), northSouthPassage);
		roomList.put(chasm.getName(), chasm);
		roomList.put(deepCanyon.getName(), deepCanyon);
		roomList.put(loudRoom.getName(), loudRoom);
		roomList.put(dampCave.getName(), dampCave);
		roomList.put(whiteCliffsBeachNorth.getName(), whiteCliffsBeachNorth);
		roomList.put(whiteCliffsBeachSouth.getName(), whiteCliffsBeachSouth);
		roomList.put(dam.getName(), dam);
		roomList.put(damLobby.getName(), damLobby);
		roomList.put(maintenanceRoom.getName(), maintenanceRoom);
		roomList.put(damBase.getName(), damBase);
		roomList.put(frigidRiver1.getName(), frigidRiver1);
		roomList.put(frigidRiver2.getName(), frigidRiver2);
		roomList.put(frigidRiver3.getName(), frigidRiver3);
		roomList.put(frigidRiver4.getName(), frigidRiver4);
		roomList.put(frigidRiver5.getName(), frigidRiver5);
		roomList.put(overTheFalls.getName(), overTheFalls);
		roomList.put(sandyBeach.getName(), sandyBeach);
		roomList.put(sandyCave.getName(), sandyCave);
		roomList.put(shore.getName(), shore);
		roomList.put(reservoirSouth.getName(), reservoirSouth);
		roomList.put(streamView.getName(), streamView);
		roomList.put(stream.getName(), stream);
		roomList.put(reservoir.getName(), reservoir);
		roomList.put(reservoirNorth.getName(), reservoirNorth);
		roomList.put(atlantisRoom.getName(), atlantisRoom);
		roomList.put(cave1.getName(), cave1);
		roomList.put(twistingPassage.getName(), twistingPassage);
		roomList.put(mirrorRoomNorth.getName(), mirrorRoomNorth);
		roomList.put(coldPassage.getName(), coldPassage);
		roomList.put(slideRoom.getName(), slideRoom);
		roomList.put(mineEntrance.getName(), mineEntrance);
		roomList.put(squeakyRoom.getName(), squeakyRoom);
		roomList.put(batRoom.getName(), batRoom);
		roomList.put(shaftRoom.getName(), shaftRoom);
		roomList.put(smellyRoom.getName(), smellyRoom);
		roomList.put(gasRoom.getName(), gasRoom);
		roomList.put(coalMine1.getName(), coalMine1);
		roomList.put(coalMine2.getName(), coalMine2);
		roomList.put(coalMine3.getName(), coalMine3);
		roomList.put(coalMine4.getName(), coalMine4);
		roomList.put(ladderTop.getName(), ladderTop);
		roomList.put(ladderBottom.getName(), ladderBottom);
		roomList.put(deadEnd.getName(), deadEnd);
		roomList.put(timberRoom.getName(), timberRoom);
		roomList.put(draftyRoom.getName(), draftyRoom);
		roomList.put(machineRoom.getName(), machineRoom);
		roomList.put(maze1.getName(), maze1);
		roomList.put(maze2.getName(), maze2);
		roomList.put(maze3.getName(), maze3);
		roomList.put(maze4.getName(), maze4);
		roomList.put(maze5.getName(), maze5);
		roomList.put(maze6.getName(), maze6);
		roomList.put(maze7.getName(), maze7);
		roomList.put(maze8.getName(), maze8);
		roomList.put(maze9.getName(), maze9);
		roomList.put(maze10.getName(), maze10);
		roomList.put(maze11.getName(), maze11);
		roomList.put(maze12.getName(), maze12);
		roomList.put(maze13.getName(), maze13);
		roomList.put(maze14.getName(), maze14);
		roomList.put(maze15.getName(), maze15);
		roomList.put(deadEnd1.getName(), deadEnd1);
		roomList.put(deadEnd2.getName(), deadEnd2);
		roomList.put(deadEnd3.getName(), deadEnd3);
		roomList.put(deadEnd4.getName(), deadEnd4);
		
	}
	
}