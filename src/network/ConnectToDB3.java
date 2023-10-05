package network;

import simpledb.jdbc.network.NetworkDriver;
import java.sql.*;

public class ConnectToDB3 {
	public static void main(String[] args) {
		Driver d = new NetworkDriver();
		String url = "jdbc:simpledb:studentdb";
		try (Connection conn = d.connect(url, null)) {
			// do nothing!
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
