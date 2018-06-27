package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import java.util.List;

public class SingedLeaseInternshipView
  extends SingedLeaseItem
{
  private CheckBox a;
  private TextView b;
  private TextView c;
  private TextView d;
  private View e;
  private String f;
  private String g;
  private String h;
  private String i;
  private List<Integer> j;
  private int k;
  private String l;
  private String m;
  private int n;
  private b o;
  private e p;
  private String q;
  
  public SingedLeaseInternshipView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public SingedLeaseInternshipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public SingedLeaseInternshipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public CheckBox getCheckBox()
  {
    if (this.a != null) {
      return this.a;
    }
    return null;
  }
  
  public int getIsBlank()
  {
    return this.k;
  }
  
  public int getIsShort()
  {
    return this.n;
  }
  
  public String getIsZWhite()
  {
    return this.l;
  }
  
  public List<Integer> getPayments()
  {
    return this.j;
  }
  
  public b getPaymentsTags()
  {
    return this.o;
  }
  
  public String getPrice()
  {
    return this.h;
  }
  
  public String getPriceUnit()
  {
    return this.m;
  }
  
  public boolean getSelectStatus()
  {
    if (this.a != null) {
      return this.a.isChecked();
    }
    return false;
  }
  
  public int getShorRentMaxDays()
  {
    return 0;
  }
  
  public int getShortRentMinDays()
  {
    return 0;
  }
  
  public String getSign_Date()
  {
    return this.f;
  }
  
  public String getStop_Date()
  {
    return this.g;
  }
  
  public String getTenancyChoice()
  {
    return this.q;
  }
  
  public String getTenancy_Type()
  {
    return this.i;
  }
  
  public TextView getmDateView()
  {
    return this.c;
  }
  
  public TextView getmMoneyView()
  {
    return this.d;
  }
  
  public e getzWhiteModel()
  {
    return this.p;
  }
  
  public void initView(Context paramContext)
  {
    View.inflate(paramContext, 2130904274, this);
    this.b = ((TextView)findViewById(2131695195));
    this.a = ((CheckBox)findViewById(2131695192));
    this.c = ((TextView)findViewById(2131695193));
    this.d = ((TextView)findViewById(2131695190));
    this.e = findViewById(2131695191);
    setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (SingedLeaseInternshipView.a(SingedLeaseInternshipView.this).isChecked())
        {
          SingedLeaseInternshipView.a(SingedLeaseInternshipView.this).setChecked(false);
          return;
        }
        SingedLeaseInternshipView.a(SingedLeaseInternshipView.this).setChecked(true);
      }
    });
  }
  
  public void setBottomLineGone(boolean paramBoolean)
  {
    View localView = this.e;
    if (paramBoolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void setDateAndMoneyText(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.c.setText(paramInt + "天, " + m.StrToNorDate(paramString1));
    if ("group".equals(paramString2)) {
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.m = paramString3;
      return;
      ah.setTextColor(this.d, paramString2 + "元/" + paramString3, 0, paramString2.length());
    }
  }
  
  public void setIsZWhite(String paramString)
  {
    this.l = paramString;
  }
  
  public void setPayments(List<Integer> paramList)
  {
    this.j = paramList;
  }
  
  public void setPaymentsTags(b paramb)
  {
    this.o = paramb;
  }
  
  public void setSelectStatus(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }
  
  public void setTenancyChoice(String paramString1, String paramString2)
  {
    this.q = paramString1;
    if (ae.notNull(paramString2)) {
      this.b.setText(paramString2);
    }
  }
  
  public void setmIsBlank(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setmIsShort(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setmPrice(String paramString)
  {
    this.h = paramString;
  }
  
  public void setmSign_Date(String paramString)
  {
    this.f = paramString;
  }
  
  public void setmStop_Date(String paramString)
  {
    this.g = paramString;
  }
  
  public void setmTenancy_Type(String paramString)
  {
    this.i = paramString;
  }
  
  public void setzWhiteModel(e parame)
  {
    this.p = parame;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SingedLeaseInternshipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */