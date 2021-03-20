package fa.training.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class Khachhang {
	@Id
	@Column(name = "MaKH", columnDefinition = "varchar(10)")
	private String maKH;

	@Column(name = "TenKH", columnDefinition = "varchar(50)")
	private String tenKH;

	@Column(name = "DiaChi",columnDefinition = "varchar(255)")
	private String diaChi;

	@Column(name = "SoDienThoai", columnDefinition = "varchar(12)")
	private String soDienThoai;

	@Column(name = "DiaChiEmail", columnDefinition = "varchar(30)")
	private String diachiEmail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "khachhang")
	private Set<SuDungMay> suDungMays;
	
	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String dicChi) {
		this.diaChi = dicChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiachiEmail() {
		return diachiEmail;
	}

	public void setDiachiEmail(String diachiEmail) {
		this.diachiEmail = diachiEmail;
	}

	public Khachhang() {
		super();
	}

	public Khachhang(String maKH, String tenKH, String dicChi, String soDienThoai, String diachiEmail) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = dicChi;
		this.soDienThoai = soDienThoai;
		this.diachiEmail = diachiEmail;
	}

	@Override
	public String toString() {
		return "Khachhang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", diachiEmail=" + diachiEmail + "]";
	}

}
