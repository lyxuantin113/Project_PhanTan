package dao;

import java.rmi.Remote;
import java.util.List;

import entity.NhanVien;
import entity.TaiKhoan;


public interface TaiKhoan_Dao extends Remote {
	public boolean createTaiKhoan(TaiKhoan tk);
	
	public boolean deleteTaiKhoan(String maNV);
}
