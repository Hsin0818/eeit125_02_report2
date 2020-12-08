package SetConnection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();
	static {
		
	}
	private static SessionFactory buildSessionFactory() {
		try {
			// 由組態檔(hibernate.cfg.xml)內的資訊來建立SessionFactory物件
			// Hibernate 5.x 的寫法
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml").build();
			                    
			                    
	        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	        SessionFactory sessionFactory  = metadata.getSessionFactoryBuilder().build();
	        return sessionFactory; 
			
		} catch (Throwable ex) {
			System.err.println("新建SessionFactory失敗:" + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}
	// 外界呼叫此靜態方法來取的 SessionFactory物件
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}