package cn.jiguang.c.b;

import android.content.Context;
import java.io.File;

final class d
  extends Thread
{
  private static final String z;
  
  static
  {
    Object localObject1 = "\026w0UjQg0T}Na\023Np]".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 28;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 56;
      continue;
      i = 4;
      continue;
      i = 85;
      continue;
      i = 39;
    }
  }
  
  d(Context paramContext) {}
  
  public final void run()
  {
    File localFile = this.a.getFilesDir();
    if (localFile != null)
    {
      localFile = new File(localFile, z);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */