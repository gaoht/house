package com.ziroom.ziroomcustomer.signed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.TenancyInfo;
import com.ziroom.ziroomcustomer.model.TenancyUpdate;
import com.ziroom.ziroomcustomer.signed.a.c;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SignedLeaseInfoActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private ImageView a;
  private TextView b;
  private LinearLayout c;
  private HouseDetail d;
  private List<String> e;
  private c f;
  private Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      SignedLeaseInfoActivity.this.dismissProgress();
      switch (paramAnonymousMessage.what)
      {
      case 69668: 
      default: 
        return;
      case 69667: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          paramAnonymousMessage = (List)((l)localObject).getObject();
          SignedLeaseInfoActivity.this.a(paramAnonymousMessage);
          SignedLeaseInfoActivity.a(SignedLeaseInfoActivity.this, SignedLeaseInfoActivity.b(SignedLeaseInfoActivity.this, paramAnonymousMessage));
          return;
        }
        SignedLeaseInfoActivity.this.showToast(((l)localObject).getMessage());
        return;
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = (TenancyUpdate)((l)localObject).getObject();
        localObject = new Intent(SignedLeaseInfoActivity.this, PayTermsActivity.class);
        ((Intent)localObject).putExtra("detail", SignedLeaseInfoActivity.a(SignedLeaseInfoActivity.this));
        ((Intent)localObject).putExtra("person", SignedLeaseInfoActivity.b(SignedLeaseInfoActivity.this));
        ((Intent)localObject).putExtra("tenancy", paramAnonymousMessage);
        SignedLeaseInfoActivity.this.startActivity((Intent)localObject);
        return;
      }
      SignedLeaseInfoActivity.this.showToast(((l)localObject).getMessage());
    }
  };
  private SingedLeaseInfoItemView r;
  private SingedShortLeaseItemView s;
  private SingedLeaseInternshipView t;
  private SingedLeaseInternshipView u;
  
  private void a()
  {
    findViewById(2131691080).setOnClickListener(this);
    findViewById(2131691076).setOnClickListener(this);
  }
  
  private void a(TenancyInfo paramTenancyInfo)
  {
    String str;
    if ("greatBud".equals(paramTenancyInfo.getTenancyChoice()))
    {
      this.u = new SingedLeaseInternshipView(this);
      this.u.setDateAndMoneyText(paramTenancyInfo.getStopDate(), paramTenancyInfo.getPrice(), paramTenancyInfo.getPriceUnit(), paramTenancyInfo.getShorRentMaxDays());
      this.u.setmSign_Date(paramTenancyInfo.getSignDate());
      this.u.setmStop_Date(paramTenancyInfo.getStopDate());
      this.u.setmPrice(paramTenancyInfo.getPrice());
      this.u.setmTenancy_Type(paramTenancyInfo.getTenancyType());
      this.u.setPayments(paramTenancyInfo.getPayments());
      this.u.setmIsBlank(paramTenancyInfo.getIsBlank());
      this.u.setIsZWhite(paramTenancyInfo.getIsZWhite());
      this.u.getCheckBox().setOnCheckedChangeListener(this);
      this.u.setmIsShort(paramTenancyInfo.getIsShort());
      this.u.setPaymentsTags(paramTenancyInfo.getPaymentsTags());
      this.u.setzWhiteModel(paramTenancyInfo.getzWhiteModel());
      str = "";
      if (paramTenancyInfo.getAdditionalLoad() != null) {
        str = paramTenancyInfo.getAdditionalLoad().getString("activityTip");
      }
      this.u.setTenancyChoice(paramTenancyInfo.getTenancyChoice(), str);
      this.c.addView(this.u);
    }
    do
    {
      return;
      if ((paramTenancyInfo.getIsShort() == 0) || ("s1".equals(paramTenancyInfo.getTenancyType())))
      {
        this.r = new SingedLeaseInfoItemView(this);
        this.r.setDateAndMoneyText(paramTenancyInfo.getStopDate(), paramTenancyInfo.getPrice(), paramTenancyInfo.getPriceUnit());
        this.r.setmSign_Date(paramTenancyInfo.getSignDate());
        this.r.setmStop_Date(paramTenancyInfo.getStopDate());
        this.r.setmPrice(paramTenancyInfo.getPrice());
        this.r.setmTenancy_Type(paramTenancyInfo.getTenancyType());
        this.r.setPayments(paramTenancyInfo.getPayments());
        this.r.setmIsBlank(paramTenancyInfo.getIsBlank());
        this.r.setIsZWhite(paramTenancyInfo.getIsZWhite());
        this.r.getCheckBox().setOnCheckedChangeListener(this);
        this.r.setmIsShort(paramTenancyInfo.getIsShort());
        this.r.setPaymentsTags(paramTenancyInfo.getPaymentsTags());
        this.r.setzWhiteModel(paramTenancyInfo.getzWhiteModel());
        this.r.setTenancyChoice(paramTenancyInfo.getTenancyChoice());
        this.c.addView(this.r);
        return;
      }
      if ("INTERN_ZIROOM".equals(paramTenancyInfo.getTenancyChoice()))
      {
        this.t = new SingedLeaseInternshipView(this);
        this.t.setDateAndMoneyText(paramTenancyInfo.getStopDate(), paramTenancyInfo.getPrice(), paramTenancyInfo.getPriceUnit(), paramTenancyInfo.getShorRentMaxDays());
        this.t.setmSign_Date(paramTenancyInfo.getSignDate());
        this.t.setmStop_Date(paramTenancyInfo.getStopDate());
        this.t.setmPrice(paramTenancyInfo.getPrice());
        this.t.setmTenancy_Type(paramTenancyInfo.getTenancyType());
        this.t.setPayments(paramTenancyInfo.getPayments());
        this.t.setmIsBlank(paramTenancyInfo.getIsBlank());
        this.t.setIsZWhite(paramTenancyInfo.getIsZWhite());
        this.t.getCheckBox().setOnCheckedChangeListener(this);
        this.t.setmIsShort(paramTenancyInfo.getIsShort());
        this.t.setPaymentsTags(paramTenancyInfo.getPaymentsTags());
        this.t.setzWhiteModel(paramTenancyInfo.getzWhiteModel());
        str = "";
        if (paramTenancyInfo.getAdditionalLoad() != null) {
          str = paramTenancyInfo.getAdditionalLoad().getString("activityTip");
        }
        this.t.setTenancyChoice(paramTenancyInfo.getTenancyChoice(), str);
        this.c.addView(this.t);
        return;
      }
    } while (paramTenancyInfo.getIsShort() != 1);
    this.s = new SingedShortLeaseItemView(this);
    this.s.setStartDate(paramTenancyInfo.getSignDate());
    this.s.setmStopDate(paramTenancyInfo.getStopDate());
    this.s.setmPrice(paramTenancyInfo.getPrice());
    this.s.setmTenancy_Type(paramTenancyInfo.getTenancyType());
    this.s.setPayments(paramTenancyInfo.getPayments());
    this.s.setIsBlank(paramTenancyInfo.getIsBlank());
    this.s.setShorRentMaxDays(paramTenancyInfo.getShorRentMaxDays());
    this.s.setShortRentMinDays(paramTenancyInfo.getShortRentMinDays());
    this.s.setDateAndMoneyText(paramTenancyInfo.getStopDate(), paramTenancyInfo.getPrice(), paramTenancyInfo.getPriceUnit());
    this.s.getCheckBox().setOnCheckedChangeListener(this);
    this.s.setmIsShort(paramTenancyInfo.getIsShort());
    this.s.setPaymentsTags(paramTenancyInfo.getPaymentsTags());
    this.s.setzWhiteModel(paramTenancyInfo.getzWhiteModel());
    this.s.setTenancyChoice(paramTenancyInfo.getTenancyChoice());
    this.c.addView(this.s);
  }
  
  private List<String> b(List<TenancyInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    SimpleDateFormat localSimpleDateFormat;
    if (paramList.size() > 0)
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      paramList = ((TenancyInfo)paramList.get(0)).getSignDate();
      localArrayList.add(m.StrToNorDate(paramList));
    }
    try
    {
      paramList = localSimpleDateFormat.parse(paramList);
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTime(paramList);
      localGregorianCalendar.add(5, 1);
      localArrayList.add(m.StrToNorDate(localSimpleDateFormat.format(localGregorianCalendar.getTime())));
      return localArrayList;
    }
    catch (ParseException paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131691077));
    this.b = ((TextView)findViewById(2131691078));
    this.c = ((LinearLayout)findViewById(2131691079));
    this.c.setVisibility(4);
  }
  
  private String d(String paramString)
  {
    if (ae.isNull(paramString)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy年MM月dd日").parse(paramString);
      Object localObject1 = new SimpleDateFormat("yyyy");
      Object localObject2 = new SimpleDateFormat("MM");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd");
      localObject1 = ((SimpleDateFormat)localObject1).format(paramString);
      localObject2 = ((SimpleDateFormat)localObject2).format(paramString);
      paramString = localSimpleDateFormat.format(paramString);
      paramString = (String)localObject1 + "-" + (String)localObject2 + "-" + paramString;
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void e()
  {
    Object localObject5 = null;
    int i = 0;
    int j = 0;
    String str1 = "";
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject4 = "";
    Object localObject1 = "";
    List localList = null;
    int k = 0;
    String str3 = "0";
    int n = 0;
    e locale = null;
    String str2 = null;
    if (this.d != null)
    {
      this.d.getHouse_code();
      this.d.getHouse_id();
      this.d.getHouse_type();
    }
    int i2 = 0;
    long l1 = 0L;
    long l2 = 0L;
    int m = 0;
    Object localObject6;
    if (m < this.c.getChildCount())
    {
      localObject6 = (SingedLeaseItem)this.c.getChildAt(m);
      boolean bool = ((SingedLeaseItem)localObject6).getSelectStatus();
      if (!bool) {
        break label503;
      }
      str3 = ((SingedLeaseItem)localObject6).getIsZWhite();
      i = ((SingedLeaseItem)localObject6).getIsBlank();
      localList = ((SingedLeaseItem)localObject6).getPayments();
      ((SingedLeaseItem)localObject6).getSign_Date();
      k = ((SingedLeaseItem)localObject6).getShortRentMinDays();
      j = ((SingedLeaseItem)localObject6).getShorRentMaxDays();
      str1 = d(this.b.getText().toString());
      localObject4 = ((SingedLeaseItem)localObject6).getStop_Date();
      localObject5 = ((SingedLeaseItem)localObject6).getPrice();
      localObject1 = ((SingedLeaseItem)localObject6).getPriceUnit();
      localObject3 = ((SingedLeaseItem)localObject6).getTenancy_Type();
      n = ((SingedLeaseItem)localObject6).getIsShort();
      if (!(localObject6 instanceof SingedShortLeaseItemView)) {
        break label500;
      }
      l1 = ((SingedShortLeaseItemView)localObject6).getmRangeDays();
      l2 = ((SingedShortLeaseItemView)localObject6).getEditDays();
      label246:
      localObject2 = ((SingedLeaseItem)localObject6).getPaymentsTags();
      locale = ((SingedLeaseItem)localObject6).getzWhiteModel();
      str2 = ((SingedLeaseItem)localObject6).getTenancyChoice();
      i2 = bool;
    }
    for (;;)
    {
      int i1 = m + 1;
      Object localObject7 = localObject4;
      m = i;
      localObject4 = localObject3;
      localObject6 = localObject2;
      localObject3 = localObject7;
      localObject2 = localObject5;
      localObject5 = localObject6;
      i = j;
      j = k;
      k = m;
      m = i1;
      break;
      if (i2 == 0)
      {
        showToast("请选择结束时间");
        return;
      }
      if (ae.isNull((String)localObject3))
      {
        showToast("请输入正确的天数");
        return;
      }
      if ((l1 != 0L) && ((l2 < j) || (l2 > i)))
      {
        showToast("请输入正确的天数");
        return;
      }
      localObject1 = new TenancyInfo(str1, (String)localObject3, (String)localObject2, (String)localObject1, (String)localObject4, n, null, 0, str3, (b)localObject5, locale, i, j, str2);
      localObject2 = new TenancyUpdate(localList, k, str3);
      localObject3 = new Intent(this, PayTermsActivity.class);
      ((Intent)localObject3).putExtra("detail", this.d);
      ((Intent)localObject3).putExtra("tenancy", (Serializable)localObject2);
      ((Intent)localObject3).putExtra("person", this.f);
      ((Intent)localObject3).putExtra("tenancyInfo", (Serializable)localObject1);
      startActivity((Intent)localObject3);
      showProgress("");
      return;
      label500:
      break label246;
      label503:
      localObject6 = localObject5;
      localObject5 = localObject4;
      i1 = i;
      localObject4 = localObject3;
      i = k;
      localObject3 = localObject5;
      localObject5 = localObject2;
      k = j;
      j = i1;
      localObject2 = localObject6;
    }
  }
  
  protected void a(List<TenancyInfo> paramList)
  {
    int i = 0;
    if (paramList == null) {}
    while (paramList.size() <= 0) {
      return;
    }
    this.b.setText(m.StrToNorDate(((TenancyInfo)paramList.get(0)).getSignDate()));
    this.c.setVisibility(0);
    while (i < paramList.size())
    {
      a((TenancyInfo)paramList.get(i));
      i += 1;
    }
    ((SingedLeaseItem)this.c.getChildAt(this.c.getChildCount() - 1)).setBottomLineGone(true);
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    int i = 0;
    while (i < this.c.getChildCount())
    {
      ((SingedLeaseItem)this.c.getChildAt(i)).setSelectStatus(false);
      i += 1;
    }
    paramCompoundButton.setChecked(paramBoolean);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131691077: 
    case 2131691078: 
    case 2131691079: 
    default: 
      return;
    case 2131691080: 
      e();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903244);
    ApplicationEx.c.addActivity(this);
    this.d = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.f = ((c)getIntent().getSerializableExtra("person"));
    b();
    showProgress("");
    d.getTenancyInfo(this.g, this.d.getHouse_code(), this.d.getHouse_id(), this.d.getHouse_type());
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignedLeaseInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */