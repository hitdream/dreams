package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jenkin.model.User;
import jenkin.pageModel.UserGrid;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Login
 */
/**
 * @author jenkin
 * 
 */
public class OnlineUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String ip;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnlineUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		// Map<String, String> user = (Map<String, String>) session
		// .getAttribute("name");
		// System.out.println("Ãù¹Ä¶ø¹¥ »êÇ£ÃÎÝÓ»êÇ£ÃÎÝÓ»êÇ£ÃÎÝÓ»êÇ£ÃÎÝÓ³ÇÑî»¨Ñ©Âä¸²°×Æ»Ìü"+user);
		ServletContext application = this.getServletContext();
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");

		UserGrid ug = new UserGrid();
		ug.setTotal(allUser.size());
		// System.out.println(allUser.size()+"ÑÏ³ÉÄ£Ò»");
		for (int i = 0; i < allUser.size(); i++) {
			User users = new User();
			users.setIp(allUser.get(i).get("IP"));
			users.setName(allUser.get(i).get("name"));
			users.setLoadDate(allUser.get(i).get("loadtime"));
			ug.getRows().add(users);
		}
		String jsonS = JSONObject.fromObject(ug).toString();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(jsonS);
	//	System.out.print(jsonS);
	}
}
