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
@Table(name = "attachment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Attachment extends BaseEntity {
    private static final long serialVersionUID = -8968186810025962883L;

    @Column(name = "attachment_source")
    @NotNull(message = "Attachment source cannot be null")
    @Size(max = 150, message = "Max attachment source length - 150 symbols")
    private String attachmentSource;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @NotNull(message = "Report cannot be null")
    private Report report;

    public Attachment() {
    }

    public Attachment(String attachmentSource, Report report) {
        this.attachmentSource = attachmentSource;
        this.report = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (attachmentSource != null ? !attachmentSource.equals(that.attachmentSource) : that.attachmentSource != null)
            return false;
        return report != null ? report.equals(that.report) : that.report == null;
    }

    @Override
    public int hashCode() {
        int result = attachmentSource != null ? attachmentSource.hashCode() : 0;
        result = 31 * result + (report != null ? report.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachmentSource='" + attachmentSource + '\'' +
                ", report=" + report +
                '}';
    }
}

