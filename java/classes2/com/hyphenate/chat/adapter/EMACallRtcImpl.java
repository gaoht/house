package com.hyphenate.chat.adapter;

import com.hyphenate.chat.EMCallManager;
import com.hyphenate.util.EMLog;
import com.superrtc.sdk.d;
import org.json.JSONException;
import org.json.JSONObject;

public class EMACallRtcImpl
  implements EMACallRtcInterface
{
  public static final String TAG = "EMACallRtcImpl";
  EMCallManager callManager;
  d rtcConnection;
  
  public void answer()
  {
    this.rtcConnection.answer();
  }
  
  public void createOffer()
  {
    this.rtcConnection.createOffer();
  }
  
  public d getConnection()
  {
    return this.rtcConnection;
  }
  
  public String getDefaultConfig(int paramInt)
  {
    new JSONObject();
    return "{}";
  }
  
  public String getRtcId()
  {
    return this.rtcConnection.getName();
  }
  
  public String getRtcReport()
  {
    try
    {
      String str = this.rtcConnection.getReportString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONException.toString();
    }
  }
  
  public String getSubConfig()
  {
    return "{}";
  }
  
  public void hangup()
  {
    EMLog.d("EMACallRtcImpl", "hangup");
    this.rtcConnection.hangup();
    if (this.callManager != null) {
      this.callManager.clearRtcConnection();
    }
  }
  
  public void setConfigJson(String paramString)
  {
    EMLog.d("EMACallRtcImpl", "setConfigJson:" + paramString);
    if ((paramString != null) && (paramString.isEmpty())) {}
    this.rtcConnection.setConfigure(paramString);
  }
  
  public void setRemoteJson(String paramString)
  {
    try
    {
      EMLog.d("EMACallRtcImpl", "setRemoteJson:" + paramString);
      this.rtcConnection.setRemoteJson(new String(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setRtcConnection(EMCallManager paramEMCallManager, d paramd)
  {
    this.callManager = paramEMCallManager;
    this.rtcConnection = paramd;
  }
  
  public void setStatsEnable(boolean paramBoolean)
  {
    this.rtcConnection.setStatsEnable(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallRtcImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */