package com.ziroom.ziroomcustomer.findhouse.model;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentSearchHistoryUtil
{
  private static String historyFileName = "/rentSearchHistory";
  private static List<RentSearchHistory> list;
  
  /* Error */
  public static void clearHistory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 24	com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistoryUtil:list	Ljava/util/List;
    //   4: new 26	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 33	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   14: invokevirtual 37	com/ziroom/ziroomcustomer/base/ApplicationEx:getCacheDir	()Ljava/io/File;
    //   17: invokevirtual 43	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 15	com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistoryUtil:historyFileName	Ljava/lang/String;
    //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_0
    //   33: new 52	java/io/FileWriter
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 55	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ldc 57
    //   45: invokevirtual 60	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   48: aload_1
    //   49: invokevirtual 63	java/io/FileWriter:flush	()V
    //   52: aload_1
    //   53: invokevirtual 66	java/io/FileWriter:close	()V
    //   56: return
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 66	java/io/FileWriter:close	()V
    //   68: ldc 68
    //   70: new 26	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   77: ldc 70
    //   79: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokestatic 76	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   86: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 82	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: return
    //   96: astore_1
    //   97: goto -29 -> 68
    //   100: astore_0
    //   101: goto -41 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	6	0	str	String
    //   57	26	0	localIOException1	IOException
    //   100	1	0	localIOException2	IOException
    //   41	24	1	localFileWriter	java.io.FileWriter
    //   96	1	1	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   33	42	57	java/io/IOException
    //   64	68	96	java/io/IOException
    //   42	56	100	java/io/IOException
  }
  
  public static List<RentSearchHistory> getList()
  {
    if ((list == null) || (list.size() < 1)) {
      return queryHistory();
    }
    return list;
  }
  
  private static List<RentSearchHistory> queryHistory()
  {
    Object localObject1 = ApplicationEx.c.getCacheDir().getAbsolutePath();
    Object localObject3 = historyFileName;
    localObject1 = new File((String)localObject1 + "/" + (String)localObject3);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      for (;;)
      {
        try
        {
          localObject3 = new BufferedReader(new FileReader((File)localObject1));
          try
          {
            localObject1 = new StringBuffer();
            String str = ((BufferedReader)localObject3).readLine();
            if (str != null)
            {
              ((StringBuffer)localObject1).append(str);
              continue;
              if (localObject3 == null) {}
            }
          }
          catch (IOException localIOException1) {}
        }
        catch (IOException localIOException2)
        {
          Object localObject2;
          Object localObject4 = null;
          continue;
        }
        try
        {
          ((BufferedReader)localObject3).close();
          u.e("rentSearchHistory", "eror: " + Log.getStackTraceString(localIOException1));
          localObject2 = null;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          try
          {
            localObject2 = a.parseArray((String)localObject2, RentSearchHistory.class);
            if (localObject2 == null) {
              break;
            }
          }
          catch (d locald1)
          {
            localObject2 = null;
            u.e("rentSearchHistory", "error: " + Log.getStackTraceString(locald1));
            continue;
          }
          try
          {
            Collections.sort((List)localObject2);
            return (List<RentSearchHistory>)localObject2;
          }
          catch (d locald2)
          {
            continue;
          }
          localObject2 = ((StringBuffer)localObject2).toString();
        }
        catch (IOException localIOException3) {}
      }
    }
  }
  
  public static void saveHistory(RentSearchHistory paramRentSearchHistory)
  {
    if (paramRentSearchHistory == null) {
      return;
    }
    if (list == null) {
      list = queryHistory();
    }
    if (list == null) {
      list = new ArrayList();
    }
    paramRentSearchHistory = (RentSearchHistory)a.parseObject(a.toJSONString(paramRentSearchHistory), RentSearchHistory.class);
    if (list.size() < 1)
    {
      list.add(paramRentSearchHistory);
      saveToFile();
      return;
    }
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i < list.size())
    {
      RentSearchHistory localRentSearchHistory = (RentSearchHistory)list.get(i);
      if (localRentSearchHistory == null) {}
      do
      {
        i += 1;
        break;
        bool2 = localRentSearchHistory.shouldOverWrite(paramRentSearchHistory);
        bool1 = bool2;
      } while (!bool2);
    }
    if (bool2) {
      list.remove(i);
    }
    for (;;)
    {
      list.add(paramRentSearchHistory);
      saveToFile();
      return;
      if (list.size() >= 5)
      {
        Collections.sort(list);
        list = list.subList(0, 3);
      }
    }
  }
  
  /* Error */
  private static void saveToFile()
  {
    // Byte code:
    //   0: new 26	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 33	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   10: invokevirtual 37	com/ziroom/ziroomcustomer/base/ApplicationEx:getCacheDir	()Ljava/io/File;
    //   13: invokevirtual 43	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: getstatic 15	com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistoryUtil:historyFileName	Ljava/lang/String;
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore_1
    //   29: getstatic 24	com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistoryUtil:list	Ljava/util/List;
    //   32: invokestatic 156	com/alibaba/fastjson/a:toJSONString	(Ljava/lang/Object;)Ljava/lang/String;
    //   35: astore_0
    //   36: new 52	java/io/FileWriter
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 55	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 60	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 63	java/io/FileWriter:flush	()V
    //   54: aload_1
    //   55: invokevirtual 66	java/io/FileWriter:close	()V
    //   58: return
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 66	java/io/FileWriter:close	()V
    //   70: ldc 68
    //   72: new 26	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   79: ldc 70
    //   81: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokestatic 76	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 82	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: return
    //   98: astore_1
    //   99: goto -29 -> 70
    //   102: astore_0
    //   103: goto -41 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	12	0	str	String
    //   59	26	0	localIOException1	IOException
    //   102	1	0	localIOException2	IOException
    //   28	39	1	localObject	Object
    //   98	1	1	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   36	45	59	java/io/IOException
    //   66	70	98	java/io/IOException
    //   45	58	102	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistoryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */