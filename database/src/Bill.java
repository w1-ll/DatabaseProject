
public class Bill {
	protected String bill_id;
	protected String initial_price;
	protected String price_bargain;
	protected String final_bill;
	
	public Bill() {
		
	}
	public Bill(String bill_id) {
		this.bill_id = bill_id;
	}
	public Bill (String bill_id, String initial_price, String price_bargain, String final_bill) {
		this(initial_price, price_bargain, final_bill);
		this.bill_id = bill_id;
	}
	public Bill (String initial_price, String price_bargain, String final_bill) {
		this.initial_price = initial_price;
		this.price_bargain = price_bargain;
		this.final_bill = final_bill;
	}
	public void setBillID(String bill_id) {
		this.bill_id = bill_id;
	}
	public void setIinitialPrice(String initial_price) {
		this.initial_price = initial_price;
	}
	public void setPriceBargain(String price_bargain) {
		this.price_bargain = price_bargain;
	}
	public void setFinalBill(String final_bill) {
		this.final_bill = final_bill;
	}
	public String getBillId() {
		return bill_id;
	}
	public String getIinitialPrice() {
		return initial_price;
	}
	public String PriceBargain() {
		return price_bargain;
	}
	public String getFinalBill() {
		return final_bill;
	}
	

}
