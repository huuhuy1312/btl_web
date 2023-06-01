package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.ConnectToDataBase;
import model.Item;
import model.Order;
import model.Product;
import model.Voucher;

public class DAO 
{

	public DAO()
	{
		
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> list = new ArrayList<>();
		try {
			ResultSet rs = new ConnectToDataBase().selectData("SELECT * FROM product");
			while(rs.next())
			{
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return list;
	}
	public Product getLastProduct()
	{
		Product lastProduct = new Product();
		try {
			ResultSet rs = new ConnectToDataBase().selectData("SELECT * FROM product order by id desc Limit 1");
			while(rs.next())
			{
			lastProduct = new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6));
			}
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lastProduct;
	}
	public List<Product> getProbyCid(String cid)
	{
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n"
				+"where cateID =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,cid);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return list;
	}
	public Product getProbyID(String id)
	{
		String query = "select * from product \n"
				+"where id =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return null;
	}
	public List<Product> searchProByName(String txtSearch)
	{
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n"
				+"where name like ?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,"%"+txtSearch+"%");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Account login(String user, String pass)
	{
		String query = "select * from account\n"
				+"where username = ?\n"
				+"and password = ?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					return new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
			
		
	}
	public Account checkAccountExist(String user)
	{
		String query = "select * from account\n"
				+"where username = ?\n";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					return new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
			
		
	}
	public void signup(String user, String pass)
	{
		String query = "insert into account(username, password, isSell, isAdmin)\n"
					+"values(?,?,0,0)";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<Product> getProbySellId(int sid)
	{
		List<Product> list = new ArrayList<>();
		String query = "select * from product \n"
				+"where sellID =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,sid);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getLong(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return list;
	}
	public void deleteProduct(String pid)
	{
		String query = "delete from product\n"
				+"where id = ?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,pid);
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insertProduct(String name,String image, String price, String title, String description, String category,int sid)
	{
		String query = "INSERT INTO product (name, image, price, title,description,cateID,sellID)\n"
				+"values(?,?,?,?,?,?,?);";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,image);
			ps.setString(3,price);
			ps.setString(4,title);
			ps.setString(5,description);
			ps.setString(6,category);
			ps.setInt(7,sid);
			ps.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public void editProduct(String name,String image, String price, String title, String description, String category,String pid)
	{
		String query = "update product\n" + 
				"set name = ?,\n" + 
				"image = ?,\n" + 
				"price = ?,\n" + 
				"title = ?,\r\n" + 
				"description = ?,\r\n" + 
				"cateID = ?\n" 
				+ "where id =?;";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,image);
			ps.setString(3,price);
			ps.setString(4,title);
			ps.setString(5,description);
			ps.setString(6,category);
			ps.setString(7,pid);
			ps.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public void addToCart(int soLuong)
	{
		String query = "insert into Sorder(soLuong)\r\n" + 
				"values (?);";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,soLuong);
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<Voucher> getListVoucherByIDUser(int id)
	{
		List<Voucher> list = new ArrayList<>();
		String query = "Select * from voucher\n"
				+ "where idUser = ?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				list.add(new Voucher(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return list;
		
	}
	public Voucher getVoucherById(int id)
	{
		String query = "select * from voucher \n"
				+"where id =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
			return new Voucher(rs.getInt(1),
					rs.getInt(2),
					rs.getInt(3),
					rs.getInt(4),
					rs.getString(5));
			}
			
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return null;
	}
	public void addOrder(Order order, Timestamp timestamp, int uid)
	{
		String query =  "insert into sorder(tenNguoiMua,thoiGianDatHang,soLuongSanPham,danhSachSanPham,tongTien,trangthai,uid)\r\n" + 
				"values(?,?,?,?,?,?,?);";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,order.getCustomer().getUser());
			ps.setTimestamp(2,timestamp);
			int count = 0;
			String dssp=  "";
			List<Item> items = order.getItems();
			for(Item item: items)
			{
				count+=item.getQuantity();
				dssp+=item.getProduct().getId()+"("+item.getQuantity()+"),";
			}
			dssp =dssp.substring(0, dssp.length() - 1);
			ps.setInt(3, count);
			ps.setString(4,dssp);
			ps.setDouble(5,order.getTotalBill());
			ps.setString(6, "Chưa Thanh Toán");
			ps.setInt(7, uid);
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			
		}
	}
	public List<Order> getListOrderById(int uid, Account acc)
	{
		List<Order> list = new ArrayList<>();
		String query = "select * from sorder \n"
				+"where uid =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setOid(rs.getInt(1));
				order.setTenNguoiMua(rs.getString(2));
				order.setThoigiandat(rs.getTimestamp(3));
				order.setSoLuongSanPham(rs.getInt(4));
				
				order.setListitem(rs.getString(5));
				order.setTotalBill(rs.getDouble(6));
				order.setStatus(rs.getString(7));
				order.setUid(rs.getInt(8));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return null;
	}
	public Order getOrderById(int oid)
	{
		
		String query = "select * from sorder \n"
				+"where oid =?";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, oid);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setOid(rs.getInt(1));
				order.setTenNguoiMua(rs.getString(2));
				order.setThoigiandat(rs.getTimestamp(3));
				order.setSoLuongSanPham(rs.getInt(4));
				order.setListitem(rs.getString(5));
				order.setTotalBill(rs.getDouble(6));
				order.setStatus(rs.getString(7));
				order.setUid(rs.getInt(8));
				return order;
			}
			
		} catch (Exception e) {
			System.out.println("ko chay");
			e.printStackTrace();
		}
		return null;
	}
	public void editOrderByID(String oid)
	{
		String query = "update sorder\n" + 
				"set trangthai = ?\n" 
				+ "where oid =?;";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,"Đã Thanh Toán");
			ps.setString(2,oid);
			ps.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	
public static void main(String arg[]) {
	DAO dao = new DAO();
//	Product pro = new Product(); pro = dao.getProbyID("1");
//	List<Product> list = new ArrayList<>();
//	list = dao.getAllProduct();
//	dao.addToCart(10);
	List<Voucher> listVoucher = new ArrayList<>();
	listVoucher = dao.getListVoucherByIDUser(3);
	
//	List<Order> listOrder = new ArrayList<>();
//	listOrder = dao.getListOrderById(3);
//	System.out.print(listOrder);
	dao.editOrderByID("2");
	System.out.print(dao.getOrderById(1));
}
}

