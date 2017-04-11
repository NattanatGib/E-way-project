/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eway.GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rei
 */
@Entity
@Table(name = "BOOKING", catalog = "", schema = "SAJA")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate")
    , @NamedQuery(name = "Booking.findByBookingRound", query = "SELECT b FROM Booking b WHERE b.bookingRound = :bookingRound")
    , @NamedQuery(name = "Booking.findByRouteLocationRecieve", query = "SELECT b FROM Booking b WHERE b.routeLocationRecieve = :routeLocationRecieve")
    , @NamedQuery(name = "Booking.findByRouteLocationDestination", query = "SELECT b FROM Booking b WHERE b.routeLocationDestination = :routeLocationDestination")
    , @NamedQuery(name = "Booking.findByPersonId", query = "SELECT b FROM Booking b WHERE b.personId = :personId")})
public class Booking implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKING_ID")
    private Integer bookingId;
    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Column(name = "BOOKING_ROUND")
    @Temporal(TemporalType.TIME)
    private Date bookingRound;
    @Column(name = "ROUTE_LOCATION_RECIEVE")
    private Long routeLocationRecieve;
    @Column(name = "ROUTE_LOCATION_DESTINATION")
    private Long routeLocationDestination;
    @Column(name = "PERSON_ID")
    private BigInteger personId;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        Integer oldBookingId = this.bookingId;
        this.bookingId = bookingId;
        changeSupport.firePropertyChange("bookingId", oldBookingId, bookingId);
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        Date oldBookingDate = this.bookingDate;
        this.bookingDate = bookingDate;
        changeSupport.firePropertyChange("bookingDate", oldBookingDate, bookingDate);
    }

    public Date getBookingRound() {
        return bookingRound;
    }

    public void setBookingRound(Date bookingRound) {
        Date oldBookingRound = this.bookingRound;
        this.bookingRound = bookingRound;
        changeSupport.firePropertyChange("bookingRound", oldBookingRound, bookingRound);
    }

    public Long getRouteLocationRecieve() {
        return routeLocationRecieve;
    }

    public void setRouteLocationRecieve(Long routeLocationRecieve) {
        Long oldRouteLocationRecieve = this.routeLocationRecieve;
        this.routeLocationRecieve = routeLocationRecieve;
        changeSupport.firePropertyChange("routeLocationRecieve", oldRouteLocationRecieve, routeLocationRecieve);
    }

    public Long getRouteLocationDestination() {
        return routeLocationDestination;
    }

    public void setRouteLocationDestination(Long routeLocationDestination) {
        Long oldRouteLocationDestination = this.routeLocationDestination;
        this.routeLocationDestination = routeLocationDestination;
        changeSupport.firePropertyChange("routeLocationDestination", oldRouteLocationDestination, routeLocationDestination);
    }

    public BigInteger getPersonId() {
        return personId;
    }

    public void setPersonId(BigInteger personId) {
        BigInteger oldPersonId = this.personId;
        this.personId = personId;
        changeSupport.firePropertyChange("personId", oldPersonId, personId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Eway.GUI.Booking[ bookingId=" + bookingId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
