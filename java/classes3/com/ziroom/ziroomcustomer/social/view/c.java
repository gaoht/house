package com.ziroom.ziroomcustomer.social.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCmdMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Type;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.social.a.d.b;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialComplainSuccessActivity;
import com.ziroom.ziroomcustomer.social.model.q;
import java.util.List;

public class c
  extends Dialog
{
  private Activity a;
  private ListView b;
  private ImageView c;
  private TextView d;
  private String e;
  private String f;
  private int g = -100;
  private String h;
  private a i;
  
  public c(Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramActivity, 2131427591);
    this.a = paramActivity;
    this.e = paramString1;
    this.h = paramString2;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903635, null);
    a(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.f = ("app_" + this.e);
    this.b = ((ListView)paramView.findViewById(2131693087));
    this.c = ((ImageView)paramView.findViewById(2131690588));
    this.d = ((TextView)paramView.findViewById(2131689956));
    b();
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.a(c.this);
      }
    });
  }
  
  private void b()
  {
    n.getSocialZzComplainList(this.a, new com.ziroom.ziroomcustomer.e.a.d(this.a, new e(q.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, final List<q> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          com.ziroom.ziroomcustomer.social.a.d locald = new com.ziroom.ziroomcustomer.social.a.d(c.b(c.this), paramAnonymousList);
          c.c(c.this).setAdapter(locald);
          locald.setOnPosComplainListener(new d.b()
          {
            public void conplainInfo(int paramAnonymous2Int)
            {
              c.a(c.this, ((q)paramAnonymousList.get(paramAnonymous2Int)).getType());
              c.d(c.this).setEnabled(true);
            }
          });
        }
      }
    });
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.e))
    {
      g.textToast(this.a, "发送对象为空");
      return;
    }
    if (this.g == -100)
    {
      g.textToast(this.a, "请先选择投诉原因");
      return;
    }
    if ((this.g == 2) || (this.g == 3))
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("您确定投诉么？\n投诉将会把你们最近的聊天记录作为调查依据").setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            c.e(c.this);
          }
        }
      }).build().show();
      return;
    }
    d();
  }
  
  private void d()
  {
    final Object localObject = EMMessage.createSendMessage(EMMessage.Type.CMD);
    ((EMMessage)localObject).setAttribute("ziroomType", 202);
    ((EMMessage)localObject).setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    ((EMMessage)localObject).setAttribute("domainFlag", j.getDomainFlag());
    ((EMMessage)localObject).setChatType(EMMessage.ChatType.Chat);
    EMCmdMessageBody localEMCmdMessageBody = new EMCmdMessageBody("shieldFriend");
    ((EMMessage)localObject).setTo(this.f);
    ((EMMessage)localObject).addBody(localEMCmdMessageBody);
    EMClient.getInstance().chatManager().sendMessage((EMMessage)localObject);
    ((EMMessage)localObject).setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        c.b(c.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(c.b(c.this), c.5.this.a, 1, true);
          }
        });
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        c.b(c.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(c.b(c.this), c.5.this.a, 0, true);
          }
        });
      }
    });
    localObject = this.e;
    n.setSocialZzComplain(this.a, (String)localObject, this.g, new com.ziroom.ziroomcustomer.e.a.d(this.a, new f(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (c.f(c.this) != null) {
          c.f(c.this).isFinish();
        }
        paramAnonymousString = new Intent(c.b(c.this), ZzSocialComplainSuccessActivity.class);
        paramAnonymousString.putExtra("isFrom", c.g(c.this));
        c.b(c.this).startActivity(paramAnonymousString);
        c.this.dismiss();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(false);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localWindow.setWindowAnimations(2131427962);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public void setOnFinishActivityListener(a parama)
  {
    this.i = parama;
  }
  
  public static abstract interface a
  {
    public abstract void isFinish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */