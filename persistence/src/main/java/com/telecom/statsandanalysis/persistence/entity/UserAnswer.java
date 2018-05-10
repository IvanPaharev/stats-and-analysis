package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "user_answer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserAnswer extends BaseEntity {
    private static final long serialVersionUID = -5223084520032214671L;

    @Column(name = "user_answer")
    @NotNull(message = "User answer cannot be null")
    @Size(max = 600, message = "Max user answer length - 600 symbols")
    private String userAnswer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @NotNull(message = "Survey cannot be null")
    private Survey survey;

    public UserAnswer() {
    }

    public UserAnswer(String userAnswer, Survey survey) {
        this.userAnswer = userAnswer;
        this.survey = survey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAnswer that = (UserAnswer) o;

        if (userAnswer != null ? !userAnswer.equals(that.userAnswer) : that.userAnswer != null) return false;
        return survey != null ? survey.equals(that.survey) : that.survey == null;
    }

    @Override
    public int hashCode() {
        return userAnswer != null ? userAnswer.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "userAnswer='" + userAnswer + '\'' +
                '}';
    }
}