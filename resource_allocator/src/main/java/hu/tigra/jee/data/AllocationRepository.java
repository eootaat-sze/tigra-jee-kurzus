package hu.tigra.jee.data;

import hu.tigra.jee.model.Allocation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class AllocationRepository {

    @Inject
    private EntityManager em;

    List<Allocation> findAllOrderedByStartTime() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Allocation> query = cb.createQuery(Allocation.class);
        Root<Allocation> alloc = query.from(Allocation.class);
        query.select(alloc).orderBy(cb.asc(alloc.get("start")));
        return em.createQuery(query).getResultList();
    }
}
