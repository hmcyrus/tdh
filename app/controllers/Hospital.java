package controllers;

import models.*;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

import play.data.Form.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import ViewModels.HospitalForm;

import java.io.*;
import views.html.hospital.index;
import views.html.login;
import views.html.hospital.create;

import static play.libs.Json.toJson;

@Security.Authenticated(Secured.class)
public class Hospital extends Controller {

    public static Result index() {
    	
        //return ok(login.render("Your new application is ready.", User.find.all(), Form.form(UploadResource.class)));
    	List<models.Hospital> hospitals = models.Hospital.find.all();
    	
    	return ok(index.render(hospitals));
    }
    
    public static Result create() {
    	
    	//return ok("create");
    	return ok(create.render(Form.form(HospitalForm.class)));
    	
    }
    
    public static Result upload() {
    	//Form<UploadResource> filledForm = Form.form(UploadResource.class).bindFromRequest();
    	//final Form<MyObject> form = formFactory.form(MyObject.class).bindFromRequest();
    	DynamicForm requestData = Form.form().bindFromRequest();
    	System.out.println(requestData.get("name") + " -- ");
    	System.out.println(requestData.get("contact") + " -- ");
    	
    	//filledForm.
    	MultipartFormData body = request().body().asMultipartFormData();
    	//DynamicForm b = request().body().as
    	//Sytem.out.println(body.get);
    	FilePart profileImage = body.getFile("imageFile");
    	if (profileImage != null) {
    			try {
    			String fileName = profileImage.getFilename();
    			String contentType = profileImage.getContentType();
    			File file = profileImage.getFile(); 
    			//Path path = FileSystems.getDefault().getPath("/tmp/" + fileName);
    			//System.out.println(path.toAbsolutePath());
    			byte[] hola = FileUtils.readFileToByteArray(file);//; new byte[498];
    			//hola = FileUtils.readFileToByteArray(file);
    			String fpForDb = FileUtils.readFileToString(file, Charset.defaultCharset());
    			System.out.println(hola );
    			System.out.println(hola.length);
    			/*try {
    	            FileUtils.moveFile(file, new File("public/images", fileName));
    	        } catch (IOException ioe) {
    	            System.out.println("Problem operating on filesystem");
    	        }*/
    			
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
    
    public static Result getHospitals() {
    	return ok(toJson(models.Hospital.find.all()));
    }
    

}
