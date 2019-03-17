package com.papersystem.demo.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiaotong
 * @createTime 20190313 上午10:43
 * @description 文章章节描述
 */
public class Function {

    public static final Map<String,String> map=new HashMap<String, String>();

    public Function(){
        map.put("摘要","0");
        map.put("引言","1");
        map.put("相关研究","2");
        map.put("研究主体","3");
        map.put("研究方法","4");
        map.put("研究结果","5");
        map.put("讨论","6");
        map.put("结论","7");
        map.put("参考文献","8");

    }

}
