package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.PhieuNhapThuoc_Dao;
import entity.HoaDon;
import entity.PhieuNhapThuoc;
import entity.Thuoc;
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
	    PhieuNhapThuoc pnt = em.find(PhieuNhapThuoc.class, maPhieuNhap);
	  
	    if (pnt != null) {
	        
	        pnt.setTrangThai(false);
	        
	        em.merge(pnt);
	    } else {
	        System.out.println("Không tìm thấy phiếu nhập thuốc với mã: " + maPhieuNhap);
	    }
	}
	@Override
	public boolean checkThuoc(String maThuoc) {
		Thuoc temp = em.find(Thuoc.class, maThuoc);
	    return em.createNamedQuery("PhieuNhapThuoc.checkThuoc", PhieuNhapThuoc.class)
	             .setParameter("maThuoc", temp)
	             .getResultList()
	             .isEmpty();
	}
	@Override
	public boolean delete(String maPNT) {
	    em.getTransaction().begin();
	    int rowsAffected = em.createNamedQuery("PhieuNhapThuoc.delete")
	                         .setParameter("maPhieuNhap", maPNT)
	                         .executeUpdate();
	    em.getTransaction().commit();
	    return rowsAffected > 0;
	}
	@Override
	public boolean findMaPhieuNhap(String maPNT) {
	    List<PhieuNhapThuoc> result = em.createNamedQuery("PhieuNhapThuoc.findByMaPhieuNhap", PhieuNhapThuoc.class)
	                                    .setParameter("maPhieuNhap", maPNT)
	                                    .getResultList();
	    return !result.isEmpty();
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

	@Override
	public PhieuNhapThuoc timTheoMa(String maCTPNT) {
		return em.find(PhieuNhapThuoc.class, maCTPNT);
	}

	@Override
	public void updateTongTien(PhieuNhapThuoc pnt) {
		em.getTransaction().begin();
		try {
			em.merge(pnt);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}
	

}
