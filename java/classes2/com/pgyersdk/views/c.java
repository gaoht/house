package com.pgyersdk.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.pgyersdk.b.b;
import com.pgyersdk.i.k;

public abstract class c
  extends AlertDialog.Builder
{
  protected static String e = "#ffffff";
  protected static String j = "#2E2D2D";
  protected Context a;
  protected TextView b;
  protected Activity c;
  protected int d;
  protected String f;
  protected String g;
  protected int h;
  protected int i;
  private ScrollView k;
  
  public c(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.c = ((Activity)paramContext);
    }
    this.a = paramContext;
  }
  
  @TargetApi(11)
  public c(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    if ((paramContext instanceof Activity)) {
      this.c = ((Activity)paramContext);
    }
    if (paramInt == 2) {
      this.a = new ContextThemeWrapper(paramContext, 16973931);
    }
    for (;;)
    {
      this.d = paramInt;
      return;
      if (paramInt == 3) {
        this.a = new ContextThemeWrapper(paramContext, 16973934);
      } else {
        this.a = new ContextThemeWrapper(paramContext, 16973829);
      }
    }
  }
  
  private AlertDialog a(AlertDialog paramAlertDialog)
  {
    Window localWindow = paramAlertDialog.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.gravity = 7;
    localWindow.setAttributes(localLayoutParams);
    return paramAlertDialog;
  }
  
  public static void setDialogTitleBackgroundColor(String paramString)
  {
    j = paramString;
  }
  
  public static void setDialogTitleTextColor(String paramString)
  {
    e = paramString;
  }
  
  protected abstract View a(Context paramContext);
  
  protected View a(Context paramContext, CharSequence paramCharSequence)
  {
    this.b = new TextView(paramContext);
    this.b.setText(paramCharSequence.toString());
    this.b.setTextSize(22.0F);
    this.b.setTextColor(Color.parseColor(e));
    this.b.setPadding(30, 20, 0, 20);
    this.b.setBackgroundColor(Color.parseColor(j));
    this.b.setGravity(17);
    this.b.setSingleLine(true);
    return this.b;
  }
  
  protected void a(int paramInt)
  {
    if (k.a(j)) {
      j = "#56bc94";
    }
    if (k.a(e)) {
      j = "#ffffff";
    }
    this.f = "#56bc94";
    this.g = "#cccccc";
    this.h = Color.rgb(245, 245, 245);
    this.i = Color.rgb(255, 255, 255);
  }
  
  protected abstract View b(Context paramContext);
  
  public AlertDialog create()
  {
    a(this.d);
    AlertDialog localAlertDialog = super.create();
    localAlertDialog.getWindow().clearFlags(131072);
    localAlertDialog.requestWindowFeature(1);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(a(this.a, b.a(1062)));
    this.k = new ScrollView(this.a);
    this.k.setVerticalScrollBarEnabled(false);
    if (this.a.getResources().getConfiguration().orientation == 1) {
      this.k.addView(a(this.a), g());
    }
    for (;;)
    {
      localLinearLayout.addView(this.k, g());
      localAlertDialog.setView(localLinearLayout);
      return localAlertDialog;
      this.k.addView(b(this.a), g());
    }
  }
  
  protected LinearLayout.LayoutParams g()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  public AlertDialog.Builder setTitle(CharSequence paramCharSequence)
  {
    setCustomTitle(a(this.a, paramCharSequence));
    return super.setTitle(paramCharSequence);
  }
  
  public AlertDialog show()
  {
    return a(super.show());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */