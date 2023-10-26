public class request 
{
		protected String requestID;
	 	protected String status;
	    protected String note;
	   
	 
	    //constructors
	    public request() {
	    }
	 
	    public request(String requestID) 
	    {
	        this.requestID = requestID;
	    }
	    
	    public request(String requestID, String status, String note) 
	    {
	    	this(status,note);
	    	this.requestID = requestID;
	    }
	 
	
	    public request(String status, String note) 
	    {
	    	this.status = status;
	    	this.note = note;
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
	        
	   
	}
