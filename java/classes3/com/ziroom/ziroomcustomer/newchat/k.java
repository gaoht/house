package com.ziroom.ziroomcustomer.newchat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
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
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends BaseAdapter
{
  Handler a = new Handler()
  {
    private void a()
    {
      u.e("sdjgkdsj", "===== zhixingle   22222");
      k.a(k.this, EMClient.getInstance().chatManager().getConversation(k.a(k.this), EMConversation.EMConversationType.Chat, true));
      u.e("sdjgkdsj", "===== zhixingle   22222  username" + k.a(k.this));
      u.e("sdjgkdsj", "===== zhixingle   22222" + k.b(k.this));
      if (k.b(k.this) != null)
      {
        k.a(k.this, (EMMessage[])k.c(k.this).toArray(new EMMessage[k.c(k.this).size()]));
        k.b(k.this).markAllMessagesAsRead();
        k.this.notifyDataSetChanged();
        return;
      }
      k.a(k.this, null);
      k.this.notifyDataSetChanged();
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
        } while ((k.d(k.this) == null) || (k.d(k.this).length <= 0));
        k.e(k.this).setSelection(k.d(k.this).length - 1);
        return;
      }
      int i = paramAnonymousMessage.arg1;
      k.e(k.this).setSelection(i);
    }
  };
  private String b;
  private LayoutInflater c;
  private Activity d;
  private a e;
  private EMConversation f;
  private Context g;
  private int h = 5;
  private EMMessage[] i = null;
  private Map<String, Timer> j = new Hashtable();
  private XListView k;
  private Boolean l = Boolean.valueOf(true);
  private List<EMMessage> m = new ArrayList();
  
  public k(Context paramContext, String paramString, int paramInt, XListView paramXListView)
  {
    this.b = paramString;
    this.g = paramContext;
    this.k = paramXListView;
    this.c = LayoutInflater.from(paramContext);
    this.d = ((Activity)paramContext);
    this.f = EMClient.getInstance().chatManager().getConversation(paramString);
  }
  
  private View a(EMMessage paramEMMessage, int paramInt)
  {
    switch (11.a[paramEMMessage.getType().ordinal()])
    {
    default: 
      if (paramEMMessage.getBooleanAttribute("weichat_businesss_msg", false)) {
        return this.c.inflate(2130905107, null);
      }
      break;
    case 1: 
      if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
        return this.c.inflate(2130905102, null);
      }
      return this.c.inflate(2130905105, null);
    }
    if (new l().isEvalMessage(paramEMMessage))
    {
      if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
        return this.c.inflate(2130905103, null);
      }
      return this.c.inflate(2130905106, null);
    }
    if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
      return this.c.inflate(2130905101, null);
    }
    return this.c.inflate(2130905104, null);
  }
  
  private void a(int paramInt, b paramb)
  {
    this.h = paramInt;
    if (paramInt == 1)
    {
      paramb.s.setImageResource(2130839757);
      paramb.t.setImageResource(2130839753);
      paramb.u.setImageResource(2130839753);
      paramb.v.setImageResource(2130839753);
      paramb.w.setImageResource(2130839753);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        paramb.s.setImageResource(2130839757);
        paramb.t.setImageResource(2130839757);
        paramb.u.setImageResource(2130839753);
        paramb.v.setImageResource(2130839753);
        paramb.w.setImageResource(2130839753);
        return;
      }
      if (paramInt == 3)
      {
        paramb.s.setImageResource(2130839757);
        paramb.t.setImageResource(2130839757);
        paramb.u.setImageResource(2130839757);
        paramb.v.setImageResource(2130839753);
        paramb.w.setImageResource(2130839753);
        return;
      }
      if (paramInt == 4)
      {
        paramb.s.setImageResource(2130839757);
        paramb.t.setImageResource(2130839757);
        paramb.u.setImageResource(2130839757);
        paramb.v.setImageResource(2130839757);
        paramb.w.setImageResource(2130839753);
        return;
      }
    } while (paramInt != 5);
    paramb.s.setImageResource(2130839757);
    paramb.t.setImageResource(2130839757);
    paramb.u.setImageResource(2130839757);
    paramb.v.setImageResource(2130839757);
    paramb.w.setImageResource(2130839757);
  }
  
  private void a(EMMessage paramEMMessage)
  {
    if (!this.l.booleanValue()) {
      EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    }
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess() {}
    });
    refresh();
  }
  
  private void a(final EMMessage paramEMMessage, int paramInt, b paramb)
  {
    for (;;)
    {
      try
      {
        final JSONObject localJSONObject1 = paramEMMessage.getJSONObjectAttribute("weichat");
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("ctrlArgs");
        final EMMessage localEMMessage = EMMessage.createTxtSendMessage("评价", paramEMMessage.getFrom());
        localJSONObject2.put("summary", paramInt + "");
        localJSONObject1.put("ctrlType", "enquiry");
        localEMMessage.setAttribute("weichat", localJSONObject1);
        paramb.m.setVisibility(8);
        paramb.o.setBackgroundResource(2130838131);
        paramb.s.setClickable(false);
        paramb.t.setClickable(false);
        paramb.u.setClickable(false);
        paramb.v.setClickable(false);
        paramb.w.setClickable(false);
        if (!TextUtils.isEmpty(paramInt + ""))
        {
          a(Integer.parseInt(paramInt + ""), paramb);
          if ("1".equals(paramInt + "")) {
            paramb.o.setText("非常不满意");
          }
        }
        else
        {
          EMClient.getInstance().chatManager().sendMessage(localEMMessage);
          localEMMessage.setMessageStatusCallback(new EMCallBack()
          {
            public void onError(int paramAnonymousInt, String paramAnonymousString) {}
            
            public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
            
            public void onSuccess()
            {
              EMClient.getInstance().chatManager().getConversation(paramEMMessage.getFrom()).removeMessage(localEMMessage.getMsgId());
              try
              {
                localJSONObject1.put("enable", true);
                paramEMMessage.setAttribute("weichat", localJSONObject1);
                EMClient.getInstance().chatManager().updateMessage(paramEMMessage);
                return;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  localJSONException.printStackTrace();
                }
              }
            }
          });
          return;
        }
        if ("2".equals(paramInt + ""))
        {
          paramb.o.setText("不满意");
          continue;
        }
      }
      catch (JSONException paramEMMessage)
      {
        paramEMMessage.printStackTrace();
        return;
        if ("3".equals(paramInt + ""))
        {
          paramb.o.setText("一般");
          continue;
        }
      }
      catch (HyphenateException paramEMMessage)
      {
        paramEMMessage.printStackTrace();
        return;
      }
      if ("4".equals(paramInt + "")) {
        paramb.o.setText("满意");
      } else if ("5".equals(paramInt + "")) {
        paramb.o.setText("非常满意");
      }
    }
  }
  
  private void a(EMMessage paramEMMessage, final long paramLong)
  {
    this.d.runOnUiThread(new Runnable()
    {
      public void run()
      {
        System.currentTimeMillis();
        long l = paramLong;
        HashMap localHashMap = new HashMap();
        if (this.b.status() == EMMessage.Status.SUCCESS) {
          localHashMap.put("status", "success");
        }
        for (;;)
        {
          switch (k.11.a[this.b.getType().ordinal()])
          {
          }
          return;
          localHashMap.put("status", "failure");
        }
      }
    });
  }
  
  private void a(final EMMessage paramEMMessage, final b paramb)
  {
    System.err.println("!!! show download image progress");
    EMFileMessageBody localEMFileMessageBody = (EMFileMessageBody)paramEMMessage.getBody();
    if (paramb.g != null) {
      paramb.g.setVisibility(0);
    }
    if (paramb.f != null) {
      paramb.f.setVisibility(0);
    }
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramEMMessage.getType() == EMMessage.Type.IMAGE) {
          k.h(k.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              k.6.this.b.f.setText(paramAnonymousInt + "%");
            }
          });
        }
      }
      
      public void onSuccess()
      {
        k.h(k.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (k.6.this.a.getType() == EMMessage.Type.IMAGE)
            {
              k.6.this.b.g.setVisibility(8);
              k.6.this.b.f.setVisibility(8);
            }
            k.this.notifyDataSetChanged();
          }
        });
      }
    });
  }
  
  private void a(final EMMessage paramEMMessage, final b paramb, int paramInt)
  {
    for (paramInt = 1;; paramInt = 0)
    {
      String str1;
      try
      {
        JSONObject localJSONObject1 = paramEMMessage.getJSONObjectAttribute("weichat");
        u.e("jsonObj", "========   WEICHAT_MSG 22   " + com.alibaba.fastjson.a.toJSONString(localJSONObject1));
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("ctrlArgs");
        String str2 = "";
        str1 = str2;
        if (localJSONObject2.has("summary"))
        {
          str1 = str2;
          if (!localJSONObject2.isNull("summary")) {
            str1 = localJSONObject2.getString("summary");
          }
        }
        if ((!localJSONObject1.has("ctrlType")) || (localJSONObject1.isNull("ctrlType"))) {
          break;
        }
        if (!localJSONObject1.has("enable")) {
          continue;
        }
        if (paramInt == 0) {
          break label325;
        }
        paramb.m.setVisibility(8);
        paramb.o.setBackgroundResource(2130838131);
        paramb.s.setClickable(false);
        paramb.t.setClickable(false);
        paramb.u.setClickable(false);
        paramb.v.setClickable(false);
        paramb.w.setClickable(false);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        a(Integer.parseInt(str1), paramb);
        if ("1".equals(str1))
        {
          paramb.o.setText("非常不满意");
          return;
        }
        if ("2".equals(str1))
        {
          paramb.o.setText("不满意");
          return;
        }
      }
      catch (Exception paramEMMessage)
      {
        paramEMMessage.printStackTrace();
        return;
      }
      if ("3".equals(str1))
      {
        paramb.o.setText("一般");
        return;
      }
      if ("4".equals(str1))
      {
        paramb.o.setText("满意");
        return;
      }
      if (!"5".equals(str1)) {
        break;
      }
      paramb.o.setText("非常满意");
      return;
      label325:
      paramb.m.setVisibility(8);
      paramb.o.setBackgroundResource(2130838130);
      paramb.o.setText("提交评价");
      paramb.s.setClickable(true);
      paramb.t.setClickable(true);
      paramb.u.setClickable(true);
      paramb.v.setClickable(true);
      paramb.w.setClickable(true);
      a(5, paramb);
      paramb.s.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, 1, paramb);
        }
      });
      paramb.t.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, 2, paramb);
        }
      });
      paramb.u.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, 3, paramb);
        }
      });
      paramb.v.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, 4, paramb);
        }
      });
      paramb.w.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, 5, paramb);
        }
      });
      paramb.o.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.a(k.this, paramEMMessage, k.f(k.this), paramb);
        }
      });
      return;
    }
  }
  
  private void a(final EMMessage paramEMMessage, final b paramb, int paramInt, final View paramView)
  {
    paramb.g.setTag(Integer.valueOf(paramInt));
    paramView = paramEMMessage.getStringAttribute("name", null);
    String str1 = paramEMMessage.getStringAttribute("price", null);
    Object localObject = paramEMMessage.getStringAttribute("picUrl", null);
    if (paramView != null)
    {
      paramb.q.setVisibility(0);
      paramb.r.setVisibility(8);
      paramb.c.setVisibility(0);
      paramb.d.setVisibility(0);
      paramb.e.setVisibility(0);
      paramb.c.setText("我正在看：");
      paramb.d.setText(paramView);
      paramb.e.setText(str1 + " 元/月");
      paramb.a.setVisibility(0);
      paramb.z.setVisibility(0);
      u.e("picUrl", (String)localObject);
      paramb.b.setVisibility(8);
      paramb.a.setController(c.frescoController((String)localObject));
    }
    if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
      if (paramEMMessage.status() == EMMessage.Status.INPROGRESS)
      {
        paramb.b.setImageResource(2130838350);
        a(paramEMMessage, paramb);
      }
    }
    label503:
    do
    {
      do
      {
        return;
        paramb.g.setVisibility(8);
        paramb.f.setVisibility(8);
        paramb.b.setImageResource(2130838350);
        localObject = (EMImageMessageBody)paramEMMessage.getBody();
      } while (((EMImageMessageBody)localObject).getLocalUrl() == null);
      String str2 = h.getImagePath(((EMImageMessageBody)localObject).getRemoteUrl());
      ((EMImageMessageBody)localObject).getThumbnailUrl();
      str1 = ((EMImageMessageBody)localObject).thumbnailLocalPath();
      paramView = str1;
      if (!new File(str1).exists()) {
        paramView = h.getThumbnailImagePath(((EMImageMessageBody)localObject).getLocalUrl());
      }
      a(paramView, paramb.b, str2, ((EMImageMessageBody)localObject).getRemoteUrl(), paramEMMessage);
      return;
      if (paramView == null)
      {
        paramb.q.setVisibility(8);
        paramb.r.setVisibility(0);
        paramb.c.setVisibility(8);
        paramb.d.setVisibility(8);
        paramb.e.setVisibility(8);
        paramb.z.setVisibility(0);
        paramb.a.setVisibility(8);
        paramb.b.setVisibility(0);
        paramView = ((EMImageMessageBody)paramEMMessage.getBody()).getLocalUrl();
        if ((paramView == null) || (!new File(paramView).exists())) {
          break label503;
        }
        a(h.getThumbnailImagePath(paramView), paramb.b, paramView, null, paramEMMessage);
      }
      for (;;)
      {
        switch (11.b[paramEMMessage.status().ordinal()])
        {
        default: 
          b(paramEMMessage, paramb);
          return;
          a(h.getThumbnailImagePath(paramView), paramb.b, paramView, "chat/image/", paramEMMessage);
        }
      }
      paramb.g.setVisibility(8);
      paramb.f.setVisibility(8);
      paramb.h.setVisibility(8);
      return;
      paramb.g.setVisibility(8);
      paramb.f.setVisibility(8);
      paramb.h.setVisibility(0);
      return;
      paramb.h.setVisibility(8);
      paramb.g.setVisibility(0);
      paramb.f.setVisibility(0);
    } while (this.j.containsKey(paramEMMessage.getMsgId()));
    paramView = new Timer();
    this.j.put(paramEMMessage.getMsgId(), paramView);
    paramView.schedule(new TimerTask()
    {
      public void run()
      {
        k.h(k.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            k.4.this.a.g.setVisibility(0);
            k.4.this.a.f.setVisibility(0);
            k.4.this.a.f.setText(k.4.this.b.progress() + "%");
            if (k.4.this.b.status() == EMMessage.Status.SUCCESS)
            {
              k.4.this.a.g.setVisibility(8);
              k.4.this.a.f.setVisibility(8);
              k.4.this.c.cancel();
            }
            while (k.4.this.b.status() != EMMessage.Status.FAIL) {
              return;
            }
            k.4.this.a.g.setVisibility(8);
            k.4.this.a.f.setVisibility(8);
            k.4.this.a.h.setVisibility(0);
            com.freelxl.baselibrary.f.g.textToast(k.h(k.this), k.h(k.this).getString(2131297427) + k.h(k.this).getString(2131296734), 0);
            k.4.this.c.cancel();
          }
        });
      }
    }, 0L, 500L);
  }
  
  private boolean a(final String paramString1, ImageView paramImageView, final String paramString2, final String paramString3, final EMMessage paramEMMessage)
  {
    Bitmap localBitmap = g.getInstance().get(paramString1);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(d.convertBitmap(localBitmap, d.convertDip2Px(this.g, 90), d.convertDip2Px(this.g, 90)));
      paramImageView.setClickable(true);
      paramImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(k.h(k.this), ShowBigImage.class);
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
              k.h(k.this).startActivity(paramAnonymousView);
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
              paramAnonymousView.putExtra("remotepath", ((EMImageMessageBody)paramEMMessage.getBody()).getLocalUrl());
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
    new i().execute(new Object[] { paramString1, paramString2, paramString3, paramEMMessage.getChatType(), paramImageView, this.d, paramEMMessage });
    return true;
  }
  
  private void b(final EMMessage paramEMMessage, b paramb)
  {
    try
    {
      paramEMMessage.getTo();
      paramb.h.setVisibility(8);
      paramb.g.setVisibility(0);
      paramb.f.setVisibility(0);
      paramb.f.setText("0%");
      final long l1 = System.currentTimeMillis();
      if (!this.l.booleanValue()) {
        EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
      }
      for (;;)
      {
        paramEMMessage.setMessageStatusCallback(new EMCallBack()
        {
          public void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            k.a(k.this, paramEMMessage, l1);
            k.h(k.this).runOnUiThread(new Runnable()
            {
              public void run()
              {
                k.7.this.c.g.setVisibility(8);
                k.7.this.c.f.setVisibility(8);
                k.7.this.c.h.setVisibility(0);
                com.freelxl.baselibrary.f.g.textToast(k.h(k.this), k.h(k.this).getString(2131297427) + k.h(k.this).getString(2131296734), 0);
              }
            });
          }
          
          public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
          {
            k.h(k.this).runOnUiThread(new Runnable()
            {
              public void run()
              {
                k.7.this.c.f.setText(paramAnonymousInt + "%");
              }
            });
          }
          
          public void onSuccess()
          {
            Log.d("msg", "send image message successfully");
            k.a(k.this, paramEMMessage, l1);
            k.h(k.this).runOnUiThread(new Runnable()
            {
              public void run()
              {
                k.7.this.c.g.setVisibility(8);
                k.7.this.c.f.setVisibility(8);
              }
            });
          }
        });
        return;
        paramb.g.setVisibility(8);
        paramb.f.setVisibility(8);
      }
      return;
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  private void b(final EMMessage paramEMMessage, b paramb, int paramInt)
  {
    try
    {
      paramInt = paramEMMessage.getIntAttribute("selectPostion", -1);
      final Object localObject = com.alibaba.fastjson.a.parseObject(paramEMMessage.getJSONObjectAttribute("weichat").get("weichat_businesss_msg").toString());
      final String str = ((e)localObject).getString("businessTypeId");
      paramb.x.setText(((e)localObject).getString("label"));
      localObject = com.alibaba.fastjson.a.parseArray(((e)localObject).getString("content"), com.ziroom.ziroomcustomer.newchat.chatcenter.b.a.class);
      localObject = new com.ziroom.ziroomcustomer.newchat.chatcenter.a.a(this.g, (List)localObject);
      paramb.y.setAdapter((ListAdapter)localObject);
      if (this.l.booleanValue()) {
        paramb.y.setChoiceMode(1);
      }
      for (;;)
      {
        paramb.y.setEnabled(this.l.booleanValue());
        paramb.y.setItemChecked(paramInt, true);
        paramb.y.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            paramEMMessage.setAttribute("selectPostion", paramAnonymousInt);
            if (k.g(k.this) != null) {
              k.g(k.this).onClick(localObject.getItem(paramAnonymousInt), str);
            }
          }
        });
        return;
        paramb.y.setChoiceMode(0);
      }
      return;
    }
    catch (JSONException paramEMMessage)
    {
      paramEMMessage.printStackTrace();
      return;
    }
    catch (HyphenateException paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  private void c(final EMMessage paramEMMessage, final b paramb)
  {
    this.d.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramEMMessage.getType() == EMMessage.Type.VIDEO) {
          paramb.f.setVisibility(8);
        }
        if (paramEMMessage.status() == EMMessage.Status.SUCCESS) {}
        for (;;)
        {
          k.this.notifyDataSetChanged();
          return;
          if (paramEMMessage.status() == EMMessage.Status.FAIL) {
            com.freelxl.baselibrary.f.g.textToast(k.h(k.this), k.h(k.this).getString(2131297427) + k.h(k.this).getString(2131296734), 0);
          }
        }
      }
    });
  }
  
  private void c(EMMessage paramEMMessage, b paramb, int paramInt)
  {
    Object localObject = (EMTextMessageBody)paramEMMessage.getBody();
    localObject = SmileUtils.getSmiledText(this.g, ((EMTextMessageBody)localObject).getMessage());
    paramb.f.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
    u.e("sdjgkdsj", "===== zhixingle   message.status()  " + paramEMMessage.status());
    if (paramEMMessage.direct() == EMMessage.Direct.SEND) {
      switch (11.b[paramEMMessage.status().ordinal()])
      {
      default: 
        sendMsgInBackground(paramEMMessage, paramb);
        u.e("sdjgkdsj", "===== zhixingle  isAcked   1111");
        if ((paramEMMessage.isAcked()) || (paramEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
          break;
        }
      }
    }
    try
    {
      u.e("sdjgkdsj", "===== zhixingle  isAcked   22222");
      EMClient.getInstance().chatManager().ackMessageRead(paramEMMessage.getFrom(), paramEMMessage.getMsgId());
      return;
    }
    catch (HyphenateException paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
    paramb.g.setVisibility(0);
    paramb.h.setVisibility(8);
    return;
    paramb.g.setVisibility(8);
    paramb.h.setVisibility(8);
    return;
    paramb.g.setVisibility(8);
    paramb.h.setVisibility(0);
    return;
    paramb.g.setVisibility(0);
    paramb.h.setVisibility(8);
    return;
  }
  
  public void addLocalMessage(EMMessage paramEMMessage)
  {
    this.m.add(paramEMMessage);
    refresh();
  }
  
  public void addLocalMessages(List<EMMessage> paramList, int paramInt)
  {
    this.m.addAll(paramInt, paramList);
    refresh();
  }
  
  public void clearMessages()
  {
    this.m.clear();
    refresh();
  }
  
  public int getCount()
  {
    if (this.i == null) {
      return 0;
    }
    return this.i.length;
  }
  
  public EMMessage getItem(int paramInt)
  {
    if ((this.i != null) && (paramInt < this.i.length)) {
      return this.i[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int n = 0;
    EMMessage localEMMessage = getItem(paramInt);
    if (localEMMessage == null) {
      paramInt = -1;
    }
    do
    {
      return paramInt;
      if (localEMMessage.getType() != EMMessage.Type.TXT) {
        break;
      }
      if (localEMMessage.getBooleanAttribute("weichat_businesss_msg", false)) {
        return 6;
      }
      if (new l().isEvalMessage(localEMMessage))
      {
        if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
          return 5;
        }
        return 4;
      }
      paramInt = n;
    } while (localEMMessage.direct() == EMMessage.Direct.RECEIVE);
    return 1;
    if (localEMMessage.getType() == EMMessage.Type.IMAGE)
    {
      if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
        return 3;
      }
      return 2;
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final EMMessage localEMMessage1 = getItem(paramInt);
    Object localObject = localEMMessage1.getChatType();
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = a(localEMMessage1, paramInt);
      if (localEMMessage1.getType() != EMMessage.Type.IMAGE) {}
    }
    try
    {
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131697446));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131697447));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131697448));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131697449));
      paramViewGroup.b = ((BubbleImageView)paramView.findViewById(2131697432));
      paramViewGroup.i = ((SimpleDraweeView)paramView.findViewById(2131693228));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131696907));
      paramViewGroup.g = ((ProgressBar)paramView.findViewById(2131697433));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131696914));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131696904));
      paramViewGroup.q = ((RelativeLayout)paramView.findViewById(2131697445));
      paramViewGroup.r = ((RelativeLayout)paramView.findViewById(2131697441));
      paramViewGroup.z = ((LinearLayout)paramView.findViewById(2131696906));
      paramView.setTag(paramViewGroup);
      label232:
      if ((localObject == EMMessage.ChatType.GroupChat) && (localEMMessage1.direct() == EMMessage.Direct.RECEIVE)) {
        paramViewGroup.j.setText(localEMMessage1.getFrom());
      }
      if ((localEMMessage1.direct() == EMMessage.Direct.SEND) && (localObject != EMMessage.ChatType.GroupChat))
      {
        paramViewGroup.k = ((TextView)paramView.findViewById(2131696915));
        paramViewGroup.l = ((TextView)paramView.findViewById(2131696916));
        if (paramViewGroup.k != null)
        {
          if (localEMMessage1.isAcked())
          {
            if (paramViewGroup.l != null) {
              paramViewGroup.l.setVisibility(4);
            }
            paramViewGroup.k.setVisibility(0);
          }
        }
        else {
          label348:
          switch (11.a[localEMMessage1.getType().ordinal()])
          {
          default: 
            label384:
            if ((localEMMessage1.direct() == EMMessage.Direct.SEND) && (!localEMMessage1.getBooleanAttribute("weichat_businesss_msg", false)))
            {
              localObject = ApplicationEx.c.getUser();
              if (localObject == null) {
                break label969;
              }
              if (TextUtils.isEmpty(((UserInfo)localObject).getHead_img())) {
                break label956;
              }
              paramViewGroup.i.setController(c.frescoController(((UserInfo)localObject).getHead_img()));
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramView.findViewById(2131696914).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            k.a(k.this, localEMMessage1);
          }
        });
        paramViewGroup = (TextView)paramView.findViewById(2131696902);
        if (paramInt != 0) {
          break label982;
        }
        paramViewGroup.setText(DateUtils.getTimestampString(new Date(localEMMessage1.getMsgTime())));
        paramViewGroup.setVisibility(0);
        return paramView;
        if (localEMMessage1.getType() != EMMessage.Type.TXT) {
          break;
        }
        try
        {
          paramViewGroup.g = ((ProgressBar)paramView.findViewById(2131697440));
          paramViewGroup.h = ((ImageView)paramView.findViewById(2131696914));
          paramViewGroup.i = ((SimpleDraweeView)paramView.findViewById(2131693228));
          paramViewGroup.f = ((TextView)paramView.findViewById(2131696912));
          paramViewGroup.j = ((TextView)paramView.findViewById(2131696904));
          paramViewGroup.m = ((TextView)paramView.findViewById(2131697437));
          paramViewGroup.n = ((RelativeLayout)paramView.findViewById(2131697434));
          paramViewGroup.o = ((TextView)paramView.findViewById(2131697436));
          paramViewGroup.p = ((Button)paramView.findViewById(2131697439));
          paramViewGroup.s = ((ImageView)paramView.findViewById(2131690054));
          paramViewGroup.t = ((ImageView)paramView.findViewById(2131690055));
          paramViewGroup.u = ((ImageView)paramView.findViewById(2131690056));
          paramViewGroup.v = ((ImageView)paramView.findViewById(2131690057));
          paramViewGroup.w = ((ImageView)paramView.findViewById(2131690058));
          paramViewGroup.x = ((TextView)paramView.findViewById(2131697450));
          paramViewGroup.y = ((ListView)paramView.findViewById(2131690955));
        }
        catch (Exception localException2) {}
        break;
        paramViewGroup = (b)paramView.getTag();
        break label232;
        paramViewGroup.k.setVisibility(4);
        if (paramViewGroup.l == null) {
          break label348;
        }
        if (localEMMessage1.isDelivered())
        {
          paramViewGroup.l.setVisibility(0);
          break label348;
        }
        paramViewGroup.l.setVisibility(4);
        break label348;
        if (((localEMMessage1.getType() != EMMessage.Type.TXT) && (localEMMessage1.getType() != EMMessage.Type.LOCATION)) || (localObject == EMMessage.ChatType.GroupChat) || (localEMMessage1.getBooleanAttribute("is_voice_call", false))) {
          break label348;
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
        break label348;
        a(localEMMessage1, paramViewGroup, paramInt, paramView);
        break label384;
        if (localEMMessage1.getBooleanAttribute("weichat_businesss_msg", false))
        {
          b(localEMMessage1, paramViewGroup, paramInt);
          break label384;
        }
        if (new l().isEvalMessage(localEMMessage1))
        {
          a(localEMMessage1, paramViewGroup, paramInt);
          break label384;
        }
        c(localEMMessage1, paramViewGroup, paramInt);
        break label384;
        label956:
        paramViewGroup.i.setImageResource(2130838104);
        continue;
        label969:
        paramViewGroup.i.setImageResource(2130838104);
      }
      label982:
      EMMessage localEMMessage2 = this.i[(paramInt - 1)];
      if (DateUtils.isCloseEnough(localEMMessage1.getMsgTime(), localEMMessage2.getMsgTime()))
      {
        paramViewGroup.setVisibility(8);
        return paramView;
      }
      paramViewGroup.setText(DateUtils.getTimestampString(new Date(localEMMessage1.getMsgTime())));
      paramViewGroup.setVisibility(0);
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
    if (this.a.hasMessages(0)) {
      return;
    }
    Message localMessage = this.a.obtainMessage(0);
    this.a.sendMessage(localMessage);
  }
  
  public void refreshSeekTo(int paramInt)
  {
    this.a.sendMessage(this.a.obtainMessage(0));
    Message localMessage = this.a.obtainMessage(2);
    localMessage.arg1 = paramInt;
    this.a.sendMessage(localMessage);
  }
  
  public void refreshSelectLast()
  {
    this.a.removeMessages(0);
    this.a.removeMessages(1);
    this.a.sendEmptyMessageDelayed(0, 100L);
    this.a.sendEmptyMessageDelayed(1, 100L);
  }
  
  public void removeMessage(EMMessage paramEMMessage)
  {
    this.m.remove(paramEMMessage);
    refresh();
  }
  
  public void sendMsgInBackground(final EMMessage paramEMMessage, b paramb)
  {
    paramb.h.setVisibility(8);
    paramb.g.setVisibility(8);
    paramEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        u.e("sdjkgjk", "=======  sendMsgInBackgroundonError");
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString)
      {
        u.e("sdjkgjk", "=======  sendMsgInBackgroundonProgress");
      }
      
      public void onSuccess()
      {
        u.e("sdjkgjk", "=======  sendMsgInBackgroundonSuccess");
        k.a(k.this, paramEMMessage, this.b);
        k.a(k.this, paramEMMessage, this.c);
      }
    });
  }
  
  public void setIsSkillEnable(Boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setmBusinessItemLenter(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(com.ziroom.ziroomcustomer.newchat.chatcenter.b.a parama, String paramString);
  }
  
  public static class b
  {
    SimpleDraweeView a;
    BubbleImageView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    ProgressBar g;
    ImageView h;
    SimpleDraweeView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    RelativeLayout n;
    TextView o;
    Button p;
    RelativeLayout q;
    RelativeLayout r;
    ImageView s;
    ImageView t;
    ImageView u;
    ImageView v;
    ImageView w;
    TextView x;
    ListView y;
    LinearLayout z;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */