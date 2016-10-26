package richtext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

	public static void main(String[] args) {
		String source = "<p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><span style=\"color: rgb(255, 0, 0); font-size: 18px;\">体检卡有效期为购买之日起一年内</span></span></p><p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><span style=\"font-size: 18px; color: rgb(255, 0, 0);\">注：平台所售体检卡均为电子体检卡，客户下单成功之后，会有客服联系确认体检信息，24小时之内会收到电子体检卡号，客户凭电子卡号至体检中心进行体检。</span>&nbsp;</span></p><p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><img src=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\" title=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\" alt=\"详情页-VIP6(N12) 副本.jpg\"/></span></p>";
		
		
		System.out.println(match(source, "IMG", "src"));
		System.out.println(match(source, "span", "style"));
		System.out.println("style:" + match1(source, "span", "style"));
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
	public static List<String> match(String source, String element, String attr) {
		
		List<String> result = new ArrayList<String>();
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";


		Pattern p_style=Pattern.compile(reg,Pattern.CASE_INSENSITIVE);  // 不区分大小写
		Matcher m = p_style.matcher(source);
		while (m.find()) {
			String r = m.group(1);
			result.add(r);
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
