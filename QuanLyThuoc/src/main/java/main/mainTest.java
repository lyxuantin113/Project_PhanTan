package main;

import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class mainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyThuoc MSSQL");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
//			KhachHang khach = new KhachHang("KH00000", "0912644361", "Ly Xuan Tin");
			System.out.println("Hello World");
//			em.persist(khach);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
