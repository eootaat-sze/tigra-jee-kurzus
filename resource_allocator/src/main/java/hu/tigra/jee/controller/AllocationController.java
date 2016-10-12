package hu.tigra.jee.controller;

import hu.tigra.jee.model.Allocation;
import hu.tigra.jee.service.AllocationRegistration;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;

@Model
public class AllocationController {

    @Inject
    private FacesContext context;

    @Inject
    private AllocationRegistration registration;

    @Produces
    @Named
    private Allocation allocation;

    @PostConstruct
    public void initAllocation() {
        allocation = new Allocation();
    }

    public void register() throws Exception {
        setYearTo(2016);
        FacesMessage message;
        try {
            registration.register(allocation);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful!");
            context.addMessage(null, message);
            initAllocation();
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some problem appeared. Try again later, please!", "Registration unsuccessful!");
            context.addMessage(null, message);
        }
    }

    private void setYearTo(int year) {
        Calendar c = Calendar.getInstance();

        c.setTime(allocation.getStart());
        c.set(Calendar.YEAR, year);
        allocation.setStart(c.getTime());

        c.setTime(allocation.getEnd());
        c.set(Calendar.YEAR, year);
        allocation.setEnd(c.getTime());
    }
}
