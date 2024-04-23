package dao;

import java.util.List;

import entity.ChiTietHoaDon;
import entity.HoaDon;

public interface ChiTietHoaDon_Dao {
	public List<ChiTietHoaDon> findByID(String maHoaDon);
	public void addChiTietHoaDon(HoaDon hoaDon);
	public boolean deleteOne(ChiTietHoaDon chiTietHoaDon);
	public List<ChiTietHoaDon> getList();
}
