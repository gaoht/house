package com.ziroom.ziroomcustomer.social.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialMainActivity;
import com.ziroom.ziroomcustomer.social.model.j;
import com.ziroom.ziroomcustomer.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@Instrumented
public class d
{
  public static Bitmap getBlurBitmap(Bitmap paramBitmap, float paramFloat)
  {
    return new a().blur(Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false), paramFloat);
  }
  
  public static int getTxtMessageType(EMMessage paramEMMessage)
  {
    try
    {
      paramEMMessage = Integer.valueOf(paramEMMessage.getIntAttribute("ziroomType", 100));
      if (paramEMMessage != null)
      {
        if (paramEMMessage.intValue() == 103) {
          return 103;
        }
        int i = paramEMMessage.intValue();
        if (i == 102) {
          return 102;
        }
        return 100;
      }
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
    return 100;
  }
  
  public static List<j> getZzSocialFriendList(List<j> paramList)
  {
    if (EMClient.getInstance().isLoggedInBefore() == true) {}
    for (;;)
    {
      EMMessage localEMMessage;
      j localj;
      try
      {
        Iterator localIterator = EMClient.getInstance().chatManager().getAllConversations().entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject1).getKey();
          localObject1 = (EMConversation)((Map.Entry)localObject1).getValue();
          localEMMessage = ((EMConversation)localObject1).getLastMessage();
          Object localObject2 = localEMMessage.getStringAttribute("ziroomFlag", "");
          u.d("sdjfkldsj", "=========  workInfo " + (String)localObject2);
          if (!"ZIROOM_CHANGZU_IM".equals(localObject2)) {
            continue;
          }
          localObject2 = paramList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localj = (j)((Iterator)localObject2).next();
            if (!localj.getToChatName().equals(str)) {
              continue;
            }
            localj.setUnReadSize(((EMConversation)localObject1).getUnreadMsgCount());
            if (localEMMessage.getType() != EMMessage.Type.TXT) {
              break label272;
            }
            Integer localInteger = Integer.valueOf(localEMMessage.getIntAttribute("ziroomType", 100));
            if (localInteger == null) {
              break label253;
            }
            if (localInteger.intValue() != 103) {
              break label234;
            }
            localj.setLastMessage(localEMMessage.getStringAttribute("activityName"));
          }
        }
        else
        {
          return paramList;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label234:
      localj.setLastMessage(((EMTextMessageBody)localEMMessage.getBody()).getMessage());
      continue;
      label253:
      localj.setLastMessage(((EMTextMessageBody)localEMMessage.getBody()).getMessage());
      continue;
      label272:
      if (localEMMessage.getType() == EMMessage.Type.IMAGE) {
        localj.setLastMessage("图片");
      }
    }
  }
  
  public static int getZzSocialUnReadMessageNum()
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if (EMClient.getInstance().isLoggedInBefore() == true) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = EMClient.getInstance().chatManager().getAllConversations().values().iterator();
        j = i;
        k = i;
        if (localIterator.hasNext())
        {
          j = i;
          EMConversation localEMConversation = (EMConversation)localIterator.next();
          if (localEMConversation != null)
          {
            j = i;
            EMMessage localEMMessage = localEMConversation.getLastMessage();
            if (localEMMessage != null)
            {
              j = i;
              if ("ZIROOM_CHANGZU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag")))
              {
                j = i;
                k = localEMConversation.getUnreadMsgCount();
                i = k + i;
              }
            }
          }
        }
        else
        {
          return k;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        k = j;
      }
    }
  }
  
  public static int getZzSocialUnReadMsgSize()
  {
    int m = 0;
    int n = 0;
    int i = 0;
    for (;;)
    {
      int k;
      int j;
      try
      {
        boolean bool = EMClient.getInstance().isLoggedInBefore();
        if (!bool)
        {
          k = i;
          return k;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        j = n;
      }
      try
      {
        Object localObject = EMClient.getInstance().chatManager().getAllConversations();
        k = i;
        if (localObject == null) {
          continue;
        }
        k = i;
        j = n;
        if (((Map)localObject).size() <= 0) {
          continue;
        }
        j = n;
        localObject = ((Map)localObject).values().iterator();
        i = m;
        k = i;
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        j = i;
        EMConversation localEMConversation = (EMConversation)((Iterator)localObject).next();
        if (localEMConversation != null)
        {
          j = i;
          if ("ZIROOM_CHANGZU_IM".equals(localEMConversation.getLastMessage().getStringAttribute("ziroomFlag", "")))
          {
            j = i;
            k = localEMConversation.getUnreadMsgCount();
            i = k + i;
          }
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 这都崩溃？ e = " + localException2.getMessage());
        return j;
      }
    }
  }
  
  public static boolean isZzHaveConversations()
  {
    boolean bool = false;
    if (EMClient.getInstance().isLoggedInBefore() == true) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = EMClient.getInstance().chatManager().getAllConversations().values().iterator();
        if (localIterator.hasNext())
        {
          EMConversation localEMConversation = (EMConversation)localIterator.next();
          if (localEMConversation == null) {
            continue;
          }
          EMMessage localEMMessage = localEMConversation.getLastMessage();
          if ((localEMMessage == null) || (!"ZIROOM_CHANGZU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag")))) {
            continue;
          }
          int i = localEMConversation.getAllMsgCount();
          if (i <= 0) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      bool = false;
    }
  }
  
  public static void refreshZzLive(Context paramContext)
  {
    n.refreshSocialZzLive(paramContext, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.f(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString) {}
    });
  }
  
  public static Bitmap returnBitmap(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        try
        {
          if (!(paramString instanceof URL))
          {
            paramString = paramString.openConnection();
            paramString = (HttpURLConnection)paramString;
            paramString.setDoInput(true);
            paramString.connect();
            localInputStream = paramString.getInputStream();
            paramString = BitmapFactory.decodeStream(localInputStream);
          }
        }
        catch (IOException localIOException1)
        {
          InputStream localInputStream;
          paramString = null;
        }
        try
        {
          localInputStream.close();
          return paramString;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
        continue;
        paramString = HttpInstrumentation.openConnection((URL)paramString);
      }
    }
    localIOException1.printStackTrace();
    return paramString;
  }
  
  public static void saveChanngZhuMessageLog(Activity paramActivity, EMMessage paramEMMessage, int paramInt, boolean paramBoolean)
  {
    String str3 = paramEMMessage.getMsgId();
    String str4 = paramEMMessage.getFrom();
    String str5 = paramEMMessage.getTo();
    String str1 = "";
    if (!paramBoolean) {
      if (paramEMMessage.getType() == EMMessage.Type.TXT) {
        str1 = ((EMTextMessageBody)paramEMMessage.getBody()).getMessage();
      }
    }
    for (;;)
    {
      String str6 = com.alibaba.fastjson.e.toJSONString(paramEMMessage.ext());
      String str2 = "txt";
      if (paramEMMessage.getType() == EMMessage.Type.IMAGE) {
        str2 = "img";
      }
      com.ziroom.ziroomcustomer.minsu.e.a.imSaveChangZhuMsgLog(paramActivity, str3, str4, str5, str1, str6, "chat", "ZIROOM_CHANGZU_IM", str2, paramInt, new t(paramActivity, new com.freelxl.baselibrary.d.f.e())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          u.d("lsjdkgj", "======onFailure ");
          System.out.println(" e = " + paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          u.d("lsjdkgj", "======onSuccess " + paramAnonymousString);
          System.out.println(" o = " + paramAnonymousString);
        }
      });
      return;
      if (paramEMMessage.getType() == EMMessage.Type.IMAGE)
      {
        str1 = "[图片]";
        continue;
        str1 = "";
      }
    }
  }
  
  public static void sendZzTextMessage(Activity paramActivity, boolean paramBoolean, final String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, EMConversation paramEMConversation, com.ziroom.ziroomcustomer.social.a.f paramf)
  {
    u.d("jkdjgkdjg", "======sendTextMsg   " + paramString2);
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = EMMessage.createTxtSendMessage(paramString2, paramString3);
    paramString1.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    paramString1.setAttribute("ziroomType", 100);
    paramString1.setAttribute("showMsgTxt", paramString2);
    paramString1.setAttribute("nicName", paramString4);
    paramString1.setAttribute("headURL", paramString5);
    paramString1.setAttribute("toNicName", paramString6);
    paramString1.setAttribute("toHeadUrl", paramString7);
    paramString1.setAttribute("em_ignore_notification", true);
    try
    {
      paramString3 = new JSONObject();
      paramString3.put("em_push_title", paramString4 + ":" + paramString2);
      paramString3.put("ziroomFlag", "ZIROOM_CHANGZU_IM");
      paramString1.setAttribute("em_apns_ext", paramString3);
      if (paramBoolean)
      {
        paramEMConversation.appendMessage(paramString1);
        paramf.refreshSelectLast();
        return;
      }
      EMClient.getInstance().chatManager().sendMessage(paramString1);
      refreshZzLive(paramActivity);
      paramString1.setMessageStatusCallback(new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          d.saveChanngZhuMessageLog(this.a, paramString1, 1, false);
        }
        
        public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onSuccess()
        {
          d.saveChanngZhuMessageLog(this.a, paramString1, 0, false);
        }
      });
      paramf.refreshSelectLast();
      return;
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
  }
  
  public static void toZzSocialChat(Context paramContext)
  {
    if (ApplicationEx.c.isLoginState())
    {
      paramContext.startActivity(new Intent(paramContext, ZzSocialMainActivity.class));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */