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
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import java.util.Map;

public class MinsuChatRowText
  extends MinsuChatRow
{
  private TextView t;
  
  public MinsuChatRowText(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
  }
  
  protected void a(EMMessage paramEMMessage) {}
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904919;; i = 2130904928)
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
    Object localObject3;
    Object localObject2;
    String str1;
    String str2;
    long l;
    Map localMap;
    try
    {
      Object localObject1 = (EMTextMessageBody)this.e.getBody();
      localObject1 = SmileUtils.getSmiledText(this.c, ((EMTextMessageBody)localObject1).getMessage());
      this.t.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      ac.addInnerLink(this.t);
      j();
      return;
    }
    catch (Exception localException)
    {
      localObject3 = this.e;
      localObject2 = ((EMMessage)localObject3).direct();
      str1 = ((EMMessage)localObject3).getTo();
      str2 = ((EMMessage)localObject3).getFrom();
      l = ((EMMessage)localObject3).getMsgTime();
      localObject3 = ((EMMessage)localObject3).getMsgId();
      localMap = this.e.ext();
      if (localObject2 != EMMessage.Direct.SEND) {
        break label134;
      }
    }
    this.e = j.createSentTextMsg(str2, str1, "不支持的消息,请升级APP版本", l, (String)localObject3, localMap);
    for (;;)
    {
      localObject2 = (EMTextMessageBody)this.e.getBody();
      break;
      label134:
      if (localObject2 == EMMessage.Direct.RECEIVE) {
        this.e = j.createReceivedTextMsg(str2, str1, "不支持的消息,请升级APP版本", l, (String)localObject3, localMap);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */