package dao;

import java.rmi.Remote;
import java.util.List;

import entity.PhieuNhapThuoc;

public interface PhieuNhapThuoc_Dao extends Remote {

	List<PhieuNhapThuoc> readFromTableSort();
	void updateTrangThai(String maPhieuNhap);
	boolean checkThuoc(String maThuoc);
	boolean delete(String maPNT);
	boolean findMaPhieuNhap(String maPNT);
	boolean create(PhieuNhapThuoc pnt);
	PhieuNhapThuoc timTheoMa(String maCTPNT);
	void updateTongTien(PhieuNhapThuoc pnt);
	
}
