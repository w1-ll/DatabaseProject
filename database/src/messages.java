import java.util.Date;

public class messages {
	protected int message_id;
	protected String sender;
	protected String recipient;
	protected String message_content;
	protected String time_stamp;
	protected String quoteID;
	protected String billID;

	
	public messages() {
		
	}
	public messages(int message_id, String sender,String recipient, String message_content, String time_stamp, String quoteID) {
		this.message_id = message_id;
		this.sender = sender;
		this.recipient = recipient;
		this.message_content = message_content;
		this.time_stamp = time_stamp;
		this.quoteID = quoteID;
	}
	public messages(String billID, int message_id, String sender,String recipient, String message_content, String time_stamp) {
		this.message_id = message_id;
		this.sender = sender;
		this.recipient = recipient;
		this.message_content = message_content;
		this.time_stamp = time_stamp;
		this.billID = billID;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSender() {
		return sender;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setTime_Stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	
	public String getQuoteID() {
		return quoteID;
	}
	public void setQuoteID(String quoteID) {
		this.quoteID = quoteID;
	}
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}

}
