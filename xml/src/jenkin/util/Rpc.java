package jenkin.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class Rpc {

	/**
	 * rpc工具类
	 */
	public static void main(String[] args) {
		try {
			// 配置客户端
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			// 设置服务器端地址
			config.setServerURL(new URL(
					"http://10.131.247.242:8080/rpc/HPathHandler"));
			// 创建XmlRpc客户端
			XmlRpcClient client = new XmlRpcClient();
			// 绑定以上设置
			client.setConfig(config);
			// 创建参数列表
			Vector<String> params = new Vector<String>();
			params.addElement("homewghtjfast22databstxml");
			params.addElement("");
			// 执行XML-RPC 请求
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