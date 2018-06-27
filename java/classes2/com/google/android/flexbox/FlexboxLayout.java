package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private Drawable f;
  private Drawable g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int[] l;
  private SparseIntArray m;
  private List<a> n = new ArrayList();
  private boolean[] o;
  
  public FlexboxLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlexboxLayout, paramInt, 0);
    this.a = paramContext.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
    this.b = paramContext.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
    this.c = paramContext.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
    this.d = paramContext.getInt(R.styleable.FlexboxLayout_alignItems, 4);
    this.e = paramContext.getInt(R.styleable.FlexboxLayout_alignContent, 5);
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDivider, 0);
    if (paramInt != 0)
    {
      this.i = paramInt;
      this.h = paramInt;
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
    if (paramInt != 0) {
      this.i = paramInt;
    }
    paramInt = paramContext.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
    if (paramInt != 0) {
      this.h = paramInt;
    }
    paramContext.recycle();
  }
  
  private int a(int paramInt1, int paramInt2, a parama, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if ((parama.j <= 0.0F) || (paramInt4 < parama.e))
    {
      i3 = paramInt6 + parama.h;
      return i3;
    }
    int i6 = parama.e;
    float f3 = (paramInt4 - parama.e) / parama.j;
    parama.e = (parama.f + paramInt5);
    if (!paramBoolean) {
      parama.g = Integer.MIN_VALUE;
    }
    int i1 = 0;
    int i2 = paramInt6;
    int i3 = 0;
    float f1 = 0.0F;
    int i5 = 0;
    View localView;
    label111:
    label139:
    LayoutParams localLayoutParams;
    float f2;
    label206:
    int i4;
    label255:
    int i7;
    if (i5 < parama.h)
    {
      localView = getReorderedChildAt(i2);
      if (localView == null) {}
      for (;;)
      {
        i5 += 1;
        break;
        if (localView.getVisibility() != 8) {
          break label139;
        }
        i2 += 1;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (b(paramInt3))
      {
        if (this.o[i2] != 0) {
          break label726;
        }
        f2 = localView.getMeasuredWidth() + localLayoutParams.b * f3;
        if (i5 != parama.h - 1) {
          break label723;
        }
        f2 = f1 + f2;
        f1 = 0.0F;
        i4 = Math.round(f2);
        if (i4 > localLayoutParams.h)
        {
          i1 = 1;
          i4 = localLayoutParams.h;
          this.o[i2] = true;
          parama.j -= localLayoutParams.b;
          i7 = b(paramInt2, localLayoutParams);
          localView.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i7);
          i3 = Math.max(i3, localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        }
      }
    }
    label340:
    label473:
    label522:
    label723:
    label726:
    for (;;)
    {
      i4 = parama.e;
      i7 = localView.getMeasuredWidth();
      int i8 = localLayoutParams.leftMargin;
      parama.e = (localLayoutParams.rightMargin + (i7 + i8) + i4);
      parama.g = Math.max(parama.g, i3);
      i2 += 1;
      break label111;
      f1 += f2 - i4;
      if (f1 > 1.0D)
      {
        i4 += 1;
        f1 = (float)(f1 - 1.0D);
        break label255;
      }
      if (f1 < -1.0D)
      {
        i4 -= 1;
        f1 = (float)(f1 + 1.0D);
        break label255;
        if (this.o[i2] == 0)
        {
          f2 = localView.getMeasuredHeight() + localLayoutParams.b * f3;
          if (i5 == parama.h - 1)
          {
            f2 = f1 + f2;
            f1 = 0.0F;
            i4 = Math.round(f2);
            if (i4 > localLayoutParams.i)
            {
              i1 = 1;
              i4 = localLayoutParams.i;
              this.o[i2] = true;
              parama.j -= localLayoutParams.b;
              localView.measure(a(paramInt1, localLayoutParams), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
              i3 = Math.max(i3, localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
            }
          }
        }
        for (;;)
        {
          i4 = parama.e;
          i7 = localView.getMeasuredHeight();
          i8 = localLayoutParams.topMargin;
          parama.e = (localLayoutParams.bottomMargin + (i7 + i8) + i4);
          break label340;
          f1 += f2 - i4;
          if (f1 > 1.0D)
          {
            i4 += 1;
            f1 = (float)(f1 - 1.0D);
            break label522;
          }
          if (f1 < -1.0D)
          {
            i4 -= 1;
            f1 = (float)(f1 + 1.0D);
            break label522;
            i3 = i2;
            if (i1 == 0) {
              break;
            }
            i3 = i2;
            if (i6 == parama.e) {
              break;
            }
            a(paramInt1, paramInt2, parama, paramInt3, paramInt4, paramInt5, paramInt6, true);
            return i2;
          }
          break label522;
          break label473;
        }
      }
      break label255;
      break label206;
    }
  }
  
  private int a(int paramInt, LayoutParams paramLayoutParams)
  {
    int i1 = getChildMeasureSpec(paramInt, getPaddingLeft() + getPaddingRight() + paramLayoutParams.leftMargin + paramLayoutParams.rightMargin, paramLayoutParams.width);
    int i2 = View.MeasureSpec.getSize(i1);
    if (i2 > paramLayoutParams.h) {
      paramInt = View.MeasureSpec.makeMeasureSpec(paramLayoutParams.h, View.MeasureSpec.getMode(i1));
    }
    do
    {
      return paramInt;
      paramInt = i1;
    } while (i2 >= paramLayoutParams.f);
    return View.MeasureSpec.makeMeasureSpec(paramLayoutParams.f, View.MeasureSpec.getMode(i1));
  }
  
  private List<a> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramInt);
    int i1 = 0;
    while (i1 < paramInt)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i1).getLayoutParams();
      a locala = new a(null);
      locala.b = localLayoutParams.a;
      locala.a = i1;
      localArrayList.add(locala);
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt1);
    int i1 = 0;
    this.n.clear();
    int i9 = getChildCount();
    int i10 = ViewCompat.getPaddingStart(this);
    int i11 = ViewCompat.getPaddingEnd(this);
    int i4 = Integer.MIN_VALUE;
    Object localObject1 = new a();
    int i2 = 0;
    ((a)localObject1).e = (i10 + i11);
    int i3 = 0;
    Object localObject2;
    label156:
    Object localObject3;
    int i6;
    int i5;
    if (i3 < i9)
    {
      localObject2 = getReorderedChildAt(i3);
      if (localObject2 == null) {
        a(i3, i9, (a)localObject1);
      }
      for (;;)
      {
        i3 += 1;
        break;
        if (((View)localObject2).getVisibility() != 8) {
          break label156;
        }
        ((a)localObject1).h += 1;
        ((a)localObject1).i += 1;
        a(i3, i9, (a)localObject1);
      }
      localObject3 = (LayoutParams)((View)localObject2).getLayoutParams();
      if (((LayoutParams)localObject3).d == 4) {
        ((a)localObject1).m.add(Integer.valueOf(i3));
      }
      i6 = ((LayoutParams)localObject3).width;
      i5 = i6;
      if (((LayoutParams)localObject3).e != -1.0F)
      {
        i5 = i6;
        if (i7 == 1073741824) {
          i5 = Math.round(i8 * ((LayoutParams)localObject3).e);
        }
      }
      ((View)localObject2).measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + ((LayoutParams)localObject3).leftMargin + ((LayoutParams)localObject3).rightMargin, i5), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + ((LayoutParams)localObject3).topMargin + ((LayoutParams)localObject3).bottomMargin, ((LayoutParams)localObject3).height));
      a((View)localObject2);
      i6 = ViewCompat.combineMeasuredStates(i1, ViewCompat.getMeasuredState((View)localObject2));
      i1 = Math.max(i4, ((View)localObject2).getMeasuredHeight() + ((LayoutParams)localObject3).topMargin + ((LayoutParams)localObject3).bottomMargin);
      i4 = ((a)localObject1).e;
      i5 = ((View)localObject2).getMeasuredWidth();
      int i12 = ((LayoutParams)localObject3).leftMargin;
      if (a(i7, i8, i4, ((LayoutParams)localObject3).rightMargin + (i5 + i12), (LayoutParams)localObject3, i3, i2))
      {
        if (((a)localObject1).getItemCountNotGone() > 0) {
          a((a)localObject1);
        }
        localObject1 = new a();
        ((a)localObject1).h = 1;
        ((a)localObject1).e = (i10 + i11);
        i1 = ((View)localObject2).getMeasuredHeight();
        i2 = ((LayoutParams)localObject3).topMargin;
        i2 = ((LayoutParams)localObject3).bottomMargin + (i1 + i2);
        i1 = 0;
        label458:
        ((a)localObject1).e += ((View)localObject2).getMeasuredWidth() + ((LayoutParams)localObject3).leftMargin + ((LayoutParams)localObject3).rightMargin;
        ((a)localObject1).j += ((LayoutParams)localObject3).b;
        ((a)localObject1).k += ((LayoutParams)localObject3).c;
        ((a)localObject1).g = Math.max(((a)localObject1).g, i2);
        if (d(i3, i1))
        {
          ((a)localObject1).e += this.k;
          ((a)localObject1).f += this.k;
        }
        if (this.b == 2) {
          break label667;
        }
        i4 = ((a)localObject1).l;
        i5 = ((View)localObject2).getBaseline();
      }
      for (((a)localObject1).l = Math.max(i4, ((LayoutParams)localObject3).topMargin + i5);; ((a)localObject1).l = Math.max(i4, ((LayoutParams)localObject3).bottomMargin + (i5 - i12)))
      {
        a(i3, i9, (a)localObject1);
        i5 = i1;
        i1 = i6;
        i4 = i2;
        i2 = i5;
        break;
        ((a)localObject1).h += 1;
        i4 = i2 + 1;
        i2 = i1;
        i1 = i4;
        break label458;
        label667:
        i4 = ((a)localObject1).l;
        i5 = ((View)localObject2).getMeasuredHeight();
        i12 = ((View)localObject2).getBaseline();
      }
    }
    a(this.a, paramInt1, paramInt2);
    if (this.d == 3)
    {
      i2 = 0;
      localObject1 = this.n.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        i4 = i2;
        i3 = Integer.MIN_VALUE;
        if (i4 < ((a)localObject2).h + i2)
        {
          localObject3 = getReorderedChildAt(i4);
          LayoutParams localLayoutParams = (LayoutParams)((View)localObject3).getLayoutParams();
          if (this.b != 2)
          {
            i5 = Math.max(((a)localObject2).l - ((View)localObject3).getBaseline(), localLayoutParams.topMargin);
            i6 = ((View)localObject3).getHeight();
          }
          for (i3 = Math.max(i3, localLayoutParams.bottomMargin + (i6 + i5));; i3 = Math.max(i3, localLayoutParams.topMargin + i6 + i5))
          {
            i4 += 1;
            break;
            i5 = Math.max(((a)localObject2).l - ((View)localObject3).getMeasuredHeight() + ((View)localObject3).getBaseline(), localLayoutParams.bottomMargin);
            i6 = ((View)localObject3).getHeight();
          }
        }
        ((a)localObject2).g = i3;
        i2 += ((a)localObject2).h;
      }
    }
    a(this.a, paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    c(this.a, this.d);
    b(this.a, paramInt1, paramInt2, i1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    int i1;
    int i3;
    Iterator localIterator;
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("Invalid flex direction: " + paramInt1);
    case 0: 
    case 1: 
      i2 = View.MeasureSpec.getMode(paramInt2);
      i1 = View.MeasureSpec.getSize(paramInt2);
      if (i2 == 1073741824)
      {
        i3 = getPaddingLeft() + getPaddingRight();
        i2 = i1;
        localIterator = this.n.iterator();
        i1 = 0;
      }
      break;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      a locala = (a)localIterator.next();
      if (locala.e < i2)
      {
        i1 = a(paramInt2, paramInt3, locala, paramInt1, i2, i3, i1, false);
        continue;
        i1 = getLargestMainSize();
        break;
        i2 = View.MeasureSpec.getMode(paramInt3);
        i1 = View.MeasureSpec.getSize(paramInt3);
        if (i2 == 1073741824) {}
        for (;;)
        {
          i3 = getPaddingTop() + getPaddingBottom();
          i2 = i1;
          break;
          i1 = getLargestMainSize();
        }
      }
      i1 = b(paramInt2, paramInt3, locala, paramInt1, i2, i3, i1, false);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("Invalid flex direction: " + paramInt1);
    case 0: 
    case 1: 
      paramInt2 = View.MeasureSpec.getMode(paramInt3);
      paramInt1 = View.MeasureSpec.getSize(paramInt3);
      if (paramInt2 == 1073741824)
      {
        paramInt2 = getSumOfCrossSize() + paramInt4;
        if (this.n.size() != 1) {
          break label133;
        }
        ((a)this.n.get(0)).g = (paramInt1 - paramInt4);
      }
      break;
    }
    label133:
    float f5;
    do
    {
      do
      {
        return;
        paramInt3 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        paramInt2 = paramInt3;
        break;
      } while ((this.n.size() < 2) || (paramInt2 >= paramInt1));
      switch (this.e)
      {
      default: 
        return;
      case 1: 
        localObject = new a();
        ((a)localObject).g = (paramInt1 - paramInt2);
        this.n.add(0, localObject);
        return;
      case 5: 
        f5 = (paramInt1 - paramInt2) / this.n.size();
        paramInt3 = this.n.size();
        paramInt2 = 0;
        f1 = 0.0F;
      }
    } while (paramInt2 >= paramInt3);
    Object localObject = (a)this.n.get(paramInt2);
    float f4 = ((a)localObject).g + f5;
    float f3 = f4;
    float f2 = f1;
    if (paramInt2 == this.n.size() - 1)
    {
      f3 = f4 + f1;
      f2 = 0.0F;
    }
    paramInt1 = Math.round(f3);
    float f1 = f2 + (f3 - paramInt1);
    if (f1 > 1.0F)
    {
      paramInt1 += 1;
      f1 -= 1.0F;
    }
    for (;;)
    {
      ((a)localObject).g = paramInt1;
      paramInt2 += 1;
      break;
      if (f1 < -1.0F)
      {
        paramInt1 -= 1;
        f1 += 1.0F;
        continue;
        paramInt1 = (paramInt1 - paramInt2) / (this.n.size() * 2);
        localObject = new ArrayList();
        a locala1 = new a();
        locala1.g = paramInt1;
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext())
        {
          a locala2 = (a)localIterator.next();
          ((List)localObject).add(locala1);
          ((List)localObject).add(locala2);
          ((List)localObject).add(locala1);
        }
        this.n = ((List)localObject);
        return;
        f3 = (paramInt1 - paramInt2) / (this.n.size() - 1);
        localObject = new ArrayList();
        paramInt2 = this.n.size();
        paramInt1 = 0;
        f1 = 0.0F;
        if (paramInt1 < paramInt2)
        {
          ((List)localObject).add((a)this.n.get(paramInt1));
          if (paramInt1 == this.n.size() - 1) {
            break label851;
          }
          locala1 = new a();
          if (paramInt1 == this.n.size() - 2)
          {
            locala1.g = Math.round(f3 + f1);
            f1 = 0.0F;
            label620:
            f2 = f1 + (f3 - locala1.g);
            if (f2 <= 1.0F) {
              break label689;
            }
            locala1.g += 1;
            f1 = f2 - 1.0F;
            label659:
            ((List)localObject).add(locala1);
          }
        }
        label689:
        label851:
        for (;;)
        {
          paramInt1 += 1;
          break;
          locala1.g = Math.round(f3);
          break label620;
          f1 = f2;
          if (f2 >= -1.0F) {
            break label659;
          }
          locala1.g -= 1;
          f1 = f2 + 1.0F;
          break label659;
          this.n = ((List)localObject);
          return;
          paramInt1 = (paramInt1 - paramInt2) / 2;
          localObject = new ArrayList();
          locala1 = new a();
          locala1.g = paramInt1;
          paramInt2 = this.n.size();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            if (paramInt1 == 0) {
              ((List)localObject).add(locala1);
            }
            ((List)localObject).add((a)this.n.get(paramInt1));
            if (paramInt1 == this.n.size() - 1) {
              ((List)localObject).add(locala1);
            }
            paramInt1 += 1;
          }
          this.n = ((List)localObject);
          return;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, a parama)
  {
    if ((paramInt1 == paramInt2 - 1) && (parama.getItemCountNotGone() != 0)) {
      a(parama);
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g == null) {
      return;
    }
    this.g.setBounds(paramInt1, paramInt2, this.k + paramInt1, paramInt2 + paramInt3);
    this.g.draw(paramCanvas);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    int i5 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i6 = Math.max(0, getWidth() - i2 - i5);
    int i7 = this.n.size();
    i2 = 0;
    if (i2 < i7)
    {
      a locala = (a)this.n.get(i2);
      int i3 = 0;
      while (i3 < locala.h)
      {
        View localView = getReorderedChildAt(i1);
        int i4 = i1;
        if (localView != null)
        {
          if (localView.getVisibility() == 8) {
            i4 = i1;
          }
        }
        else
        {
          i3 += 1;
          i1 = i4;
          continue;
        }
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (d(i1, i3))
        {
          if (paramBoolean1)
          {
            i4 = localView.getRight() + localLayoutParams.rightMargin;
            label163:
            a(paramCanvas, i4, locala.b, locala.g);
          }
        }
        else if ((i3 == locala.h - 1) && ((this.i & 0x4) > 0)) {
          if (!paramBoolean1) {
            break label270;
          }
        }
        for (i4 = localView.getLeft() - localLayoutParams.leftMargin - this.k;; i4 = localLayoutParams.rightMargin + i4)
        {
          a(paramCanvas, i4, locala.b, locala.g);
          i4 = i1 + 1;
          break;
          i4 = localView.getLeft() - localLayoutParams.leftMargin - this.k;
          break label163;
          label270:
          i4 = localView.getRight();
        }
      }
      if (c(i2))
      {
        if (paramBoolean2)
        {
          i3 = locala.d;
          label310:
          b(paramCanvas, i5, i3, i6);
        }
      }
      else if ((e(i2)) && ((this.h & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label390;
        }
      }
      label390:
      for (i3 = locala.b - this.j;; i3 = locala.d)
      {
        b(paramCanvas, i5, i3, i6);
        i2 += 1;
        break;
        i3 = locala.b - this.j;
        break label310;
      }
    }
  }
  
  private void a(View paramView)
  {
    int i3 = 1;
    int i1 = 0;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredWidth();
    int i4 = paramView.getMeasuredHeight();
    if (paramView.getMeasuredWidth() < localLayoutParams.f)
    {
      i2 = localLayoutParams.f;
      i1 = 1;
      if (i4 >= localLayoutParams.g) {
        break label106;
      }
      i1 = localLayoutParams.g;
    }
    for (;;)
    {
      if (i3 != 0) {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
      }
      return;
      if (paramView.getMeasuredWidth() <= localLayoutParams.h) {
        break;
      }
      i2 = localLayoutParams.h;
      i1 = 1;
      break;
      label106:
      if (i4 > localLayoutParams.i)
      {
        i1 = localLayoutParams.i;
      }
      else
      {
        i3 = i4;
        i4 = i1;
        i1 = i3;
        i3 = i4;
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt = Math.max(paramInt - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 0);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
  }
  
  private void a(View paramView, a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.d != -1) {
      paramInt2 = localLayoutParams.d;
    }
    int i1 = parama.g;
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
    case 4: 
      if (paramInt1 != 2)
      {
        paramView.layout(paramInt3, localLayoutParams.topMargin + paramInt4, paramInt5, localLayoutParams.topMargin + paramInt6);
        return;
      }
      paramView.layout(paramInt3, paramInt4 - localLayoutParams.bottomMargin, paramInt5, paramInt6 - localLayoutParams.bottomMargin);
      return;
    case 3: 
      if (paramInt1 != 2)
      {
        paramInt1 = Math.max(parama.l - paramView.getBaseline(), localLayoutParams.topMargin);
        paramView.layout(paramInt3, paramInt4 + paramInt1, paramInt5, paramInt1 + paramInt6);
        return;
      }
      paramInt1 = Math.max(parama.l - paramView.getMeasuredHeight() + paramView.getBaseline(), localLayoutParams.bottomMargin);
      paramView.layout(paramInt3, paramInt4 - paramInt1, paramInt5, paramInt6 - paramInt1);
      return;
    case 1: 
      if (paramInt1 != 2)
      {
        paramView.layout(paramInt3, paramInt4 + i1 - paramView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt5, i1 + paramInt4 - localLayoutParams.bottomMargin);
        return;
      }
      paramInt1 = paramView.getMeasuredHeight();
      paramInt2 = localLayoutParams.topMargin;
      int i2 = paramView.getMeasuredHeight();
      paramView.layout(paramInt3, paramInt4 - i1 + paramInt1 + paramInt2, paramInt5, localLayoutParams.topMargin + (paramInt6 - i1 + i2));
      return;
    }
    paramInt2 = (i1 - paramView.getMeasuredHeight() + localLayoutParams.topMargin - localLayoutParams.bottomMargin) / 2;
    if (paramInt1 != 2)
    {
      paramView.layout(paramInt3, paramInt4 + paramInt2, paramInt5, paramInt2 + paramInt4 + paramView.getMeasuredHeight());
      return;
    }
    paramView.layout(paramInt3, paramInt4 - paramInt2, paramInt5, paramInt4 - paramInt2 + paramView.getMeasuredHeight());
  }
  
  private void a(View paramView, a parama, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.d != -1) {
      paramInt1 = localLayoutParams.d;
    }
    int i1 = parama.g;
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
    case 3: 
    case 4: 
      if (!paramBoolean)
      {
        paramView.layout(localLayoutParams.leftMargin + paramInt2, paramInt3, localLayoutParams.leftMargin + paramInt4, paramInt5);
        return;
      }
      paramView.layout(paramInt2 - localLayoutParams.rightMargin, paramInt3, paramInt4 - localLayoutParams.rightMargin, paramInt5);
      return;
    case 1: 
      if (!paramBoolean)
      {
        paramView.layout(paramInt2 + i1 - paramView.getMeasuredWidth() - localLayoutParams.rightMargin, paramInt3, i1 + paramInt4 - paramView.getMeasuredWidth() - localLayoutParams.rightMargin, paramInt5);
        return;
      }
      paramInt1 = paramView.getMeasuredWidth();
      int i2 = localLayoutParams.leftMargin;
      int i3 = paramView.getMeasuredWidth();
      paramView.layout(paramInt2 - i1 + paramInt1 + i2, paramInt3, localLayoutParams.leftMargin + (paramInt4 - i1 + i3), paramInt5);
      return;
    }
    paramInt1 = (i1 - paramView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart(localLayoutParams) - MarginLayoutParamsCompat.getMarginEnd(localLayoutParams)) / 2;
    if (!paramBoolean)
    {
      paramView.layout(paramInt2 + paramInt1, paramInt3, paramInt1 + paramInt4, paramInt5);
      return;
    }
    paramView.layout(paramInt2 - paramInt1, paramInt3, paramInt4 - paramInt1, paramInt5);
  }
  
  private void a(a parama)
  {
    if (b(this.a)) {
      if ((this.i & 0x4) > 0)
      {
        parama.e += this.k;
        parama.f += this.k;
      }
    }
    for (;;)
    {
      this.n.add(parama);
      return;
      if ((this.h & 0x4) > 0)
      {
        parama.e += this.j;
        parama.f += this.j;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getPaddingLeft();
    int i4 = getPaddingRight();
    int i1 = 0;
    int i5 = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2 - getPaddingBottom();
    paramInt2 = getPaddingTop();
    int i6 = this.n.size();
    paramInt4 = 0;
    paramInt1 = i1;
    a locala;
    int i2;
    float f1;
    float f3;
    float f2;
    label210:
    View localView;
    label438:
    LayoutParams localLayoutParams;
    float f4;
    if (paramInt4 < i6)
    {
      locala = (a)this.n.get(paramInt4);
      i1 = paramInt3;
      i2 = paramInt2;
      if (c(paramInt4))
      {
        i1 = paramInt3 - this.j;
        i2 = paramInt2 + this.j;
      }
      f1 = 0.0F;
      f3 = 0.0F;
      switch (this.c)
      {
      default: 
        throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
      case 0: 
        f2 = i3;
        f1 = i5 - i4;
        f3 = Math.max(f3, 0.0F);
        paramInt2 = 0;
        if (paramInt2 >= locala.h) {
          break label869;
        }
        localView = getReorderedChildAt(paramInt1);
        if (localView != null) {
          break;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label210;
        f2 = i5 - locala.e + i4;
        f1 = locala.e - i3;
        break;
        f1 = i3;
        f2 = (i5 - locala.e) / 2.0F + f1;
        f1 = i5 - i4 - (i5 - locala.e) / 2.0F;
        break;
        paramInt2 = locala.getItemCountNotGone();
        f3 = f1;
        if (paramInt2 != 0) {
          f3 = (i5 - locala.e) / paramInt2;
        }
        f1 = i3;
        f2 = f3 / 2.0F + f1;
        f1 = i5 - i4 - f3 / 2.0F;
        break;
        f2 = i3;
        paramInt2 = locala.getItemCountNotGone();
        if (paramInt2 != 1) {}
        for (f1 = paramInt2 - 1;; f1 = 1.0F)
        {
          f3 = (i5 - locala.e) / f1;
          f1 = i5 - i4;
          break;
        }
        if (localView.getVisibility() != 8) {
          break label438;
        }
        paramInt1 += 1;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f2 += localLayoutParams.leftMargin;
      f1 -= localLayoutParams.rightMargin;
      if (!d(paramInt1, paramInt2)) {
        break label898;
      }
      f4 = this.k;
      f1 -= this.k;
      f2 = f4 + f2;
    }
    label869:
    label898:
    for (;;)
    {
      if (this.b == 2) {
        if (paramBoolean) {
          a(localView, locala, this.b, this.d, Math.round(f1) - localView.getMeasuredWidth(), i1 - localView.getMeasuredHeight(), Math.round(f1), i1);
        }
      }
      for (;;)
      {
        f2 += localView.getMeasuredWidth() + f3 + localLayoutParams.rightMargin;
        f4 = localView.getMeasuredWidth();
        float f5 = localLayoutParams.leftMargin;
        locala.a = Math.min(locala.a, localView.getLeft() - localLayoutParams.leftMargin);
        locala.b = Math.min(locala.b, localView.getTop() - localLayoutParams.topMargin);
        locala.c = Math.max(locala.c, localView.getRight() + localLayoutParams.rightMargin);
        locala.d = Math.max(locala.d, localView.getBottom() + localLayoutParams.bottomMargin);
        f1 -= f4 + f3 + f5;
        paramInt1 += 1;
        break;
        paramInt3 = this.b;
        int i7 = this.d;
        int i8 = Math.round(f2);
        int i9 = localView.getMeasuredHeight();
        int i10 = Math.round(f2);
        a(localView, locala, paramInt3, i7, i8, i1 - i9, localView.getMeasuredWidth() + i10, i1);
        continue;
        if (paramBoolean) {
          a(localView, locala, this.b, this.d, Math.round(f1) - localView.getMeasuredWidth(), i2, Math.round(f1), i2 + localView.getMeasuredHeight());
        } else {
          a(localView, locala, this.b, this.d, Math.round(f2), i2, Math.round(f2) + localView.getMeasuredWidth(), i2 + localView.getMeasuredHeight());
        }
      }
      paramInt2 = i2 + locala.g;
      paramInt3 = i1 - locala.g;
      paramInt4 += 1;
      break;
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i6 = getPaddingRight();
    int i2 = getPaddingLeft();
    int i1 = 0;
    int i5 = paramInt4 - paramInt2;
    paramInt2 = paramInt3 - paramInt1 - i6;
    i6 = this.n.size();
    paramInt4 = 0;
    paramInt3 = i2;
    paramInt1 = i1;
    a locala;
    float f1;
    float f3;
    float f2;
    float f4;
    label235:
    View localView;
    label508:
    LayoutParams localLayoutParams;
    if (paramInt4 < i6)
    {
      locala = (a)this.n.get(paramInt4);
      i1 = paramInt2;
      i2 = paramInt3;
      if (c(paramInt4))
      {
        i2 = paramInt3 + this.k;
        i1 = paramInt2 - this.k;
      }
      f1 = 0.0F;
      f3 = 0.0F;
      switch (this.c)
      {
      default: 
        throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
      case 0: 
        f2 = i3;
        f1 = i5 - i4;
        f4 = Math.max(f3, 0.0F);
        paramInt2 = 0;
        f3 = f1;
        f1 = f2;
        f2 = f3;
        if (paramInt2 >= locala.h) {
          break label936;
        }
        localView = getReorderedChildAt(paramInt1);
        if (localView == null)
        {
          f3 = f2;
          f2 = f1;
          f1 = f3;
        }
        break;
      }
      for (;;)
      {
        paramInt2 += 1;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        break label235;
        f2 = i5 - locala.e + i4;
        f1 = locala.e - i3;
        break;
        f1 = i3;
        f2 = (i5 - locala.e) / 2.0F + f1;
        f1 = i5 - i4 - (i5 - locala.e) / 2.0F;
        break;
        paramInt2 = locala.getItemCountNotGone();
        f3 = f1;
        if (paramInt2 != 0) {
          f3 = (i5 - locala.e) / paramInt2;
        }
        f1 = i3;
        f2 = f3 / 2.0F + f1;
        f1 = i5 - i4 - f3 / 2.0F;
        break;
        f2 = i3;
        paramInt2 = locala.getItemCountNotGone();
        if (paramInt2 != 1) {}
        for (f1 = paramInt2 - 1;; f1 = 1.0F)
        {
          f3 = (i5 - locala.e) / f1;
          f1 = i5 - i4;
          break;
        }
        if (localView.getVisibility() != 8) {
          break label508;
        }
        f3 = f1;
        paramInt1 += 1;
        f1 = f2;
        f2 = f3;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f1 += localLayoutParams.topMargin;
      f2 -= localLayoutParams.bottomMargin;
      if (!d(paramInt1, paramInt2)) {
        break label966;
      }
      f3 = this.j;
      f2 -= this.j;
      f1 = f3 + f1;
    }
    label936:
    label966:
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2) {
          a(localView, locala, true, this.d, i1 - localView.getMeasuredWidth(), Math.round(f2) - localView.getMeasuredHeight(), i1, Math.round(f2));
        }
      }
      for (;;)
      {
        f3 = localView.getMeasuredHeight();
        float f5 = localLayoutParams.bottomMargin;
        float f6 = localView.getMeasuredHeight();
        float f7 = localLayoutParams.topMargin;
        locala.a = Math.min(locala.a, localView.getLeft() - localLayoutParams.leftMargin);
        locala.b = Math.min(locala.b, localView.getTop() - localLayoutParams.topMargin);
        locala.c = Math.max(locala.c, localView.getRight() + localLayoutParams.rightMargin);
        locala.d = Math.max(locala.d, localView.getBottom() + localLayoutParams.bottomMargin);
        f2 -= f6 + f4 + f7;
        f3 = f1 + (f3 + f4 + f5);
        paramInt1 += 1;
        f1 = f2;
        f2 = f3;
        break;
        paramInt3 = this.d;
        int i7 = localView.getMeasuredWidth();
        int i8 = Math.round(f1);
        int i9 = Math.round(f1);
        a(localView, locala, true, paramInt3, i1 - i7, i8, i1, localView.getMeasuredHeight() + i9);
        continue;
        if (paramBoolean2) {
          a(localView, locala, false, this.d, i2, Math.round(f2) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f2));
        } else {
          a(localView, locala, false, this.d, i2, Math.round(f1), i2 + localView.getMeasuredWidth(), Math.round(f1) + localView.getMeasuredHeight());
        }
      }
      paramInt3 = i2 + locala.g;
      paramInt2 = i1 - locala.g;
      paramInt4 += 1;
      break;
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LayoutParams paramLayoutParams, int paramInt5, int paramInt6)
  {
    boolean bool = true;
    if (this.b == 0) {}
    do
    {
      return false;
      if (paramLayoutParams.j) {
        return true;
      }
    } while (paramInt1 == 0);
    int i1;
    if (b(this.a))
    {
      i1 = paramInt4;
      if (d(paramInt5, paramInt6)) {
        i1 = paramInt4 + this.k;
      }
      paramInt1 = i1;
      if ((this.i & 0x4) > 0) {
        paramInt1 = i1 + this.k;
      }
      if (paramInt2 >= paramInt3 + paramInt1) {
        break label138;
      }
    }
    for (;;)
    {
      return bool;
      i1 = paramInt4;
      if (d(paramInt5, paramInt6)) {
        i1 = paramInt4 + this.j;
      }
      paramInt1 = i1;
      if ((this.h & 0x4) <= 0) {
        break;
      }
      paramInt1 = i1 + this.j;
      break;
      label138:
      bool = false;
    }
  }
  
  private int[] a()
  {
    int i1 = getChildCount();
    return a(i1, a(i1));
  }
  
  private int[] a(int paramInt, List<a> paramList)
  {
    Collections.sort(paramList);
    if (this.m == null) {
      this.m = new SparseIntArray(paramInt);
    }
    this.m.clear();
    int[] arrayOfInt = new int[paramInt];
    paramList = paramList.iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      arrayOfInt[paramInt] = locala.a;
      this.m.append(paramInt, locala.b);
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  private int[] a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    int i1 = getChildCount();
    List localList = a(i1);
    a locala = new a(null);
    if ((paramView != null) && ((paramLayoutParams instanceof LayoutParams)))
    {
      locala.b = ((LayoutParams)paramLayoutParams).a;
      if ((paramInt != -1) && (paramInt != i1)) {
        break label95;
      }
      locala.a = i1;
    }
    for (;;)
    {
      localList.add(locala);
      return a(i1 + 1, localList);
      locala.b = 1;
      break;
      label95:
      if (paramInt < getChildCount())
      {
        locala.a = paramInt;
        while (paramInt < i1)
        {
          paramView = (a)localList.get(paramInt);
          paramView.a += 1;
          paramInt += 1;
        }
      }
      else
      {
        locala.a = i1;
      }
    }
  }
  
  private int b(int paramInt1, int paramInt2, a parama, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    int i6 = parama.e;
    if ((parama.k <= 0.0F) || (paramInt4 > parama.e))
    {
      i3 = paramInt6 + parama.h;
      return i3;
    }
    float f3 = (parama.e - paramInt4) / parama.k;
    parama.e = (parama.f + paramInt5);
    if (!paramBoolean) {
      parama.g = Integer.MIN_VALUE;
    }
    int i1 = 0;
    int i2 = paramInt6;
    float f1 = 0.0F;
    int i3 = 0;
    int i5 = 0;
    View localView;
    label111:
    label139:
    LayoutParams localLayoutParams;
    float f2;
    label206:
    int i4;
    label255:
    int i7;
    if (i5 < parama.h)
    {
      localView = getReorderedChildAt(i2);
      if (localView == null) {}
      for (;;)
      {
        i5 += 1;
        break;
        if (localView.getVisibility() != 8) {
          break label139;
        }
        i2 += 1;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (b(paramInt3))
      {
        if (this.o[i2] != 0) {
          break label718;
        }
        f2 = localView.getMeasuredWidth() - localLayoutParams.c * f3;
        if (i5 != parama.h - 1) {
          break label715;
        }
        f2 = f1 + f2;
        f1 = 0.0F;
        i4 = Math.round(f2);
        if (i4 < localLayoutParams.f)
        {
          i1 = 1;
          i4 = localLayoutParams.f;
          this.o[i2] = true;
          parama.k -= localLayoutParams.c;
          i7 = b(paramInt2, localLayoutParams);
          localView.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i7);
          i3 = Math.max(i3, localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        }
      }
    }
    label340:
    label469:
    label518:
    label715:
    label718:
    for (;;)
    {
      i4 = parama.e;
      i7 = localView.getMeasuredWidth();
      int i8 = localLayoutParams.leftMargin;
      parama.e = (localLayoutParams.rightMargin + (i7 + i8) + i4);
      parama.g = Math.max(parama.g, i3);
      i2 += 1;
      break label111;
      f1 += f2 - i4;
      if (f1 > 1.0D)
      {
        i4 += 1;
        f1 -= 1.0F;
        break label255;
      }
      if (f1 < -1.0D)
      {
        i4 -= 1;
        f1 += 1.0F;
        break label255;
        if (this.o[i2] == 0)
        {
          f2 = localView.getMeasuredHeight() - localLayoutParams.c * f3;
          if (i5 == parama.h - 1)
          {
            f2 = f1 + f2;
            f1 = 0.0F;
            i4 = Math.round(f2);
            if (i4 < localLayoutParams.g)
            {
              i1 = 1;
              i4 = localLayoutParams.g;
              this.o[i2] = true;
              parama.k -= localLayoutParams.c;
              localView.measure(a(paramInt1, localLayoutParams), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
              i3 = Math.max(i3, localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
            }
          }
        }
        for (;;)
        {
          i4 = parama.e;
          i7 = localView.getMeasuredHeight();
          i8 = localLayoutParams.topMargin;
          parama.e = (localLayoutParams.bottomMargin + (i7 + i8) + i4);
          break label340;
          f1 += f2 - i4;
          if (f1 > 1.0D)
          {
            i4 += 1;
            f1 -= 1.0F;
            break label518;
          }
          if (f1 < -1.0D)
          {
            i4 -= 1;
            f1 += 1.0F;
            break label518;
            i3 = i2;
            if (i1 == 0) {
              break;
            }
            i3 = i2;
            if (i6 == parama.e) {
              break;
            }
            b(paramInt1, paramInt2, parama, paramInt3, paramInt4, paramInt5, paramInt6, true);
            return i2;
          }
          break label518;
          break label469;
        }
      }
      break label255;
      break label206;
    }
  }
  
  private int b(int paramInt, LayoutParams paramLayoutParams)
  {
    int i1 = getChildMeasureSpec(paramInt, getPaddingTop() + getPaddingBottom() + paramLayoutParams.topMargin + paramLayoutParams.bottomMargin, paramLayoutParams.height);
    int i2 = View.MeasureSpec.getSize(i1);
    if (i2 > paramLayoutParams.i) {
      paramInt = View.MeasureSpec.makeMeasureSpec(paramLayoutParams.i, View.MeasureSpec.getMode(i1));
    }
    do
    {
      return paramInt;
      paramInt = i1;
    } while (i2 >= paramLayoutParams.g);
    return View.MeasureSpec.makeMeasureSpec(paramLayoutParams.g, View.MeasureSpec.getMode(i1));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    int i1 = 0;
    this.n.clear();
    int i9 = getChildCount();
    int i10 = getPaddingTop();
    int i11 = getPaddingBottom();
    int i4 = Integer.MIN_VALUE;
    a locala = new a();
    locala.e = (i10 + i11);
    int i2 = 0;
    int i3 = 0;
    if (i3 < i9)
    {
      View localView = getReorderedChildAt(i3);
      if (localView == null) {
        a(i3, i9, locala);
      }
      for (;;)
      {
        i3 += 1;
        break;
        if (localView.getVisibility() != 8) {
          break label157;
        }
        locala.h += 1;
        locala.i += 1;
        a(i3, i9, locala);
      }
      label157:
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.d == 4) {
        locala.m.add(Integer.valueOf(i3));
      }
      int i6 = localLayoutParams.height;
      int i5 = i6;
      if (localLayoutParams.e != -1.0F)
      {
        i5 = i6;
        if (i7 == 1073741824) {
          i5 = Math.round(i8 * localLayoutParams.e);
        }
      }
      localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin, i5));
      a(localView);
      i6 = ViewCompat.combineMeasuredStates(i1, ViewCompat.getMeasuredState(localView));
      i1 = Math.max(i4, localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
      i4 = locala.e;
      i5 = localView.getMeasuredHeight();
      int i12 = localLayoutParams.topMargin;
      if (a(i7, i8, i4, localLayoutParams.bottomMargin + (i5 + i12), localLayoutParams, i3, i2))
      {
        if (locala.getItemCountNotGone() > 0) {
          a(locala);
        }
        locala = new a();
        locala.h = 1;
        locala.e = (i10 + i11);
        i1 = localView.getMeasuredWidth();
        i2 = localLayoutParams.leftMargin;
        i2 = localLayoutParams.rightMargin + (i1 + i2);
      }
      for (i1 = 0;; i1 = i4)
      {
        locala.e += localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        locala.j += localLayoutParams.b;
        float f1 = locala.k;
        locala.k = (localLayoutParams.c + f1);
        locala.g = Math.max(locala.g, i2);
        if (d(i3, i1)) {
          locala.e += this.j;
        }
        a(i3, i9, locala);
        i5 = i1;
        i1 = i6;
        i4 = i2;
        i2 = i5;
        break;
        locala.h += 1;
        i4 = i2 + 1;
        i2 = i1;
      }
    }
    a(this.a, paramInt1, paramInt2);
    a(this.a, paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    c(this.a, this.d);
    b(this.a, paramInt1, paramInt2, i1);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt3);
    int i3 = View.MeasureSpec.getSize(paramInt3);
    int i1;
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("Invalid flex direction: " + paramInt1);
    case 0: 
    case 1: 
      paramInt1 = getSumOfCrossSize();
      i1 = getPaddingTop();
      i1 = getPaddingBottom() + (paramInt1 + i1);
    }
    for (paramInt1 = getLargestMainSize();; paramInt1 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight()) {
      switch (i2)
      {
      default: 
        throw new IllegalStateException("Unknown width mode is set: " + i2);
        i1 = getLargestMainSize();
      }
    }
    i2 = paramInt4;
    if (i4 < paramInt1) {
      i2 = ViewCompat.combineMeasuredStates(paramInt4, 16777216);
    }
    paramInt2 = ViewCompat.resolveSizeAndState(i4, paramInt2, i2);
    paramInt1 = i2;
    for (;;)
    {
      switch (i5)
      {
      default: 
        throw new IllegalStateException("Unknown height mode is set: " + i5);
        if (i4 < paramInt1)
        {
          paramInt4 = ViewCompat.combineMeasuredStates(paramInt4, 16777216);
          paramInt1 = i4;
        }
        for (;;)
        {
          paramInt2 = ViewCompat.resolveSizeAndState(paramInt1, paramInt2, paramInt4);
          paramInt1 = paramInt4;
          break;
        }
        paramInt2 = ViewCompat.resolveSizeAndState(paramInt1, paramInt2, paramInt4);
        paramInt1 = paramInt4;
      }
    }
    paramInt4 = paramInt1;
    if (i3 < i1) {
      paramInt4 = ViewCompat.combineMeasuredStates(paramInt1, 256);
    }
    paramInt1 = ViewCompat.resolveSizeAndState(i3, paramInt3, paramInt4);
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      if (i3 < i1)
      {
        i1 = ViewCompat.combineMeasuredStates(paramInt1, 256);
        paramInt1 = i3;
        paramInt4 = paramInt1;
      }
      for (;;)
      {
        paramInt1 = ViewCompat.resolveSizeAndState(paramInt4, paramInt3, i1);
        break;
        paramInt4 = i1;
        i1 = paramInt1;
      }
      paramInt1 = ViewCompat.resolveSizeAndState(i1, paramInt3, paramInt1);
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f == null) {
      return;
    }
    this.f.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.j + paramInt2);
    this.f.draw(paramCanvas);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    int i5 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i6 = Math.max(0, getHeight() - i2 - i5);
    int i7 = this.n.size();
    i2 = 0;
    if (i2 < i7)
    {
      a locala = (a)this.n.get(i2);
      int i3 = 0;
      while (i3 < locala.h)
      {
        View localView = getReorderedChildAt(i1);
        int i4 = i1;
        if (localView != null)
        {
          if (localView.getVisibility() == 8) {
            i4 = i1;
          }
        }
        else
        {
          i3 += 1;
          i1 = i4;
          continue;
        }
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (d(i1, i3))
        {
          if (paramBoolean2)
          {
            i4 = localView.getBottom() + localLayoutParams.bottomMargin;
            label163:
            b(paramCanvas, locala.a, i4, locala.g);
          }
        }
        else if ((i3 == locala.h - 1) && ((this.h & 0x4) > 0)) {
          if (!paramBoolean2) {
            break label270;
          }
        }
        for (i4 = localView.getTop() - localLayoutParams.topMargin - this.j;; i4 = localLayoutParams.bottomMargin + i4)
        {
          b(paramCanvas, locala.a, i4, locala.g);
          i4 = i1 + 1;
          break;
          i4 = localView.getTop() - localLayoutParams.topMargin - this.j;
          break label163;
          label270:
          i4 = localView.getBottom();
        }
      }
      if (c(i2))
      {
        if (paramBoolean1)
        {
          i3 = locala.c;
          label310:
          a(paramCanvas, i3, i5, i6);
        }
      }
      else if ((e(i2)) && ((this.i & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label390;
        }
      }
      label390:
      for (i3 = locala.a - this.k;; i3 = locala.c)
      {
        a(paramCanvas, i3, i5, i6);
        i2 += 1;
        break;
        i3 = locala.a - this.k;
        break label310;
      }
    }
  }
  
  private void b(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramView.measure(View.MeasureSpec.makeMeasureSpec(Math.max(paramInt - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 0), 1073741824), View.MeasureSpec.makeMeasureSpec(paramView.getMeasuredHeight(), 1073741824));
  }
  
  private boolean b()
  {
    int i2 = getChildCount();
    if (this.m == null) {
      this.m = new SparseIntArray(i2);
    }
    if (this.m.size() != i2) {
      return true;
    }
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView == null) {}
      while (((LayoutParams)localView.getLayoutParams()).a == this.m.get(i1))
      {
        i1 += 1;
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private void c()
  {
    if ((this.f == null) && (this.g == null))
    {
      setWillNotDraw(true);
      return;
    }
    setWillNotDraw(false);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    a locala;
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 4)
    {
      localIterator = this.n.iterator();
      paramInt2 = 0;
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        int i1 = 0;
        if (i1 < locala.h)
        {
          localObject1 = getReorderedChildAt(paramInt2);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if ((((LayoutParams)localObject2).d != -1) && (((LayoutParams)localObject2).d != 4)) {}
          for (;;)
          {
            paramInt2 += 1;
            i1 += 1;
            break;
            switch (paramInt1)
            {
            default: 
              throw new IllegalArgumentException("Invalid flex direction: " + paramInt1);
            case 0: 
            case 1: 
              a((View)localObject1, locala.g);
              break;
            case 2: 
            case 3: 
              b((View)localObject1, locala.g);
            }
          }
        }
      }
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      localObject1 = locala.m.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = getReorderedChildAt(((Integer)((Iterator)localObject1).next()).intValue());
        switch (paramInt1)
        {
        default: 
          throw new IllegalArgumentException("Invalid flex direction: " + paramInt1);
        case 0: 
        case 1: 
          a((View)localObject2, locala.g);
          break;
        case 2: 
        case 3: 
          b((View)localObject2, locala.g);
        }
      }
    }
  }
  
  private boolean c(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.n.size())) {
      bool = false;
    }
    label64:
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            if (!d(paramInt)) {
              break label64;
            }
            if (!b(this.a)) {
              break;
            }
          } while ((this.h & 0x1) != 0);
          return false;
        } while ((this.i & 0x1) != 0);
        return false;
        if (!b(this.a)) {
          break;
        }
      } while ((this.h & 0x2) != 0);
      return false;
    } while ((this.i & 0x2) != 0);
    return false;
  }
  
  private boolean d(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      if (((a)this.n.get(i1)).getItemCountNotGone() > 0) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if (e(paramInt1, paramInt2)) {
      if (b(this.a)) {
        if ((this.i & 0x1) == 0) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while ((this.h & 0x1) != 0);
        return false;
        if (!b(this.a)) {
          break;
        }
      } while ((this.i & 0x2) != 0);
      return false;
    } while ((this.h & 0x2) != 0);
    return false;
  }
  
  private boolean e(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.n.size())) {
      return false;
    }
    paramInt += 1;
    for (;;)
    {
      if (paramInt >= this.n.size()) {
        break label64;
      }
      if (((a)this.n.get(paramInt)).getItemCountNotGone() > 0) {
        break;
      }
      paramInt += 1;
    }
    label64:
    if (b(this.a))
    {
      if ((this.h & 0x4) != 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if ((this.i & 0x4) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i1 = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 <= paramInt2)
      {
        View localView = getReorderedChildAt(paramInt1 - i1);
        if ((localView != null) && (localView.getVisibility() != 8)) {
          bool1 = false;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private int getLargestMainSize()
  {
    Iterator localIterator = this.n.iterator();
    for (int i1 = Integer.MIN_VALUE; localIterator.hasNext(); i1 = Math.max(i1, ((a)localIterator.next()).e)) {}
    return i1;
  }
  
  private int getSumOfCrossSize()
  {
    int i4 = this.n.size();
    int i3 = 0;
    int i2 = 0;
    if (i3 < i4)
    {
      a locala = (a)this.n.get(i3);
      int i1 = i2;
      if (c(i3))
      {
        if (b(this.a)) {
          i1 = i2 + this.j;
        }
      }
      else
      {
        label64:
        i2 = i1;
        if (e(i3)) {
          if (!b(this.a)) {
            break label117;
          }
        }
      }
      label117:
      for (i2 = i1 + this.j;; i2 = i1 + this.k)
      {
        i2 += locala.g;
        i3 += 1;
        break;
        i1 = i2 + this.k;
        break label64;
      }
    }
    return i2;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.l = a(paramView, paramInt, paramLayoutParams);
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getAlignContent()
  {
    return this.e;
  }
  
  public int getAlignItems()
  {
    return this.d;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.f;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.g;
  }
  
  public int getFlexDirection()
  {
    return this.a;
  }
  
  public List<a> getFlexLines()
  {
    ArrayList localArrayList = new ArrayList(this.n.size());
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.getItemCountNotGone() != 0) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  public int getFlexWrap()
  {
    return this.b;
  }
  
  public int getJustifyContent()
  {
    return this.c;
  }
  
  public View getReorderedChildAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.l.length)) {
      return null;
    }
    return getChildAt(this.l[paramInt]);
  }
  
  public int getShowDividerHorizontal()
  {
    return this.h;
  }
  
  public int getShowDividerVertical()
  {
    return this.i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool3 = true;
    if ((this.g == null) && (this.f == null)) {}
    while ((this.h == 0) && (this.i == 0)) {
      return;
    }
    int i1 = ViewCompat.getLayoutDirection(this);
    boolean bool1;
    switch (this.a)
    {
    default: 
      return;
    case 0: 
      if (i1 == 1)
      {
        bool1 = true;
        if (this.b != 2) {
          break label238;
        }
      }
      break;
    }
    label182:
    label223:
    label229:
    label232:
    label238:
    for (bool2 = bool3;; bool2 = false)
    {
      a(paramCanvas, bool1, bool2);
      return;
      bool1 = false;
      break;
      if (i1 != 1)
      {
        bool1 = true;
        if (this.b != 2) {
          break label232;
        }
      }
      for (bool2 = bool4;; bool2 = false)
      {
        a(paramCanvas, bool1, bool2);
        return;
        bool1 = false;
        break;
        if (i1 == 1)
        {
          bool1 = true;
          if (this.b != 2) {
            break label229;
          }
          if (bool1) {
            break label182;
          }
          bool1 = bool5;
        }
        for (;;)
        {
          b(paramCanvas, bool1, false);
          return;
          bool1 = false;
          break;
          bool1 = false;
          continue;
          if (i1 == 1)
          {
            bool1 = true;
            if (this.b != 2) {
              break label223;
            }
            if (bool1) {}
          }
          for (bool2 = true;; bool2 = bool1)
          {
            b(paramCanvas, bool2, true);
            return;
            bool1 = false;
            break;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    int i1 = ViewCompat.getLayoutDirection(this);
    switch (this.a)
    {
    default: 
      throw new IllegalStateException("Invalid flex direction is set: " + this.a);
    case 0: 
      if (i1 == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    case 1: 
      if (i1 != 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    case 2: 
      if (i1 == 1)
      {
        paramBoolean = true;
        if (this.b != 2) {
          break label223;
        }
        if (paramBoolean) {
          break label170;
        }
        paramBoolean = bool2;
      }
      break;
    }
    label170:
    label217:
    label223:
    for (;;)
    {
      a(paramBoolean, false, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      continue;
      if (i1 == 1)
      {
        paramBoolean = true;
        if (this.b != 2) {
          break label217;
        }
        if (paramBoolean) {}
      }
      for (bool1 = true;; bool1 = paramBoolean)
      {
        a(bool1, true, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (b()) {
      this.l = a();
    }
    if ((this.o == null) || (this.o.length < getChildCount())) {
      this.o = new boolean[getChildCount()];
    }
    switch (this.a)
    {
    default: 
      throw new IllegalStateException("Invalid value for the flex direction is set: " + this.a);
    case 0: 
    case 1: 
      a(paramInt1, paramInt2);
    }
    for (;;)
    {
      Arrays.fill(this.o, false);
      return;
      b(paramInt1, paramInt2);
    }
  }
  
  public void setAlignContent(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      requestLayout();
    }
  }
  
  public void setAlignItems(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    setDividerDrawableHorizontal(paramDrawable);
    setDividerDrawableVertical(paramDrawable);
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    if (paramDrawable == this.f) {
      return;
    }
    this.f = paramDrawable;
    if (paramDrawable != null) {}
    for (this.j = paramDrawable.getIntrinsicHeight();; this.j = 0)
    {
      c();
      requestLayout();
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    if (paramDrawable == this.g) {
      return;
    }
    this.g = paramDrawable;
    if (paramDrawable != null) {}
    for (this.k = paramDrawable.getIntrinsicWidth();; this.k = 0)
    {
      c();
      requestLayout();
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      requestLayout();
    }
  }
  
  public void setFlexWrap(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      requestLayout();
    }
  }
  
  public void setJustifyContent(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDivider(int paramInt)
  {
    setShowDividerVertical(paramInt);
    setShowDividerHorizontal(paramInt);
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      requestLayout();
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 1;
    public float b = 0.0F;
    public float c = 1.0F;
    public int d = -1;
    public float e = -1.0F;
    public int f;
    public int g;
    public int h = 16777215;
    public int i = 16777215;
    public boolean j;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super();
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlexboxLayout_Layout);
      this.a = paramContext.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
      this.b = paramContext.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0F);
      this.c = paramContext.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0F);
      this.d = paramContext.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
      this.e = paramContext.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0F);
      this.f = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, 0);
      this.g = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, 0);
      this.h = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
      this.i = paramContext.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
      this.j = paramContext.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
      this.b = paramLayoutParams.b;
      this.c = paramLayoutParams.c;
      this.d = paramLayoutParams.d;
      this.e = paramLayoutParams.e;
      this.f = paramLayoutParams.f;
      this.g = paramLayoutParams.g;
      this.h = paramLayoutParams.h;
      this.i = paramLayoutParams.i;
      this.j = paramLayoutParams.j;
    }
  }
  
  private static class a
    implements Comparable<a>
  {
    int a;
    int b;
    
    public int compareTo(a parama)
    {
      if (this.b != parama.b) {
        return this.b - parama.b;
      }
      return this.a - parama.a;
    }
    
    public String toString()
    {
      return "Order{order=" + this.b + ", index=" + this.a + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/android/flexbox/FlexboxLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */