package server;
import dao.impl.*;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;


import dao.*;

public class Server {
	private static final String URL = "rmi://localhost:2024/";

	public static void main(String[] args) {
		try {
			TaiKhoan_Dao taiKhoanService = new TaiKhoan_Impl();
			Thuoc_Dao thuocService = new Thuoc_Impl();
			
			DonDat_Dao donDatService = new DonDat_Impl();
			ChiTietDonDat_Dao chiTietDonDatService = new ChiTietDonDat_Impl();
			
			HoaDon_Dao hoaDonService = new HoaDon_Impl();
			ChiTietHoaDon_Dao chiTietHoaDonService = new ChiTietHoaDon_Impl();
			
			NhaCungCap_Dao nhaCungCapService = new NhaCungCap_Impl();
			NhanVien_Dao nhanVienService = new NhanVien_Impl();
			KhachHang_Dao khachHangService = new KhachHang_Impl();
			
			PhieuNhapThuoc_Dao phieuNhapThuocService = new PhieuNhapThuoc_Impl();
			ChiTietPhieuNhapThuoc_Dao chiTietPhieuNhapThuocService = new ChiTietPhieuNhapThuoc_Impl();
			
			
			Context context = new InitialContext();
			
			LocateRegistry.createRegistry(2024);
			context.bind(URL + "Thuoc_Dao", thuocService);
			context.bind(URL + "DonDat_Dao", donDatService);
			context.bind(URL + "ChiTietDonDat_Dao", chiTietDonDatService);
			context.bind(URL + "HoaDon_Dao", hoaDonService);
			context.bind(URL + "ChiTietHoaDon_Dao", chiTietHoaDonService);
			context.bind(URL + "NhaCungCap_Dao", nhaCungCapService);
			context.bind(URL + "NhanVien_Dao", nhanVienService);
			context.bind(URL + "KhachHang_Dao", khachHangService);
			context.bind(URL + "PhieuNhapThuoc_Dao", phieuNhapThuocService);
			context.bind(URL + "ChiTietPhieuNhapThuoc_Dao", chiTietPhieuNhapThuocService);
			context.bind(URL + "TaiKhoan_Dao", taiKhoanService);
			
			System.out.println("Server is running...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
