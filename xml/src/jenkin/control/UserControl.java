package jenkin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jenkin.model.User;
import jenkin.pageModel.Json;
import jenkin.service.UserServiceI;
import jenkin.service.impl.UserServiceImpl;




/**
 * @author jenkin
 *
 */
public class UserControl {
	public Json logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		Json j = new Json();
		j.setSuccess(true);
		return j;
	}

	public Json login(User user, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		UserServiceI userService = new UserServiceImpl();
		User u = userService.find(user);
		if (u != null) {
			j.setSuccess(true);
			j.setMsg("µÇÂ¼³É¹¦£¡");
		} else {
			j.setMsg("µÇÂ¼Ê§°Ü£¡");
		}
		return j;
	}
}
