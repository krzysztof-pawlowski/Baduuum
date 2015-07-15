package pl.baduuum.shared.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carnet_usage database table.
 * 
 */
@Entity
@Table(name="carnet_usage")
@NamedQuery(name="CarnetUsage.findAll", query="SELECT c FROM CarnetUsage c")
public class CarnetUsageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer hours;

	//bi-directional many-to-one association to Carnet
	@ManyToOne
	private CarnetDTO carnet;

	//bi-directional many-to-one association to Reservation
	@ManyToOne
	private ReservationDTO reservation;

	public CarnetUsageDTO() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public CarnetDTO getCarnet() {
		return this.carnet;
	}

	public void setCarnet(CarnetDTO carnet) {
		this.carnet = carnet;
	}

	public ReservationDTO getReservation() {
		return this.reservation;
	}

	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}

}