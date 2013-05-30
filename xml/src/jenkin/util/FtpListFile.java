package jenkin.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import jenkin.model.FileList;
import jenkin.pageModel.DataGrid;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.alibaba.fastjson.JSON;

public class FtpListFile {
	public static DataGrid listFile(String url, int port, String username,
			String password) {
		DataGrid dg = new DataGrid();
		FTPClient ftp = new FTPClient();
		/*try {
		//	path = new String(path.getBytes("gbk"), "iso-8859-1");
			// filename = new String(filename.getBytes("gbk"), "iso-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		try {
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			ftp.login(username, password);// 登录
			System.out.println("FTP登录成功.");
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.out.println("连接服务器失败");
			}
			ftp.setControlEncoding("utf-8");

			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");

		//	ftp.changeWorkingDirectory(path);
			FTPFile[] files = ftp.listFiles();

			
			dg.setTotal( files.length);
			for (int i = 0; i < files.length; i++) {
				FileList filelist = new FileList();
				filelist.setId(i+1);
				filelist.setFileName(files[i].getName());
				dg.getRows().add(filelist);

			}
		//	System.out.print(JSON.toJSONString(dg));
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return dg;
	}

	/*public static void main(String[] args) {
		listFile("127.0.0.1", 21, "xml", "xml");
	}*/
}
