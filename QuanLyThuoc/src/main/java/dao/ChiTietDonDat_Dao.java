package dao;

import java.rmi.Remote;
import java.util.List;

import entity.ChiTietDonDat;
import entity.DonDat;
import entity.HoaDon;

public interface ChiTietDonDat_Dao extends Remote {
	public List<ChiTietDonDat> findByID(String maHoaDon);
	public void addChiTietDonDat(DonDat donDat);
	public boolean deleteOne(ChiTietDonDat chiTietDonDat);
	public boolean deleteByID(String maDonDat);
}
