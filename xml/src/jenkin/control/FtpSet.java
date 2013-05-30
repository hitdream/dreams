package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import jenkin.model.FTP;

/**
 * Servlet implementation class FtpSet
 */
public class FtpSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static FTP ftp;
	public static String ftpurl = "127.0.0.1";
	public static int port = 21;
	public static String ftpuser = "xml";
	public static String ftppwd = "xml";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FtpSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ftp = new FTP();
		if (request != null) {
			ftpurl = request.getParameter("url");
			String ftpport = request.getParameter("port");
			port = Integer.parseInt(ftpport);
			ftpuser = request.getParameter("ftpUser");
			ftppwd = request.getParameter("ftpPassword");
		}
		// System.out.print(ftpurl + port + ftpuser + ftppwd);

		ftp.setFtpUrl(ftpurl);
		ftp.setPort(port);
		ftp.setFtpUser(ftpuser);
		ftp.setFtpPwd(ftppwd);
	//	System.out.print(ftp.getFtpUrl() + ftp.getPort());
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			json.put("success", true);
			json.put("msg", "…Ë÷√≥…π¶£°");
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(json));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
