package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.util.ae;

public class MinsuChatRowHouse
  extends MinsuChatRow
{
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private SimpleDraweeView x;
  private Activity y;
  
  public MinsuChatRowHouse(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
    this.y = paramActivity;
  }
  
  private void b(EMMessage paramEMMessage)
  {
    try
    {
      Object localObject = (EMTextMessageBody)paramEMMessage.getBody();
      String str3 = paramEMMessage.getStringAttribute("fid", "");
      int i = Integer.parseInt(paramEMMessage.getStringAttribute("rentWay", ""));
      String str2 = ((EMTextMessageBody)localObject).getMessage();
      String str4 = paramEMMessage.getStringAttribute("startDate", "");
      String str5 = paramEMMessage.getStringAttribute("endDate", "");
      String str1 = c.getUserName(paramEMMessage.getTo());
      localObject = str2;
      if (j.isImError(str2)) {
        localObject = "";
      }
      str2 = paramEMMessage.getStringAttribute("houseName", "");
      Activity localActivity = this.y;
      OrderStatusEnum localOrderStatusEnum = OrderStatusEnum.YD;
      paramEMMessage = str1;
      if (ae.isNull(str1)) {
        paramEMMessage = "";
      }
      k.toMinsuApplyActivity(localActivity, localOrderStatusEnum, str3, str2, i, str4, str5, paramEMMessage, (String)localObject);
      return;
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  protected void a(EMMessage paramEMMessage)
  {
    b(paramEMMessage);
  }
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904917;; i = 2130904923)
    {
      localLayoutInflater.inflate(i, this);
      return;
    }
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131694581));
    this.u = ((TextView)findViewById(2131694587));
    this.w = ((TextView)findViewById(2131691573));
    this.v = ((TextView)findViewById(2131691576));
    this.x = ((SimpleDraweeView)findViewById(2131696911));
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
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(this.e.getStringAttribute("rentWay", ""));
        String str2 = this.e.getStringAttribute("startDate", "");
        String str3 = this.e.getStringAttribute("endDate", "");
        this.t.setText(this.e.getStringAttribute("houseName", ""));
        this.x.setController(com.freelxl.baselibrary.f.c.frescoController(this.e.getStringAttribute("housePicUrl", "")));
        str1 = this.e.getStringAttribute("rentWayName", "");
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        TextView localTextView = this.u;
        if (i != 0) {
          continue;
        }
        str1 = "整套出租";
        localTextView.setText(str1);
        if (this.v != null) {
          this.v.setText(this.e.getStringAttribute("personNum", "") + "位房客");
        }
        this.w.setText(str2 + "至" + str3);
      }
      catch (Exception localException)
      {
        String str1;
        localException.printStackTrace();
        continue;
      }
      j();
      return;
      str1 = "独立房间";
      continue;
      this.u.setText(str1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowHouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */