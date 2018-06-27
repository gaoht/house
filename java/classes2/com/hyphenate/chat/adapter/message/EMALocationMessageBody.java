package com.hyphenate.chat.adapter.message;

public class EMALocationMessageBody
  extends EMAMessageBody
{
  public String address;
  public double latitude;
  public double longitude;
  
  private EMALocationMessageBody()
  {
    nativeInit(0.0D, 0.0D, "");
  }
  
  public EMALocationMessageBody(double paramDouble1, double paramDouble2, String paramString)
  {
    nativeInit(paramDouble1, paramDouble2, paramString);
  }
  
  public EMALocationMessageBody(EMALocationMessageBody paramEMALocationMessageBody)
  {
    nativeInit(paramEMALocationMessageBody);
  }
  
  public String address()
  {
    return nativeaddress();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public double latitude()
  {
    return nativelatitude();
  }
  
  public double longitude()
  {
    return nativelongitude();
  }
  
  native void nativeFinalize();
  
  native void nativeInit(double paramDouble1, double paramDouble2, String paramString);
  
  native void nativeInit(EMALocationMessageBody paramEMALocationMessageBody);
  
  native String nativeaddress();
  
  native double nativelatitude();
  
  native double nativelongitude();
  
  native void nativesetAddress(String paramString);
  
  native void nativesetLatitude(double paramDouble);
  
  native void nativesetLongitude(double paramDouble);
  
  public void setAddress(String paramString)
  {
    nativesetAddress(paramString);
  }
  
  public void setLatitude(double paramDouble)
  {
    nativesetLatitude(paramDouble);
  }
  
  public void setLongitude(double paramDouble)
  {
    nativesetLongitude(paramDouble);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMALocationMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */