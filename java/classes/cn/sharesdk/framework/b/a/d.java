package cn.sharesdk.framework.b.a;

import android.database.Cursor;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import java.util.ArrayList;

public class d
{
  /* Error */
  public static long a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: invokevirtual 12	java/lang/String:trim	()Ljava/lang/String;
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 14
    //   15: if_acmpne +12 -> 27
    //   18: ldc2_w 15
    //   21: lstore_1
    //   22: ldc 2
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: invokestatic 21	cn/sharesdk/framework/b/a/b:a	()Lcn/sharesdk/framework/b/a/b;
    //   30: astore_3
    //   31: new 23	android/content/ContentValues
    //   34: dup
    //   35: invokespecial 27	android/content/ContentValues:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: ldc 29
    //   44: lload_1
    //   45: invokestatic 35	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokevirtual 39	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   51: aload 4
    //   53: ldc 41
    //   55: aload_0
    //   56: invokevirtual 44	java/lang/String:toString	()Ljava/lang/String;
    //   59: invokevirtual 47	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_3
    //   63: ldc 49
    //   65: aload 4
    //   67: invokevirtual 52	cn/sharesdk/framework/b/a/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   70: lstore_1
    //   71: goto -49 -> 22
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramString	String
    //   0	80	1	paramLong	long
    //   11	52	3	localObject	Object
    //   38	28	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   7	12	74	finally
    //   27	71	74	finally
  }
  
  public static long a(ArrayList<String> paramArrayList)
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
        i = b.a().a("message", "_id in ( " + paramArrayList + " )", null);
        e.b().i("delete COUNT == %s", new Object[] { Integer.valueOf(i) });
        l = i;
      }
      finally {}
    }
  }
  
  /* Error */
  public static ArrayList<c> a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 21	cn/sharesdk/framework/b/a/b:a	()Lcn/sharesdk/framework/b/a/b;
    //   6: ldc 49
    //   8: invokevirtual 115	cn/sharesdk/framework/b/a/b:a	(Ljava/lang/String;)I
    //   11: ifle +14 -> 25
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokestatic 118	cn/sharesdk/framework/b/a/d:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: new 59	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 119	java/util/ArrayList:<init>	()V
    //   32: astore_0
    //   33: goto -13 -> 20
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	14	0	localArrayList	ArrayList
    //   36	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	20	36	finally
    //   25	33	36	finally
  }
  
  private static ArrayList<c> a(String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList;
    Cursor localCursor;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        c localc = new c();
        StringBuilder localStringBuilder = new StringBuilder();
        localCursor = b.a().a("message", new String[] { "_id", "post_time", "message_data" }, paramString, paramArrayOfString, null);
        paramString = localStringBuilder;
        paramArrayOfString = localc;
        if ((localCursor == null) || (!localCursor.moveToNext())) {
          break;
        }
        paramArrayOfString.b.add(localCursor.getString(0));
        if (paramArrayOfString.b.size() == 100)
        {
          paramString.append(localCursor.getString(2));
          paramArrayOfString.a = paramString.toString();
          localArrayList.add(paramArrayOfString);
          paramArrayOfString = new c();
          paramString = new StringBuilder();
        }
        else
        {
          paramString.append(localCursor.getString(2) + "\n");
        }
      }
      finally {}
    }
    localCursor.close();
    if (paramArrayOfString.b.size() != 0)
    {
      paramArrayOfString.a = paramString.toString().substring(0, paramString.length() - 1);
      localArrayList.add(paramArrayOfString);
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */