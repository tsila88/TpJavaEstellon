package fr.amu.models;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FoodDAOImpl implements FoodDAO {

	// (id , name , brand), quality type , favorite BOOLEAN
	@Autowired
	JdbcTemplate jt;

	@Override
	public Integer add(Food food) {
		String sql = "INSERT INTO Food(name,brand,quality,type,favorite) values(?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		String id_column = "ID";

		jt.update(con -> {
			PreparedStatement ps = con.prepareStatement(sql, new String[] { id_column });
			ps.setString(1, food.getName());
			ps.setString(2, food.getBrand());
			ps.setString(3, food.getQuality());
			ps.setString(4, food.getType());
			ps.setBoolean(5, food.isFavorite());
			return ps;
		}, keyHolder);
		Integer id = (Integer) keyHolder.getKeys().get(id_column);
		return id.intValue();
	}

	@Override
	public void update(Food food) {
		
		
		String sql = ("UPDATE food set name = ?,  brand = ?, quality = ?,  type = ?,  favorite = ? WHERE id = ?");
		jt.update(sql, food.getName(), food.getBrand(), food.getQuality(), food.getType(), food.isFavorite(),
				food.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM food WHERE id = ?";
		jt.update(sql, id);

	}

	@Override
	public List<Food> findAll() {
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food", rowMapper);
	}

	@Override
	public Food findById(Integer id) {
		String sql = "SELECT * FROM food WHERE id = ?";
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Food> findByType(String type) {
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE type = ?", rowMapper,type);
	}

	@Override
	public List<Food> findByQuality(String quality) {
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE quality = ?", rowMapper, quality);
	}

	
	
	@Override
	public List<Food> findByQualityAndType(String quality, String type) {
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE quality = ? AND type = ?", rowMapper,quality,type);
	}

	@Override
	public List<Food> findByFavorite(boolean bool) {
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE favorite = ? ", rowMapper,bool);
	}

}
