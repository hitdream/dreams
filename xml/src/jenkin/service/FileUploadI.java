package jenkin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileUploadI {
	public void intiUpload(HttpServletRequest request,
			HttpServletResponse response);

	public boolean upload2FtpServer(String url, int port, String username,
			String password);
}
