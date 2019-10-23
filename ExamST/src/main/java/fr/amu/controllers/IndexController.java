package fr.amu.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.amu.models.Food;
import fr.amu.services.FoodService;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ServletContext context;

	@Autowired
	FoodService foodService;

	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le
													// graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //

	// TODO : completer avec les methodes adequates

	@RequestMapping(value = "/shutdown", method = RequestMethod.GET)
	public void shutdown() {
		System.exit(0);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		List<Food> foods = foodService.findAll();
		ObjectMapper mapper = new ObjectMapper();
		model.put("foods", foods);
	
		model.put("types", Food.TYPE.values());
		model.put("qualities", Food.QUALITY.values());
		model.put("qualitycounts", mapper.writeValueAsString(foodService.qualityCounts(foods)));
		return "index";
	}

}
