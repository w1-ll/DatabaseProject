public class quote 
{
		protected String quoteID;
	 	protected String contractor_status;
	 	protected String user_status;
	    protected String negotiation_note;
	    protected String work_period;
	    protected String price;
	    protected String email;
	    protected String user_note;
	    protected int tree_id;
	    //constructors
	    public quote() {
	    }
	 
	    public quote(String quoteID) 
	    {
	        this.quoteID = quoteID;
	    }
	    
	    public quote(String quoteID, String status1, String status2, String negotiation_note,String work_period, String price,String email) 
	    {
	    	//contractor status = status1 user status = status2
	    	this(status1, status2, negotiation_note,work_period, price,email);
	    	this.quoteID = quoteID;
	    }
	 
	    public quote(String quoteID, String status1, String status2, String negotiation_note,String work_period, String price,String email, String user_note) 
	    {
	    	this(quoteID,status1, status2,negotiation_note,work_period,price,email);
	    	this.user_note = user_note;
	    }
	    
	    public quote(String quoteID, String status1, String status2, String negotiation_note,String work_period, String price,String email, String user_note,int tree_id) 
	    {
	    	this(quoteID,status1, status2,negotiation_note,work_period,price,email,user_note);
	    	this.tree_id = tree_id;
	    	System.out.println(this.tree_id);
	    }
	
	    public quote(String status1, String status2, String negotiation_note,String work_period, String price, String email) 
	    {
	    	this.email = email;
	    	contractor_status = status1;
	    	user_status = status2;
	    	this.negotiation_note = negotiation_note;
	    	this.work_period = work_period;
	    	this.price = price;
	    }
	    
	   //getter and setter methods
	    public String getQuoteID() {
	        return quoteID;
	    }
	    public void setQuoteID(String quoteID) {
	        this.quoteID = quoteID;
	    }
	    
	    public String getContractor_status() {
	        return contractor_status;
	    }
	    public void setContractor_status(String status) {
	        contractor_status = status;
	    }
	    
	    public String getUser_status() {
	        return user_status;
	    }
	    public void setUser_status(String status) {
	        user_status = status;
	    }
	    
	    public String getNegotiation_note() {
	        return negotiation_note;
	    }
	    public void setNegotiation_note(String negotiation_note) {
	        this.negotiation_note = negotiation_note;
	    }
	        
	    public String getWork_period() {
	        return work_period;
	    }
	    public void setWork_period(String work_period) {
	        this.work_period = work_period;
	    }
	    
	    public String getPrice() {
	        return price;
	    }
	    public void setPrice(String price) {
	        this.price = price;
	    }
	    public String getEmail() {
	    	return email;
	    }
	    public void setEmail(String email) {
	    	this.email = email;
	    }
	    
	    public String getUser_note() {
	    	return user_note;
	    }
	    public void setUser_note(String note) {
	    	this.user_note = note;
	    }
	    public int getTree_id() {
	    	return tree_id;
	    }
	    
	}
