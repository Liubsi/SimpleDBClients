package embedded;

import simpledb.jdbc.embedded.EmbeddedDriver;
import java.sql.*;

public class ConnectToDB3 {
	public static void main(String[] args) {
		Driver d = new EmbeddedDriver();
		String url = "jdbc:simpledb:studentdb";
		try (Connection conn = d.connect(url, null)) {
			// do nothing!
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
