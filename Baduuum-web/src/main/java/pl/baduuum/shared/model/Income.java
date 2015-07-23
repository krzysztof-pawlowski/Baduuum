package pl.baduuum.shared.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the income database table.
 * 
 */
@Entity
@Table(name = "income")
//@NamedQuery(name="Income.findAll", query="SELECT i FROM Income i")
public class Income implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to IncomeCategory
	@ManyToOne
	@JoinColumn(name="income_category_id")
	private IncomeCategory incomeCategory;

	//bi-directional many-to-one association to Reservation
	@ManyToOne
	private Reservation reservation;

	public Income() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IncomeCategory getIncomeCategory() {
		return this.incomeCategory;
	}

	public void setIncomeCategory(IncomeCategory incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}