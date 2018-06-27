package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMAFileMessageBody.EMADownloadStatus;
import com.hyphenate.chat.adapter.message.EMAImageMessageBody;
import java.io.File;

public class EMImageMessageBody
  extends EMFileMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMImageMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMImageMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMImageMessageBody(paramAnonymousParcel, null);
    }
    
    public EMImageMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMImageMessageBody[paramAnonymousInt];
    }
  };
  private boolean sendOriginalImage = false;
  
  private EMImageMessageBody(Parcel paramParcel)
  {
    super("", 1);
    ((EMAImageMessageBody)this.emaObject).setDisplayName(paramParcel.readString());
    ((EMAImageMessageBody)this.emaObject).setLocalPath(paramParcel.readString());
    ((EMAImageMessageBody)this.emaObject).setRemotePath(paramParcel.readString());
    ((EMAImageMessageBody)this.emaObject).setThumbnailRemotePath(paramParcel.readString());
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    ((EMAImageMessageBody)this.emaObject).setSize(i, j);
  }
  
  public EMImageMessageBody(EMAImageMessageBody paramEMAImageMessageBody)
  {
    super(paramEMAImageMessageBody);
  }
  
  public EMImageMessageBody(File paramFile)
  {
    super(paramFile.getAbsolutePath(), 1);
  }
  
  public EMImageMessageBody(File paramFile1, File paramFile2)
  {
    super(paramFile1.getAbsolutePath(), 1);
    ((EMAImageMessageBody)this.emaObject).setThumbnailLocalPath(paramFile2.getAbsolutePath());
  }
  
  EMImageMessageBody(String paramString1, String paramString2, String paramString3)
  {
    super("", 1);
    this.emaObject = new EMAImageMessageBody("", "");
    ((EMAImageMessageBody)this.emaObject).setDisplayName(paramString1);
    ((EMAImageMessageBody)this.emaObject).setRemotePath(paramString2);
    ((EMAImageMessageBody)this.emaObject).setThumbnailRemotePath(paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getFileName()
  {
    return ((EMAImageMessageBody)this.emaObject).displayName();
  }
  
  public int getHeight()
  {
    return ((EMAImageMessageBody)this.emaObject).height();
  }
  
  public String getThumbnailSecret()
  {
    return ((EMAImageMessageBody)this.emaObject).thumbnailSecretKey();
  }
  
  public String getThumbnailUrl()
  {
    return ((EMAImageMessageBody)this.emaObject).thumbnailRemotePath();
  }
  
  public int getWidth()
  {
    return ((EMAImageMessageBody)this.emaObject).width();
  }
  
  public boolean isSendOriginalImage()
  {
    return this.sendOriginalImage;
  }
  
  public void setSendOriginalImage(boolean paramBoolean)
  {
    this.sendOriginalImage = paramBoolean;
  }
  
  void setSize(int paramInt1, int paramInt2)
  {
    ((EMAImageMessageBody)this.emaObject).setSize(paramInt1, paramInt2);
  }
  
  void setThumbnailDownloadStatus(EMFileMessageBody.EMDownloadStatus paramEMDownloadStatus)
  {
    ((EMAImageMessageBody)this.emaObject).setThumbnailDownloadStatus(EMAFileMessageBody.EMADownloadStatus.valueOf(paramEMDownloadStatus.name()));
  }
  
  public void setThumbnailLocalPath(String paramString)
  {
    ((EMAImageMessageBody)this.emaObject).setThumbnailLocalPath(paramString);
  }
  
  public void setThumbnailSecret(String paramString)
  {
    ((EMAImageMessageBody)this.emaObject).setThumbnailSecretKey(paramString);
  }
  
  public void setThumbnailUrl(String paramString)
  {
    ((EMAImageMessageBody)this.emaObject).setThumbnailRemotePath(paramString);
  }
  
  public EMFileMessageBody.EMDownloadStatus thumbnailDownloadStatus()
  {
    EMAFileMessageBody.EMADownloadStatus localEMADownloadStatus = ((EMAImageMessageBody)this.emaObject).thumbnailDownloadStatus();
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
  
  public String thumbnailLocalPath()
  {
    return ((EMAImageMessageBody)this.emaObject).thumbnailLocalPath();
  }
  
  public String toString()
  {
    return "image: " + ((EMAImageMessageBody)this.emaObject).displayName() + ", localurl: " + ((EMAImageMessageBody)this.emaObject).getLocalUrl() + ", remoteurl: " + ((EMAImageMessageBody)this.emaObject).getRemoteUrl() + ", thumbnail: " + ((EMAImageMessageBody)this.emaObject).thumbnailRemotePath();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMAImageMessageBody)this.emaObject).displayName());
    paramParcel.writeString(((EMAImageMessageBody)this.emaObject).getLocalUrl());
    paramParcel.writeString(((EMAImageMessageBody)this.emaObject).getRemoteUrl());
    paramParcel.writeString(((EMAImageMessageBody)this.emaObject).thumbnailRemotePath());
    paramParcel.writeInt(((EMAImageMessageBody)this.emaObject).width());
    paramParcel.writeInt(((EMAImageMessageBody)this.emaObject).height());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMImageMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */