package com.hyphenate.chat.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.hyphenate.chat.MessageEncoder;
import com.hyphenate.util.EMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class EMDBManager
{
  private static final String A = "isblocked";
  private static final String B = "max_users";
  private static final String C = "chatroom";
  private static final String D = "name";
  private static final String E = "nick";
  private static final String F = "desc";
  private static final String G = "owner";
  private static final String H = "members";
  private static final String I = "members_size";
  private static final String J = "isblocked";
  private static final String K = "max_users";
  private static final String L = "unreadcount";
  private static final String M = "username";
  private static final String N = "count";
  private static final String O = "token";
  private static final String P = "username";
  private static final String Q = "value";
  private static final String R = "saved_time";
  private static final String S = "contact";
  private static final String T = "jid";
  private static final String U = "username";
  private static final String V = "nick";
  private static final String W = "black_list";
  private static final String X = "username";
  private static final String Y = "conversation_list";
  private static final String Z = "username";
  public static final String a = "_emmsg.db";
  private static final String aa = "groupname";
  private static final String ab = "ext";
  private static final String ac = "conversation_type";
  private static final String ad = "porting";
  private static final String ae = "done";
  private static final String af = "create table chat (_id integer primary key autoincrement, msgid text, msgtime integer, msgdir integer, isacked integer, isdelivered integer, status integer,participant text not null, islistened integer, msgbody text not null,msgtype integer, groupname text);";
  private static final String ag = "create table emgroup (name text primary key, jid text not null, nick text not null, owner text not null, modifiedtime integer, ispublic integer, desc text, members_size integer, isblocked integer, members text, max_users integer);";
  private static final String ah = "create table chatroom (name text primary key, nick text, owner text, desc text, members_size integer, isblocked integer, members text, max_users integer);";
  private static final String ai = "create table unreadcount (username text primary key, count integer);";
  private static final String aj = "create table token (username text primary key, value text, saved_time integer);";
  private static final String ak = "create table contact (jid text primary key, username text, nick );";
  private static final String al = "create table black_list (username text primary key);";
  private static final String am = "create table if not exists conversation_list (username text primary key, groupname text, ext text, conversation_type integer);";
  private static final String an = "create table if not exists porting (done integer)";
  private static EMDBManager ao = null;
  public static final String b = "msgbody";
  public static final String c = "status";
  private static String d = "EMDBManager";
  private static final int e = 13;
  private static final String f = "chat";
  private static final String g = "_id";
  private static final String h = "msgid";
  private static final String i = "msgtime";
  private static final String j = "msgdir";
  private static final String k = "participant";
  private static final String l = "groupname";
  private static final String m = "isacked";
  private static final String n = "isdelivered";
  private static final String o = "islistened";
  private static final String p = "msgtype";
  private static final String q = "emgroup";
  private static final String r = "name";
  private static final String s = "nick";
  private static final String t = "desc";
  private static final String u = "owner";
  private static final String v = "members";
  private static final String w = "members_size";
  private static final String x = "modifiedtime";
  private static final String y = "jid";
  private static final String z = "ispublic";
  private boolean ap = true;
  private String aq = null;
  private Context ar;
  private boolean as = false;
  private EMChatConfigPrivate at = null;
  private a au = null;
  
  public static EMDBManager a()
  {
    try
    {
      if (ao == null)
      {
        EMLog.e(d, "Please login first!");
        throw new IllegalStateException("Please login first!");
      }
    }
    finally {}
    EMDBManager localEMDBManager = ao;
    return localEMDBManager;
  }
  
  /* Error */
  public static void a(String paramString, EMChatConfigPrivate paramEMChatConfigPrivate)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 192	com/hyphenate/chat/core/EMDBManager:d	Ljava/lang/String;
    //   6: new 231	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   13: ldc -22
    //   15: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 244	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   31: ifnull +37 -> 68
    //   34: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   37: getfield 202	com/hyphenate/chat/core/EMDBManager:aq	Ljava/lang/String;
    //   40: ifnull +22 -> 62
    //   43: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   46: getfield 202	com/hyphenate/chat/core/EMDBManager:aq	Ljava/lang/String;
    //   49: aload_0
    //   50: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: ifeq +7 -> 62
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   65: invokevirtual 252	com/hyphenate/chat/core/EMDBManager:b	()V
    //   68: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   71: ifnonnull +32 -> 103
    //   74: new 2	com/hyphenate/chat/core/EMDBManager
    //   77: dup
    //   78: invokespecial 253	com/hyphenate/chat/core/EMDBManager:<init>	()V
    //   81: putstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   84: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   87: aload_1
    //   88: putfield 206	com/hyphenate/chat/core/EMDBManager:at	Lcom/hyphenate/chat/core/EMChatConfigPrivate;
    //   91: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   94: invokestatic 259	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   97: invokevirtual 263	com/hyphenate/chat/EMClient:getContext	()Landroid/content/Context;
    //   100: putfield 265	com/hyphenate/chat/core/EMDBManager:ar	Landroid/content/Context;
    //   103: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   106: aload_0
    //   107: putfield 202	com/hyphenate/chat/core/EMDBManager:aq	Ljava/lang/String;
    //   110: getstatic 194	com/hyphenate/chat/core/EMDBManager:ao	Lcom/hyphenate/chat/core/EMDBManager;
    //   113: iconst_0
    //   114: putfield 200	com/hyphenate/chat/core/EMDBManager:ap	Z
    //   117: goto -59 -> 58
    //   120: astore_0
    //   121: ldc 2
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString	String
    //   0	126	1	paramEMChatConfigPrivate	EMChatConfigPrivate
    //   53	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	54	120	finally
    //   62	68	120	finally
    //   68	103	120	finally
    //   103	117	120	finally
  }
  
  private static void b(String paramString1, int paramInt, String paramString2)
  {
    ao.at.a(paramString1, paramInt, paramString2);
  }
  
  private static EMMessage d(Cursor paramCursor)
  {
    boolean bool2 = true;
    EMMessage localEMMessage = MessageEncoder.getMsgFromJson(paramCursor.getString(paramCursor.getColumnIndex("msgbody")));
    localEMMessage.setMsgId(paramCursor.getString(paramCursor.getColumnIndex("msgid")));
    localEMMessage.setMsgTime(paramCursor.getLong(paramCursor.getColumnIndex("msgtime")));
    Object localObject;
    if (paramCursor.getInt(paramCursor.getColumnIndex("msgdir")) == 0)
    {
      localObject = EMMessage.Direct.SEND;
      localEMMessage.setDirection((EMMessage.Direct)localObject);
      i1 = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (i1 != EMMessage.Status.CREATE.ordinal()) {
        break label243;
      }
      localEMMessage.setStatus(EMMessage.Status.CREATE);
      label121:
      if (paramCursor.getInt(paramCursor.getColumnIndex("isacked")) == 0) {
        break label306;
      }
      bool1 = true;
      label140:
      localEMMessage.setAcked(bool1);
      if (paramCursor.getInt(paramCursor.getColumnIndex("isdelivered")) == 0) {
        break label311;
      }
      bool1 = true;
      label165:
      localEMMessage.setDeliverAcked(bool1);
      if (paramCursor.getInt(paramCursor.getColumnIndex("islistened")) != 1) {
        break label316;
      }
    }
    label243:
    label306:
    label311:
    label316:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localEMMessage.setListened(bool1);
      localEMMessage.setUnread(false);
      localObject = paramCursor.getString(paramCursor.getColumnIndex("groupname"));
      if (localObject != null) {
        break label321;
      }
      localEMMessage.setChatType(EMMessage.ChatType.Chat);
      return localEMMessage;
      localObject = EMMessage.Direct.RECEIVE;
      break;
      if (i1 == EMMessage.Status.INPROGRESS.ordinal())
      {
        localEMMessage.setStatus(EMMessage.Status.INPROGRESS);
        break label121;
      }
      if (i1 == EMMessage.Status.SUCCESS.ordinal())
      {
        localEMMessage.setStatus(EMMessage.Status.SUCCESS);
        break label121;
      }
      if (i1 != EMMessage.Status.FAIL.ordinal()) {
        break label121;
      }
      localEMMessage.setStatus(EMMessage.Status.FAIL);
      break label121;
      bool1 = false;
      break label140;
      bool1 = false;
      break label165;
    }
    label321:
    int i1 = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    localEMMessage.setChatType(EMMessage.ChatType.GroupChat);
    if (i1 == EMMessage.ChatType.ChatRoom.ordinal()) {
      localEMMessage.setChatType(EMMessage.ChatType.ChatRoom);
    }
    localEMMessage.setTo((String)localObject);
    return localEMMessage;
  }
  
  private static void e(Cursor paramCursor)
    throws Exception
  {
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("name"));
    int i1;
    String str2;
    String str3;
    String str4;
    if (paramCursor.getInt(paramCursor.getColumnIndex("ispublic")) == 0)
    {
      i1 = 1;
      str2 = paramCursor.getString(paramCursor.getColumnIndex("nick"));
      str3 = paramCursor.getString(paramCursor.getColumnIndex("owner"));
      str4 = paramCursor.getString(paramCursor.getColumnIndex("desc"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("isblocked")) != 0) {
        break label178;
      }
    }
    int i2;
    ArrayList localArrayList;
    label178:
    for (boolean bool = false;; bool = true)
    {
      i2 = paramCursor.getInt(paramCursor.getColumnIndex("max_users"));
      paramCursor = new StringTokenizer(paramCursor.getString(paramCursor.getColumnIndex("members")), ",");
      localArrayList = new ArrayList();
      while (paramCursor.hasMoreTokens()) {
        localArrayList.add(paramCursor.nextToken());
      }
      i1 = 2;
      break;
    }
    ao.at.a(str1, i1, str3, str2, str4, localArrayList, bool, i2);
  }
  
  private static void f(Cursor paramCursor)
    throws Exception
  {
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("name"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("nick"));
    String str3 = paramCursor.getString(paramCursor.getColumnIndex("owner"));
    String str4 = paramCursor.getString(paramCursor.getColumnIndex("desc"));
    int i1 = paramCursor.getInt(paramCursor.getColumnIndex("max_users"));
    paramCursor = new StringTokenizer(paramCursor.getString(paramCursor.getColumnIndex("members")), ",");
    ArrayList localArrayList = new ArrayList();
    while (paramCursor.hasMoreTokens()) {
      localArrayList.add(paramCursor.nextToken());
    }
    ao.at.a(str1, str3, str2, str4, localArrayList, i1);
  }
  
  private static void h()
  {
    ao.at.y();
  }
  
  public int a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = EMChatDBOpenHelper.getInstance(this.ar, this.aq).getReadableDatabase().rawQuery("select count from unreadcount where username = ?", new String[] { paramString });
        if (paramString.moveToFirst())
        {
          i1 = paramString.getInt(paramString.getColumnIndex("count"));
          paramString.close();
          if (i1 < 0) {
            return 0;
          }
          return i1;
        }
      }
      catch (Exception paramString)
      {
        return 0;
      }
      int i1 = 0;
    }
  }
  
  public long a(String paramString, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = EMChatDBOpenHelper.getInstance(this.ar, this.aq).getWritableDatabase();
    if (!paramBoolean) {}
    for (String str = "participant";; str = "groupname") {
      try
      {
        paramString = localSQLiteDatabase.rawQuery("select count(*) as msgCount from chat where " + str + " = ?", new String[] { paramString });
        if (!paramString.moveToFirst())
        {
          paramString.close();
          return 0L;
        }
        long l1 = paramString.getLong(0);
        paramString.close();
        return l1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 0L;
      }
    }
  }
  
  public void a(a parama)
  {
    this.au = parama;
  }
  
  public void b()
  {
    try
    {
      EMChatDBOpenHelper.closeDB();
      EMLog.d(d, "close msg db");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      EMChatDBOpenHelper.getInstance(this.ar, this.aq).getWritableDatabase();
      ao.b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public List<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = EMChatDBOpenHelper.getInstance(this.ar, this.aq).getReadableDatabase().rawQuery("select * from unreadcount", new String[0]);
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        return localArrayList;
      }
      do
      {
        String str = localCursor.getString(0);
        if (localCursor.getInt(1) > 0) {
          localArrayList.add(str);
        }
      } while (localCursor.moveToNext());
      localCursor.close();
      return localArrayList;
    }
    catch (Exception localException) {}
    return localArrayList;
  }
  
  public boolean e()
  {
    return this.as;
  }
  
  private static class EMChatDBOpenHelper
    extends SQLiteOpenHelper
  {
    private static EMChatDBOpenHelper instance = null;
    private String username;
    
    private EMChatDBOpenHelper(Context paramContext, String paramString)
    {
      super(paramString + "_emmsg.db", null, 13);
      this.username = paramString;
      EMLog.d(EMDBManager.f(), "created chatdb for :" + paramString);
    }
    
    private void addConversation(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
    {
      try
      {
        EMLog.d(EMDBManager.f(), "add converstion with:" + paramString);
        if (!paramBoolean) {}
        for (String str = "username";; str = "groupname")
        {
          paramSQLiteDatabase.execSQL("insert into conversation_list (" + str + ") select ? where not exists (select null from " + "conversation_list" + " where " + str + " = ?)", new String[] { paramString, paramString });
          return;
        }
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
    
    private void clearContactTable_v10(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        EMLog.d(EMDBManager.f(), "add converstion with:" + this.username);
        paramSQLiteDatabase.execSQL("delete from contact", new String[0]);
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
    
    /* Error */
    public static void closeDB()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: getstatic 15	com/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper:instance	Lcom/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper;
      //   6: astore_0
      //   7: aload_0
      //   8: ifnull +16 -> 24
      //   11: getstatic 15	com/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper:instance	Lcom/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper;
      //   14: invokevirtual 87	com/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   17: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
      //   20: aconst_null
      //   21: putstatic 15	com/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper:instance	Lcom/hyphenate/chat/core/EMDBManager$EMChatDBOpenHelper;
      //   24: ldc 2
      //   26: monitorexit
      //   27: return
      //   28: astore_0
      //   29: aload_0
      //   30: invokevirtual 78	java/lang/Exception:printStackTrace	()V
      //   33: goto -13 -> 20
      //   36: astore_0
      //   37: ldc 2
      //   39: monitorexit
      //   40: aload_0
      //   41: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   6	2	0	localEMChatDBOpenHelper	EMChatDBOpenHelper
      //   28	2	0	localException	Exception
      //   36	5	0	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   11	20	28	java/lang/Exception
      //   3	7	36	finally
      //   11	20	36	finally
      //   20	24	36	finally
      //   29	33	36	finally
    }
    
    static void createMigrateTable(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("create table if not exists porting (done integer)");
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    
    private void dropDB(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("drop table chat");
        paramSQLiteDatabase.execSQL("drop table emgroup");
        paramSQLiteDatabase.execSQL("drop table unreadcount");
        paramSQLiteDatabase.execSQL("drop table token");
        paramSQLiteDatabase.execSQL("drop table contact");
        paramSQLiteDatabase.execSQL("drop table black_list");
        paramSQLiteDatabase.execSQL("drop table conversation_list");
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    
    public static EMChatDBOpenHelper getInstance(Context paramContext, String paramString)
    {
      try
      {
        if (instance == null) {
          instance = new EMChatDBOpenHelper(paramContext, paramString);
        }
        paramContext = instance;
        return paramContext;
      }
      finally {}
    }
    
    private boolean importBlackList(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      EMLog.d(EMDBManager.f(), "importBlackList");
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from black_list", null);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isClosed())) {
            paramSQLiteDatabase.close();
          }
        }
        do
        {
          return true;
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          ArrayList localArrayList = new ArrayList();
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(paramSQLiteDatabase.getString(0));
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
          } while (paramSQLiteDatabase.moveToNext());
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          EMDBManager.a(EMDBManager.a()).a(localArrayList);
        } while ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isClosed()));
        paramSQLiteDatabase.close();
        return true;
      }
      catch (Exception paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
        if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isClosed())) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private boolean importChatRooms(SQLiteDatabase paramSQLiteDatabase)
    {
      EMLog.d(EMDBManager.f(), "importChatRooms");
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from chatroom", new String[0]);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isClosed())) {
            paramSQLiteDatabase.close();
          }
        }
        do
        {
          return true;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            EMDBManager.c(paramSQLiteDatabase);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
          } while (paramSQLiteDatabase.moveToNext());
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
        } while ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isClosed()));
        paramSQLiteDatabase.close();
        return true;
      }
      catch (Exception paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
        localObject = localSQLiteDatabase;
        paramSQLiteDatabase.printStackTrace();
        if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isClosed())) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private boolean importContacts(SQLiteDatabase paramSQLiteDatabase)
    {
      localObject = null;
      localSQLiteDatabase = null;
      bool2 = true;
      EMLog.d(EMDBManager.f(), "importContacts");
      label78:
      do
      {
        do
        {
          try
          {
            paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from contact", null);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.moveToFirst()) {
              break label78;
            }
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            paramSQLiteDatabase.close();
            bool1 = bool2;
            if (paramSQLiteDatabase != null)
            {
              bool1 = bool2;
              if (!paramSQLiteDatabase.isClosed())
              {
                paramSQLiteDatabase.close();
                bool1 = bool2;
              }
            }
          }
          catch (Exception paramSQLiteDatabase)
          {
            do
            {
              do
              {
                ArrayList localArrayList;
                localObject = localSQLiteDatabase;
                EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
                bool2 = false;
                bool1 = bool2;
              } while (localSQLiteDatabase == null);
              boolean bool1 = bool2;
            } while (localSQLiteDatabase.isClosed());
            localSQLiteDatabase.close();
            return false;
          }
          finally
          {
            if ((localObject == null) || (((Cursor)localObject).isClosed())) {
              break;
            }
            ((Cursor)localObject).close();
          }
          return bool1;
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localArrayList = new ArrayList();
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(paramSQLiteDatabase.getString(1));
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
          } while (paramSQLiteDatabase.moveToNext());
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          EMDBManager.a(EMDBManager.a()).b(localArrayList);
          bool1 = bool2;
        } while (paramSQLiteDatabase == null);
        bool1 = bool2;
      } while (paramSQLiteDatabase.isClosed());
      paramSQLiteDatabase.close();
      return true;
    }
    
    /* Error */
    private boolean importConversations(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 7
      //   3: aconst_null
      //   4: astore 6
      //   6: invokestatic 40	com/hyphenate/chat/core/EMDBManager:f	()Ljava/lang/String;
      //   9: ldc -69
      //   11: invokestatic 48	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   14: aload 6
      //   16: astore 5
      //   18: aload 7
      //   20: astore 4
      //   22: new 136	java/util/ArrayList
      //   25: dup
      //   26: invokespecial 137	java/util/ArrayList:<init>	()V
      //   29: pop
      //   30: aload 6
      //   32: astore 5
      //   34: aload 7
      //   36: astore 4
      //   38: aload_1
      //   39: ldc -67
      //   41: aconst_null
      //   42: invokevirtual 124	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   45: astore_1
      //   46: aload_1
      //   47: astore 5
      //   49: aload_1
      //   50: astore 4
      //   52: aload_1
      //   53: invokeinterface 130 1 0
      //   58: ifne +36 -> 94
      //   61: aload_1
      //   62: astore 5
      //   64: aload_1
      //   65: astore 4
      //   67: aload_1
      //   68: invokeinterface 131 1 0
      //   73: aload_1
      //   74: ifnull +18 -> 92
      //   77: aload_1
      //   78: invokeinterface 134 1 0
      //   83: ifne +9 -> 92
      //   86: aload_1
      //   87: invokeinterface 131 1 0
      //   92: iconst_1
      //   93: ireturn
      //   94: aload_1
      //   95: astore 5
      //   97: aload_1
      //   98: astore 4
      //   100: new 136	java/util/ArrayList
      //   103: dup
      //   104: invokespecial 137	java/util/ArrayList:<init>	()V
      //   107: pop
      //   108: aload_1
      //   109: astore 5
      //   111: aload_1
      //   112: astore 4
      //   114: aload_1
      //   115: aload_1
      //   116: ldc 75
      //   118: invokeinterface 193 2 0
      //   123: invokeinterface 197 2 0
      //   128: ifne +114 -> 242
      //   131: iconst_1
      //   132: istore_2
      //   133: iload_2
      //   134: ifne +113 -> 247
      //   137: aload_1
      //   138: astore 5
      //   140: aload_1
      //   141: astore 4
      //   143: aload_1
      //   144: aload_1
      //   145: ldc 55
      //   147: invokeinterface 193 2 0
      //   152: invokeinterface 141 2 0
      //   157: astore 6
      //   159: iload_2
      //   160: ifne +112 -> 272
      //   163: aload_1
      //   164: astore 5
      //   166: aload_1
      //   167: astore 4
      //   169: getstatic 203	com/hyphenate/chat/EMConversation$EMConversationType:Chat	Lcom/hyphenate/chat/EMConversation$EMConversationType;
      //   172: astore 7
      //   174: aload_1
      //   175: astore 5
      //   177: aload_1
      //   178: astore 4
      //   180: aload 6
      //   182: aload 7
      //   184: invokevirtual 207	com/hyphenate/chat/EMConversation$EMConversationType:ordinal	()I
      //   187: aload_1
      //   188: aload_1
      //   189: ldc -47
      //   191: invokeinterface 193 2 0
      //   196: invokeinterface 141 2 0
      //   201: invokestatic 212	com/hyphenate/chat/core/EMDBManager:a	(Ljava/lang/String;ILjava/lang/String;)V
      //   204: aload_1
      //   205: astore 5
      //   207: aload_1
      //   208: astore 4
      //   210: aload_1
      //   211: invokeinterface 150 1 0
      //   216: istore_3
      //   217: iload_3
      //   218: ifne -110 -> 108
      //   221: aload_1
      //   222: ifnull -130 -> 92
      //   225: aload_1
      //   226: invokeinterface 134 1 0
      //   231: ifne -139 -> 92
      //   234: aload_1
      //   235: invokeinterface 131 1 0
      //   240: iconst_1
      //   241: ireturn
      //   242: iconst_0
      //   243: istore_2
      //   244: goto -111 -> 133
      //   247: aload_1
      //   248: astore 5
      //   250: aload_1
      //   251: astore 4
      //   253: aload_1
      //   254: aload_1
      //   255: ldc 75
      //   257: invokeinterface 193 2 0
      //   262: invokeinterface 141 2 0
      //   267: astore 6
      //   269: goto -110 -> 159
      //   272: aload_1
      //   273: astore 5
      //   275: aload_1
      //   276: astore 4
      //   278: getstatic 215	com/hyphenate/chat/EMConversation$EMConversationType:GroupChat	Lcom/hyphenate/chat/EMConversation$EMConversationType;
      //   281: astore 7
      //   283: goto -109 -> 174
      //   286: astore_1
      //   287: aload 5
      //   289: astore 4
      //   291: invokestatic 40	com/hyphenate/chat/core/EMDBManager:f	()Ljava/lang/String;
      //   294: new 20	java/lang/StringBuilder
      //   297: dup
      //   298: invokespecial 22	java/lang/StringBuilder:<init>	()V
      //   301: ldc -92
      //   303: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   306: aload_1
      //   307: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   310: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   313: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   316: invokestatic 170	com/hyphenate/util/EMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   319: aload 5
      //   321: ifnull +20 -> 341
      //   324: aload 5
      //   326: invokeinterface 134 1 0
      //   331: ifne +10 -> 341
      //   334: aload 5
      //   336: invokeinterface 131 1 0
      //   341: iconst_0
      //   342: ireturn
      //   343: astore_1
      //   344: aload 4
      //   346: ifnull +20 -> 366
      //   349: aload 4
      //   351: invokeinterface 134 1 0
      //   356: ifne +10 -> 366
      //   359: aload 4
      //   361: invokeinterface 131 1 0
      //   366: aload_1
      //   367: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	368	0	this	EMChatDBOpenHelper
      //   0	368	1	paramSQLiteDatabase	SQLiteDatabase
      //   132	112	2	i	int
      //   216	2	3	bool	boolean
      //   20	340	4	localObject1	Object
      //   16	319	5	localObject2	Object
      //   4	264	6	str	String
      //   1	281	7	localEMConversationType	EMConversation.EMConversationType
      // Exception table:
      //   from	to	target	type
      //   22	30	286	java/lang/Exception
      //   38	46	286	java/lang/Exception
      //   52	61	286	java/lang/Exception
      //   67	73	286	java/lang/Exception
      //   100	108	286	java/lang/Exception
      //   114	131	286	java/lang/Exception
      //   143	159	286	java/lang/Exception
      //   169	174	286	java/lang/Exception
      //   180	204	286	java/lang/Exception
      //   210	217	286	java/lang/Exception
      //   253	269	286	java/lang/Exception
      //   278	283	286	java/lang/Exception
      //   22	30	343	finally
      //   38	46	343	finally
      //   52	61	343	finally
      //   67	73	343	finally
      //   100	108	343	finally
      //   114	131	343	finally
      //   143	159	343	finally
      //   169	174	343	finally
      //   180	204	343	finally
      //   210	217	343	finally
      //   253	269	343	finally
      //   278	283	343	finally
      //   291	319	343	finally
    }
    
    private boolean importGroups(SQLiteDatabase paramSQLiteDatabase)
    {
      EMLog.d(EMDBManager.f(), "importGroups");
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from emgroup", new String[0]);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isClosed())) {
            paramSQLiteDatabase.close();
          }
        }
        do
        {
          return true;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            EMDBManager.b(paramSQLiteDatabase);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
          } while (paramSQLiteDatabase.moveToNext());
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
        } while ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isClosed()));
        paramSQLiteDatabase.close();
        return true;
      }
      catch (Exception paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
        localObject = localSQLiteDatabase;
        paramSQLiteDatabase.printStackTrace();
        if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isClosed())) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private boolean importMessages(SQLiteDatabase paramSQLiteDatabase)
    {
      localObject = null;
      SQLiteDatabase localSQLiteDatabase1 = null;
      bool2 = true;
      EMLog.d(EMDBManager.f(), "importMessages");
      for (;;)
      {
        try
        {
          paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM chat", null);
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToFirst()) {
            continue;
          }
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          bool1 = bool2;
          if (paramSQLiteDatabase != null)
          {
            bool1 = bool2;
            if (!paramSQLiteDatabase.isClosed())
            {
              paramSQLiteDatabase.close();
              bool1 = bool2;
            }
          }
        }
        catch (Exception paramSQLiteDatabase)
        {
          ArrayList localArrayList;
          SQLiteDatabase localSQLiteDatabase2;
          localObject = localSQLiteDatabase2;
          EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
          bool2 = false;
          boolean bool1 = bool2;
          if (localSQLiteDatabase2 == null) {
            continue;
          }
          bool1 = bool2;
          if (localSQLiteDatabase2.isClosed()) {
            continue;
          }
          localSQLiteDatabase2.close();
          return false;
        }
        finally
        {
          if ((localObject == null) || (((Cursor)localObject).isClosed())) {
            continue;
          }
          ((Cursor)localObject).close();
        }
        return bool1;
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        localArrayList = new ArrayList();
        localObject = paramSQLiteDatabase;
        try
        {
          localArrayList.add(EMDBManager.a(paramSQLiteDatabase));
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (localArrayList.size() >= 1000)
          {
            localSQLiteDatabase1 = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            EMClient.getInstance().chatManager().importMessages(localArrayList);
            localSQLiteDatabase1 = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.clear();
          }
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToNext()) {
            continue;
          }
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (localArrayList.size() > 0)
          {
            localSQLiteDatabase1 = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            EMClient.getInstance().chatManager().importMessages(localArrayList);
            localSQLiteDatabase1 = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.clear();
          }
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          bool1 = bool2;
          if (paramSQLiteDatabase == null) {
            continue;
          }
          bool1 = bool2;
          if (paramSQLiteDatabase.isClosed()) {
            continue;
          }
          paramSQLiteDatabase.close();
          return true;
        }
        catch (Exception localException)
        {
          localSQLiteDatabase2 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          EMLog.d(EMDBManager.f(), "failed to load msg: " + paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("msgbody")));
        }
      }
    }
    
    private boolean importUnread(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      EMLog.d(EMDBManager.f(), "importUnread");
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from unreadcount", null);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.close();
          if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isClosed())) {
            paramSQLiteDatabase.close();
          }
        }
        do
        {
          return true;
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            String str = paramSQLiteDatabase.getString(0);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            int i = paramSQLiteDatabase.getInt(1);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            EMDBManager.a(EMDBManager.a()).a(str, i);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            bool = paramSQLiteDatabase.moveToNext();
          } while (bool);
        } while ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isClosed()));
        paramSQLiteDatabase.close();
        return true;
      }
      catch (Exception paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        EMLog.e(EMDBManager.f(), "migrateToOneSDK..." + paramSQLiteDatabase.getMessage());
        if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isClosed())) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private void initializeConversation(SQLiteDatabase paramSQLiteDatabase)
    {
      EMLog.d(EMDBManager.f(), "initializeConversation");
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      try
      {
        Cursor localCursor = paramSQLiteDatabase.rawQuery("select distinct participant from chat where groupname is null", null);
        if (localCursor.moveToFirst()) {
          do
          {
            ((List)localObject2).add(localCursor.getString(0));
          } while (localCursor.moveToNext());
        }
        localCursor.close();
        localCursor = paramSQLiteDatabase.rawQuery("select distinct groupname from chat where groupname is not null", null);
        if (localCursor.moveToFirst()) {
          do
          {
            ((List)localObject1).add(localCursor.getString(0));
          } while (localCursor.moveToNext());
        }
        localCursor.close();
        EMLog.d(EMDBManager.f(), "load participants size:" + ((List)localObject2).size());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          addConversation(paramSQLiteDatabase, (String)((Iterator)localObject1).next(), true);
        }
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        addConversation(paramSQLiteDatabase, (String)((Iterator)localObject2).next(), false);
      }
    }
    
    private boolean isColumnExist(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
    {
      localObject = null;
      localSQLiteDatabase = null;
      bool3 = false;
      bool2 = false;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM " + paramString1 + " LIMIT 0", null);
        boolean bool1 = bool2;
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          int i = paramSQLiteDatabase.getColumnIndex(paramString2);
          bool1 = bool2;
          if (i != -1) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramSQLiteDatabase != null)
        {
          bool2 = bool1;
          if (!paramSQLiteDatabase.isClosed())
          {
            paramSQLiteDatabase.close();
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        do
        {
          do
          {
            localObject = localSQLiteDatabase;
            EMLog.e(EMDBManager.f(), "checkColumnExists..." + paramSQLiteDatabase.getMessage());
            bool2 = bool3;
          } while (localSQLiteDatabase == null);
          bool2 = bool3;
        } while (localSQLiteDatabase.isClosed());
        localSQLiteDatabase.close();
        return false;
      }
      finally
      {
        if ((localObject == null) || (((Cursor)localObject).isClosed())) {
          break label203;
        }
        ((Cursor)localObject).close();
      }
      return bool2;
    }
    
    private void migrateFrom10To12(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from conversation_list", null);
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        return;
      }
      int i;
      label48:
      int j;
      String str;
      if (!localCursor.isNull(localCursor.getColumnIndex("groupname")))
      {
        i = 1;
        j = EMConversation.EMConversationType.Chat.ordinal();
        if (i == 0) {
          break label167;
        }
        i = EMConversation.EMConversationType.GroupChat.ordinal();
        str = "groupname";
      }
      for (;;)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("conversation_type", Integer.valueOf(i));
        paramSQLiteDatabase.update("conversation_list", localContentValues, str + " = ?", new String[] { localCursor.getString(localCursor.getColumnIndex(str)) });
        if (localCursor.moveToNext()) {
          break;
        }
        localCursor.close();
        return;
        i = 0;
        break label48;
        label167:
        str = "username";
        i = j;
      }
    }
    
    static boolean migrationFinished(SQLiteDatabase paramSQLiteDatabase)
    {
      for (boolean bool = true;; bool = false) {
        try
        {
          paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from porting", new String[0]);
          if (paramSQLiteDatabase != null)
          {
            if (paramSQLiteDatabase.moveToFirst())
            {
              if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("done")) == 1)
              {
                paramSQLiteDatabase.close();
                return bool;
              }
            }
            else {
              paramSQLiteDatabase.close();
            }
          }
          else {
            return false;
          }
        }
        catch (Exception paramSQLiteDatabase)
        {
          return false;
        }
      }
    }
    
    static boolean setMigrationDone(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("done", Integer.valueOf(1));
        long l = paramSQLiteDatabase.replace("porting", null, localContentValues);
        return l != -1L;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
      return false;
    }
    
    public void migrateToOneSDK(SQLiteDatabase paramSQLiteDatabase)
    {
      boolean bool = true;
      EMLog.d(EMDBManager.f(), "---->start migrate");
      createMigrateTable(paramSQLiteDatabase);
      if (migrationFinished(paramSQLiteDatabase)) {}
      int i;
      int j;
      label44:
      int k;
      label55:
      int m;
      label66:
      int n;
      label77:
      int i1;
      label88:
      label139:
      label180:
      do
      {
        return;
        if (importMessages(paramSQLiteDatabase)) {
          break;
        }
        i = 1;
        if (importConversations(paramSQLiteDatabase)) {
          break label231;
        }
        j = 1;
        if (importGroups(paramSQLiteDatabase)) {
          break label236;
        }
        k = 1;
        if (importBlackList(paramSQLiteDatabase)) {
          break label242;
        }
        m = 1;
        if (importContacts(paramSQLiteDatabase)) {
          break label248;
        }
        n = 1;
        if (importUnread(paramSQLiteDatabase)) {
          break label254;
        }
        i1 = 1;
        j = 0x0 | i | j | k | m | n | i1;
        EMClient.getInstance().chatManager().loadAllConversations();
        i = j;
        if (j == 0)
        {
          EMLog.d(EMDBManager.f(), "---->finished migrate");
          if (setMigrationDone(paramSQLiteDatabase)) {
            break label260;
          }
          i = 1;
          i |= j;
        }
        if (i == 0) {
          dropDB(paramSQLiteDatabase);
        }
        String str = EMDBManager.f();
        StringBuilder localStringBuilder = new StringBuilder().append("DB migration: ");
        if (i != 0) {
          break label265;
        }
        paramSQLiteDatabase = "success";
        EMLog.d(str, paramSQLiteDatabase);
        EMDBManager.g();
      } while (EMDBManager.b(EMDBManager.a()) == null);
      paramSQLiteDatabase = EMDBManager.b(EMDBManager.a());
      if (i == 0) {}
      for (;;)
      {
        paramSQLiteDatabase.onMigrationFinish(bool);
        return;
        i = 0;
        break;
        label231:
        j = 0;
        break label44;
        label236:
        k = 0;
        break label55;
        label242:
        m = 0;
        break label66;
        label248:
        n = 0;
        break label77;
        label254:
        i1 = 0;
        break label88;
        label260:
        i = 0;
        break label139;
        label265:
        paramSQLiteDatabase = "fail";
        break label180;
        bool = false;
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.w(EMDBManager.f(), "Upgrading from version " + paramInt1 + " to " + paramInt2);
      if (paramInt1 < 2) {
        paramSQLiteDatabase.execSQL("create table unreadcount (username text primary key, count integer);");
      }
      if (paramInt1 < 3)
      {
        paramSQLiteDatabase.execSQL("create table token (username text primary key, value text, saved_time integer);");
        paramSQLiteDatabase.execSQL("create table contact (jid text primary key, username text, nick );");
      }
      if (paramInt1 < 4) {}
      try
      {
        paramSQLiteDatabase.delete("token", "username = ?", new String[] { this.username });
        if (paramInt1 >= 5) {}
      }
      catch (Exception localException2)
      {
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE chat ADD COLUMN isdelivered integer ;");
          EMLog.d(EMDBManager.f(), "db upgrade to vervison 5");
          if (paramInt1 < 6)
          {
            paramSQLiteDatabase.execSQL("create table black_list (username text primary key);");
            paramSQLiteDatabase.execSQL("ALTER TABLE chat ADD COLUMN islistened integer ;");
          }
          if (paramInt1 < 7) {
            paramSQLiteDatabase.execSQL("ALTER TABLE emgroup ADD COLUMN members_size INTEGER ;");
          }
          if (paramInt1 < 8) {
            paramSQLiteDatabase.execSQL("ALTER TABLE emgroup ADD COLUMN isblocked INTEGER ;");
          }
          if (paramInt1 < 9) {
            paramSQLiteDatabase.execSQL("ALTER TABLE emgroup ADD COLUMN max_users INTEGER ;");
          }
          if (paramInt1 < 10)
          {
            paramSQLiteDatabase.execSQL("create table if not exists conversation_list (username text primary key, groupname text, ext text, conversation_type integer);");
            initializeConversation(paramSQLiteDatabase);
            clearContactTable_v10(paramSQLiteDatabase);
            EMDBManager.a(EMDBManager.a(), true);
          }
          if (paramInt1 < 12)
          {
            paramSQLiteDatabase.execSQL("create table chatroom (name text primary key, nick text, owner text, desc text, members_size integer, isblocked integer, members text, max_users integer);");
            if (!EMDBManager.a(EMDBManager.a()).l().equals("dewmobile#kuaiya")) {}
          }
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              paramSQLiteDatabase.execSQL("create table if not exists conversation_list (username text primary key, groupname text, ext text, conversation_type integer);");
              if (!isColumnExist(paramSQLiteDatabase, "conversation_list", "conversation_type")) {
                paramSQLiteDatabase.execSQL("ALTER TABLE conversation_list ADD COLUMN conversation_type INTEGER ;");
              }
              paramSQLiteDatabase.execSQL("ALTER TABLE chat ADD COLUMN msgtype INTEGER ;");
              migrateFrom10To12(paramSQLiteDatabase);
              if (paramInt1 < 13) {
                migrateToOneSDK(paramSQLiteDatabase);
              }
              return;
              localException1 = localException1;
              localException1.printStackTrace();
            }
            localException2 = localException2;
            localException2.printStackTrace();
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              localException3.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onMigrationFinish(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/core/EMDBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */