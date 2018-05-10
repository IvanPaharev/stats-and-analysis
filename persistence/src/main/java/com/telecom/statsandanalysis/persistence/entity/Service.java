package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "service")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Service extends BaseEntity {
    private static final long serialVersionUID = 2957420791141660299L;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    @Size(max = 150, message = "Max name length - 15- symbols")
    private String name;

    @Column(name = "description")
    @Size(max = 900, message = "Max description length - 900 symbols")
    private String description;

    @Column(name = "one_time_payment")
    @NotNull(message = "One time payment cannot be null")
    @DecimalMin(value = "0.0", message = "One time payment cannot be lower than zero")
    private double oneTimePayment;

    @Column(name = "monthly_payment")
    @NotNull(message = "Monthly payment cannot be null")
    @DecimalMin(value = "0.0", message = "Monthly payment cannot be lower than zero")
    private double monthlyPayment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    @NotNull(message = "Service type cannot be null")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    @JsonIgnore
    private List<UserService> userServices;

    public Service() {
    }

    public Service(String name, String description, double oneTimePayment, double monthlyPayment, ServiceType serviceType) {
        this.name = name;
        this.description = description;
        this.oneTimePayment = oneTimePayment;
        this.monthlyPayment = monthlyPayment;
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (Double.compare(service.oneTimePayment, oneTimePayment) != 0) return false;
        if (Double.compare(service.monthlyPayment, monthlyPayment) != 0) return false;
        if (name != null ? !name.equals(service.name) : service.name != null) return false;
        if (description != null ? !description.equals(service.description) : service.description != null) return false;
        return serviceType != null ? serviceType.equals(service.serviceType) : service.serviceType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(oneTimePayment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(monthlyPayment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", oneTimePayment=" + oneTimePayment +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
