package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietHoaDon")
@NamedQueries({
	@NamedQuery(name = "ChiTietHoaDon.findByID", query = "SELECT cthd FROM ChiTietHoaDon cthd WHERE cthd.maHoaDon = :maHoaDon"),
	@NamedQuery(name = "ChiTietHoaDon.deleteOne", query = "DELETE FROM ChiTietHoaDon cthd WHERE cthd.maThuoc = :maThuoc"),
})
public class ChiTietHoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "maHoaDon")
	private HoaDon maHoaDon;

	@ManyToOne
	@JoinColumn(name = "maThuoc")
	private Thuoc maThuoc;

	@Column(name = "soLuong")
	private int soLuong;

	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon maHoaDon, Thuoc maThuoc, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public ChiTietHoaDon(Thuoc maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}
	
	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [id=" + id + ", maHoaDon=" + maHoaDon + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				+ "]";
	}

}
