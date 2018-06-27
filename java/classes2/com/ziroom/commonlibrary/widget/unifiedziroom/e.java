package com.ziroom.commonlibrary.widget.unifiedziroom;

import android.content.Context;
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

public class e
  extends b
{
  private a a;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public e(a parama)
  {
    super((Context)a.a(parama).get(), R.style.UnifiedZiroomDialogTheme);
    setContentView(R.layout.dialog_ziroom_info);
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
        e.this.dismiss();
        if (e.a.b(e.a(e.this)) != null) {
          e.a.b(e.a(e.this)).onClick(paramAnonymousView);
        }
      }
    });
  }
  
  private void a(Context paramContext)
  {
    this.c = ((TextView)findViewById(R.id.tv_content));
    this.b = ((TextView)findViewById(R.id.tv_title));
    this.d = ((TextView)findViewById(R.id.btn_confirm));
    if (!TextUtils.isEmpty(a.c(this.a))) {
      this.b.setText(a.c(this.a));
    }
    this.c.setText(a.d(this.a));
    if (!TextUtils.isEmpty(a.e(this.a))) {
      this.d.setText(a.e(this.a));
    }
    if (a.f(this.a)) {
      setCanceledOnTouchOutside(a.g(this.a));
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
    private boolean e;
    private boolean f;
    private View.OnClickListener g;
    
    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public e build()
    {
      return new e(this);
    }
    
    public a setButtonText(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.f = true;
      this.e = paramBoolean;
      return this;
    }
    
    public a setContent(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.g = paramOnClickListener;
      return this;
    }
    
    public a setTitle(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public void show()
    {
      new e(this).show();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */