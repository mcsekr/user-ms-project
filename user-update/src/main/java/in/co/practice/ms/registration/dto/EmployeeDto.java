package in.co.practice.ms.registration.dto;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private String qualification;

	public EmployeeDto() {

	}

	public EmployeeDto(int id, String name, int age, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", age=" + age + ", qualification=" + qualification + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, qualification);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDto other = (EmployeeDto) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(qualification, other.qualification);
	}

}
