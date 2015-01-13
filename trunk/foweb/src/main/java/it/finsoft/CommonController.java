package it.finsoft;

import it.finsoft.user.UserVO;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

@ImportResource("classpath:/datasource.xml")
public abstract class CommonController<T> extends JdbcDaoSupport implements GenericDAO<T> {

	protected UserVO getLoggedUser(HttpSession session) throws FowebException {
		UserVO currentUser = (UserVO) session.getAttribute("currentUser");

		if (currentUser == null)
			throw new FowebException("Sessione scaduta. Prego riconnettersi");

		return currentUser;

	}

}
