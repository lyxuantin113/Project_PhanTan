package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

	@Id
	@OneToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNhanVien;

	@Column(name = "taiKhoan")
	private String taiKhoan;

	@Column(name = "matKhau")
	private String matKhau;

	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(NhanVien maNhanVien, String taiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maNhanVien=" + maNhanVien + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + "]";
	}

}
