package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMAFileMessageBody;
import java.io.File;

public class EMNormalFileMessageBody
  extends EMFileMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMNormalFileMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMNormalFileMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMNormalFileMessageBody(paramAnonymousParcel, null);
    }
    
    public EMNormalFileMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMNormalFileMessageBody[paramAnonymousInt];
    }
  };
  
  public EMNormalFileMessageBody()
  {
    super("");
  }
  
  private EMNormalFileMessageBody(Parcel paramParcel)
  {
    super("");
    ((EMAFileMessageBody)this.emaObject).setDisplayName(paramParcel.readString());
    ((EMAFileMessageBody)this.emaObject).setLocalPath(paramParcel.readString());
    ((EMAFileMessageBody)this.emaObject).setRemotePath(paramParcel.readString());
    ((EMAFileMessageBody)this.emaObject).setFileLength(paramParcel.readLong());
    ((EMAFileMessageBody)this.emaObject).setSecretKey(paramParcel.readString());
  }
  
  EMNormalFileMessageBody(EMAFileMessageBody paramEMAFileMessageBody)
  {
    super(paramEMAFileMessageBody);
  }
  
  public EMNormalFileMessageBody(File paramFile)
  {
    super(paramFile.getAbsolutePath());
  }
  
  EMNormalFileMessageBody(String paramString1, String paramString2)
  {
    super(paramString1);
    super.setRemoteUrl(paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getFileSize()
  {
    return ((EMAFileMessageBody)this.emaObject).fileLength();
  }
  
  public String toString()
  {
    return "normal file:" + ((EMAFileMessageBody)this.emaObject).displayName() + ",localUrl:" + ((EMAFileMessageBody)this.emaObject).getLocalUrl() + ",remoteUrl:" + ((EMAFileMessageBody)this.emaObject).getRemoteUrl() + ",file size:" + ((EMAFileMessageBody)this.emaObject).fileLength();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMAFileMessageBody)this.emaObject).displayName());
    paramParcel.writeString(((EMAFileMessageBody)this.emaObject).getLocalUrl());
    paramParcel.writeString(((EMAFileMessageBody)this.emaObject).getRemoteUrl());
    paramParcel.writeLong(((EMAFileMessageBody)this.emaObject).fileLength());
    paramParcel.writeString(((EMAFileMessageBody)this.emaObject).getSecret());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMNormalFileMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */