package com.ziroom.ziroomcustomer.minsu.activity;

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
import android.support.v4.content.LocalBroadcastManager;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
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
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.NetUtils;
import com.hyphenate.util.PathUtil;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newchat.ExpandGridView;
import com.ziroom.ziroomcustomer.newchat.SildingFinishLayout;
import com.ziroom.ziroomcustomer.newchat.SildingFinishLayout.a;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.newchat.b;
import com.ziroom.ziroomcustomer.newchat.d;
import com.ziroom.ziroomcustomer.newchat.e;
import com.ziroom.ziroomcustomer.newchat.f;
import com.ziroom.ziroomcustomer.newchat.k;
import com.ziroom.ziroomcustomer.newchat.l;
import com.ziroom.ziroomcustomer.newchat.m;
import com.ziroom.ziroomcustomer.util.j;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
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

public class MinsuChatActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private static int R;
  public static MinsuChatActivity a = null;
  private PowerManager.WakeLock A;
  private int B = -1;
  private int C = -1;
  private List<String> D;
  private RelativeLayout E;
  private ImageView F;
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
  private TextView X;
  private NotificationManager Y;
  private RelativeLayout Z;
  private LinearLayout aa;
  private String ab;
  private a ac = null;
  private String ad;
  private String ae;
  private EMMessageListener af;
  private Handler ag = new Handler()
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
        MinsuChatActivity.b(MinsuChatActivity.this, MinsuChatActivity.u(MinsuChatActivity.this));
        return;
      }
      MinsuChatActivity.this.showToast("服务器异常，请稍后再试");
    }
  };
  public String b;
  public String c = null;
  private BasicZiroomToolBar d;
  private EditText e;
  private ImageView f;
  private Button g;
  private Button r;
  private LinearLayout s;
  private RelativeLayout t;
  private ViewPager u;
  private RelativeLayout v;
  private LinearLayout w;
  private ImageView x;
  private ImageView y;
  private InputMethodManager z;
  
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
        showToast(getResources().getString(2131297293));
        return;
      }
      if (EMClient.getInstance().isLoggedInBefore() == true)
      {
        e(paramUri);
        return;
      }
      showToast("服务器异常，请稍后再试");
      return;
    }
    paramUri = new File(paramUri.getPath());
    if (!paramUri.exists())
    {
      showToast(getResources().getString(2131297293));
      return;
    }
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      e(paramUri.getAbsolutePath());
      return;
    }
    showToast("服务器异常，请稍后再试");
  }
  
  private void a(EMMessage paramEMMessage)
  {
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.L.refresh();
  }
  
  private View b(int paramInt)
  {
    View localView = View.inflate(this, 2130903884, null);
    ExpandGridView localExpandGridView = (ExpandGridView)localView.findViewById(2131689486);
    final Object localObject = new ArrayList();
    if (paramInt == 1) {
      ((List)localObject).addAll(this.D.subList(0, 20));
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
          u.e("filename: ", paramAnonymousAdapterView);
          if (paramAnonymousAdapterView != "delete_expression") {}
          try
          {
            paramAnonymousAdapterView = Class.forName("com.ziroom.ziroomcustomer.newchat.SmileUtils").getField(paramAnonymousAdapterView);
            MinsuChatActivity.s(MinsuChatActivity.this).append(SmileUtils.getSmiledText(MinsuChatActivity.this, (String)paramAnonymousAdapterView.get(null)));
            return;
          }
          catch (Exception paramAnonymousAdapterView) {}
          if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(MinsuChatActivity.s(MinsuChatActivity.this))))
          {
            paramAnonymousInt = MinsuChatActivity.s(MinsuChatActivity.this).getSelectionStart();
            if (paramAnonymousInt > 0)
            {
              paramAnonymousAdapterView = VdsAgent.trackEditTextSilent(MinsuChatActivity.s(MinsuChatActivity.this)).toString().substring(0, paramAnonymousInt);
              int i = paramAnonymousAdapterView.lastIndexOf("[");
              if (i != -1)
              {
                if (SmileUtils.containsKey(paramAnonymousAdapterView.substring(i, paramAnonymousInt).toString()))
                {
                  MinsuChatActivity.s(MinsuChatActivity.this).getEditableText().delete(i, paramAnonymousInt);
                  return;
                }
                MinsuChatActivity.s(MinsuChatActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
                return;
              }
              MinsuChatActivity.s(MinsuChatActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
            }
          }
          return;
        }
      });
      return localView;
      if (paramInt == 2) {
        ((List)localObject).addAll(this.D.subList(20, this.D.size()));
      }
    }
  }
  
  private void d(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = EMMessage.createTxtSendMessage(paramString, this.J);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("queueName", this.ab);
      paramString.setAttribute("weichat", localJSONObject);
      EMClient.getInstance().chatManager().sendMessage(paramString);
      this.L.addLocalMessage(paramString);
      this.L.refreshSelectLast();
      this.e.setText("");
      setResult(-1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Log.e("Message", localJSONException.getMessage());
      }
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void e()
  {
    this.d = ((BasicZiroomToolBar)findViewById(2131689787));
    this.Y = ((NotificationManager)this.T.getSystemService("notification"));
    this.Y.cancel(291);
    this.e = ((EditText)findViewById(2131691254));
    this.f = ((ImageView)findViewById(2131691255));
    this.E = ((RelativeLayout)findViewById(2131691253));
    this.g = ((Button)findViewById(2131691256));
    this.r = ((Button)findViewById(2131691257));
    this.s = ((LinearLayout)findViewById(2131691258));
    this.t = ((RelativeLayout)findViewById(2131691259));
    this.u = ((ViewPager)findViewById(2131691260));
    this.v = ((RelativeLayout)findViewById(2131690419));
    this.w = ((LinearLayout)findViewById(2131691262));
    this.x = ((ImageView)findViewById(2131691263));
    this.y = ((ImageView)findViewById(2131691264));
    this.F = ((ImageView)findViewById(2131689492));
    this.G = ((XListView)findViewById(2131691266));
    this.M = ((ProgressBar)findViewById(2131691265));
    this.V = ((LinearLayout)findViewById(2131691261));
    this.X = ((TextView)findViewById(2131689541));
    this.Z = ((RelativeLayout)findViewById(2131690816));
    this.aa = ((LinearLayout)findViewById(2131690322));
    this.z = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.A = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    SildingFinishLayout localSildingFinishLayout = (SildingFinishLayout)findViewById(2131691249);
    localSildingFinishLayout.setOnSildingFinishListener(new SildingFinishLayout.a()
    {
      public void onSildingFinish()
      {
        MinsuChatActivity.this.getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00000000"));
        MinsuChatActivity.a(MinsuChatActivity.this);
        MinsuChatActivity.this.finish();
      }
    });
    localSildingFinishLayout.setTouchView(this.G);
  }
  
  private void e(String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.J);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("queueName", this.ab);
      paramString.setAttribute("weichat", localJSONObject);
      if (this.K == 2) {
        paramString.setChatType(EMMessage.ChatType.GroupChat);
      }
      EMClient.getInstance().chatManager().sendMessage(paramString);
      this.L.addLocalMessage(paramString);
      this.L.refreshSelectLast();
      if (this.c != null)
      {
        paramString.setAttribute("name", this.c);
        paramString.setAttribute("price", this.b);
        paramString.setAttribute("picUrl", this.ad);
        localJSONObject = getMessageExtFromPicture();
        if (localJSONObject != null) {
          paramString.setAttribute("msgtype", localJSONObject);
        }
      }
      this.G.setAdapter(this.L);
      this.c = null;
      this.b = null;
      this.L.refresh();
      this.G.setSelection(this.L.getCount() - 1);
      setResult(-1);
      this.s.setVisibility(8);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Log.e("Message", localJSONException.getMessage());
      }
    }
  }
  
  private void f()
  {
    this.d.setTitle("在线咨询");
    this.d.addButton(this.d.newButton(2130840207, new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuChatActivity.b(MinsuChatActivity.this);
      }
    }));
    this.B = 0;
    this.C = 0;
    this.J = "ms_ziroom";
    if ("minsu".equals(getIntent().getStringExtra("chatForm"))) {
      this.J = "ms_ziroom";
    }
    this.D = getExpressionRes(35);
    final ArrayList localArrayList = new ArrayList();
    View localView = b(1);
    Object localObject = b(2);
    localArrayList.add(localView);
    localArrayList.add(localObject);
    this.u.setAdapter(new f(localArrayList));
    this.E.requestFocus();
    int i = 0;
    while (i < localArrayList.size())
    {
      localView = new View(this.T);
      localObject = new LinearLayout.LayoutParams(n.dip2px(this.T, 8.0F), n.dip2px(this.T, 8.0F));
      ((LinearLayout.LayoutParams)localObject).leftMargin = n.dip2px(this.T, 7.0F);
      localView.setEnabled(false);
      localView.setBackgroundResource(2130839308);
      this.V.addView(localView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    this.u.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        paramAnonymousInt %= localArrayList.size();
        MinsuChatActivity.d(MinsuChatActivity.this).getChildAt(MinsuChatActivity.c(MinsuChatActivity.this)).setEnabled(false);
        MinsuChatActivity.d(MinsuChatActivity.this).getChildAt(paramAnonymousInt).setEnabled(true);
        MinsuChatActivity.a(MinsuChatActivity.this, paramAnonymousInt);
      }
    });
    this.V.getChildAt(0).setEnabled(true);
    if ("yuekan".equals(getIntent().getStringExtra("from")))
    {
      this.Q = ((b)getIntent().getSerializableExtra("Test"));
      this.c = this.Q.getStImage();
      this.b = this.Q.getStPrice();
      this.ad = this.Q.getHouseUrl();
      this.ae = this.Q.getDetailUrl();
      new SimpleDraweeView(this.T).setController(com.freelxl.baselibrary.f.c.frescoController(this.ad, new BasePostprocessor()
      {
        public void process(Bitmap paramAnonymousBitmap)
        {
          MinsuChatActivity.this.saveMyBitmap(paramAnonymousBitmap);
        }
      }));
    }
  }
  
  private void g()
  {
    a = this;
    this.I = ((ClipboardManager)getSystemService("clipboard"));
    this.z = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.A = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.H = EMClient.getInstance().chatManager().getConversation(this.J, EMConversation.EMConversationType.Chat, true);
      this.L = new k(this, this.J, this.K, this.G);
      if (this.H != null)
      {
        this.H.markAllMessagesAsRead();
        ApplicationEx.c.setMisuNum(0);
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
        if (localArrayList.size() > 0)
        {
          final int i = localArrayList.size();
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              MinsuChatActivity.e(MinsuChatActivity.this).setSelection(i - 1);
            }
          }, 150L);
        }
      }
      this.G.setAdapter(this.L);
      this.G.setSelection(this.G.getCount() - 1);
      this.L.notifyDataSetChanged();
    }
    for (;;)
    {
      this.Z.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          MinsuChatActivity.a(MinsuChatActivity.this);
          MinsuChatActivity.f(MinsuChatActivity.this).setVisibility(8);
          MinsuChatActivity.g(MinsuChatActivity.this).setVisibility(0);
          MinsuChatActivity.h(MinsuChatActivity.this).setVisibility(8);
          MinsuChatActivity.i(MinsuChatActivity.this).setVisibility(8);
          return false;
        }
      });
      this.G.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = MinsuChatActivity.j(MinsuChatActivity.this).getItem(paramAnonymousInt - 1);
          MinsuChatActivity.a(MinsuChatActivity.this, new PopupWindow(MinsuChatActivity.k(MinsuChatActivity.this)));
          MinsuChatActivity.l(MinsuChatActivity.this).setBackgroundDrawable(new ColorDrawable(0));
          MinsuChatActivity.l(MinsuChatActivity.this).setOutsideTouchable(true);
          View localView = View.inflate(MinsuChatActivity.k(MinsuChatActivity.this), 2130903665, null);
          Object localObject = (TextView)localView.findViewById(2131693221);
          TextView localTextView = (TextView)localView.findViewById(2131691849);
          ((TextView)localObject).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = MinsuChatActivity.j(MinsuChatActivity.this).getItem(paramAnonymousInt - 1);
              MinsuChatActivity.m(MinsuChatActivity.this).setText(((EMTextMessageBody)paramAnonymous2View.getBody()).getMessage());
              MinsuChatActivity.l(MinsuChatActivity.this).dismiss();
            }
          });
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = MinsuChatActivity.j(MinsuChatActivity.this).getItem(paramAnonymousInt - 1);
              MinsuChatActivity.n(MinsuChatActivity.this).removeMessage(paramAnonymous2View.getMsgId());
              MinsuChatActivity.j(MinsuChatActivity.this).removeMessage(paramAnonymous2View);
              MinsuChatActivity.e(MinsuChatActivity.this).setSelection(paramAnonymousInt - 1);
              MinsuChatActivity.l(MinsuChatActivity.this).dismiss();
            }
          });
          MinsuChatActivity.l(MinsuChatActivity.this).setContentView(localView);
          MinsuChatActivity.l(MinsuChatActivity.this).setWidth(-2);
          MinsuChatActivity.l(MinsuChatActivity.this).setHeight(-2);
          try
          {
            localObject = new int[2];
            localView = paramAnonymousView.findViewById(2131696912);
            localView.getLocationInWindow((int[])localObject);
            paramAnonymousView.getLocationInWindow(new int[2]);
            paramAnonymousAdapterView = paramAnonymousAdapterView.getFrom();
            if (MinsuChatActivity.o(MinsuChatActivity.this).equals(paramAnonymousAdapterView))
            {
              paramAnonymousAdapterView = MinsuChatActivity.l(MinsuChatActivity.this);
              paramAnonymousInt = -n.dip2px(MinsuChatActivity.this, 160.0F) / 2;
              if (!(paramAnonymousAdapterView instanceof PopupWindow))
              {
                paramAnonymousAdapterView.showAsDropDown(localView, 0, paramAnonymousInt);
                return true;
              }
              VdsAgent.showAsDropDown((PopupWindow)paramAnonymousAdapterView, localView, 0, paramAnonymousInt);
              return true;
            }
            paramAnonymousAdapterView = MinsuChatActivity.l(MinsuChatActivity.this);
            paramAnonymousInt = -n.dip2px(MinsuChatActivity.this, 160.0F) / 2;
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
      a();
      j.getInstance().pushActivity(this);
      return;
      showToast("服务器异常，请稍后再试");
    }
  }
  
  private void h()
  {
    this.ac = new a(null);
    EMClient.getInstance().addConnectionListener(this.ac);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setPullLoadEnable(false);
    this.G.setPullRefreshEnable(true);
    this.G.setXListViewListener(this);
    this.e.requestFocus();
    this.e.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        MinsuChatActivity.g(MinsuChatActivity.this).setVisibility(0);
        MinsuChatActivity.f(MinsuChatActivity.this).setVisibility(8);
        MinsuChatActivity.h(MinsuChatActivity.this).setVisibility(8);
        MinsuChatActivity.i(MinsuChatActivity.this).setVisibility(8);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuChatActivity.g(MinsuChatActivity.this).setVisibility(0);
        MinsuChatActivity.f(MinsuChatActivity.this).setVisibility(8);
        MinsuChatActivity.h(MinsuChatActivity.this).setVisibility(8);
        MinsuChatActivity.i(MinsuChatActivity.this).setVisibility(8);
        MinsuChatActivity.b(MinsuChatActivity.this, 0);
        MinsuChatActivity.c(MinsuChatActivity.this, 0);
        MinsuChatActivity.e(MinsuChatActivity.this).setSelection(MinsuChatActivity.e(MinsuChatActivity.this).getCount() - 1);
      }
    });
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!TextUtils.isEmpty(paramAnonymousCharSequence))
        {
          MinsuChatActivity.p(MinsuChatActivity.this).setVisibility(8);
          MinsuChatActivity.q(MinsuChatActivity.this).setVisibility(0);
          return;
        }
        MinsuChatActivity.p(MinsuChatActivity.this).setVisibility(0);
        MinsuChatActivity.q(MinsuChatActivity.this).setVisibility(8);
      }
    });
  }
  
  private void i()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      this.z.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
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
          u.e("后台", localRunningAppProcessInfo.processName);
          return true;
        }
        u.e("前台", localRunningAppProcessInfo.processName);
        return false;
      }
    }
    return false;
  }
  
  private void j()
  {
    this.G.stopRefresh();
    this.G.stopLoadMore();
    this.G.setRefreshTime("刚刚");
  }
  
  private void k()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.T).setTitle("提示").setContent("是否清空所有聊天记录？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (MinsuChatActivity.n(MinsuChatActivity.this) != null) {
            MinsuChatActivity.n(MinsuChatActivity.this).clearAllMessages();
          }
          EMClient.getInstance().chatManager().deleteConversation(MinsuChatActivity.o(MinsuChatActivity.this), true);
          MinsuChatActivity.a(MinsuChatActivity.this, EMClient.getInstance().chatManager().getConversation(MinsuChatActivity.o(MinsuChatActivity.this), EMConversation.EMConversationType.Chat, true));
          MinsuChatActivity.j(MinsuChatActivity.this).clearMessages();
          paramAnonymousView = new Intent(MinsuChatActivity.this.getString(2131296571));
          LocalBroadcastManager.getInstance(MinsuChatActivity.this).sendBroadcast(paramAnonymousView);
        }
      }
    }).build().show();
  }
  
  private void l()
  {
    if (this.C == 0)
    {
      this.C = 1;
      this.B = 0;
      i();
      this.s.setVisibility(0);
      this.t.setVisibility(0);
      this.w.setVisibility(8);
    }
    while (this.C != 1) {
      return;
    }
    this.C = 0;
    this.s.setVisibility(8);
  }
  
  private void m()
  {
    if (this.B == 0)
    {
      this.B = 1;
      this.C = 0;
      i();
      this.s.setVisibility(0);
      this.w.setVisibility(0);
      this.t.setVisibility(8);
    }
    while (this.B != 1) {
      return;
    }
    this.B = 0;
    this.s.setVisibility(8);
  }
  
  private void n()
  {
    if (this.L == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        MinsuChatActivity.j(MinsuChatActivity.this).refreshSelectLast();
      }
    });
  }
  
  protected void a()
  {
    this.af = new EMMessageListener()
    {
      public void onCmdMessageReceived(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageChanged(EMMessage paramAnonymousEMMessage, Object paramAnonymousObject) {}
      
      public void onMessageDelivered(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageRead(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageRecalled(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageReceived(List<EMMessage> paramAnonymousList)
      {
        u.e("huanxin_kefu", "=======  onMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
        Iterator localIterator = paramAnonymousList.iterator();
        if (localIterator.hasNext())
        {
          EMMessage localEMMessage = (EMMessage)localIterator.next();
          if ((localEMMessage.getChatType() == EMMessage.ChatType.GroupChat) || (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom)) {}
          String str2;
          for (String str1 = localEMMessage.getTo();; str2 = localEMMessage.getFrom())
          {
            if (str1.equals(MinsuChatActivity.o(MinsuChatActivity.this).toLowerCase()))
            {
              u.e("huanxin_kefu", "=======  addLocalMessage onMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
              MinsuChatActivity.j(MinsuChatActivity.this).addLocalMessage(localEMMessage);
              MinsuChatActivity.r(MinsuChatActivity.this);
            }
            if ((localEMMessage.isAcked()) || (localEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
              break;
            }
            try
            {
              u.e("sdjgkdsj", "===== zhixingle  isAcked   22222");
              EMClient.getInstance().chatManager().ackMessageRead(localEMMessage.getFrom(), localEMMessage.getMsgId());
            }
            catch (HyphenateException localHyphenateException)
            {
              localHyphenateException.printStackTrace();
            }
            break;
          }
        }
        MinsuChatActivity.n(MinsuChatActivity.this).markAllMessagesAsRead();
      }
    };
    EMClient.getInstance().chatManager().addMessageListener(this.af);
  }
  
  public void back(View paramView)
  {
    i();
    finish();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.aa.getLocationOnScreen(arrayOfInt);
    if ((this.B == 1) || (this.C == 1)) {
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.aa.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.aa.getHeight() + n.dip2px(this.T, 500.0F)))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        this.s.setVisibility(8);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.aa.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.aa.getHeight()))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        this.s.setVisibility(8);
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
    return new m(1, "我正在看", "", this.b, this.c, this.ad, this.ae).getJSONObject();
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
                e(this.P.getAbsolutePath());
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
        e(paramIntent.replace("EASEMOBIMG", ""));
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
    if (this.s.getVisibility() == 0)
    {
      this.s.setVisibility(8);
      this.f.setVisibility(0);
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
      m();
      return;
    case 2131691255: 
      l();
      return;
    case 2131691257: 
      paramView = VdsAgent.trackEditTextSilent(this.e).toString();
      if (EMClient.getInstance().isLoggedInBefore() == true) {
        try
        {
          d(paramView);
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
    }
    try
    {
      selectPicFromLocal();
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903387);
    this.T = this;
    paramBundle = getIntent().getStringExtra("chatForm");
    this.ab = com.ziroom.ziroomcustomer.newchat.chat.a.a.getSkillName(paramBundle);
    if ("chatCenter".equals(paramBundle)) {
      this.ab = getIntent().getStringExtra("skill_set_name");
    }
    u.e("sjdgkj", "=======    skill_set_name" + this.ab);
    e();
    f();
    h();
    g();
    this.Y = ((NotificationManager)this.T.getSystemService("notification"));
    this.Y.cancel(291);
    paramBundle = (SildingFinishLayout)findViewById(2131691249);
    paramBundle.setOnSildingFinishListener(new SildingFinishLayout.a()
    {
      public void onSildingFinish()
      {
        MinsuChatActivity.a(MinsuChatActivity.this);
        MinsuChatActivity.this.finish();
      }
    });
    paramBundle.setTouchView(this.G);
  }
  
  protected void onDestroy()
  {
    u.i("huanxin_kefu", " minsuchat activity  onDestroy ");
    super.onDestroy();
    a = null;
    if (this.ac != null)
    {
      EMClient.getInstance().chatManager().removeMessageListener(this.af);
      EMClient.getInstance().removeConnectionListener(this.ac);
    }
    j.getInstance().popActivity(this);
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
      j();
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
            j();
          }
          if (localList.size() != 0) {
            continue;
          }
          j();
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
    u.i("huanxin_kefu", " minsuchat activity  onStop ");
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
        //   1: getfield 19	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;
        //   4: new 30	java/lang/StringBuilder
        //   7: dup
        //   8: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   11: invokestatic 37	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   14: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   17: getstatic 47	java/io/File:separator	Ljava/lang/String;
        //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: ldc 52
        //   25: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: invokestatic 55	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity:b	()I
        //   31: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   34: ldc 60
        //   36: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   42: invokestatic 67	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity:a	(Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;Ljava/lang/String;)Ljava/lang/String;
        //   45: pop
        //   46: invokestatic 70	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
        //   49: ldc 72
        //   51: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   54: ifeq +116 -> 170
        //   57: new 43	java/io/File
        //   60: dup
        //   61: invokestatic 37	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   64: new 30	java/lang/StringBuilder
        //   67: dup
        //   68: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   71: ldc 52
        //   73: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: invokestatic 55	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity:b	()I
        //   79: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   82: ldc 60
        //   84: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokespecial 81	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   93: astore_1
        //   94: aload_1
        //   95: invokevirtual 85	java/io/File:exists	()Z
        //   98: ifeq +8 -> 106
        //   101: aload_1
        //   102: invokevirtual 88	java/io/File:delete	()Z
        //   105: pop
        //   106: new 90	java/io/FileOutputStream
        //   109: dup
        //   110: aload_1
        //   111: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   114: astore_2
        //   115: aload_2
        //   116: astore_1
        //   117: aload_0
        //   118: getfield 21	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity$8:a	Landroid/graphics/Bitmap;
        //   121: getstatic 99	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   124: bipush 100
        //   126: aload_2
        //   127: invokevirtual 105	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   130: pop
        //   131: aload_2
        //   132: astore_1
        //   133: aload_2
        //   134: invokevirtual 108	java/io/FileOutputStream:flush	()V
        //   137: aload_2
        //   138: astore_1
        //   139: aload_0
        //   140: getfield 19	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;
        //   143: invokestatic 112	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity:t	(Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;)Landroid/os/Handler;
        //   146: bipush 100
        //   148: invokevirtual 118	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   151: astore_3
        //   152: aload_2
        //   153: astore_1
        //   154: aload_0
        //   155: getfield 19	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;
        //   158: invokestatic 112	com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity:t	(Lcom/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity;)Landroid/os/Handler;
        //   161: aload_3
        //   162: invokevirtual 122	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
        //   165: pop
        //   166: aload_2
        //   167: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   170: return
        //   171: astore_1
        //   172: aload_1
        //   173: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   176: return
        //   177: astore_3
        //   178: aconst_null
        //   179: astore_2
        //   180: aload_2
        //   181: astore_1
        //   182: aload_3
        //   183: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   186: aload_2
        //   187: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   190: return
        //   191: astore_1
        //   192: aload_1
        //   193: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   196: return
        //   197: astore_2
        //   198: aconst_null
        //   199: astore_1
        //   200: aload_1
        //   201: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   204: aload_2
        //   205: athrow
        //   206: astore_1
        //   207: aload_1
        //   208: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   211: goto -7 -> 204
        //   214: astore_2
        //   215: goto -15 -> 200
        //   218: astore_3
        //   219: goto -39 -> 180
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	222	0	this	8
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
      showToast(getResources().getString(2131297414));
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
      MinsuChatActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          u.e("huanxin", "ChatActivity----MyConnectionListener ----onConnected----- ");
          ApplicationEx.c.setImconnect(true);
        }
      });
    }
    
    public void onDisconnected(final int paramInt)
    {
      MinsuChatActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (paramInt == 207)
          {
            u.e("huanxin", "ChatActivity-----MyConnectionListener -------显示帐号已经被移除 ");
            ApplicationEx.c.setImconnect(false);
          }
          do
          {
            return;
            if (paramInt != 206) {
              break;
            }
            u.e("huanxin", "ChatActivity----MyConnectionListener -------显示帐号在其他设备登陆dialog ");
            ApplicationEx.c.setImconnect(false);
          } while (EMClient.getInstance().isLoggedInBefore() != true);
          if (!MinsuChatActivity.isBackground(MinsuChatActivity.k(MinsuChatActivity.this))) {
            MinsuChatActivity.this.showToast("您已在另一设备上登录");
          }
          MinsuChatActivity.this.finish();
          return;
          ApplicationEx.c.setImconnect(false);
          if (NetUtils.hasNetwork(MinsuChatActivity.this))
          {
            u.e("huanxin", "ChatActivity----MyConnectionListener -------连接不到聊天服务器 ");
            return;
          }
          u.e("huanxin", "ChatActivity----MyConnectionListener --------当前网络不可用，请检查网络设置 ");
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */