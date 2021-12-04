package com.laptrinhweb.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("d76lm45gj5sgn4");
	public static EntityManagerFactory getEmFactory() {
			return emf;
	}
}
