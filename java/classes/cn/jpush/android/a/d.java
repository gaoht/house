package cn.jpush.android.a;

import android.os.IBinder;
import android.os.RemoteException;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.b;
import cn.jpush.android.c.f;

public final class d
{
  private static a a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "io\004\000{jj \021~T\032";
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
        i = 18;
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
        localObject2 = "IH\r\031}P;\021`Rs\013\0212MiH\032gHvDTpMt\f'wVl\001\027w\004r\t\0072Ju\034TpA\006TqKt\006\021qP\f";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "qt\r\fbAy\034\021v\005:)\035vH:\000\025a\004m\032\033|C:\037\035fL::\021Kn\r1jG\030\000{KtH\003zAtH\023wP:&\033fM|\001\027sPs\007\032CQ\035\0212Ws\022\021<";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "qt\r\fbAy\034\021v\005:)\035vH:\000\025a\004m\032\033|C:\037\035fL::\021Kn\r1jG\030\000{KtH\003zAtH:}Ps\016\035qEn\001\033|uo\r\001w\004j\007\030~\n";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "qt\r\fbAy\034\021v\005:)\035vH:\000\025a\004m\032\033|C:\037\035fL::\021Kn\r1jG\030\000{KtH\003zAtH:}Ps\016\035qEn\001\033|uo\r\001w\004y\007\032fEs\006\007<";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "qt\r\fbAy\034\021v\005:)\035vH:\000\025a\004m\032\033|C:\037\035fL::\021Kn\r1jG\030\000{KtH\003zAtH:}Ps\016\035qEn\001\033|uo\r\001w\004u\016\022wV4";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 36;
        continue;
        i = 26;
        continue;
        i = 104;
        continue;
        i = 116;
      }
    }
  }
  
  public static int a()
  {
    int i = 0;
    try
    {
      if (c()) {
        i = a.a();
      }
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      f.g(z[0], z[3]);
      localRemoteException.printStackTrace();
      return 0;
    }
    catch (NullPointerException localNullPointerException)
    {
      f.a(z[0], z[1]);
    }
    return i.a();
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    try
    {
      if (c()) {
        bool = a.a(paramInt);
      }
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      f.g(z[0], z[5]);
      localRemoteException.printStackTrace();
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
      f.a(z[0], z[1]);
    }
    return i.a(paramInt);
  }
  
  public static int b()
  {
    int i = 0;
    try
    {
      if (c()) {
        i = a.b();
      }
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      f.g(z[0], z[2]);
      localRemoteException.printStackTrace();
      return 0;
    }
    catch (NullPointerException localNullPointerException)
    {
      f.a(z[0], z[1]);
    }
    return i.b();
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    try
    {
      if (c()) {
        bool = a.b(paramInt);
      }
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      f.g(z[0], z[4]);
      localRemoteException.printStackTrace();
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
      f.a(z[0], z[1]);
    }
    return i.b(paramInt);
  }
  
  private static boolean c()
  {
    boolean bool = false;
    if (JCoreInterface.canCallDirect())
    {
      if (a == null)
      {
        IBinder localIBinder = JCoreInterface.getBinderByType(cn.jpush.android.d.a, "");
        if (localIBinder != null) {
          a = b.a(localIBinder);
        }
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */