package com.ziroom.ziroomcustomer.newclean.periodclean.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.a;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanMainActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CleanerBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import java.util.List;

public class d
  extends a<CleanerBean>
{
  private Context d;
  private com.ziroom.ziroomcustomer.newclean.d.c e;
  private FrequencyBean f;
  
  public d(Context paramContext, List<CleanerBean> paramList, com.ziroom.ziroomcustomer.newclean.d.c paramc)
  {
    super(paramContext, paramList, 2130904430);
    this.d = paramContext;
    this.e = paramc;
  }
  
  public void convert(b paramb, final CleanerBean paramCleanerBean)
  {
    int i = 5;
    paramb.setText(2131690912, paramCleanerBean.getName());
    if (!TextUtils.isEmpty(paramCleanerBean.getServeNum())) {
      paramb.setText(2131692092, "共服务" + paramCleanerBean.getServeNum() + "单");
    }
    ((SimpleDraweeView)paramb.getView(2131690097)).setController(com.freelxl.baselibrary.f.c.frescoController(paramCleanerBean.getHeadPic()));
    RatingStar localRatingStar = (RatingStar)paramb.getView(2131690595);
    if (h.isNumber(paramCleanerBean.getSocre())) {
      if (Math.round(Float.parseFloat(paramCleanerBean.getSocre())) == 0) {
        localRatingStar.setStarScore(i);
      }
    }
    for (;;)
    {
      paramb.setOnClickListener(2131691015, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (d.a(d.this) == null)
          {
            g.textToast(d.b(d.this), "请先选择保洁频次");
            return;
          }
          paramAnonymousView = new Intent(d.b(d.this), PeriodCleanMainActivity.class);
          paramAnonymousView.putExtra("address", d.c(d.this));
          paramAnonymousView.putExtra("cleaner", paramCleanerBean);
          paramAnonymousView.putExtra("selectFreqBean", d.a(d.this));
          ((Activity)d.b(d.this)).startActivityForResult(paramAnonymousView, 32);
        }
      });
      return;
      i = Math.round(Float.parseFloat(paramCleanerBean.getSocre()));
      break;
      localRatingStar.setStarScore(5);
    }
  }
  
  public void setFreqBean(FrequencyBean paramFrequencyBean)
  {
    this.f = paramFrequencyBean;
  }
  
  public void setmAddress(com.ziroom.ziroomcustomer.newclean.d.c paramc)
  {
    this.e = paramc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */