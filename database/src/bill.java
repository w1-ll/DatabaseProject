import java.util.Date;

public class bill 
{
		protected String billID;
	 	protected String status;
	    protected String user_note;
	    protected String contractor_note;
	    protected String email;

	    protected int amt_due;
	    protected int amt_paid;
	    protected int unique_tree_id;
		protected int date_counter;
		protected Date createdDate;


	 
	    //constructors
	    public bill() {
	    }
	 
	    public bill(String billID) 
	    {
	        this.billID = billID;
	    }
	    
	    public bill(String billID, String status, String user_note, String contractor_note, int amt_due,int amt_paid) 
	    {
	    	this(status,user_note,contractor_note, amt_due,amt_paid);
	    	this.billID = billID;
	    }
	 
	
	    public bill(String billID, String status, String user_note, String contractor_note, int amt_due,int amt_paid, int unique_tree_id) 
	    {
	    	this(status,user_note,contractor_note, amt_due,amt_paid);
	    	this.billID = billID;
	    	this.unique_tree_id = unique_tree_id;
	    }
	    public bill(String billID, String status, String user_note, String contractor_note, int amt_due,int amt_paid, int unique_tree_id,String email) 
	    {
	    	this(status,user_note,contractor_note, amt_due,amt_paid);
	    	this.billID = billID;
	    	this.unique_tree_id = unique_tree_id;
	    	this.email = email;

	    }
	    public bill(String billID, String status, String user_note, String contractor_note, int amt_due,int amt_paid, int unique_tree_id,String email, int counter) {
	    	this( billID,  status,  user_note, contractor_note, amt_due, amt_paid,  unique_tree_id, email);
	    	this.date_counter = counter;
	    }
	    public bill(String billID, String status, String user_note, String contractor_note, int amt_due,int amt_paid, int unique_tree_id,String email, int counter,Date createdDate) {
	    	this(billID,  status,  user_note, contractor_note, amt_due, amt_paid,  unique_tree_id, email,counter);
	    	this.createdDate = createdDate;
	    }
	    
	    public bill(String status, String user_note,String contractor_note, int amt_due,int amt_paid) 
	    {
	    	this.status = status;
	    	this.contractor_note = contractor_note;	    	
	    	this.user_note = user_note;
	    	this.amt_due = amt_due;
	    	this.amt_paid = amt_paid;

	    }
	    
	   //getter and setter methods
	    public String getBillID() {
	        return billID;
	    }
	    public void setBillID(String billID) {
	        this.billID = billID;
	    }
	    
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    
	    public String getContractor_note() {
	        return contractor_note;
	    }
	    public void setContractor_note(String contractor_note) {
	        this.contractor_note = contractor_note;
	    }
	    
	    public String getUser_note() {
	        return user_note;
	    }
	    public void setUser_note(String user_note) {
	        this.user_note = user_note;
	    }
	    public int getAmt_due() {
	        return amt_due;
	    }
	    public void setAmt_due(int amt_due) {
	        this.amt_due = amt_due;
	    }
	    
	    public int getAmt_paid() {
	        return amt_paid;
	    }
	    public void setAmt_paid(int amt_paid) {
	        this.amt_paid = amt_paid;
	    }
	    public int getUnique_tree_id() {
	        return unique_tree_id;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setDate_counter(int date_counter) {
	        this.date_counter = date_counter;
	    }
	    public int getDate_counter() {
	        return date_counter;
	    }
	    public Date getCreatedDate() {
	        return createdDate;
	    }
	}
