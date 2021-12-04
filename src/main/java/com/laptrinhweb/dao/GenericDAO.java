package com.laptrinhweb.dao;

import java.util.List;

public interface GenericDAO<T> {
	List<T> query(String sql,Object... params);
	T insert(T obj);
	void update(T obj);
	T findOneById(Class<T> tClass,Long id);
}
