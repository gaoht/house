package com.ziroom.ziroomcustomer.social.a;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMFileMessageBody;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.DateUtils;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newchat.ShowBigImage;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.newchat.d;
import com.ziroom.ziroomcustomer.newchat.h;
import com.ziroom.ziroomcustomer.social.activity.ac.AcListActivity;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialMySpaceActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.BuddleArrowView;
import com.ziroom.ziroomcustomer.widget.CircleImageView;
import com.ziroom.ziroomcustomer.widget.XListView;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class f
  extends BaseAdapter
{
  EMMessage[] a = null;
  Handler b = new Handler()
  {
    private void a()
    {
      f.a(f.this, EMClient.getInstance().chatManager().getConversation(f.a(f.this)));
      if (f.b(f.this) != null)
      {
        List localList = f.b(f.this).getAllMessages();
        f.this.a = ((EMMessage[])localList.toArray(new EMMessage[localList.size()]));
        f.b(f.this).markAllMessagesAsRead();
        f.this.notifyDataSetChanged();
      }
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          a();
          return;
        } while ((f.this.a == null) || (f.this.a.length <= 0));
        f.c(f.this).setSelection(f.this.a.length - 1);
        return;
      }
      int i = paramAnonymousMessage.arg1;
      f.c(f.this).setSelection(i);
    }
  };
  private LayoutInflater c;
  private Context d;
  private String e;
  private XListView f;
  private Activity g;
  private EMConversation h;
  private List<EMMessage> i = new ArrayList();
  private Map<String, Timer> j = new Hashtable();
  private String k = "";
  private String l = "";
  private String m;
  private Bitmap n;
  private Bitmap o;
  
  public f(Context paramContext, String paramString1, XListView paramXListView, String paramString2, String paramString3)
  {
    this.d = paramContext;
    this.e = paramString1;
    this.f = paramXListView;
    this.l = paramString2;
    this.m = paramString3;
    this.c = LayoutInflater.from(paramContext);
    this.g = ((Activity)paramContext);
    paramContext = ApplicationEx.c.getUser();
    if (paramContext == null) {
      this.k = "";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        a(paramString2, true);
      }
      this.h = EMClient.getInstance().chatManager().getConversation(paramString1);
      return;
      this.k = paramContext.getHeadImg();
      a(this.k, false);
    }
  }
  
  private View a(EMMessage paramEMMessage, int paramInt)
  {
    switch (7.a[paramEMMessage.getType().ordinal()])
    {
    default: 
      if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
        return this.c.inflate(2130905145, null);
      }
      break;
    case 1: 
      if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
        return this.c.inflate(2130905144, null);
      }
      return this.c.inflate(2130905150, null);
    }
    return this.c.inflate(2130905148, null);
  }
  
  private void a(EMMessage paramEMMessage)
  {
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess() {}
    });
    refresh();
  }
  
  private void a(final EMMessage paramEMMessage, final a parama)
  {
    System.err.println("!!! show download image progress");
    EMFileMessageBody localEMFileMessageBody = (EMFileMessageBody)paramEMMessage.getBody();
    if (parama.d != null) {
      parama.d.setVisibility(0);
    }
    if (parama.c != null) {
      parama.c.setVisibility(0);
    }
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramEMMessage.getType() == EMMessage.Type.IMAGE) {
          f.f(f.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              f.15.this.b.c.setText(paramAnonymousInt + "%");
            }
          });
        }
      }
      
      public void onSuccess()
      {
        f.f(f.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (f.15.this.a.getType() == EMMessage.Type.IMAGE)
            {
              f.15.this.b.d.setVisibility(8);
              f.15.this.b.c.setVisibility(8);
            }
            f.this.notifyDataSetChanged();
          }
        });
      }
    });
  }
  
  private void a(EMMessage paramEMMessage, a parama, int paramInt)
  {
    final Object localObject1 = paramEMMessage.getStringAttribute("ziroomType", "100");
    final Object localObject2;
    if ("103".equals(localObject1))
    {
      if (parama.v != null) {
        parama.v.setVisibility(8);
      }
      if (parama.m != null) {
        parama.m.setVisibility(8);
      }
      if (parama.q != null) {
        parama.q.setVisibility(0);
      }
      if (parama.l != null) {
        parama.l.setVisibility(0);
      }
      if (parama.c != null) {
        parama.c.setVisibility(8);
      }
      if (parama.y != null) {
        parama.y.setVisibility(8);
      }
      localObject1 = paramEMMessage.getStringAttribute("activityPicUrl", "");
      localObject2 = paramEMMessage.getStringAttribute("activityName", "");
      final String str1 = paramEMMessage.getStringAttribute("linkUrl", "");
      String str2 = paramEMMessage.getStringAttribute("activityDate", "");
      final String str3 = paramEMMessage.getStringAttribute("activityDesc", "");
      if (parama.r.getTag() == null)
      {
        parama.r.setTag(localObject1);
        parama.r.setController(c.frescoController((String)localObject1));
        parama.s.setText((CharSequence)localObject2);
        parama.t.setText(str2);
        parama.u.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(f.d(f.this), localObject2, str1, true, str3, localObject1, false);
          }
        });
      }
    }
    for (;;)
    {
      if (paramEMMessage.direct() == EMMessage.Direct.SEND) {
        switch (7.b[paramEMMessage.status().ordinal()])
        {
        default: 
          sendMsgInBackground(paramEMMessage, parama);
          if ((paramEMMessage.isAcked()) || (paramEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
            break;
          }
        }
      }
      try
      {
        EMClient.getInstance().chatManager().ackMessageRead(paramEMMessage.getFrom(), paramEMMessage.getMsgId());
        return;
      }
      catch (HyphenateException paramEMMessage)
      {
        paramEMMessage.printStackTrace();
      }
      if (((String)localObject1).equals(parama.r.getTag())) {
        break;
      }
      parama.r.setTag(localObject1);
      parama.r.setController(c.frescoController((String)localObject1));
      break;
      if ("102".equals(localObject1))
      {
        if (parama.v != null) {
          parama.v.setVisibility(8);
        }
        if (parama.m != null) {
          parama.m.setVisibility(0);
        }
        if (parama.q != null) {
          parama.q.setVisibility(8);
        }
        if (parama.l != null) {
          parama.l.setVisibility(8);
        }
        if (parama.c != null) {
          parama.c.setVisibility(0);
        }
        if (parama.y != null) {
          parama.y.setVisibility(8);
        }
        localObject1 = paramEMMessage.getStringAttribute("activityPicUrl", "");
        localObject2 = paramEMMessage.getStringAttribute("content", "");
        if (parama.n.getTag() == null)
        {
          parama.n.setTag(localObject1);
          parama.n.setController(c.frescoController((String)localObject1));
        }
        for (;;)
        {
          parama.o.setText((CharSequence)localObject2);
          parama.p.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(f.d(f.this), AcListActivity.class);
              paramAnonymousView.putExtra("from", "zhaozhao");
              f.d(f.this).startActivity(paramAnonymousView);
            }
          });
          break;
          if (!((String)localObject1).equals(parama.n.getTag()))
          {
            parama.n.setTag(localObject1);
            parama.n.setController(c.frescoController((String)localObject1));
          }
        }
      }
      if ("101".equals(localObject1))
      {
        if (parama.m != null) {
          parama.m.setVisibility(8);
        }
        if (parama.l != null) {
          parama.l.setVisibility(8);
        }
        if (parama.y != null) {
          parama.y.setVisibility(8);
        }
        if (paramEMMessage.direct() == EMMessage.Direct.SEND)
        {
          if (parama.v != null)
          {
            parama.v.setVisibility(0);
            parama.v.setText("你们可以开始聊天了，打个招呼吧");
            parama.v.setAlpha(0.2F);
          }
        }
        else if (parama.v != null)
        {
          parama.v.setVisibility(0);
          parama.v.setText("ta想认识你，打个招呼吧");
          parama.v.setAlpha(0.2F);
        }
      }
      else if ("104".equals(localObject1))
      {
        if (parama.v != null) {
          parama.v.setVisibility(8);
        }
        if (parama.m != null) {
          parama.m.setVisibility(8);
        }
        if (parama.q != null) {
          parama.q.setVisibility(8);
        }
        if (parama.l != null) {
          parama.l.setVisibility(0);
        }
        if (parama.c != null) {
          parama.c.setVisibility(8);
        }
        if (parama.y != null)
        {
          parama.y.setVisibility(0);
          localObject1 = paramEMMessage.getStringAttribute("gifFileName", "");
          paramInt = this.d.getResources().getIdentifier(String.format("%s_g", new Object[] { localObject1 }), "drawable", this.d.getPackageName());
          parama.y.setController(c.frescoFromResourceController(paramInt));
        }
      }
      else
      {
        if (parama.v != null) {
          parama.v.setVisibility(8);
        }
        if (parama.m != null) {
          parama.m.setVisibility(8);
        }
        if (parama.q != null) {
          parama.q.setVisibility(8);
        }
        if (parama.l != null) {
          parama.l.setVisibility(0);
        }
        if (parama.c != null) {
          parama.c.setVisibility(0);
        }
        if (parama.y != null) {
          parama.y.setVisibility(8);
        }
        localObject1 = (EMTextMessageBody)paramEMMessage.getBody();
        localObject2 = SmileUtils.getSmiledText(this.d, ((EMTextMessageBody)localObject1).getMessage());
        parama.c.setText(((EMTextMessageBody)localObject1).getMessage());
        parama.c.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
      }
    }
    parama.d.setVisibility(8);
    parama.e.setVisibility(8);
    return;
    parama.d.setVisibility(8);
    parama.e.setVisibility(8);
    return;
    parama.d.setVisibility(8);
    parama.e.setVisibility(0);
    return;
    parama.d.setVisibility(8);
    parama.e.setVisibility(8);
    return;
  }
  
  private void a(final EMMessage paramEMMessage, final a parama, int paramInt, final View paramView)
  {
    parama.d.setTag(Integer.valueOf(paramInt));
    if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
      if (paramEMMessage.status() == EMMessage.Status.INPROGRESS)
      {
        parama.a.setImageResource(2130838350);
        a(paramEMMessage, parama);
      }
    }
    do
    {
      EMImageMessageBody localEMImageMessageBody;
      do
      {
        return;
        parama.d.setVisibility(8);
        parama.c.setVisibility(8);
        parama.a.setImageResource(2130838350);
        localEMImageMessageBody = (EMImageMessageBody)paramEMMessage.getBody();
      } while (localEMImageMessageBody.getLocalUrl() == null);
      String str2 = h.getImagePath(localEMImageMessageBody.getRemoteUrl());
      localEMImageMessageBody.getThumbnailUrl();
      String str1 = localEMImageMessageBody.thumbnailLocalPath();
      paramView = str1;
      if (!new File(str1).exists()) {
        paramView = h.getThumbnailImagePath(localEMImageMessageBody.getLocalUrl());
      }
      a(paramView, parama.a, parama.b, str2, localEMImageMessageBody.getRemoteUrl(), paramEMMessage);
      return;
      parama.j.setVisibility(0);
      parama.k.setVisibility(0);
      parama.a.setVisibility(0);
      paramView = ((EMImageMessageBody)paramEMMessage.getBody()).getLocalUrl();
      if ((paramView != null) && (new File(paramView).exists())) {
        a(h.getThumbnailImagePath(paramView), parama.a, parama.b, paramView, null, paramEMMessage);
      }
      for (;;)
      {
        switch (7.b[paramEMMessage.status().ordinal()])
        {
        default: 
          b(paramEMMessage, parama);
          return;
          a(h.getThumbnailImagePath(paramView), parama.a, parama.b, paramView, "chat/image/", paramEMMessage);
        }
      }
      parama.d.setVisibility(8);
      parama.c.setVisibility(8);
      parama.e.setVisibility(8);
      return;
      parama.d.setVisibility(8);
      parama.c.setVisibility(8);
      parama.e.setVisibility(0);
      return;
      parama.e.setVisibility(8);
      parama.d.setVisibility(0);
      parama.c.setVisibility(0);
    } while (this.j.containsKey(paramEMMessage.getMsgId()));
    paramView = new Timer();
    this.j.put(paramEMMessage.getMsgId(), paramView);
    paramView.schedule(new TimerTask()
    {
      public void run()
      {
        f.f(f.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            f.13.this.a.d.setVisibility(0);
            f.13.this.a.c.setVisibility(0);
            f.13.this.a.c.setText(f.13.this.b.progress() + "%");
            if (f.13.this.b.status() == EMMessage.Status.SUCCESS)
            {
              f.13.this.a.d.setVisibility(8);
              f.13.this.a.c.setVisibility(8);
              f.13.this.c.cancel();
            }
            while (f.13.this.b.status() != EMMessage.Status.FAIL) {
              return;
            }
            f.13.this.a.d.setVisibility(8);
            f.13.this.a.c.setVisibility(8);
            f.13.this.a.e.setVisibility(0);
            com.freelxl.baselibrary.f.g.textToast(f.f(f.this), f.f(f.this).getString(2131297427) + f.f(f.this).getString(2131296734), 0);
            f.13.this.c.cancel();
          }
        });
      }
    }, 0L, 500L);
  }
  
  private void a(String paramString, final boolean paramBoolean)
  {
    n.getUrl2Bitmap(this.d, paramString, new com.freelxl.baselibrary.d.c.a(new com.ziroom.commonlibrary.a.b.a())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null)
        {
          if (!paramBoolean) {
            break label28;
          }
          f.a(f.this, paramAnonymousBitmap);
        }
        for (;;)
        {
          f.this.refresh();
          return;
          label28:
          f.b(f.this, paramAnonymousBitmap);
        }
      }
    });
  }
  
  private boolean a(final String paramString1, final ImageView paramImageView1, ImageView paramImageView2, final String paramString2, final String paramString3, final EMMessage paramEMMessage)
  {
    d.convertDip2Px(this.d, 124);
    Bitmap localBitmap = com.ziroom.ziroomcustomer.newchat.g.getInstance().get(paramString1);
    if (localBitmap != null)
    {
      paramImageView1.setImageBitmap(d.convertBitmap(localBitmap, d.convertDip2Px(this.d, 90), d.convertDip2Px(this.d, 90)));
      if (paramImageView2 != null) {
        paramImageView2.setVisibility(8);
      }
      paramImageView1.setClickable(true);
      paramImageView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(f.f(f.this), ShowBigImage.class);
          paramAnonymousView.putExtra("messageId", paramEMMessage.getMsgId());
          File localFile;
          if (paramEMMessage.direct() == EMMessage.Direct.SEND)
          {
            localFile = new File(paramString2);
            if (localFile.exists()) {
              paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
            }
          }
          for (;;)
          {
            if ((paramEMMessage != null) && (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) && (!paramEMMessage.isAcked()) && (paramEMMessage.getChatType() != EMMessage.ChatType.GroupChat)) {}
            try
            {
              EMClient.getInstance().chatManager().ackMessageRead(paramEMMessage.getFrom(), paramEMMessage.getMsgId());
              paramEMMessage.setAcked(true);
              paramAnonymousView.putExtra("remotepath", ((EMImageMessageBody)paramEMMessage.getBody()).getLocalUrl());
              f.f(f.this).startActivity(paramAnonymousView, ActivityOptions.makeScaleUpAnimation(paramImageView1, paramImageView1.getWidth() / 2, paramImageView1.getHeight() / 2, 0, 0).toBundle());
              return;
              paramAnonymousView.putExtra("secret", ((EMImageMessageBody)paramEMMessage.getBody()).getSecret());
              paramAnonymousView.putExtra("remotepath", paramString3);
              continue;
              if (paramEMMessage.direct() != EMMessage.Direct.RECEIVE) {
                continue;
              }
              localFile = new File(paramString1);
              if (localFile.exists())
              {
                paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
                continue;
              }
              paramAnonymousView.putExtra("remotepath", paramString3);
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      });
      return true;
    }
    new com.ziroom.ziroomcustomer.social.activity.zz.a().execute(new Object[] { paramString1, paramString2, paramString3, paramEMMessage.getChatType(), paramImageView1, this.g, paramEMMessage, paramImageView2 });
    return true;
  }
  
  private void b(EMMessage paramEMMessage, final a parama)
  {
    try
    {
      paramEMMessage.getTo();
      parama.e.setVisibility(8);
      parama.d.setVisibility(0);
      parama.c.setVisibility(0);
      parama.c.setText("0%");
      System.currentTimeMillis();
      EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
      paramEMMessage.setMessageStatusCallback(new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          f.f(f.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              f.2.this.a.d.setVisibility(8);
              f.2.this.a.c.setVisibility(8);
              f.2.this.a.e.setVisibility(0);
              com.freelxl.baselibrary.f.g.textToast(f.f(f.this), f.f(f.this).getString(2131297427) + f.f(f.this).getString(2131296734), 0);
            }
          });
        }
        
        public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
        {
          f.f(f.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              f.2.this.a.c.setText(paramAnonymousInt + "%");
            }
          });
        }
        
        public void onSuccess()
        {
          Log.d("SocialZzMessageAdapter", "send image message successfully");
          f.f(f.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              f.2.this.a.d.setVisibility(8);
              f.2.this.a.c.setVisibility(8);
            }
          });
        }
      });
      return;
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  private void c(final EMMessage paramEMMessage, final a parama)
  {
    this.g.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramEMMessage.status() == EMMessage.Status.SUCCESS)
        {
          parama.d.setVisibility(8);
          parama.e.setVisibility(8);
        }
        for (;;)
        {
          f.this.notifyDataSetChanged();
          return;
          if (paramEMMessage.status() == EMMessage.Status.FAIL)
          {
            parama.d.setVisibility(8);
            parama.e.setVisibility(0);
            com.freelxl.baselibrary.f.g.textToast(f.f(f.this), f.f(f.this).getString(2131297427) + f.f(f.this).getString(2131296734), 0);
          }
        }
      }
    });
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public EMMessage getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt < this.a.length)) {
      return this.a[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    EMMessage localEMMessage = getItem(paramInt);
    if (localEMMessage == null) {}
    do
    {
      return -1;
      if (localEMMessage.getType() == EMMessage.Type.TXT)
      {
        if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
          return 0;
        }
        return 1;
      }
    } while (localEMMessage.getType() != EMMessage.Type.IMAGE);
    if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
      return 3;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final EMMessage localEMMessage1 = getItem(paramInt);
    EMMessage.ChatType localChatType = localEMMessage1.getChatType();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(localEMMessage1, paramInt);
      paramViewGroup.w = ((TextView)paramView.findViewById(2131696902));
      if (localEMMessage1.getType() != EMMessage.Type.IMAGE) {}
    }
    try
    {
      paramViewGroup.a = ((BuddleArrowView)paramView.findViewById(2131697432));
      paramViewGroup.f = ((CircleImageView)paramView.findViewById(2131693228));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131696907));
      paramViewGroup.d = ((ProgressBar)paramView.findViewById(2131697433));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131696914));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131696904));
      paramViewGroup.j = ((RelativeLayout)paramView.findViewById(2131697441));
      paramViewGroup.k = ((LinearLayout)paramView.findViewById(2131696906));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131697590));
      paramViewGroup.x = paramView.findViewById(2131690279);
      paramView.setTag(paramViewGroup);
      label201:
      EMMessage.Type localType = localEMMessage1.getType();
      if (localType == EMMessage.Type.IMAGE)
      {
        a(localEMMessage1, paramViewGroup, paramInt, paramView);
        label225:
        if ((localChatType == EMMessage.ChatType.GroupChat) && (localEMMessage1.direct() == EMMessage.Direct.RECEIVE)) {
          paramViewGroup.g.setText(localEMMessage1.getFrom());
        }
        if ((localEMMessage1.direct() != EMMessage.Direct.SEND) || (localChatType == EMMessage.ChatType.GroupChat)) {
          break label776;
        }
        paramViewGroup.h = ((TextView)paramView.findViewById(2131696915));
        paramViewGroup.i = ((TextView)paramView.findViewById(2131696916));
        if (paramViewGroup.h != null) {
          paramViewGroup.h.setVisibility(8);
        }
        if (paramViewGroup.i != null) {
          paramViewGroup.i.setVisibility(8);
        }
        label335:
        if (localEMMessage1.direct() != EMMessage.Direct.SEND) {
          break label856;
        }
        if (paramViewGroup.f != null)
        {
          if (this.n != null) {
            paramViewGroup.f.setImageBitmap(this.n);
          }
          paramViewGroup.f.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(f.d(f.this), ZzSocialMySpaceActivity.class);
              paramAnonymousView.putExtra("isEditer", true);
              f.d(f.this).startActivity(paramAnonymousView);
            }
          });
        }
        paramView.findViewById(2131696914).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            f.a(f.this, localEMMessage1);
          }
        });
        label406:
        paramViewGroup.w.setAlpha(0.2F);
        if (paramInt != 0) {
          break label899;
        }
        paramViewGroup.w.setText(i.getZzTimestampString(new Date(localEMMessage1.getMsgTime())));
        paramViewGroup.w.setVisibility(0);
      }
      for (;;)
      {
        if (this.a != null)
        {
          if (paramInt == this.a.length - 1)
          {
            paramViewGroup.x.setVisibility(0);
            return paramView;
            if (localEMMessage1.getType() != EMMessage.Type.TXT) {
              break;
            }
            try
            {
              paramViewGroup.d = ((ProgressBar)paramView.findViewById(2131697440));
              paramViewGroup.e = ((ImageView)paramView.findViewById(2131696914));
              paramViewGroup.f = ((CircleImageView)paramView.findViewById(2131693228));
              paramViewGroup.c = ((TextView)paramView.findViewById(2131696912));
              paramViewGroup.g = ((TextView)paramView.findViewById(2131696904));
              paramViewGroup.m = ((RelativeLayout)paramView.findViewById(2131697577));
              paramViewGroup.n = ((SimpleDraweeView)paramView.findViewById(2131697578));
              paramViewGroup.o = ((TextView)paramView.findViewById(2131697579));
              paramViewGroup.p = ((TextView)paramView.findViewById(2131697580));
              paramViewGroup.q = ((RelativeLayout)paramView.findViewById(2131697581));
              paramViewGroup.r = ((SimpleDraweeView)paramView.findViewById(2131697583));
              paramViewGroup.s = ((TextView)paramView.findViewById(2131697584));
              paramViewGroup.t = ((TextView)paramView.findViewById(2131697585));
              paramViewGroup.u = ((TextView)paramView.findViewById(2131697586));
              paramViewGroup.l = ((RelativeLayout)paramView.findViewById(2131697588));
              paramViewGroup.v = ((TextView)paramView.findViewById(2131697587));
              paramViewGroup.x = paramView.findViewById(2131690279);
              paramViewGroup.y = ((SimpleDraweeView)paramView.findViewById(2131697589));
            }
            catch (Exception localException2) {}
            break;
            paramViewGroup = (a)paramView.getTag();
            break label201;
            if (localException2 != EMMessage.Type.TXT) {
              break label225;
            }
            a(localEMMessage1, paramViewGroup, paramInt);
            break label225;
            label776:
            if (((localEMMessage1.getType() != EMMessage.Type.TXT) && (localEMMessage1.getType() != EMMessage.Type.LOCATION)) || (localChatType == EMMessage.ChatType.GroupChat) || (localEMMessage1.getBooleanAttribute("is_voice_call", false))) {
              break label335;
            }
            try
            {
              EMClient.getInstance().chatManager().ackMessageRead(localEMMessage1.getFrom(), localEMMessage1.getMsgId());
              localEMMessage1.setAcked(true);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
            break label335;
            label856:
            if (paramViewGroup.f == null) {
              break label406;
            }
            if (this.o != null) {
              paramViewGroup.f.setImageBitmap(this.o);
            }
            paramViewGroup.f.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                paramAnonymousView = new Intent(f.d(f.this), ZzSocialMySpaceActivity.class);
                paramAnonymousView.putExtra("isEditer", false);
                paramAnonymousView.putExtra("be_uid", f.e(f.this));
                f.d(f.this).startActivity(paramAnonymousView);
              }
            });
            break label406;
            label899:
            EMMessage localEMMessage2 = this.a[(paramInt - 1)];
            if (DateUtils.isCloseEnough(localEMMessage1.getMsgTime(), localEMMessage2.getMsgTime()))
            {
              paramViewGroup.w.setVisibility(8);
              continue;
            }
            paramViewGroup.w.setText(i.getZzTimestampString(new Date(localEMMessage1.getMsgTime())));
            paramViewGroup.w.setVisibility(0);
            continue;
          }
          paramViewGroup.x.setVisibility(8);
          return paramView;
        }
      }
      paramViewGroup.x.setVisibility(8);
      return paramView;
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  public int getViewTypeCount()
  {
    return 19;
  }
  
  public void refresh()
  {
    if (this.b.hasMessages(0)) {
      return;
    }
    Message localMessage = this.b.obtainMessage(0);
    this.b.sendMessage(localMessage);
  }
  
  public void refreshSeekTo(int paramInt)
  {
    this.b.sendMessage(this.b.obtainMessage(0));
  }
  
  public void refreshSelectLast()
  {
    this.b.removeMessages(0);
    this.b.removeMessages(1);
    this.b.sendEmptyMessageDelayed(0, 100L);
    this.b.sendEmptyMessageDelayed(1, 100L);
  }
  
  public void sendMsgInBackground(final EMMessage paramEMMessage, final a parama)
  {
    parama.e.setVisibility(8);
    parama.d.setVisibility(8);
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        f.a(f.this, paramEMMessage, parama);
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        f.a(f.this, paramEMMessage, parama);
      }
    });
  }
  
  public static class a
  {
    BuddleArrowView a;
    ImageView b;
    TextView c;
    ProgressBar d;
    ImageView e;
    CircleImageView f;
    TextView g;
    TextView h;
    TextView i;
    RelativeLayout j;
    LinearLayout k;
    RelativeLayout l;
    RelativeLayout m;
    SimpleDraweeView n;
    TextView o;
    TextView p;
    RelativeLayout q;
    SimpleDraweeView r;
    TextView s;
    TextView t;
    TextView u;
    TextView v;
    TextView w;
    View x;
    SimpleDraweeView y;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */