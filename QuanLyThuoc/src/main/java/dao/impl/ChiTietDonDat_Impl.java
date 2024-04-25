package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietDonDat_Dao;
import entity.ChiTietDonDat;
import entity.DonDat;
import entity.Thuoc;
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
	private List<ChiTietDonDat> list;

	public ChiTietDonDat_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		list = new ArrayList<ChiTietDonDat>();
	}

	@Override
	public List<ChiTietDonDat> findByID(String maDonDat) {
		return em.createNamedQuery("ChiTietDonDat.findByID", ChiTietDonDat.class)
				.setParameter("maDonDat", maDonDat)
				.getResultList();
	}

	@Override
	public void addChiTietDonDat(DonDat donDat) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			for (ChiTietDonDat chiTietDonDat : donDat.getListChiTiet()) {
				em.persist(chiTietDonDat);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOne(ChiTietDonDat chiTietDonDat) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(ChiTietDonDat.class, chiTietDonDat));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteByID(String maDonDat) {
		EntityTransaction tx = em.getTransaction();
		List<ChiTietDonDat> list = this.findByID(maDonDat);
		try {
			tx.begin();
			for (ChiTietDonDat chiTietDonDat : list) {
				em.remove(em.find(ChiTietDonDat.class, chiTietDonDat.getId()));
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
	}
}
