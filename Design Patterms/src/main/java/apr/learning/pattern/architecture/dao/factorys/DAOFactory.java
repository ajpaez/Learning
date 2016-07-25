package apr.learning.pattern.architecture.dao.factorys;

import apr.learning.pattern.architecture.dao.CustomerDAO;

/**
 * Factoria de DAO's segun la conexion que se desea
 * @author Antonio
 *
 */
public abstract class DAOFactory {
	
	public static final int ORACLE = 1;
	public static final int SYBASE = 3;

	//metodos que deberan implementar los DAOs Factory que se devuelvan
	public abstract CustomerDAO getCustomerDAO();

	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case ORACLE:
			return new OracleDbDAOFactory();
		case SYBASE:
			return new SybaseDbDAOFactory();	
		//resto de factorys de DAO por origen de datos
		default:
			return null;
		}
	}
}
