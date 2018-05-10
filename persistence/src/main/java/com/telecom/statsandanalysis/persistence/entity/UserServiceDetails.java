package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "user_service_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class UserServiceDetails extends BaseEntity {
    private static final long serialVersionUID = 4691733221686865377L;

    @EmbeddedId
    protected UserServicePK userServicePK;

    @NotNull(message = "User cannot be null")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private User user;

    @NotNull(message = "Status cannot be null")
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Service service;

    @NotNull(message = "Traffic type cannot be null")
    @JoinColumn(name = "traffic_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private TrafficType trafficType;

    @Column(name = "start_date")
    @NotNull(message = "Start date cannot be null")
    private Timestamp startDate;

    @Column(name = "end_date")
    @NotNull(message = "End date cannot be null")
    private Timestamp endDate;

    @Column(name = "traffic")
    @NotNull(message = "Traffic cannot be null")
    @DecimalMin(value = "0.0", message = "Traffic cannot be lower than zero")
    private double traffic;

    public UserServiceDetails() {
    }

    public UserServiceDetails(UserServicePK userServicePK, User user, Service service, TrafficType trafficType, Timestamp startDate, Timestamp endDate, double traffic) {
        this.userServicePK = userServicePK;
        this.user = user;
        this.service = service;
        this.trafficType = trafficType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.traffic = traffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserServiceDetails that = (UserServiceDetails) o;

        if (Double.compare(that.traffic, traffic) != 0) return false;
        if (userServicePK != null ? !userServicePK.equals(that.userServicePK) : that.userServicePK != null)
            return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (trafficType != null ? !trafficType.equals(that.trafficType) : that.trafficType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userServicePK != null ? userServicePK.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (trafficType != null ? trafficType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        temp = Double.doubleToLongBits(traffic);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserServiceDetails{" +
                "userServicePK=" + userServicePK +
                ", user=" + user +
                ", service=" + service +
                ", trafficType=" + trafficType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", traffic=" + traffic +
                '}';
    }
}
