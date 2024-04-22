package dao;

import java.rmi.Remote;
import java.time.LocalDate;
import java.util.List;

import entity.DonDat;

public interface DonDat_Dao extends Remote{
	public boolean addDonDat(DonDat donDat);
	
	public DonDat findByID(String maDonDat);
	
	public boolean checkThuoc(String maThuoc);
	
	public List<DonDat> readFromTable();
	
	public double tinhTongTien(DonDat donDat);
	
	public List<DonDat> findByNhanVien(String textFind);
	
	public List<DonDat> findByNgayLap(LocalDate textFindDate);
	
	public List<DonDat> findByNgayNhan(LocalDate textFindDate);
	
	public boolean deleteByID(String maDonDat);
}
