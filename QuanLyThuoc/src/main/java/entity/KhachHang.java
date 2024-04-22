package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "KhachHang")
@NamedQueries({ @NamedQuery(name = "KhachHang.findAll", query = "SELECT kh FROM KhachHang kh"),
		@NamedQuery(name = "KhachHang.findByMaKhachHang", query = "SELECT kh FROM KhachHang kh WHERE kh.maKhachHang = :maKhachHang"),
		@NamedQuery(name = "KhachHang.findKhachHangByName", query = "SELECT kh FROM KhachHang kh WHERE kh.tenKhachHang like :tenKhachHang"),
		@NamedQuery(name = "KhachHang.findKhachHangBySDT", query = "SELECT kh FROM KhachHang kh WHERE kh.soDienThoai = :soDienThoai"),})
public class KhachHang implements Serializable{

	private static final long serialVersionUID = 965874523652145877L;
	
	@Id
	@Column(name = "maKhachHang")
	private String maKhachHang;

	@Column(name = "soDienThoai")
	private String soDienThoai;

	@Column(name = "tenKhachHang")
	private String tenKhachHang;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai + ", tenKhachHang="
				+ tenKhachHang + "]";
	}

}
