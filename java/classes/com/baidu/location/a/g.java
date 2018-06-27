package com.baidu.location.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.d;
import com.baidu.location.d.e;
import com.baidu.location.f;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class g
{
  public static String c = null;
  public com.baidu.location.b.g a = null;
  public com.baidu.location.b.a b = null;
  final Handler d = new a();
  private boolean e = true;
  private boolean f = false;
  private String g = null;
  
  public String a(String paramString)
  {
    if (this.g == null) {
      this.g = h.b(f.getServiceContext());
    }
    if ((this.b == null) || (!this.b.a())) {
      this.b = b.a().f();
    }
    if ((this.a == null) || (!this.a.f())) {
      this.a = com.baidu.location.b.h.a().m();
    }
    if (d.a().i()) {}
    for (paramString = d.a().g();; paramString = null)
    {
      if (((this.b == null) || (this.b.c())) && ((this.a == null) || (this.a.a() == 0)) && (paramString == null)) {
        return null;
      }
      String str = b();
      return com.baidu.location.d.j.a(this.b, this.a, paramString, str, 0);
    }
  }
  
  public abstract void a();
  
  public abstract void a(Message paramMessage);
  
  public String b()
  {
    String str3 = a.a().c();
    String str1;
    String str4;
    String str2;
    if (com.baidu.location.b.h.h())
    {
      str1 = "&cn=32";
      if (!this.e) {
        break label144;
      }
      this.e = false;
      str4 = com.baidu.location.b.h.a().o();
      str2 = str1;
      if (!TextUtils.isEmpty(str4))
      {
        str2 = str1;
        if (!str4.equals("02:00:00:00:00:00"))
        {
          str2 = str4.replace(":", "");
          str2 = String.format(Locale.CHINA, "%s&mac=%s", new Object[] { str1, str2 });
        }
      }
      if (Build.VERSION.SDK_INT <= 17) {}
    }
    for (;;)
    {
      return str2 + str3;
      str1 = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(b.a().e()) });
      break;
      label144:
      str2 = str1;
      if (!this.f)
      {
        str4 = s.f();
        str2 = str1;
        if (str4 != null) {
          str2 = str1 + str4;
        }
        this.f = true;
      }
    }
  }
  
  public class a
    extends Handler
  {
    public a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!f.isServing) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 21: 
        g.this.a(paramMessage);
        return;
      }
      g.this.a();
    }
  }
  
  class b
    extends e
  {
    String a = null;
    String b = null;
    
    public b()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = com.baidu.location.d.j.c();
      Object localObject = Jni.encodeTp4(this.b);
      this.b = null;
      if (this.a == null) {
        this.a = s.b();
      }
      this.k.put("bloc", localObject);
      if (this.a != null) {
        this.k.put("up", this.a);
      }
      localObject = new StringBuffer(512);
      if (((com.baidu.location.d.j.g) || (com.baidu.location.d.j.h)) && (g.a(g.this) != null)) {
        ((StringBuffer)localObject).append(String.format(Locale.CHINA, "&ki=%s", new Object[] { g.a(g.this) }));
      }
      if (((StringBuffer)localObject).length() > 0) {
        this.k.put("ext", Jni.encode(((StringBuffer)localObject).toString()));
      }
      localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.k.put("trtm", localObject);
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
      e();
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.j;
            g.c = (String)localObject1;
          }
          catch (Exception localException2)
          {
            Object localObject1;
            localMessage = g.this.d.obtainMessage(63);
            localMessage.obj = "HttpStatus error";
            localMessage.sendToTarget();
            continue;
            Object localObject2 = g.this.d.obtainMessage(21);
            ((Message)localObject2).obj = localMessage;
            ((Message)localObject2).sendToTarget();
            continue;
          }
          try
          {
            localObject2 = new BDLocation((String)localObject1);
            ((BDLocation)localObject2).setOperators(b.a().h());
            localObject1 = localObject2;
            if (j.a().f())
            {
              ((BDLocation)localObject2).setDirection(j.a().h());
              localObject1 = localObject2;
            }
          }
          catch (Exception localException1)
          {
            localBDLocation = new BDLocation();
            localBDLocation.setLocType(0);
          }
        }
        this.a = null;
        if ((((BDLocation)localObject1).getLocType() == 0) && (((BDLocation)localObject1).getLatitude() == Double.MIN_VALUE) && (((BDLocation)localObject1).getLongitude() == Double.MIN_VALUE))
        {
          localObject1 = g.this.d.obtainMessage(63);
          ((Message)localObject1).obj = "HttpStatus error";
          ((Message)localObject1).sendToTarget();
        }
      }
      for (;;)
      {
        if (this.k != null) {
          this.k.clear();
        }
        return;
        BDLocation localBDLocation;
        Message localMessage = g.this.d.obtainMessage(63);
        localMessage.obj = "HttpStatus error";
        localMessage.sendToTarget();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */