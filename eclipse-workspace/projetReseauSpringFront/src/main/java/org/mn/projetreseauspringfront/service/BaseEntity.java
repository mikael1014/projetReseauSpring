package org.mn.projetreseauspringfront.service;

import java.time.LocalDateTime;

/**
 *
 * @author Mike
 *
 */
//InFosGenerales
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
public abstract class BaseEntity {

	protected long id;

	protected LocalDateTime dateCreation;

	protected LocalDateTime dateModification;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BaseEnty{");
		sb.append("id=").append(id);
		sb.append(", dateCreation=").append(dateCreation);
		sb.append(", dateModification=").append(dateModification);
		sb.append('}');
		return sb.toString();
	}

}
