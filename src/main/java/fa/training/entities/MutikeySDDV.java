package fa.training.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

public class MutikeySDDV implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name = "MaMay", columnDefinition = "varchar(10)")
	private String key1;

	@Column(name = "MaDV", columnDefinition = "varchar(10)")
	private String key2;

	@Column(name = "NgaySuDung", columnDefinition = "date")
	private LocalDate key3;

	@Column(name = "GioSuDung")
	private LocalTime key4;

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public LocalDate getKey3() {
		return key3;
	}

	public void setKey3(LocalDate key3) {
		this.key3 = key3;
	}

	public LocalTime getKey4() {
		return key4;
	}

	public void setKey4(LocalTime key4) {
		this.key4 = key4;
	}

	
}
