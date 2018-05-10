package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "user_service")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class UserService implements Serializable {
    private static final long serialVersionUID = -7646656481919550037L;

    @EmbeddedId
    protected UserServicePK userServicePK;

    @NotNull(message = "Balance cannot be null")
    private int balance;

    @NotNull(message = "User cannot be null")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private User user;

    @NotNull(message = "Status cannot be null")
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Service service;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @NotNull(message = "Status cannot be null")
    private Status status;

    @OneToMany(mappedBy = "userService")
    @JsonIgnore
    private List<UserServiceDetails> userServiceDetailsList;

    public UserService() {
    }

    public UserService(UserServicePK userServicePK, int balance, Status status) {
        this.userServicePK = userServicePK;
        this.balance = balance;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserService that = (UserService) o;

        if (balance != that.balance) return false;
        if (userServicePK != null ? !userServicePK.equals(that.userServicePK) : that.userServicePK != null)
            return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = userServicePK != null ? userServicePK.hashCode() : 0;
        result = 31 * result + balance;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
