package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.model.ChatHistory;
import com.ziroom.ziroomcustomer.model.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS chat(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("myuid \t\tvarchar,");
    localStringBuffer.append("friendid \tvarchar,");
    localStringBuffer.append("friendname \tvarchar,");
    localStringBuffer.append("msg \t\tvarchar,");
    localStringBuffer.append("issend \t\tinteger,");
    localStringBuffer.append("time \t\tvarchar,");
    localStringBuffer.append("read\t\tinteger default 0");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static int getAllMsgCnt(Context paramContext, String paramString)
  {
    j = 0;
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      paramString = localb.rawQuery("SELECT count(*) FROM chat WHERE myuid=?", new String[] { paramString });
      paramString.moveToFirst();
      i = j;
      if (!paramString.isAfterLast()) {
        i = paramString.getInt(0);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = j;
      }
    }
    paramContext.releaseSession(localb);
    return i;
  }
  
  public static List<ChatHistory> getFriendNames(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT *  FROM chat GROUP BY friendid HAVING myuid=? ORDER BY time DESC", new String[] { paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        ChatHistory localChatHistory = new ChatHistory();
        localChatHistory.setFriendname(paramString.getString(paramString.getColumnIndex("friendname")));
        localChatHistory.setTime(paramString.getString(paramString.getColumnIndex("time")));
        localChatHistory.setFriendid(paramString.getString(paramString.getColumnIndex("friendid")));
        localChatHistory.setRead(paramString.getInt(paramString.getColumnIndex("read")));
        localChatHistory.setMsg(((ChatMessage)a.parseObject(paramString.getString(paramString.getColumnIndex("msg")), ChatMessage.class)).getMessage());
        localArrayList.add(localChatHistory);
        paramString.moveToNext();
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramContext.releaseSession(localb);
    }
  }
  
  public static List<ChatHistory> getMessageList(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString1 = localb.rawQuery("SELECT * FROM chat WHERE myuid=? AND friendid=?", new String[] { paramString1, paramString2 });
      paramString1.moveToFirst();
      while (!paramString1.isAfterLast())
      {
        paramString2 = new ChatHistory();
        paramString2.setMyuid(paramString1.getString(paramString1.getColumnIndex("myuid")));
        paramString2.setFriendid(paramString1.getString(paramString1.getColumnIndex("friendid")));
        paramString2.setFriendname(paramString1.getString(paramString1.getColumnIndex("friendname")));
        paramString2.setMsg(paramString1.getString(paramString1.getColumnIndex("msg")));
        paramString2.setIssend(paramString1.getInt(paramString1.getColumnIndex("issend")));
        paramString2.setTime(paramString1.getString(paramString1.getColumnIndex("time")));
        paramString2.setRead(paramString1.getInt(paramString1.getColumnIndex("read")));
        localArrayList.add(paramString2);
        paramString1.moveToNext();
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramContext.releaseSession(localb);
    }
  }
  
  public static List<ChatHistory> getSubMessageList(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString1 = localb.rawQuery("SELECT * FROM chat WHERE myuid=? AND friendid=? LIMIT ?OFFSET ((SELECT COUNT(*) FROM chat) - LIMIT ?", new String[] { paramString1, paramString2, paramString3, paramString3 });
      paramString1.moveToFirst();
      while (!paramString1.isAfterLast())
      {
        paramString2 = new ChatHistory();
        paramString2.setMyuid(paramString1.getString(paramString1.getColumnIndex("myuid")));
        paramString2.setFriendid(paramString1.getString(paramString1.getColumnIndex("friendid")));
        paramString2.setFriendname(paramString1.getString(paramString1.getColumnIndex("friendname")));
        paramString2.setMsg(paramString1.getString(paramString1.getColumnIndex("msg")));
        paramString2.setIssend(paramString1.getInt(paramString1.getColumnIndex("issend")));
        paramString2.setTime(paramString1.getString(paramString1.getColumnIndex("time")));
        paramString2.setRead(paramString1.getInt(paramString1.getColumnIndex("read")));
        localArrayList.add(paramString2);
        paramString1.moveToNext();
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramContext.releaseSession(localb);
    }
  }
  
  public static int getUnreadMsgCnt(Context paramContext, String paramString)
  {
    j = 0;
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      paramString = localb.rawQuery("SELECT count(*) FROM chat WHERE myuid=? AND read=0", new String[] { paramString });
      paramString.moveToFirst();
      i = j;
      if (!paramString.isAfterLast()) {
        i = paramString.getInt(0);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = j;
      }
    }
    paramContext.releaseSession(localb);
    return i;
  }
  
  public static void save(Context paramContext, ChatHistory paramChatHistory)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("myuid", paramChatHistory.getMyuid());
      localContentValues.put("friendid", paramChatHistory.getFriendid());
      localContentValues.put("friendname", paramChatHistory.getFriendname());
      localContentValues.put("msg", paramChatHistory.getMsg());
      localContentValues.put("issend", Integer.valueOf(paramChatHistory.getIssend()));
      localContentValues.put("time", paramChatHistory.getTime());
      localContentValues.put("read", Integer.valueOf(paramChatHistory.getRead()));
      localb.insert("chat", null, localContentValues);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramChatHistory)
    {
      for (;;)
      {
        paramChatHistory.printStackTrace();
      }
    }
  }
  
  public static void setMyID(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("UPDATE chat SET myuid = ? WHERE myuid=?", new Object[] { paramString2, paramString1 });
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void setReadMsg(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("UPDATE chat SET read = ? WHERE myuid=?", new Object[] { "1", paramString });
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */