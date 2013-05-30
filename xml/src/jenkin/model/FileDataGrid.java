package jenkin.model;

import java.util.ArrayList;
import java.util.List;

public class FileDataGrid {
	private int total;
	private List<FileList> files = new ArrayList<FileList>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<FileList> getFiles() {
		return files;
	}

	public void setFiles(List<FileList> files) {
		this.files = files;
	}
}
