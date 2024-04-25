package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Thuoc;

public interface Thuoc_Dao extends Remote {

	public Thuoc timTheoMa(String maThuoc) throws RemoteException;

	public List<Thuoc> findAll() throws RemoteException;

	public boolean timTheoTen(String tenThuoc) throws RemoteException;

	public boolean timTheoLoai(String loaiThuoc) throws RemoteException;

	public Thuoc findByName(String tenThuoc) throws RemoteException;

	public void updateThuocQuatity(String maThuoc, int soLuong) throws RemoteException;

	public void updateTTThuoc(Thuoc thuoc) throws RemoteException;

	public void updateThuoc(Thuoc thuoc) throws RemoteException;

	public void deleteThuoc(String maThuoc) throws RemoteException;

	public boolean checkThuoc(String maThuoc) throws RemoteException;

	public void addThuoc(Thuoc thuoc) throws RemoteException;

	public Thuoc[] getDSTByNCC(String maNCC) throws RemoteException;

	public Thuoc readFromTable(String string) throws RemoteException;

	public boolean searchNCC(String maNCC) throws RemoteException;

	public boolean timTheoMaTuyetDoi(String thongTin) throws RemoteException;

	public boolean timTheoNCC(String thongTin) throws RemoteException;

	

}
