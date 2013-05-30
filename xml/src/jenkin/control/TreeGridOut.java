package jenkin.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jenkin.model.TreeDataBuild;
import jenkin.model.TreeGrid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class TreeGridOut
 */
public class TreeGridOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TreeGridOut() {
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
			TreeDataBuild tdb = new TreeDataBuild();
			TreeGrid tg = new TreeGrid();
			tdb.setId("1");
			tdb.setCode("1");
			tdb.setElement("大本营");
			tdb.setValue("大规模");
			tdb.setState("closed");

			tg.setTotal(5);
			tg.getRows().add(tdb);
			TreeDataBuild tdb1 = new TreeDataBuild();
			tdb1.setId("1_1");
			tdb1.setCode("1_1");
			tdb1.setElement("顶戴");
			tdb1.setValue("需要");
			tdb1.set_parentId("1");
			tg.getRows().add(tdb1);
			TreeDataBuild tdb2 = new TreeDataBuild();
			tdb2.setId("1_2");
			tdb2.setCode("1_2");
			tdb2.setElement("kaii");
			tdb2.setValue("msutd");
			tdb2.set_parentId("1");
			tg.getRows().add(tdb2);
			String json = JSONObject.fromObject(tg).toString();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			System.out.print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
