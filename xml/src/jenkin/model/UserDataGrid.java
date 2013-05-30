package jenkin.model;

import java.util.ArrayList;
import java.util.List;

public class UserDataGrid {
	private int total;
	private List<User> users = new ArrayList<User>();

	public int getTotal() {
		return total;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setTotal(int total) {
		this.total = total;
	}


}
