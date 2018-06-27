package com.ziroom.ziroomcustomer.minsu.searchlist.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBannerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelTips;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.MinsuMapFindActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.BrowsingHistoryActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment.a;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends RecyclerView.a<RecyclerView.u>
{
  private Context a;
  private List<MinsuHouseBean.DataBean.ListBean> b;
  private b<MinsuHouseBean.DataBean.ListBean> c;
  private MinsuHouseBean.DataBean.ListBean d;
  private MinsuHouseBean.DataBean.ListBean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private c j = c.a;
  private boolean k = true;
  private BaseSearchListFragment.a l;
  private boolean m = true;
  private boolean n = true;
  private int o = 0;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, b<MinsuHouseBean.DataBean.ListBean> paramb)
  {
    this.a = paramContext;
    this.c = paramb;
    this.f = n.dip2px(this.a, 6.0F);
    this.g = n.dip2px(this.a, 12.0F);
    this.h = n.dip2px(this.a, 22.0F);
    this.i = n.dip2px(this.a, 8.0F);
  }
  
  private int a(int paramInt)
  {
    switch (5.a[this.j.ordinal()])
    {
    }
    return paramInt;
  }
  
  private void a(b paramb, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean localTonightDiscountInfoVoBean = paramListBean.tonightDiscountInfoVo;
    if (localTonightDiscountInfoVoBean == null)
    {
      paramb.o.setVisibility(8);
      return;
    }
    paramb.o.setVisibility(0);
    paramb.j.setText(localTonightDiscountInfoVoBean.getTonightDiscount() * 10.0F + "折");
    paramb.k.setText(localTonightDiscountInfoVoBean.getTipsNname());
    paramb.h.setText("¥ " + ad.getPriceInt(localTonightDiscountInfoVoBean.tonightPrice) + "/晚");
    paramb.m.setPaintFlags(17);
    if (paramListBean.tonightDiscountInfoVo.remainTime > 1000L)
    {
      paramb.q.setVisibility(8);
      paramb.r.setVisibility(0);
      paramb.s.setBackgroundColor(this.a.getResources().getColor(2131624495));
      paramb.l.setText(localTonightDiscountInfoVoBean.getOpenTimeListTips());
      paramb.m.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
      return;
    }
    paramb.q.setVisibility(8);
    paramb.r.setVisibility(0);
    paramb.s.setBackgroundColor(this.a.getResources().getColor(2131624497));
    paramb.l.setText(localTonightDiscountInfoVoBean.getDeadlineTimeListTips());
    if (paramListBean.originalPrice > 0)
    {
      paramb.m.setText("¥" + ad.getPriceInt(paramListBean.originalPrice) + "/晚");
      return;
    }
    paramb.m.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
  }
  
  public void addData(List<MinsuHouseBean.DataBean.ListBean> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void changeMoreStatus(int paramInt)
  {
    this.o = paramInt;
    notifyDataSetChanged();
  }
  
  public boolean getCanLoadMore()
  {
    return this.k;
  }
  
  public MinsuHouseBean.DataBean.ListBean getCurrentCancelCollectData()
  {
    return this.e;
  }
  
  public MinsuHouseBean.DataBean.ListBean getCurrentCollectData()
  {
    return this.d;
  }
  
  public c getCurrentModel()
  {
    return this.j;
  }
  
  public List<MinsuHouseBean.DataBean.ListBean> getData()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    if ((this.j == c.c) || (this.j == c.b)) {
      return this.b.size();
    }
    return this.b.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.j == c.a)
    {
      if (paramInt + 1 == getItemCount()) {
        return 1;
      }
      if ((((MinsuHouseBean.DataBean.ListBean)this.b.get(paramInt)).houseBannerBean != null) && ("TonightDiscountGuideBanner001".equals(((MinsuHouseBean.DataBean.ListBean)this.b.get(paramInt)).houseBannerBean.getBannerType()))) {
        return 2;
      }
      return 0;
    }
    if (this.j == c.b) {
      return 0;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    final MinsuHouseBean.DataBean.ListBean localListBean;
    Object localObject1;
    Object localObject2;
    int i2;
    int i1;
    label414:
    label563:
    label613:
    Object localObject3;
    if ((paramu instanceof b))
    {
      paramu = (b)paramu;
      localListBean = (MinsuHouseBean.DataBean.ListBean)this.b.get(a(paramInt));
      ((GenericDraweeHierarchy)paramu.b.getHierarchy()).setFailureImage(2130838651);
      if (!TextUtils.isEmpty(localListBean.picUrl)) {
        com.freelxl.baselibrary.f.c.loadHolderImage(paramu.b, localListBean.picUrl);
      }
      if (this.m)
      {
        paramu.c.setHierarchy(d.getRoundingHierarchy(this.a));
        com.freelxl.baselibrary.f.c.loadHolderImage(paramu.c, localListBean.landlordUrl);
        paramu.c.setTag(localListBean);
        paramu.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (MinsuHouseBean.DataBean.ListBean)paramAnonymousView.getTag();
            k.toLandlordDetailActivty(a.a(a.this), paramAnonymousView.landlordUid);
          }
        });
        paramu.c.setVisibility(0);
        paramu.d.setText(localListBean.houseName);
        localObject1 = new ArrayList();
        if (((this.a instanceof BrowsingHistoryActivity)) || ((this.a instanceof MinsuMapFindActivity)) || ((ae.isNull(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode())) && (!ae.isNull(localListBean.cityName)))) {
          ((List)localObject1).add(localListBean.cityName);
        }
        ((List)localObject1).add(localListBean.rentWayName);
        if (localListBean.personCount <= 0) {
          break label414;
        }
        ((List)localObject1).add("可住" + localListBean.personCount + "人");
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        i2 = ((List)localObject1).size();
        i1 = 0;
        while (i1 < i2)
        {
          ((StringBuilder)localObject2).append((String)((List)localObject1).get(i1));
          if (i1 < i2 - 1)
          {
            ((StringBuilder)localObject2).append(this.a.getString(2131297451));
            ((StringBuilder)localObject2).append(this.a.getString(2131297451));
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append(this.a.getString(2131297451));
            ((StringBuilder)localObject2).append(this.a.getString(2131297451));
          }
          i1 += 1;
        }
        paramu.c.setVisibility(8);
        break;
        if (localListBean.personCount == 0) {
          ((List)localObject1).add("不限人数");
        }
      }
      ac.colorMulti(paramu.e, ((StringBuilder)localObject2).toString(), "|", this.a.getResources().getColor(2131624046));
      if (localListBean.evaluateCount == 0)
      {
        paramu.f.setVisibility(8);
        paramu.g.setVisibility(8);
        paramu.h.setText("¥ " + ad.getPriceInt(localListBean.price) + "/晚");
        paramu.h.getPaint().setFakeBoldText(true);
        if (localListBean.isToNightDiscount != 1) {
          break label911;
        }
        paramu.m.setVisibility(0);
        a(paramu, localListBean);
        paramu.p.setVisibility(0);
        paramu.p.removeAllViews();
        if ((localListBean.labelInfoList == null) || (localListBean.labelInfoList.size() <= 0)) {
          break label955;
        }
        localObject1 = localListBean.labelInfoList.iterator();
        i1 = 0;
        i2 = i1;
        if (!((Iterator)localObject1).hasNext()) {
          break label958;
        }
        localObject3 = (MinsuHouseBean.DataBean.ListBean.LabelInfo)((Iterator)localObject1).next();
        if (!"isSpeed".equals(((MinsuHouseBean.DataBean.ListBean.LabelInfo)localObject3).code)) {
          break label1708;
        }
        localObject2 = new SimpleDraweeView(this.a);
        ((SimpleDraweeView)localObject2).setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuHouseBean.DataBean.ListBean.LabelInfo)localObject3).iconUrl));
        localObject3 = new LinearLayout.LayoutParams(this.h, -1);
        ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramu.p.addView((View)localObject2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, this.f, 0);
        i1 = i1 + 1 + 1;
        localObject2 = new TextView(this.a);
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((TextView)localObject2).setText("立即预订");
        ((TextView)localObject2).setTextSize(1, 8.0F);
        ((TextView)localObject2).setTextColor(this.a.getResources().getColor(2131624487));
        ((TextView)localObject2).getPaint().setFakeBoldText(true);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramu.p.addView((View)localObject2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(-this.g, 0, this.i, 0);
      }
    }
    label911:
    label955:
    label958:
    label1209:
    label1237:
    label1331:
    label1361:
    label1449:
    label1705:
    label1708:
    for (;;)
    {
      break label613;
      paramu.f.setVisibility(0);
      paramu.g.setVisibility(0);
      paramu.f.setText("评价 " + localListBean.evaluateCount);
      paramu.g.setText(localListBean.realEvaluateScore + "分");
      break;
      paramu.m.setVisibility(8);
      paramu.o.setVisibility(8);
      paramu.h.setTextColor(Color.parseColor("#444444"));
      paramu.h.setPaintFlags(1312);
      break label563;
      i2 = 0;
      int i4;
      int i3;
      if ((localListBean.labelTipsList != null) && (localListBean.labelTipsList.size() > 0))
      {
        localObject1 = localListBean.labelTipsList.iterator();
        i1 = 0;
        i4 = i2;
        i3 = i1;
        if (!((Iterator)localObject1).hasNext()) {
          break label1209;
        }
        localObject2 = (MinsuHouseBean.DataBean.ListBean.LabelTips)((Iterator)localObject1).next();
        if (this.a.getResources().getString(2131297164).equals(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).tipsType))
        {
          if (i1 >= 1) {
            break label1705;
          }
          paramu.i.setText(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).name);
          i1 += 1;
        }
      }
      for (;;)
      {
        break;
        if (this.a.getResources().getString(2131297163).equals(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).tipsType))
        {
          localObject3 = (TextView)LayoutInflater.from(this.a).inflate(2130904936, null);
          ((TextView)localObject3).setTextSize(1, 8.0F);
          ((TextView)localObject3).setText(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).name);
          ((TextView)localObject3).setTextColor(this.a.getResources().getColor(2131624487));
          ((TextView)localObject3).getPaint().setFakeBoldText(true);
          ((TextView)localObject3).setBackgroundResource(2130838659);
          paramu.p.addView((View)localObject3);
          ((LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams()).setMargins(0, 0, this.f, 0);
          i2 += 1;
          continue;
          i3 = 0;
          i4 = i2;
          if (i4 == 0)
          {
            paramu.p.setVisibility(8);
            if (i3 != 0) {
              break label1331;
            }
            paramu.i.setVisibility(8);
            paramu.a.setTag(2131689523, localListBean);
            if (this.c != null) {
              break label1361;
            }
            paramu.t.setVisibility(8);
            if ((localListBean.houseStatus != 41) && (localListBean.houseStatus != 50)) {
              break label1449;
            }
            paramu.n.setVisibility(0);
            paramu.h.setVisibility(8);
            paramu.e.setVisibility(8);
            paramu.a.setOnClickListener(null);
          }
          do
          {
            return;
            paramu.p.setVisibility(0);
            break;
            if (this.n)
            {
              paramu.i.setVisibility(0);
              break label1237;
            }
            paramu.i.setVisibility(8);
            break label1237;
            paramu.t.setVisibility(0);
            if (localListBean.isCollect == 1) {
              paramu.t.setImageResource(2130840221);
            }
            for (;;)
            {
              paramu.t.setTag(2131689523, localListBean);
              paramu.t.setTag(2131689526, Integer.valueOf(a(paramInt)));
              paramu.t.setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymousView)
                {
                  VdsAgent.onClick(this, paramAnonymousView);
                  paramAnonymousView = (MinsuHouseBean.DataBean.ListBean)paramAnonymousView.getTag(2131689523);
                  v.onClick(a.a(a.this), "M-Collection_listwant");
                  if (!ApplicationEx.c.isLoginState()) {
                    com.ziroom.commonlibrary.login.a.startLoginActivity(a.a(a.this));
                  }
                  while (a.b(a.this) == null) {
                    return;
                  }
                  if (paramAnonymousView.isCollect == 0)
                  {
                    ((BaseActivity)a.a(a.this)).showProgressNoCancel("正在添加收藏", 20000L);
                    a.a(a.this, paramAnonymousView);
                    a.b(a.this).onCollectClick(paramAnonymousView, true);
                    return;
                  }
                  ((BaseActivity)a.a(a.this)).showProgressNoCancel("正在取消收藏", 20000L);
                  a.b(a.this, paramAnonymousView);
                  a.b(a.this).onCollectClick(paramAnonymousView, false);
                }
              });
              break;
              paramu.t.setImageResource(2130840222);
            }
            paramu.n.setVisibility(8);
            paramu.h.setVisibility(0);
            paramu.e.setVisibility(0);
            paramu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                MinsuHouseBean.DataBean.ListBean localListBean = (MinsuHouseBean.DataBean.ListBean)paramAnonymousView.getTag(2131689523);
                if (localListBean.isTop50Online == 1) {}
                for (paramAnonymousView = new Intent(a.a(a.this), MinsuTopHouseDetailActivity.class);; paramAnonymousView = new Intent(a.a(a.this), MinsuHouseDetailActivity.class))
                {
                  paramAnonymousView.putExtra("fid", localListBean.fid);
                  paramAnonymousView.putExtra("rentWay", localListBean.rentWay);
                  paramAnonymousView.putExtra("startTime", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getStartTime());
                  paramAnonymousView.putExtra("endTime", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getEndTime());
                  paramAnonymousView.putExtra("image", localListBean.picUrl);
                  ((Activity)a.a(a.this)).startActivityForResult(paramAnonymousView, 119);
                  return;
                }
              }
            });
            return;
            if ((paramu instanceof a))
            {
              paramu = (a)paramu;
              if (this.k)
              {
                switch (this.o)
                {
                default: 
                  return;
                case 0: 
                  paramu.b.setText("上拉加载更多...");
                  return;
                }
                paramu.b.setText("正在加载更多数据...");
                return;
              }
              paramu.b.setText("没有更多数据");
              return;
            }
          } while (!(paramu instanceof d));
          localListBean = (MinsuHouseBean.DataBean.ListBean)this.b.get(a(paramInt));
          paramu = (d)paramu;
          paramu.b.setText(localListBean.houseBannerBean.getBannerTitle());
          paramu.d.setText(localListBean.houseBannerBean.getBannerSubtitle());
          if (!TextUtils.isEmpty(localListBean.houseBannerBean.getBannerImg())) {
            com.freelxl.baselibrary.f.c.loadHolderImage(paramu.e, localListBean.houseBannerBean.getBannerImg());
          }
          for (;;)
          {
            paramu.a.setTag(Integer.valueOf(paramInt));
            paramu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                int i = ((Integer)paramAnonymousView.getTag()).intValue();
                a.c(a.this).onBannerItemClick(a.a(a.this, i), localListBean.houseBannerBean.getBannerType());
              }
            });
            return;
            paramu.e.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130840019));
          }
        }
      }
    }
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new b(LayoutInflater.from(this.a).inflate(2130904349, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new a(LayoutInflater.from(this.a).inflate(2130904347, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new d(LayoutInflater.from(this.a).inflate(2130904353, paramViewGroup, false));
    }
    return null;
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.k = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setData(List<MinsuHouseBean.DataBean.ListBean> paramList, c paramc)
  {
    this.b = paramList;
    this.j = paramc;
    notifyDataSetChanged();
  }
  
  public void setLandlordHeaderShow(boolean paramBoolean)
  {
    this.m = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setPricePrivilegeShow(boolean paramBoolean)
  {
    this.n = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setonBannerItemClick(BaseSearchListFragment.a parama)
  {
    this.l = parama;
  }
  
  class a
    extends RecyclerView.u
  {
    View a;
    TextView b;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695336));
    }
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    SimpleDraweeView b;
    SimpleDraweeView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    TextView n;
    View o;
    LinearLayout p;
    LinearLayout q;
    RelativeLayout r;
    RelativeLayout s;
    ImageView t;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.c = ((SimpleDraweeView)paramView.findViewById(2131695295));
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695337));
      this.d = ((TextView)paramView.findViewById(2131691378));
      this.e = ((TextView)paramView.findViewById(2131694215));
      this.f = ((TextView)paramView.findViewById(2131695340));
      this.g = ((TextView)paramView.findViewById(2131695339));
      this.h = ((TextView)paramView.findViewById(2131689912));
      this.m = ((TextView)paramView.findViewById(2131691316));
      this.i = ((TextView)paramView.findViewById(2131695261));
      this.j = ((TextView)paramView.findViewById(2131694747));
      this.k = ((TextView)paramView.findViewById(2131694748));
      this.l = ((TextView)paramView.findViewById(2131694755));
      this.o = paramView.findViewById(2131695270);
      this.o.findViewById(2131694745).setVisibility(0);
      this.p = ((LinearLayout)paramView.findViewById(2131695341));
      this.q = ((LinearLayout)paramView.findViewById(2131694749));
      this.r = ((RelativeLayout)paramView.findViewById(2131694754));
      this.s = ((RelativeLayout)paramView.findViewById(2131694746));
      this.t = ((ImageView)paramView.findViewById(2131691394));
      this.n = ((TextView)paramView.findViewById(2131695338));
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  class d
    extends RecyclerView.u
  {
    View a;
    TextView b;
    TextView c;
    TextView d;
    SimpleDraweeView e;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131689541));
      this.c = ((TextView)paramView.findViewById(2131695351));
      this.d = ((TextView)paramView.findViewById(2131690071));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131695350));
      com.freelxl.baselibrary.f.c.frescoHierarchyController(this.e, 2130840479);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */