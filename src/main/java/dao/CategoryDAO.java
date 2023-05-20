package dao;

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
		try {
			ResultSet rs = new ConnectToDataBase().selectData("SELECT * FROM category");
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
}
