package com.telecom.statsandanalysis.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by A-one on 10.05.2018.
 */
@Entity
@Table(name = "report")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Report extends BaseEntity {
    private static final long serialVersionUID = -8701171665287073990L;

    @Size(max = 1500, message = "Description max length - 1500 symbols")
    @NotNull(message = "Description cannot be null")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "report_type_id", referencedColumnName = "id")
    @NotNull(message = "Report type cannot be null")
    private ReportType reportType;

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    public Report() {
    }

    public Report(String description, User user, ReportType reportType, Priority priority) {
        this.description = description;
        this.user = user;
        this.reportType = reportType;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (description != null ? !description.equals(report.description) : report.description != null) return false;
        if (user != null ? !user.equals(report.user) : report.user != null) return false;
        if (reportType != null ? !reportType.equals(report.reportType) : report.reportType != null) return false;
        return priority != null ? priority.equals(report.priority) : report.priority == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (reportType != null ? reportType.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "description=" + description +
                ", user=" + user +
                ", reportType=" + reportType +
                ", name=" + priority +
                '}';
    }
}
