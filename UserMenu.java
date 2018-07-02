package BootCampProject;

import java.sql.SQLException;
import java.util.Scanner;
import DataBase.UserDB;

public class UserMenu {
	
	public int options;
	boolean exitCondition=false;
	SimpleUser user;
	UserDB db=new UserDB();
	
	public UserMenu(SimpleUser user) {
		this.user=user;
	}
	

	public void userMenuView(SimpleUser user) {
		printOptions();
		Scanner sc=new Scanner(System.in);
		options=sc.nextInt();
		while (!exitCondition) {
			switch (options){
			case 1: checkMsgs(user);
			break;
			case 2: usernameList();
			break;
			case 3: usernameList(); System.out.println("Send Message by username"); try {
					sendMsg(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			case 4: browseProducts();
			break;
			case 5: printOptions();
			break;
			case 6: exit();
			break;
			default: System.out.println("This option does not exist. Please try again");
			printOptions();	
			break;
			}
		}
		sc.close();
	}

	public UserMenu() {
	}
	public void checkMsgs(SimpleUser user) { // It should return a returnstatment AND SHOULD TRIGGER A TRIGGER !!!
		System.out.println(user.getName()+" you have the following messages: ");
		db.fetchUserMsgsDB(user);
	}
	
	public void printOptions() {
		System.out.println("Press 1 to check your messages /n/r"+
				"Press 2 to see the available usernames /n/r"+
				"Press 3 to send your message /n/r"+
				"Press 4 to browse investment proposals /n/r"+
				"Press 5 to see your options"+
				"Press 6 to Exit /n /r");
	}

	public void usernameList() { //Should return a resultTable
		db.fetchUserNamesDB();
	}


	public void exit() {
		exitCondition=true;

	}
	public void browseProducts() {
		db.browseProductsDB();
	}
	public void sendMsg(SimpleUser user) throws SQLException {
		//String sender=user.getUserName();
		System.out.println("Enter recipient's username: ");
		Scanner sc2=new Scanner(System.in);
		String recipient=sc2.nextLine();
		System.out.println("______________________"+
		" Enter your message: "+
				"_________________________");
		String msgBody=sc2.nextLine();
		boolean success;
			success = db.sentMsgDB(user, recipient, msgBody);
		if (!success) {
		System.out.println("Message sent successfully");
		}else {
		System.out.println("Failed to deliver! Please try again");
		sendMsg(user);
		}
		sc2.close();
	}
}
	
