package in.co.practice.ms.registration.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	@Id
	@Column(name = "EMP_ID", nullable = false)
	private int id;
	@Column(name = "EMP_NAME", length = 100, nullable = false)
	private String name;
	@Column(name = "EMP_AGE", nullable = false)
	private int age;
	@Column(name = "EMP_QUAL", length = 200)
	private String qualification;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, String qualification) {
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
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", qualification=" + qualification + "]";
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
		Employee other = (Employee) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(qualification, other.qualification);
	}

}
