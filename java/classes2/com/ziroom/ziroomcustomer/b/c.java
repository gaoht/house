package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class c
{
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_chat_search_question(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid varchar,");
    localStringBuffer.append("question_name    varchar");
    localStringBuffer.append("sendtime    varchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_chat_search_question", new Object[0]);
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
  
  public static void deleteAccount(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.delete("t_chat_search_question", "uid=?", new String[] { paramString });
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
  
  public static boolean exist(com.freelxl.baselibrary.c.b paramb, String paramString1, String paramString2)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_chat_search_question WHERE uid=? AND question_name=? ", new String[] { paramString1, paramString2 });
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
  
  public static List<com.ziroom.ziroomcustomer.newchat.chatcenter.b> query(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_chat_search_question WHERE uid=? ORDER BY id desc", new String[] { paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        com.ziroom.ziroomcustomer.newchat.chatcenter.b localb1 = new com.ziroom.ziroomcustomer.newchat.chatcenter.b();
        localb1.setUid(paramString.getString(paramString.getColumnIndex("uid")));
        localb1.setQuestion_name(paramString.getString(paramString.getColumnIndex("question_name")));
        localArrayList.add(localb1);
        paramString.moveToNext();
        continue;
        paramContext.releaseSession(localb);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      return localArrayList;
      paramString.close();
    }
  }
  
  public static void save(Context paramContext, com.ziroom.ziroomcustomer.newchat.chatcenter.b paramb)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramb.getUid());
      localContentValues.put("question_name", paramb.getQuestion_name());
      localb.delete("t_chat_search_question", "question_name=?", new String[] { paramb.getQuestion_name() });
      localb.insert("t_chat_search_question", null, localContentValues);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
      }
    }
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_chat_search_question");
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */