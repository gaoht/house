package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat
{
  private static final ConnectivityManagerCompatImpl IMPL = new ConnectivityManagerCompatBaseImpl();
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new ConnectivityManagerCompatApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ConnectivityManagerCompatApi16Impl();
      return;
    }
  }
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (paramIntent != null) {
      return paramConnectivityManager.getNetworkInfo(paramIntent.getType());
    }
    return null;
  }
  
  public static int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.getRestrictBackgroundStatus(paramConnectivityManager);
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }
  
  static class ConnectivityManagerCompatApi16Impl
    extends ConnectivityManagerCompat.ConnectivityManagerCompatBaseImpl
  {
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      return paramConnectivityManager.isActiveNetworkMetered();
    }
  }
  
  static class ConnectivityManagerCompatApi24Impl
    extends ConnectivityManagerCompat.ConnectivityManagerCompatApi16Impl
  {
    public int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager)
    {
      return paramConnectivityManager.getRestrictBackgroundStatus();
    }
  }
  
  static class ConnectivityManagerCompatBaseImpl
    implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
  {
    public int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager)
    {
      return 3;
    }
    
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      paramConnectivityManager = paramConnectivityManager.getActiveNetworkInfo();
      if (paramConnectivityManager == null) {
        return true;
      }
      switch (paramConnectivityManager.getType())
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 8: 
      default: 
        return true;
      }
      return false;
    }
  }
  
  static abstract interface ConnectivityManagerCompatImpl
  {
    public abstract int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager);
    
    public abstract boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RestrictBackgroundStatus {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/net/ConnectivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */