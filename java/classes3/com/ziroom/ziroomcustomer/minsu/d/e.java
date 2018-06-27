package com.ziroom.ziroomcustomer.minsu.d;

import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuMiPushMessage;

public class e
{
  public static boolean getOfflineMsgId(String paramString)
  {
    paramString = g.get(paramString);
    if (paramString != null) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  public static MinsuMiPushMessage getOfflinePushMsg()
  {
    return (MinsuMiPushMessage)g.get("mipush");
  }
  
  public static void putOfflineMsgId(String paramString)
  {
    a.i("wz_xiaomi", " msgid = " + paramString);
    g.put(paramString, Boolean.valueOf(true));
  }
  
  public static void putOfflinePushMsg(MinsuMiPushMessage paramMinsuMiPushMessage)
  {
    g.put("mipush", paramMinsuMiPushMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */