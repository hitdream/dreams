package jenkin.listener;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener {
	// 声明一个ServletContext对象
	private ServletContext application = null;

	// ServletContext创建时调用该方法
	public void contextInitialized(ServletContextEvent sce) {
		// 储存所用用户名
		ArrayList<Map<String, String>> allUser = new ArrayList<Map<String, String>>();
		// 获得当前application对象
		application = sce.getServletContext();
		// 设置到application范围
		application.setAttribute("allUser", allUser);

	}

	// ServletContext销毁时调用该方法
	public void contextDestroyed(ServletContextEvent sce) {

	}

	// session创建时调用该方法
	public void sessionCreated(HttpSessionEvent se) {

	}

	// session销毁时调用该方法
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		// 获得当前所有的用户
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");
		// 获得删除的用户
		Map<String, String> user = (Map<String, String>) se.getSession()
				.getAttribute("name");
		// 删除该用户
		allUser.remove(user);
		// 重新设置到application范围中
		application.setAttribute("allUser", allUser);
	//	System.out.println("fdsadgdsa" + allUser.size());
	}

	// session范围属性添加时调用
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 获得当前所有的用户
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");
		// 获得添加的用户
		@SuppressWarnings("unchecked")
		Map<String, String> user = (Map<String, String>) se.getValue();
		// 添加到所有用户中
		allUser.add(user);
//		System.out.println("DSFAGSAGDASG"+user);

	}

	// session范围属性移除时调用
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	// session范围属性替换时调用
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
