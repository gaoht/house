package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarDayInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarEditData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLDaysEditInitBean;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class MinsuLLDaysEditActivity
  extends BaseFluxActivity
  implements View.OnClickListener
{
  private CompoundButton.OnCheckedChangeListener A;
  private CompoundButton.OnCheckedChangeListener B;
  private String b;
  private String c;
  @BindView(2131691568)
  CheckBox cbNotRentable;
  @BindView(2131691566)
  CheckBox cbRentable;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private String d;
  private int e;
  @BindView(2131691569)
  EditText etSpecialPrice;
  private ArrayList<String> f = new ArrayList();
  private HashMap<String, LLCalendarDayInfoBean> g = new HashMap();
  private int r = 0;
  private int s = 0;
  @BindView(2131691564)
  TextView subtitle;
  private LLDaysEditInitBean t;
  private int u = 0;
  private int v = 0;
  private int w = -1;
  private boolean x = false;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.a y;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.a z;
  
  private void a()
  {
    b();
    this.r = 0;
    this.s = 0;
    if (this.g != null)
    {
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        LLCalendarDayInfoBean localLLCalendarDayInfoBean = (LLCalendarDayInfoBean)((Map.Entry)localIterator.next()).getValue();
        if (localLLCalendarDayInfoBean.getStatus() == 0) {
          this.r += 1;
        } else if (localLLCalendarDayInfoBean.getStatus() == 2) {
          this.s += 1;
        }
      }
    }
    if ((this.r == 0) && (this.s > 0))
    {
      this.cbRentable.setChecked(false);
      this.cbNotRentable.setChecked(true);
      this.u = 2;
    }
    for (;;)
    {
      this.A = new MinsuLLDaysEditActivity.2(this);
      this.B = new MinsuLLDaysEditActivity.3(this);
      this.cbRentable.setOnCheckedChangeListener(this.A);
      this.cbNotRentable.setOnCheckedChangeListener(this.B);
      this.etSpecialPrice.addTextChangedListener(new MinsuLLDaysEditActivity.4(this));
      this.etSpecialPrice.clearFocus();
      this.etSpecialPrice.setOnFocusChangeListener(new MinsuLLDaysEditActivity.5(this));
      return;
      if ((this.r > 0) && (this.s == 0))
      {
        this.cbRentable.setChecked(true);
        this.cbNotRentable.setChecked(false);
        this.u = 1;
      }
      else
      {
        this.u = 0;
      }
    }
  }
  
  private void b()
  {
    this.commonTitle = ((CommonTitle)findViewById(2131691272));
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setOnLeftButtonClickListener(new MinsuLLDaysEditActivity.6(this));
    this.commonTitle.showRightText(true, getString(2131297412));
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.setRightTextColorSize(2131624046, 14);
    this.commonTitle.setOnRightButtonClickListener(new MinsuLLDaysEditActivity.7(this));
  }
  
  private void e()
  {
    boolean bool = false;
    f();
    if (this.u != this.v) {}
    for (int i = 1;; i = 0)
    {
      Object localObject1 = VdsAgent.trackEditTextSilent(this.etSpecialPrice).toString();
      try
      {
        j = Integer.parseInt((String)localObject1);
        localObject1 = Integer.valueOf(j);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          Object localObject2 = null;
        }
        this.commonTitle.setRightTextColorSize(2131624045, 14);
        return;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() != this.w)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        this.x = bool;
        if (this.x)
        {
          this.commonTitle.setRightTextColorSize(2131624081, 14);
          return;
        }
      }
    }
  }
  
  private boolean f()
  {
    if ((this.cbRentable.isChecked()) && (!this.cbNotRentable.isChecked())) {
      this.v = 1;
    }
    while (this.v != this.u)
    {
      return true;
      if ((!this.cbRentable.isChecked()) && (this.cbNotRentable.isChecked()))
      {
        this.v = 2;
      }
      else if ((!this.cbRentable.isChecked()) && (!this.cbNotRentable.isChecked()))
      {
        this.v = 0;
      }
      else
      {
        g.textToast(this, "出现错误，重新U型安泽U型安泽选择状态");
        this.cbRentable.setChecked(false);
        this.cbNotRentable.setChecked(false);
        this.v = 0;
      }
    }
    return false;
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    this.z.initLLCalendarEdit(this, this.b, this.c, this.d, this.e, this.f);
  }
  
  private void i()
  {
    this.y = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.a(this);
    this.a.register(this.y);
    this.z = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.a.getInstance(this.a);
  }
  
  private void j()
  {
    Object localObject2 = null;
    String str = VdsAgent.trackEditTextSilent(this.etSpecialPrice).toString();
    Integer localInteger;
    try
    {
      int i = Integer.parseInt(str);
      localInteger = Integer.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        localInteger = null;
      }
      localObject1 = localObject2;
      if (!f()) {
        break label84;
      }
      if (!this.cbRentable.isChecked()) {
        break label115;
      }
      localObject1 = Integer.valueOf(0);
    }
    if ((localInteger != null) && (localInteger.intValue() < 60))
    {
      g.textToast(this, getString(2131297452));
      return;
    }
    for (;;)
    {
      label84:
      this.z.saveLLCalendarEdit(this, this.b, this.c, this.d, this.e, this.f, (Integer)localObject1, localInteger);
      return;
      label115:
      Object localObject1 = localObject2;
      if (this.cbNotRentable.isChecked()) {
        localObject1 = Integer.valueOf(1);
      }
    }
  }
  
  private void k()
  {
    setResult(0, getIntent());
    finish();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    ad.hideSoftInput(this);
    paramView.getId();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903310);
    ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("houseBaseFid");
    this.c = getIntent().getStringExtra("houseRoomFid");
    this.d = getIntent().getStringExtra("bedFid");
    this.e = getIntent().getIntExtra("rentWay", 0);
    a();
    i();
  }
  
  @j(sticky=true, threadMode=ThreadMode.MAIN)
  public void onEventBusData(LLCalendarEditData paramLLCalendarEditData)
  {
    this.f = paramLLCalendarEditData.getSelectDatesStr();
    this.g = paramLLCalendarEditData.getSelectData();
    new Handler(Looper.getMainLooper()).post(new MinsuLLDaysEditActivity.1(this));
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i;
    switch (parama.hashCode())
    {
    default: 
      i = -1;
      label54:
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("CalendarEditInit")) {
        break;
      }
      i = 0;
      break label54;
      if (!parama.equals("CalendarEditInitError")) {
        break;
      }
      i = 1;
      break label54;
      if (!parama.equals("CalendarEditSave")) {
        break;
      }
      i = 2;
      break label54;
      if (!parama.equals("CalendarEditSaveError")) {
        break;
      }
      i = 3;
      break label54;
      this.t = this.y.getCalendarEidtInitBean();
    } while (this.t == null);
    this.subtitle.setText(this.t.getDateEditTitle());
    this.etSpecialPrice.setHint(String.format("%s%s元", new Object[] { getString(2131296601), ad.getPriceInt(this.t.getBasePrice()) }));
    this.etSpecialPrice.clearFocus();
    this.w = this.t.getBasePrice();
    return;
    ad.shouErrorMessage(this.y.getCalendarEidtInitErrorMsg());
    return;
    parama = com.alibaba.fastjson.a.parseObject(this.y.getCalendarEidtSaveBean()).getString("data");
    if (!TextUtils.isEmpty(parama)) {
      g.textToast(this, parama);
    }
    for (;;)
    {
      setResult(-1);
      finish();
      return;
      g.textToast(this, "保存失败");
    }
    parama = this.y.getCalendarEidtSaveErrorMsg();
    if (TextUtils.isEmpty(parama))
    {
      g.textToast(this, "保存失败");
      return;
    }
    g.textToast(this, "" + parama);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ad.hideSoftInput(this);
    this.etSpecialPrice.clearFocus();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/MinsuLLDaysEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */