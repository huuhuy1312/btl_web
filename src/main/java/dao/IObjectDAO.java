package dao;

public interface IObjectDAO {
	default boolean add(Object obj)
	{
		return false;
	}
	default boolean edit(Object obj)
	{
		return false;
	}
	default boolean del(String id)
	{
		return false;
	}
}
