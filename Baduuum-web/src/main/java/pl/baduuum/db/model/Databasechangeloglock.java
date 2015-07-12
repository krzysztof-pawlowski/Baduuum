package pl.baduuum.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the databasechangeloglock database table.
 * 
 */
@Entity
@NamedQuery(name="Databasechangeloglock.findAll", query="SELECT d FROM Databasechangeloglock d")
public class Databasechangeloglock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean locked;

	private String lockedby;

	private Timestamp lockgranted;

	public Databasechangeloglock() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getLockedby() {
		return this.lockedby;
	}

	public void setLockedby(String lockedby) {
		this.lockedby = lockedby;
	}

	public Timestamp getLockgranted() {
		return this.lockgranted;
	}

	public void setLockgranted(Timestamp lockgranted) {
		this.lockgranted = lockgranted;
	}

}