package dao;

import java.rmi.Remote;

import entity.ChiTietHoaDon;

public interface ChiTietHoaDon_Dao extends Remote{
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
}
