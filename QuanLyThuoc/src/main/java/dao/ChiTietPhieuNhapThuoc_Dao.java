package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuNhapThuoc;

public interface ChiTietPhieuNhapThuoc_Dao extends Remote{

	List<ChiTietPhieuNhapThuoc> readFromTable(String maPhieuNhap) throws RemoteException;

	boolean update(ChiTietPhieuNhapThuoc ct) throws RemoteException;

	boolean delete(String maCTPNT) throws RemoteException;

	boolean findMaPhieuNhap(String maCTPNT, String ma) throws RemoteException;

	boolean create(ChiTietPhieuNhapThuoc ct) throws RemoteException;

}
