package dao;

import java.util.List;
import entity.NhanVien;

public interface NhanVien_Dao {

	public NhanVien getNhanVien(String maNV);

	public boolean maNhanVienDaTonTai(String maNV);
	
	public boolean createNhanVien(NhanVien nv);
	
	public boolean updateNhanVien(NhanVien nv) ;
	
	public boolean deleteNhanVien(String maNV);
	
	
	public List<NhanVien> docTuBang() ;
	
	public List<NhanVien> findByTenNV(String tenNV);

	

}
