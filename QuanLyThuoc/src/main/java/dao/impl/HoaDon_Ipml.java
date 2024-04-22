package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDon_Ipml extends UnicastRemoteObject implements HoaDon_Dao {

	private static final long serialVersionUID = 9223372036854775807L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;

	public HoaDon_Ipml() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<HoaDon> findAll() {
		return em.createNamedQuery("HoaDon.findAll", HoaDon.class).getResultList();
	}

	@Override
	public void addHoaDon(HoaDon hoaDon) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(hoaDon);
			ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Impl();
			cthdDao.addChiTietHoaDon(hoaDon);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public HoaDon findById(String maHoaDon) {
		return em.find(HoaDon.class, maHoaDon);
	}

	@Override
	public List<HoaDon> findByNhanVien(String maNV) {
		return em.createNamedQuery("HoaDon.findByMaNhanVien", HoaDon.class).setParameter("maNhanVien", maNV)
				.getResultList();
	}

	@Override
	public List<HoaDon> findByNgayLap(LocalDate ngayLap) {
		return em.createNamedQuery("HoaDon.findByNgayLap", HoaDon.class).setParameter("ngayLap", ngayLap)
				.getResultList();
	}

	@Override
	public List<HoaDon> findByNgayNhan(LocalDate ngayNhan) {
		return em.createNamedQuery("HoaDon.findByNgayNhan", HoaDon.class).setParameter("ngayNhan", ngayNhan)
				.getResultList();
	}

	@Override
	public void updateHoaDon(HoaDon hoaDon) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(hoaDon);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<HoaDon> findTKFullField(LocalDate ngayLap, String maNV, String maKH) {
		return em.createNamedQuery("HoaDon.findTKFullField", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("maKhachHang", maKH).setParameter("ngayLap", ngayLap).getResultList();
	}

	@Override
	public List<HoaDon> findXYinMonth(LocalDate ngayLap, String maNV, String maKH) {
		return em.createNamedQuery("HoaDon.findXYinMonth", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("maKhachHang", maKH).setParameter("year", ngayLap.getYear())
				.setParameter("month", ngayLap.getMonthValue()).getResultList();
	}

	@Override
	public List<HoaDon> findXYinYear(LocalDate ngayLap, String maNV, String maKH) {
		return em.createNamedQuery("HoaDon.findXYinYear", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("maKhachHang", maKH).setParameter("year", ngayLap.getYear()).getResultList();
	}

	@Override
	public List<HoaDon> findXByY(String maNV, String maKH) {
		return em.createNamedQuery("HoaDon.findXYinYear", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("maKhachHang", maKH).getResultList();
	}

	@Override
	public List<HoaDon> findNV(String maNV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findNVinYear(LocalDate ngayLap, String maNV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findNVinMonth(LocalDate ngayLap, String maNV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findNVinDay(LocalDate ngayLap, String maNV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findKH(String maKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findKHinYear(LocalDate ngayLap, String maKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findKHinMonth(LocalDate ngayLap, String maKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findKHinDay(LocalDate ngayLap, String maKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findinYear(LocalDate ngayLap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findinMonth(LocalDate ngayLap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> findinDay(LocalDate ngayLap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> thongKeKHTiemNang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> thongKeNVChamChi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDon> thongKeLoiNhuanCaoNhat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double tinhTongTien(HoaDon hoaDon) {
		double doanhThu = 0.0;
		if (hoaDon.getListChiTiet() != null) {
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTiet()) {
				double giaBan = chiTietHoaDon.getMaThuoc().getGiaBan();
				int soLuong = chiTietHoaDon.getSoLuong();
				doanhThu += giaBan * soLuong;
			}
		} else
			return 0;
		return doanhThu;
	}

	@Override
	public double tinhLoiNhuanChoHoaDon(HoaDon hoaDon) {
		double loiNhuan = 0.0;
		if (hoaDon.getListChiTiet() != null) {
			for (ChiTietHoaDon chiTiet : hoaDon.getListChiTiet()) {
				double giaNhap = chiTiet.getMaThuoc().getGiaNhap();
				double giaBan = chiTiet.getMaThuoc().getGiaBan();
				int soLuong = chiTiet.getSoLuong();
				loiNhuan += (giaBan - giaNhap) * soLuong;
			}
		} else
			return 0;
		return loiNhuan;
	}

	@Override
	public boolean checkThuoc(String maThuoc) {
		return em.createNamedQuery("HoaDon.checkThuoc", HoaDon.class).setParameter("maThuoc", maThuoc).getResultList().size() > 0;
		
	}
}
