package com.ziroom.ziroomcustomer.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class c
  extends a
{
  private View a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private a g;
  
  private c(a parama)
  {
    super((Context)a.a(parama).get(), 2131427574);
    this.g = parama;
  }
  
  private void a()
  {
    if (a.b(this.g) != null) {
      setOnDismissListener(a.b(this.g));
    }
    if (a.c(this.g) != null) {
      setOnShowListener(a.c(this.g));
    }
    setCanceledOnTouchOutside(a.d(this.g));
  }
  
  private void a(final Context paramContext)
  {
    this.c = ((TextView)findViewById(2131691363));
    if (a.f(this.g) != null) {
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.a.f(c.a(c.this)).onClick(paramAnonymousView);
          if ((paramContext != null) && (!((Activity)paramContext).isFinishing())) {
            c.this.dismiss();
          }
        }
      });
    }
    Object localObject;
    int i;
    for (;;)
    {
      if (!TextUtils.isEmpty(a.g(this.g))) {
        this.c.setText(a.g(this.g));
      }
      this.d = ((TextView)findViewById(2131690084));
      if ((a.h(this.g) == null) || (a.h(this.g).size() <= 0)) {
        break label263;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < a.h(this.g).size())
      {
        if (!TextUtils.isEmpty((CharSequence)a.h(this.g).get(i))) {
          ((StringBuilder)localObject).append((String)a.h(this.g).get(i)).append("\n");
        }
        i += 1;
      }
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.this.dismiss();
        }
      });
    }
    if (((StringBuilder)localObject).length() > 1)
    {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      if (a.i(this.g) != 0) {
        this.d.setGravity(a.i(this.g));
      }
      this.d.setText(((StringBuilder)localObject).toString());
    }
    label263:
    this.e = ((TextView)findViewById(2131689541));
    if (!TextUtils.isEmpty(a.j(this.g)))
    {
      this.e.setVisibility(0);
      this.e.setText(a.j(this.g));
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, n.dip2px(paramContext, 12.0F), 0, 0);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a = findViewById(2131690425);
      if (a.k(this.g) != null) {
        this.a.setLayoutParams(a.k(this.g));
      }
      this.b = findViewById(2131693705);
      this.f = ((TextView)findViewById(2131690460));
      if (a.l(this.g) == null) {
        break label558;
      }
      this.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.a.l(c.a(c.this)).onClick(paramAnonymousView);
          c.this.dismiss();
        }
      });
      label428:
      if (TextUtils.isEmpty(a.m(this.g))) {
        break label576;
      }
      this.b.setVisibility(0);
      this.f.setVisibility(0);
      this.f.setText(a.m(this.g));
    }
    for (;;)
    {
      i = (ac.getScreenHeight(paramContext) - n.dip2px(paramContext, 400.0F)) / 2;
      localObject = getWindow();
      int j = n.dip2px(paramContext, 24.0F);
      ((Window)localObject).getDecorView().setPadding(j, i, j, i);
      return;
      this.e.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, n.dip2px(paramContext, 24.0F), 0, 0);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label558:
      this.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.this.dismiss();
        }
      });
      break label428;
      label576:
      this.b.setVisibility(8);
      this.f.setVisibility(8);
    }
  }
  
  public static a newBuilder(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void onBackPressed()
  {
    if (a.e(this.g)) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903777);
    paramBundle = (Context)a.a(this.g).get();
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
    private List<String> d;
    private int e;
    private String f;
    private DialogInterface.OnDismissListener g;
    private DialogInterface.OnShowListener h;
    private boolean i = false;
    private FrameLayout.LayoutParams j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private boolean m = true;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public c build()
    {
      return new c(this, null);
    }
    
    public a setButtonText(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a setCanceledOnBackPressed(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }
    
    public a setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
    
    public a setContent(String paramString)
    {
      this.d = new ArrayList();
      this.d.add(paramString);
      return this;
    }
    
    public a setContentGravity(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public a setContentList(List<String> paramList)
    {
      this.d = new ArrayList();
      this.d.addAll(paramList);
      return this;
    }
    
    public a setDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.g = paramOnDismissListener;
      return this;
    }
    
    public a setLayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      this.j = paramLayoutParams;
      return this;
    }
    
    public a setOnButtonClickListener(View.OnClickListener paramOnClickListener)
    {
      this.k = paramOnClickListener;
      return this;
    }
    
    public a setOnSecondClickListener(View.OnClickListener paramOnClickListener)
    {
      this.l = paramOnClickListener;
      return this;
    }
    
    public a setSecondButtonText(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a setShowListener(DialogInterface.OnShowListener paramOnShowListener)
    {
      this.h = paramOnShowListener;
      return this;
    }
    
    public a setTitle(String paramString)
    {
      this.f = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */