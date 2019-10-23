package fr.amu.controllers;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.amu.services.ProductService;

@Controller //annotaiotn pour dire que c'est un controlleur, un servlet est crée dans l'ombre
public class IndexController {

	@Autowired 
	private HttpSession httpSession;

	@Autowired
	ServletContext context;
	
	@Autowired
	ProductService ps; //Toujours utiliser l'interface qui sert de proxy
	
	// quasi copié-collé du cours
    @GetMapping("/")
    public String index(Map<String, Object> model) {
    	String sessionUser= (String) httpSession.getAttribute("user");
    	model.put("products", ps.getProducts() );
    	
//    	if(sessionUser==null) {
//    		return "login";
//    	}
		
		System.out.println("session user = " + sessionUser);
		return "homepage";    	
    }  
    
    

}