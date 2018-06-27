package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class LocationHelper
{
  private DeviceHelper deviceHelper;
  private boolean gpsRequesting;
  private int gpsTimeoutSec;
  private Handler handler = MobHandlerThread.newHandler("h", newCallback());
  private LocationListener listener;
  private LocationManager lm;
  private boolean networkRequesting;
  private int networkTimeoutSec;
  private Location res;
  
  public LocationHelper()
  {
    newLocationListener();
  }
  
  private Handler.Callback newCallback()
  {
    new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        try
        {
          if (!LocationHelper.this.deviceHelper.checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
            break label118;
          }
          if (paramAnonymousMessage.what == 0) {
            LocationHelper.this.onRequest();
          } else if (LocationHelper.this.gpsRequesting) {
            LocationHelper.this.onGPSTimeout();
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          MobLog.getInstance().d(paramAnonymousMessage);
          LocationHelper.this.quit();
        }
        if (LocationHelper.this.networkRequesting)
        {
          if (LocationHelper.this.lm != null) {
            LocationHelper.this.lm.removeUpdates(LocationHelper.this.listener);
          }
          LocationHelper.this.quit();
          break label125;
          label118:
          LocationHelper.this.quit();
        }
        label125:
        return false;
      }
    };
  }
  
  private void newLocationListener()
  {
    this.listener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        VdsAgent.onLocationChanged(this, paramAnonymousLocation);
        try
        {
          synchronized (LocationHelper.this)
          {
            try
            {
              LocationHelper.this.lm.removeUpdates(this);
              LocationHelper.access$802(LocationHelper.this, paramAnonymousLocation);
              LocationHelper.this.notifyAll();
              LocationHelper.this.handler.getLooper().quit();
              return;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                MobLog.getInstance().d(localThrowable);
              }
            }
          }
          return;
        }
        catch (Throwable paramAnonymousLocation)
        {
          MobLog.getInstance().d(paramAnonymousLocation);
        }
      }
      
      public void onProviderDisabled(String paramAnonymousString) {}
      
      public void onProviderEnabled(String paramAnonymousString) {}
      
      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
    };
  }
  
  private void onGPSTimeout()
  {
    int i = 0;
    this.lm.removeUpdates(this.listener);
    this.gpsRequesting = false;
    if (this.networkTimeoutSec != 0) {
      i = 1;
    }
    if ((i != 0) && (this.lm.isProviderEnabled("network")))
    {
      this.networkRequesting = true;
      this.lm.requestLocationUpdates("network", 1000L, 0.0F, this.listener);
      if (this.networkTimeoutSec > 0) {
        this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
      }
      return;
    }
    quit();
  }
  
  private void onRequest()
  {
    int j = 0;
    int i;
    if (this.gpsTimeoutSec != 0)
    {
      i = 1;
      if (this.networkTimeoutSec != 0) {
        j = 1;
      }
      if (this.lm == null) {
        break label198;
      }
      if ((i == 0) || (!this.lm.isProviderEnabled("gps"))) {
        break label115;
      }
      this.gpsRequesting = true;
    }
    for (;;)
    {
      try
      {
        this.lm.requestLocationUpdates("gps", 1000L, 0.0F, this.listener);
        if (this.gpsTimeoutSec > 0) {
          this.handler.sendEmptyMessageDelayed(1, this.gpsTimeoutSec * 1000);
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        MobLog.getInstance().w(localThrowable1);
        this.handler.sendEmptyMessage(1);
        return;
      }
      i = 0;
      break;
      label115:
      if ((j != 0) && (this.lm.isProviderEnabled("network")))
      {
        this.networkRequesting = true;
        try
        {
          this.lm.requestLocationUpdates("network", 1000L, 0.0F, this.listener);
          if (this.networkTimeoutSec > 0)
          {
            this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
            return;
          }
        }
        catch (Throwable localThrowable2)
        {
          MobLog.getInstance().w(localThrowable2);
          this.handler.sendEmptyMessage(1);
          return;
        }
      }
    }
    label198:
    quit();
  }
  
  private void quit()
  {
    try
    {
      try
      {
        notifyAll();
        this.handler.getLooper().quit();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
  }
  
  public Location getLocation(Context paramContext)
    throws Throwable
  {
    return getLocation(paramContext, 0);
  }
  
  public Location getLocation(Context paramContext, int paramInt)
    throws Throwable
  {
    return getLocation(paramContext, paramInt, 0);
  }
  
  public Location getLocation(Context paramContext, int paramInt1, int paramInt2)
    throws Throwable
  {
    return getLocation(paramContext, paramInt1, paramInt2, true);
  }
  
  public Location getLocation(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
    throws Throwable
  {
    this.deviceHelper = DeviceHelper.getInstance(paramContext);
    this.gpsTimeoutSec = paramInt1;
    this.networkTimeoutSec = paramInt2;
    this.lm = ((LocationManager)paramContext.getSystemService("location"));
    if (this.lm == null) {
      return null;
    }
    try
    {
      this.handler.sendEmptyMessageDelayed(0, 50L);
      wait();
      if ((this.res == null) && (paramBoolean))
      {
        this.res = this.lm.getLastKnownLocation("gps");
        if (this.res == null) {
          this.res = this.lm.getLastKnownLocation("network");
        }
      }
      return this.res;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/LocationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */