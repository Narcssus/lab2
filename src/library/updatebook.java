package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class updatebook extends ActionSupport {
	private String ISBN, AuthorID, Title, Publisher, PublishDate, Name,
			Country;
	private int Price, Age;
	public String bookupdated = "", Authoradded = "";

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
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "narc0912";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use bookDB");
			String sta = "update book set AuthorID=\"" + AuthorID
					+ "\",Title=\"" + Title + "\",Publisher=\"" + Publisher
					+ "\",PublishDate=\"" + PublishDate + "\",Price=\"" + Price
					+ "\" where ISBN=\"" + ISBN + "\"";
			ResultSet rs = statement.executeQuery("select * from Book");
			while (rs.next()) {
				String tmp = rs.getString("ISBN");
				if (tmp.equals(ISBN)) {

					bookupdated = "This book updated successful!";
				}
			}
			if (bookupdated.equals("")) {
				bookupdated = "This book does not exist!";
			} else {
				statement.execute(sta);
			}
			ResultSet rs2 = statement.executeQuery("select * from author");
			while (rs2.next()) {
				String tmp2 = rs2.getString("AuthorID");
				String[] authors = tmp2.split(";");
				String[] newauthors = AuthorID.split(";");
				String[] addauthors = new String[newauthors.length];
				int k = 0;
				for (int i = 0; i < authors.length; i++) {
					for (int j = 0; j < newauthors.length; j++) {
						if (authors[i].equals(newauthors[j])) {
							Authoradded = "no need add new author";
						} else {
							addauthors[k] = newauthors[j];
							k += 1;
						}
					}
				}
			}
			if (Authoradded.equals("")) {
				String sta2 = "insert into author set AuthorID=" + AuthorID
						+ ",Name=" + Name + ",Age=" + Age + ",Country="
						+ Country + ";";
				statement.execute(sta2);
				Authoradded = "A new author added";
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