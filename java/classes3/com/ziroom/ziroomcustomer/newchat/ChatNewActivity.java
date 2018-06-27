package com.ziroom.ziroomcustomer.newchat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.NetUtils;
import com.hyphenate.util.PathUtil;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.s;
import com.ziroom.ziroomcustomer.e.c.v;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.o;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatNewActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private static int R;
  public static ChatNewActivity a = null;
  static int d;
  private InputMethodManager A;
  private PowerManager.WakeLock B;
  private int C = -1;
  private int D = -1;
  private List<String> E;
  private RelativeLayout F;
  private XListView G;
  private EMConversation H;
  private ClipboardManager I;
  private String J;
  private int K;
  private k L;
  private ProgressBar M;
  private boolean N = true;
  private final int O = 20;
  private File P;
  private b Q;
  private String S;
  private Context T;
  private PopupWindow U;
  private LinearLayout V;
  private int W;
  private NotificationManager X;
  private RelativeLayout Y;
  private LinearLayout Z;
  private String aa;
  private a ab = null;
  private String ac;
  private String ad;
  private EMMessageListener ae;
  private Boolean af = Boolean.valueOf(false);
  private String ag;
  private boolean ah = false;
  private Handler ai = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (EMClient.getInstance().isLoggedInBefore() == true)
      {
        ChatNewActivity.f(ChatNewActivity.this, ChatNewActivity.x(ChatNewActivity.this));
        return;
      }
      ChatNewActivity.this.showToast("服务器异常，请稍后再试");
    }
  };
  public String b;
  public String c = null;
  private BasicZiroomToolBar e;
  private EditText f;
  private ImageView g;
  private Button r;
  private Button s;
  private LinearLayout t;
  private RelativeLayout u;
  private ViewPager v;
  private RelativeLayout w;
  private LinearLayout x;
  private ImageView y;
  private ImageView z;
  
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
        g(paramUri);
        return;
      }
      showToast("服务器异常，请稍后再试");
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
      g(paramUri.getAbsolutePath());
      return;
    }
    showToast("服务器异常，请稍后再试");
  }
  
  private void a(EMMessage paramEMMessage)
  {
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.L.refresh();
  }
  
  private void a(String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.e.n.getSkillGroupType(this, paramString1, paramString2, new h(this, new v(o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, o paramAnonymouso)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouso);
        if ((paramAnonymouso == null) || (com.freelxl.baselibrary.f.f.isNull(paramAnonymouso.getSkillGroup()))) {
          return;
        }
        ChatNewActivity.d(ChatNewActivity.this, paramAnonymouso.getSkillGroup());
        ChatNewActivity.a(ChatNewActivity.this, Boolean.valueOf(true));
        ChatNewActivity.a(ChatNewActivity.this, true);
        ChatNewActivity.a(ChatNewActivity.this, "会话接入");
        ChatNewActivity.b(ChatNewActivity.this).setIsSkillEnable(Boolean.valueOf(false));
        ChatNewActivity.b(ChatNewActivity.this).refresh();
      }
    });
  }
  
  private View b(int paramInt)
  {
    View localView = View.inflate(this, 2130903884, null);
    ExpandGridView localExpandGridView = (ExpandGridView)localView.findViewById(2131689486);
    final Object localObject = new ArrayList();
    if (paramInt == 1) {
      ((List)localObject).addAll(this.E.subList(0, 20));
    }
    for (;;)
    {
      ((List)localObject).add("delete_expression");
      localObject = new e(this, 1, (List)localObject);
      localExpandGridView.setAdapter((ListAdapter)localObject);
      localExpandGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = (String)localObject.getItem(paramAnonymousInt);
          com.ziroom.ziroomcustomer.util.u.e("filename: ", paramAnonymousAdapterView);
          if (paramAnonymousAdapterView != "delete_expression") {}
          try
          {
            paramAnonymousAdapterView = Class.forName("com.ziroom.ziroomcustomer.newchat.SmileUtils").getField(paramAnonymousAdapterView);
            ChatNewActivity.v(ChatNewActivity.this).append(SmileUtils.getSmiledText(ChatNewActivity.this, (String)paramAnonymousAdapterView.get(null)));
            return;
          }
          catch (Exception paramAnonymousAdapterView) {}
          if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(ChatNewActivity.v(ChatNewActivity.this))))
          {
            paramAnonymousInt = ChatNewActivity.v(ChatNewActivity.this).getSelectionStart();
            if (paramAnonymousInt > 0)
            {
              paramAnonymousAdapterView = VdsAgent.trackEditTextSilent(ChatNewActivity.v(ChatNewActivity.this)).toString().substring(0, paramAnonymousInt);
              int i = paramAnonymousAdapterView.lastIndexOf("[");
              if (i != -1)
              {
                if (SmileUtils.containsKey(paramAnonymousAdapterView.substring(i, paramAnonymousInt).toString()))
                {
                  ChatNewActivity.v(ChatNewActivity.this).getEditableText().delete(i, paramAnonymousInt);
                  return;
                }
                ChatNewActivity.v(ChatNewActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
                return;
              }
              ChatNewActivity.v(ChatNewActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
            }
          }
          return;
        }
      });
      return localView;
      if (paramInt == 2) {
        ((List)localObject).addAll(this.E.subList(20, this.E.size()));
      }
    }
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.e.n.getUserIsContont(this, "3902", EMClient.getInstance().getCurrentUser(), EMClient.getInstance().getOptions().getAppKey() + "#" + this.J, new h(this, new s())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        boolean bool = true;
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (TextUtils.isEmpty(paramAnonymousString)) {
          if (ChatNewActivity.a(ChatNewActivity.this))
          {
            ChatNewActivity.a(ChatNewActivity.this, "正在为您接入金牌客服");
            ChatNewActivity.b(ChatNewActivity.this).setIsSkillEnable(Boolean.valueOf(false));
            if (ChatNewActivity.b(ChatNewActivity.this) != null)
            {
              paramAnonymousString = ChatNewActivity.b(ChatNewActivity.this);
              if (ChatNewActivity.d(ChatNewActivity.this).booleanValue()) {
                break label134;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString.setIsSkillEnable(Boolean.valueOf(bool));
          return;
          ChatNewActivity.a(ChatNewActivity.this, Boolean.valueOf(false));
          ChatNewActivity.c(ChatNewActivity.this);
          break;
          ChatNewActivity.a(ChatNewActivity.this, false);
          ChatNewActivity.a(ChatNewActivity.this, Boolean.valueOf(true));
          break;
          label134:
          bool = false;
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    EMMessage localEMMessage = EMMessage.createReceiveMessage(EMMessage.Type.TXT);
    localEMMessage.setDirection(EMMessage.Direct.RECEIVE);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("queueName", this.aa);
      localJSONObject.put("weichat_businesss_msg", paramString);
      localEMMessage.setAttribute("weichat", localJSONObject);
      localEMMessage.setAttribute("weichat_businesss_msg", true);
      this.L.addLocalMessage(localEMMessage);
      this.L.refreshSelectLast();
      this.L.setIsSkillEnable(Boolean.valueOf(true));
      this.L.refresh();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        Log.e("Message", paramString.getMessage());
      }
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void e()
  {
    this.X = ((NotificationManager)this.T.getSystemService("notification"));
    this.X.cancel(291);
    this.f = ((EditText)findViewById(2131691254));
    this.g = ((ImageView)findViewById(2131691255));
    this.F = ((RelativeLayout)findViewById(2131691253));
    this.r = ((Button)findViewById(2131691256));
    this.s = ((Button)findViewById(2131691257));
    this.t = ((LinearLayout)findViewById(2131691258));
    this.u = ((RelativeLayout)findViewById(2131691259));
    this.v = ((ViewPager)findViewById(2131691260));
    this.w = ((RelativeLayout)findViewById(2131690419));
    this.x = ((LinearLayout)findViewById(2131691262));
    this.y = ((ImageView)findViewById(2131691263));
    this.z = ((ImageView)findViewById(2131691264));
    this.G = ((XListView)findViewById(2131691266));
    this.M = ((ProgressBar)findViewById(2131691265));
    this.V = ((LinearLayout)findViewById(2131691261));
    this.Y = ((RelativeLayout)findViewById(2131690816));
    this.Z = ((LinearLayout)findViewById(2131690322));
    this.e = ((BasicZiroomToolBar)findViewById(2131689787));
    this.A = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.B = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    SildingFinishLayout localSildingFinishLayout = (SildingFinishLayout)findViewById(2131691249);
    localSildingFinishLayout.setOnSildingFinishListener(new SildingFinishLayout.a()
    {
      public void onSildingFinish()
      {
        ChatNewActivity.this.getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00000000"));
        ChatNewActivity.e(ChatNewActivity.this);
        ChatNewActivity.this.finish();
      }
    });
    localSildingFinishLayout.setTouchView(this.G);
  }
  
  private void e(final String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getQuestionType(this, paramString, new h(this, new com.ziroom.ziroomcustomer.e.c.u(com.ziroom.ziroomcustomer.newchat.chatcenter.b.j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newchat.chatcenter.b.j> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0)) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("label", "请选择您的问题类型");
          localJSONObject.put("content", com.alibaba.fastjson.a.toJSONString(paramAnonymousList).toString());
          localJSONObject.put("businessTypeId", paramString);
          ChatNewActivity.c(ChatNewActivity.this, localJSONObject.toString());
          return;
        }
        catch (JSONException paramAnonymousList)
        {
          paramAnonymousList.printStackTrace();
        }
      }
    });
  }
  
  private void f()
  {
    getIntent().getStringExtra("chat_class_from");
    this.e.setTitle("在线咨询");
    this.e.addButton(this.e.newButton(2130840207, new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ChatNewActivity.f(ChatNewActivity.this);
      }
    }));
    this.C = 0;
    this.D = 0;
    this.J = "ziroomerPro";
    this.E = getExpressionRes(35);
    final ArrayList localArrayList = new ArrayList();
    View localView = b(1);
    Object localObject = b(2);
    localArrayList.add(localView);
    localArrayList.add(localObject);
    this.v.setAdapter(new f(localArrayList));
    this.F.requestFocus();
    int i = 0;
    while (i < localArrayList.size())
    {
      localView = new View(this.T);
      localObject = new LinearLayout.LayoutParams(com.ziroom.ziroomcustomer.util.n.dip2px(this.T, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.T, 8.0F));
      ((LinearLayout.LayoutParams)localObject).leftMargin = com.ziroom.ziroomcustomer.util.n.dip2px(this.T, 7.0F);
      localView.setEnabled(false);
      localView.setBackgroundResource(2130839308);
      this.V.addView(localView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    this.v.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        paramAnonymousInt %= localArrayList.size();
        ChatNewActivity.h(ChatNewActivity.this).getChildAt(ChatNewActivity.g(ChatNewActivity.this)).setEnabled(false);
        ChatNewActivity.h(ChatNewActivity.this).getChildAt(paramAnonymousInt).setEnabled(true);
        ChatNewActivity.a(ChatNewActivity.this, paramAnonymousInt);
      }
    });
    this.V.getChildAt(0).setEnabled(true);
    if ("yuekan".equals(getIntent().getStringExtra("from")))
    {
      this.Q = ((b)getIntent().getSerializableExtra("Test"));
      this.c = this.Q.getStImage();
      this.b = this.Q.getStPrice();
      this.ac = this.Q.getHouseUrl();
      this.ad = this.Q.getDetailUrl();
      new SimpleDraweeView(this.T).setController(com.freelxl.baselibrary.f.c.frescoController(this.ac, new BasePostprocessor()
      {
        public void process(Bitmap paramAnonymousBitmap)
        {
          ChatNewActivity.this.saveMyBitmap(paramAnonymousBitmap);
        }
      }));
    }
  }
  
  private void f(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.ah) {
        this.af = Boolean.valueOf(true);
      }
      paramString = EMMessage.createTxtSendMessage(paramString, this.J);
      localJSONObject = new JSONObject();
    }
    try
    {
      if (!TextUtils.isEmpty(this.aa)) {
        localJSONObject.put("queueName", this.aa);
      }
      if (!TextUtils.isEmpty(this.ag)) {
        localJSONObject.put("agentUsername", this.ag);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Log.e("Message", localJSONException.getMessage());
        continue;
        this.L.addLocalMessage(paramString);
        h();
      }
    }
    paramString.setAttribute("weichat", localJSONObject);
    if (this.ah)
    {
      paramString.setAttribute("ZiroomNoShow_Message", "yes");
      this.ah = false;
    }
    if (this.af.booleanValue())
    {
      EMClient.getInstance().chatManager().sendMessage(paramString);
      if (!"yes".equals(paramString.getStringAttribute("ZiroomNoShow_Message", null))) {
        this.L.addLocalMessage(paramString);
      }
      this.L.refreshSelectLast();
      this.f.setText("");
      setResult(-1);
      return;
    }
  }
  
  private void g()
  {
    a = this;
    this.I = ((ClipboardManager)getSystemService("clipboard"));
    this.A = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.B = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    this.L = new k(this, this.J, this.K, this.G);
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.H = EMClient.getInstance().chatManager().getConversation(this.J, EMConversation.EMConversationType.Chat, true);
      if (this.H != null)
      {
        this.H.markAllMessagesAsRead();
        ApplicationEx.c.setUnReadNum(0);
        Object localObject = this.H.getAllMessages();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EMMessage localEMMessage = (EMMessage)((Iterator)localObject).next();
          if (!"yes".equals(localEMMessage.getStringAttribute("ZiroomNoShow_Message", null))) {
            localArrayList.add(localEMMessage);
          }
        }
        this.L.addLocalMessages(localArrayList, 0);
      }
      this.G.setAdapter(this.L);
      this.G.setSelection(this.G.getCount() - 1);
      this.L.notifyDataSetChanged();
      this.L.refreshSelectLast();
    }
    for (;;)
    {
      this.Y.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          ChatNewActivity.e(ChatNewActivity.this);
          ChatNewActivity.i(ChatNewActivity.this).setVisibility(8);
          ChatNewActivity.j(ChatNewActivity.this).setVisibility(0);
          ChatNewActivity.k(ChatNewActivity.this).setVisibility(8);
          ChatNewActivity.l(ChatNewActivity.this).setVisibility(8);
          return false;
        }
      });
      this.G.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = ChatNewActivity.b(ChatNewActivity.this).getItem(paramAnonymousInt - 1);
          ChatNewActivity.a(ChatNewActivity.this, new PopupWindow(ChatNewActivity.m(ChatNewActivity.this)));
          ChatNewActivity.n(ChatNewActivity.this).setBackgroundDrawable(new ColorDrawable(0));
          ChatNewActivity.n(ChatNewActivity.this).setOutsideTouchable(true);
          View localView = View.inflate(ChatNewActivity.m(ChatNewActivity.this), 2130903665, null);
          Object localObject = (TextView)localView.findViewById(2131693221);
          TextView localTextView = (TextView)localView.findViewById(2131691849);
          ((TextView)localObject).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = ChatNewActivity.b(ChatNewActivity.this).getItem(paramAnonymousInt - 1);
              ChatNewActivity.o(ChatNewActivity.this).setText(((EMTextMessageBody)paramAnonymous2View.getBody()).getMessage());
              ChatNewActivity.n(ChatNewActivity.this).dismiss();
            }
          });
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = ChatNewActivity.b(ChatNewActivity.this).getItem(paramAnonymousInt - 1);
              ChatNewActivity.p(ChatNewActivity.this).removeMessage(paramAnonymous2View.getMsgId());
              ChatNewActivity.b(ChatNewActivity.this).removeMessage(paramAnonymous2View);
              ChatNewActivity.q(ChatNewActivity.this).setSelection(paramAnonymousInt - 1);
              ChatNewActivity.n(ChatNewActivity.this).dismiss();
            }
          });
          ChatNewActivity.n(ChatNewActivity.this).setContentView(localView);
          ChatNewActivity.n(ChatNewActivity.this).setWidth(-2);
          ChatNewActivity.n(ChatNewActivity.this).setHeight(-2);
          try
          {
            localObject = new int[2];
            localView = paramAnonymousView.findViewById(2131696912);
            localView.getLocationInWindow((int[])localObject);
            paramAnonymousView.getLocationInWindow(new int[2]);
            paramAnonymousAdapterView = paramAnonymousAdapterView.getFrom();
            if (ChatNewActivity.r(ChatNewActivity.this).equals(paramAnonymousAdapterView))
            {
              paramAnonymousAdapterView = ChatNewActivity.n(ChatNewActivity.this);
              paramAnonymousInt = -com.ziroom.ziroomcustomer.util.n.dip2px(ChatNewActivity.this, 160.0F) / 2;
              if (!(paramAnonymousAdapterView instanceof PopupWindow))
              {
                paramAnonymousAdapterView.showAsDropDown(localView, 0, paramAnonymousInt);
                return true;
              }
              VdsAgent.showAsDropDown((PopupWindow)paramAnonymousAdapterView, localView, 0, paramAnonymousInt);
              return true;
            }
            paramAnonymousAdapterView = ChatNewActivity.n(ChatNewActivity.this);
            paramAnonymousInt = -com.ziroom.ziroomcustomer.util.n.dip2px(ChatNewActivity.this, 160.0F) / 2;
            if (!(paramAnonymousAdapterView instanceof PopupWindow))
            {
              paramAnonymousAdapterView.showAsDropDown(localView, 0, paramAnonymousInt);
              return true;
            }
            VdsAgent.showAsDropDown((PopupWindow)paramAnonymousAdapterView, localView, 0, paramAnonymousInt);
            return true;
          }
          catch (Exception paramAnonymousAdapterView) {}
          return true;
        }
      });
      this.ae = new b(null);
      EMClient.getInstance().chatManager().addMessageListener(this.ae);
      com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(this);
      if (this.L != null) {
        this.L.setmBusinessItemLenter(new k.a()
        {
          public void onClick(com.ziroom.ziroomcustomer.newchat.chatcenter.b.a paramAnonymousa, String paramAnonymousString)
          {
            if ((paramAnonymousString == null) || ("".equals(paramAnonymousString)))
            {
              if (paramAnonymousa.getHasSubType() == 0)
              {
                ChatNewActivity.a(ChatNewActivity.this, paramAnonymousa.getId(), null);
                return;
              }
              ChatNewActivity.b(ChatNewActivity.this, paramAnonymousa.getId());
              return;
            }
            ChatNewActivity.a(ChatNewActivity.this, paramAnonymousString, paramAnonymousa.getId());
          }
        });
      }
      return;
      showToast("服务器异常，请稍后再试");
    }
  }
  
  private void g(String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.J);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.aa)) {
        localJSONObject.put("queueName", this.aa);
      }
      paramString.setAttribute("weichat", localJSONObject);
      if (this.K == 2) {
        paramString.setChatType(EMMessage.ChatType.GroupChat);
      }
      if (this.c != null)
      {
        paramString.setAttribute("name", this.c);
        paramString.setAttribute("price", this.b);
        paramString.setAttribute("picUrl", this.ac);
        localJSONObject = getMessageExtFromPicture();
        if (localJSONObject != null) {
          paramString.setAttribute("msgtype", localJSONObject);
        }
      }
      if (this.af.booleanValue())
      {
        EMClient.getInstance().chatManager().sendMessage(paramString);
        this.L.addLocalMessage(paramString);
        this.L.refreshSelectLast();
        this.G.setAdapter(this.L);
        this.c = null;
        this.b = null;
        this.L.refresh();
        this.G.setSelection(this.L.getCount() - 1);
        setResult(-1);
        this.t.setVisibility(8);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Log.e("Message", localJSONException.getMessage());
        continue;
        this.L.addLocalMessage(paramString);
        h();
      }
    }
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.e.n.getBusinessType(this, new h(this, new com.ziroom.ziroomcustomer.e.c.u(com.ziroom.ziroomcustomer.newchat.chatcenter.b.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newchat.chatcenter.b.a> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0)) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("label", "请选择您要咨询的业务");
          localJSONObject.put("content", com.alibaba.fastjson.a.toJSONString(paramAnonymousList).toString());
          ChatNewActivity.c(ChatNewActivity.this, localJSONObject.toString());
          return;
        }
        catch (JSONException paramAnonymousList)
        {
          paramAnonymousList.printStackTrace();
        }
      }
    });
  }
  
  private void i()
  {
    this.ab = new a(null);
    EMClient.getInstance().addConnectionListener(this.ab);
    this.r.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.G.setPullLoadEnable(false);
    this.G.setPullRefreshEnable(true);
    this.G.setXListViewListener(this);
    this.f.requestFocus();
    this.f.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        ChatNewActivity.j(ChatNewActivity.this).setVisibility(0);
        ChatNewActivity.i(ChatNewActivity.this).setVisibility(8);
        ChatNewActivity.k(ChatNewActivity.this).setVisibility(8);
        ChatNewActivity.l(ChatNewActivity.this).setVisibility(8);
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ChatNewActivity.j(ChatNewActivity.this).setVisibility(0);
        ChatNewActivity.i(ChatNewActivity.this).setVisibility(8);
        ChatNewActivity.k(ChatNewActivity.this).setVisibility(8);
        ChatNewActivity.l(ChatNewActivity.this).setVisibility(8);
        ChatNewActivity.b(ChatNewActivity.this, 0);
        ChatNewActivity.c(ChatNewActivity.this, 0);
        ChatNewActivity.q(ChatNewActivity.this).setSelection(ChatNewActivity.q(ChatNewActivity.this).getCount() - 1);
      }
    });
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!TextUtils.isEmpty(paramAnonymousCharSequence))
        {
          ChatNewActivity.s(ChatNewActivity.this).setVisibility(8);
          ChatNewActivity.t(ChatNewActivity.this).setVisibility(0);
          return;
        }
        ChatNewActivity.s(ChatNewActivity.this).setVisibility(0);
        ChatNewActivity.t(ChatNewActivity.this).setVisibility(8);
      }
    });
  }
  
  public static boolean isBackground(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))
      {
        if (localRunningAppProcessInfo.importance == 400)
        {
          com.ziroom.ziroomcustomer.util.u.e("后台", localRunningAppProcessInfo.processName);
          return true;
        }
        com.ziroom.ziroomcustomer.util.u.e("前台", localRunningAppProcessInfo.processName);
        return false;
      }
    }
    return false;
  }
  
  private void j()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      this.A.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  private void k()
  {
    this.G.stopRefresh();
    this.G.stopLoadMore();
    this.G.setRefreshTime("刚刚");
  }
  
  private void l()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent("是否清空所有聊天记录？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (ChatNewActivity.p(ChatNewActivity.this) != null) {
            ChatNewActivity.p(ChatNewActivity.this).clearAllMessages();
          }
          EMClient.getInstance().chatManager().deleteConversation(ChatNewActivity.r(ChatNewActivity.this), true);
          ChatNewActivity.a(ChatNewActivity.this, EMClient.getInstance().chatManager().getConversation(ChatNewActivity.r(ChatNewActivity.this), EMConversation.EMConversationType.Chat, true));
          ChatNewActivity.b(ChatNewActivity.this).clearMessages();
        }
      }
    }).show();
  }
  
  private void m()
  {
    if (this.D == 0)
    {
      this.D = 1;
      this.C = 0;
      j();
      this.t.setVisibility(0);
      this.u.setVisibility(0);
      this.x.setVisibility(8);
    }
    while (this.D != 1) {
      return;
    }
    this.D = 0;
    this.t.setVisibility(8);
  }
  
  private void n()
  {
    if (this.C == 0)
    {
      this.C = 1;
      this.D = 0;
      j();
      this.t.setVisibility(0);
      this.x.setVisibility(0);
      this.u.setVisibility(8);
    }
    while (this.C != 1) {
      return;
    }
    this.C = 0;
    this.t.setVisibility(8);
  }
  
  private void o()
  {
    if (this.L == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ChatNewActivity.b(ChatNewActivity.this).refreshSelectLast();
      }
    });
  }
  
  public void back(View paramView)
  {
    j();
    finish();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.Z.getLocationOnScreen(arrayOfInt);
    if ((this.C == 1) || (this.D == 1)) {
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.Z.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.Z.getHeight() + com.ziroom.ziroomcustomer.util.n.dip2px(this.T, 500.0F)))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        this.t.setVisibility(8);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.Z.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.Z.getHeight()))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        this.t.setVisibility(8);
      }
    }
  }
  
  public List<String> getExpressionRes(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i <= paramInt)
    {
      localArrayList.add("ee_" + i);
      i += 1;
    }
    return localArrayList;
  }
  
  public XListView getListView()
  {
    return this.G;
  }
  
  public JSONObject getMessageExtFromPicture()
  {
    return new m(1, "我正在看", "", this.b, this.c, this.ac, this.ad).getJSONObject();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 2) {
        break label40;
      }
      EMClient.getInstance().chatManager().deleteConversation(this.J, true);
      this.L.clearMessages();
    }
    label40:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt1 != 18) {
                  break;
                }
              } while ((this.P == null) || (!this.P.exists()));
              if (EMClient.getInstance().isLoggedInBefore() == true)
              {
                g(this.P.getAbsolutePath());
                return;
              }
              showToast("服务器异常，请稍后再试");
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
          if (paramInt1 != 11) {
            break;
          }
        } while (TextUtils.isEmpty(this.I.getText()));
        paramIntent = this.I.getText().toString();
      } while (!paramIntent.startsWith("EASEMOBIMG"));
      if (EMClient.getInstance().isLoggedInBefore() == true)
      {
        g(paramIntent.replace("EASEMOBIMG", ""));
        return;
      }
      showToast("服务器异常，请稍后再试");
      return;
      if (this.H.getAllMessages().size() > 0)
      {
        this.L.refresh();
        setResult(-1);
        return;
      }
      if (paramInt1 == 21)
      {
        this.L.refresh();
        return;
      }
    } while (paramInt1 != 26);
    this.L.refresh();
  }
  
  public void onBackPressed()
  {
    if (this.t.getVisibility() == 0)
    {
      this.t.setVisibility(8);
      this.g.setVisibility(0);
      return;
    }
    super.onBackPressed();
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
      finish();
      return;
    case 2131691256: 
      n();
      return;
    case 2131691255: 
      m();
      return;
    case 2131691257: 
      paramView = VdsAgent.trackEditTextSilent(this.f).toString();
      if (EMClient.getInstance().isLoggedInBefore() == true) {
        try
        {
          f(paramView);
          w.onEvent(this.T, "online_service_send");
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
      }
      showToast("服务器异常，请稍后再试");
      return;
    case 2131691263: 
      try
      {
        selectPicFromCamera();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    case 2131691264: 
      try
      {
        selectPicFromLocal();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
    l();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903387);
    this.T = this;
    paramBundle = getIntent().getStringExtra("chatForm");
    this.aa = com.ziroom.ziroomcustomer.newchat.chat.a.a.getSkillName(paramBundle);
    if ("chatCenter".equals(paramBundle))
    {
      this.ag = getIntent().getStringExtra("agentUsername");
      this.aa = getIntent().getStringExtra("skill_set_name");
      this.ah = getIntent().getBooleanExtra("chatType", false);
    }
    com.ziroom.ziroomcustomer.util.u.e("sjdgkj", "=======    skill_set_name" + this.aa + "***" + this.ag);
    e();
    f();
    i();
    g();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a = null;
    if (this.ab != null)
    {
      EMClient.getInstance().chatManager().removeMessageListener(this.ae);
      EMClient.getInstance().removeConnectionListener(this.ab);
    }
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(this);
  }
  
  public void onLoadMore() {}
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  public void onRefresh()
  {
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      if (this.H == null) {
        break label180;
      }
      if (this.H.getAllMessages().size() != 0) {
        break label37;
      }
      k();
    }
    for (;;)
    {
      return;
      try
      {
        label37:
        List localList = this.H.loadMoreMsgFromDB(this.L.getItem(0).getMsgId(), 20);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          EMMessage localEMMessage = (EMMessage)localIterator.next();
          if (!"yes".equals(localEMMessage.getStringAttribute("ZiroomNoShow_Message", null))) {
            localArrayList.add(localEMMessage);
          }
        }
        this.L.addLocalMessages(localArrayList, 0);
        try
        {
          Thread.sleep(300L);
          if (localList.size() != 0) {
            k();
          }
          if (localList.size() != 0) {
            continue;
          }
          k();
          this.G.setPullRefreshEnable(false);
          showToast("已经没有数据了！");
          return;
          label180:
          showToast("服务器异常，请稍后再试");
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
      this.L.refresh();
      new l().pushActivity(this);
      if (this.ae == null) {
        this.ae = new b(null);
      }
      EMClient.getInstance().chatManager().addMessageListener(this.ae);
      return;
    }
    showToast("服务器异常，请稍后再试");
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void saveMyBitmap(final Bitmap paramBitmap)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/ziroom/ziroomcustomer/newchat/ChatNewActivity$10:b	Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;
        //   4: new 30	java/lang/StringBuilder
        //   7: dup
        //   8: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   11: invokestatic 37	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   14: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   17: getstatic 47	java/io/File:separator	Ljava/lang/String;
        //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: ldc 52
        //   25: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: invokestatic 55	com/ziroom/ziroomcustomer/newchat/ChatNewActivity:a	()I
        //   31: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   34: ldc 60
        //   36: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   42: invokestatic 68	com/ziroom/ziroomcustomer/newchat/ChatNewActivity:e	(Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;Ljava/lang/String;)Ljava/lang/String;
        //   45: pop
        //   46: invokestatic 71	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
        //   49: ldc 73
        //   51: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   54: ifeq +116 -> 170
        //   57: new 43	java/io/File
        //   60: dup
        //   61: invokestatic 37	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   64: new 30	java/lang/StringBuilder
        //   67: dup
        //   68: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   71: ldc 52
        //   73: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: invokestatic 55	com/ziroom/ziroomcustomer/newchat/ChatNewActivity:a	()I
        //   79: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   82: ldc 60
        //   84: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   93: astore_1
        //   94: aload_1
        //   95: invokevirtual 86	java/io/File:exists	()Z
        //   98: ifeq +8 -> 106
        //   101: aload_1
        //   102: invokevirtual 89	java/io/File:delete	()Z
        //   105: pop
        //   106: new 91	java/io/FileOutputStream
        //   109: dup
        //   110: aload_1
        //   111: invokespecial 94	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   114: astore_2
        //   115: aload_2
        //   116: astore_1
        //   117: aload_0
        //   118: getfield 21	com/ziroom/ziroomcustomer/newchat/ChatNewActivity$10:a	Landroid/graphics/Bitmap;
        //   121: getstatic 100	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   124: bipush 100
        //   126: aload_2
        //   127: invokevirtual 106	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   130: pop
        //   131: aload_2
        //   132: astore_1
        //   133: aload_2
        //   134: invokevirtual 109	java/io/FileOutputStream:flush	()V
        //   137: aload_2
        //   138: astore_1
        //   139: aload_0
        //   140: getfield 19	com/ziroom/ziroomcustomer/newchat/ChatNewActivity$10:b	Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;
        //   143: invokestatic 113	com/ziroom/ziroomcustomer/newchat/ChatNewActivity:w	(Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;)Landroid/os/Handler;
        //   146: bipush 100
        //   148: invokevirtual 119	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   151: astore_3
        //   152: aload_2
        //   153: astore_1
        //   154: aload_0
        //   155: getfield 19	com/ziroom/ziroomcustomer/newchat/ChatNewActivity$10:b	Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;
        //   158: invokestatic 113	com/ziroom/ziroomcustomer/newchat/ChatNewActivity:w	(Lcom/ziroom/ziroomcustomer/newchat/ChatNewActivity;)Landroid/os/Handler;
        //   161: aload_3
        //   162: invokevirtual 123	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
        //   165: pop
        //   166: aload_2
        //   167: invokevirtual 126	java/io/FileOutputStream:close	()V
        //   170: return
        //   171: astore_1
        //   172: aload_1
        //   173: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   176: return
        //   177: astore_3
        //   178: aconst_null
        //   179: astore_2
        //   180: aload_2
        //   181: astore_1
        //   182: aload_3
        //   183: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   186: aload_2
        //   187: invokevirtual 126	java/io/FileOutputStream:close	()V
        //   190: return
        //   191: astore_1
        //   192: aload_1
        //   193: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   196: return
        //   197: astore_2
        //   198: aconst_null
        //   199: astore_1
        //   200: aload_1
        //   201: invokevirtual 126	java/io/FileOutputStream:close	()V
        //   204: aload_2
        //   205: athrow
        //   206: astore_1
        //   207: aload_1
        //   208: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   211: goto -7 -> 204
        //   214: astore_2
        //   215: goto -15 -> 200
        //   218: astore_3
        //   219: goto -39 -> 180
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	222	0	this	10
        //   93	61	1	localObject1	Object
        //   171	2	1	localException1	Exception
        //   181	1	1	localObject2	Object
        //   191	2	1	localException2	Exception
        //   199	2	1	localObject3	Object
        //   206	2	1	localException3	Exception
        //   114	73	2	localFileOutputStream	java.io.FileOutputStream
        //   197	8	2	localObject4	Object
        //   214	1	2	localObject5	Object
        //   151	11	3	localMessage	Message
        //   177	6	3	localException4	Exception
        //   218	1	3	localException5	Exception
        // Exception table:
        //   from	to	target	type
        //   166	170	171	java/lang/Exception
        //   106	115	177	java/lang/Exception
        //   186	190	191	java/lang/Exception
        //   106	115	197	finally
        //   200	204	206	java/lang/Exception
        //   117	131	214	finally
        //   133	137	214	finally
        //   139	152	214	finally
        //   154	166	214	finally
        //   182	186	214	finally
        //   117	131	218	java/lang/Exception
        //   133	137	218	java/lang/Exception
        //   139	152	218	java/lang/Exception
        //   154	166	218	java/lang/Exception
      }
    }).start();
  }
  
  public void selectPicFromCamera()
  {
    if (!d.isExitsSdcard())
    {
      g.textToast(getApplicationContext(), 2131297414);
      return;
    }
    this.P = new File(PathUtil.getInstance().getImagePath(), System.currentTimeMillis() + ".jpg");
    this.P.getParentFile().mkdirs();
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", Uri.fromFile(this.P)), 18);
  }
  
  public void selectPicFromLocal()
  {
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
  
  public void setListView(XListView paramXListView)
  {
    this.G = paramXListView;
  }
  
  private class a
    implements EMConnectionListener
  {
    private a() {}
    
    public void onConnected()
    {
      ChatNewActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          com.ziroom.ziroomcustomer.util.u.e("huanxin", "ChatActivity----MyConnectionListener ----onConnected----- ");
          ApplicationEx.c.setImconnect(true);
        }
      });
    }
    
    public void onDisconnected(final int paramInt)
    {
      ChatNewActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (paramInt == 207)
          {
            com.ziroom.ziroomcustomer.util.u.e("huanxin", "ChatActivity-----MyConnectionListener -------显示帐号已经被移除 ");
            ApplicationEx.c.setImconnect(false);
          }
          do
          {
            return;
            if (paramInt != 206) {
              break;
            }
            com.ziroom.ziroomcustomer.util.u.e("huanxin", "ChatActivity----MyConnectionListener -------显示帐号在其他设备登陆dialog ");
            ApplicationEx.c.setImconnect(false);
          } while (EMClient.getInstance().isLoggedInBefore() != true);
          if (!ChatNewActivity.isBackground(ChatNewActivity.m(ChatNewActivity.this))) {
            g.textToast(ChatNewActivity.m(ChatNewActivity.this), "您已在另一设备上登录", 0);
          }
          ChatNewActivity.this.finish();
          return;
          ApplicationEx.c.setImconnect(false);
          if (NetUtils.hasNetwork(ChatNewActivity.this))
          {
            com.ziroom.ziroomcustomer.util.u.e("huanxin", "ChatActivity----MyConnectionListener -------连接不到聊天服务器 ");
            return;
          }
          com.ziroom.ziroomcustomer.util.u.e("huanxin", "ChatActivity----MyConnectionListener --------当前网络不可用，请检查网络设置 ");
        }
      });
    }
  }
  
  private class b
    implements EMMessageListener
  {
    private b() {}
    
    public void onCmdMessageReceived(List<EMMessage> paramList) {}
    
    public void onMessageChanged(EMMessage paramEMMessage, Object paramObject) {}
    
    public void onMessageDelivered(List<EMMessage> paramList) {}
    
    public void onMessageRead(List<EMMessage> paramList) {}
    
    public void onMessageRecalled(List<EMMessage> paramList) {}
    
    public void onMessageReceived(List<EMMessage> paramList)
    {
      com.ziroom.ziroomcustomer.util.u.e("sjdkfjsdj", "=======  onMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramList));
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        EMMessage localEMMessage = (EMMessage)localIterator.next();
        if ((localEMMessage.getChatType() == EMMessage.ChatType.GroupChat) || (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom)) {}
        for (paramList = localEMMessage.getTo();; paramList = localEMMessage.getFrom())
        {
          if (new l().isEvalMessage(localEMMessage))
          {
            ChatNewActivity.a(ChatNewActivity.this, Boolean.valueOf(false));
            ChatNewActivity.b(ChatNewActivity.this).setIsSkillEnable(Boolean.valueOf(true));
          }
          if (paramList.equals(ChatNewActivity.r(ChatNewActivity.this).toLowerCase()))
          {
            ChatNewActivity.b(ChatNewActivity.this).addLocalMessage(localEMMessage);
            ChatNewActivity.u(ChatNewActivity.this);
          }
          if ((localEMMessage.isAcked()) || (localEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
            break;
          }
          try
          {
            com.ziroom.ziroomcustomer.util.u.e("sdjgkdsj", "===== zhixingle  isAcked   22222");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/ChatNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */