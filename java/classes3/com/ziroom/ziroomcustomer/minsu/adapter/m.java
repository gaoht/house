package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.TextView;
import cn.testin.analysis.TestinApi;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.CityCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.CityCardBean.RegionListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.GuideCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelTips;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.minsu.view.b.f.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class m
  extends com.ziroom.ziroomcustomer.minsu.view.b.a<MinsuHouseBean.DataBean.ListBean>
{
  private int a = 1;
  private BaseActivity j;
  private List<MinsuHouseBean.DataBean.GuideCardBean> k;
  private MinsuHouseBean.DataBean.CityCardBean l;
  private String m = "";
  
  public m(BaseActivity paramBaseActivity, List<MinsuHouseBean.DataBean.ListBean> paramList)
  {
    super(paramBaseActivity, 2130904310, paramList);
    this.j = paramBaseActivity;
  }
  
  private void a(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, MinsuHouseBean.DataBean.CityCardBean paramCityCardBean)
  {
    if (paramCityCardBean.cityCode.equals("110100"))
    {
      this.m = TestinApi.getStringFlag("Title", "");
      if (TextUtils.isEmpty(this.m)) {
        paramc.setText(2131689541, paramCityCardBean.colTitle);
      }
    }
    for (;;)
    {
      paramc = (RecyclerView)paramc.getView(2131695268);
      paramCityCardBean = new f(this.b, this.l);
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.b);
      localLinearLayoutManager.setOrientation(0);
      paramc.setLayoutManager(localLinearLayoutManager);
      paramc.addItemDecoration(((f.a)((f.a)new f.a(this.b).color(-1)).sizeResId(2131231165)).build());
      paramc.setAdapter(paramCityCardBean);
      paramCityCardBean.setmOnItemClickListener(new e.a()
      {
        public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousView = (MinsuHouseBean.DataBean.CityCardBean.RegionListBean)m.c(m.this).regionList.get(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (paramAnonymousInt != 0) {
              break label50;
            }
            TestinApi.track("click1");
          }
          for (;;)
          {
            paramAnonymousView = paramAnonymousView.targetUrl;
            com.ziroom.ziroomcustomer.minsu.f.k.goWebNoLogin(m.d(m.this), paramAnonymousView);
            return;
            label50:
            if (paramAnonymousInt == 1) {
              TestinApi.track("click2");
            } else if (paramAnonymousInt == 2) {
              TestinApi.track("click3");
            }
          }
        }
        
        public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          return false;
        }
      });
      return;
      paramc.setText(2131689541, this.m);
      continue;
      paramc.setText(2131689541, paramCityCardBean.colTitle);
    }
  }
  
  private void a(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, MinsuHouseBean.DataBean.GuideCardBean paramGuideCardBean)
  {
    paramc.setText(2131695266, paramGuideCardBean.subTitle + paramGuideCardBean.describe);
    paramc.setText(2131689533, paramGuideCardBean.title);
    paramc.getConvertView().setTag(paramGuideCardBean);
  }
  
  private void a(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean localTonightDiscountInfoVoBean = paramListBean.tonightDiscountInfoVo;
    if (localTonightDiscountInfoVoBean == null)
    {
      paramc.getView(2131694745).setVisibility(8);
      u.e("wz error", " tonightDiscountInfoVo == null");
      return;
    }
    paramc.getView(2131694745).setVisibility(0);
    ((TextView)paramc.getView(2131694747)).setText(this.b.getString(2131297162) + " " + ad.getPriceInt(localTonightDiscountInfoVoBean.getTonightPrice()));
    ((TextView)paramc.getView(2131694748)).setText(localTonightDiscountInfoVoBean.getTipsNname());
    TextView localTextView = (TextView)paramc.getView(2131689912);
    if (paramListBean.tonightDiscountInfoVo.remainTime > 1000L)
    {
      paramc.getView(2131694749).setVisibility(8);
      paramc.getView(2131694754).setVisibility(0);
      paramc.getView(2131694746).setBackgroundColor(this.b.getResources().getColor(2131624475));
      paramc.setText(2131694755, localTonightDiscountInfoVoBean.getOpenTimeListTips());
      localTextView.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
      localTextView.setTextColor(Color.parseColor("#444444"));
      localTextView.setPaintFlags(1312);
      return;
    }
    paramc.getView(2131694749).setVisibility(8);
    paramc.getView(2131694754).setVisibility(0);
    paramc.getView(2131694746).setBackgroundColor(this.b.getResources().getColor(2131624499));
    paramc.setText(2131694755, localTonightDiscountInfoVoBean.getDeadlineTimeListTips());
    if (paramListBean.originalPrice > 0)
    {
      localTextView.setText("¥" + ad.getPriceInt(paramListBean.originalPrice) + "/晚");
      localTextView.setTextColor(Color.parseColor("#999999"));
      localTextView.setPaintFlags(48);
      return;
    }
    localTextView.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
    localTextView.setTextColor(Color.parseColor("#444444"));
    localTextView.setPaintFlags(1312);
  }
  
  private int b(int paramInt)
  {
    return ad.dp2px(this.b, paramInt);
  }
  
  private void b()
  {
    if (((this.l == null) || ((this.l != null) && (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.l.regionList)))) && (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.k))) {
      return;
    }
    int n;
    int i;
    label78:
    MinsuHouseBean.DataBean.ListBean localListBean;
    if ((this.l == null) || (this.l.regionList == null))
    {
      n = -1;
      if ((this.k != null) && (this.k.size() != 0)) {
        break label193;
      }
      i = -1;
      int i1 = i;
      if (n == i) {
        i1 = -1;
      }
      if (n != -1)
      {
        localListBean = new MinsuHouseBean.DataBean.ListBean();
        localListBean.type = 1;
        if (this.d.size() > n) {
          break label213;
        }
        this.d.add(localListBean);
      }
      label132:
      if (i1 != -1)
      {
        localListBean = new MinsuHouseBean.DataBean.ListBean();
        localListBean.type = 2;
        if (i1 >= this.d.size()) {
          break label228;
        }
        this.d.add(i1, localListBean);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      n = this.l.index;
      break;
      label193:
      i = ((MinsuHouseBean.DataBean.GuideCardBean)this.k.get(0)).index;
      break label78;
      label213:
      this.d.add(n, localListBean);
      break label132;
      label228:
      this.d.add(localListBean);
    }
  }
  
  protected void a(ViewGroup paramViewGroup, com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, int paramInt)
  {
    super.a(paramViewGroup, paramc, paramInt);
  }
  
  protected void a(final ImageView paramImageView, MinsuHouseBean.DataBean.ListBean paramListBean, final int paramInt)
  {
    this.j.showProgressNoCancel("正在取消收藏", 20000L);
    com.ziroom.ziroomcustomer.minsu.e.a.unCollectHouse(this.j, paramListBean.fid, paramListBean.rentWay, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseCancelCollectResultBean localMinsuHouseCancelCollectResultBean = (MinsuHouseCancelCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCancelCollectResultBean != null) && (localMinsuHouseCancelCollectResultBean.checkSuccess(m.b(m.this))) && ("0".equals(localMinsuHouseCancelCollectResultBean.data.delCollResult)))
        {
          u.e("lanzhihong", "ro======" + localMinsuHouseCancelCollectResultBean.toString());
          ((MinsuHouseBean.DataBean.ListBean)m.this.getDatas().get(paramInt)).isCollect = 0;
          g.textToast(m.b(m.this), "取消收藏成功");
          int i = ((Integer)paramImageView.getTag(2131689526)).intValue();
          u.e("error", "index ==" + paramInt + " currentIndex == " + i);
          if (i == paramInt) {
            paramImageView.setImageResource(2130840220);
          }
          m.b(m.this).dismissProgress();
          return;
        }
        if (localMinsuHouseCancelCollectResultBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseCancelCollectResultBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          break;
        }
      }
    });
  }
  
  public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, final MinsuHouseBean.DataBean.ListBean paramListBean, final int paramInt)
  {
    if ((paramc.getAdapterPosition() == 0) && (this.a == 2))
    {
      paramc.getView(2131691413).setVisibility(0);
      if (paramListBean.type != 1) {
        break label116;
      }
      paramc.getView(2131695265).setVisibility(8);
      paramc.getView(2131695258).setVisibility(8);
      paramc.getView(2131695267).setVisibility(0);
      a(paramc, this.l);
    }
    label116:
    final Object localObject1;
    Object localObject2;
    int i;
    label669:
    label738:
    label793:
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (paramc.getPosition() == getItemCount() - 1)
      {
        paramc.setVisibility(2131689590, 0);
        return;
        paramc.getView(2131691413).setVisibility(8);
        break;
        if (paramListBean.type == 2)
        {
          if ((this.k != null) && (this.k.size() != 0) && (paramc.getAdapterPosition() == ((MinsuHouseBean.DataBean.GuideCardBean)this.k.get(0)).index))
          {
            paramc.getView(2131695265).setVisibility(0);
            paramc.getView(2131695258).setVisibility(8);
            paramc.getView(2131695267).setVisibility(8);
            a(paramc, (MinsuHouseBean.DataBean.GuideCardBean)this.k.get(0));
          }
        }
        else
        {
          paramc.getView(2131695265).setVisibility(8);
          paramc.getView(2131695267).setVisibility(8);
          paramc.getView(2131695258).setVisibility(0);
          ((SimpleDraweeView)paramc.getView(2131695249)).setController(com.freelxl.baselibrary.f.c.frescoController(paramListBean.picUrl, new BasePostprocessor()
          {
            public void process(Bitmap paramAnonymousBitmap)
            {
              super.process(paramAnonymousBitmap);
            }
          }));
          ((SimpleDraweeView)paramc.getView(2131695264)).setHierarchy(d.getRoundingHierarchy(this.b));
          ((SimpleDraweeView)paramc.getView(2131695264)).setController(com.freelxl.baselibrary.f.c.frescoController(paramListBean.landlordUrl));
          paramc.setText(2131695250, paramListBean.houseName);
          paramc.getView(2131695264).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              com.ziroom.ziroomcustomer.minsu.f.k.toLandlordDetailActivty(m.a(m.this), paramListBean.landlordUid);
            }
          });
          localObject1 = new ArrayList();
          if ((ae.isNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) && (!ae.isNull(paramListBean.cityName))) {
            ((List)localObject1).add(paramListBean.cityName);
          }
          ((List)localObject1).add(paramListBean.rentWayName);
          if (paramListBean.personCount > 0) {
            ((List)localObject1).add("可住" + paramListBean.personCount + "人");
          }
          for (;;)
          {
            localObject2 = new StringBuilder();
            i = ((List)localObject1).size();
            paramInt = 0;
            while (paramInt < i)
            {
              ((StringBuilder)localObject2).append((String)((List)localObject1).get(paramInt));
              if (paramInt < i - 1)
              {
                ((StringBuilder)localObject2).append(this.b.getString(2131297451));
                ((StringBuilder)localObject2).append(this.b.getString(2131297451));
                ((StringBuilder)localObject2).append("|");
                ((StringBuilder)localObject2).append(this.b.getString(2131297451));
                ((StringBuilder)localObject2).append(this.b.getString(2131297451));
              }
              paramInt += 1;
            }
            if (paramListBean.personCount == 0) {
              ((List)localObject1).add("不限人数");
            }
          }
          ac.colorMulti((TextView)paramc.getView(2131695251), ((StringBuilder)localObject2).toString(), "|", this.b.getResources().getColor(2131624046));
          if (paramListBean.evaluateCount == 0)
          {
            paramc.getView(2131695252).setVisibility(8);
            paramc.getView(2131695262).setVisibility(8);
            paramc.setText(2131689912, "¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
            ((TextView)paramc.getView(2131689912)).getPaint().setFakeBoldText(true);
            if (paramListBean.isToNightDiscount != 1) {
              break label1124;
            }
            a(paramc, paramListBean);
            localObject1 = (LinearLayout)paramc.getView(2131693065);
            ((LinearLayout)localObject1).setVisibility(0);
            ((LinearLayout)localObject1).removeAllViews();
            if ((paramListBean.labelInfoList == null) || (paramListBean.labelInfoList.size() <= 0)) {
              break label1168;
            }
            localObject2 = paramListBean.labelInfoList.iterator();
            paramInt = 0;
            i = paramInt;
            if (!((Iterator)localObject2).hasNext()) {
              break label1171;
            }
            localObject4 = (MinsuHouseBean.DataBean.ListBean.LabelInfo)((Iterator)localObject2).next();
            if (!"isSpeed".equals(((MinsuHouseBean.DataBean.ListBean.LabelInfo)localObject4).code)) {
              break label1592;
            }
            localObject3 = new SimpleDraweeView(this.b);
            ((SimpleDraweeView)localObject3).setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuHouseBean.DataBean.ListBean.LabelInfo)localObject4).iconUrl));
            localObject4 = new LinearLayout.LayoutParams(b(22), -1);
            ((SimpleDraweeView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((LinearLayout)localObject1).addView((View)localObject3);
            ((LinearLayout.LayoutParams)localObject4).setMargins(b(0), b(0), b(6), b(0));
            paramInt = paramInt + 1 + 1;
            localObject3 = new TextView(this.b);
            localObject4 = new LinearLayout.LayoutParams(b(52), -2);
            ((TextView)localObject3).setText("立即预订");
            ((TextView)localObject3).setTextSize(1, 8.0F);
            ((TextView)localObject3).setTextColor(this.b.getResources().getColor(2131624487));
            ((TextView)localObject3).getPaint().setFakeBoldText(true);
            ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((LinearLayout)localObject1).addView((View)localObject3);
            ((LinearLayout.LayoutParams)localObject4).setMargins(b(-12), b(0), b(0), b(0));
          }
        }
      }
    }
    label1124:
    label1168:
    label1171:
    label1203:
    label1421:
    label1438:
    label1453:
    label1555:
    label1567:
    label1589:
    label1592:
    for (;;)
    {
      break label793;
      paramc.getView(2131695252).setVisibility(0);
      paramc.getView(2131695262).setVisibility(0);
      paramc.setText(2131695252, "评价 " + paramListBean.evaluateCount);
      paramc.setText(2131695262, paramListBean.realEvaluateScore + "分");
      break label669;
      paramc.getView(2131694745).setVisibility(8);
      localObject1 = (TextView)paramc.getView(2131689912);
      ((TextView)localObject1).setTextColor(Color.parseColor("#444444"));
      ((TextView)localObject1).setPaintFlags(1312);
      break label738;
      i = 0;
      int i1;
      int n;
      if ((paramListBean.labelTipsList != null) && (paramListBean.labelTipsList.size() > 0))
      {
        localObject2 = paramListBean.labelTipsList.iterator();
        paramInt = 0;
        i1 = i;
        n = paramInt;
        if (!((Iterator)localObject2).hasNext()) {
          break label1421;
        }
        localObject3 = (MinsuHouseBean.DataBean.ListBean.LabelTips)((Iterator)localObject2).next();
        if (this.b.getResources().getString(2131297164).equals(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject3).tipsType))
        {
          if (paramInt >= 1) {
            break label1589;
          }
          paramc.setText(2131695261, ((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject3).name);
          paramInt += 1;
        }
      }
      for (;;)
      {
        break label1203;
        if (this.b.getResources().getString(2131297163).equals(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject3).tipsType))
        {
          localObject4 = (TextView)LayoutInflater.from(this.b).inflate(2130904936, null);
          ((TextView)localObject4).setTextSize(1, 8.0F);
          ((TextView)localObject4).setText(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject3).name);
          ((TextView)localObject4).setTextColor(this.b.getResources().getColor(2131624487));
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
          ((TextView)localObject4).setBackgroundResource(2130838659);
          ((LinearLayout)localObject1).addView((View)localObject4);
          ((LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams()).setMargins(0, 0, b(6), 0);
          i += 1;
          continue;
          n = 0;
          i1 = i;
          if (i1 == 0)
          {
            paramc.getView(2131693065).setVisibility(8);
            if (n != 0) {
              break label1555;
            }
            paramc.setVisibility(2131695261, 8);
            paramc.getConvertView().setTag(2131689523, paramListBean);
            paramInt = getDatas().indexOf(paramListBean);
            localObject1 = (ImageView)paramc.getView(2131695260);
            if (paramListBean.isCollect != 1) {
              break label1567;
            }
            ((ImageView)localObject1).setImageResource(2130840221);
          }
          for (;;)
          {
            ((ImageView)localObject1).setTag(paramListBean);
            ((ImageView)localObject1).setTag(2131689526, Integer.valueOf(paramInt));
            ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(final View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                u.e("test", "onclick p = " + paramInt + " index = " + paramInt);
                v.onClick(m.b(m.this), "M-Collection_listwant");
                if (!ApplicationEx.c.isLoginState())
                {
                  com.ziroom.commonlibrary.login.a.startLoginActivity(m.b(m.this));
                  return;
                }
                if (paramListBean.isCollect == 0)
                {
                  m.b(m.this).showProgressNoCancel("正在添加收藏", 20000L);
                  com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(m.b(m.this), paramListBean.fid, paramListBean.rentWay, new i.a()
                  {
                    public void onParse(String paramAnonymous2String, com.freelxl.baselibrary.e.k paramAnonymous2k) {}
                    
                    public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymous2k)
                    {
                      MinsuHouseCollectResultBean localMinsuHouseCollectResultBean = (MinsuHouseCollectResultBean)paramAnonymous2k.getObject();
                      if ((paramAnonymous2k.getSuccess().booleanValue()) && (localMinsuHouseCollectResultBean != null) && (localMinsuHouseCollectResultBean.checkSuccess(m.b(m.this))) && (localMinsuHouseCollectResultBean.data != null) && ("0".equals(localMinsuHouseCollectResultBean.data.collResult)))
                      {
                        u.e("lanzhihong", "ro======" + localMinsuHouseCollectResultBean.toString());
                        ((MinsuHouseBean.DataBean.ListBean)m.this.getDatas().get(m.3.this.a)).isCollect = 1;
                        int i = ((Integer)paramAnonymousView.getTag(2131689526)).intValue();
                        u.e("error", "index ==" + m.3.this.a + " currentIndex == " + i);
                        if (i == m.3.this.a) {
                          m.3.this.c.setImageResource(2130840221);
                        }
                        g.textToast(m.b(m.this), "收藏成功");
                        m.b(m.this).dismissProgress();
                        return;
                      }
                      if (localMinsuHouseCollectResultBean == null) {}
                      for (paramAnonymous2k = null;; paramAnonymous2k = localMinsuHouseCollectResultBean.message)
                      {
                        ad.shouErrorMessage(paramAnonymous2k);
                        break;
                      }
                    }
                  });
                  return;
                }
                m.this.a(localObject1, paramListBean, paramInt);
              }
            });
            break;
            paramc.getView(2131693065).setVisibility(0);
            break label1438;
            paramc.setVisibility(2131695261, 0);
            break label1453;
            ((ImageView)localObject1).setImageResource(2130840220);
          }
          paramc.setVisibility(2131689590, 8);
          return;
        }
      }
    }
  }
  
  public int getType()
  {
    return this.a;
  }
  
  public void setCityCardBean(MinsuHouseBean.DataBean.CityCardBean paramCityCardBean)
  {
    this.l = paramCityCardBean;
    b();
  }
  
  public void setGuideCardList(List<MinsuHouseBean.DataBean.GuideCardBean> paramList)
  {
    this.k = paramList;
  }
  
  public void setType(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */