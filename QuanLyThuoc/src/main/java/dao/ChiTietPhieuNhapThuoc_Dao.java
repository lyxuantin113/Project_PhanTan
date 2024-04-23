package dao;

import java.util.List;

import entity.ChiTietPhieuNhapThuoc;

public interface ChiTietPhieuNhapThuoc_Dao {

	List<ChiTietPhieuNhapThuoc> readFromTable(String maPhieuNhap);

	boolean update(ChiTietPhieuNhapThuoc ct);

	boolean delete(String maCTPNT);

	boolean findMaPhieuNhap(String maCTPNT, String ma);

	boolean create(ChiTietPhieuNhapThuoc ct);

}
