import java.util.Date;
public class orders {
		protected String email;
		protected String orderID;
		protected String status;
		protected int tree_id;
		protected Date finish_date;
		
		public orders(){
			
		}
		public orders(String email,String orderID,String status){
			this.orderID = orderID;
			this.status = status;
			this.email = email;
		}
		public orders(String email,String orderID,String status,int tree_id){
			this(email,orderID,status);
			this.tree_id = tree_id;
			
		}
		public orders(String email,String orderID,String status,Date finish_date){
			this(email,orderID,status);
			this.finish_date = finish_date;
			
		}
		public orders(String email,String orderID,String status,int tree_id,Date finish_date){
			this(email,orderID,status,tree_id);
			this.finish_date = finish_date;
			
		}
		
		
		
		public String getOrderID() {
			return orderID;
		}
		public void setOrderID(String orderID) {
			this.orderID = orderID;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getTree_id() {
			return tree_id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getFinish_date() {
			return finish_date;
		}
		public void setFinish_date(Date finish_date) {
			this.finish_date = finish_date;
		}
}
