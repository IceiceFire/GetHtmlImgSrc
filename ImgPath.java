package richtext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgPath {

	// ---------------------- test ----------------------------------//
	public static void main(String[] args) {
		
		// html 源
		String source = "<p><img src=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" title=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" alt=\"20160314_160933_069.jpg\"/><img src=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" title=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" alt=\"20160314_160933_071.jpg\"/><img src=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" title=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" alt=\"20160314_160933_072.jpg\"/><img src=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" title=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" alt=\"20160314_160933_073.jpg\"/></p><p>sdfsfs</p>";

		System.out.println(GetImgSrc(source));
	}
	// -------------------------------------------------------------//

	/**
	 * 获得 html 标签.
	 * 
	 * @param html HTML源   
	 * @return list 图片路径
	 */
	public static List<String> GetImgSrc(String html) {

		List<String> res = new ArrayList<String>();
		
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
							res.add(match(temp, "img", "src"));
						}
					}
				}
			}
		}
		System.out.println("---------------------------结果-----------------------------");
		return res;
	}

	/**
	 * 获取指定HTML标签的指定属性的值.
	 * 
	 * @param source 要匹配的源文本
	 * @param element 标签名称    
	 * @param attr 标签的属性名称    
	 * @return 属性值列表
	 */
	private static String match(String source, String element, String attr) {

		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		
		Pattern p_style = Pattern.compile(reg, Pattern.CASE_INSENSITIVE); // 不区分大小写
		Matcher m = p_style.matcher(source);
		
		String r = "";
		if (m.find()) {
			r = m.group(1);
		}
		return r;
	}
}
