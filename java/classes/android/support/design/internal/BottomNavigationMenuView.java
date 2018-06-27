package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.R.dimen;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.transition.ad;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class BottomNavigationMenuView
  extends ViewGroup
  implements o
{
  private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  private final int mActiveItemMaxWidth;
  private BottomNavigationItemView[] mButtons;
  private final int mInactiveItemMaxWidth;
  private final int mInactiveItemMinWidth;
  private int mItemBackgroundRes;
  private final int mItemHeight;
  private ColorStateList mItemIconTint;
  private final Pools.Pool<BottomNavigationItemView> mItemPool = new Pools.SynchronizedPool(5);
  private ColorStateList mItemTextColor;
  private h mMenu;
  private final View.OnClickListener mOnClickListener;
  private BottomNavigationPresenter mPresenter;
  private int mSelectedItemId = 0;
  private int mSelectedItemPosition = 0;
  private final TransitionSet mSet;
  private boolean mShiftingMode = true;
  private int[] mTempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.mInactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.mInactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.mActiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.mItemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.mSet = new AutoTransition();
    this.mSet.setOrdering(0);
    this.mSet.setDuration(115L);
    this.mSet.setInterpolator(new FastOutSlowInInterpolator());
    this.mSet.addTransition(new TextScale());
    this.mOnClickListener = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.this.mMenu.performItemAction(paramAnonymousView, BottomNavigationMenuView.this.mPresenter, 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.mTempChildWidths = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.mItemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public void buildMenuView()
  {
    removeAllViews();
    Object localObject1;
    int i;
    if (this.mButtons != null)
    {
      localObject1 = this.mButtons;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.mItemPool.release(localObject2);
        i += 1;
      }
    }
    if (this.mMenu.size() == 0)
    {
      this.mSelectedItemId = 0;
      this.mSelectedItemPosition = 0;
      this.mButtons = null;
      return;
    }
    this.mButtons = new BottomNavigationItemView[this.mMenu.size()];
    if (this.mMenu.size() > 3) {}
    for (boolean bool = true;; bool = false)
    {
      this.mShiftingMode = bool;
      i = 0;
      while (i < this.mMenu.size())
      {
        this.mPresenter.setUpdateSuspended(true);
        this.mMenu.getItem(i).setCheckable(true);
        this.mPresenter.setUpdateSuspended(false);
        localObject1 = getNewItem();
        this.mButtons[i] = localObject1;
        ((BottomNavigationItemView)localObject1).setIconTintList(this.mItemIconTint);
        ((BottomNavigationItemView)localObject1).setTextColor(this.mItemTextColor);
        ((BottomNavigationItemView)localObject1).setItemBackground(this.mItemBackgroundRes);
        ((BottomNavigationItemView)localObject1).setShiftingMode(this.mShiftingMode);
        ((BottomNavigationItemView)localObject1).initialize((j)this.mMenu.getItem(i), 0);
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.mOnClickListener);
        addView((View)localObject1);
        i += 1;
      }
    }
    this.mSelectedItemPosition = Math.min(this.mMenu.size() - 1, this.mSelectedItemPosition);
    this.mMenu.getItem(this.mSelectedItemPosition).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.mItemIconTint;
  }
  
  public int getItemBackgroundRes()
  {
    return this.mItemBackgroundRes;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.mItemTextColor;
  }
  
  public int getSelectedItemId()
  {
    return this.mSelectedItemId;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(h paramh)
  {
    this.mMenu = paramh;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    paramInt3 -= paramInt1;
    paramInt4 -= paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() == 8)
      {
        paramInt1 += 1;
      }
      else
      {
        if (ViewCompat.getLayoutDirection(this) == 1) {
          localView.layout(paramInt3 - paramInt2 - localView.getMeasuredWidth(), 0, paramInt3 - paramInt2, paramInt4);
        }
        for (;;)
        {
          paramInt2 += localView.getMeasuredWidth();
          break;
          localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, paramInt4);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int j = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
    int k;
    int m;
    Object localObject;
    int i;
    if (this.mShiftingMode)
    {
      paramInt1 = j - 1;
      k = Math.min(paramInt2 - this.mInactiveItemMinWidth * paramInt1, this.mActiveItemMaxWidth);
      m = Math.min((paramInt2 - k) / paramInt1, this.mInactiveItemMaxWidth);
      paramInt1 = paramInt2 - k - paramInt1 * m;
      paramInt2 = 0;
      if (paramInt2 >= j) {
        break label228;
      }
      localObject = this.mTempChildWidths;
      if (paramInt2 == this.mSelectedItemPosition)
      {
        i = k;
        label102:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label332;
        }
        localObject = this.mTempChildWidths;
        localObject[paramInt2] += 1;
        paramInt1 -= 1;
      }
    }
    label228:
    label332:
    for (;;)
    {
      paramInt2 += 1;
      break;
      i = m;
      break label102;
      if (j == 0) {}
      for (paramInt1 = 1;; paramInt1 = j)
      {
        k = Math.min(paramInt2 / paramInt1, this.mActiveItemMaxWidth);
        paramInt2 -= k * j;
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          this.mTempChildWidths[paramInt1] = k;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = this.mTempChildWidths;
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
          paramInt1 += 1;
          paramInt2 = i;
        }
      }
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt1 < j)
      {
        localObject = getChildAt(paramInt1);
        if (((View)localObject).getVisibility() == 8) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.mTempChildWidths[paramInt1], 1073741824), n);
          ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
          paramInt2 += ((View)localObject).getMeasuredWidth();
        }
      }
      setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.mItemHeight, n, 0));
      return;
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.mItemIconTint = paramColorStateList;
    if (this.mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.mItemBackgroundRes = paramInt;
    if (this.mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.mItemTextColor = paramColorStateList;
    if (this.mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.mPresenter = paramBottomNavigationPresenter;
  }
  
  void tryRestoreSelectedItemId(int paramInt)
  {
    int j = this.mMenu.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        MenuItem localMenuItem = this.mMenu.getItem(i);
        if (paramInt == localMenuItem.getItemId())
        {
          this.mSelectedItemId = paramInt;
          this.mSelectedItemPosition = i;
          localMenuItem.setChecked(true);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void updateMenuView()
  {
    int j = this.mMenu.size();
    if (j != this.mButtons.length) {
      buildMenuView();
    }
    for (;;)
    {
      return;
      int k = this.mSelectedItemId;
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = this.mMenu.getItem(i);
        if (localMenuItem.isChecked())
        {
          this.mSelectedItemId = localMenuItem.getItemId();
          this.mSelectedItemPosition = i;
        }
        i += 1;
      }
      if (k != this.mSelectedItemId) {
        ad.beginDelayedTransition(this, this.mSet);
      }
      i = 0;
      while (i < j)
      {
        this.mPresenter.setUpdateSuspended(true);
        this.mButtons[i].initialize((j)this.mMenu.getItem(i), 0);
        this.mPresenter.setUpdateSuspended(false);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/internal/BottomNavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */