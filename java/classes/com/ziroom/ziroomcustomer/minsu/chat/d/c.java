package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMPushManager;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static EMMessage createExpressionMessage(String paramString1, String paramString2)
  {
    paramString1 = EMMessage.createTxtSendMessage("不支持的消息,请升级APP版本", paramString1);
    paramString1.setAttribute("msgType", "4");
    paramString1.setAttribute("em_expr_big_name", paramString2);
    return paramString1;
  }
  
  @Deprecated
  public static void exitGroup(String paramString, EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().groupManager().asyncLeaveGroup(paramString, new c.1(paramString, paramEMCallBack));
  }
  
  public static void loadIM()
  {
    EMClient.getInstance().groupManager().loadAllGroups();
    EMClient.getInstance().chatManager().loadAllConversations();
    try
    {
      EMClient.getInstance().groupManager().getJoinedGroupsFromServer();
      EMClient.getInstance().pushManager().getPushConfigsFromServer();
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  public static final void sendExitGroup(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("im_exit_group");
    localIntent.putExtra("groupId", paramString);
    LocalBroadcastManager.getInstance(paramContext).sendBroadcast(localIntent);
  }
  
  public static final void sendGroupMemberChange(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("im_group_member_changed");
    localIntent.putExtra("groupId", paramString);
    LocalBroadcastManager.getInstance(paramContext).sendBroadcast(localIntent);
  }
  
  public static final void sendGroupsChange(Context paramContext)
  {
    Intent localIntent = new Intent("im_groups_chaned");
    LocalBroadcastManager.getInstance(paramContext).sendBroadcast(localIntent);
  }
  
  public static void setAPNS(EMMessage paramEMMessage, String paramString1, String paramString2)
  {
    setAPNS(paramEMMessage, paramString1, paramString2, null);
  }
  
  public static void setAPNS(EMMessage paramEMMessage, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("em_push_title", "" + paramString1);
      localJSONObject.put("ziroomFlag", paramString2);
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramString1 = paramMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          localJSONObject.put((String)paramString2.getKey(), paramString2.getValue());
        }
      }
      paramEMMessage.setAttribute("em_apns_ext", localJSONObject);
    }
    catch (JSONException paramEMMessage)
    {
      paramEMMessage.printStackTrace();
      u.i("huanxin", " e = " + paramEMMessage.getMessage());
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */