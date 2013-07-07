package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class generateTables {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("locadora");
	}
}
