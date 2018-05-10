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
@Table(name = "answer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Answer extends BaseEntity {
    private static final long serialVersionUID = 340752373519630483L;

    @Column(name = "answer")
    @NotNull(message = "Answer cannot be null")
    @Size(max = 600, message = "Max answer length - 600 symbols")
    private String answer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @NotNull(message = "Survey cannot be null")
    private Survey survey;

    public Answer() {
    }

    public Answer(String answer, Survey survey) {
        this.answer = answer;
        this.survey = survey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        if (answer != null ? !answer.equals(answer1.answer) : answer1.answer != null) return false;
        return survey != null ? survey.equals(answer1.survey) : answer1.survey == null;
    }

    @Override
    public int hashCode() {
        return answer != null ? answer.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
