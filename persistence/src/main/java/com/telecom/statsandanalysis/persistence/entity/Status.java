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
@Table(name = "status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Status extends BaseEntity {
    private static final long serialVersionUID = 1653013640156353053L;

    @Column(unique = true)
    @NotNull(message = "Status cannot be null")
    @Size(max = 45, message = "Status name max length - 45 symbols")
    private String status;

    @Size(max = 300, message = "Status description max length - 300 symbols")
    private String description;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<UserService> userServices;

    public Status() {
        super();
    }

    public Status(String status, String description) {
        super();
        this.status = status;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status that = (Status) o;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
