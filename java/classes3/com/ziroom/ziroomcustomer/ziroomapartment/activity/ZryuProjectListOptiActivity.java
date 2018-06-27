package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.a.a.b;
import com.ziroom.ziroomcustomer.ziroomapartment.a.d;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuListItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.CityListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.PriceBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView.a;
import java.util.Iterator;
import java.util.List;

public class ZryuProjectListOptiActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Unbinder a;
  private List<ZryuListItem> b;
  @BindView(2131690078)
  ImageView btnBack;
  private a c;
  @BindView(2131690896)
  ProjectListConditionalView conditionalView;
  private LayoutInflater d;
  private float e;
  private int f;
  private String g = ZryuProjectListOptiActivity.class.getSimpleName();
  @BindView(2131692932)
  ImageView iv_address_top_right;
  @BindView(2131692933)
  ListView lvZryuProjectListOpti;
  private String r = "";
  private double s;
  private double t;
  @BindView(2131689541)
  TextView tvTitle;
  private String u = "";
  private ZryuSearchConditionV2 v;
  
  private void a()
  {
    if (this.v != null)
    {
      if (this.v.selectCityIndex != -1) {
        this.r = ((ZryuSearchConditionV2.CityListBean)this.v.cityList.get(this.v.selectCityIndex)).cityCode;
      }
      if (this.v.priceBean != null)
      {
        this.s = this.v.priceBean.minPrice;
        this.t = this.v.priceBean.maxPrice;
      }
      if (this.v.checkInDate != null) {
        this.u = m.getFormatDate(this.v.checkInDate, m.b);
      }
    }
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getProjectListByConditionsV2(this, com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildSearchConditionsV2(this, this.r, this.s, this.t, this.u), new d(this, new b(ZryuListItem.class))
    {
      public void onSuccess(int paramAnonymousInt, List<ZryuListItem> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        u.logBigData(ZryuProjectListOptiActivity.b(ZryuProjectListOptiActivity.this), "获取了列表:" + paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          u.logBigData(ZryuProjectListOptiActivity.b(ZryuProjectListOptiActivity.this), "刷新列表:" + paramAnonymousList);
          ZryuProjectListOptiActivity.a(ZryuProjectListOptiActivity.this, paramAnonymousList);
          ZryuProjectListOptiActivity.c(ZryuProjectListOptiActivity.this).notifyDataSetChanged();
        }
      }
    });
  }
  
  public void initData()
  {
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getSearchConditionsV2(this, new d(this, new com.ziroom.ziroomcustomer.ziroomapartment.a.a.a())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        ZryuProjectListOptiActivity.a(ZryuProjectListOptiActivity.this, (ZryuSearchConditionV2)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), ZryuSearchConditionV2.class));
        if ((ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this) != null) && (ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).cityList != null) && (ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).priceRangeList != null))
        {
          ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).priceBean = new ZryuSearchConditionV2.PriceBean();
          ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).priceBean.minPrice = 0;
          ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).priceBean.maxPrice = 0;
          ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).selectCityIndex = -1;
          ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this).checkInDate = null;
          ZryuProjectListOptiActivity.this.conditionalView.initState(ZryuProjectListOptiActivity.d(ZryuProjectListOptiActivity.this));
          ZryuProjectListOptiActivity.this.conditionalView.dismissAllPop();
        }
      }
    });
    a();
  }
  
  public void initView()
  {
    this.d = LayoutInflater.from(this);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.f = localDisplayMetrics.widthPixels;
    this.e = localDisplayMetrics.density;
    this.btnBack.setOnClickListener(this);
    this.iv_address_top_right.setOnClickListener(this);
    this.conditionalView.setDataListener(new ProjectListConditionalView.a()
    {
      public void getData(ZryuSearchConditionV2 paramAnonymousZryuSearchConditionV2)
      {
        if (paramAnonymousZryuSearchConditionV2 == null) {
          return;
        }
        ZryuProjectListOptiActivity.a(ZryuProjectListOptiActivity.this, paramAnonymousZryuSearchConditionV2);
        ZryuProjectListOptiActivity.a(ZryuProjectListOptiActivity.this);
      }
    });
    this.c = new a(null);
    this.lvZryuProjectListOpti.setAdapter(this.c);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    }
    paramView = new Intent(this, ZryuMapActivity.class);
    paramView.putExtra("citycode", this.r);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903595);
    this.a = ButterKnife.bind(this);
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (ZryuProjectListOptiActivity.e(ZryuProjectListOptiActivity.this) == null) {
        return 0;
      }
      return ZryuProjectListOptiActivity.e(ZryuProjectListOptiActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ZryuProjectListOptiActivity.e(ZryuProjectListOptiActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final Object localObject1;
      label235:
      label255:
      label295:
      Object localObject2;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = new a(null);
        localObject1 = ZryuProjectListOptiActivity.f(ZryuProjectListOptiActivity.this).inflate(2130904605, paramViewGroup, false);
        paramView.a = ((SimpleDraweeView)((View)localObject1).findViewById(2131691098));
        paramView.b = ((TextView)((View)localObject1).findViewById(2131690049));
        paramView.c = ((TextView)((View)localObject1).findViewById(2131689912));
        paramView.d = ((TextView)((View)localObject1).findViewById(2131690041));
        paramView.e = ((LinearLayout)((View)localObject1).findViewById(2131695864));
        ((View)localObject1).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject1;
        localObject1 = (ZryuListItem)ZryuProjectListOptiActivity.e(ZryuProjectListOptiActivity.this).get(paramInt);
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(((ZryuListItem)localObject1).getHeadPic()));
        paramViewGroup.b.setText(((ZryuListItem)localObject1).getProName());
        if ((!ae.notNull(((ZryuListItem)localObject1).getPriceTag())) || (!ae.notNull(((ZryuListItem)localObject1).getMinPrice())) || (!ae.notNull(((ZryuListItem)localObject1).getMaxPrice()))) {
          break label476;
        }
        paramViewGroup.c.setText(((ZryuListItem)localObject1).getPriceTag() + ((ZryuListItem)localObject1).getMinPrice() + "-" + ((ZryuListItem)localObject1).getMaxPrice());
        if (!TextUtils.isEmpty(((ZryuListItem)localObject1).getProAddr())) {
          break label488;
        }
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.e.removeAllViews();
        if ((((ZryuListItem)localObject1).getTagList() == null) || (((ZryuListItem)localObject1).getTagList().size() <= 0)) {
          break label531;
        }
        Iterator localIterator = ((ZryuListItem)localObject1).getTagList().iterator();
        if (!localIterator.hasNext()) {
          break label531;
        }
        localObject2 = (String)localIterator.next();
        localTextView = new TextView(ZryuProjectListOptiActivity.this);
        localTextView.setText((CharSequence)localObject2);
        if (((ZryuListItem)localObject1).getTagFlag() != 1) {
          break label511;
        }
        localTextView.setTextColor(Color.parseColor("#999999"));
        localTextView.setBackgroundResource(2130837908);
      }
      for (;;)
      {
        localTextView.setTextSize(10.0F);
        localTextView.setPadding((int)ZryuProjectListOptiActivity.g(ZryuProjectListOptiActivity.this) * 5, (int)ZryuProjectListOptiActivity.g(ZryuProjectListOptiActivity.this) * 3, (int)ZryuProjectListOptiActivity.g(ZryuProjectListOptiActivity.this) * 5, (int)ZryuProjectListOptiActivity.g(ZryuProjectListOptiActivity.this) * 3);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, (int)ZryuProjectListOptiActivity.g(ZryuProjectListOptiActivity.this) * 5, 0);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramViewGroup.e.addView(localTextView);
        break label295;
        paramViewGroup = (a)paramView.getTag();
        break;
        label476:
        paramViewGroup.c.setText("");
        break label235;
        label488:
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(((ZryuListItem)localObject1).getProAddr());
        break label255;
        label511:
        localTextView.setTextColor(Color.parseColor("#444444"));
        localTextView.setBackgroundResource(2130837909);
      }
      label531:
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (1 == localObject1.getProjectState())
          {
            g.textToast(ZryuProjectListOptiActivity.this, "敬请期待");
            return;
          }
          com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(ZryuProjectListOptiActivity.this, localObject1.getProFid());
        }
      });
      return paramView;
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      TextView c;
      TextView d;
      LinearLayout e;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectListOptiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */