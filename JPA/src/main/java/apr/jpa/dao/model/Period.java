package apr.jpa.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Si lo que se desea es estructurar el modelo Java de forma más fina que el
 * modelo de base de datos, esto puede hacerse con la anotación Embeddable. Un
 * ejemplo de uso para este caso es la clase Java Period que modela el tiempo
 * entre un inicio y una fecha de finalización. Esta clase la pueden reutilizar
 * diferentes entidades, ya que no se desea copiar los dos campos de la clase:
 * startDate y endDate, en cada entidad que tiene un período de tiempo.
 *
 */
@Embeddable
public class Period {
	private Date startDate;
	private Date endDate;

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
