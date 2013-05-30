package jenkin.util;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class UserLog {

	public static void main(String[] args) {
		File log = new File("D:\\log\\login.log");
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String date = df.format(d);
		String newLog = "Jim Green,"+ "202.65.21.14," + date ;
		appendLog(log, newLog);
		try {
			BufferedReader br = new BufferedReader(new FileReader(log));
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] info = s.split(",");
				System.out.println(info[0]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void appendLog(File log, String newLog) {
		Scanner sc = null;
		PrintWriter pw = null;
		try {
			if (!log.exists())// 如果文件不存在,则新建.
			{
				File parentDir = new File(log.getParent());
				if (!parentDir.exists())// 如果所在目录不存在,则新建.
					parentDir.mkdirs();
				log.createNewFile();
			}
			sc = new Scanner(log);
			StringBuilder sb = new StringBuilder();
			while (sc.hasNextLine())// 先读出旧文件内容,并暂存sb中;
			{
				sb.append(sc.nextLine());
				sb.append("\r\n");// 换行符作为间隔,扫描器读不出来,因此要自己添加.
			}
			sc.close();

			pw = new PrintWriter(new FileWriter(log), true);
			/* A. */pw.println(sb.toString());// ,写入旧文件内容.
			/* B. */pw.println(newLog);// 写入新日志.
			/*
			 * 如果先写入A,最近日志在文件最后. 如是先写入B,最近日志在文件最前.
			 */
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}