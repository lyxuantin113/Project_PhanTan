package dao;

import java.rmi.Remote;
import java.util.List;

import entity.KhachHang;

public interface KhachHang_Dao extends Remote {
	public KhachHang findKhachHangByID(String maKhachHang);
	public List<KhachHang> findKhachHangByName(String tenKhachHang);
	public KhachHang findKhachHangBySDT(String sdt);
}
