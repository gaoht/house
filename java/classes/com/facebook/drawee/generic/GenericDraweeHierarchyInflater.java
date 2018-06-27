package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater
{
  @Nullable
  private static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    if (paramInt == 0) {
      return null;
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    if (paramGenericDraweeHierarchyBuilder.getRoundingParams() == null) {
      paramGenericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
    }
    return paramGenericDraweeHierarchyBuilder.getRoundingParams();
  }
  
  @Nullable
  private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray paramTypedArray, int paramInt)
  {
    switch (paramTypedArray.getInt(paramInt, -2))
    {
    default: 
      throw new RuntimeException("XML attribute not specified!");
    case -1: 
      return null;
    case 0: 
      return ScalingUtils.ScaleType.FIT_XY;
    case 1: 
      return ScalingUtils.ScaleType.FIT_START;
    case 2: 
      return ScalingUtils.ScaleType.FIT_CENTER;
    case 3: 
      return ScalingUtils.ScaleType.FIT_END;
    case 4: 
      return ScalingUtils.ScaleType.CENTER;
    case 5: 
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    case 6: 
      return ScalingUtils.ScaleType.CENTER_CROP;
    }
    return ScalingUtils.ScaleType.FOCUS_CROP;
  }
  
  public static GenericDraweeHierarchyBuilder inflateBuilder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return updateBuilder(new GenericDraweeHierarchyBuilder(paramContext.getResources()), paramContext, paramAttributeSet);
  }
  
  public static GenericDraweeHierarchy inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return inflateBuilder(paramContext, paramAttributeSet).build();
  }
  
  public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder, Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    boolean bool5 = true;
    boolean bool1 = true;
    int k = 0;
    int i = 0;
    if (paramAttributeSet != null) {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GenericDraweeHierarchy);
    }
    for (;;)
    {
      int i2;
      boolean bool6;
      boolean bool7;
      boolean bool8;
      int m;
      int n;
      try
      {
        int i1 = paramAttributeSet.getIndexCount();
        k = 0;
        bool2 = true;
        bool3 = true;
        bool4 = true;
        j = 0;
        if (k >= i1) {
          break label1243;
        }
        i2 = paramAttributeSet.getIndex(k);
        if (i2 == R.styleable.GenericDraweeHierarchy_actualImageScaleType)
        {
          paramGenericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          m = i;
          n = j;
        }
        else if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImage)
        {
          paramGenericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(paramContext, paramAttributeSet, i2));
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          m = i;
          n = j;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (i2 == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage)
      {
        paramGenericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImage)
      {
        paramGenericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_fadeDuration)
      {
        paramGenericDraweeHierarchyBuilder.setFadeDuration(paramAttributeSet.getInt(i2, 0));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_viewAspectRatio)
      {
        paramGenericDraweeHierarchyBuilder.setDesiredAspectRatio(paramAttributeSet.getFloat(i2, 0.0F));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_retryImage)
      {
        paramGenericDraweeHierarchyBuilder.setRetryImage(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_retryImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_failureImage)
      {
        paramGenericDraweeHierarchyBuilder.setFailureImage(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_failureImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval)
      {
        n = paramAttributeSet.getInteger(i2, j);
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_backgroundImage)
      {
        paramGenericDraweeHierarchyBuilder.setBackground(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_overlayImage)
      {
        paramGenericDraweeHierarchyBuilder.setOverlay(getDrawable(paramContext, paramAttributeSet, i2));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundAsCircle)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setRoundAsCircle(paramAttributeSet.getBoolean(i2, false));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundedCornerRadius)
      {
        m = paramAttributeSet.getDimensionPixelSize(i2, i);
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundTopLeft)
      {
        bool8 = paramAttributeSet.getBoolean(i2, bool4);
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundTopRight)
      {
        bool7 = paramAttributeSet.getBoolean(i2, bool3);
        bool5 = bool1;
        bool6 = bool2;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomLeft)
      {
        bool6 = paramAttributeSet.getBoolean(i2, bool2);
        bool5 = bool1;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomRight)
      {
        bool5 = paramAttributeSet.getBoolean(i2, bool1);
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setOverlayColor(paramAttributeSet.getColor(i2, 0));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderWidth)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderWidth(paramAttributeSet.getDimensionPixelSize(i2, 0));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderColor)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderColor(paramAttributeSet.getColor(i2, 0));
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
      }
      else
      {
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        m = i;
        n = j;
        if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderPadding)
        {
          getRoundingParams(paramGenericDraweeHierarchyBuilder).setPadding(paramAttributeSet.getDimensionPixelSize(i2, 0));
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          m = i;
          n = j;
          break label1386;
          label1243:
          paramAttributeSet.recycle();
          for (;;)
          {
            if ((paramGenericDraweeHierarchyBuilder.getProgressBarImage() != null) && (j > 0)) {
              paramGenericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(paramGenericDraweeHierarchyBuilder.getProgressBarImage(), j));
            }
            float f1;
            float f2;
            label1306:
            float f3;
            if (i > 0)
            {
              paramContext = getRoundingParams(paramGenericDraweeHierarchyBuilder);
              if (!bool4) {
                break label1340;
              }
              f1 = i;
              if (!bool3) {
                break label1345;
              }
              f2 = i;
              if (!bool1) {
                break label1351;
              }
              f3 = i;
              label1316:
              if (!bool2) {
                break label1357;
              }
            }
            label1340:
            label1345:
            label1351:
            label1357:
            for (float f4 = i;; f4 = 0.0F)
            {
              paramContext.setCornersRadii(f1, f2, f3, f4);
              return paramGenericDraweeHierarchyBuilder;
              f1 = 0.0F;
              break;
              f2 = 0.0F;
              break label1306;
              f3 = 0.0F;
              break label1316;
            }
            bool2 = true;
            bool3 = true;
            bool4 = true;
            j = 0;
            bool1 = bool5;
            i = k;
          }
        }
      }
      label1386:
      k += 1;
      bool1 = bool5;
      boolean bool2 = bool6;
      boolean bool3 = bool7;
      boolean bool4 = bool8;
      i = m;
      int j = n;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/generic/GenericDraweeHierarchyInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */