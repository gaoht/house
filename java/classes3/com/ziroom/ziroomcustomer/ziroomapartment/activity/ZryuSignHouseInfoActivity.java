package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignRoom;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignRoomInfo;

public class ZryuSignHouseInfoActivity
  extends BaseActivity
{
  private ImageView a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private String t;
  private ZryuSignProject u;
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((SimpleDraweeView)findViewById(2131691098));
    this.c = ((TextView)findViewById(2131696404));
    this.d = ((TextView)findViewById(2131696579));
    this.e = ((TextView)findViewById(2131696402));
    this.f = ((TextView)findViewById(2131693029));
    this.g = ((TextView)findViewById(2131693023));
    this.r = ((TextView)findViewById(2131693024));
    this.s = ((TextView)findViewById(2131693025));
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.t)) {
      j.zryuContractRoomInfo(this, this.t, new com.ziroom.ziroomcustomer.e.a.c(this, new f(ZryuSignRoomInfo.class))
      {
        public void onSuccess(int paramAnonymousInt, ZryuSignRoomInfo paramAnonymousZryuSignRoomInfo)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignRoomInfo);
          if (paramAnonymousZryuSignRoomInfo != null)
          {
            ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this, paramAnonymousZryuSignRoomInfo.getProjectInfo());
            if (ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this) != null)
            {
              ZryuSignHouseInfoActivity.b(ZryuSignHouseInfoActivity.this).setText(ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this).getProName());
              ZryuSignHouseInfoActivity.c(ZryuSignHouseInfoActivity.this).setText(ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this).getProAddress());
              ZryuSignHouseInfoActivity.d(ZryuSignHouseInfoActivity.this).setText(ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this).getRoomSalesPrice() + "");
              ZryuSignHouseInfoActivity.e(ZryuSignHouseInfoActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(ZryuSignHouseInfoActivity.a(ZryuSignHouseInfoActivity.this).getProHeadFigureUrl()));
            }
            ZryuSignRoom localZryuSignRoom = paramAnonymousZryuSignRoomInfo.getRoomInfo();
            if (localZryuSignRoom != null)
            {
              ZryuSignHouseInfoActivity.f(ZryuSignHouseInfoActivity.this).setText(localZryuSignRoom.getHouseTypeName());
              ZryuSignHouseInfoActivity.g(ZryuSignHouseInfoActivity.this).setText(localZryuSignRoom.getFloorNumber());
              ZryuSignHouseInfoActivity.h(ZryuSignHouseInfoActivity.this).setText(localZryuSignRoom.getRoomDirection());
            }
            ZryuSignHouseInfoActivity.i(ZryuSignHouseInfoActivity.this).setText(paramAnonymousZryuSignRoomInfo.getRentTime());
          }
        }
      });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903612);
    ApplicationEx.c.addToZryuSign(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeFromZryuSign(this);
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131696578: 
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    paramView = new Intent(this, ZryuSignPaymentMethodActivity.class);
    paramView.putExtra("contractId", this.t);
    startActivity(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignHouseInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */