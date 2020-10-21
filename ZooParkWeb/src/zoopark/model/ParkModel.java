package zoopark.model;

import java.sql.SQLException;
import java.util.Collection;

public interface ParkModel<T> {
	public T doRetrievebyKey(int key) throws SQLException;
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	public void doSave(T ruolo) throws SQLException;
	public void doUpdate(T ruolo) throws SQLException;
	public void doDelete(String key) throws SQLException;

}
