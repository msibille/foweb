package it.finsoft.user;

import it.finsoft.CommonController;
import it.finsoft.FowebException;
import it.finsoft.ReturnVO;

import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends CommonController {

	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public ReturnVO<UserVO> logon(HttpSession session, @RequestBody UserVO user) {// @RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {

		ReturnVO<UserVO> ret = new ReturnVO<UserVO>();
		//@formatter:off
		String sql = "SELECT id_user, "
					+ "    	matricola, "
					+ "    	cognome, "
					+ "    	nome, "
					+ "    	telefono, "
					+ "    	mail, "
					+ "    	foto, "
					+ "    	user "
					+ "FROM "
					+ "		users "
					+ "WHERE "
					+ "		user = ? AND "
					+ "		password = ?";
		//@formatter:on

		try {
			JdbcTemplate jdbcTemplate = getJdbcTemplate();
			UserVO currentUser = (UserVO) jdbcTemplate.queryForObject(sql, new Object[] { user.getUser(), user.getPassword() }, new BeanPropertyRowMapper<UserVO>(UserVO.class));
			ret.setRetVal(currentUser);
			session.setAttribute("currentUser", currentUser);
		} catch (EmptyResultDataAccessException e) {
			ret.setException(new FowebException("Login non valido"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return ret;
	}
}
