package vote.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class data {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int index;

	@Column(name = "name")
	private String name;

	public data(int index, String name, String age, String gender, String address, String mobileNumber, String email,
			String id) {
		super();
		this.index = index;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.id = id;
	}

	public data() {
		super();
	}

	@Column(name = "age")
	private String age;

	@Column(name = "gender")
	private String gender;

	@Override
	public String toString() {
		return "data [index=" + index + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + ", mobileNumber=" + mobileNumber + ", email=" + email + ", id=" + id + "]";
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "address")
	private String address;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "id")
	private String id;

}
