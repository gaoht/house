package com.ziroom.ziroomcustomer.widget.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
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
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private View g;
  private SimpleDraweeView h;
  private LinearLayout i;
  private ScrollView j;
  private Context k;
  
  public a(a parama)
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
        a.this.dismiss();
        if (a.a.c(a.a(a.this)) != null) {
          a.a.c(a.a(a.this)).onClick(paramAnonymousView, true);
        }
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
        if (a.a.c(a.a(a.this)) != null) {
          a.a.c(a.a(a.this)).onClick(paramAnonymousView, false);
        }
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.i = ((LinearLayout)findViewById(2131690425));
    this.j = ((ScrollView)findViewById(2131689506));
    this.e = ((TextView)findViewById(2131693929));
    this.d = ((TextView)findViewById(2131689541));
    this.b = ((TextView)findViewById(2131691363));
    this.c = ((TextView)findViewById(2131690460));
    this.g = findViewById(2131690147);
    this.h = ((SimpleDraweeView)findViewById(2131693928));
    this.f = ((TextView)findViewById(2131690084));
    if (!TextUtils.isEmpty(a.d(this.a))) {
      this.d.setText(a.d(this.a));
    }
    if (!TextUtils.isEmpty(a.e(this.a))) {
      this.b.setText(a.e(this.a));
    }
    if (!TextUtils.isEmpty(a.f(this.a)))
    {
      this.e.setText(a.f(this.a).replaceAll("\\\\n", "\n"));
      if (TextUtils.isEmpty(a.g(this.a))) {
        break label362;
      }
      paramContext = new GenericDraweeHierarchyBuilder(getContext().getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
      this.h.setHierarchy(paramContext);
      this.h.setController(c.frescoController(a.g(this.a)));
      this.h.setVisibility(0);
      label278:
      if (TextUtils.isEmpty(a.h(this.a))) {
        break label374;
      }
      this.c.setText(a.h(this.a));
    }
    for (;;)
    {
      if (a.i(this.a)) {
        setCanceledOnTouchOutside(a.j(this.a));
      }
      this.f.setText(a.k(this.a));
      return;
      this.e.setVisibility(8);
      this.g.setVisibility(8);
      break;
      label362:
      this.h.setVisibility(8);
      break label278;
      label374:
      this.c.setVisibility(8);
    }
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f1 = paramInt;
    return (int)(paramContext.density * f1 + 0.5D);
  }
  
  public static a newBuilder(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903875);
    this.k = ((Context)a.a(this.a).get());
    if (this.k != null)
    {
      a(this.k);
      a();
    }
    for (;;)
    {
      setCancelable(a.b(this.a));
      return;
      dismiss();
    }
  }
  
  public void show()
  {
    super.show();
  }
  
  public static class a
  {
    private WeakReference<Context> a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private a.b k;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public a build()
    {
      return new a(this);
    }
    
    public a setBtnCancelText(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a setBtnConfirmText(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a setCanceledOnBack(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
    
    public a setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.i = true;
      this.h = paramBoolean;
      return this;
    }
    
    public a setContent(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a setContentInfo(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a setImageUrl(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public a setOnConfirmClickListener(a.b paramb)
    {
      this.k = paramb;
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
  
  public static abstract interface b
  {
    public abstract void onClick(View paramView, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */