package com.ziroom.ziroomcustomer.newchat.chat.a;

import android.text.TextUtils;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  public static String getSkillName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return b.c + "服务";
    }
    if ("houseList".equals(paramString))
    {
      u.e("skill_set_name", "售前");
      return "售前";
    }
    if ("ziruyu".equals(paramString))
    {
      u.e("skill_set_name", "自如驿");
      return "自如驿";
    }
    paramString = b.c + "服务";
    u.e("skill_set_name", paramString);
    return paramString;
  }
  
  public static void sendTextMessage(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = EMMessage.createTxtSendMessage(paramString1, paramString3);
      paramString3 = new HashMap();
      paramString3.put("queueName", paramString2);
      paramString1.setAttribute("weichat", com.alibaba.fastjson.a.toJSONString(paramString3));
      EMClient.getInstance().chatManager().sendMessage(paramString1);
    }
  }
  
  public List<String> getExpressionRes(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i <= paramInt)
    {
      localArrayList.add("ee_" + i);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chat/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */