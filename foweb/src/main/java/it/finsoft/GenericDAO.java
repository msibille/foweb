package it.finsoft;

import java.util.List;

public interface GenericDAO<T> {
	public void insert(T obj);
	
	public void update(T obj);
	
	public T findById(int Id);

	public List<T> findAll();

}
