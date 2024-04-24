package dao;

import java.rmi.RemoteException;

import entity.NhanVien;
import entity.TaiKhoan;


public interface TaiKhoan_Dao {
	public boolean createTaiKhoan(TaiKhoan tk) throws RemoteException;
	
	public boolean deleteTaiKhoan(String maNV)  throws RemoteException;

	public TaiKhoan getTKById(String maNV);
	
	public NhanVien getNVByAccount(String taiKhoan, String matKhau);
	
	public boolean kiemTraDangNhap(String taiKhoan, String matKhau);
}
