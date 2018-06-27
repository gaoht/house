package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.r;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] a = { 16843505 };
  private final e b;
  private final Context c;
  private z d;
  private SpinnerAdapter e;
  private final boolean f;
  private b g;
  private int h;
  private final Rect i;
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 65	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 67	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 69	android/graphics/Rect:<init>	()V
    //   15: putfield 71	android/support/v7/widget/AppCompatSpinner:i	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 76	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 82	android/support/v7/widget/at:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/at;
    //   28: astore 10
    //   30: aload_0
    //   31: new 84	android/support/v7/widget/e
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 87	android/support/v7/widget/e:<init>	(Landroid/view/View;)V
    //   39: putfield 89	android/support/v7/widget/AppCompatSpinner:b	Landroid/support/v7/widget/e;
    //   42: aload 5
    //   44: ifnull +285 -> 329
    //   47: aload_0
    //   48: new 91	android/support/v7/view/d
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 94	android/support/v7/view/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   65: ifnull +184 -> 249
    //   68: iload 4
    //   70: istore 7
    //   72: iload 4
    //   74: iconst_m1
    //   75: if_icmpne +71 -> 146
    //   78: getstatic 101	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 11
    //   83: if_icmplt +361 -> 444
    //   86: aload_1
    //   87: aload_2
    //   88: getstatic 41	android/support/v7/widget/AppCompatSpinner:a	[I
    //   91: iload_3
    //   92: iconst_0
    //   93: invokevirtual 106	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   96: astore 8
    //   98: iload 4
    //   100: istore 6
    //   102: aload 8
    //   104: astore 5
    //   106: aload 8
    //   108: iconst_0
    //   109: invokevirtual 112	android/content/res/TypedArray:hasValue	(I)Z
    //   112: ifeq +16 -> 128
    //   115: aload 8
    //   117: astore 5
    //   119: aload 8
    //   121: iconst_0
    //   122: iconst_0
    //   123: invokevirtual 116	android/content/res/TypedArray:getInt	(II)I
    //   126: istore 6
    //   128: iload 6
    //   130: istore 7
    //   132: aload 8
    //   134: ifnull +12 -> 146
    //   137: aload 8
    //   139: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   142: iload 6
    //   144: istore 7
    //   146: iload 7
    //   148: iconst_1
    //   149: if_icmpne +100 -> 249
    //   152: new 13	android/support/v7/widget/AppCompatSpinner$b
    //   155: dup
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   161: aload_2
    //   162: iload_3
    //   163: invokespecial 122	android/support/v7/widget/AppCompatSpinner$b:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   166: astore 5
    //   168: aload_0
    //   169: getfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   172: aload_2
    //   173: getstatic 76	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   176: iload_3
    //   177: iconst_0
    //   178: invokestatic 82	android/support/v7/widget/at:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/at;
    //   181: astore 8
    //   183: aload_0
    //   184: aload 8
    //   186: getstatic 125	android/support/v7/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   189: bipush -2
    //   191: invokevirtual 128	android/support/v7/widget/at:getLayoutDimension	(II)I
    //   194: putfield 130	android/support/v7/widget/AppCompatSpinner:h	I
    //   197: aload 5
    //   199: aload 8
    //   201: getstatic 133	android/support/v7/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   204: invokevirtual 137	android/support/v7/widget/at:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   207: invokevirtual 141	android/support/v7/widget/AppCompatSpinner$b:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   210: aload 5
    //   212: aload 10
    //   214: getstatic 144	android/support/v7/appcompat/R$styleable:Spinner_android_prompt	I
    //   217: invokevirtual 148	android/support/v7/widget/at:getString	(I)Ljava/lang/String;
    //   220: invokevirtual 152	android/support/v7/widget/AppCompatSpinner$b:setPromptText	(Ljava/lang/CharSequence;)V
    //   223: aload 8
    //   225: invokevirtual 153	android/support/v7/widget/at:recycle	()V
    //   228: aload_0
    //   229: aload 5
    //   231: putfield 155	android/support/v7/widget/AppCompatSpinner:g	Landroid/support/v7/widget/AppCompatSpinner$b;
    //   234: aload_0
    //   235: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   238: dup
    //   239: aload_0
    //   240: aload_0
    //   241: aload 5
    //   243: invokespecial 158	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$b;)V
    //   246: putfield 160	android/support/v7/widget/AppCompatSpinner:d	Landroid/support/v7/widget/z;
    //   249: aload 10
    //   251: getstatic 163	android/support/v7/appcompat/R$styleable:Spinner_android_entries	I
    //   254: invokevirtual 167	android/support/v7/widget/at:getTextArray	(I)[Ljava/lang/CharSequence;
    //   257: astore 5
    //   259: aload 5
    //   261: ifnull +28 -> 289
    //   264: new 169	android/widget/ArrayAdapter
    //   267: dup
    //   268: aload_1
    //   269: ldc -86
    //   271: aload 5
    //   273: invokespecial 173	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   276: astore_1
    //   277: aload_1
    //   278: getstatic 178	android/support/v7/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   281: invokevirtual 182	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   284: aload_0
    //   285: aload_1
    //   286: invokevirtual 186	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   289: aload 10
    //   291: invokevirtual 153	android/support/v7/widget/at:recycle	()V
    //   294: aload_0
    //   295: iconst_1
    //   296: putfield 188	android/support/v7/widget/AppCompatSpinner:f	Z
    //   299: aload_0
    //   300: getfield 190	android/support/v7/widget/AppCompatSpinner:e	Landroid/widget/SpinnerAdapter;
    //   303: ifnull +16 -> 319
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 190	android/support/v7/widget/AppCompatSpinner:e	Landroid/widget/SpinnerAdapter;
    //   311: invokevirtual 186	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   314: aload_0
    //   315: aconst_null
    //   316: putfield 190	android/support/v7/widget/AppCompatSpinner:e	Landroid/widget/SpinnerAdapter;
    //   319: aload_0
    //   320: getfield 89	android/support/v7/widget/AppCompatSpinner:b	Landroid/support/v7/widget/e;
    //   323: aload_2
    //   324: iload_3
    //   325: invokevirtual 193	android/support/v7/widget/e:a	(Landroid/util/AttributeSet;I)V
    //   328: return
    //   329: aload 10
    //   331: getstatic 196	android/support/v7/appcompat/R$styleable:Spinner_popupTheme	I
    //   334: iconst_0
    //   335: invokevirtual 199	android/support/v7/widget/at:getResourceId	(II)I
    //   338: istore 6
    //   340: iload 6
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: new 91	android/support/v7/view/d
    //   349: dup
    //   350: aload_1
    //   351: iload 6
    //   353: invokespecial 201	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   356: putfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   359: goto -298 -> 61
    //   362: getstatic 101	android/os/Build$VERSION:SDK_INT	I
    //   365: bipush 23
    //   367: if_icmpge +15 -> 382
    //   370: aload_1
    //   371: astore 5
    //   373: aload_0
    //   374: aload 5
    //   376: putfield 96	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   379: goto -318 -> 61
    //   382: aconst_null
    //   383: astore 5
    //   385: goto -12 -> 373
    //   388: astore 9
    //   390: aconst_null
    //   391: astore 8
    //   393: aload 8
    //   395: astore 5
    //   397: ldc -53
    //   399: ldc -51
    //   401: aload 9
    //   403: invokestatic 210	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   406: pop
    //   407: iload 4
    //   409: istore 7
    //   411: aload 8
    //   413: ifnull -267 -> 146
    //   416: aload 8
    //   418: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   421: iload 4
    //   423: istore 7
    //   425: goto -279 -> 146
    //   428: astore_1
    //   429: aconst_null
    //   430: astore 5
    //   432: aload 5
    //   434: ifnull +8 -> 442
    //   437: aload 5
    //   439: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   442: aload_1
    //   443: athrow
    //   444: iconst_1
    //   445: istore 7
    //   447: goto -301 -> 146
    //   450: astore_1
    //   451: goto -19 -> 432
    //   454: astore 9
    //   456: goto -63 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	AppCompatSpinner
    //   0	459	1	paramContext	Context
    //   0	459	2	paramAttributeSet	AttributeSet
    //   0	459	3	paramInt1	int
    //   0	459	4	paramInt2	int
    //   0	459	5	paramTheme	Resources.Theme
    //   100	252	6	j	int
    //   70	376	7	k	int
    //   96	321	8	localObject	Object
    //   388	14	9	localException1	Exception
    //   454	1	9	localException2	Exception
    //   28	302	10	localat	at
    // Exception table:
    //   from	to	target	type
    //   86	98	388	java/lang/Exception
    //   86	98	428	finally
    //   106	115	450	finally
    //   119	128	450	finally
    //   397	407	450	finally
    //   106	115	454	java/lang/Exception
    //   119	128	454	java/lang/Exception
  }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int j = Math.max(0, getSelectedItemPosition());
    int i3 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
    int k = Math.max(0, j - (15 - (i3 - j)));
    View localView = null;
    int m = 0;
    j = 0;
    if (k < i3)
    {
      int n = paramSpinnerAdapter.getItemViewType(k);
      if (n == j) {
        break label204;
      }
      localView = null;
      j = n;
    }
    label204:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(k, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i1, i2);
      m = Math.max(m, localView.getMeasuredWidth());
      k += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.i);
        return this.i.left + this.i.right + m;
      }
      return m;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.b != null) {
      this.b.c();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.g != null) {
      return this.g.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.g != null) {
      return this.g.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.g != null) {
      return this.h;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.g != null) {
      return this.g.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.g != null) {
      return this.c;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.g != null) {
      return this.g.getHintText();
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.b != null) {
      return this.b.a();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.b != null) {
      return this.b.b();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.g != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.d != null) && (this.d.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.g != null)
    {
      if (!this.g.isShowing()) {
        this.g.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.f) {
      this.e = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.g == null);
    if (this.c == null) {}
    for (Context localContext = getContext();; localContext = this.c)
    {
      this.g.setAdapter(new a(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.b != null) {
      this.b.a(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.b != null) {
      this.b.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.g != null) {
      this.g.setHorizontalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.g != null) {
      this.g.setVerticalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.g != null) {
      this.h = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.g != null) {
      this.g.setBackgroundDrawable(paramDrawable);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(b.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.g != null)
    {
      this.g.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.b != null) {
      this.b.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.b != null) {
      this.b.a(paramMode);
    }
  }
  
  private static class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter a;
    private ListAdapter b;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.a = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.b = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null)
      {
        if ((Build.VERSION.SDK_INT < 23) || (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter))) {
          break label66;
        }
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      label66:
      do
      {
        do
        {
          return;
        } while (!(paramSpinnerAdapter instanceof ap));
        paramSpinnerAdapter = (ap)paramSpinnerAdapter;
      } while (paramSpinnerAdapter.getDropDownViewTheme() != null);
      paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (this.a == null) {
        return -1L;
      }
      return this.a.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return (this.a != null) && (this.a.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class b
    extends ListPopupWindow
  {
    ListAdapter a;
    private CharSequence h;
    private final Rect i = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.b.this.a.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.b.this.dismiss();
        }
      });
    }
    
    void a()
    {
      Object localObject = getBackground();
      int j;
      int n;
      int i1;
      int i2;
      int k;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.b(AppCompatSpinner.this));
        if (bb.isLayoutRtl(AppCompatSpinner.this))
        {
          j = AppCompatSpinner.b(AppCompatSpinner.this).right;
          n = AppCompatSpinner.this.getPaddingLeft();
          i1 = AppCompatSpinner.this.getPaddingRight();
          i2 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.c(AppCompatSpinner.this) != -2) {
            break label240;
          }
          k = AppCompatSpinner.this.a((SpinnerAdapter)this.a, getBackground());
          int m = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.b(AppCompatSpinner.this).left - AppCompatSpinner.b(AppCompatSpinner.this).right;
          if (k <= m) {
            break label288;
          }
          k = m;
        }
      }
      label165:
      label240:
      label288:
      for (;;)
      {
        setContentWidth(Math.max(k, i2 - n - i1));
        if (bb.isLayoutRtl(AppCompatSpinner.this)) {
          j = i2 - i1 - getWidth() + j;
        }
        for (;;)
        {
          setHorizontalOffset(j);
          return;
          j = -AppCompatSpinner.b(AppCompatSpinner.this).left;
          break;
          localObject = AppCompatSpinner.b(AppCompatSpinner.this);
          AppCompatSpinner.b(AppCompatSpinner.this).right = 0;
          ((Rect)localObject).left = 0;
          j = 0;
          break;
          if (AppCompatSpinner.c(AppCompatSpinner.this) == -1)
          {
            setContentWidth(i2 - n - i1);
            break label165;
          }
          setContentWidth(AppCompatSpinner.c(AppCompatSpinner.this));
          break label165;
          j += n;
        }
      }
    }
    
    boolean a(View paramView)
    {
      return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.i));
    }
    
    public CharSequence getHintText()
    {
      return this.h;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.a = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.h = paramCharSequence;
    }
    
    public void show()
    {
      boolean bool = isShowing();
      a();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {}
      ViewTreeObserver localViewTreeObserver;
      do
      {
        return;
        localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      } while (localViewTreeObserver == null);
      final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (!AppCompatSpinner.b.this.a(AppCompatSpinner.this))
          {
            AppCompatSpinner.b.this.dismiss();
            return;
          }
          AppCompatSpinner.b.this.a();
          AppCompatSpinner.b.a(AppCompatSpinner.b.this);
        }
      };
      localViewTreeObserver.addOnGlobalLayoutListener(local2);
      setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
          if (localViewTreeObserver != null) {
            localViewTreeObserver.removeGlobalOnLayoutListener(local2);
          }
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */