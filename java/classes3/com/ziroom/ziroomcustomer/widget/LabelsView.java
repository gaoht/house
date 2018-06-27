package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private Context a;
  private ColorStateList b;
  private float c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private d k;
  private int l;
  private ArrayList<Object> m = new ArrayList();
  private ArrayList<Integer> n = new ArrayList();
  private ArrayList<Integer> o = new ArrayList();
  private b p;
  private c q;
  
  public LabelsView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i1 == 1073741824) {}
    for (;;)
    {
      return Math.max(paramInt1, getSuggestedMinimumWidth());
      paramInt2 = getPaddingLeft() + paramInt2 + getPaddingRight();
      if (i1 == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  private void a()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a((TextView)getChildAt(i1), false);
      i1 += 1;
    }
    this.n.clear();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.labels_view);
      this.k = d.a(paramAttributeSet.getInt(0, 1));
      this.l = paramAttributeSet.getInteger(1, 0);
      this.b = paramAttributeSet.getColorStateList(2);
      this.c = paramAttributeSet.getDimension(3, sp2px(paramContext, 14.0F));
      this.e = paramAttributeSet.getDimensionPixelOffset(4, 0);
      this.f = paramAttributeSet.getDimensionPixelOffset(5, 0);
      this.g = paramAttributeSet.getDimensionPixelOffset(6, 0);
      this.h = paramAttributeSet.getDimensionPixelOffset(7, 0);
      this.j = paramAttributeSet.getDimensionPixelOffset(8, 0);
      this.i = paramAttributeSet.getDimensionPixelOffset(9, 0);
      this.d = paramAttributeSet.getResourceId(10, 0);
      paramAttributeSet.recycle();
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if ((paramTextView.isSelected()) && (paramBoolean) && (this.k == d.b)) {}
    for (;;)
    {
      return;
      if (paramTextView.isSelected() != paramBoolean)
      {
        paramTextView.setSelected(paramBoolean);
        if (paramBoolean) {
          this.n.add((Integer)paramTextView.getTag(2131689525));
        }
        while (this.q != null)
        {
          this.q.onLabelSelectChange(paramTextView, paramTextView.getTag(2131689524), paramBoolean, ((Integer)paramTextView.getTag(2131689525)).intValue());
          return;
          this.n.remove((Integer)paramTextView.getTag(2131689525));
        }
      }
    }
  }
  
  private <T> void a(T paramT, int paramInt, a<T> parama)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setPadding(this.e, this.f, this.g, this.h);
    localTextView.setTextSize(0, this.c);
    if (this.b != null) {}
    for (ColorStateList localColorStateList = this.b;; localColorStateList = ColorStateList.valueOf(-16777216))
    {
      localTextView.setTextColor(localColorStateList);
      if (this.d != 0) {
        localTextView.setBackgroundResource(this.d);
      }
      localTextView.setTag(2131689524, paramT);
      localTextView.setTag(2131689525, Integer.valueOf(paramInt));
      localTextView.setOnClickListener(this);
      addView(localTextView);
      localTextView.setText(parama.getLabelText(localTextView, paramInt, paramT));
      return;
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i1 == 1073741824) {}
    for (;;)
    {
      return Math.max(paramInt1, getSuggestedMinimumHeight());
      paramInt2 = getPaddingTop() + paramInt2 + getPaddingBottom();
      if (i1 == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  private void b()
  {
    int i2 = getChildCount();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < i2)
    {
      if (!this.o.contains(Integer.valueOf(i1)))
      {
        a((TextView)getChildAt(i1), false);
        localArrayList.add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    this.n.removeAll(localArrayList);
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public void clearAllSelect()
  {
    if (this.k != d.c)
    {
      if ((this.k == d.d) && (!this.o.isEmpty())) {
        b();
      }
    }
    else {
      return;
    }
    a();
  }
  
  public void clearCompulsorys()
  {
    if ((this.k == d.d) && (!this.o.isEmpty()))
    {
      this.o.clear();
      a();
    }
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.o;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.b;
  }
  
  public float getLabelTextSize()
  {
    return this.c;
  }
  
  public <T> List<T> getLabels()
  {
    return this.m;
  }
  
  public int getLineMargin()
  {
    return this.j;
  }
  
  public int getMaxSelect()
  {
    return this.l;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = this.n.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(((Integer)this.n.get(i1)).intValue()).getTag(2131689524);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public List<Integer> getSelectLabels()
  {
    return this.n;
  }
  
  public d getSelectType()
  {
    return this.k;
  }
  
  public int getTextPaddingBottom()
  {
    return this.h;
  }
  
  public int getTextPaddingLeft()
  {
    return this.e;
  }
  
  public int getTextPaddingRight()
  {
    return this.g;
  }
  
  public int getTextPaddingTop()
  {
    return this.f;
  }
  
  public int getWordMargin()
  {
    return this.i;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.k != d.a)
      {
        if (!paramView.isSelected()) {
          break label105;
        }
        if ((this.k != d.c) && (!this.o.contains((Integer)paramView.getTag(2131689525)))) {
          a(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.p != null) {
        this.p.onLabelClick(paramView, paramView.getTag(2131689524), ((Integer)paramView.getTag(2131689525)).intValue());
      }
      return;
      label105:
      if ((this.k == d.b) || (this.k == d.c))
      {
        a();
        a(paramView, true);
      }
      else if ((this.k == d.d) && ((this.l <= 0) || (this.l > this.n.size())))
      {
        a(paramView, true);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getPaddingLeft();
    int i4 = getPaddingTop();
    int i6 = getChildCount();
    int i1 = 0;
    paramInt2 = 0;
    while (i1 < i6)
    {
      View localView = getChildAt(i1);
      int i5 = paramInt2;
      int i2 = i4;
      int i3 = paramInt4;
      if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
      {
        i3 = getPaddingLeft();
        i2 = paramInt2 + (i4 + this.j);
        i5 = 0;
      }
      localView.layout(i3, i2, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + i2);
      paramInt4 = localView.getMeasuredWidth();
      i4 = this.i;
      paramInt2 = Math.max(i5, localView.getMeasuredHeight());
      i1 += 1;
      paramInt4 = i4 + (i3 + paramInt4);
      i4 = i2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i11 = getChildCount();
    int i12 = View.MeasureSpec.getSize(paramInt1);
    int i13 = getPaddingLeft();
    int i14 = getPaddingRight();
    int i5 = 0;
    int i4 = 1;
    int i1 = 0;
    int i9 = 0;
    int i2 = 0;
    int i8 = 0;
    if (i5 < i11)
    {
      View localView = getChildAt(i5);
      measureChild(localView, paramInt1, paramInt2);
      int i10 = i1;
      int i7 = i9;
      int i3 = i2;
      int i6 = i8;
      if (i12 - i13 - i14 < localView.getMeasuredWidth() + i2)
      {
        i4 = this.j;
        i7 = Math.max(i9, i2);
        i3 = 0;
        i6 = i1 + (i4 + i8);
        i10 = 0;
        i4 = 1;
      }
      i1 = Math.max(i10, localView.getMeasuredHeight());
      if (i4 == 0) {
        i3 += this.i;
      }
      for (;;)
      {
        i2 = i3 + localView.getMeasuredWidth();
        i5 += 1;
        i9 = i7;
        i8 = i6;
        break;
        i4 = 0;
      }
    }
    setMeasuredDimension(a(paramInt1, Math.max(i9, i2)), b(paramInt2, i8 + i1));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int i1 = 0;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getParcelable("key_super_state"));
      Object localObject = (ColorStateList)paramParcelable.getParcelable("key_text_color_state");
      if (localObject != null) {
        setLabelTextColor((ColorStateList)localObject);
      }
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.c));
      int i2 = paramParcelable.getInt("key_bg_res_id_state", this.d);
      if (i2 != 0) {
        setLabelBackgroundResource(i2);
      }
      localObject = paramParcelable.getIntArray("key_padding_state");
      if ((localObject != null) && (localObject.length == 4)) {
        setLabelTextPadding(localObject[0], localObject[1], localObject[2], localObject[3]);
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.i));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.j));
      setSelectType(d.a(paramParcelable.getInt("key_select_type_state", this.k.e)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.l));
      localObject = paramParcelable.getIntegerArrayList("key_select_compulsory_state");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        setCompulsorys((List)localObject);
      }
      paramParcelable = paramParcelable.getIntegerArrayList("key_select_labels_state");
      if ((paramParcelable != null) && (!paramParcelable.isEmpty()))
      {
        i2 = paramParcelable.size();
        localObject = new int[i2];
        while (i1 < i2)
        {
          localObject[i1] = ((Integer)paramParcelable.get(i1)).intValue();
          i1 += 1;
        }
        setSelects((int[])localObject);
      }
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_super_state", super.onSaveInstanceState());
    if (this.b != null) {
      localBundle.putParcelable("key_text_color_state", this.b);
    }
    localBundle.putFloat("key_text_size_state", this.c);
    localBundle.putInt("key_bg_res_id_state", this.d);
    localBundle.putIntArray("key_padding_state", new int[] { this.e, this.f, this.g, this.h });
    localBundle.putInt("key_word_margin_state", this.i);
    localBundle.putInt("key_line_margin_state", this.j);
    localBundle.putInt("key_select_type_state", this.k.e);
    localBundle.putInt("key_max_select_state", this.l);
    if (!this.n.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.n);
    }
    if (!this.o.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.o);
    }
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    if ((this.k == d.d) && (paramList != null))
    {
      this.o.clear();
      this.o.addAll(paramList);
      a();
      setSelects(paramList);
    }
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    if ((this.k == d.d) && (paramVarArgs != null))
    {
      ArrayList localArrayList = new ArrayList(paramVarArgs.length);
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localArrayList.add(Integer.valueOf(paramVarArgs[i1]));
        i1 += 1;
      }
      setCompulsorys(localArrayList);
    }
  }
  
  public void setLabelBackgroundResource(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      int i1 = getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        ((TextView)getChildAt(paramInt)).setBackgroundResource(this.d);
        paramInt += 1;
      }
    }
  }
  
  public void setLabelTextColor(int paramInt)
  {
    setLabelTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setLabelTextColor(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      TextView localTextView = (TextView)getChildAt(i1);
      if (this.b != null) {}
      for (paramColorStateList = this.b;; paramColorStateList = ColorStateList.valueOf(-16777216))
      {
        localTextView.setTextColor(paramColorStateList);
        i1 += 1;
        break;
      }
    }
  }
  
  public void setLabelTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.e != paramInt1) || (this.f != paramInt2) || (this.g != paramInt3) || (this.h != paramInt4))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = paramInt3;
      this.h = paramInt4;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        ((TextView)getChildAt(i1)).setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
        i1 += 1;
      }
    }
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        ((TextView)getChildAt(i1)).setTextSize(0, paramFloat);
        i1 += 1;
      }
    }
  }
  
  public void setLabels(List<String> paramList)
  {
    setLabels(paramList, new a()
    {
      public CharSequence getLabelText(TextView paramAnonymousTextView, int paramAnonymousInt, String paramAnonymousString)
      {
        return paramAnonymousString.trim();
      }
    });
  }
  
  public <T> void setLabels(List<T> paramList, a<T> parama)
  {
    a();
    removeAllViews();
    this.m.clear();
    if (paramList != null)
    {
      this.m.addAll(paramList);
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        a(paramList.get(i1), i1, parama);
        i1 += 1;
      }
    }
    if (this.k == d.c) {
      setSelects(new int[] { 0 });
    }
  }
  
  public void setLineMargin(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      requestLayout();
    }
  }
  
  public void setMaxSelect(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      if (this.k == d.d) {
        a();
      }
    }
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    this.p = paramb;
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.q = paramc;
  }
  
  public void setSelectType(d paramd)
  {
    if (this.k != paramd)
    {
      this.k = paramd;
      a();
      if (this.k == d.c) {
        setSelects(new int[] { 0 });
      }
      if (this.k != d.d) {
        this.o.clear();
      }
    }
  }
  
  public void setSelects(List<Integer> paramList)
  {
    if (paramList != null)
    {
      int i2 = paramList.size();
      int[] arrayOfInt = new int[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfInt[i1] = ((Integer)paramList.get(i1)).intValue();
        i1 += 1;
      }
      setSelects(arrayOfInt);
    }
  }
  
  public void setSelects(int... paramVarArgs)
  {
    if (this.k != d.a)
    {
      ArrayList localArrayList = new ArrayList();
      int i3 = getChildCount();
      int i1;
      int i4;
      int i2;
      if ((this.k == d.b) || (this.k == d.c))
      {
        i1 = 1;
        i4 = paramVarArgs.length;
        i2 = 0;
      }
      for (;;)
      {
        if (i2 < i4)
        {
          int i5 = paramVarArgs[i2];
          if (i5 < i3)
          {
            TextView localTextView = (TextView)getChildAt(i5);
            if (!localArrayList.contains(localTextView))
            {
              a(localTextView, true);
              localArrayList.add(localTextView);
            }
            if ((i1 <= 0) || (localArrayList.size() != i1)) {}
          }
        }
        else
        {
          i1 = 0;
          while (i1 < i3)
          {
            paramVarArgs = (TextView)getChildAt(i1);
            if (!localArrayList.contains(paramVarArgs)) {
              a(paramVarArgs, false);
            }
            i1 += 1;
          }
          i1 = this.l;
          break;
        }
        i2 += 1;
      }
    }
  }
  
  public void setWordMargin(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      requestLayout();
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract CharSequence getLabelText(TextView paramTextView, int paramInt, T paramT);
  }
  
  public static abstract interface b
  {
    public abstract void onLabelClick(TextView paramTextView, Object paramObject, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void onLabelSelectChange(TextView paramTextView, Object paramObject, boolean paramBoolean, int paramInt);
  }
  
  public static enum d
  {
    int e;
    
    private d(int paramInt)
    {
      this.e = paramInt;
    }
    
    static d a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return a;
      case 1: 
        return a;
      case 2: 
        return b;
      case 3: 
        return c;
      }
      return d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/LabelsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */