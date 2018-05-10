package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by A-one on 18.04.2017.
 */
@Entity
@Table(name = "survey")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Survey extends BaseEntity {
    private static final long serialVersionUID = 7722192986659845970L;

    @Column(unique = true)
    @NotNull(message = "Survey name cannot be null")
    @Size(max = 150, message = "Max survey name length - 150 symbols")
    private String name;

    @Size(max = 600, message = "Max manufacturer description length - 600 symbols")
    private String description;

    @OneToMany(mappedBy = "survey")
    @JsonIgnore
    private List<Question> questions;

    @ManyToMany(mappedBy = "surveys")
    @JsonIgnore
    private List<User> users;

    public Survey() {
        super();
    }

    public Survey(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "role='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey that = (Survey) o;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return questions != null ? questions.equals(that.questions) : that.questions == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
