package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVien_Dao;
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TaiKhoan_Impl extends UnicastRemoteObject implements TaiKhoan_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8114624633946054475L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public TaiKhoan_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public boolean createTaiKhoan(TaiKhoan tk) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.persist(tk);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteTaiKhoan(String manv) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			TaiKhoan tk = em.find(TaiKhoan.class, manv);
			em.remove(manv);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public TaiKhoan getTKById(String maNV) {
		return em.createQuery("Select tk From TaiKhoan tk WHERE tk.maNhanVien = :maNhanVien", TaiKhoan.class)
				.setParameter("maNhanVien", maNV)
				.getSingleResult();
	}

	@Override
	public NhanVien getNVByAccount(String taiKhoan, String matKhau) {
	    try {
	        TypedQuery<TaiKhoan> query = em.createQuery("SELECT tk FROM TaiKhoan tk WHERE tk.taiKhoan = :taiKhoan AND tk.matKhau = :matKhau", TaiKhoan.class);
	        query.setParameter("taiKhoan", taiKhoan);
	        query.setParameter("matKhau", matKhau);
	        TaiKhoan tk = query.getSingleResult();
	        if (tk != null) {
	            return tk.getMaNhanVien();
	        }
	    } catch (NoResultException e) {
	        // Xử lý nếu không tìm thấy kết quả
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
	    try {
	        TypedQuery<Long> query = em.createQuery("SELECT COUNT(tk) FROM TaiKhoan tk WHERE tk.taiKhoan = :taiKhoan AND tk.matKhau = :matKhau", Long.class);
	        query.setParameter("taiKhoan", taiKhoan);
	        query.setParameter("matKhau", matKhau);
	        Long count = query.getSingleResult();
	        return count > 0; // Trả về true nếu có ít nhất một bản ghi trả về
	    } catch (NoResultException e) {
	        // Xử lý nếu không tìm thấy kết quả
	        e.printStackTrace();
	    }
	    return false; // Trả về false nếu có lỗi xảy ra hoặc không có bản ghi nào trả về
	}
}
