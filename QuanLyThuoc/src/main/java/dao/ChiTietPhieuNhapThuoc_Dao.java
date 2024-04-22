package dao;

import java.rmi.Remote;
import java.util.List;

import entity.ChiTietPhieuNhapThuoc;

public interface ChiTietPhieuNhapThuoc_Dao extends Remote {

	List<ChiTietPhieuNhapThuoc> readFromTable(String maPhieuNhap);

	boolean update(ChiTietPhieuNhapThuoc ct);

	boolean delete(String maCTPNT);

	boolean findMaPhieuNhap(String maCTPNT, String ma);

	boolean create(ChiTietPhieuNhapThuoc ct);

}
