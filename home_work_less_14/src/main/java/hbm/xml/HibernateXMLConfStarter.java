package hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateXMLConfStarter {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory buildSessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session openSession = buildSessionFactory.openSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		
		Cart cart = new Cart(120, "cartName");
		Item item1 = new Item(35);
		Item item2 = new Item(25);
		Item item3 = new Item(40);
		Item item4 = new Item(20);
		
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
		openSession.persist(cart);
		
		beginTransaction.commit();
		openSession.close();
	}
}
