package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.minsu.chat.d.k;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;

public class MinsuChatRowStationText
  extends MinsuChatRow
{
  private TextView t;
  private k u;
  
  public MinsuChatRowStationText(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter, k paramk)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
    this.u = paramk;
  }
  
  protected void a(EMMessage paramEMMessage) {}
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904934;; i = 2130904935)
    {
      localLayoutInflater.inflate(i, this);
      return;
    }
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131696912));
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
    Object localObject = (EMTextMessageBody)this.e.getBody();
    localObject = SmileUtils.getSmiledText(this.c, ((EMTextMessageBody)localObject).getMessage());
    this.t.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
    ac.addInnerLink(this.t);
    j();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowStationText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */