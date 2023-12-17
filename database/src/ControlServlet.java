import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        	 case "/CheckOrder":
        		 System.out.println("check order initiated.");
        		 CheckOrder(request,response);
        		 break;
        	 case "/ClientOrderPage":
        		 System.out.println("client order page initiated.");
        		 ClientOrderPage(request,response);
        		 break;
        	 case "/ChangeFinishDate":
        		 System.out.println("change finish date initiated.");
        		 ChangeFinishDate(request,response);
        		 break;
        	 case "/goToContractorFromOrders":
        		 System.out.println("go to contractor page from check order initiated.");
        		 contractorPage(request,response,"");
        		 break;
        	 case "/newBill":
        		 System.out.println("New bill initiated.");
        		 newBill(request, response);
        		 break;
        	 case "/CheckBill":
        		 System.out.println("New bill initiated.");
        		 CheckBill(request, response);
        		 break;
        	 case "/ClientBillPage":
        		 System.out.println("Client Bill Page initiated.");
        		 ClientBillPage(request, response);
        		 break;
        	 case "/reviseBill":
        		 System.out.println("Client Bill Page initiated.");
        		 ReviseBill(request, response);
        		 break;
        	 case "/payment":
        		 System.out.println("Client Bill Page initiated.");
        		 ClientPayment(request, response);
        		 break;
        	 case "/finishPayment":
        		 System.out.println("Client Bill Page initiated.");
        		 ClientFinishPayment(request, response);
        		 break;
        	 case "/clientBillQueries":
        		 System.out.println("Client Bill Page initiated.");
        		 ClientBillQueries(request, response);
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
			//userDAO.updateAllBillCounter();
			request.setAttribute("Requests", userDAO.listAllRequests());
			request.setAttribute("Quotes", userDAO.listAllQuotes());
			request.setAttribute("Trees", userDAO.listAllTrees());

			request.setAttribute("Orders", userDAO.listAllOrders());
			request.setAttribute("BigClients", userDAO.listBigClients());
			request.setAttribute("SingleTrees", userDAO.listSingleTree());
			request.setAttribute("ProspectiveClients", userDAO.listProspectiveClients());
			request.setAttribute("EasyClients", userDAO.listEasyClients());
			request.setAttribute("HighestTree", userDAO.listHighestTree());
			request.setAttribute("BadClients", userDAO.listBadClients());
			request.setAttribute("GoodClients", userDAO.listGoodClients());
			request.setAttribute("Statistics", userDAO.listStatistics());


			List<bill> lb = userDAO.listAllBills();

			request.setAttribute("Bills", userDAO.listAllBills());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void contractorPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("contractor view");
	    	request.setAttribute("Requests", userDAO.listAllRequestsForContractor());
	    	request.setAttribute("Quotes", userDAO.listAllQuotesForContractor());
	    	request.setAttribute("Orders", userDAO.listAllOrders());
	    	request.setAttribute("RejectedQuotes", userDAO.listAllRejectedQuotes());
	    	request.setAttribute("RejectedRequests", userDAO.listAllRejectedRequests());
	    	request.setAttribute("SuccessfulRequests", userDAO.listAllSuccessfulRequests());
	    	request.setAttribute("SuccessfulQuotes", userDAO.listAllSuccessfulQuotes());
	    	request.setAttribute("Bills", userDAO.listAllBills());

	    	request.getRequestDispatcher("contractor.jsp").forward(request, response);

	    }
	    private void userPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	 System.out.println("userPage started");
	    	 //String email = request.getParameter("email");
	    	 session = request.getSession();
	    	 String email = (String)session.getAttribute("username");
	    	 request.setAttribute("specificRequest",userDAO.listSpecificRequests(email));
			 request.setAttribute("specificQuote", userDAO.listSpecificQuote(email));
			 request.setAttribute("specificOrder", userDAO.listSpecificOrder(email));
			 request.setAttribute("specificBill", userDAO.listSpecificBill(email));

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
	    	int counter = Integer.parseInt(request.getParameter("addTreeCounter"));
	    	//System.out.println("Whats wrong?");
	    	System.out.println("Count: "+counter);
	    	int tree_distance = 0,trunk_size = 0, tree_height = 0,tree_location=0;
	    	request Request = new request(RequestID,Status,Note, Email);
	    	userDAO.insertRequest(Request);
	    	int number = userDAO.getRequest(RequestID).getUnique_tree_id();
	    	System.out.println(number);
	    	//TreeIdentifier newIdentifier = new TreeIdentifier(Request.getUnique_tree_id());
	    	for (int i = 0;i<counter;i++) {
	    		tree_distance = Integer.parseInt(request.getParameter("TreeDistance"+(i+1)));
		    	trunk_size = Integer.parseInt(request.getParameter("TrunkSize"+(i+1)));
		    	tree_height = Integer.parseInt(request.getParameter("TreeHeight"+(i+1)));
		    	tree_location = Integer.parseInt(request.getParameter("TreeLocation"+(i+1)));
		    	System.out.println("Tree dist.: "+tree_distance);
		    	System.out.println("Tree size: "+trunk_size);
		    	System.out.println("Tree height: "+tree_height);
		    	System.out.println("Tree location: "+tree_location);
		    	tree Tree = new tree(tree_distance,trunk_size, tree_height,tree_location);
		    	int tree_id = userDAO.insertTree(Tree);
		    	System.out.println("Issue1?");
		    	TreeIdentifier newIdentifier = new TreeIdentifier(userDAO.getRequest(RequestID).getUnique_tree_id());
		    	System.out.println("Issue2?");
		    	newIdentifier.setTree_ids(tree_id);
		    	System.out.println("Issue3?");
		    	userDAO.insertTreeIdentifier(newIdentifier);
		    	System.out.println("Issue4?");

	    	}
	    	userPage(request, response, "");	

//	    	SELECT users.user_id, username, order_id, order_date
//	    	FROM users
//	    	INNER JOIN orders ON users.user_id = orders.user_id;
	    }    
	    
private void newQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	//String RequestID = request.getParameter("selectedRequestID");
			String email = request.getParameter("selectedEmail");
	    	String QuoteID = request.getParameter("quoteID");
	    	String RequestStatus = request.getParameter("options");
	    	String Note = request.getParameter("note");
	    	String WorkPeriod = request.getParameter("workPeriod");
	    	int price = Integer.parseInt(request.getParameter("price"));
	    	String requestID = request.getParameter("selectedRequestID");
	    	String user_note = request.getParameter("user_note");
	    	request tempReq = userDAO.getRequest(requestID);
	    	
	    	int unique_tree_id = tempReq.getUnique_tree_id();;
	    	
	    	System.out.println("data obtained.");
	    	System.out.println(unique_tree_id);
	    	userDAO.updateRequest(requestID,RequestStatus);
	    	if (RequestStatus.equals("S")) {
	    		quote Quote = new quote(QuoteID,"P","P",Note, WorkPeriod,price,email,user_note,unique_tree_id);
	    	//Quote.setRequest(null);
	    		System.out.println(Quote.getUnique_tree_id());
	    		System.out.println("new quote created");
	    		userDAO.insertQuote(Quote);
	    	}
	    	System.out.println("userDAO ran.");
	    	contractorPage(request,response,"");
	    	
	    } 


private void newBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	System.out.println("Started");
	String billID = randomIDGenerator();
	String status = "P";
	String user_note = "",contractor_note = "";
	String orderID = request.getParameter("orderID");
	System.out.println("1");
	String email = request.getParameter("email");
	orders tempOrder = userDAO.getOrder(orderID);
	System.out.println("2");

	int unique_treeID = tempOrder.getUnique_tree_id();
	System.out.println("3");

	int amt_due = userDAO.getQuotePriceFromUniqueTreeID(unique_treeID);

	userDAO.updateOrder(orderID,"S");
    Date billCreationDate = new Date();

	bill Bills = new bill(billID,status,user_note,contractor_note,amt_due,0,unique_treeID,email,0,billCreationDate);
	userDAO.insertBill(Bills);
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
	 request re = userDAO.getRequest(requestID);
	 List<tree> specificTrees = userDAO.listSpecificTrees(re.getUnique_tree_id());
	 System.out.println("Specific Trees: " + specificTrees); // Debug output
	 //request.setAttribute("SpecificTrees", specificTrees);

	 request.setAttribute("SpecificTrees", specificTrees);


	 request.setAttribute("user_note", re.getNote());
	 System.out.println("Re started");	
	 request.getRequestDispatcher("SendQuote.jsp").forward(request, response);
 	System.out.println("Re ended");

	    } 
private void ClientQuotePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String quoteID = request.getParameter("quoteID");
	 quote sample = userDAO.getQuote(quoteID);
	 String user_status = sample.getUser_status();
	 String note = sample.getNegotiation_note();
	 String work_period = sample.getWork_period();
	 int price = sample.getPrice();
	 String user_note = sample.getUser_note();
	 tree sampleT = userDAO.getTree(sample.getUnique_tree_id());
	 request.setAttribute("quoteID", quoteID);
	 request.setAttribute("user_status", user_status);
	 request.setAttribute("note", note);
	 request.setAttribute("work_period", work_period);
	 request.setAttribute("price", price);
	 request.setAttribute("user_note", user_note);
	 List<tree> specificTrees = userDAO.listSpecificTrees(sample.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", specificTrees);
	 request.setAttribute("SpecificMessages", userDAO.listSpecificMessages(quoteID));

	 System.out.println("Re started");	
	request.getRequestDispatcher("CheckQuote.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 

private void ContractorQuotePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started");

	 String quoteID = request.getParameter("quoteID");

	 quote sample = userDAO.getQuote(quoteID);
	 String email = sample.getEmail();

	 String Contractor_status = sample.getContractor_status();
	 String user_status = sample.getUser_status();

	 String note = sample.getNegotiation_note();
	 String work_period = sample.getWork_period();

	 int price = sample.getPrice();

	 System.out.println("Tree ID 1st print :" + (sample.getUnique_tree_id()));
	 String user_note = sample.getUser_note();
	 tree sampleT = userDAO.getTree(sample.getUnique_tree_id());
	 //System.out.println("Tree ID 1st print :" + (sampleT.getTree_id()));

	 request.setAttribute("email", email);
	 request.setAttribute("quoteID", quoteID);
	 request.setAttribute("Contractor_status", Contractor_status);
	 request.setAttribute("user_status", user_status);
	 request.setAttribute("Contractor_note", note);
	 request.setAttribute("work_period", work_period);
	 request.setAttribute("price", price);
	 request.setAttribute("user_note", user_note);
	 
	 List<tree> specificTrees = userDAO.listSpecificTrees(sample.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", specificTrees);
	 request.setAttribute("SpecificMessages", userDAO.listSpecificMessages(quoteID));
	 
	 System.out.println("Re started");	
	request.getRequestDispatcher("ContractorQuotePage.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 
private void checkQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	 String user_note = request.getParameter("note");
	 String status = request.getParameter("options");
	 String quoteID = request.getParameter("quoteID");
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 System.out.println(user_note);
	 System.out.println(status);
	 System.out.println(quoteID);
	 userDAO.insertMessagesForClient(quoteID, email, user_note);
	 List<messages> specificMessages = userDAO.listSpecificMessages(quoteID);

	 
	 System.out.println("Re started");
	 System.out.println("Size: "+specificMessages.size());
	 userDAO.modifyUserQuote(quoteID,user_note,status);
	 if ((specificMessages.size() == 1)&& (status.equals("S"))) {
		 System.out.println("negstatus function ran.");
		 userDAO.modifyUserQuoteForNegotiationStatus(quoteID);
	 }
	 userPage(request, response, "");
	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 	   
private void SendToRequestPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 //System.out.println(email);
	 request.setAttribute("emailID", email);
	 System.out.println("order email " +email);
	 String requestID = randomIDGenerator();
	 request.setAttribute("requestID", requestID);
	 System.out.println("Re started");	
	request.getRequestDispatcher("ClientRequest.jsp").forward(request, response);
	System.out.println("Re ended");

	    }


private void ReviseQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started.");
	//int tree_id = Integer.parseInt(request.getParameter("tree_id"));
	 String email = request.getParameter("email");

	 String price1 = request.getParameter("price");
	 String price2 = request.getParameter("price2");

	 String Contractor_status = request.getParameter("options");
	 String user_status = request.getParameter("user_status");

	 String Contractor_note = request.getParameter("Contractor_note");
	 String quoteID = request.getParameter("quoteID");
	 quote sample = userDAO.getQuote(quoteID);
	 System.out.println("data:");
	 System.out.println("Price1: "+price1);
	 System.out.println("Price2: "+price2);
	 System.out.println(Contractor_status);
	 System.out.println(quoteID);
	 //System.out.println(tree_id);
	 

	 if (!(user_status.equals("S") || user_status.equals("R")) ) Contractor_status = "P";
	 //Create a new Order
	 if (Contractor_status.equals("S") && user_status.equals("S")) {
		 orders Order = new orders(email,randomIDGenerator(),"P", sample.getUnique_tree_id());
		 userDAO.insertOrder(Order);
		 System.out.println("Order inserted.");
	 }
	 
	 System.out.println("Re started");
	 String newP = (price2 == "")? price1:price2;

	 userDAO.modifyContractorQuote(quoteID,Contractor_note,Contractor_status,newP);
	 userDAO.insertMessagesForClient(quoteID, email, Contractor_note);
	 contractorPage(request, response, "");
	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }
	     
@SuppressWarnings("deprecation")
private void CheckOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started");
	 String orderID = request.getParameter("orderID");
	 String status = request.getParameter("status");
	 String email = request.getParameter("email");
	 orders newOrder = userDAO.getOrder(orderID);
	 List<tree>SpecificTrees = userDAO.listSpecificTrees(newOrder.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", SpecificTrees);

	 request.setAttribute("orderID", orderID);
	 request.setAttribute("status", status);
	 request.setAttribute("email", email);
	 if (newOrder.getFinish_date()!=new Date(100,9,1)) {
		request.setAttribute("finish_date", newOrder.getFinish_date()); 
	 }else {
		request.setAttribute("finish_date", null); 

	 }

	 request.getRequestDispatcher("CheckOrder.jsp").forward(request, response);


	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }

private void ClientOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 String orderID = request.getParameter("orderID");
	 String status = request.getParameter("status");
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 orders newOrder = userDAO.getOrder(orderID);
	 List<tree>SpecificTrees = userDAO.listSpecificTrees(newOrder.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", SpecificTrees);
	 request.setAttribute("orderID", orderID);
	 request.setAttribute("status", status);
	 request.setAttribute("finish_date", newOrder.getFinish_date());
	 System.out.println(newOrder.getFinish_date());

	 request.getRequestDispatcher("ClientOrderPage.jsp").forward(request, response);


	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }


@SuppressWarnings("deprecation")
private void ChangeFinishDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started");
	 String firstInput = request.getParameter("changeFinishDate");
	 String orderID = request.getParameter("orderID");
	 String status = request.getParameter("status");
	 String email = request.getParameter("email");
	 Date finishDate = new Date();
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(finishDate);
	 System.out.println("slice began");

	 int day = Integer.parseInt(firstInput.substring(8,10));
	 int month = Integer.parseInt(firstInput.substring(5,7))-1;
	 int year = Integer.parseInt(firstInput.substring(0,4));
	 System.out.println("slice end");

	 
	 cal.set(Calendar.DAY_OF_MONTH, day); // Set the day of the month
	 cal.set(Calendar.YEAR, year); // Set the year
	 cal.set(Calendar.MONTH, month); // Set the month (Note: Months are zero-based in Java)
	 finishDate = cal.getTime();
	 userDAO.modifyOrderFinalDate(orderID, finishDate);
	 System.out.println(finishDate.toString());
	 
	 orders newOrder = userDAO.getOrder(orderID);
	 List<tree>SpecificTrees = userDAO.listSpecificTrees(newOrder.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", SpecificTrees);
	 
	 request.setAttribute("orderID", orderID);
	 request.setAttribute("status", status);
	 request.setAttribute("email", email);
	 if (newOrder.getFinish_date()!=new Date(100,9,1)) {
		request.setAttribute("finish_date", newOrder.getFinish_date()); 
	 }else {
		request.setAttribute("finish_date", null); 

	 }

	 request.getRequestDispatcher("CheckOrder.jsp").forward(request, response);

	System.out.println("Re ended");
	 
	 request.getRequestDispatcher("CheckOrder.jsp").forward(request, response);
	    }

private void newMessageInsertion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 String orderID = request.getParameter("orderID");
	 String status = request.getParameter("status");
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 orders newOrder = userDAO.getOrder(orderID);
	 List<tree>SpecificTrees = userDAO.listSpecificTrees(newOrder.getUnique_tree_id());
	 request.setAttribute("SpecificTrees", SpecificTrees);
	 request.setAttribute("orderID", orderID);
	 request.setAttribute("status", status);
	 request.setAttribute("finish_date", newOrder.getFinish_date());
	 System.out.println(newOrder.getFinish_date());

	 request.getRequestDispatcher("ClientOrderPage.jsp").forward(request, response);


	//request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }

private void CheckBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	System.out.println("Started");
	 String billID = request.getParameter("billID");
	 String status = request.getParameter("status");
	 String user_note = request.getParameter("user_note");
	 String contractor_note = request.getParameter("contractor_note");
	 
	 String email =request.getParameter("email");
	 int amt_due = Integer.parseInt(request.getParameter("amt_due"));
	 int amt_paid = Integer.parseInt(request.getParameter("amt_paid"));
	 int unique_tree_id = Integer.parseInt(request.getParameter("unique_tree_id"));
	 request.setAttribute("billID", billID);
	 request.setAttribute("status", status);
	 request.setAttribute("user_note", user_note);
	 request.setAttribute("contractor_note", contractor_note);
	 request.setAttribute("amt_due", amt_due);
	 request.setAttribute("amt_paid", amt_paid);

		List<tree>SpecificTrees = userDAO.listSpecificTrees(unique_tree_id);
		 request.setAttribute("SpecificTrees", SpecificTrees);
		 request.setAttribute("SpecificMessages", userDAO.listSpecificMessagesFromBillID(billID));


	request.getRequestDispatcher("ContractorBillPage.jsp").forward(request, response);
	System.out.println("Re ended");

	    } 
private void ClientBillPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	System.out.println("Started");
	 String billID = request.getParameter("billID");
	 String status = request.getParameter("status");
	 String user_note = request.getParameter("user_note");
	 String contractor_note = request.getParameter("contractor_note");

	 int amt_due = Integer.parseInt(request.getParameter("amt_due"));
	 int amt_paid = Integer.parseInt(request.getParameter("amt_paid"));
	 int unique_tree_id = Integer.parseInt(request.getParameter("unique_tree_id"));
	 request.setAttribute("billID", billID);
	 request.setAttribute("status", status);
	 request.setAttribute("user_note", user_note);
	 request.setAttribute("contractor_note", contractor_note);
	 request.setAttribute("amt_due", amt_due);
	 request.setAttribute("amt_paid", amt_paid);

		List<tree>SpecificTrees = userDAO.listSpecificTrees(unique_tree_id);
		 request.setAttribute("SpecificTrees", SpecificTrees);

		 request.setAttribute("SpecificMessages", userDAO.listSpecificMessagesFromBillID(billID));

	request.getRequestDispatcher("ClientBillPage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }

private void ReviseBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started.");
	 String billID = request.getParameter("billID");
	 int amt_due = Integer.parseInt(request.getParameter("amt_due"));
	 int amt_paid = Integer.parseInt(request.getParameter("amt_paid"));
	 bill nBill = userDAO.getBill(billID);
	 String email = nBill.getEmail();
	 int unique_tree_id = nBill.getUnique_tree_id();
	 int total_price = userDAO.getQuotePriceFromUniqueTreeID(unique_tree_id);
	 String user_note = request.getParameter("user_note");
	 String temp_status = request.getParameter("options");

	 String contractor_note = request.getParameter("contractor_note");
	 
	 int price2 = Integer.parseInt(request.getParameter("price2"));
	 if (price2 != 0) {
			 amt_due += price2;}
	 if (temp_status.equals("S")) {
	 userDAO.modifyBill(billID,contractor_note,amt_due);
	 userDAO.insertMessagesForContractorUsingBillID(billID, email, contractor_note);
	 }
	
	 System.out.println("Re started");
	 //String newP = (price2 == "")? price1:price2;

	 contractorPage(request, response, "");
	System.out.println("Re ended");

	    }

private void ClientPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started.");
	 String billID = request.getParameter("billID");
	 int amt_due = Integer.parseInt(request.getParameter("amt_due"));
	 int amt_paid = Integer.parseInt(request.getParameter("amt_paid"));
	 
	 session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 request.setAttribute("billID", billID);
	 request.setAttribute("amt_due", amt_due);
	 request.setAttribute("amt_paid", amt_paid);
	 request.setAttribute("email", email);

		request.getRequestDispatcher("ClientPaymentPortal.jsp").forward(request, response);
	System.out.println("Re ended");

	    }

private void ClientFinishPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started.");
	 String status = "P";

	 String billID = request.getParameter("billID");

	 int amt_due = Integer.parseInt(request.getParameter("amt_due"));

	 int amt_paid = Integer.parseInt(request.getParameter("amt_paid"));
	 int payment = Integer.parseInt(request.getParameter("payment"));
	 amt_due = amt_due - payment;
	 amt_paid = amt_paid +payment;
	 String email = request.getParameter("email");
	 int diff = (amt_due-amt_paid);
	 if (diff == 0) status = "S";
	 
	 userDAO.updateBill(billID, status, amt_due, amt_paid);
	 
	 bill nBill = userDAO.getBill(billID);
	 String user_note = nBill.getUser_note();
	 String contractor_note = nBill.getContractor_note();
	 int unique_tree_id = nBill.getUnique_tree_id();
	 request.setAttribute("billID",billID);
	 request.setAttribute("status", status);
	 request.setAttribute("user_note", user_note);
	 request.setAttribute("contractor_note", contractor_note);
	 request.setAttribute("amt_due", amt_due);
	 request.setAttribute("amt_paid", amt_paid);
	 
	 List<tree>SpecificTrees = userDAO.listSpecificTrees(unique_tree_id);
	 request.setAttribute("SpecificTrees", SpecificTrees);

	 request.setAttribute("SpecificMessages", userDAO.listSpecificMessagesFromBillID(billID));


		request.getRequestDispatcher("ClientBillPage.jsp").forward(request, response);
	System.out.println("Re ended");

	    }

private void ClientBillQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 System.out.println("Started.");
	String note = request.getParameter("note");
	session = request.getSession();
	 String email = (String)session.getAttribute("username");
	 String billID = request.getParameter("billID");
	 userDAO.insertMessagesForClientUsingBillID(billID, email, note);
	 bill nBill = userDAO.getBill(billID);
	 nBill.setUser_note(note);
	 userPage(request, response, "");
	System.out.println("Re ended");

	    }

	        
	    
}
	        
	        
	    
	        
	        
	        
	    


