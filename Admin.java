package BootCampProject;

public class Admin extends Advisor {

//	public Admin(Roles yourRole) {
//		super(yourRole);
//		// TODO Auto-generated constructor stub
//	}

	public Admin(String username, String password, String name) {
		super(username, password, name);
		yourRole=Roles.ADMIN;
	}
}
