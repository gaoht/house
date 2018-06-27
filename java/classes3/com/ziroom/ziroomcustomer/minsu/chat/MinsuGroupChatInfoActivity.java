package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMPushManager;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberBaseInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyNickNameActivity;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MinsuGroupChatInfoActivity
  extends BaseActivity
{
  private Context a;
  private com.ziroom.ziroomcustomer.minsu.view.b.a<MinsuChatMemberBaseInfoBean> b;
  private ArrayList<MinsuChatMemberBaseInfoBean> c;
  @BindView(2131691302)
  CheckBox cb_notication;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private String d;
  private String e;
  private String f;
  private int g;
  @BindView(2131691301)
  LinearLayout ll_more_member;
  @BindView(2131691303)
  LinearLayout ll_my_nickname;
  private boolean r;
  @BindView(2131691305)
  RelativeLayout rl_my_portrait;
  @BindView(2131691300)
  RecyclerView rv_member;
  private String s;
  @BindView(2131691306)
  SimpleDraweeView sdv_portrait;
  private CompoundButton.OnCheckedChangeListener t;
  @BindView(2131691307)
  TextView tv_exit_group_chat;
  @BindView(2131690741)
  TextView tv_group_name;
  @BindView(2131691304)
  TextView tv_nickname;
  private BroadcastReceiver u = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getStringExtra("groupId");
      if (MinsuGroupChatInfoActivity.g(MinsuGroupChatInfoActivity.this).equals(paramAnonymousContext))
      {
        paramAnonymousContext = MinsuGroupChatInfoActivity.this.getIntent();
        paramAnonymousContext.putExtra("groupId", MinsuGroupChatInfoActivity.g(MinsuGroupChatInfoActivity.this));
        MinsuGroupChatInfoActivity.this.setResult(-1, paramAnonymousContext);
        MinsuGroupChatInfoActivity.this.finish();
      }
    }
  };
  
  private void a()
  {
    g();
  }
  
  private void a(final boolean paramBoolean)
  {
    if (paramBoolean == f()) {
      return;
    }
    new AsyncTask()
    {
      protected Boolean a(String... paramAnonymousVarArgs)
      {
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramAnonymousVarArgs[0]);
          EMClient.getInstance().pushManager().updatePushServiceForGroup(localArrayList, paramBoolean);
          return Boolean.valueOf(true);
        }
        catch (Exception paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs.printStackTrace();
          if (!TextUtils.isEmpty(paramAnonymousVarArgs.getMessage())) {}
        }
        for (paramAnonymousVarArgs = "log 免打扰设置失败，请重试";; paramAnonymousVarArgs = paramAnonymousVarArgs.getMessage())
        {
          u.e("huanxin", paramAnonymousVarArgs);
          return Boolean.valueOf(false);
        }
      }
      
      protected void a(Boolean paramAnonymousBoolean)
      {
        super.onPostExecute(paramAnonymousBoolean);
        if (paramAnonymousBoolean.booleanValue()) {
          return;
        }
        g.textToast(MinsuGroupChatInfoActivity.this, "免打扰设置失败，请重试");
        MinsuGroupChatInfoActivity.this.cb_notication.setChecked(MinsuGroupChatInfoActivity.h(MinsuGroupChatInfoActivity.this));
      }
      
      protected void onPreExecute()
      {
        super.onPreExecute();
      }
    }.execute(new String[] { this.f });
  }
  
  private void b()
  {
    UserInfo localUserInfo = ((ApplicationEx)getApplication()).getUser();
    if (localUserInfo != null)
    {
      this.sdv_portrait.setHierarchy(d.getRoundingHierarchy(ApplicationEx.c));
      this.sdv_portrait.setController(com.freelxl.baselibrary.f.c.frescoController(localUserInfo.getHead_img()));
      if (TextUtils.isEmpty(localUserInfo.getNickName())) {
        break label84;
      }
      this.s = localUserInfo.getNickName();
    }
    while (TextUtils.isEmpty(this.s))
    {
      this.tv_nickname.setText(getString(2131297329));
      return;
      label84:
      if (!TextUtils.isEmpty(localUserInfo.getPhone())) {
        this.s = localUserInfo.getPhone();
      } else if (!TextUtils.isEmpty(localUserInfo.getEmail())) {
        this.s = localUserInfo.getEmail();
      }
    }
    this.tv_nickname.setText(this.s);
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      this.tv_group_name.setText(this.e);
      if (this.g < 20) {
        break label127;
      }
      this.ll_more_member.setVisibility(0);
    }
    for (;;)
    {
      this.rv_member.setLayoutManager(new GridLayoutManager(this, 5, 1, false));
      this.rv_member.setNestedScrollingEnabled(false);
      if (this.r) {
        this.tv_exit_group_chat.setVisibility(8);
      }
      this.cb_notication.setChecked(f());
      this.t = new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this, paramAnonymousBoolean);
        }
      };
      this.cb_notication.setOnCheckedChangeListener(this.t);
      return;
      this.tv_group_name.setText("群聊");
      break;
      label127:
      this.ll_more_member.setVisibility(8);
    }
  }
  
  private boolean f()
  {
    List localList = EMClient.getInstance().pushManager().getNoPushGroups();
    if (localList == null) {
      return false;
    }
    return localList.contains(this.f);
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryGroupUserInfo(this, this.f, 1, new s(this, new r(MinsuChatMemberListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuGroupChatInfoActivity.this.rv_member.setVisibility(8);
        g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "获取成员列表失败");
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuChatMemberListBean paramAnonymousMinsuChatMemberListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuChatMemberListBean);
        if ((paramAnonymousMinsuChatMemberListBean != null) && ("0".equals(paramAnonymousMinsuChatMemberListBean.getStatus())))
        {
          MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this, (ArrayList)paramAnonymousMinsuChatMemberListBean.getData().getListUserInfo());
          if ((MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this) != null) && (MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this).size() > 0))
          {
            MinsuGroupChatInfoActivity.this.rv_member.setVisibility(0);
            MinsuGroupChatInfoActivity.b(MinsuGroupChatInfoActivity.this);
            return;
          }
          MinsuGroupChatInfoActivity.this.rv_member.setVisibility(8);
          g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "暂时还没有群成员");
          return;
        }
        if (paramAnonymousMinsuChatMemberListBean != null)
        {
          MinsuGroupChatInfoActivity.this.rv_member.setVisibility(8);
          g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), paramAnonymousMinsuChatMemberListBean.getMessage());
          return;
        }
        MinsuGroupChatInfoActivity.this.rv_member.setVisibility(8);
        g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "获取成员列表失败");
      }
    });
  }
  
  private void h()
  {
    this.b = new com.ziroom.ziroomcustomer.minsu.view.b.a(this, 2130904300, this.c)
    {
      public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramAnonymousc, MinsuChatMemberBaseInfoBean paramAnonymousMinsuChatMemberBaseInfoBean, int paramAnonymousInt)
      {
        paramAnonymousc.setText(2131695245, paramAnonymousMinsuChatMemberBaseInfoBean.getNickName());
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramAnonymousc.getView(2131695244);
        localSimpleDraweeView.setHierarchy(d.getRoundingHierarchy(ApplicationEx.c));
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuChatMemberBaseInfoBean.getHeadImg()));
        paramAnonymousc.setTag(2131690233, paramAnonymousMinsuChatMemberBaseInfoBean);
        paramAnonymousc.setOnClickListener(2131690233, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
          }
        });
      }
      
      public int getItemCount()
      {
        if ((MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this) != null) && (MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this).size() >= 20)) {
          return 20;
        }
        if (MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this) != null) {
          return MinsuGroupChatInfoActivity.a(MinsuGroupChatInfoActivity.this).size();
        }
        return 0;
      }
    };
    this.b.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt) {}
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    this.rv_member.setAdapter(this.b);
  }
  
  private void i()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.exitGroup(this, this.f, this.d, new s(this, new com.freelxl.baselibrary.d.f.e())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "退出群聊失败");
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          if ("0".equals(paramAnonymousString.getString("status")))
          {
            g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "退出群聊成功");
            MinsuGroupChatInfoActivity.this.setResult(-1);
            MinsuGroupChatInfoActivity.this.finish();
            return;
          }
          g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), paramAnonymousString.getString("message"));
          return;
        }
        g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), "退出群聊失败");
      }
    });
  }
  
  private void j()
  {
    IntentFilter localIntentFilter = new IntentFilter("im_exit_group");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.u, localIntentFilter);
  }
  
  private void k()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.u);
  }
  
  public void initTitle()
  {
    this.commonTitle.setLeftButtonType(0);
    CommonTitle localCommonTitle = this.commonTitle;
    if (this.g == 0) {}
    for (String str = "聊天信息";; str = "聊天信息 (" + this.g + "人)")
    {
      localCommonTitle.setMiddleText(str);
      this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuGroupChatInfoActivity.this.finish();
        }
      });
      this.commonTitle.setBottomLineVisible(true);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("path");
    } while (TextUtils.isEmpty(paramIntent));
    j.headImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this.a), new File(paramIntent), new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        g.textToast(MinsuGroupChatInfoActivity.c(MinsuGroupChatInfoActivity.this), MinsuGroupChatInfoActivity.this.getString(2131297263));
        paramAnonymouse = paramAnonymouse.getString("url");
        ApplicationEx.c.getUser().setHeadImg(paramAnonymouse);
        MinsuGroupChatInfoActivity.e(MinsuGroupChatInfoActivity.this);
        MinsuGroupChatInfoActivity.f(MinsuGroupChatInfoActivity.this);
      }
    });
  }
  
  @OnClick({2131691301, 2131691303, 2131691305, 2131691307})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131691302: 
    case 2131691304: 
    case 2131691306: 
    default: 
      return;
    case 2131691301: 
      paramView = new Intent(this.a, MinsuGroupChatMembersActivity.class);
      paramView.putExtra("groupId", this.f);
      paramView.putExtra("count", this.g);
      paramView.putParcelableArrayListExtra("members", this.c);
      startActivity(paramView);
      return;
    case 2131691303: 
      b("nickname");
      paramView = new Intent();
      paramView.setClass(this, MyNickNameActivity.class);
      if (((ApplicationEx)getApplication()).getUser() != null) {
        paramView.putExtra("nickname", this.s);
      }
      startActivity(paramView);
      overridePendingTransition(2130968681, 2130968686);
      return;
    case 2131691305: 
      startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, true, 200, 200), 1);
      return;
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent(getResources().getString(2131297082)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          MinsuGroupChatInfoActivity.d(MinsuGroupChatInfoActivity.this);
        }
      }
    }).build().show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903276);
    this.a = this;
    ButterKnife.bind(this);
    paramBundle = getIntent();
    this.f = paramBundle.getStringExtra("groupId");
    this.d = paramBundle.getStringExtra("projectBid");
    this.g = paramBundle.getIntExtra("count", 0);
    this.e = paramBundle.getStringExtra("groupName");
    this.r = paramBundle.getBooleanExtra("isOwner", false);
    initTitle();
    e();
    a();
    j();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    k();
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */