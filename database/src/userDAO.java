import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "allowPublicKeyRetrieval=true&useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String phone_number = resultSet.getString("phone_number");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            String creditcard_information = resultSet.getString("creditcard_information");
            

             
            user users = new user(email,firstName, lastName, password, phone_number, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, creditcard_information);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    public List<request> listAllRequests() throws SQLException {
        List<request> listRequest = new ArrayList<request>();        
        String sql = "SELECT * FROM Request";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String requestID = resultSet.getString("requestID");
            String note = resultSet.getString("note");
            String status = resultSet.getString("status");
            
             
            request Requests = new request(requestID,status,note);
            listRequest.add(Requests);
        }        
        resultSet.close();
        disconnect();        
        return listRequest;
    }
    
    public List<quote> listAllQuotes() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quote";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String quoteID = resultSet.getString("quoteID");
            String negotiation_note = resultSet.getString("negotiation_note");
            String status = resultSet.getString("status");
            String work_period = resultSet.getString("work_period");
            String price = resultSet.getString("price");
             
            quote Quotes = new quote(quoteID,status,negotiation_note,work_period,price);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, phone_number,adress_street_num, adress_street,adress_city,adress_state,adress_zip_code,creditcard_information) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getPhone_number());
			preparedStatement.setString(6, users.getAdress_street_num());		
			preparedStatement.setString(7, users.getAdress_street());		
			preparedStatement.setString(8, users.getAdress_city());		
			preparedStatement.setString(9, users.getAdress_state());		
			preparedStatement.setString(10, users.getAdress_zip_code());		
			preparedStatement.setString(11, users.getCreditcard_information());			

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void insertRequest(request requests) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","pass1234"); 
    	System.out.println("connected");
		String sql = "insert into Request(requestID,status,note) values (?, ?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setString(1, requests.getRequestID());
			preparedStatement.setString(2, requests.getStatus());
			preparedStatement.setString(3, requests.getNote());
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, lastName =?,password = ?,phone_number=?,adress_street_num =?, adress_street=?,adress_city=?,adress_state=?,adress_zip_code=?, creditcard_information =? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getPhone_number());
		preparedStatement.setString(6, users.getAdress_street_num());		
		preparedStatement.setString(7, users.getAdress_street());		
		preparedStatement.setString(8, users.getAdress_city());		
		preparedStatement.setString(9, users.getAdress_state());		
		preparedStatement.setString(10, users.getAdress_zip_code());		
		preparedStatement.setString(11, users.getCreditcard_information());		
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	 String email1 = resultSet.getString("email");
             String firstName = resultSet.getString("firstName");
             String lastName = resultSet.getString("lastName");
             String password = resultSet.getString("password");
             String phone_number = resultSet.getString("phone_number");
             String adress_street_num = resultSet.getString("adress_street_num"); 
             String adress_street = resultSet.getString("adress_street"); 
             String adress_city = resultSet.getString("adress_city"); 
             String adress_state = resultSet.getString("adress_state"); 
             String adress_zip_code = resultSet.getString("adress_zip_code"); 
             String creditcard_information = resultSet.getString("creditcard_information");
                           
             user users = new user(email1,firstName, lastName, password, phone_number, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, creditcard_information);
             }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	System.out.println("init started.");
    	connect_func();
        statement =  (Statement) connect.createStatement();
        System.out.println("start it.");
        String[] INITIAL = {"drop database if exists testdb; ",
					        "create database testdb; ",
					        "use testdb; ",
					        "drop table if exists User; ",
					        ("CREATE TABLE if not exists User( " +
					            "email VARCHAR(50) NOT NULL, " + 
					            "firstName VARCHAR(10) NOT NULL, " +
					            "lastName VARCHAR(10) NOT NULL, " +
					            "password VARCHAR(20) NOT NULL, " +
					            "phone_number VARCHAR(10) NOT NULL, " +
					            "adress_street_num VARCHAR(4) , "+ 
					            "adress_street VARCHAR(30) , "+ 
					            "adress_city VARCHAR(20)," + 
					            "adress_state VARCHAR(2),"+ 
					            "adress_zip_code VARCHAR(5),"+
					            "creditcard_information VARCHAR(16),"+ 
					            "PRIMARY KEY (email)); ")
					        	
        					};
        String[] INITIAL2 = {
        		"drop table if exists Request;",
		        ("CREATE TABLE if not exists Request( "+
		        	"requestID VARCHAR(10),"+
		        	"status VARCHAR(1),"+
		        	"note VARCHAR(100),"+
		        	"PRIMARY KEY(requestID));")

        };
        String[] INITIAL3 = {
        		"drop table if exists Quote;",
		        ("CREATE TABLE if not exists Quote( "+
		        	"quoteID VARCHAR(10),"+
		        	"status VARCHAR(1),"+
		        	"Negotiation_note VARCHAR(100),"+
		        	"work_period VARCHAR(2),"+
		        	"price VARCHAR(6),"+
		        	"PRIMARY KEY(quoteID));")
        };
        
        System.out.println("finish it.");
        String[] TUPLES = {("insert into User(email, firstName, lastName, password, phone_number, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, creditcard_information)"+
        			"values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '9438295729', '1234', 'whatever street', 'detroit', 'MI', '48202','8758274858294710'),\n"
        	
        			+ "('root', 'default', 'default','pass1234', '8954595318', '0000', 'Default', 'Default', '0', '00000','8758334858296523'),\n"
        			+ "('david@gmail.com', 'David', 'Smith','david1234', '8950095318', '0000', 'Contractor', 'Contractor', '0', '00000','0000000000000000'),\n"
        			+ "('roy@gmail.com','Roy','Harper','roy1234','1947663856','3342','Star','Gotham','NY','25843','1845107948375001'),\n"
        			+ "('dick@gmail.com','Dick','Grayson','dick1234','1029573829',4546,'red','Gotham','NY','38492','1039573829105839'),\n"
        			+ "('bat@gmail.com','Bruce','Wayne','bruce1234','1029384756',2954,'green','Central','NY','39455','4103943022594302'),\n"
        			+ "('barbara@gmail.com','Barbara','Gordan','barb1234','1029483945','3945','blue','Gotham','NY','10447','1039583960402943'),\n"
        			+ "('tim@gmail.com','Tim','Drake','tim1234','2034564345','4923','gre','Gotham','NY',48603,'3456783948272345'),\n"
        			+ "('damian@gmail.com','Damian','Wayne','Damian2534','1049283746','2932','Blood','Haven','NJ','29385','1057382945194037'),\n"
        			+ "('maria@gmail.com','Maria','Alsamaien','Maria1234','1112930457','4920','Street','Allen Park','MI','48277','1039675555556666');"
        		)
           			};
        String[] TUPLES2 = {
        		("insert into Request(requestID, status,note)"+
            			"values ('334DGWP','P','Nothing'),"+
        				"('4930634532','P','note'),"+
            			"('492054243','R','NA'),"+
        				"('435920853','A','good'),"+
            			"('df3424','A','nice'),"+
        				"('3954023452','A','reasonable'),"+
        				"('3948123413','P','need more'),"+
        				"('3928543213','R','No Way'),"+
        				"('392043255','A','valid');")
        		
        };
        String[] TUPLES3 = {
        		("insert into Quote(quoteID, status,negotiation_note,work_period,price)"+
            			"values ('4421FGWP','A','Nothing','20','2500'),"+
        				"('49204GQW3','A','satisfied','12','1340'),"+
            			"('492054HW','R','invalid','13','4400'),"+
        				"('39402043HQ','P','better deal','35','3752'),"+
            			"('AW492054E4','P','do better','3','23456'),"+
        				"('4825042','A','accepted','3','100'),"+
            			"('5449205425','A','like it','7','3456'),"+
        				"('4920543243','R','no','8','567'),"+
        				"('4920542431','A','yes','19','24354');"
        				)
        };
        
        System.out.println("33333333333.");
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        
        for (int i = 0; i < INITIAL2.length; i++)
        	statement.execute(INITIAL2[i]);
                
        System.out.println("444444444444.");
        for (int i = 0; i < INITIAL3.length; i++)
        	statement.execute(INITIAL3[i]);
        
        
        System.out.println("555555555555.");
        for (int i = 0; i < TUPLES.length; i++)
        	{statement.execute(TUPLES[i]);
        	}
        	
      
        	System.out.println("dsjfbsjfb");
        
        for (int j = 0; j<TUPLES2.length;j++) {
        	statement.execute(TUPLES2[j]);
        }
        
        for (int i = 0; i<TUPLES3.length;i++) {
        	statement.execute(TUPLES3[i]);
        }
        
        System.out.println("1111111111.");
        disconnect();
        System.out.println("2222222222.");
    }
    
    
   
    
    
    
    
    
	
	

}
