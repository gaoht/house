package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.newclean.d.h;
import com.ziroom.ziroomcustomer.newclean.d.h.a;
import com.ziroom.ziroomcustomer.newclean.fragment.BiweeklyOrderDetailFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.BiweeklyOrderStateFragment;
import com.ziroom.ziroomcustomer.newclean.view.BiWeekCleanEvalWidght;
import com.ziroom.ziroomcustomer.payment.a;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

public class WeekCleanDetailActivity
  extends BiweeklyDetailBaseActivity
{
  private WeekCleanDetailActivity A;
  private h t;
  private boolean u = true;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private String z;
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.t == null) {
        g.textToast(this, "数据刷新中...");
      }
    }
    else {
      while ((!"2".equals(this.t.getOperateCode())) || (this.w) || (this.y)) {
        return;
      }
    }
    if (this.u)
    {
      this.u = false;
      this.g.setCleanDetailInfo(this.t);
    }
    this.g.setCleanEvalListener(new WeekCleanDetailActivity.1(this));
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(true, this.g);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(true, this.r);
    this.v = true;
    this.r.setClickable(true);
    this.r.setOnClickListener(new WeekCleanDetailActivity.2(this));
  }
  
  private void d(String paramString)
  {
    this.v = false;
    this.w = true;
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(false, this.g);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(false, this.r);
    this.r.setClickable(false);
    if (this.x)
    {
      paramString = new Intent(this, BiWeeklyQuestionnaireActivity.class);
      if (!TextUtils.isEmpty(this.t.getEmployeeDetailVO().getCleanerId()))
      {
        paramString.putExtra("avatar", this.t.getEmployeeDetailVO().getHeadPic());
        paramString.putExtra("cleanerName", this.t.getEmployeeDetailVO().getName());
        paramString.putExtra("cleanerId", this.t.getEmployeeDetailVO().getCleanerId());
      }
      paramString.putExtra("billId", this.t.getOrderId());
      startActivity(paramString);
    }
  }
  
  protected void a()
  {
    super.a();
    this.A = this;
    org.greenrobot.eventbus.c.getDefault().register(this);
    this.b.setText("自如客保洁");
    this.e.setVisibility(8);
    this.z = getIntent().getStringExtra("billId");
    this.f.add(BiweeklyOrderStateFragment.getInstance(getIntent().getStringExtra("billId")));
    this.f.add(BiweeklyOrderDetailFragment.getInstance(getIntent().getExtras()));
    this.a.setCurrentItem(1);
    b(1);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.v) {
        d("");
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    String str;
    if ("biweekly_clean_detail_data".equals(paramc.getType()))
    {
      this.t = ((h)paramc.getData());
      if (this.t != null)
      {
        str = this.t.getEmployeeDetailVO().getCleanerId();
        if (!TextUtils.isEmpty(str)) {
          break label82;
        }
        this.s.setVisibility(8);
      }
    }
    for (;;)
    {
      a(false);
      if ("biweekly_clean_show_eval_dialog".equals(paramc.getType())) {
        a(true);
      }
      return;
      label82:
      Bundle localBundle = new Bundle();
      localBundle.putString("thumbType", "clean");
      localBundle.putString("showType", "detail");
      localBundle.putString("orderCode", this.z);
      localBundle.putString("orderNum", this.t.getOrderNum());
      localBundle.putString("employeeCode", str);
      com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(this, this.s, localBundle);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/WeekCleanDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */