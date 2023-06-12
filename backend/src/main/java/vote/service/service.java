package vote.service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.stereotype.Service;

import vote.entity.data;
import vote.entity.mainTable;
import vote.repository.repository;

@Service
public class service {

	@Autowired
	private repository repo;

	public boolean signup(mainTable t) {
		if (repo.isAlreadyPresent(t.getName()) == 0) {
			repo.save(t);
			String tableName = t.getName() + "_table";

			try {
				String url = "jdbc:mysql://localhost:3306/vote";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, "root", "Paraak@7145:)");
				java.sql.Statement st = con.createStatement();
				st.execute("create table " + tableName
						+ " (name varchar(250),age varchar(250),gender varchar(250),address varchar(250),mobileNumber varchar(250),email varchar(250),id varchar(250));");

			} catch (Exception e) {
				System.out.println(e);
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean login(mainTable t) {
		List<mainTable> temp;
		temp = repo.allUsers();

		boolean flag = false;
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i));

			if (temp.get(i).getName().equals(t.getName()) && temp.get(i).getPassword().equals(t.getPassword())) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	public boolean addData(data t, String name) {
		System.out.println(name);
		try {
			String url = "jdbc:mysql://localhost:3306/vote";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "Paraak@7145:)");
			java.sql.Statement st = con.createStatement();
			String uri = "insert into vote." + name
					+ "_table (name,age,gender,address,mobileNumber,email,id) values(?,?,?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(uri);
			p.setString(1, t.getName());
			p.setString(2, t.getAge());
			p.setString(3, t.getGender());
			p.setString(4, t.getAddress());
			p.setString(5, t.getMobileNumber());
			p.setString(6, t.getEmail());
			p.setString(7, t.getId());
			p.executeUpdate();

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public List<data> get(String name) {
		List<data> temp = new ArrayList<>();
		try {
			String url = "jdbc:mysql://localhost:3306/vote";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "Paraak@7145:)");
			java.sql.Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from " + name + "_table");

			while (rs.next()) {
				data d = new data();
				d.setName(rs.getString(1));
				d.setAge(rs.getString(2));
				d.setGender(rs.getString(3));
				d.setAddress(rs.getString(4));
				d.setMobileNumber(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setId(rs.getString(7));
				temp.add(d);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return temp;
	}

	public boolean update(data t, String name) {
		try {
			String url = "jdbc:mysql://localhost:3306/vote";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "Paraak@7145:)");

			System.out.println(name);

			String sql = "update " + name
					+ "_table set name= ? ,age= ? ,gender= ? ,address= ? ,mobileNumber= ? ,email= ? where id= ? ";

			PreparedStatement p = con.prepareStatement(sql);

			p.setString(1, t.getName());
			p.setString(2, t.getAge());
			p.setString(3, t.getGender());
			p.setString(4, t.getAddress());
			p.setString(5, t.getMobileNumber());
			p.setString(6, t.getEmail());
			p.setString(7, t.getId());

			p.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean delete(String name, String id) {
		try {
			String url = "jdbc:mysql://localhost:3306/vote";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "Paraak@7145:)");

//			System.out.println(name);

			String sql = "delete from " + name + "_table where id= ?";

			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, id);

			p.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
