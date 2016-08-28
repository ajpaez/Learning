package apr.jpa.dao.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import apr.jpa.dao.model.converters.CryptoConverter;

@Entity
@Table(name = "T_CREADIT_CARD")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CC_NUMBER")
	@Convert(converter = CryptoConverter.class)
	private String ccNumber;

	@Column(name = "NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

}
