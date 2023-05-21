package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ConnectToDataBase;
import model.Category;

public class CategoryDAO {
	public CategoryDAO()
	{
		
	}
	
	public List<Category> getAllCategory()
	{
		List<Category> list = new ArrayList<>();
		String query = "SELECT * FROM category";
		try {
			Connection conn = new ConnectToDataBase().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				list.add(new Category(
						rs.getInt(1),
						rs.getString(2)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[])
	{
		
		CategoryDAO  dao = new CategoryDAO();
		List<Category> list = new ArrayList<>();
		list = dao.getAllCategory();
		System.out.println(list);
	}
}

