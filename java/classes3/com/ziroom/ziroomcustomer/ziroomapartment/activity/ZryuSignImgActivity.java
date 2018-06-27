package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.d.a.a;

public class ZryuSignImgActivity
  extends BaseActivity
{
  private ZoomableDraweeView a;
  
  private void a()
  {
    this.a = ((ZoomableDraweeView)findViewById(2131691098));
    ((GenericDraweeHierarchy)this.a.getHierarchy()).setPlaceholderImage(a.a.b);
  }
  
  private void b()
  {
    String str = getIntent().getStringExtra("imgUrl");
    if (!TextUtils.isEmpty(str)) {
      this.a.setController(c.frescoController(str));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903613);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignImgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */