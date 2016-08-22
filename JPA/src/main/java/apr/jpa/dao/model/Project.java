package apr.jpa.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROJECT")
public class Project {

	private Long id;
	private String title;

	private List<Geek> geeks = new ArrayList<Geek>();

	private ProjectType projectType;

	private Period projectPeriod;

	private List<Period> billingPeriods = new ArrayList<Period>();

	// es posible mapear tipos enum a BD
	public enum ProjectType {
		FIXED, TIME_AND_MATERIAL
	}

	@Id
	@GeneratedValue
	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "S_PROJECT")
	 * 
	 * @SequenceGenerator(name = "S_PROJECT", sequenceName = "S_PROJECT",
	 * allocationSize = 100)
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Para una relacción ManyToMany necesitamos una tabla adicional. Esta tabla
	 * es configurada por la anotación JoinTable que describe como se almacenan
	 * los geek y los diferentes proyectos. Se creará una tabla con
	 * T_GEEK_PROJECT que tendrá dos referencias, una a Project.id y otra a
	 * Geek.id.
	 * 
	 * Lar relacciones ManyToMany son por defecto Lazy. Como una relacción
	 * ManyToMany es igual en ambos lados, podríamos anotar las dos listas de
	 * ambas clases a la inversa.
	 */
	@ManyToMany
	@JoinTable(name = "T_GEEK_PROJECT", joinColumns = {
			@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "GEEK_ID", referencedColumnName = "ID") })
	public List<Geek> getGeeks() {
		return geeks;
	}

	public void setGeeks(List<Geek> geeks) {
		this.geeks = geeks;
	}

	/**
	 * La anotación Enumerated nos permite mapear las enumeraciones a columnas
	 * de base de datos. La elección de EnumType.ORDINAL significa que cada
	 * constante de la enum es mapedad como un número específico en base de
	 * datos. También se puede mapear como string, en éste caso la columna es de
	 * tipo String y codifica la enumeración llamando a su método name()
	 * 
	 */
	@Enumerated(EnumType.STRING)
	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	@Embedded
	public Period getProjectPeriod() {
		return projectPeriod;
	}

	public void setProjectPeriod(Period projectPeriod) {
		this.projectPeriod = projectPeriod;
	}

	/**
	 * Desde la version 2.0 de JPA tú puedes incluso usar entitys Embeddable en
	 * relacciones OneToMany. Esto se consigue mediante el uso de las
	 * anotaciones ElementCollection y CollectionTable. Esta relacción crea una
	 * nueva tabla T_BILLING_PERIOD, con la clave primaria del proyecto y los
	 * campos de la entidad embeddable
	 */
	@ElementCollection
	@CollectionTable(name = "T_BILLING_PERIOD", joinColumns = @JoinColumn(name = "PROJECT_ID") )
	public List<Period> getBillingPeriods() {
		return billingPeriods;
	}

	public void setBillingPeriods(List<Period> billingPeriods) {
		this.billingPeriods = billingPeriods;
	}
}
