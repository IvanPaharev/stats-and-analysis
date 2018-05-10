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
@Table(name = "priority")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@Getter @Setter
public class Priority extends BaseEntity {
    private static final long serialVersionUID = -6320461834437291652L;

    @Column(unique = true)
    @NotNull(message = "Priority cannot be null")
    @Size(max = 30, message = "Priority max length - 30 symbols")
    private String priority;

    @Size(max = 300, message = "Description max length - 300 symbols")
    private String description;

    @OneToMany(mappedBy = "priority")
    @JsonIgnore
    private List<Report> reports;

    @OneToMany(mappedBy = "priority")
    @JsonIgnore
    private List<Review> reviews;

    public Priority() {
    }

    public Priority(String priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority1 = (Priority) o;

        if (priority != null ? !priority.equals(priority1.priority) : priority1.priority != null) return false;
        return description != null ? description.equals(priority1.description) : priority1.description == null;
    }

    @Override
    public int hashCode() {
        int result = priority != null ? priority.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
