package dao.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import entity.com.eproductEntity;

public class eproductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<eproductEntity> getAllProducts() {

		return jdbcTemplate.query("select * from eproduct", new RowMapper<eproductEntity>() {

			public eproductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

				eproductEntity obj = new eproductEntity();
				obj.setId(rs.getLong(1));
				obj.setName(rs.getString(2));
				obj.setPrice(rs.getBigDecimal(3));
				return obj;
			}
		});

	}

	public eproductEntity getProductById(long id) {

		return jdbcTemplate.query("select * from eproduct where id=" + id, new ResultSetExtractor<eproductEntity>() {

			public eproductEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					eproductEntity obj = new eproductEntity();
					obj.setId(rs.getLong(1));
					obj.setName(rs.getString(2));
					obj.setPrice(rs.getBigDecimal(3));
					return obj;

				}
				return null;
			}
		});
	}

	public void updateProduct(eproductEntity obj) {
		if (obj.getId() > 0) {
			String sql = "update eproduct set name=?,price=? where id=?";
			jdbcTemplate.update(sql, obj.getName(), obj.getPrice(), obj.getId());
		} else {
			String sql = "insert into eproduct (name,price) values (?,?)";
			jdbcTemplate.update(sql, obj.getName(), obj.getPrice());
		}
	}

}
