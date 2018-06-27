package com.h;

import android.app.Activity;
import android.content.Intent;
import com.megvii.zhimasdk.MGLoadActivity;
import com.megvii.zhimasdk.d.m;
import java.util.HashMap;

public class a
{
  private static a a = new a();
  private b b;
  
  public static a getInstance()
  {
    return a;
  }
  
  public String getVersion()
  {
    return "ZMCert 1.0.4A";
  }
  
  public void onFinish(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.b != null) {
      this.b.onFinish(paramBoolean1, paramBoolean2, paramInt);
    }
  }
  
  public void setZMCertificationListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void startCertification(Activity paramActivity, String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    m localm = new m();
    localm.a(paramHashMap);
    paramActivity.startActivity(new Intent(paramActivity, MGLoadActivity.class).putExtra("bizno", paramString1).putExtra("merchantid", paramString2).putExtra("extParamsMap", localm));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */