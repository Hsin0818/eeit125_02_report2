package shopping;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			// 由組態檔(hibernate.cfg.xml)內的資訊來建立SessionFactory物件
			// Hibernate4.3 的寫法
			// Hibernate 5.x 的寫法
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.lsm.xml").build();
			System.out.println("--------------------------");
			// 以下為Mapping檔的寫法
			 Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			// 
			// 以下為addAnnotatedClass()的寫法
//			MetadataSources sources = new MetadataSources(standardRegistry);
//			sources.addAnnotatedClass(Member.class);
//			Metadata metadata = sources.getMetadataBuilder().build();

			// 共同部分
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			System.out.println("SessionFactory Ready...(ch06.HibernateUtils.java)");
			return sessionFactory; 
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	// 外界呼叫此靜態方法來取的 SessionFactory物件
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close() {
		getSessionFactory().close();
	}

}