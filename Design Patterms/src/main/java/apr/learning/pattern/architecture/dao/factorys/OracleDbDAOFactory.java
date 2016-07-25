package apr.learning.pattern.architecture.dao.factorys;

import java.sql.Connection;

import apr.learning.pattern.architecture.dao.CustomerDAO;
import apr.learning.pattern.architecture.dao.impl.CustomerDAOImpl;

/**
 * Clase que actua de factory para los distintos DAO's manejados por
 * la conexion a base de datos en oracle
 * @author Antonio
 *
 */
public class OracleDbDAOFactory extends DAOFactory{

	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@[host]:[port]:[sid]";

	static Connection c;
	
	public static void createConnection() {
		c = null;
	}

	public CustomerDAO getCustomerDAO() {
		// OracleDbCustomerDAO implements CustomerDAO
		return new CustomerDAOImpl(c);
	}
	
	//resto de DAOs para las diferentes tablas de oracle

}
