package com.unionpay.mobile.android.pboctransaction;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.pboctransaction.samsung.f;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.j;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static String a = "A0000003330101010000000000010000";
  public static String b = "A0000003330101020001050001000000";
  private static Date l = new Date(System.currentTimeMillis());
  private static String m = new SimpleDateFormat("yyyyMMddhhmmss").format(l);
  private static HashMap<String, String> o = new HashMap();
  private static d s = null;
  c c;
  a d;
  public boolean e = false;
  private String f = "1.4";
  private byte g = 0;
  private byte h = 0;
  private byte i = 1;
  private boolean j = true;
  private boolean k = true;
  private String n = null;
  private final String p = "A0000003334355502D4D4F42494C45";
  private boolean q = false;
  private String r = "";
  
  public d(c paramc, a parama, String paramString)
  {
    this.f = paramString;
    this.c = paramc;
    this.d = parama;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i3 = 1;
    if (paramString1 == null) {
      return null;
    }
    paramString1 = e.a(paramString1);
    int i1 = 0;
    if (i1 < paramString1.length) {
      if ((byte)(paramString1[i1] & 0x1F) != 31) {
        break label484;
      }
    }
    label474:
    label484:
    for (int i2 = 2;; i2 = 1)
    {
      byte[] arrayOfByte = new byte[i2];
      System.arraycopy(paramString1, i1, arrayOfByte, 0, i2);
      int i4;
      if (e.a(arrayOfByte, i2).compareToIgnoreCase(paramString2) == 0)
      {
        i4 = i2 + i1;
        if ((byte)(paramString1[i4] & 0x80) != Byte.MIN_VALUE)
        {
          i1 = paramString1[i4] & 0xFF;
          i2 = i3;
        }
      }
      for (;;)
      {
        paramString2 = new byte[i1];
        System.arraycopy(paramString1, i4 + i2, paramString2, 0, i1);
        return e.a(paramString2, i1);
        i2 = (paramString1[i4] & 0x7F) + 1;
        if (i2 == 2)
        {
          i1 = paramString1[(i4 + 1)] & 0xFF;
        }
        else if (i2 == 3)
        {
          i1 = (paramString1[(i4 + 1)] & 0xFF) << 8 | paramString1[(i4 + 2)] & 0xFF;
        }
        else if (i2 == 4)
        {
          i1 = (paramString1[(i4 + 1)] & 0xFF) << 16 | (paramString1[(i4 + 2)] & 0xFF) << 8 | paramString1[(i4 + 3)] & 0xFF;
          continue;
          if ((paramString1[i1] & 0x20) == 32)
          {
            i2 += i1;
            if ((i2 >= paramString1.length) || ((byte)(paramString1[i2] & 0x80) != Byte.MIN_VALUE)) {
              break label474;
            }
          }
          for (i1 = (paramString1[i2] & 0x7F) + 1;; i1 = 1)
          {
            i1 += i2;
            break;
            i4 = i1 + i2;
            if ((i4 < paramString1.length) && ((byte)(paramString1[i4] & 0x80) == 0))
            {
              i1 = paramString1[i4] & 0xFF;
              i2 = 1;
              i1 = i1 + i2 + i4;
              break;
            }
            if (i4 < paramString1.length) {}
            for (i2 = (paramString1[i4] & 0x7F) + 1;; i2 = 0)
            {
              if ((i2 == 2) && (i4 + 1 < paramString1.length))
              {
                i1 = paramString1[(i4 + 1)] & 0xFF;
                break;
              }
              if ((i2 == 3) && (i4 + 2 < paramString1.length))
              {
                i1 = (paramString1[(i4 + 1)] & 0xFF) << 8 | paramString1[(i4 + 2)] & 0xFF;
                break;
              }
              if ((i2 == 4) && (i4 + 2 < paramString1.length))
              {
                i1 = (paramString1[(i4 + 1)] & 0xFF) << 16 | (paramString1[(i4 + 2)] & 0xFF) << 8 | paramString1[(i4 + 3)] & 0xFF;
                break;
                return null;
              }
              i1 = 0;
              break;
            }
          }
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toUpperCase().getBytes();
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append(String.format("%02X", new Object[] { Byte.valueOf(paramString[i1]) }));
      i1 += 1;
    }
    i1 = localStringBuffer.length() / 2;
    i2 = localStringBuffer.length() % 2 + i1;
    if (!paramBoolean) {
      if (i2 % 8 == 0) {
        break label180;
      }
    }
    label180:
    for (i1 = 8 - i2 % 8 + i2;; i1 = i2)
    {
      paramString = new byte[i1];
      System.arraycopy(e.a(localStringBuffer.toString()), 0, paramString, 0, i2);
      return e.a(paramString, i1);
      int i3 = i2 + 1;
      i1 = i3;
      if (i3 % 8 != 0) {
        i1 = i3 + (8 - i3 % 8);
      }
      paramString = new byte[i1];
      System.arraycopy(e.a(localStringBuffer.toString()), 0, paramString, 0, i2);
      paramString[i2] = -128;
      return e.a(paramString, i1);
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    int i5 = 0;
    paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] | this.g));
    byte[] arrayOfByte = this.c.a(paramArrayOfByte, this.g);
    int i4;
    int i3;
    Object localObject;
    if (arrayOfByte != null)
    {
      i4 = arrayOfByte.length;
      i3 = i4;
      localObject = arrayOfByte;
      if (i4 >= 2)
      {
        i3 = i4;
        localObject = arrayOfByte;
        if (arrayOfByte[(i4 - 2)] == 97)
        {
          int i1 = arrayOfByte[(i4 - 1)];
          int i2 = this.g;
          localObject = this.c;
          i3 = this.g;
          localObject = ((c)localObject).a(new byte[] { i2, -64, 0, 0, i1 }, i3);
          if (localObject == null) {
            break label253;
          }
          i3 = localObject.length;
        }
      }
      label145:
      if ((i3 < 2) || (localObject[(i3 - 2)] != 108)) {
        break label293;
      }
      paramArrayOfByte[(paramArrayOfByte.length - 1)] = localObject[(i3 - 1)];
      localObject = this.c.a(paramArrayOfByte, this.g);
      paramArrayOfByte = (byte[])localObject;
      i3 = i5;
      if (localObject != null) {
        i3 = localObject.length;
      }
    }
    label253:
    label293:
    for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = (byte[])localObject)
    {
      if ((i3 > 2) && (paramArrayOfByte[(i3 - 2)] == -112) && (paramArrayOfByte[(i3 - 1)] == 0))
      {
        return e.a(paramArrayOfByte, i3 - 2);
        i4 = 0;
        break;
        i3 = 0;
        break label145;
      }
      if ((i3 == 2) && (paramArrayOfByte[(i3 - 2)] == -112) && (paramArrayOfByte[(i3 - 1)] == 0)) {
        return e.a(paramArrayOfByte, 2);
      }
      return null;
    }
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)(paramString.length() / 2));
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + paramString.length() / 2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(e.a(paramString), 0, arrayOfByte, paramArrayOfByte.length, paramString.length() / 2);
    return a(arrayOfByte);
  }
  
  private static void a(String paramString, StringBuffer paramStringBuffer)
  {
    String str = (String)o.get(paramString);
    Object localObject = new byte[1];
    localObject[0] = ((byte)(str.length() / 2));
    localObject = e.a((byte[])localObject, localObject.length);
    paramStringBuffer.append(paramString);
    paramStringBuffer.append((String)localObject);
    paramStringBuffer.append(str);
  }
  
  private String b(String paramString)
  {
    String str = null;
    if ((this.c instanceof f)) {
      str = this.c.a(paramString);
    }
    do
    {
      return str;
      this.g = this.h;
    } while (paramString == null);
    str = e.a(new byte[] { Integer.valueOf(paramString.length() / 2).byteValue() });
    return a(e.a("00a40400" + str + paramString));
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    int i1 = m.length() / 2 + 1;
    byte[] arrayOfByte1 = new byte[i1];
    System.arraycopy(e.a(m), 0, arrayOfByte1, 0, m.length() / 2);
    arrayOfByte1[(i1 - 1)] = Byte.MIN_VALUE;
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)arrayOfByte1.length);
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + arrayOfByte1.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramArrayOfByte.length, arrayOfByte1.length);
    a(arrayOfByte2);
  }
  
  private String c(String paramString)
  {
    String str1;
    Iterator localIterator;
    String str2;
    if ((paramString == null) || ("9000".equals(paramString)))
    {
      paramString = new StringBuffer("80A800000b8309");
      localObject = i("9F7A019F02065F2A02").iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label116;
        }
        str1 = (String)((Iterator)localObject).next();
        localIterator = o.keySet().iterator();
        if (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          if (str1.compareToIgnoreCase(str2) != 0) {
            break;
          }
          paramString.append((String)o.get(str2));
        }
      }
      label116:
      return a(e.a(paramString.toString()));
    }
    j.c("uppay", "test for gongshang version 2");
    Object localObject = new StringBuffer("");
    paramString = a(paramString, "9F38");
    if (TextUtils.isEmpty(paramString))
    {
      paramString = ByteBuffer.allocate(7);
      paramString.put((byte)Byte.MIN_VALUE).put((byte)-88).put((byte)0).put((byte)0).put((byte)2).put((byte)-125).put((byte)0);
      return a(paramString.array());
    }
    paramString = i(paramString).iterator();
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label300;
      }
      str1 = (String)paramString.next();
      localIterator = o.keySet().iterator();
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (str1.compareToIgnoreCase(str2) != 0) {
          break;
        }
        ((StringBuffer)localObject).append((String)o.get(str2));
      }
    }
    label300:
    paramString = e.a(((StringBuffer)localObject).toString());
    localObject = ByteBuffer.allocate(paramString.length + 7);
    ((ByteBuffer)localObject).put((byte)Byte.MIN_VALUE).put((byte)-88).put((byte)0).put((byte)0).put((byte)(paramString.length + 2)).put((byte)-125).put((byte)paramString.length).put(paramString);
    return a(((ByteBuffer)localObject).array());
  }
  
  private String d(String paramString)
  {
    int i2 = 0;
    paramString = a(paramString, "80");
    if (paramString == null) {
      return null;
    }
    o.put("82", paramString.substring(0, 4));
    paramString = e.a(paramString.substring(4));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("5A");
    localArrayList.add("5F34");
    localArrayList.add("9F1F");
    localArrayList.add("57");
    localArrayList.add("5F24");
    localArrayList.add("9F10");
    localArrayList.add("8C");
    localArrayList.add("8D");
    try
    {
      if (i2 < paramString.length)
      {
        byte[] arrayOfByte1 = new byte[5];
        byte[] tmp151_149 = arrayOfByte1;
        tmp151_149[0] = 0;
        byte[] tmp157_151 = tmp151_149;
        tmp157_151[1] = -78;
        byte[] tmp163_157 = tmp157_151;
        tmp163_157[2] = 0;
        byte[] tmp169_163 = tmp163_157;
        tmp169_163[3] = 0;
        byte[] tmp175_169 = tmp169_163;
        tmp175_169[4] = 0;
        tmp175_169;
        byte[] arrayOfByte2 = new byte[4];
        System.arraycopy(paramString, i2, arrayOfByte2, 0, 4);
        int i1 = arrayOfByte2[1];
        label201:
        if (i1 <= arrayOfByte2[2])
        {
          arrayOfByte1[4] = 0;
          arrayOfByte1[3] = ((byte)(arrayOfByte2[0] & 0xFFFFFFF8 | 0x4));
          arrayOfByte1[2] = i1;
          i1 = (byte)(i1 + 1);
          String str1 = a(arrayOfByte1);
          if (str1 != null)
          {
            Iterator localIterator = localArrayList.iterator();
            while (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              String str3 = a(str1, str2);
              if (str3 != null)
              {
                o.put(str2, str3);
                continue;
                return (String)o.get("8C");
              }
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      break label201;
      i2 += 4;
      break;
      paramString = new StringBuffer((String)o.get("5F34"));
      paramString.insert(0, "0");
      o.put("5F34", paramString.toString());
    }
  }
  
  private static void d()
  {
    String str2 = m.substring(2, 8);
    long l1 = new Date(System.currentTimeMillis()).getTime();
    String str1 = String.valueOf(l1);
    if (str1.length() < 8) {}
    for (str1 = String.format("%08d", new Object[] { Long.valueOf(l1) });; str1 = str1.substring(str1.length() - 8, str1.length()))
    {
      o.put("9F26", "");
      o.put("9F27", "80");
      o.put("9F10", "");
      o.put("9F37", str1);
      o.put("9F36", "");
      o.put("95", "0000000800");
      o.put("9A", str2);
      o.put("9C", "45");
      o.put("9F02", "000000000000");
      o.put("5F2A", "0156");
      o.put("82", "");
      o.put("9F1A", "0156");
      o.put("9F03", "000000000000");
      o.put("9F33", "A04000");
      o.put("9F34", "420300");
      o.put("9F35", "34");
      o.put("9F1E", "3030303030303030");
      o.put("84", "");
      o.put("9F09", "0001");
      o.put("9F74", "");
      o.put("9F63", "");
      o.put("9F7A", "01");
      o.put("9F21", m.substring(8));
      o.put("9F4E", "0000000000000000000000000000000000000000");
      o.put("DF31", "0100000000");
      o.put("9F66", "36800000");
      o.put("DF60", "00");
      return;
    }
  }
  
  private String e(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("80AE800034");
    paramString = i(paramString).iterator();
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label103;
      }
      String str1 = (String)paramString.next();
      Iterator localIterator = o.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str1.compareToIgnoreCase(str2) != 0) {
          break;
        }
        localStringBuffer.append((String)o.get(str2));
      }
    }
    label103:
    paramString = a(e.a(localStringBuffer.toString()));
    if (paramString != null)
    {
      o.put("9F27", paramString.substring(4, 6));
      o.put("9F36", paramString.substring(6, 10));
      o.put("9F26", paramString.substring(10, 26));
      o.put("9F10", paramString.substring(26));
    }
    return paramString;
  }
  
  private boolean e()
  {
    for (String str = (String)o.get("5A"); str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f"); str = str.substring(0, str.length() - 1)) {}
    str = f(str);
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("AN1", str);
    str = f("00000001");
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("TID", str);
    str = f((String)o.get("9F02"));
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("AMT", str);
    str = f("156");
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("CUR", str);
    for (str = (String)o.get("57"); (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f")) || (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("F")); str = str.substring(0, str.length() - 1)) {}
    str = f(str);
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("TD2", str);
    if ((o.get("5F24") != null) && (((String)o.get("5F24")).length() == 6))
    {
      str = f(((String)o.get("5F24")).substring(0, 4));
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      o.put("ED", str);
    }
    return true;
  }
  
  private String f()
  {
    this.g = this.i;
    String str = a(new byte[] { 0, -80, -126, 0, 10 });
    if ((str != null) && (str.length() != 0)) {
      o.put("CSN", str);
    }
    this.g = this.h;
    return str;
  }
  
  private String f(String paramString)
  {
    this.g = this.i;
    paramString = a(paramString, false);
    b(new byte[] { -128, 26, 19, 1, 0 });
    paramString = a(new byte[] { -128, -6, 0, 0, 0 }, paramString);
    this.g = this.h;
    return paramString;
  }
  
  private static Bundle g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action_resp_code", "0000");
    return localBundle;
  }
  
  private String g(String paramString)
  {
    int i1 = 0;
    this.g = this.i;
    paramString = String.format("%02d", new Object[] { Integer.valueOf(paramString.length()) }) + paramString;
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    while (i1 < 16 - paramString.length())
    {
      localStringBuffer.append("F");
      i1 += 1;
    }
    b(new byte[] { -128, 26, 20, 1, 0 });
    paramString = localStringBuffer.toString();
    paramString = a(new byte[] { -128, -6, 0, 0, 0 }, paramString);
    if (paramString != null) {
      o.put("PIN", paramString);
    }
    this.g = this.h;
    return paramString;
  }
  
  private String h(String paramString)
  {
    this.g = this.i;
    Object localObject = new byte[5];
    Object tmp13_12 = localObject;
    tmp13_12[0] = -128;
    Object tmp19_13 = tmp13_12;
    tmp19_13[1] = -6;
    Object tmp25_19 = tmp19_13;
    tmp25_19[2] = 1;
    Object tmp31_25 = tmp25_19;
    tmp31_25[3] = 0;
    Object tmp37_31 = tmp31_25;
    tmp37_31[4] = 0;
    tmp37_31;
    paramString = a(paramString, true);
    b(new byte[] { -128, 26, 21, 1, 8 });
    while (paramString.length() > 448)
    {
      localObject[2] = 3;
      a((byte[])localObject, paramString.substring(0, 448).toUpperCase());
      paramString = paramString.substring(448);
    }
    localObject[2] = 1;
    if (Build.VERSION.SDK_INT <= 10) {}
    try
    {
      Thread.sleep(1000L);
      localObject = a((byte[])localObject, paramString);
      j.c("uppay", "encryptMac in resp" + (String)localObject);
      if (localObject != null) {
        o.put("MAC", ((String)localObject).toUpperCase());
      }
      this.g = this.h;
      paramString = (String)localObject;
      if (localObject != null) {
        paramString = ((String)localObject).toUpperCase();
      }
      return paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private static List<String> i(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return localArrayList;
    }
    paramString = e.a(paramString);
    int i1 = 0;
    if (i1 < paramString.length) {
      if ((byte)(paramString[i1] & 0x1F) != 31) {
        break label114;
      }
    }
    label114:
    for (int i2 = 2;; i2 = 1)
    {
      byte[] arrayOfByte = new byte[i2];
      System.arraycopy(paramString, i1, arrayOfByte, 0, i2);
      localArrayList.add(e.a(arrayOfByte, i2));
      i2 += i1;
      if ((i2 < paramString.length) && ((byte)(paramString[i2] & 0x80) == Byte.MIN_VALUE)) {}
      for (i1 = (paramString[i2] & 0x7F) + 1;; i1 = 1)
      {
        i1 += i2;
        break;
        return localArrayList;
      }
    }
  }
  
  /* Error */
  public final Bundle a(int paramInt, String paramString1, HashMap<String, String> paramHashMap, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc -12
    //   4: ldc_w 507
    //   7: invokestatic 251	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: invokestatic 509	com/unionpay/mobile/android/pboctransaction/d:g	()Landroid/os/Bundle;
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   20: invokeinterface 511 1 0
    //   25: aload_0
    //   26: invokevirtual 513	com/unionpay/mobile/android/pboctransaction/d:a	()Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +11 -> 44
    //   36: aload 6
    //   38: invokevirtual 173	java/lang/String:length	()I
    //   41: ifne +28 -> 69
    //   44: aload_0
    //   45: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   48: invokeinterface 515 1 0
    //   53: aload 5
    //   55: ldc_w 466
    //   58: ldc_w 517
    //   61: invokevirtual 472	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: areturn
    //   69: ldc -12
    //   71: new 197	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 519
    //   78: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: getstatic 61	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   84: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 251	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: getstatic 67	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   97: ldc_w 478
    //   100: aload_2
    //   101: invokevirtual 290	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getstatic 67	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   109: ldc_w 478
    //   112: invokevirtual 180	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 127	java/lang/String
    //   118: aload 4
    //   120: invokestatic 524	com/unionpay/mobile/android/utils/PreferenceUtils:decPrefData	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial 526	com/unionpay/mobile/android/pboctransaction/d:g	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +10 -> 138
    //   131: aload_2
    //   132: invokevirtual 173	java/lang/String:length	()I
    //   135: ifne +26 -> 161
    //   138: aload_0
    //   139: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   142: invokeinterface 515 1 0
    //   147: aload 5
    //   149: ldc_w 466
    //   152: ldc_w 517
    //   155: invokevirtual 472	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -94 -> 64
    //   161: ldc -12
    //   163: new 197	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 528
    //   170: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: getstatic 61	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   176: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 251	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   185: pop
    //   186: aload_0
    //   187: iload_1
    //   188: getstatic 61	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   191: invokevirtual 531	com/unionpay/mobile/android/pboctransaction/d:a	(ILjava/lang/String;)Ljava/lang/String;
    //   194: astore_2
    //   195: aload_2
    //   196: ifnull +10 -> 206
    //   199: aload_2
    //   200: invokevirtual 173	java/lang/String:length	()I
    //   203: ifne +26 -> 229
    //   206: aload_0
    //   207: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   210: invokeinterface 515 1 0
    //   215: aload 5
    //   217: ldc_w 466
    //   220: ldc_w 517
    //   223: invokevirtual 472	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: goto -162 -> 64
    //   229: aload_0
    //   230: invokespecial 533	com/unionpay/mobile/android/pboctransaction/d:f	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload 4
    //   237: ifnull +11 -> 248
    //   240: aload 4
    //   242: invokevirtual 173	java/lang/String:length	()I
    //   245: ifne +26 -> 271
    //   248: aload_0
    //   249: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   252: invokeinterface 515 1 0
    //   257: aload 5
    //   259: ldc_w 466
    //   262: ldc_w 517
    //   265: invokevirtual 472	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -204 -> 64
    //   271: aload_2
    //   272: bipush 40
    //   274: bipush 60
    //   276: invokevirtual 287	java/lang/String:substring	(II)Ljava/lang/String;
    //   279: invokestatic 535	com/unionpay/mobile/android/pboctransaction/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 6
    //   284: aload_2
    //   285: bipush 60
    //   287: bipush 100
    //   289: invokevirtual 287	java/lang/String:substring	(II)Ljava/lang/String;
    //   292: astore 7
    //   294: aload_2
    //   295: bipush 100
    //   297: sipush 208
    //   300: invokevirtual 287	java/lang/String:substring	(II)Ljava/lang/String;
    //   303: astore 8
    //   305: aload_2
    //   306: sipush 216
    //   309: sipush 232
    //   312: invokevirtual 287	java/lang/String:substring	(II)Ljava/lang/String;
    //   315: astore 9
    //   317: new 537	org/json/JSONObject
    //   320: dup
    //   321: invokespecial 538	org/json/JSONObject:<init>	()V
    //   324: astore_2
    //   325: aload_2
    //   326: ldc_w 540
    //   329: aload_0
    //   330: getfield 84	com/unionpay/mobile/android/pboctransaction/d:f	Ljava/lang/String;
    //   333: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   336: pop
    //   337: aload_2
    //   338: ldc_w 545
    //   341: ldc_w 547
    //   344: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: new 537	org/json/JSONObject
    //   351: dup
    //   352: invokespecial 538	org/json/JSONObject:<init>	()V
    //   355: astore 4
    //   357: aload_2
    //   358: ldc_w 549
    //   361: aload 4
    //   363: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   366: pop
    //   367: aload 4
    //   369: ldc_w 551
    //   372: ldc_w 553
    //   375: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   378: pop
    //   379: aload 4
    //   381: ldc_w 555
    //   384: ldc_w 557
    //   387: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload 4
    //   393: ldc_w 559
    //   396: ldc_w 561
    //   399: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload 4
    //   405: ldc_w 563
    //   408: ldc_w 557
    //   411: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload 4
    //   417: ldc_w 565
    //   420: aload 7
    //   422: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   425: pop
    //   426: aload 4
    //   428: ldc_w 567
    //   431: aload 8
    //   433: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   436: pop
    //   437: aload 4
    //   439: ldc_w 569
    //   442: getstatic 67	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   445: ldc_w 449
    //   448: invokevirtual 180	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   454: pop
    //   455: aload 4
    //   457: ldc_w 571
    //   460: getstatic 61	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   463: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload 4
    //   469: ldc_w 573
    //   472: ldc_w 575
    //   475: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload 4
    //   481: ldc_w 577
    //   484: getstatic 67	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   487: ldc_w 478
    //   490: invokevirtual 180	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   493: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   496: pop
    //   497: aload 4
    //   499: ldc_w 579
    //   502: aload 6
    //   504: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   507: pop
    //   508: aload 4
    //   510: ldc_w 581
    //   513: aload 9
    //   515: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   518: pop
    //   519: aload 4
    //   521: ldc_w 583
    //   524: ldc_w 557
    //   527: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload_3
    //   532: ifnull +154 -> 686
    //   535: aload_3
    //   536: invokevirtual 239	java/util/HashMap:keySet	()Ljava/util/Set;
    //   539: ifnull +147 -> 686
    //   542: aload_3
    //   543: invokevirtual 239	java/util/HashMap:keySet	()Ljava/util/Set;
    //   546: invokeinterface 586 1 0
    //   551: ifle +135 -> 686
    //   554: aload_3
    //   555: ldc_w 579
    //   558: invokevirtual 589	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   561: pop
    //   562: aload_3
    //   563: ldc_w 577
    //   566: invokevirtual 589	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   569: pop
    //   570: aload_3
    //   571: invokevirtual 239	java/util/HashMap:keySet	()Ljava/util/Set;
    //   574: invokeinterface 242 1 0
    //   579: astore 6
    //   581: aload 6
    //   583: invokeinterface 231 1 0
    //   588: ifeq +98 -> 686
    //   591: aload 6
    //   593: invokeinterface 235 1 0
    //   598: checkcast 127	java/lang/String
    //   601: astore 7
    //   603: aload 4
    //   605: aload 7
    //   607: aload_3
    //   608: aload 7
    //   610: invokevirtual 180	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   613: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   616: pop
    //   617: goto -36 -> 581
    //   620: astore_2
    //   621: aload_2
    //   622: invokevirtual 590	org/json/JSONException:printStackTrace	()V
    //   625: ldc 106
    //   627: astore_2
    //   628: ldc -12
    //   630: new 197	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 592
    //   637: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: getstatic 61	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   643: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 251	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   652: pop
    //   653: aload 5
    //   655: ldc_w 594
    //   658: aload_0
    //   659: getfield 112	com/unionpay/mobile/android/pboctransaction/d:d	Lcom/unionpay/mobile/android/fully/a;
    //   662: aload_2
    //   663: invokeinterface 597 2 0
    //   668: invokevirtual 472	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload_0
    //   672: getfield 110	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   675: invokeinterface 515 1 0
    //   680: invokestatic 599	com/unionpay/mobile/android/pboctransaction/d:d	()V
    //   683: goto -619 -> 64
    //   686: aload_2
    //   687: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   690: astore_2
    //   691: goto -63 -> 628
    //   694: astore_2
    //   695: aload_0
    //   696: monitorexit
    //   697: aload_2
    //   698: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	d
    //   0	699	1	paramInt	int
    //   0	699	2	paramString1	String
    //   0	699	3	paramHashMap	HashMap<String, String>
    //   0	699	4	paramString2	String
    //   14	640	5	localBundle	Bundle
    //   29	563	6	localObject	Object
    //   292	317	7	str1	String
    //   303	129	8	str2	String
    //   315	199	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   317	531	620	org/json/JSONException
    //   535	581	620	org/json/JSONException
    //   581	617	620	org/json/JSONException
    //   686	691	620	org/json/JSONException
    //   2	31	694	finally
    //   36	44	694	finally
    //   44	64	694	finally
    //   69	127	694	finally
    //   131	138	694	finally
    //   138	158	694	finally
    //   161	195	694	finally
    //   199	206	694	finally
    //   206	226	694	finally
    //   229	235	694	finally
    //   240	248	694	finally
    //   248	268	694	finally
    //   271	317	694	finally
    //   317	531	694	finally
    //   535	581	694	finally
    //   581	617	694	finally
    //   621	625	694	finally
    //   628	683	694	finally
    //   686	691	694	finally
  }
  
  public final Bundle a(AppIdentification paramAppIdentification, String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString3)
  {
    for (;;)
    {
      try
      {
        this.c.b();
        j.c("uppay", "startPBOCPurchase() +++");
        d();
        o.put("PIN", paramString1);
        o.put("9F02", paramHashMap1.get("trans_amt"));
        o.put("9F1A", "0156");
        o.put("5F2A", paramHashMap1.get("trans currcy code"));
        o.put("9C", paramHashMap1.get("trans_type"));
        paramString1 = paramAppIdentification.a();
        if (!paramString1.startsWith("A000000333"))
        {
          this.c.c();
          paramAppIdentification = g();
          paramAppIdentification.putString("action_resp_code", "10019");
          return paramAppIdentification;
        }
        paramAppIdentification = g();
        l = new Date(System.currentTimeMillis());
        m = new SimpleDateFormat("yyyyMMddHHmmss").format(l);
        this.n = new String(m);
        j.c("uppay", "selectUPCard");
        paramHashMap1 = a();
        j.c("uppay", "selectUPCard return: " + paramHashMap1);
        if ((paramHashMap1 == null) || (paramHashMap1.length() == 0))
        {
          paramAppIdentification.putString("action_resp_code", "10019");
          if (paramAppIdentification.getString("action_resp_code") == "0000") {
            break label594;
          }
          this.c.c();
          continue;
        }
        j.c("uppay", "selectPBOC");
        paramString1 = b(paramString1);
        j.c("uppay", "selectPBOC return: " + paramString1);
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramAppIdentification.putString("action_resp_code", "10019");
          continue;
        }
        j.c("uppay", "GPO");
      }
      finally {}
      paramString1 = c(paramString1);
      j.c("uppay", "gpo return: " + paramString1);
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        paramAppIdentification.putString("action_resp_code", "10020");
      }
      else
      {
        j.c("uppay", "CDOL1");
        paramString1 = d(paramString1);
        j.c("uppay", "CDOL1 return: " + paramString1);
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramAppIdentification.putString("action_resp_code", "10019");
        }
        else
        {
          j.c("uppay", "GAC1");
          paramString1 = e(paramString1);
          j.c("uppay", "GAC1 return: " + paramString1);
          if ((paramString1 == null) || (paramString1.length() == 0))
          {
            paramAppIdentification.putString("action_resp_code", "10019");
          }
          else
          {
            j.c("uppay", "csn");
            paramString1 = f();
            j.c("uppay", "csn return: " + paramString1);
            if ((paramString1 == null) || (paramString1.length() == 0))
            {
              paramAppIdentification.putString("action_resp_code", "10019");
              continue;
              label594:
              j.c("uppay", "encryptPIN");
              paramString1 = g(PreferenceUtils.decPrefData((String)o.get("PIN"), paramString3));
              j.c("uppay", "encryptPIN return:" + paramString1);
              if ((paramString1 == null) || (paramString1.length() == 0))
              {
                this.c.c();
                paramAppIdentification.putString("action_resp_code", "10019");
              }
              else
              {
                j.c("uppay", "encryptData");
                if (!e())
                {
                  j.c("uppay", "encryptData false");
                  this.c.c();
                  paramAppIdentification.putString("action_resp_code", "10019");
                }
                else
                {
                  j.c("uppay", "initDCData");
                  paramString1 = new StringBuffer();
                  a("9F26", paramString1);
                  a("9F27", paramString1);
                  a("9F10", paramString1);
                  a("9F37", paramString1);
                  a("9F36", paramString1);
                  a("95", paramString1);
                  a("9A", paramString1);
                  a("9C", paramString1);
                  a("9F02", paramString1);
                  a("5F2A", paramString1);
                  a("82", paramString1);
                  a("9F1A", paramString1);
                  a("9F03", paramString1);
                  a("9F33", paramString1);
                  a("9F34", paramString1);
                  a("9F35", paramString1);
                  a("9F1E", paramString1);
                  paramString1 = paramString1.toString();
                  o.put("DCD", paramString1);
                  if ((o.get("TID") != null) && (o.get("AMT") != null) && (o.get("CUR") != null) && (o.get("AN1") != null) && (o.get("CSN") != null) && (o.get("5F34") != null)) {
                    break;
                  }
                  this.c.c();
                  paramAppIdentification.putString("action_resp_code", "10019");
                }
              }
            }
          }
        }
      }
    }
    paramHashMap1 = new ArrayList();
    paramHashMap1.add(m);
    if (o.get("TID") != null) {
      paramHashMap1.add(o.get("TID"));
    }
    if (o.get("AMT") != null) {
      paramHashMap1.add(o.get("AMT"));
    }
    if (o.get("CUR") != null) {
      paramHashMap1.add(o.get("CUR"));
    }
    if (o.get("AN1") != null) {
      paramHashMap1.add(o.get("AN1"));
    }
    o.put("AN1", e.c((String)o.get("5A")));
    if (o.get("CSN") != null) {
      paramHashMap1.add(o.get("CSN"));
    }
    if ((this.q) && (o.get("ED") != null)) {
      paramHashMap1.add(o.get("ED"));
    }
    if (o.get("5F34") != null) {
      paramHashMap1.add(o.get("5F34"));
    }
    if (o.get("DCD") != null) {
      paramHashMap1.add(o.get("DCD"));
    }
    paramString1 = "";
    paramHashMap1 = paramHashMap1.iterator();
    for (;;)
    {
      if (paramHashMap1.hasNext())
      {
        paramString3 = (String)paramHashMap1.next();
        if (paramString3 != null) {
          paramString1 = paramString1 + paramString3 + " ";
        }
      }
      else
      {
        paramString1 = paramString1.trim();
        j.c("uppay", "encryptMac");
        paramString1 = h(paramString1);
        j.c("uppay", "encryptMac result" + paramString1);
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          this.c.c();
          paramAppIdentification.putString("action_resp_code", "10019");
          break;
        }
        for (;;)
        {
          try
          {
            paramHashMap1 = new JSONObject();
            paramHashMap1.put("v", this.f);
            paramHashMap1.put("cmd", "pay");
            paramString3 = new JSONObject();
            paramHashMap1.put("params", paramString3);
            paramString3.put("pay_type", "2");
            paramString3.put("pay_mode", "1");
            paramString3.put("bind", "no");
            paramString3.put("carrier_tp", paramString2);
            paramString3.put("icc_data", o.get("DCD"));
            paramString3.put("csn", o.get("CSN"));
            if (o.get("5F34") != null)
            {
              paramString1 = (String)o.get("5F34");
              paramString3.put("card_seq_id", paramString1);
              paramString3.put("submit_time", m);
              paramString3.put("sp_id", "8889");
              paramString3.put("pin", o.get("PIN"));
              paramString3.put("pan", o.get("AN1"));
              paramString3.put("carrier_app_tp", "2");
              if (o.get("ED") != null) {
                paramString3.put("expire", o.get("ED"));
              }
              if (o.get("TD2") != null) {
                paramString3.put("track2_data", o.get("TD2"));
              }
              if ((paramHashMap2 == null) || (paramHashMap2.keySet() == null) || (paramHashMap2.keySet().size() <= 0)) {
                break label1804;
              }
              paramHashMap2.remove("pan");
              paramHashMap2.remove("pin");
              paramString1 = paramHashMap2.keySet().iterator();
              if (!paramString1.hasNext()) {
                break label1804;
              }
              paramString2 = (String)paramString1.next();
              paramString3.put(paramString2, paramHashMap2.get(paramString2));
              continue;
            }
          }
          catch (JSONException paramString1)
          {
            this.c.c();
            paramAppIdentification.putString("action_resp_code", "10019");
          }
          paramString1 = "";
        }
        label1804:
        paramString1 = paramHashMap1.toString();
        j.c("uppay", paramString1);
        paramAppIdentification.putString("action_resp_message", this.d.a(paramString1));
        this.c.c();
        d();
        break;
      }
    }
  }
  
  public final String a()
  {
    if ((this.c instanceof f)) {
      return this.c.a("A0000003334355502D4D4F42494C45");
    }
    this.g = this.i;
    return a(new byte[] { 0, -92, 4, 0, 15, -96, 0, 0, 3, 51, 67, 85, 80, 45, 77, 79, 66, 73, 76, 69 });
  }
  
  public final String a(int paramInt, String paramString)
  {
    this.g = this.i;
    if (Integer.toHexString(paramInt).length() == 1) {}
    for (String str = "0" + Integer.toHexString(paramInt);; str = Integer.toHexString(paramInt)) {
      return a(e.a("80F802" + str + "08" + paramString + "80"));
    }
  }
  
  /* Error */
  public final String a(AppIdentification paramAppIdentification)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 613	com/unionpay/mobile/android/pboctransaction/AppIdentification:a	()Ljava/lang/String;
    //   8: astore_1
    //   9: invokestatic 599	com/unionpay/mobile/android/pboctransaction/d:d	()V
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 632	com/unionpay/mobile/android/pboctransaction/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: aload_0
    //   19: aconst_null
    //   20: invokespecial 637	com/unionpay/mobile/android/pboctransaction/d:c	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_3
    //   26: astore_1
    //   27: aload 4
    //   29: ifnull +15 -> 44
    //   32: aload 4
    //   34: invokevirtual 173	java/lang/String:length	()I
    //   37: istore_2
    //   38: iload_2
    //   39: ifne +9 -> 48
    //   42: aload_3
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_0
    //   49: aload 4
    //   51: invokespecial 645	com/unionpay/mobile/android/pboctransaction/d:d	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload_3
    //   57: astore_1
    //   58: aload 4
    //   60: ifnull -16 -> 44
    //   63: aload_3
    //   64: astore_1
    //   65: aload 4
    //   67: invokevirtual 173	java/lang/String:length	()I
    //   70: ifeq -26 -> 44
    //   73: getstatic 67	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   76: ldc_w 298
    //   79: invokevirtual 180	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 127	java/lang/String
    //   85: astore_1
    //   86: goto -42 -> 44
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	d
    //   0	94	1	paramAppIdentification	AppIdentification
    //   37	2	2	i1	int
    //   1	63	3	localObject	Object
    //   23	43	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	25	89	finally
    //   32	38	89	finally
    //   48	56	89	finally
    //   65	86	89	finally
  }
  
  public final String a(String paramString)
  {
    this.c.d();
    paramString = b(paramString);
    this.c.d();
    return a(paramString, "84");
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> b()
  {
    this.c.d();
    this.c.b();
    ArrayList localArrayList = this.c.a(this);
    this.c.c();
    return localArrayList;
  }
  
  public final String c()
  {
    this.g = this.i;
    return a(e.a("80F2000102"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */