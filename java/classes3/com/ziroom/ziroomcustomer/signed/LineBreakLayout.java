package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineBreakLayout
  extends ViewGroup
{
  private List<String> a;
  private List<String> b = new ArrayList();
  private int c;
  private int d;
  
  public LineBreakLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LineBreakLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineBreakLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LineBreakLayout);
    this.c = paramContext.getDimensionPixelSize(0, 10);
    this.d = paramContext.getDimensionPixelSize(1, 10);
    paramContext.recycle();
  }
  
  public List<String> getLables()
  {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    int i = 0;
    for (paramInt2 = 0; paramInt1 < getChildCount(); paramInt2 = paramInt4)
    {
      View localView = getChildAt(paramInt1);
      int k = localView.getMeasuredWidth();
      int n = localView.getMeasuredHeight();
      int m = i + k;
      int j = (this.d + n) * paramInt2 + n;
      paramInt4 = paramInt2;
      i = m;
      if (m > paramInt3 - this.c)
      {
        paramInt4 = paramInt2 + 1;
        j = (this.d + n) * paramInt4 + n;
        i = k;
      }
      localView.layout(i - k, j - n, i, j);
      i = this.c + i;
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildren(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      setMeasuredDimension(j, paramInt1);
      return;
      int k = getChildCount();
      if (k <= 0)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt2 = 1;
        paramInt1 = 0;
        i = j;
        if (paramInt1 < k)
        {
          int m = getChildAt(paramInt1).getMeasuredWidth();
          if (i >= m) {
            i -= m;
          }
          for (;;)
          {
            m = this.c;
            paramInt1 += 1;
            i -= m;
            break;
            paramInt2 += 1;
            i = j - m;
          }
        }
        paramInt1 = getChildAt(0).getMeasuredHeight() * paramInt2 + (paramInt2 - 1) * this.d;
      }
    }
  }
  
  public void setLables(List<String> paramList)
  {
    this.a = paramList;
    if (paramList == null) {
      removeAllViews();
    }
  }
  
  public void setLables(List<String> paramList, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    label61:
    final String str;
    final TextView localTextView;
    if (paramBoolean)
    {
      this.a.addAll(paramList);
      if ((paramList == null) || (paramList.size() <= 0)) {
        return;
      }
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      paramList = paramList.iterator();
      if (!paramList.hasNext()) {
        return;
      }
      str = (String)paramList.next();
      localTextView = (TextView)localLayoutInflater.inflate(2130905023, null);
      localTextView.setText(str);
      if (!this.b.contains(str)) {
        break label181;
      }
      localTextView.setSelected(true);
      localTextView.setTextColor(getResources().getColor(2131624417));
    }
    for (;;)
    {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = localTextView;
          if (!localTextView.isSelected()) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setSelected(bool);
            if (!localTextView.isSelected()) {
              break;
            }
            localTextView.setTextColor(LineBreakLayout.this.getResources().getColor(2131624417));
            LineBreakLayout.a(LineBreakLayout.this).add(str);
            return;
          }
          localTextView.setTextColor(LineBreakLayout.this.getResources().getColor(2131624417));
          LineBreakLayout.a(LineBreakLayout.this).remove(str);
        }
      });
      addView(localTextView);
      break label61;
      this.a.clear();
      removeAllViews();
      this.a = paramList;
      break;
      label181:
      localTextView.setSelected(false);
      localTextView.setTextColor(getResources().getColor(2131624417));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/LineBreakLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */