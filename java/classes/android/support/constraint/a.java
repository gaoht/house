package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
{
  private static final int[] a = { 0, 4, 8 };
  private static SparseIntArray c = new SparseIntArray();
  private HashMap<Integer, a> b = new HashMap();
  
  static
  {
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    c.append(R.styleable.ConstraintSet_android_orientation, 27);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
    c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    c.append(R.styleable.ConstraintSet_android_layout_width, 23);
    c.append(R.styleable.ConstraintSet_android_layout_height, 21);
    c.append(R.styleable.ConstraintSet_android_visibility, 22);
    c.append(R.styleable.ConstraintSet_android_alpha, 43);
    c.append(R.styleable.ConstraintSet_android_elevation, 44);
    c.append(R.styleable.ConstraintSet_android_rotationX, 45);
    c.append(R.styleable.ConstraintSet_android_rotationY, 46);
    c.append(R.styleable.ConstraintSet_android_scaleX, 47);
    c.append(R.styleable.ConstraintSet_android_scaleY, 48);
    c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    c.append(R.styleable.ConstraintSet_android_translationX, 51);
    c.append(R.styleable.ConstraintSet_android_translationY, 52);
    c.append(R.styleable.ConstraintSet_android_translationZ, 53);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    c.append(R.styleable.ConstraintSet_android_id, 38);
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private a a(int paramInt)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt))) {
      this.b.put(Integer.valueOf(paramInt), new a(null));
    }
    return (a)this.b.get(Integer.valueOf(paramInt));
  }
  
  private a a(Context paramContext, AttributeSet paramAttributeSet)
  {
    a locala = new a(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    a(locala, paramContext);
    paramContext.recycle();
    return locala;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      a(paramArrayOfInt[0]).N = paramArrayOfFloat[0];
    }
    a(paramArrayOfInt[0]).P = paramInt5;
    connect(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramInt2 = paramArrayOfInt[paramInt1];
      connect(paramArrayOfInt[paramInt1], paramInt6, paramArrayOfInt[(paramInt1 - 1)], paramInt7, -1);
      connect(paramArrayOfInt[(paramInt1 - 1)], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
      if (paramArrayOfFloat != null) {
        a(paramArrayOfInt[paramInt1]).O = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
  }
  
  private void a(a parama, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (c.get(k))
      {
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      default: 
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(k) + "   " + c.get(k));
      }
      for (;;)
      {
        i += 1;
        break;
        parama.h = a(paramTypedArray, k, parama.h);
        continue;
        parama.i = a(paramTypedArray, k, parama.i);
        continue;
        parama.j = a(paramTypedArray, k, parama.j);
        continue;
        parama.k = a(paramTypedArray, k, parama.k);
        continue;
        parama.l = a(paramTypedArray, k, parama.l);
        continue;
        parama.m = a(paramTypedArray, k, parama.m);
        continue;
        parama.n = a(paramTypedArray, k, parama.n);
        continue;
        parama.o = a(paramTypedArray, k, parama.o);
        continue;
        parama.p = a(paramTypedArray, k, parama.p);
        continue;
        parama.x = paramTypedArray.getDimensionPixelOffset(k, parama.x);
        continue;
        parama.y = paramTypedArray.getDimensionPixelOffset(k, parama.y);
        continue;
        parama.e = paramTypedArray.getDimensionPixelOffset(k, parama.e);
        continue;
        parama.f = paramTypedArray.getDimensionPixelOffset(k, parama.f);
        continue;
        parama.g = paramTypedArray.getFloat(k, parama.g);
        continue;
        parama.z = paramTypedArray.getInt(k, parama.z);
        continue;
        parama.q = a(paramTypedArray, k, parama.q);
        continue;
        parama.r = a(paramTypedArray, k, parama.r);
        continue;
        parama.s = a(paramTypedArray, k, parama.s);
        continue;
        parama.n = a(paramTypedArray, k, parama.t);
        continue;
        parama.H = paramTypedArray.getDimensionPixelSize(k, parama.H);
        continue;
        parama.I = paramTypedArray.getDimensionPixelSize(k, parama.I);
        continue;
        parama.J = paramTypedArray.getDimensionPixelSize(k, parama.J);
        continue;
        parama.K = paramTypedArray.getDimensionPixelSize(k, parama.K);
        continue;
        parama.M = paramTypedArray.getDimensionPixelSize(k, parama.M);
        continue;
        parama.L = paramTypedArray.getDimensionPixelSize(k, parama.L);
        continue;
        parama.u = paramTypedArray.getFloat(k, parama.u);
        continue;
        parama.v = paramTypedArray.getFloat(k, parama.v);
        continue;
        parama.A = paramTypedArray.getDimensionPixelSize(k, parama.A);
        continue;
        parama.B = paramTypedArray.getDimensionPixelSize(k, parama.B);
        continue;
        parama.F = paramTypedArray.getDimensionPixelSize(k, parama.F);
        continue;
        parama.E = paramTypedArray.getDimensionPixelSize(k, parama.E);
        continue;
        parama.C = paramTypedArray.getDimensionPixelSize(k, parama.C);
        continue;
        parama.D = paramTypedArray.getDimensionPixelSize(k, parama.D);
        continue;
        parama.b = paramTypedArray.getLayoutDimension(k, parama.b);
        continue;
        parama.c = paramTypedArray.getLayoutDimension(k, parama.c);
        continue;
        parama.G = paramTypedArray.getInt(k, parama.G);
        parama.G = a[parama.G];
        continue;
        parama.R = paramTypedArray.getFloat(k, parama.R);
        continue;
        parama.S = true;
        parama.T = paramTypedArray.getFloat(k, parama.T);
        continue;
        parama.U = paramTypedArray.getFloat(k, parama.U);
        continue;
        parama.V = paramTypedArray.getFloat(k, parama.V);
        continue;
        parama.W = paramTypedArray.getFloat(k, parama.W);
        continue;
        parama.X = paramTypedArray.getFloat(k, parama.X);
        continue;
        parama.Y = paramTypedArray.getFloat(k, parama.Y);
        continue;
        parama.Z = paramTypedArray.getFloat(k, parama.Z);
        continue;
        parama.aa = paramTypedArray.getFloat(k, parama.aa);
        continue;
        parama.ab = paramTypedArray.getFloat(k, parama.ab);
        continue;
        parama.ac = paramTypedArray.getFloat(k, parama.ac);
        continue;
        parama.N = paramTypedArray.getFloat(k, parama.N);
        continue;
        parama.O = paramTypedArray.getFloat(k, parama.O);
        continue;
        parama.Q = paramTypedArray.getInt(k, parama.Q);
        continue;
        parama.P = paramTypedArray.getInt(k, parama.P);
        continue;
        parama.d = paramTypedArray.getResourceId(k, parama.d);
        continue;
        parama.w = paramTypedArray.getString(k);
        continue;
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(k) + "   " + c.get(k));
      }
    }
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 1: 
      return "left";
    case 2: 
      return "right";
    case 3: 
      return "top";
    case 4: 
      return "bottom";
    case 5: 
      return "baseline";
    case 6: 
      return "start";
    }
    return "end";
  }
  
  void a(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.b.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (this.b.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (a)this.b.get(Integer.valueOf(k));
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((a)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((a)localObject3).G);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((a)localObject3).R);
          ((View)localObject2).setRotationX(((a)localObject3).U);
          ((View)localObject2).setRotationY(((a)localObject3).V);
          ((View)localObject2).setScaleX(((a)localObject3).W);
          ((View)localObject2).setScaleY(((a)localObject3).X);
          ((View)localObject2).setPivotX(((a)localObject3).Y);
          ((View)localObject2).setPivotY(((a)localObject3).Z);
          ((View)localObject2).setTranslationX(((a)localObject3).aa);
          ((View)localObject2).setTranslationY(((a)localObject3).ab);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((a)localObject3).ac);
            if (((a)localObject3).S) {
              ((View)localObject2).setElevation(((a)localObject3).T);
            }
          }
        }
      }
      i += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Integer)((Iterator)localObject1).next();
      localObject2 = (a)this.b.get(localObject4);
      if (((a)localObject2).a)
      {
        localObject3 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject3).setId(((Integer)localObject4).intValue());
        localObject4 = paramConstraintLayout.b();
        ((a)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject4);
        paramConstraintLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
    }
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 1;
      connect(paramInt1, 1, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 2;; i = 1)
    {
      connect(paramInt1, 2, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 2, paramInt1, 1, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 1, paramInt1, 2, 0);
      }
      return;
      i = 2;
      break;
    }
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 6;
      connect(paramInt1, 6, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label76;
      }
    }
    label76:
    for (int i = 7;; i = 6)
    {
      connect(paramInt1, 7, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 7, paramInt1, 6, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 6, paramInt1, 7, 0);
      }
      return;
      i = 7;
      break;
    }
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 3;
      connect(paramInt1, 3, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 4;; i = 3)
    {
      connect(paramInt1, 4, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 4, paramInt1, 3, 0);
      }
      if (paramInt2 != 0) {
        connect(paramInt3, 3, paramInt1, 4, 0);
      }
      return;
      i = 4;
      break;
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    a(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if (paramInt7 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if ((paramFloat <= 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    }
    if ((paramInt3 == 1) || (paramInt3 == 2))
    {
      connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
      ((a)this.b.get(Integer.valueOf(paramInt1))).u = paramFloat;
      return;
    }
    if ((paramInt3 == 6) || (paramInt3 == 7))
    {
      connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
      ((a)this.b.get(Integer.valueOf(paramInt1))).u = paramFloat;
      return;
    }
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((a)this.b.get(Integer.valueOf(paramInt1))).v = paramFloat;
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((a)this.b.get(Integer.valueOf(paramInt1))).u = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((a)this.b.get(Integer.valueOf(paramInt1))).u = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((a)this.b.get(Integer.valueOf(paramInt1))).v = paramFloat;
  }
  
  public void clear(int paramInt)
  {
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    a locala;
    if (this.b.containsKey(Integer.valueOf(paramInt1))) {
      locala = (a)this.b.get(Integer.valueOf(paramInt1));
    }
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      locala.i = -1;
      locala.h = -1;
      locala.A = -1;
      locala.H = -1;
      return;
    case 2: 
      locala.k = -1;
      locala.j = -1;
      locala.B = -1;
      locala.J = -1;
      return;
    case 3: 
      locala.m = -1;
      locala.l = -1;
      locala.C = -1;
      locala.I = -1;
      return;
    case 4: 
      locala.n = -1;
      locala.o = -1;
      locala.D = -1;
      locala.K = -1;
      return;
    case 5: 
      locala.p = -1;
      return;
    case 6: 
      locala.q = -1;
      locala.r = -1;
      locala.F = -1;
      locala.M = -1;
      return;
    }
    locala.s = -1;
    locala.t = -1;
    locala.E = -1;
    locala.L = -1;
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    this.b.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (!this.b.containsKey(Integer.valueOf(k))) {
        this.b.put(Integer.valueOf(k), new a(null));
      }
      a locala = (a)this.b.get(Integer.valueOf(k));
      a.a(locala, k, localLayoutParams);
      locala.G = localView.getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        locala.R = localView.getAlpha();
        locala.U = localView.getRotationX();
        locala.V = localView.getRotationY();
        locala.W = localView.getScaleX();
        locala.X = localView.getScaleY();
        locala.Y = localView.getPivotX();
        locala.Z = localView.getPivotY();
        locala.aa = localView.getTranslationX();
        locala.ab = localView.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          locala.ac = localView.getTranslationZ();
          if (locala.S) {
            locala.T = localView.getElevation();
          }
        }
      }
      i += 1;
    }
  }
  
  public void clone(a parama)
  {
    this.b.clear();
    Iterator localIterator = parama.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.b.put(localInteger, ((a)parama.b.get(localInteger)).clone());
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt1))) {
      this.b.put(Integer.valueOf(paramInt1), new a(null));
    }
    a locala = (a)this.b.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(b(paramInt2) + " to " + b(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        locala.h = paramInt3;
        locala.i = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        locala.i = paramInt3;
        locala.h = -1;
        return;
      }
      throw new IllegalArgumentException("left to " + b(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        locala.j = paramInt3;
        locala.k = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        locala.k = paramInt3;
        locala.j = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        locala.l = paramInt3;
        locala.m = -1;
        locala.p = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        locala.m = paramInt3;
        locala.l = -1;
        locala.p = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        locala.o = paramInt3;
        locala.n = -1;
        locala.p = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        locala.n = paramInt3;
        locala.o = -1;
        locala.p = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        locala.p = paramInt3;
        locala.o = -1;
        locala.n = -1;
        locala.l = -1;
        locala.m = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        locala.r = paramInt3;
        locala.q = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        locala.q = paramInt3;
        locala.r = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      locala.t = paramInt3;
      locala.s = -1;
      return;
    }
    if (paramInt4 == 6)
    {
      locala.s = paramInt3;
      locala.t = -1;
      return;
    }
    throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt1))) {
      this.b.put(Integer.valueOf(paramInt1), new a(null));
    }
    a locala = (a)this.b.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(b(paramInt2) + " to " + b(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        locala.h = paramInt3;
        locala.i = -1;
      }
      for (;;)
      {
        locala.A = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        locala.i = paramInt3;
        locala.h = -1;
      }
      throw new IllegalArgumentException("Left to " + b(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        locala.j = paramInt3;
        locala.k = -1;
      }
      for (;;)
      {
        locala.B = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        locala.k = paramInt3;
        locala.j = -1;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        locala.l = paramInt3;
        locala.m = -1;
      }
      for (locala.p = -1;; locala.p = -1)
      {
        locala.C = paramInt5;
        return;
        if (paramInt4 != 4) {
          break;
        }
        locala.m = paramInt3;
        locala.l = -1;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        locala.o = paramInt3;
        locala.n = -1;
      }
      for (locala.p = -1;; locala.p = -1)
      {
        locala.D = paramInt5;
        return;
        if (paramInt4 != 3) {
          break;
        }
        locala.n = paramInt3;
        locala.o = -1;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        locala.p = paramInt3;
        locala.o = -1;
        locala.n = -1;
        locala.l = -1;
        locala.m = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        locala.r = paramInt3;
        locala.q = -1;
      }
      for (;;)
      {
        locala.F = paramInt5;
        return;
        if (paramInt4 != 7) {
          break;
        }
        locala.q = paramInt3;
        locala.r = -1;
      }
      throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      locala.t = paramInt3;
      locala.s = -1;
    }
    for (;;)
    {
      locala.E = paramInt5;
      return;
      if (paramInt4 != 6) {
        break;
      }
      locala.s = paramInt3;
      locala.t = -1;
    }
    throw new IllegalArgumentException("right to " + b(paramInt4) + " undefined");
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    a(paramInt1).ae = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    a(paramInt1).ad = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    a(paramInt1).c = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    a(paramInt1).ag = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    a(paramInt1).af = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    a(paramInt1).ai = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    a(paramInt1).ah = paramInt2;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    a(paramInt1).b = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    a locala = a(paramInt1);
    locala.a = true;
    locala.z = paramInt2;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      a(paramArrayOfInt[0]).N = paramArrayOfFloat[0];
    }
    a(paramArrayOfInt[0]).Q = paramInt5;
    connect(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramInt2 = paramArrayOfInt[paramInt1];
      connect(paramArrayOfInt[paramInt1], 3, paramArrayOfInt[(paramInt1 - 1)], 4, 0);
      connect(paramArrayOfInt[(paramInt1 - 1)], 4, paramArrayOfInt[paramInt1], 3, 0);
      if (paramArrayOfFloat != null) {
        a(paramArrayOfInt[paramInt1]).N = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return a(paramInt).S;
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    for (;;)
    {
      try
      {
        paramInt = localXmlResourceParser.getEventType();
      }
      catch (XmlPullParserException paramContext)
      {
        paramContext.printStackTrace();
        return;
        String str = localXmlResourceParser.getName();
        a locala = a(paramContext, Xml.asAttributeSet(localXmlResourceParser));
        if (!str.equalsIgnoreCase("Guideline")) {
          continue;
        }
        locala.a = true;
        this.b.put(Integer.valueOf(locala.d), locala);
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      paramInt = localXmlResourceParser.next();
      break label108;
      localXmlResourceParser.getName();
      continue;
      label108:
      if (paramInt != 1) {
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    a locala;
    int i;
    if (this.b.containsKey(Integer.valueOf(paramInt)))
    {
      locala = (a)this.b.get(Integer.valueOf(paramInt));
      i = locala.i;
      j = locala.j;
      if ((i == -1) && (j == -1)) {
        break label153;
      }
      if ((i == -1) || (j == -1)) {
        break label93;
      }
      connect(i, 2, j, 1, 0);
      connect(j, 1, i, 2, 0);
    }
    for (;;)
    {
      clear(paramInt, 1);
      clear(paramInt, 2);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (locala.k != -1) {
          connect(i, 2, locala.k, 2, 0);
        } else if (locala.h != -1) {
          connect(j, 1, locala.h, 1, 0);
        }
      }
    }
    label153:
    int j = locala.q;
    int k = locala.s;
    if ((j != -1) || (k != -1))
    {
      if ((j == -1) || (k == -1)) {
        break label227;
      }
      connect(j, 7, k, 6, 0);
      connect(k, 6, i, 7, 0);
    }
    for (;;)
    {
      clear(paramInt, 6);
      clear(paramInt, 7);
      return;
      label227:
      if ((i != -1) || (k != -1)) {
        if (locala.k != -1) {
          connect(i, 7, locala.k, 7, 0);
        } else if (locala.h != -1) {
          connect(k, 6, locala.h, 6, 0);
        }
      }
    }
  }
  
  public void removeFromVerticalChain(int paramInt)
  {
    a locala;
    int i;
    int j;
    if (this.b.containsKey(Integer.valueOf(paramInt)))
    {
      locala = (a)this.b.get(Integer.valueOf(paramInt));
      i = locala.m;
      j = locala.n;
      if ((i != -1) || (j != -1))
      {
        if ((i == -1) || (j == -1)) {
          break label93;
        }
        connect(i, 4, j, 3, 0);
        connect(j, 3, i, 4, 0);
      }
    }
    for (;;)
    {
      clear(paramInt, 3);
      clear(paramInt, 4);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (locala.o != -1) {
          connect(i, 4, locala.o, 4, 0);
        } else if (locala.l != -1) {
          connect(j, 3, locala.l, 3, 0);
        }
      }
    }
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    a(paramInt).R = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    a(paramInt).S = paramBoolean;
  }
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    a(paramInt).w = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    a(paramInt).T = paramFloat;
    a(paramInt).S = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    a locala = a(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      locala.H = paramInt3;
      return;
    case 2: 
      locala.J = paramInt3;
      return;
    case 3: 
      locala.I = paramInt3;
      return;
    case 4: 
      locala.K = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      locala.M = paramInt3;
      return;
    }
    locala.L = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    a(paramInt1).e = paramInt2;
    a(paramInt1).f = -1;
    a(paramInt1).g = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    a(paramInt1).f = paramInt2;
    a(paramInt1).e = -1;
    a(paramInt1).g = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    a(paramInt).g = paramFloat;
    a(paramInt).f = -1;
    a(paramInt).e = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    a(paramInt).u = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    a(paramInt1).P = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    a(paramInt).O = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    a locala = a(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      locala.A = paramInt3;
      return;
    case 2: 
      locala.B = paramInt3;
      return;
    case 3: 
      locala.C = paramInt3;
      return;
    case 4: 
      locala.D = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      locala.F = paramInt3;
      return;
    }
    locala.E = paramInt3;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    a(paramInt).U = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    a(paramInt).V = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    a(paramInt).W = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    a(paramInt).X = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    a locala = a(paramInt);
    locala.Z = paramFloat2;
    locala.Y = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    a(paramInt).Y = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    a(paramInt).Z = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    a locala = a(paramInt);
    locala.aa = paramFloat1;
    locala.ab = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    a(paramInt).aa = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    a(paramInt).ab = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    a(paramInt).ac = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    a(paramInt).v = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    a(paramInt1).Q = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    a(paramInt).N = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    a(paramInt1).G = paramInt2;
  }
  
  private static class a
  {
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = -1;
    public int G = 0;
    public int H = -1;
    public int I = -1;
    public int J = -1;
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public float N = 0.0F;
    public float O = 0.0F;
    public int P = 0;
    public int Q = 0;
    public float R = 1.0F;
    public boolean S = false;
    public float T = 0.0F;
    public float U = 0.0F;
    public float V = 0.0F;
    public float W = 1.0F;
    public float X = 1.0F;
    public float Y = 0.0F;
    public float Z = 0.0F;
    boolean a = false;
    public float aa = 0.0F;
    public float ab = 0.0F;
    public float ac = 0.0F;
    public int ad = -1;
    public int ae = -1;
    public int af = -1;
    public int ag = -1;
    public int ah = -1;
    public int ai = -1;
    public int b;
    public int c;
    int d;
    public int e = -1;
    public int f = -1;
    public float g = -1.0F;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public float u = 0.5F;
    public float v = 0.5F;
    public String w = null;
    public int x = -1;
    public int y = -1;
    public int z = -1;
    
    private void a(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      this.d = paramInt;
      this.h = paramLayoutParams.d;
      this.i = paramLayoutParams.e;
      this.j = paramLayoutParams.f;
      this.k = paramLayoutParams.g;
      this.l = paramLayoutParams.h;
      this.m = paramLayoutParams.i;
      this.n = paramLayoutParams.j;
      this.o = paramLayoutParams.k;
      this.p = paramLayoutParams.l;
      this.q = paramLayoutParams.m;
      this.r = paramLayoutParams.n;
      this.s = paramLayoutParams.o;
      this.t = paramLayoutParams.p;
      this.u = paramLayoutParams.w;
      this.v = paramLayoutParams.x;
      this.w = paramLayoutParams.y;
      this.x = paramLayoutParams.L;
      this.y = paramLayoutParams.M;
      this.z = paramLayoutParams.N;
      this.g = paramLayoutParams.c;
      this.e = paramLayoutParams.a;
      this.f = paramLayoutParams.b;
      this.b = paramLayoutParams.width;
      this.c = paramLayoutParams.height;
      this.A = paramLayoutParams.leftMargin;
      this.B = paramLayoutParams.rightMargin;
      this.C = paramLayoutParams.topMargin;
      this.D = paramLayoutParams.bottomMargin;
      this.N = paramLayoutParams.C;
      this.O = paramLayoutParams.B;
      this.Q = paramLayoutParams.E;
      this.P = paramLayoutParams.D;
      this.ad = paramLayoutParams.F;
      this.ae = paramLayoutParams.G;
      this.af = paramLayoutParams.J;
      this.ag = paramLayoutParams.K;
      this.ah = paramLayoutParams.H;
      this.ai = paramLayoutParams.I;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.E = paramLayoutParams.getMarginEnd();
        this.F = paramLayoutParams.getMarginStart();
      }
    }
    
    public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.d = this.h;
      paramLayoutParams.e = this.i;
      paramLayoutParams.f = this.j;
      paramLayoutParams.g = this.k;
      paramLayoutParams.h = this.l;
      paramLayoutParams.i = this.m;
      paramLayoutParams.j = this.n;
      paramLayoutParams.k = this.o;
      paramLayoutParams.l = this.p;
      paramLayoutParams.m = this.q;
      paramLayoutParams.n = this.r;
      paramLayoutParams.o = this.s;
      paramLayoutParams.p = this.t;
      paramLayoutParams.leftMargin = this.A;
      paramLayoutParams.rightMargin = this.B;
      paramLayoutParams.topMargin = this.C;
      paramLayoutParams.bottomMargin = this.D;
      paramLayoutParams.u = this.M;
      paramLayoutParams.v = this.L;
      paramLayoutParams.w = this.u;
      paramLayoutParams.x = this.v;
      paramLayoutParams.y = this.w;
      paramLayoutParams.L = this.x;
      paramLayoutParams.M = this.y;
      paramLayoutParams.C = this.N;
      paramLayoutParams.B = this.O;
      paramLayoutParams.E = this.Q;
      paramLayoutParams.D = this.P;
      paramLayoutParams.F = this.ad;
      paramLayoutParams.G = this.ae;
      paramLayoutParams.J = this.af;
      paramLayoutParams.K = this.ag;
      paramLayoutParams.H = this.ah;
      paramLayoutParams.I = this.ai;
      paramLayoutParams.N = this.z;
      paramLayoutParams.c = this.g;
      paramLayoutParams.a = this.e;
      paramLayoutParams.b = this.f;
      paramLayoutParams.width = this.b;
      paramLayoutParams.height = this.c;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.F);
        paramLayoutParams.setMarginEnd(this.E);
      }
      paramLayoutParams.validate();
    }
    
    public a clone()
    {
      a locala = new a();
      locala.a = this.a;
      locala.b = this.b;
      locala.c = this.c;
      locala.e = this.e;
      locala.f = this.f;
      locala.g = this.g;
      locala.h = this.h;
      locala.i = this.i;
      locala.j = this.j;
      locala.k = this.k;
      locala.l = this.l;
      locala.m = this.m;
      locala.n = this.n;
      locala.o = this.o;
      locala.p = this.p;
      locala.q = this.q;
      locala.r = this.r;
      locala.s = this.s;
      locala.t = this.t;
      locala.u = this.u;
      locala.v = this.v;
      locala.w = this.w;
      locala.x = this.x;
      locala.y = this.y;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.z = this.z;
      locala.A = this.A;
      locala.B = this.B;
      locala.C = this.C;
      locala.D = this.D;
      locala.E = this.E;
      locala.F = this.F;
      locala.G = this.G;
      locala.H = this.H;
      locala.I = this.I;
      locala.J = this.J;
      locala.K = this.K;
      locala.L = this.L;
      locala.M = this.M;
      locala.N = this.N;
      locala.O = this.O;
      locala.P = this.P;
      locala.Q = this.Q;
      locala.R = this.R;
      locala.S = this.S;
      locala.T = this.T;
      locala.U = this.U;
      locala.V = this.V;
      locala.W = this.W;
      locala.X = this.X;
      locala.Y = this.Y;
      locala.Z = this.Z;
      locala.aa = this.aa;
      locala.ab = this.ab;
      locala.ac = this.ac;
      locala.ad = this.ad;
      locala.ae = this.ae;
      locala.af = this.af;
      locala.ag = this.ag;
      locala.ah = this.ah;
      locala.ai = this.ai;
      return locala;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */