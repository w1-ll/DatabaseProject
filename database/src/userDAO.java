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
            String email = resultSet.getString("email");
            String note = resultSet.getString("note");
            String status = resultSet.getString("status");
            
             
            request Requests = new request(requestID,status,note,email);
            listRequest.add(Requests);
        }        
        resultSet.close();
        disconnect();        
        return listRequest;
    }
    
    
    public List<request> listAllRequestsForContractor() throws SQLException {
        List<request> listRequest = new ArrayList<request>();        
        String sql = "SELECT * FROM Request WHERE status != 'S' ";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String requestID = resultSet.getString("requestID");
            String email = resultSet.getString("email");
            String note = resultSet.getString("note");
            String status = resultSet.getString("status");
            
             
            request Requests = new request(requestID,status,note,email);
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
        	String user_note =  resultSet.getString("user_note");
        	String email = resultSet.getString("email");
            String quoteID = resultSet.getString("quoteID");
            String negotiation_note = resultSet.getString("negotiation_note");
            String contractor_status = resultSet.getString("contractor_status");
            String user_status = resultSet.getString("user_status");
            String work_period = resultSet.getString("work_period");
            String price = resultSet.getString("price");
             
            quote Quotes = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<tree> listAllTrees() throws SQLException {
    	 List<tree> listTree = new ArrayList<tree>();        
         String sql = "SELECT * FROM tree";      
         connect_func();      
         statement = (Statement) connect.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
          
         while (resultSet.next()) {
         	String tree_distance =  resultSet.getString("tree_distance");
         	String trunk_size = resultSet.getString("trunk_size");
             String tree_height = resultSet.getString("tree_height");
             String tree_location = resultSet.getString("tree_location");
             //System.out.println(tree_distance+"\n"+trunk_size+"\n"+tree_height+"\n"+tree_location);
              
             tree Tree = new tree(tree_distance,trunk_size,tree_height,tree_location);
             listTree.add(Tree);
         }        
         resultSet.close();
         disconnect();        
         return listTree;
    }
    
    public List<bill> listAllBills() throws SQLException{
    	List<bill> listBill = new ArrayList<bill>();        
        String sql = "SELECT * FROM bill";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String billID = resultSet.getString("billID");
        	String status = resultSet.getString("status");
        	String negotiation_note = resultSet.getString("negotiation_note");
        	String final_price = resultSet.getString("final_price");
            System.out.println(billID+" "+status+" "+negotiation_note+" "+final_price);
             
            bill Bill = new bill(billID,status,negotiation_note,final_price);
            System.out.println(Bill.getBillID()+" "+Bill.getStatus()+" "+ Bill.getNegotiation_note()+" "+ Bill.getFinal_price());
            listBill.add(Bill);
        }        
        resultSet.close();
        disconnect();        
        return listBill;
    		
    	
    }
    
    
    public List<request> listSpecificRequests(String email) throws SQLException {
        List<request> listRequest = new ArrayList<request>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM Request WHERE email=\"%s\";",email);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String requestID = resultSet.getString("requestID");
            String status = resultSet.getString("status");
            
             
            request Requests = new request(requestID,status);
            listRequest.add(Requests);
        }        
        resultSet.close();
        disconnect();        
        return listRequest;
    }
    
    public List<quote> listSpecificQuote(String email) throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM Quote WHERE email=\"%s\";",email);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String quoteID = resultSet.getString("quoteID");
            String negotiation_note = resultSet.getString("negotiation_note");
            String contractor_status = resultSet.getString("contractor_status");
            String user_status = resultSet.getString("user_status");
            String work_period = resultSet.getString("work_period");
            String price = resultSet.getString("price");
            quote Quotes = new quote(quoteID, contractor_status, user_status, negotiation_note,work_period, price,email);
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
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
		String sql = "insert into Request(email, requestID,status,note) values (?, ?, ?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, requests.getEmail());
	        preparedStatement.setString(2, requests.getRequestID());
			preparedStatement.setString(3, requests.getStatus());
			preparedStatement.setString(4, requests.getNote());
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    public void insertQuote(quote quotes) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	System.out.println(quotes.getQuoteID());
		String sql = "insert into quote(email,quoteID, contractor_status, user_status ,negotiation_note,work_period,price) values (?, ?, ?, ?, ?,?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, quotes.getEmail());
		 preparedStatement.setString(2, quotes.getQuoteID());
	        preparedStatement.setString(3, quotes.getContractor_status());
	        preparedStatement.setString(4, quotes.getUser_status());
			preparedStatement.setString(5, quotes.getNegotiation_note());
			preparedStatement.setString(6, quotes.getWork_period());
			preparedStatement.setString(7, quotes.getPrice());
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
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
    
    
    public boolean modifyUserQuote(String quoteID, String user_note, String status) throws SQLException {
        String updateSql = "UPDATE quote SET user_note = ?, user_status = ? WHERE quoteID = ?";
        String selectSql = "SELECT user_note, user_status FROM quote WHERE quoteID = ?";
        connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(updateSql);
             PreparedStatement selectStatement = (PreparedStatement) connect.prepareStatement(selectSql);

            // Update the quote
            updateStatement.setString(1, user_note);
            updateStatement.setString(2, status);
            updateStatement.setString(3, quoteID);

            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            // Retrieve updated values
            selectStatement.setString(1, quoteID);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String updatedUserNote = resultSet.getString("user_note");
                String updatedUserStatus = resultSet.getString("user_status");

                System.out.println("Updated user_note: " + updatedUserNote);
                System.out.println("Updated user_status: " + updatedUserStatus);
            }

            return rowUpdated;
        
        
        
    }

public boolean modifyContractorQuote(String quoteID, String Contractor_note, String Contractor_status, String price) throws SQLException {
        String updateSql = "UPDATE quote SET Negotiation_note = ?, contractor_status = ?, price = ? WHERE quoteID = ?";
        String selectSql = "SELECT Negotiation_note, contractor_status,  price FROM quote WHERE quoteID = ?";
        connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(updateSql);
             PreparedStatement selectStatement = (PreparedStatement) connect.prepareStatement(selectSql);

            // Update the quote
            updateStatement.setString(1, Contractor_note);
            updateStatement.setString(2, Contractor_status);
            updateStatement.setString(3, price);
            updateStatement.setString(4, quoteID);

            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            // Retrieve updated values
            selectStatement.setString(1, quoteID);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String updatedContractorNote = resultSet.getString("Negotiation_note");
                String updatedContractorStatus = resultSet.getString("contractor_status");
                String updatedPrice = resultSet.getString("price");
                System.out.println("Updated contractor_note: " + updatedContractorNote);
                System.out.println("Updated contractor_status: " + updatedContractorStatus);
                System.out.println("Updated price: " + updatedPrice);
            }

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
    
    
    public boolean updateRequest(String requestID, String status) throws SQLException
    {
    	String sql = "UPDATE request SET status = ? WHERE requestID = ?";
    	connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(sql);

            // Update the request
            updateStatement.setString(1, status);
            updateStatement.setString(2, requestID);
           
            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            return rowUpdated;
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
		        	"email VARCHAR(50),"+
		        	"requestID VARCHAR(10),"+
		        	"status VARCHAR(1),"+
		        	"note VARCHAR(100),"+
		        	"tree_id INT,"+
		        	"PRIMARY KEY(requestID),"+
		        	"FOREIGN KEY(tree_id) REFERENCES tree(tree_id));")

        };
        String[] INITIAL3 = {
        		"drop table if exists Quote;",
		        ("CREATE TABLE if not exists Quote( "+
		        	"email VARCHAR(50),"+
		        	"quoteID VARCHAR(10),"+
		        	"contractor_status VARCHAR(1),"+
		        	"user_status VARCHAR(1),"+
		        	"Negotiation_note VARCHAR(100),"+
		        	"work_period VARCHAR(2),"+
		        	"price VARCHAR(6),"+
		        	"user_note VARCHAR(100),"+
		        	"PRIMARY KEY(quoteID));")
        };
        
        String[] INITIAL4 = {
        		"drop table if exists tree;",
        		("CREATE TABLE IF NOT EXISTS tree ( "+
        				"tree_id INT AUTO_INCREMENT,"+
        			    "tree_distance VARCHAR(4),"+
        			    "trunk_size VARCHAR(4),"+
        			    "tree_height VARCHAR(6),"+
        			    "tree_location VARCHAR(50),"+
        			    "PRIMARY KEY (tree_id));")

        };
        
        String[] INITIAL5 = {
        		"drop table if exists bill;",
        		("CREATE TABLE IF NOT EXISTS bill ( "+
        			    "billID VARCHAR(10),"+
        			    "status VARCHAR(1),"+
        			    "negotiation_note VARCHAR(60),"+
        			    "final_price VARCHAR(4),"+
        			    "PRIMARY KEY (billID));")

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
        			+ "('damian@gmail.com','Damian','Wayne','damian2534','1049283746','2932','Blood','Haven','NJ','29385','1057382945194037'),\n"
        			+ "('maria@gmail.com','Maria','Alsamaien','maria1234','1112930457','4920','Street','Allen Park','MI','48277','1039675555556666');"
        		)
           			};
        String[] TUPLES2 = {
        		("insert into Request(email,requestID, status,note,tree_id)"+
            			"values ('roy@gmail.com','334DGWP','P','Nothing',1),"+
        				"('roy@gmail.com','4930634532','P','note',2),"+
            			"('dick@gmail.com','492054243','R','NA',3),"+
        				"('bat@gmail.com','435920853','P','good',4),"+
            			"('dick@gmail.com','df3424','P','nice',5),"+
        				"('barbara@gmail.com','3954023452','P','reasonable',6),"+
        				"('tim@gmail.com','3948123413','R','need more',7),"+
        				"('damian@gmail.com','3928543213','P','No Way',8),"+
        				"('maria@gmail.com','392043255','P','valid',9);")
        		
        };
        String[] TUPLES3 = {
//        		
        		("insert into Quote(email, quoteID, contractor_status, user_status,negotiation_note,work_period,price,user_note)"+
            			"values ('roy@gmail.com','4421FGWP','P','P','Nothing','20','2500',''),"+
        				"('roy@gmail.com','49204GQW3','P','P','satisfied','12','1340',''),"+
            			"('dick@gmail.com','492054HW','R','R','invalid','13','4400',''),"+
        				"('bat@gmail.com','39402043HQ','P','P','better deal','35','3752',''),"+
            			"('bat@gmail.com','AW492054E4','P','P','do better','3','23456',''),"+
        				"('barbara@gmail.com','4825042','P','P','accepted','3','100',''),"+
            			"('tim@gmail.com','5449205425','P','P','like it','7','3456',''),"+
        				"('damian@gmail.com','4920543243','P','P','no','8','567',''),"+
        				"('maria@gmail.com','4920542431','P','P','yes','19','24354','');")
        };
        
        String[] TUPLES4 = {
        		("insert into tree(tree_distance, trunk_size,tree_height,tree_location)"+
            			"values ('1111','1010','101010','Troy'),"+
        				"('2','2','2','Birmingham'),"+
            			"('1','1','1','Detroit'),"+
        				"('123','11','22876','Baltimore'),"+
            			"('1234','3213','12423','Warren'),"+
        				"('3920','4322','33333','Canton'),"+
            			"('1232','11','222','Dearborn'),"+
        				"('4323','234','423','Ann Arbor'),"+
        				"('3333','2222','333333','Troy');"
        				)
        };
       
        
        String[] TUPLES5 = {
        		("insert into bill(billID, status,negotiation_note,final_price)"+
            			"values ('0000','P','No notes','0000'),"+
        				"('S24S','P','Reduce price','800'),"+
            			"('g345','P','No notes','7777'),"+
        				"('dwrt','P','No notes','8749'),"+
            			"('Jk98','P','No notes','3100'),"+
        				"('h832','P','No notes','4000'),"+
            			"('1232','P','Reduce price','6100'),"+
        				"('43y3','P','Reduce price','2150'),"+
        				"('hy78','P','Reduce price','4000');"
        				)
        };
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < INITIAL4.length; i++)
        	statement.execute(INITIAL4[i]);
        for (int i = 0; i < INITIAL2.length; i++)
        	statement.execute(INITIAL2[i]);
                
        System.out.println("444444444444.");
        for (int i = 0; i < INITIAL3.length; i++)
        	statement.execute(INITIAL3[i]);
        
        for (int i = 0; i < INITIAL5.length; i++)
        	statement.execute(INITIAL5[i]);
        
        
        for (int i = 0; i < TUPLES.length; i++)
        	{statement.execute(TUPLES[i]);
        	}
        	
      
        	System.out.println("dsjfbsjfb");
        for (int i = 0; i<TUPLES4.length;i++) {
            statement.execute(TUPLES4[i]);
            }
        for (int j = 0; j<TUPLES2.length;j++) {
        	statement.execute(TUPLES2[j]);
        }
        
        for (int i = 0; i<TUPLES3.length;i++) {
        	statement.execute(TUPLES3[i]);
        }
        
        for (int i = 0; i<TUPLES5.length;i++) {
        	statement.execute(TUPLES5[i]);
        }
        
        
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
