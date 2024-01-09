package prac_mini_project_01Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	private Statement stmnt;
	private Connection con;

	@Override
	public boolean verifycredentials(String email, String password) {
		try {

			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void saveregistrations(String name, String city, String mobile, String email) {
		try {
			stmnt.executeUpdate("insert into registration values('" + name + "','" + city + "','" + mobile + "','" + email + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2", "root", "test");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet listAllreg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBYEmail(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='" + email + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatreg(String email, String mobile) {
		try {
			stmnt.executeUpdate("update registration set mobile='" + mobile + "' where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
