package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;

class AlertController
{
  private boolean A = false;
  private CharSequence B;
  private CharSequence C;
  private CharSequence D;
  private int E = 0;
  private Drawable F;
  private ImageView G;
  private TextView H;
  private TextView I;
  private View J;
  private int K;
  private int L;
  private boolean M;
  private int N = 0;
  private final View.OnClickListener O = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if ((paramAnonymousView == AlertController.this.c) && (AlertController.this.d != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.d);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.p.obtainMessage(1, AlertController.this.a).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.e) && (AlertController.this.f != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.f);
        } else if ((paramAnonymousView == AlertController.this.g) && (AlertController.this.h != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.h);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final k a;
  ListView b;
  Button c;
  Message d;
  Button e;
  Message f;
  Button g;
  Message h;
  NestedScrollView i;
  ListAdapter j;
  int k = -1;
  int l;
  int m;
  int n;
  int o;
  Handler p;
  private final Context q;
  private final Window r;
  private CharSequence s;
  private CharSequence t;
  private View u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public AlertController(Context paramContext, k paramk, Window paramWindow)
  {
    this.q = paramContext;
    this.a = paramk;
    this.r = paramWindow;
    this.p = new b(paramk);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.K = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    this.L = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    this.l = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    this.m = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    this.n = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    this.o = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    this.M = paramContext.getBoolean(R.styleable.AlertDialog_showTitle, true);
    paramContext.recycle();
    paramk.supportRequestWindowFeature(1);
  }
  
  private int a()
  {
    if (this.L == 0) {
      return this.K;
    }
    if (this.N == 1) {
      return this.L;
    }
    return this.K;
  }
  
  private ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int i2 = 0;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1))
      {
        i1 = 0;
        paramView2.setVisibility(i1);
      }
    }
    else if (paramView3 != null) {
      if (!paramView1.canScrollVertically(1)) {
        break label48;
      }
    }
    label48:
    for (int i1 = i2;; i1 = 4)
    {
      paramView3.setVisibility(i1);
      return;
      i1 = 4;
      break;
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i1 = 0;
    View localView;
    if (this.u != null) {
      localView = this.u;
    }
    for (;;)
    {
      if (localView != null) {
        i1 = 1;
      }
      if ((i1 == 0) || (!a(localView))) {
        this.r.setFlags(131072, 131072);
      }
      if (i1 == 0) {
        break;
      }
      FrameLayout localFrameLayout = (FrameLayout)this.r.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.A) {
        localFrameLayout.setPadding(this.w, this.x, this.y, this.z);
      }
      if (this.b != null) {
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).g = 0.0F;
      }
      return;
      if (this.v != 0) {
        localView = LayoutInflater.from(this.q).inflate(this.v, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void a(ViewGroup paramViewGroup, final View paramView, int paramInt1, int paramInt2)
  {
    final Object localObject = null;
    View localView2 = this.r.findViewById(R.id.scrollIndicatorUp);
    View localView1 = this.r.findViewById(R.id.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23)
    {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (localView2 != null) {
        paramViewGroup.removeView(localView2);
      }
      if (localView1 != null) {
        paramViewGroup.removeView(localView1);
      }
    }
    label232:
    for (;;)
    {
      return;
      paramView = localView2;
      if (localView2 != null)
      {
        paramView = localView2;
        if ((paramInt1 & 0x1) == 0)
        {
          paramViewGroup.removeView(localView2);
          paramView = null;
        }
      }
      if ((localView1 != null) && ((paramInt1 & 0x2) == 0)) {
        paramViewGroup.removeView(localView1);
      }
      for (;;)
      {
        if ((paramView == null) && (localObject == null)) {
          break label232;
        }
        if (this.t != null)
        {
          this.i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener()
          {
            public void onScrollChange(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              AlertController.a(paramAnonymousNestedScrollView, paramView, localObject);
            }
          });
          this.i.post(new Runnable()
          {
            public void run()
            {
              AlertController.a(AlertController.this.i, paramView, localObject);
            }
          });
          return;
        }
        if (this.b != null)
        {
          this.b.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AlertController.a(paramAnonymousAbsListView, paramView, localObject);
            }
            
            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
          });
          this.b.post(new Runnable()
          {
            public void run()
            {
              AlertController.a(AlertController.this.b, paramView, localObject);
            }
          });
          return;
        }
        if (paramView != null) {
          paramViewGroup.removeView(paramView);
        }
        if (localObject == null) {
          break;
        }
        paramViewGroup.removeView((View)localObject);
        return;
        localObject = localView1;
      }
    }
  }
  
  private void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  private static boolean a(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, localTypedValue, true);
    return localTypedValue.data != 0;
  }
  
  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    Object localObject4 = this.r.findViewById(R.id.parentPanel);
    Object localObject3 = ((View)localObject4).findViewById(R.id.topPanel);
    Object localObject2 = ((View)localObject4).findViewById(R.id.contentPanel);
    Object localObject1 = ((View)localObject4).findViewById(R.id.buttonPanel);
    localObject4 = (ViewGroup)((View)localObject4).findViewById(R.id.customPanel);
    a((ViewGroup)localObject4);
    View localView3 = ((ViewGroup)localObject4).findViewById(R.id.topPanel);
    View localView2 = ((ViewGroup)localObject4).findViewById(R.id.contentPanel);
    View localView1 = ((ViewGroup)localObject4).findViewById(R.id.buttonPanel);
    localObject3 = a(localView3, (View)localObject3);
    localObject2 = a(localView2, (View)localObject2);
    localObject1 = a(localView1, (View)localObject1);
    c((ViewGroup)localObject2);
    d((ViewGroup)localObject1);
    b((ViewGroup)localObject3);
    int i1;
    boolean bool1;
    label173:
    boolean bool2;
    if ((localObject4 != null) && (((ViewGroup)localObject4).getVisibility() != 8))
    {
      i1 = 1;
      if ((localObject3 == null) || (((ViewGroup)localObject3).getVisibility() == 8)) {
        break label405;
      }
      bool1 = true;
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label410;
      }
      bool2 = true;
      label191:
      if ((!bool2) && (localObject2 != null))
      {
        localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoButtons);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if (!bool1) {
        break label416;
      }
      if (this.i != null) {
        this.i.setClipToPadding(true);
      }
      localObject1 = null;
      if ((this.t != null) || (this.b != null)) {
        localObject1 = ((ViewGroup)localObject3).findViewById(R.id.titleDividerNoCustom);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      label279:
      if ((this.b instanceof RecycleListView)) {
        ((RecycleListView)this.b).setHasDecor(bool1, bool2);
      }
      if (i1 == 0)
      {
        if (this.b == null) {
          break label445;
        }
        localObject1 = this.b;
        label319:
        if (localObject1 != null)
        {
          if (!bool1) {
            break label454;
          }
          i1 = 1;
          label330:
          if (!bool2) {
            break label459;
          }
        }
      }
    }
    label405:
    label410:
    label416:
    label445:
    label454:
    label459:
    for (int i2 = 2;; i2 = 0)
    {
      a((ViewGroup)localObject2, (View)localObject1, i2 | i1, 3);
      localObject1 = this.b;
      if ((localObject1 != null) && (this.j != null))
      {
        ((ListView)localObject1).setAdapter(this.j);
        i1 = this.k;
        if (i1 > -1)
        {
          ((ListView)localObject1).setItemChecked(i1, true);
          ((ListView)localObject1).setSelection(i1);
        }
      }
      return;
      i1 = 0;
      break;
      bool1 = false;
      break label173;
      bool2 = false;
      break label191;
      if (localObject2 == null) {
        break label279;
      }
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoTitle);
      if (localObject1 == null) {
        break label279;
      }
      ((View)localObject1).setVisibility(0);
      break label279;
      localObject1 = this.i;
      break label319;
      i1 = 0;
      break label330;
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if (this.J != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.J, 0, localLayoutParams);
      this.r.findViewById(R.id.title_template).setVisibility(8);
      return;
    }
    this.G = ((ImageView)this.r.findViewById(16908294));
    int i1;
    if (!TextUtils.isEmpty(this.s)) {
      i1 = 1;
    }
    while ((i1 != 0) && (this.M))
    {
      this.H = ((TextView)this.r.findViewById(R.id.alertTitle));
      this.H.setText(this.s);
      if (this.E != 0)
      {
        this.G.setImageResource(this.E);
        return;
        i1 = 0;
      }
      else
      {
        if (this.F != null)
        {
          this.G.setImageDrawable(this.F);
          return;
        }
        this.H.setPadding(this.G.getPaddingLeft(), this.G.getPaddingTop(), this.G.getPaddingRight(), this.G.getPaddingBottom());
        this.G.setVisibility(8);
        return;
      }
    }
    this.r.findViewById(R.id.title_template).setVisibility(8);
    this.G.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.i = ((NestedScrollView)this.r.findViewById(R.id.scrollView));
    this.i.setFocusable(false);
    this.i.setNestedScrollingEnabled(false);
    this.I = ((TextView)paramViewGroup.findViewById(16908299));
    if (this.I == null) {
      return;
    }
    if (this.t != null)
    {
      this.I.setText(this.t);
      return;
    }
    this.I.setVisibility(8);
    this.i.removeView(this.I);
    if (this.b != null)
    {
      paramViewGroup = (ViewGroup)this.i.getParent();
      int i1 = paramViewGroup.indexOfChild(this.i);
      paramViewGroup.removeViewAt(i1);
      paramViewGroup.addView(this.b, i1, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    int i2 = 1;
    this.c = ((Button)paramViewGroup.findViewById(16908313));
    this.c.setOnClickListener(this.O);
    if (TextUtils.isEmpty(this.B))
    {
      this.c.setVisibility(8);
      i1 = 0;
      this.e = ((Button)paramViewGroup.findViewById(16908314));
      this.e.setOnClickListener(this.O);
      if (!TextUtils.isEmpty(this.C)) {
        break label200;
      }
      this.e.setVisibility(8);
      label92:
      this.g = ((Button)paramViewGroup.findViewById(16908315));
      this.g.setOnClickListener(this.O);
      if (!TextUtils.isEmpty(this.D)) {
        break label226;
      }
      this.g.setVisibility(8);
      label136:
      if (a(this.q))
      {
        if (i1 != 1) {
          break label252;
        }
        a(this.c);
      }
      label159:
      if (i1 == 0) {
        break label284;
      }
    }
    label200:
    label226:
    label252:
    label284:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 == 0) {
        paramViewGroup.setVisibility(8);
      }
      return;
      this.c.setText(this.B);
      this.c.setVisibility(0);
      i1 = 1;
      break;
      this.e.setText(this.C);
      this.e.setVisibility(0);
      i1 |= 0x2;
      break label92;
      this.g.setText(this.D);
      this.g.setVisibility(0);
      i1 |= 0x4;
      break label136;
      if (i1 == 2)
      {
        a(this.e);
        break label159;
      }
      if (i1 != 4) {
        break label159;
      }
      a(this.g);
      break label159;
    }
  }
  
  public Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.c;
    case -2: 
      return this.e;
    }
    return this.g;
  }
  
  public int getIconAttributeResId(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.q.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public ListView getListView()
  {
    return this.b;
  }
  
  public void installContent()
  {
    int i1 = a();
    this.a.setContentView(i1);
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.i != null) && (this.i.executeKeyEvent(paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.i != null) && (this.i.executeKeyEvent(paramKeyEvent));
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    Message localMessage = paramMessage;
    if (paramMessage == null)
    {
      localMessage = paramMessage;
      if (paramOnClickListener != null) {
        localMessage = this.p.obtainMessage(paramInt, paramOnClickListener);
      }
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.B = paramCharSequence;
      this.d = localMessage;
      return;
    case -2: 
      this.C = paramCharSequence;
      this.f = localMessage;
      return;
    }
    this.D = paramCharSequence;
    this.h = localMessage;
  }
  
  public void setButtonPanelLayoutHint(int paramInt)
  {
    this.N = paramInt;
  }
  
  public void setCustomTitle(View paramView)
  {
    this.J = paramView;
  }
  
  public void setIcon(int paramInt)
  {
    this.F = null;
    this.E = paramInt;
    if (this.G != null)
    {
      if (paramInt != 0)
      {
        this.G.setVisibility(0);
        this.G.setImageResource(this.E);
      }
    }
    else {
      return;
    }
    this.G.setVisibility(8);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.F = paramDrawable;
    this.E = 0;
    if (this.G != null)
    {
      if (paramDrawable != null)
      {
        this.G.setVisibility(0);
        this.G.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    this.G.setVisibility(8);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.t = paramCharSequence;
    if (this.I != null) {
      this.I.setText(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    if (this.H != null) {
      this.H.setText(paramCharSequence);
    }
  }
  
  public void setView(int paramInt)
  {
    this.u = null;
    this.v = paramInt;
    this.A = false;
  }
  
  public void setView(View paramView)
  {
    this.u = paramView;
    this.v = 0;
    this.A = false;
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.u = paramView;
    this.v = 0;
    this.A = true;
    this.w = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
    this.z = paramInt4;
  }
  
  public static class RecycleListView
    extends ListView
  {
    private final int a;
    private final int b;
    
    public RecycleListView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
      this.b = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      this.a = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
    
    public void setHasDecor(boolean paramBoolean1, boolean paramBoolean2)
    {
      int k;
      int i;
      int m;
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        k = getPaddingLeft();
        if (!paramBoolean1) {
          break label51;
        }
        i = getPaddingTop();
        m = getPaddingRight();
        if (!paramBoolean2) {
          break label59;
        }
      }
      label51:
      label59:
      for (int j = getPaddingBottom();; j = this.b)
      {
        setPadding(k, i, m, j);
        return;
        i = this.a;
        break;
      }
    }
  }
  
  public static class a
  {
    public int A;
    public boolean B = false;
    public boolean[] C;
    public boolean D;
    public boolean E;
    public int F = -1;
    public DialogInterface.OnMultiChoiceClickListener G;
    public Cursor H;
    public String I;
    public String J;
    public boolean K;
    public AdapterView.OnItemSelectedListener L;
    public a M;
    public boolean N = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public DialogInterface.OnClickListener j;
    public CharSequence k;
    public DialogInterface.OnClickListener l;
    public CharSequence m;
    public DialogInterface.OnClickListener n;
    public boolean o;
    public DialogInterface.OnCancelListener p;
    public DialogInterface.OnDismissListener q;
    public DialogInterface.OnKeyListener r;
    public CharSequence[] s;
    public ListAdapter t;
    public DialogInterface.OnClickListener u;
    public int v;
    public View w;
    public int x;
    public int y;
    public int z;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
      this.o = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
    
    private void a(final AlertController paramAlertController)
    {
      final AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.b.inflate(paramAlertController.l, null);
      Object localObject;
      if (this.D) {
        if (this.H == null)
        {
          localObject = new ArrayAdapter(this.a, paramAlertController.m, 16908308, this.s)
          {
            public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
            {
              paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
              if ((AlertController.a.this.C != null) && (AlertController.a.this.C[paramAnonymousInt] != 0)) {
                localRecycleListView.setItemChecked(paramAnonymousInt, true);
              }
              return paramAnonymousView;
            }
          };
          if (this.M != null) {
            this.M.onPrepareListView(localRecycleListView);
          }
          paramAlertController.j = ((ListAdapter)localObject);
          paramAlertController.k = this.F;
          if (this.u == null) {
            break label271;
          }
          localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            @Instrumented
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
              AlertController.a.this.u.onClick(paramAlertController.a, paramAnonymousInt);
              if (!AlertController.a.this.E) {
                paramAlertController.a.dismiss();
              }
            }
          });
          label108:
          if (this.L != null) {
            localRecycleListView.setOnItemSelectedListener(this.L);
          }
          if (!this.E) {
            break label297;
          }
          localRecycleListView.setChoiceMode(1);
        }
      }
      for (;;)
      {
        paramAlertController.b = localRecycleListView;
        return;
        localObject = new CursorAdapter(this.a, this.H, false)
        {
          private final int d;
          private final int e;
          
          public void bindView(View paramAnonymousView, Context paramAnonymousContext, Cursor paramAnonymousCursor)
          {
            ((CheckedTextView)paramAnonymousView.findViewById(16908308)).setText(paramAnonymousCursor.getString(this.d));
            paramAnonymousView = localRecycleListView;
            int i = paramAnonymousCursor.getPosition();
            if (paramAnonymousCursor.getInt(this.e) == 1) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setItemChecked(i, bool);
              return;
            }
          }
          
          public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
          {
            return AlertController.a.this.b.inflate(paramAlertController.m, paramAnonymousViewGroup, false);
          }
        };
        break;
        if (this.E) {}
        for (int i1 = paramAlertController.n;; i1 = paramAlertController.o)
        {
          if (this.H == null) {
            break label234;
          }
          localObject = new SimpleCursorAdapter(this.a, i1, this.H, new String[] { this.I }, new int[] { 16908308 });
          break;
        }
        label234:
        if (this.t != null)
        {
          localObject = this.t;
          break;
        }
        localObject = new AlertController.c(this.a, i1, 16908308, this.s);
        break;
        label271:
        if (this.G == null) {
          break label108;
        }
        localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (AlertController.a.this.C != null) {
              AlertController.a.this.C[paramAnonymousInt] = localRecycleListView.isItemChecked(paramAnonymousInt);
            }
            AlertController.a.this.G.onClick(paramAlertController.a, paramAnonymousInt, localRecycleListView.isItemChecked(paramAnonymousInt));
          }
        });
        break label108;
        label297:
        if (this.D) {
          localRecycleListView.setChoiceMode(2);
        }
      }
    }
    
    public void apply(AlertController paramAlertController)
    {
      if (this.g != null)
      {
        paramAlertController.setCustomTitle(this.g);
        if (this.h != null) {
          paramAlertController.setMessage(this.h);
        }
        if (this.i != null) {
          paramAlertController.setButton(-1, this.i, this.j, null);
        }
        if (this.k != null) {
          paramAlertController.setButton(-2, this.k, this.l, null);
        }
        if (this.m != null) {
          paramAlertController.setButton(-3, this.m, this.n, null);
        }
        if ((this.s != null) || (this.H != null) || (this.t != null)) {
          a(paramAlertController);
        }
        if (this.w == null) {
          break label236;
        }
        if (!this.B) {
          break label227;
        }
        paramAlertController.setView(this.w, this.x, this.y, this.z, this.A);
      }
      label227:
      label236:
      while (this.v == 0)
      {
        return;
        if (this.f != null) {
          paramAlertController.setTitle(this.f);
        }
        if (this.d != null) {
          paramAlertController.setIcon(this.d);
        }
        if (this.c != 0) {
          paramAlertController.setIcon(this.c);
        }
        if (this.e == 0) {
          break;
        }
        paramAlertController.setIcon(paramAlertController.getIconAttributeResId(this.e));
        break;
        paramAlertController.setView(this.w);
        return;
      }
      paramAlertController.setView(this.v);
    }
    
    public static abstract interface a
    {
      public abstract void onPrepareListView(ListView paramListView);
    }
  }
  
  private static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> a;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -3: 
      case -2: 
      case -1: 
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  private static class c
    extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/AlertController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */