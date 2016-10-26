package richtext;
  
import java.util.ArrayList;  
import java.util.List;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 * @use 获取指定HTML标签的指定属性的值 
 * @ProjectName stuff 
 * @Author <a href="mailto:mhmyqn@qq.com">mikan</a></br> 
 * @Date 2012-11-19 下午08:27:24 </br> 
 * @FullName com.mmq.regex.MatchHtmlElementAttrValue.java </br> 
 * @JDK 1.6.0 </br> 
 * @Version 1.0 </br> 
 */  
public class MatchHtmlElementAttrValue {  
      
    /** 
     * 获取指定HTML标签的指定属性的值 
     * @param source 要匹配的源文本 
     * @param element 标签名称 
     * @param attr 标签的属性名称 
     * @return 属性值列表 
     */  
    public static List<String> match(String source, String element, String attr) {  
        List<String> result = new ArrayList<String>();  
          String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";  
//        String reg = "<" + element + "[^<>]*?\\s?" + attr + "=['\"]?(.*?)['\"]?[(\\s.*?)>]";
//         String reg = "<" + element + "[^<>]*?\\s?" + attr + "=['\"]?(.*?)['\"]?[(\\s.*?)>]";
                                                          
        Matcher m = Pattern.compile(reg).matcher(source);  
        while (m.find()) {  
            String r = m.group(1);  
            result.add(r);  
        }  
        return result;  
    }  
      
    public static void main(String[] args) {  
//        String source = "<a title=中国体育报 href=''>aaa</a><a title='北京日报' href=''>bbb</a>";  
		String source = "<p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><span style=\"color: rgb(255, 0, 0); font-size: 18px;\">体检卡有效期为购买之日起一年内</span></span></p><p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><span style=\"font-size: 18px; color: rgb(255, 0, 0);\">注：平台所售体检卡均为电子体检卡，客户下单成功之后，会有客服联系确认体检信息，24小时之内会收到电子体检卡号，客户凭电子卡号至体检中心进行体检。</span>&nbsp;</span></p><p><span style=\"font-size: 18px; color: rgb(255, 0, 0);\"><img src=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\" title=\"/images/richText/110/eacd84b6-7398-4404-82d6-24edacf8b0dc.jpg\" alt=\"详情页-VIP6(N12) 副本.jpg\"/></span></p>";
//		String source = "<p><img src=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" title=\"/images/richText/110/034477ae-35d3-43c0-b572-20b4a7eebbbc.jpg\" alt=\"20160314_160933_069.jpg\"/><img src=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" title=\"/images/richText/110/c7dff6f3-cd4d-47ea-9823-4a0f0458d34c.jpg\" alt=\"20160314_160933_071.jpg\"/><img src=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" title=\"/images/richText/110/129faae7-94ce-4e58-b53d-8078be5d688e.jpg\" alt=\"20160314_160933_072.jpg\"/><img src=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" title=\"/images/richText/110/e49f18f1-5e9e-4dd5-8aee-188d83424e9d.jpg\" alt=\"20160314_160933_073.jpg\"/></p>";
		List<String> list = match(source, "img", "src");  
		List<String> list1 = match(source, "span", "style"); 
        System.out.println(list);  
        System.out.println(list1); 
    }  
}  