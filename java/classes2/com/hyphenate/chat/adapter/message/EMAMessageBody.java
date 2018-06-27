package com.hyphenate.chat.adapter.message;

import com.hyphenate.chat.adapter.EMABase;

public abstract class EMAMessageBody
  extends EMABase
{
  public static final int EMAMessageBodyType_COMMAND = 6;
  public static final int EMAMessageBodyType_FILE = 5;
  public static final int EMAMessageBodyType_IMAGE = 1;
  public static final int EMAMessageBodyType_LOCATION = 3;
  public static final int EMAMessageBodyType_TEXT = 0;
  public static final int EMAMessageBodyType_VIDEO = 2;
  public static final int EMAMessageBodyType_VOICE = 4;
  public int type = 0;
  
  public native int nativeType();
  
  public int type()
  {
    return nativeType();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMAMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */