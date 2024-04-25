package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Thuoc")
public class Thuoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7834018117303079856L;

	@Id
	@Column(name = "maThuoc")
	private String maThuoc;

	@Column(name = "tenThuoc")
	private String tenThuoc;

	@Column(name = "loaiThuoc")
	private String loaiThuoc;

	@Column(name = "donVi")
	private String donVi;

	@Column(name = "hanSuDung")
	private LocalDate hanSuDung;

	@Column(name = "giaNhap")
	private double giaNhap;

	@Column(name = "giaBan")
	private double giaBan;

	@Column(name = "soLuongTon")
	private int soLuongTon;

	@Column(name = "nuocSanXuat")
	private String nuocSanXuat;

	@Column(name = "maNCC")
	private String maNCC;

	public Thuoc() {
		// TODO Auto-generated constructor stub
	}

	public Thuoc(String maThuoc, String tenThuoc, String loaiThuoc, String donVi, LocalDate hanSuDung, double giaNhap,
			double giaBan, int soLuongTon, String nuocSanXuat, String maNCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.loaiThuoc = loaiThuoc;
		this.donVi = donVi;
		this.hanSuDung = hanSuDung;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.nuocSanXuat = nuocSanXuat;
		this.maNCC = maNCC;
	}

	public String getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public LocalDate getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(LocalDate hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", loaiThuoc=" + loaiThuoc + ", donVi=" + donVi
				+ ", hanSuDung=" + hanSuDung + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon="
				+ soLuongTon + ", nuocSanXuat=" + nuocSanXuat + ", maNCC=" + maNCC + "]";
	}

}
