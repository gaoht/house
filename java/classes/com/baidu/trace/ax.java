package com.baidu.trace;

import com.baidu.trace.c.d;
import com.baidu.trace.c.g;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ax
{
  private static int a = 0;
  private static Map<Short, g> b = null;
  
  protected static void a()
  {
    if (b == null) {
      b = new HashMap();
    }
  }
  
  public static boolean a(DataInputStream paramDataInputStream)
    throws Exception
  {
    byte[] arrayOfByte1 = new byte[1];
    arrayOfByte1[0] = 0;
    int i = 1;
    int j;
    Object localObject1;
    Object localObject2;
    int m;
    byte[] arrayOfByte2;
    while (i != 0) {
      if ((arrayOfByte1[0] == 0) && (paramDataInputStream.read(arrayOfByte1) <= 0))
      {
        i = a + 1;
        a = i;
        if (i >= 10)
        {
          a = 0;
          return false;
        }
      }
      else if (arrayOfByte1[0] != -1)
      {
        j = a + 1;
        a = j;
        if (j >= 10)
        {
          a = 0;
          return false;
        }
      }
      else
      {
        a = 0;
        localObject1 = new byte[4];
        if (paramDataInputStream.read((byte[])localObject1) >= 4) {
          if ("YING".equals(new String((byte[])localObject1)))
          {
            localObject2 = new byte[2];
            if (paramDataInputStream.read((byte[])localObject2) >= 2)
            {
              j = d.a((byte[])localObject2, 0);
              if (j > 2)
              {
                m = (short)(j - 2);
                arrayOfByte2 = new byte[m + 1];
                j = paramDataInputStream.read(arrayOfByte2);
                if (j >= m)
                {
                  if ((j > m) && (arrayOfByte2[m] == -1)) {
                    break label496;
                  }
                  i = 0;
                }
              }
            }
          }
        }
      }
    }
    label496:
    for (;;)
    {
      byte[] arrayOfByte3 = new byte[m + 2 + 4 + 1];
      j = 1;
      arrayOfByte3[0] = arrayOfByte1[0];
      if (i != 0) {
        arrayOfByte1[0] = arrayOfByte2[m];
      }
      for (;;)
      {
        k = 0;
        while (k < localObject1.length)
        {
          arrayOfByte3[j] = localObject1[k];
          k += 1;
          j += 1;
        }
        arrayOfByte1[0] = 0;
      }
      int k = 0;
      while (k < localObject2.length)
      {
        arrayOfByte3[j] = localObject2[k];
        k += 1;
        j += 1;
      }
      k = 0;
      while ((k < arrayOfByte2.length) && (k < m))
      {
        arrayOfByte3[j] = arrayOfByte2[k];
        k += 1;
        j += 1;
      }
      localObject1 = TraceJniInterface.a().parseResponseProtocolData(arrayOfByte3);
      if ((localObject1 == null) || (localObject1.length == 0)) {
        return false;
      }
      localObject1 = new String((byte[])localObject1);
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        short s = (short)((JSONObject)localObject2).getInt("business_id");
        if ((b != null) && (b.containsKey(Short.valueOf(s)))) {
          localObject1 = (g)b.get(Short.valueOf(s));
        }
        for (;;)
        {
          ((g)localObject1).a((JSONObject)localObject2);
          break;
          localObject1 = (g)Class.forName((String)n.a.get(Short.valueOf(s))).newInstance();
          b.put(Short.valueOf(s), localObject1);
        }
        return true;
      }
      catch (Exception paramDataInputStream)
      {
        paramDataInputStream = paramDataInputStream;
        return false;
      }
      finally {}
    }
  }
  
  public static byte[] a(short paramShort, int paramInt)
  {
    StringBuffer localStringBuffer2 = null;
    Object localObject;
    if ((b != null) && (b.containsKey(Short.valueOf(paramShort)))) {
      localObject = (g)b.get(Short.valueOf(paramShort));
    }
    for (;;)
    {
      ((g)localObject).a();
      try
      {
        localObject = TraceJniInterface.a().buildRequestProtocolData(paramShort, paramInt);
        if (localObject != null)
        {
          localStringBuffer2 = new StringBuffer();
          paramInt = 0;
          for (;;)
          {
            if (paramInt < localObject.length)
            {
              localStringBuffer2.append(localObject[paramInt]);
              paramInt += 1;
              continue;
              localObject = (String)n.a.get(Short.valueOf(paramShort));
              try
              {
                localObject = (g)Class.forName((String)localObject).newInstance();
              }
              catch (Exception localException1)
              {
                return null;
              }
            }
          }
        }
        return localException1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          StringBuffer localStringBuffer1 = localStringBuffer2;
        }
      }
    }
  }
  
  protected static void b()
  {
    if (b != null)
    {
      b.clear();
      b = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */