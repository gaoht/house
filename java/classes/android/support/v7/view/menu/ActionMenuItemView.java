package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.ActionMenuView.a;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.av;
import android.support.v7.widget.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class ActionMenuItemView
  extends AppCompatTextView
  implements o.a, ActionMenuView.a, View.OnClickListener
{
  j a;
  h.b b;
  b c;
  private CharSequence d;
  private Drawable e;
  private z f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.g = a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.i = paramContext.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.k = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.j = -1;
    setSaveEnabled(false);
  }
  
  private boolean a()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int m = localConfiguration.screenWidthDp;
    int n = localConfiguration.screenHeightDp;
    return (m >= 480) || ((m >= 640) && (n >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void b()
  {
    int i1 = 0;
    Object localObject2 = null;
    int m;
    if (!TextUtils.isEmpty(this.d))
    {
      m = 1;
      if (this.e != null)
      {
        n = i1;
        if (!this.a.showsTextAsAction()) {
          break label54;
        }
        if (!this.g)
        {
          n = i1;
          if (!this.h) {
            break label54;
          }
        }
      }
      int n = 1;
      label54:
      m &= n;
      if (m == 0) {
        break label141;
      }
      localObject1 = this.d;
      label68:
      setText((CharSequence)localObject1);
      localObject1 = this.a.getContentDescription();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label159;
      }
      if (m == 0) {
        break label147;
      }
      localObject1 = null;
      label98:
      setContentDescription((CharSequence)localObject1);
      label104:
      localObject1 = this.a.getTooltipText();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label180;
      }
      if (m == 0) {
        break label168;
      }
    }
    label141:
    label147:
    label159:
    label168:
    for (Object localObject1 = localObject2;; localObject1 = this.a.getTitle())
    {
      av.setTooltipText(this, (CharSequence)localObject1);
      return;
      m = 0;
      break;
      localObject1 = null;
      break label68;
      localObject1 = this.a.getTitle();
      break label98;
      setContentDescription((CharSequence)localObject1);
      break label104;
    }
    label180:
    av.setTooltipText(this, (CharSequence)localObject1);
  }
  
  public j getItemData()
  {
    return this.a;
  }
  
  public boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void initialize(j paramj, int paramInt)
  {
    this.a = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.f == null)) {
        this.f = new a();
      }
      return;
    }
  }
  
  public boolean needsDividerAfter()
  {
    return hasText();
  }
  
  public boolean needsDividerBefore()
  {
    return (hasText()) && (this.a.getIcon() == null);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.b != null) {
      this.b.invokeItem(this.a);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.g = a();
    b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.j >= 0)) {
      super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == Integer.MIN_VALUE) {}
    for (paramInt1 = Math.min(paramInt1, this.i);; paramInt1 = this.i)
    {
      if ((m != 1073741824) && (this.i > 0) && (n < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.e != null)) {
        super.setPadding((getMeasuredWidth() - this.e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a.hasSubMenu()) && (this.f != null) && (this.f.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean prefersCondensedTitle()
  {
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      if (this.a != null) {
        this.a.actionFormatChanged();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    if (paramDrawable != null)
    {
      int i2 = paramDrawable.getIntrinsicWidth();
      int i1 = paramDrawable.getIntrinsicHeight();
      int n = i1;
      int m = i2;
      float f1;
      if (i2 > this.k)
      {
        f1 = this.k / i2;
        m = this.k;
        n = (int)(i1 * f1);
      }
      i2 = n;
      i1 = m;
      if (n > this.k)
      {
        f1 = this.k / n;
        i2 = this.k;
        i1 = (int)(m * f1);
      }
      paramDrawable.setBounds(0, 0, i1, i2);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    b();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.b = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.c = paramb;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    b();
  }
  
  public boolean showsIcon()
  {
    return true;
  }
  
  private class a
    extends z
  {
    public a()
    {
      super();
    }
    
    public r getPopup()
    {
      if (ActionMenuItemView.this.c != null) {
        return ActionMenuItemView.this.c.getPopup();
      }
      return null;
    }
    
    protected boolean onForwardingStarted()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.b != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.b.invokeItem(ActionMenuItemView.this.a))
        {
          r localr = getPopup();
          bool1 = bool2;
          if (localr != null)
          {
            bool1 = bool2;
            if (localr.isShowing()) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public static abstract class b
  {
    public abstract r getPopup();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */