package com.ziroom.ziroomcustomer.minsu.chat;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.fastjson.e;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMFileMessageBody.EMDownloadStatus;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.util.PathUtil;
import com.ziroom.commonlib.utils.h;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImHistoryBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImHistoryBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImHistoryBean.DataBean.ListBean.AppChatRecordsExtBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class j
{
  static String a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getString(paramInt);
  }
  
  private static String a(String paramString)
  {
    return com.ziroom.ziroomcustomer.minsu.chat.d.j.getStorageDir2(ApplicationEx.c) + PathUtil.pathPrefix + "ziroom#ziroom/files/" + EMClient.getInstance().getCurrentUser() + File.separator + paramString;
  }
  
  private static void a(int paramInt, List<Pair<Long, EMConversation>> paramList, List<EMConversation> paramList1)
  {
    paramList = paramList.iterator();
    label203:
    label241:
    label317:
    label320:
    label323:
    for (;;)
    {
      Pair localPair;
      int j;
      if (paramList.hasNext())
      {
        localPair = (Pair)paramList.next();
        EMMessage localEMMessage = ((EMConversation)localPair.second).getLastMessage();
        String str2;
        String str3;
        try
        {
          if (!"ZIROOM_MINSU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag", ""))) {
            continue;
          }
          j = localEMMessage.getIntAttribute("roleType", 0);
          String str1 = localEMMessage.getFrom();
          str2 = localEMMessage.getTo();
          str1 = appendEMPrefix(str1);
          str2 = appendEMPrefix(str2);
          str3 = "app_" + com.ziroom.ziroomcustomer.minsu.e.d.getUid();
          if (j != 0) {
            break label241;
          }
          j = Integer.parseInt(localEMMessage.getStringAttribute("msgSenderType", ""));
          if (!str3.equals(str1)) {
            break label203;
          }
          if (j != paramInt) {
            continue;
          }
          paramList1.add(localPair.second);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          com.freelxl.baselibrary.f.d.e("huanxin", Log.getStackTraceString(localException.getCause()));
          paramList1.add(localPair.second);
        }
        continue;
        if (!str3.equals(str2)) {
          continue;
        }
        if (paramInt != 2) {
          break label320;
        }
      }
      for (int i = 1;; i = 2)
      {
        if (j != i) {
          break label323;
        }
        paramList1.add(localPair.second);
        break;
        if (localException.direct() == EMMessage.Direct.SEND)
        {
          if ((j & paramInt) == 0) {
            break;
          }
          paramList1.add(localPair.second);
          break;
        }
        if (localException.direct() != EMMessage.Direct.RECEIVE) {
          break;
        }
        if (paramInt == 2) {}
        for (i = 1;; i = 2)
        {
          if ((i & j) == 0) {
            break label317;
          }
          paramList1.add(localPair.second);
          break;
        }
        break;
        return;
      }
    }
  }
  
  private static void a(EMMessage paramEMMessage, Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramMap.get(str);
        if ((localObject instanceof Integer)) {
          paramEMMessage.setAttribute(str, localObject + "");
        } else if ((localObject instanceof String)) {
          paramEMMessage.setAttribute(str, (String)localObject);
        } else if ((localObject instanceof Boolean)) {
          paramEMMessage.setAttribute(str, ((Boolean)localObject).booleanValue());
        }
      }
    }
  }
  
  private static void a(List<Pair<Long, EMConversation>> paramList)
  {
    Collections.sort(paramList, new j.4());
  }
  
  public static String appendEMPrefix(String paramString)
  {
    if (ae.isNull(paramString)) {}
    while (paramString.contains("app_")) {
      return paramString;
    }
    return "app_" + paramString;
  }
  
  private static void b(int paramInt, List<EMGroup> paramList, List<EMConversation> paramList1)
  {
    if (paramInt == 1) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMGroup localEMGroup = (EMGroup)paramList.next();
      try
      {
        localArrayList.add(EMClient.getInstance().chatManager().getConversation(localEMGroup.getGroupId(), EMConversation.EMConversationType.GroupChat, true));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        com.freelxl.baselibrary.f.d.e("huanxin", Log.getStackTraceString(localException.getCause()));
      }
    }
    Collections.sort(localArrayList, new j.3());
    paramList1.addAll(localArrayList);
  }
  
  /* Error */
  public static void copyDb()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: getstatic 277	com/ziroom/ziroomcustomer/minsu/b/c:e	Ljava/lang/String;
    //   7: astore_0
    //   8: new 26	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 279
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: getstatic 33	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   24: invokevirtual 282	com/ziroom/ziroomcustomer/base/ApplicationEx:getPackageName	()Ljava/lang/String;
    //   27: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 284
    //   33: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 60	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   39: invokevirtual 64	com/hyphenate/chat/EMClient:getCurrentUser	()Ljava/lang/String;
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 286
    //   48: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_2
    //   55: getstatic 33	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   58: invokevirtual 290	com/ziroom/ziroomcustomer/base/ApplicationEx:getCacheDir	()Ljava/io/File;
    //   61: invokevirtual 293	java/io/File:getParent	()Ljava/lang/String;
    //   64: pop
    //   65: new 66	java/io/File
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: new 66	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: new 26	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   86: invokestatic 60	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   89: invokevirtual 64	com/hyphenate/chat/EMClient:getCurrentUser	()Ljava/lang/String;
    //   92: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 286
    //   98: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 298	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 301	java/io/File:exists	()Z
    //   112: ifne +8 -> 120
    //   115: aload_0
    //   116: invokevirtual 304	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: new 306	java/io/FileOutputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 309	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: astore_0
    //   129: new 311	java/io/FileInputStream
    //   132: dup
    //   133: aload_2
    //   134: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_2
    //   138: sipush 4096
    //   141: newarray <illegal type>
    //   143: astore_1
    //   144: aload_2
    //   145: aload_1
    //   146: invokevirtual 316	java/io/FileInputStream:read	([B)I
    //   149: iconst_m1
    //   150: if_icmpeq +31 -> 181
    //   153: aload_0
    //   154: aload_1
    //   155: invokevirtual 320	java/io/FileOutputStream:write	([B)V
    //   158: goto -14 -> 144
    //   161: astore_3
    //   162: aload_0
    //   163: astore_1
    //   164: aload_2
    //   165: astore_0
    //   166: aload_3
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   172: aload_0
    //   173: invokevirtual 323	java/io/FileInputStream:close	()V
    //   176: aload_1
    //   177: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   180: return
    //   181: aload_0
    //   182: invokevirtual 327	java/io/FileOutputStream:flush	()V
    //   185: aload_2
    //   186: invokevirtual 323	java/io/FileInputStream:close	()V
    //   189: aload_0
    //   190: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   193: return
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   199: return
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   205: goto -16 -> 189
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   213: goto -37 -> 176
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   221: return
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_2
    //   225: aload_3
    //   226: astore_1
    //   227: aload_2
    //   228: invokevirtual 323	java/io/FileInputStream:close	()V
    //   231: aload_1
    //   232: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   242: goto -11 -> 231
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   250: goto -15 -> 235
    //   253: astore_3
    //   254: aconst_null
    //   255: astore_2
    //   256: aload_0
    //   257: astore_1
    //   258: aload_3
    //   259: astore_0
    //   260: goto -33 -> 227
    //   263: astore_3
    //   264: aload_0
    //   265: astore_1
    //   266: aload_3
    //   267: astore_0
    //   268: goto -41 -> 227
    //   271: astore_3
    //   272: aload_0
    //   273: astore_2
    //   274: aload_3
    //   275: astore_0
    //   276: goto -49 -> 227
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_0
    //   282: goto -114 -> 168
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_3
    //   288: aload_0
    //   289: astore_1
    //   290: aload_3
    //   291: astore_0
    //   292: goto -124 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	183	0	localObject1	Object
    //   194	2	0	localIOException1	java.io.IOException
    //   208	2	0	localIOException2	java.io.IOException
    //   216	2	0	localIOException3	java.io.IOException
    //   222	35	0	localObject2	Object
    //   259	33	0	localObject3	Object
    //   3	174	1	localObject4	Object
    //   200	2	1	localIOException4	java.io.IOException
    //   226	6	1	localException1	Exception
    //   245	2	1	localIOException5	java.io.IOException
    //   257	33	1	localObject5	Object
    //   54	174	2	localObject6	Object
    //   237	2	2	localIOException6	java.io.IOException
    //   255	19	2	localObject7	Object
    //   279	1	2	localException2	Exception
    //   285	1	2	localException3	Exception
    //   1	1	3	localObject8	Object
    //   161	65	3	localException4	Exception
    //   253	6	3	localObject9	Object
    //   263	4	3	localObject10	Object
    //   271	4	3	localObject11	Object
    //   287	4	3	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   138	144	161	java/lang/Exception
    //   144	158	161	java/lang/Exception
    //   181	185	161	java/lang/Exception
    //   189	193	194	java/io/IOException
    //   185	189	200	java/io/IOException
    //   172	176	208	java/io/IOException
    //   176	180	216	java/io/IOException
    //   4	120	222	finally
    //   120	129	222	finally
    //   227	231	237	java/io/IOException
    //   231	235	245	java/io/IOException
    //   129	138	253	finally
    //   138	144	263	finally
    //   144	158	263	finally
    //   181	185	263	finally
    //   168	172	271	finally
    //   4	120	279	java/lang/Exception
    //   120	129	279	java/lang/Exception
    //   129	138	285	java/lang/Exception
  }
  
  @Deprecated
  public static EMMessage createExpressionMessage(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = EMMessage.createTxtSendMessage("[" + paramString2 + "]", paramString1);
    if (paramString3 != null) {
      paramString1.setAttribute("em_expression_id", paramString3);
    }
    paramString1.setAttribute("em_is_big_expression", true);
    return paramString1;
  }
  
  public static EMMessage createGroupMsg(MinsuImHistoryBean.DataBean.ListBean paramListBean)
  {
    if (paramListBean == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        String str2 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
        str5 = paramListBean.fromUid;
        str3 = paramListBean.toUid;
        str4 = paramListBean.msgContent;
        Object localObject = paramListBean.type;
        l = paramListBean.msgSendTime;
        str1 = null;
        str5 = appendEMPrefix(str5);
        localHashMap = new HashMap();
        if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramListBean.appChatRecordsExt))
        {
          localHashMap.put("ziroomFlag", paramListBean.appChatRecordsExt.ziroomFlag);
          localHashMap.put("domainFlag", paramListBean.appChatRecordsExt.domainFlag);
          localHashMap.put("nicName", paramListBean.appChatRecordsExt.nicName);
          localHashMap.put("userPic", paramListBean.appChatRecordsExt.userPic);
          localHashMap.put("msgType", paramListBean.appChatRecordsExt.msgType);
          localHashMap.put("em_expr_big_name", paramListBean.appChatRecordsExt.em_expr_big_name);
          str1 = paramListBean.appChatRecordsExt.huanxinMsgId;
        }
        EMClient.getInstance().chatManager().getConversation(str3, EMConversation.EMConversationType.GroupChat, true);
        localObject = com.ziroom.ziroomcustomer.minsu.chat.d.b.getType((String)localObject);
        if (str2.equals(paramListBean.fromUid)) {}
        switch (j.5.b[localObject.ordinal()])
        {
        case 1: 
          return createSentTextMsg(str5, str3, "不支持的消息,请升级APP版本", l, str1, localHashMap);
          return createSentTextMsg(str5, str3, str4, l, str1, localHashMap);
        case 2: 
          return createSentImgMsg(str5, str3, paramListBean.url, paramListBean.filename, paramListBean.secret, l, str1, localHashMap);
          switch (j.5.b[localObject.ordinal()])
          {
          case 1: 
            return createReceivedTextMsg(str5, str3, "不支持的消息,请升级APP版本", l, str1, localHashMap);
          }
          break;
        }
      }
      catch (Exception paramListBean)
      {
        String str5;
        String str3;
        String str4;
        long l;
        String str1;
        HashMap localHashMap;
        paramListBean.printStackTrace();
        com.freelxl.baselibrary.f.d.e("imhistory", Log.getStackTraceString(paramListBean.getCause()));
        return null;
      }
      return createReceivedTextMsg(str5, str3, str4, l, str1, localHashMap);
      paramListBean = createReceivedImgMsg(EMMessage.ChatType.GroupChat, str5, str3, paramListBean.url, paramListBean.filename, paramListBean.secret, l, str1, localHashMap, paramListBean);
      return paramListBean;
    }
  }
  
  public static EMImageMessageBody createIMGMsgBodyHuanxin(MinsuImHistoryBean.DataBean.ListBean paramListBean)
  {
    try
    {
      Object localObject = new File("");
      localObject = (EMImageMessageBody)Class.forName("com.hyphenate.chat.EMImageMessageBody").getDeclaredConstructor(new Class[] { File.class }).newInstance(new Object[] { localObject });
      Method localMethod = Class.forName("com.hyphenate.chat.EMImageMessageBody").getDeclaredMethod("setSize", new Class[] { Integer.TYPE, Integer.TYPE });
      localMethod.setAccessible(true);
      e locale = e.parseObject(paramListBean.size);
      localMethod.invoke(localObject, new Object[] { Integer.valueOf(locale.getInteger("width").intValue()), Integer.valueOf(locale.getInteger("height").intValue()) });
      ((EMImageMessageBody)localObject).setFileName(paramListBean.msgSendTime + "" + paramListBean.filename);
      ((EMImageMessageBody)localObject).setSecret(paramListBean.secret);
      ((EMImageMessageBody)localObject).setRemoteUrl(paramListBean.url);
      ((EMImageMessageBody)localObject).setThumbnailUrl(paramListBean.url);
      return (EMImageMessageBody)localObject;
    }
    catch (ClassNotFoundException paramListBean)
    {
      paramListBean.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramListBean)
    {
      for (;;)
      {
        paramListBean.printStackTrace();
      }
    }
    catch (InstantiationException paramListBean)
    {
      for (;;)
      {
        paramListBean.printStackTrace();
      }
    }
    catch (IllegalAccessException paramListBean)
    {
      for (;;)
      {
        paramListBean.printStackTrace();
      }
    }
    catch (InvocationTargetException paramListBean)
    {
      for (;;)
      {
        paramListBean.printStackTrace();
      }
    }
  }
  
  public static EMImageMessageBody createImgBody(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a(paramString3);
    paramString3 = paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length());
    paramString2 = paramString3;
    if (!paramString3.endsWith(".jpg")) {
      paramString2 = paramString3 + ".jpg";
    }
    paramString3 = new EMImageMessageBody(new File(str, paramString2));
    paramString3.setRemoteUrl(paramString1);
    paramString3.setThumbnailUrl(paramString1);
    paramString3.setFileName(paramString2);
    paramString3.setThumbnailLocalPath(str + "/thumb_" + paramString2.substring(0, paramString2.lastIndexOf(".jpg")));
    paramString3.setThumbnailSecret(paramString4);
    return paramString3;
  }
  
  public static EMMessage createReceivedImgMsg(EMMessage.ChatType paramChatType, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, Map<String, Object> paramMap, MinsuImHistoryBean.DataBean.ListBean paramListBean)
  {
    paramListBean = EMMessage.createReceiveMessage(EMMessage.Type.IMAGE);
    if (ae.notNull(paramString6)) {
      paramListBean.setMsgId(paramString6);
    }
    if (paramChatType == EMMessage.ChatType.Chat)
    {
      paramString3 = createImgBody(paramString3, paramString4, paramString1, paramString5);
      paramListBean.addBody(paramString3);
      paramListBean.setFrom(paramString1);
      paramListBean.setTo(paramString2);
      paramListBean.setAcked(true);
      paramListBean.setUnread(false);
      paramListBean.setMsgTime(paramLong);
      paramListBean.setChatType(paramChatType);
      a(paramListBean, paramMap);
      if (!ae.notNull(paramString6)) {
        break label201;
      }
      paramChatType = EMClient.getInstance().chatManager().getMessage(paramString6);
      if (paramChatType == null) {
        break label201;
      }
      paramChatType = (EMImageMessageBody)paramChatType.getBody();
      if ((paramChatType.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.PENDING) && (paramChatType.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.DOWNLOADING) && (paramChatType.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.SUCCESSED)) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        paramListBean.setMessageStatusCallback(new j.1(paramListBean));
        EMClient.getInstance().chatManager().downloadThumbnail(paramListBean);
      }
      return paramListBean;
      paramString3 = createImgBody(paramString3, paramString4, paramString2, paramString5);
      break;
    }
  }
  
  public static EMMessage createReceivedTextMsg(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, Map<String, Object> paramMap)
  {
    EMMessage localEMMessage = EMMessage.createReceiveMessage(EMMessage.Type.TXT);
    if (ae.notNull(paramString4)) {
      localEMMessage.setMsgId(paramString4);
    }
    localEMMessage.addBody(new EMTextMessageBody(paramString3));
    localEMMessage.setFrom(paramString1);
    localEMMessage.setAcked(true);
    localEMMessage.setUnread(false);
    localEMMessage.setTo(paramString2);
    localEMMessage.setStatus(EMMessage.Status.SUCCESS);
    localEMMessage.setMsgTime(paramLong);
    a(localEMMessage, paramMap);
    return localEMMessage;
  }
  
  public static EMMessage createSentImgMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, Map<String, Object> paramMap)
  {
    EMMessage localEMMessage = EMMessage.createSendMessage(EMMessage.Type.IMAGE);
    if (ae.notNull(paramString6)) {
      localEMMessage.setMsgId(paramString6);
    }
    localEMMessage.addBody(createImgBody(paramString3, paramString4, paramString2, paramString5));
    localEMMessage.setTo(paramString2);
    localEMMessage.setFrom(paramString1);
    localEMMessage.setAcked(true);
    localEMMessage.setUnread(false);
    localEMMessage.setMsgTime(paramLong);
    localEMMessage.setStatus(EMMessage.Status.SUCCESS);
    a(localEMMessage, paramMap);
    if (ae.notNull(paramString6))
    {
      paramString1 = EMClient.getInstance().chatManager().getMessage(paramString6);
      if (paramString1 != null)
      {
        paramString1 = (EMImageMessageBody)paramString1.getBody();
        if ((paramString1.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.PENDING) && (paramString1.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.DOWNLOADING) && (paramString1.thumbnailDownloadStatus() != EMFileMessageBody.EMDownloadStatus.SUCCESSED)) {}
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        EMClient.getInstance().chatManager().downloadThumbnail(localEMMessage);
      }
      return localEMMessage;
    }
  }
  
  public static EMMessage createSentTextMsg(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, Map<String, Object> paramMap)
  {
    EMMessage localEMMessage = EMMessage.createSendMessage(EMMessage.Type.TXT);
    if (ae.notNull(paramString4)) {
      localEMMessage.setMsgId(paramString4);
    }
    localEMMessage.addBody(new EMTextMessageBody(paramString3));
    localEMMessage.setTo(paramString2);
    localEMMessage.setFrom(paramString1);
    localEMMessage.setAcked(true);
    localEMMessage.setUnread(false);
    localEMMessage.setMsgTime(paramLong);
    localEMMessage.setStatus(EMMessage.Status.SUCCESS);
    a(localEMMessage, paramMap);
    return localEMMessage;
  }
  
  public static EMMessage createSingleMsg(MinsuImHistoryBean.DataBean.ListBean paramListBean)
  {
    if (paramListBean == null) {
      return null;
    }
    String str2;
    String str4;
    String str5;
    String str3;
    Object localObject;
    long l;
    String str1;
    HashMap localHashMap;
    try
    {
      str2 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
      str4 = paramListBean.fromUid;
      str5 = paramListBean.toUid;
      str3 = paramListBean.msgContent;
      localObject = paramListBean.type;
      l = paramListBean.msgSendTime;
      str1 = null;
      int i = paramListBean.msgSenderType;
      str4 = appendEMPrefix(str4);
      str5 = appendEMPrefix(str5);
      localHashMap = new HashMap();
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramListBean.appChatRecordsExt))
      {
        localHashMap.put("fid", paramListBean.appChatRecordsExt.fid);
        localHashMap.put("rentWay", Integer.valueOf(paramListBean.appChatRecordsExt.rentWay));
        localHashMap.put("rentWayName", paramListBean.appChatRecordsExt.rentWayName);
        localHashMap.put("startDate", paramListBean.appChatRecordsExt.startDate);
        localHashMap.put("endDate", paramListBean.appChatRecordsExt.endDate);
        localHashMap.put("ziroomFlag", paramListBean.appChatRecordsExt.ziroomFlag);
        localHashMap.put("personNum", paramListBean.appChatRecordsExt.personNum);
        localHashMap.put("houseName", paramListBean.appChatRecordsExt.houseName);
        localHashMap.put("housePicUrl", paramListBean.appChatRecordsExt.housePicUrl);
        localHashMap.put("houseCard", paramListBean.appChatRecordsExt.houseCard);
        localHashMap.put("huanxinMsgId", paramListBean.appChatRecordsExt.huanxinMsgId);
        localHashMap.put("domainFlag", paramListBean.appChatRecordsExt.domainFlag);
        localHashMap.put("roleType", Integer.valueOf(paramListBean.appChatRecordsExt.roleType));
        localHashMap.put("msgType", paramListBean.appChatRecordsExt.msgType);
        localHashMap.put("shareHouseMsg", paramListBean.appChatRecordsExt.shareHouseMsg);
        str1 = paramListBean.appChatRecordsExt.huanxinMsgId;
        localHashMap.put("msgSenderType", i + "");
        localHashMap.put("em_expr_big_name", paramListBean.appChatRecordsExt.em_expr_big_name + "");
      }
      if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramListBean.changZuExt)) && (paramListBean.changZuExt.startsWith("{")) && (paramListBean.changZuExt.endsWith("}")))
      {
        Iterator localIterator = ((Map)com.alibaba.fastjson.a.parseObject(paramListBean.changZuExt, Map.class)).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
        }
      }
      localObject = com.ziroom.ziroomcustomer.minsu.chat.d.b.getType((String)localObject);
    }
    catch (Exception paramListBean)
    {
      paramListBean.printStackTrace();
      com.freelxl.baselibrary.f.d.e("imhistory", Log.getStackTraceString(paramListBean.getCause()));
      return null;
    }
    if (str2.equals(paramListBean.fromUid)) {
      EMClient.getInstance().chatManager().getConversation(str5, EMConversation.EMConversationType.Chat, true);
    }
    switch (j.5.b[localObject.ordinal()])
    {
    case 1: 
      return createSentTextMsg(str4, str5, "不支持的消息,请升级APP版本", l, str1, localHashMap);
      return createSentTextMsg(str4, str5, str3, l, str1, localHashMap);
    case 2: 
      return createSentImgMsg(str4, str5, paramListBean.url, paramListBean.filename, paramListBean.secret, l, str1, localHashMap);
      EMClient.getInstance().chatManager().getConversation(str4, EMConversation.EMConversationType.Chat, true);
      switch (j.5.b[localObject.ordinal()])
      {
      }
      break;
    }
    for (;;)
    {
      return createReceivedTextMsg(str4, str5, "不支持的消息,请升级APP版本", l, str1, localHashMap);
      return createReceivedTextMsg(str4, str5, str3, l, str1, localHashMap);
      paramListBean = createReceivedImgMsg(EMMessage.ChatType.Chat, str4, str5, paramListBean.url, paramListBean.filename, paramListBean.secret, l, str1, localHashMap, paramListBean);
      return paramListBean;
      break;
    }
  }
  
  public static String editHouseCard(EMMessage paramEMMessage)
  {
    return "房源咨询消息";
  }
  
  public static String editHouseShare(EMMessage paramEMMessage)
  {
    return "房源推荐消息";
  }
  
  public static String getDomainFlag()
  {
    switch ()
    {
    default: 
      return "";
    case 1: 
      return "minsu_d";
    case 2: 
      return "minsu_tt";
    case 3: 
      return "minsu_q";
    }
    return "minsu_online";
  }
  
  public static String getMessageDigest(EMMessage paramEMMessage, Context paramContext)
  {
    Object localObject = "";
    switch (j.5.a[paramEMMessage.getType().ordinal()])
    {
    }
    do
    {
      do
      {
        return (String)localObject;
      } while (paramContext == null);
      return a(paramContext, 2131297337);
      return a(paramContext, 2131297537);
      return a(paramContext, 2131297535);
      localObject = (EMTextMessageBody)paramEMMessage.getBody();
      if (paramEMMessage.getBooleanAttribute("is_voice_call", false)) {
        return a(paramContext, 2131297536) + ((EMTextMessageBody)localObject).getMessage();
      }
      if ("4".equals(paramEMMessage.getStringAttribute("msgType", ""))) {
        return a(paramContext, 2131296765);
      }
      localObject = ((EMTextMessageBody)localObject).getMessage();
      paramContext = (Context)localObject;
      if (isImError((String)localObject)) {
        paramContext = "";
      }
      if (isMinsuHouseShare(paramEMMessage)) {
        paramContext = editHouseShare(paramEMMessage);
      }
      localObject = paramContext;
    } while (!isHouseCard(paramEMMessage));
    return editHouseCard(paramEMMessage);
  }
  
  /* Error */
  public static int getUnReadMsgSize(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore_1
    //   8: invokestatic 60	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   11: invokevirtual 829	com/hyphenate/chat/EMClient:isLoggedInBefore	()Z
    //   14: istore 6
    //   16: iload 6
    //   18: ifne +12 -> 30
    //   21: iconst_0
    //   22: ireturn
    //   23: astore 7
    //   25: aload 7
    //   27: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   30: iload_0
    //   31: iconst_2
    //   32: if_icmpne +341 -> 373
    //   35: iconst_1
    //   36: istore_3
    //   37: iload 5
    //   39: istore_2
    //   40: invokestatic 143	com/ziroom/ziroomcustomer/minsu/e/d:getUid	()Ljava/lang/String;
    //   43: invokestatic 136	com/ziroom/ziroomcustomer/minsu/chat/j:appendEMPrefix	(Ljava/lang/String;)Ljava/lang/String;
    //   46: pop
    //   47: iload 5
    //   49: istore_2
    //   50: invokestatic 60	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   53: invokevirtual 247	com/hyphenate/chat/EMClient:chatManager	()Lcom/hyphenate/chat/EMChatManager;
    //   56: invokevirtual 833	com/hyphenate/chat/EMChatManager:getAllConversations	()Ljava/util/Map;
    //   59: astore 7
    //   61: iload 5
    //   63: istore_2
    //   64: aload 7
    //   66: monitorenter
    //   67: iload 4
    //   69: istore_2
    //   70: aload 7
    //   72: invokeinterface 837 1 0
    //   77: invokeinterface 840 1 0
    //   82: astore 8
    //   84: iload_1
    //   85: istore_2
    //   86: aload 8
    //   88: invokeinterface 87 1 0
    //   93: ifeq +270 -> 363
    //   96: iload_1
    //   97: istore_2
    //   98: aload 8
    //   100: invokeinterface 91 1 0
    //   105: checkcast 99	com/hyphenate/chat/EMConversation
    //   108: astore 9
    //   110: iload_1
    //   111: istore_2
    //   112: aload 9
    //   114: invokevirtual 103	com/hyphenate/chat/EMConversation:getLastMessage	()Lcom/hyphenate/chat/EMMessage;
    //   117: astore 10
    //   119: aload 10
    //   121: ifnull -37 -> 84
    //   124: iload_1
    //   125: istore_2
    //   126: aload 10
    //   128: invokevirtual 179	com/hyphenate/chat/EMMessage:direct	()Lcom/hyphenate/chat/EMMessage$Direct;
    //   131: getstatic 188	com/hyphenate/chat/EMMessage$Direct:RECEIVE	Lcom/hyphenate/chat/EMMessage$Direct;
    //   134: if_acmpne -50 -> 84
    //   137: iload_1
    //   138: istore_2
    //   139: ldc 105
    //   141: aload 10
    //   143: ldc 107
    //   145: ldc 109
    //   147: invokevirtual 115	com/hyphenate/chat/EMMessage:getStringAttribute	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifeq +79 -> 232
    //   156: iload_1
    //   157: istore_2
    //   158: aload 10
    //   160: ldc 123
    //   162: iconst_0
    //   163: invokevirtual 127	com/hyphenate/chat/EMMessage:getIntAttribute	(Ljava/lang/String;I)I
    //   166: istore 4
    //   168: iload 4
    //   170: ifne +38 -> 208
    //   173: iload_1
    //   174: istore_2
    //   175: aload 10
    //   177: ldc -111
    //   179: ldc 109
    //   181: invokevirtual 115	com/hyphenate/chat/EMMessage:getStringAttribute	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: invokestatic 151	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: iload_3
    //   188: if_icmpne +182 -> 370
    //   191: iload_1
    //   192: istore_2
    //   193: aload 9
    //   195: invokevirtual 843	com/hyphenate/chat/EMConversation:getUnreadMsgCount	()I
    //   198: iload_1
    //   199: iadd
    //   200: istore 4
    //   202: iload 4
    //   204: istore_1
    //   205: goto +165 -> 370
    //   208: iload 4
    //   210: iload_3
    //   211: iand
    //   212: ifeq +158 -> 370
    //   215: iload_1
    //   216: istore_2
    //   217: aload 9
    //   219: invokevirtual 843	com/hyphenate/chat/EMConversation:getUnreadMsgCount	()I
    //   222: iload_1
    //   223: iadd
    //   224: istore 4
    //   226: iload 4
    //   228: istore_1
    //   229: goto +141 -> 370
    //   232: iload_0
    //   233: iconst_2
    //   234: if_icmpne -150 -> 84
    //   237: iload_1
    //   238: istore_2
    //   239: ldc_w 845
    //   242: aload 10
    //   244: ldc 107
    //   246: ldc 109
    //   248: invokevirtual 115	com/hyphenate/chat/EMMessage:getStringAttribute	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifeq -170 -> 84
    //   257: iload_1
    //   258: istore_2
    //   259: aload 9
    //   261: invokevirtual 843	com/hyphenate/chat/EMConversation:getUnreadMsgCount	()I
    //   264: istore 4
    //   266: iload_1
    //   267: iload 4
    //   269: iadd
    //   270: istore_1
    //   271: goto -187 -> 84
    //   274: astore 9
    //   276: iload_1
    //   277: istore_2
    //   278: aload 9
    //   280: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   283: iload_1
    //   284: istore_2
    //   285: ldc -97
    //   287: new 26	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 847
    //   297: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 9
    //   302: invokevirtual 848	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 851	com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -230 -> 84
    //   317: astore 8
    //   319: aload 7
    //   321: monitorexit
    //   322: aload 8
    //   324: athrow
    //   325: astore 7
    //   327: aload 7
    //   329: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   332: ldc -97
    //   334: new 26	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 853
    //   344: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 7
    //   349: invokevirtual 848	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   352: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 851	com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: iload_2
    //   362: ireturn
    //   363: iload_1
    //   364: istore_2
    //   365: aload 7
    //   367: monitorexit
    //   368: iload_1
    //   369: ireturn
    //   370: goto -286 -> 84
    //   373: iconst_2
    //   374: istore_3
    //   375: goto -338 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramInt	int
    //   7	362	1	i	int
    //   39	326	2	j	int
    //   36	339	3	k	int
    //   1	269	4	m	int
    //   4	58	5	n	int
    //   14	3	6	bool	boolean
    //   23	3	7	localException1	Exception
    //   59	261	7	localMap	Map
    //   325	41	7	localException2	Exception
    //   82	17	8	localIterator	Iterator
    //   317	6	8	localObject	Object
    //   108	152	9	localEMConversation	EMConversation
    //   274	27	9	localException3	Exception
    //   117	126	10	localEMMessage	EMMessage
    // Exception table:
    //   from	to	target	type
    //   8	16	23	java/lang/Exception
    //   112	119	274	java/lang/Exception
    //   126	137	274	java/lang/Exception
    //   139	156	274	java/lang/Exception
    //   158	168	274	java/lang/Exception
    //   175	191	274	java/lang/Exception
    //   193	202	274	java/lang/Exception
    //   217	226	274	java/lang/Exception
    //   239	257	274	java/lang/Exception
    //   259	266	274	java/lang/Exception
    //   70	84	317	finally
    //   86	96	317	finally
    //   98	110	317	finally
    //   112	119	317	finally
    //   126	137	317	finally
    //   139	156	317	finally
    //   158	168	317	finally
    //   175	191	317	finally
    //   193	202	317	finally
    //   217	226	317	finally
    //   239	257	317	finally
    //   259	266	317	finally
    //   278	283	317	finally
    //   285	314	317	finally
    //   319	322	317	finally
    //   365	368	317	finally
    //   40	47	325	java/lang/Exception
    //   50	61	325	java/lang/Exception
    //   64	67	325	java/lang/Exception
    //   322	325	325	java/lang/Exception
  }
  
  public static com.ziroom.ziroomcustomer.minsu.chat.a.a getUserFromMessage(EMMessage paramEMMessage)
  {
    String str1 = paramEMMessage.getStringAttribute("nicName", "");
    String str2 = paramEMMessage.getStringAttribute("userPic", "");
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      com.ziroom.ziroomcustomer.minsu.chat.a.a locala = new com.ziroom.ziroomcustomer.minsu.chat.a.a();
      locala.a = str1;
      locala.b = str2;
      locala.c = paramEMMessage.getMsgTime();
      return locala;
    }
    return null;
  }
  
  public static boolean hasForegroundActivies()
  {
    return com.ziroom.ziroomcustomer.util.j.getInstance().getImActivitySize() > 0;
  }
  
  public static boolean isHouseCard(EMMessage paramEMMessage)
  {
    return ("1".equals(paramEMMessage.getStringAttribute("houseCard", ""))) || ("1".equals(paramEMMessage.getStringAttribute("msgType", "")));
  }
  
  public static boolean isImError(String paramString)
  {
    return "#error#".equals(paramString);
  }
  
  public static boolean isMinsuHouseShare(EMMessage paramEMMessage)
  {
    return "2".equals(paramEMMessage.getStringAttribute("msgType", ""));
  }
  
  public static List<EMConversation> loadConversationList(int paramInt)
  {
    Object localObject1 = EMClient.getInstance().chatManager().getAllConversations();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    for (;;)
    {
      EMConversation localEMConversation;
      try
      {
        localObject2 = ((Map)localObject1).values().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localEMConversation = (EMConversation)((Iterator)localObject2).next();
        if (paramInt == 2)
        {
          if ((localEMConversation.getType() == EMConversation.EMConversationType.GroupChat) || (localEMConversation.getAllMessages().size() == 0)) {
            continue;
          }
          localArrayList.add(new Pair(Long.valueOf(localEMConversation.getLastMessage().getMsgTime()), localEMConversation));
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
      }
      finally {}
      if (localEMConversation.getAllMessages().size() != 0) {
        localList.add(new Pair(Long.valueOf(localEMConversation.getLastMessage().getMsgTime()), localEMConversation));
      }
    }
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " sortListSingle = " + localList.size());
    try
    {
      a(localList);
      localObject1 = new ArrayList();
      localObject2 = EMClient.getInstance().groupManager().getAllGroups();
      if (localObject2 != null) {
        b(paramInt, (List)localObject2, (List)localObject1);
      }
      a(paramInt, localList, (List)localObject1);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " currentType = " + paramInt + "  --- DATA = " + localList.size() + " g.size = ");
      return (List<EMConversation>)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void logMsg(List<EMMessage> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)paramList.next();
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = ziroomFlag" + localEMMessage.getStringAttribute("ziroomFlag", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = fid" + localEMMessage.getStringAttribute("fid", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = rentWay" + localEMMessage.getStringAttribute("rentWay", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = startDate" + localEMMessage.getStringAttribute("startDate", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = endDate" + localEMMessage.getStringAttribute("endDate", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = isTop50Online" + localEMMessage.getStringAttribute("isTop50Online", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = houseName" + localEMMessage.getStringAttribute("houseName", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = housePicUrl" + localEMMessage.getStringAttribute("housePicUrl", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = msgSenderType" + localEMMessage.getStringAttribute("msgSenderType", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = domainFlag" + localEMMessage.getStringAttribute("domainFlag", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = nicName" + localEMMessage.getStringAttribute("nicName", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = source" + localEMMessage.getStringAttribute("source", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = roleType" + localEMMessage.getStringAttribute("roleType", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = msgType" + localEMMessage.getStringAttribute("msgType", "wz_null"));
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg = " + localEMMessage);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg.getMsgId = " + localEMMessage.getMsgId());
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "msg.getMsgTime = " + localEMMessage.getMsgTime());
    }
  }
  
  public static String removeEMPrefix(String paramString)
  {
    if (ae.isNull(paramString)) {
      return paramString;
    }
    return paramString.replace("app_", "");
  }
  
  public static void setExtMsg(EMMessage paramEMMessage1, EMMessage paramEMMessage2, String paramString, int paramInt)
  {
    if (paramEMMessage1 == null) {
      return;
    }
    if (paramEMMessage2 != null)
    {
      paramEMMessage2 = paramEMMessage2.ext().entrySet().iterator();
      while (paramEMMessage2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramEMMessage2.next();
        if ((!"ziroomFlag".equals(localEntry.getKey())) && (!"domainFlag".equals(localEntry.getKey())) && (!"nicName".equals(localEntry.getKey())) && (!"source".equals(localEntry.getKey())) && (!"roleType".equals(localEntry.getKey())) && (!"msgSenderType".equals(localEntry.getKey())) && (!"houseCard".equals(localEntry.getKey())) && (!"msgType".equals(localEntry.getKey())) && (!"shareHouseMsg".equals(localEntry.getKey())) && (!"em_expr_big_name".equals(localEntry.getKey()))) {
          if ("shareHouseMsg".equals(localEntry.getKey()))
          {
            if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(localEntry.getValue())) && (!"[]".equals(String.valueOf(localEntry.getValue()))))
            {
              JSONArray localJSONArray = new JSONArray(Arrays.asList(com.alibaba.fastjson.a.parseArray(String.valueOf(localEntry.getValue())).toArray()));
              paramEMMessage1.setAttribute((String)localEntry.getKey(), localJSONArray);
            }
          }
          else if (TextUtils.isEmpty(paramEMMessage1.getStringAttribute((String)localEntry.getKey(), ""))) {
            paramEMMessage1.setAttribute((String)localEntry.getKey(), localEntry.getValue() + "");
          }
        }
      }
    }
    paramEMMessage1.setAttribute("ziroomFlag", "ZIROOM_MINSU_IM");
    paramEMMessage1.setAttribute("msgSenderType", paramString);
    paramEMMessage1.setAttribute("domainFlag", getDomainFlag());
    paramEMMessage1.setAttribute("nicName", c.getUserName4N(com.ziroom.ziroomcustomer.minsu.e.d.getUid()));
    paramEMMessage1.setAttribute("source", "1");
    paramEMMessage1.setAttribute("roleType", paramInt);
    paramEMMessage1.setAttribute("versionCode", 100032);
  }
  
  public static void setExtMsg4Station(EMMessage paramEMMessage1, EMMessage paramEMMessage2)
  {
    if (paramEMMessage1 == null) {
      return;
    }
    paramEMMessage1.setAttribute("ziroomFlag", "ZIROOM_ZRY_IM");
    paramEMMessage1.setAttribute("domainFlag", getDomainFlag());
    paramEMMessage1.setAttribute("nicName", ApplicationEx.c.getUser().getNickName());
    paramEMMessage1.setAttribute("userPic", ApplicationEx.c.getUser().getHeadImg());
    paramEMMessage1.setAttribute("source", "1");
    paramEMMessage1.setAttribute("versionCode", 100032);
  }
  
  public static void syncImList(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("imhistory", " 环信 登录状态 = " + EMClient.getInstance().isLoggedInBefore());
        if (ae.isNull(com.ziroom.ziroomcustomer.minsu.e.d.getUid()))
        {
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("imhistory", " uid 空 !");
          return;
        }
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("imhistory", " 登陆状态错误 !");
          continue;
        }
        if (EMClient.getInstance().isLoggedInBefore()) {
          break label127;
        }
      }
      finally {}
      com.freelxl.baselibrary.f.d.e("imhistory", " error = " + paramContext.getString(2131297083));
      continue;
      label127:
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("imhistory", " 环信 开始同步历史 异步 ");
      com.ziroom.ziroomcustomer.minsu.e.a.syncImList(paramContext, paramInt, new j.2(paramContext, new com.freelxl.baselibrary.d.f.d(MinsuImHistoryBean.class), paramInt, paramContext));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */