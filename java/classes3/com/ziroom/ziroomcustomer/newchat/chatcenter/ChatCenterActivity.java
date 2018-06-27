package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.model.SysMessageOnlineModel.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.g;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.ChartAndHelpFristPaperGroup;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.ChartAndHelpFristPaperGroup.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatCenterActivity
  extends BaseActivity
{
  private int a = 1;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  @BindView(2131689744)
  ImageView img;
  @BindView(2131690159)
  ImageView ivArraw1;
  @BindView(2131690163)
  ImageView ivArraw2;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690152)
  SimpleDraweeView ivChartIcon;
  @BindView(2131689813)
  LinearLayout llQuestion;
  @BindView(2131690155)
  LinearLayout llServiceForm;
  @BindView(2131690156)
  LinearLayout llServiceMessage1;
  @BindView(2131690160)
  LinearLayout llServiceMessage2;
  @BindView(2131690144)
  ImageView myinfoChat;
  @BindView(2131690145)
  ImageView myinfoChatRedPoint;
  @BindView(2131690146)
  TextView myinfoChatRedPointNum;
  @BindView(2131690151)
  RelativeLayout rlMumu;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131690153)
  TextView tvChartContent;
  @BindView(2131690164)
  TextView tvExchange;
  @BindView(2131690165)
  TextView tvNoServiceQuestion;
  @BindView(2131690154)
  TextView tvNoServiceTable;
  @BindView(2131690158)
  TextView tvServiceContent1;
  @BindView(2131690162)
  TextView tvServiceContent2;
  @BindView(2131690157)
  TextView tvServiceTime1;
  @BindView(2131690161)
  TextView tvServiceTime2;
  @BindView(2131690148)
  TextView tvToMumu;
  @BindView(2131690147)
  View view;
  
  private List<com.ziroom.commonlibrary.c.b> a(List<SysMessageOnlineModel.DataBean> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      if (i < paramList.size())
      {
        com.ziroom.commonlibrary.c.b localb = new com.ziroom.commonlibrary.c.b();
        localb.b = this.g;
        localb.d = ((SysMessageOnlineModel.DataBean)paramList.get(i)).content;
        localb.e = ((SysMessageOnlineModel.DataBean)paramList.get(i)).title;
        localb.f = ((SysMessageOnlineModel.DataBean)paramList.get(i)).extras;
        com.alibaba.fastjson.e locale = com.alibaba.fastjson.e.parseObject(localb.f);
        for (;;)
        {
          try
          {
            localb.g = locale.getString("msg_body_type");
            localb.h = locale.getString("msg_sub_type");
            if (!ae.isNull(locale.getString("msg_tag_type"))) {
              continue;
            }
            j = 0;
            localb.i = j;
            localb.j = locale.getString("msg_backup");
            localb.k = locale.getString("push_time");
            localb.c = locale.getString("msgId");
          }
          catch (Exception localException)
          {
            int j;
            continue;
          }
          localb.m = ((SysMessageOnlineModel.DataBean)paramList.get(i)).isRead;
          localb.o = ((SysMessageOnlineModel.DataBean)paramList.get(i)).sendTime;
          if (localb.m == 0) {
            localArrayList2.add(localb.c);
          }
          localArrayList1.add(localb);
          i += 1;
          break;
          j = Integer.parseInt(locale.getString("msg_tag_type"));
        }
      }
    }
    return localArrayList1;
  }
  
  private void a()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    Object localObject = ApplicationEx.c.getUser().getNickName();
    this.g = ApplicationEx.c.getUser().getUid();
    this.tvChartContent.setText("Hi," + (String)localObject + "");
    com.ziroom.ziroomcustomer.e.n.getSelfForm(this, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.e(g.class))
    {
      public void onSuccess(int paramAnonymousInt, List<g> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList == null) {}
        for (;;)
        {
          return;
          ChatCenterActivity.this.tvNoServiceTable.setVisibility(8);
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            final g localg = (g)paramAnonymousList.next();
            if ((!com.freelxl.baselibrary.f.f.isNull(localg.getImageUrl())) && (!com.freelxl.baselibrary.f.f.isNull(localg.getFormName())) && (!com.freelxl.baselibrary.f.f.isNull(localg.getFormUrl())))
            {
              SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(ChatCenterActivity.this);
              Object localObject = new LinearLayout.LayoutParams(ah.dip2px(ChatCenterActivity.this, 72.0F), ah.dip2px(ChatCenterActivity.this, 72.0F));
              ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, ah.dip2px(ChatCenterActivity.this, 12.0F), 0);
              localSimpleDraweeView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              localObject = new GenericDraweeHierarchyBuilder(ChatCenterActivity.this.getResources()).setFadeDuration(300).build();
              RoundingParams localRoundingParams = new RoundingParams();
              localRoundingParams.setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(ChatCenterActivity.this, 2.0F));
              ((GenericDraweeHierarchy)localObject).setRoundingParams(localRoundingParams);
              localSimpleDraweeView.setHierarchy((DraweeHierarchy)localObject);
              localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(localg.getImageUrl()));
              localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  com.ziroom.ziroomcustomer.newchat.chatcenter.c.a.ToAotherActivity(ChatCenterActivity.this, localg);
                }
              });
              ChatCenterActivity.this.llServiceForm.addView(localSimpleDraweeView);
            }
          }
        }
      }
    });
    final long l = Calendar.getInstance().getTimeInMillis();
    localObject = new HashMap();
    ((Map)localObject).put("app", "ZRK_APP");
    ((Map)localObject).put("alias", ah.toMd5(this.g.getBytes()));
    ((Map)localObject).put("lines", new String[] { "move_clean", "home_repair" });
    ((Map)localObject).put("page", "1");
    ((Map)localObject).put("size", "2");
    com.ziroom.ziroomcustomer.service.f.syncMessages(this, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.l(SysMessageOnlineModel.DataBean.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<SysMessageOnlineModel.DataBean> paramAnonymousList)
      {
        com.ziroom.ziroomcustomer.service.e.putLastSyncTime(ChatCenterActivity.this, l);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          paramAnonymousList = ChatCenterActivity.a(ChatCenterActivity.this, paramAnonymousList);
          if (paramAnonymousList.size() != 1) {
            break label191;
          }
          ChatCenterActivity.this.tvServiceTime1.setVisibility(0);
          ChatCenterActivity.this.tvServiceContent1.setVisibility(0);
          ChatCenterActivity.this.ivArraw1.setVisibility(0);
          ChatCenterActivity.this.llServiceMessage1.setTag(paramAnonymousList.get(0));
          ChatCenterActivity.this.tvServiceContent1.setText(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).e);
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          if (((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).k != null) {
            break label155;
          }
          ChatCenterActivity.this.tvServiceTime1.setVisibility(8);
        }
        label155:
        label191:
        while (paramAnonymousList.size() != 2)
        {
          return;
          paramAnonymousList = localSimpleDateFormat.format(Long.valueOf(Long.parseLong(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).k)));
          ChatCenterActivity.this.tvServiceTime1.setText(paramAnonymousList);
          return;
        }
        ChatCenterActivity.this.llServiceMessage2.setVisibility(0);
        ChatCenterActivity.this.ivArraw1.setVisibility(0);
        ChatCenterActivity.this.tvServiceTime1.setVisibility(0);
        ChatCenterActivity.this.tvServiceContent1.setVisibility(0);
        ChatCenterActivity.this.llServiceMessage1.setTag(paramAnonymousList.get(0));
        ChatCenterActivity.this.llServiceMessage2.setTag(paramAnonymousList.get(1));
        ChatCenterActivity.this.tvServiceContent1.setText(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).e);
        ChatCenterActivity.this.tvServiceTime1.setText(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).k);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).k != null)
        {
          String str = localSimpleDateFormat.format(Long.valueOf(Long.parseLong(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(0)).k)));
          ChatCenterActivity.this.tvServiceTime1.setText(str);
        }
        for (;;)
        {
          ChatCenterActivity.this.tvServiceContent2.setText(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(1)).e);
          if (((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(1)).k != null) {
            break;
          }
          ChatCenterActivity.this.tvServiceTime2.setVisibility(8);
          return;
          ChatCenterActivity.this.tvServiceTime1.setVisibility(8);
        }
        ChatCenterActivity.this.tvServiceTime2.setText(localSimpleDateFormat.format(Long.valueOf(Long.parseLong(((com.ziroom.commonlibrary.c.b)paramAnonymousList.get(1)).k))));
      }
    }, (Map)localObject);
    b();
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.e.n.getClasssQueations(this, this.a, 4, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.e(com.ziroom.ziroomcustomer.newchat.chatcenter.b.l.class))
    {
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newchat.chatcenter.b.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        ChatCenterActivity.this.llQuestion.removeAllViews();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          Object localObject = (com.ziroom.ziroomcustomer.newchat.chatcenter.b.l)paramAnonymousList.next();
          ChartAndHelpFristPaperGroup localChartAndHelpFristPaperGroup = (ChartAndHelpFristPaperGroup)LayoutInflater.from(ChatCenterActivity.this).inflate(2130905195, null);
          localChartAndHelpFristPaperGroup.setmQuestionTypeBeans((com.ziroom.ziroomcustomer.newchat.chatcenter.b.l)localObject);
          localChartAndHelpFristPaperGroup.setOnViewClick(new ChartAndHelpFristPaperGroup.a()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = (com.ziroom.ziroomcustomer.newchat.chatcenter.b.h)paramAnonymous2View.getTag();
              if (paramAnonymous2View != null)
              {
                Intent localIntent = new Intent(ChatCenterActivity.this, QuestionDetailActivity.class);
                localIntent.putExtra("item_id", paramAnonymous2View.getLoreGroupId());
                ChatCenterActivity.this.startActivity(localIntent);
              }
            }
          });
          ChatCenterActivity.this.llQuestion.addView(localChartAndHelpFristPaperGroup);
          localObject = new View(ChatCenterActivity.this);
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, 2));
          ((View)localObject).setBackgroundColor(Color.parseColor("#eeeeee"));
          ChatCenterActivity.this.llQuestion.addView((View)localObject);
        }
        if (ChatCenterActivity.this.llQuestion.getChildCount() == 0)
        {
          ChatCenterActivity.this.tvNoServiceQuestion.setVisibility(0);
          return;
        }
        ChatCenterActivity.this.tvNoServiceQuestion.setVisibility(8);
      }
    });
  }
  
  private void b(int paramInt)
  {
    this.f = (this.d + this.b + this.c);
    if (this.f > 0)
    {
      this.myinfoChatRedPoint.setVisibility(8);
      this.myinfoChatRedPointNum.setVisibility(0);
      if (this.f <= 99) {
        this.myinfoChatRedPointNum.setText(this.f + "");
      }
      while (this.myinfoChatRedPointNum.getText().toString().trim().length() <= 1)
      {
        this.myinfoChatRedPointNum.setBackgroundResource(2130839386);
        return;
        this.myinfoChatRedPointNum.setText("99+");
      }
      this.myinfoChatRedPointNum.setBackgroundResource(2130837779);
      return;
    }
    if (paramInt > 0) {
      this.myinfoChatRedPoint.setVisibility(0);
    }
    for (;;)
    {
      this.myinfoChatRedPointNum.setVisibility(8);
      return;
      this.myinfoChatRedPoint.setVisibility(8);
    }
  }
  
  private void e()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    this.view.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ChatCenterActivity.this.view.setAlpha(f);
      }
    });
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130840474).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130840474).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localRoundingParams.setBorder(Color.parseColor("#99FFFFFF"), com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.ivChartIcon.setHierarchy(localGenericDraweeHierarchy);
    f();
  }
  
  private void f()
  {
    this.b = ApplicationEx.c.getUnReadNum();
    this.c = ApplicationEx.c.getMisuNum();
    this.d = j.getUnReadMsgSize(2);
    if (!ae.isNull(this.g))
    {
      com.ziroom.ziroomcustomer.service.f.getUnreadNum(this, new com.freelxl.baselibrary.d.c.a(new m(com.alibaba.fastjson.e.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          ChatCenterActivity.a(ChatCenterActivity.this, 0);
          ChatCenterActivity.b(ChatCenterActivity.this, ChatCenterActivity.a(ChatCenterActivity.this));
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
          if (paramAnonymouse != null)
          {
            ChatCenterActivity.a(ChatCenterActivity.this, paramAnonymouse.getInteger("unread").intValue());
            com.freelxl.baselibrary.f.d.d("OKHttp", "Push resp sysMessNum: " + ChatCenterActivity.a(ChatCenterActivity.this));
          }
          for (;;)
          {
            ChatCenterActivity.b(ChatCenterActivity.this, ChatCenterActivity.a(ChatCenterActivity.this));
            return;
            ChatCenterActivity.a(ChatCenterActivity.this, 0);
          }
        }
      }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(this, com.ziroom.ziroomcustomer.service.d.a, com.freelxl.baselibrary.f.h.toMd5(this.g.getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(this)));
      return;
    }
    b(this.e);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903128);
    ButterKnife.bind(this);
    e();
    a();
  }
  
  @OnClick({2131690151, 2131689492, 2131690144, 2131690148, 2131690156, 2131690160, 2131690164, 2131689744})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690144: 
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this);
        return;
      }
      startActivity(new Intent(this, ChatWebViewActivity.class));
    case 2131689492: 
      finish();
      return;
    case 2131690156: 
      paramView = (com.ziroom.commonlibrary.c.b)paramView.getTag();
      if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null)
      {
        com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this, paramView);
        return;
      }
      com.ziroom.commonlibrary.g.a.getInstance().setjPushListener(new com.ziroom.ziroomcustomer.service.b());
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this, paramView);
      return;
    case 2131690160: 
      paramView = (com.ziroom.commonlibrary.c.b)paramView.getTag();
      if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null)
      {
        com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this, paramView);
        return;
      }
      com.ziroom.commonlibrary.g.a.getInstance().setjPushListener(new com.ziroom.ziroomcustomer.service.b());
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this, paramView);
      return;
    case 2131690164: 
      this.a += 1;
      b();
      return;
    case 2131689744: 
      this.a += 1;
      b();
      return;
    case 2131690151: 
      startActivity(new Intent(this, ChatWebViewActivity.class));
      return;
    }
    startActivity(new Intent(this, ChatWebViewActivity.class));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/ChatCenterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */