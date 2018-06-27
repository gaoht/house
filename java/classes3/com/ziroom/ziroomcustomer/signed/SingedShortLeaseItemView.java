package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.List;

public class SingedShortLeaseItemView
  extends SingedLeaseItem
{
  private CheckBox a;
  private TextView b;
  private TextView c;
  private EditText d;
  private String e;
  private String f;
  private View g;
  private String h;
  private String i;
  private String j;
  private long k = 0L;
  private List<Integer> l;
  private int m;
  private String n;
  private int o;
  private String p;
  private b q;
  private e r;
  private int s;
  private int t;
  private String u;
  
  public SingedShortLeaseItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CheckBox getCheckBox()
  {
    if (this.a != null) {
      return this.a;
    }
    return null;
  }
  
  public long getEditDays()
  {
    String str = VdsAgent.trackEditTextSilent(this.d).toString();
    if (ae.notNull(str)) {
      return Long.valueOf(str).longValue();
    }
    return 0L;
  }
  
  public int getIsBlank()
  {
    return this.m;
  }
  
  public int getIsShort()
  {
    return this.o;
  }
  
  public String getIsZWhite()
  {
    return this.p;
  }
  
  public List<Integer> getPayments()
  {
    return this.l;
  }
  
  public b getPaymentsTags()
  {
    return this.q;
  }
  
  public String getPrice()
  {
    return this.i;
  }
  
  public String getPriceUnit()
  {
    return this.n;
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
    return this.t;
  }
  
  public int getShortRentMinDays()
  {
    return this.s;
  }
  
  public String getSign_Date()
  {
    return this.e;
  }
  
  public String getStop_Date()
  {
    return this.h;
  }
  
  public String getTenancyChoice()
  {
    return this.u;
  }
  
  public String getTenancy_Type()
  {
    return this.j;
  }
  
  public TextView getmDateView()
  {
    return this.b;
  }
  
  public EditText getmDaySelectText()
  {
    return this.d;
  }
  
  public TextView getmMoneyView()
  {
    return this.c;
  }
  
  public long getmRangeDays()
  {
    return this.k;
  }
  
  public String getmStopDate()
  {
    return this.f;
  }
  
  public e getzWhiteModel()
  {
    return this.r;
  }
  
  public void initView(Context paramContext)
  {
    View.inflate(paramContext, 2130904526, this);
    this.a = ((CheckBox)findViewById(2131695669));
    this.b = ((TextView)findViewById(2131695672));
    this.c = ((TextView)findViewById(2131689846));
    this.d = ((EditText)findViewById(2131695670));
    this.g = findViewById(2131695191);
    this.d.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (ae.isNull(paramAnonymousCharSequence.toString())) {
          return;
        }
        paramAnonymousInt1 = Integer.valueOf(paramAnonymousCharSequence.toString()).intValue();
        paramAnonymousCharSequence = m.DateToStr(m.getDateAfter(m.strToDate(SingedShortLeaseItemView.a(SingedShortLeaseItemView.this), m.b), paramAnonymousInt1 - 1));
        SingedShortLeaseItemView.a(SingedShortLeaseItemView.this, paramAnonymousCharSequence);
        SingedShortLeaseItemView.b(SingedShortLeaseItemView.this).setText(m.StrToNorDate(paramAnonymousCharSequence));
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SingedShortLeaseItemView.c(SingedShortLeaseItemView.this).setChecked(true);
      }
    });
    setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (SingedShortLeaseItemView.c(SingedShortLeaseItemView.this).isChecked())
        {
          SingedShortLeaseItemView.c(SingedShortLeaseItemView.this).setChecked(false);
          return;
        }
        SingedShortLeaseItemView.c(SingedShortLeaseItemView.this).setChecked(true);
      }
    });
  }
  
  public void setBottomLineGone(boolean paramBoolean)
  {
    View localView = this.g;
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
    this.c.setText(paramString2 + "元/" + paramString3);
    this.n = paramString3;
    this.d.setHint(this.s + "-" + this.t);
    setmRangeDays(Long.valueOf(this.t));
  }
  
  public void setIsBlank(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setIsZWhite(String paramString)
  {
    this.p = paramString;
  }
  
  public void setPayments(List<Integer> paramList)
  {
    this.l = paramList;
  }
  
  public void setPaymentsTags(b paramb)
  {
    this.q = paramb;
  }
  
  public void setSelectStatus(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }
  
  public void setShorRentMaxDays(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setShortRentMinDays(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setStartDate(String paramString)
  {
    this.e = paramString;
  }
  
  public void setTenancyChoice(String paramString)
  {
    this.u = paramString;
  }
  
  public void setmIsShort(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setmPrice(String paramString)
  {
    this.i = paramString;
  }
  
  public void setmRangeDays(Long paramLong)
  {
    this.k = paramLong.longValue();
  }
  
  public void setmSign_Date(String paramString)
  {
    this.e = paramString;
  }
  
  public void setmStopDate(String paramString)
  {
    this.f = paramString;
  }
  
  public void setmStop_Date(String paramString)
  {
    this.h = paramString;
  }
  
  public void setmTenancy_Type(String paramString)
  {
    this.j = paramString;
  }
  
  public void setzWhiteModel(e parame)
  {
    this.r = parame;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SingedShortLeaseItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */