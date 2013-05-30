package jenkin.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jenkin.service.FileUploadI;
import jenkin.util.FtpUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadImpl implements FileUploadI {
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	String temp = "";
	String path = "";

	@Override
	public boolean upload2FtpServer(String url, int port, String username,
			String password) {
		boolean result = false;
		try {

			File uploadFile = new File(path);
			if (!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			File tempFile = new File(temp);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setRepository(tempFile);
				factory.setSizeThreshold(4096);
				ServletFileUpload upload = new ServletFileUpload(factory);
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					String name = item.getFieldName();
					if (item.isFormField()) {
						String value = item.getString();
						request.setAttribute(name, value);
					} else {
						String value = item.getName();
						int start = value.lastIndexOf("\\");
						String fileName = value.substring(start + 1);
						request.setAttribute(name, fileName);
						File saveFile = new File(uploadFile, fileName);
						item.write(saveFile);
						System.out.println("文件成功上传到web服务器！");
						item.delete();
						FileInputStream input = new FileInputStream(saveFile);
						FtpUpload.uploadFile(url, port, username, password,
								"\\", fileName, input);
						System.out.println("文件成功上传到FTP！");
						saveFile.delete();
						System.out.println("文件名:" + fileName);
						result = true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void intiUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			this.request = request;
			this.response = response;
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			path = request.getRealPath("/upload");
			temp = request.getRealPath("/temp");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
