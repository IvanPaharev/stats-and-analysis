package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "report_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@Getter @Setter
public class TrafficType extends BaseEntity {
    private static final long serialVersionUID = 7893482462494955739L;

    @Column(unique = true)
    @NotNull(message = "Type cannot be null")
    @Size(max = 45, message = "Type max length - 45 symbols")
    private String type;

    @Size(max = 300, message = "Description max length - 300 symbols")
    private String description;

    @OneToMany(mappedBy = "trafficType")
    @JsonIgnore
    private List<UserServiceDetails> userServiceDetails;

    public TrafficType() {
    }

    public TrafficType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficType that = (TrafficType) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
