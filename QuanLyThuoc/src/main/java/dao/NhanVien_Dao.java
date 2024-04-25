package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.NhanVien;

public interface NhanVien_Dao extends Remote {

	public NhanVien getNhanVien(String maNV) throws RemoteException;

	public boolean maNhanVienDaTonTai(String maNV) throws RemoteException;
	
	public boolean createNhanVien(NhanVien nv) throws RemoteException;
	
	public boolean updateNhanVien(NhanVien nv) throws RemoteException ;
	
	public boolean deleteNhanVien(String maNV) throws RemoteException;
	
	
	public List<NhanVien> docTuBang() throws RemoteException;
	
	public List<NhanVien> findByTenNV(String tenNV) throws RemoteException;

	

}
