package richtext;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
public class ZYJ {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
//      String htmlStr = "<b><font www=\"red\" pp='oo'>aaaaa</font><font www=\"red\" pp='oo'>aaaaa</font></b> ";  
        String htmlStr = "<b><a href='http://www.baby.com' pp='oo'/><a href =\"http://www.baby.com\" pp=\"o\">welcome</a></b> ";  
        System.out.println("zyj  "+ZYJ.updateHtmlTag(htmlStr, "a", "href","http://www.redirect.com/xxx?url=" , "?xx=ss\""));  
  
    }  
      
    /**   
     * @param htmlStr  html文本   
     * @param searchTag  要修改的目标标签  
     * @param searchAttrib  目标标签中的属性  
     * @param newStr  修改值       
     */    
    public static String updateHtmlTag(String htmlStr, String searchTag,     
            String searchAttrib,String startStr , String endStr) {     
        String regxpForTag ="<\\s*" + searchTag + "\\s+([^>]*)\\s*>";      
        String regxpForTagAttrib = searchAttrib + "\\s*=\\s*[\"|']http://([^\"|']+)[\"|']";   //"=[\"|']([^[\"|']]+)[\"|']";     
        Pattern patternForTag = Pattern.compile(regxpForTag);     
        Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);     
        Matcher matcherForTag = patternForTag.matcher(htmlStr);     
        StringBuffer sb = new StringBuffer();     
        boolean result = matcherForTag.find();     
        while (result) {     
            StringBuffer sbreplace = new StringBuffer("<"+searchTag +" ");   
            System.out.println(matcherForTag.group(1));  
            Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag     
                    .group(1));     
              
            if (matcherForAttrib.find()) {  
                System.out.println("ll"+matcherForAttrib.group(1));  
                matcherForAttrib.appendReplacement(sbreplace, searchAttrib+"=\"" +startStr     
                        + matcherForAttrib.group(1) + endStr);     
            }     
//            matcherForTag.appendReplacement(sb, sbreplace.toString());    
            matcherForAttrib.appendTail(sbreplace);   
            matcherForTag.appendReplacement(sb, sbreplace.toString()+">");  
            result = matcherForTag.find();     
        }     
        matcherForTag.appendTail(sb);     
        return sb.toString();     
    }     
      
}  