public class quote 
{
		protected String quoteID;
	 	protected String status;
	    protected String negotiation_note;
	    protected String work_period;
	    protected String price;
	 
	    //constructors
	    public quote() {
	    }
	 
	    public quote(String quoteID) 
	    {
	        this.quoteID = quoteID;
	    }
	    
	    public quote(String quoteID, String status, String negotiation_note,String work_period, String price) 
	    {
	    	this(status,negotiation_note,work_period, price);
	    	this.quoteID = quoteID;
	    }
	 
	
	    public quote(String status, String negotiation_note,String work_period, String price) 
	    {
	    	this.status = status;
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
	    
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
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
	        return quoteID;
	    }
	    public void setPrice(String price) {
	        this.price = price;
	    }
	}
