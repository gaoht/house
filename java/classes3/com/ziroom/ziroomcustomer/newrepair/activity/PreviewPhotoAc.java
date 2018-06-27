package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newrepair.widget.TouchImageView;
import com.ziroom.ziroomcustomer.newrepair.widget.TouchImageView.a;
import java.util.ArrayList;
import java.util.List;

public class PreviewPhotoAc
  extends BaseActivity
{
  private List<String> a;
  private int b;
  private Context c;
  private TouchImageView d;
  private int e;
  private TouchImageView.a f = new TouchImageView.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      PreviewPhotoAc.this.finish();
    }
  };
  
  private void a()
  {
    this.d = ((TouchImageView)getSupportFragmentManager().findFragmentById(2131690555));
  }
  
  public void bindLunboTu(List<String> paramList, int paramInt)
  {
    if (paramList.size() > 1) {
      this.d.setCycle(true);
    }
    for (;;)
    {
      this.d.setData(this, paramList, this.f, paramInt, 1);
      return;
      this.d.setCycle(false);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903435);
    this.c = this;
    a();
    this.a = ((ArrayList)getIntent().getSerializableExtra("photos"));
    this.b = getIntent().getIntExtra("position", 0);
    this.e = getIntent().getIntExtra("mHouse_type", 1);
    bindLunboTu(this.a, this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/PreviewPhotoAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */