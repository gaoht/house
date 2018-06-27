package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cn.dreamtobe.kpswitch.b.c.b;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelFrameLayout;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCmdMessageBody;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.chat.b.b;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.social.activity.ac.AcListActivity;
import com.ziroom.ziroomcustomer.social.model.v;
import com.ziroom.ziroomcustomer.social.model.v.a;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ZzSocialChatDetailActivity
  extends Activity
  implements View.OnClickListener, XListView.a
{
  public static ZzSocialChatDetailActivity a = null;
  private boolean A = false;
  private boolean B = false;
  private int C = 0;
  private String D;
  private String E;
  private String F;
  private String G;
  private a H = null;
  private String I;
  private String J;
  private boolean K = true;
  private boolean L = true;
  private boolean M = false;
  private boolean N = false;
  private String O;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private EditText g;
  private TextView h;
  private XListView i;
  private LinearLayout j;
  private ViewPager k;
  private LinearLayout l;
  private ImageView m;
  private ImageView n;
  private KPSwitchPanelFrameLayout o;
  private ImageView p;
  private com.ziroom.ziroomcustomer.social.a.f q;
  private String r;
  private EMConversation s;
  private EMMessageListener t;
  private ZzSocialChatDetailActivity u;
  private InputMethodManager v;
  private PowerManager.WakeLock w;
  private File x;
  private final int y = 20;
  private TextView z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.f = ((TextView)findViewById(2131692481));
    this.c = ((ImageView)findViewById(2131692480));
    this.g = ((EditText)findViewById(2131692483));
    this.h = ((TextView)findViewById(2131692482));
    this.i = ((XListView)findViewById(2131691266));
    this.d = ((ImageView)findViewById(2131692489));
    this.e = ((ImageView)findViewById(2131692490));
    this.j = ((LinearLayout)findViewById(2131692479));
    this.z = ((TextView)findViewById(2131692485));
    this.p = ((ImageView)findViewById(2131692488));
    this.o = ((KPSwitchPanelFrameLayout)findViewById(2131692491));
    this.k = ((ViewPager)findViewById(2131694549));
    this.l = ((LinearLayout)findViewById(2131694550));
    this.m = ((ImageView)findViewById(2131694552));
    this.n = ((ImageView)findViewById(2131694553));
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      this.A = true;
    }
    for (;;)
    {
      String str = this.D;
      com.ziroom.ziroomcustomer.e.n.setSocialZzShieldState(this.u, str, paramInt, new com.ziroom.ziroomcustomer.e.a.d(this.u, new com.ziroom.ziroomcustomer.e.c.f(String.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousString);
        }
      });
      return;
      if (paramInt == 2) {
        this.A = false;
      }
    }
  }
  
  private void a(Uri paramUri)
  {
    Cursor localCursor = getContentResolver().query(paramUri, null, null, null, null);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      paramUri = localCursor.getString(localCursor.getColumnIndex("_data"));
      localCursor.close();
      if ((paramUri == null) || (paramUri.equals("null")))
      {
        paramUri = Toast.makeText(this, 2131297293, 0);
        paramUri.setGravity(17, 0, 0);
        if (!(paramUri instanceof Toast))
        {
          paramUri.show();
          return;
        }
        VdsAgent.showToast((Toast)paramUri);
        return;
      }
      if (EMClient.getInstance().isLoggedInBefore() == true)
      {
        a(paramUri);
        return;
      }
      g.textToast(this.u, "服务器异常，请稍后再试");
      return;
    }
    paramUri = new File(paramUri.getPath());
    if (!paramUri.exists())
    {
      paramUri = Toast.makeText(this, 2131297293, 0);
      paramUri.setGravity(17, 0, 0);
      if (!(paramUri instanceof Toast))
      {
        paramUri.show();
        return;
      }
      VdsAgent.showToast((Toast)paramUri);
      return;
    }
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      a(paramUri.getAbsolutePath());
      return;
    }
    g.textToast(this.u, "服务器异常，请稍后再试");
  }
  
  private void a(EMMessage paramEMMessage)
  {
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.q.refresh();
  }
  
  private void a(final String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.r);
    paramString.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    paramString.setAttribute("showMsgTxt", "[图片]");
    paramString.setAttribute("em_ignore_notification", true);
    paramString.setAttribute("nicName", this.I);
    paramString.setAttribute("headURL", this.J);
    paramString.setAttribute("toNicName", this.G);
    paramString.setAttribute("toHeadUrl", this.E);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("em_push_title", this.I + ":[图片]");
      localJSONObject.put("ziroomFlag", "ZIROOM_CHANGZU_IM");
      paramString.setAttribute("em_apns_ext", localJSONObject);
      if (this.B)
      {
        this.s.appendMessage(paramString);
        return;
      }
      EMClient.getInstance().chatManager().sendMessage(paramString);
      com.ziroom.ziroomcustomer.social.b.d.refreshZzLive(this.u);
      this.q.refreshSelectLast();
      paramString.setMessageStatusCallback(new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), paramString, 1, false);
        }
        
        public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onSuccess()
        {
          com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), paramString, 0, false);
        }
      });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.L)
    {
      this.L = false;
      if (paramBoolean) {
        break label129;
      }
      if (TextUtils.isEmpty(this.r)) {
        g.textToast(this.u, "发送对象为空");
      }
    }
    else
    {
      return;
    }
    final EMMessage localEMMessage = EMMessage.createSendMessage(EMMessage.Type.CMD);
    localEMMessage.setChatType(EMMessage.ChatType.Chat);
    localEMMessage.setAttribute("domainFlag", com.ziroom.ziroomcustomer.minsu.chat.j.getDomainFlag());
    localEMMessage.setAttribute("ziroomType", 200);
    localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    EMCmdMessageBody localEMCmdMessageBody = new EMCmdMessageBody("shieldFriend");
    localEMMessage.setTo(this.r);
    localEMMessage.addBody(localEMCmdMessageBody);
    EMClient.getInstance().chatManager().sendMessage(localEMMessage);
    localEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.10.this.a, 1, true);
          }
        });
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this, 0);
            g.textToast(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), "已屏蔽");
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.10.this.a, 0, true);
          }
        });
      }
    });
    return;
    label129:
    localEMMessage = EMMessage.createSendMessage(EMMessage.Type.CMD);
    localEMMessage.setAttribute("ziroomType", 201);
    localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    localEMMessage.setAttribute("domainFlag", com.ziroom.ziroomcustomer.minsu.chat.j.getDomainFlag());
    localEMMessage.setChatType(EMMessage.ChatType.Chat);
    localEMCmdMessageBody = new EMCmdMessageBody("cancelShield");
    localEMMessage.setTo(this.r);
    localEMMessage.addBody(localEMCmdMessageBody);
    EMClient.getInstance().chatManager().sendMessage(localEMMessage);
    localEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.11.this.a, 1, true);
          }
        });
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this, 2);
            g.textToast(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), "取消屏蔽");
            com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.11.this.a, 0, true);
          }
        });
      }
    });
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.A) {
      g.textToast(this.u, "您已将对方屏蔽，不能给对方发送消息");
    }
    for (;;)
    {
      return;
      String str;
      label26:
      final EMMessage localEMMessage;
      if (paramBoolean)
      {
        str = "[动画表情]";
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localEMMessage = EMMessage.createTxtSendMessage(str, this.r);
        localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
        if (!paramBoolean) {
          break label262;
        }
        localEMMessage.setAttribute("ziroomType", 104);
        label68:
        localEMMessage.setAttribute("showMsgTxt", str);
        localEMMessage.setAttribute("nicName", this.I);
        localEMMessage.setAttribute("headURL", this.J);
        localEMMessage.setAttribute("toNicName", this.G);
        localEMMessage.setAttribute("toHeadUrl", this.E);
        localEMMessage.setAttribute("em_ignore_notification", true);
        if (paramBoolean) {
          localEMMessage.setAttribute("gifFileName", paramString);
        }
      }
      try
      {
        paramString = new JSONObject();
        paramString.put("em_push_title", this.I + ":" + str);
        paramString.put("ziroomFlag", "ZIROOM_CHANGZU_IM");
        localEMMessage.setAttribute("em_apns_ext", paramString);
        if (this.B)
        {
          this.s.appendMessage(localEMMessage);
          this.q.refreshSelectLast();
        }
        while (!paramBoolean)
        {
          this.g.setText("");
          return;
          str = VdsAgent.trackEditTextSilent(this.g).toString();
          break label26;
          label262:
          localEMMessage.setAttribute("ziroomType", 100);
          break label68;
          EMClient.getInstance().chatManager().sendMessage(localEMMessage);
          com.ziroom.ziroomcustomer.social.b.d.refreshZzLive(this.u);
          localEMMessage.setMessageStatusCallback(new EMCallBack()
          {
            public void onError(int paramAnonymousInt, String paramAnonymousString)
            {
              com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), localEMMessage, 1, false);
            }
            
            public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
            
            public void onSuccess()
            {
              com.ziroom.ziroomcustomer.social.b.d.saveChanngZhuMessageLog(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), localEMMessage, 0, false);
            }
          });
          this.q.refreshSelectLast();
        }
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
  
  private void b()
  {
    this.v = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.w = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    this.H = new a(null);
    EMClient.getInstance().addConnectionListener(this.H);
    this.o.setIgnoreRecommendHeight(true);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setPullLoadEnable(false);
    this.i.setPullRefreshEnable(true);
    this.i.setXListViewListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.i.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this);
        if (ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this).getVisibility() == 0)
        {
          ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this, false);
          ZzSocialChatDetailActivity.c(ZzSocialChatDetailActivity.this);
        }
        ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this).setVisibility(8);
        return false;
      }
    });
    this.g.requestFocus();
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this, false);
        ZzSocialChatDetailActivity.c(ZzSocialChatDetailActivity.this);
      }
    });
    cn.dreamtobe.kpswitch.b.c.attach(this.u, this.o, new c.b()
    {
      public void onKeyboardShowing(boolean paramAnonymousBoolean)
      {
        ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this, paramAnonymousBoolean);
        if (paramAnonymousBoolean) {}
        while (!ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this)) {
          return;
        }
        ZzSocialChatDetailActivity.c(ZzSocialChatDetailActivity.this, false);
        ZzSocialChatDetailActivity.b(ZzSocialChatDetailActivity.this).setVisibility(0);
      }
    });
  }
  
  private void c()
  {
    final Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 != null)
    {
      this.I = ((UserInfo)localObject1).getNickName();
      this.J = ((UserInfo)localObject1).getHeadImg();
    }
    this.D = getIntent().getStringExtra("toChatUid");
    this.E = getIntent().getStringExtra("toChatPic");
    this.G = getIntent().getStringExtra("toChatName");
    this.F = getIntent().getStringExtra("isFrom");
    this.r = ("app_" + this.D);
    this.f.setText(this.G);
    l();
    com.ziroom.ziroomcustomer.social.b.d.refreshZzLive(this.u);
    this.q = new com.ziroom.ziroomcustomer.social.a.f(this, this.r, this.i, this.E, this.D);
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.s = EMClient.getInstance().chatManager().getConversation(this.r, EMConversation.EMConversationType.Chat, true);
      if (this.s == null) {
        break label447;
      }
      this.s.markAllMessagesAsRead();
      this.i.setAdapter(this.q);
      this.q.refreshSelectLast();
    }
    for (;;)
    {
      g();
      localObject1 = new ArrayList();
      View localView = b.getGridChildView(1, this.u, this.g);
      Object localObject2 = b.getGridChildView(2, this.u, this.g);
      ((List)localObject1).add(localView);
      ((List)localObject1).add(localObject2);
      ((List)localObject1).add(b.getBigExpressionView(this.u, 1, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
      {
        public void onClick(String paramAnonymousString)
        {
          ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this, true, paramAnonymousString);
        }
      }));
      ((List)localObject1).add(b.getBigExpressionView(this.u, 2, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
      {
        public void onClick(String paramAnonymousString)
        {
          ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this, true, paramAnonymousString);
        }
      }));
      this.k.setOffscreenPageLimit(4);
      this.k.setAdapter(new com.ziroom.ziroomcustomer.minsu.chat.b.d((List)localObject1));
      this.l.removeAllViews();
      int i1 = 0;
      while (i1 < 2)
      {
        localView = new View(this.u);
        localObject2 = new LinearLayout.LayoutParams(com.ziroom.ziroomcustomer.util.n.dip2px(this.u, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.u, 8.0F));
        ((LinearLayout.LayoutParams)localObject2).leftMargin = com.ziroom.ziroomcustomer.util.n.dip2px(this.u, 7.0F);
        localView.setBackgroundResource(2130839323);
        localView.setId(i1);
        this.l.addView(localView, (ViewGroup.LayoutParams)localObject2);
        i1 += 1;
      }
      label447:
      g.textToast(this.u, "服务器异常，请稍后再试");
    }
    this.k.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        int i = paramAnonymousInt % localObject1.size();
        ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this).removeAllViews();
        paramAnonymousInt = 0;
        if (paramAnonymousInt < 2)
        {
          View localView = new View(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this));
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.ziroom.ziroomcustomer.util.n.dip2px(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), 8.0F));
          localLayoutParams.leftMargin = com.ziroom.ziroomcustomer.util.n.dip2px(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), 7.0F);
          if (i % 2 == paramAnonymousInt) {
            localView.setBackgroundResource(2130839314);
          }
          for (;;)
          {
            localView.setId(paramAnonymousInt);
            ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this).addView(localView, localLayoutParams);
            paramAnonymousInt += 1;
            break;
            localView.setBackgroundResource(2130839323);
          }
        }
        ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this).invalidate();
        switch (i)
        {
        default: 
          return;
        case 0: 
        case 1: 
          ZzSocialChatDetailActivity.g(ZzSocialChatDetailActivity.this).setSelected(true);
          ZzSocialChatDetailActivity.h(ZzSocialChatDetailActivity.this).setSelected(false);
          return;
        }
        ZzSocialChatDetailActivity.g(ZzSocialChatDetailActivity.this).setSelected(false);
        ZzSocialChatDetailActivity.h(ZzSocialChatDetailActivity.this).setSelected(true);
      }
    });
    this.l.getChildAt(0).setBackgroundResource(2130839314);
  }
  
  private void d()
  {
    if ((this.k.getCurrentItem() == 2) || (this.k.getCurrentItem() == 3)) {
      return;
    }
    this.k.setCurrentItem(2);
  }
  
  private void e()
  {
    if ((this.k.getCurrentItem() == 1) || (this.k.getCurrentItem() == 0)) {
      return;
    }
    this.k.setCurrentItem(0);
  }
  
  private void f()
  {
    if (this.K)
    {
      k();
      this.K = false;
      this.p.setImageResource(2130840299);
      if (this.M)
      {
        this.N = true;
        return;
      }
      this.o.setVisibility(0);
      return;
    }
    this.K = true;
    this.p.setImageResource(2130840298);
    this.o.setVisibility(8);
  }
  
  private void g()
  {
    if (this.A) {}
    while ((TextUtils.isEmpty(this.F)) || (!"isFrom_match".equals(this.F))) {
      return;
    }
    EMMessage localEMMessage = EMMessage.createTxtSendMessage("ta想认识你，打个招呼吧", this.r);
    localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    localEMMessage.setAttribute("ziroomType", 101);
    localEMMessage.setAttribute("nicName", this.I);
    localEMMessage.setAttribute("headURL", this.J);
    localEMMessage.setAttribute("toNicName", this.G);
    localEMMessage.setAttribute("toHeadUrl", this.E);
    localEMMessage.setAttribute("em_ignore_notification", true);
    localEMMessage.setAttribute("showMsgTxt", "ta想认识你，打个招呼吧");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("em_push_title", this.I + ":ta想认识你，打个招呼吧");
      localJSONObject.put("ziroomFlag", "ZIROOM_CHANGZU_IM");
      localEMMessage.setAttribute("em_apns_ext", localJSONObject);
      EMClient.getInstance().chatManager().sendMessage(localEMMessage);
      this.q.refreshSelectLast();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void h()
  {
    if (this.A)
    {
      g.textToast(this.u, "您已将对方屏蔽，不能给对方发送消息");
      return;
    }
    Intent localIntent = new Intent(this.u, AcListActivity.class);
    localIntent.putExtra("from", "zhaozhao");
    startActivity(localIntent);
  }
  
  private void i()
  {
    if (this.q == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ZzSocialChatDetailActivity.k(ZzSocialChatDetailActivity.this).refreshSelectLast();
      }
    });
  }
  
  private void j()
  {
    this.i.stopRefresh();
    this.i.stopLoadMore();
    this.i.setRefreshTime("刚刚");
  }
  
  private void k()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      this.v.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  private void l()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    String str = this.D;
    com.ziroom.ziroomcustomer.minsu.e.a.imFindRelationShip(this.u, (String)localObject, str, "ZIROOM_CHANGZU_IM", new s(this.u, new com.freelxl.baselibrary.d.f.d(v.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        System.out.println(" e = " + paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, v paramAnonymousv)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousv);
        if ((paramAnonymousv != null) && ("0".equals(paramAnonymousv.getStatus())) && (paramAnonymousv.getData() != null) && (paramAnonymousv.getData().getShieldFlag() != null))
        {
          ZzSocialChatDetailActivity.a(ZzSocialChatDetailActivity.this, paramAnonymousv.getData().getShieldFlag().intValue());
          if (ZzSocialChatDetailActivity.l(ZzSocialChatDetailActivity.this) != 0) {
            break label86;
          }
          ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this, false);
          ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, false);
        }
        label86:
        do
        {
          return;
          if (ZzSocialChatDetailActivity.l(ZzSocialChatDetailActivity.this) == 1)
          {
            ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this, true);
            ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, false);
            return;
          }
          if (ZzSocialChatDetailActivity.l(ZzSocialChatDetailActivity.this) == 2)
          {
            ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this, false);
            ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, true);
            return;
          }
        } while (ZzSocialChatDetailActivity.l(ZzSocialChatDetailActivity.this) != 3);
        ZzSocialChatDetailActivity.e(ZzSocialChatDetailActivity.this, true);
        ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, true);
      }
    });
  }
  
  private void m()
  {
    final Dialog localDialog = new Dialog(this, 2131427565);
    View localView = LayoutInflater.from(this).inflate(2130905063, null);
    Object localObject2 = (TextView)localView.findViewById(2131697341);
    TextView localTextView1 = (TextView)localView.findViewById(2131697340);
    TextView localTextView2 = (TextView)localView.findViewById(2131697342);
    Object localObject1 = (TextView)localView.findViewById(2131691849);
    TextView localTextView3 = (TextView)localView.findViewById(2131690169);
    if (this.A)
    {
      ((TextView)localObject2).setText("取消屏蔽");
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localDialog.dismiss();
          paramAnonymousView = new com.ziroom.ziroomcustomer.social.view.c(ZzSocialChatDetailActivity.this, ZzSocialChatDetailActivity.m(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.n(ZzSocialChatDetailActivity.this));
          paramAnonymousView.show();
          paramAnonymousView.setOnFinishActivityListener(new com.ziroom.ziroomcustomer.social.view.c.a()
          {
            public void isFinish()
            {
              ZzSocialChatDetailActivity.this.finish();
            }
          });
        }
      });
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this, ZzSocialChatDetailActivity.o(ZzSocialChatDetailActivity.this));
          localDialog.dismiss();
        }
      });
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localDialog.dismiss();
        }
      });
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localDialog.dismiss();
          paramAnonymousView = new Intent(ZzSocialChatDetailActivity.this, ZzSocialMySpaceActivity.class);
          paramAnonymousView.putExtra("be_uid", ZzSocialChatDetailActivity.m(ZzSocialChatDetailActivity.this));
          ZzSocialChatDetailActivity.this.startActivity(paramAnonymousView);
        }
      });
      localObject2 = ApplicationEx.c.getUser();
      if (localObject2 != null) {
        this.O = ((UserInfo)localObject2).getUid();
      }
      ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.dialog.c.newBuilder(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this)).setContent("你确定删除该好友？").setButtonText("确认").setSecondButtonText("取消").setOnButtonClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              com.ziroom.ziroomcustomer.e.n.deleteSocialZzFriend(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.p(ZzSocialChatDetailActivity.this), ZzSocialChatDetailActivity.m(ZzSocialChatDetailActivity.this), new com.ziroom.ziroomcustomer.e.a.d(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), new com.ziroom.ziroomcustomer.e.c.f(String.class))
              {
                public void onFailure(Throwable paramAnonymous3Throwable)
                {
                  dismissProgress();
                  g.textToast(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), paramAnonymous3Throwable.getMessage());
                }
                
                public void onSuccess(int paramAnonymous3Int, String paramAnonymous3String)
                {
                  super.onSuccess(paramAnonymous3Int, paramAnonymous3String);
                  dismissProgress();
                  ZzSocialChatDetailActivity.q(ZzSocialChatDetailActivity.this);
                }
              });
            }
          }).build().show();
        }
      });
      localDialog.setContentView(localView);
      localObject1 = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDisplayMetrics().widthPixels;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localDialog.getWindow().setGravity(80);
      localDialog.getWindow().setWindowAnimations(2131427566);
      localDialog.setCanceledOnTouchOutside(true);
      if ((localDialog instanceof Dialog)) {
        break label276;
      }
      localDialog.show();
    }
    for (;;)
    {
      localDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ZzSocialChatDetailActivity.g(ZzSocialChatDetailActivity.this, true);
        }
      });
      return;
      ((TextView)localObject2).setText("屏蔽此人");
      break;
      label276:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  private void n()
  {
    EMMessage localEMMessage = EMMessage.createSendMessage(EMMessage.Type.CMD);
    localEMMessage.setChatType(EMMessage.ChatType.Chat);
    localEMMessage.setAttribute("domainFlag", com.ziroom.ziroomcustomer.minsu.chat.j.getDomainFlag());
    localEMMessage.setAttribute("ziroomType", 203);
    localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    EMCmdMessageBody localEMCmdMessageBody = new EMCmdMessageBody("shieldFriend");
    localEMMessage.setTo(this.r);
    localEMMessage.addBody(localEMCmdMessageBody);
    EMClient.getInstance().chatManager().sendMessage(localEMMessage);
    localEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run() {}
        });
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (ZzSocialChatDetailActivity.r(ZzSocialChatDetailActivity.this) != null) {
              ZzSocialChatDetailActivity.r(ZzSocialChatDetailActivity.this).clearAllMessages();
            }
            EMClient.getInstance().chatManager().deleteConversation(ZzSocialChatDetailActivity.i(ZzSocialChatDetailActivity.this), true);
            ZzSocialChatDetailActivity.k(ZzSocialChatDetailActivity.this).notifyDataSetChanged();
            g.textToast(ZzSocialChatDetailActivity.f(ZzSocialChatDetailActivity.this), "好友已删除");
            ZzSocialChatDetailActivity.this.finish();
          }
        });
      }
    });
  }
  
  public void back(View paramView)
  {
    k();
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 18) {
        break label68;
      }
      if ((this.x != null) && (this.x.exists()))
      {
        if (EMClient.getInstance().isLoggedInBefore() != true) {
          break label57;
        }
        a(this.x.getAbsolutePath());
      }
    }
    label57:
    label68:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            g.textToast(this.u, "服务器异常，请稍后再试");
            return;
            if (paramInt1 != 19) {
              break;
            }
          } while (paramIntent == null);
          paramIntent = paramIntent.getData();
        } while (paramIntent == null);
        a(paramIntent);
        return;
        if ((paramInt1 == 5) || (paramInt1 == 7))
        {
          a((EMMessage)getIntent().getParcelableExtra("message"));
          return;
        }
      } while (paramInt1 == 11);
      if (this.s.getAllMessages().size() > 0)
      {
        this.q.refresh();
        setResult(-1);
        return;
      }
      if (paramInt1 == 21)
      {
        this.q.refresh();
        return;
      }
    } while (paramInt1 != 26);
    this.q.refresh();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      k();
      finish();
      return;
    case 2131692480: 
      m();
      return;
    case 2131692482: 
      a(false, "");
      return;
    case 2131692489: 
      try
      {
        selectPicFromCamera();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    case 2131692490: 
      try
      {
        selectPicFromLocal();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    case 2131692485: 
      h();
      return;
    case 2131692488: 
      f();
      return;
    case 2131694552: 
      e();
      return;
    }
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903508);
    this.u = this;
    a = this;
    a();
    b();
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(this);
    if (this.t != null) {
      EMClient.getInstance().chatManager().removeMessageListener(this.t);
    }
    if (this.H != null) {
      EMClient.getInstance().removeConnectionListener(this.H);
    }
  }
  
  public void onLoadMore() {}
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    Object localObject = paramIntent.getStringExtra("activityPic");
    String str1 = paramIntent.getStringExtra("activityTitle");
    String str2 = paramIntent.getStringExtra("activityDesc");
    String str3 = paramIntent.getStringExtra("activityStartTime");
    String str4 = paramIntent.getStringExtra("activityUrl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramIntent = EMMessage.createTxtSendMessage("邀请参加活动", this.r);
      paramIntent.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
      paramIntent.setAttribute("showMsgTxt", "[链接]" + str1);
      paramIntent.setAttribute("ziroomType", 103);
      paramIntent.setAttribute("activityName", str1);
      paramIntent.setAttribute("activityPicUrl", (String)localObject);
      paramIntent.setAttribute("linkUrl", str4);
      paramIntent.setAttribute("activityDate", str3);
      paramIntent.setAttribute("activityDesc", str2);
      paramIntent.setAttribute("nicName", this.I);
      paramIntent.setAttribute("headURL", this.J);
      paramIntent.setAttribute("toNicName", this.G);
      paramIntent.setAttribute("toHeadUrl", this.E);
      paramIntent.setAttribute("em_ignore_notification", true);
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("em_push_title", this.I + ":" + str1);
      ((JSONObject)localObject).put("ziroomFlag", "ZIROOM_CHANGZU_IM");
      paramIntent.setAttribute("em_apns_ext", (JSONObject)localObject);
      EMClient.getInstance().chatManager().sendMessage(paramIntent);
      this.q.refreshSelectLast();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onRefresh()
  {
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      if (this.s == null) {
        break label116;
      }
      if (this.s.getAllMessages().size() != 0) {
        break label37;
      }
      j();
    }
    for (;;)
    {
      return;
      try
      {
        label37:
        List localList = this.s.loadMoreMsgFromDB(this.q.getItem(0).getMsgId(), 20);
        try
        {
          Thread.sleep(300L);
          if (localList.size() != 0)
          {
            this.q.refreshSelectLast();
            j();
          }
          if (localList.size() != 0) {
            continue;
          }
          j();
          this.i.setPullRefreshEnable(false);
          g.textToast(this.u, "已经没有数据了！");
          return;
          label116:
          g.textToast(this.u, "服务器异常，请稍后再试");
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.q.refresh();
      com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(this);
      if (this.t == null) {
        this.t = new b();
      }
      EMClient.getInstance().chatManager().addMessageListener(this.t);
      return;
    }
    g.textToast(this.u, "服务器异常，请稍后再试");
  }
  
  public void selectPicFromCamera()
  {
    if (this.A)
    {
      g.textToast(this.u, "您已将对方屏蔽，不能给对方发送消息");
      return;
    }
    if (!com.ziroom.ziroomcustomer.newchat.d.isExitsSdcard())
    {
      g.textToast(getApplicationContext(), 2131297414, 0);
      return;
    }
    this.x = new File(PathUtil.getInstance().getImagePath(), System.currentTimeMillis() + ".jpg");
    this.x.getParentFile().mkdirs();
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", Uri.fromFile(this.x)), 18);
  }
  
  public void selectPicFromLocal()
  {
    if (this.A)
    {
      g.textToast(this.u, "您已将对方屏蔽，不能给对方发送消息");
      return;
    }
    Intent localIntent;
    if (Build.VERSION.SDK_INT < 19)
    {
      localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.setType("image/*");
    }
    for (;;)
    {
      startActivityForResult(localIntent, 19);
      return;
      localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }
  }
  
  private class a
    implements EMConnectionListener
  {
    private a() {}
    
    public void onConnected()
    {
      ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
      {
        public void run() {}
      });
    }
    
    public void onDisconnected(final int paramInt)
    {
      ZzSocialChatDetailActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (paramInt == 207) {
            ApplicationEx.c.setImconnect(false);
          }
          do
          {
            do
            {
              return;
            } while (paramInt != 206);
            ApplicationEx.c.setImconnect(false);
          } while (EMClient.getInstance().isLoggedInBefore() != true);
          ZzSocialChatDetailActivity.this.finish();
        }
      });
    }
  }
  
  class b
    implements EMMessageListener
  {
    b() {}
    
    public void onCmdMessageReceived(List<EMMessage> paramList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EMMessage localEMMessage = (EMMessage)localIterator.next();
        if ((localEMMessage.getChatType() == EMMessage.ChatType.GroupChat) || (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom)) {}
        for (paramList = localEMMessage.getTo();; paramList = localEMMessage.getFrom())
        {
          if (!paramList.equals(ZzSocialChatDetailActivity.i(ZzSocialChatDetailActivity.this))) {
            break label103;
          }
          paramList = (EMCmdMessageBody)localEMMessage.getBody();
          if (!"shieldFriend".equals(paramList.action())) {
            break label105;
          }
          ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, true);
          break;
        }
        label103:
        continue;
        label105:
        if ("cancelShield".equals(paramList.action())) {
          ZzSocialChatDetailActivity.d(ZzSocialChatDetailActivity.this, false);
        }
      }
    }
    
    public void onMessageChanged(EMMessage paramEMMessage, Object paramObject) {}
    
    public void onMessageDelivered(List<EMMessage> paramList) {}
    
    public void onMessageRead(List<EMMessage> paramList) {}
    
    public void onMessageRecalled(List<EMMessage> paramList) {}
    
    public void onMessageReceived(List<EMMessage> paramList)
    {
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        EMMessage localEMMessage = (EMMessage)localIterator.next();
        if ((localEMMessage.getChatType() == EMMessage.ChatType.GroupChat) || (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom)) {}
        for (paramList = localEMMessage.getTo();; paramList = localEMMessage.getFrom())
        {
          if (paramList.equals(ZzSocialChatDetailActivity.i(ZzSocialChatDetailActivity.this))) {
            ZzSocialChatDetailActivity.j(ZzSocialChatDetailActivity.this);
          }
          if ((localEMMessage.isAcked()) || (localEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
            break;
          }
          try
          {
            EMClient.getInstance().chatManager().ackMessageRead(localEMMessage.getFrom(), localEMMessage.getMsgId());
          }
          catch (HyphenateException paramList)
          {
            paramList.printStackTrace();
          }
          break;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialChatDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */