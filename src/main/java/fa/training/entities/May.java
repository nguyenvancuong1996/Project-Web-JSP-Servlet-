package fa.training.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "May")
public class May implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaMay", columnDefinition = "varchar(10)")

	private String maMay;

	@Column(name = "Vitri", columnDefinition = "varchar(50)")
	private String viTri;

	@Column(name = "TrangThai", columnDefinition = "varchar(50)")
	private String trangThai;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "may")
	private Set<SuDungMay> suDungMays;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "may")
	private Set<SuDungDichVu> suDungDichVus;

	public Set<SuDungMay> getSuDungMays() {
		return suDungMays;
	}

	public void setSuDungMays(Set<SuDungMay> suDungMays) {
		this.suDungMays = suDungMays;
	}

	public Set<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(Set<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public May() {
		super();
	}

	public May(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "May [maMay=" + maMay + ", viTri=" + viTri + ", trangThai=" + trangThai + "]";
	}

}
