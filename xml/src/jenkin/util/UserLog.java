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
			if (!log.exists())// ����ļ�������,���½�.
			{
				File parentDir = new File(log.getParent());
				if (!parentDir.exists())// �������Ŀ¼������,���½�.
					parentDir.mkdirs();
				log.createNewFile();
			}
			sc = new Scanner(log);
			StringBuilder sb = new StringBuilder();
			while (sc.hasNextLine())// �ȶ������ļ�����,���ݴ�sb��;
			{
				sb.append(sc.nextLine());
				sb.append("\r\n");// ���з���Ϊ���,ɨ������������,���Ҫ�Լ����.
			}
			sc.close();

			pw = new PrintWriter(new FileWriter(log), true);
			/* A. */pw.println(sb.toString());// ,д����ļ�����.
			/* B. */pw.println(newLog);// д������־.
			/*
			 * �����д��A,�����־���ļ����. ������д��B,�����־���ļ���ǰ.
			 */
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}