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
@Table(name = "grade")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@Getter @Setter
public class Grade extends BaseEntity {
    private static final long serialVersionUID = -6420402653080183918L;

    @Column(unique = true)
    @NotNull(message = "Grade cannot be null")
    @Size(max = 30, message = "Grade max length - 30 symbols")
    private String grade;

    @Size(max = 300, message = "Description max length - 300 symbols")
    private String description;

    @OneToMany(mappedBy = "grade")
    @JsonIgnore
    private List<Review> reviews;

    public Grade() {
    }

    public Grade(String grade, String description) {
        this.grade = grade;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade1 = (Grade) o;

        if (grade != null ? !grade.equals(grade1.grade) : grade1.grade != null) return false;
        return description != null ? description.equals(grade1.description) : grade1.description == null;
    }

    @Override
    public int hashCode() {
        int result = grade != null ? grade.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
