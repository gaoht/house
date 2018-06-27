package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.flux.a.a;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseSuccessActivity
  extends BaseFluxActivity
{
  private Context b;
  @BindView(2131690078)
  View btn_back;
  @BindView(2131691560)
  View btn_next;
  private List<String> c;
  @BindView(2131691559)
  LinearLayout ll_house_name_container;
  @BindView(2131691557)
  ObservableScrollView osv_content;
  @BindView(2131691558)
  TextView tv_success_info;
  @BindView(2131689863)
  View v_divider;
  
  private void a()
  {
    Object localObject = getIntent().getExtras();
    this.c = ((Bundle)localObject).getStringArrayList("houseName");
    localObject = ((Bundle)localObject).getString("successInfo");
    this.tv_success_info.setText((CharSequence)localObject);
    b();
  }
  
  private void b()
  {
    if (this.c != null)
    {
      int i = n.dip2px(this.b, 16.0F);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        TextView localTextView = new TextView(this.b);
        localTextView.setText(str);
        localTextView.setTextColor(Color.parseColor("#444444"));
        localTextView.setTextSize(16.0F);
        localTextView.setPadding(0, 0, 0, i);
        this.ll_house_name_container.addView(localTextView);
      }
    }
  }
  
  @OnClick({2131691560, 2131690078})
  public void OnClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903306);
    this.b = this;
    ButterKnife.bind(this);
    this.osv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordReleaseSuccessActivity.this.v_divider.setAlpha(f);
      }
    });
    a();
  }
  
  protected void onEventHandle(a parama) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */