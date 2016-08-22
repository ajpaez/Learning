package apr.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import apr.jpa.dao.model.Geek;
import apr.jpa.dao.model.IdCard;
import apr.jpa.dao.model.Period;
import apr.jpa.dao.model.Person;
import apr.jpa.dao.model.Phone;
import apr.jpa.dao.model.Project;
import apr.jpa.entitymanager.EntityManagerFactorySingleton;

public class App {
	private static final Logger LOGGER = Logger.getLogger("JPA");

	public static void main(String[] args) {
		// System.out.println("isOpen? : " +
		// EntityManagerFactorySingleton.INSTANCE.getEntityManager().isOpen());
		persistPerson(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		persistGeek(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		addPhones(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		createProject(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		queryProject(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		getPersonAndGeek(EntityManagerFactorySingleton.INSTANCE.getEntityManager());
		EntityManagerFactorySingleton.INSTANCE.cerrar();
	}

	private static void persistPerson(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Person person = new Person();
			person.setFirstName("Homer");
			person.setLastName("Simpson");
			entityManager.persist(person);
			IdCard idCard = new IdCard();
			idCard.setIdNumber("4711");
			idCard.setIssueDate(new Date());
			person.setIdCard(idCard);
			entityManager.persist(idCard);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	private static void addPhones(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> query = builder.createQuery(Person.class);
		Root<Person> personRoot = query.from(Person.class);
		query.where(builder.and(builder.equal(personRoot.get("firstName"), "Homer"),
				builder.equal(personRoot.get("lastName"), "Simpson")));
		List<Person> resultList = entityManager.createQuery(query).getResultList();
		for (Person person : resultList) {
			Phone phone = new Phone();
			phone.setNumber("+49 1234 456789");
			entityManager.persist(phone);
			person.getPhones().add(phone);
			phone.setPerson(person);
		}
		transaction.commit();
	}

	private static void persistGeek(EntityManager entityManager) {
		// hibernate creará las entradas en la tabla de personas necesarias
		// y el resto de la informacion para la entidad geek se almacenará
		// en su tabla. Esto se debe a la anotacion @Inheritance(strategy =
		// InheritanceType.JOINED) en Person
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Geek geek = new Geek();
		geek.setFirstName("Gavin");
		geek.setLastName("Coffee");
		geek.setFavouriteProgrammingLanguage("Java");
		entityManager.persist(geek);
		geek = new Geek();
		geek.setFirstName("Thomas");
		geek.setLastName("Micro");
		geek.setFavouriteProgrammingLanguage("C#");
		entityManager.persist(geek);
		geek = new Geek();
		geek.setFirstName("Christian");
		geek.setLastName("Cup");
		geek.setFavouriteProgrammingLanguage("Java");
		entityManager.persist(geek);
		transaction.commit();
	}

	private static void createProject(EntityManager entityManager) {
		List<Geek> resultList = entityManager
				.createQuery("from Geek where favouriteProgrammingLanguage = :fpl", Geek.class)
				.setParameter("fpl", "Java").getResultList();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Project project = new Project();
		project.setTitle("Java Project");
		project.setProjectType(Project.ProjectType.TIME_AND_MATERIAL);
		Period period = new Period();
		period.setStartDate(createDate(1, 1, 2015));
		period.setEndDate(createDate(31, 12, 2015));
		project.setProjectPeriod(period);
		for (Geek geek : resultList) {
			project.getGeeks().add(geek);
			geek.getProjects().add(project);
		}
		entityManager.persist(project);
		transaction.commit();
	}

	private static void queryProject(EntityManager entityManager) {
		TypedQuery<Project> query = entityManager
				.createQuery("from Project p where p.projectPeriod.startDate = :startDate", Project.class)
				.setParameter("startDate", createDate(1, 1, 2015));
		List<Project> resultList = query.getResultList();
		for (Project project : resultList) {
			LOGGER.info(project.getProjectPeriod().getStartDate().toString());
		}
	}

	private static void getPersonAndGeek(EntityManager entityManager) {
		entityManager.clear();
		TypedQuery<Person> query = entityManager.createQuery("from Person p", Person.class);
		List<Person> resultList = query.getResultList();
		for (Person person : resultList) {
			StringBuilder sb = new StringBuilder();
			sb.append(person.getFirstName()).append(" ").append(person.getLastName());
			if (person instanceof Geek) {
				Geek geek = (Geek) person;
				sb.append(" ").append(geek.getFavouriteProgrammingLanguage());
			}
			IdCard idCard = person.getIdCard();
			if (idCard != null) {
				sb.append(" ").append(idCard.getIdNumber()).append(" ").append(idCard.getIssueDate());
			}
			List<Phone> phones = person.getPhones();
			for (Phone phone : phones) {
				sb.append(" ").append(phone.getNumber());
			}
			LOGGER.info(sb.toString());
		}
	}

	private static Date createDate(int day, int month, int year) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.DAY_OF_MONTH, day);
		gc.set(Calendar.MONTH, month - 1);
		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		return new Date(gc.getTimeInMillis());
	}
}
