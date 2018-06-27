package com.mato.sdk.f;

import android.os.SystemClock;
import java.io.IOException;

public final class j
{
  public static final j a = new j(3, 100);
  private final int b = 3;
  private final int c = 100;
  
  private j(int paramInt1, int paramInt2) {}
  
  public final boolean a(IOException paramIOException, int paramInt)
  {
    boolean bool = true;
    if (paramInt >= this.b) {
      bool = false;
    }
    if (bool) {
      SystemClock.sleep(this.c);
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */