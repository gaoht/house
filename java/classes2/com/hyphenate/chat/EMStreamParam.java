package com.hyphenate.chat;

import android.view.View;

public class EMStreamParam
{
  protected boolean audioOff = false;
  protected String extension = "";
  protected String name = "AndroidNormal";
  protected View shareView = null;
  protected EMConferenceStream.StreamType streamType = EMConferenceStream.StreamType.NORMAL;
  protected boolean useBackCamera = false;
  protected int videoHeight = 320;
  protected boolean videoOff = false;
  protected int videoWidth = 240;
  
  public String getExtension()
  {
    return this.extension;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public View getShareView()
  {
    return this.shareView;
  }
  
  public EMConferenceStream.StreamType getStreamType()
  {
    return this.streamType;
  }
  
  public int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public boolean isAudioOff()
  {
    return this.audioOff;
  }
  
  public boolean isUseBackCamera()
  {
    return this.useBackCamera;
  }
  
  public boolean isVideoOff()
  {
    return this.videoOff;
  }
  
  public void setAudioOff(boolean paramBoolean)
  {
    this.audioOff = paramBoolean;
  }
  
  public void setExtension(String paramString)
  {
    this.extension = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setShareView(View paramView)
  {
    this.shareView = paramView;
  }
  
  public void setStreamType(EMConferenceStream.StreamType paramStreamType)
  {
    this.streamType = paramStreamType;
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    this.useBackCamera = paramBoolean;
  }
  
  public void setVideoHeight(int paramInt)
  {
    this.videoHeight = paramInt;
  }
  
  public void setVideoOff(boolean paramBoolean)
  {
    this.videoOff = paramBoolean;
  }
  
  public void setVideoWidth(int paramInt)
  {
    this.videoWidth = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMStreamParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */