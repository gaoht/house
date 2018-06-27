package com.ziroom.ziroomcustomer.social.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.b;
import java.lang.ref.WeakReference;

public class a
  extends b
{
  private a a;
  private TextView b;
  private SimpleDraweeView c;
  private TextView d;
  
  public a(a parama)
  {
    super((Context)a.a(parama).get(), 2131427695);
    setContentView(2130903851);
    this.a = parama;
    parama = (Context)a.a(this.a).get();
    if (parama != null)
    {
      a(parama);
      a();
      return;
    }
    dismiss();
  }
  
  private void a()
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
        if (a.a.b(a.a(a.this)) != null) {
          a.a.b(a.a(a.this)).onClick(paramAnonymousView);
        }
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.c = ((SimpleDraweeView)findViewById(2131691098));
    this.b = ((TextView)findViewById(2131689541));
    this.d = ((TextView)findViewById(2131691363));
    this.b.setText(a.c(this.a));
    this.c.setController(c.frescoController(a.d(this.a)));
    if (!TextUtils.isEmpty(a.e(this.a))) {
      this.d.setText(a.e(this.a));
    }
  }
  
  public static a newBuilder(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public static class a
  {
    private WeakReference<Context> a;
    private String b;
    private String c;
    private String d;
    private View.OnClickListener e;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public a build()
    {
      return new a(this);
    }
    
    public a setButtonText(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a setCodeUrl(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.e = paramOnClickListener;
      return this;
    }
    
    public a setTitle(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public void show()
    {
      new a(this).show();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */