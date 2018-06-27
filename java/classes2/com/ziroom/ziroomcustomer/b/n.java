package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.MessageInfo;
import java.util.ArrayList;
import java.util.List;

public class n
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_message(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid \t\tvarchar,");
    localStringBuffer.append("msg_id \t\tvarchar,");
    localStringBuffer.append("alert \t\tvarchar,");
    localStringBuffer.append("title \t\tvarchar,");
    localStringBuffer.append("push_time \tvarchar,");
    localStringBuffer.append("content \tvarchar,");
    localStringBuffer.append("msg_body_type\tvarchar,");
    localStringBuffer.append("msg_sub_type\tvarchar,");
    localStringBuffer.append("read\t\tinteger");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_message WHERE msg_id=?", new String[] { paramString });
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
  
  public static void deleteAll(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_message", new String[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_message");
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean exist(b paramb, String paramString)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_message WHERE msg_id=?", new String[] { paramString });
    paramb.moveToFirst();
    if (!paramb.isAfterLast()) {
      paramb.moveToNext();
    }
    for (;;)
    {
      paramb.close();
      return bool;
      bool = false;
    }
  }
  
  public static int getMsgCnt(Context paramContext, String paramString)
  {
    j = 0;
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      paramString = localb.rawQuery("SELECT count(*) FROM t_message WHERE uid=? AND read=0", new String[] { paramString });
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
  
  public static int getMsgCnt(Context paramContext, String paramString1, String paramString2)
  {
    j = 0;
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      paramString1 = localb.rawQuery("SELECT count(*) FROM t_message WHERE uid=? AND msg_sub_type=? AND read=0", new String[] { paramString1, paramString2 });
      paramString1.moveToFirst();
      i = j;
      if (!paramString1.isAfterLast()) {
        i = paramString1.getInt(0);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        int i = j;
      }
    }
    paramContext.releaseSession(localb);
    return i;
  }
  
  public static List<MessageInfo> getReadMsg(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_message WHERE read=0 AND uid in (?,?) order by push_time desc", new String[] { "", paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        MessageInfo localMessageInfo = new MessageInfo();
        localMessageInfo.setMsg_id(paramString.getString(paramString.getColumnIndex("msg_id")));
        localMessageInfo.setAlert(paramString.getString(paramString.getColumnIndex("alert")));
        localMessageInfo.setTitle(paramString.getString(paramString.getColumnIndex("title")));
        localMessageInfo.setPush_time(paramString.getString(paramString.getColumnIndex("push_time")));
        localMessageInfo.setContent(paramString.getString(paramString.getColumnIndex("content")));
        localMessageInfo.setMsg_body_type(paramString.getString(paramString.getColumnIndex("msg_body_type")));
        localMessageInfo.setMsg_sub_type(paramString.getString(paramString.getColumnIndex("msg_sub_type")));
        localMessageInfo.setRead(paramString.getInt(paramString.getColumnIndex("read")));
        localArrayList.add(localMessageInfo);
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
  
  public static List<MessageInfo> queryAll(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_message WHERE uid in (?,?) order by push_time desc", new String[] { "", paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        MessageInfo localMessageInfo = new MessageInfo();
        localMessageInfo.setMsg_id(paramString.getString(paramString.getColumnIndex("msg_id")));
        localMessageInfo.setAlert(paramString.getString(paramString.getColumnIndex("alert")));
        localMessageInfo.setTitle(paramString.getString(paramString.getColumnIndex("title")));
        localMessageInfo.setPush_time(paramString.getString(paramString.getColumnIndex("push_time")));
        localMessageInfo.setContent(paramString.getString(paramString.getColumnIndex("content")));
        localMessageInfo.setMsg_body_type(paramString.getString(paramString.getColumnIndex("msg_body_type")));
        localMessageInfo.setMsg_sub_type(paramString.getString(paramString.getColumnIndex("msg_sub_type")));
        localMessageInfo.setRead(paramString.getInt(paramString.getColumnIndex("read")));
        localArrayList.add(localMessageInfo);
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
  
  public static void save(Context paramContext, MessageInfo paramMessageInfo, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramString);
      localContentValues.put("msg_id", paramMessageInfo.getMsg_id());
      localContentValues.put("alert", paramMessageInfo.getAlert());
      localContentValues.put("title", paramMessageInfo.getTitle());
      localContentValues.put("push_time", paramMessageInfo.getPush_time());
      localContentValues.put("content", paramMessageInfo.getContent());
      localContentValues.put("msg_body_type", paramMessageInfo.getMsg_body_type());
      localContentValues.put("msg_sub_type", paramMessageInfo.getMsg_sub_type());
      localContentValues.put("read", Integer.valueOf(paramMessageInfo.getRead()));
      if (!exist(localb, paramMessageInfo.getMsg_id())) {
        localb.insert("t_message", null, localContentValues);
      }
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramMessageInfo)
    {
      for (;;)
      {
        paramMessageInfo.printStackTrace();
      }
    }
  }
  
  public static void setReadByMsgId(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext).getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("read", Integer.valueOf(1));
      paramContext.update("t_message", localContentValues, "msg_id=?", new String[] { paramString });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void setReadByMsgType(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new e(paramContext).getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramString1);
      localContentValues.put("read", Integer.valueOf(1));
      paramContext.update("t_message", localContentValues, "uid=? AND msg_body_type=? AND msg_sub_type=?", new String[] { paramString1, paramString2, paramString3 });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */