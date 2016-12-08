package models;

import play.data.validation.Constraints.Required;

public class UploadResource {
	@Required
    public String lang;

    @Required
    public String country;

}
