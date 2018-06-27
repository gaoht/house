package android.support.v4.app;

import android.app.Activity;
import android.support.v4.util.SimpleArrayMap;

public class SupportActivity
  extends Activity
{
  private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
  
  public <T extends ExtraData> T getExtraData(Class<T> paramClass)
  {
    return (ExtraData)this.mExtraDataMap.get(paramClass);
  }
  
  public void putExtraData(ExtraData paramExtraData)
  {
    this.mExtraDataMap.put(paramExtraData.getClass(), paramExtraData);
  }
  
  public static class ExtraData {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/SupportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */