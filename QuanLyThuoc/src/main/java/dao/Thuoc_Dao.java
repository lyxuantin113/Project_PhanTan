package dao;

import java.rmi.Remote;
import java.time.LocalDate;
import java.util.List;

import entity.Thuoc;

public interface Thuoc_Dao extends Remote {

	public Thuoc timTheoMa(String maThuoc);

	public List<Thuoc> findAll();

	public boolean timTheoTen(String tenThuoc);

	public boolean timTheoLoai(String loaiThuoc);

	public Thuoc findByName(String tenThuoc);

	public void updateThuocQuatity(String maThuoc, int soLuong);

}
