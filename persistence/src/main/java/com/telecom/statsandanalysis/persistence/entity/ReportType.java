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
@Table(name = "report_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@Getter @Setter
public class ReportType extends BaseEntity {
    private static final long serialVersionUID = 5371972780243636216L;

    @Column(unique = true)
    @NotNull(message = "Type cannot be null")
    @Size(max = 30, message = "Type max length - 30 symbols")
    private String type;

    @Size(max = 300, message = "Description max length - 300 symbols")
    private String description;

    @OneToMany(mappedBy = "reportType")
    @JsonIgnore
    private List<Report> reports;

    public ReportType() {
    }

    public ReportType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportType that = (ReportType) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
