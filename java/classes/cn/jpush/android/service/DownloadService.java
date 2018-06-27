package cn.jpush.android.service;

import android.app.IntentService;
import android.content.Intent;

public class DownloadService
  extends IntentService
{
  private static final String z;
  
  static
  {
    Object localObject1 = "Nj\027lied\004Q`xs\ta`".toCharArray();
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
        i = 5;
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
      i = 10;
      continue;
      i = 5;
      continue;
      i = 96;
      continue;
      i = 2;
    }
  }
  
  public DownloadService()
  {
    super(z);
  }
  
  protected void onHandleIntent(Intent paramIntent) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */