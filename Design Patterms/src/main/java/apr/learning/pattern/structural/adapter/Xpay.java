package apr.learning.pattern.structural.adapter;

/**
 * @author Antonio
 * Contiene getters y setters para la información acerca de la tarjeta de crédito y el nombre del cliente. 
 * Esta interfaz expone el objeto al API del proveedor.
 */

public interface Xpay {
	
	public String getCreditCardNo();
	public String getCustomerName();
	public String getCardExpMonth();
	public String getCardExpYear();
	public Short getCardCVVNo();
	public Double getAmount();
	
	public void setCreditCardNo(String creditCardNo);
	public void setCustomerName(String customerName);
	public void setCardExpMonth(String cardExpMonth);
	public void setCardExpYear(String cardExpYear);
	public void setCardCVVNo(Short cardCVVNo);
	public void setAmount(Double amount);
	
}
