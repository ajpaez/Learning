package apr.learning.pattern.architecture.dao.bo;

/**
 * Objeto que manejaran los dao. Business Object
 * @author Antonio
 *
 */
public class Customer {
	
	private String name;
	private int Id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int newCustNo) {
		this.Id= newCustNo;
		
	}

	public int getId() {
		return this.Id;
		
	}
	
	

}
