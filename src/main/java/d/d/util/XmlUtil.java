package d.d.util;

import cn.hutool.core.util.StrUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class XmlUtil {

	public static void main(String[] args) throws Exception {


		HashMap<String,String> entity = new HashMap();
		ArrayList<HashMap<String,String>> itemList = new ArrayList<>();

		entity.put("prefix",null);
		entity.put("handle","86.124.000000/6t9JLyks9uA3FWy6Ka2mYTDNfGwXm7xU6XZkEmWfz2RMavznE1Y1DRSu63QKnjxE");
		entity.put("version","1.0.0");

		HashMap item1 = new HashMap();
		item1.put("idType","idType");

		HashMap item2 = new HashMap();
		item2.put("idType","idType");

		itemList.add(item1);
		itemList.add(item2);

		Element rootElement = DocumentHelper.createElement("data");
		Document document = DocumentHelper.createDocument(rootElement);
		Element root = document.getRootElement();

		// java.lang.IllegalArgumentException: Adding text to an XML document must not be null
//		root.addElement("prefix").addText(null);
//		root.addElement("prefix").addText(entity.get("prefix") == null? "":entity.get("prefix")); //三目
		root.addElement("prefix").addText(StrUtil.emptyIfNull(entity.get("prefix"))); //hutool
//		root.addElement("prefix").addText(entity.get("prefix")+""); //输出null 不是空字符
		root.addElement("handle").addText(entity.get("handle"));
		root.addElement("meta").addText(entity.get("version"));

		Element items = root.addElement("items");
		items.addComment("item支持多条，最多500条");
		Element elementItem = items.addElement("item");
		elementItem.addElement("identity");
		for(HashMap item : itemList) {
			elementItem.addElement(item.get("idType").toString());
		}

		// 在项目路径下
		FileOutputStream out =new FileOutputStream("./test.xml");

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setExpandEmptyElements(true);
		format.setEncoding("UTF-8");

		XMLWriter writer=new XMLWriter(out,format);
		writer.write(document);
		System.out.println("写入完成！");

//输出到response输出流
//		response.setContentType("text/xml");
//		String fileName = HttpFileUtils.encodeFileName(request,entity.getPrefix()+"_"+entity.getVersion()+".xml");
//		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//		response.setCharacterEncoding("UTF-8");
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setExpandEmptyElements(true);
//		format.setEncoding("UTF-8");
//		XMLWriter writer = new XMLWriter(response.getOutputStream() , format);
//		writer.write(document);

	}
}
