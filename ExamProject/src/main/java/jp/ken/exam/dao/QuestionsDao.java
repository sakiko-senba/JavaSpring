package jp.ken.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.ken.exam.entity.Questions;

@Component
public class QuestionsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Questions> questionsMapper = new BeanPropertyRowMapper<Questions>(Questions.class);

	public Questions getQuestionsById(Integer id) {
		String sql = "select * from questions where questionroorrrt_id=?";
		Object[] parameters = { id };

		try {
			Questions questions = jdbcTemplate.queryForObject(sql, parameters, questionsMapper);
			return questions;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public List<Questions> getList() {
		String sql = "select * from questions order by questionroorrrt_id";

		List<Questions> questionsList = jdbcTemplate.query(sql, questionsMapper);
		return questionsList;
	}

}
