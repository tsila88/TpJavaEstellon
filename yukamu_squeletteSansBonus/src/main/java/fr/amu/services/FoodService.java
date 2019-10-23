package fr.amu.services;

import fr.amu.models.Food;
import fr.amu.models.FoodDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodService {

    @Autowired
    private FoodDAO dao;

    public FoodService() { }

    public Integer add(Food food){
        if(food == null)
            return null;

        return dao.add(food);
    }

    public void update(Food food){
        if(food == null)
            return;

        dao.update(food);
    }

    public void delete(Integer id){
        if(id == null)
            return;

        dao.delete(id);
    }

    public List<Food> findAll(){
        return dao.findAll();
    }

    public void swapFavorite(Integer id){
        if(id == null)
            return;

        Food food = dao.findById(id);
        food.setFavorite(!food.isFavorite());
        dao.update(food);
    }

    public Food findById( Integer id ){
        if(id == null)
            return null;

        return dao.findById(id);
    }

    public List<Food> findByType(String type){
        if(type == null)
            return new ArrayList<>();

        if(type.equals("ALL"))
            return dao.findAll();

        return dao.findByType(type);
    }

    public List<Food> findByQuality(String quality){
        if(quality == null)
            return new ArrayList<>();

        return dao.findByQuality(quality);
    }

    public List<Food> findByQualityAndType(String quality, String type){
        if(quality == null || type == null)
            return new ArrayList<>();

        return dao.findByQualityAndType(quality, type);
    }

    public List<Food> findByFavorite(boolean bool){
        return dao.findByFavorite(bool);
    }

    public Map<String, Integer> getQualityCounts(List<Food> foods){
        Map<String, Integer> mapOccurence = new HashMap<>();

        for(Food.QUALITY quality : Food.QUALITY.values()){
            mapOccurence.put(quality.name(), 0);
        }

        for(Food food : foods){
            mapOccurence.replace(food.getQuality(), mapOccurence.get(food.getQuality()) + 1);
        }

        return mapOccurence;
    }

}