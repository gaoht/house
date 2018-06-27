package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.chat.a.a;
import com.ziroom.ziroomcustomer.minsu.chat.d.k;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Date;

public abstract class MinsuChatRow
  extends LinearLayout
{
  protected static final String a = MinsuChatRow.class.getSimpleName();
  protected LayoutInflater b;
  protected Activity c;
  protected BaseAdapter d;
  protected EMMessage e;
  protected int f;
  protected TextView g;
  protected SimpleDraweeView h;
  protected View i;
  protected TextView j;
  protected TextView k;
  protected ProgressBar l;
  protected ImageView m;
  protected Activity n;
  protected TextView o;
  protected EMCallBack p;
  protected EMCallBack q;
  protected d r;
  protected i s;
  
  public MinsuChatRow(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity);
    this.c = paramActivity;
    this.n = paramActivity;
    this.e = paramEMMessage;
    this.f = paramInt;
    this.d = paramBaseAdapter;
    this.b = LayoutInflater.from(paramActivity);
    j();
  }
  
  private void j()
  {
    g();
    this.g = ((TextView)findViewById(2131696902));
    this.h = ((SimpleDraweeView)findViewById(2131693228));
    this.i = findViewById(2131696903);
    this.j = ((TextView)findViewById(2131696904));
    this.l = ((ProgressBar)findViewById(2131692289));
    this.m = ((ImageView)findViewById(2131696914));
    this.o = ((TextView)findViewById(2131696916));
    h();
  }
  
  private void k()
  {
    Object localObject1 = this.e.getFrom();
    Object localObject2 = k.getInstance().getUser((String)localObject1);
    a locala = j.getUserFromMessage(this.e);
    if (localObject2 == null)
    {
      u.i("wz_huanxin", "chat group  a");
      k.getInstance().putUser((String)localObject1, locala);
    }
    for (;;)
    {
      localObject1 = k.getInstance().getUser((String)localObject1);
      u.i("wz_huanxin", "chat group  user = " + localObject1);
      if (localObject1 == null) {
        break label206;
      }
      localObject2 = ((a)localObject1).b;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.h.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(ApplicationEx.c));
        this.h.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject2));
      }
      localObject1 = ((a)localObject1).a;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      this.j.setText((CharSequence)localObject1);
      return;
      if ((localObject2 != null) && (locala != null))
      {
        u.i("wz_huanxin", "chat group  b 0");
        if (!((a)localObject2).equals(locala))
        {
          u.i("wz_huanxin", "chat group  b 1");
          if (locala.c > ((a)localObject2).c)
          {
            u.i("wz_huanxin", "chat group  b 2");
            k.getInstance().putUser((String)localObject1, locala);
          }
        }
      }
    }
    this.j.setText("房客");
    return;
    label206:
    this.j.setText("房客");
  }
  
  private void l()
  {
    if ((ApplicationEx.c.getUser() == null) || (ApplicationEx.c.getUser().getHeadImg() == null)) {}
    String str;
    do
    {
      return;
      str = ApplicationEx.c.getUser().getHeadImg();
    } while ((str.equals(this.h.getTag(2131689523))) || (TextUtils.isEmpty(str)));
    this.h.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(ApplicationEx.c));
    this.h.setController(com.freelxl.baselibrary.f.c.frescoController(str));
    this.h.setTag(2131689523, str);
  }
  
  protected void a()
  {
    if ("ZIROOM_ZRY_IM".equals(this.e.getStringAttribute("ziroomFlag", "")))
    {
      c();
      return;
    }
    b();
  }
  
  protected abstract void a(EMMessage paramEMMessage);
  
  protected void a(final String paramString)
  {
    this.n.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (MinsuChatRow.this.e.status() == EMMessage.Status.FAIL)
        {
          if (f.notNull(paramString)) {
            com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, paramString);
          }
          if (MinsuChatRow.this.s != null) {
            MinsuChatRow.this.s.onFail(MinsuChatRow.this.e);
          }
        }
        for (;;)
        {
          MinsuChatRow.this.i();
          return;
          if ((MinsuChatRow.this.e.status() == EMMessage.Status.SUCCESS) && (MinsuChatRow.this.s != null)) {
            MinsuChatRow.this.s.onSuccess(MinsuChatRow.this.e);
          }
        }
      }
    });
  }
  
  protected void b()
  {
    TextView localTextView = (TextView)findViewById(2131696902);
    if (localTextView != null)
    {
      if (this.f == 0)
      {
        localTextView.setText(com.ziroom.ziroomcustomer.minsu.chat.d.i.getTimestampString(new Date(this.e.getMsgTime())));
        localTextView.setVisibility(0);
      }
    }
    else
    {
      if (this.e.direct() != EMMessage.Direct.SEND) {
        break label299;
      }
      this.h.setTag(2131689528, this.e.getFrom());
      c.setUserInfo(this.c, EMClient.getInstance().getCurrentUser(), this.h, null);
      label95:
      if (this.o != null)
      {
        if (!this.e.isDelivered()) {
          break label341;
        }
        this.o.setVisibility(0);
      }
      label120:
      if ((this.d instanceof g))
      {
        if (!((g)this.d).isShowAvatar()) {
          break label352;
        }
        this.h.setVisibility(0);
        label151:
        if (this.j != null)
        {
          if (!((g)this.d).isShowUserNick()) {
            break label364;
          }
          this.j.setVisibility(0);
        }
        label179:
        if (this.e.direct() != EMMessage.Direct.SEND) {
          break label376;
        }
        if (((g)this.d).getMyBubbleBg() != null) {
          this.i.setBackgroundDrawable(((g)this.d).getMyBubbleBg());
        }
      }
    }
    label299:
    label341:
    label352:
    label364:
    label376:
    while ((this.e.direct() != EMMessage.Direct.RECEIVE) || (((g)this.d).getOtherBuddleBg() == null))
    {
      return;
      EMMessage localEMMessage = (EMMessage)this.d.getItem(this.f - 1);
      if ((localEMMessage != null) && (com.ziroom.ziroomcustomer.minsu.chat.d.i.isCloseEnough(this.e.getMsgTime(), localEMMessage.getMsgTime())))
      {
        localTextView.setVisibility(8);
        break;
      }
      localTextView.setText(com.ziroom.ziroomcustomer.minsu.chat.d.i.getTimestampString(new Date(this.e.getMsgTime())));
      localTextView.setVisibility(0);
      break;
      this.h.setTag(2131689528, this.e.getFrom());
      c.setUserInfo(this.c, this.e.getFrom(), this.h, this.j);
      break label95;
      this.o.setVisibility(4);
      break label120;
      this.h.setVisibility(8);
      break label151;
      this.j.setVisibility(8);
      break label179;
    }
    this.i.setBackgroundDrawable(((g)this.d).getOtherBuddleBg());
  }
  
  protected void c()
  {
    TextView localTextView = (TextView)findViewById(2131696902);
    if (localTextView != null)
    {
      if (this.f == 0)
      {
        localTextView.setText(com.ziroom.ziroomcustomer.minsu.chat.d.i.getTimestampString(new Date(this.e.getMsgTime())));
        localTextView.setVisibility(0);
      }
    }
    else
    {
      if (this.e.direct() != EMMessage.Direct.SEND) {
        break label268;
      }
      l();
      label64:
      if (this.o != null)
      {
        if (!this.e.isDelivered()) {
          break label275;
        }
        this.o.setVisibility(0);
      }
      label89:
      if ((this.d instanceof g))
      {
        if (!((g)this.d).isShowAvatar()) {
          break label286;
        }
        this.h.setVisibility(0);
        label120:
        if (this.j != null)
        {
          if (!((g)this.d).isShowUserNick()) {
            break label298;
          }
          this.j.setVisibility(0);
        }
        label148:
        if (this.e.direct() != EMMessage.Direct.SEND) {
          break label310;
        }
        if (((g)this.d).getMyBubbleBg() != null) {
          this.i.setBackgroundDrawable(((g)this.d).getMyBubbleBg());
        }
      }
    }
    label268:
    label275:
    label286:
    label298:
    label310:
    while ((this.e.direct() != EMMessage.Direct.RECEIVE) || (((g)this.d).getOtherBuddleBg() == null))
    {
      return;
      EMMessage localEMMessage = (EMMessage)this.d.getItem(this.f - 1);
      if ((localEMMessage != null) && (com.ziroom.ziroomcustomer.minsu.chat.d.i.isCloseEnough(this.e.getMsgTime(), localEMMessage.getMsgTime())))
      {
        localTextView.setVisibility(8);
        break;
      }
      localTextView.setText(com.ziroom.ziroomcustomer.minsu.chat.d.i.getTimestampString(new Date(this.e.getMsgTime())));
      localTextView.setVisibility(0);
      break;
      k();
      break label64;
      this.o.setVisibility(4);
      break label89;
      this.h.setVisibility(8);
      break label120;
      this.j.setVisibility(8);
      break label148;
    }
    this.i.setBackgroundDrawable(((g)this.d).getOtherBuddleBg());
  }
  
  protected void d()
  {
    if (this.p == null) {
      this.p = new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          MinsuChatRow.this.a(paramAnonymousString);
        }
        
        public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
        {
          MinsuChatRow.this.n.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if (MinsuChatRow.this.k != null) {
                MinsuChatRow.this.k.setText(paramAnonymousInt + "%");
              }
            }
          });
        }
        
        public void onSuccess()
        {
          MinsuChatRow.this.a("");
        }
      };
    }
    this.e.setMessageStatusCallback(this.p);
  }
  
  protected void e()
  {
    if (this.q == null) {
      this.q = new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          MinsuChatRow.this.a(paramAnonymousString);
        }
        
        public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
        {
          MinsuChatRow.this.n.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if (MinsuChatRow.this.k != null) {
                MinsuChatRow.this.k.setText(paramAnonymousInt + "%");
              }
            }
          });
        }
        
        public void onSuccess()
        {
          MinsuChatRow.this.a("");
        }
      };
    }
    this.e.setMessageStatusCallback(this.q);
  }
  
  protected void f()
  {
    if (this.i != null)
    {
      this.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((MinsuChatRow.this.r != null) && (!MinsuChatRow.this.r.onBubbleClick(MinsuChatRow.this.e))) {
            MinsuChatRow.this.a(MinsuChatRow.this.e);
          }
        }
      });
      this.i.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if (MinsuChatRow.this.r != null) {
            MinsuChatRow.this.r.onBubbleLongClick(MinsuChatRow.this.e);
          }
          return true;
        }
      });
    }
    if (this.m != null) {
      this.m.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuChatRow.this.r != null) {
            MinsuChatRow.this.r.onResendClick(MinsuChatRow.this.e);
          }
        }
      });
    }
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MinsuChatRow.this.r != null)
        {
          if (MinsuChatRow.this.e.direct() == EMMessage.Direct.SEND) {
            MinsuChatRow.this.r.onUserAvatarClick(EMClient.getInstance().getCurrentUser());
          }
        }
        else {
          return;
        }
        MinsuChatRow.this.r.onUserAvatarClick(MinsuChatRow.this.e.getFrom());
      }
    });
  }
  
  protected abstract void g();
  
  protected abstract void h();
  
  protected abstract void i();
  
  protected abstract void onSetUpView();
  
  public void setOnMessageStatusListener(i parami)
  {
    this.s = parami;
  }
  
  public void setUpView(EMMessage paramEMMessage, int paramInt, d paramd)
  {
    this.e = paramEMMessage;
    this.f = paramInt;
    this.r = paramd;
    a();
    onSetUpView();
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */