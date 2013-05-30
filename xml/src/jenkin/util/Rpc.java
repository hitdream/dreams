package jenkin.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class Rpc {

	/**
	 * rpc������
	 */
	public static void main(String[] args) {
		try {
			// ���ÿͻ���
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			// ���÷������˵�ַ
			config.setServerURL(new URL(
					"http://10.131.247.242:8080/rpc/HPathHandler"));
			// ����XmlRpc�ͻ���
			XmlRpcClient client = new XmlRpcClient();
			// ����������
			client.setConfig(config);
			// ���������б�
			Vector<String> params = new Vector<String>();
			params.addElement("homewghtjfast22databstxml");
			params.addElement("");
			// ִ��XML-RPC ����
			String result = (String) client.execute("HPathHandler.query",
					params);
			System.out.println(result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
	}

}