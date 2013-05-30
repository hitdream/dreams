package jenkin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jenkin.pageModel.Json;

/**
 * Servlet implementation class Logout
 */
/**
 * @author jenkin
 * 
 */
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}
		Json j = new Json();
		j.setSuccess(true);
	}

	private static final long serialVersionUID = 1L;

	public Logout() {
		super();
	}

}
