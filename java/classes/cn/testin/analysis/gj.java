package cn.testin.analysis;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class gj
  implements Camera.AutoFocusCallback
{
  gj(gg paramgg) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.a.postDelayed(gg.e(this.a), 1000L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */