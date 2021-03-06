package pl.baduuum.shared.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cost database table.
 * 
 */
@Entity
@Table(name = "cost")
//@NamedQuery(name="Cost.findAll", query="SELECT c FROM Cost c")
public class Cost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_sequence_cost",sequenceName="seq_cost_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_cost")
	private Integer id;

	private BigDecimal cost;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	//bi-directional many-to-one association to CostSubcategory
	@ManyToOne
	@JoinColumn(name="cost_subcategory_id")
	private CostSubcategory costSubcategory;

	public Cost() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CostSubcategory getCostSubcategory() {
		return this.costSubcategory;
	}

	public void setCostSubcategory(CostSubcategory costSubcategory) {
		this.costSubcategory = costSubcategory;
	}

}