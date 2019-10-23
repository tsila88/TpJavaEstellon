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

	public FoodService() {

	}

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

	public List<Food> findByType(String type) {
		return foodDAO.findByType(type);
	}

	public List<Food> findByQuality(String quality) {
		return foodDAO.findByQuality(quality);
	}

	public List<Food> findByQualityAndType(String quality, String type) {
		return foodDAO.findByQualityAndType(quality, type);
	}

	public List<Food> findByFavorite(boolean bool) {
		return foodDAO.findByFavorite(bool);
	}

	public void changeFavori(Integer id) {
		Food food = foodDAO.findById(id);
		food.setFavorite(!food.isFavorite());
		foodDAO.update(food);
	}

	public Map<String, Integer> qualityCounts(List<Food> foods) {

		Map<String, Integer> qualityCount = new HashMap<String, Integer>();

		
		for (Food.QUALITY quality : Food.QUALITY.values()) {
			qualityCount.put(quality.name(), 0);
		}

		for (Food food : foods) {
			
			qualityCount.replace(food.getQuality(), qualityCount.get(food.getQuality())+1);
		}
		
		return qualityCount;

	}
}