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

	// ���������û�������
	private Vector users = new Vector();

	// �õ��û�����
	public int getCount() {
		users.trimToSize();
		return users.capacity();
	}

	// �ж��Ƿ����ָ�����û�
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

	// ɾ��ָ�����û�
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

	// �õ���ǰ�����û����б�
	public Vector getOnLineUser() {
		return users;
	}

	public void valueBound(HttpSessionBindingEvent e) {
		users.trimToSize();
		if (!existUser(e.getName())) {
			users.add(e.getName());
			System.out.print(e.getName() + "\t  ���뵽ϵͳ\t" + (DateFormat.getDateTimeInstance().format(new Date())));
			System.out.println("     �����û���Ϊ��" + getCount());
		} else
			System.out.println(e.getName() + "�Ѿ�����");
	}

	public void valueUnbound(HttpSessionBindingEvent e) {
		users.trimToSize();
		String userName = e.getName();
		deleteUser(userName);
		System.out.print(userName + "\t  �˳�ϵͳ\t" + (DateFormat.getDateTimeInstance().format(new Date())));
		System.out.println("     �����û���Ϊ��" + getCount());
	}

}
