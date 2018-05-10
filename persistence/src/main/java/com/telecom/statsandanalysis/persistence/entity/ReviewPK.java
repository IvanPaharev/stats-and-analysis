package com.telecom.statsandanalysis.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by A-one on 10.05.2018.
 */
@Embeddable
@Getter @Setter
@EqualsAndHashCode
@ToString
public class ReviewPK implements Serializable {
    private static final long serialVersionUID = -6398456120556706714L;

    @Column(name = "user_id")
    @NotNull(message = "User id cannot be null")
    private int userId;

    @Column(name = "review_subject_id")
    @NotNull(message = "Review subject id cannot be null")
    private int reviewSubjectId;

    public ReviewPK() {
    }

    public ReviewPK(int userId, int reviewSubjectId) {
        this.userId = userId;
        this.reviewSubjectId = reviewSubjectId;
    }
}
