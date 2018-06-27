package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.model.BaseItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.PeopleItem;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class LandlordCustomerActivity
  extends BaseActivity
{
  private com.freelxl.baselibrary.a.a a;
  private List<PeopleItem> b;
  @BindView(2131691452)
  ImageView imgClose;
  @BindView(2131691217)
  MyListView list;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691453)
  View vBottomLine;
  
  private void a()
  {
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordCustomerActivity.this.vBottomLine.setAlpha(f);
      }
    });
  }
  
  private void b()
  {
    this.a = new com.freelxl.baselibrary.a.a(this, this.b, 2130904322)
    {
      public void convert(b paramAnonymousb, PeopleItem paramAnonymousPeopleItem)
      {
        paramAnonymousb.setText(2131690049, paramAnonymousPeopleItem.getName().getValue());
        StringBuilder localStringBuilder = new StringBuilder().append(paramAnonymousPeopleItem.getSex().getName()).append("  ");
        Object localObject;
        if (f.isNull(paramAnonymousPeopleItem.getSex().getValue()))
        {
          localObject = "-";
          paramAnonymousb.setText(2131690981, (String)localObject);
          localObject = new StringBuilder().append(paramAnonymousPeopleItem.getAge().getName()).append("  ");
          if (!f.isNull(paramAnonymousPeopleItem.getAge().getValue())) {
            break label136;
          }
        }
        label136:
        for (paramAnonymousPeopleItem = "-";; paramAnonymousPeopleItem = paramAnonymousPeopleItem.getAge().getValue())
        {
          paramAnonymousb.setText(2131690052, paramAnonymousPeopleItem);
          return;
          localObject = paramAnonymousPeopleItem.getSex().getValue();
          break;
        }
      }
    };
    this.list.setAdapter(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903292);
    ButterKnife.bind(this);
    paramBundle = getIntent().getStringExtra("CustomerData");
    String str = getIntent().getStringExtra("title");
    this.tvTitle.setText(str);
    this.b = com.alibaba.fastjson.a.parseArray(paramBundle, PeopleItem.class);
    a();
    b();
    this.svContent.smoothScrollTo(0, 0);
  }
  
  @OnClick({2131691452})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordCustomerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */