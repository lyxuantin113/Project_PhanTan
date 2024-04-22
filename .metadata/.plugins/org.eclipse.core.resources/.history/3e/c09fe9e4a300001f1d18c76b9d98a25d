package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

	@Id
	@Column(name = "maNCC")
	private String maNCC;

	@Column(name = "tenNCC")
	private String tenNCC;

	@Column(name = "soDienThoai")
	private String soDienThoai;

	@Column(name = "diaChiNCC")
	private String diaChiNCC;

	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(String maNCC, String tenNCC, String soDienThoai, String diaChiNCC) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.soDienThoai = soDienThoai;
		this.diaChiNCC = diaChiNCC;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiNCC() {
		return diaChiNCC;
	}

	public void setDiaChiNCC(String diaChiNCC) {
		this.diaChiNCC = diaChiNCC;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", soDienThoai=" + soDienThoai + ", diaChiNCC="
				+ diaChiNCC + "]";
	}

}
