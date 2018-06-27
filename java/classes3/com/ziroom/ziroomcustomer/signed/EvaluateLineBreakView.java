package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
import com.ziroom.ziroomcustomer.model.EvaluateSubOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvaluateLineBreakView
  extends ViewGroup
{
  private List<EvaluateSubOption> a;
  private List<EvaluateSubOption> b = new ArrayList();
  private int c;
  private int d;
  
  public EvaluateLineBreakView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EvaluateLineBreakView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EvaluateLineBreakView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LineBreakLayout);
    this.c = paramContext.getDimensionPixelSize(0, 10);
    this.d = paramContext.getDimensionPixelSize(1, 10);
    paramContext.recycle();
  }
  
  public List<EvaluateSubOption> getLables()
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
  
  public void setLables(List<EvaluateSubOption> paramList)
  {
    this.a = paramList;
    if (paramList == null) {
      removeAllViews();
    }
  }
  
  public void setLables(List<EvaluateSubOption> paramList, final boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    removeAllViews();
    this.a = paramList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        final EvaluateSubOption localEvaluateSubOption = (EvaluateSubOption)paramList.next();
        final TextView localTextView = (TextView)localLayoutInflater.inflate(2130905023, null);
        localTextView.setText(localEvaluateSubOption.getDesc());
        if (localEvaluateSubOption.getSelected() == 1) {
          this.b.add(localEvaluateSubOption);
        }
        if (this.b.contains(localEvaluateSubOption))
        {
          localTextView.setSelected(true);
          localTextView.setBackgroundResource(2130837756);
          localTextView.setTextColor(Color.parseColor("#fe9800"));
        }
        for (;;)
        {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (paramBoolean)
              {
                paramAnonymousView = localTextView;
                if (localTextView.isSelected()) {
                  break label74;
                }
              }
              label74:
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousView.setSelected(bool);
                if (!localTextView.isSelected()) {
                  break;
                }
                localTextView.setBackgroundResource(2130837756);
                localTextView.setTextColor(Color.parseColor("#fe9800"));
                localEvaluateSubOption.setSelected(1);
                return;
              }
              localTextView.setBackgroundResource(2130837755);
              localTextView.setTextColor(Color.parseColor("#BBBBBB"));
              localEvaluateSubOption.setSelected(2);
            }
          });
          addView(localTextView);
          break;
          localTextView.setSelected(false);
          localTextView.setBackgroundResource(2130837755);
          localTextView.setTextColor(Color.parseColor("#BBBBBB"));
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EvaluateLineBreakView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */