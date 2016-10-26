package richtext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLTest {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws Exception {
		// URL url = new URL("http://www.ascii-code.com/");
		// InputStreamReader reader = new InputStreamReader(url.openStream());
		// BufferedReader br = new BufferedReader(reader);
		// String s = null;
		// while((s=br.readLine())!=null){
		// s = GetLabel(s);
		// if(s!=null){
		// System.out.println(s);
		// }
		// }
		// br.close();
		// reader.close();

		// /** HTML转义 **/
		// String s = HtmlUtils.htmlEscape("<div>hello
		// world</div><p>&nbsp;</p>");
		// System.out.println(s);
		// String s2 = HtmlUtils.htmlUnescape(s);
		// System.out.println(s2);

		// String source = "<p style=\"font-size: 18px; color: rgb(255, 0,
		// 0);\"><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><span
		// style=\"color: rgb(255, 0, 0); font-size:
		// 18px;\">体检卡有效期为购买之日起一年内</span></span></p><p><span style=\"font-size:
		// 18px; color: rgb(255, 0, 0);\"><span style=\"font-size: 18px; color:
		// rgb(255, 0,
		// 0);\">注：平台所售体检卡均为电子体检卡，客户下单成功之后，会有客服联系确认体检信息，24小时之内会收到电子体检卡号，客户凭电子卡号至体检中心进行体检。</span>&nbsp;</span></p><p><span
		// style=\"font-size: 18px; color: rgb(255, 0, 0);\"><img
		// src=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\"
		// title=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\"
		// alt=\"详情页-VIP6(N12) 副本.jpg\"/></span></p>";
		String source = "<p><img src=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" title=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" alt=\"20160314_160933_069.jpg\"/><img src=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" title=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" alt=\"20160314_160933_071.jpg\"/><img src=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" title=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" alt=\"20160314_160933_072.jpg\"/><img src=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" title=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" alt=\"20160314_160933_073.jpg\"/></p>";
//		System.out.println(GetContent(source));
//		System.out.println(GetLabel(source));
		GetLabel(source);
		
	}

	/**
	 * 获得html 文本
	 * 
	 * @param html html源
	 * @return
	 */
	public static String GetContent(String html) {
		// String html = "<ul><li>1.hehe</li><li>2.hi</li><li>3.hei</li></ul>";
		String ss = ">[^<]+<";
		String temp = null;
		Pattern pa = Pattern.compile(ss);
		Matcher ma = null;
		ma = pa.matcher(html);
		String result = null;
		while (ma.find()) {
			temp = ma.group();
			if (temp != null) {
				if (temp.startsWith(">")) {
					temp = temp.substring(1);
				}
				if (temp.endsWith("<")) {
					temp = temp.substring(0, temp.length() - 1);
				}
				if (!temp.equalsIgnoreCase("")) {
					if (result == null) {
						result = temp;
					} else {
						result += "____" + temp;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 获得 html 标签
	 * 
	 * @param html 源
	 * @return html标签
	 */
	public static String GetLabel(String html) {
		// String html = "<ul><li>1.hehe</li><li>2.hi</li><li>3.hei</li></ul>";
		String ss = "<[^>]+>";
		String temp = null;
		Pattern pa = Pattern.compile(ss);
		Matcher ma = null;
		ma = pa.matcher(html);
		String result = null;
		while (ma.find()) {
			temp = ma.group();
			if (temp != null) {
				if (temp.startsWith(">")) {
					temp = temp.substring(1);
				}
				if (temp.endsWith("<")) {
					temp = temp.substring(0, temp.length() - 1);
				}
				if (!temp.equalsIgnoreCase("")) {
					if (result == null) {
						result = temp;
					} else {
						if (temp.toLowerCase().indexOf("img") <= 0) {
							result += "____" + temp;
						} else {
							System.out.println(temp);
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 获取指定HTML标签的指定属性的值
	 * 
	 * @param source
	 *            要匹配的源文本
	 * @param element
	 *            标签名称
	 * @param attr
	 *            标签的属性名称
	 * @return 属性值列表
	 */
	public static List<String> match1(String source, String element, String attr) {
		
		List<String> result = new ArrayList<String>();
		String reg = "<" + element + "[^<>]*?\\s" + attr + "\\s*=\\s*['\"]?(.*?;)['\"]?(\\s.*?;)?>";
		
//		String regtag = "<\\s*" + element + "\\s+([^>]*)\\s*";
//		String regAttrib = "([a-z]+)\\s*=\\s*\"([^\"]+)\"";

		Pattern p_style=Pattern.compile(reg,Pattern.CASE_INSENSITIVE);  // 不区分大小写
		Matcher m = p_style.matcher(source);
		while (m.find()) {
			String r = m.group(1);
			result.add(r);
		}
		return result;
	}
}