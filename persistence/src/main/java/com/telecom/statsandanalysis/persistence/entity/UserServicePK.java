package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by A-one on 10.05.2018.
 */
@Embeddable
@Getter @Setter
@EqualsAndHashCode
@ToString
public class UserServicePK implements Serializable {
    private static final long serialVersionUID = 6804787341447964180L;

    @Column(name = "user_id", insertable = false, updatable = false)
    @NotNull(message = "User id cannot be null")
    private int userId;

    @Column(name = "service_id", insertable = false, updatable = false)
    @NotNull(message = "Service id cannot be null")
    private int serviceId;

    public UserServicePK() {
    }

    public UserServicePK(int userId, int serviceId) {
        this.userId = userId;
        this.serviceId = serviceId;
    }
}
