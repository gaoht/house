package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.r;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements r
{
  private static Method a;
  private static Method b;
  private static Method h;
  private Drawable A;
  private AdapterView.OnItemClickListener B;
  private AdapterView.OnItemSelectedListener C;
  private final d D = new d();
  private final c E = new c();
  private final a F = new a();
  private Runnable G;
  private final Rect H = new Rect();
  private Rect I;
  private boolean J;
  DropDownListView c;
  int d = Integer.MAX_VALUE;
  final e e = new e();
  final Handler f;
  PopupWindow g;
  private Context i;
  private ListAdapter j;
  private int k = -2;
  private int l = -2;
  private int m;
  private int n;
  private int o = 1002;
  private boolean p;
  private boolean q = true;
  private boolean r;
  private boolean s;
  private int t = 0;
  private boolean u = false;
  private boolean v = false;
  private View w;
  private int x = 0;
  private DataSetObserver y;
  private View z;
  
  static
  {
    try
    {
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          try
          {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
          }
          localNoSuchMethodException1 = localNoSuchMethodException1;
          Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
      }
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.i = paramContext;
    this.f = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.m = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.n = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.n != 0) {
      this.p = true;
    }
    localTypedArray.recycle();
    this.g = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.g.setInputMethodMode(1);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (b != null) {
      try
      {
        int i1 = ((Integer)b.invoke(this.g, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i1;
      }
      catch (Exception localException)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    }
    return this.g.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void a()
  {
    if (this.w != null)
    {
      ViewParent localViewParent = this.w.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.w);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (a != null) {}
    try
    {
      a.invoke(this.g, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 66) || (paramInt == 23);
  }
  
  private int b()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label253:
    int i2;
    int i1;
    if (this.c == null)
    {
      localObject2 = this.i;
      this.G = new Runnable()
      {
        public void run()
        {
          View localView = ListPopupWindow.this.getAnchorView();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.J)
      {
        bool1 = true;
        this.c = a((Context)localObject2, bool1);
        if (this.A != null) {
          this.c.setSelector(this.A);
        }
        this.c.setAdapter(this.j);
        this.c.setOnItemClickListener(this.B);
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          @Instrumented
          public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemSelected(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.c;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.c.setOnScrollListener(this.E);
        if (this.C != null) {
          this.c.setOnItemSelectedListener(this.C);
        }
        localObject1 = this.c;
        localView = this.w;
        if (localView == null) {
          break label734;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.x)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.x);
          if (this.l >= 0)
          {
            i2 = this.l;
            i1 = Integer.MIN_VALUE;
            label269:
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i1 = localView.getMeasuredHeight();
            i2 = ((LinearLayout.LayoutParams)localObject1).topMargin;
            i1 = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i1 + i2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.g.setContentView((View)localObject1);
      for (;;)
      {
        label325:
        localObject1 = this.g.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.H);
          i2 = this.H.top + this.H.bottom;
          if (this.p) {
            break label726;
          }
          this.n = (-this.H.top);
        }
        label384:
        label562:
        label726:
        for (;;)
        {
          if (this.g.getInputMethodMode() == 2) {}
          int i4;
          for (bool1 = bool2;; bool1 = false)
          {
            i4 = a(getAnchorView(), this.n, bool1);
            if ((!this.u) && (this.k != -1)) {
              break label562;
            }
            return i4 + i2;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label253;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label253;
            i1 = 0;
            i2 = 0;
            break label269;
            localObject1 = (ViewGroup)this.g.getContentView();
            localObject1 = this.w;
            if (localObject1 == null) {
              break label729;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i1 = ((View)localObject1).getMeasuredHeight();
            i2 = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i1 = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i1 + i2);
            break label325;
            this.H.setEmpty();
            i2 = 0;
            break label384;
          }
          int i3;
          switch (this.l)
          {
          default: 
            i3 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
          }
          for (;;)
          {
            i4 = this.c.measureHeightOfChildrenCompat(i3, 0, -1, i4 - i1, -1);
            i3 = i1;
            if (i4 > 0) {
              i3 = i1 + (this.c.getPaddingTop() + this.c.getPaddingBottom() + i2);
            }
            return i4 + i3;
            i3 = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
            continue;
            i3 = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
          }
        }
        label729:
        i1 = 0;
      }
      label734:
      i1 = 0;
    }
  }
  
  DropDownListView a(Context paramContext, boolean paramBoolean)
  {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = this.c;
    if (localDropDownListView != null)
    {
      localDropDownListView.setListSelectionHidden(true);
      localDropDownListView.requestLayout();
    }
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView)
  {
    new z(paramView)
    {
      public ListPopupWindow getPopup()
      {
        return ListPopupWindow.this;
      }
    };
  }
  
  public void dismiss()
  {
    this.g.dismiss();
    a();
    this.g.setContentView(null);
    this.c = null;
    this.f.removeCallbacks(this.e);
  }
  
  public View getAnchorView()
  {
    return this.z;
  }
  
  public int getAnimationStyle()
  {
    return this.g.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return this.g.getBackground();
  }
  
  public int getHeight()
  {
    return this.k;
  }
  
  public int getHorizontalOffset()
  {
    return this.m;
  }
  
  public int getInputMethodMode()
  {
    return this.g.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return this.c;
  }
  
  public int getPromptPosition()
  {
    return this.x;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return this.c.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return this.c.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return this.c.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return this.c.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return this.g.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.p) {
      return 0;
    }
    return this.n;
  }
  
  public int getWidth()
  {
    return this.l;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return this.u;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return this.g.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return this.J;
  }
  
  public boolean isShowing()
  {
    return this.g.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i4;
    int i3;
    int i1;
    int i2;
    if ((isShowing()) && (paramInt != 62) && ((this.c.getSelectedItemPosition() >= 0) || (!a(paramInt))))
    {
      i4 = this.c.getSelectedItemPosition();
      ListAdapter localListAdapter;
      if (!this.g.isAboveAnchor())
      {
        i3 = 1;
        localListAdapter = this.j;
        i1 = Integer.MAX_VALUE;
        i2 = Integer.MIN_VALUE;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label162;
          }
          i1 = 0;
          label87:
          if (!bool) {
            break label175;
          }
        }
      }
      label162:
      label175:
      for (i2 = localListAdapter.getCount() - 1;; i2 = this.c.lookForSelectablePosition(localListAdapter.getCount() - 1, false))
      {
        if (((i3 == 0) || (paramInt != 19) || (i4 > i1)) && ((i3 != 0) || (paramInt != 20) || (i4 < i2))) {
          break label197;
        }
        clearListSelection();
        this.g.setInputMethodMode(1);
        show();
        return true;
        i3 = 0;
        break;
        i1 = this.c.lookForSelectablePosition(0, true);
        break label87;
      }
      label197:
      this.c.setListSelectionHidden(false);
      if (!this.c.onKeyDown(paramInt, paramKeyEvent)) {
        break label282;
      }
      this.g.setInputMethodMode(2);
      this.c.requestFocusFromTouch();
      show();
      switch (paramInt)
      {
      }
    }
    label282:
    do
    {
      do
      {
        return false;
        if ((i3 == 0) || (paramInt != 20)) {
          break;
        }
      } while (i4 != i2);
      return true;
    } while ((i3 != 0) || (paramInt != 19) || (i4 != i1));
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (isShowing()))
    {
      Object localObject = this.z;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (this.c.getSelectedItemPosition() >= 0))
    {
      boolean bool = this.c.onKeyUp(paramInt, paramKeyEvent);
      if ((bool) && (a(paramInt))) {
        dismiss();
      }
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (this.B != null)
      {
        DropDownListView localDropDownListView = this.c;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.B.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    this.f.post(this.G);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.y == null) {
      this.y = new b();
    }
    for (;;)
    {
      this.j = paramListAdapter;
      if (this.j != null) {
        paramListAdapter.registerDataSetObserver(this.y);
      }
      if (this.c != null) {
        this.c.setAdapter(this.j);
      }
      return;
      if (this.j != null) {
        this.j.unregisterDataSetObserver(this.y);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.z = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.g.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.g.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.g.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.H);
      this.l = (this.H.left + this.H.right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setEpicenterBounds(Rect paramRect)
  {
    this.I = paramRect;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.k = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.g.setInputMethodMode(paramInt);
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.A = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.J = paramBoolean;
    this.g.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.g.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.B = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.C = paramOnItemSelectedListener;
  }
  
  public void setOverlapAnchor(boolean paramBoolean)
  {
    this.s = true;
    this.r = paramBoolean;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      a();
    }
    this.w = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = this.c;
    if ((isShowing()) && (localDropDownListView != null))
    {
      localDropDownListView.setListSelectionHidden(false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.g.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.n = paramInt;
    this.p = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i4 = -1;
    int i1 = b();
    boolean bool3 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.g, this.o);
    if (this.g.isShowing()) {
      if (ViewCompat.isAttachedToWindow(getAnchorView())) {}
    }
    for (;;)
    {
      return;
      int i2;
      label75:
      PopupWindow localPopupWindow;
      int i3;
      label96:
      label110:
      View localView;
      int i5;
      int i6;
      if (this.l == -1)
      {
        i2 = -1;
        if (this.k != -1) {
          break label277;
        }
        if (!bool3) {
          break label229;
        }
        if (!bool3) {
          break label239;
        }
        localPopupWindow = this.g;
        if (this.l != -1) {
          break label234;
        }
        i3 = -1;
        localPopupWindow.setWidth(i3);
        this.g.setHeight(0);
        localPopupWindow = this.g;
        bool1 = bool2;
        if (!this.v)
        {
          bool1 = bool2;
          if (!this.u) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        localPopupWindow = this.g;
        localView = getAnchorView();
        i5 = this.m;
        i6 = this.n;
        i3 = i2;
        if (i2 < 0) {
          i3 = -1;
        }
        if (i1 >= 0) {
          break label297;
        }
        i1 = i4;
      }
      label229:
      label234:
      label239:
      label277:
      label297:
      for (;;)
      {
        localPopupWindow.update(localView, i5, i6, i3, i1);
        return;
        if (this.l == -2)
        {
          i2 = getAnchorView().getWidth();
          break;
        }
        i2 = this.l;
        break;
        i1 = -1;
        break label75;
        i3 = 0;
        break label96;
        localPopupWindow = this.g;
        if (this.l == -1) {}
        for (i3 = -1;; i3 = 0)
        {
          localPopupWindow.setWidth(i3);
          this.g.setHeight(-1);
          break;
        }
        if (this.k == -2) {
          break label110;
        }
        i1 = this.k;
        break label110;
      }
      if (this.l == -1)
      {
        i2 = -1;
        label310:
        if (this.k != -1) {
          break label525;
        }
        i1 = -1;
        label320:
        this.g.setWidth(i2);
        this.g.setHeight(i1);
        a(true);
        localPopupWindow = this.g;
        if ((this.v) || (this.u)) {
          break label542;
        }
        localPopupWindow.setOutsideTouchable(bool1);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
          PopupWindowCompat.setOverlapAnchor(this.g, this.r);
        }
        if (h == null) {}
      }
      try
      {
        h.invoke(this.g, new Object[] { this.I });
        PopupWindowCompat.showAsDropDown(this.g, getAnchorView(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if ((!this.J) || (this.c.isInTouchMode())) {
          clearListSelection();
        }
        if (this.J) {
          continue;
        }
        this.f.post(this.F);
        return;
        if (this.l == -2)
        {
          i2 = getAnchorView().getWidth();
          break label310;
        }
        i2 = this.l;
        break label310;
        label525:
        if (this.k == -2) {
          break label320;
        }
        i1 = this.k;
        break label320;
        label542:
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException);
        }
      }
    }
  }
  
  private class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private class b
    extends DataSetObserver
  {
    b() {}
    
    public void onChanged()
    {
      if (ListPopupWindow.this.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.g.getContentView() != null))
      {
        ListPopupWindow.this.f.removeCallbacks(ListPopupWindow.this.e);
        ListPopupWindow.this.e.run();
      }
    }
  }
  
  private class d
    implements View.OnTouchListener
  {
    d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.g != null) && (ListPopupWindow.this.g.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.g.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.g.getHeight())) {
        ListPopupWindow.this.f.postDelayed(ListPopupWindow.this.e, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.f.removeCallbacks(ListPopupWindow.this.e);
        }
      }
    }
  }
  
  private class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      if ((ListPopupWindow.this.c != null) && (ViewCompat.isAttachedToWindow(ListPopupWindow.this.c)) && (ListPopupWindow.this.c.getCount() > ListPopupWindow.this.c.getChildCount()) && (ListPopupWindow.this.c.getChildCount() <= ListPopupWindow.this.d))
      {
        ListPopupWindow.this.g.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */