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
@Table(name = "review_subject")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@Getter @Setter
public class ReviewSubject extends BaseEntity {
    private static final long serialVersionUID = -5246029109268526986L;

    @Column(unique = true)
    @NotNull(message = "Review subject cannot be null")
    @Size(max = 300, message = "Review subject max length - 300 symbols")
    private String priority;

    @NotNull(message = "Description cannot be null")
    @Size(max = 600, message = "Description max length - 600 symbols")
    private String description;

    @OneToMany(mappedBy = "reviewSubject")
    @JsonIgnore
    private List<Review> reviews;

    public ReviewSubject() {
    }

    public ReviewSubject(String priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewSubject that = (ReviewSubject) o;

        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = priority != null ? priority.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
