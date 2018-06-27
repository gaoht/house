package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class InternalRepairShowBigPicActivity
  extends BaseActivity
{
  private SimpleDraweeView a;
  private int b;
  
  private void a()
  {
    this.a = ((SimpleDraweeView)findViewById(2131691028));
    String str = getIntent().getStringExtra("picUrl");
    this.b = getIntent().getIntExtra("mImgIndex", -1);
    if (!TextUtils.isEmpty(str)) {
      this.a.setController(c.frescoController(str));
    }
    int i = getIntent().getIntExtra("mImgCount", -1);
    ((TextView)findViewById(2131689541)).setText(this.b + "/" + i);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903232);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairShowBigPicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */