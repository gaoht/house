package com.unionpay.mobile.android.pboctransaction.nfc;

import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
{
  protected static final byte[] d = { 50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49 };
  protected String a = "UnionPay Card";
  com.unionpay.mobile.android.fully.a b;
  b.b c;
  
  public a(com.unionpay.mobile.android.fully.a parama, b.b paramb)
  {
    this.b = parama;
    this.c = paramb;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int k = 1;
    if (paramString1 == null) {
      return null;
    }
    paramString1 = e.a(paramString1);
    int i = 0;
    if (i < paramString1.length) {
      if ((byte)(paramString1[i] & 0x1F) != 31) {
        break label484;
      }
    }
    label474:
    label484:
    for (int j = 2;; j = 1)
    {
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramString1, i, arrayOfByte, 0, j);
      int m;
      if (e.a(arrayOfByte, j).compareToIgnoreCase(paramString2) == 0)
      {
        m = j + i;
        if ((byte)(paramString1[m] & 0x80) != Byte.MIN_VALUE)
        {
          i = paramString1[m] & 0xFF;
          j = k;
        }
      }
      for (;;)
      {
        paramString2 = new byte[i];
        System.arraycopy(paramString1, m + j, paramString2, 0, i);
        return e.a(paramString2, i);
        j = (paramString1[m] & 0x7F) + 1;
        if (j == 2)
        {
          i = paramString1[(m + 1)] & 0xFF;
        }
        else if (j == 3)
        {
          i = (paramString1[(m + 1)] & 0xFF) << 8 | paramString1[(m + 2)] & 0xFF;
        }
        else if (j == 4)
        {
          i = (paramString1[(m + 1)] & 0xFF) << 16 | (paramString1[(m + 2)] & 0xFF) << 8 | paramString1[(m + 3)] & 0xFF;
          continue;
          if ((paramString1[i] & 0x20) == 32)
          {
            j += i;
            if ((j >= paramString1.length) || ((byte)(paramString1[j] & 0x80) != Byte.MIN_VALUE)) {
              break label474;
            }
          }
          for (i = (paramString1[j] & 0x7F) + 1;; i = 1)
          {
            i += j;
            break;
            m = i + j;
            if ((m < paramString1.length) && ((byte)(paramString1[m] & 0x80) == 0))
            {
              i = paramString1[m] & 0xFF;
              j = 1;
              i = i + j + m;
              break;
            }
            if (m < paramString1.length) {}
            for (j = (paramString1[m] & 0x7F) + 1;; j = 0)
            {
              if ((j == 2) && (m + 1 < paramString1.length))
              {
                i = paramString1[(m + 1)] & 0xFF;
                break;
              }
              if ((j == 3) && (m + 2 < paramString1.length))
              {
                i = (paramString1[(m + 1)] & 0xFF) << 8 | paramString1[(m + 2)] & 0xFF;
                break;
              }
              if ((j == 4) && (m + 2 < paramString1.length))
              {
                i = (paramString1[(m + 1)] & 0xFF) << 16 | (paramString1[(m + 2)] & 0xFF) << 8 | paramString1[(m + 3)] & 0xFF;
                break;
                return null;
              }
              i = 0;
              break;
            }
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private static List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return localArrayList;
    }
    paramString = e.a(paramString);
    int i = 0;
    if (i < paramString.length) {
      if ((byte)(paramString[i] & 0x1F) != 31) {
        break label114;
      }
    }
    label114:
    for (int j = 2;; j = 1)
    {
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramString, i, arrayOfByte, 0, j);
      localArrayList.add(e.a(arrayOfByte, j));
      j += i;
      if ((j < paramString.length) && ((byte)(paramString[j] & 0x80) == Byte.MIN_VALUE)) {}
      for (i = (paramString[j] & 0x7F) + 1;; i = 1)
      {
        i += j;
        break;
        return localArrayList;
      }
    }
  }
  
  public static void b(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add("82");
    ((List)localObject).add("9F36");
    ((List)localObject).add("9F10");
    ((List)localObject).add("9F26");
    ((List)localObject).add("5F34");
    ((List)localObject).add("57");
    ((List)localObject).add("9F63");
    int i = 0;
    for (;;)
    {
      try
      {
        String str1;
        if (i < ((List)localObject).size())
        {
          str1 = (String)((List)localObject).get(i);
          String str2 = a(paramString, str1);
          if (str2 != null) {
            paramHashMap.put(str1, str2);
          }
        }
        else
        {
          paramString = new StringBuffer((String)paramHashMap.get("5F34"));
          paramString.insert(0, "0");
          paramHashMap.put("5F34", paramString.toString());
          paramString = (String)paramHashMap.get("57");
          if ((paramString.substring(paramString.length() - 1, paramString.length()).equalsIgnoreCase("f")) || (paramString.substring(paramString.length() - 1, paramString.length()).equalsIgnoreCase("F")))
          {
            paramString = paramString.substring(0, paramString.length() - 1);
            continue;
          }
          paramHashMap.put("TD2", paramString.toString());
          i = paramString.indexOf("D");
          str1 = paramString.substring(0, i);
          if (!str1.endsWith("F"))
          {
            localObject = str1;
            if (!str1.endsWith("f")) {}
          }
          else
          {
            localObject = str1.substring(0, str1.length() - 1);
          }
          paramHashMap.put("AN1", localObject);
          paramHashMap.put("ED", paramString.substring(i + 1, i + 5));
          paramHashMap.put("AMT", paramHashMap.get("9F02"));
          if ((paramHashMap.containsKey("9F10")) && ((byte)(e.a((String)paramHashMap.get("9F10"))[4] & 0x30) == 32)) {
            paramHashMap.put("9F27", "80");
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public final String a()
  {
    Object localObject = this.c.a(d);
    if (!((b.a)localObject).b()) {}
    do
    {
      return null;
      localObject = a(((b.a)localObject).toString(), "4F");
      if (!((String)localObject).startsWith("A000000333")) {
        break;
      }
      localObject = this.c.a(e.a((String)localObject));
    } while (!((b.a)localObject).b());
    return ((b.a)localObject).toString();
    return "noSupUnionpay";
  }
  
  public final String a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = a(paramString, "9F38");
    paramString = new StringBuffer();
    localObject = a((String)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label105;
      }
      String str1 = (String)((Iterator)localObject).next();
      Iterator localIterator = paramHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str1.compareToIgnoreCase(str2) != 0) {
          break;
        }
        paramString.append((String)paramHashMap.get(str2));
      }
    }
    label105:
    paramHashMap = this.c;
    paramString = e.a(paramString.toString());
    localObject = ByteBuffer.allocate(paramString.length + 7);
    ((ByteBuffer)localObject).put((byte)Byte.MIN_VALUE).put((byte)-88).put((byte)0).put((byte)0).put((byte)(paramString.length + 2)).put((byte)-125).put((byte)paramString.length).put(paramString);
    Log.e("PBOC Transceive", b.b.c(((ByteBuffer)localObject).array()));
    paramString = new b.a(paramHashMap.b(((ByteBuffer)localObject).array()));
    Log.e("PBOC receive", b.b.c(paramString.a()));
    if (!paramString.b()) {
      return null;
    }
    paramHashMap = a(paramString.toString(), "9F10");
    if ((!TextUtils.isEmpty(paramHashMap)) && ((byte)(e.a(paramHashMap)[4] & 0x30) != 32)) {
      return null;
    }
    return paramString.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/nfc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */