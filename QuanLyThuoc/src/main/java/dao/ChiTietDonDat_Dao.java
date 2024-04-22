package dao;

import java.rmi.Remote;

import entity.ChiTietDonDat;


public interface ChiTietDonDat_Dao extends Remote{
	public boolean addChiTietDonDat(ChiTietDonDat chiTietDonDat);
}
