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
	// id INTEGER IDENTITY PRIMARY KEY, name VARCHAR(255), imgurl VARCHAR(255), tag
	// VARCHAR(255), done BOOLEAN
	@RequestMapping(value = "food/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		Food food = new Food(request.getParameter("name"), request.getParameter("imgurl"));
		foodService.add(food);
		List<Food> foods = foodService.findAll();
		model.put("foods", foods);
		model.put("tags", Food.TAG.values());
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		return "index";

	}

	@RequestMapping(value = "food/remove", method = RequestMethod.POST)
	public String remove(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {

		int id = Integer.valueOf(request.getParameter("id"));
		foodService.delete(id);
		List<Food> foods = foodService.findAll();
		model.put("foods", foods);
		model.put("tags", Food.TAG.values());
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		return "index";

	}

	@RequestMapping(value = "food/tag", method = RequestMethod.POST)
	public String addTag(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {

		int id = Integer.valueOf(request.getParameter("id"));
		Food food = foodService.findById(id);
		String tag = request.getParameter("tag");
		food.setTag(tag);

		if (tag.equals("NONE"))
			food.setDone(false);
		else {
			food.setDone(true);
		}
		foodService.update(food);
		List<Food> foods = foodService.findAll();
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		model.put("foods", foods);
		model.put("tags", Food.TAG.values());

		return "index";
	}

	@RequestMapping(value = "food/change", method = RequestMethod.POST)
	public String change(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {

		int id = Integer.valueOf(request.getParameter("id"));
		Food food = foodService.findById(id);
		food.setTag("NONE");
		food.setDone(false);
		foodService.update(food);
		List<Food> foods = foodService.findAll();
		model.put("foods",foods);
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		model.put("tags", Food.TAG.values());

		return "index";
	}

	@RequestMapping(value = "food/filter", method = RequestMethod.POST)
	public String filter(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		
		List<Food> foods = foodService.filter(request.getParameter("todo"), request.getParameter("done"));
		model.put("foods", foods);
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		model.put("tags", Food.TAG.values());

		return "index";
	}

	@RequestMapping(value = "/progress", method = RequestMethod.GET)
	public String progress(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {

		List<Food> foodsDone = foodService.findByDone(true);
		List<Food> foodsTodo = foodService.findByDone(false);

		model.put("foodsDone", foodsDone);
		model.put("foodsTodo", foodsTodo);
		model.put("tags", Food.TAG.values());

		return "progresspage";
	}

	// filterTag
	@RequestMapping(value = "/filterTag", method = RequestMethod.POST)
	public String filterTag(HttpServletRequest request, Map<String, Object> model) throws JsonProcessingException {
		String tag = request.getParameter("tag");

		if (tag.equals("ALL")) {
			model.put("foodsDone", foodService.findByDone(true));
			model.put("foodsTodo", foodService.findByDone(false));
		} else {
			model.put("foodsDone", foodService.findByTagAndDone(tag, true));
			model.put("foodsTodo", foodService.findByTagAndDone(tag, false));
		}

		model.put("tags", Food.TAG.values());
		List<Food> foods = foodService.findAll();
		model.put("progresscounts", mapper.writeValueAsString(foodService.countByState(foods)));
		return "progresspage";
	}
}
