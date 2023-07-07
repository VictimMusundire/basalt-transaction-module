package com.basalt.basalttransactionmodule.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
@ToString(of = {
        "id",
        "dateCreated",
        "lastUpdated"
})
@EqualsAndHashCode(of = "id")
public class BaseEntity implements Serializable {
    @Id
    protected String id;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    protected OffsetDateTime dateCreated;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    protected OffsetDateTime lastUpdated;

    @PrePersist
    public void onCreate() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (dateCreated == null) {
            dateCreated = OffsetDateTime.now();
        }
        if (lastUpdated == null) {
            lastUpdated = OffsetDateTime.now();
        }
    }
}
