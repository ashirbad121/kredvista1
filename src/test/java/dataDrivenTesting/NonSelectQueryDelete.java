package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryDelete {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			// register database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// get conn of database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");

			// create statement
			Statement state = conn.createStatement();
			String query = "delete from students where lower(sname)='abc';";

			// excute update
			int result = state.executeUpdate(query);

			if (result >= 1) {
				System.out.println("deleted");
			} else {
				System.err.println("not deleted");
			}
		} catch (Exception e) {

		} finally {
			// close db
			conn.close();

		}

	}

}
