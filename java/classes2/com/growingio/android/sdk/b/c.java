package com.growingio.android.sdk.b;

import android.annotation.TargetApi;
import java.util.Arrays;

public final class c
{
  public static int a(int paramInt)
  {
    return d.a(paramInt);
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    return d.a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
  
  @TargetApi(9)
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[a(paramArrayOfByte.length)];
    return Arrays.copyOf(arrayOfByte, a(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte, 0));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */