package fr.formation.daObsolete;

import java.util.List;

public interface IDAO<T,K> {

	
	public void insert(T t);
	
	public T selectById(K id);
	
	public List<T> selectAll();
	
	public void update(T t);
	
	public void delete(K id);
	
}
