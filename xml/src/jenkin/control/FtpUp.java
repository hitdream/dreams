package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jenkin.model.FTP;
import jenkin.service.FileUploadI;
import jenkin.service.impl.FileUploadImpl;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class FtpUp
 */
public class FtpUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String url = "127.0.0.1";
	public static int port = 21;
	public static String ftpuser = "xml";
	public static String ftppwd = "xml";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FtpUp() {
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
		Map<String, Object> json = new HashMap<String, Object>();

		try {
			FileUploadI ftpFile = new FileUploadImpl();
			ftpFile.intiUpload(request, response);
			FTP ftp = FtpSet.ftp;
			url = ftp.getFtpUrl();
			port = ftp.getPort();
			ftpuser = ftp.getFtpUser();
			ftppwd = ftp.getFtpPwd();
			System.out.print(url + port + ftpuser + ftppwd);
			boolean result = ftpFile.upload2FtpServer(url, port, ftpuser,
					ftppwd);
			if (result) {
				json.put("success", true);
				json.put("msg", "上传成功！");
			} else {
				json.put("success", false);
				json.put("msg", "上传失败！");
			}
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

		} catch (NullPointerException ioe) {
			ioe.getMessage();
			System.out.print(ioe.getMessage()
					+ "___________________________________");
			json.put("success", false);
			json.put("msg", "上传失败！请检查FTP设置。");
		}
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(json));
	}

}