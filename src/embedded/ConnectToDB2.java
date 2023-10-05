package embedded;

import simpledb.jdbc.embedded.EmbeddedDriver;
import java.sql.*;

public class ConnectToDB2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Driver d = new EmbeddedDriver();
			String url = "jdbc:simpledb:studentdb";
			conn = d.connect(url, null);
			conn.close();
		} catch (SQLException e) {
			try {
				conn.close();
				e.printStackTrace();
			}
			catch (SQLException e2) {
			}
		}
	}
}
