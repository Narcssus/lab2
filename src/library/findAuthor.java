package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class findAuthor extends ActionSupport {
	public String ISBN;
	public String AuthorID;
	public String[] Authors = new String[10];
	public String[] Names = new String[10];
	public String[] Ages = new String[10];
	public String[] Countrys = new String[10];
	public String Title,Publisher,PublishDate;
	public int Price;
	public String getName() {
		return ISBN;
	}
	public void setName(String ISBN) {
		this.ISBN = ISBN;
	}

	public String execute() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "narc0912";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use bookDB");
			ResultSet rs = statement.executeQuery("select * from Book");
			String name = null;
			while (rs.next()) {
				name = rs.getString("ISBN");
				if (name.equals(ISBN)) {
					AuthorID = rs.getString("AuthorID");
					Title=rs.getString("Title");
					Publisher=rs.getString("Publisher");
					PublishDate=rs.getString("PublishDate");
					Price=rs.getInt("Price");
				}
			}
			ResultSet rs2 = statement.executeQuery("select * from Author");
			Authors = AuthorID.split(";");
			String tmp = null;
			while (rs2.next()) {
				tmp = rs2.getString("AuthorID");
				for(int i=0;i<Authors.length;i++){
					if (tmp.equals(Authors[i])) {
						Names[i] = rs2.getString("Name");
						Ages[i] = rs2.getString("Age");
						Countrys[i] = rs2.getString("Country");
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
