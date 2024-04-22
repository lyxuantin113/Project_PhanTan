package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.KhachHang_Dao;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHang_Impl extends UnicastRemoteObject implements KhachHang_Dao {
	
	private static final long serialVersionUID = 96854785625879658L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public KhachHang_Impl() throws Exception {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	public boolean themKhachHang(KhachHang khachHang) throws RemoteException{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public KhachHang findKhachHangByID(String maKhachHang) {
		return em.createNamedQuery("findKhachHangByID", KhachHang.class)
				.setParameter("maKhachHang", maKhachHang)
				.getSingleResult();
	}
	
	@Override
	public List<KhachHang> findKhachHangByName(String tenKhachHang) {
		return em.createNamedQuery("findKhachHangByName", KhachHang.class).setParameter("tenKhachHang", tenKhachHang).getResultList();
	}
	
	@Override
	public KhachHang findKhachHangBySDT(String sdt) {
		return em.createNamedQuery("findKhachHangBySDT", KhachHang.class).setParameter("sdt", sdt).getSingleResult();
	}

}
