package Listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class mySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session被创建**********");
		ServletContext context = arg0.getSession().getServletContext();
		Integer count = (Integer)context.getAttribute("count");
		if(count == null){
			count = new Integer(1);
		}else{
			int co = count.intValue();
			count = new Integer(co+1);
		}
		System.out.println("当前用户人数："+count);
		context.setAttribute("count", count);//保存人数
		
		HttpSession s = arg0.getSession();
		long time = s.getLastAccessedTime();
		
		getTime(time);		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("销毁session......");   
        ServletContext context=arg0.getSession().getServletContext();   
        Integer count=(Integer)context.getAttribute("count");   
        int co=count.intValue();   
        count=new Integer(co-1);   
        context.setAttribute("count", count);   
        System.out.println("当前用户人数："+count);
		HttpSession s = arg0.getSession();
		long time = s.getLastAccessedTime();
		getTime(time);
	}
	
	/*
     * 根据输入的时间获取具体的日期
     */
    public static void getTime(long ll){
    	Calendar calendar = Calendar.getInstance(); 
        calendar.setTimeInMillis(ll);
        String str;
	    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());  
	    System.out.println("根据输入的时间获得的日期是："+str);

    }

}
