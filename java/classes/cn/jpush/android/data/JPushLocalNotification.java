package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.c.f;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class JPushLocalNotification
  implements Serializable
{
  private static final String[] z;
  private int a = 1;
  private String b = "";
  private String c = z[0];
  private String d = z[0];
  private long e = 0L;
  private String f;
  private String g;
  private String h;
  private long i;
  private long j = 1L;
  private int k = 1;
  private String l = "";
  private String m = "";
  
  static
  {
    String[] arrayOfString = new String[15];
    int i1 = 0;
    Object localObject2 = "S@";
    int n = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i2 = arrayOfChar.length;
    int i5 = 0;
    int i3 = 0;
    int i7 = n;
    localObject2 = arrayOfChar;
    int i8 = i1;
    Object localObject3 = localObject1;
    int i4 = i2;
    Object localObject4;
    int i6;
    if (i2 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i6 = n;
      label68:
      i4 = i3;
      label71:
      localObject2 = localObject1;
      i5 = localObject2[i3];
      switch (i4 % 5)
      {
      default: 
        n = 74;
      }
    }
    for (;;)
    {
      localObject2[i3] = ((char)(n ^ i5));
      i4 += 1;
      if (i2 == 0)
      {
        i3 = i2;
        break label71;
      }
      i5 = i4;
      i4 = i2;
      localObject3 = localObject4;
      i8 = i1;
      localObject2 = localObject1;
      i7 = i6;
      i6 = i7;
      localObject1 = localObject2;
      i1 = i8;
      localObject4 = localObject3;
      i2 = i4;
      i3 = i5;
      if (i4 > i5) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i7)
      {
      default: 
        localObject3[i8] = localObject1;
        i1 = 1;
        localObject2 = "\r/\037\n#\017\024\030\r\025\n\024";
        n = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i8] = localObject1;
        i1 = 2;
        localObject2 = "\r\037\t\026,\n\023\034\026%\r/\t\006:\006";
        n = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i8] = localObject1;
        i1 = 3;
        localObject2 = "\000\037\023\013/\r\004\"\0133\023\025";
        n = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i8] = localObject1;
        i1 = 4;
        localObject2 = "\r/\t\026>\017\025";
        n = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i8] = localObject1;
        i1 = 5;
        localObject2 = "\r/\022\021&\032";
        n = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i8] = localObject1;
        i1 = 6;
        localObject2 = "\002\024\"\013";
        n = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i8] = localObject1;
        i1 = 7;
        localObject2 = "\020\030\022\b\025\027\t\r\032";
        n = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i8] = localObject1;
        i1 = 8;
        localObject2 = "\r/\036\020$\027\025\023\013";
        n = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i8] = localObject1;
        i1 = 9;
        localObject2 = "\016/\036\020$\027\025\023\013";
        n = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i8] = localObject1;
        i1 = 10;
        localObject2 = "\r/\030\007>\021\021\016";
        n = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i8] = localObject1;
        i1 = 11;
        localObject2 = "\f\006\030\r8\n\024\030 '\020\027\"\026.";
        n = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i8] = localObject1;
        i1 = 12;
        localObject2 = "\016\003\032 #\007";
        n = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i8] = localObject1;
        i1 = 13;
        localObject2 = "0\025\t_>\n\035\030_,\002\031\021^j3\034\030\0369\006P\036\027/\000\033]\006%\026\002]\0368\004\003\\";
        n = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i8] = localObject1;
        i1 = 14;
        localObject2 = ") \b\f\"/\037\036\036&-\037\t\026,\n\023\034\013#\f\036";
        n = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i8] = localObject1;
        z = arrayOfString;
        return;
        n = 99;
        continue;
        n = 112;
        continue;
        n = 125;
        continue;
        n = 127;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (JPushLocalNotification)paramObject;
    } while (this.j == ((JPushLocalNotification)paramObject).j);
    return false;
  }
  
  public long getBroadcastTime()
  {
    return this.e;
  }
  
  public long getBuilderId()
  {
    return this.i;
  }
  
  public String getContent()
  {
    return this.f;
  }
  
  public String getExtras()
  {
    return this.h;
  }
  
  public long getNotificationId()
  {
    return this.j;
  }
  
  public String getTitle()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    return (int)(this.j ^ this.j >>> 32);
  }
  
  public void setBroadcastTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 > 12) || (paramInt3 <= 0) || (paramInt3 > 31) || (paramInt4 < 0) || (paramInt4 > 23) || (paramInt5 < 0) || (paramInt5 > 59) || (paramInt6 < 0) || (paramInt6 > 59))
    {
      f.j(z[14], z[13]);
      return;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, paramInt5, paramInt6);
    localObject = ((Calendar)localObject).getTime();
    long l1 = System.currentTimeMillis();
    if (((Date)localObject).getTime() < l1)
    {
      this.e = l1;
      return;
    }
    this.e = ((Date)localObject).getTime();
  }
  
  public void setBroadcastTime(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setBroadcastTime(Date paramDate)
  {
    this.e = paramDate.getTime();
  }
  
  public void setBuilderId(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void setContent(String paramString)
  {
    this.f = paramString;
  }
  
  public void setExtras(String paramString)
  {
    this.h = paramString;
  }
  
  public void setNotificationId(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.g = paramString;
  }
  
  public String toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (!TextUtils.isEmpty(this.h))
      {
        JSONObject localJSONObject3 = new JSONObject(this.h);
        localJSONObject2.put(z[10], localJSONObject3);
      }
      a(z[8], this.f, localJSONObject2);
      a(z[4], this.g, localJSONObject2);
      a(z[8], this.f, localJSONObject2);
      localJSONObject2.put(z[6], 0);
      localJSONObject1.put(z[9], localJSONObject2);
      a(z[12], this.j, localJSONObject1);
      a(z[3], this.m, localJSONObject1);
      a(z[11], this.l, localJSONObject1);
      localJSONObject1.put(z[5], this.k);
      localJSONObject1.put(z[1], this.i);
      localJSONObject1.put(z[7], 3);
      localJSONObject1.put(z[2], 1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject1.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/JPushLocalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */