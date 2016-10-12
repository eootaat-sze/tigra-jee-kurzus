package hu.tigra.jee.service;

import hu.tigra.jee.model.Allocation;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class AllocationRegistration {

    @Inject
    private EntityManager em;

    @Inject
    private Event<Allocation> allocEvent;

    public void register(Allocation a) throws Exception {
        em.persist(a);
        allocEvent.fire(a);
    }
}
