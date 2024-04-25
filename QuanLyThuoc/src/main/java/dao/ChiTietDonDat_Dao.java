package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietDonDat;
import entity.DonDat;

public interface ChiTietDonDat_Dao extends Remote {
	public List<ChiTietDonDat> findByID(String maDonDat) throws RemoteException;
	public void addChiTietDonDat(DonDat donDat) throws RemoteException;
	public void deleteOne(ChiTietDonDat chiTietDonDat) throws RemoteException;
	public void deleteByID(String maDonDat) throws RemoteException;
}
