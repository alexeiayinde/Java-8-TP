package bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String lastName;
	private String firstName;
	private Date inscriptionDate;

	public User() {
	}

	public User(String firstName, String lastName, String date) throws ParseException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.inscriptionDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User : ");
		builder.append(firstName);
		builder.append(" ");
		builder.append(lastName);
		builder.append("\nDate d'adhésion : ");
		builder.append(new SimpleDateFormat("dd/MM/yyyy").format(this.inscriptionDate));
		return builder.toString();
	}

}
