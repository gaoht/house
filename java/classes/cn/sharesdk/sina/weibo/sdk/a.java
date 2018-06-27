package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.util.StateSet;
import com.mob.tools.utils.Data;

public class a
{
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 16842913 }, { 16842908 }, StateSet.WILD_CARD }, new int[] { paramInt2, paramInt2, paramInt2, paramInt1 });
  }
  
  public static String a(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        i = 0;
        if (i >= paramContext.signatures.length) {
          break;
        }
        paramString = paramContext.signatures[i].toByteArray();
        if (paramString != null) {
          return Data.MD5(paramString);
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return null;
      }
      i += 1;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    byte[] arrayOfByte = new byte[(paramArrayOfByte.length + 2) / 3 * 4];
    int i = 0;
    int j = 0;
    int m;
    if (j < paramArrayOfByte.length)
    {
      m = (paramArrayOfByte[j] & 0xFF) << 8;
      if (j + 1 >= paramArrayOfByte.length) {
        break label219;
      }
      m |= paramArrayOfByte[(j + 1)] & 0xFF;
    }
    label109:
    label204:
    label219:
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (j + 2 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[(j + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        if (n != 0)
        {
          n = m & 0x3F;
          arrayOfByte[(i + 3)] = ((byte)arrayOfChar[n]);
          m >>= 6;
          if (k == 0) {
            break label204;
          }
        }
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfByte[(i + 2)] = ((byte)arrayOfChar[k]);
          k = m >> 6;
          arrayOfByte[(i + 1)] = ((byte)arrayOfChar[(k & 0x3F)]);
          arrayOfByte[(i + 0)] = ((byte)arrayOfChar[(k >> 6 & 0x3F)]);
          j += 3;
          i += 4;
          break;
          n = 64;
          break label109;
        }
        return arrayOfByte;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */