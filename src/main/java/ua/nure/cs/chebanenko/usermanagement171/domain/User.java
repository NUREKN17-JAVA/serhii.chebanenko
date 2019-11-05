package ua.nure.cs.chebanenko.usermanagement171.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = -499588932944423295L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFullName() {
		StringBuilder full_name_builder = new StringBuilder();
		full_name_builder.append(getLastName()).append(", ").append(getFirstName());
		String full_name = full_name_builder.toString();
		return full_name;
	}

	public int getAge() {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH)+1;
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(getDateOfBirth());
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		if (currentMonth >= birthMonth && currentDay >= birthDay) {
            return currentYear - birthYear;
		} else {
			return currentYear - birthYear - 1;
		}
	}
	
}