package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietDonDat_Dao;
import entity.ChiTietDonDat;
import entity.DonDat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDonDat_Impl extends UnicastRemoteObject implements ChiTietDonDat_Dao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8582181906822373544L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	private List<ChiTietDonDat> ds;
	
	public ChiTietDonDat_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		ds = new ArrayList<ChiTietDonDat>();
	}

	@Override
	public List<ChiTietDonDat> findByID(String maDonDat) {
		return em.createNamedQuery("ChiTietDonDat.findByID", ChiTietDonDat.class)
				.setParameter("maDonDat", maDonDat)
				.getResultList();
	}

	@Override
	public void addChiTietDonDat(DonDat donDat) {
		EntityTransaction tx =em.getTransaction();
		try {
			tx.begin();
			for (ChiTietDonDat chiTietDonDat : donDat.getListChiTiet()) {
//				em.persist(chiTietDonDat);
				ds.add(chiTietDonDat);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean deleteOne(ChiTietDonDat chiTietDonDat) {
		int checkUpdate = em.createNamedQuery("ChiTietDonDat.deleteOne", ChiTietDonDat.class)
				.setParameter("maThuoc", chiTietDonDat.getMaThuoc().getMaThuoc())
				.executeUpdate();
		return checkUpdate > 0;
	}

	@Override
	public boolean deleteByID(String maDonDat) {
		// TODO Auto-generated method stub
		int checkUpdate = em.createNamedQuery("ChiTietDonDat.deleteByID", ChiTietDonDat.class)
				.setParameter("maDonDat", maDonDat).executeUpdate();
		return checkUpdate > 0;
	}
}
