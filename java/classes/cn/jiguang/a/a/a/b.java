package cn.jiguang.a.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import cn.jiguang.f.j;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  private static final String[] z;
  private int a = -1;
  private int b = -1;
  private String c = "";
  private String d = "";
  private String e = "";
  private TelephonyManager f = null;
  private Context g = null;
  private int h = 0;
  private c i = null;
  private a j = null;
  private d k = null;
  
  static
  {
    String[] arrayOfString = new String[29];
    int n = 0;
    Object localObject2 = "Q\037\\\0356|\nA\004<";
    int m = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i1 = arrayOfChar.length;
    int i4 = 0;
    int i2 = 0;
    int i6 = m;
    localObject2 = arrayOfChar;
    int i7 = n;
    Object localObject3 = localObject1;
    int i3 = i1;
    Object localObject4;
    int i5;
    if (i1 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i5 = m;
      label68:
      i3 = i2;
      label71:
      localObject2 = localObject1;
      i4 = localObject2[i2];
      switch (i3 % 5)
      {
      default: 
        m = 89;
      }
    }
    for (;;)
    {
      localObject2[i2] = ((char)(m ^ i4));
      i3 += 1;
      if (i1 == 0)
      {
        i2 = i1;
        break label71;
      }
      i4 = i3;
      i3 = i1;
      localObject3 = localObject4;
      i7 = n;
      localObject2 = localObject1;
      i6 = i5;
      i5 = i6;
      localObject1 = localObject2;
      n = i7;
      localObject4 = localObject3;
      i1 = i3;
      i2 = i4;
      if (i3 > i4) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i6)
      {
      default: 
        localObject3[i7] = localObject1;
        n = 1;
        localObject2 = "D\033V\021+B\nQ\0337";
        m = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i7] = localObject1;
        n = 2;
        localObject2 = "D\033L7<O\022q\032?L*Q\031<\003\035]\0305J\020^\033yW\027U\021c";
        m = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i7] = localObject1;
        n = 3;
        localObject2 = "J\nQ\031<";
        m = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i7] = localObject1;
        n = 4;
        localObject2 = "@\037J\0060F\f";
        m = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i7] = localObject1;
        n = 5;
        localObject2 = "@\033T\030\006J\032";
        m = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i7] = localObject1;
        n = 6;
        localObject2 = "O\021[\025-J\021V+8Q\033Y+:L\032]";
        m = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i7] = localObject1;
        n = 7;
        localObject2 = "N\021Z\0355F![\033,M\nJ\r\006@\021\\\021";
        m = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i7] = localObject1;
        n = 8;
        localObject2 = "N\021Z\0355F!V\021-T\021J\037\006@\021\\\021";
        m = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i7] = localObject1;
        n = 9;
        localObject2 = "P\027_\0328O!K\000+F\020_\0001";
        m = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i7] = localObject1;
        n = 10;
        localObject2 = "`\033T\030\020M\030W98M\037_\021+";
        m = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i7] = localObject1;
        n = 11;
        localObject2 = "P\nW\004yO\027K\000<Q";
        m = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i7] = localObject1;
        n = 12;
        localObject2 = "V\020]\f:F\016L\021=\003S\030\0357J\n{\0215O2Q\007-F\f\030\021c";
        m = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i7] = localObject1;
        n = 13;
        localObject2 = "b\035L\0356M^\025T7L\nQ\022 q\033H\033+W?[\0000L\020";
        m = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i7] = localObject1;
        n = 14;
        localObject2 = "D\rU";
        m = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i7] = localObject1;
        n = 15;
        localObject2 = "@\033T\030\025L\035Y\0000L\020u\0257B\031]\006yT\037KT7V\022TYyP\025Q\004yW\026Q\007yB\035L\0356M";
        m = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i7] = localObject1;
        n = 16;
        localObject2 = "O\n]";
        m = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i7] = localObject1;
        n = 17;
        localObject2 = "\017^_\0217F\fY\0000L\020\002";
        m = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i7] = localObject1;
        n = 18;
        localObject2 = "v\020]\f)F\035L\021=\002^[\0215O2W\0278W\027W\032yJ\r\030\032,O\022\024T>J\b]T,S^J\021)L\fLT:F\022TY0M\030W";
        m = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i7] = localObject1;
        n = 19;
        localObject2 = "@\032U\025";
        m = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i7] = localObject1;
        n = 20;
        localObject2 = "w\033T\0216M\007u\0257B\031]\006\fW\027T\007";
        m = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i7] = localObject1;
        n = 21;
        localObject2 = "D\033L&8G\027W  S\033\030YyM\033L\0036Q\025l\r)FD";
        m = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i7] = localObject1;
        n = 22;
        localObject2 = "Q\037\\\0356w\007H\021c";
        m = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i7] = localObject1;
        n = 23;
        localObject2 = "v\020]\f)F\035L\021=\002";
        m = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i7] = localObject1;
        n = 24;
        localObject2 = "D\033L&8G\027W  S\033\030YyQ\037\\\0356w\007H\021c";
        m = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i7] = localObject1;
        n = 25;
        localObject2 = "\017^[\025+Q\027]\006c";
        m = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i7] = localObject1;
        n = 26;
        localObject2 = "S\026W\032<";
        m = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i7] = localObject1;
        n = 27;
        localObject2 = "w\026]T)F\fU\035*P\027W\032yL\030\0305\032`;k'\006`1y&\nf!t;\032b*q;\027\003\027KT=F\020Q\021=\002";
        m = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i7] = localObject1;
        n = 28;
        localObject2 = "V\020]\f)F\035L\021=\002";
        m = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i7] = localObject1;
        z = arrayOfString;
        return;
        m = 35;
        continue;
        m = 126;
        continue;
        m = 56;
        continue;
        m = 116;
      }
    }
  }
  
  public b(Context paramContext)
  {
    this.g = paramContext;
    try
    {
      this.f = ((TelephonyManager)paramContext.getSystemService(z[26]));
      return;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.c(z[10], z[27], paramContext);
    }
  }
  
  private static int a(String paramString)
  {
    int m = -1;
    try
    {
      if (paramString.length() <= 6) {
        m = Integer.parseInt(paramString.substring(3, paramString.length()));
      }
      return m;
    }
    catch (Exception paramString)
    {
      cn.jiguang.d.d.e(z[10], z[28], paramString);
    }
    return -1;
  }
  
  private JSONObject a(int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[8], this.b);
      localJSONObject.put(z[5], paramInt2);
      localJSONObject.put(z[0], this.c);
      localJSONObject.put(z[9], paramInt1);
      localJSONObject.put(z[7], this.a);
      localJSONObject.put(z[4], this.e);
      localJSONObject.put(z[6], paramInt3);
      localJSONObject.put(z[1], this.d);
      String str = z[3];
      long l = cn.jiguang.c.a.a.g();
      cn.jiguang.d.d.c(z[10], z[2] + l);
      localJSONObject.put(str, l);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 268435455) && ((paramInt4 == 0) || (paramInt4 == 3))) {
      return a(paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 < 65535) && ((paramInt4 == 1) || (paramInt4 == 2))) {
      return a(paramInt1, paramInt2, paramInt3);
    }
    return null;
  }
  
  private void b()
  {
    cn.jiguang.d.d.c(z[10], z[13]);
    if (this.j != null) {
      this.j.a();
    }
    while (this.k == null) {
      return;
    }
    this.k.e();
  }
  
  private void c()
  {
    try
    {
      this.i = new c(this);
      this.f.listen(this.i, 256);
      return;
    }
    catch (Exception localException)
    {
      cn.jiguang.d.d.g(z[10], z[12] + localException.getMessage());
      b();
    }
  }
  
  public final void a()
  {
    cn.jiguang.d.d.c(z[10], z[11]);
    try
    {
      if ((this.f != null) && (this.i != null)) {
        this.f.listen(this.i, 0);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void a(a parama)
  {
    this.j = parama;
  }
  
  public final void a(d paramd)
  {
    this.k = paramd;
    if (paramd == null)
    {
      cn.jiguang.d.d.g(z[10], z[15]);
      b();
      return;
    }
    try
    {
      CellLocation localCellLocation = this.f.getCellLocation();
      if (localCellLocation == null)
      {
        cn.jiguang.d.d.g(z[10], z[18]);
        b();
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject1;
      for (;;)
      {
        cn.jiguang.d.d.e(z[10], z[23], localException1);
        localObject1 = null;
      }
      this.a = -1;
      this.b = -1;
      this.c = "";
      this.d = "";
      this.e = "";
      this.e = this.f.getNetworkOperatorName();
      int m = this.f.getNetworkType();
      cn.jiguang.d.d.a(z[20], z[21] + m);
      if ((m == 4) || (m == 7) || (m == 5) || (m == 6) || (m == 12) || (m == 14)) {
        localObject1 = z[19];
      }
      for (;;)
      {
        cn.jiguang.d.d.a(z[20], z[24] + (String)localObject1);
        this.c = ((String)localObject1);
        this.d = j.a(this.g, this.f.getNetworkType());
        cn.jiguang.d.d.a(z[10], z[22] + this.c + z[25] + this.e + z[17] + this.d);
        try
        {
          localObject1 = this.f.getNetworkOperator();
          if (((String)localObject1).length() > 3)
          {
            this.a = Integer.parseInt(((String)localObject1).substring(0, 3));
            this.b = a((String)localObject1);
          }
          localObject1 = new JSONArray();
          if (Build.VERSION.SDK_INT > 17)
          {
            Object localObject2 = this.f.getAllCellInfo();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (CellInfo)((Iterator)localObject2).next();
                  if ((localObject3 instanceof CellInfoLte))
                  {
                    localObject4 = (CellInfoLte)localObject3;
                    if (Build.VERSION.SDK_INT <= 17) {
                      continue;
                    }
                    localObject3 = ((CellInfoLte)localObject4).getCellSignalStrength();
                    localObject4 = ((CellInfoLte)localObject4).getCellIdentity();
                    localObject3 = a(((CellSignalStrengthLte)localObject3).getDbm(), ((CellIdentityLte)localObject4).getCi(), ((CellIdentityLte)localObject4).getTac(), 0);
                    if (localObject3 == null) {
                      continue;
                    }
                    ((JSONArray)localObject1).put(localObject3);
                    continue;
                    if (m == 13)
                    {
                      localObject1 = z[16];
                      break;
                    }
                    localObject1 = z[14];
                  }
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3;
            Object localObject4;
            localException2.printStackTrace();
            continue;
            if ((localObject3 instanceof CellInfoGsm))
            {
              localObject4 = (CellInfoGsm)localObject3;
              if (Build.VERSION.SDK_INT > 17)
              {
                localObject3 = ((CellInfoGsm)localObject4).getCellSignalStrength();
                localObject4 = ((CellInfoGsm)localObject4).getCellIdentity();
                localObject3 = a(((CellSignalStrengthGsm)localObject3).getDbm(), ((CellIdentityGsm)localObject4).getCid(), ((CellIdentityGsm)localObject4).getLac(), 1);
                if (localObject3 != null) {
                  localException2.put(localObject3);
                }
              }
            }
            else if ((localObject3 instanceof CellInfoCdma))
            {
              localObject4 = (CellInfoCdma)localObject3;
              if (Build.VERSION.SDK_INT > 17)
              {
                localObject3 = ((CellInfoCdma)localObject4).getCellSignalStrength();
                localObject4 = ((CellInfoCdma)localObject4).getCellIdentity();
                localObject3 = a(((CellSignalStrengthCdma)localObject3).getDbm(), ((CellIdentityCdma)localObject4).getBasestationId(), ((CellIdentityCdma)localObject4).getNetworkId(), 2);
                if (localObject3 != null) {
                  localException2.put(localObject3);
                }
              }
            }
            else if ((localObject3 instanceof CellInfoWcdma))
            {
              localObject4 = (CellInfoWcdma)localObject3;
              if (Build.VERSION.SDK_INT > 17)
              {
                localObject3 = ((CellInfoWcdma)localObject4).getCellSignalStrength();
                localObject4 = ((CellInfoWcdma)localObject4).getCellIdentity();
                localObject3 = a(((CellSignalStrengthWcdma)localObject3).getDbm(), ((CellIdentityWcdma)localObject4).getCid(), ((CellIdentityWcdma)localObject4).getLac(), 3);
                if (localObject3 != null) {
                  localException2.put(localObject3);
                }
              }
            }
          }
          paramd.a(localException2);
          b();
          return;
        }
      }
      c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */