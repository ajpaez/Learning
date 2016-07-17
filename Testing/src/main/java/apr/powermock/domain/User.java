package apr.powermock.domain;

import java.util.Date;

/**
 * Class representing User entity.
 * 
 * @author Meraj
 *
 */
public class User {

	private String firstName;
	private String surname;
	private Date today;

	public User() {
		today = new Date();
	}

	public User(String firstName, String surname) {
		super();
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

}
