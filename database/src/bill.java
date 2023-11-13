public class bill 
{
		protected String billID;
	 	protected String status;
	    protected String negotiation_note;
	    protected String final_price;
	 
	    //constructors
	    public bill() {
	    }
	 
	    public bill(String billID) 
	    {
	        this.billID = billID;
	    }
	    
	    public bill(String billID, String status, String negotiation_note, String final_price) 
	    {
	    	this(status,negotiation_note, final_price);
	    	this.billID = billID;
	    }
	 
	
	    public bill(String status, String negotiation_note, String final_price) 
	    {
	    	this.status = status;
	    	this.negotiation_note = negotiation_note;
	    	this.final_price = final_price;
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
	    
	    public String getNegotiation_note() {
	        return negotiation_note;
	    }
	    public void setNegotiation_note(String negotiation_note) {
	        this.negotiation_note = negotiation_note;
	    }
	        
	    	    
	    public String getFinal_price() {
	        return final_price;
	    }
	    public void setFinal_price(String final_price) {
	        this.final_price = final_price;
	    }
	}
