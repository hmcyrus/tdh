package controllers;

import models.*;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import java.nio.file.*;
import play.data.Form.*;

import org.apache.commons.io.FileUtils;
import org.mindrot.jbcrypt.BCrypt;

import ViewModels.LoginForm;

import java.io.*;
import views.html.login;

public class AuthenticationController extends Controller {

    public static Result index() {
    	System.out.println("fine");
        return ok(login.render(Form.form(LoginForm.class)));
    }
    
    public static Result validate() {
    	DynamicForm requestData = Form.form().bindFromRequest();
    	System.out.println(requestData.get("userName") + " -- ");
    	System.out.println(requestData.get("password") + " -- ");
    	User user = User.find.where().eq("userName", requestData.get("userName")).findUnique();
	    if (user != null && BCrypt.checkpw(requestData.get("password"), user.password)) {
	    	session("currentUser", requestData.get("userName"));
	    	return ok("validated");
	    } else {
	    	return ok(" not validated");
	    } 
    	//return ok("hello");
    }
    
    public static Result logout() {
        session().clear();
        
        return redirect(routes.Application.index());
    }
    
    public static Result upload() {
    	//Form<UploadResource> filledForm = Form.form(UploadResource.class).bindFromRequest();
    	//final Form<MyObject> form = formFactory.form(MyObject.class).bindFromRequest();
    	DynamicForm requestData = Form.form().bindFromRequest();
    	System.out.println(requestData.get("lang") + " -- ");
    	System.out.println(requestData.get("country") + " -- ");
    	
    	//filledForm.
    	MultipartFormData body = request().body().asMultipartFormData();
    	//DynamicForm b = request().body().as
    	//Sytem.out.println(body.get);
    	FilePart profileImage = body.getFile("profile");
    	if (profileImage != null) {
    			try {
    			String fileName = profileImage.getFilename();
    			String contentType = profileImage.getContentType();
    			File file = profileImage.getFile();
    			//Path path = FileSystems.getDefault().getPath("/tmp/" + fileName);
    			//System.out.println(path.toAbsolutePath());
    			//Files.write(path, Files.readAllBytes(file.toPath()));
    			
    			try {
    	            FileUtils.moveFile(file, new File("public/images", fileName));
    	        } catch (IOException ioe) {
    	            System.out.println("Problem operating on filesystem");
    	        }
    			
    			return ok("Image uploaded");
    			} catch(Exception e) {
    			return internalServerError(e.getMessage());
    			}
    			} else {
    			flash("error", "Please upload a valid file");
    			return redirect(routes.Application.index()); 
    			}
    	  /*MultipartFormData body = request().body().asMultipartFormData();
    	  FilePart picture = body.getFile("picture");
    	  if (picture != null) {
    	    String fileName = picture.getFilename();
    	    String contentType = picture.getContentType(); 
    	    File file = picture.getFile();
    	    return ok("File uploaded");
    	  } else {
    	    flash("error", "Missing file");
    	    return redirect(routes.Application.index());    
    	  }*/
    	//DynamicForm bindedForm = form().bindFromRequest();
        //System.out.println(bindedForm.get("myname"));
    	 //Form<UploadResource> filledForm = uploadForm.bindFromRequest();
    	 //System.out.println(filledForm.);
    	    /*if (filledForm.hasErrors()) {
    	        return badRequest(views.html.upload.render(filledForm));
    	    } else {
    	        UploadResource resource = filledForm.get();
    	        MultipartFormData body = request().body().asMultipartFormData();
    	        FilePart resourceFile = body.getFile("resourceFile");

    	         Check resourceFile for null, then extract the File object and process it 
    	     }*/
        
        /*@inputText(uploadForm("lang"))
        @inputText(uploadForm("country"))
        @inputFile(uploadForm("resourceFile"))*/

    }

}
