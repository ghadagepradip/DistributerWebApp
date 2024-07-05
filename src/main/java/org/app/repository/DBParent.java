package org.app.repository;

import java.sql.*;


public class DBParent {

	public static String path;
	protected DBConfig db = DBConfig.getDBInstance(path);
	protected Connection conn = db.getConn();
	protected PreparedStatement stmt = db.getPstmt();
	protected ResultSet rs = db.getRs();
	

}
