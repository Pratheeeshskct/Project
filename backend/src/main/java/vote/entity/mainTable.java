package vote.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "main_table")
public class mainTable {

	public mainTable() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public mainTable(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "mainTable [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
}
