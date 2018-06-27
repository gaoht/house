package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.social.model.e;
import com.ziroom.ziroomcustomer.social.model.e.a;
import com.ziroom.ziroomcustomer.social.model.l;
import com.ziroom.ziroomcustomer.social.view.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class AcEnrollListActivity
  extends BaseActivity
{
  private LayoutInflater a;
  private a b;
  private int c;
  private final int d = 10;
  private boolean e = true;
  private List<e> f;
  private boolean g;
  @BindView(2131689818)
  LinearLayout mLlEmpty;
  @BindView(2131689817)
  ListView mLv;
  private com.ziroom.ziroomcustomer.e.a.f<com.ziroom.ziroomcustomer.social.model.g> r = new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.social.model.g.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      AcEnrollListActivity.this.mLv.setEmptyView(AcEnrollListActivity.this.mLlEmpty);
      AcEnrollListActivity.a(AcEnrollListActivity.this, false);
    }
    
    public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.social.model.g paramAnonymousg)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousg);
      if (paramAnonymousg != null)
      {
        if ((paramAnonymousg.getList() == null) || (paramAnonymousg.getList().size() <= 0)) {
          break label138;
        }
        paramAnonymousg = paramAnonymousg.getList();
        if (paramAnonymousg.size() < 10) {
          AcEnrollListActivity.b(AcEnrollListActivity.this, false);
        }
        AcEnrollListActivity.e(AcEnrollListActivity.this);
        if (AcEnrollListActivity.f(AcEnrollListActivity.this) == null) {
          AcEnrollListActivity.a(AcEnrollListActivity.this, new ArrayList());
        }
        AcEnrollListActivity.f(AcEnrollListActivity.this).addAll(paramAnonymousg);
        AcEnrollListActivity.g(AcEnrollListActivity.this).notifyDataSetChanged();
      }
      for (;;)
      {
        AcEnrollListActivity.this.mLv.setEmptyView(AcEnrollListActivity.this.mLlEmpty);
        AcEnrollListActivity.a(AcEnrollListActivity.this, false);
        return;
        label138:
        AcEnrollListActivity.b(AcEnrollListActivity.this, false);
      }
    }
  };
  
  private void a()
  {
    this.b = new a(null);
    this.mLv.setAdapter(this.b);
    this.mLv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (AcEnrollListActivity.this.mLv.getChildAt(AcEnrollListActivity.this.mLv.getChildCount() - 1) != null) && (!AcEnrollListActivity.a(AcEnrollListActivity.this)))
        {
          d.d("ListView", "##### 滚动到底部 ######");
          if (AcEnrollListActivity.b(AcEnrollListActivity.this))
          {
            AcEnrollListActivity.a(AcEnrollListActivity.this, true);
            j.acEnrollList(AcEnrollListActivity.this, AcEnrollListActivity.c(AcEnrollListActivity.this), 10, 1, AcEnrollListActivity.d(AcEnrollListActivity.this));
          }
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  private void b()
  {
    this.c = 1;
    this.e = true;
    if (this.f != null) {
      this.f.clear();
    }
    this.g = true;
    j.acEnrollList(this, this.c, 10, 1, this.r);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903080);
    ButterKnife.bind(this);
    this.a = LayoutInflater.from(this);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    paramView = new Intent(this, AcMainActivity.class);
    paramView.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    startActivityAndFinish(paramView);
  }
  
  private class a
    extends BaseAdapter
  {
    private int b = Color.parseColor("#444444");
    private int c = Color.parseColor("#666666");
    private int d = Color.parseColor("#999999");
    private int e = Color.parseColor("#FB303E");
    private int f = Color.parseColor("#FFA000");
    
    private a() {}
    
    public int getCount()
    {
      if (AcEnrollListActivity.f(AcEnrollListActivity.this) == null) {
        return 0;
      }
      return AcEnrollListActivity.f(AcEnrollListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return AcEnrollListActivity.f(AcEnrollListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final e locale;
      String str1;
      label236:
      String str2;
      if (paramView == null)
      {
        paramView = AcEnrollListActivity.h(AcEnrollListActivity.this).inflate(2130904115, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131689822));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131693107));
        paramViewGroup.e = ((Button)paramView.findViewById(2131690043));
        paramViewGroup.f = ((Button)paramView.findViewById(2131694811));
        paramViewGroup.g = ((SimpleDraweeView)paramView.findViewById(2131691098));
        paramView.setTag(paramViewGroup);
        locale = (e)getItem(paramInt);
        e.a locala = locale.getApp_show();
        paramViewGroup.a.setText(locale.getTitle());
        paramViewGroup.b.setText(locale.getShow_time());
        if (locala != null)
        {
          str1 = locala.getType();
          if ((!"2".equals(str1)) || (ae.isNull(locala.getButton_2()))) {
            break label466;
          }
          paramViewGroup.f.setVisibility(0);
          paramViewGroup.f.setText(locala.getButton_2());
          paramViewGroup.f.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(AcEnrollListActivity.this).setTitle("提示").setContent("请假超过2次会影响活动信用，不利于报名其他活动；且请假后不能再次报名参加活动\n是否确认请假这次活动").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
                {
                  if (paramAnonymous2Boolean) {
                    j.acEnrollAskForLeave(AcEnrollListActivity.this, AcEnrollListActivity.a.1.this.a.getActivity_code(), new com.ziroom.ziroomcustomer.e.a.f(AcEnrollListActivity.this, new com.ziroom.ziroomcustomer.e.c.f(String.class))
                    {
                      public void onSuccess(int paramAnonymous3Int, String paramAnonymous3String)
                      {
                        super.onSuccess(paramAnonymous3Int, paramAnonymous3String);
                        com.freelxl.baselibrary.f.g.textToast(AcEnrollListActivity.this, "请假成功！");
                        AcEnrollListActivity.i(AcEnrollListActivity.this);
                      }
                    });
                  }
                }
              }).build().show();
            }
          });
          if (!TextUtils.isEmpty(locala.getStatus()))
          {
            str2 = locala.getStatus();
            if (!"报名通过".equals(str2)) {
              break label478;
            }
            paramViewGroup.c.setTextColor(this.f);
          }
          label275:
          paramViewGroup.c.setText(locala.getStatus());
          if (TextUtils.isEmpty(locala.getButton())) {
            break label607;
          }
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.e.setText(locala.getButton());
          if (!"取消报名".equals(locala.getButton())) {
            break label542;
          }
          paramViewGroup.e.setTextColor(this.c);
          paramViewGroup.e.setBackgroundResource(2130837956);
          label351:
          if (!TextUtils.isEmpty(str1))
          {
            if (!"1".equals(str1)) {
              break label566;
            }
            paramViewGroup.e.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(AcEnrollListActivity.this).setTitle("提示").setContent("取消报名后不能再次报名，是否确认取消").setOnConfirmClickListener(new c.b()
                {
                  public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
                  {
                    if (paramAnonymous2Boolean) {
                      j.acEnrollCancel(AcEnrollListActivity.this, AcEnrollListActivity.a.2.this.a.getActivity_code(), new com.ziroom.ziroomcustomer.e.a.f(AcEnrollListActivity.this, new com.ziroom.ziroomcustomer.e.c.f(String.class))
                      {
                        public void onSuccess(int paramAnonymous3Int, String paramAnonymous3String)
                        {
                          super.onSuccess(paramAnonymous3Int, paramAnonymous3String);
                          com.freelxl.baselibrary.f.g.textToast(AcEnrollListActivity.this, "取消报名成功！");
                          AcEnrollListActivity.i(AcEnrollListActivity.this);
                        }
                      });
                    }
                  }
                }).build().show();
              }
            });
          }
        }
        label386:
        if (TextUtils.isEmpty(locale.getRefusal_reason())) {
          break label619;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(locale.getRefusal_reason());
      }
      for (;;)
      {
        paramViewGroup.g.setController(com.freelxl.baselibrary.f.c.frescoController(x.makeUrl(locale.getCover_pic(), 0.5F)));
        if (!TextUtils.isEmpty(locale.getDetail_url())) {
          break label631;
        }
        paramView.setOnClickListener(null);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label466:
        paramViewGroup.f.setVisibility(8);
        break label236;
        label478:
        if ("报名失败".equals(str2))
        {
          paramViewGroup.c.setTextColor(this.e);
          break label275;
        }
        if ("已关闭".equals(str2))
        {
          paramViewGroup.c.setTextColor(this.b);
          break label275;
        }
        paramViewGroup.c.setTextColor(this.d);
        break label275;
        label542:
        paramViewGroup.e.setTextColor(this.f);
        paramViewGroup.e.setBackgroundResource(2130837965);
        break label351;
        label566:
        if ("2".equals(str1))
        {
          paramViewGroup.e.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              com.ziroom.ziroomcustomer.social.view.a.newBuilder(AcEnrollListActivity.this).setTitle("活动微信群二维码").setCodeUrl(locale.getErcode()).build().show();
            }
          });
          break label386;
        }
        paramViewGroup.e.setOnClickListener(null);
        break label386;
        label607:
        paramViewGroup.e.setVisibility(8);
        break label386;
        label619:
        paramViewGroup.d.setVisibility(8);
      }
      label631:
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (locale.getShare_info() != null)
          {
            JsBridgeWebActivity.start(AcEnrollListActivity.this, "", locale.getDetail_url(), true, locale.getShare_info().getContent(), locale.getShare_info().getImage(), false, false);
            return;
          }
          JsBridgeWebActivity.start(AcEnrollListActivity.this, "", locale.getDetail_url(), false, "", "", false, true);
        }
      });
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      Button e;
      Button f;
      SimpleDraweeView g;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */