package cn.jpush.android.c;

import android.text.TextUtils;
import cn.jpush.android.api.b;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  public static final Pattern a;
  public static final Pattern b;
  public static final Pattern c;
  public static final Pattern d;
  public static final Pattern e;
  public static final Pattern f;
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[3];
    int j = 0;
    Object localObject3 = "\f\r乥$鿙b{\\hQ(\027HS#s\026F-Zx}X'\000\017}A";
    int i = -1;
    Object localObject1 = localObject2;
    int k;
    int i1;
    int m;
    int i4;
    Object localObject4;
    int n;
    int i2;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject3).toCharArray();
      k = arrayOfChar.length;
      i1 = 0;
      m = 0;
      int i3 = i;
      localObject3 = arrayOfChar;
      i4 = j;
      localObject4 = localObject1;
      n = k;
      Object localObject5;
      if (k <= 1)
      {
        localObject5 = localObject1;
        localObject1 = arrayOfChar;
        i2 = i;
      }
      label143:
      do
      {
        n = m;
        for (;;)
        {
          localObject3 = localObject1;
          i1 = localObject3[m];
          switch (n % 5)
          {
          default: 
            i = 124;
            localObject3[m] = ((char)(i ^ i1));
            n += 1;
            if (k != 0) {
              break label143;
            }
            m = k;
          }
        }
        i1 = n;
        n = k;
        localObject4 = localObject5;
        i4 = j;
        localObject3 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject3;
        j = i4;
        localObject5 = localObject4;
        k = n;
        m = i1;
      } while (n > i1);
      localObject1 = new String((char[])localObject3).intern();
      switch (i3)
      {
      default: 
        localObject4[i4] = localObject1;
        j = 1;
        localObject3 = "\f\r乥$鿙b{\\hQ(\027HS#s\026F-Zx}X'\000\017-U%Hb+A";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "z~M!'3{\037HQ\bfH0Ü힩便$ﶳﶢ{ﾊT'3{\037HQ\bfH0Ü힩便$ﶳﶢ{ﾊUQ\017|L#'3{\037HQ\bfH0Ü힩便$ﶳﶢ{ﾊT |N";
        i = 1;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    localObject1 = "z~\004l\016=*\004{\f3*\004z\0253*\004R\03763\003n\025>;\013f\r %\021|\013*,8 \000z4\fs\0000\r\004k\03070\002a\0258;\013f\016!\"\023~\005(\013LuT17\021u\037=;\031j\023=&\031j'35\001o\033:?\016e\021<9\027|\n*/\037TU.2>l\0269;\ns!.~\000m\t.3>j\0315$\026}\t\017\031o';<\016d\023 \013\031!\033= \031n'34\001l\0325>\fe\021<&\024{\017&#\022p!{*\rR\027?8\027}\t\017*M`\02249\031`\022&*\fR\0307:\bg\023#$\026}!{*Mc\0230%\031c'7;\ny!{*\016R\0315>\fd\022\"$\022p\006\017*\tR\03505\fb\016!\"\020\005\017*Md\025>*\bf\036;*\b|\0177#\bu\021\t7\006m\0315>\016e\021<9\025x\016!\"\020\013*/\037TU.~\013h\0217*\013l\b.8>h\03770\002`\020=&\027|\006\017\031!\023 1\031f\021{*My\016=*\025R\03570\002a\027>;\013{\017&!\034TU.'\004u\016\t3\nz\t%\013\031z'34\006m\0315>\fc\027>;\013f\016&#\023p\006\017*M}\031>*\021{\035$3\tu\b\t5\001o\033:<\016e\021<9\025{\b$!\037TU.#>h\0339%\034s!. >h\03771\fg\t\017*\022R\032!\013\031!\004<\nHUQb,\022dId2\031q\022\016{9$Mc4Pk\017a7\\h\026d1\031q\022\016{9$Db7\016a\036+=\013cH4*\035g \nH0\bf4T8\005;c\004u\004<\nHUQ63\007hL32\031q\022\016{9$\033d!W<M6*\035g \nHa\0330=Sh\026e0P:\03607\031q\022\016{9$\024>5\017?\035+7\\l\0171a\004u\004<\nHUQ8.\004e\f6:\025u\004<\nHUQ91\007l\037:\"\023u\004<\nHUQ(5\016s\035:\031p'7\"\020T\000(\r\004d\013\017";
    i = -1;
    for (;;)
    {
      label294:
      localObject1 = ((String)localObject1).toCharArray();
      j = localObject1.length;
      n = 0;
      k = 0;
      i2 = i;
      localObject2 = localObject1;
      m = j;
      if (j <= 1) {
        i1 = i;
      }
      label329:
      label573:
      label662:
      do
      {
        m = k;
        localObject2 = localObject1;
        n = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 124;
        }
        for (;;)
        {
          localObject2[k] = ((char)(i ^ n));
          m += 1;
          if (j != 0) {
            break label662;
          }
          k = j;
          break label329;
          i = 82;
          break;
          i = 86;
          break;
          i = 101;
          break;
          i = 9;
          break;
          c = Pattern.compile((String)localObject1);
          localObject3 = new StringBuilder(z[2]).append(a);
          localObject1 = "{*".toCharArray();
          j = localObject1.length;
          m = 0;
          i = 0;
          localObject2 = localObject1;
          k = j;
          if (j <= 1) {}
          do
          {
            m = i;
            k = i;
            localObject2 = localObject1;
            n = localObject2[k];
            switch (m % 5)
            {
            default: 
              i = 124;
            }
            for (;;)
            {
              localObject2[k] = ((char)(i ^ n));
              m += 1;
              if (j != 0) {
                break label573;
              }
              k = j;
              break;
              i = 82;
              continue;
              i = 86;
              continue;
              i = 101;
              continue;
              i = 9;
            }
            k = j;
            localObject2 = localObject1;
            localObject1 = localObject2;
            j = k;
            i = m;
          } while (k > m);
          d = Pattern.compile(new String((char[])localObject2).intern() + c + ")");
          localObject1 = "\t7Hs=\fU$E\016}9' \r\n@UQ\016}8rM~dP?\001\016\026>hQ(\027HSLo8R\035,$$&b{\\UQ\017-U%Jf+MUR\t7Hs=\fU$E\017\r\004$\006\023{?9Qk\nHT\007bzW<\001{}";
          i = 2;
          break label294;
          i = 82;
          continue;
          i = 86;
          continue;
          i = 101;
          continue;
          i = 9;
        }
        n = m;
        m = j;
        localObject2 = localObject1;
        i2 = i1;
        i1 = i2;
        localObject1 = localObject2;
        j = m;
        k = n;
      } while (m > n);
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      case 1: 
      default: 
        a = Pattern.compile((String)localObject1);
        localObject1 = "z~Z3T:\"\021y\000:\"\021y\017.\036\021}\f.\036\021}\f!*\027}\017\"*7}\017\"_US\016yM6Fzi_R\035,$$&b{\\UX\016{9V |\nNU]\016|9. z\nLUP\016m96 t\nXT\000zi_UY\t7Ho=\020U$E\017-WtU{-T%Jf+M6F\016lM6F\t7Hs=\fU$E\016r9$ \r\nKUW\016w9# u\nMUU\016z92 m\nCUA\017*M6F\016s>hQ4\027HOLo8rN/LrM~dPtUm\n% C{iM!Ch~Z3'3{\037HQ\bfH0Ü힩便$ﶳﶢ{ﾊT'3{\037HQ\bfH0Ü힩便$ﶳﶢ{ﾊUQ\017-U%Jf+9'Uy~Z3Tml\004l\016=*\004{\f3*\004z\0253*\004R\03763\003n\025>;\013f\r %\021|\013*,8 \000zi_k\025(*\007R\03502\000o\033:?\017d\022=$\026}\n%/\037TU.~Z3\0373\"\031j\023?*\006f\023\"*\006R\03512\003n\024;=\td\022=$\020\004+,8 \0006\r\000c\027?9\037T\000zi_l\030'*\000R\03771\027z\b'\013Lu\032\t?\017b\021=$8uTml\002f\n.1>h\03663\003n\024;:\bg\f#$\026}\t%/8 \000:\r\016d\022 \"\020T\000zi_`\02249\031`\022&*\fR\0307:\bg\023#$\026}!{*M6F89\007z\0008\r\000d\023\"\013Lu\027\t3\002a\025?8\025{\013+,8u\020\t7\007j\0259$\026}\t$/8uTml\b`\020.;\nk\025.;\020z\031';\031d'35\001l\033:=\td\022=&\024{\017&#\023~\004+,8 \000zi_g\035?3\031g\031&*\013R\03513\003n\025>9\025{\t(\013LuTml\n{\033.9\b \000zi_y\016=*\025R\03570\002a\027>;\013{\017&!\034TU.'\004u\016\t3\nz\t%\013\031z'34\006m\0315>\fc\027>;\013f\016&#\023p\006\017*M6F&3\tu\b 7\023l\020.\">j\03041\rc\027>;\013f\f \"\023~\006\017\031|'31\016z\005(\013\031'35\000n\025<#8u\013\t0\026T\000zi_q\022\016{9$L(!\b<J6*\035g \nH8M0c\007zO3o\004cJ5*\035g \nH1L3=\rk\00598\017=\032..\013UQ\016{\\}H0gTp\025g7\031q\022\016{9$\03074\0049\0356*\035g \nHnJ%dP8\030..\013UQ\016{\rn\0369`\004cK4cVk\0363*\035g \nHa\0201<Sh\0053o\000z\037e7\031q\022\016{9$\026*7\ty\030>&\031q\022\016{9$\02754\000j\024& \031q\022\016{9$\0061=\037h\024{*\034R\031&#8u\006\t7\b~!{\031!Ch~Z3Ng\rU$I\017*WRLb8RLo8u'b{TT'b{\\T\007`+\031RMo8RLo8u'c{\\TU\016xM6F`c>9Qg\013\031;'b{QT'b{\\T\000\tfH8!\tfH0!)d\030u'c{\\T'b{\\T\000\tgH0!.fLURzi_;I\tfH<!.d>9Qf\013>9Qk\013\031RLg8RLo8rN/*>8Qk\013>9Qk\013\031RMo8uL{\nK!ChdPRLc8uN\tfH=!\tfH0!.\rU$M\017\rU$E\017-Wt\000\tgH0!\tfH0!.\rU$E\017L Tml93 6-T%I/Z T\016yM6Fzi_R\035,$$&b{\\©Q힭稜Hﷆﶌﾹ92 }\nZUF\016\0269/ o\nFU\002\016{9' y\nDUV\016q9! {\nIU#\017\031!Ch\n@R\0350$$:b{\\T\007`+L V{iM6F\0164\031-U";
        i = 0;
        break;
      case 0: 
        b = Pattern.compile((String)localObject1);
        localObject1 = "z~W<'b{PT\000`\rU$H\017\rU$E\017*>9Qc\013>9Qk\013\036;\001.\rT$E\017\rU$E\017*>8Qk\013LURzdPRLc8uN\tfH=!\tfH0!.\rU$M\017\rU$E\017-Wt\000\tgH0!\tfH0!.\rT$E\017*U  |~W<'b{PT\000`\rU$H\017\rU$E\017*>9Qc\013>9Qk\013\036;\001.\rT$E\017\rU$E\017*>8Qk\013\0319U\016xM;I\tfH<!.d>9Qf\013>9Qk\013\031RLg8RLo8rN/*>8Qk\013>9Qk\013\031RLo8 U";
        i = 1;
        break;
      case 2: 
        e = Pattern.compile((String)localObject1);
        localObject1 = "z\nNRLo8\"'\016{EUR\017|L6T\016~>9Qk\013NUU\t\nH) |\013O Cz\rU$E\017\rU$E\016{EUR\017\rU$E\016{EUR\017}>9Qk\013L";
        i = 3;
      }
    }
    f = Pattern.compile((String)localObject1);
  }
  
  public static int a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return 0;
    }
    if (paramSet.size() > 1000) {
      return b.g;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (str == null) {
        return b.e;
      }
      if (str.getBytes().length > 40) {
        return b.f;
      }
      if (!Pattern.compile(z[0]).matcher(str).matches()) {
        return b.e;
      }
    }
    return 0;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.compile(z[1]).matcher(paramString).matches();
  }
  
  public static int b(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return 0;
      if (paramString.getBytes().length > 40) {
        return b.d;
      }
    } while (Pattern.compile(z[0]).matcher(paramString).matches());
    return b.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */