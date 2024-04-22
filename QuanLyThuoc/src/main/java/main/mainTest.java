package main;

import java.time.LocalDate;

import dao.ChiTietDonDat_Dao;
import dao.impl.ChiTietDonDat_Impl;
import entity.ChiTietDonDat;
import entity.ChiTietHoaDon;
import entity.DonDat;
import entity.HoaDon;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class mainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyThuoc MSSQL");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			System.out.println("Hello World");
/**			Quy trình tổng quát: có khách hàng, tạo hóa đơn/đơn đặt không có chi tiết, tạo chi tiết hóa đơn/đơn đặt, thêm vào hóa đơn/đơn đặt, hiển thị
			Có khách hàng: thêm khách hàng mới, tìm khách hàng theo tên, tìm theo số đt
			--> Xong
			Tạo hóa đơn/đơn đặt không có chi tiết: thêm hóa đơn/đơn đặt không có chi tiết, tìm hóa đơn/đơn đặt theo mã
			--> ????
			Tạo chi tiết hóa đơn/đơn đặt: tạo chi tiết hóa đơn/đơn đặt theo mã hóa đơn/đơn đặt
			Thêm chi tiết hóa đơn/đơn đặt: thêm chi tiết vào hóa đơn, đơn đặt
			Thống kê: tìm hóa đơn, đơn đặt theo tên khách hàng, theo ngày lập, theo ngày nhận, đếm số hóa đơn theo ngày lập, theo ngày nhận, theo nhân viên, theo khách hàng
*/
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
