package myPackage;
import java.util.Scanner;

//coach: name player and sport 

public class MainApplication {
	static Scanner sc = new Scanner(System.in);
	static Sports[] sportArray = new Sports[100];
	static Players[] playerArray = new Players[50];
	static Game[] gameArray = new Game[50];
	static Coach[] coachArray = new Coach[10];

	public static void main(String[] args) {
		MainApplication.showMenu();
	}

	public static void showMenu() {
		while (true) {
			System.out.println("================================================");
			System.out.println("Please make a choice:");
			System.out.println("1.Add Sports");
			System.out.println("2.Registration");
			// coach registration method : how any coach ?, which sport(validations)?, which
			// player?

			System.out.println("3.Create Schedule");
			System.out.println("4.Display Schedule");
			System.out.println("5.Display");

			int no = sc.nextInt();

			switch (no) {
			case 1:
				addSport();
				break;
			case 2:
				registration();
				break;
			case 3:
				createSchedule();
				break;
			case 4:
				//displaySchedule();
				System.out.println("1.Day Wise\r\n" +
				"	 2.Player Wise\r\n" + 
				"	 3.Game Wise\r\n" + 
				"	 4.Main Menu\r\n"  +
				"	 Select your choice");
				int ch=sc.nextInt();
				if(ch == 1) {
					dayWise();
					showMenu();
				}
				else if(ch == 2) {
					playerWise();
					showMenu();
				}
				else if(ch == 3) {
					gameWise();
					showMenu();
				}
				else if(ch == 4) {
					continue;
				}
			case 5:
				break;
			default:
				System.out.println("Invalid choice!!!!");
			}
		}
	}
	private static void dayWise() {
		System.out.println("Enter the day ");
		String gd=sc.next();
	    for(Game gd1 : gameArray) {
	    	if(gd1 == null) {
	    		break;
	    	}
	    	if(gd1.gameDay.equals(gd)) {
	    		System.out.println("Game Name : "+gd1.gameName+ " day : "+gd1.gameDay );	
	    	}
	    	for(Players p : playerArray) {
		    	if(p == null) {
		    		break;
		    	}
		    	if(gd1.gameName.equals(p.sport))
		    	System.out.println("Player's name : "+ p.playerName+" Game : "+p.sport);
		    }
	    }
	    
	}
	private static void playerWise() {
		System.out.println("Enter player name");
		String pn=sc.next();
	       for(Players p: playerArray) {
	    	   if(p == null) {
	    		   break;
	    	   }
	    	   System.out.println("Player's name : "+ p.playerName+" Game : "+p.sport);
	      	
	       for(Game gd1 : gameArray) {
		    	if(gd1 == null) {
		    		break;
		    	}
		    	//if(gameArray[i].gameDay.equals(gd)) {}
		    	System.out.println("Game Name : "+gd1.gameName+ " day : "+gd1.gameDay );
		    }
		}
	 }

	private static void gameWise() {
		System.out.println("Enter game name");
		String g=sc.next();
		for(Game gd1 : gameArray) {
	    	if(gd1 == null) {
	    		break;
	    	}
	    	//if(gameArray[i].gameDay.equals(gd)) {}
	    	System.out.println("Game Name : "+gd1.gameName+ " day : "+gd1.gameDay );
	    }
		for(Players p: playerArray) {
	    	   if(p == null) {
	    		   break;
	    	   }
	    	   System.out.println("Player's name : "+ p.playerName+" Game : "+p.sport);
	       }	
	}
	
	private static void addSport() {
		System.out.println("How many sports do you want to add?");
		int s = sc.nextInt();
		for (int i = 0; i < s; i++) {
			sportArray[i] = new Sports();
			System.out.println("Enter sport");
			sportArray[i].sportName = sc.next();
		}
	}

	private static void registration() {
		System.out.println("Available sports");
		displayAvailableSport();
		System.out.println("How many players do you want to enter?");
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) {
			System.out.println("Enter player name");
			String name = sc.next();
			System.out.println("Enter sport which you want to play");
			String sport = sc.next();

			playerArray[i] = new Players();
			playerArray[i].playerName = name;
			playerArray[i].sport = sport;

			for (Sports sn : sportArray) {
				if (sn == null) {
					break;
				}
			}

			if (sportArray[i].sportName.equals(sport)) {
				System.out.println(sport + " you registerd!!");
			} else {
				System.out.println("sport " + sport + " is not available");
			}

			/*
			 * System.out.println("coach for sport"); String c = sc.next();
			 * coachArray[i].coachName=c; if(coachArray[i].coachName.equals(c)) {
			 * System.out.println(c+" Coach assigned"); } else {
			 * System.out.println(c+" Coach not available"); }
			 */
		}
	}

	private static void createSchedule() {
		System.out.println("Available sports");
		displayAvailableSport();
		System.out.println("Available players");
		displayAvailablePlayers();
		System.out.println("How many games??");
		int gameNo = sc.nextInt();
		for (int i = 0; i < gameNo; i++) {
			System.out.println("On which day??");
			String day = sc.next();
			System.out.println("Enter game");
			String name = sc.next();

			gameArray[i] = new Game();
			gameArray[i].gameDay = day; // insertion
			gameArray[i].gameName = name;

			if (sportArray[i].sportName.equals(name)) {
				System.out.println(name + " is scheduled!!");
			} else {
				System.out.println(name + " is not available");
			}
		}
	}

	private static void displayAvailableSport() {
		for (Sports a : sportArray) {
			if (a == null) {
				break;
			}
			System.out.println(a.sportName);
		}
	}

	private static void displayAvailablePlayers() {
		for (Players p : playerArray) {
			if (p == null) {
				break;
			}
			System.out.println("Player Name : " + p.playerName + ", Sport :" + p.sport);
		}
	}
}
