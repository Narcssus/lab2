package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class addbook extends ActionSupport {
	private String ISBN, AuthorID, Title, Publisher, PublishDate, Name,
			Country;
	private int Price, Age;
	public String bookadded = "";
	private int Authoradded = 1;

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setAuthorID(String AuthorID) {
		this.AuthorID = AuthorID;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}

	public void setPublishDate(String PublishDate) {
		this.PublishDate = PublishDate;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	public String execute() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_1120310721lab2";
		String user = "2z514z50wo";
		String password = "lmiyzzixk5i23m21il1wkzw3w33105ljy53iw5h5";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use app_1120310721lab2");
			String sta = "insert into book value (\"" + ISBN + "\",\""
					+ AuthorID + "\",\"" + Title + "\",\"" + Publisher
					+ "\",\"" + PublishDate + "\",\"" + Price + "\");";
			ResultSet rs = statement.executeQuery("select * from book");
			while (rs.next()) {
				String tmp = rs.getString("ISBN");
				if (tmp.equals(ISBN)) {
					bookadded = "This book already exists!";
				}
			}
			if (bookadded.equals("")) {
				statement.execute(sta);
				bookadded = "This book added successful!";
			}
			statement.executeQuery("use app_1120310721lab2");
			ResultSet rs2 = statement.executeQuery("select * from author");
			while (rs2.next()) {
				String tmp2 = rs2.getString("AuthorID");
				if (tmp2.equals(AuthorID)) {
					Authoradded = 0;
				}
			}
			if (Authoradded==1) {
				String sta2 = "insert into author set AuthorID='" + AuthorID
						+ "',Name='" + Name + "',Age=" + Age + ",Country='"
						+ Country + "';";
				statement.execute(sta2);
				Authoradded = 0;
			}

			conn.close();
			rs.close();
			rs2.close();

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