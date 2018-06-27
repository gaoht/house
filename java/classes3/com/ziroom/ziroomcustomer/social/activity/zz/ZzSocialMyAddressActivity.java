package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.social.a.g;
import com.ziroom.ziroomcustomer.social.a.g.a;
import com.ziroom.ziroomcustomer.social.model.o;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class ZzSocialMyAddressActivity
  extends BaseActivity
{
  private g a;
  private o b;
  @BindView(2131690043)
  Button btn;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131691217)
  ListView list;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131689850)
  TextView tvMessage;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691494)
  View vLineBottom;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903630);
    ButterKnife.bind(this);
    this.b = ((o)getIntent().getSerializableExtra("address"));
    this.a = new g(this);
    this.list.setAdapter(this.a);
    this.vLineBottom.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ZzSocialMyAddressActivity.this.vLineBottom.setAlpha(f);
      }
    });
    this.a.setmPayType(new g.a()
    {
      public void setSelectType(o paramAnonymouso)
      {
        ZzSocialMyAddressActivity.a(ZzSocialMyAddressActivity.this, paramAnonymouso);
        if (ZzSocialMyAddressActivity.a(ZzSocialMyAddressActivity.this) == null)
        {
          ZzSocialMyAddressActivity.this.btn.setEnabled(false);
          return;
        }
        ZzSocialMyAddressActivity.this.btn.setEnabled(true);
      }
    });
    n.getUserLocations(this, new d(this, new e(o.class))
    {
      public void onSuccess(int paramAnonymousInt, List<o> paramAnonymousList)
      {
        int i = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (ZzSocialMyAddressActivity.a(ZzSocialMyAddressActivity.this) != null)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousList.size())
          {
            if (((o)paramAnonymousList.get(paramAnonymousInt)).getHouse_address().equals(ZzSocialMyAddressActivity.a(ZzSocialMyAddressActivity.this).getHouse_address()))
            {
              ZzSocialMyAddressActivity.b(ZzSocialMyAddressActivity.this).a = paramAnonymousInt;
              ZzSocialMyAddressActivity.this.btn.setEnabled(true);
            }
            paramAnonymousInt += 1;
          }
        }
        if (ZzSocialMyAddressActivity.b(ZzSocialMyAddressActivity.this).a == -1) {
          paramAnonymousInt = i;
        }
        for (;;)
        {
          if (paramAnonymousInt < paramAnonymousList.size())
          {
            o localo = (o)paramAnonymousList.get(paramAnonymousInt);
            if ((localo.getBizcircle_name() != null) && (localo.getBizcircle_name().equals(ZzSocialMyAddressActivity.a(ZzSocialMyAddressActivity.this).getBizcircle_name())))
            {
              ZzSocialMyAddressActivity.b(ZzSocialMyAddressActivity.this).a = paramAnonymousInt;
              ZzSocialMyAddressActivity.this.btn.setEnabled(true);
            }
          }
          else
          {
            ZzSocialMyAddressActivity.b(ZzSocialMyAddressActivity.this).setmList(paramAnonymousList);
            return;
          }
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  @OnClick({2131690078, 2131690043})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    }
    paramView = new Intent();
    paramView.putExtra("address", this.b);
    setResult(21, paramView);
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMyAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */