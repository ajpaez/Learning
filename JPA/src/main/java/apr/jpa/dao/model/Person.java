package apr.jpa.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_PERSON")
/**
 * indica que las anotaciones se realizan a nivel de campo, PROPERTY a nivel de
 * metodo
 */
@Access(AccessType.FIELD)
/**
 * indica la forma en la que se almacenarán los tipos person y todos sus
 * subtipos
 */
@Inheritance(strategy = InheritanceType.JOINED)
/**
 * Esta anotación crea una nueva columna, se usará para indicar el tipo de
 * persona almacenada en base de datos. Aquí podemos cambiar el nombre de la
 * columna o el tipo usado para identificar a cada elemento
 * 
 */
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;

	/**
	 * Esta columna en la tabla T_PERSON contendrá una clave foranea a la tabla
	 * T_ID_CARD, que será almacenada en la columna ID_CARD_ID. El valor
	 * FetchType.EAGER es el valor por defecto y especifica que cada vez que
	 * cargamos una persona también queremos que se cargue la tarjeta de
	 * identificación de esta. Por otro lado, podemos especificar que sólo
	 * queremos cargar la tarjeta cuando realmente acceder a ella llamando
	 * person.getIdCard (): @OneToOne(fetch = FetchType.LAZY)
	 * 
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARD_ID")
	private IdCard idCard;

	/**
	 * En la clase person anotamos que "una" persona tiene "muchos" teléfonos
	 * OneToMany. El valor del atributo mappedBy indica a JPA qué lista en el
	 * otro lado de la relacción tiene que mapear, en este caso Phone.person
	 */
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Phone> phones = new ArrayList<Phone>();

	/**
	 * NOTA: Las anotaciones de Column pueden añadirse en su lugar a los metodos
	 * getters. Esto se usa para la herencia de Entitys, si añadimos la
	 * anotación al campo no podemos sobreescribirla como si podemos hacerlo
	 * cuando sobreescribimos los metodos getters. No se pueden mezclar ambas
	 * formas para un entity y sus subclases, si se necesitara se debe indicar
	 * como se está haciendo con Access
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
