package pl.baduuum.shared.dto;

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
public class IncomeCategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="incomeCategory")
	private List<IncomeDTO> incomes;

	public IncomeCategoryDTO() {
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

	public List<IncomeDTO> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<IncomeDTO> incomes) {
		this.incomes = incomes;
	}

	public IncomeDTO addIncome(IncomeDTO income) {
		getIncomes().add(income);
		income.setIncomeCategory(this);

		return income;
	}

	public IncomeDTO removeIncome(IncomeDTO income) {
		getIncomes().remove(income);
		income.setIncomeCategory(null);

		return income;
	}

}