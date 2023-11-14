
public class messages {
	protected String message_id;
	protected String sender_id;
	protected String recipient_id;
	protected String content;
	protected String timestamp;
	
	public messages() {
		
	}
	
	
	public messages(String sender_id, String recipient_id,String content, String timestamp) {
		this.sender_id=sender_id; 
		this.recipient_id=recipient_id;
		this.content=content;
		this.timestamp=timestamp;
	}
	
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMessage_id() {
		return message_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public String getRecipient_id() {
		return recipient_id;
	}
	public String getContent() {
		return content;
	}
	public String getTimestamp() {
		return timestamp;
	}
	
	

}
