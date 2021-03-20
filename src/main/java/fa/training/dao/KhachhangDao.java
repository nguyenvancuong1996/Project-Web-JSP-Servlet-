package fa.training.dao;

import java.util.List;

import fa.training.entities.Khachhang;

public interface KhachhangDao {

	public boolean save(Khachhang khachhang);

	public Khachhang getKhachhang(String maKh);

	public boolean update(Khachhang khachhang);

	public void deleteByID(String maKH);

	public void delete(Khachhang khachhang);

	public List<Khachhang> getAllKhachhang();
}
