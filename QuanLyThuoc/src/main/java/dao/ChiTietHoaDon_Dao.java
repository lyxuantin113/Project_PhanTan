package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.HoaDon;

public interface ChiTietHoaDon_Dao extends Remote{
	public List<ChiTietHoaDon> findByID(String maHoaDon) throws RemoteException;
	public void addChiTietHoaDon(HoaDon hoaDon) throws RemoteException;
	public boolean deleteOne(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	public List<ChiTietHoaDon> getList() throws RemoteException;
}
