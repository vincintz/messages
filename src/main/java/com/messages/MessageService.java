package com.messages;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * <p>
 * Encapsulates services available for messages.
 * </p>
 * @author theo
 */
@Stateless
public class MessageService {
    @PersistenceContext (unitName="primary")
    private EntityManager em;

    /**
     * @return
     * <p>
     * Message list.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public List<Message> loadMessageList() {
        final Query query = em.createQuery("SELECT m FROM Message m ORDER BY m.timeStamp DESC");
        return query.getResultList();
    }

    public void saveMessage(final Message message) {
        em.persist(message);
    }
}
