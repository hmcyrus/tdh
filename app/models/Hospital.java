package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Hospital extends Model {

    @Id
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    public String email;
    
    @Constraints.Required
    @Formats.NonEmpty
    public String address;
    
    @Constraints.Required
    @Formats.NonEmpty
    public String name;
    
    public String latlong;
        
    public String imageLocation;
        
    public String contactPerson;
    
    public String contactNumber;
    
    public String webpage;   
    

    
    // -- Queries (long id, user.class)
    public static Model.Finder<Long, Hospital> find = new Model.Finder<Long, Hospital>(Long.class, Hospital.class);   

}
