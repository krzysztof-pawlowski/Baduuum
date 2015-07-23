package pl.baduuum.shared.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cost_category database table.
 * 
 */
@Entity
@Table(name="cost_category")
//@NamedQuery(name="CostCategory.findAll", query="SELECT c FROM CostCategory c")
public class CostCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to CostSubcategory
	@OneToMany(mappedBy="costCategory")
	private List<CostSubcategory> costSubcategories;

	public CostCategory() {
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

	public List<CostSubcategory> getCostSubcategories() {
		return this.costSubcategories;
	}

	public void setCostSubcategories(List<CostSubcategory> costSubcategories) {
		this.costSubcategories = costSubcategories;
	}

	public CostSubcategory addCostSubcategory(CostSubcategory costSubcategory) {
		getCostSubcategories().add(costSubcategory);
		costSubcategory.setCostCategory(this);

		return costSubcategory;
	}

	public CostSubcategory removeCostSubcategory(CostSubcategory costSubcategory) {
		getCostSubcategories().remove(costSubcategory);
		costSubcategory.setCostCategory(null);

		return costSubcategory;
	}

}