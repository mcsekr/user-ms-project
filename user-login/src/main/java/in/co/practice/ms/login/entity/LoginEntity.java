package in.co.practice.ms.login.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_DETAILS")
public class LoginEntity implements Serializable {

	private static final long serialVersionUID = -4508920459228918594L;
	@Id
	@Column(name = "USER_EMAIL")
	private String email;
	@Column(name = "USER_FNAME")
	private String firstName;
	@Column(name = "USER_LNAME")
	private String lastName;
	@Column(name = "USER_PHONE")
	private Integer phoneNumber;
	@Column(name = "USER_PASSWORD")
	private String password;

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginEntity other = (LoginEntity) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

}
