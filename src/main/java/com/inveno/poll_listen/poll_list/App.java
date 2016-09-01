package com.inveno.poll_listen.poll_list;


/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ReqTimer reqTime = null;
    	
    	try {
    		//每10分钟拉取一次
    		reqTime = new ReqTimer(2, 60*10);
		} catch (Exception e) {
			reqTime.stopTimer();
		}
    	
    
    }
}
