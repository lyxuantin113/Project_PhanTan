package dao;

import java.rmi.Remote;
import java.time.LocalDate;
import java.util.List;

import entity.HoaDon;

public interface HoaDon_Dao extends Remote {
	public List<HoaDon> findAll();

	public void addHoaDon(HoaDon hoaDon);

	public HoaDon findById(String maHoaDon);

	public List<HoaDon> findByNhanVien(String maNV);

	public List<HoaDon> findByNgayLap(LocalDate ngayLap);

	public List<HoaDon> findByNgayNhan(LocalDate ngayNhan);

	public void updateHoaDon(HoaDon hoaDon);

//	THỐNG KÊ FULL FIELD
	public List<HoaDon> findTKFullField(LocalDate ngayLap, String maNV, String maKH);

//	Thống kê đơn của KH X được lập bởi NV Y theo tháng
	public List<HoaDon> findXYinMonth(LocalDate ngayLap, String maNV, String maKH);

//	Thống kê đơn của KH X được lập bởi NV Y theo năm
	public List<HoaDon> findXYinYear(LocalDate ngayLap, String maNV, String maKH);

//	Thống kê đơn của KH X được lập bởi NV Y 
	public List<HoaDon> findXByY(String maNV, String maKH);

//  NHÂN VIÊN
//	Thống kê đơn của NV Y
	public List<HoaDon> findNV(String maNV);

//	Thống kê đơn của NV Y theo năm
	public List<HoaDon> findNVinYear(LocalDate ngayLap, String maNV);

//	Thống kê đơn của NV Y theo tháng
	public List<HoaDon> findNVinMonth(LocalDate ngayLap, String maNV);

//	Thống kê đơn của NV Y theo ngày
	public List<HoaDon> findNVinDay(LocalDate ngayLap, String maNV);

//  KHÁCH HÀNG
//	Thống kê đơn của KH X
	public List<HoaDon> findKH(String maKH);

//	Thống kê đơn của KH X theo năm
	public List<HoaDon> findKHinYear(LocalDate ngayLap, String maKH);

//	Thống kê đơn của KH X theo tháng
	public List<HoaDon> findKHinMonth(LocalDate ngayLap, String maKH);

//  Thống kê đơn của KH X theo ngày
	public List<HoaDon> findKHinDay(LocalDate ngayLap, String maKH);

//	Thống kê đơn theo năm
	public List<HoaDon> findinYear(LocalDate ngayLap);

//	Thống kê đơn theo tháng
	public List<HoaDon> findinMonth(LocalDate ngayLap);

//	Thống kê đơn theo ngày
	public List<HoaDon> findinDay(LocalDate ngayLap);

//	Phương thức thống kê top 3 khách hàng có số đơn hàng nhiều nhất
	public List<HoaDon> thongKeKHTiemNang();

//	Phương thức thống kê nhân viên chăm chỉ
	public List<HoaDon> thongKeNVChamChi();

//	Phương thức thống kê lợi nhuận cao nhất
	public List<HoaDon> thongKeLoiNhuanCaoNhat();

//	Tính toán
	public double tinhTongTien(HoaDon hoaDon);

	public double tinhLoiNhuanChoHoaDon(HoaDon hoaDon);
}
