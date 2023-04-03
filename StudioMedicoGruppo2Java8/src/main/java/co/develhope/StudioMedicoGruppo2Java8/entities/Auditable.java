package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import static jakarta.persistence.TemporalType.DATE;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable <U>{

    @CreatedBy
    private U createdBy;

    @LastModifiedBy
    private U lastModifiedBy;

    @CreatedDate
    @Temporal(DATE)
    private Date createdOn;
    @LastModifiedDate
    @Temporal(DATE)
    private Date modifiedOn;

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
