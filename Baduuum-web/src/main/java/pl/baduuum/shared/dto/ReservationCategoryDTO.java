package pl.baduuum.shared.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reservation_category database table.
 * 
 */
@Entity
@Table(name="reservation_category")
@NamedQuery(name="ReservationCategory.findAll", query="SELECT r FROM ReservationCategory r")
public class ReservationCategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="reservationCategory")
	private List<ReservationDTO> reservations;

	public ReservationCategoryDTO() {
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

	public List<ReservationDTO> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}

	public ReservationDTO addReservation(ReservationDTO reservation) {
		getReservations().add(reservation);
		reservation.setReservationCategory(this);

		return reservation;
	}

	public ReservationDTO removeReservation(ReservationDTO reservation) {
		getReservations().remove(reservation);
		reservation.setReservationCategory(null);

		return reservation;
	}

}