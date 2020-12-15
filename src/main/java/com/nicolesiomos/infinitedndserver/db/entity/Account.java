package com.nicolesiomos.infinitedndserver.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@Entity
@NamedQuery(name = Account.QUERY_ACCOUNT_COUNT, query = "SELECT COUNT(*) FROM Account")
public class Account extends BaseEntity {

    public static final String QUERY_ACCOUNT_COUNT = "Account.count";

    private String emailAddress;

    @Column(nullable = false, unique = true)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
