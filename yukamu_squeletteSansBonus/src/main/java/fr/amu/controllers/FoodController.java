package fr.amu.controllers;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.amu.models.Food;
import fr.amu.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller()
public class FoodController {

	private static final Logger log = LoggerFactory.getLogger(FoodController.class);

	@Autowired
	ServletContext context;

	@Autowired
	private FoodService foodService;

	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //

	@RequestMapping(value = "food/add", method = RequestMethod.POST)
	public String addFood(@RequestParam(value = "name") String name,
						  @RequestParam(value = "brand") String brand,
						  @RequestParam(value = "quality") String quality,
						  @RequestParam(value = "type") String type) throws JsonProcessingException {

		Food food = new Food(name, brand, quality, type);

		foodService.add(food);

		List<Food> foods = foodService.findAll();

		context.setAttribute("foods", foods);
		context.setAttribute("types", Food.TYPE.values());
		context.setAttribute("qualities", Food.QUALITY.values());

		context.setAttribute("qualitycounts", mapper.writeValueAsString(foodService.getQualityCounts(foods)));

		return "index";
	}

	@RequestMapping(value = "food/remove", method = RequestMethod.POST)
	public String deleteFood(@RequestParam(value = "foodId") Integer id){

		foodService.delete(id);

		context.setAttribute("foods", foodService.findAll());
		context.setAttribute("types", Food.TYPE.values());
		context.setAttribute("qualities", Food.QUALITY.values());

		return "index";
	}

	@RequestMapping(value = "food/fav", method = RequestMethod.POST)
	public String setFavorite(@RequestParam(value = "id") Integer id){

		foodService.swapFavorite(id);

		context.setAttribute("foods", foodService.findAll());
		context.setAttribute("types", Food.TYPE.values());
		context.setAttribute("qualities", Food.QUALITY.values());

		return "index";
	}

	@RequestMapping(value = "food/type", method = RequestMethod.POST)
	public String filterByType(@RequestParam(value = "type") String type) throws JsonProcessingException {

		List<Food> foods = foodService.findByType(type);

		context.setAttribute("foods", foods);
		context.setAttribute("types", Food.TYPE.values());
		context.setAttribute("qualities", Food.QUALITY.values());

		//context.setAttribute("qualitycounts", mapper.writeValueAsString(foodService.getQualityCounts(foods)));

		return "index";
	}

	@RequestMapping(value = "food/favorites", method = RequestMethod.GET)
	public String filterFavorites(){

		context.setAttribute("foods", foodService.findByFavorite(true));

		return "favoritespage";
	}


}
