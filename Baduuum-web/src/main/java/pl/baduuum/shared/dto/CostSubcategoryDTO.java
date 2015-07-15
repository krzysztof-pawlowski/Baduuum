package pl.baduuum.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cost_subcategory database table.
 * 
 */
@Entity
@Table(name="cost_subcategory")
@NamedQuery(name="CostSubcategory.findAll", query="SELECT c FROM CostSubcategory c")
public class CostSubcategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Cost
	@OneToMany(mappedBy="costSubcategory")
	private List<CostDTO> costs;

	//bi-directional many-to-one association to CostCategory
	@ManyToOne
	@JoinColumn(name="cost_category_id")
	private CostCategoryDTO costCategory;

	public CostSubcategoryDTO() {
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

	public List<CostDTO> getCosts() {
		return this.costs;
	}

	public void setCosts(List<CostDTO> costs) {
		this.costs = costs;
	}

	public CostDTO addCost(CostDTO cost) {
		getCosts().add(cost);
		cost.setCostSubcategory(this);

		return cost;
	}

	public CostDTO removeCost(CostDTO cost) {
		getCosts().remove(cost);
		cost.setCostSubcategory(null);

		return cost;
	}

	public CostCategoryDTO getCostCategory() {
		return this.costCategory;
	}

	public void setCostCategory(CostCategoryDTO costCategory) {
		this.costCategory = costCategory;
	}

}