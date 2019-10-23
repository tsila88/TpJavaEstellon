package fr.amu.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Food;
import fr.amu.models.FoodDAO;

@Service
public class FoodService {

	@Autowired
	FoodDAO foodDAO;

	public Integer add(Food food) {

		return foodDAO.add(food);
	}

	public void update(Food food) {
		foodDAO.update(food);
	}

	public void delete(Integer id) {
		foodDAO.delete(id);
	}

	public List<Food> findAll() {
		return foodDAO.findAll();
	}

	public Food findById(Integer id) {
		return foodDAO.findById(id);
	}

	public List<Food> findByTag(String type) {
		return foodDAO.findByTag(type);
	}

	public List<Food> findByDone(boolean bool) {
		return foodDAO.findByDone(bool);
	}

	public List<Food> findByTagAndDone(String tag, boolean done) {
		return foodDAO.findByTagAndDone(tag, done);
	}

	public Map<String, Integer> countByState(List<Food> foods) {

		Map<String, Integer> progresscounts = new HashMap<String, Integer>();

		// int numberFoodDone = 0, numberFoodTodo = 0;
		progresscounts.put("DONE", 0);
		progresscounts.put("TODO", 0);
		// progresscounts.put

		for (Food food : foods) {
			if (food.isDone()) {
				progresscounts.put("DONE", progresscounts.get("DONE") + 1);
			} else {
				progresscounts.put("TODO", progresscounts.get("TODO") + 1);
			}
		}
		return progresscounts;
	}

	public List<Food>  filter(String TODO,String DONE) {
		
		List<Food> foods = null;
		if (TODO != null && DONE == null) {
			foods = this.findByDone(false);
			
		}
		if (TODO == null && DONE != null) {
			foods = this.findByDone(true);
			
		}

		if 	((TODO != null && DONE != null) || (TODO == null && DONE == null)) {
			foods = this.findByDone(true);
			
			foods = this.findAll();
		}
		
		return foods;
		
	}
}