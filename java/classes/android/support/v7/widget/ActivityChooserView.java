package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.r;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class ActivityChooserView
  extends ViewGroup
{
  final a a;
  final FrameLayout b;
  final FrameLayout c;
  ActionProvider d;
  final DataSetObserver e = new DataSetObserver()
  {
    public void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.a.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.a.notifyDataSetInvalidated();
    }
  };
  PopupWindow.OnDismissListener f;
  boolean g;
  int h = 4;
  private final b i;
  private final LinearLayoutCompat j;
  private final Drawable k;
  private final ImageView l;
  private final ImageView m;
  private final int n;
  private final ViewTreeObserver.OnGlobalLayoutListener o = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ActivityChooserView.this.isShowingPopup())
      {
        if (ActivityChooserView.this.isShown()) {
          break label31;
        }
        ActivityChooserView.this.getListPopupWindow().dismiss();
      }
      label31:
      do
      {
        return;
        ActivityChooserView.this.getListPopupWindow().show();
      } while (ActivityChooserView.this.d == null);
      ActivityChooserView.this.d.subUiVisibilityChanged(true);
    }
  };
  private ListPopupWindow p;
  private boolean q;
  private int r;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActivityChooserView, paramInt, 0);
    this.h = ((TypedArray)localObject).getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    this.i = new b();
    this.j = ((LinearLayoutCompat)findViewById(R.id.activity_chooser_view_content));
    this.k = this.j.getBackground();
    this.c = ((FrameLayout)findViewById(R.id.default_activity_button));
    this.c.setOnClickListener(this.i);
    this.c.setOnLongClickListener(this.i);
    this.m = ((ImageView)this.c.findViewById(R.id.image));
    localObject = (FrameLayout)findViewById(R.id.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.i);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(paramAnonymousAccessibilityNodeInfo).setCanOpenPopup(true);
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new z((View)localObject)
    {
      public r getPopup()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      protected boolean onForwardingStarted()
      {
        ActivityChooserView.this.showPopup();
        return true;
      }
      
      protected boolean onForwardingStopped()
      {
        ActivityChooserView.this.dismissPopup();
        return true;
      }
    });
    this.b = ((FrameLayout)localObject);
    this.l = ((ImageView)((FrameLayout)localObject).findViewById(R.id.image));
    this.l.setImageDrawable(paramAttributeSet);
    this.a = new a();
    this.a.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        ActivityChooserView.this.a();
      }
    });
    paramContext = paramContext.getResources();
    this.n = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  void a()
  {
    if (this.a.getCount() > 0)
    {
      this.b.setEnabled(true);
      int i1 = this.a.getActivityCount();
      int i2 = this.a.getHistorySize();
      if ((i1 != 1) && ((i1 <= 1) || (i2 <= 0))) {
        break label161;
      }
      this.c.setVisibility(0);
      Object localObject = this.a.getDefaultActivity();
      PackageManager localPackageManager = getContext().getPackageManager();
      this.m.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (this.r != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = getContext().getString(this.r, new Object[] { localObject });
        this.c.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (this.c.getVisibility() != 0) {
        break label173;
      }
      this.j.setBackgroundDrawable(this.k);
      return;
      this.b.setEnabled(false);
      break;
      label161:
      this.c.setVisibility(8);
    }
    label173:
    this.j.setBackgroundDrawable(null);
  }
  
  void a(int paramInt)
  {
    if (this.a.getDataModel() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.o);
    boolean bool;
    int i1;
    label60:
    label92:
    ListPopupWindow localListPopupWindow;
    if (this.c.getVisibility() == 0)
    {
      bool = true;
      int i2 = this.a.getActivityCount();
      if (!bool) {
        break label208;
      }
      i1 = 1;
      if ((paramInt == Integer.MAX_VALUE) || (i2 <= i1 + paramInt)) {
        break label213;
      }
      this.a.setShowFooterView(true);
      this.a.setMaxActivityCount(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.isShowing())
      {
        if ((!this.g) && (bool)) {
          break label232;
        }
        this.a.setShowDefaultActivity(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.a.measureContentWidth(), this.n));
      localListPopupWindow.show();
      if (this.d != null) {
        this.d.subUiVisibilityChanged(true);
      }
      localListPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
      localListPopupWindow.getListView().setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label208:
      i1 = 0;
      break label60;
      label213:
      this.a.setShowFooterView(false);
      this.a.setMaxActivityCount(paramInt);
      break label92;
      label232:
      this.a.setShowDefaultActivity(false, false);
    }
  }
  
  public boolean dismissPopup()
  {
    if (isShowingPopup())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.o);
      }
    }
    return true;
  }
  
  public c getDataModel()
  {
    return this.a.getDataModel();
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.p == null)
    {
      this.p = new ListPopupWindow(getContext());
      this.p.setAdapter(this.a);
      this.p.setAnchorView(this);
      this.p.setModal(true);
      this.p.setOnItemClickListener(this.i);
      this.p.setOnDismissListener(this.i);
    }
    return this.p;
  }
  
  public boolean isShowingPopup()
  {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.a.getDataModel();
    if (localc != null) {
      localc.registerObserver(this.e);
    }
    this.q = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.a.getDataModel();
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.e);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.o);
    }
    if (isShowingPopup()) {
      dismissPopup();
    }
    this.q = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup()) {
      dismissPopup();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayoutCompat localLinearLayoutCompat = this.j;
    int i1 = paramInt2;
    if (this.c.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayoutCompat, paramInt1, i1);
    setMeasuredDimension(localLinearLayoutCompat.getMeasuredWidth(), localLinearLayoutCompat.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    this.a.setDataModel(paramc);
    if (isShowingPopup())
    {
      dismissPopup();
      showPopup();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.l.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.l.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.f = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.d = paramActionProvider;
  }
  
  public boolean showPopup()
  {
    if ((isShowingPopup()) || (!this.q)) {
      return false;
    }
    this.g = false;
    a(this.h);
    return true;
  }
  
  public static class InnerLayout
    extends LinearLayoutCompat
  {
    private static final int[] a = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = at.obtainStyledAttributes(paramContext, paramAttributeSet, a);
      setBackgroundDrawable(paramContext.getDrawable(0));
      paramContext.recycle();
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private c b;
    private int c = 4;
    private boolean d;
    private boolean e;
    private boolean f;
    
    a() {}
    
    public int getActivityCount()
    {
      return this.b.getActivityCount();
    }
    
    public int getCount()
    {
      int j = this.b.getActivityCount();
      int i = j;
      if (!this.d)
      {
        i = j;
        if (this.b.getDefaultActivity() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.c);
      i = j;
      if (this.f) {
        i = j + 1;
      }
      return i;
    }
    
    public c getDataModel()
    {
      return this.b;
    }
    
    public ResolveInfo getDefaultActivity()
    {
      return this.b.getDefaultActivity();
    }
    
    public int getHistorySize()
    {
      return this.b.getHistorySize();
    }
    
    public Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!this.d)
      {
        i = paramInt;
        if (this.b.getDefaultActivity() != null) {
          i = paramInt + 1;
        }
      }
      return this.b.getActivity(i);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.f) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public boolean getShowDefaultActivity()
    {
      return this.d;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == R.id.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(R.id.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.d) && (paramInt == 0) && (this.e))
      {
        localView.setActivated(true);
        return localView;
      }
      localView.setActivated(false);
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public int measureContentWidth()
    {
      int i = 0;
      int k = this.c;
      this.c = Integer.MAX_VALUE;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      View localView = null;
      int j = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      this.c = k;
      return j;
    }
    
    public void setDataModel(c paramc)
    {
      c localc = ActivityChooserView.this.a.getDataModel();
      if ((localc != null) && (ActivityChooserView.this.isShown())) {
        localc.unregisterObserver(ActivityChooserView.this.e);
      }
      this.b = paramc;
      if ((paramc != null) && (ActivityChooserView.this.isShown())) {
        paramc.registerObserver(ActivityChooserView.this.e);
      }
      notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(int paramInt)
    {
      if (this.c != paramInt)
      {
        this.c = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.d != paramBoolean1) || (this.e != paramBoolean2))
      {
        this.d = paramBoolean1;
        this.e = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public void setShowFooterView(boolean paramBoolean)
    {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        notifyDataSetChanged();
      }
    }
  }
  
  private class b
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    b() {}
    
    private void a()
    {
      if (ActivityChooserView.this.f != null) {
        ActivityChooserView.this.f.onDismiss();
      }
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      if (paramView == ActivityChooserView.this.c)
      {
        ActivityChooserView.this.dismissPopup();
        paramView = ActivityChooserView.this.a.getDefaultActivity();
        int i = ActivityChooserView.this.a.getDataModel().getActivityIndex(paramView);
        paramView = ActivityChooserView.this.a.getDataModel().chooseActivity(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          ActivityChooserView.this.getContext().startActivity(paramView);
        }
        return;
      }
      if (paramView == ActivityChooserView.this.b)
      {
        ActivityChooserView.this.g = false;
        ActivityChooserView.this.a(ActivityChooserView.this.h);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public void onDismiss()
    {
      a();
      if (ActivityChooserView.this.d != null) {
        ActivityChooserView.this.d.subUiVisibilityChanged(false);
      }
    }
    
    @Instrumented
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
      switch (((ActivityChooserView.a)paramAdapterView.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.this.a(Integer.MAX_VALUE);
      }
      do
      {
        return;
        ActivityChooserView.this.dismissPopup();
        if (!ActivityChooserView.this.g) {
          break;
        }
      } while (paramInt <= 0);
      ActivityChooserView.this.a.getDataModel().setDefaultActivity(paramInt);
      return;
      if (ActivityChooserView.this.a.getShowDefaultActivity()) {}
      for (;;)
      {
        paramAdapterView = ActivityChooserView.this.a.getDataModel().chooseActivity(paramInt);
        if (paramAdapterView == null) {
          break;
        }
        paramAdapterView.addFlags(524288);
        ActivityChooserView.this.getContext().startActivity(paramAdapterView);
        return;
        paramInt += 1;
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.c)
      {
        if (ActivityChooserView.this.a.getCount() > 0)
        {
          ActivityChooserView.this.g = true;
          ActivityChooserView.this.a(ActivityChooserView.this.h);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */