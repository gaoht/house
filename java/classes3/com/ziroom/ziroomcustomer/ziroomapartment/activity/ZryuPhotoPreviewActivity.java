package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZryuPhotoPreviewActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final String b = ZryuPhotoPreviewActivity.class.getSimpleName();
  private ViewPager a;
  private String[] c;
  private List<String> d = new ArrayList();
  private int e = 0;
  private boolean f = true;
  private f g;
  private ImageView r;
  private ImageView s;
  private TextView t;
  private TextView u;
  private Dialog v;
  private Dialog w;
  
  private void a()
  {
    this.d = getIntent().getStringArrayListExtra("urlList");
    this.e = getIntent().getIntExtra("position", 0);
    this.f = getIntent().getBooleanExtra("isDeleteable", true);
    this.v = b();
    this.a = ((ViewPager)findViewById(2131691037));
    this.g = new f(this, this.d);
    this.a.setAdapter(this.g);
    this.r = ((ImageView)findViewById(2131691035));
    this.s = ((ImageView)findViewById(2131692519));
    ImageView localImageView = this.s;
    int i;
    if (this.f)
    {
      i = 0;
      localImageView.setVisibility(i);
      this.t = ((TextView)findViewById(2131691036));
      this.t.setText(this.e + 1 + "/" + this.d.size());
      this.u = ((TextView)findViewById(2131692918));
      if (!ae.isNull(getIntent().getStringExtra("fPanoramicUrl"))) {
        break label277;
      }
      this.u.setVisibility(8);
    }
    for (;;)
    {
      this.u.setOnClickListener(this);
      this.a.setCurrentItem(this.e);
      this.a.setOnPageChangeListener(this);
      this.s.setOnClickListener(this);
      this.r.setOnClickListener(this);
      return;
      i = 8;
      break;
      label277:
      this.u.setVisibility(0);
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
    Dialog localDialog = new Dialog(this, 2131427591);
    localDialog.setContentView(2130903834);
    TextView localTextView = (TextView)localDialog.findViewById(2131689850);
    Button localButton1 = (Button)localDialog.findViewById(2131692249);
    Button localButton2 = (Button)localDialog.findViewById(2131690460);
    localTextView.setText("确认删除该图片?");
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return localDialog;
    }
    VdsAgent.showDialog((Dialog)localDialog);
    return localDialog;
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
    }
    do
    {
      return;
      setBackResult();
      return;
      this.w = e();
      return;
      this.w.dismiss();
      b(this.a.getCurrentItem());
      return;
      this.w.dismiss();
      return;
      w.onEventToZiroomAndUmeng("zra_xm_vr");
    } while (TextUtils.isEmpty(getIntent().getStringExtra("fPanoramicUrl")));
    JsBridgeWebActivity.start(this, "全景看房", getIntent().getStringExtra("fPanoramicUrl"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903592);
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
    if (this.a == null) {
      return;
    }
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuPhotoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */