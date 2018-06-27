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

public class c
  extends b
{
  private a a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public c(a parama)
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
        c.this.dismiss();
        if (c.a.b(c.a(c.this)) != null) {
          c.a.b(c.a(c.this)).onClick(paramAnonymousView, true);
        }
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
        if (c.a.b(c.a(c.this)) != null) {
          c.a.b(c.a(c.this)).onClick(paramAnonymousView, false);
        }
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.e = ((TextView)findViewById(R.id.tv_content));
    this.d = ((TextView)findViewById(R.id.tv_title));
    this.b = ((TextView)findViewById(R.id.btn_confirm));
    this.c = ((TextView)findViewById(R.id.btn_cancel));
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
    setContentView(R.layout.dialog_ziroom_confirm);
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
    private c.b h;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public c build()
    {
      return new c(this);
    }
    
    public a setBtnCancelText(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a setBtnConfirmText(String paramString)
    {
      this.d = paramString;
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
    
    public a setOnConfirmClickListener(c.b paramb)
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
      new c(this).show();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onClick(View paramView, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */