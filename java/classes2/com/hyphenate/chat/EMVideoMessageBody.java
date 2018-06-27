package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMAFileMessageBody.EMADownloadStatus;
import com.hyphenate.chat.adapter.message.EMAVideoMessageBody;
import com.hyphenate.util.EMLog;

public class EMVideoMessageBody
  extends EMFileMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMVideoMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMVideoMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMVideoMessageBody(paramAnonymousParcel, null);
    }
    
    public EMVideoMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMVideoMessageBody[paramAnonymousInt];
    }
  };
  
  public EMVideoMessageBody()
  {
    super("", 2);
  }
  
  private EMVideoMessageBody(Parcel paramParcel)
  {
    super("", 2);
    ((EMAVideoMessageBody)this.emaObject).setDisplayName(paramParcel.readString());
    ((EMAVideoMessageBody)this.emaObject).setLocalPath(paramParcel.readString());
    ((EMAVideoMessageBody)this.emaObject).setRemotePath(paramParcel.readString());
    ((EMAVideoMessageBody)this.emaObject).setThumbnailRemotePath(paramParcel.readString());
    ((EMAVideoMessageBody)this.emaObject).setThumbnailLocalPath(paramParcel.readString());
    ((EMAVideoMessageBody)this.emaObject).setDuration(paramParcel.readInt());
    ((EMAVideoMessageBody)this.emaObject).setFileLength(paramParcel.readLong());
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    ((EMAVideoMessageBody)this.emaObject).setSize(i, j);
  }
  
  public EMVideoMessageBody(EMAVideoMessageBody paramEMAVideoMessageBody)
  {
    super(paramEMAVideoMessageBody);
  }
  
  public EMVideoMessageBody(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    super(paramString1, 2);
    ((EMAVideoMessageBody)this.emaObject).setThumbnailLocalPath(paramString2);
    ((EMAVideoMessageBody)this.emaObject).setDuration(paramInt);
    ((EMAVideoMessageBody)this.emaObject).setFileLength(paramLong);
    EMLog.d("videomsg", "create video, message body for:" + paramString1);
  }
  
  EMVideoMessageBody(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1, 2);
    ((EMAVideoMessageBody)this.emaObject).setThumbnailLocalPath(paramString3);
    ((EMAVideoMessageBody)this.emaObject).setLocalPath(paramString1);
    ((EMAVideoMessageBody)this.emaObject).setRemotePath(paramString2);
    ((EMAVideoMessageBody)this.emaObject).setThumbnailRemotePath(paramString3);
    ((EMAVideoMessageBody)this.emaObject).setFileLength(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDuration()
  {
    return ((EMAVideoMessageBody)this.emaObject).duration();
  }
  
  public String getLocalThumb()
  {
    return ((EMAVideoMessageBody)this.emaObject).thumbnailLocalPath();
  }
  
  public int getThumbnailHeight()
  {
    return ((EMAVideoMessageBody)this.emaObject).height();
  }
  
  public String getThumbnailSecret()
  {
    return ((EMAVideoMessageBody)this.emaObject).thumbnailSecretKey();
  }
  
  public String getThumbnailUrl()
  {
    return ((EMAVideoMessageBody)this.emaObject).thumbnailRemotePath();
  }
  
  public int getThumbnailWidth()
  {
    return ((EMAVideoMessageBody)this.emaObject).width();
  }
  
  public long getVideoFileLength()
  {
    return ((EMAVideoMessageBody)this.emaObject).fileLength();
  }
  
  public void setLocalThumb(String paramString)
  {
    ((EMAVideoMessageBody)this.emaObject).setThumbnailLocalPath(paramString);
  }
  
  void setThumbnailDownloadStatus(EMFileMessageBody.EMDownloadStatus paramEMDownloadStatus)
  {
    ((EMAVideoMessageBody)this.emaObject).setThumbnailDownloadStatus(EMAFileMessageBody.EMADownloadStatus.valueOf(paramEMDownloadStatus.name()));
  }
  
  public void setThumbnailSecret(String paramString)
  {
    ((EMAVideoMessageBody)this.emaObject).setThumbnailSecretKey(paramString);
  }
  
  public void setThumbnailSize(int paramInt1, int paramInt2)
  {
    ((EMAVideoMessageBody)this.emaObject).setSize(paramInt1, paramInt2);
  }
  
  public void setThumbnailUrl(String paramString)
  {
    ((EMAVideoMessageBody)this.emaObject).setThumbnailRemotePath(paramString);
  }
  
  public void setVideoFileLength(long paramLong)
  {
    ((EMAVideoMessageBody)this.emaObject).setFileLength(paramLong);
  }
  
  public EMFileMessageBody.EMDownloadStatus thumbnailDownloadStatus()
  {
    EMAFileMessageBody.EMADownloadStatus localEMADownloadStatus = ((EMAVideoMessageBody)this.emaObject).thumbnailDownloadStatus();
    switch (localEMADownloadStatus)
    {
    default: 
      return EMFileMessageBody.EMDownloadStatus.SUCCESSED;
    case ???: 
      return EMFileMessageBody.EMDownloadStatus.DOWNLOADING;
    case ???: 
      return EMFileMessageBody.EMDownloadStatus.SUCCESSED;
    case ???: 
      return EMFileMessageBody.EMDownloadStatus.FAILED;
    }
    return EMFileMessageBody.EMDownloadStatus.PENDING;
  }
  
  public String toString()
  {
    return "video: " + ((EMAVideoMessageBody)this.emaObject).displayName() + ", localUrl: " + ((EMAVideoMessageBody)this.emaObject).getLocalUrl() + ", remoteUrl: " + ((EMAVideoMessageBody)this.emaObject).getRemoteUrl() + ", thumbnailUrl: " + ((EMAVideoMessageBody)this.emaObject).thumbnailLocalPath() + ", length: " + ((EMAVideoMessageBody)this.emaObject).fileLength();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMAVideoMessageBody)this.emaObject).displayName());
    paramParcel.writeString(((EMAVideoMessageBody)this.emaObject).getLocalUrl());
    paramParcel.writeString(((EMAVideoMessageBody)this.emaObject).getRemoteUrl());
    paramParcel.writeString(((EMAVideoMessageBody)this.emaObject).thumbnailLocalPath());
    paramParcel.writeString(((EMAVideoMessageBody)this.emaObject).thumbnailLocalPath());
    paramParcel.writeInt(((EMAVideoMessageBody)this.emaObject).duration());
    paramParcel.writeLong(((EMAVideoMessageBody)this.emaObject).fileLength());
    paramParcel.writeInt(((EMAVideoMessageBody)this.emaObject).width());
    paramParcel.writeInt(((EMAVideoMessageBody)this.emaObject).height());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMVideoMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */