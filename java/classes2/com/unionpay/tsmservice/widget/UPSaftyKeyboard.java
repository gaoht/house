package com.unionpay.tsmservice.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.AudioManager;
import android.os.RemoteException;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UPSaftyKeyboard
{
  private static List<Integer> ab = new ArrayList(10);
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N = 0;
  private OnShowListener O;
  private OnHideListener P;
  private OnEditorListener Q;
  private UPTsmAddon.UPTsmConnectionListener R;
  private AudioManager S;
  private Vibrator T;
  private boolean U = false;
  private boolean V = false;
  private boolean W = false;
  private boolean X = true;
  private boolean Y = false;
  private UPTsmAddon Z;
  final View.OnClickListener a = new UPSaftyKeyboard.4(this);
  private String aa;
  private PopupWindow.OnDismissListener ac = new UPSaftyKeyboard.3(this);
  private Context b = null;
  private LinearLayout c;
  private RelativeLayout d;
  private ImageView e;
  private a f = null;
  private PopupWindow g;
  private TextView h;
  private b i;
  private boolean j = true;
  private Drawable k;
  private Drawable[] l;
  private Drawable[] m;
  private Drawable n;
  private Drawable o;
  private Drawable p;
  private Drawable q;
  private Drawable r;
  private Drawable s;
  private int t = -16777216;
  private int u = 40;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    int i1 = 0;
    while (i1 < 10)
    {
      ab.add(Integer.valueOf(i1));
      i1 += 1;
    }
  }
  
  public UPSaftyKeyboard(Context paramContext)
  {
    this.b = paramContext;
    c();
    a(paramContext);
    d();
  }
  
  public UPSaftyKeyboard(Context paramContext, Drawable paramDrawable)
  {
    this.b = paramContext;
    this.k = paramDrawable;
    c();
    a(paramContext);
    d();
  }
  
  private void a(Context paramContext)
  {
    this.c = new LinearLayout(paramContext);
    this.c.setOrientation(1);
    if (this.k != null) {
      this.c.setBackgroundDrawable(this.k);
    }
    for (;;)
    {
      this.d = new RelativeLayout(paramContext);
      Object localObject = new LinearLayout.LayoutParams(-1, e() / 16);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.h = new TextView(paramContext);
      this.h.setText("Secure Mode");
      this.h.setTextColor(-1);
      this.h.setGravity(17);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.e = new ImageView(paramContext);
      this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject = new RelativeLayout.LayoutParams(120, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.e.setVisibility(8);
      this.d.addView(this.h);
      this.d.addView(this.e);
      this.f = new a(paramContext, (byte)0);
      this.f.setHorizontalScrollBarEnabled(false);
      this.f.setVerticalScrollBarEnabled(false);
      this.f.setEnabled(false);
      this.f.setNumColumns(3);
      this.f.setVerticalSpacing(this.B);
      this.f.setHorizontalSpacing(this.A);
      this.f.setAdapter(this.i);
      this.f.setPadding(this.G, this.H, this.I, this.J);
      this.c.addView(this.d);
      this.c.addView(this.f);
      this.c.setPadding(this.C, this.D, this.E, this.F);
      this.g = new PopupWindow(this.c, this.x, this.y);
      this.g.setBackgroundDrawable(new BitmapDrawable());
      this.g.setSoftInputMode(2);
      this.g.setOutsideTouchable(true);
      this.g.setFocusable(true);
      this.g.setOnDismissListener(this.ac);
      return;
      this.c.setBackgroundColor(-7829368);
    }
  }
  
  private static String b(String paramString)
  {
    try
    {
      paramString = IUPJniInterface.rEFP(paramString);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = IUPJniInterface.ePB(paramString);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void c()
  {
    this.v = 0;
    this.w = 0;
    this.K = -1;
    this.L = (e() / 14);
    this.z = (e() / 16);
    this.A = 10;
    this.B = 10;
    this.C = 0;
    this.D = 0;
    this.E = 0;
    this.F = 0;
    this.G = 10;
    this.H = 5;
    this.I = 10;
    this.J = 10;
    this.x = -1;
    this.y = (e() / 14 * 4 + e() / 16 + this.B * 3 + 10 + 5);
    this.T = ((Vibrator)this.b.getSystemService("vibrator"));
    this.S = ((AudioManager)this.b.getSystemService("audio"));
    this.W = true;
    this.i = new b((byte)0);
  }
  
  private void d()
  {
    clearPwd();
    this.Z = UPTsmAddon.getInstance(this.b);
    if (!this.Z.isConnected())
    {
      this.R = new UPSaftyKeyboard.1(this);
      this.Z.addConnectionListener(this.R);
      this.Z.bind();
      return;
    }
    try
    {
      String[] arrayOfString = new String[1];
      this.Z.getPubKey(1001, arrayOfString);
      this.aa = arrayOfString[0];
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private int e()
  {
    if (this.b != null) {
      return this.b.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
  
  public void clearPwd()
  {
    try
    {
      IUPJniInterface.cPD();
      this.N = 0;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public int getCurrentPinLength()
  {
    return this.N;
  }
  
  public String getEncryptPin()
  {
    String str = "";
    if (!TextUtils.isEmpty(this.aa)) {
      str = b(this.aa);
    }
    return str;
  }
  
  public String getEncryptPin(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = c(paramString);
    }
    return str;
  }
  
  public void hide()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
    if (this.P != null) {
      this.P.onHide();
    }
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.M = paramInt;
  }
  
  public void setDelKeyDrawableSelector(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.o = paramDrawable1;
    this.q = paramDrawable2;
  }
  
  public void setDoneKeyDrawableSelector(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.n = paramDrawable1;
    this.p = paramDrawable2;
  }
  
  public void setDoneKeyEnable(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public void setDoneKeyRightMode(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public void setKeyAreaPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.G = paramInt1;
    this.H = paramInt2;
    this.I = paramInt3;
    this.J = paramInt4;
    this.f.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setKeyBoardSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      this.x = paramInt1;
    }
    if (paramInt2 >= 0) {
      this.y = paramInt2;
    }
    this.c.setLayoutParams(new LinearLayout.LayoutParams(this.x, this.y));
  }
  
  public void setKeyboardAudio(boolean paramBoolean)
  {
    int i1 = -1;
    if (this.S != null) {
      i1 = this.S.getRingerMode();
    }
    if (paramBoolean) {
      if (!this.W) {
        break label43;
      }
    }
    label43:
    for (this.U = true;; this.U = false)
    {
      if (i1 == 0) {
        this.U = false;
      }
      return;
    }
  }
  
  public void setKeyboardBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.k = paramDrawable;
      this.c.setBackgroundDrawable(this.k);
    }
  }
  
  public void setKeyboardPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.C = paramInt1;
    this.D = paramInt2;
    this.E = paramInt3;
    this.F = paramInt4;
    this.c.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setKeyboardStartPosition(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      this.v = paramInt1;
      this.w = paramInt2;
      this.j = false;
    }
  }
  
  public void setKeyboardVibrate(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public void setNumKeyBackgroud(Drawable paramDrawable)
  {
    this.s = paramDrawable;
  }
  
  public void setNumKeyMargin(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      this.B = paramInt1;
      this.f.setVerticalSpacing(paramInt1);
    }
    if (paramInt2 >= 0)
    {
      this.A = paramInt2;
      this.f.setHorizontalSpacing(paramInt2);
    }
  }
  
  public void setNumberKeyColor(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setNumberKeyDrawableSelector(Drawable[] paramArrayOfDrawable1, Drawable[] paramArrayOfDrawable2)
  {
    this.l = paramArrayOfDrawable1;
    this.m = paramArrayOfDrawable2;
  }
  
  public void setNumberKeySize(int paramInt)
  {
    if (paramInt >= 0) {
      this.u = paramInt;
    }
  }
  
  public void setOnEditorListener(OnEditorListener paramOnEditorListener)
  {
    this.Q = paramOnEditorListener;
  }
  
  public void setOnHideListener(OnHideListener paramOnHideListener)
  {
    this.P = paramOnHideListener;
  }
  
  public void setOnShowListener(OnShowListener paramOnShowListener)
  {
    this.O = paramOnShowListener;
  }
  
  public void setTitleBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.d.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setTitleColor(int paramInt)
  {
    this.h.setTextColor(paramInt);
  }
  
  public void setTitleConfirmDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.e.setVisibility(0);
      this.e.setImageDrawable(paramDrawable);
      this.e.setOnClickListener(new UPSaftyKeyboard.2(this));
    }
  }
  
  public void setTitleDrawable(Drawable paramDrawable)
  {
    this.r = paramDrawable;
    this.h.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    this.h.setCompoundDrawablePadding(10);
  }
  
  public void setTitleDrawablePadding(int paramInt)
  {
    this.h.setCompoundDrawablePadding(paramInt);
  }
  
  public void setTitleDrawableSize(int paramInt1, int paramInt2)
  {
    if (this.r != null)
    {
      this.r.setBounds(0, 0, paramInt1, paramInt2);
      this.h.setCompoundDrawables(this.r, null, null, null);
    }
  }
  
  public void setTitleFont(Typeface paramTypeface)
  {
    if (paramTypeface != null) {
      this.h.setTypeface(paramTypeface);
    }
  }
  
  public void setTitleHeight(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.z = 0;
      this.c.removeView(this.d);
      this.g.setContentView(this.c);
      return;
    }
    this.z = paramInt;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, paramInt);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public void setTitleSize(int paramInt)
  {
    if (paramInt >= 0) {
      this.h.setTextSize(0, paramInt);
    }
  }
  
  public void setTitleText(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void show(View paramView)
  {
    Object localObject;
    if (this.i != null)
    {
      localObject = this.i;
      b.a();
      this.i.notifyDataSetChanged();
    }
    this.f.requestLayout();
    this.c.invalidate();
    if (this.g != null)
    {
      this.g.setWidth(this.x);
      this.g.setHeight(this.y);
    }
    int i1;
    int i2;
    if (this.g != null)
    {
      this.g.setAnimationStyle(this.M);
      if (this.O != null) {
        this.O.onShow();
      }
      if (this.j) {
        break label165;
      }
      localObject = this.g;
      i1 = this.v;
      i2 = this.w;
      if ((localObject instanceof PopupWindow)) {
        break label149;
      }
      ((PopupWindow)localObject).showAtLocation(paramView, 51, i1, i2);
    }
    for (;;)
    {
      this.g.update();
      return;
      label149:
      VdsAgent.showAtLocation((PopupWindow)localObject, paramView, 51, i1, i2);
      continue;
      label165:
      localObject = this.g;
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(paramView, 80, 0, 0);
      } else {
        VdsAgent.showAtLocation((PopupWindow)localObject, paramView, 80, 0, 0);
      }
    }
  }
  
  public static abstract interface OnEditorListener
  {
    public abstract void onEditorChanged(int paramInt);
  }
  
  public static abstract interface OnHideListener
  {
    public abstract void onHide();
  }
  
  public static abstract interface OnShowListener
  {
    public abstract void onShow();
  }
  
  private final class a
    extends GridView
  {
    private a(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 2) {
        return true;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  private final class b
    extends BaseAdapter
  {
    private b()
    {
      Collections.shuffle(UPSaftyKeyboard.b());
    }
    
    private void a(TextView paramTextView)
    {
      ColorDrawable localColorDrawable1 = new ColorDrawable(-1);
      ColorDrawable localColorDrawable2 = new ColorDrawable(-7829368);
      UPSaftyKeyboard localUPSaftyKeyboard = UPSaftyKeyboard.this;
      paramTextView.setBackgroundDrawable(UPSaftyKeyboard.a(localColorDrawable1, localColorDrawable2));
    }
    
    public final int getCount()
    {
      return 12;
    }
    
    public final Object getItem(int paramInt)
    {
      if (paramInt == 9)
      {
        if (UPSaftyKeyboard.i(UPSaftyKeyboard.this)) {
          return "Del";
        }
        return "OK";
      }
      if (paramInt == 11)
      {
        if (UPSaftyKeyboard.i(UPSaftyKeyboard.this)) {
          return "OK";
        }
        return "Del";
      }
      if (paramInt == 10) {
        return String.valueOf(UPSaftyKeyboard.b().get(paramInt - 1));
      }
      return String.valueOf(UPSaftyKeyboard.b().get(paramInt));
    }
    
    public final long getItemId(int paramInt)
    {
      if (paramInt == 9) {
        if (!UPSaftyKeyboard.i(UPSaftyKeyboard.this)) {}
      }
      do
      {
        return 20L;
        return 10L;
        if (paramInt != 11) {
          break;
        }
      } while (!UPSaftyKeyboard.i(UPSaftyKeyboard.this));
      return 10L;
      if (paramInt == 10) {
        return ((Integer)UPSaftyKeyboard.b().get(paramInt - 1)).intValue();
      }
      return ((Integer)UPSaftyKeyboard.b().get(paramInt)).intValue();
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (-1 != UPSaftyKeyboard.j(UPSaftyKeyboard.this)) {
        UPSaftyKeyboard.a(UPSaftyKeyboard.this, (UPSaftyKeyboard.j(UPSaftyKeyboard.this) - UPSaftyKeyboard.k(UPSaftyKeyboard.this) * 2 - UPSaftyKeyboard.l(UPSaftyKeyboard.this) - UPSaftyKeyboard.m(UPSaftyKeyboard.this) - UPSaftyKeyboard.n(UPSaftyKeyboard.this) - UPSaftyKeyboard.o(UPSaftyKeyboard.this)) / 3);
      }
      UPSaftyKeyboard.b(UPSaftyKeyboard.this, (UPSaftyKeyboard.p(UPSaftyKeyboard.this) - UPSaftyKeyboard.q(UPSaftyKeyboard.this) - UPSaftyKeyboard.r(UPSaftyKeyboard.this) - UPSaftyKeyboard.s(UPSaftyKeyboard.this) - UPSaftyKeyboard.t(UPSaftyKeyboard.this) - UPSaftyKeyboard.u(UPSaftyKeyboard.this) - UPSaftyKeyboard.v(UPSaftyKeyboard.this) * 3) / 4);
      paramViewGroup = new ImageButton(UPSaftyKeyboard.w(UPSaftyKeyboard.this));
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(UPSaftyKeyboard.x(UPSaftyKeyboard.this), UPSaftyKeyboard.y(UPSaftyKeyboard.this)));
      paramView = new TextView(UPSaftyKeyboard.w(UPSaftyKeyboard.this));
      paramView.setTextColor(UPSaftyKeyboard.z(UPSaftyKeyboard.this));
      paramView.setTextSize(0, UPSaftyKeyboard.A(UPSaftyKeyboard.this));
      paramView.setGravity(17);
      paramView.setLayoutParams(new AbsListView.LayoutParams(UPSaftyKeyboard.x(UPSaftyKeyboard.this), UPSaftyKeyboard.y(UPSaftyKeyboard.this)));
      if (!UPSaftyKeyboard.B(UPSaftyKeyboard.this))
      {
        paramViewGroup.setSoundEffectsEnabled(false);
        paramView.setSoundEffectsEnabled(false);
      }
      long l = getItemId(paramInt);
      Object localObject = (String)getItem(paramInt);
      if (10L == l)
      {
        if ((UPSaftyKeyboard.C(UPSaftyKeyboard.this) != null) || (UPSaftyKeyboard.D(UPSaftyKeyboard.this) != null))
        {
          if (UPSaftyKeyboard.C(UPSaftyKeyboard.this) != null) {
            paramViewGroup.setImageDrawable(UPSaftyKeyboard.C(UPSaftyKeyboard.this));
          }
          if (UPSaftyKeyboard.D(UPSaftyKeyboard.this) != null) {
            paramViewGroup.setBackgroundDrawable(UPSaftyKeyboard.D(UPSaftyKeyboard.this).getConstantState().newDrawable());
          }
          if (!UPSaftyKeyboard.E(UPSaftyKeyboard.this))
          {
            paramViewGroup.setEnabled(false);
            return paramViewGroup;
          }
        }
        else
        {
          a(paramView);
          if (!UPSaftyKeyboard.E(UPSaftyKeyboard.this)) {
            return paramView;
          }
          paramView.setText((CharSequence)localObject);
          paramView.setId((int)getItemId(paramInt));
          paramView.setOnClickListener(UPSaftyKeyboard.this.a);
          return paramView;
        }
      }
      else
      {
        if (20L != l) {
          break label565;
        }
        if ((UPSaftyKeyboard.F(UPSaftyKeyboard.this) == null) && (UPSaftyKeyboard.G(UPSaftyKeyboard.this) == null)) {
          break label531;
        }
        if (UPSaftyKeyboard.F(UPSaftyKeyboard.this) != null) {
          paramViewGroup.setImageDrawable(UPSaftyKeyboard.F(UPSaftyKeyboard.this));
        }
        if (UPSaftyKeyboard.G(UPSaftyKeyboard.this) != null) {
          paramViewGroup.setBackgroundDrawable(UPSaftyKeyboard.G(UPSaftyKeyboard.this).getConstantState().newDrawable());
        }
      }
      for (;;)
      {
        paramViewGroup.setId((int)getItemId(paramInt));
        paramViewGroup.setOnClickListener(UPSaftyKeyboard.this.a);
        return paramViewGroup;
        label531:
        paramView.setText((CharSequence)localObject);
        a(paramView);
        paramView.setId((int)getItemId(paramInt));
        paramView.setOnClickListener(UPSaftyKeyboard.this.a);
        return paramView;
        label565:
        if (UPSaftyKeyboard.H(UPSaftyKeyboard.this) == null) {
          break;
        }
        int i = (int)l;
        if (UPSaftyKeyboard.H(UPSaftyKeyboard.this)[i] != null) {
          paramViewGroup.setImageDrawable(UPSaftyKeyboard.H(UPSaftyKeyboard.this)[i].getConstantState().newDrawable());
        }
        if ((UPSaftyKeyboard.J(UPSaftyKeyboard.this) != null) && (UPSaftyKeyboard.J(UPSaftyKeyboard.this)[i] != null)) {
          paramViewGroup.setBackgroundDrawable(UPSaftyKeyboard.J(UPSaftyKeyboard.this)[i].getConstantState().newDrawable());
        } else if (UPSaftyKeyboard.I(UPSaftyKeyboard.this) != null) {
          paramViewGroup.setBackgroundDrawable(UPSaftyKeyboard.I(UPSaftyKeyboard.this).getConstantState().newDrawable());
        }
      }
      paramView.setText(String.valueOf((int)l));
      if (UPSaftyKeyboard.I(UPSaftyKeyboard.this) != null) {
        paramView.setBackgroundDrawable(UPSaftyKeyboard.I(UPSaftyKeyboard.this).getConstantState().newDrawable());
      }
      for (;;)
      {
        paramView.setId((int)getItemId(paramInt));
        paramView.setOnClickListener(UPSaftyKeyboard.this.a);
        return paramView;
        paramViewGroup = new ColorDrawable(-1);
        localObject = new ColorDrawable(-7829368);
        UPSaftyKeyboard localUPSaftyKeyboard = UPSaftyKeyboard.this;
        paramView.setBackgroundDrawable(UPSaftyKeyboard.a(paramViewGroup, (Drawable)localObject));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/widget/UPSaftyKeyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */