package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "review")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Review implements Serializable {
    private static final long serialVersionUID = -2063468810021532131L;

    @EmbeddedId
    protected ReviewPK reviewPK;

    @Size(max = 600, message = "Review max length - 600 symbols")
    @NotNull(message = "Review cannot be null")
    private String review;

    @NotNull(message = "User cannot be null")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private User user;

    @NotNull(message = "Review subject cannot be null")
    @JoinColumn(name = "review_subject_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private ReviewSubject reviewSubject;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    @NotNull(message = "Grade cannot be null")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    public Review() {
    }

    public Review(ReviewPK reviewPK, String review, User user, ReviewSubject reviewSubject, Grade grade, Priority priority) {
        this.reviewPK = reviewPK;
        this.review = review;
        this.user = user;
        this.reviewSubject = reviewSubject;
        this.grade = grade;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review1 = (Review) o;

        if (review != review1.review) return false;
        if (reviewPK != null ? !reviewPK.equals(review1.reviewPK) : review1.reviewPK != null) return false;
        if (user != null ? !user.equals(review1.user) : review1.user != null) return false;
        if (reviewSubject != null ? !reviewSubject.equals(review1.reviewSubject) : review1.reviewSubject != null)
            return false;
        if (grade != null ? !grade.equals(review1.grade) : review1.grade != null) return false;
        return priority != null ? priority.equals(review1.priority) : review1.priority == null;
    }

    @Override
    public int hashCode() {
        int result = reviewPK != null ? reviewPK.hashCode() : 0;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (reviewSubject != null ? reviewSubject.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewPK=" + reviewPK +
                ", review=" + review +
                ", user=" + user +
                ", reviewSubject=" + reviewSubject +
                ", grade=" + grade +
                ", name=" + priority +
                '}';
    }
}
