package dao;

import java.util.List;

import entity.ChiTietDonDat;
import entity.DonDat;

public interface ChiTietDonDat_Dao {
	public List<ChiTietDonDat> findByID(String maDonDat);
	public void addChiTietDonDat(DonDat donDat);
	public void deleteOne(ChiTietDonDat chiTietDonDat);
	public void deleteByID(String maDonDat);
}
