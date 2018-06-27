package cn.jiguang.api;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.nio.ByteBuffer;

public abstract interface JAction
{
  public abstract long dispatchMessage(Context paramContext, long paramLong, int paramInt, Object paramObject, ByteBuffer paramByteBuffer);
  
  public abstract void dispatchTimeOutMessage(Context paramContext, long paramLong1, long paramLong2, int paramInt);
  
  public abstract IBinder getBinderByType(String paramString);
  
  public abstract String getSdkVersion();
  
  public abstract void handleMessage(Context paramContext, long paramLong, Object paramObject);
  
  public abstract boolean isSupportedCMD(int paramInt);
  
  public abstract void onActionRun(Context paramContext, long paramLong, Bundle paramBundle, Object paramObject);
  
  public abstract void onEvent(Context paramContext, long paramLong, int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */