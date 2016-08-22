package apr.jpa.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_GEEK")
/** Indica acceso a los datos por getters */
@Access(AccessType.PROPERTY)
public class Geek extends Person {
	private String favouriteProgrammingLanguage;
	private List<Project> projects = new ArrayList<Project>();

	@Column(name = "FAV_PROG_LANG")
	public String getFavouriteProgrammingLanguage() {
		return favouriteProgrammingLanguage;
	}

	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
	}

	/**
	 * El atributo mappedBy indica a JPA el miembro de la clase (Project.geeks)
	 * con el que se relacciona. Esto indica que no puede existir más de una
	 * lista de proyectos para un geek
	 */
	@ManyToMany(mappedBy = "geeks")
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
