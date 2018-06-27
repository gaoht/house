package com.baidu.platform.comjni.map.commonmemcache;

import android.os.Bundle;

public class a
{
  private long a = 0L;
  private JNICommonMemCache b = null;
  
  public long a()
  {
    this.a = this.b.Create();
    return this.a;
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.a != 0L) {
      this.b.Init(this.a, paramBundle);
    }
  }
  
  public String b()
  {
    return this.b.GetPhoneInfoUrl(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/map/commonmemcache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */