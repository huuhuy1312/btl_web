package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.ConnectToDataBase;
import model.Product;

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
public static void main(String arg[]) {
	DAO dao = new DAO();
	Product pro = new Product(); pro = dao.getProbyID("1");
	List<Product> list = new ArrayList<>();
	list = dao.searchProByName("msi");
	System.out.println(pro);
	Account acc = dao.login("admin", "123456");
	System.out.println(acc);
	dao.signup("huy2", "123456");
	System.out.println(dao.checkAccountExist("huy2"));
}
}

