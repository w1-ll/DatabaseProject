public class request 
{
		protected String email;
		protected String requestID;
	 	protected String status;
	    protected String note;
	    protected String tree_distance;
	    //protected tree Tree;
	 
	    //constructors
	    public request() {
	    }
	 
	    public request(String requestID) 
	    {
	        this.requestID = requestID;
	    }
	    
	    public request(String requestID, String status, String note, String email) 
	    {
	    	this(status,note,email);
	    	this.requestID = requestID;
	    	
	    }
	 
	
	    public request(String status, String note, String email) 
	    {
	    	this.status = status;
	    	this.note = note;
	    	this.email = email;
	    }
	    
	    public request(String requestID,String status) {
	    	this.requestID=requestID;
	    	this.status = status;
	    }
	   //getter and setter methods
	    public String getRequestID() {
	        return requestID;
	    }
	    public void setRequestID(String requestID) {
	        this.requestID = requestID;
	    }
	    
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    
	    public String getNote() {
	        return note;
	    }
	    public void setNote(String note) {
	        this.note = note;
	    }
	   
	    public void setEmail(String email) {
    	this.email = email;
    }
    public String getEmail() {
    	return email;
    }
	   
	}
