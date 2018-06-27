package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpResponse;
import cn.jpush.android.a.b;
import cn.jpush.android.c.f;
import java.util.ArrayList;

final class i
  extends Thread
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[20];
    int j = 0;
    Object localObject2 = "\\{d\035}Gu>\037";
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
        i = 14;
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
        localObject2 = "SoX4\0329";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "F~lJK[bjIw\025fqRmPep\035}AwqI.Gcm\034.F~lJCZrf\0353\025";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "f~lJK[bjIw";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "rsw\035jP`fQaEsq\035~\\uwH|P6e\\gYsg\021.F~lJ.WwpTm\025xlIgS`\\z\\ym\035a[zz\023";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "`xfE~PuwXj\0176vSe[ytS.F~lJ.\025{lYk\025;#";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "{y#MkG{jN}\\ym\035zZ6qXoQ6qX}Zcq^k\025pqRc\025ewR|Tqf\021.F~lJ.WwpTm\025xlIgS`\\z\\ym\035a[zz\023";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "]bwM}\0179,";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "yybY}\025dj^f\025fvNf\025dfNa@d`X}\025pbTbPr/\035yPtUTkB6tTbY6lMk[6vOb\024";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "TxgOa\\r-MkG{jN}\\ym\023\\pWGbKmBFo@tZ\\nZzDBzK";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "rsw\035`PbtR|^6sTmAcqX.SwjQkQ:#NfZa#_oF`\035`Zbj[gVwwTa[6lSbL8";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "TxgOa\\r-MkG{jN}\\ym\023Yg_WxQpNWx\\{WOb]aYQ|Ip";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "]bwM4\0329";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\0316qTm]BzMk\025+#";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "{YWx4\025pbTbPr#Ia\025rlJ`YybY.]bnQ.EwdX \025QjKk\025cs\035z]p\023";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\033~wPb";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\0316iHcE[lYk\025+#";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "yybY}\025dj^f\025fvNf\025dfNa@d`X}\025ev^mPsg\021.BsakgPa#JgYz#R~Px#^oV~f\034";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "g`U#EcpU.[sfY}\025bkX.EsqPgFejR`\025ye\035Yg_WxQpNWx\\{WOb]aYQ|Ip:#MbPwpX.GsrHkFb#Tz\033";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "{y#MkG{jN}\\ym\035zZ6tOgAs#OkFyvOmP6wR.FblOoRs/\035}]yt\035lTej^.[ywTh\\ubIgZx#R`Yo-";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 53;
        continue;
        i = 22;
        continue;
        i = 3;
        continue;
        i = 61;
      }
    }
  }
  
  i(h paramh1, h paramh2, Context paramContext) {}
  
  public final void run()
  {
    f.a(z[3], z[2] + this.c.K + z[13] + this.c.J + z[16] + this.c.I);
    if (this.c.K != 0)
    {
      f.c(z[3], z[5] + this.c.K);
      return;
    }
    String str1 = this.a.c;
    String str2 = this.a.a;
    Object localObject = this.a.w;
    if (this.a.J == 0)
    {
      if ((this.a.u == 3) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!((String)localObject).startsWith(z[12])) && (!((String)localObject).startsWith(z[7]))) {
          break label292;
        }
        if (!cn.jpush.android.c.a.b(this.b, z[11])) {
          break label275;
        }
        localObject = c.a(this.b, (String)localObject, str1);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label258;
        }
        this.a.w = ((String)localObject);
      }
      for (;;)
      {
        b.a(str1, 995, this.b);
        cn.jpush.android.api.c.a(this.b, this.a);
        return;
        label258:
        f.h(z[3], z[10]);
        continue;
        label275:
        f.h(z[3], z[19]);
        continue;
        label292:
        if (cn.jpush.android.c.a.b(this.b, z[9]))
        {
          localObject = cn.jpush.android.c.c.c(this.b, (String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.a.w = ((String)localObject);
          } else {
            f.h(z[3], z[4]);
          }
        }
        else
        {
          f.h(z[3], z[6]);
        }
      }
    }
    if (4 == this.a.J)
    {
      this.a.O = str2;
      b.a(str1, 995, this.b);
      cn.jpush.android.api.c.a(this.b, this.a);
      return;
    }
    if (!cn.jpush.android.c.a.b(this.b, z[11]))
    {
      f.j(z[3], z[18]);
      b.a(str1, 1014, this.b);
      return;
    }
    int i = 0;
    if (i < 4)
    {
      localObject = cn.jpush.android.b.a.a(str2, 5, 5000L);
      if ((localObject != null) && (((HttpResponse)localObject).getResponseCode() == 200))
      {
        i = 1;
        localObject = ((HttpResponse)localObject).getResponseBody();
      }
    }
    for (;;)
    {
      String str3 = cn.jpush.android.c.c.b(this.b, str1);
      String str4;
      if (i != 0)
      {
        str4 = str3 + str1 + z[15];
        str2 = str2.substring(0, str2.lastIndexOf("/") + 1);
        if (this.a.L.isEmpty()) {
          break label814;
        }
        if (c.a(this.a.L, this.b, str2, str1, this.a.a())) {
          break label682;
        }
        f.c(z[3], z[8]);
        b.a(str1, 1014, this.b);
        cn.jpush.android.api.c.a(this.b, this.a);
        return;
        i += 1;
        break;
      }
      f.g(z[3], z[14]);
      b.a(str1, 1014, this.b);
      b.a(str1, 1021, cn.jpush.android.c.a.a(this.b, str2), this.b);
      return;
      label682:
      f.c(z[3], z[17]);
      if (cn.jpush.android.c.c.a(str4, ((String)localObject).replaceAll(z[0] + str2, z[0] + str3), this.b))
      {
        this.a.O = (z[1] + str4);
        b.a(str1, 995, this.b);
        cn.jpush.android.api.c.a(this.b, this.a);
        return;
      }
      b.a(str1, 1014, this.b);
      return;
      label814:
      this.a.O = this.a.a;
      cn.jpush.android.api.c.a(this.b, this.a);
      return;
      localObject = null;
      i = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */