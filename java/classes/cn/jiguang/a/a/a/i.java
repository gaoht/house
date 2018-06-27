package cn.jiguang.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.c.d.l;
import cn.jiguang.f.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends d
{
  public static String b;
  public static boolean c;
  public static boolean d;
  private static final String[] z;
  private Context e;
  private String f;
  private boolean g;
  private String h = null;
  private String i = null;
  private String j = null;
  
  static
  {
    String[] arrayOfString = new String[34];
    int m = 0;
    Object localObject2 = "|1D\n";
    int k = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int n = arrayOfChar.length;
    int i3 = 0;
    int i1 = 0;
    int i5 = k;
    localObject2 = arrayOfChar;
    int i6 = m;
    Object localObject3 = localObject1;
    int i2 = n;
    Object localObject4;
    int i4;
    if (n <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i4 = k;
      label68:
      i2 = i1;
      label71:
      localObject2 = localObject1;
      i3 = localObject2[i1];
      switch (i2 % 5)
      {
      default: 
        k = 62;
      }
    }
    for (;;)
    {
      localObject2[i1] = ((char)(k ^ i3));
      i2 += 1;
      if (n == 0)
      {
        i1 = n;
        break label71;
      }
      i3 = i2;
      i2 = n;
      localObject3 = localObject4;
      i6 = m;
      localObject2 = localObject1;
      i5 = i4;
      i4 = i5;
      localObject1 = localObject2;
      m = i6;
      localObject4 = localObject3;
      n = i2;
      i1 = i3;
      if (i2 > i3) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i5)
      {
      default: 
        localObject3[i6] = localObject1;
        m = 1;
        localObject2 = "l'A\002\036k-\r\000Q{bN\006_a%H\n";
        k = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i6] = localObject1;
        m = 2;
        localObject2 = "B;a\001]n6D\001PB#C\017Yj0";
        k = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i6] = localObject1;
        m = 3;
        localObject2 = "e2X\035VP.O\035af,K\001\020e1B\000";
        k = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i6] = localObject1;
        m = 4;
        localObject2 = "c-N1If$D";
        k = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i6] = localObject1;
        m = 5;
        localObject2 = "X+K\007\036c'C\tJgx\r";
        k = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i6] = localObject1;
        m = 6;
        localObject2 = "z,H\026Nj!Y\013Z/-CNRm1\r\034[-_\032n}']\017Lj";
        k = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i6] = localObject1;
        m = 7;
        localObject2 = "l-C\032[a6";
        k = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i6] = localObject1;
        m = 8;
        localObject2 = "c-N1Y1";
        k = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i6] = localObject1;
        m = 9;
        localObject2 = "c ^CWa$BNR`%\r\rRj#_NMz!N\013[k";
        k = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i6] = localObject1;
        m = 10;
        localObject2 = "{;]\013";
        k = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i6] = localObject1;
        m = 11;
        localObject2 = "c-N\017RP&C\035";
        k = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i6] = localObject1;
        m = 12;
        localObject2 = "x+K\007j`5H\034\0365";
        k = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i6] = localObject1;
        m = 13;
        localObject2 = "f6D\003[";
        k = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i6] = localObject1;
        m = 14;
        localObject2 = "l'A\002";
        k = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i6] = localObject1;
        m = 15;
        localObject2 = "k'A\013JjbK\007Rjb^\033]l'^\035\022/$D\002[a#@\013\004e2X\035VP.O\035af,K\001\020e1B\000";
        k = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i6] = localObject1;
        m = 16;
        localObject2 = "n.A";
        k = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i6] = localObject1;
        m = 17;
        localObject2 = "N.ANQibA\001]n6D\001P/+C\bQ/5L\035\036a7A\002\022/%D\030[/7]NLj2B\034J";
        k = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i6] = localObject1;
        m = 18;
        localObject2 = "k'A\013JjbK\007RjbK\017Wc'IB\036i+A\013Pn/HTT7^\006ac ^1Wa$B@T|-C";
        k = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i6] = localObject1;
        m = 19;
        localObject2 = "C-N\032W`,\r\000Q{bN\006_a%H\n\022/%D\030[/7]NLj2B\034J";
        k = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i6] = localObject1;
        m = 20;
        localObject2 = "l'A\002j`5C\013L/x";
        k = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i6] = localObject1;
        m = 21;
        localObject2 = "c-N1]j.A";
        k = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i6] = localObject1;
        m = 22;
        localObject2 = "x+K\007";
        k = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i6] = localObject1;
        m = 23;
        localObject2 = "c-N1Wa$B";
        k = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i6] = localObject1;
        m = 24;
        localObject2 = "c#^\032a}']\001L{\035A\001]n6D\001P";
        k = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i6] = localObject1;
        m = 25;
        localObject2 = "h2^";
        k = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i6] = localObject1;
        m = 26;
        localObject2 = "x+K\007a{-Z\013L|";
        k = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i6] = localObject1;
        m = 27;
        localObject2 = "H'YN[}0B\034\036c-NNWa$B";
        k = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i6] = localObject1;
        m = 28;
        localObject2 = "c ^1Lj2B\034JP,B\031";
        k = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i6] = localObject1;
        m = 29;
        localObject2 = "a'Y\031Q})r\032G'";
        k = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i6] = localObject1;
        m = 30;
        localObject2 = "l'A\002a{-Z\013L|";
        k = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i6] = localObject1;
        m = 31;
        localObject2 = "h2^/Zk0H\035M5";
        k = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i6] = localObject1;
        m = 32;
        localObject2 = "C-N\017Jf-CT\036";
        k = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i6] = localObject1;
        m = 33;
        localObject2 = ",7C\013Fl']\032[kb\000N]`,Y\013F{bZ\017M/,X\002R";
        k = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i6] = localObject1;
        z = arrayOfString;
        b = z[16];
        c = false;
        d = false;
        return;
        k = 15;
        continue;
        k = 66;
        continue;
        k = 45;
        continue;
        k = 110;
      }
    }
  }
  
  public i(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, paramString, paramBoolean2);
    this.e = paramContext;
    this.f = paramString;
    this.g = true;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      cn.jiguang.d.d.g(z[2], z[33]);
      return;
    }
    new j(paramContext).start();
  }
  
  private boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, String paramString)
  {
    if (h.a(paramString))
    {
      if (!h.a(this.j)) {
        return false;
      }
    }
    else if (!paramString.equals(this.j)) {
      return false;
    }
    if (h.a(this.i))
    {
      if ((paramJSONArray2 != null) && (paramJSONArray2.length() != 0)) {
        return false;
      }
    }
    else
    {
      if (paramJSONArray2 == null) {
        return false;
      }
      if (paramJSONArray2.length() == 0) {
        return false;
      }
      if (!this.i.equals(paramJSONArray2.toString())) {
        return false;
      }
      cn.jiguang.d.d.e(z[2], z[1]);
    }
    if (h.a(this.h))
    {
      if ((paramJSONArray1 != null) && (paramJSONArray1.length() != 0)) {
        return false;
      }
    }
    else
    {
      if (paramJSONArray1 == null) {
        return false;
      }
      if (paramJSONArray1.length() == 0) {
        return false;
      }
      try
      {
        paramJSONArray1 = ((JSONObject)paramJSONArray1.get(0)).optString(z[0]);
        if (!h.a(paramJSONArray1))
        {
          boolean bool = paramJSONArray1.equals(this.h);
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception paramJSONArray1)
      {
        return false;
      }
    }
    return true;
  }
  
  public final void a()
  {
    boolean bool;
    Object localObject5;
    label430:
    Object localObject6;
    JSONArray localJSONArray;
    Object localObject4;
    String str;
    Object localObject7;
    for (;;)
    {
      try
      {
        bool = this.g;
        if (!bool) {
          return;
        }
        if (!this.f.equals(z[30])) {
          continue;
        }
        if (cn.jiguang.c.a.a.s())
        {
          localObject1 = c();
          localObject1 = cn.jiguang.f.a.a(z[21], (JSONArray)localObject1);
          if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
          {
            l.a(this.e, (JSONObject)localObject1);
            cn.jiguang.d.d.e(z[2], z[32] + localObject1);
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        cn.jiguang.d.d.e(z[2], z[27], localException1);
        return;
        if (!this.f.equals(z[25])) {
          break label430;
        }
        if (!cn.jiguang.c.a.a.s()) {
          continue;
        }
        Object localObject2 = b();
        if (localObject2 == null) {
          continue;
        }
        bool = "".equals(localObject2);
        if (bool) {
          continue;
        }
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localObject5 = new JSONArray();
          ((JSONArray)localObject5).put(localObject2);
          localObject2 = cn.jiguang.f.a.a(z[8], (JSONArray)localObject5);
          if ((localObject2 == null) || (((JSONObject)localObject2).length() <= 0)) {
            continue;
          }
          l.a(this.e, (JSONObject)localObject2);
          cn.jiguang.d.d.e(z[2], z[32] + localObject2);
        }
        catch (JSONException localJSONException1)
        {
          cn.jiguang.d.d.i(z[2], localJSONException1.getMessage());
        }
        continue;
      }
      finally
      {
        g();
      }
      g();
      return;
      if (this.f.equals(z[26]))
      {
        if (cn.jiguang.c.a.a.s())
        {
          localObject1 = d();
          localObject1 = cn.jiguang.f.a.a(z[4], (JSONArray)localObject1);
          if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
          {
            l.a(this.e, (JSONObject)localObject1);
            cn.jiguang.d.d.e(z[2], z[5] + ((JSONObject)localObject1).toString().getBytes().length);
            cn.jiguang.d.d.e(z[2], z[32] + localObject1);
          }
        }
      }
      else if ((this.f.equals(z[16])) && (cn.jiguang.c.a.a.s()))
      {
        localObject6 = d();
        localJSONArray = c();
        localObject4 = new JSONArray();
        str = b();
        cn.jiguang.d.d.c(z[2], z[31] + str);
        localObject7 = z[2];
        StringBuilder localStringBuilder = new StringBuilder(z[12]);
        if (localObject6 == null)
        {
          localObject5 = localObject6;
          label539:
          cn.jiguang.d.d.c((String)localObject7, localObject5);
          localObject7 = z[2];
          localStringBuilder = new StringBuilder(z[20]);
          if (localJSONArray != null) {
            break label645;
          }
        }
        label645:
        for (localObject5 = localJSONArray;; localObject5 = localJSONArray.toString())
        {
          cn.jiguang.d.d.c((String)localObject7, localObject5);
          if ((!TextUtils.isEmpty(str)) || (localJSONArray != null) || (localObject6 != null)) {
            break label655;
          }
          cn.jiguang.d.d.c(z[2], z[17]);
          break;
          localObject5 = ((JSONArray)localObject6).toString();
          break label539;
        }
        label655:
        if (!a((JSONArray)localObject6, localJSONArray, str)) {
          break;
        }
        cn.jiguang.d.d.e(z[2], z[19]);
      }
    }
    if (str != null)
    {
      bool = "".equals(str);
      if (bool) {}
    }
    label1176:
    label1193:
    label1223:
    label1226:
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        ((JSONArray)localObject4).put(new JSONObject(str));
        localObject7 = new JSONObject();
        try
        {
          ((JSONObject)localObject7).put(z[10], z[23]);
          ((JSONObject)localObject7).put(z[13], cn.jiguang.c.a.a.g());
          ((JSONObject)localObject7).put(z[29], cn.jiguang.f.a.c(this.e));
          ((JSONObject)localObject7).put(z[11], cn.jiguang.f.a.c());
          if ((localObject6 != null) && (((JSONArray)localObject6).length() > 0))
          {
            ((JSONObject)localObject7).put(z[22], localObject6);
            this.h = ((JSONObject)((JSONArray)localObject6).get(0)).optString(z[0]);
          }
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            ((JSONObject)localObject7).put(z[14], localJSONArray);
            this.i = localJSONArray.toString();
          }
          if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
          {
            ((JSONObject)localObject7).put(z[25], localObject4);
            this.j = str;
          }
          localObject6 = this.e;
          localObject4 = l.a((Context)localObject6, z[3]);
          if (localObject4 != null) {
            break label1226;
          }
          localObject4 = new JSONObject();
          localObject5 = ((JSONObject)localObject4).optJSONArray(z[7]);
          if (localObject5 != null) {
            break label1223;
          }
          localObject5 = new JSONArray();
          try
          {
            ((JSONArray)localObject5).put(localObject7);
            long l1 = MultiSpHelper.getLong(cn.jiguang.c.a.e, z[24], 0L);
            long l2 = System.currentTimeMillis();
            if (l2 - l1 > cn.jiguang.a.b.a.a())
            {
              MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[24], l2);
              k = 1;
              if ((k == 0) && (!MultiSpHelper.getBoolean((Context)localObject6, z[28], false))) {
                break label1193;
              }
              MultiSpHelper.commitBoolean((Context)localObject6, z[28], false);
              MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[24], System.currentTimeMillis());
              l.a((Context)localObject6, (JSONArray)localObject5);
              if (l.a((Context)localObject6, z[3], null)) {
                break label1176;
              }
              if (!((Context)localObject6).deleteFile(z[3])) {
                continue;
              }
              cn.jiguang.d.d.c(z[2], z[15]);
            }
          }
          catch (JSONException localJSONException2)
          {
            cn.jiguang.d.d.d(z[2], z[6], localJSONException2);
          }
        }
        catch (JSONException localJSONException3) {}
      }
      catch (Exception localException2)
      {
        localJSONObject = null;
        continue;
        int k = 0;
        continue;
        cn.jiguang.d.d.g(z[2], z[18]);
      }
      break;
      cn.jiguang.d.d.c(z[2], z[9]);
      break;
      localJSONObject.put(z[7], localObject5);
      l.a((Context)localObject6, z[3], localJSONObject);
      break;
      continue;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */