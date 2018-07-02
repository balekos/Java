package BootCampProject;

import java.sql.SQLException;
import java.util.Scanner;
import DataBase.AdvisorDB;

public class AdvisorMenu extends UserMenu {
	Advisor user2;
	public int options;
	AdvisorDB db=new AdvisorDB();

	public AdvisorMenu(Advisor user2) {
		super(user2);
	}

	public void advisorMenuView(SimpleUser user1) {
		printOptions();
		Scanner sc1=new Scanner(System.in);
		while (!exitCondition) {
			int AdvOptions=sc1.nextInt();
			switch (AdvOptions){
			case 1: checkMsgs(user1);
			break;
			case 2: usernameList();
			break;
			case 3: usernameList(); try {
					sendMsg(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			case 4: browseProducts();
			break;
			case 5: editMsgs(42,user1);
			break;
			case 6: messagesList();
			break;
			case 7: deleteMsg();
			case 8: printOptions();
			break;
			case 9: exit();
			break;
			default: System.out.println("This option does not exist. Please try again");
			printOptions();	
			break;
			}
		}	//cs1.close();
	}
	@Override
	public void printOptions(){
		System.out.println("Press 1 to check your messages \n\r"+
				"Press 2 to see the available usernames \n\r"+
				"Press 3 to send your message \n\r"+
				"Press 4 to browse investment proposals \n\r"+
				"Press 5 to edit messages. \n\r"+
				"Press 6 to see the messages list. \n \r"+
				"Press 7 to delete message.\n\r"+
				"Press 8 to see your options.\n\r"+
				"Press 9 to Exit");
	}
	protected void editMsgs(int msgID,SimpleUser user) {
		String editor=user.getName();
		int editorId=user.getUserId();
		//connectDb();
		
	}
	protected void messagesList() { // Returns all the messages as an Array
		db.fetchMessagesDB();
	}
	
	protected void deleteMsg() {
	}
}
