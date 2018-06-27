package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.h;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Map;

public class WaitDeliveryActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  private String d;
  private HashMap<String, Object> e;
  @BindView(2131692626)
  TextView wait_delivery_refresh;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("contract_part_code");
  }
  
  public void getData()
  {
    Map localMap = g.buildSundHandleList(this.c);
    this.d = (q.s + e.n.y);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(this.d).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        paramAnonymouse = h.parseSundHandleList(paramAnonymouse.toJSONString());
        if (paramAnonymouse.getSuccess().booleanValue())
        {
          if (paramAnonymouse.getObject() != null) {
            WaitDeliveryActivity.a(WaitDeliveryActivity.this, (HashMap)paramAnonymouse.getObject());
          }
          String str = WaitDeliveryActivity.this.getIntent().getStringExtra("lease");
          if (("5".equals(WaitDeliveryActivity.a(WaitDeliveryActivity.this).get("house_type") + "")) || ("8".equals(WaitDeliveryActivity.a(WaitDeliveryActivity.this).get("house_type") + "")))
          {
            paramAnonymouse = new Intent(WaitDeliveryActivity.this, NewZZItemsActivity.class);
            paramAnonymouse.putExtra("wuyesure", "wuyesure");
            paramAnonymouse.putExtra("contract_part_code", WaitDeliveryActivity.b(WaitDeliveryActivity.this));
            paramAnonymouse.putExtra("bts_map", WaitDeliveryActivity.a(WaitDeliveryActivity.this));
            paramAnonymouse.putExtra("lease", str);
            WaitDeliveryActivity.this.startActivity(paramAnonymouse);
            WaitDeliveryActivity.this.finish();
          }
        }
        for (;;)
        {
          dismissProgress();
          return;
          paramAnonymouse = new Intent(WaitDeliveryActivity.this, MainFragmentActivity.class);
          break;
          WaitDeliveryActivity.this.showToast(paramAnonymouse.getMessage());
        }
      }
    });
  }
  
  @OnClick({2131692626, 2131692624, 2131692625})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692625: 
      paramView = new Intent(this, MainActivity.class);
      paramView.putExtra("FRAGMENT_TYPE", 7);
      startActivity(paramView);
      finish();
      return;
    case 2131692626: 
      getData();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903545);
    this.b = this;
    this.a = ButterKnife.bind(this);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/WaitDeliveryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */