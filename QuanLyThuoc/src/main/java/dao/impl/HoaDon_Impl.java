package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDon_Impl extends UnicastRemoteObject implements HoaDon_Dao {

	private static final long serialVersionUID = 9223372036854775807L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;

	public HoaDon_Impl() throws RemoteException {
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
		return em.createNamedQuery("HoaDon.findXByY", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("maKhachHang", maKH).getResultList();
	}

	@Override
	public List<HoaDon> findNV(String maNV) {
		return em.createNamedQuery("HoaDon.findByMaNhanVien", HoaDon.class).setParameter("maNhanVien", maNV)
				.getResultList();
	}

	@Override
	public List<HoaDon> findNVinYear(LocalDate ngayLap, String maNV) {
		return em.createNamedQuery("HoaDon.findXYinYear", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("year", ngayLap.getYear()).getResultList();
	}

	@Override
	public List<HoaDon> findNVinMonth(LocalDate ngayLap, String maNV) {
		return em.createNamedQuery("HoaDon.findXYinMonth", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("year", ngayLap.getYear()).setParameter("month", ngayLap.getMonthValue()).getResultList();
	}

	@Override
	public List<HoaDon> findNVinDay(LocalDate ngayLap, String maNV) {
		return em.createNamedQuery("HoaDon.findTKFullField", HoaDon.class).setParameter("maNhanVien", maNV)
				.setParameter("ngayLap", ngayLap).getResultList();
	}

	@Override
	public List<HoaDon> findKH(String maKH) {
		return em.createNamedQuery("HoaDon.findByMaKhachHang", HoaDon.class).setParameter("maKhachHang", maKH)
				.getResultList();
	}

	@Override
	public List<HoaDon> findKHinYear(LocalDate ngayLap, String maKH) {
		return em.createNamedQuery("HoaDon.findXYinYear", HoaDon.class).setParameter("maKhachHang", maKH)
				.setParameter("year", ngayLap.getYear()).getResultList();
	}

	@Override
	public List<HoaDon> findKHinMonth(LocalDate ngayLap, String maKH) {
		return em.createNamedQuery("HoaDon.findXYinMonth", HoaDon.class).setParameter("maKhachHang", maKH)
				.setParameter("year", ngayLap.getYear()).setParameter("month", ngayLap.getMonthValue()).getResultList();
	}

	@Override
	public List<HoaDon> findKHinDay(LocalDate ngayLap, String maKH) {
		return em.createNamedQuery("HoaDon.findTKFullField", HoaDon.class).setParameter("maKhachHang", maKH)
				.setParameter("ngayLap", ngayLap).getResultList();
	}

	@Override
	public List<HoaDon> findinYear(LocalDate ngayLap) {
		return em.createNamedQuery("HoaDon.findXYinYear", HoaDon.class).setParameter("year", ngayLap.getYear())
				.getResultList();
	}

	@Override
	public List<HoaDon> findinMonth(LocalDate ngayLap) {
		return em.createNamedQuery("HoaDon.findXYinMonth", HoaDon.class).setParameter("year", ngayLap.getYear())
				.setParameter("month", ngayLap.getMonthValue()).getResultList();
	}

	@Override
	public List<HoaDon> findinDay(LocalDate ngayLap) {
		return em.createNamedQuery("HoaDon.findTKFullField", HoaDon.class).setParameter("ngayLap", ngayLap)
				.getResultList();
	}

	// Phương thức thống kê top 3 khách hàng có số đơn hàng nhiều nhất
		public List<HoaDon> thongKeKHTiemNang() throws RemoteException {
			// Khởi tạo một map để lưu số đơn hàng của mỗi khách hàng
			Map<String, Integer> khachHangCountMap = new HashMap<>();

			// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
			List<HoaDon> allHoaDon = findAll();

			// Đếm số đơn hàng của mỗi khách hàng
			for (HoaDon hoaDon : allHoaDon) {
				String maKH = hoaDon.getMaKhachHang().getMaKhachHang();
				if (!maKH.equals("KH00000"))
					khachHangCountMap.put(maKH, khachHangCountMap.getOrDefault(maKH, 0) + 1);
			}

			// Sắp xếp theo số đơn hàng giảm dần và chọn ra khách hàng tiềm năng có số đơn
			// hàng cao nhất
			Optional<Map.Entry<String, Integer>> topKhachHangEntry = khachHangCountMap.entrySet().stream()
					.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst();

			List<HoaDon> topHoaDonList = new ArrayList<>(); // Danh sách hóa đơn của khách hàng tiềm năng có số đơn hàng cao
															// nhất

			// Nếu có khách hàng tiềm năng, tạo danh sách hóa đơn chứa thông tin của khách
			// hàng đó
			if (topKhachHangEntry.isPresent()) {
				String topMaKH = topKhachHangEntry.get().getKey();
				KhachHang_Dao khachHangDao = new KhachHang_Impl();
				KhachHang topKhachHang = khachHangDao.findById(topMaKH);

				// Lọc danh sách hóa đơn theo mã khách hàng tiềm năng
				topHoaDonList = allHoaDon.stream().filter(hoaDon -> hoaDon.getMaKhachHang().getMaKhachHang().equals(topMaKH))
						.collect(Collectors.toList());
			}

			return topHoaDonList;
		}

		public List<HoaDon> thongKeNVChamChi() {
			// Khởi tạo một map để lưu số đơn hàng của mỗi nhân viên
			Map<String, Integer> nhanVienCountMap = new HashMap<>();

			// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
			List<HoaDon> allHoaDon = findAll();

			// Đếm số đơn hàng của mỗi nhân viên
			for (HoaDon hoaDon : allHoaDon) {
				String maNV = hoaDon.getMaNhanVien().getMaNhanVien();
				if (!maNV.equals("NV000"))
					nhanVienCountMap.put(maNV, nhanVienCountMap.getOrDefault(maNV, 0) + 1);
			}

			// Sắp xếp theo số đơn hàng giảm dần và chọn ra top 3 nhân viên lập số đơn nhiều
			// nhất
			Optional<Map.Entry<String, Integer>> topNhanVienEntry = nhanVienCountMap.entrySet().stream()
					.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst();

			List<HoaDon> topHoaDonList = new ArrayList<>(); // Danh sách hóa đơn của nhân viên lập số đơn hàng nhiều nhất

			// Nếu có nhân viên lập số đơn hàng nhiều nhất, tạo danh sách hóa đơn của nhân
			// viên đó
			if (topNhanVienEntry.isPresent()) {
				String topMaNV = topNhanVienEntry.get().getKey();

				// Lọc danh sách hóa đơn theo mã của nhân viên lập số đơn hàng nhiều nhất
				topHoaDonList = allHoaDon.stream().filter(hoaDon -> hoaDon.getMaNhanVien().getMaNhanVien().equals(topMaNV))
						.collect(Collectors.toList());
			}

			return topHoaDonList;
		}

		public List<HoaDon> thongKeLoiNhuanCaoNhat() {
			// Khởi tạo một map để lưu lợi nhuận của mỗi đơn hàng
			Map<String, Double> loiNhuanMap = new HashMap<>();

			// Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
			List<HoaDon> allHoaDon = findAll();

			// Tính lợi nhuận cho mỗi đơn hàng
			for (HoaDon hoaDon : allHoaDon) {
				double loiNhuan = tinhLoiNhuanChoHoaDon(hoaDon);
				loiNhuanMap.put(hoaDon.getMaHoaDon(), loiNhuan);
			}

			// Sắp xếp theo lợi nhuận giảm dần và chọn ra top 3 đơn hàng có lợi nhuận cao
			// nhất
			List<HoaDon> top3HoaDon = loiNhuanMap.entrySet().stream()
					.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3).map(e -> findById(e.getKey()))
					.collect(Collectors.toList());

			return top3HoaDon;
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
		Thuoc temp = em.find(Thuoc.class, maThuoc);
		return em.createNamedQuery("HoaDon.checkThuoc", HoaDon.class).setParameter("maThuoc", temp).getResultList()
				.size() > 0;

	}
}
