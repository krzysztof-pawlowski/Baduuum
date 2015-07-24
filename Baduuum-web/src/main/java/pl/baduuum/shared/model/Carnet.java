package pl.baduuum.shared.model;

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
public class Carnet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_sequence_carnet",sequenceName="seq_carnet_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_carnet")
	private Integer id;

	private String number;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private Date purchaseDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to CarnetUsage
	@OneToMany(mappedBy="carnet")
	private List<CarnetUsage> carnetUsages;

	public Carnet() {
	}
	
	public Carnet(int id) {
		this.id = id;
	}
	
	public Carnet(int id, String number) {
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<CarnetUsage> getCarnetUsages() {
		return this.carnetUsages;
	}

	public void setCarnetUsages(List<CarnetUsage> carnetUsages) {
		this.carnetUsages = carnetUsages;
	}

	public CarnetUsage addCarnetUsage(CarnetUsage carnetUsage) {
		getCarnetUsages().add(carnetUsage);
		carnetUsage.setCarnet(this);

		return carnetUsage;
	}

	public CarnetUsage removeCarnetUsage(CarnetUsage carnetUsage) {
		getCarnetUsages().remove(carnetUsage);
		carnetUsage.setCarnet(null);

		return carnetUsage;
	}

}