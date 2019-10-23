package fr.amu.controllers;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.amu.models.Food;
import fr.amu.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private FoodService foodService;

	@Autowired
	ServletContext context;
	
	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //
	
	// TODO : completer avec les methodes adequates
    
    @RequestMapping(value = "/shutdown", method = RequestMethod.GET)
    public void shutdown() {
    	System.exit(0);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() throws JsonProcessingException {

    	List<Food> foods = foodService.findAll();

    	context.setAttribute("foods", foods);
		context.setAttribute("types", Food.TYPE.values());
		context.setAttribute("qualities", Food.QUALITY.values());

		context.setAttribute("qualitycounts", mapper.writeValueAsString(foodService.getQualityCounts(foods)));


		return "index";
	}

}