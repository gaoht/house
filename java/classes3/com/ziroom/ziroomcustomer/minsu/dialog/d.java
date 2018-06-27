package com.ziroom.ziroomcustomer.minsu.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.b;
import java.lang.ref.WeakReference;

public class d
  extends b
{
  private a a;
  private View b;
  private TextView c;
  private TextView d;
  private SimpleDraweeView e;
  
  public d(a parama)
  {
    super((Context)a.a(parama).get(), 2131427695);
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
        if (d.a.b(d.a(d.this)) != null) {
          d.a.b(d.a(d.this)).onCloseClick();
        }
        d.this.dismiss();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (d.a.b(d.a(d.this)) != null) {
          d.a.b(d.a(d.this)).onConfirmClick();
        }
        d.this.dismiss();
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.c = ((TextView)findViewById(2131689541));
    this.d = ((TextView)findViewById(2131691363));
    this.b = findViewById(2131690460);
    this.e = ((SimpleDraweeView)findViewById(2131693822));
    this.c.setText(a.c(this.a));
    this.d.setText(a.d(this.a));
    this.e.setController(c.frescoController(a.e(this.a)));
  }
  
  public static a newBuilder(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (a.b(this.a) != null) {
      a.b(this.a).onCloseClick();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903816);
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
    private d.b e;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public d build()
    {
      return new d(this);
    }
    
    public a setButtonText(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a setOnClickListener(d.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public a setTitle(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a setUrl(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public void show()
    {
      new d(this).show();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onCloseClick();
    
    public abstract void onConfirmClick();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */