package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class CheckLoad
 */
/**
 * @author jenkin
 * 
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * // * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

	}

	@SuppressWarnings({ "unused", "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		String loadtime = DateFormat.getDateTimeInstance().format(new Date());
		if (ip.equals("0:0:0:0:0:0:0:1")||ip.equals("127.0.0.1")) {
			ip = "本地";
		}
		HttpSession session = request.getSession();
		Map<String, String> onlineuser = new HashMap<String, String>();
		onlineuser.put("name", name);
		onlineuser.put("IP", ip);
		onlineuser.put("loadtime",loadtime);
		session.setAttribute("name", onlineuser);
		// System.out.println(onlineuser);
		// System.out.print(name);
		ServletContext application = this.getServletContext();
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");
		
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			for(Map<String, String>user:allUser){
				if(user.get("name").equals(name)){
					json.put("success", "loaded");
					json.put("msg", "您已经登录！");
				}
			}
		/*	if ((name.equals("admin") && pwd.equals("admin"))
					|| (name.equals("務卓") && pwd.equals("jenkin"))) {
				json.put("success", true);
				json.put("msg", "登录成功！");
			} else {
				json.put("success", false);
				json.put("msg", "登录失败！用户名或密码错误！");
			}*/
		} catch (Exception e) {

		}
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			// out.println(pwd);
			out.write(JSON.toJSONString(json));
			System.out.println(JSON.toJSONString(json));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}