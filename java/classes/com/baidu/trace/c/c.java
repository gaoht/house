package com.baidu.trace.c;

import android.text.TextUtils;

final class c
  implements Runnable
{
  c(a.d paramd, StringBuffer paramStringBuffer) {}
  
  public final void run()
  {
    if (!TextUtils.isEmpty(this.a.toString()))
    {
      a.d.a(this.b.a, this.b.f, this.a.toString(), this.b.b, this.b.g);
      return;
    }
    a.d.a(this.b.a, this.b.f, 14001, "请求失败", this.b.b, this.b.g);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */