package apr.learning.pattern.architecture.dao.factorys;

import java.sql.Connection;

import apr.learning.pattern.architecture.dao.CustomerDAO;
import apr.learning.pattern.architecture.dao.impl.CustomerDAOImpl;

/**
 * Clase que actua de factory para los distintos DAO's manejados por
 * la conexion a base de datos en sybase
 * @author Antonio
 *
 */
public class SybaseDbDAOFactory extends DAOFactory{

	public static final String DRIVER = "com.sybase.jdbc2.jdbc.SybDriver";
	public static final String DBURL = "jdbc:sybase:Tds:server-name:server-port";
	
	static Connection c;
	
	
	public static void createConnection() {
		c = null;
	}

	public CustomerDAO getCustomerDAO() {
		// OracleDbCustomerDAO implements CustomerDAO
		return new CustomerDAOImpl(c);
	}
	
	//resto de DAOs para las diferentes tablas de sybase

}
