package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.appcompat.R.attr;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class c
  extends k
  implements DialogInterface
{
  final AlertController a = new AlertController(getContext(), this, getWindow());
  
  protected c(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) >= 1) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public Button getButton(int paramInt)
  {
    return this.a.getButton(paramInt);
  }
  
  public ListView getListView()
  {
    return this.a.getListView();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.installContent();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.setButton(paramInt, paramCharSequence, paramOnClickListener, null);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, Message paramMessage)
  {
    this.a.setButton(paramInt, paramCharSequence, null, paramMessage);
  }
  
  public void setCustomTitle(View paramView)
  {
    this.a.setCustomTitle(paramView);
  }
  
  public void setIcon(int paramInt)
  {
    this.a.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.a.setIcon(paramDrawable);
  }
  
  public void setIconAttribute(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(paramInt, localTypedValue, true);
    this.a.setIcon(localTypedValue.resourceId);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.a.setMessage(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.setTitle(paramCharSequence);
  }
  
  public void setView(View paramView)
  {
    this.a.setView(paramView);
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.setView(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static class a
  {
    private final AlertController.a a;
    private final int b;
    
    public a(Context paramContext)
    {
      this(paramContext, c.a(paramContext, 0));
    }
    
    public a(Context paramContext, int paramInt)
    {
      this.a = new AlertController.a(new ContextThemeWrapper(paramContext, c.a(paramContext, paramInt)));
      this.b = paramInt;
    }
    
    public c create()
    {
      c localc = new c(this.a.a, this.b);
      this.a.apply(localc.a);
      localc.setCancelable(this.a.o);
      if (this.a.o) {
        localc.setCanceledOnTouchOutside(true);
      }
      localc.setOnCancelListener(this.a.p);
      localc.setOnDismissListener(this.a.q);
      if (this.a.r != null) {
        localc.setOnKeyListener(this.a.r);
      }
      return localc;
    }
    
    public Context getContext()
    {
      return this.a.a;
    }
    
    public a setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.t = paramListAdapter;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a setCancelable(boolean paramBoolean)
    {
      this.a.o = paramBoolean;
      return this;
    }
    
    public a setCursor(Cursor paramCursor, DialogInterface.OnClickListener paramOnClickListener, String paramString)
    {
      this.a.H = paramCursor;
      this.a.I = paramString;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a setCustomTitle(View paramView)
    {
      this.a.g = paramView;
      return this;
    }
    
    public a setIcon(int paramInt)
    {
      this.a.c = paramInt;
      return this;
    }
    
    public a setIcon(Drawable paramDrawable)
    {
      this.a.d = paramDrawable;
      return this;
    }
    
    public a setIconAttribute(int paramInt)
    {
      TypedValue localTypedValue = new TypedValue();
      this.a.a.getTheme().resolveAttribute(paramInt, localTypedValue, true);
      this.a.c = localTypedValue.resourceId;
      return this;
    }
    
    @Deprecated
    public a setInverseBackgroundForced(boolean paramBoolean)
    {
      this.a.K = paramBoolean;
      return this;
    }
    
    public a setItems(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.s = this.a.a.getResources().getTextArray(paramInt);
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a setItems(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.s = paramArrayOfCharSequence;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a setMessage(int paramInt)
    {
      this.a.h = this.a.a.getText(paramInt);
      return this;
    }
    
    public a setMessage(CharSequence paramCharSequence)
    {
      this.a.h = paramCharSequence;
      return this;
    }
    
    public a setMultiChoiceItems(int paramInt, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.a.s = this.a.a.getResources().getTextArray(paramInt);
      this.a.G = paramOnMultiChoiceClickListener;
      this.a.C = paramArrayOfBoolean;
      this.a.D = true;
      return this;
    }
    
    public a setMultiChoiceItems(Cursor paramCursor, String paramString1, String paramString2, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.a.H = paramCursor;
      this.a.G = paramOnMultiChoiceClickListener;
      this.a.J = paramString1;
      this.a.I = paramString2;
      this.a.D = true;
      return this;
    }
    
    public a setMultiChoiceItems(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.a.s = paramArrayOfCharSequence;
      this.a.G = paramOnMultiChoiceClickListener;
      this.a.C = paramArrayOfBoolean;
      this.a.D = true;
      return this;
    }
    
    public a setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.k = this.a.a.getText(paramInt);
      this.a.l = paramOnClickListener;
      return this;
    }
    
    public a setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.k = paramCharSequence;
      this.a.l = paramOnClickListener;
      return this;
    }
    
    public a setNeutralButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.m = this.a.a.getText(paramInt);
      this.a.n = paramOnClickListener;
      return this;
    }
    
    public a setNeutralButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.m = paramCharSequence;
      this.a.n = paramOnClickListener;
      return this;
    }
    
    public a setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.a.p = paramOnCancelListener;
      return this;
    }
    
    public a setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.a.q = paramOnDismissListener;
      return this;
    }
    
    public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
    {
      this.a.L = paramOnItemSelectedListener;
      return this;
    }
    
    public a setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      this.a.r = paramOnKeyListener;
      return this;
    }
    
    public a setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.i = this.a.a.getText(paramInt);
      this.a.j = paramOnClickListener;
      return this;
    }
    
    public a setPositiveButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.i = paramCharSequence;
      this.a.j = paramOnClickListener;
      return this;
    }
    
    public a setRecycleOnMeasureEnabled(boolean paramBoolean)
    {
      this.a.N = paramBoolean;
      return this;
    }
    
    public a setSingleChoiceItems(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.s = this.a.a.getResources().getTextArray(paramInt1);
      this.a.u = paramOnClickListener;
      this.a.F = paramInt2;
      this.a.E = true;
      return this;
    }
    
    public a setSingleChoiceItems(Cursor paramCursor, int paramInt, String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.H = paramCursor;
      this.a.u = paramOnClickListener;
      this.a.F = paramInt;
      this.a.I = paramString;
      this.a.E = true;
      return this;
    }
    
    public a setSingleChoiceItems(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.t = paramListAdapter;
      this.a.u = paramOnClickListener;
      this.a.F = paramInt;
      this.a.E = true;
      return this;
    }
    
    public a setSingleChoiceItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.s = paramArrayOfCharSequence;
      this.a.u = paramOnClickListener;
      this.a.F = paramInt;
      this.a.E = true;
      return this;
    }
    
    public a setTitle(int paramInt)
    {
      this.a.f = this.a.a.getText(paramInt);
      return this;
    }
    
    public a setTitle(CharSequence paramCharSequence)
    {
      this.a.f = paramCharSequence;
      return this;
    }
    
    public a setView(int paramInt)
    {
      this.a.w = null;
      this.a.v = paramInt;
      this.a.B = false;
      return this;
    }
    
    public a setView(View paramView)
    {
      this.a.w = paramView;
      this.a.v = 0;
      this.a.B = false;
      return this;
    }
    
    @Deprecated
    public a setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a.w = paramView;
      this.a.v = 0;
      this.a.B = true;
      this.a.x = paramInt1;
      this.a.y = paramInt2;
      this.a.z = paramInt3;
      this.a.A = paramInt4;
      return this;
    }
    
    public c show()
    {
      c localc = create();
      localc.show();
      return localc;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */