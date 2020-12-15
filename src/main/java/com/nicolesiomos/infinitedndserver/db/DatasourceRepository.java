package com.nicolesiomos.infinitedndserver.db;

import com.nicolesiomos.infinitedndserver.db.entity.Account;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@Repository
@Transactional
public class DatasourceRepository {

    @PersistenceContext
    private EntityManager em;

    public long getAccountCount() {
        return (Long) em.createNamedQuery(Account.QUERY_ACCOUNT_COUNT).getSingleResult();
    }
}
