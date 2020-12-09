package utils;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();
	static {
		System.out.println("HibernateUtils已載入");

	}

	private static SessionFactory buildSessionFactory() {
		try {
			// 由組態檔(hibernate.cfg.xml)內的資訊來建立SessionFactory物件
			// Hibernate 5.x 的寫法
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			// .configure("\\hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
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

	public Blob fileToBlob(File file) {
		Blob blob = null;
		try (
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		) {
			
			int len = 0;
			byte[] b = new byte[8192];
			while ((len = fis.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			blob = new SerialBlob(baos.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return blob;

	}
	
	public Clob fileToClob(File file, String encoding) {
		Clob clob = null;
		try (
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			CharArrayWriter caw = new CharArrayWriter();
		) {
			
			int len = 0;
			char[] b = new char[8192];
			while ((len = isr.read(b)) != -1) {
				caw.write(b, 0, len);
			}
			clob = new SerialClob(caw.toCharArray());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clob;

	}
}