package com.ziroom.commonlibrary.widget.unifiedziroom;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.style;
import java.lang.ref.WeakReference;

public class d
  extends b
{
  private a a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public d(a parama)
  {
    super((Context)a.a(parama).get(), R.style.UnifiedZiroomDialogTheme);
    this.a = parama;
  }
  
  private void a()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.this.dismiss();
        if (d.a.b(d.a(d.this)) != null) {
          d.a.b(d.a(d.this)).onLeftClick(paramAnonymousView);
        }
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.this.dismiss();
        if (d.a.b(d.a(d.this)) != null) {
          d.a.b(d.a(d.this)).onRightClick(paramAnonymousView);
        }
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.e = ((TextView)findViewById(R.id.tv_content));
    this.d = ((TextView)findViewById(R.id.tv_title));
    this.c = ((TextView)findViewById(R.id.btn_right));
    this.b = ((TextView)findViewById(R.id.btn_left));
    if (!TextUtils.isEmpty(a.c(this.a))) {
      this.d.setText(a.c(this.a));
    }
    this.e.setText(a.d(this.a));
    if (!TextUtils.isEmpty(a.e(this.a))) {
      this.b.setText(a.e(this.a));
    }
    if (!TextUtils.isEmpty(a.f(this.a))) {
      this.c.setText(a.f(this.a));
    }
    if (a.g(this.a)) {
      setCanceledOnTouchOutside(a.h(this.a));
    }
  }
  
  public static a newBuilder(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.dialog_ziroom_custom_double);
    paramBundle = (Context)a.a(this.a).get();
    if (paramBundle != null)
    {
      a(paramBundle);
      a();
      return;
    }
    dismiss();
  }
  
  public static class a
  {
    private WeakReference<Context> a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private d.b h;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public d build()
    {
      return new d(this);
    }
    
    public a setButtonText(String paramString1, String paramString2)
    {
      this.e = paramString1;
      this.d = paramString2;
      return this;
    }
    
    public a setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.g = true;
      this.f = paramBoolean;
      return this;
    }
    
    public a setContent(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a setOnConfirmClickListener(d.b paramb)
    {
      this.h = paramb;
      return this;
    }
    
    public a setTitle(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public void show()
    {
      new d(this).show();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onLeftClick(View paramView);
    
    public abstract void onRightClick(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */