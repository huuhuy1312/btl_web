package model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class Order {
	private int oid;
	private String tenNguoiMua;
	private Timestamp thoigiandat;
	private int uid;
	private String status;
	private long priceTotal;
	private double VAT;
	private double totalBill;
	private double shipFee;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getTenNguoiMua() {
		return tenNguoiMua;
	}
	public void setTenNguoiMua(String tenNguoiMua) {
		this.tenNguoiMua = tenNguoiMua;
	}
	public Timestamp getThoigiandat() {
		return thoigiandat;
	}
	public void setThoigiandat(Timestamp thoigiandat) {
		this.thoigiandat = thoigiandat;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private Account customer;
	private List<Item> items;
	private String listitem;
	public String getListitem() {
		return listitem;
	}
	public void setListitem(String listitem) {
		this.listitem = listitem;
	}
	private int soLuongSanPham;
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	
	public Order(Account customer, List<Item> items, String status, long priceTotal) {
		super();
		this.customer = customer;
		this.items = items;
		this.status = status;
		this.priceTotal = priceTotal;
		this.voucher = null;
	}
	
	
	
}
