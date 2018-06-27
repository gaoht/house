package com.ziroom.ziroomcustomer.newchat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.hyphenate.util.ImageUtils;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class AlertDialog
  extends BaseActivity
{
  private TextView a;
  private Button b;
  private int c;
  private ImageView d;
  private EditText e;
  private boolean f;
  
  public void cancel(View paramView)
  {
    finish();
  }
  
  public void ok(View paramView)
  {
    setResult(-1, new Intent().putExtra("position", this.c).putExtra("edittext", VdsAgent.trackEditTextSilent(this.e).toString()));
    if (this.c != -1) {
      ChatNewActivity.d = this.c;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903647);
    this.a = ((TextView)findViewById(2131689533));
    this.b = ((Button)findViewById(2131690460));
    this.d = ((ImageView)findViewById(2131689700));
    this.e = ((EditText)findViewById(2131693118));
    Object localObject = getIntent().getStringExtra("msg");
    String str2 = getIntent().getStringExtra("title");
    this.c = getIntent().getIntExtra("position", -1);
    boolean bool1 = getIntent().getBooleanExtra("titleIsCancel", true);
    boolean bool2 = getIntent().getBooleanExtra("cancel", true);
    this.f = getIntent().getBooleanExtra("editTextShow", true);
    paramBundle = getIntent().getStringExtra("forwardImage");
    String str1 = getIntent().getStringExtra("edit_text");
    if (localObject != null) {
      ((TextView)findViewById(2131693117)).setText((CharSequence)localObject);
    }
    if (str2 != null) {
      this.a.setText(str2);
    }
    if (bool1) {
      this.a.setVisibility(8);
    }
    if (bool2) {
      this.b.setVisibility(0);
    }
    if (paramBundle != null)
    {
      this.d.setVisibility(0);
      findViewById(2131693117).setVisibility(8);
      if (g.getInstance().get(paramBundle) == null) {
        break label341;
      }
      this.d.setImageBitmap(g.getInstance().get(paramBundle));
    }
    for (;;)
    {
      if (this.f)
      {
        this.e.setVisibility(0);
        this.e.setText(str1);
      }
      setResult(-1, new Intent().putExtra("position", this.c).putExtra("edittext", VdsAgent.trackEditTextSilent(this.e).toString()));
      if (this.c != -1) {
        ChatNewActivity.d = this.c;
      }
      finish();
      return;
      label341:
      localObject = ImageUtils.decodeScaleImage(paramBundle, 150, 150);
      this.d.setImageBitmap((Bitmap)localObject);
      g.getInstance().put(paramBundle, (Bitmap)localObject);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/AlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */