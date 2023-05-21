package model;

import java.util.List;

public class Order {
	private int id;
	private Account customer;
	private List<Item> items;
	private int status;
	public Order(Account customer, List<Item> items, int status) {
		super();
		this.customer = customer;
		this.items = items;
		this.status = status;
	}
	public Order() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
}
