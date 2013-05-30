package jenkin.control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import jenkin.model.TreeDataBuild;
import jenkin.model.TreeGrid;

public class Test {
	public static void main(String[] args) {
		TreeDataBuild tdb = new TreeDataBuild();
		TreeGrid tg = new TreeGrid();
		tdb.setId("1");
		tdb.setCode("1");
		tdb.setElement("大本营");
		tdb.setValue("大规模");
		tdb.setState("closed");
		tg.setTotal(5);
		tg.getRows().add(tdb);
		TreeDataBuild tdb1 = new TreeDataBuild();
		tdb1.setId("11");
		tdb1.setCode("11");
		tdb1.setElement("顶戴");
		tdb1.setValue("需要");
		tdb1.set_parentId("1");
		tg.getRows().add(tdb1);
		TreeDataBuild tdb2 = new TreeDataBuild();
		tdb2.setId("12");
		tdb2.setCode("12");
		tdb2.setElement("kaii");
		tdb2.setValue("msutd");
		tdb2.set_parentId("1");
		tg.getRows().add(tdb2);
		String json = JSONObject.fromObject(tg).toString();
		System.out.println(json);
		System.out.println(tdb1.get_parentId());
	}

}
