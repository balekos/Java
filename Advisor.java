package BootCampProject;

public class Advisor extends SimpleUser {

//	public Advisor(Roles yourRole) {
//		super(yourRole);
//		// TODO Auto-generated constructor stub
//	}
	// private SimpleUser user; // Mporw na to kanw auto
	
	public Advisor(String username, String password, String name) {
		super(username, password, name);
		yourRole=Roles.ADVISOR;
	}
}
