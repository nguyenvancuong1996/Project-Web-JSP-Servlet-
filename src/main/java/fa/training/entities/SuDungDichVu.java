package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SuDungDichVu")
public class SuDungDichVu {

	@EmbeddedId
	private MutikeySDDV mutikeySDDV;

	@Column(name = "SoLuong", columnDefinition = "int")
	private int soLuong;

	@ManyToOne
	@JoinColumn(name = "MaMay", referencedColumnName = "MaMay", columnDefinition = "varchar(10)", insertable = false, updatable = false)
	private May may;

	@ManyToOne
	@JoinColumn(name = "MaDV", referencedColumnName = "MaDV", columnDefinition = "varchar(10)", insertable = false, updatable = false)
	private DichVu dichVu;

	public MutikeySDDV getMutikeySDDV() {
		return mutikeySDDV;
	}

	public void setMutikeySDDV(MutikeySDDV mutikeySDDV) {
		this.mutikeySDDV = mutikeySDDV;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public SuDungDichVu(MutikeySDDV mutikeySDDV, int soLuong) {
		super();
		this.mutikeySDDV = mutikeySDDV;
		this.soLuong = soLuong;
	}

	public SuDungDichVu(MutikeySDDV mutikeySDDV, int soLuong, May may, DichVu dichVu) {
		super();
		this.mutikeySDDV = mutikeySDDV;
		this.soLuong = soLuong;
		this.may = may;
		this.dichVu = dichVu;
	}

	@Override
	public String toString() {
		return "SuDungDichVu [mutikeySDDV=" + mutikeySDDV + ", soLuong=" + soLuong + ", may=" + may + ", dichVu="
				+ dichVu + "]";
	}

}
