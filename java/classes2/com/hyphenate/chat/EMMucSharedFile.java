package com.hyphenate.chat;

import com.hyphenate.chat.adapter.EMAMucShareFile;

public class EMMucSharedFile
  extends EMBase<EMAMucShareFile>
{
  public EMMucSharedFile()
  {
    this.emaObject = new EMAMucShareFile();
  }
  
  public EMMucSharedFile(EMAMucShareFile paramEMAMucShareFile)
  {
    this.emaObject = new EMAMucShareFile(paramEMAMucShareFile);
  }
  
  public String getFileId()
  {
    return ((EMAMucShareFile)this.emaObject).getFileId();
  }
  
  public String getFileName()
  {
    return ((EMAMucShareFile)this.emaObject).getFileName();
  }
  
  public String getFileOwner()
  {
    return ((EMAMucShareFile)this.emaObject).getFileOwner();
  }
  
  public long getFileSize()
  {
    return ((EMAMucShareFile)this.emaObject).getFileSize();
  }
  
  public long getFileUpdateTime()
  {
    return ((EMAMucShareFile)this.emaObject).getUpdateTime();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMMucSharedFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */