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
import java.util.Date;
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
    
    public List<request> listAllRejectedRequests() throws SQLException {
        List<request> listRequest = new ArrayList<request>();        
        String sql = "SELECT * FROM Request WHERE status = 'R'";      
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
    
    public List<request> listAllSuccessfulRequests() throws SQLException {
        List<request> listRequest = new ArrayList<request>();        
        String sql = "SELECT * FROM Request WHERE status = 'S'";      
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
        String sql = "SELECT * FROM Request WHERE status = 'P' ";      
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
            int price = resultSet.getInt("price");
            int unique_tree_id =  resultSet.getInt("unique_tree_id");
            quote Quotes = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note,unique_tree_id);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<quote> listAllRejectedQuotes() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quote WHERE (contractor_status  = 'R' AND user_status = 'R')";      
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
            int price = resultSet.getInt("price");
            int unique_tree_id =  resultSet.getInt("unique_tree_id");
            quote Quotes = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note,unique_tree_id);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    
    public List<quote> listAllSuccessfulQuotes() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quote WHERE (contractor_status  = 'S' AND user_status = 'S')";      
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
            int price = resultSet.getInt("price");
            int unique_tree_id =  resultSet.getInt("unique_tree_id");
            quote Quotes = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note,unique_tree_id);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    
    public List<quote> listAllQuotesForContractor() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quote WHERE (contractor_status = 'P');  ";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String user_note =  resultSet.getString("user_note");
        	String email = resultSet.getString("email");
            String quoteID = resultSet.getString("quoteID");
            String negotiation_note = resultSet.getString("negotiation_note");
            String contractor_status = resultSet.getString("contractor_status");
            System.out.println("status1:"+resultSet.getString("contractor_status"));
            System.out.println("status2:"+resultSet.getString("user_status"));
            String user_status = resultSet.getString("user_status");
            String work_period = resultSet.getString("work_period");
            int price = resultSet.getInt("price");
            int unique_tree_id =  resultSet.getInt("unique_tree_id");
            quote Quotes = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note,unique_tree_id);
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
         	int tree_distance = resultSet.getInt("tree_distance");//Integer.parseInt(resultSet.getString("tree_distance"));
         	int trunk_size = resultSet.getInt("trunk_size");
             int tree_height = resultSet.getInt("tree_height");
             int tree_location = resultSet.getInt("tree_location");
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
        	String contractor_note = resultSet.getString("contractor_note");
        	String user_note = resultSet.getString("user_note");
        	String email = resultSet.getString("email");

        	int amt_due = resultSet.getInt("amt_due");
        	int amt_paid = resultSet.getInt("amt_paid");
        	int unique_tree_id = resultSet.getInt("unique_tree_id");
        	Date createdDate = resultSet.getDate("billCreationDate");
        	int counter = resultSet.getInt("counter");
        	

            System.out.println(billID+" "+status+" ");
             
            bill Bill = new bill(billID,status,user_note,contractor_note,amt_due,amt_paid,unique_tree_id,email,counter,createdDate);
            System.out.println(Bill.getBillID()+" "+Bill.getStatus()+" ");
            listBill.add(Bill);
            updateBillCounter(billID,createdDate);
        }        
        resultSet.close();
        disconnect();        
        return listBill;
    		
    	
    }
    
    public List<orders> listAllOrders() throws SQLException{
    	List<orders> listOrders = new ArrayList<orders>();        
        String sql = "SELECT * FROM orders";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String orderID = resultSet.getString("orderID");
        	String status = resultSet.getString("status");
        	String email = resultSet.getString("email");
        	Date finishDate = resultSet.getDate("finish_date");
            System.out.println(orderID+" "+status+" "+email);
             
            orders Order = new orders(email,orderID,status,finishDate);
            //System.out.println(Bill.getBillID()+" "+Bill.getStatus()+" "+ Bill.getNegotiation_note()+" "+ Bill.getFinal_price());
            listOrders.add(Order);
        }        
        resultSet.close();
        disconnect();        
        return listOrders;
    		
    	
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
            int price = resultSet.getInt("price");
            quote Quotes = new quote(quoteID, contractor_status, user_status, negotiation_note,work_period, price,email);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<orders> listSpecificOrder(String email) throws SQLException {
        List<orders> listOrder = new ArrayList<orders>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM orders WHERE email=\"%s\";",email);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String orderID = resultSet.getString("orderID");
            String status = resultSet.getString("status");
            int unique_tree_id = resultSet.getInt("unique_tree_id");
            Date finish_date = resultSet.getDate("finish_date");
            orders Order = new orders(email, orderID, status, unique_tree_id,finish_date);
            listOrder.add(Order);
        }        
        resultSet.close();
        disconnect();        
        return listOrder;
    }
    
    public List<tree> listSpecificTrees(int unique_tree_id) throws SQLException {
        List<tree> listTree = new ArrayList<>();
        System.out.println("Started");
        List<Integer> treeIDs = getTreeIdentifier(unique_tree_id);
        for (int i = 0; i < treeIDs.size(); i++) {
            String sql = "SELECT * FROM tree WHERE tree_id = ?";
            connect_func();
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, treeIDs.get(i));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int tree_distance = resultSet.getInt("tree_distance");
                int trunk_size = resultSet.getInt("trunk_size");
                int tree_height = resultSet.getInt("tree_height");
                int tree_location = resultSet.getInt("tree_location");
                tree Tree = new tree(tree_distance, trunk_size, tree_height, tree_location);
                listTree.add(Tree);
            }
            resultSet.close();
            preparedStatement.close();
        }
        disconnect();
        return listTree;
    }
    
    public List<messages> listSpecificMessages(String quoteID) throws SQLException {
    	List<messages> listMessages = new ArrayList<messages>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM messages WHERE quoteID=\"%s\";",quoteID);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
        	int message_id = resultSet.getInt("message_id");
            String sender = resultSet.getString("sender");
            String recipient = resultSet.getString("recipient");
            String message_content = resultSet.getString("message_content");
            String timestamp = resultSet.getString("timestamp");

            messages Message = new messages(message_id, sender, recipient, message_content,timestamp,quoteID);
            listMessages.add(Message);
        }        
        resultSet.close();
        disconnect();        
        return listMessages;
    }
    
    public List<messages> listSpecificMessagesFromBillID(String billID) throws SQLException {
    	List<messages> listMessages = new ArrayList<messages>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM messages WHERE billID=\"%s\";",billID);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
        	int message_id = resultSet.getInt("message_id");
            String sender = resultSet.getString("sender");
            String recipient = resultSet.getString("recipient");
            String message_content = resultSet.getString("message_content");
            String timestamp = resultSet.getString("timestamp");

            messages Message = new messages(billID,message_id, sender, recipient, message_content,timestamp);
            listMessages.add(Message);
        }        
        resultSet.close();
        disconnect();        
        return listMessages;
        
       
    }
    public List<bill> listSpecificBill(String email) throws SQLException {
        List<bill> listBill = new ArrayList<bill>();        
        System.out.println("Started");
        String sql = String.format("SELECT * FROM bill WHERE email=\"%s\";",email);    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String billID = resultSet.getString("billID");
            String status = resultSet.getString("status");
            int amt_due = resultSet.getInt("amt_due");
            int amt_paid = resultSet.getInt("amt_paid");
            String user_note = resultSet.getString("user_note");
            String contractor_note = resultSet.getString("contractor_note");
            int unique_tree_id = resultSet.getInt("unique_tree_id");

            bill Bill = new bill(billID,status,user_note,contractor_note,amt_due,amt_paid,unique_tree_id,email);
            listBill.add(Bill);
        }        
        resultSet.close();
        disconnect();        
        return listBill;
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
		String sql = "insert into Request(email, requestID,status,note,unique_tree_id) values (?, ?, ?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, requests.getEmail());
	        preparedStatement.setString(2, requests.getRequestID());
			preparedStatement.setString(3, requests.getStatus());
			preparedStatement.setString(4, requests.getNote());
			preparedStatement.setInt(5, requests.getUnique_tree_id());
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
		String sql = "insert into quote(email,quoteID, contractor_status, user_status ,negotiation_note,work_period,price,unique_tree_id) values (?,?, ?, ?, ?, ?,?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, quotes.getEmail());
		 preparedStatement.setString(2, quotes.getQuoteID());
	        preparedStatement.setString(3, quotes.getContractor_status());
	        preparedStatement.setString(4, quotes.getUser_status());
			preparedStatement.setString(5, quotes.getNegotiation_note());
			preparedStatement.setString(6, quotes.getWork_period());
			preparedStatement.setInt(7, quotes.getPrice());
			preparedStatement.setInt(8, quotes.getUnique_tree_id());
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    
    public int insertTree(tree trees) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	//System.out.println(quotes.getQuoteID());
		String sql = "insert into tree(tree_distance, trunk_size,tree_height,tree_location) values (?, ?, ?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setInt(1, trees.getTree_distance());
		 preparedStatement.setInt(2, trees.getTrunk_size());
	        preparedStatement.setInt(3, trees.getTree_height());
	        preparedStatement.setInt(4, trees.getTree_location());
			
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
		String selectSql = "SELECT tree_id FROM tree ORDER BY tree_id DESC LIMIT 1;";
        PreparedStatement selectStatement = (PreparedStatement) connect.prepareStatement(selectSql);

		ResultSet resultSet = selectStatement.executeQuery();
		int tree_id = 1;
        if (resultSet.next()) {
        	tree_id = resultSet.getInt(tree_id);
        	System.out.println(tree_id);
            
        }
        System.out.println("Updated tree_number: " + tree_id);
        preparedStatement.close();
        System.out.println("closed");
        return tree_id;
    }
    
    public void insertTreeIdentifier(TreeIdentifier tree_identifier) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	//System.out.println(quotes.getQuoteID());
		String sql = "insert into TreeIdentifier(unique_id, tree_ids) values (?, ?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setInt(1, tree_identifier.getUnique_id());
		 preparedStatement.setInt(2, tree_identifier.getTree_ids());
			
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");

        preparedStatement.close();
        System.out.println("closed");
        return;
    }
    
    public void insertOrder(orders Order) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	//System.out.println(quotes.getQuoteID());
		String sql = "insert into Orders(orderID,status,email,unique_tree_id) values (?, ?, ?, ?)";
		System.out.println(Order.getUnique_tree_id());
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, Order.getOrderID());
		 preparedStatement.setString(2, Order.getStatus());
	        preparedStatement.setString(3, Order.getEmail());
	        System.out.println(Order.getEmail());
	        preparedStatement.setInt(4, Order.getUnique_tree_id());
	        //preparedStatement.setDate(5, (java.sql.Date) Order.getFinish_date());
			
			System.out.println("sql implemented.");

			try {
		        // Your existing code for establishing connection and preparing the statement

		        // Execute the SQL query
		        preparedStatement.executeUpdate();

		        // Close resources
		        preparedStatement.close();
		        connect.close();
		    } catch (SQLException e) {
		        System.err.println("SQLException: " + e.getMessage());
		        System.err.println("SQLState: " + e.getSQLState());
		        System.err.println("VendorError: " + e.getErrorCode());
		    }
    }
    public void insertBill(bill bills) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	System.out.println(bills.getBillID());
		String sql = "insert into bill(billID,status, user_note,contractor_note, amt_due ,amt_paid,unique_tree_id) values (?,?, ?, ?, ?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, bills.getBillID());
		 preparedStatement.setString(2, bills.getStatus());
	        preparedStatement.setString(3, bills.getUser_note());
	        preparedStatement.setString(4, bills.getContractor_note());

	        preparedStatement.setInt(5, bills.getAmt_due());
			preparedStatement.setInt(6, bills.getAmt_paid());
			preparedStatement.setInt(7, bills.getUnique_tree_id());
			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    public void insertMessagesForClient(String quoteID,String email,String user_note) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	System.out.println(quoteID);
		String sql = "insert into messages(sender,recipient, message_content,quoteID) values (?,?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, "david@gmail.com");
	        preparedStatement.setString(3, user_note);
	        preparedStatement.setString(4, quoteID);

			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    public void insertMessagesForContractor(String quoteID,String user_email,String contractor_note) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
    	System.out.println(quoteID);
		String sql = "insert into messages(sender,recipient, message_content,quoteID) values (?,?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, "david@gmail.com");
		 preparedStatement.setString(2, user_email);
	        preparedStatement.setString(3, contractor_note);
	        preparedStatement.setString(4, quoteID);

			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    public void insertMessagesForContractorUsingBillID(String billID,String user_email,String contractor_note) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
		String sql = "insert into messages(sender,recipient, message_content,BillID) values (?,?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, "david@gmail.com");
		 preparedStatement.setString(2, user_email);
	        preparedStatement.setString(3, contractor_note);
	        preparedStatement.setString(4, billID);

			System.out.println("sql implemented.");

		preparedStatement.executeUpdate();
		System.out.println("updated");
        preparedStatement.close();
        System.out.println("closed");
    }
    
    public void insertMessagesForClientUsingBillID(String billID,String user_email,String client_note) throws SQLException {
    	System.out.println("insert began");
    	connect_func("root","rishi1234"); 
    	System.out.println("connected");
		String sql = "insert into messages(sender,recipient, message_content,BillID) values (?,?, ?,?)";
		
		 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		 preparedStatement.setString(1, user_email);
		 preparedStatement.setString(2, "david@gmail.com");
	        preparedStatement.setString(3, client_note);
	        preparedStatement.setString(4, billID);

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
    
public boolean modifyBill(String billID,String contractor_note,int amt_due) throws SQLException {
        String updateSql = "UPDATE bill SET contractor_note = ?, amt_due = ? WHERE billID = ?";
        connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(updateSql);

            // Update the quote
            updateStatement.setString(1, contractor_note);
            updateStatement.setInt(2, amt_due);
            updateStatement.setString(3, billID);

            boolean rowUpdated = updateStatement.executeUpdate() > 0;
            return rowUpdated;
        
        
        
    }
    
    public boolean modifyUserQuoteForNegotiationStatus(String quoteID) throws SQLException {
        String updateSql = "UPDATE quote SET negotiationStatus = ? WHERE quoteID = ?";
        String selectSql = "SELECT negotiationStatus FROM quote WHERE quoteID = ?";
        connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(updateSql);
             PreparedStatement selectStatement = (PreparedStatement) connect.prepareStatement(selectSql);

            // Update the quote
            updateStatement.setInt(1, 1);
            updateStatement.setString(2, quoteID);

            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            // Retrieve updated values
            selectStatement.setString(1, quoteID);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int updatedNegStatus = resultSet.getInt("negotiationStatus");

                System.out.println("Updated user_note: " + updatedNegStatus);
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

public boolean modifyOrderFinalDate(String orderID,Date finish_date) throws SQLException {
    String updateSql = "UPDATE orders SET finish_date = ?  WHERE orderID = ?";
    String selectSql = "SELECT finish_date FROM orders WHERE orderID = ?";
    connect_func(); 
    
    	 
         PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(updateSql);
         PreparedStatement selectStatement = (PreparedStatement) connect.prepareStatement(selectSql);

        // Update the quote
        updateStatement.setDate(1, new java.sql.Date(finish_date.getTime()));
        updateStatement.setString(2, orderID);

        boolean rowUpdated = updateStatement.executeUpdate() > 0;

        // Retrieve updated values
        selectStatement.setString(1, orderID);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            Date updatedFinishDate = resultSet.getDate("finish_date");
            System.out.println("Updated contractor_note: " + updatedFinishDate);
        }

        return rowUpdated;
    
    
    
}


public request getRequest(String requestID) throws SQLException {
	request Request = null;
    String sql = "SELECT * FROM request WHERE requestID = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, requestID);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    String user_note = ""; 
    int unique_tree_id= 1; 
    if (resultSet.next()) {
    	 user_note = resultSet.getString("note");
         unique_tree_id = resultSet.getInt("unique_tree_id"); 
         }
    Request = new request(user_note, unique_tree_id);
    System.out.println(Request.getUnique_tree_id()); 
    resultSet.close();
    preparedStatement.close();
     
    return Request;
}

public quote getQuote(String quoteID) throws SQLException {
	quote Quote = null;
    String sql = "SELECT * FROM quote WHERE quoteID = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, quoteID);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    String user_note = "",contractor_status="", user_status="", negotiation_note="",work_period ="",email=""; 
    int unique_tree_id= 1, price=0; 
    if (resultSet.next()) {
    	 user_note = resultSet.getString("user_note");
    	 contractor_status = resultSet.getString("contractor_status");
    	 user_status = resultSet.getString("user_status");
    	 negotiation_note = resultSet.getString("Negotiation_note");
    	 work_period = resultSet.getString("work_period");
    	 price = resultSet.getInt("price");
    	 email = resultSet.getString("email");
         unique_tree_id = resultSet.getInt("unique_tree_id"); 
         }
    Quote = new quote(quoteID,contractor_status,user_status,negotiation_note,work_period,price,email,user_note,unique_tree_id);
    //System.out.println(Request.getTree_id()); 
    resultSet.close();
    preparedStatement.close();
     
    return Quote;
}

public int getQuotePriceFromUniqueTreeID(int unique_tree_id ) throws SQLException {
	System.out.println("Price started");
    String sql = "SELECT price FROM quote WHERE unique_tree_id = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setInt(1, unique_tree_id);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    int price=0; 
    if (resultSet.next()) {
    	 price = resultSet.getInt("price");
         }
    //System.out.println(Request.getTree_id()); 
    resultSet.close();
    preparedStatement.close();
     
    return price;
}


public tree getTree(int treeID) throws SQLException {
	tree Tree = null;
    String sql = "SELECT * FROM tree WHERE tree_id = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setInt(1, treeID);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    int tree_distance=0, trunk_size=0,tree_height=0,tree_location = 0; 
    if (resultSet.next()) {
    	 tree_distance = resultSet.getInt("tree_distance");
         trunk_size = resultSet.getInt("trunk_size");
         tree_height = resultSet.getInt("tree_height");
         tree_location = resultSet.getInt("tree_location");
         }
    Tree = new tree(tree_distance, trunk_size,tree_height,tree_location); 
    //System.out.println(Tree.getTree_distance()+" "+Tree.getTrunk_size()+" "+Tree.getTree_height()+" "+Tree.getTree_location()); 

    resultSet.close();
    preparedStatement.close();
    return Tree;
}

public ArrayList<Integer> getTreeIdentifier(int unique_id) throws SQLException {
	System.out.println("Started");
	String sql = "SELECT * FROM TreeIdentifier WHERE unique_id = ?";
	connect_func();

	preparedStatement = connect.prepareStatement(sql);
	preparedStatement.setInt(1, unique_id);

	ResultSet resultSet = preparedStatement.executeQuery();
	//System.out.println("RS: " + resultSet);

	ArrayList<Integer> tree_id_list = new ArrayList<>();
	while (resultSet.next()) {
	    String treeIdsString = resultSet.getString("tree_ids");
	    System.out.println(treeIdsString); 
	    String[] treeIdsArray = treeIdsString.split(",");
	    for (String id : treeIdsArray) {
	        int treeId = Integer.parseInt(id.trim());
	        tree_id_list.add(treeId);
	        System.out.println(treeId);
	    }
	}

	System.out.println("finished");

	resultSet.close();
	preparedStatement.close();

	return tree_id_list;
//	//tree Tree = null;
//	System.out.println("Started");
//    String sql = "SELECT tree_ids FROM TreeIdentifier WHERE unique_id = ?";
//     
//    connect_func();
//     
//    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//    preparedStatement.setInt(1, unique_id);
//     
//    ResultSet resultSet = preparedStatement.executeQuery();
//	System.out.println("RS: "+resultSet);
//
//    String tree_ids = "";
//    int tree = 0;
//    //ArrayList<tree> treeList = new ArrayList<>();
//    ArrayList<Integer> tree_id_list = new ArrayList<>();
//    if (resultSet.next()) {
//    	tree_ids = resultSet.getString("tree_ids");
//    	tree_id_list.add(tree);
//    	System.out.println(tree_ids);
//         }
//    
//    //System.out.println(Tree.getTree_distance()+" "+Tree.getTrunk_size()+" "+Tree.getTree_height()+" "+Tree.getTree_location()); 
//	System.out.println("finished");
//
//    resultSet.close();
//
//    preparedStatement.close();
//
//    return tree_id_list;

}

@SuppressWarnings("deprecation")
public orders getOrder(String orderID) throws SQLException {
	orders Order = null;
    String sql = "SELECT * FROM orders WHERE orderID = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, orderID);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    String status="", email="";
    int unique_tree_id = 1;
    Date finish_date = new Date(100,9,1);
    if (resultSet.next()) {
    	 status = resultSet.getString("status");
         email = resultSet.getString("email");
         unique_tree_id = resultSet.getInt("unique_tree_id");
         finish_date = resultSet.getDate("finish_date");
         }
    Order = new orders(email,orderID,status,unique_tree_id,finish_date); 
    //System.out.println(Tree.getTree_distance()+" "+Tree.getTrunk_size()+" "+Tree.getTree_height()+" "+Tree.getTree_location()); 

    resultSet.close();
    preparedStatement.close();
    return Order;
}

public bill getBill(String billID) throws SQLException {
	orders Order = null;
    String sql = "SELECT * FROM bill WHERE billID = ?";
     
    connect_func();
     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, billID);
     
    ResultSet resultSet = preparedStatement.executeQuery();
    String status="", user_note="", contractor_note="",email="";
    int unique_tree_id = 1,amt_due = 0,amt_paid =0,counter=0;
    if (resultSet.next()) {
    	 status = resultSet.getString("status");
         email = resultSet.getString("email");
         unique_tree_id = resultSet.getInt("unique_tree_id");
         user_note = resultSet.getString("user_note");
         contractor_note = resultSet.getString("contractor_note");
         amt_due = resultSet.getInt("amt_due");
         amt_paid = resultSet.getInt("amt_paid");
         counter = resultSet.getInt("counter");

         }
    bill nBill = new bill(billID,status,user_note,contractor_note, amt_due,amt_paid,unique_tree_id,email); 
    //System.out.println(Tree.getTree_distance()+" "+Tree.getTrunk_size()+" "+Tree.getTree_height()+" "+Tree.getTree_location()); 

    resultSet.close();
    preparedStatement.close();
    return nBill;
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
    
    public boolean updateOrder(String orderID, String status) throws SQLException
    {
    	String sql = "UPDATE orders SET status = ? WHERE orderID = ?";
    	connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(sql);

            // Update the request
            updateStatement.setString(1, status);
            updateStatement.setString(2, orderID);
           
            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            return rowUpdated;
    }
    
    public boolean updateBill(String billID, String status,int amt_due,int amt_paid) throws SQLException
    {
    	String sql = "UPDATE bill SET status = ?,amt_due=?,amt_paid=? WHERE billID = ?";
    	connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(sql);

            // Update the request
            updateStatement.setString(1, status);
            updateStatement.setInt(2, amt_due);
            updateStatement.setInt(3, amt_paid);
            updateStatement.setString(4, billID);

           
            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            return rowUpdated;
    }
    
private long BillDaysCalculator(Date billCreationDate) {
    	System.out.println("");
           // Date billCreationDate = new Date();
            
            Date currentDate = new Date();
            
            long daysDifference = (currentDate.getTime() - billCreationDate.getTime())/(1000 * 60 * 60 * 24);
            System.out.println("Number of days since the bill was created: " + daysDifference + " days");
            return daysDifference;

          }
    
    public boolean updateBillCounter(String billID, Date billCreationDate) throws SQLException
    {
    	long counter = BillDaysCalculator(billCreationDate);
    	String sql = "UPDATE bill SET counter = ? WHERE billID = ?";
    	connect_func(); 
        
        	 
             PreparedStatement updateStatement = (PreparedStatement) connect.prepareStatement(sql);

            // Update the request
            updateStatement.setInt(1, (int)counter);
            updateStatement.setString(2, billID);
           
            boolean rowUpdated = updateStatement.executeUpdate() > 0;

            return rowUpdated;
    }
    
    public void updateAllBillCounter() throws SQLException
    {
    	String sql = "SELECT COUNT(*) AS row_count FROM bill;";
    	         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.close();
        preparedStatement.close();
        int counter = 0;
        if (resultSet.next()) {
        	counter =resultSet.getInt("row_count");
             }
        String sql2 = "SELECT billID,billCreationDate FROM bill";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql2);
        ResultSet resultSet2 = preparedStatement.executeQuery();

        String billID = "";
        Date billCreationDate = new Date();
        if (resultSet2.next()) {
        	billID = resultSet2.getString("billID");
        	billCreationDate = resultSet2.getDate("billCreationDate");
        	updateBillCounter(billID,billCreationDate);
        }
        
        resultSet2.close();
        preparedStatement.close();
    }
    
    
    public List<String> listBigClients() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = ("select\n"
        		+ "  q.email,\n"
        		+ "  COUNT(t.tree_ids) AS tree_count\n"
        		+ "from\n"
        		+ "  quote q, treeIdentifier t\n"
        		+ "where q.unique_tree_id = t.unique_id\n"
        		+ "GROUP BY\n"
        		+ "  q.email\n"
        		+ "Order by \n"
        		+ " tree_count DESC\n"
        		+ "LIMIT 1;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String treeCount = resultSet.getString("tree_count");
            list.add(email);
            list.add(treeCount);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }  
    
    public List<String> listSingleTree() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = ("SELECT\n"
        		+ "  q.email,\n"
        		+ "  COUNT(t.tree_ids) AS tree_count\n"
        		+ "FROM quote q, treeIdentifier t \n"
        		+ "where q.unique_tree_id = t.unique_id\n"
        		+ "GROUP BY q.email\n"
        		+ "having  tree_count = 1\n"
        		+ "order by\n"
        		+ "tree_count DESC;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String treeCount = resultSet.getString("tree_count");
            list.add(email);
            list.add(treeCount);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<String> listProspectiveClients() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = (" select distinct email from quote\n"
        		+ "where user_status = \"P\";");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(email);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<String> listEasyClients() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = ("SELECT email\n"
        		+ "from quote \n"
        		+ "where user_status = 'S' AND negotiationStatus = 1;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(email);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<Integer> listHighestTree() throws SQLException {
    	List<Integer> list = new ArrayList<Integer>();        
        System.out.println("Started");
        String sql = ("SELECT tree_height\n"
        		+ "FROM tree\n"
        		+ "WHERE tree_height = (\n"
        		+ "    SELECT MAX(tree_height)\n"
        		+ "    FROM tree\n"
        		+ ");");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            int tree_height = resultSet.getInt("tree_height");
            list.add(tree_height);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<String> listBadClients() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = (" SELECT\n"
        		+ "  email\n"
        		+ "FROM\n"
        		+ "  bill\n"
        		+ "WHERE\n"
        		+ "  counter>7;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(email);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<String> listGoodClients() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = ("    SELECT\n"
        		+ "  email\n"
        		+ "FROM\n"
        		+ "  bill\n"
        		+ "WHERE\n"
        		+ "  counter<=1;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(email);
        }        
        resultSet.close();
        disconnect();        
        return list;
    }
    
    public List<String> listStatistics() throws SQLException {
    	List<String> list = new ArrayList<String>();        
        System.out.println("Started");
        String sql = ("SELECT\n"
        		+ "  q.email,\n"
        		+ "  COUNT(t.tree_id) AS total_trees,\n"
        		+ "  SUM(b.amt_due) AS total_due_amount,\n"
        		+ "  SUM(b.amt_paid) AS total_paid_amount,\n"
        		+ "  o.finish_date AS work_done_date\n"
        		+ "FROM\n"
        		+ "  quote q\n"
        		+ "JOIN tree t ON q.unique_tree_id = t.tree_id\n"
        		+ "JOIN orders o ON q.unique_tree_id = o.unique_tree_id\n"
        		+ "JOIN bill b ON q.unique_tree_id = b.unique_tree_id \n"
        		+ "GROUP BY q.email,o.finish_date;");    
        
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SQL started");
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String trees = resultSet.getString("total_trees");
            String amt_due = resultSet.getString("total_due_amount");
            String amt_paid = resultSet.getString("total_paid_amount");
            String date = resultSet.getString("work_done_date");


            list.add(email);
            list.add(trees);
            list.add(amt_due);
            list.add(amt_paid);
            list.add(date);

        }        
        resultSet.close();
        disconnect();        
        return list;
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
		        	"unique_tree_id INT AUTO_INCREMENT,"+
		        	"PRIMARY KEY(unique_tree_id));")

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
		        	"price INT,"+
		        	"user_note VARCHAR(100),"+
		        	"unique_tree_id INT,"+
		        	"negotiationStatus INT(1),"+
		        	"PRIMARY KEY(quoteID));")
        };
        
        String[] INITIAL4 = {
        		"drop table if exists tree;",
        		("CREATE TABLE IF NOT EXISTS tree ( "+
        				"tree_id INT AUTO_INCREMENT,"+
        			    "tree_distance INT,"+
        			    "trunk_size INT,"+
        			    "tree_height INT,"+
        			    "tree_location INT,"+
        			    "PRIMARY KEY (tree_id));")

        };
        
        String[] INITIAL5 = {
        		"drop table if exists bill;",
        		("CREATE TABLE IF NOT EXISTS bill ( "+
        			    "billID VARCHAR(10),"+
        			    "status VARCHAR(1),"+
        			    "user_note VARCHAR(60),"+
        			    "contractor_note VARCHAR(60),"+
        			    "amt_due INT,"+
        			    "amt_paid INT,"+
        			    "unique_tree_id INT,"+
        			    "email VARCHAR(50),"+
        			    "counter INT,"+
        			    "billCreationDate DATE,"+
        			    "PRIMARY KEY (billID));")

        };
        
        String[] INITIAL6 = {
        		"drop table if exists orders;",
        		("CREATE TABLE IF NOT EXISTS orders ( "+
    					"orderID VARCHAR(10), "+
    							"status VARCHAR(1),"+
    		                    "email VARCHAR(50),"+
    		                    "unique_tree_id INT,"+
    		                    "finish_date DATE,"+
    		                    "PRIMARY KEY(orderID));")

        };
        
        String[] INITIAL7 = {
        		"drop table if exists TreeIdentifier;",
        		("CREATE TABLE IF NOT EXISTS TreeIdentifier ( "+
        			    "unique_id INT,"+
        			    "tree_ids INT);")

        };
        
        String[] INITIAL8 = {
        		"drop table if exists messages;",
        		("CREATE TABLE IF NOT EXISTS messages ( "+
        			    "message_id INT AUTO_INCREMENT,"+
        			    "sender VARCHAR(50),"+
        			    "recipient VARCHAR(50),"+
        			    "message_content TEXT,"+
        			    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"+
        			    "quoteID VARCHAR(10),"+
        			    "BillID VARCHAR(10),"+
        			    "PRIMARY KEY (message_id));")

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
        			+ "('damian@gmail.com','Damian','Wayne','damian1234','1049283746','2932','Blood','Haven','NJ','29385','1057382945194037'),\n"
        			+ "('maria@gmail.com','Maria','Alsamaien','maria1234','1112930457','4920','Street','Allen Park','MI','48277','1039675555556666');"
        		)
           			};
        String[] TUPLES2 = {
        		("insert into Request(email,requestID, status,note,unique_tree_id)"+
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
        		("insert into Quote(email, quoteID, contractor_status, user_status,negotiation_note,work_period,price,user_note,unique_tree_id,negotiationStatus)"+
            			"values ('roy@gmail.com','4421FGWP','P','P','Nothing','20',3000,'',1,0),"+
        				"('roy@gmail.com','49204GQW3','P','P','satisfied','12',1340,'',2,0),"+
            			"('dick@gmail.com','492054HW','R','S','invalid','13',4400,'',3,1),"+
        				"('bat@gmail.com','39402043HQ','P','P','better deal','35',3752,'',4,0),"+
            			"('dick@gmail.com','AW492054E4','P','P','do better','3',23456,'',5,0),"+
        				"('barbara@gmail.com','4825042','P','S','accepted','3',100,'',6,1),"+
            			"('tim@gmail.com','5449205425','P','P','like it','7',3456,'',7,0),"+
        				"('damian@gmail.com','4920543243','P','P','no','8',567,'',8,0),"+
        				"('maria@gmail.com','4920542431','P','P','yes','19',2435,'',9,0);")
        };
        
        String[] TUPLES4 = {
        		("insert into tree(tree_distance, trunk_size,tree_height,tree_location)"+
            			"values (1111,1010,101010,10),"+
        				"(2,2,2,18),"+
            			"(1,1,1,20),"+
        				"(123,11,22876,9),"+
            			"(123,3213,12423,29),"+
        				"(3920,4322,33333,3),"+
            			"(1232,11,222,20),"+
        				"(4323,234,423,16),"+
        				"(3333,2222,333333,18),"+
        				"(23,12,18,20);"
        				)
        };
       
        
        String[] TUPLES5 = {
        		("insert into bill(billID, status,user_note,contractor_note,amt_due,amt_paid,unique_tree_id,email,counter,billCreationDate)"+
            			"values ('0000','P','No notes','',5000,200,1,'roy@gmail.com',1,'2023-12-15'),"+
        				"('S24S','P','Reduce price','',1340,100,2,'bat@gmail.com',3,'2023-12-13'),"+
            			"('g345','P','No notes','',1200,90,3,'maria@gmail.com',4,'2023-12-12'),"+
        				"('dwrt','P','No notes','',1000,200,4,'dick@gmail.com',1,'2023-12-15'),"+
            			"('Jk98','P','No notes','',3100,1300,5,'barbara@gmail.com',3,'2023-12-13'),"+
        				"('h832','P','No notes','',4000,1200,6,'tim@gmail.com',2,'2023-12-14'),"+
            			"('1232','P','Reduce price','',6100,2000,7,'damian@gmail.com',6,'2023-12-10'),"+
        				"('43y3','P','Reduce price','',2150,400,8,'damian@gmail.com',9,'2023-12-07'),"+
        				"('hy78','P','Reduce price','',4000,300,9,'barbara@gmail.com',10,'2023-12-16');"
        				)
        };
        
        String[] TUPLES7 = {
        		("insert into TreeIdentifier(unique_id, tree_ids)"+
            			"values (1,1),"+
        				"(2,2),"+
            			"(3,3),"+
        				"(4,4),"+	
            			"(5,5),"+
        				"(6,6),"+
            			"(7,7),"+
        				"(8,8),"+
        				"(9,9),"+
        				"(9,10);"
        				)
        };
        
        String[] TUPLES6 = {
        		("insert into Orders(orderID,status,email,unique_tree_id,finish_date)\n"
        				+ "            			values ('ap9807','P', 'roy@gmail.com',1,'2023-10-12');")
        };
        
        String[] TUPLES8 = {
        		("insert into messages(sender,recipient,message_content,timestamp,quoteID)\n"
        				+ "            			values ('roy@gmail.com','david@gmail.com', 'Can I get a price reduction?','2023-12-10 09:56:46','4421FGWP'),"+
        												"('david@gmail.com','roy@gmail.com','Sure. I can reduce 100 dollars','2023-12-10 10:56:00','4421FGWP');")
        };
        String[] TUPLES9 = {
        		("insert into messages(sender,recipient,message_content,timestamp,billID)\n"
        				+ "            			values ('roy@gmail.com','david@gmail.com', 'Can I get a price reduction?','2023-12-14 09:56:46','0000'),"+
        												"('david@gmail.com','roy@gmail.com','Sure. I can reduce 100 dollars','2023-12-14 10:56:00','0000');")
        };
//        for (int i = 0; i < INITIAL8.length; i++)
//        	statement.execute(INITIAL8[i]);
//        
//        for (int i = 0; i<TUPLES8.length;i++) {
//       	statement.execute(TUPLES8[i]);
//       }
//        
//        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < INITIAL7.length; i++)
        	statement.execute(INITIAL7[i]);
        for (int i = 0; i < INITIAL4.length; i++)
        	statement.execute(INITIAL4[i]);
        for (int i = 0; i < INITIAL2.length; i++)
        	statement.execute(INITIAL2[i]);
                
        System.out.println("444444444444.");
        for (int i = 0; i < INITIAL3.length; i++)
        	statement.execute(INITIAL3[i]);
        
        for (int i = 0; i < INITIAL5.length; i++)
        	statement.execute(INITIAL5[i]);
        
        for (int i = 0; i < INITIAL6.length; i++)
        	statement.execute(INITIAL6[i]);
        
        for (int i = 0; i < INITIAL8.length; i++)
        	statement.execute(INITIAL8[i]);
        
        
        System.out.println("dsjfbsjfb");
        for (int i = 0; i < TUPLES.length; i++)
        	{statement.execute(TUPLES[i]);
        	}
        	
      
        	
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
        
        for (int i = 0; i<TUPLES6.length;i++) {
        	statement.execute(TUPLES6[i]);
        }
        
        for (int i = 0; i<TUPLES7.length;i++) {
        	statement.execute(TUPLES7[i]);
        }
        
        for (int i = 0; i<TUPLES8.length;i++) {
        	statement.execute(TUPLES8[i]);
        }
        for (int i = 0; i<TUPLES9.length;i++) {
        	statement.execute(TUPLES9[i]);
        }
        
        
        
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
