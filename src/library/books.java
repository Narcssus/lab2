package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class books extends ActionSupport {
	//test
	private String authorname;
	public String AuthorID;
	public String[] Authorbooks = new String[100];
	public String[] ISBN = new String[100];
	public String[] Authors = new String[10];
	public int booknum;

	public String getName() {
		return authorname;
	}

	public void setName(String authorname) {
		this.authorname = authorname;
	}

	public String execute() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_1120310721lab2";
		String user = "2z514z50wo";
		String password = "lmiyzzixk5i23m21il1wkzw3w33105ljy53iw5h5";

		booknum = 0;
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use app_1120310721lab2");
			ResultSet rs = statement.executeQuery("select * from author");
			String name = null;

			while (rs.next()) {
				name = rs.getString("Name");
				if (name.equals(authorname)) {
					AuthorID = rs.getString("AuthorID");
				}
			}

			ResultSet rs2 = statement.executeQuery("select * from book");
			name = null;
			while (rs2.next()) {
				name = rs2.getString("AuthorID");
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				Authors = name.split(";");
				for (int i = 0; i < Authors.length; i++) {
					if (AuthorID.equals(Authors[i])) {
						Authorbooks[booknum] = rs2.getString("Title");
						ISBN[booknum] = rs2.getString("ISBN");
						booknum += 1;
					}
				}
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return SUCCESS;
	}

}
