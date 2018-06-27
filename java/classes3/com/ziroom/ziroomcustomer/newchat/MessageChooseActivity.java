package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Iterator;
import java.util.List;

public class MessageChooseActivity
  extends BaseActivity
  implements View.OnClickListener, EMMessageListener
{
  BasicZiroomToolBar a;
  private RelativeLayout b;
  private RelativeLayout c;
  private TextView d;
  private boolean e;
  private Context f;
  private TextView g;
  private int r = 0;
  private TextView s;
  private TextView t;
  private TextView u;
  private RelativeLayout v;
  private int w;
  private EMConversation x;
  private EMConversation y;
  
  private void a()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("在线咨询");
    this.b = ((RelativeLayout)findViewById(2131691189));
    this.c = ((RelativeLayout)findViewById(2131691193));
    this.v = ((RelativeLayout)findViewById(2131691191));
    this.d = ((TextView)findViewById(2131691194));
    this.g = ((TextView)findViewById(2131690657));
    this.s = ((TextView)findViewById(2131691190));
    this.t = ((TextView)findViewById(2131691192));
    this.u = ((TextView)findViewById(2131691172));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.r = ApplicationEx.c.getUnReadNum();
    this.w = ApplicationEx.c.getMisuNum();
    if (ApplicationEx.c.isImconnect() == true)
    {
      this.x = EMClient.getInstance().chatManager().getConversation("ms_ziroom", EMConversation.EMConversationType.Chat, true);
      this.y = EMClient.getInstance().chatManager().getConversation("ziroomerPro", EMConversation.EMConversationType.Chat, true);
      if (this.r > 0) {
        this.g.setVisibility(0);
      }
      if (this.w > 0) {
        this.u.setVisibility(0);
      }
      localObject = this.y.getLastMessage();
      if (localObject != null)
      {
        if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
          break label385;
        }
        localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
        if ((localObject != null) && (!TextUtils.isEmpty(((EMTextMessageBody)localObject).getMessage()))) {
          break label359;
        }
        this.s.setText("合租、整租、自如驿、服务等相关问题沟通");
      }
      if (this.x == null) {
        break label397;
      }
    }
    label359:
    label385:
    label397:
    for (Object localObject = this.x.getLastMessage();; localObject = null)
    {
      if (localObject != null)
      {
        if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
          break label426;
        }
        localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
        if (!TextUtils.isEmpty(((EMTextMessageBody)localObject).getMessage())) {
          break label402;
        }
        this.t.setText("民宿相关问题沟通");
      }
      return;
      localObject = SmileUtils.getSmiledText(this.f, ((EMTextMessageBody)localObject).getMessage());
      this.s.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      break;
      this.s.setText("合租、整租、自如驿、服务等相关问题沟通");
      break;
    }
    label402:
    localObject = SmileUtils.getSmiledText(this.f, ((EMTextMessageBody)localObject).getMessage());
    this.t.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
    return;
    label426:
    this.t.setText("民宿相关问题沟通");
  }
  
  private void a(final Class paramClass)
  {
    if (this.e)
    {
      if (!ApplicationEx.c.isImconnect())
      {
        a.register(this);
        if (l.getNetWorkType(this.f)) {
          showProgressNoCancel("", 8000L);
        }
        for (;;)
        {
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                if (l.getNetWorkType(MessageChooseActivity.a(MessageChooseActivity.this))) {
                  Thread.sleep(8000L);
                }
                for (;;)
                {
                  Intent localIntent = new Intent(MessageChooseActivity.a(MessageChooseActivity.this), paramClass);
                  MessageChooseActivity.this.startActivity(localIntent);
                  return;
                  Thread.sleep(18000L);
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }.start();
          return;
          showProgressNoCancel("", 18000L);
        }
      }
      startActivity(new Intent(this.f, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void b()
  {
    this.u.setVisibility(4);
    ApplicationEx.c.setUnReadNum(0);
    k.contactIM(this);
    w.onEvent(this, "personalcenter_message_Mcs");
  }
  
  private void e()
  {
    this.g.setVisibility(4);
    ApplicationEx.c.setMisuNum(0);
    a(ChatNewActivity.class);
    w.onEvent(this, "personalcenter_message_ziroomcs");
  }
  
  private void f() {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.e = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    case 2131691190: 
    case 2131691192: 
    default: 
      return;
    case 2131691193: 
      f();
      return;
    case 2131691189: 
      e();
      return;
    }
    b();
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903257);
    this.f = this;
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject) {}
  
  public void onMessageDelivered(List<EMMessage> paramList) {}
  
  public void onMessageRead(List<EMMessage> paramList) {}
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (EMMessage)localIterator.next();
      if ((paramList.getChatType() == EMMessage.ChatType.GroupChat) || (paramList.getChatType() == EMMessage.ChatType.ChatRoom))
      {
        paramList = paramList.getTo();
        label51:
        if (("ziroomerPro".equals(paramList)) && (this.y.getUnreadMsgCount() > 0))
        {
          this.g.setVisibility(0);
          Object localObject = this.y.getLastMessage();
          if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
            break label214;
          }
          localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
          localObject = SmileUtils.getSmiledText(this.f, ((EMTextMessageBody)localObject).getMessage());
          this.s.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
        }
      }
      for (;;)
      {
        if ((!"ms_ziroom".equals(paramList)) || (this.x.getUnreadMsgCount() <= 0)) {
          break label224;
        }
        this.u.setVisibility(0);
        paramList = this.x.getLastMessage();
        if (paramList.getType() != EMMessage.Type.TXT) {
          break label226;
        }
        paramList = (EMTextMessageBody)paramList.getBody();
        paramList = SmileUtils.getSmiledText(this.f, paramList.getMessage());
        this.t.setText(paramList, TextView.BufferType.SPANNABLE);
        break;
        paramList = paramList.getFrom();
        break label51;
        label214:
        this.s.setText("合租、整租、自如驿、服务等相关问题沟通");
      }
      label224:
      continue;
      label226:
      this.t.setText("民宿相关问题沟通");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    EMClient.getInstance().chatManager().addMessageListener(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EMClient.getInstance().chatManager().removeMessageListener(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/MessageChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */