package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static int a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[12];
    int j = 0;
    Object localObject2 = "V{\033;-M`U+!Q4\033 <\025}\033&<\0314\007*<@f\033";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 72;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "Qu\001.";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\\`\034\"-";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "D\000< gq\005 :A\\\020#8Pf";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "D\000< \025}\006o![B\024#!QF\020(!F`\020=-Q";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\025f\020?'G`U,'[`\020!<\0174";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "Tw\001&'[.\007*8Zf\001\016+A}\032!\032Pg\000#<\0259U\"-Fg\024(-|pOo";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\0314\026 ,P.U";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "Xg\022\020;Au\001:;";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "Xg\022\020!Q";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "Gq\006:$A";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "Am\005*";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = 20480;
        return;
        i = 53;
        continue;
        i = 20;
        continue;
        i = 117;
        continue;
        i = 79;
      }
    }
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    a(paramString, paramInt, null, paramContext);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Context paramContext)
  {
    if (!JCoreInterface.isValidRegistered())
    {
      f.a(z[3], z[4]);
      return;
    }
    if (paramContext == null)
    {
      f.c(z[3], z[0]);
      return;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(z[6] + paramString1 + z[7] + paramInt + "-" + j.a(paramInt));
    if (!TextUtils.isEmpty(paramString2)) {
      ((StringBuffer)localObject).append(z[5] + paramString2);
    }
    f.c(z[3], ((StringBuffer)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(z[9], paramString1);
      ((JSONObject)localObject).put(z[10], paramInt);
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put(z[1], paramString2);
      }
      ((JSONObject)localObject).put(z[2], JCoreInterface.getReportTime());
      ((JSONObject)localObject).put(z[11], z[8]);
      JCoreInterface.reportHttpData(paramContext, localObject, d.a);
      return;
    }
    catch (JSONException paramString1) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */