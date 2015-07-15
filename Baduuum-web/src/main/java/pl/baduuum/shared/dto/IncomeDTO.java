package pl.baduuum.shared.dto;

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
@NamedQuery(name="Income.findAll", query="SELECT i FROM Income i")
public class IncomeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to IncomeCategory
	@ManyToOne
	@JoinColumn(name="income_category_id")
	private IncomeCategoryDTO incomeCategory;

	//bi-directional many-to-one association to Reservation
	@ManyToOne
	private ReservationDTO reservation;

	public IncomeDTO() {
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

	public IncomeCategoryDTO getIncomeCategory() {
		return this.incomeCategory;
	}

	public void setIncomeCategory(IncomeCategoryDTO incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public ReservationDTO getReservation() {
		return this.reservation;
	}

	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}

}