package entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhieuNhapThuoc")
@NamedQueries({ 
    @NamedQuery(name = "PhieuNhapThuoc.readFromTableSort", query = "SELECT pnt FROM PhieuNhapThuoc pnt ORDER BY pnt.trangThai DESC, pnt.ngayNhap ASC"),
    @NamedQuery(name = "PhieuNhapThuoc.updateTrangThai", query = "UPDATE PhieuNhapThuoc pnt SET pnt.trangThai = 1 WHERE pnt.maPhieuNhap = :maPhieuNhap"),
    @NamedQuery(name = "PhieuNhapThuoc.findByMaPhieuNhap", query = "SELECT pnt FROM PhieuNhapThuoc pnt WHERE pnt.maPhieuNhap = :maPhieuNhap"),
    @NamedQuery(name = "PhieuNhapThuoc.findByMaNCC", query = "SELECT pnt FROM PhieuNhapThuoc pnt WHERE pnt.maNCC = :maNCC"),
    @NamedQuery(name = "PhieuNhapThuoc.findByMaNV", query = "SELECT pnt FROM PhieuNhapThuoc pnt WHERE pnt.maNV = :maNV"),
    @NamedQuery(name = "PhieuNhapThuoc.findByNgayNhap", query = "SELECT pnt FROM PhieuNhapThuoc pnt WHERE pnt.ngayNhap = :ngayNhap"),
    @NamedQuery(name = "PhieuNhapThuoc.findByTongTien", query = "SELECT pnt FROM PhieuNhapThuoc pnt WHERE pnt.tongTien = :tongTien"),
    @NamedQuery(name= "PhieuNhapThuoc.checkThuoc", query = "SELECT pnt FROM PhieuNhapThuoc pnt JOIN pnt.listChiTiet ct WHERE ct.maThuoc = :maThuoc AND pnt.trangThai = 0"),
    @NamedQuery(name = "PhieuNhapThuoc.delete", query = "DELETE FROM PhieuNhapThuoc pnt WHERE pnt.maPhieuNhap = :maPhieuNhap")
})
public class PhieuNhapThuoc {
	@Id
	@Column(name = "maPhieuNhap")
	private String maPhieuNhap;
	
	@ManyToOne
	@JoinColumn(name = "maNCC")
	private NhaCungCap maNhaCungCap;
	
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien maNhanVien;
	
	@Column(name = "ngayNhap")
	private LocalDate ngayNhap;
	
	@Column(name = "tongTien")
	private double tongTien;
	
	@Column(name = "trangThai")
	private boolean trangThai;
	
	@OneToMany(mappedBy = "maPhieuNhap", fetch = FetchType.LAZY)
	private List<ChiTietPhieuNhapThuoc> listChiTiet;
	
	public PhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}
	
	

	



	public PhieuNhapThuoc(String maPhieuNhap, NhaCungCap maNhaCungCap, NhanVien maNhanVien, LocalDate ngayNhap,
			double tongTien, boolean trangThai, List<ChiTietPhieuNhapThuoc> listChiTiet) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNhaCungCap = maNhaCungCap;
		this.maNhanVien = maNhanVien;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
		this.listChiTiet = listChiTiet;
	}







	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	
	

	public NhaCungCap getMaNCC() {
		return maNhaCungCap;
	}



	public void setMaNhaCungCap(NhaCungCap maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}



	public NhanVien getMaNV() {
		return maNhanVien;
	}



	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}



	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
	public List<ChiTietPhieuNhapThuoc> getListChiTiet() {
		return listChiTiet;
	}



	public void setListChiTiet(List<ChiTietPhieuNhapThuoc> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}



	@Override
	public String toString() {
		return "PhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maNhaCungCap=" + maNhaCungCap + ", maNhanVien="
				+ maNhanVien + ", ngayNhap=" + ngayNhap + ", tongTien=" + tongTien + ", trangThai=" + trangThai
				+ ", listChiTiet=" + listChiTiet + "]";
	}



	
	
	
	
	
}
