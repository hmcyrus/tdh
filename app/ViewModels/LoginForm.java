package ViewModels;

import play.data.validation.Constraints.Required;

public class LoginForm {
	@Required
    public String userName;

    @Required
    public String password;

}
