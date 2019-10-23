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
public class FoodController {

	private static final Logger log = LoggerFactory.getLogger(FoodController.class);

	@Autowired
	ServletContext context;

	@Autowired
	FoodService foodService;

	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le
	
// graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //

	// TODO : completer avec les methodes adequates
	// (id , name , brand), quality type , favorite BOOLEAN
	@RequestMapping(value = "/food/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		Food food = new Food(request.getParameter("name"), request.getParameter("brand"),
				request.getParameter("quality"), request.getParameter("type"));
		List<Food> foods = foodService.findAll();
		foodService.add(food);

		model.put("foods", foods);

		model.put("types", Food.TYPE.values());
		model.put("qualities", Food.QUALITY.values());
		model.put("qualitycounts", mapper.writeValueAsString(foodService.qualityCounts(foods)));

		return "index";
	}

	@RequestMapping(value = "food/remove", method = RequestMethod.POST)
	public String remove(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		log.info("ID = " + String.valueOf(request.getParameter("foodId")));
		int id = Integer.valueOf(request.getParameter("foodId"));
		foodService.delete(id);
		List<Food> foods = foodService.findAll();
		model.put("foods", foods);
		model.put("types", Food.TYPE.values());
		model.put("qualities", Food.QUALITY.values());
		model.put("qualitycounts", mapper.writeValueAsString(foodService.qualityCounts(foods)));
		return "index";
	}

	@RequestMapping(value = "food/type", method = RequestMethod.POST)
	public String findByType(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		// log.info("ID = " + String.valueOf( request.getParameter("type") ));
		// int id = Integer.valueOf(request.getParameter("foodId"));
		List<Food> foods = foodService.findAll();
		if (request.getParameter("type").equals("ALL")) {
			model.put("foods", foodService.findAll());
		} else {
			model.put("foods", foodService.findByType(request.getParameter("type")));
		}
		model.put("types", Food.TYPE.values());
		model.put("qualities", Food.QUALITY.values());
		model.put("qualitycounts", mapper.writeValueAsString(foodService.qualityCounts(foods)));
		return "index";

	}

	@RequestMapping(value = "food/favori", method = RequestMethod.POST)
	public String addFavori(HttpServletRequest request, Map<String, Object> model) {
		int id = Integer.valueOf(request.getParameter("foodId"));
		// model.put("food", foodService.addFav(id));
		log.info("ID = " + String.valueOf(request.getParameter("foodId")));
		foodService.changeFavori(id);
		model.put("foods", foodService.findAll());
		model.put("types", Food.TYPE.values());
		model.put("qualities", Food.QUALITY.values());
		return "index";
	}

	@RequestMapping(value = "food/favorites", method = RequestMethod.GET)
	public String getFavorites(HttpServletRequest request, Map<String, Object> model) {

		model.put("foods", foodService.findByFavorite(true));
		// context.setAttribute("foods", foodService.findByFavorite(true));
		return "favoritespage";

	}

}
