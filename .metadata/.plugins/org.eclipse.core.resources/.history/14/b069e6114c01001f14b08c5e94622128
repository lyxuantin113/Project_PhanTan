package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuNhapThuoc_Dao;
import entity.ChiTietPhieuNhapThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

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
		return em.createNamedQuery("ChiTietPhieuNhapThuoc.readFromTable", ChiTietPhieuNhapThuoc.class).setParameter("maPhieuNhap", maPhieuNhap).getResultList();
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
		return em.createNamedQuery("ChiTietPhieuNhapThuoc.findByMaPhieuNhap", ChiTietPhieuNhapThuoc.class).setParameter("maCTPNT", maCTPNT).setParameter("ma", ma).executeUpdate() > 0;
    }

	@Override
	public boolean create(ChiTietPhieuNhapThuoc ct) {
		return em.createNamedQuery("ChiTietPhieuNhapThuoc.create", ChiTietPhieuNhapThuoc.class)
				.setParameter("maPhieuNhap", ct.getMaPhieuNhap())
				.setParameter("maThuoc", ct.getMaThuoc())
				.setParameter("soLuong", ct.getSoLuong())
				.setParameter("giaNhap", ct.getGiaNhap())
				.setParameter("hsd", ct.getHsd())
				.setParameter("thanhTien", ct.getThanhTien())
				.executeUpdate() > 0;
	}
	

}
