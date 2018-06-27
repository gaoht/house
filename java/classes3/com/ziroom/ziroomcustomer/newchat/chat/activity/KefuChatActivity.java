package com.ziroom.ziroomcustomer.newchat.chat.activity;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
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
import android.util.Log;
import android.view.LayoutInflater;
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
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.NetUtils;
import com.hyphenate.util.PathUtil;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
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

public class KefuChatActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private static int S;
  public static KefuChatActivity a = null;
  static int d;
  private InputMethodManager A;
  private PowerManager.WakeLock B;
  private int C = -1;
  private int D = -1;
  private List<String> E;
  private RelativeLayout F;
  private ImageView G;
  private XListView H;
  private EMConversation I;
  private ClipboardManager J;
  private String K;
  private int L;
  private k M;
  private ProgressBar N;
  private boolean O = true;
  private final int P = 20;
  private File Q;
  private b R;
  private String T;
  private Context U;
  private PopupWindow V;
  private LinearLayout W;
  private int X;
  private TextView Y;
  private NotificationManager Z;
  private RelativeLayout aa;
  private LinearLayout ab;
  private String ac;
  private a ad = null;
  private String ae;
  private String af;
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
        KefuChatActivity.b(KefuChatActivity.this, KefuChatActivity.u(KefuChatActivity.this));
        return;
      }
      KefuChatActivity.this.showToast("服务器异常，请稍后再试");
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
        e(paramUri);
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
      e(paramUri.getAbsolutePath());
      return;
    }
    showToast("服务器异常，请稍后再试");
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
          u.e("filename: ", paramAnonymousAdapterView);
          if (paramAnonymousAdapterView != "delete_expression") {}
          try
          {
            paramAnonymousAdapterView = Class.forName("com.ziroom.ziroomcustomer.newchat.SmileUtils").getField(paramAnonymousAdapterView);
            KefuChatActivity.s(KefuChatActivity.this).append(SmileUtils.getSmiledText(KefuChatActivity.this, (String)paramAnonymousAdapterView.get(null)));
            return;
          }
          catch (Exception paramAnonymousAdapterView) {}
          if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(KefuChatActivity.s(KefuChatActivity.this))))
          {
            paramAnonymousInt = KefuChatActivity.s(KefuChatActivity.this).getSelectionStart();
            if (paramAnonymousInt > 0)
            {
              paramAnonymousAdapterView = VdsAgent.trackEditTextSilent(KefuChatActivity.s(KefuChatActivity.this)).toString().substring(0, paramAnonymousInt);
              int i = paramAnonymousAdapterView.lastIndexOf("[");
              if (i != -1)
              {
                if (SmileUtils.containsKey(paramAnonymousAdapterView.substring(i, paramAnonymousInt).toString()))
                {
                  KefuChatActivity.s(KefuChatActivity.this).getEditableText().delete(i, paramAnonymousInt);
                  return;
                }
                KefuChatActivity.s(KefuChatActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
                return;
              }
              KefuChatActivity.s(KefuChatActivity.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
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
  
  private void d(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = EMMessage.createTxtSendMessage(paramString, this.K);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("queueName", this.ac);
      paramString.setAttribute("weichat", localJSONObject);
      EMClient.getInstance().chatManager().sendMessage(paramString);
      paramString.setMessageStatusCallback(new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          u.e("sjdglk", "======  sendMessage  error");
        }
        
        public void onProgress(int paramAnonymousInt, String paramAnonymousString)
        {
          u.e("sjdglk", "======  sendMessage  progress");
        }
        
        public void onSuccess()
        {
          u.e("sjdglk", "======  sendMessage  onSuccess");
        }
      });
      this.f.setText("");
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
  
  private void e()
  {
    this.e = ((BasicZiroomToolBar)findViewById(2131689787));
    this.Z = ((NotificationManager)this.U.getSystemService("notification"));
    this.Z.cancel(291);
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
    this.G = ((ImageView)findViewById(2131689492));
    this.H = ((XListView)findViewById(2131691266));
    this.N = ((ProgressBar)findViewById(2131691265));
    this.W = ((LinearLayout)findViewById(2131691261));
    this.Y = ((TextView)findViewById(2131689541));
    this.aa = ((RelativeLayout)findViewById(2131690816));
    this.ab = ((LinearLayout)findViewById(2131690322));
    this.A = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.B = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    SildingFinishLayout localSildingFinishLayout = (SildingFinishLayout)findViewById(2131691249);
    localSildingFinishLayout.setOnSildingFinishListener(new SildingFinishLayout.a()
    {
      public void onSildingFinish()
      {
        KefuChatActivity.this.getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00000000"));
        KefuChatActivity.a(KefuChatActivity.this);
        KefuChatActivity.this.finish();
      }
    });
    localSildingFinishLayout.setTouchView(this.H);
  }
  
  private void e(String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.K);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("queueName", this.ac);
      paramString.setAttribute("weichat", localJSONObject);
      if (this.L == 2) {
        paramString.setChatType(EMMessage.ChatType.GroupChat);
      }
      EMClient.getInstance().chatManager().sendMessage(paramString);
      if (this.c != null)
      {
        paramString.setAttribute("name", this.c);
        paramString.setAttribute("price", this.b);
        paramString.setAttribute("picUrl", this.ae);
        localJSONObject = getMessageExtFromPicture();
        if (localJSONObject != null) {
          paramString.setAttribute("msgtype", localJSONObject);
        }
      }
      this.H.setAdapter(this.M);
      this.c = null;
      this.b = null;
      this.M.refresh();
      this.H.setSelection(this.M.getCount() - 1);
      setResult(-1);
      this.t.setVisibility(8);
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
    this.e.setTitle("在线咨询");
    this.e.addButton(this.e.newButton(2130840207, new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        KefuChatActivity.b(KefuChatActivity.this);
      }
    }));
    this.C = 0;
    this.D = 0;
    this.K = "ziroomerPro";
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
      localView = new View(this.U);
      localObject = new LinearLayout.LayoutParams(n.dip2px(this.U, 8.0F), n.dip2px(this.U, 8.0F));
      ((LinearLayout.LayoutParams)localObject).leftMargin = n.dip2px(this.U, 7.0F);
      localView.setEnabled(false);
      localView.setBackgroundResource(2130839308);
      this.W.addView(localView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    this.v.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        paramAnonymousInt %= localArrayList.size();
        KefuChatActivity.d(KefuChatActivity.this).getChildAt(KefuChatActivity.c(KefuChatActivity.this)).setEnabled(false);
        KefuChatActivity.d(KefuChatActivity.this).getChildAt(paramAnonymousInt).setEnabled(true);
        KefuChatActivity.a(KefuChatActivity.this, paramAnonymousInt);
      }
    });
    this.W.getChildAt(0).setEnabled(true);
    if ("yuekan".equals(getIntent().getStringExtra("from")))
    {
      this.R = ((b)getIntent().getSerializableExtra("Test"));
      this.c = this.R.getStImage();
      this.b = this.R.getStPrice();
      this.ae = this.R.getHouseUrl();
      this.af = this.R.getDetailUrl();
      new SimpleDraweeView(this.U).setController(c.frescoController(this.ae, new BasePostprocessor()
      {
        public void process(Bitmap paramAnonymousBitmap)
        {
          KefuChatActivity.this.saveMyBitmap(paramAnonymousBitmap);
        }
      }));
    }
  }
  
  private void g()
  {
    a = this;
    this.J = ((ClipboardManager)getSystemService("clipboard"));
    this.A = ((InputMethodManager)getSystemService("input_method"));
    getWindow().setSoftInputMode(3);
    this.B = ((PowerManager)getSystemService("power")).newWakeLock(6, "demo");
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.I = EMClient.getInstance().chatManager().getConversation(this.K);
      if (this.I != null)
      {
        this.I.markAllMessagesAsRead();
        ApplicationEx.c.setUnReadNum(0);
      }
      this.M = new k(this, this.K, this.L, this.H);
      this.H.setAdapter(this.M);
      this.H.setSelection(this.H.getCount() - 1);
      this.M.notifyDataSetChanged();
    }
    for (;;)
    {
      this.aa.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          KefuChatActivity.a(KefuChatActivity.this);
          KefuChatActivity.e(KefuChatActivity.this).setVisibility(8);
          KefuChatActivity.f(KefuChatActivity.this).setVisibility(0);
          KefuChatActivity.g(KefuChatActivity.this).setVisibility(8);
          KefuChatActivity.h(KefuChatActivity.this).setVisibility(8);
          return false;
        }
      });
      this.H.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = KefuChatActivity.i(KefuChatActivity.this).getItem(paramAnonymousInt - 1);
          KefuChatActivity.a(KefuChatActivity.this, new PopupWindow(KefuChatActivity.j(KefuChatActivity.this)));
          KefuChatActivity.k(KefuChatActivity.this).setBackgroundDrawable(new ColorDrawable(0));
          KefuChatActivity.k(KefuChatActivity.this).setOutsideTouchable(true);
          View localView = View.inflate(KefuChatActivity.j(KefuChatActivity.this), 2130903665, null);
          Object localObject = (TextView)localView.findViewById(2131693221);
          TextView localTextView = (TextView)localView.findViewById(2131691849);
          ((TextView)localObject).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = KefuChatActivity.i(KefuChatActivity.this).getItem(paramAnonymousInt - 1);
              KefuChatActivity.l(KefuChatActivity.this).setText(((EMTextMessageBody)paramAnonymous2View.getBody()).getMessage());
              KefuChatActivity.k(KefuChatActivity.this).dismiss();
            }
          });
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = KefuChatActivity.i(KefuChatActivity.this).getItem(paramAnonymousInt - 1);
              KefuChatActivity.m(KefuChatActivity.this).removeMessage(paramAnonymous2View.getMsgId());
              KefuChatActivity.i(KefuChatActivity.this).refresh();
              KefuChatActivity.n(KefuChatActivity.this).setSelection(paramAnonymousInt - 1);
              KefuChatActivity.k(KefuChatActivity.this).dismiss();
            }
          });
          KefuChatActivity.k(KefuChatActivity.this).setContentView(localView);
          KefuChatActivity.k(KefuChatActivity.this).setWidth(-2);
          KefuChatActivity.k(KefuChatActivity.this).setHeight(-2);
          try
          {
            localObject = new int[2];
            localView = paramAnonymousView.findViewById(2131696912);
            localView.getLocationInWindow((int[])localObject);
            paramAnonymousView.getLocationInWindow(new int[2]);
            paramAnonymousAdapterView = paramAnonymousAdapterView.getFrom();
            if (KefuChatActivity.o(KefuChatActivity.this).equals(paramAnonymousAdapterView))
            {
              paramAnonymousAdapterView = KefuChatActivity.k(KefuChatActivity.this);
              paramAnonymousInt = -n.dip2px(KefuChatActivity.this, 160.0F) / 2;
              if (!(paramAnonymousAdapterView instanceof PopupWindow))
              {
                paramAnonymousAdapterView.showAsDropDown(localView, 0, paramAnonymousInt);
                return true;
              }
              VdsAgent.showAsDropDown((PopupWindow)paramAnonymousAdapterView, localView, 0, paramAnonymousInt);
              return true;
            }
            paramAnonymousAdapterView = KefuChatActivity.k(KefuChatActivity.this);
            paramAnonymousInt = -n.dip2px(KefuChatActivity.this, 160.0F) / 2;
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
    this.ad = new a(null);
    EMClient.getInstance().addConnectionListener(this.ad);
    this.r.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setPullLoadEnable(false);
    this.H.setPullRefreshEnable(true);
    this.H.setXListViewListener(this);
    this.f.requestFocus();
    this.f.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        KefuChatActivity.f(KefuChatActivity.this).setVisibility(0);
        KefuChatActivity.e(KefuChatActivity.this).setVisibility(8);
        KefuChatActivity.g(KefuChatActivity.this).setVisibility(8);
        KefuChatActivity.h(KefuChatActivity.this).setVisibility(8);
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        KefuChatActivity.f(KefuChatActivity.this).setVisibility(0);
        KefuChatActivity.e(KefuChatActivity.this).setVisibility(8);
        KefuChatActivity.g(KefuChatActivity.this).setVisibility(8);
        KefuChatActivity.h(KefuChatActivity.this).setVisibility(8);
        KefuChatActivity.b(KefuChatActivity.this, 0);
        KefuChatActivity.c(KefuChatActivity.this, 0);
        KefuChatActivity.n(KefuChatActivity.this).setSelection(KefuChatActivity.n(KefuChatActivity.this).getCount() - 1);
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
          KefuChatActivity.p(KefuChatActivity.this).setVisibility(8);
          KefuChatActivity.q(KefuChatActivity.this).setVisibility(0);
          return;
        }
        KefuChatActivity.p(KefuChatActivity.this).setVisibility(0);
        KefuChatActivity.q(KefuChatActivity.this).setVisibility(8);
      }
    });
  }
  
  private void i()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      this.A.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
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
    this.H.stopRefresh();
    this.H.stopLoadMore();
    this.H.setRefreshTime("刚刚");
  }
  
  private void k()
  {
    if (this.M == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run() {}
    });
  }
  
  private void l()
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903648, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131691288);
    ((TextView)localView.findViewById(2131693113)).setText("是否清空所有聊天记录？");
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        EMClient.getInstance().chatManager().deleteConversation(KefuChatActivity.o(KefuChatActivity.this), true);
        KefuChatActivity.i(KefuChatActivity.this).refresh();
        localDialog.dismiss();
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private void m()
  {
    this.I.getMessage("1", false);
    this.M.refresh();
    this.H.setSelection(d);
  }
  
  private void n()
  {
    if (this.D == 0)
    {
      this.D = 1;
      this.C = 0;
      i();
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
  
  private void o()
  {
    if (this.C == 0)
    {
      this.C = 1;
      this.D = 0;
      i();
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
  
  protected void a()
  {
    EMMessageListener local5 = new EMMessageListener()
    {
      public void onCmdMessageReceived(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageChanged(EMMessage paramAnonymousEMMessage, Object paramAnonymousObject) {}
      
      public void onMessageDelivered(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageRead(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageRecalled(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageReceived(List<EMMessage> paramAnonymousList)
      {
        u.e("sjdkfjsdj", "=======  onMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
        Iterator localIterator = paramAnonymousList.iterator();
        if (localIterator.hasNext())
        {
          EMMessage localEMMessage = (EMMessage)localIterator.next();
          if ((localEMMessage.getChatType() == EMMessage.ChatType.GroupChat) || (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom)) {}
          for (paramAnonymousList = localEMMessage.getTo();; paramAnonymousList = localEMMessage.getFrom())
          {
            if (paramAnonymousList.equals(KefuChatActivity.o(KefuChatActivity.this))) {
              KefuChatActivity.r(KefuChatActivity.this);
            }
            if ((localEMMessage.isAcked()) || (localEMMessage.getChatType() != EMMessage.ChatType.Chat)) {
              break;
            }
            try
            {
              u.e("sdjgkdsj", "===== zhixingle  isAcked   22222");
              EMClient.getInstance().chatManager().ackMessageRead(localEMMessage.getFrom(), localEMMessage.getMsgId());
            }
            catch (HyphenateException paramAnonymousList)
            {
              paramAnonymousList.printStackTrace();
            }
            break;
          }
        }
      }
    };
    EMClient.getInstance().chatManager().addMessageListener(local5);
  }
  
  public void back(View paramView)
  {
    i();
    finish();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.ab.getLocationOnScreen(arrayOfInt);
    if ((this.C == 1) || (this.D == 1)) {
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.ab.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.ab.getHeight() + n.dip2px(this.U, 500.0F)))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        this.t.setVisibility(8);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getRawX() < arrayOfInt[0]) || (paramMotionEvent.getRawX() > arrayOfInt[0] + this.ab.getWidth()) || (paramMotionEvent.getRawY() < arrayOfInt[1]) || (paramMotionEvent.getRawY() > arrayOfInt[1] + this.ab.getHeight()))
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
    return this.H;
  }
  
  public JSONObject getMessageExtFromPicture()
  {
    return new m(1, "我正在看", "", this.b, this.c, this.ae, this.af).getJSONObject();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 2) {
        break label40;
      }
      EMClient.getInstance().chatManager().deleteConversation(this.K, true);
      this.M.refresh();
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
              } while ((this.Q == null) || (!this.Q.exists()));
              if (EMClient.getInstance().isLoggedInBefore() == true)
              {
                e(this.Q.getAbsolutePath());
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
            m();
            return;
          }
          if (paramInt1 != 11) {
            break;
          }
        } while (TextUtils.isEmpty(this.J.getText()));
        paramIntent = this.J.getText().toString();
      } while (!paramIntent.startsWith("EASEMOBIMG"));
      if (EMClient.getInstance().isLoggedInBefore() == true)
      {
        e(paramIntent.replace("EASEMOBIMG", ""));
        return;
      }
      showToast("服务器异常，请稍后再试");
      return;
      if (this.I.getAllMessages().size() > 0)
      {
        this.M.refresh();
        setResult(-1);
        return;
      }
      if (paramInt1 == 21)
      {
        this.M.refresh();
        return;
      }
    } while (paramInt1 != 26);
    this.M.refresh();
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
      o();
      return;
    case 2131691255: 
      n();
      return;
    case 2131691257: 
      paramView = VdsAgent.trackEditTextSilent(this.f).toString();
      if (EMClient.getInstance().isLoggedInBefore() == true) {
        try
        {
          d(paramView);
          w.onEvent(this.U, "online_service_send");
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
    this.U = this;
    this.ac = com.ziroom.ziroomcustomer.newchat.chat.a.a.getSkillName(getIntent().getStringExtra("chatForm"));
    e();
    f();
    h();
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a = null;
    if (this.ad != null) {
      EMClient.getInstance().removeConnectionListener(this.ad);
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
      if (this.I == null) {
        break label106;
      }
      if (this.I.getAllMessages().size() != 0) {
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
        List localList = this.I.loadMoreMsgFromDB(this.M.getItem(0).getMsgId(), 20);
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
          this.H.setPullRefreshEnable(false);
          showToast("已经没有数据了！");
          return;
          label106:
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
      this.M.refresh();
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
        //   1: getfield 19	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;
        //   4: new 30	java/lang/StringBuilder
        //   7: dup
        //   8: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   11: invokestatic 37	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   14: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   17: getstatic 47	java/io/File:separator	Ljava/lang/String;
        //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: ldc 52
        //   25: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: invokestatic 55	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity:b	()I
        //   31: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   34: ldc 60
        //   36: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   42: invokestatic 67	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity:a	(Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;Ljava/lang/String;)Ljava/lang/String;
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
        //   76: invokestatic 55	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity:b	()I
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
        //   118: getfield 21	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity$8:a	Landroid/graphics/Bitmap;
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
        //   140: getfield 19	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;
        //   143: invokestatic 112	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity:t	(Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;)Landroid/os/Handler;
        //   146: bipush 100
        //   148: invokevirtual 118	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   151: astore_3
        //   152: aload_2
        //   153: astore_1
        //   154: aload_0
        //   155: getfield 19	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity$8:b	Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;
        //   158: invokestatic 112	com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity:t	(Lcom/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity;)Landroid/os/Handler;
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
      Toast localToast = Toast.makeText(getApplicationContext(), 2131297414, 0);
      if (!(localToast instanceof Toast))
      {
        localToast.show();
        return;
      }
      VdsAgent.showToast((Toast)localToast);
      return;
    }
    this.Q = new File(PathUtil.getInstance().getImagePath(), System.currentTimeMillis() + ".jpg");
    this.Q.getParentFile().mkdirs();
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", Uri.fromFile(this.Q)), 18);
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
    this.H = paramXListView;
  }
  
  private class a
    implements EMConnectionListener
  {
    private a() {}
    
    public void onConnected()
    {
      KefuChatActivity.this.runOnUiThread(new Runnable()
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
      KefuChatActivity.this.runOnUiThread(new Runnable()
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
          if (!KefuChatActivity.isBackground(KefuChatActivity.j(KefuChatActivity.this))) {
            g.textToast(KefuChatActivity.j(KefuChatActivity.this), "您已在另一设备上登录", 0);
          }
          KefuChatActivity.this.finish();
          return;
          ApplicationEx.c.setImconnect(false);
          if (NetUtils.hasNetwork(KefuChatActivity.this))
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chat/activity/KefuChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */