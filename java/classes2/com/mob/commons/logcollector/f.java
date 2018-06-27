package com.mob.commons.logcollector;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class f
{
  /* Error */
  public static long a(long paramLong, String paramString1, int paramInt, String paramString2)
    throws Throwable
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: invokestatic 14	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore 5
    //   9: iload 5
    //   11: ifeq +12 -> 23
    //   14: ldc2_w 15
    //   17: lstore_0
    //   18: ldc 2
    //   20: monitorexit
    //   21: lload_0
    //   22: lreturn
    //   23: invokestatic 21	com/mob/commons/logcollector/b:a	()Lcom/mob/commons/logcollector/b;
    //   26: astore 6
    //   28: new 23	android/content/ContentValues
    //   31: dup
    //   32: invokespecial 27	android/content/ContentValues:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc 29
    //   41: lload_0
    //   42: invokestatic 35	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 39	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   48: aload 7
    //   50: ldc 41
    //   52: aload_2
    //   53: invokevirtual 47	java/lang/String:toString	()Ljava/lang/String;
    //   56: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 7
    //   61: ldc 52
    //   63: iload_3
    //   64: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 60	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   70: aload 7
    //   72: ldc 62
    //   74: aload 4
    //   76: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 6
    //   81: ldc 64
    //   83: aload 7
    //   85: invokevirtual 67	com/mob/commons/logcollector/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   88: lstore_0
    //   89: goto -71 -> 18
    //   92: astore_2
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramLong	long
    //   0	98	2	paramString1	String
    //   0	98	3	paramInt	int
    //   0	98	4	paramString2	String
    //   7	3	5	bool	boolean
    //   26	54	6	localb	b
    //   35	49	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   3	9	92	finally
    //   23	89	92	finally
  }
  
  public static long a(ArrayList<String> paramArrayList)
    throws Throwable
  {
    long l;
    if (paramArrayList == null) {
      l = 0L;
    }
    for (;;)
    {
      return l;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramArrayList.size())
        {
          localStringBuilder.append("'");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.append("'");
          localStringBuilder.append(",");
          i += 1;
        }
        paramArrayList = localStringBuilder.toString().substring(0, localStringBuilder.length() - 1);
        i = b.a().a("table_exception", "exception_md5 in ( " + paramArrayList + " )", null);
        MobLog.getInstance().i("delete COUNT == %s", new Object[] { Integer.valueOf(i) });
        l = i;
      }
      finally {}
    }
  }
  
  private static ArrayList<e> a(String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      e locale = new e();
      b localb = b.a();
      String str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
      String str1 = str2;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = str2;
        if (paramArrayOfString != null)
        {
          str1 = str2;
          if (paramArrayOfString.length > 0) {
            str1 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + paramString + " group by exception_md5 having max(_id)";
          }
        }
      }
      paramArrayOfString = localb.a(str1, paramArrayOfString);
      do
      {
        paramString = locale;
        if (paramArrayOfString == null) {
          break;
        }
        paramString = locale;
        if (!paramArrayOfString.moveToNext()) {
          break;
        }
        locale.b.add(paramArrayOfString.getString(0));
        paramString = new HashMap();
        paramString.put("type", Integer.valueOf(paramArrayOfString.getInt(1)));
        paramString.put("errat", Long.valueOf(paramArrayOfString.getLong(2)));
        paramString.put("msg", Base64.encodeToString(paramArrayOfString.getString(3).getBytes(), 2));
        paramString.put("times", Integer.valueOf(paramArrayOfString.getInt(4)));
        locale.a.add(paramString);
      } while (locale.b.size() != 50);
      localArrayList.add(locale);
      paramString = new e();
      paramArrayOfString.close();
      if (paramString.b.size() != 0) {
        localArrayList.add(paramString);
      }
      return localArrayList;
    }
    finally {}
  }
  
  public static ArrayList<e> a(String[] paramArrayOfString)
    throws Throwable
  {
    String str = "exception_level = ?";
    if (paramArrayOfString != null) {}
    for (String[] arrayOfString = paramArrayOfString;; arrayOfString = null) {
      try
      {
        if (paramArrayOfString.length > 0)
        {
          if (b.a().a("table_exception") > 0) {}
          for (paramArrayOfString = a(str, arrayOfString);; paramArrayOfString = new ArrayList()) {
            return paramArrayOfString;
          }
        }
        str = null;
      }
      finally {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/logcollector/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */