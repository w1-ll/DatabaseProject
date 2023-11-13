import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Random;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);  
                 break;
//        	 case "/SendToRequestPage":
//        		 System.out.println("Direct to Request Page initiated.");
//        		 SendToRequestPage(request,response);
        	 case "/newRequest":
        		 System.out.println("Request initiated");
        		 newRequest(request, response);
                 break;
        	 case "/sendQuote":
        		 System.out.println("Send to Quote initiated");
        		 newQuote(request, response);
                 break;
        	 case "/DirectToQuotePage":
        		 System.out.println("Direct to Quote Page initiated.");
        		 DirectToQuotePage(request,response);
        		 break;
        	 case "/ClientQuotePage":
        		 System.out.println("Client Quote Page initiated");
        		 ClientQuotePage(request,response);
        		 break;
        	 case "/checkQuote":
        		 System.out.println("Quote checked.");
        		 checkQuote(request,response);
        		 break;
        	 case "/SendToRequestPage":
        		 System.out.println("Send to Request page initiated.");
        		 SendToRequestPage(request,response);
        		 break;
        	 case "/ContractorQuotePage":
        		 System.out.println("Contractor quote page initiated.");
        		 ContractorQuotePage(request,response);
        		 break;
        	 case "/ReviseQuote":
        		 System.out.println("Quote revision initiated.");
        		 ReviseQuote(request,response);
        		 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
			
			request.setAttribute("Requests", userDAO.listAllRequests());
			request.setAttribute("Quotes", userDAO.listAllQuotes());
			request.setAttribute("Trees", userDAO.listAllTrees());
			List<bill> lb = userDAO.listAllBills();

			for (bill e : lb) {
				System.out.println(e.getBillID()+" "+e.getStatus()+" "+ e.getNegotiation_note()+" "+ e.getFinal_price());
			}
			request.setAttribute("Bills", userDAO.listAllBills());
			//request.setAttribute("Bills", "Bills are fucking stupid and cowards.");
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void contractorPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("contractor view");
	    	request.setAttribute("Requests", userDAO.listAllRequestsForContractor());
	    	request.setAttribute("Quotes", userDAO.listAllQuotes());
	    	request.getRequestDispatcher("contractor.jsp").forward(request, response);

	    }
	    private void userPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	 System.out.println("userPage started");
	    	 //String email = request.getParameter("email");
	    	 session = request.getSession();
	    	 String email = (String)session.getAttribute("username");
	    	 request.setAttribute("specificRequest",userDAO.listSpecificRequests(email));
			 request.setAttribute("specificQuote", userDAO.listSpecificQuote(email));
		     request.getRequestDispatcher("activitypage.jsp").forward(request, response);

	    }
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 System.out.println("check");
	    	 if (email.equals("root") && password.equals("pass1234")) {
	    		 System.out.println("worked");
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 
				 rootPage(request, response, "");
	    	 }
	    	 else if(email.equals("david@gmail.com") && password.equals("david1234")) {
	    		 System.out.println("worked");
				 System.out.println("Login Successful! Redirecting to the contractor.");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 contractorPage(request, response, "");
	    	 }
	    	 
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 currentUser = email;
				 System.out.println("Login Successful! Redirecting");
				 session = request.getSession();
				 session.setAttribute("username", currentUser);
				 System.out.println("Started.");
				 userPage(request, response, "");
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String phone_number = request.getParameter("phone_number");
	   	 	String adress_street_num = request.getParameter("adress_street_num"); 
	   	 	String adress_street = request.getParameter("adress_street"); 
	   	 	String adress_city = request.getParameter("adress_city"); 
	   	 	String adress_state = request.getParameter("adress_state"); 
	   	 	String adress_zip_code = request.getParameter("adress_zip_code"); 
	   	 	String creditcard_information = request.getParameter("creditcard_information");
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, phone_number, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, creditcard_information);
		   	 				   	
		            userDAO.insert(users);
		         	response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
private void newRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	session = request.getSession();
	    	String RequestID = request.getParameter("requestID");
	    	String Status = request.getParameter("status");
	    	String Note = request.getParameter("note");
	    	String Email =  (String)session.getAttribute("username");
	    	String tree_distance = request.getParameter("tree_distance");
	    	String trunk_size = request.getParameter("trunk_size");
	    	String tree_height = request.getParameter("tree_height");
	    	String tree_location = request.getParameter("tree_location");
	    	//System.out.println(Email);
	    	System.out.println("data obtained.");
	    	request Request = new request(RequestID,Status,Note, Email);
	    	tree Tree = new tree(tree_distance,trunk_size, tree_height,tree_location);
	    	System.out.println("new request created");
	    	userDAO.insertRequest(Request);
	    	System.out.println("userDAO ran.");
	    	userPage(request, response, "");
	    }    
	    
private void newQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	//String RequestID = request.getParameter("selectedRequestID");
			String email = request.getParameter("selectedEmail");
	    	String QuoteID = request.getParameter("quoteID");
	    	String RequestStatus = request.getParameter("options");
	    	String Note = request.getParameter("note");
	    	String WorkPeriod = request.getParameter("workPeriod");
	    	String price = request.getParameter("price");
	    	String requestID = request.getParameter("selectedRequestID");
	    	System.out.println("data obtained.");
	    	System.out.println(QuoteID);
	    	userDAO.updateRequest(requestID,RequestStatus);
	    	quote Quote = new quote(QuoteID,"P","",Note, WorkPeriod,price,email);
	    	//Quote.setRequest(null);
	    	System.out.println("new quote created");
	    	userDAO.insertQuote(Quote);
	    	System.out.println("userDAO ran.");
	    	contractorPage(request,response,"");
	    	
	    } 
private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
private String randomIDGenerator() {
	System.out.println("Random started.");
	 Random random = new Random();
	 char[] letters = new char[2];
	 for (int i = 0; i<2;i++) {
	 Random random2 = new Random();
	 int limit = random2.nextInt(26);
	 String alphabets = "abcdefghijklmnopqrstuvwxyz";
	 char Character= alphabets.charAt(limit);
	 letters[i] = Character;
	 System.out.println(letters[i]);
	 }
	 String alpha = letters[0]+""+letters[1];
     String ID = alpha +Integer.toString(100000 + random.nextInt(900000));
     System.out.println(ID);
     return ID;
}
private void DirectToQuotePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	
	 String email = request.getParameter("selectedEmail");
	 String requestID = request.getParameter("selectedRequestID");
	 System.out.println(email);
	 
	 String QuoteID = randomIDGenerator();
     request.setAttribute("quoteID", QuoteID);
	 request.setAttribute("emailID", email);
	 request.setAttribute("requestID", requestID);
	 System.out.println("Re started");	
 	request.getRequestDispatcher("SendQuote.jsp").forward(request, response);
 	System.out.println("Re ended");

	    } 
private void ClientQuotePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String quoteID = request.getParameter("quoteID");
	 String status = request.getParameter("status");
	 String note = request.getParameter("note");
	 String work_period = request.getParameter("work_period");
	 String price = request.getParameter("price");
	 String user_note = request.getParameter("user_note");
	 request.setAttribute("quoteID", quoteID);
	 request.setAttribute("user_status", status);
	 request.setAttribute("note", note);
	 request.setAttribute("work_period", work_period);
	 request.setAttribute("price", price);
	 request.setAttribute("user_note", user_note);
	 System.out.println("Re started");	
	request.getRequestDispatcher("CheckQuote.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 

private void ContractorQuotePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String quoteID = request.getParameter("quoteID");
	 String Contractor_status = request.getParameter("Cstatus");
	 String Client_status = request.getParameter("Ustatus");
	 String Contractor_note = request.getParameter("note");
	 String work_period = request.getParameter("work_period");
	 String price = request.getParameter("price");
	 String user_note = request.getParameter("user_note");
	 request.setAttribute("quoteID", quoteID);
	 request.setAttribute("Contractor_status", Contractor_status);
	 request.setAttribute("user_status", Client_status);
	 request.setAttribute("Contractor_note", Contractor_note);
	 request.setAttribute("work_period", work_period);
	 request.setAttribute("price", price);
	 request.setAttribute("user_note", user_note);
	 System.out.println("Re started");	
	request.getRequestDispatcher("ContractorQuotePage.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 
private void checkQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String user_note = request.getParameter("note");
	 String status = request.getParameter("options");
	 String quoteID = request.getParameter("quoteID");
	 System.out.println(user_note);
	 System.out.println(status);
	 System.out.println(quoteID);
	
	 System.out.println("Re started");
	 
	 userDAO.modifyUserQuote(quoteID,user_note,status);
	 userPage(request, response, "");
	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 	   
private void SendToRequestPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 //System.out.println(email);
	 request.setAttribute("emailID", email);
	 
	 String requestID = randomIDGenerator();
	 request.setAttribute("requestID", requestID);
	 System.out.println("Re started");	
	request.getRequestDispatcher("ClientRequest.jsp").forward(request, response);
	System.out.println("Re ended");

	    }


private void ReviseQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String price = request.getParameter("price");
	 String Contractor_status = request.getParameter("options");
	 String Contractor_note = request.getParameter("Contractor_note");
	 String quoteID = request.getParameter("quoteID");
	 System.out.println(price);
	 System.out.println(Contractor_status);
	 System.out.println(quoteID);
	
	 System.out.println("Re started");
	 
	 userDAO.modifyContractorQuote(quoteID,Contractor_note,Contractor_status,price);
	 contractorPage(request, response, "");
	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }
	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    


