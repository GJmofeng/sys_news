package com.news.util;

import org.apache.commons.beanutils.BeanUtils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.Map;

public class WebUtils {

	public static  <T> T copyParamToBean(Map value, T bean){//使用泛型来减少request.getParameter的重复代码，优化�????�????
		try {

			System.out.println("注入之前"+bean);
			BeanUtils.populate(bean,value);
			System.out.println("注入之后"+bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int parseInt(String sid,int defalultvalue) {//把String类型的id转化Integer类型�????
		  try {
	            return Integer.parseInt(sid);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return defalultvalue;
	}
	
	public static String message (String url) {
		File source =new File(url); 
		Encoder encoder = new Encoder();
		MultimediaInfo m;
		long ls = 0;
		try {
			m = encoder.getInfo(source);
			ls = m.getDuration();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//duration = ls/1000;
		System.out.println("此视频时长为:"+ls/60000+"�?"+(ls/1000-ls/60000*60)+"秒！");
		return ls/60000+":"+(ls/1000-ls/60000*60);
	}


}
