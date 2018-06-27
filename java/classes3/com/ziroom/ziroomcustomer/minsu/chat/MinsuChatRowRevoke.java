package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.minsu.chat.d.i;
import java.util.Date;

public class MinsuChatRowRevoke
  extends MinsuChatRow
{
  private TextView t;
  
  public MinsuChatRowRevoke(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
  }
  
  protected void a(EMMessage paramEMMessage) {}
  
  protected void g()
  {
    if (this.e.getBooleanAttribute("em_revoke", false)) {
      this.b.inflate(2130904922, this);
    }
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131696912));
  }
  
  protected void i() {}
  
  protected void onSetUpView()
  {
    Object localObject = (TextView)findViewById(2131696902);
    if (localObject != null)
    {
      if (this.f != 0) {
        break label70;
      }
      ((TextView)localObject).setText(i.getTimestampString(new Date(this.e.getMsgTime())));
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (EMTextMessageBody)this.e.getBody();
      this.t.setText(((EMTextMessageBody)localObject).getMessage());
      return;
      label70:
      EMMessage localEMMessage = (EMMessage)this.d.getItem(this.f - 1);
      if ((localEMMessage != null) && (i.isCloseEnough(this.e.getMsgTime(), localEMMessage.getMsgTime())))
      {
        ((TextView)localObject).setVisibility(8);
      }
      else
      {
        ((TextView)localObject).setText(i.getTimestampString(new Date(this.e.getMsgTime())));
        ((TextView)localObject).setVisibility(0);
      }
    }
  }
  
  public void setUpView(EMMessage paramEMMessage, int paramInt, d paramd)
  {
    this.e = paramEMMessage;
    this.f = paramInt;
    this.r = paramd;
    onSetUpView();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowRevoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */