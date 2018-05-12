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

    @ManyToOne(optional = false)
    @NotNull(message = "Status cannot be null")
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    })
    private UserService userService;

    @NotNull(message = "Traffic type cannot be null")
    @JoinColumn(name = "traffic_type_id", referencedColumnName = "id")
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

    public UserServiceDetails(UserService userService, User user, TrafficType trafficType, Timestamp startDate, Timestamp endDate, double traffic) {
        this.userService = userService;
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
        if (trafficType != null ? !trafficType.equals(that.trafficType) : that.trafficType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = trafficType != null ? trafficType.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        temp = Double.doubleToLongBits(traffic);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserServiceDetails{" +
                "trafficType=" + trafficType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", traffic=" + traffic +
                '}';
    }
}
