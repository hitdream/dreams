package jenkin.listener;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import java.util.ArrayList;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class OnlineUser implements HttpSessionBindingListener {
	public OnlineUser() {
	}

	// 保存在线用户的向量
	private Vector users = new Vector();

	// 得到用户总数
	public int getCount() {
		users.trimToSize();
		return users.capacity();
	}

	// 判断是否存在指定的用户
	public boolean existUser(String userName) {
		users.trimToSize();
		boolean existUser = false;
		for (int i = 0; i < users.capacity(); i++) {
			if (userName.equals((String) users.get(i))) {
				existUser = true;
				break;
			}
		}
		return existUser;
	}

	// 删除指定的用户
	public boolean deleteUser(String userName) {
		users.trimToSize();
		if (existUser(userName)) {
			int currUserIndex = -1;
			for (int i = 0; i < users.capacity(); i++) {
				if (userName.equals((String) users.get(i))) {
					currUserIndex = i;
					break;
				}
			}
			if (currUserIndex != -1) {
				users.remove(currUserIndex);
				users.trimToSize();
				return true;
			}
		}
		return false;
	}

	// 得到当前在线用户的列表
	public Vector getOnLineUser() {
		return users;
	}

	public void valueBound(HttpSessionBindingEvent e) {
		users.trimToSize();
		if (!existUser(e.getName())) {
			users.add(e.getName());
			System.out.print(e.getName() + "\t  登入到系统\t" + (DateFormat.getDateTimeInstance().format(new Date())));
			System.out.println("     在线用户数为：" + getCount());
		} else
			System.out.println(e.getName() + "已经存在");
	}

	public void valueUnbound(HttpSessionBindingEvent e) {
		users.trimToSize();
		String userName = e.getName();
		deleteUser(userName);
		System.out.print(userName + "\t  退出系统\t" + (DateFormat.getDateTimeInstance().format(new Date())));
		System.out.println("     在线用户数为：" + getCount());
	}

}
