package bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User8 {

	private String lastName;
	private String firstName;
	private LocalDate inscriptionDate;

	public User8() {
	}

	public User8(String firstName, String lastName, String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.inscriptionDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

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

	public LocalDate getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(LocalDate inscriptionDate) {
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
		builder.append(this.inscriptionDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return builder.toString();
	}

}
