package dao;

import java.rmi.Remote;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.HoaDon;

public interface ChiTietHoaDon_Dao extends Remote {
	public List<ChiTietHoaDon> findByID(String maHoaDon);
	public void addChiTietHoaDon(HoaDon hoaDon);
	public boolean deleteOne(ChiTietHoaDon chiTietHoaDon);
	public List<ChiTietHoaDon> getList();
}
