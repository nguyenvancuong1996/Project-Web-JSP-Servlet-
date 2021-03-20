package fa.training.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DichVu")
public class DichVu {

	@Id
	@Column(name = "MaDV", columnDefinition = "varchar(10)")
	private String maDV;

	@Column(name = "TenDV")
	private String tenDV;

	@Column(name = "DonViTinh", columnDefinition = "varchar(3)")
	private String donViTinh;

	@Column(name = "DonGia", columnDefinition = "float")
	private double donGia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dichVu")
	private Set<SuDungDichVu> suDungDichVus;

	public Set<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(Set<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public DichVu() {
		super();
	}

	public DichVu(String maDV, String tenDV, String donViTinh, double donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh + ", donGia=" + donGia + "]";
	}

}
