package it.finsoft.user;

import it.finsoft.CommonController;
import it.finsoft.FowebException;
import it.finsoft.ReturnVO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends CommonController<UserVO> {
	
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
			UserVO currentUser = (UserVO) getJdbcTemplate().queryForObject(sql, new Object[] { user.getUser(), user.getPassword() }, new BeanPropertyRowMapper<UserVO>(UserVO.class));
			ret.setRetVal(currentUser);
			session.setAttribute("currentUser", currentUser);
		} catch (EmptyResultDataAccessException e) {
			ret.setException(new FowebException("Login non valido"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return ret;
	}

	@Override
	public void insert(UserVO obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO findById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserVO obj) {
		// TODO Auto-generated method stub

	}
}
