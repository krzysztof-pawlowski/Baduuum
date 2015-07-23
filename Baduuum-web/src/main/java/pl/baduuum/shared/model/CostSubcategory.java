package pl.baduuum.shared.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cost_subcategory database table.
 * 
 */
@Entity
@Table(name="cost_subcategory")
//@NamedQuery(name="CostSubcategory.findAll", query="SELECT c FROM CostSubcategory c")
public class CostSubcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Cost
	@OneToMany(mappedBy="costSubcategory")
	private List<Cost> costs;

	//bi-directional many-to-one association to CostCategory
	@ManyToOne
	@JoinColumn(name="cost_category_id")
	private CostCategory costCategory;

	public CostSubcategory() {
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

	public List<Cost> getCosts() {
		return this.costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public Cost addCost(Cost cost) {
		getCosts().add(cost);
		cost.setCostSubcategory(this);

		return cost;
	}

	public Cost removeCost(Cost cost) {
		getCosts().remove(cost);
		cost.setCostSubcategory(null);

		return cost;
	}

	public CostCategory getCostCategory() {
		return this.costCategory;
	}

	public void setCostCategory(CostCategory costCategory) {
		this.costCategory = costCategory;
	}

}