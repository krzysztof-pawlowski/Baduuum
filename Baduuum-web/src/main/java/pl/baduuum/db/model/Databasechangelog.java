package pl.baduuum.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the databasechangelog database table.
 * 
 */
@Entity
@NamedQuery(name="Databasechangelog.findAll", query="SELECT d FROM Databasechangelog d")
public class Databasechangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	private String author;

	private String comments;

	private String contexts;

	private Timestamp dateexecuted;

	private String description;

	private String exectype;

	private String filename;

	private String id;

	private String labels;

	private String liquibase;

	private String md5sum;

	private Integer orderexecuted;

	private String tag;

	public Databasechangelog() {
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContexts() {
		return this.contexts;
	}

	public void setContexts(String contexts) {
		this.contexts = contexts;
	}

	public Timestamp getDateexecuted() {
		return this.dateexecuted;
	}

	public void setDateexecuted(Timestamp dateexecuted) {
		this.dateexecuted = dateexecuted;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExectype() {
		return this.exectype;
	}

	public void setExectype(String exectype) {
		this.exectype = exectype;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabels() {
		return this.labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getLiquibase() {
		return this.liquibase;
	}

	public void setLiquibase(String liquibase) {
		this.liquibase = liquibase;
	}

	public String getMd5sum() {
		return this.md5sum;
	}

	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}

	public Integer getOrderexecuted() {
		return this.orderexecuted;
	}

	public void setOrderexecuted(Integer orderexecuted) {
		this.orderexecuted = orderexecuted;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}