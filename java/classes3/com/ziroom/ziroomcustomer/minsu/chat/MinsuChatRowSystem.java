package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.minsu.chat.d.i;
import java.util.Date;

public class MinsuChatRowSystem
  extends MinsuChatRow
{
  private TextView t;
  private Activity u;
  
  public MinsuChatRowSystem(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
    this.u = paramActivity;
  }
  
  protected void a()
  {
    TextView localTextView = (TextView)findViewById(2131696902);
    if (localTextView != null)
    {
      if (this.f == 0)
      {
        localTextView.setText(i.getTimestampString(new Date(this.e.getMsgTime())));
        localTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    EMMessage localEMMessage = (EMMessage)this.d.getItem(this.f - 1);
    if ((localEMMessage != null) && (i.isCloseEnough(this.e.getMsgTime(), localEMMessage.getMsgTime())))
    {
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setText(i.getTimestampString(new Date(this.e.getMsgTime())));
    localTextView.setVisibility(0);
  }
  
  protected void a(EMMessage paramEMMessage) {}
  
  protected void g()
  {
    this.b.inflate(2130904930, this);
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131696913));
  }
  
  protected void i()
  {
    if ((this.d instanceof g))
    {
      ((g)this.d).refresh();
      return;
    }
    this.d.notifyDataSetChanged();
  }
  
  protected void j()
  {
    if (this.e.direct() == EMMessage.Direct.SEND)
    {
      d();
      switch (1.a[this.e.status().ordinal()])
      {
      }
    }
    while ((this.e.isAcked()) || (this.e.getChatType() != EMMessage.ChatType.Chat) || (this.e.getBooleanAttribute("em_readFire", false)))
    {
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      return;
      this.l.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    try
    {
      EMClient.getInstance().chatManager().ackMessageRead(this.e.getFrom(), this.e.getMsgId());
      this.e.setAcked(true);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  public void onSetUpView()
  {
    try
    {
      EMTextMessageBody localEMTextMessageBody = (EMTextMessageBody)this.e.getBody();
      this.t.setText(localEMTextMessageBody.getMessage());
      j();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void setUpView(EMMessage paramEMMessage, int paramInt, d paramd)
  {
    this.e = paramEMMessage;
    this.f = paramInt;
    this.r = paramd;
    a();
    onSetUpView();
    super.f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */