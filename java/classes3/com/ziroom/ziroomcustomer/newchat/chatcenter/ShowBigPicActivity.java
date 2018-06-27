package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class ShowBigPicActivity
  extends BaseActivity
{
  private SimpleDraweeView a;
  private String b;
  
  private void a()
  {
    this.a = ((SimpleDraweeView)findViewById(2131691028));
    String str = getIntent().getStringExtra("picUrl");
    this.b = getIntent().getStringExtra("mImgIndex");
    if (!TextUtils.isEmpty(str)) {
      this.a.setController(c.frescoController(str));
    }
    str = getIntent().getStringExtra("mImgCount");
    ImageView localImageView1 = (ImageView)findViewById(2131689492);
    ImageView localImageView2 = (ImageView)findViewById(2131692598);
    ((TextView)findViewById(2131689541)).setText(this.b + "/" + str);
    localImageView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ShowBigPicActivity.this.finish();
      }
    });
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.setAction("showbig_delete");
        paramAnonymousView.putExtra("imgIndex", ShowBigPicActivity.a(ShowBigPicActivity.this));
        ShowBigPicActivity.this.setResult(-1, paramAnonymousView);
        ShowBigPicActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903528);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/ShowBigPicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */