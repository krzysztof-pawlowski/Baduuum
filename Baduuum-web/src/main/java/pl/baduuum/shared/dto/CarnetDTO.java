package pl.baduuum.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carnet database table.
 * 
 */
@Entity
@Table(name = "carnet")
//@NamedQuery(name="Carnet.findAll", query="SELECT c FROM carnet c")
public class CarnetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String number;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private Date purchaseDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private ClientDTO client;

	//bi-directional many-to-one association to CarnetUsage
	@OneToMany(mappedBy="carnet")
	private List<CarnetUsageDTO> carnetUsages;

	public CarnetDTO() {
	}
	
	public CarnetDTO(int id) {
		this.id = id;
	}
	
	public CarnetDTO(int id, String number) {
		this.id = id;
		this.number = number;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public ClientDTO getClient() {
		return this.client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<CarnetUsageDTO> getCarnetUsages() {
		return this.carnetUsages;
	}

	public void setCarnetUsages(List<CarnetUsageDTO> carnetUsages) {
		this.carnetUsages = carnetUsages;
	}

	public CarnetUsageDTO addCarnetUsage(CarnetUsageDTO carnetUsage) {
		getCarnetUsages().add(carnetUsage);
		carnetUsage.setCarnet(this);

		return carnetUsage;
	}

	public CarnetUsageDTO removeCarnetUsage(CarnetUsageDTO carnetUsage) {
		getCarnetUsages().remove(carnetUsage);
		carnetUsage.setCarnet(null);

		return carnetUsage;
	}

}