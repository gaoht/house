package com.ziroom.ziroomcustomer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class a
  extends Dialog
{
  private TextView a;
  private Button b;
  private ImageView c;
  private String d = "";
  private boolean e = false;
  private boolean f = false;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131689850));
    this.b = ((Button)findViewById(2131692249));
    this.c = ((ImageView)findViewById(2131690588));
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        a.this.dismiss();
        return false;
      }
    });
    this.c.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        a.this.dismiss();
        return false;
      }
    });
    this.a.setText(this.d);
    if (this.e) {
      this.b.setVisibility(0);
    }
    while (this.f)
    {
      this.c.setVisibility(0);
      return;
      this.b.setVisibility(8);
    }
    this.c.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.onCreate(paramBundle);
    setContentView(2130903644);
    a();
  }
  
  public void setMessage(String paramString)
  {
    this.d = paramString;
  }
  
  public void showClose()
  {
    this.f = true;
  }
  
  public void showOK()
  {
    this.e = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */