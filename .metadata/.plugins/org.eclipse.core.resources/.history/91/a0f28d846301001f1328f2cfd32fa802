package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien")
@NamedQueries({ // JPQL
		@NamedQuery(name = "NhanVien.findAll", query = "select n from NhanVien n"),
		@NamedQuery(name = "NhanVien.findByTenNV", query = "select n from NhanVien n where n.tenNhanVien like :tenNhanVien"),
		})
public class NhanVien implements Serializable {

	@Id
	@Column(name = "maNhanVien")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maNhanVien;

	@Column(name = "tenNhanVien", nullable = false)
	private String tenNhanVien;

	@Column(name = "soDienThoai", unique = true, nullable = false)
	private String soDienThoai;

	@Column(name = "chucVu", nullable = false)
	private String chucVu;

	@Column(name = "email")
	private String email;

//	@OneToMany(mappedBy = "NhanVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<HoaDon> listHoaDon = new HashSet<>();
//
//	@OneToMany(mappedBy = "NhanVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<DonDat> listDonDatThuoc = new HashSet<>();

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Set<HoaDon> getListHoaDon() {
//		return listHoaDon;
//	}
//
//	public void setListHoaDon(Set<HoaDon> listHoaDon) {
//		this.listHoaDon = listHoaDon;
//	}
//
//	public Set<DonDat> getListDonDatThuoc() {
//		return listDonDatThuoc;
//	}
//
//	public void setListDonDatThuoc(Set<DonDat> listDonDatThuoc) {
//		this.listDonDatThuoc = listDonDatThuoc;
//	}

	public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String chucVu, String email) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
		this.email = email;
	}

	public NhanVien() {
		super();
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", soDienThoai=" + soDienThoai
				+ ", chucVu=" + chucVu + ", email=" + email + "]";
	}


}
