package entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "HoaDon")
@NamedQueries({ @NamedQuery(name = "HoaDon.findAll", query = "SELECT hd FROM HoaDon hd"),
		@NamedQuery(name = "HoaDon.findByMaNhanVien", query = "SELECT hd FROM HoaDon hd WHERE hd.maNhanVien.maNhanVien = :maNhanVien"),
		@NamedQuery(name = "HoaDon.findByNgayLap", query = "SELECT hd FROM HoaDon hd WHERE hd.ngayLap = :ngayLap"),
		@NamedQuery(name = "HoaDon.findByMaKhachHang", query = "SELECT hd FROM HoaDon hd WHERE hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.findByNgayNhan", query = "SELECT hd FROM HoaDon hd WHERE hd.ngayNhan = :ngayNhan"), 
		@NamedQuery(name = "HoaDon.findTKFullField", query = "SELECT hd FROM HoaDon hd WHERE hd.maNhanVien.maNhanVien = :maNhanVien AND hd.maKhachHang.maKhachHang = :maKhachHang AND hd.ngayLap = :ngayLap"),
		@NamedQuery(name = "HoaDon.findXYinMonth", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND FUNCTION('MONTH', hd.ngayLap) = :month AND hd.maNhanVien.maNhanVien = :maNhanVien AND hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.findXYinYear", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND hd.maNhanVien.maNhanVien = :maNhanVien AND hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.findXByY", query = "SELECT hd FROM HoaDon hd WHERE hd.maNhanVien.maNhanVien = :maNhanVien AND hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.checkThuoc", query = "SELECT hd FROM HoaDon hd JOIN hd.listChiTiet ct WHERE ct.maThuoc = :maThuoc"),
		
		@NamedQuery(name = "HoaDon.findNVinYear", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND hd.maNhanVien.maNhanVien = :maNhanVien"),
		@NamedQuery(name = "HoaDon.findNVinMonth", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND FUNCTION('MONTH', hd.ngayLap) = :month AND hd.maNhanVien.maNhanVien = :maNhanVien"),
		@NamedQuery(name = "HoaDon.findNVinDay", query = "SELECT hd FROM HoaDon hd WHERE hd.maNhanVien.maNhanVien = :maNhanVien AND hd.ngayLap = :ngayLap"),
		
		@NamedQuery(name = "HoaDon.findKHinYear", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.findKHinMonth", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND FUNCTION('MONTH', hd.ngayLap) = :month AND hd.maKhachHang.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "HoaDon.findKHinDay", query = "SELECT hd FROM HoaDon hd WHERE hd.maKhachHang.maKhachHang = :maKhachHang AND hd.ngayLap = :ngayLap"),
		
		@NamedQuery(name = "HoaDon.findinYear", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year"),
		@NamedQuery(name = "HoaDon.findinMonth", query = "SELECT hd FROM HoaDon hd WHERE FUNCTION('YEAR', hd.ngayLap) = :year AND FUNCTION('MONTH', hd.ngayLap) = :month "),
		@NamedQuery(name = "HoaDon.findinDay", query = "SELECT hd FROM HoaDon hd WHERE hd.ngayLap = :ngayLap"),
})

public class HoaDon {
	private static final String PREFIX = "HD";

	@Id
	@Column(name = "maHoaDon")
	private String maHoaDon;

	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang maKhachHang;

	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNhanVien;

	@Column(name = "ngayLap")
	private LocalDate ngayLap;

	@Column(name = "ngayNhan")
	private LocalDate ngayNhan;

	@ToString.Exclude
	@OneToMany(mappedBy = "maHoaDon", fetch = FetchType.LAZY)
	private List<ChiTietHoaDon> listChiTiet;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTietHoaDon;
	}

	public HoaDon(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maHoaDon = PREFIX + generateRandomCode(5);
		this.maKhachHang = maKH;
		this.maNhanVien = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTiet = listChiTietHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon() {
		this.maHoaDon = PREFIX + generateRandomCode(5);
	}

	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public List<ChiTietHoaDon> getListChiTiet() {
		return listChiTiet;
	}

	public void setListChiTiet(List<ChiTietHoaDon> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}

	public static String generateRandomCode(int length) {
		String characters = "0123456789"; // Các ký tự được chấp nhận
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
				+ ", ngayLap=" + ngayLap + ", ngayNhan=" + ngayNhan + ", listChiTiet=" + listChiTiet + "]";
	}

}
