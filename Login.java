package BootCampProject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import BootCampProject.SimpleUser.Roles;
import DataBase.Database;
import DataBase.UserDB;
//import BootCampProject.AdvisorMenu.advisorMenuView;

public class Login {
//private String userName;
//private String password; // Na to kanw na elegxei ta Strings ktl
private int options;
private SimpleUser user1;
private Advisor user2;
Admin user3; //Maybe Private;
private boolean logginStatus;
private boolean validated;

Database base=new Database();
UserDB ur=new UserDB();

UserMenu menu=new UserMenu(user1);
AdvisorMenu menu1=new AdvisorMenu(user2);
AdminMenu menu2=new AdminMenu(user3);

Scanner scanner=new Scanner(System.in);

public void logginOptions() {
	myOptions();
	options=scanner.nextInt();
	switch (options) {
	case 1: try {
			login();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	break;
	case 2: register();
	break;
	default: System.out.println("Your options was incorrect"); myOptions(); logginOptions();
	}
	scanner.close();
}

public void myOptions() {
	System.out.println("Press 1 to loggin \n\r"+
	"Press 2 to register");
}

Scanner sc=new Scanner(System.in);
public void login() throws SQLException {
	boolean check1;
	System.out.println("[**--- Enter your User Name ---**] \n"
			+ "------------------------ \n");
	String username=sc.nextLine();
	check1 = base.validateUserDB(username);
	if (!check1) {
		System.out.println("This username does not exist. Please 'Register'");
		logginOptions();
	}
	System.out.println("[**--- Enter your Password ---**] "
			+ "\n ------------------------------- ");
	String password=sc.nextLine();
	logginStatus=validationDB(username,password);
	if (logginStatus) {
		ResultSet userDetails=base.fetchUserDetailsDB(username);//		int userId=2; //=fetchUserid();
		try {
			while (userDetails.next()) {
				String name=userDetails.getString(2);
				String userRole=userDetails.getString(4);		
				sendToMenu(username,userDetails.getString(2).trim(),password,userDetails.getString(4).trim());
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	sc.close();
	}
	

public boolean validationDB(String username,String password) throws SQLException {
		validated=base.logginValidationDB(username,password);
	return validated;
}

public void sendToMenu(String userName,String name,String password,String role) {
if (role.equals("USER")) { //IGNORE CASE
	user1=new SimpleUser(userName,name,password);
	this.menu.userMenuView(user1);
}else if(role.equals("ADVISOR")){
	user2=new Advisor(userName,name,password);
	this.menu1.advisorMenuView(user2);
}else {
	user3=new Admin(userName,password,name);
	this.menu2.adminMenuView(user3);
}
}


public void register() {
	Scanner sc4=new Scanner(System.in);
	System.out.println("Enter your username \n\r");
	// ELEGXOS IF USERNAME EXISTS
	String newUsername=sc4.nextLine(); //Check in registration if it is 2 long
	System.out.println("Enter your password (!!YOU SHOULD REMEMBER IT!!) \n\r");
	String newPassword=sc4.nextLine();
	System.out.println("Enter your full name \n\r");
	String fullname=sc4.next();
	try {
	boolean result=ur.registerDB(newUsername,newPassword,fullname);
	if (!result) {
		System.out.println("Your registration was successful! Please Login with your new data");
		login();
	}else {
		System.out.println("Your registration failed! Please try register again or seek the help of the Admin");
		logginOptions();
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
