package com.hyphenate.chat.adapter;

public class EMAGroupSetting
  extends EMABase
{
  public static final int EMAGroupStyle_PRIVATE_MEMBER_INVITE = 1;
  public static final int EMAGroupStyle_PRIVATE_OWNER_INVITE = 0;
  public static final int EMAGroupStyle_PUBLIC_ANONYMOUS = 4;
  public static final int EMAGroupStyle_PUBLIC_JOIN_APPROVAL = 2;
  public static final int EMAGroupStyle_PUBLIC_JOIN_OPEN = 3;
  
  public EMAGroupSetting()
  {
    nativeInit(0, 200, false, "");
  }
  
  public EMAGroupSetting(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    nativeInit(paramInt1, paramInt2, paramBoolean, paramString);
  }
  
  public EMAGroupSetting(EMAGroupSetting paramEMAGroupSetting)
  {
    nativeInit(paramEMAGroupSetting);
  }
  
  public String extension()
  {
    return nativeExtension();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public boolean inviteNeedConfirm()
  {
    return nativeInviteNeedConfirm();
  }
  
  public int maxUserCount()
  {
    return nativeMaxUserCount();
  }
  
  native String nativeExtension();
  
  native void nativeFinalize();
  
  native void nativeInit(int paramInt1, int paramInt2, boolean paramBoolean, String paramString);
  
  native void nativeInit(EMAGroupSetting paramEMAGroupSetting);
  
  native boolean nativeInviteNeedConfirm();
  
  native int nativeMaxUserCount();
  
  native void nativeSetMaxUserCount(int paramInt);
  
  native void nativeSetStyle(int paramInt);
  
  native int nativeStyle();
  
  public void setMaxUserCount(int paramInt)
  {
    nativeSetMaxUserCount(paramInt);
  }
  
  public void setStyle(int paramInt)
  {
    nativeSetStyle(paramInt);
  }
  
  public int style()
  {
    return nativeStyle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAGroupSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */