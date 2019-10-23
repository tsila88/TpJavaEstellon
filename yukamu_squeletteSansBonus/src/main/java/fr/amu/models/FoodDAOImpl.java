package fr.amu.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Transactional
@Repository
public class FoodDAOImpl implements FoodDAO {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Integer add(Food food) {
        String sql = "INSERT INTO food(name,brand,quality,type,favorite) values(?, ?, ?, ?, ?)";

        KeyHolder key = new GeneratedKeyHolder();

        jt.update(connection -> {
                final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, food.getName());
                ps.setString(2, food.getBrand());
                ps.setString(3, food.getQuality());
                ps.setString(4, food.getType());
                ps.setBoolean(5, food.isFavorite());

                return ps;
            }, key);


        return key.getKey().intValue();
    }

    @Override
    public void update(Food food) {
        String sql = "UPDATE food SET name = ?, brand = ?, quality = ?, type = ?, favorite = ? WHERE id = ?";
        jt.update(sql, food.getName(), food.getBrand(), food.getQuality(), food.getType(), food.isFavorite(), food.getId());
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
        String sql = "SELECT * FROM food WHERE type = ?";

        RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);

        return jt.query(sql, rowMapper, type);
    }

    @Override
    public List<Food> findByQuality(String quality) {
        String sql = "SELECT * FROM food WHERE quality = ?";

        RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);

        return jt.query(sql, rowMapper, quality);
    }

    @Override
    public List<Food> findByQualityAndType(String quality, String type) {
        String sql = "SELECT * FROM food WHERE quality = ? and type = ?";

        RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);

        return jt.query(sql, rowMapper, quality, type);
    }

    @Override
    public List<Food> findByFavorite(boolean bool) {
        String sql = "SELECT * FROM food WHERE favorite = ?";

        RowMapper<Food> rowMapper = new BeanPropertyRowMapper<Food>(Food.class);

        return jt.query(sql, rowMapper, bool);
    }
}
