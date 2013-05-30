package jenkin.model;

import java.util.ArrayList;
import java.util.List;

public class TreeGrid {
	private int total;
	private List<TreeDataBuild> rows = new ArrayList<TreeDataBuild>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<TreeDataBuild> getRows() {
		return rows;
	}

	public void setRows(List<TreeDataBuild> rows) {
		this.rows = rows;
	}

}
