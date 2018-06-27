package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean.DataBean.RowsBean.LabelInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Iterator;
import java.util.List;

public class l
  extends com.ziroom.ziroomcustomer.minsu.a.a<MinsuHouseCollectBean.DataBean.RowsBean>
{
  private BaseActivity d;
  
  public l(BaseActivity paramBaseActivity, List<MinsuHouseCollectBean.DataBean.RowsBean> paramList)
  {
    super(paramBaseActivity, paramList, 2130904310);
    this.d = paramBaseActivity;
  }
  
  private int a(int paramInt)
  {
    return ad.dp2px(this.a, paramInt);
  }
  
  protected void a(final MinsuHouseCollectBean.DataBean.RowsBean paramRowsBean)
  {
    this.d.showProgressNoCancel("正在取消收藏", 20000L);
    com.ziroom.ziroomcustomer.minsu.e.a.unCollectHouse(this.d, paramRowsBean.fid, paramRowsBean.rentWay.intValue(), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        u.e("lanzhihong", "str======" + paramAnonymousString);
        paramAnonymousk.setObject(paramAnonymousString);
        l.a(l.this).dismissProgress();
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuHouseCancelCollectResultBean localMinsuHouseCancelCollectResultBean = (MinsuHouseCancelCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCancelCollectResultBean != null) && (localMinsuHouseCancelCollectResultBean.checkSuccess(l.a(l.this))) && ("0".equals(localMinsuHouseCancelCollectResultBean.data.delCollResult)))
        {
          u.e("lanzhihong", "ro======" + localMinsuHouseCancelCollectResultBean.toString());
          g.textToast(l.a(l.this), "已经取消收藏");
          l.this.getDatas().remove(paramRowsBean);
          l.this.notifyDataSetChanged();
          l.a(l.this).dismissProgress();
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
  
  public void convert(b paramb, final MinsuHouseCollectBean.DataBean.RowsBean paramRowsBean)
  {
    Object localObject2;
    if (paramRowsBean.houseStatus.intValue() == 41)
    {
      ((SimpleDraweeView)paramb.getView(2131695249)).setHierarchy(d.getCollectHouseOffLineHierarchy(this.a));
      ((SimpleDraweeView)paramb.getView(2131695249)).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject2 = (SimpleDraweeView)paramb.getView(2131695249);
      if (!ae.isNull(paramRowsBean.picUrl)) {
        break label420;
      }
      localObject1 = "";
      label71:
      ((SimpleDraweeView)localObject2).setImageURI(Uri.parse((String)localObject1));
      ((SimpleDraweeView)paramb.getView(2131695264)).setHierarchy(d.getRoundingHierarchy(this.a));
      ((SimpleDraweeView)paramb.getView(2131695264)).setController(com.freelxl.baselibrary.f.c.frescoController(paramRowsBean.landlordUrl));
      if (paramRowsBean.houseStatus.intValue() != 41) {
        break label429;
      }
      paramb.setVisibility(2131695259, 0);
      paramb.setText(2131695259, this.a.getString(2131296803));
      label155:
      paramb.setText(2131695250, paramRowsBean.houseName);
      localObject1 = null;
      if (paramRowsBean.personCount != null) {
        break label441;
      }
      label176:
      paramb.setText(2131695251, (String)localObject1);
      if ((paramRowsBean.evaluateCount != null) && (paramRowsBean.evaluateCount.intValue() != 0)) {
        break label578;
      }
      paramb.setVisibility(2131695252, 8);
      label211:
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramRowsBean.price)) {
        break label619;
      }
      paramb.setVisibility(2131689912, 8);
    }
    for (;;)
    {
      if ((paramRowsBean.labelInfoList == null) || (paramRowsBean.labelInfoList.size() <= 0)) {
        break label672;
      }
      localObject1 = (LinearLayout)paramb.getView(2131693065);
      ((LinearLayout)localObject1).setVisibility(0);
      if (((LinearLayout)localObject1).getChildCount() > 0) {
        ((LinearLayout)localObject1).removeAllViews();
      }
      localObject2 = paramRowsBean.labelInfoList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (MinsuHouseCollectBean.DataBean.RowsBean.LabelInfo)((Iterator)localObject2).next();
        SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.a);
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuHouseCollectBean.DataBean.RowsBean.LabelInfo)localObject3).iconUrl));
        localObject3 = new ViewGroup.MarginLayoutParams(a(22), -1);
        ((ViewGroup.MarginLayoutParams)localObject3).setMargins(a(6), a(0), a(6), a(0));
        localSimpleDraweeView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((LinearLayout)localObject1).addView(localSimpleDraweeView);
      }
      ((SimpleDraweeView)paramb.getView(2131695249)).setHierarchy(d.getHierarchy(this.a));
      break;
      label420:
      localObject1 = paramRowsBean.picUrl;
      break label71;
      label429:
      paramb.setVisibility(2131695259, 8);
      break label155;
      label441:
      if (paramRowsBean.personCount.intValue() > 0)
      {
        localObject2 = new StringBuilder();
        if (paramRowsBean.rentWay.intValue() == 0) {}
        for (localObject1 = "整套出租 | ";; localObject1 = "独立房间 | ")
        {
          localObject1 = (String)localObject1 + "可住" + paramRowsBean.personCount + "人";
          break;
        }
      }
      if (paramRowsBean.personCount.intValue() != 0) {
        break label176;
      }
      localObject2 = new StringBuilder();
      if (paramRowsBean.rentWay.intValue() == 0) {}
      for (localObject1 = "整套出租 | ";; localObject1 = "独立房间 | ")
      {
        localObject1 = (String)localObject1 + "不限人数";
        break;
      }
      label578:
      paramb.setVisibility(2131695252, 0);
      paramb.setText(2131695252, "评价 " + paramRowsBean.evaluateCount);
      break label211;
      label619:
      paramb.setVisibility(2131689912, 0);
      paramb.setText(2131689912, "¥ " + ad.getPriceInt(paramRowsBean.price.intValue()) + "/晚");
    }
    label672:
    paramb.getView(2131693065).setVisibility(8);
    final int i = getDatas().indexOf(paramRowsBean);
    Object localObject1 = (ImageView)paramb.getView(2131695260);
    ((ImageView)localObject1).setImageResource(2130840221);
    ((ImageView)localObject1).setTag(paramRowsBean);
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        u.e("test", "onclick  index = " + i);
        l.this.a(paramRowsBean);
      }
    });
    paramb.setVisibility(2131694745, 8);
  }
  
  public void initView(View paramView) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */