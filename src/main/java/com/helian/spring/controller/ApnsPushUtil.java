package com.helian.spring.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotifications;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;


public class ApnsPushUtil {

	private static final Log logger = LogFactory.getLog(ApnsPushUtil.class);
	
	public static String keystore_endUser = null;
	public static String keystore_dealer = null;
	public static String keystore = null;
	public static String password = null;
	public static String host = null;
	public static Boolean production = true;// true：production false: sandbox
	static {
		Properties propertie = new Properties();
		InputStream inputStream;

		try {
			/*File fiel = new File("apns.properties");
			inputStream = new FileInputStream(fiel);*/
			inputStream = ApnsPushUtil.class.getClassLoader()
					.getResourceAsStream("apns.properties");
			propertie.load(inputStream);
			//keystore =Thread.currentThread().getContextClassLoader().getResource("apns_development.p12").getPath();
			//keystore = ApnsPushUtil.class.getClassLoader().getResource("apns_development.p12").getPath();
			keystore_endUser = propertie.getProperty("certificatePath_endUser");
			keystore_dealer = propertie.getProperty("certificatePath_dealer");
			//keystore = System.getProperty("./apns_development.p12");
			password = propertie.getProperty("certificatePassword", "123456");
			host = propertie.getProperty("apns.host", "");
			production = Boolean.valueOf(propertie.getProperty("production",
					"false"));
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
     * 发送的deviceToken转成 List<Device> devices   待定
     */
	public static void changeType(String msg , String deviceTokenes,Integer type){
		
		List<Device> devices = new ArrayList<Device>();
		
		if(StringUtils.contains(deviceTokenes , ",")){
			String[] split = deviceTokenes.split(",");
			for (String deviceToken : split) {
				Device d = new BasicDevice();
				d.setToken(deviceToken);
				devices.add(d);
			}
		}else
			{
				Device d = new BasicDevice();
				d.setToken(deviceTokenes);
				devices.add(d);
			}
		Map<String,Object> map = new HashMap<String,Object>();
			map.put("content-available", 1);
			//判断type类型
			if(type == 2){
				keystore = keystore_dealer;
			}else {
				if(type == 3){
					keystore = keystore_endUser;
				}
			}
		pushPayload(msg,devices,1,null,map,type,keystore);
	}
	/**
     * 推送自定义负载
     */
    public static void pushPayload( String msg,List<Device> devices,Integer badge,String sound,Map<String,Object> map,Integer type,String keystore) {
        PushNotificationPayload payload;
		try {
			payload = customPayload(msg, badge, sound, map);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
        PushedNotifications payload2;
		try {
			
			//Push.contentAvailable(keystore, password, production, devices);
			payload2 = Push.payload(payload, keystore, password, production, devices);
			if(payload2!=null){
				//System.out.println(payload2);
				int numOfFailedNotifications = payload2.getFailedNotifications()
	                    .size();
	            int numOfSuccessfulNotificatios = payload2
	                    .getSuccessfulNotifications().size();

	            System.out.println(String.format(
	                    "Successful Send: %d, Failed Send: %d",
	                    numOfSuccessfulNotificatios, numOfFailedNotifications));
	            logger.info(String.format(
	                    "Successful Send: %d, Failed Send: %d",
	                    numOfSuccessfulNotificatios, numOfFailedNotifications));
			}
			
	        
		} catch (CommunicationException e) {
			e.printStackTrace();
		} catch (KeystoreException e) {
			e.printStackTrace();
		}
        
    }
    /**
     * 自定义负载
     * @param map 自定义字典
     */
    private static PushNotificationPayload customPayload(String msg,Integer badge,String sound,Map<String,Object> map) throws JSONException{
        PushNotificationPayload payload = PushNotificationPayload.complex();
        if(msg!=null){
            payload.addAlert(msg);         
        }
        if(badge != null){         
            payload.addBadge(badge);
        }
        payload.addSound(StringUtils.defaultIfEmpty(sound, "default"));
       // payload.addSound("default");
        if(map!=null && !map.isEmpty()){
            Object[] keys = map.keySet().toArray();    
            Object[] vals = map.values().toArray();
            if(keys!= null && vals != null && keys.length == vals.length){
                for (int i = 0; i < map.size(); i++) {                  
                    payload.addCustomDictionary(String.valueOf(keys[i]),(vals[i]));
                }
            }
        }
        return payload;
    }

    public static void main (String[] args) throws KeystoreException, JSONException{
		String msg="测试推送";
		//{"aps":{"alert":"{"title":"ios推送测试 ....."}"}} 自动封装
		//d.setToken("48cb077b660d68c58e91e8619d74b4302fca0df53baeada80b53b48806e29850");
		changeType(msg,"22a4e26c6571ca9e69ddc4a61680893c6d0c3d735776dd81201488046634a,aaa,bbb",3);
	}
}
