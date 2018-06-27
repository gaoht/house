package com.baidu.trace;

public final class TraceJniInterface
{
  private static final TraceJniInterface a = new TraceJniInterface();
  
  static
  {
    av.a().a("BaiduTraceSDK_v3_0_7");
  }
  
  protected static TraceJniInterface a()
  {
    return a;
  }
  
  public static native void clearTrackData();
  
  public static native double[] gcjToBaidu(double paramDouble1, double paramDouble2);
  
  public static native double[] processTrackPoint(double paramDouble1, double paramDouble2, double paramDouble3, long paramLong, int paramInt);
  
  public static native double[] wgsToBaidu(double paramDouble1, double paramDouble2);
  
  protected final native void addAttributeData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  protected final native void addCustomData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  protected final native void addNearbyCell(int paramInt1, int paramInt2);
  
  protected final native void addWifiData(byte[] paramArrayOfByte1, byte paramByte1, byte[] paramArrayOfByte2, byte paramByte2);
  
  protected final native byte[] buildHeartbeatData();
  
  protected final native byte[] buildLocationData(int paramInt);
  
  protected final native byte[] buildRequestProtocolData(short paramShort, int paramInt);
  
  protected final native void clearAttributeData();
  
  protected final native void clearBluetoothData();
  
  protected final native void clearCustomData();
  
  protected final native void clearNearbyCells();
  
  protected final native void clearWifiData();
  
  protected final native byte[] parseResponseProtocolData(byte[] paramArrayOfByte);
  
  protected final native void setAppInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4);
  
  protected final native void setCellData(byte paramByte1, byte paramByte2, short paramShort1, short paramShort2, int paramInt1, int paramInt2);
  
  protected final native void setDeviceInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8);
  
  protected final native void setGPSData(byte paramByte1, short paramShort1, byte paramByte2, short paramShort2, short paramShort3, int paramInt1, int paramInt2);
  
  protected final native void setPackData(byte paramByte, byte[] paramArrayOfByte);
  
  protected final native void setPushResult(int paramInt, byte paramByte);
  
  protected final native void socketDisconnection();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/TraceJniInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */