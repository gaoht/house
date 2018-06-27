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
import com.ziroom.ziroomcustomer.util.m;
import java.util.List;

public class SingedLeaseInfoItemView
  extends SingedLeaseItem
{
  private CheckBox a;
  private TextView b;
  private TextView c;
  private View d;
  private String e;
  private String f;
  private String g;
  private String h;
  private List<Integer> i;
  private int j;
  private String k;
  private String l;
  private int m;
  private b n;
  private e o;
  private String p;
  
  public SingedLeaseInfoItemView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public SingedLeaseInfoItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public SingedLeaseInfoItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    return this.j;
  }
  
  public int getIsShort()
  {
    return this.m;
  }
  
  public String getIsZWhite()
  {
    return this.k;
  }
  
  public List<Integer> getPayments()
  {
    return this.i;
  }
  
  public b getPaymentsTags()
  {
    return this.n;
  }
  
  public String getPrice()
  {
    return this.g;
  }
  
  public String getPriceUnit()
  {
    return this.l;
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
    return this.e;
  }
  
  public String getStop_Date()
  {
    return this.f;
  }
  
  public String getTenancyChoice()
  {
    return this.p;
  }
  
  public String getTenancy_Type()
  {
    return this.h;
  }
  
  public TextView getmDateView()
  {
    return this.b;
  }
  
  public TextView getmMoneyView()
  {
    return this.c;
  }
  
  public e getzWhiteModel()
  {
    return this.o;
  }
  
  public void initView(Context paramContext)
  {
    View.inflate(paramContext, 2130904273, this);
    this.a = ((CheckBox)findViewById(2131695192));
    this.b = ((TextView)findViewById(2131695193));
    this.c = ((TextView)findViewById(2131695190));
    this.d = findViewById(2131695191);
    setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (SingedLeaseInfoItemView.a(SingedLeaseInfoItemView.this).isChecked())
        {
          SingedLeaseInfoItemView.a(SingedLeaseInfoItemView.this).setChecked(false);
          return;
        }
        SingedLeaseInfoItemView.a(SingedLeaseInfoItemView.this).setChecked(true);
      }
    });
  }
  
  public void setBottomLineGone(boolean paramBoolean)
  {
    View localView = this.d;
    if (paramBoolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void setDateAndMoneyText(String paramString1, String paramString2, String paramString3)
  {
    this.b.setText(m.StrToNorDate(paramString1));
    if ("group".equals(paramString2)) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.l = paramString3;
      return;
      this.c.setText(paramString2 + "元/" + paramString3);
    }
  }
  
  public void setIsZWhite(String paramString)
  {
    this.k = paramString;
  }
  
  public void setPayments(List<Integer> paramList)
  {
    this.i = paramList;
  }
  
  public void setPaymentsTags(b paramb)
  {
    this.n = paramb;
  }
  
  public void setSelectStatus(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }
  
  public void setTenancyChoice(String paramString)
  {
    this.p = paramString;
  }
  
  public void setmIsBlank(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setmIsShort(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setmPrice(String paramString)
  {
    this.g = paramString;
  }
  
  public void setmSign_Date(String paramString)
  {
    this.e = paramString;
  }
  
  public void setmStop_Date(String paramString)
  {
    this.f = paramString;
  }
  
  public void setmTenancy_Type(String paramString)
  {
    this.h = paramString;
  }
  
  public void setzWhiteModel(e parame)
  {
    this.o = parame;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SingedLeaseInfoItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */