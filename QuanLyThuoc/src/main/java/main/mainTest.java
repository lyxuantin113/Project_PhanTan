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

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
