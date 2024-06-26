package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.Thuoc_Dao;
import entity.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Thuoc_Impl extends UnicastRemoteObject implements Thuoc_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417489909540989701L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;

	public Thuoc_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public Thuoc timTheoMa(String maThuoc) {
		return em.find(Thuoc.class, maThuoc);
	}

	@Override
	public List<Thuoc> findAll() {
		return em.createQuery("Select t FROM Thuoc t", Thuoc.class).getResultList();
	}

	@Override
	public boolean timTheoTen(String tenThuoc) {
	    List<Thuoc> result = em.createQuery("SELECT t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc", Thuoc.class)
	                            .setParameter("tenThuoc", tenThuoc)
	                            .getResultList();
	    return !result.isEmpty();
	}
	@Override
	public boolean timTheoLoai(String loaiThuoc) {
	    List<Thuoc> result = em.createQuery("SELECT t FROM Thuoc t WHERE t.loaiThuoc = :loaiThuoc", Thuoc.class)
	                            .setParameter("loaiThuoc", loaiThuoc)
	                            .getResultList();
	    return !result.isEmpty();
	}

	@Override
	public Thuoc findByName(String tenThuoc) {
		return em.createQuery("Select t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc", Thuoc.class)
				.setParameter("tenThuoc", tenThuoc)
//				.getSingleResult()
				.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public void updateThuocQuatity(String maThuoc, int soLuongGiam) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createQuery("UPDATE Thuoc t SET t.soLuongTon = t.soLuongTon - :soLuong WHERE t.maThuoc = :maThuoc")
					.setParameter("soLuong", soLuongGiam).setParameter("maThuoc", maThuoc).executeUpdate();

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
	}

	@Override
	public void updateTTThuoc(Thuoc thuoc) {
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.merge(thuoc);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public void updateThuoc(Thuoc thuoc) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(thuoc);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		
	}

	@Override
	public void deleteThuoc(String maThuoc) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Thuoc.class, maThuoc));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		
	}

	@Override
	public boolean checkThuoc(String maThuoc) {
	    List<Thuoc> result = em.createQuery("SELECT t FROM Thuoc t WHERE t.maThuoc = :maThuoc", Thuoc.class)
	                            .setParameter("maThuoc", maThuoc)
	                            .getResultList();
	    return !result.isEmpty();
	}

	@Override
	public void addThuoc(Thuoc thuoc) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(thuoc);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		
	}

	@Override
	public Thuoc[] getDSTByNCC(String maNCC) {
		
		return em.createQuery("Select t FROM Thuoc t WHERE t.maNCC = :maNCC", Thuoc.class).setParameter("maNCC", maNCC)
				.getResultList().toArray(new Thuoc[0]);
		
	}

	@Override
	public Thuoc readFromTable(String string) {
		return em.createQuery("Select t FROM Thuoc t WHERE t.maThuoc = :maThuoc", Thuoc.class)
				.setParameter("maThuoc", string).getSingleResult();
	}

	@Override
	public boolean searchNCC(String maNCC) {
	    List<Thuoc> result = em.createQuery(
	            "SELECT t FROM Thuoc t WHERE t.maNCC = :maNCC", 
	            Thuoc.class)
	        .setParameter("maNCC", maNCC)
	        .getResultList();
	    return !result.isEmpty();
	}

	@Override
	public boolean timTheoMaTuyetDoi(String thongTin) {
	    List<Thuoc> result = em.createQuery("SELECT t FROM Thuoc t WHERE t.maThuoc = :maThuoc", Thuoc.class)
	                            .setParameter("maThuoc", thongTin)
	                            .getResultList();
	    return !result.isEmpty();
	}
	@Override
	public boolean timTheoNCC(String thongTin) {
	    List<Thuoc> result = em.createQuery("SELECT t FROM Thuoc t WHERE t.maNCC = :maNCC", Thuoc.class)
	                            .setParameter("maNCC", thongTin)
	                            .getResultList();
	    return !result.isEmpty();
	}
	

	

}
