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
	@Autowired
	JdbcTemplate jt;

	// id INTEGER IDENTITY PRIMARY KEY, name VARCHAR(255), imgurl VARCHAR(255), tag
	// VARCHAR(255), done BOOLEAN
	@Override
	public Integer add(Food food) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Food(name,imgurl,tag,done) values(?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		String id_column = "ID";

		jt.update(con -> {
			PreparedStatement ps = con.prepareStatement(sql, new String[] { id_column });
			ps.setString(1, food.getName());
			ps.setString(2, food.getImgurl());
			ps.setString(3, food.getTag());
			ps.setBoolean(4, food.isDone());
			return ps;
		}, keyHolder);
		Integer id = (Integer) keyHolder.getKeys().get(id_column);
		return id.intValue();
	}

	@Override
	public void update(Food food) {
		// TODO Auto-generated method stub
		String sql = ("UPDATE food set name = ?,  imgurl = ?, tag = ?,  done = ? WHERE id = ?");
		jt.update(sql, food.getName(), food.getImgurl(), food.getTag(), food.isDone(), food.getId());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM food WHERE id = ?";
		jt.update(sql, id);
	}

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food", rowMapper);
	}

	@Override
	public Food findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM food WHERE id = ?";
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Food> findByTag(String tag) {
		// TODO Auto-generated method stub
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE tag = ?", rowMapper, tag);
	}

	@Override
	public List<Food> findByDone(boolean bool) {
		// TODO Auto-generated method stub
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE done = ?", rowMapper, bool);
	}

	@Override
	public List<Food> findByTagAndDone(String tag, boolean done) {
		// TODO Auto-generated method stub
		RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);
		return jt.query("SELECT * FROM food WHERE tag = ? AND done = ?", rowMapper, tag, done);
	}

}
