package com.ziroom.ziroomcustomer.newclean.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestActivity
  extends BaseActivity
{
  private TextView a;
  private TestActivity b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private SimpleDraweeView g;
  private int r = 1;
  private int s = 200;
  private int t = 200;
  private List<File> u = new ArrayList();
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131692606));
    this.c = ((ImageView)findViewById(2131692601));
    this.g = ((SimpleDraweeView)findViewById(2131692602));
    this.d = ((ImageView)findViewById(2131692603));
    this.e = ((ImageView)findViewById(2131692604));
    this.f = ((ImageView)findViewById(2131692605));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = this;
    setContentView(2130903532);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/TestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */