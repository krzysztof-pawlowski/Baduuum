package pl.baduuum.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="band_name")
	private String bandName;

	private Integer city;

	private String email;

	private String name;

	private String nip;

	private String password;

	@Column(name="phone_numer")
	private String phoneNumer;

	@Column(name="postal_code")
	private String postalCode;

	private String street;

	//bi-directional many-to-one association to Carnet
	@OneToMany(mappedBy="client")
	private List<Carnet> carnets;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="client")
	private List<Reservation> reservations;

	public Client() {
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

	public Integer getCity() {
		return this.city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumer() {
		return this.phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Carnet> getCarnets() {
		return this.carnets;
	}

	public void setCarnets(List<Carnet> carnets) {
		this.carnets = carnets;
	}

	public Carnet addCarnet(Carnet carnet) {
		getCarnets().add(carnet);
		carnet.setClient(this);

		return carnet;
	}

	public Carnet removeCarnet(Carnet carnet) {
		getCarnets().remove(carnet);
		carnet.setClient(null);

		return carnet;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setClient(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setClient(null);

		return reservation;
	}

}