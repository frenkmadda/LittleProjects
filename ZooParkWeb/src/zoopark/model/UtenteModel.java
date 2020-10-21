package zoopark.model;

import java.sql.SQLException;
import java.util.Collection;

public interface UtenteModel<T> {
	public T doRetrievebyKey(String key) throws SQLException;
	public T doRetrievebyName(String key) throws SQLException;
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	public void doSave(T utente) throws SQLException;
	public void doUpdate(T utente) throws SQLException;
	public void doDelete(String key) throws SQLException;
	public void doUpdateTicket(T utente) throws SQLException;
}
