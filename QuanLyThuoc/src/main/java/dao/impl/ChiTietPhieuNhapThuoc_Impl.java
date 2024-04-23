package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuNhapThuoc_Dao;
import entity.ChiTietPhieuNhapThuoc;
import entity.PhieuNhapThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class ChiTietPhieuNhapThuoc_Impl extends UnicastRemoteObject implements ChiTietPhieuNhapThuoc_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2195088738328711745L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public ChiTietPhieuNhapThuoc_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<ChiTietPhieuNhapThuoc> readFromTable(String maPhieuNhap) {
	    return em.createNamedQuery("ChiTietPhieuNhapThuoc.readFromTable", ChiTietPhieuNhapThuoc.class)
	             .setParameter("maPhieuNhap", maPhieuNhap)
	             .getResultList();
	}

	@Override
	public boolean update(ChiTietPhieuNhapThuoc ct) {
		return em.createNamedQuery("ChiTietPhieuNhapThuoc.update", ChiTietPhieuNhapThuoc.class)
				.setParameter("maPhieuNhap", ct.getMaPhieuNhap())
				.setParameter("maThuoc", ct.getMaThuoc())
				.setParameter("soLuong", ct.getSoLuong())
				.setParameter("giaNhap", ct.getGiaNhap())
				.setParameter("hsd", ct.getHsd())
				.setParameter("thanhTien", ct.getThanhTien())
				.executeUpdate() > 0;
    
	}

	@Override
	public boolean delete(String maCTPNT) {
		return em.createNamedQuery("ChiTietPhieuNhapThuoc.delete", ChiTietPhieuNhapThuoc.class).setParameter("maCTPNT", maCTPNT).executeUpdate() > 0;
	}

	@Override
	public boolean findMaPhieuNhap(String maCTPNT, String ma) {
	    List<ChiTietPhieuNhapThuoc> result = em.createNamedQuery("ChiTietPhieuNhapThuoc.findByMaPhieuNhap", ChiTietPhieuNhapThuoc.class)
	                                            .setParameter("maPhieuNhap", maCTPNT)
	                                            .setParameter("maThuoc", ma)
	                                            .getResultList();
	    return !result.isEmpty();
	}

	@Override
	public boolean create(ChiTietPhieuNhapThuoc ct) {
		EntityTransaction tx = em.getTransaction();
	    try {
	    	tx.begin();
			em.persist(ct);
			tx.commit();
	        return true; 
	    } catch (PersistenceException e) {
	        
	        e.printStackTrace();
	        return false; 
	    }
	}
	

}
