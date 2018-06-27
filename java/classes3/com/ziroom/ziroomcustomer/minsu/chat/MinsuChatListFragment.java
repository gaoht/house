package com.ziroom.ziroomcustomer.minsu.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.activity.SysMessageActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.c;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.model.SysMessageOnlineModel.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import java.util.ArrayList;
import java.util.List;

public class MinsuChatListFragment
  extends BaseFragment
  implements View.OnClickListener, EMMessageListener
{
  protected boolean a = false;
  protected boolean b;
  protected List<EMConversation> c = new ArrayList();
  protected MinsuChatListView d;
  public UserInfo e;
  protected boolean f;
  BadgeView g;
  ImageView h;
  TextView i;
  TextView j;
  int k = 0;
  public BroadcastReceiver l = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuChatListFragment.this.refresh();
    }
  };
  private CommonTitle m;
  private int n;
  private EMConversation o;
  private SysMessReceiver p;
  private InputMethodManager q;
  private int r = 1;
  private a s;
  private b t;
  
  private void f()
  {
    this.g.setVisibility(4);
    ApplicationEx.c.setMisuNum(0);
    k.contactIM((BaseActivity)getActivity());
    w.onEvent(getActivity(), "personalcenter_message_Mcs");
  }
  
  private void g()
  {
    try
    {
      f.getUnreadNum(getContext(), new com.freelxl.baselibrary.d.c.a(new m(com.alibaba.fastjson.e.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          MinsuChatListFragment.this.h.setVisibility(4);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
          if (paramAnonymouse != null)
          {
            MinsuChatListFragment.this.k = paramAnonymouse.getInteger("unread").intValue();
            com.freelxl.baselibrary.f.d.d("OKHttp", "Push resp sysMessNum: " + MinsuChatListFragment.this.k);
            if (MinsuChatListFragment.this.k > 0)
            {
              MinsuChatListFragment.this.h.setVisibility(0);
              return;
            }
            MinsuChatListFragment.this.h.setVisibility(4);
            return;
          }
          MinsuChatListFragment.this.h.setVisibility(4);
        }
      }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(getActivity(), com.ziroom.ziroomcustomer.service.d.a, h.toMd5(com.ziroom.ziroomcustomer.minsu.e.d.getUid().getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(getActivity())));
      f.syncMessages(getContext(), new com.freelxl.baselibrary.d.c.a(new l(SysMessageOnlineModel.DataBean.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, List<SysMessageOnlineModel.DataBean> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            TextView localTextView = MinsuChatListFragment.this.j;
            if (ae.isNull(((SysMessageOnlineModel.DataBean)paramAnonymousList.get(0)).content)) {}
            for (paramAnonymousList = "消息内容为空";; paramAnonymousList = ((SysMessageOnlineModel.DataBean)paramAnonymousList.get(0)).content)
            {
              localTextView.setText(paramAnonymousList);
              return;
            }
          }
          MinsuChatListFragment.this.j.setText("暂无系统消息");
        }
      }, com.ziroom.ziroomcustomer.service.d.buildSyncMessages(getActivity(), com.ziroom.ziroomcustomer.service.d.a, h.toMd5(com.ziroom.ziroomcustomer.minsu.e.d.getUid().getBytes()), 1, 1));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin info", " e = " + localException.getMessage());
    }
  }
  
  private void h()
  {
    try
    {
      boolean bool = EMClient.getInstance().isLoggedInBefore();
      if (!bool) {
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.e = ApplicationEx.c.getUser();
      this.o = EMClient.getInstance().chatManager().getConversation("ms_ziroom");
      int i1;
      if (this.o == null)
      {
        i1 = 0;
        this.n = i1;
        if (this.n <= 0) {
          break label170;
        }
        this.g.setVisibility(0);
        this.g.setText(this.n + "");
      }
      for (;;)
      {
        if (this.o == null) {
          break label217;
        }
        localObject = this.o.getLastMessage();
        if (localObject == null) {
          break label217;
        }
        if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
          break label206;
        }
        localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
        if (!TextUtils.isEmpty(((EMTextMessageBody)localObject).getMessage())) {
          break label182;
        }
        this.i.setText("民宿相关问题沟通记录");
        return;
        i1 = this.o.getUnreadMsgCount();
        break;
        label170:
        this.g.setVisibility(8);
      }
      label182:
      Object localObject = SmileUtils.getSmiledText(getActivity(), ((EMTextMessageBody)localObject).getMessage());
      this.i.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      return;
    }
    label206:
    this.i.setText("民宿相关问题沟通记录");
    return;
    label217:
    this.i.setText("民宿相关问题沟通记录");
  }
  
  private void i()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.l);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.t);
    getActivity().unregisterReceiver(this.p);
  }
  
  protected void c()
  {
    this.g = ((BadgeView)getView().findViewById(2131696861));
    this.h = ((ImageView)getView().findViewById(2131691181));
    this.i = ((TextView)getView().findViewById(2131691173));
    this.j = ((TextView)getView().findViewById(2131691180));
    getView().findViewById(2131691171).setOnClickListener(this);
    getView().findViewById(2131691176).setOnClickListener(this);
    this.q = ((InputMethodManager)getActivity().getSystemService("input_method"));
    this.d = ((MinsuChatListView)getView().findViewById(2131689522));
    this.r = getArguments().getInt("customerType", 1);
    initTitle();
  }
  
  protected void d()
  {
    this.d.init(this.c);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (MinsuChatListFragment.a(MinsuChatListFragment.this) != null)
        {
          paramAnonymousAdapterView = MinsuChatListFragment.this.d.getItem(paramAnonymousInt);
          MinsuChatListFragment.a(MinsuChatListFragment.this).onListItemClicked(paramAnonymousAdapterView);
        }
      }
    });
    this.d.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        MinsuChatListFragment.this.e();
        return false;
      }
    });
    setConversationListItemClickListener(new a()
    {
      public void onListItemClicked(EMConversation paramAnonymousEMConversation)
      {
        if (!com.ziroom.commonlibrary.login.a.getLoginState(MinsuChatListFragment.this.getActivity()))
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(MinsuChatListFragment.this.getActivity());
          return;
        }
        paramAnonymousEMConversation = paramAnonymousEMConversation.getLastMessage().getUserName();
        if (paramAnonymousEMConversation.equals(EMClient.getInstance().getCurrentUser()))
        {
          g.textToast(MinsuChatListFragment.this.getActivity(), MinsuChatListFragment.this.getActivity().getString(2131296555));
          return;
        }
        Intent localIntent = new Intent(MinsuChatListFragment.this.getActivity(), MinsuChatActivity.class);
        localIntent.putExtra("userId", paramAnonymousEMConversation);
        localIntent.putExtra("msgSenderType", MinsuChatListFragment.b(MinsuChatListFragment.this));
        MinsuChatListFragment.this.startActivity(localIntent);
      }
    });
  }
  
  protected void e()
  {
    if ((getActivity().getWindow().getAttributes().softInputMode != 2) && (getActivity().getCurrentFocus() != null)) {
      this.q.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  public void initTitle()
  {
    this.m = ((CommonTitle)getView().findViewById(2131691272));
    this.m.setLeftButtonType(0);
    this.m.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuChatListFragment.this.getActivity().finish();
      }
    });
    this.m.showRightIc(false, 2130838560);
    this.m.setMiddleText("我的消息");
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isConflict", false))) {
      return;
    }
    super.onActivityCreated(paramBundle);
    c();
    try
    {
      if (EMClient.getInstance().isLoggedInBefore()) {
        new Thread(new Runnable()
        {
          public void run()
          {
            EMClient.getInstance().chatManager().loadAllConversations();
          }
        }).start();
      }
      for (;;)
      {
        d();
        registerMessageReceiver();
        return;
        com.ziroom.ziroomcustomer.newchat.a.register(getActivity());
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691171: 
      f();
      return;
    }
    startActivity(new Intent(getActivity(), SysMessageActivity.class));
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e(" huanxin ");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130904892, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    i();
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.b = paramBoolean;
    if ((!paramBoolean) && (!this.f)) {
      refresh();
    }
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e(" huanxin ");
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e(" huanxin ");
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e(" huanxin ");
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e(" huanxin ");
    refresh();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.b) {
      refresh();
    }
    com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(getActivity());
    EMClient.getInstance().chatManager().addMessageListener(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.f) {
      paramBundle.putBoolean("isConflict", true);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    EMClient.getInstance().chatManager().removeMessageListener(this);
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(getActivity());
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if (paramBoolean)
    {
      refresh();
      g();
      h();
    }
  }
  
  public void refresh()
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 对话列表 刷新数据");
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        MinsuChatListFragment.this.c.clear();
        MinsuChatListFragment.this.c.addAll(j.loadConversationList(MinsuChatListFragment.b(MinsuChatListFragment.this)));
        MinsuChatListFragment.this.d.refresh();
      }
    });
  }
  
  public void registerMessageReceiver()
  {
    this.p = new SysMessReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.setPriority(1000);
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION");
    getActivity().registerReceiver(this.p, localIntentFilter);
    localIntentFilter = new IntentFilter("action_sync_im_succ");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.l, localIntentFilter);
    this.t = new b(null);
    localIntentFilter = new IntentFilter(getString(2131296571));
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.t, localIntentFilter);
  }
  
  public void setConversationListItemClickListener(a parama)
  {
    this.s = parama;
  }
  
  public class SysMessReceiver
    extends BroadcastReceiver
  {
    public SysMessReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION".equals(paramIntent.getAction())) {
        MinsuChatListFragment.c(MinsuChatListFragment.this);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onListItemClicked(EMConversation paramEMConversation);
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MinsuChatListFragment.c(MinsuChatListFragment.this);
      MinsuChatListFragment.d(MinsuChatListFragment.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */