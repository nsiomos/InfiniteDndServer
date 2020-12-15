package com.nicolesiomos.infinitedndserver.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    private String emailAddress;

    @Column(nullable = false, unique = true)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
