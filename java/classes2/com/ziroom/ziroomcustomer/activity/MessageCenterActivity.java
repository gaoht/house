package com.ziroom.ziroomcustomer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.a.c;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatActivity;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatListView;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuGroupChatActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.model.SysMessageOnlineModel.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialFriendListActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.List;

public class MessageCenterActivity
  extends BaseActivity
{
  private a A;
  private b B;
  public UserInfo a;
  protected List<EMConversation> b = new ArrayList();
  protected MinsuChatListView c;
  protected BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MessageCenterActivity.this.refresh();
    }
  };
  private boolean e;
  private int f = 0;
  private int g;
  @BindView(2131691181)
  ImageView ivSysMessNewSign;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131691174)
  TextView minsuServiceRedPointNum;
  private EMConversation r;
  @BindView(2131691167)
  RelativeLayout rlChatLine;
  @BindView(2131691171)
  RelativeLayout rlChatMisu;
  @BindView(2131691176)
  RelativeLayout rlSysMess;
  @BindView(2131691182)
  RelativeLayout rl_mess_center_meeta_mess;
  private EMConversation s;
  private ScrollView t;
  @BindView(2131691173)
  TextView tvChatMinsu;
  @BindView(2131691180)
  TextView tvChatSysMess;
  @BindView(2131691168)
  TextView tvChatZiru;
  @BindView(2131691186)
  TextView tv_chat_meeta_mess;
  @BindView(2131691187)
  TextView tv_meeta_mess_new_sign;
  private Context u;
  private SysMessReceiver v;
  private int w = 2;
  private int x = 0;
  private EMMessageListener y;
  private c z;
  @BindView(2131691169)
  TextView ziruServiceRedPointNum;
  
  private void a(int paramInt, TextView paramTextView)
  {
    if (paramInt <= 99) {
      paramTextView.setText(paramInt + "");
    }
    while (paramTextView.getText().toString().trim().length() <= 1)
    {
      paramTextView.setBackgroundResource(2130839386);
      return;
      paramTextView.setText("99+");
    }
    paramTextView.setBackgroundResource(2130837779);
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter("action_sync_im_succ");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.d, localIntentFilter);
    this.z = new c(null);
    localIntentFilter = new IntentFilter(getString(2131296571));
    LocalBroadcastManager.getInstance(this).registerReceiver(this.z, localIntentFilter);
    this.A = new a(null);
    localIntentFilter = new IntentFilter("im_group_member_changed");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.A, localIntentFilter);
    this.B = new b(null);
    localIntentFilter = new IntentFilter("im_groups_chaned");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.B, localIntentFilter);
  }
  
  private boolean f()
  {
    this.e = ApplicationEx.c.isLoginState();
    if (!this.e) {
      return true;
    }
    this.a = ApplicationEx.c.getUser();
    this.f = ApplicationEx.c.getUnReadNum();
    this.g = ApplicationEx.c.getMisuNum();
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.r = EMClient.getInstance().chatManager().getConversation("ms_ziroom");
      this.s = EMClient.getInstance().chatManager().getConversation("ziroomerPro");
    }
    label144:
    Object localObject;
    if (this.f > 0)
    {
      this.ziruServiceRedPointNum.setVisibility(0);
      a(this.f, this.ziruServiceRedPointNum);
      if (this.g <= 0) {
        break label276;
      }
      this.minsuServiceRedPointNum.setVisibility(0);
      a(this.g, this.minsuServiceRedPointNum);
      if (this.s != null)
      {
        localObject = this.s.getLastMessage();
        if (localObject != null)
        {
          if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
            break label311;
          }
          localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
          if ((localObject != null) && (!TextUtils.isEmpty(((EMTextMessageBody)localObject).getMessage()))) {
            break label288;
          }
          this.tvChatZiru.setText("点击查看你与客服的沟通记录");
        }
      }
      label205:
      if (this.r != null)
      {
        localObject = this.r.getLastMessage();
        if (localObject != null)
        {
          if (((EMMessage)localObject).getType() != EMMessage.Type.TXT) {
            break label347;
          }
          localObject = (EMTextMessageBody)((EMMessage)localObject).getBody();
          if (!TextUtils.isEmpty(((EMTextMessageBody)localObject).getMessage())) {
            break label324;
          }
          this.tvChatMinsu.setText("民宿相关问题沟通记录");
        }
      }
    }
    for (;;)
    {
      return false;
      this.ziruServiceRedPointNum.setVisibility(8);
      break;
      label276:
      this.minsuServiceRedPointNum.setVisibility(8);
      break label144;
      label288:
      localObject = SmileUtils.getSmiledText(this, ((EMTextMessageBody)localObject).getMessage());
      this.tvChatZiru.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      break label205;
      label311:
      this.tvChatZiru.setText("点击查看你与客服的沟通记录");
      break label205;
      label324:
      localObject = SmileUtils.getSmiledText(this, ((EMTextMessageBody)localObject).getMessage());
      this.tvChatMinsu.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      continue;
      label347:
      this.tvChatMinsu.setText("民宿相关问题沟通记录");
    }
  }
  
  private void g()
  {
    this.t = ((ScrollView)findViewById(2131689567));
    this.t.post(new Runnable()
    {
      public void run()
      {
        MessageCenterActivity.a(MessageCenterActivity.this).fullScroll(33);
      }
    });
  }
  
  private void h()
  {
    this.f = ApplicationEx.c.getUnReadNum();
    this.g = ApplicationEx.c.getMisuNum();
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.r = EMClient.getInstance().chatManager().getConversation("ms_ziroom");
      this.s = EMClient.getInstance().chatManager().getConversation("ziroomerPro");
    }
    Object localObject1;
    if (this.f > 0)
    {
      this.ziruServiceRedPointNum.setVisibility(0);
      a(this.f, this.ziruServiceRedPointNum);
      localObject1 = (TextView)findViewById(2131691174);
      if (this.g <= 0) {
        break label264;
      }
      ((TextView)localObject1).setVisibility(0);
      a(this.g, (TextView)localObject1);
      label119:
      if (this.s != null)
      {
        localObject1 = this.s.getLastMessage();
        if (localObject1 == null) {
          break label309;
        }
        if (((EMMessage)localObject1).getType() != EMMessage.Type.TXT) {
          break label296;
        }
        localObject1 = (EMTextMessageBody)((EMMessage)localObject1).getBody();
        if ((localObject1 != null) && (!TextUtils.isEmpty(((EMTextMessageBody)localObject1).getMessage()))) {
          break label273;
        }
        this.tvChatZiru.setText("点击查看你与客服的沟通记录");
        label180:
        this.tvChatZiru.postInvalidate();
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = (TextView)findViewById(2131691173);
      if (this.r != null)
      {
        localObject2 = this.r.getLastMessage();
        if (localObject2 == null) {
          break label346;
        }
        if (((EMMessage)localObject2).getType() != EMMessage.Type.TXT) {
          break label338;
        }
        localObject2 = (EMTextMessageBody)((EMMessage)localObject2).getBody();
        if (!TextUtils.isEmpty(((EMTextMessageBody)localObject2).getMessage())) {
          break label322;
        }
        ((TextView)localObject1).setText("民宿相关问题沟通记录");
      }
      return;
      this.ziruServiceRedPointNum.setVisibility(8);
      break;
      label264:
      ((TextView)localObject1).setVisibility(8);
      break label119;
      label273:
      localObject1 = SmileUtils.getSmiledText(this, ((EMTextMessageBody)localObject1).getMessage());
      this.tvChatZiru.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      break label180;
      label296:
      this.tvChatZiru.setText("点击查看你与客服的沟通记录");
      break label180;
      label309:
      this.tvChatZiru.setText("点击查看你与客服的沟通记录");
    }
    label322:
    ((TextView)localObject1).setText(SmileUtils.getSmiledText(this, ((EMTextMessageBody)localObject2).getMessage()), TextView.BufferType.SPANNABLE);
    return;
    label338:
    ((TextView)localObject1).setText("民宿相关问题沟通记录");
    return;
    label346:
    ((TextView)localObject1).setText("民宿相关问题沟通记录");
  }
  
  private void i()
  {
    this.c = ((MinsuChatListView)findViewById(2131691188));
    a();
  }
  
  private void j()
  {
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (com.ziroom.ziroomcustomer.social.b.d.isZzHaveConversations())
    {
      this.rl_mess_center_meeta_mess.setVisibility(0);
      if (com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMessageNum() <= 0) {
        break label118;
      }
      this.tv_chat_meeta_mess.setVisibility(0);
      a(com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMessageNum(), this.tv_meeta_mess_new_sign);
      this.tv_meeta_mess_new_sign.setVisibility(0);
      localTextView = this.tv_chat_meeta_mess;
      localStringBuilder = new StringBuilder().append("您有");
      if (com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMessageNum() <= 99) {
        break label108;
      }
    }
    label108:
    for (Object localObject = "99+";; localObject = Integer.valueOf(com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMessageNum()))
    {
      localTextView.setText(localObject + "条新消息");
      return;
      this.rl_mess_center_meeta_mess.setVisibility(8);
      break;
    }
    label118:
    this.tv_chat_meeta_mess.setText("与Meeta好友聊天");
    this.tv_meeta_mess_new_sign.setVisibility(8);
  }
  
  private void k()
  {
    this.minsuServiceRedPointNum.setVisibility(8);
    ApplicationEx.c.setMisuNum(0);
    k.contactIM(this);
    w.onEvent(this, "personalcenter_message_Mcs");
  }
  
  private void l()
  {
    if (this.a != null)
    {
      this.a.getUid();
      f.getUnreadNum(this, new com.freelxl.baselibrary.d.c.a(new m(com.alibaba.fastjson.e.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          MessageCenterActivity.this.ivSysMessNewSign.setVisibility(4);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
          if (paramAnonymouse != null)
          {
            MessageCenterActivity.a(MessageCenterActivity.this, paramAnonymouse.getInteger("unread").intValue());
            com.freelxl.baselibrary.f.d.d("OKHttp", "Push getUnreadNum resp: " + MessageCenterActivity.c(MessageCenterActivity.this));
            if (MessageCenterActivity.c(MessageCenterActivity.this) > 0)
            {
              MessageCenterActivity.this.ivSysMessNewSign.setVisibility(0);
              return;
            }
            MessageCenterActivity.this.ivSysMessNewSign.setVisibility(4);
            return;
          }
          MessageCenterActivity.this.ivSysMessNewSign.setVisibility(4);
        }
      }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(this, com.ziroom.ziroomcustomer.service.d.a, h.toMd5(this.a.getUid().getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(this)));
      f.syncMessages(this, new com.freelxl.baselibrary.d.c.a(new l(SysMessageOnlineModel.DataBean.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, List<SysMessageOnlineModel.DataBean> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            TextView localTextView = MessageCenterActivity.this.tvChatSysMess;
            if (ae.isNull(((SysMessageOnlineModel.DataBean)paramAnonymousList.get(0)).content)) {}
            for (paramAnonymousList = "消息内容为空";; paramAnonymousList = ((SysMessageOnlineModel.DataBean)paramAnonymousList.get(0)).content)
            {
              localTextView.setText(paramAnonymousList);
              return;
            }
          }
          MessageCenterActivity.this.tvChatSysMess.setText("暂无系统消息");
        }
      }, com.ziroom.ziroomcustomer.service.d.buildSyncMessages(this, com.ziroom.ziroomcustomer.service.d.a, h.toMd5(this.a.getUid().getBytes()), 1, 1));
    }
  }
  
  protected void a()
  {
    EMClient.getInstance().chatManager().loadAllConversations();
    this.b.addAll(com.ziroom.ziroomcustomer.minsu.chat.j.loadConversationList(2));
    this.c.init(this.b);
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView = MessageCenterActivity.this.c.getItem(paramAnonymousInt);
        if (!com.ziroom.commonlibrary.login.a.getLoginState(MessageCenterActivity.this))
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(MessageCenterActivity.this);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousView.conversationId();
        if (paramAnonymousAdapterView.equals(EMClient.getInstance().getCurrentUser()))
        {
          g.textToast(MessageCenterActivity.this, MessageCenterActivity.this.getString(2131296555));
          return;
        }
        if (paramAnonymousView.getType() == EMConversation.EMConversationType.GroupChat)
        {
          paramAnonymousView = new Intent(MessageCenterActivity.this, MinsuGroupChatActivity.class);
          paramAnonymousView.putExtra("userId", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("msgSenderType", MessageCenterActivity.b(MessageCenterActivity.this));
          MessageCenterActivity.this.startActivity(paramAnonymousView);
          return;
        }
        paramAnonymousView = new Intent(MessageCenterActivity.this, MinsuChatActivity.class);
        paramAnonymousView.putExtra("userId", paramAnonymousAdapterView);
        paramAnonymousView.putExtra("msgSenderType", MessageCenterActivity.b(MessageCenterActivity.this));
        MessageCenterActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.c.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
  }
  
  protected void b()
  {
    if (this.y == null) {
      this.y = new EMMessageListener()
      {
        public void onCmdMessageReceived(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageChanged(EMMessage paramAnonymousEMMessage, Object paramAnonymousObject) {}
        
        public void onMessageDelivered(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageRead(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageRecalled(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageReceived(List<EMMessage> paramAnonymousList)
        {
          com.freelxl.baselibrary.f.d.i("huanxin", " MessageCenterActivity  on MessRece ");
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              MessageCenterActivity.this.refreshCustomerService();
              MessageCenterActivity.this.refresh();
            }
          });
        }
      };
    }
    EMClient.getInstance().chatManager().addMessageListener(this.y);
  }
  
  public void initData()
  {
    b();
    j();
  }
  
  public void initView()
  {
    this.e = ApplicationEx.c.isLoginState();
    if (!this.e) {
      return;
    }
    f();
  }
  
  @OnClick({2131691167, 2131691171, 2131691176, 2131691182})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.e = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691182: 
      startActivity(new Intent(this, ZzSocialFriendListActivity.class));
      return;
    case 2131691167: 
      startActivity(new Intent(this, ChatWebViewActivity.class));
      return;
    case 2131691171: 
      k();
      return;
    }
    this.ivSysMessNewSign.setVisibility(4);
    startActivity(new Intent(this, SysMessageActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903256);
    this.u = this;
    ButterKnife.bind(this);
    this.mBztb.setTitle("消息中心");
    initData();
    e();
    registerMessageReceiver();
    this.e = ApplicationEx.c.isLoginState();
    if (!this.e) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    g();
    i();
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.v);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.z);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.A);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.B);
    EMClient.getInstance().chatManager().removeMessageListener(this.y);
    super.onDestroy();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    j();
  }
  
  public void onResume()
  {
    super.onResume();
    initView();
    refresh();
    l();
    if (this.y != null) {
      EMClient.getInstance().chatManager().addMessageListener(this.y);
    }
    com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(this);
  }
  
  public void onStop()
  {
    super.onStop();
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(this);
  }
  
  public void refresh()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        MessageCenterActivity.this.b.clear();
        MessageCenterActivity.this.b.addAll(com.ziroom.ziroomcustomer.minsu.chat.j.loadConversationList(2));
        if (MessageCenterActivity.this.c != null) {
          MessageCenterActivity.this.c.refresh();
        }
      }
    });
  }
  
  public void refreshCustomerService()
  {
    this.e = ApplicationEx.c.isLoginState();
    if (!this.e) {
      return;
    }
    this.a = ApplicationEx.c.getUser();
    h();
  }
  
  public void registerMessageReceiver()
  {
    this.v = new SysMessReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.setPriority(1000);
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION");
    registerReceiver(this.v, localIntentFilter);
  }
  
  public class SysMessReceiver
    extends BroadcastReceiver
  {
    public SysMessReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION".equals(paramIntent.getAction())) {
        MessageCenterActivity.d(MessageCenterActivity.this);
      }
    }
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MessageCenterActivity.this.refresh();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MessageCenterActivity.this.refresh();
    }
  }
  
  private class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MessageCenterActivity.e(MessageCenterActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/MessageCenterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */