package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.R.color;
import android.support.v7.cardview.R.style;
import android.support.v7.cardview.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] e = { 16842801 };
  private static final r f;
  int a;
  int b;
  final Rect c = new Rect();
  final Rect d = new Rect();
  private boolean g;
  private boolean h;
  private final q i = new q()
  {
    private Drawable b;
    
    public Drawable getCardBackground()
    {
      return this.b;
    }
    
    public View getCardView()
    {
      return CardView.this;
    }
    
    public boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public void setCardBackground(Drawable paramAnonymousDrawable)
    {
      this.b = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
    
    public void setMinWidthHeightInternal(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.a) {
        CardView.a(CardView.this, paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.b) {
        CardView.b(CardView.this, paramAnonymousInt2);
      }
    }
    
    public void setShadowPadding(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.d.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView.a(CardView.this, CardView.this.c.left + paramAnonymousInt1, CardView.this.c.top + paramAnonymousInt2, CardView.this.c.right + paramAnonymousInt3, CardView.this.c.bottom + paramAnonymousInt4);
    }
  };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      f = new o();
    }
    for (;;)
    {
      f.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        f = new n();
      } else {
        f = new p();
      }
    }
  }
  
  public CardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt, R.style.CardView);
    if (localTypedArray.hasValue(R.styleable.CardView_cardBackgroundColor))
    {
      paramAttributeSet = localTypedArray.getColorStateList(R.styleable.CardView_cardBackgroundColor);
      float f4 = localTypedArray.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
      float f2 = localTypedArray.getDimension(R.styleable.CardView_cardElevation, 0.0F);
      float f3 = localTypedArray.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
      this.g = localTypedArray.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
      this.h = localTypedArray.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
      paramInt = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
      this.c.left = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, paramInt);
      this.c.top = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, paramInt);
      this.c.right = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, paramInt);
      this.c.bottom = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.a = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
      this.b = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
      localTypedArray.recycle();
      f.initialize(this.i, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(e);
    paramInt = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = new float[3];
    Color.colorToHSV(paramInt, paramAttributeSet);
    if (paramAttributeSet[2] > 0.5F) {}
    for (paramInt = getResources().getColor(R.color.cardview_light_background);; paramInt = getResources().getColor(R.color.cardview_dark_background))
    {
      paramAttributeSet = ColorStateList.valueOf(paramInt);
      break;
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return f.getBackgroundColor(this.i);
  }
  
  public float getCardElevation()
  {
    return f.getElevation(this.i);
  }
  
  public int getContentPaddingBottom()
  {
    return this.c.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.c.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.c.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.c.top;
  }
  
  public float getMaxCardElevation()
  {
    return f.getMaxElevation(this.i);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.h;
  }
  
  public float getRadius()
  {
    return f.getRadius(this.i);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.g;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(f instanceof o))
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      switch (j)
      {
      default: 
        j = View.MeasureSpec.getMode(paramInt2);
        switch (j)
        {
        }
        break;
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.getMinWidth(this.i)), View.MeasureSpec.getSize(paramInt1)), j);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.getMinHeight(this.i)), View.MeasureSpec.getSize(paramInt2)), j);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    f.setBackgroundColor(this.i, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    f.setBackgroundColor(this.i, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    f.setElevation(this.i, paramFloat);
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    f.updatePadding(this.i);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    f.setMaxElevation(this.i, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.b = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.a = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.h)
    {
      this.h = paramBoolean;
      f.onPreventCornerOverlapChanged(this.i);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    f.setRadius(this.i, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      f.onCompatPaddingChanged(this.i);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/CardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */