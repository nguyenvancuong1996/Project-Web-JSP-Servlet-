package fa.training.dao;

import java.util.List;

import fa.training.entities.DichVu;


public interface DichVuDao {

	public boolean save(DichVu dichvu);

	public DichVu getDichVu(String maDv);

	public boolean update(DichVu dv);

	public void deleteByID(String maDv);

	public void delete(DichVu dichvu);

	public List<DichVu> getAllDichVu();
}
