package com.anson.java;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 短信发送
 * @author Administrator
 *
 */
public class MobMsg {

	public static void main(String[] args)throws Exception
	{

	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
	
	ArrayList<NameValuePair[]> arrayList=new ArrayList<NameValuePair[]>();
	String strMsg="验证码：8888";
//	NameValuePair[] data ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","18888643739"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data);
//	NameValuePair[] data1 ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","18868931714"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data1);
//	NameValuePair[] data2 ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","18888643792"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data2);
//	NameValuePair[] data3 ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","18888643480"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data3);
//	NameValuePair[] data4 ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","15757468425"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data4);
//	NameValuePair[] data5 ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","18888643757"),new NameValuePair("smsText",strMsg)};
//	arrayList.add(data5);
	NameValuePair[] data ={ new NameValuePair("Uid", "George Anson"),new NameValuePair("Key", "9898a3e0712f474c97ab"),new NameValuePair("smsMob","17855833076"),new NameValuePair("smsText",strMsg)};
	arrayList.add(data);
	for(NameValuePair[] item:arrayList)
	{
		post.setRequestBody(item);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result); //打印返回消息状态


		post.releaseConnection();
	}

	}

}
