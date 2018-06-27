package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.c.b;
import java.util.ArrayList;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final String[] P;
  public String H;
  public int I;
  public int J;
  public int K;
  public ArrayList<String> L = new ArrayList();
  public String M = "";
  public String N = "";
  public String O;
  public String a;
  
  static
  {
    String[] arrayOfString = new String[13];
    int j = 0;
    Object localObject2 = "i\037/\r$T\003)\016\030";
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
        i = 97;
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
        localObject2 = "[\0244\023\016TM0\b\016Y\0223\t";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "R\0034\n[\025X";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "_(4\023\025V\022";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "_(*\017\fJ(-\025\005_";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "[\0244\023\016TM`\n\000H\004%ZL\032\024/\024\025_\0314";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\\\005/\027>T\002-";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "_(3\022\016M";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "_(5\b\r";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "_(2\023\002R(4\003\021_";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "N\030\037\024\024W";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "_(%\b\004I";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "{\023$Z\tN\0030Z\025UW.\025\017\027\0072\037\007S\017`\017\023VM`";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        P = arrayOfString;
        return;
        i = 58;
        continue;
        i = 119;
        continue;
        i = 64;
        continue;
        i = 122;
      }
    }
  }
  
  public h()
  {
    this.o = 0;
  }
  
  public final void a(Context paramContext)
  {
    cn.jpush.android.c.f.a(P[0], P[1]);
    new i(this, this, paramContext).start();
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    cn.jpush.android.c.f.a(P[0], P[5]);
    this.a = paramJSONObject.optString(P[8], "").trim();
    this.H = paramJSONObject.optString(P[3], "").trim();
    if (!cn.jpush.android.a.f.a(this.a))
    {
      this.a = (P[2] + this.a);
      cn.jpush.android.c.f.e(P[0], P[12] + this.a);
    }
    this.J = paramJSONObject.optInt(P[9], 0);
    this.I = paramJSONObject.optInt(P[4], 0);
    this.K = paramJSONObject.optInt(P[7], 0);
    if ((3 == this.J) || (2 == this.J) || (1 == this.J)) {
      this.L = b.a(paramJSONObject.optJSONArray(P[11]));
    }
    this.M = paramJSONObject.optString(P[6], "");
    this.N = paramJSONObject.optString(P[10], "");
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */