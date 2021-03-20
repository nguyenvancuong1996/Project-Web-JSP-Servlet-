package fa.training.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author HCD-Fresher107
 *
 */
@Entity
@Table(name = "SuDungMay")
public class SuDungMay {

	@EmbeddedId
	private MultiKeySDM multiKey;

	@Column(name = "ThoiGianSuDung")
	private LocalTime thoigianSuDung;

	@ManyToOne
	@JoinColumn(name = "MaKH", referencedColumnName = "MaKH", columnDefinition = "varchar(10)", insertable = false, updatable = false)
	private Khachhang khachhang;

	@ManyToOne
	@JoinColumn(name = "MaMay", referencedColumnName = "MaMay", columnDefinition = "varchar(10)", insertable = false, updatable = false)
	private May may;

	public MultiKeySDM getMultiKey() {
		return multiKey;
	}

	public void setMultiKey(MultiKeySDM multiKey) {
		this.multiKey = multiKey;
	}

	public LocalTime getThoigianSuDung() {
		return thoigianSuDung;
	}

	public void setThoigianSuDung(LocalTime thoigianSuDung) {
		this.thoigianSuDung = thoigianSuDung;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public SuDungMay(MultiKeySDM multiKey, LocalTime thoigianSuDung) {
		super();
		this.multiKey = multiKey;
		this.thoigianSuDung = thoigianSuDung;
	}

	public SuDungMay(MultiKeySDM multiKey, LocalTime thoigianSuDung, Khachhang khachhang, May may) {
		super();
		this.multiKey = multiKey;
		this.thoigianSuDung = thoigianSuDung;
		this.khachhang = khachhang;
		this.may = may;
	}

	@Override
	public String toString() {
		return "SuDungMay [multiKey=" + multiKey + ", thoigianSuDung=" + thoigianSuDung + ", khachhang=" + khachhang
				+ ", may=" + may + "]";
	}

}
