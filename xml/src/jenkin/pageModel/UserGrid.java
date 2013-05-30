package jenkin.pageModel;

import java.util.ArrayList;
import java.util.List;

import jenkin.model.User;

public class UserGrid {
	private int total = 0;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<User> getRows() {
		return rows;
	}

	public void setRows(List<User> rows) {
		this.rows = rows;
	}

	private List<User> rows = new ArrayList<User>();
}
