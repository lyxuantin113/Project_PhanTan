package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.DonDat;

public interface DonDat_Dao extends Remote{
	public boolean addDonDat(DonDat donDat) throws RemoteException;
	
	public DonDat findByID(String maDonDat) throws RemoteException;
	
	public boolean checkThuoc(String maThuoc) throws RemoteException;
	
	public List<DonDat> readFromTable() throws RemoteException;
	
	public double tinhTongTien(DonDat donDat) throws RemoteException;
	
	public List<DonDat> findByNhanVien(String textFind) throws RemoteException;
	
	public List<DonDat> findByNgayLap(LocalDate textFindDate) throws RemoteException;
	
	public List<DonDat> findByNgayNhan(LocalDate textFindDate) throws RemoteException;
	
	public boolean deleteByID(String maDonDat) throws RemoteException;
}
