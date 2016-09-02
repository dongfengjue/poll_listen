package com.inveno.poll_listen.poll_list;


import java.util.TimerTask;

import net.sf.json.JSONObject;
public class CallReqTimer extends TimerTask{

    public void run() {
    	
        Boolean res = checkPollMore();
        LogUtil.info("==== check poll result is ==="+res);
        if(!res){
        	MailUtil.sendMail();
        }
        
    }
    
    private Boolean checkPollMore(){
    	LogUtil.info("=== check poll staring ===");
    	int checkMax = 3;
    	for(int i = 0 ;i < checkMax ;i++ ){
    		// 休眠3秒
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
    		
    		if(checkPoll()){
    			return true;
    		}
    	}
    	return false;
    }
    private Boolean checkPoll(){
    	try {
//			String url = "1";
	    	String url = "https://h5xz.hotoday.in/topicer/?m=index&a=tpkrindex&uid=01011607011635214801000000433908&ltk=2d0234a216950f19df4e46353c5084dd_VV&os=android&app=hotoday&tm=1472626084514&product_id=mata&pagenum=1&osver=4.4.4&ver=1.0.0.0.0.4_debug&tk=26db6bdad111967502fe6b69d2d612d1&net=wifi&rver=8&lan=Indonesian&pm=Google+Nexus+4+-+4.4.4+-+API+19+-+768x1280&src=gp&sdk=4&requesttype=2";
	    	String resultStr = HttpXmlClient.get(url);
	    	
	    	
	    	
	    	if(resultStr != null && resultStr != ""){
	    		JSONObject jsonObject = JSONObject.fromObject(resultStr);
	    		
	    		Integer jsonCode = (Integer) jsonObject.get("code");
	    		if(jsonCode == 200){
	    			return true;
	    		}
	    		
	    	}
    	} catch (Exception e) {
    		
    		return false;
    	}
    	
    	return false;
    }
}