package cn.testin.analysis;

import android.hardware.Camera;
import android.text.TextUtils;

class go
  extends gk
{
  go(gn paramgn, Camera paramCamera1, byte[] paramArrayOfByte, gl paramgl, Camera paramCamera2)
  {
    super(paramCamera1, paramArrayOfByte, paramgl);
  }
  
  protected void a(String paramString)
  {
    if ((!this.b.f) || ((this.b.d != null) && (!TextUtils.isEmpty(paramString)))) {}
    for (;;)
    {
      try
      {
        this.b.d.a(paramString);
        return;
      }
      catch (Exception paramString) {}
      try
      {
        this.a.setOneShotPreviewCallback(this.b);
        return;
      }
      catch (Exception paramString) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */