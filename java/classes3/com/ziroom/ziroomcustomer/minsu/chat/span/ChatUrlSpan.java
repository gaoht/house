package com.ziroom.ziroomcustomer.minsu.chat.span;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.b.b.b.a;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.util.u;

public class ChatUrlSpan
  extends ClickableSpan
  implements Parcelable
{
  public static final Parcelable.Creator<ChatUrlSpan> CREATOR = new Parcelable.Creator()
  {
    public ChatUrlSpan createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ChatUrlSpan(paramAnonymousParcel);
    }
    
    public ChatUrlSpan[] newArray(int paramAnonymousInt)
    {
      return new ChatUrlSpan[paramAnonymousInt];
    }
  };
  private final String a;
  
  public ChatUrlSpan(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public ChatUrlSpan(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(View paramView)
  {
    Object localObject = Uri.parse(getURL());
    paramView = paramView.getContext();
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    ((Intent)localObject).putExtra("com.android.browser.application_id", paramView.getPackageName());
    try
    {
      paramView.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      u.e("URLSpan", "Actvity was not found for intent, " + ((Intent)localObject).toString());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getSpanTypeId()
  {
    return getSpanTypeIdInternal();
  }
  
  public int getSpanTypeIdInternal()
  {
    return 11;
  }
  
  public String getURL()
  {
    return this.a;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    String str = getURL();
    String[] arrayOfString = b.b.a.a;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!str.contains(arrayOfString[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        k.goWeb(paramView.getContext(), str, true, false, "", true, true);
        return;
        i += 1;
        break;
      }
      a(paramView);
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#ffa000"));
    paramTextPaint.setUnderlineText(false);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    writeToParcelInternal(paramParcel, paramInt);
  }
  
  public void writeToParcelInternal(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/span/ChatUrlSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */