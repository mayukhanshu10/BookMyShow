package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



/*
This base model is super class used to set common attributes to all the table.
Remember Why Jaspreet always told to use this.

@MappedSuperclass It tells JPA that whichever class is extending this class, make these attributes available as column in sub-class tables.
 */

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
