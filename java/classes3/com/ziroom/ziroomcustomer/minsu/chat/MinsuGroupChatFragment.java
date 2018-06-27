package com.ziroom.ziroomcustomer.minsu.chat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import cn.dreamtobe.kpswitch.b.a.b;
import cn.dreamtobe.kpswitch.b.c.b;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelFrameLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMChatRoomManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Status;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuZRYNoticeCMSBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuZRYNoticeCMSBean.NoticeBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuZRYNoticeCMSBean.NoticeBean.LunboBean;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.f.y;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.widget.VerticalViewPager2;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MinsuGroupChatFragment
  extends BaseFragment
  implements View.OnClickListener, EMMessageListener
{
  private View A;
  private TextView B;
  private int C = 1;
  private String D;
  private int E = 1;
  private com.ziroom.ziroomcustomer.minsu.chat.d.k F;
  private int G = 0;
  private List<String> H;
  private ViewPager I;
  private LinearLayout J;
  private ImageView K;
  private ImageView L;
  private View M;
  private KPSwitchPanelFrameLayout N;
  private ImageView O;
  private a P = new a(null);
  protected Bundle a;
  protected int b;
  protected String c;
  protected MinsuChatMessageList d;
  protected EMConversation e;
  protected InputMethodManager f;
  protected ClipboardManager g;
  protected Handler h = new Handler();
  protected File i;
  protected SwipeRefreshLayout j;
  protected ListView k;
  protected boolean l;
  protected boolean m = true;
  protected int n = 20;
  protected EMMessage o;
  AnimatorSet p;
  protected a q;
  protected BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuGroupChatFragment.this.d.refresh();
      MinsuGroupChatFragment.h(MinsuGroupChatFragment.this);
    }
  };
  protected BroadcastReceiver s = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getStringExtra("groupId");
      if ((paramAnonymousContext != null) && (paramAnonymousContext.equals(MinsuGroupChatFragment.this.c))) {
        MinsuGroupChatFragment.h(MinsuGroupChatFragment.this);
      }
    }
  };
  private boolean t;
  private CommonTitle u;
  private TextView v;
  private EditText w;
  private CountDownTimer x;
  private VerticalViewPager2 y;
  private int z = 0;
  
  private void A()
  {
    this.H = com.ziroom.ziroomcustomer.minsu.chat.b.b.getExpressionRes(35);
    final ArrayList localArrayList = new ArrayList();
    View localView = com.ziroom.ziroomcustomer.minsu.chat.b.b.getGridChildView(1, getActivity(), this.w);
    Object localObject = com.ziroom.ziroomcustomer.minsu.chat.b.b.getGridChildView(2, getActivity(), this.w);
    localArrayList.add(localView);
    localArrayList.add(localObject);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.chat.b.b.getBigExpressionView(getActivity(), 1, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
    {
      public void onClick(String paramAnonymousString)
      {
        MinsuGroupChatFragment.this.a(MinsuGroupChatFragment.this.c, paramAnonymousString);
      }
    }));
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.chat.b.b.getBigExpressionView(getActivity(), 2, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
    {
      public void onClick(String paramAnonymousString)
      {
        MinsuGroupChatFragment.this.a(MinsuGroupChatFragment.this.c, paramAnonymousString);
      }
    }));
    this.I.setOffscreenPageLimit(4);
    this.I.setAdapter(new com.ziroom.ziroomcustomer.minsu.chat.b.d(localArrayList));
    this.J.removeAllViews();
    int i1 = 0;
    while (i1 < 2)
    {
      localView = new View(getActivity());
      localObject = new LinearLayout.LayoutParams(n.dip2px(getActivity(), 8.0F), n.dip2px(getActivity(), 8.0F));
      ((LinearLayout.LayoutParams)localObject).leftMargin = n.dip2px(getActivity(), 7.0F);
      localView.setBackgroundResource(2130839323);
      localView.setId(i1);
      this.J.addView(localView, (ViewGroup.LayoutParams)localObject);
      i1 += 1;
    }
    this.I.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        int i = paramAnonymousInt % localArrayList.size();
        MinsuGroupChatFragment.k(MinsuGroupChatFragment.this).removeAllViews();
        paramAnonymousInt = 0;
        if (paramAnonymousInt < 2)
        {
          View localView = new View(MinsuGroupChatFragment.this.getActivity());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(MinsuGroupChatFragment.this.getActivity(), 8.0F), n.dip2px(MinsuGroupChatFragment.this.getActivity(), 8.0F));
          localLayoutParams.leftMargin = n.dip2px(MinsuGroupChatFragment.this.getActivity(), 7.0F);
          if (i % 2 == paramAnonymousInt) {
            localView.setBackgroundResource(2130839314);
          }
          for (;;)
          {
            localView.setId(paramAnonymousInt);
            MinsuGroupChatFragment.k(MinsuGroupChatFragment.this).addView(localView, localLayoutParams);
            paramAnonymousInt += 1;
            break;
            localView.setBackgroundResource(2130839323);
          }
        }
        MinsuGroupChatFragment.k(MinsuGroupChatFragment.this).invalidate();
        switch (i)
        {
        default: 
          return;
        case 0: 
        case 1: 
          MinsuGroupChatFragment.l(MinsuGroupChatFragment.this).setSelected(true);
          MinsuGroupChatFragment.m(MinsuGroupChatFragment.this).setSelected(false);
          return;
        }
        MinsuGroupChatFragment.l(MinsuGroupChatFragment.this).setSelected(false);
        MinsuGroupChatFragment.m(MinsuGroupChatFragment.this).setSelected(true);
      }
    });
    this.J.getChildAt(0).setBackgroundResource(2130839314);
  }
  
  private void a(int paramInt)
  {
    this.G = paramInt;
    switch (paramInt)
    {
    }
    while (paramInt == 1)
    {
      o();
      return;
      this.N.setVisibility(8);
      this.M.setVisibility(8);
      this.O.setImageResource(2130840298);
      continue;
      this.N.setVisibility(0);
      this.M.setVisibility(0);
      if ((this.N.getLayoutParams().height <= 0) || (this.M.getLayoutParams().height <= 0))
      {
        getView().findViewById(2131696862).invalidate();
        this.N.invalidate();
        this.M.invalidate();
      }
      this.O.setImageResource(2130840299);
    }
    k();
  }
  
  private boolean e(String paramString)
  {
    int i1 = aa.getInt(ApplicationEx.c, "imConMax", 400);
    if (paramString.length() > i1)
    {
      showToast("字数超出限制");
      return true;
    }
    return false;
  }
  
  private String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = ApplicationEx.c.getUser().getNickName();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str).append(":");
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void l()
  {
    try
    {
      EMGroup localEMGroup = EMClient.getInstance().groupManager().getGroup(this.c);
      String str = localEMGroup.getGroupName();
      int i1 = localEMGroup.getMemberCount();
      if (i1 != 0)
      {
        this.u.setMiddleText(String.format("%s (%d人)", new Object[] { str, Integer.valueOf(i1) }));
        return;
      }
      this.u.setMiddleText(str);
      m();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    try
    {
      EMClient.getInstance().groupManager().asyncGetGroupFromServer(this.c, new EMValueCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onSuccess(final EMGroup paramAnonymousEMGroup)
        {
          MinsuGroupChatFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              String str = paramAnonymousEMGroup.getGroupName();
              int i = paramAnonymousEMGroup.getMemberCount();
              str = String.format(MinsuGroupChatFragment.this.getString(2131297169), new Object[] { str, Integer.valueOf(i) });
              MinsuGroupChatFragment.d(MinsuGroupChatFragment.this).setMiddleText(str);
            }
          });
        }
      });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.v = ((TextView)getView().findViewById(2131691438));
    this.v.setOnClickListener(this);
    this.w.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (ae.isNull(VdsAgent.trackEditTextSilent(MinsuGroupChatFragment.a(MinsuGroupChatFragment.this)).toString()))
        {
          MinsuGroupChatFragment.e(MinsuGroupChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624046));
          MinsuGroupChatFragment.e(MinsuGroupChatFragment.this).setEnabled(false);
          return;
        }
        MinsuGroupChatFragment.e(MinsuGroupChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624475));
        MinsuGroupChatFragment.e(MinsuGroupChatFragment.this).setEnabled(true);
      }
    });
    this.v.setVisibility(0);
    getView().findViewById(2131696858).setVisibility(0);
    getView().findViewById(2131694528).setOnClickListener(this);
    getView().findViewById(2131694527).setOnClickListener(this);
  }
  
  private void o()
  {
    this.w.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)MinsuGroupChatFragment.this.getActivity().getSystemService("input_method");
        localInputMethodManager.showSoftInput(MinsuGroupChatFragment.a(MinsuGroupChatFragment.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 100L);
  }
  
  private void p()
  {
    setChatFragmentHelper(new a()
    {
      public void onAvatarClick(String paramAnonymousString) {}
      
      public void onEnterToChatDetails() {}
      
      public boolean onExtendMenuItemClick(int paramAnonymousInt, View paramAnonymousView)
      {
        return false;
      }
      
      public boolean onMessageBubbleClick(EMMessage paramAnonymousEMMessage)
      {
        return false;
      }
      
      public void onMessageBubbleLongClick(EMMessage paramAnonymousEMMessage) {}
      
      public f onSetCustomChatRowProvider()
      {
        return new h(MinsuGroupChatFragment.this.getActivity(), MinsuGroupChatFragment.g(MinsuGroupChatFragment.this));
      }
      
      public void onSetMessageAttributes(EMMessage paramAnonymousEMMessage)
      {
        j.setExtMsg4Station(paramAnonymousEMMessage, MinsuGroupChatFragment.this.e.getLastMessage());
        MinsuGroupChatFragment.f(MinsuGroupChatFragment.this);
      }
    });
  }
  
  private void q()
  {
    IntentFilter localIntentFilter = new IntentFilter("action_sync_im_succ");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.r, localIntentFilter);
    localIntentFilter = new IntentFilter("im_exit_group");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.P, localIntentFilter);
    localIntentFilter = new IntentFilter("im_group_member_changed");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.s, localIntentFilter);
  }
  
  private void r()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getZRYNotice(getActivity(), new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.e())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_todo", "e = " + paramAnonymousThrowable);
        MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", " s = " + paramAnonymousString);
        Object localObject2 = (MinsuZRYNoticeCMSBean)com.alibaba.fastjson.a.parseObject(paramAnonymousString, MinsuZRYNoticeCMSBean.class);
        ArrayList localArrayList = new ArrayList();
        paramAnonymousString = null;
        try
        {
          localObject1 = EMClient.getInstance().groupManager().getGroup(MinsuGroupChatFragment.this.c).getDescription();
          paramAnonymousString = (String)localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            localException.printStackTrace();
          }
          MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramAnonymousString)) {
          try
          {
            paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString).getString("projectBid");
            paramAnonymousString = (MinsuZRYNoticeCMSBean.NoticeBean)((MinsuZRYNoticeCMSBean)localObject2).data.get(paramAnonymousString);
            if ((paramAnonymousString != null) && (paramAnonymousString.lunbotu != null))
            {
              paramAnonymousString = paramAnonymousString.lunbotu.iterator();
              while (paramAnonymousString.hasNext())
              {
                localObject1 = (MinsuZRYNoticeCMSBean.NoticeBean.LunboBean)paramAnonymousString.next();
                Object localObject3 = ((MinsuZRYNoticeCMSBean.NoticeBean.LunboBean)localObject1).app.split("&");
                if (localObject3.length >= 2)
                {
                  localObject2 = m.strToDate(localObject3[0], "yyyy-MM-dd HH:mm");
                  localObject3 = m.strToDate(localObject3[1], "yyyy-MM-dd HH:mm");
                  Date localDate = Calendar.getInstance().getTime();
                  if ((((Date)localObject2).before(localDate)) && (((Date)localObject3).after(localDate))) {
                    localArrayList.add(localObject1);
                  }
                }
              }
            }
            if (localArrayList == null) {
              break label311;
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
          }
        }
        if (localArrayList.size() > 0)
        {
          MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setVisibility(0);
          MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setOffscreenPageLimit(1);
          MinsuGroupChatFragment.b(MinsuGroupChatFragment.this, localArrayList.size());
          paramAnonymousString = new MinsuGroupChatFragment.b(MinsuGroupChatFragment.this, localArrayList);
          MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setAdapter(paramAnonymousString);
          return;
        }
        label311:
      }
    });
    EMClient.getInstance().groupManager().asyncGetGroupFromServer(this.c, new EMValueCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess(EMGroup paramAnonymousEMGroup)
      {
        MinsuGroupChatFragment.j(MinsuGroupChatFragment.this);
      }
    });
  }
  
  private void s()
  {
    t();
    u();
  }
  
  private void t()
  {
    this.x = new CountDownTimer(2147483647L, 4000L)
    {
      public void onFinish() {}
      
      public void onTick(long paramAnonymousLong)
      {
        if (MinsuGroupChatFragment.this.p != null) {
          MinsuGroupChatFragment.this.p.start();
        }
        MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).setCurrentItem(MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).getCurrentItem() + 1);
        MinsuGroupChatFragment.i(MinsuGroupChatFragment.this).postInvalidate();
      }
    };
  }
  
  private void u()
  {
    this.p = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.A, View.ROTATION_X, new float[] { 0.0F, ab.dp2px(getActivity(), 70.0F) });
    localObjectAnimator1.setDuration(750L);
    localObjectAnimator1.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  ---  ");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  ---  ");
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  ---  ");
      }
    });
    localObjectAnimator1.setRepeatMode(2);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.A, View.TRANSLATION_X, new float[] { 0.0F, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.A, View.TRANSLATION_Y, new float[] { 0.0F, 0.0F });
    this.p.setDuration(1500L);
    this.p.setInterpolator(new AccelerateDecelerateInterpolator());
    this.p.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  ---  ");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  ---  ");
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "  onAnimationStart  ");
      }
    });
    this.p.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
  }
  
  private void v()
  {
    if (this.x == null) {
      t();
    }
    if (this.p == null) {
      u();
    }
    if (this.x != null) {
      this.x.start();
    }
  }
  
  private void w()
  {
    this.x.cancel();
    this.x = null;
    if ((this.p != null) && ((this.p.isRunning()) || (this.p.isPaused()) || (this.p.isStarted()))) {
      this.p.end();
    }
  }
  
  private void x()
  {
    if ((this.I.getCurrentItem() == 2) || (this.I.getCurrentItem() == 3)) {
      return;
    }
    this.I.setCurrentItem(2);
  }
  
  private void y()
  {
    if ((this.I.getCurrentItem() == 1) || (this.I.getCurrentItem() == 0)) {
      return;
    }
    this.I.setCurrentItem(0);
  }
  
  private void z()
  {
    String str = VdsAgent.trackEditTextSilent(this.w).toString();
    if (e(str)) {
      return;
    }
    b(str);
    this.w.setText("");
  }
  
  protected void a(Uri paramUri)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    Cursor localCursor = getActivity().getContentResolver().query(paramUri, arrayOfString, null, null, null);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      paramUri = localCursor.getString(localCursor.getColumnIndex(arrayOfString[0]));
      localCursor.close();
      if ((paramUri == null) || (paramUri.equals("null")))
      {
        paramUri = Toast.makeText(getActivity(), 2131297293, 0);
        paramUri.setGravity(17, 0, 0);
        if (!(paramUri instanceof Toast))
        {
          paramUri.show();
          return;
        }
        VdsAgent.showToast((Toast)paramUri);
        return;
      }
      c(paramUri);
      return;
    }
    paramUri = new File(paramUri.getPath());
    if (!paramUri.exists())
    {
      paramUri = Toast.makeText(getActivity(), 2131297293, 0);
      paramUri.setGravity(17, 0, 0);
      if (!(paramUri instanceof Toast))
      {
        paramUri.show();
        return;
      }
      VdsAgent.showToast((Toast)paramUri);
      return;
    }
    c(paramUri.getAbsolutePath());
  }
  
  protected void a(EMMessage paramEMMessage)
  {
    if (this.q != null) {
      this.q.onSetMessageAttributes(paramEMMessage);
    }
    paramEMMessage.setChatType(EMMessage.ChatType.GroupChat);
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.d.refreshSelectLast();
  }
  
  protected void a(EMMessage paramEMMessage, String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.chat.d.c.setAPNS(paramEMMessage, paramString, "ZIROOM_ZRY_IM");
    a(paramEMMessage);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString1 = com.ziroom.ziroomcustomer.minsu.chat.d.c.createExpressionMessage(paramString1, paramString2);
    com.ziroom.ziroomcustomer.minsu.chat.d.c.setAPNS(paramString1, f("[动画表情]"), "ZIROOM_ZRY_IM");
    a(paramString1);
  }
  
  protected void b(String paramString)
  {
    if (ae.isNull(paramString))
    {
      showToast("输入内容为空");
      return;
    }
    a(EMMessage.createTxtSendMessage(paramString, this.c), f(paramString));
  }
  
  protected void c()
  {
    this.d = ((MinsuChatMessageList)getView().findViewById(2131696855));
    if (this.b != 1) {
      this.d.setShowUserNick(true);
    }
    this.k = this.d.getListView();
    this.y = ((VerticalViewPager2)getView().findViewById(2131696863));
    this.A = getView().findViewById(2131696864);
    this.B = ((TextView)getView().findViewById(2131692028));
    this.O = ((ImageView)getView().findViewById(2131694526));
    this.w = ((EditText)getView().findViewById(2131693118));
    this.w.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) || (paramAnonymousInt == 6) || ((paramAnonymousKeyEvent != null) && (66 == paramAnonymousKeyEvent.getKeyCode()) && (paramAnonymousKeyEvent.getAction() == 0)))
        {
          paramAnonymousTextView = VdsAgent.trackEditTextSilent(MinsuGroupChatFragment.a(MinsuGroupChatFragment.this)).toString();
          if (MinsuGroupChatFragment.a(MinsuGroupChatFragment.this, paramAnonymousTextView)) {
            return true;
          }
          MinsuGroupChatFragment.this.b(paramAnonymousTextView);
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).postDelayed(new Runnable()
          {
            public void run()
            {
              MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).setText("");
              MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).setLines(1);
            }
          }, 50L);
          MinsuGroupChatFragment.this.d.scrollToListViewBottom();
        }
        return false;
      }
    });
    this.w.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).setMaxLines(4);
        }
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.j = this.d.getSwipeRefreshLayout();
    this.j.setColorSchemeResources(new int[] { 2131624403, 2131624404, 2131624405, 2131624406 });
    this.f = ((InputMethodManager)getActivity().getSystemService("input_method"));
    this.g = ((ClipboardManager)getActivity().getSystemService("clipboard"));
    getActivity().getWindow().setSoftInputMode(3);
    initTitle();
    this.I = ((ViewPager)getView().findViewById(2131694549));
    this.J = ((LinearLayout)getView().findViewById(2131694550));
    this.K = ((ImageView)getView().findViewById(2131694552));
    this.K.setSelected(true);
    this.K.setOnClickListener(this);
    this.L = ((ImageView)getView().findViewById(2131694553));
    this.L.setOnClickListener(this);
    this.M = getView().findViewById(2131694548);
    this.N = ((KPSwitchPanelFrameLayout)getView().findViewById(2131692491));
    this.N.setIgnoreRecommendHeight(true);
    cn.dreamtobe.kpswitch.b.c.attach(getActivity(), this.N, new c.b()
    {
      public void onKeyboardShowing(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          MinsuGroupChatFragment.b(MinsuGroupChatFragment.this).setImageResource(2130840298);
        }
      }
    });
    cn.dreamtobe.kpswitch.b.a.attach(this.N, this.O, this.w, new a.b()
    {
      public void onClickSwitch(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).clearFocus();
          MinsuGroupChatFragment.b(MinsuGroupChatFragment.this).requestFocus();
          MinsuGroupChatFragment.b(MinsuGroupChatFragment.this).setImageResource(2130840299);
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this, 5);
          return;
        }
        MinsuGroupChatFragment.a(MinsuGroupChatFragment.this).requestFocus();
        MinsuGroupChatFragment.b(MinsuGroupChatFragment.this).setImageResource(2130840298);
      }
    });
    getView().setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this, 0);
        }
        return false;
      }
    });
    this.d.getListView().setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          MinsuGroupChatFragment.a(MinsuGroupChatFragment.this, 0);
        }
        return false;
      }
    });
  }
  
  protected void c(String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.c);
    Toast localToast;
    if (paramString == null)
    {
      localToast = Toast.makeText(getActivity(), 2131297293, 0);
      localToast.setGravity(17, 0, 0);
      if ((localToast instanceof Toast)) {
        break label51;
      }
      localToast.show();
    }
    for (;;)
    {
      a(paramString);
      return;
      label51:
      VdsAgent.showToast((Toast)localToast);
    }
  }
  
  protected void d()
  {
    p();
    if (this.b != 3)
    {
      e();
      f();
    }
    h();
    String str = getArguments().getString("forward_msg_id");
    if (str != null) {
      d(str);
    }
    A();
  }
  
  protected void d(String paramString)
  {
    paramString = EMClient.getInstance().chatManager().getMessage(paramString);
    EMMessage.Type localType = paramString.getType();
    switch (19.a[localType.ordinal()])
    {
    }
    for (;;)
    {
      if (paramString.getChatType() == EMMessage.ChatType.ChatRoom) {
        EMClient.getInstance().chatroomManager().leaveChatRoom(paramString.getTo());
      }
      return;
      if (paramString.getBooleanAttribute("em_is_big_expression", false)) {
        a(((EMTextMessageBody)paramString.getBody()).getMessage(), paramString.getStringAttribute("em_expression_id", null));
      } else {
        b(((EMTextMessageBody)paramString.getBody()).getMessage());
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.G != 0)
    {
      a(0);
      bool = true;
    }
    return bool;
  }
  
  protected void e()
  {
    this.e = EMClient.getInstance().chatManager().getConversation(this.c, EMConversation.EMConversationType.GroupChat, true);
    this.e.markAllMessagesAsRead();
    new ArrayList().addAll(this.e.loadMoreMsgFromDB(null, this.n));
  }
  
  protected void f()
  {
    MinsuChatMessageList localMinsuChatMessageList = this.d;
    String str = this.c;
    int i1 = this.b;
    if (this.q != null) {}
    for (f localf = this.q.onSetCustomChatRowProvider();; localf = null)
    {
      localMinsuChatMessageList.init(str, i1, localf);
      g();
      this.t = true;
      return;
    }
  }
  
  protected void g()
  {
    this.d.setItemClickListener(new d()
    {
      public boolean onBubbleClick(EMMessage paramAnonymousEMMessage)
      {
        if (MinsuGroupChatFragment.this.q != null) {
          return MinsuGroupChatFragment.this.q.onMessageBubbleClick(paramAnonymousEMMessage);
        }
        return false;
      }
      
      public void onBubbleLongClick(EMMessage paramAnonymousEMMessage)
      {
        MinsuGroupChatFragment.this.o = paramAnonymousEMMessage;
        if (MinsuGroupChatFragment.this.q != null) {
          MinsuGroupChatFragment.this.q.onMessageBubbleLongClick(paramAnonymousEMMessage);
        }
      }
      
      public void onResendClick(EMMessage paramAnonymousEMMessage) {}
      
      public void onUserAvatarClick(String paramAnonymousString)
      {
        if (MinsuGroupChatFragment.this.q != null) {
          MinsuGroupChatFragment.this.q.onAvatarClick(paramAnonymousString);
        }
      }
    });
    this.d.setOnMessageStatusAdapter(new i()
    {
      public void onFail(EMMessage paramAnonymousEMMessage)
      {
        String str1 = j.getMessageDigest(paramAnonymousEMMessage, MinsuGroupChatFragment.this.getActivity());
        u.i("huanxin", "消息发送失败===" + str1);
        String str2 = paramAnonymousEMMessage.getMsgId();
        String str3 = paramAnonymousEMMessage.getFrom();
        String str4 = paramAnonymousEMMessage.getTo();
        paramAnonymousEMMessage = com.alibaba.fastjson.e.toJSONString(paramAnonymousEMMessage.ext());
        com.ziroom.ziroomcustomer.minsu.e.a.imSaveMsgLog(MinsuGroupChatFragment.this.getActivity(), str2, str3, str4, str1, paramAnonymousEMMessage, "groupchat", "ZIROOM_ZRY_IM", "txt", 1, new t(MinsuGroupChatFragment.this.getActivity(), new com.freelxl.baselibrary.d.f.e())
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            System.out.println(" e = " + paramAnonymous2Throwable);
          }
          
          public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
          {
            System.out.println(" o = " + paramAnonymous2String);
          }
        });
      }
      
      public void onSuccess(EMMessage paramAnonymousEMMessage)
      {
        String str1 = j.getMessageDigest(paramAnonymousEMMessage, MinsuGroupChatFragment.this.getActivity());
        u.i("huanxin", "消息发送成功===" + str1);
        String str2 = paramAnonymousEMMessage.getMsgId();
        String str3 = paramAnonymousEMMessage.getFrom();
        String str4 = paramAnonymousEMMessage.getTo();
        paramAnonymousEMMessage = com.alibaba.fastjson.e.toJSONString(paramAnonymousEMMessage.ext());
        com.ziroom.ziroomcustomer.minsu.e.a.imSaveMsgLog(MinsuGroupChatFragment.this.getActivity(), str2, str3, str4, str1, paramAnonymousEMMessage, "groupchat", "ZIROOM_ZRY_IM", "txt", 0, new t(MinsuGroupChatFragment.this.getActivity(), new com.freelxl.baselibrary.d.f.e())
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            System.out.println(" e = " + paramAnonymous2Throwable);
          }
          
          public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
          {
            System.out.println(" o = " + paramAnonymous2String);
          }
        });
      }
    });
  }
  
  public int getBottomShowType()
  {
    return this.G;
  }
  
  protected void h()
  {
    this.j.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
    {
      public void onRefresh()
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if ((MinsuGroupChatFragment.this.k.getFirstVisiblePosition() == 0) && (!MinsuGroupChatFragment.this.l) && (MinsuGroupChatFragment.this.m)) {}
            for (;;)
            {
              try
              {
                List localList;
                if (MinsuGroupChatFragment.this.b == 1)
                {
                  localList = MinsuGroupChatFragment.this.e.loadMoreMsgFromDB(MinsuGroupChatFragment.this.d.getItem(0).getMsgId(), MinsuGroupChatFragment.this.n);
                  if (localList.size() > 0)
                  {
                    MinsuGroupChatFragment.this.d.refreshSeekTo(localList.size() - 1);
                    if (localList.size() != MinsuGroupChatFragment.this.n) {
                      MinsuGroupChatFragment.this.m = false;
                    }
                    MinsuGroupChatFragment.this.l = false;
                    MinsuGroupChatFragment.this.j.setRefreshing(false);
                  }
                }
                else
                {
                  localList = MinsuGroupChatFragment.this.e.loadMoreMsgFromDB(MinsuGroupChatFragment.this.d.getItem(0).getMsgId(), MinsuGroupChatFragment.this.n);
                  continue;
                }
                MinsuGroupChatFragment.this.m = false;
              }
              catch (Exception localException)
              {
                MinsuGroupChatFragment.this.j.setRefreshing(false);
                return;
              }
              continue;
              Toast localToast = Toast.makeText(MinsuGroupChatFragment.this.getActivity(), MinsuGroupChatFragment.this.getResources().getString(2131297288), 0);
              if (!(localToast instanceof Toast)) {
                localToast.show();
              } else {
                VdsAgent.showToast((Toast)localToast);
              }
            }
          }
        }, 600L);
      }
    });
  }
  
  protected void i()
  {
    if (!com.ziroom.ziroomcustomer.newchat.d.isExitsSdcard())
    {
      Toast localToast = Toast.makeText(getActivity(), 2131297414, 0);
      if (!(localToast instanceof Toast))
      {
        localToast.show();
        return;
      }
      VdsAgent.showToast((Toast)localToast);
      return;
    }
    this.i = new File(PathUtil.getInstance().getImagePath(), EMClient.getInstance().getCurrentUser() + System.currentTimeMillis() + ".jpg");
    this.i.getParentFile().mkdirs();
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", Uri.fromFile(this.i)), 12);
  }
  
  public void initTitle()
  {
    this.u = ((CommonTitle)getView().findViewById(2131691272));
    this.u.setLeftButtonType(0);
    this.u.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ("offline_push".equals(MinsuGroupChatFragment.c(MinsuGroupChatFragment.this)))
        {
          paramAnonymousView = new Intent(MinsuGroupChatFragment.this.getActivity(), MainActivity.class);
          MinsuGroupChatFragment.this.startActivity(paramAnonymousView);
        }
        MinsuGroupChatFragment.this.getActivity().finish();
      }
    });
    this.u.showRightIc(true, 2130840280);
    this.u.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MinsuGroupChatFragment.this.getActivity(), MinsuGroupChatInfoActivity.class);
        Object localObject = EMClient.getInstance().groupManager().getGroup(MinsuGroupChatFragment.this.c);
        String str = ((EMGroup)localObject).getGroupName();
        int i = ((EMGroup)localObject).getMemberCount();
        paramAnonymousView.putExtra("groupId", MinsuGroupChatFragment.this.c);
        paramAnonymousView.putExtra("count", i);
        paramAnonymousView.putExtra("groupName", str);
        localObject = EMClient.getInstance().groupManager().getGroup(MinsuGroupChatFragment.this.c).getOwner();
        paramAnonymousView.putExtra("isOwner", com.ziroom.ziroomcustomer.minsu.e.d.getUid().equals(j.removeEMPrefix((String)localObject)));
        MinsuGroupChatFragment.this.startActivityForResult(paramAnonymousView, 2);
      }
    });
    l();
  }
  
  protected void j()
  {
    Intent localIntent;
    if (Build.VERSION.SDK_INT < 19)
    {
      localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.setType("image/*");
    }
    for (;;)
    {
      startActivityForResult(localIntent, 13);
      return;
      localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }
  }
  
  protected void k()
  {
    if ((getActivity().getWindow().getAttributes().softInputMode != 2) && (getActivity().getCurrentFocus() != null) && (this.f != null)) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.a = getArguments();
    this.b = this.a.getInt("chatType", 2);
    this.c = this.a.getString("userId");
    this.D = this.a.getString("from");
    this.C = this.a.getInt("msgSenderType");
    this.F = com.ziroom.ziroomcustomer.minsu.chat.d.k.getInstance();
    c();
    d();
    n();
    super.onActivityCreated(paramBundle);
    q();
    s();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1)) {
      getActivity().finish();
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 12) {
        break label64;
      }
      if ((this.i != null) && (this.i.exists())) {
        c(this.i.getAbsolutePath());
      }
    }
    label64:
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 13) {
            break;
          }
        } while (paramIntent == null);
        paramIntent = paramIntent.getData();
      } while (paramIntent == null);
      a(paramIntent);
      return;
    } while (paramInt1 != 1);
  }
  
  public void onBackPressed()
  {
    if (ad.isKeyboardShown(getView().getRootView()))
    {
      k();
      return;
    }
    Intent localIntent;
    if ("offline_push".equals(this.D))
    {
      if (!ad.isMinsuLandlord()) {
        break label65;
      }
      localIntent = new Intent(getActivity(), MinsuLandLordMainNewActivity.class);
    }
    for (;;)
    {
      startActivity(localIntent);
      getActivity().finish();
      return;
      label65:
      localIntent = new Intent(getActivity(), MainActivity.class);
      localIntent.putExtra("FRAGMENT_TYPE", 2);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131694529: 
    default: 
      return;
    case 2131691438: 
      z();
      return;
    case 2131694526: 
      if ((this.N.getVisibility() == 0) && (this.M.getVisibility() == 0))
      {
        a(0);
        return;
      }
      a(5);
      return;
    case 2131694528: 
      j();
      return;
    case 2131694527: 
      y.checkPermis(getActivity(), new String[] { "android.permission.CAMERA" });
      i();
      return;
    case 2131694552: 
      y();
      return;
    }
    x();
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130904894, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.r);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.P);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.s);
    super.onDestroy();
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin  onMessageChanged");
    this.d.refresh();
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
    this.d.refresh();
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
    this.d.refresh();
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin group chat ");
    this.d.refresh();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)paramList.next();
      if (localEMMessage.getTo().equals(this.c))
      {
        this.d.refreshSelectLast();
        ApplicationEx.c.getNotifier().viberateAndPlayTone(localEMMessage);
        com.ziroom.ziroomcustomer.minsu.chat.a.a locala = j.getUserFromMessage(localEMMessage);
        if (locala != null) {
          this.F.putUser(localEMMessage.getFrom(), locala);
        }
      }
      else
      {
        try
        {
          if (!"ZIROOM_ZRY_IM".equals(localEMMessage.getStringAttribute("ziroomFlag", ""))) {
            ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    this.e.markAllMessagesAsRead();
  }
  
  public void onNewIntent()
  {
    d();
    ApplicationEx.c.getNotifier().a();
  }
  
  public void onPause()
  {
    super.onPause();
    this.e.markAllMessagesAsRead();
    w();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.t) {
      this.d.refresh();
    }
    com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(getActivity());
    EMClient.getInstance().chatManager().addMessageListener(this);
    v();
  }
  
  public void onStop()
  {
    super.onStop();
    EMClient.getInstance().chatManager().removeMessageListener(this);
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(getActivity());
    a(0);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    r();
  }
  
  public void resendMessage(EMMessage paramEMMessage)
  {
    paramEMMessage.setStatus(EMMessage.Status.CREATE);
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.d.refresh();
  }
  
  public void setChatFragmentHelper(a parama)
  {
    this.q = parama;
  }
  
  public void showBottomViewNon()
  {
    a(0);
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("groupId");
      if (MinsuGroupChatFragment.this.c.equals(paramContext))
      {
        paramIntent = MinsuGroupChatFragment.this.getActivity().getIntent();
        paramIntent.putExtra("groupId", paramContext);
        MinsuGroupChatFragment.this.getActivity().setResult(-1, paramIntent);
        MinsuGroupChatFragment.this.getActivity().finish();
      }
    }
  }
  
  public class b
    extends PagerAdapter
  {
    private List<MinsuZRYNoticeCMSBean.NoticeBean.LunboBean> b;
    
    public b()
    {
      List localList;
      this.b = localList;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return Integer.MAX_VALUE;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      if ((this.b == null) || (this.b.get(paramInt % this.b.size()) == null)) {
        return paramViewGroup;
      }
      final Object localObject = (MinsuZRYNoticeCMSBean.NoticeBean.LunboBean)this.b.get(paramInt % this.b.size());
      View localView = LayoutInflater.from(MinsuGroupChatFragment.this.getActivity()).inflate(2130904545, null, false);
      TextView localTextView = (TextView)localView.findViewById(2131692028);
      ac.image(MinsuGroupChatFragment.this.getActivity(), localTextView, "target" + "  " + ((MinsuZRYNoticeCMSBean.NoticeBean.LunboBean)localObject).title, "target", 2130840290);
      if (!TextUtils.isEmpty(((MinsuZRYNoticeCMSBean.NoticeBean.LunboBean)localObject).target))
      {
        localView.findViewById(2131694102).setVisibility(0);
        localView.setEnabled(true);
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            com.ziroom.ziroomcustomer.minsu.f.k.goWeb(MinsuGroupChatFragment.this.getActivity(), localObject.target, false, true, localObject.title, true);
          }
        });
      }
      for (;;)
      {
        localObject = localView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localView);
        }
        paramViewGroup.addView(localView);
        return localView;
        localView.findViewById(2131694102).setVisibility(8);
        localView.setEnabled(false);
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */