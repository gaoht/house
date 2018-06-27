package cn.testin.analysis;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

public class ab
  extends Handler
{
  public ab(aa paramaa, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    try
    {
      aa.h();
      this.a.c();
      aa.a(this.a).b();
      aa.b(this.a).a();
      return;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      String str = paramBundle.getString("variable");
      double d = paramBundle.getDouble("value");
      aa.a(this.a).a(str, d);
      return;
    }
    catch (Exception paramBundle)
    {
      ar.b(paramBundle);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("variable");
      String str2 = paramBundle.getString("variantId");
      String str3 = paramBundle.getString("expId");
      double d = paramBundle.getDouble("value");
      aa.a(this.a).a(str1, d, str2, str3);
      return;
    }
    catch (Exception paramBundle)
    {
      ar.b(paramBundle);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0: 
        a();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      ar.a(paramMessage);
      return;
    }
    a(paramMessage.getData());
    return;
    b(paramMessage.getData());
    return;
    aa.a(this.a).a((Pair)paramMessage.obj);
    return;
    aa.b(this.a).a((String)paramMessage.obj);
    return;
    aa.a(this.a).b();
    return;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */