package dao.impl;

import java.rmi.server.UnicastRemoteObject;

import dao.ChiTietDonDat_Dao;
import entity.ChiTietDonDat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDonDat_Impl extends UnicastRemoteObject implements ChiTietDonDat_Dao {

	private static final long serialVersionUID = 968547856325812548L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public ChiTietDonDat_Impl() throws Exception {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	@Override
	public boolean addChiTietDonDat(ChiTietDonDat chiTietDonDat) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(chiTietDonDat);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}
}
