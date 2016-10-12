package hu.tigra.jee.data;

import hu.tigra.jee.model.Allocation;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class AllocationListProducer {

    @Inject
    private AllocationRepository allocRepo;

    private List<Allocation> allocList;

    @Produces
    @Named
    public List<Allocation> getAllocList() {
        return allocList;
    }

    public void onAllocationListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Allocation alloc) {
        retrieveAllAllocationsOrderedByStartTime();
    }

    private void retrieveAllAllocationsOrderedByStartTime() {
        allocList = allocRepo.findAllOrderedByStartTime();
    }
}
