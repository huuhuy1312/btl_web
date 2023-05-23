package model;

public class Voucher {
	private int id;
	private int reducedMoney;
	private int conditionMoney;
	private int status;
	private String name;
	private int IdUser;
	

	public Voucher(int id, int reducedMoney, int conditionMoney, int status, String name) {
		super();
		this.id = id;
		this.reducedMoney = reducedMoney;
		this.conditionMoney = conditionMoney;
		this.status = status;
		this.name = name;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getReducedMoney() {
		return reducedMoney;
	}


	public void setReducedMoney(int reducedMoney) {
		this.reducedMoney = reducedMoney;
	}


	public int getConditionMoney() {
		return conditionMoney;
	}


	public void setConditionMoney(int conditionMoney) {
		this.conditionMoney = conditionMoney;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIdUser() {
		return IdUser;
	}


	public void setIdUser(int idUser) {
		IdUser = idUser;
	}


	public Voucher() {}
}
