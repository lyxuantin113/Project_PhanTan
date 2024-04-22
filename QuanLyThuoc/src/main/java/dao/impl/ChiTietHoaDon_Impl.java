package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietHoaDon_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietHoaDon_Impl extends UnicastRemoteObject implements ChiTietHoaDon_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2034982718177208289L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	List<ChiTietHoaDon> ds = null;

	public ChiTietHoaDon_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		ds = new ArrayList<ChiTietHoaDon>();
	}

	@Override
	public List<ChiTietHoaDon> findByID(String maHoaDon) {
		return em.createNamedQuery("ChiTietHoaDon.findByID", ChiTietHoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getResultList();
	}

	@Override
	public void addChiTietHoaDon(HoaDon hoaDon) {
		EntityTransaction tx =em.getTransaction();
		try {
			tx.begin();
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTiet()) {
				em.persist(chiTietHoaDon);
				ds.add(chiTietHoaDon);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean deleteOne(ChiTietHoaDon chiTietHoaDon) {
		int checkUpdate = em.createNamedQuery("ChiTietHoaDon.deleteOne", ChiTietHoaDon.class)
				.setParameter("maThuoc", chiTietHoaDon.getMaThuoc().getMaThuoc())
				.executeUpdate();
		return checkUpdate > 0;
	}
	
	@Override
	public List<ChiTietHoaDon> getList() {
		return ds;
	}
}
