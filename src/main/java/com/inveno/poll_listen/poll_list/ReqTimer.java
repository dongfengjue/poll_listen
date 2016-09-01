package com.inveno.poll_listen.poll_list;

import java.util.Timer;

public class ReqTimer {
    Timer timer;
    public ReqTimer(int waitStartTime,int everyTime){
        timer = new Timer();
        timer.schedule(new CallReqTimer(), waitStartTime * 1000,1000 * everyTime);
        LogUtil.info("== time is up ==");
    }
    
    public void stopTimer(){
    	timer.cancel();
    }
   
}

