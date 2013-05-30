package jenkin.pageModel;

import java.util.ArrayList;
import java.util.List;

import jenkin.model.FileList;

/**
 * @author jenkin
 *
 */
public class DataGrid {
	private int total = 0;
	private List<FileList> rows = new ArrayList<FileList>();
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<FileList> getRows() {
		return rows;
	}
	public void setRows(List<FileList>  rows) {
		this.rows = rows;
	}
}
