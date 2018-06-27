package com.ziroom.ziroomcustomer.minsu.tenant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean.DataBean.EvaListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean.DataBean.EvaListBean.LandlordEvaItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean.DataBean.EvaListBean.TenantEvaItemBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.fragment.MinsuHouseDetailBottomFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.a.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView.b;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.FiveEvaluteButton;
import com.ziroom.ziroomcustomer.minsu.view.MinsuExpandableTextView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuLandlordDetailActivty
  extends BaseFluxActivity
{
  private int A = 10;
  private MinsuLandlordEvaBean B;
  private a C;
  private int D = 1;
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.a E;
  private com.ziroom.ziroomcustomer.minsu.tenant.a.a F;
  private com.ziroom.ziroomcustomer.minsu.tenant.b.a G;
  private Unbinder H;
  private LinearLayoutManager I;
  private int J;
  private MinsuHouseBean K;
  private CommonTitle b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private FiveEvaluteButton f;
  private TextView g;
  private TextView r;
  @BindView(2131691465)
  RecyclerView rv_house;
  private LinearLayout s;
  @BindView(2131691456)
  SearchListScrollView sl_root;
  private TextView t;
  private TextView u;
  private FrameLayout v;
  private XListView w;
  private List<MinsuHouseDetailBottomFragment> x = new ArrayList();
  private String y;
  private int z = 1;
  
  private void a()
  {
    this.G = new com.ziroom.ziroomcustomer.minsu.tenant.b.a(this);
    this.a.register(this.G);
    this.F = com.ziroom.ziroomcustomer.minsu.tenant.a.a.getInstance(this.a);
  }
  
  private void b()
  {
    this.b = ((CommonTitle)findViewById(2131691272));
    this.b.setMiddleText("房东信息");
    this.b.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MinsuLandlordDetailActivty.a(MinsuLandlordDetailActivty.this).getVisibility() == 0)
        {
          MinsuLandlordDetailActivty.a(MinsuLandlordDetailActivty.this).setVisibility(8);
          MinsuLandlordDetailActivty.b(MinsuLandlordDetailActivty.this).setMiddleText("房东信息");
          return;
        }
        MinsuLandlordDetailActivty.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.sl_root.setOnScrollListener(new SearchListScrollView.b()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2) {}
    });
    this.sl_root.getHelper().setCurrentScrollableContainer(this.rv_house);
    this.rv_house.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (MinsuLandlordDetailActivty.c(MinsuLandlordDetailActivty.this) + 1 == MinsuLandlordDetailActivty.d(MinsuLandlordDetailActivty.this).getItemCount()) && (MinsuLandlordDetailActivty.d(MinsuLandlordDetailActivty.this).getCurrentModel() == a.c.a) && (MinsuLandlordDetailActivty.d(MinsuLandlordDetailActivty.this).getCanLoadMore()))
        {
          MinsuLandlordDetailActivty.d(MinsuLandlordDetailActivty.this).changeMoreStatus(1);
          MinsuLandlordDetailActivty.e(MinsuLandlordDetailActivty.this);
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MinsuLandlordDetailActivty.a(MinsuLandlordDetailActivty.this, MinsuLandlordDetailActivty.f(MinsuLandlordDetailActivty.this).findLastVisibleItemPosition());
      }
    });
    this.I = new LinearLayoutManager(this, 1, false);
    this.rv_house.setLayoutManager(this.I);
    this.E = new com.ziroom.ziroomcustomer.minsu.searchlist.b.a(this);
    this.E.setLandlordHeaderShow(false);
    this.rv_house.setAdapter(this.E);
    this.c = ((SimpleDraweeView)findViewById(2131691457));
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        String str = paramAnonymousView.getTag(2131689523) + "";
        if (TextUtils.isEmpty(str)) {
          return;
        }
        com.ziroom.ziroomcustomer.minsu.f.k.toOnePic(MinsuLandlordDetailActivty.this, paramAnonymousView.getTag(2131689526) + "", str);
      }
    });
    this.d = ((TextView)findViewById(2131690912));
    this.f = ((FiveEvaluteButton)findViewById(2131691339));
    this.e = ((TextView)findViewById(2131691459));
    this.g = ((TextView)findViewById(2131691460));
    this.r = ((TextView)findViewById(2131691461));
    this.s = ((LinearLayout)findViewById(2131691462));
    this.t = ((TextView)findViewById(2131691463));
    this.u = ((TextView)findViewById(2131691464));
    this.v = ((FrameLayout)findViewById(2131691466));
    this.w = ((XListView)findViewById(2131691467));
    this.w.setPullLoadEnable(true);
    this.w.setPullRefreshEnable(true);
    this.C = new a(this);
    this.w.setAdapter(this.C);
    this.w.setXListViewListener(new XListView.a()
    {
      public void onLoadMore()
      {
        MinsuLandlordDetailActivty.i(MinsuLandlordDetailActivty.this);
        MinsuLandlordDetailActivty.g(MinsuLandlordDetailActivty.this);
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).setRefreshTime("刚刚");
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).stopLoadMore();
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).stopRefresh();
      }
      
      public void onRefresh()
      {
        MinsuLandlordDetailActivty.b(MinsuLandlordDetailActivty.this, 1);
        MinsuLandlordDetailActivty.g(MinsuLandlordDetailActivty.this);
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).setRefreshTime("刚刚");
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).stopLoadMore();
        MinsuLandlordDetailActivty.h(MinsuLandlordDetailActivty.this).stopRefresh();
      }
    });
    this.f.setPadding(new int[] { 2, 2, 2, 2 });
    this.f.setSwitch(false);
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).setMaxLines(10000);
        MinsuLandlordDetailActivty.k(MinsuLandlordDetailActivty.this).setVisibility(8);
      }
    });
    this.t.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordDetailActivty.a(MinsuLandlordDetailActivty.this).setVisibility(0);
        MinsuLandlordDetailActivty.b(MinsuLandlordDetailActivty.this).setMiddleText("全部评价");
      }
    });
  }
  
  private void f()
  {
    if (this.B == null) {
      return;
    }
    label31:
    int i;
    label63:
    int j;
    label74:
    Object localObject;
    View localView;
    if (this.B.getData().getTotal() <= 3)
    {
      this.t.setVisibility(8);
      this.s.removeAllViews();
      if (this.B.getData().getTotal() >= 3) {
        break label447;
      }
      i = this.B.getData().getTotal();
      SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
      j = 0;
      if (j < i)
      {
        localObject = (MinsuLandlordEvaBean.DataBean.EvaListBean)this.B.getData().getEvaList().get(j);
        localView = LayoutInflater.from(this).inflate(2130904325, null, false);
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131690097);
        localSimpleDraweeView.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(this));
        localSimpleDraweeView.setController(c.frescoController(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getTenantEvaItem().getUserHeadPic()));
        TextView localTextView1 = (TextView)localView.findViewById(2131690049);
        localTextView1.setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getTenantEvaItem().getNickName());
        ((TextView)localView.findViewById(2131689852)).setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getTenantEvaItem().getCreateTime());
        ((MinsuExpandableTextView)localView.findViewById(2131690084)).setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getTenantEvaItem().getContent(), localSparseBooleanArray, j);
        TextView localTextView2 = (TextView)localView.findViewById(2131691210);
        localTextView2.setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getHouseName());
        localTextView2.setTag(2131689523, localObject);
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (MinsuLandlordEvaBean.DataBean.EvaListBean)paramAnonymousView.getTag(2131689523);
            MinsuLandlordDetailActivty localMinsuLandlordDetailActivty = MinsuLandlordDetailActivty.this;
            String str1 = paramAnonymousView.houseFid;
            String str2 = paramAnonymousView.rentWay + "";
            if (paramAnonymousView.isTop50Online == 1) {}
            for (boolean bool = true;; bool = false)
            {
              com.ziroom.ziroomcustomer.minsu.f.k.toHouseDetail(localMinsuLandlordDetailActivty, str1, str2, bool);
              return;
            }
          }
        });
        int k = localTextView1.getLineHeight() * 2 + ab.dp2px(this, 16.0F);
        localSimpleDraweeView.getLayoutParams().width = k;
        localSimpleDraweeView.getLayoutParams().height = k;
        ((TextView)localView.findViewById(2131691210)).setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getHouseName());
        if (((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).landlordEvaItem != null) {
          break label452;
        }
        localView.findViewById(2131695255).setVisibility(8);
      }
    }
    for (;;)
    {
      this.s.addView(localView);
      if (j != i - 1)
      {
        localObject = new View(this);
        ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(ac.getScreenWidth(this) - ab.dp2px(this, 36.0F), 1));
        ((View)localObject).setX(ab.dp2px(this, 18.0F));
        ((View)localObject).setBackgroundColor(Color.parseColor("#ababab"));
        this.s.addView((View)localObject);
      }
      j += 1;
      break label74;
      break;
      this.t.setVisibility(0);
      break label31;
      label447:
      i = 3;
      break label63;
      label452:
      ((TextView)localView.findViewById(2131695284)).setText(((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getLandlordEvaItem().getContent());
      ((TextView)localView.findViewById(2131695283)).setText(String.format("%s的回复", new Object[] { ((MinsuLandlordEvaBean.DataBean.EvaListBean)localObject).getLandlordEvaItem().getNickName() }));
    }
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLandlordDetailNew(this, this.y, true, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.e("lanzhihong", "str======" + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuLandlordBean localMinsuLandlordBean = (MinsuLandlordBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuLandlordBean != null) && (localMinsuLandlordBean.checkSuccess(MinsuLandlordDetailActivty.this)))
        {
          MinsuLandlordDetailActivty.l(MinsuLandlordDetailActivty.this).setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(MinsuLandlordDetailActivty.this));
          MinsuLandlordDetailActivty.l(MinsuLandlordDetailActivty.this).setController(c.frescoController(localMinsuLandlordBean.getData().getHeadPicUrl()));
          MinsuLandlordDetailActivty.l(MinsuLandlordDetailActivty.this).setTag(2131689523, localMinsuLandlordBean.getData().getHeadPicUrlOrg());
          MinsuLandlordDetailActivty.l(MinsuLandlordDetailActivty.this).setTag(2131689526, localMinsuLandlordBean.getData().getHeadPicUrl());
          TextView localTextView = MinsuLandlordDetailActivty.m(MinsuLandlordDetailActivty.this);
          StringBuilder localStringBuilder = new StringBuilder().append("您好，我是");
          if (ae.isNull(localMinsuLandlordBean.getData().getNickName()))
          {
            paramAnonymousk = "房东";
            localTextView.setText(paramAnonymousk);
            MinsuLandlordDetailActivty.n(MinsuLandlordDetailActivty.this).setScore((float)localMinsuLandlordBean.getData().getEva());
            if (!TextUtils.isEmpty(localMinsuLandlordBean.getData().getIntroduce())) {
              break label271;
            }
            MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).setVisibility(8);
          }
          for (;;)
          {
            MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).setText(localMinsuLandlordBean.getData().getIntroduce());
            MinsuLandlordDetailActivty.l(MinsuLandlordDetailActivty.this).setTag(2131689523, localMinsuLandlordBean.getData().getHeadPicUrlOrg());
            MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public void onGlobalLayout()
              {
                MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).getLineCount() > 3)
                {
                  MinsuLandlordDetailActivty.k(MinsuLandlordDetailActivty.this).setVisibility(0);
                  MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).setMaxLines(3);
                }
              }
            });
            return;
            paramAnonymousk = localMinsuLandlordBean.getData().getNickName();
            break;
            label271:
            MinsuLandlordDetailActivty.j(MinsuLandlordDetailActivty.this).setVisibility(0);
          }
        }
        if (localMinsuLandlordBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuLandlordBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLandlordEva(this, this.y, this.z, this.A, true, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.e("lanzhihong", "str======" + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        int i = 0;
        MinsuLandlordEvaBean localMinsuLandlordEvaBean = (MinsuLandlordEvaBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuLandlordEvaBean != null) && (localMinsuLandlordEvaBean.checkSuccess(MinsuLandlordDetailActivty.this)))
        {
          if (MinsuLandlordDetailActivty.o(MinsuLandlordDetailActivty.this) == 1)
          {
            MinsuLandlordDetailActivty.a(MinsuLandlordDetailActivty.this, localMinsuLandlordEvaBean);
            MinsuLandlordDetailActivty.p(MinsuLandlordDetailActivty.this);
            if (MinsuLandlordDetailActivty.q(MinsuLandlordDetailActivty.this).getData().getTotal() > 0) {
              MinsuLandlordDetailActivty.r(MinsuLandlordDetailActivty.this).setVisibility(0);
            }
            MinsuLandlordDetailActivty.r(MinsuLandlordDetailActivty.this).setText(MinsuLandlordDetailActivty.q(MinsuLandlordDetailActivty.this).getData().getTotal() + "条评价");
          }
          for (;;)
          {
            MinsuLandlordDetailActivty.s(MinsuLandlordDetailActivty.this).setData(MinsuLandlordDetailActivty.q(MinsuLandlordDetailActivty.this).getData().getEvaList());
            return;
            while (i < localMinsuLandlordEvaBean.getData().getEvaList().size())
            {
              MinsuLandlordDetailActivty.q(MinsuLandlordDetailActivty.this).getData().getEvaList().add(localMinsuLandlordEvaBean.getData().getEvaList().get(i));
              i += 1;
            }
          }
        }
        if (localMinsuLandlordEvaBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuLandlordEvaBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void i()
  {
    this.F.getLandlordHouseList(this, this, this.y, this.D);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903293);
    this.y = getIntent().getStringExtra("uid");
    this.H = ButterKnife.bind(this);
    e();
    a();
    b();
    g();
    h();
    i();
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.G);
    if (this.H != null) {
      this.H.unbind();
    }
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("landlord_house")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("landlord_house_error")) {
        break;
      }
      i = 1;
      break;
      this.K = this.G.getLandlordHouseBean();
    } while ((this.K == null) || (this.K.data == null));
    if (!s.isEmpty(this.K.data.list))
    {
      if (this.D == 1)
      {
        this.E.setData(this.K.data.list, a.c.a);
        this.rv_house.smoothScrollToPosition(0);
        this.E.changeMoreStatus(0);
        if (this.D > (this.K.data.total - 1) / 10) {
          break label244;
        }
        this.E.setCanLoadMore(true);
      }
      for (;;)
      {
        this.u.setVisibility(0);
        this.D += 1;
        return;
        this.E.addData(this.K.data.list);
        break;
        label244:
        this.E.setCanLoadMore(false);
      }
    }
    if (this.K.data.total == 0)
    {
      this.E.setData(null, a.c.a);
      this.E.setCanLoadMore(false);
      return;
    }
    this.E.setCanLoadMore(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (this.v.getVisibility() == 0)
      {
        this.v.setVisibility(8);
        this.b.setMiddleText("房东信息");
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends com.ziroom.ziroomcustomer.minsu.a.a<MinsuLandlordEvaBean.DataBean.EvaListBean>
  {
    SparseBooleanArray d = new SparseBooleanArray();
    
    public a(Context paramContext)
    {
      super(null, 2130904325);
    }
    
    public void convert(com.freelxl.baselibrary.a.b paramb, MinsuLandlordEvaBean.DataBean.EvaListBean paramEvaListBean)
    {
      paramb.setText(2131690049, paramEvaListBean.getTenantEvaItem().getNickName());
      paramb.setText(2131689852, paramEvaListBean.getTenantEvaItem().getCreateTime());
      ((MinsuExpandableTextView)paramb.getView(2131690084)).setText(paramEvaListBean.getTenantEvaItem().getContent(), this.d, paramb.getPosition());
      int i = ((TextView)paramb.getView(2131690049)).getLineHeight() * 2 + ab.dp2px(MinsuLandlordDetailActivty.this, 16.0F);
      paramb.getView(2131690097).getLayoutParams().width = i;
      paramb.getView(2131690097).getLayoutParams().height = i;
      if (paramEvaListBean.landlordEvaItem == null) {
        paramb.getView(2131695255).setVisibility(8);
      }
      for (;;)
      {
        ((SimpleDraweeView)paramb.getView(2131690097)).setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(this.a));
        ((SimpleDraweeView)paramb.getView(2131690097)).setController(c.frescoController(paramEvaListBean.getTenantEvaItem().getUserHeadPic()));
        paramb = (TextView)paramb.getView(2131691210);
        paramb.setText(paramEvaListBean.getHouseName());
        paramb.setTag(2131689523, paramEvaListBean);
        paramb.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (MinsuLandlordEvaBean.DataBean.EvaListBean)paramAnonymousView.getTag(2131689523);
            MinsuLandlordDetailActivty localMinsuLandlordDetailActivty = MinsuLandlordDetailActivty.this;
            String str1 = paramAnonymousView.houseFid;
            String str2 = paramAnonymousView.rentWay + "";
            if (paramAnonymousView.isTop50Online == 1) {}
            for (boolean bool = true;; bool = false)
            {
              com.ziroom.ziroomcustomer.minsu.f.k.toHouseDetail(localMinsuLandlordDetailActivty, str1, str2, bool);
              return;
            }
          }
        });
        return;
        paramb.getView(2131695255).setVisibility(0);
        paramb.setText(2131695283, String.format("%s的回复", new Object[] { paramEvaListBean.getLandlordEvaItem().getNickName() }));
        paramb.setText(2131695284, paramEvaListBean.getLandlordEvaItem().getContent());
      }
    }
    
    public void setData(List<MinsuLandlordEvaBean.DataBean.EvaListBean> paramList)
    {
      this.b = paramList;
      notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/tenant/MinsuLandlordDetailActivty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */