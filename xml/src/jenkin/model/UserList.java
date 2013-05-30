package jenkin.model;

import java.util.Enumeration;
import java.util.Vector;

public class UserList {
	private static final UserList userlist = new UserList();

	private Vector<String> v;

	private UserList()

	{

		v = new Vector<String>(); // 单例设计模式的特点设置私有，外部不能调用构造方法创造不了实例

	}

	public static UserList getInstance()

	{

		return userlist; // 外部调用类加载的时候调用这个方法就返回UserList对象

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
