package pl.baduuum.shared.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name = "reservation")
//@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_sequence_reservation",sequenceName="seq_reservation_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_reservation")
	private Integer id;

	@Column(name = "band_name")
	private String bandName;

	@Column(name = "conctact_person_email")
	private String contactPersonEmail;

	@Column(name = "contact_person_name")
	private String contactPersonName;

	@Column(name = "contact_person_phone")
	private String contactPersonPhone;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "hour_start")
	private Time hourStart;

	@Column(name = "hour_end")
	private Time hourEnd;

	@Column(name = "is_approved")
	private Boolean isApproved;

	@Column(name = "is_cymbals")
	private Boolean isCymbals;

	@Column(name = "is_cymbals_crash")
	private Boolean isCymbalsCrash;

	@Column(name = "is_paid")
	private Boolean isPaid;

	@Column(name = "is_piano")
	private Boolean isPiano;

	@OneToMany(mappedBy = "reservation")
	private List<CarnetUsage> carnetUsages;

	@OneToMany(mappedBy = "reservation")
	private List<Income> incomes;

	@ManyToOne
	private Client client;

	@ManyToOne
	@JoinColumn(name = "reservation_category_id")
	private ReservationCategory reservationCategory;

	// hibernate, why?
	public Reservation() {
	}

	private Reservation(Builder builder) {
		id = builder.id;
		bandName = builder.bandName;
		contactPersonName = builder.contactPersonName;
		contactPersonEmail = builder.contactPersonEmail;
		contactPersonPhone = builder.contactPersonPhone;
		date = builder.date;
		hourStart = builder.hourStart;
		hourEnd = builder.hourEnd;
		isApproved = builder.isApproved;
		isCymbals = builder.isCymbals;
		isCymbalsCrash = builder.isCymbalsCrash;
		isPaid = builder.isPaid;
		isPiano = builder.isPiano;
		reservationCategory = builder.reservationCategory;
	}


	public static class Builder {
		private Integer id;
		private String bandName;
		private String contactPersonName;
		private String contactPersonEmail;
		private String contactPersonPhone;
		private Date date;
		private Time hourStart;
		private Time hourEnd;
		private Boolean isApproved;
		private Boolean isCymbals;
		private Boolean isCymbalsCrash;
		private Boolean isPaid;
		private Boolean isPiano;
		private ReservationCategory reservationCategory;

		public Builder(){}

		public Builder id(Integer val) {
			id = val;
			return this;
		}

		public Builder bandName(String val) {
			bandName = val;
			return this;
		}

		public Builder contactPersonName(String val) {
			contactPersonName = val;
			return this;
		}

		public Builder contactPersonPhone(String val) {
			contactPersonPhone = val;
			return this;
		}

		public Builder contactPersonEmail(String val) {
			contactPersonEmail = val;
			return this;
		}

		public Builder date(Date val) {
			date = val;
			return this;
		}

		public Builder hourStart(Time val) {
			hourStart = val;
			return this;
		}

		public Builder hourEnd(Time val) {
			hourEnd = val;
			return this;
		}

		public Builder isApproved(Boolean val) {
			isApproved = val;
			return this;
		}

		public Builder isCymbals(Boolean val) {
			isCymbals = val;
			return this;
		}

		public Builder isCymbalsCrash(Boolean val) {
			isCymbalsCrash = val;
			return this;
		}

		public Builder isPaid(Boolean val) {
			isPaid = val;
			return this;
		}

		public Builder isPiano(Boolean val) {
			isPiano = val;
			return this;
		}

		public Builder reservationCategory(ReservationCategory val) {
			reservationCategory = val;
			return this;
		}

		public Reservation build() {
			return new Reservation(this);
		}

	}

	public Reservation(String bandName) {
		this.bandName = bandName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBandName() {
		return this.bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getContactPersonEmail() {
		return this.contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonName() {
		return this.contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonPhone() {
		return this.contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHourStart() {
		return this.hourStart;
	}

	public void setHourStart(Time hourStart) {
		this.hourStart = hourStart;
	}

	public Time getHourEnd() {
		return this.hourEnd;
	}

	public void setHourEnd(Time hourEnd) {
		this.hourEnd = hourEnd;
	}

	public Boolean getIsCymbalsCrash() {
		return isCymbalsCrash;
	}

	public void setIsCymbalsCrash(Boolean isCymbalsCrash) {
		this.isCymbalsCrash = isCymbalsCrash;
	}

	public Boolean getIsApproved() {
		return this.isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsCymbals() {
		return this.isCymbals;
	}

	public void setIsCymbals(Boolean isCymbals) {
		this.isCymbals = isCymbals;
	}

	public Boolean getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Boolean getIsPiano() {
		return this.isPiano;
	}

	public void setIsPiano(Boolean isPiano) {
		this.isPiano = isPiano;
	}

	public List<CarnetUsage> getCarnetUsages() {
		return this.carnetUsages;
	}

	public void setCarnetUsages(List<CarnetUsage> carnetUsages) {
		this.carnetUsages = carnetUsages;
	}

	public CarnetUsage addCarnetUsage(CarnetUsage carnetUsage) {
		getCarnetUsages().add(carnetUsage);
		carnetUsage.setReservation(this);

		return carnetUsage;
	}

	public CarnetUsage removeCarnetUsage(CarnetUsage carnetUsage) {
		getCarnetUsages().remove(carnetUsage);
		carnetUsage.setReservation(null);

		return carnetUsage;
	}

	public List<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setReservation(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setReservation(null);

		return income;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ReservationCategory getReservationCategory() {
		return this.reservationCategory;
	}

	public void setReservationCategory(ReservationCategory reservationCategory) {
		this.reservationCategory = reservationCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((bandName == null) ? 0 : bandName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation) obj;
		if (id != other.id)
			return false;
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		return true;


	}
}