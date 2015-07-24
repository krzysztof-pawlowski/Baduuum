package pl.baduuum.shared.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the reservation_category database table.
 * 
 */
@Entity
@Table(name="reservation_category")
//@NamedQuery(name="ReservationCategory.findAll", query="SELECT r FROM ReservationCategory r")
public class ReservationCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_sequence_reservation_category",sequenceName="seq_reservation_category_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence_reservation_category")
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="reservationCategory")
	private List<Reservation> reservations;

	public ReservationCategory() {
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

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setReservationCategory(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setReservationCategory(null);

		return reservation;
	}

}