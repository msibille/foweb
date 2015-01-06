package it.finsoft;

import it.finsoft.user.UserVO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CommonController {

	private static DataSource ds = null;

	protected JdbcTemplate getJdbcTemplate() {

		try {
			if (ds == null) {
				InitialContext cxt = new InitialContext();
				ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/FowebDB");

				if (ds == null) {
					throw new RuntimeException("Data source not found!");
				}
			}
			return new JdbcTemplate(ds);
		} catch (NamingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	protected UserVO getLoggedUser(HttpSession session) throws FowebException {
		UserVO currentUser = (UserVO) session.getAttribute("currentUser");

		if (currentUser == null)
			throw new FowebException("Sessione scaduta. Prego riconnettersi");

		return currentUser;

	}
}
