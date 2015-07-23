package pl.baduuum.shared.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the income_category database table.
 * 
 */
@Entity
@Table(name="income_category")
//@NamedQuery(name="IncomeCategory.findAll", query="SELECT i FROM IncomeCategory i")
public class IncomeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="incomeCategory")
	private List<Income> incomes;

	public IncomeCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setIncomeCategory(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setIncomeCategory(null);

		return income;
	}

}