package com.huawei.hms.api;

public abstract class HuaweiApiClient
{
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void setConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public static abstract interface ConnectionCallbacks
  {
    public abstract void onConnected();
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/api/HuaweiApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */