package ViewModels;

import javax.persistence.Column;
import javax.persistence.Id;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;

public class HospitalForm {
	@Required
    public String name;

    @Required
    public String contact;

    @Required
    public String email;
    
    @Required
    public String address;    
    
    public String latlong;
        
    public String imageLocation;
        
    public String contactPerson;
    
    public String contactNumber;
    
    public String webpage;
    
    public String validate() {
        
        return null;
    }

}
