package cn.jiguang.f;

import cn.jiguang.d.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class e
  implements HostnameVerifier, X509TrustManager
{
  private static final String[] z;
  private X509TrustManager a;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "_f\002\0170yF:\026#bT)>0";
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
        i = 66;
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
        localObject2 = "o]+8)_P<-'~a<.1xP*";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "!\030cvoNp\t\022\f,v\013\t\026Es\007\030\003Xpcvo!\030D\026\013Ep\032!\001Ot4>%MB\007\031\003k|\n\032(|C\003\032rKv\035*\005_|,h\006]p\f\0305Yt\003\036\013tv4\032\bNR\000\r\000Ml\032\032.ZaD\026\020UB\b\032\033Hc\037\n\tIB\023\030[\f\0338,ZO*\030\000FW#\0267Ag=,\005]l\n\r\023]q\013#\bDo\031b\027o[\030!&Ow\0069\0055\\D\002\025{R\037k\007{}&8\fAa\003#\017Xt\026(IO\0001\027{b&8\fA_\007,\fX|9\026(IO\0001\027{b$\031\007Ad=,\001]l\n\r\023]rD\0365Fc\033!\007[x\f\n\005M\004\033\036\001dx\000\tpZC\030\023\b=V}\n%_b{1\016fp*\026\000r\017j\027It6\026\027^\007\030-\024D8q]RD\016sBx\007\036\fN|\rk%^O\003,%kp'\026\003<r\r\b3Kf\0079qHd\013\031\003]`\017\032vEw\n,\003{R)\036\tMZ\007\031\003]q$-,8~D33\\e/ir5~x\034\032~`%0\026hQ}.\026^\000\r\020\025iZ>l'^M\005\b\022T\002?\034\033mMx\036z5ma=\023|\006+:\025t\r\005\032uYoD\016{yY\007\001\020|l{j3X\013\026\007IPe\036$|F&2\025?D9\t-]_)\021\030jt\033i*aPe61@D|\0274fT(-\033?t$*\t'wDc{J@'\034&X\002\f\020)Gm\031\0202#\026\013#Gq#\021$uv h\0279\005\000.\017D]'\022.`o;\023\007bg/4\022VF\024\r\022#Z7\035;MD1rmRe6)YS\004i$[@\002)\017<\001\037+0\\A*i\022UB{lr?Qwn/bG\033l6;Q#(8HAx7&vw\013m\000;A87t]wD\022ric\006m\f?\036\"2\021tF(\n4o\036\032\034\007G\006(-'io+)\024C\r</0Ac94$;`\013\0210{p)\t\007~w>9'Jw\b\rrtCD-\033Hy)\r5xFy#pcg{7\003kx\f\032\003K_)<\004Gx\007\022\000^_\017=\000k{\030\023\021Ap\t\037\003[R\f\017\003iE&4(U[y*5Z^D\037\000J\f?5s`@\003)\017X_\017?\000k{\030\023\0238p\b<\023Y\005#tq`C\035\035\022?|v\026\n<_|4\0248Xx\025z[[9,\007kl\n\r\020<aD\032\023D\032\f\032%{w)\036\000#B\007\031\003Ht\001\031%Bc\006\nzNt(c\007Nt\003\030\003]l9\025%Uq\030\trjw\rc5@a\017)-OX)\021vUYD:\n^\005-\037-zy|8:@[\000n [{'\027/BC,\b{fV##8@\007*k\030>M8\002/JF\0026\fuW\n\0324NR))\000kp\b\031\023owD\032\023]_\003\030\007{}9\002\013GB\027\031\000]`\006\026\003Kr\013i*<Q\006\032t@Lw5\017e\0004>\025=_\0272wfW|k5Xt\027\037\024^\005)\031\007YBD\n8Nw\f<2k]%<\000dC&\035\003]V|\026\006AB\003\n\033E~9\002\000Nd\033\023\003kp\031\021\025d\005*\023\003:y7bqh\006-.\030>c8?\nF\004D8q]@\027i{xy}\021.o\007wj!a{\"8;5_-\023\017{~\037\002\006Zg~\t\000O|9\022\t]P\003\0315tr$\032\033NR\000\r\000Mx\032\036\024B\000D9\025J@*\034\024f`\013/\b@a\013/\fXx{\026\003<r\r\b3Kf\0079qHd\013\031\001{`\017\032vEw\017\n\001k\004\03681'\006\037\027$>a6!\027BDD5pFa\006\032\b4X\004\030+;^w4sOt/8:E\036*l\f]\003}\020z;Z'p$tS??v'q\027\001\024\\]\005\023\016A^w(\013n\002\035:\030V\fD\002u?V\005m%j\005\f\024\007oeyi\fVb\004p#V\006=\036 E@y8\0265V\"<#ho\003t6Gzyb\fkB\027\030\0038P(l+>\r&>\027~RDh\tgW99$;B~7\030Ty\030h\000<a\0337mt\017\022.zw%o\000ow#(\016t}\017o7Ue\002o\030@_\026-\006yT-.{\\r=\035(8\000D\b\024KP\bk6\\p\n+ |T'\b #\006xj%q\032\016&[c658u\0078jz5W\036(\022T\004!#\n_|\b\026\026Bq-\035\016I{/\002{'{D\n\fms\0067\n|`\0348'M\004,\021zXv:nwg!),]x\027\034 my\006\001t\\e#7\n;}<3\017z]eh\023FW\f4ih\001\007\f4AED!\f_fDvo!\030c\036\fH\025\r\036\020X|\b\022\001Ma\013vo!\030c";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "T\033{k{";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "oT\021)-cA";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "kP:\032!oP>/'h|=(7iG=";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "o]+8)OY'>,xa<.1xP*";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 12;
        continue;
        i = 53;
        continue;
        i = 78;
        continue;
        i = 91;
      }
    }
  }
  
  public e()
  {
    try
    {
      Object localObject2 = z[2];
      Object localObject1 = CertificateFactory.getInstance(z[3]);
      localObject2 = new ByteArrayInputStream(((String)localObject2).getBytes());
      localObject1 = (X509Certificate)((CertificateFactory)localObject1).generateCertificate((InputStream)localObject2);
      ((InputStream)localObject2).close();
      localObject2 = new KeyStore.TrustedCertificateEntry((Certificate)localObject1);
      localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject1).load(null, null);
      ((KeyStore)localObject1).setEntry(z[4], (KeyStore.Entry)localObject2, null);
      localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject2).init((KeyStore)localObject1);
      localObject1 = ((TrustManagerFactory)localObject2).getTrustManagers();
      int i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          if ((localObject1[i] instanceof X509TrustManager)) {
            this.a = ((X509TrustManager)localObject1[i]);
          }
        }
        else {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    d.c(z[0], z[6]);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    d.c(z[0], z[1]);
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    d.c(z[0], z[5]);
    return this.a.getAcceptedIssuers();
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */