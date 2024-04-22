package dao;

import java.rmi.Remote;

import entity.HoaDon;

public interface HoaDon_Dao extends Remote{
	public boolean themHoaDon (HoaDon hoaDon);
}
