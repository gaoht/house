package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoPreviewActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final String b = PhotoPreviewActivity.class.getSimpleName();
  private ViewPager a;
  private String[] c;
  private List<String> d = new ArrayList();
  private int e = 0;
  private boolean f = true;
  private g g;
  private ImageView r;
  private ImageView s;
  private TextView t;
  private Dialog u;
  private Dialog v;
  
  private void a()
  {
    this.d = getIntent().getStringArrayListExtra("photoDescription");
    this.e = getIntent().getIntExtra("position", 0);
    this.f = getIntent().getBooleanExtra("isDeleteable", true);
    this.u = b();
    this.a = ((ViewPager)findViewById(2131691037));
    this.g = new g(this, this.d);
    this.a.setAdapter(this.g);
    this.r = ((ImageView)findViewById(2131691035));
    this.s = ((ImageView)findViewById(2131692519));
    ImageView localImageView = this.s;
    if (this.f) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      this.t = ((TextView)findViewById(2131691036));
      this.t.setText(this.e + 1 + "/" + this.d.size());
      this.a.setCurrentItem(this.e);
      this.a.setOnPageChangeListener(this);
      this.s.setOnClickListener(this);
      this.r.setOnClickListener(this);
      return;
    }
  }
  
  private Dialog b()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawableResource(17170445);
    localDialog.setContentView(2130905077);
    return localDialog;
  }
  
  private void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(this.c));
    localArrayList.remove(paramInt);
    this.c = new String[localArrayList.size()];
    localArrayList.toArray(this.c);
    setBackResult();
  }
  
  private Dialog e()
  {
    c localc = c.newBuilder(this).setTitle("提示").setContent("确认删除该图片?").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          PhotoPreviewActivity.a(PhotoPreviewActivity.this, PhotoPreviewActivity.a(PhotoPreviewActivity.this).getCurrentItem());
        }
      }
    }).build();
    if (!(localc instanceof Dialog))
    {
      localc.show();
      return localc;
    }
    VdsAgent.showDialog((Dialog)localc);
    return localc;
  }
  
  public void onBackPressed()
  {
    setBackResult();
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691035: 
      setBackResult();
      return;
    }
    this.v = e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903517);
    a();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Log.d(b, "onPageSelected" + paramInt);
    this.t.setText(paramInt + 1 + "/" + this.g.getCount());
  }
  
  public void setBackResult()
  {
    if (this.f)
    {
      localObject = new Intent();
      String[] arrayOfString = new String[this.d.size()];
      int i = 0;
      while (i < this.d.size())
      {
        arrayOfString[i] = ((String)this.d.get(i));
        i += 1;
      }
      ((Intent)localObject).putExtra("photoPaths", arrayOfString);
      setResult(-1, (Intent)localObject);
    }
    Object localObject = this.a.getBackground();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.a = null;
    this.g = null;
    this.r = null;
    this.s = null;
    this.t = null;
    finish();
    System.gc();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/PhotoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */