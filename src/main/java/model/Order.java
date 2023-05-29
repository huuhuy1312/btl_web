package model;

import java.util.List;
import java.util.Random;

public class Order {
	private Account customer;
	private List<Item> items;
	private int status;
	private long priceTotal;
	private double VAT;
	private double totalBill;
	private double shipFee;
	
	private Voucher voucher;
	
	public Voucher getVoucher() {
		return voucher;
	}
	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	public void setVAT(double vAT) {
		VAT = vAT;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public void setShipFee(double shipFee) {
		this.shipFee = shipFee;
	}
	public Order() {}
	public Account getCustomer() {
		return customer;
	}
	public void setCustomer(Account customer) {
		this.customer = customer;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
	public double getVAT() {
		return VAT;
	}
	
	public double getTotalBill() {
		return totalBill;
	}
	public void setShipFee(int t)
	{
		if(t ==0)
		{
			
			this.shipFee =0;
		}
		else {
			
		Random random = new Random();
        double number = random.nextDouble() * 9 + 1; 
        this.shipFee= Math.round(number * 1000.0) / 1000.0;
		}
		
	}
	public void setOtherBill() {
		
		this.VAT =  this.getPriceTotal()/10;
		this.totalBill = this.priceTotal + this.shipFee + this.VAT ;
		if(this.voucher!=null)
		{
			double redu = (double)this.getVoucher().getReducedMoney();
			this.totalBill-= this.getVoucher().getReducedMoney();
		}
		
	}
	public double getShipFee() {
		return shipFee;
	}
	
	public Order(Account customer, List<Item> items, int status, long priceTotal) {
		super();
		this.customer = customer;
		this.items = items;
		this.status = status;
		this.priceTotal = priceTotal;
		this.voucher = null;
	}
	
	
	
}
