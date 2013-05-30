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
	// ����һ��ServletContext����
	private ServletContext application = null;

	// ServletContext����ʱ���ø÷���
	public void contextInitialized(ServletContextEvent sce) {
		// ���������û���
		ArrayList<Map<String, String>> allUser = new ArrayList<Map<String, String>>();
		// ��õ�ǰapplication����
		application = sce.getServletContext();
		// ���õ�application��Χ
		application.setAttribute("allUser", allUser);

	}

	// ServletContext����ʱ���ø÷���
	public void contextDestroyed(ServletContextEvent sce) {

	}

	// session����ʱ���ø÷���
	public void sessionCreated(HttpSessionEvent se) {

	}

	// session����ʱ���ø÷���
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		// ��õ�ǰ���е��û�
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");
		// ���ɾ�����û�
		Map<String, String> user = (Map<String, String>) se.getSession()
				.getAttribute("name");
		// ɾ�����û�
		allUser.remove(user);
		// �������õ�application��Χ��
		application.setAttribute("allUser", allUser);
	//	System.out.println("fdsadgdsa" + allUser.size());
	}

	// session��Χ�������ʱ����
	public void attributeAdded(HttpSessionBindingEvent se) {
		// ��õ�ǰ���е��û�
		ArrayList<Map<String, String>> allUser = (ArrayList<Map<String, String>>) application
				.getAttribute("allUser");
		// �����ӵ��û�
		@SuppressWarnings("unchecked")
		Map<String, String> user = (Map<String, String>) se.getValue();
		// ��ӵ������û���
		allUser.add(user);
//		System.out.println("DSFAGSAGDASG"+user);

	}

	// session��Χ�����Ƴ�ʱ����
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	// session��Χ�����滻ʱ����
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
