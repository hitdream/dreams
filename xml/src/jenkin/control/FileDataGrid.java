package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jenkin.model.FTP;
import jenkin.model.FileList;
import jenkin.pageModel.DataGrid;
import jenkin.service.FileUploadI;
import jenkin.service.impl.FileUploadImpl;
import jenkin.util.FtpListFile;

/**
 * Servlet implementation class FileDataGrid
 */
public class FileDataGrid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String url = "127.0.0.1";
	public static int port = 21;
	public static String ftpuser = "xml";
	public static String ftppwd = "xml";
	private int page;
	private int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDataGrid() {
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
		try {
			FileUploadI ftpFile = new FileUploadImpl();
			ftpFile.intiUpload(request, response);
			FTP ftp = FtpSet.ftp;
			if (ftp != null) {
				url = ftp.getFtpUrl();
				port = ftp.getPort();
				ftpuser = ftp.getFtpUser();
				ftppwd = ftp.getFtpPwd();
			}
			DataGrid json = FtpListFile.listFile(url, port, ftpuser, ftppwd);
			DataGrid list = new DataGrid();
			FileDataGrid page_rows = new FileDataGrid();
			page_rows.setPage(Integer.parseInt(request.getParameter("page")));
			page_rows.setRows(Integer.parseInt(request.getParameter("rows")));
			int Page = page_rows.getPage();
			int Rows = page_rows.getRows();
			int filecount = 0;
			PrintWriter out = response.getWriter();
			list.setTotal(json.getTotal());
			if (Page * Rows > list.getTotal())// ∑÷“≥¥¶¿Ì
			{

				filecount = list.getTotal();
			} else {
				filecount = Page * Rows;
			}
			for (int i = (Page - 1) * Rows; i < filecount; i++) {
				list.getRows().add(json.getRows().get(i));
			}
			out.write(JSON.toJSONString(list));
			/*
			 * out.write(JSON.toJSONString(json.getRows().subList((Page-1)*Rows,
			 * Page*Rows)));
			 */
			// System.out.print(Page+","+Rows);
			// System.out.print(JSON.toJSONString(list));
			// System.out.print("================================"+JSON.toJSONString(json.getRows().subList((Page-1)*Rows,
			// Page*Rows-1))+"++++++++++++++++++++++++++++++++");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
