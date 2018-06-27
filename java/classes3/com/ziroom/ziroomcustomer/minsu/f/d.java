package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.ziroom.ziroomcustomer.d.a.a;

public class d
{
  public static void LoadDrawableFromRes(int paramInt, ImageView paramImageView)
  {
    paramImageView.setImageResource(paramInt);
  }
  
  public static GenericDraweeHierarchy getCollectHouseOffLineHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setFadeDuration(300).setPlaceholderImage(a.a.b).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImage(paramContext.getResources().getDrawable(2130838651)).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
  }
  
  public static GenericDraweeHierarchy getHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setFadeDuration(300).setPlaceholderImage(a.a.b).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImage(a.a.b).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
  }
  
  public static GenericDraweeHierarchy getLocalAlbumHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setFadeDuration(300).setPlaceholderImage(2130838342).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImage(2130838342).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
  }
  
  public static GenericDraweeHierarchy getRoundingHierarchy(Context paramContext)
  {
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    return GenericDraweeHierarchyBuilder.newInstance(paramContext.getResources()).setPlaceholderImage(paramContext.getResources().getDrawable(2130838641)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImage(paramContext.getResources().getDrawable(2130838641)).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setRoundingParams(localRoundingParams).setFadeDuration(500).build();
  }
  
  public static GenericDraweeHierarchy getRoundingHierarchy(Context paramContext, float paramFloat)
  {
    RoundingParams localRoundingParams = RoundingParams.fromCornersRadius(paramFloat);
    return GenericDraweeHierarchyBuilder.newInstance(paramContext.getResources()).setPlaceholderImage(paramContext.getResources().getDrawable(2130838349)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImage(paramContext.getResources().getDrawable(2130838349)).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setRoundingParams(localRoundingParams).setFadeDuration(500).build();
  }
  
  public static GenericDraweeHierarchy getRoundingHierarchyTrans(Context paramContext)
  {
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    return GenericDraweeHierarchyBuilder.newInstance(paramContext.getResources()).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setRoundingParams(localRoundingParams).setFadeDuration(500).build();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */