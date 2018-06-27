package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMACmdMessageBody;
import java.util.Map;

public class EMCmdMessageBody
  extends EMMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMCmdMessageBody> CREATOR = new EMCmdMessageBody.1();
  
  private EMCmdMessageBody(Parcel paramParcel)
  {
    this.emaObject = new EMACmdMessageBody(paramParcel.readString());
  }
  
  EMCmdMessageBody(EMACmdMessageBody paramEMACmdMessageBody)
  {
    this.emaObject = paramEMACmdMessageBody;
  }
  
  public EMCmdMessageBody(String paramString)
  {
    this.emaObject = new EMACmdMessageBody(paramString);
  }
  
  @Deprecated
  public EMCmdMessageBody(String paramString, Map<String, String> paramMap)
  {
    this.emaObject = new EMACmdMessageBody(paramString);
    ((EMACmdMessageBody)this.emaObject).setParams(paramMap);
  }
  
  public String action()
  {
    return ((EMACmdMessageBody)this.emaObject).action();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Map<String, String> getParams()
  {
    return ((EMACmdMessageBody)this.emaObject).params();
  }
  
  public String toString()
  {
    return "cmd:\"" + ((EMACmdMessageBody)this.emaObject).action() + "\"";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMACmdMessageBody)this.emaObject).action());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMCmdMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */