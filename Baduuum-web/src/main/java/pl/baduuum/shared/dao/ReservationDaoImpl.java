package pl.baduuum.shared.dao;

import org.springframework.stereotype.Repository;
import pl.baduuum.shared.model.Reservation;

/**
 * Created by mario on 18/07/15.
 */
@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractDao implements ReservationDao{

    public void saveReservation(Reservation reservation) {
        persist(reservation);
    }

 /*   @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }


    public Employee findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
    }

    public void updateEmployee(Employee employee){
        getSession().update(employee);
    }
 */
}