package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.PhieuNhapThuoc_Dao;
import entity.HoaDon;
import entity.PhieuNhapThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PhieuNhapThuoc_Impl extends UnicastRemoteObject implements PhieuNhapThuoc_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8720430331537767941L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public PhieuNhapThuoc_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<PhieuNhapThuoc> readFromTableSort() {
		return em.createNamedQuery("PhieuNhapThuoc.readFromTableSort", PhieuNhapThuoc.class).getResultList();
	}

	@Override
	public void updateTrangThai(String maPhieuNhap) {
		em.createNamedQuery("PhieuNhapThuoc.updateTrangThai", PhieuNhapThuoc.class).setParameter("maPhieuNhap", maPhieuNhap).executeUpdate();
		
	}

	@Override
	public boolean checkThuoc(String maThuoc) {
		return em.createNamedQuery("PhieuNhapThuoc.checkThuoc", PhieuNhapThuoc.class).setParameter("maThuoc", maThuoc).executeUpdate() > 0;
		
	}

	@Override
	public boolean delete(String maPNT) {
		return em.createNamedQuery("PhieuNhapThuoc.delete", PhieuNhapThuoc.class).setParameter("maPNT", maPNT).executeUpdate() > 0;
    }

	@Override
	public boolean findMaPhieuNhap(String maPNT) {
		return em.createNamedQuery("PhieuNhapThuoc.findByMaPhieuNhap", PhieuNhapThuoc.class).setParameter("maPNT", maPNT).executeUpdate() > 0;
		
	}

	@Override
	public boolean create(PhieuNhapThuoc pnt) {
		em.getTransaction().begin();
		try {
			em.persist(pnt);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return false;
	}
	

}
