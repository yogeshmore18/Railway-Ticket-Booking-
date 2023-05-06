package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;
public class TrainDao 
{
	

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Train train) {
		entityTransaction.begin();
		entityManager.persist(train);
		entityTransaction.commit();
	}
	
	public List<Train> fetchAll()
	{
		return entityManager.createQuery("select x from Train x").getResultList();
	}

	public void delete(int Number) {

		entityTransaction.begin();
		entityManager.remove(entityManager.find(Train.class, Number));
		entityTransaction.commit();
		
	}
	public Train fetch(int number)
	{
		return entityManager.find(Train.class, number);
	}

	public void update(Train train) {

		entityTransaction.begin();
		entityManager.merge(train);
		entityTransaction.commit();
		
	}

}
