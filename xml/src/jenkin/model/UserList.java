package jenkin.model;

import java.util.Enumeration;
import java.util.Vector;

public class UserList {
	private static final UserList userlist = new UserList();

	private Vector<String> v;

	private UserList()

	{

		v = new Vector<String>(); // �������ģʽ���ص�����˽�У��ⲿ���ܵ��ù��췽�����첻��ʵ��

	}

	public static UserList getInstance()

	{

		return userlist; // �ⲿ��������ص�ʱ�������������ͷ���UserList����

	}

	public void addUser(String name)

	{

		if (name != null)

		{

			v.addElement(name);

		}

	}

	public void removeUser(String name)

	{

		if (name != null)

		{

			v.remove(name);

		}

	}

	public Enumeration<String> getUserList()

	{

		return v.elements();

	}

	public int getUserCount()

	{

		return v.size();

	}

}
