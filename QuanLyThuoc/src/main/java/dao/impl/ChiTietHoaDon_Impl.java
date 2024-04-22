package dao.impl;

import java.rmi.server.UnicastRemoteObject;

import dao.ChiTietHoaDon_Dao;
import entity.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietHoaDon_Impl extends UnicastRemoteObject implements ChiTietHoaDon_Dao {
	
	private static final long serialVersionUID = 968547856325896547L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public ChiTietHoaDon_Impl() throws Exception {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}
}
