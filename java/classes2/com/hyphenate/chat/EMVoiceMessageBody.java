package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMAVoiceMessageBody;
import com.hyphenate.util.EMLog;
import java.io.File;

public class EMVoiceMessageBody
  extends EMFileMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMVoiceMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMVoiceMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMVoiceMessageBody(paramAnonymousParcel, null);
    }
    
    public EMVoiceMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMVoiceMessageBody[paramAnonymousInt];
    }
  };
  
  private EMVoiceMessageBody(Parcel paramParcel)
  {
    super("", 4);
    ((EMAVoiceMessageBody)this.emaObject).setDisplayName(paramParcel.readString());
    ((EMAVoiceMessageBody)this.emaObject).setLocalPath(paramParcel.readString());
    ((EMAVoiceMessageBody)this.emaObject).setRemotePath(paramParcel.readString());
    ((EMAVoiceMessageBody)this.emaObject).setDuration(paramParcel.readInt());
  }
  
  public EMVoiceMessageBody(EMAVoiceMessageBody paramEMAVoiceMessageBody)
  {
    super(paramEMAVoiceMessageBody);
  }
  
  public EMVoiceMessageBody(File paramFile, int paramInt)
  {
    super(paramFile.getAbsolutePath(), 4);
    ((EMAVoiceMessageBody)this.emaObject).setDuration(paramInt);
    EMLog.d("voicemsg", "create voice, message body for:" + paramFile.getAbsolutePath());
  }
  
  EMVoiceMessageBody(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, 4);
    ((EMAVoiceMessageBody)this.emaObject).setLocalPath(paramString1);
    ((EMAVoiceMessageBody)this.emaObject).setRemotePath(paramString2);
    ((EMAVoiceMessageBody)this.emaObject).setDuration(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getLength()
  {
    return ((EMAVoiceMessageBody)this.emaObject).duration();
  }
  
  public String toString()
  {
    return "voice:" + ((EMAVoiceMessageBody)this.emaObject).displayName() + ",localurl:" + ((EMAVoiceMessageBody)this.emaObject).getLocalUrl() + ",remoteurl:" + ((EMAVoiceMessageBody)this.emaObject).getRemoteUrl() + ",length:" + ((EMAVoiceMessageBody)this.emaObject).duration();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMAVoiceMessageBody)this.emaObject).displayName());
    paramParcel.writeString(((EMAVoiceMessageBody)this.emaObject).getLocalUrl());
    paramParcel.writeString(((EMAVoiceMessageBody)this.emaObject).getRemoteUrl());
    paramParcel.writeInt(((EMAVoiceMessageBody)this.emaObject).duration());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMVoiceMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */