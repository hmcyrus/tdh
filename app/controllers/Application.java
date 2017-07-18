package controllers;

import models.*;

import play.*;
import play.mvc.*;

import views.html.*;
import org.mindrot.jbcrypt.BCrypt;

public class Application extends Controller {

    public static Result index() {
    	System.out.println(User.find.all().size() + " --0000");    	
    	/*User a = new User();
    	a.userName = "admin";
    	a.password = BCrypt.hashpw("admin123", BCrypt.gensalt());
    	a.email = "admin@tdh.com";
    	a.save();*/
    	
    	/*for(int i = 0; i < 10; i++){
    		Hospital h = new Hospital();
    		h.name = "hospital " + Integer.toString(i);
    		h.address = "some address " + Integer.toString(i);
    		h.email  = "hospital" + Integer.toString(i)  + "@tdh.com";
    		h.imageLocation = "hospital" +  Integer.toString(i) + ".png";
    		h.save();
    	}*/
    	
        return ok(index.render("Your new application is ready."));
    }

}
