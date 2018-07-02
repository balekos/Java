package BootCampProject;

import java.sql.SQLException;
import java.util.Scanner;

import DataBase.AdminDB;

public class AdminMenu extends AdvisorMenu {
	AdminDB db=new AdminDB();

	public AdminMenu(Admin user) {
		super(user);
	}
	Scanner sc3=new Scanner(System.in);
	public void adminMenuView(Admin user) {
		printOptions();

		while (!exitCondition) {
			int adminOptions=sc3.nextInt();
			switch (adminOptions){
			case 1: checkMsgs(user); System.out.println("\n Please choose another action (Press 11 to see your options)");
			break;
			case 2: System.out.println("Users List: \n"); usernameList(); System.out.println("\n Please choose another action (Press 11 to see your options)");
			break;
			case 3: usernameList(); System.out.println("---- Choose a recipient from the list above and type your message ----");
			try {
					sendMsg(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			case 4: browseProducts(); System.out.println("\n Please choose another action (Press 11 to see your options)");
			break;
			case 5: editMsgs(41,user); // Dummy
			break;
			case 6: messagesList(); System.out.println("\n Please choose another action (Press 11 to see your options)");
			break;
			case 7: deleteMsg(); // Empty
			break;
			case 8: try {
					updateUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			case 9: deleteUser(); // Empty
			break;
			case 10: registerUser();
			break;
			case 11: printOptions();
			break;
			case 12: exit();
			break;
			default: System.out.println("This option does not exist. Please try again");
			printOptions();	
			break;
			}
		}	sc3.close();
	}
	@Override
	public void printOptions(){
		System.out.println("Press 1 to check your messages \r"+
				"Press 2 to see the available usernames \r"+
				"Press 3 to send your message \r"+
				"Press 4 to browse investment proposals \r"+
				"Press 5 to edit messages. \r"+
				"Press 6 to see the messages list. \r"+
				"Press 7 to delete message. \r"+
				"Press 8 to update user information.\r"+
				"Press 9 to delete user.\r"+
				"Press 10 to register new user.\r"+
				"Press 11 to see your options.\r"+
				"Press 12 to Exit");
	}
	
	public void updateUser() throws SQLException {
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter the user's username that you want to edit");
		String editUserName=sc3.nextLine();
		System.out.println("Enter the user's properties: 'password':");
		String password=sc3.nextLine();
		System.out.println("name");
		String name=sc3.nextLine();
		System.out.println("'role'");
		String role=sc3.nextLine();
		boolean execute= db.updateUserDB(editUserName,name,password,role);
		if (execute=false) {
			System.out.println("User's info updated successfully");
		}else {
			System.out.println("Something went wrong please try again");
		}
	}
	
	public void deleteUser() {
		
	}
	
	public void registerUser() {
		db.registerUserDB();
	}

}
