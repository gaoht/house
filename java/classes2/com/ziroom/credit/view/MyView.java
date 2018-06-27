package com.ziroom.credit.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.credit.R.id;

public class MyView
  extends FrameLayout
{
  int a;
  private SimpleDraweeView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private Context g;
  
  public MyView(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
  }
  
  public MyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
  }
  
  private void a()
  {
    int i = this.a * 72 / 345;
    int j = this.a * 163 / 345;
    int k = this.a * 36 / 345;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, j);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setTranslationY(i);
    this.b.setTranslationX(this.a * 93 / 345);
    localLayoutParams = new FrameLayout.LayoutParams(k, k);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setTranslationY(i);
    this.c.setTranslationX(this.a * 93 / 345);
    this.f.setTranslationY(this.a * 263 / 345);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((SimpleDraweeView)findViewById(R.id.credit_img));
    this.c = ((ImageView)findViewById(R.id.credit_smail_img));
    this.d = ((TextView)findViewById(R.id.credit_tv_name));
    this.e = ((TextView)findViewById(R.id.credit_tv_desc));
    this.f = ((LinearLayout)findViewById(R.id.credit_ll_group));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.a > i)
    {
      this.a = i;
      super.onMeasure(paramInt2, paramInt2);
    }
    for (;;)
    {
      a();
      return;
      super.onMeasure(paramInt1, paramInt1);
    }
  }
  
  public void setDes(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void setImageUrl(String paramString, final View paramView)
  {
    this.b.setController(c.frescoController(paramString, new BaseControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousString, paramAnonymousThrowable);
        if (paramView.getVisibility() == 0) {
          paramView.setVisibility(4);
        }
      }
      
      public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
      {
        super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
        if (paramView.getVisibility() == 0) {
          paramView.setVisibility(0);
        }
      }
    }));
  }
  
  public void setLabel(String paramString)
  {
    this.d.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/MyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */