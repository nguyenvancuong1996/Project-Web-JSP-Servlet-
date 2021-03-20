package fa.training.dao;

import java.util.List;

import fa.training.entities.May;

public interface MayDao {
	public boolean save(May may);
	
	public May getMay(String maMay);

	public boolean update(May string);

	public boolean deleteByID(String maMay);

	public void delete(May may);

	public List<May> getAllMay();
}
