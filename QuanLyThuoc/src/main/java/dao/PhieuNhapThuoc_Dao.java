package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuNhapThuoc;

public interface PhieuNhapThuoc_Dao extends Remote {

	List<PhieuNhapThuoc> readFromTableSort() throws RemoteException;
	void updateTrangThai(String maPhieuNhap) throws RemoteException;
	boolean checkThuoc(String maThuoc) throws RemoteException;
	boolean delete(String maPNT) throws RemoteException;
	boolean findMaPhieuNhap(String maPNT) throws RemoteException;
	boolean create(PhieuNhapThuoc pnt) throws RemoteException;
	PhieuNhapThuoc timTheoMa(String maCTPNT) throws RemoteException;
	void updateTongTien(PhieuNhapThuoc pnt) throws RemoteException;
	
}
