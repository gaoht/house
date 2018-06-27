package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import java.io.File;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
{
  public byte[] fileData;
  public String filePath;
  
  public WXFileObject()
  {
    this.fileData = null;
    this.filePath = null;
  }
  
  public WXFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  public WXFileObject(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    if (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)))
    {
      e.b().d("checkArgs fail, both arguments is null", new Object[0]);
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > 10485760))
    {
      e.b().d("checkArgs fail, fileData is too large", new Object[0]);
      return false;
    }
    if ((this.filePath != null) && (new File(this.filePath).length() > 10485760L))
    {
      e.b().d("checkArgs fail, fileSize is too large", new Object[0]);
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
  }
  
  public void setFileData(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public int type()
  {
    return 6;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/WXFileObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */