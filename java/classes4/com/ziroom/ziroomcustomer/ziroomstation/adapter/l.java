package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.ApplyRefundActivity;
import com.ziroom.ziroomcustomer.ziroomstation.OrderDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.ShowEvaluateActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationEvaluateActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationOrderListActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationUnEvaOrderListActivity;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel.DataBean.HouseTypeInfoBean;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class l
  extends BaseAdapter
{
  private String a = l.class.getSimpleName();
  private Context b;
  private List<StationOrderListModel.DataBean> c;
  private LayoutInflater d;
  private boolean e = true;
  
  public l(List<StationOrderListModel.DataBean> paramList, Context paramContext)
  {
    this.c = paramList;
    this.b = paramContext;
    this.d = LayoutInflater.from(paramContext);
  }
  
  private void a()
  {
    if ((this.b instanceof StationOrderListActivity)) {
      ((StationOrderListActivity)this.b).initData();
    }
    while (!(this.b instanceof StationUnEvaOrderListActivity)) {
      return;
    }
    ((StationUnEvaOrderListActivity)this.b).initData();
  }
  
  private void a(int paramInt)
  {
    if ((this.b instanceof StationOrderListActivity))
    {
      ((StationOrderListActivity)this.b).setPayOrderDialog(new com.ziroom.ziroomcustomer.ziroomstation.dialog.c(this.b, ((StationOrderListModel.DataBean)this.c.get(paramInt)).paymentNumber, ((StationOrderListModel.DataBean)this.c.get(paramInt)).amount, 3));
      ((StationOrderListActivity)this.b).getPayOrderDialog().show();
    }
    while (!(this.b instanceof StationUnEvaOrderListActivity)) {
      return;
    }
    ((StationUnEvaOrderListActivity)this.b).setPayOrderDialog(new com.ziroom.ziroomcustomer.ziroomstation.dialog.c(this.b, ((StationOrderListModel.DataBean)this.c.get(paramInt)).paymentNumber, ((StationOrderListModel.DataBean)this.c.get(paramInt)).amount, 3));
    ((StationUnEvaOrderListActivity)this.b).getPayOrderDialog().show();
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    if ((this.b instanceof StationOrderListActivity)) {
      ((StationOrderListActivity)this.b).startActivityForResult(paramIntent, paramInt);
    }
    while (!(this.b instanceof StationUnEvaOrderListActivity)) {
      return;
    }
    ((StationUnEvaOrderListActivity)this.b).startActivityForResult(paramIntent, paramInt);
  }
  
  private void a(b paramb, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    paramb.c.setText(paramString1);
    switch (paramInt1)
    {
    default: 
      return;
    case 5: 
      paramb.c.setBackgroundResource(2130839579);
      paramb.l.setVisibility(0);
      paramb.f.setVisibility(0);
      paramb.i.setVisibility(0);
      paramb.h.setVisibility(0);
      paramb.j.setVisibility(8);
      paramb.k.setVisibility(8);
      paramb.g.setVisibility(8);
      paramb.m.setVisibility(0);
      setButtonListener(paramb, paramInt2);
      return;
    case 7: 
      paramb.c.setBackgroundResource(2130839578);
      paramb.l.setVisibility(8);
      paramb.f.setVisibility(8);
      paramb.i.setVisibility(8);
      paramb.h.setVisibility(8);
      paramb.j.setVisibility(8);
      paramb.k.setVisibility(8);
      paramb.g.setVisibility(8);
      paramb.m.setVisibility(8);
      return;
    case 1: 
      paramb.c.setBackgroundResource(2130839580);
      paramb.l.setVisibility(0);
      paramb.f.setVisibility(8);
      paramb.i.setVisibility(8);
      paramb.h.setVisibility(0);
      paramb.j.setVisibility(0);
      paramb.k.setVisibility(8);
      paramb.g.setVisibility(0);
      paramb.m.setVisibility(0);
      setButtonListener(paramb, paramInt2);
      return;
    case 2: 
      paramb.c.setBackgroundResource(2130839580);
      paramb.l.setVisibility(0);
      paramb.f.setVisibility(8);
      paramb.i.setVisibility(8);
      paramb.h.setVisibility(8);
      paramb.j.setVisibility(0);
      paramb.k.setVisibility(8);
      paramb.g.setVisibility(8);
      paramb.m.setVisibility(0);
      setButtonListener(paramb, paramInt2);
      return;
    case 6: 
      paramb.c.setBackgroundResource(2130839578);
      paramb.l.setVisibility(0);
      paramb.f.setVisibility(8);
      paramb.i.setVisibility(8);
      paramb.h.setVisibility(8);
      paramb.j.setVisibility(8);
      paramb.k.setVisibility(0);
      if ("2".equals(paramString2))
      {
        paramb.k.setVisibility(8);
        paramb.l.setVisibility(8);
        paramb.m.setVisibility(8);
      }
      paramb.g.setVisibility(8);
      paramb.m.setVisibility(0);
      setButtonListener(paramb, paramInt2);
      return;
    case 3: 
      paramb.c.setBackgroundResource(2130839577);
      paramb.l.setVisibility(8);
      paramb.f.setVisibility(8);
      paramb.i.setVisibility(8);
      paramb.h.setVisibility(8);
      paramb.j.setVisibility(8);
      paramb.k.setVisibility(8);
      paramb.g.setVisibility(8);
      paramb.m.setVisibility(8);
      return;
    }
    paramb.c.setBackgroundResource(2130839577);
    paramb.l.setVisibility(8);
    paramb.f.setVisibility(8);
    paramb.i.setVisibility(8);
    paramb.h.setVisibility(8);
    paramb.j.setVisibility(8);
    paramb.k.setVisibility(8);
    paramb.g.setVisibility(8);
    paramb.m.setVisibility(8);
  }
  
  public int getCount()
  {
    if (this.c != null) {
      return this.c.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.d.inflate(2130904547, paramViewGroup, false);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.b.setText(((StationOrderListModel.DataBean)this.c.get(paramInt)).projectName);
      a(paramViewGroup, ((StationOrderListModel.DataBean)this.c.get(paramInt)).orderStatus, ((StationOrderListModel.DataBean)this.c.get(paramInt)).orderStatusDesc, paramInt, ((StationOrderListModel.DataBean)this.c.get(paramInt)).isEvaluate);
      paramViewGroup.d.setText("¥" + ((StationOrderListModel.DataBean)this.c.get(paramInt)).amount);
      if ((((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo == null) || (((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.size() <= 0)) {
        break;
      }
      paramViewGroup.e.removeAllViews();
      int i = 0;
      while (i < ((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.size())
      {
        View localView = this.d.inflate(2130904548, null);
        a locala = new a(localView);
        locala.c.setTag(((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.get(i)).imgUrl);
        locala.c.setController(com.freelxl.baselibrary.f.c.frescoController(((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.get(i)).imgUrl));
        locala.e.setText(((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.get(i)).houseName);
        locala.f.setText(((StationOrderListModel.DataBean)this.c.get(paramInt)).startDate);
        locala.g.setText(((StationOrderListModel.DataBean)this.c.get(paramInt)).endDate);
        locala.h.setText(((StationOrderListModel.DataBean)this.c.get(paramInt)).nights + "晚");
        locala.i.setText(((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)this.c.get(paramInt)).houseTypeInfo.get(i)).bedCount + "床");
        paramViewGroup.e.addView(localView);
        i += 1;
      }
      paramViewGroup = (b)paramView.getTag();
    }
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (l.a(l.this))
        {
          paramAnonymousView = new Intent(l.b(l.this), OrderDetailActivity.class);
          paramAnonymousView.putExtra("orderBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderBid);
          l.b(l.this).startActivity(paramAnonymousView);
        }
        for (;;)
        {
          switch (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderStatus)
          {
          default: 
            return;
            Intent localIntent = new Intent(l.b(l.this), StationEvaluateActivity.class);
            localIntent.putExtra("dName", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).name);
            localIntent.putExtra("phone", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).phone);
            localIntent.putExtra("orderBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderBid);
            localIntent.putExtra("orderNumber", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderNumber);
            localIntent.putExtra("projectBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).projectBid);
            String str = "";
            paramAnonymousView = str;
            if (l.c(l.this) != null)
            {
              paramAnonymousView = str;
              if (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo != null)
              {
                paramAnonymousView = str;
                if (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.size() > 0)
                {
                  paramAnonymousView = "";
                  int i = 0;
                  if (i < ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.size())
                  {
                    if (i == 0) {}
                    for (paramAnonymousView = ((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.get(i)).houseName;; paramAnonymousView = paramAnonymousView + "," + ((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.get(i)).houseName)
                    {
                      i += 1;
                      break;
                    }
                  }
                }
              }
            }
            localIntent.putExtra("houseTypeNames", paramAnonymousView);
            l.a(l.this, localIntent, 3);
          }
        }
        w.onEventToZiroomAndUmeng("zinn_list_yzf_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_yrz_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_tkz_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_ytk_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_dzf_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_ytf_enter");
        return;
        w.onEventToZiroomAndUmeng("zinn_list_yqx_enter");
      }
    });
    return paramView;
  }
  
  public List<StationOrderListModel.DataBean> getmData()
  {
    return this.c;
  }
  
  public void setButtonListener(b paramb, final int paramInt)
  {
    paramb.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        i.commonOkDialog(l.b(l.this), "您确认取消该订单？", new com.ziroom.ziroomcustomer.ziroomstation.utils.i.a()
        {
          public void okCallback()
          {
            com.ziroom.ziroomcustomer.ziroomstation.b.c.cancelOrder(l.b(l.this), b.buildCancelOrder(l.b(l.this), ((StationOrderListModel.DataBean)l.c(l.this).get(l.2.this.a)).orderBid), new com.freelxl.baselibrary.e.i.a()
            {
              public void onParse(String paramAnonymous3String, k paramAnonymous3k) {}
              
              public void onSuccess(k paramAnonymous3k)
              {
                af.showToast(l.b(l.this), "取消成功");
                l.d(l.this);
              }
            }, true);
          }
        });
        w.onEventToZiroomAndUmeng("zinn_list_dzf_cancel");
      }
    });
    paramb.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        l.a(l.this, paramInt);
      }
    });
    paramb.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).sellPhone))
        {
          af.showToast(l.b(l.this), "未登记电话，请联系客服");
          return;
        }
        ah.callPhone(l.b(l.this), ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).sellPhone);
        switch (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderStatus)
        {
        default: 
          return;
        case 1: 
          w.onEventToZiroomAndUmeng("zinn_list_yzf_complain");
          return;
        case 3: 
          w.onEventToZiroomAndUmeng("zinn_list_tkz_complain");
          return;
        }
        w.onEventToZiroomAndUmeng("zinn_list_yrz_complain");
      }
    });
    paramb.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ("1".equals(((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).isEvaluate))
        {
          Intent localIntent = new Intent(l.b(l.this), StationEvaluateActivity.class);
          localIntent.putExtra("dName", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).name);
          localIntent.putExtra("phone", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).phone);
          localIntent.putExtra("orderBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderBid);
          localIntent.putExtra("orderNumber", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderNumber);
          localIntent.putExtra("projectBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).projectBid);
          String str = "";
          paramAnonymousView = str;
          if (l.c(l.this) != null)
          {
            paramAnonymousView = str;
            if (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo != null)
            {
              paramAnonymousView = str;
              if (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.size() > 0)
              {
                paramAnonymousView = "";
                int i = 0;
                if (i < ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.size())
                {
                  if (i == 0) {}
                  for (paramAnonymousView = ((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.get(i)).houseName;; paramAnonymousView = paramAnonymousView + "," + ((StationOrderListModel.DataBean.HouseTypeInfoBean)((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).houseTypeInfo.get(i)).houseName)
                  {
                    i += 1;
                    break;
                  }
                }
              }
            }
          }
          localIntent.putExtra("houseTypeNames", paramAnonymousView);
          l.a(l.this, localIntent, 3);
          w.onEventToZiroomAndUmeng("zinn_list_ytf_eva");
          return;
        }
        paramAnonymousView = new Intent(l.b(l.this), ShowEvaluateActivity.class);
        l.b(l.this).startActivity(paramAnonymousView);
      }
    });
    paramb.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(l.b(l.this), ApplyRefundActivity.class);
        paramAnonymousView.putExtra("orderBid", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderBid);
        SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日");
        try
        {
          paramAnonymousView.putExtra("start", localSimpleDateFormat2.format(localSimpleDateFormat1.parse(i.checkString(((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).startDate))));
          paramAnonymousView.putExtra("end", localSimpleDateFormat2.format(localSimpleDateFormat1.parse(i.checkString(((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).endDate))));
          paramAnonymousView.putExtra("name", ((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).name);
          l.a(l.this, paramAnonymousView, 2);
          switch (((StationOrderListModel.DataBean)l.c(l.this).get(paramInt)).orderStatus)
          {
          default: 
            return;
          }
        }
        catch (ParseException localParseException)
        {
          for (;;)
          {
            paramAnonymousView.putExtra("start", "未知");
            paramAnonymousView.putExtra("end", "未知");
          }
          w.onEventToZiroomAndUmeng("zinn_list_yzf_payback");
          return;
        }
        w.onEventToZiroomAndUmeng("zinn_list_yrz_payback");
      }
    });
  }
  
  public void setDatas(List<StationOrderListModel.DataBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public View a;
    public ImageView b;
    public SimpleDraweeView c;
    public FrameLayout d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public RelativeLayout j;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((ImageView)paramView.findViewById(2131695719));
      this.c = ((SimpleDraweeView)paramView.findViewById(2131695720));
      this.d = ((FrameLayout)paramView.findViewById(2131695718));
      this.e = ((TextView)paramView.findViewById(2131695721));
      this.f = ((TextView)paramView.findViewById(2131695722));
      this.g = ((TextView)paramView.findViewById(2131695723));
      this.h = ((TextView)paramView.findViewById(2131695724));
      this.i = ((TextView)paramView.findViewById(2131695725));
      this.j = ((RelativeLayout)paramView.findViewById(2131690430));
    }
  }
  
  public static class b
  {
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public LinearLayout e;
    public Button f;
    public Button g;
    public View h;
    public Button i;
    public Button j;
    public Button k;
    public LinearLayout l;
    public View m;
    
    public b(View paramView)
    {
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695708));
      this.c = ((TextView)paramView.findViewById(2131695709));
      this.d = ((TextView)paramView.findViewById(2131695711));
      this.e = ((LinearLayout)paramView.findViewById(2131695710));
      this.f = ((Button)paramView.findViewById(2131695712));
      this.g = ((Button)paramView.findViewById(2131695713));
      this.h = paramView.findViewById(2131695714);
      this.i = ((Button)paramView.findViewById(2131695715));
      this.j = ((Button)paramView.findViewById(2131695716));
      this.k = ((Button)paramView.findViewById(2131692516));
      this.l = ((LinearLayout)paramView.findViewById(2131689498));
      this.m = paramView.findViewById(2131695717);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */