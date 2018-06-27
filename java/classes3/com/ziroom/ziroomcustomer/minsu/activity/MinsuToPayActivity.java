package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.a.a;
import com.ziroom.commonlibrary.e.c;
import com.ziroom.commonlibrary.e.c.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.FeeItemListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuPayVo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUPPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUPPayBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUPPayBean.DataBean.PayBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class MinsuToPayActivity
  extends BaseActivity
{
  private CommonTitle a;
  private String b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private b r = b.d;
  private ListView s;
  private LinkedHashMap<String, String> t = new LinkedHashMap();
  private ArrayList<String> u = new ArrayList();
  private List<a> v = new ArrayList();
  private c w;
  private WxReceiver x;
  private com.ziroom.commonlibrary.e.d y;
  private Handler z;
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.ziroomcustomer.activity_1");
    this.x = new WxReceiver();
    registerReceiver(this.x, localIntentFilter);
  }
  
  private void b()
  {
    Object localObject = com.alibaba.fastjson.a.parseArray(getIntent().getStringExtra("feesList"), FeeItemListBean.class);
    if ((localObject != null) && (((List)localObject).size() > 1))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FeeItemListBean localFeeItemListBean = (FeeItemListBean)((Iterator)localObject).next();
        this.t.put(localFeeItemListBean.name, localFeeItemListBean.fee + "");
        if (localFeeItemListBean.colorType.intValue() != 0) {
          this.u.add(localFeeItemListBean.name);
        }
      }
    }
    this.b = getIntent().getStringExtra("orderSn");
    this.c = getIntent().getIntExtra("price", -1);
    this.d = getIntent().getStringExtra("time");
    this.e = getIntent().getStringExtra("houseImg");
    this.f = getIntent().getStringExtra("houseName");
    this.g = getIntent().getStringExtra("rentWay");
  }
  
  private void e()
  {
    this.s = ((ListView)findViewById(2131691217));
    this.v.add(new a(2130838709, "支付宝", Boolean.valueOf(true), b.d));
    this.v.add(new a(2130839085, "微信支付", Boolean.valueOf(false), b.c));
    this.v.add(new a(2130839896, "银联信用卡支付", Boolean.valueOf(false), b.b));
    this.v.add(new a(2130839896, "银联储蓄卡支付", Boolean.valueOf(false), b.a));
    this.w = new c(this, this.v, 2130904341);
    this.s.setAdapter(this.w);
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        int i = 0;
        if (i < MinsuToPayActivity.a(MinsuToPayActivity.this).size())
        {
          paramAnonymousAdapterView = (MinsuToPayActivity.a)MinsuToPayActivity.a(MinsuToPayActivity.this).get(i);
          if (i == paramAnonymousInt) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousAdapterView.c = Boolean.valueOf(bool);
            i += 1;
            break;
          }
        }
        MinsuToPayActivity.b(MinsuToPayActivity.this).notifyDataSetChanged();
        MinsuToPayActivity.a(MinsuToPayActivity.this, ((MinsuToPayActivity.a)MinsuToPayActivity.a(MinsuToPayActivity.this).get(paramAnonymousInt)).d);
        MinsuToPayActivity.c(MinsuToPayActivity.this);
      }
    });
  }
  
  private void f()
  {
    if (this.y == null)
    {
      this.y = new com.ziroom.commonlibrary.e.d();
      this.y.initWXAPI(this);
    }
  }
  
  private void g()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.showRightText(false, null);
    this.a.setMiddleText("选择支付方式");
    this.a.setLeftButtonType(0);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuToPayActivity.this.setResult(0);
        MinsuToPayActivity.this.finish();
      }
    });
  }
  
  private void h()
  {
    String str1 = this.b;
    String str2 = this.c + "";
    final String str3 = this.r.getType();
    ArrayList localArrayList = new ArrayList();
    MinsuPayVo localMinsuPayVo = new MinsuPayVo();
    localMinsuPayVo.setOrderType(Integer.valueOf(1));
    localMinsuPayVo.setPayMoney(Integer.valueOf(this.c));
    localArrayList.add(localMinsuPayVo);
    com.ziroom.ziroomcustomer.minsu.e.a.toPay(this, 1, str1, this.b, str2, localArrayList, str3, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuUPPayBean localMinsuUPPayBean = (MinsuUPPayBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuUPPayBean != null) && (localMinsuUPPayBean.checkSuccess(MinsuToPayActivity.this)))
        {
          com.freelxl.baselibrary.f.d.d("lanzhihong", localMinsuUPPayBean.toString());
          MinsuToPayActivity.this.onUPPay(localMinsuUPPayBean, str3);
          return;
        }
        if (localMinsuUPPayBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuUPPayBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    setResult(0);
    finish();
    return false;
  }
  
  public void initFinish()
  {
    if (this.z == null) {
      this.z = new Handler()
      {
        public void dispatchMessage(Message paramAnonymousMessage)
        {
          super.dispatchMessage(paramAnonymousMessage);
          MinsuToPayActivity.this.resultAndFinish();
        }
      };
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.a()
    {
      public void doBack()
      {
        com.freelxl.baselibrary.f.d.d("lanzhihong", "支付成功!");
        MinsuToPayActivity.this.resultAndFinish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903335);
    b();
    e();
    g();
    f();
    a();
  }
  
  protected void onDestroy()
  {
    if (this.z != null)
    {
      this.z.removeMessages(1);
      this.z = null;
    }
    super.onDestroy();
    unregisterReceiver(this.x);
  }
  
  public void onUPPay(MinsuUPPayBean paramMinsuUPPayBean, String paramString)
  {
    if (b.c.getType().equals(paramString))
    {
      paramMinsuUPPayBean = paramMinsuUPPayBean.data.data;
      if (paramMinsuUPPayBean == null)
      {
        showToast("流水号为空");
        return;
      }
      this.y.doStartWXPay(this, paramMinsuUPPayBean.prepayid, paramMinsuUPPayBean.nonceStr, paramMinsuUPPayBean.timeStamp, paramMinsuUPPayBean.packageX, paramMinsuUPPayBean.sign, paramMinsuUPPayBean.partnerId);
      return;
    }
    if (b.d.getType().equals(paramString))
    {
      if ((paramMinsuUPPayBean == null) || (paramMinsuUPPayBean.data == null) || (paramMinsuUPPayBean.data.data == null) || (ae.isNull(paramMinsuUPPayBean.data.data.zfbUrl)))
      {
        showToast("获取流水号失败！");
        return;
      }
      initFinish();
      com.ziroom.commonlibrary.e.a.toALiPay(this, paramMinsuUPPayBean.data.data.zfbUrl, new a.a()
      {
        public void onError()
        {
          MinsuToPayActivity.this.showToast("支付失败");
          MinsuToPayActivity.this.setResult(0);
          MinsuToPayActivity.this.finish();
        }
        
        public void onSuccess()
        {
          MinsuToPayActivity.this.showToast("支付成功");
          MinsuToPayActivity.d(MinsuToPayActivity.this).sendEmptyMessageDelayed(1, 2500L);
        }
        
        public void onWaiting()
        {
          MinsuToPayActivity.this.showToast("支付结果确认中");
          MinsuToPayActivity.this.resultAndFinish();
        }
      });
      return;
    }
    if ((paramMinsuUPPayBean == null) || (paramMinsuUPPayBean.data == null) || (paramMinsuUPPayBean.data.data == null))
    {
      showToast("获取流水号失败！");
      return;
    }
    paramMinsuUPPayBean = paramMinsuUPPayBean.data.data.prepayid;
    if (f.isNull(paramMinsuUPPayBean))
    {
      showToast("流水号为空");
      return;
    }
    c.doStartUnionPayPlugin(this, paramMinsuUPPayBean);
  }
  
  public void resultAndFinish()
  {
    setResult(-1);
    finish();
  }
  
  public class WxReceiver
    extends BroadcastReceiver
  {
    public WxReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MinsuToPayActivity.this.resultAndFinish();
    }
  }
  
  private class a
  {
    public int a;
    public String b;
    public Boolean c;
    public MinsuToPayActivity.b d;
    
    public a(int paramInt, String paramString, Boolean paramBoolean, MinsuToPayActivity.b paramb)
    {
      this.a = paramInt;
      this.b = paramString;
      this.c = paramBoolean;
      this.d = paramb;
    }
  }
  
  public static enum b
  {
    private String e;
    
    private b(String paramString)
    {
      this.e = paramString;
    }
    
    public String getType()
    {
      return this.e;
    }
    
    public void setType(String paramString)
    {
      this.e = paramString;
    }
  }
  
  private class c
    extends com.freelxl.baselibrary.a.a<MinsuToPayActivity.a>
  {
    public c(List<MinsuToPayActivity.a> paramList, int paramInt)
    {
      super(paramInt, i);
    }
    
    public void convert(b paramb, MinsuToPayActivity.a parama)
    {
      paramb.setText(2131692246, parama.b);
      paramb.drawableLeft(MinsuToPayActivity.this, 2131692246, parama.a);
      ((RadioButton)paramb.getView(2131695332)).setChecked(parama.c.booleanValue());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuToPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */