package apr.jpa.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_PHONE")
public class Phone {
	private Long id;
	private String number;
	private Person person;

	@Id
	@GeneratedValue()
	/*
	 * @GeneratedValue(strategy = GenerationType.TABLE, generator =
	 * "TABLE_GENERATOR")
	 * 
	 * @TableGenerator(name = "TABLE_GENERATOR", table = "T_SEQUENCES",
	 * pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue =
	 * "PHONE")
	 */
	/** Cada teléfono tiene un identificador interno, así como el número. */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NUMBER")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * relación con la persona ( ManyToOne ), como podemos tener "varios"
	 * teléfonos para "una" persona. La anotacion JoinColumn especifica la
	 * columna en la tabla T_PHONE que almacena la clave externa de la persona.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
