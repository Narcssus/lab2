package library;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class deletebook extends ActionSupport{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String execute() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_1120310721lab2";
		String user = "2z514z50wo";
		String password = "lmiyzzixk5i23m21il1wkzw3w33105ljy53iw5h5";
		Connection conn = null;
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use app_1120310721lab2");
			statement.execute("delete from book where ISBN='"+name+"'");
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
