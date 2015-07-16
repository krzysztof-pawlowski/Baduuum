package pl.baduuum.shared.dto;

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
public class ReservationDTO implements Serializable {
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
	private List<CarnetUsageDTO> carnetUsages;

	@OneToMany(mappedBy="reservation")
	private List<IncomeDTO> incomes;

	@ManyToOne
	private ClientDTO client;

	@OneToOne
	@JoinColumn(name="reservation_category_id")
	private ReservationCategoryDTO reservationCategory;

	public ReservationDTO(int reservationId) {
		this.id = reservationId;
	}
	
	public ReservationDTO() {
	}
	
	public ReservationDTO(Integer id, String bandName) {
		this.id = id;
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

	public List<CarnetUsageDTO> getCarnetUsages() {
		return this.carnetUsages;
	}

	public void setCarnetUsages(List<CarnetUsageDTO> carnetUsages) {
		this.carnetUsages = carnetUsages;
	}

	public CarnetUsageDTO addCarnetUsage(CarnetUsageDTO carnetUsage) {
		getCarnetUsages().add(carnetUsage);
		carnetUsage.setReservation(this);

		return carnetUsage;
	}

	public CarnetUsageDTO removeCarnetUsage(CarnetUsageDTO carnetUsage) {
		getCarnetUsages().remove(carnetUsage);
		carnetUsage.setReservation(null);

		return carnetUsage;
	}

	public List<IncomeDTO> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<IncomeDTO> incomes) {
		this.incomes = incomes;
	}

	public IncomeDTO addIncome(IncomeDTO income) {
		getIncomes().add(income);
		income.setReservation(this);

		return income;
	}

	public IncomeDTO removeIncome(IncomeDTO income) {
		getIncomes().remove(income);
		income.setReservation(null);

		return income;
	}

	public ClientDTO getClient() {
		return this.client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public ReservationCategoryDTO getReservationCategory() {
		return this.reservationCategory;
	}

	public void setReservationCategory(ReservationCategoryDTO reservationCategory) {
		this.reservationCategory = reservationCategory;
	}

}