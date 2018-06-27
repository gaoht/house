package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alibaba.fastjson.a;
import com.hyphenate.chat.EMClient;
import com.ziroom.ziroomcustomer.model.ChatHistory;
import com.ziroom.ziroomcustomer.model.ChatMessage;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Calendar;

public class c
{
  private static boolean a = false;
  
  public static ChatHistory chatMessage2chatHistory(ChatMessage paramChatMessage, String paramString)
  {
    String str = a.toJSONString(paramChatMessage);
    ChatHistory localChatHistory = new ChatHistory();
    if (paramChatMessage.isSend) {}
    for (int i = 1;; i = 0)
    {
      localChatHistory.setIssend(i);
      localChatHistory.setFriendid(paramChatMessage.getUid());
      localChatHistory.setFriendname(paramChatMessage.getName());
      localChatHistory.setMsg(str);
      localChatHistory.setMyuid(paramString);
      localChatHistory.setRead(0);
      localChatHistory.setTime(paramChatMessage.getTime());
      return localChatHistory;
    }
  }
  
  public static String getDate()
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    int m = ((Calendar)localObject).get(11);
    int n = ((Calendar)localObject).get(12);
    int i1 = ((Calendar)localObject).get(13);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(String.valueOf(i) + "-" + String.valueOf(j + 1) + "-" + String.valueOf(k) + " " + String.valueOf(m) + ":" + String.valueOf(n) + ":" + String.valueOf(i1));
    return ((StringBuffer)localObject).toString();
  }
  
  public static String getGuestAccount(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("im_user_Info", 0);
    String str2 = localSharedPreferences.getString("account", "");
    String str1 = str2;
    if (str2.equals(""))
    {
      paramContext = ah.getDeviceId(paramContext);
      str1 = paramContext + ah.getRandom();
      localSharedPreferences.edit().putString("account", str1).apply();
    }
    return str1;
  }
  
  public boolean isConnected(Context paramContext)
  {
    return EMClient.getInstance().isConnected();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */