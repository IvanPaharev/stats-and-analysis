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
@Table(name = "question")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Question extends BaseEntity {
    private static final long serialVersionUID = -9195482358231413735L;

    @Column(name = "question")
    @NotNull(message = "Question cannot be null")
    @Size(max = 600, message = "Max question length - 600 symbols")
    private String question;

    @Column(name = "type")
    @NotNull(message = "Type cannot be null")
    @Size(max = 30, message = "Max type length - 30 symbols")
    private String type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    @NotNull(message = "Survey cannot be null")
    private Survey survey;

    public Question() {
    }

    public Question(String question, String type, Survey survey) {
        this.question = question;
        this.type = type;
        this.survey = survey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (question != null ? !question.equals(question1.question) : question1.question != null) return false;
        if (type != null ? !type.equals(question1.type) : question1.type != null) return false;
        return survey != null ? survey.equals(question1.survey) : question1.survey == null;
    }

    @Override
    public int hashCode() {
        int result = question != null ? question.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
