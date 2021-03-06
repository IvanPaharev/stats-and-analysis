package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by A-one on 23.04.2017.
 */
@Entity
@Table(name = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Role extends BaseEntity {
    private static final long serialVersionUID = 8101419755624978165L;

    @Column(unique = true)
    @NotNull(message = "Role name cannot be null")
    @Size(max = 60, message = "Role name max length - 60 symbols")
    private String role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

    public Role() {
        super();
    }

    public Role(String role) {
        super();
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return role != null ? role.equals(role1.role) : role1.role == null;

    }

    @Override
    public int hashCode() {
        return role != null ? role.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
