package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class u
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a = null;
  private EditText b = null;
  private ImageView c = null;
  private boolean d = true;
  private b e = null;
  private a f = null;
  private int g;
  private Drawable h;
  private TextView i = null;
  private LinearLayout j;
  private View.OnClickListener k = new v(this);
  private TextWatcher l = new w(this);
  private View.OnFocusChangeListener m = new x(this);
  
  public u(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setOrientation(0);
    this.g = a.n;
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setFocusable(true);
    paramContext = new TextView(this.a);
    paramContext.setPadding(f.a(this.a, 10.0F), 0, 0, 0);
    paramContext.setEms(4);
    Object localObject1 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject1).gravity = 19;
    addView(paramContext, (ViewGroup.LayoutParams)localObject1);
    paramContext.setGravity(19);
    paramContext.setTextSize(b.k);
    paramContext.setTextColor(-13421773);
    this.i = paramContext;
    this.i.setVisibility(8);
    paramContext = new RelativeLayout(this.a);
    paramContext.setGravity(21);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject1).gravity = 19;
    addView(paramContext, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout(this.a);
    ((LinearLayout)localObject2).setGravity(21);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    localObject1 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = f.a(this.a, 10.0F);
    ((LinearLayout)localObject2).setVisibility(8);
    paramContext.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.j = ((LinearLayout)localObject2);
    localObject1 = new RelativeLayout(this.a);
    ((RelativeLayout)localObject1).setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(0, ((LinearLayout)localObject2).getId());
    localLayoutParams.rightMargin = f.a(this.a, 10.0F);
    paramContext.addView((View)localObject1, localLayoutParams);
    this.c = new ImageView(this.a);
    this.c.setId(this.c.hashCode());
    this.c.setBackgroundDrawable(this.h);
    this.c.setOnClickListener(this.k);
    this.c.setVisibility(8);
    this.c.setId(this.c.hashCode());
    this.c.setAdjustViewBounds(true);
    int n = f.a(this.a, 30.0F);
    paramContext = new RelativeLayout.LayoutParams(n, n);
    paramContext.addRule(11, -1);
    paramContext.addRule(15, -1);
    ((RelativeLayout)localObject1).addView(this.c, paramContext);
    this.b = new EditText(this.a);
    this.b.setSingleLine();
    this.b.setTextSize(b.k);
    this.b.setTextColor(-10066330);
    this.b.setHintTextColor(-6710887);
    this.b.setBackgroundDrawable(null);
    this.b.setGravity(16);
    this.b.setPadding(f.a(this.a, 10.0F), 0, 0, 0);
    this.b.addTextChangedListener(this.l);
    if (this.d) {
      this.b.setOnFocusChangeListener(this.m);
    }
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(0, this.c.getId());
    paramContext.addRule(15, -1);
    paramContext.addRule(9, -1);
    ((RelativeLayout)localObject1).addView(this.b, paramContext);
  }
  
  public final TextView a(String paramString)
  {
    if ((this.i != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.i.setVisibility(0);
      this.i.setText(paramString);
    }
    return this.i;
  }
  
  public final u a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.c.setBackgroundDrawable(paramDrawable);
    }
    return this;
  }
  
  public final void a()
  {
    this.d = false;
    if (this.b != null)
    {
      this.b.setKeyListener(null);
      this.b.setFocusable(false);
      if ((this.c != null) && (this.c.getVisibility() == 0)) {
        this.c.setVisibility(8);
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.b != null) {
      this.b.setInputType(paramInt);
    }
  }
  
  public final void a(InputFilter paramInputFilter)
  {
    InputFilter[] arrayOfInputFilter1 = new InputFilter[1];
    arrayOfInputFilter1[0] = paramInputFilter;
    if (this.b == null) {
      return;
    }
    paramInputFilter = this.b.getFilters();
    if (paramInputFilter == null)
    {
      this.b.setFilters(arrayOfInputFilter1);
      return;
    }
    InputFilter[] arrayOfInputFilter2 = new InputFilter[paramInputFilter.length + arrayOfInputFilter1.length];
    System.arraycopy(paramInputFilter, 0, arrayOfInputFilter2, 0, paramInputFilter.length);
    System.arraycopy(arrayOfInputFilter1, 0, arrayOfInputFilter2, paramInputFilter.length, arrayOfInputFilter1.length);
    this.b.setFilters(arrayOfInputFilter2);
  }
  
  public final void a(TextWatcher paramTextWatcher)
  {
    if ((this.b != null) && (paramTextWatcher != null)) {
      this.b.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public final void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((paramView != null) && (this.j != null))
    {
      this.j.addView(paramView, paramLayoutParams);
      this.j.setVisibility(0);
    }
  }
  
  public final void a(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    if ((this.b != null) && (this.d)) {
      this.b.setOnEditorActionListener(paramOnEditorActionListener);
    }
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(b paramb)
  {
    this.e = paramb;
    if (this.b != null) {
      this.b.setOnClickListener(this);
    }
  }
  
  public final String b()
  {
    String str = null;
    if (this.b != null) {
      str = VdsAgent.trackEditTextSilent(this.b).toString();
    }
    return str;
  }
  
  public final void b(int paramInt)
  {
    if (this.b != null) {
      this.b.setSelection(paramInt);
    }
  }
  
  public final void b(String paramString)
  {
    if ((this.b != null) && (paramString != null)) {
      this.b.setHint(paramString);
    }
  }
  
  public final Editable c()
  {
    Editable localEditable = null;
    if (this.b != null) {
      localEditable = VdsAgent.trackEditTextSilent(this.b);
    }
    return localEditable;
  }
  
  public final void c(String paramString)
  {
    if ((this.b != null) && (paramString != null)) {
      this.b.setText(paramString);
    }
  }
  
  public final void d()
  {
    if (this.b != null) {
      this.b.setLongClickable(false);
    }
  }
  
  public final void e()
  {
    if (this.b == null) {}
    do
    {
      return;
      this.b.setText("");
    } while (this.e == null);
    this.e.e();
  }
  
  public final void f()
  {
    ((Activity)this.a).getWindow().setSoftInputMode(3);
    int n = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (n >= 16) {
      localObject = "setShowSoftInputOnFocus";
    }
    while (localObject == null)
    {
      this.b.setInputType(0);
      return;
      if (n >= 14) {
        localObject = "setSoftInputShownOnFocus";
      }
    }
    try
    {
      localObject = EditText.class.getMethod((String)localObject, new Class[] { Boolean.TYPE });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.b, new Object[] { Boolean.valueOf(false) });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      this.b.setInputType(0);
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.e != null) {
      this.e.a_();
    }
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (this.b != null) {
      this.b.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface b
    extends u.a
  {
    public abstract void a_();
    
    public abstract void e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */