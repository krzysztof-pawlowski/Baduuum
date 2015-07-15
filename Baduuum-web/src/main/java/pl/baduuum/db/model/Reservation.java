package pl.baduuum.db.model;

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
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="band_name")
	private String bandName;

	@Column(name="conctact_person_email")
	private String conctactPersonEmail;

	@Column(name="contact_person_name")
	private String contactPersonName;

	@Column(name="contact_person_phone")
	private String contactPersonPhone;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="hour_start")
	private Time hourStart;

	@Column(name="hours_end")
	private Time hoursEnd;

	@Column(name="is_approved")
	private Boolean isApproved;

	@Column(name="is_cymbals")
	private Boolean isCymbals;

	@Column(name="is_paid")
	private Boolean isPaid;

	@Column(name="is_piano")
	private Boolean isPiano;

	@OneToMany(mappedBy="reservation")
	private List<CarnetUsage> carnetUsages;

	@OneToMany(mappedBy="reservation")
	private List<Income> incomes;

	@ManyToOne
	private Client client;

	@OneToOne
	@JoinColumn(name="reservation_category_id")
	private ReservationCategory reservationCategory;

	public Reservation() {
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

	public String getConctactPersonEmail() {
		return this.conctactPersonEmail;
	}

	public void setConctactPersonEmail(String conctactPersonEmail) {
		this.conctactPersonEmail = conctactPersonEmail;
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

	public Time getHoursEnd() {
		return this.hoursEnd;
	}

	public void setHoursEnd(Time hoursEnd) {
		this.hoursEnd = hoursEnd;
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

}