package cn.jpush.android.api;

import android.app.Activity;

public class InstrumentedActivity
  extends Activity
{
  protected void onPause()
  {
    super.onPause();
    JPushInterface.onPause(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    JPushInterface.onResume(this);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/InstrumentedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */