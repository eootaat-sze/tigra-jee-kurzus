package hu.tigra.jee.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Allocation extends EqualsById implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    private Date start;

    @NotNull
    private Date end;

    @NotNull
    @NotEmpty
    private String room;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
