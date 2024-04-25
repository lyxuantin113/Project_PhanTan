package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHang_Dao extends Remote{

	public void addKhachHang(KhachHang kh) throws RemoteException;

	public KhachHang findById(String maKH) throws RemoteException;

	public KhachHang findBySDT(String sdtKH) throws RemoteException;
	
	public List<KhachHang> findBySDT2(String sdtKH) throws RemoteException;

	public List<KhachHang> getDSKH() throws RemoteException;

	public List<KhachHang> readFromTable() throws RemoteException;

	public boolean updateKhachHang(KhachHang kh) throws RemoteException;

	public boolean deleteKhachHang(KhachHang kh) throws RemoteException;

}
