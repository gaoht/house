package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import javax.annotation.Nullable;

public class SimpleDraweeView
  extends GenericDraweeView
{
  private static Supplier<? extends SimpleDraweeControllerBuilder> sDraweeControllerBuilderSupplier;
  private SimpleDraweeControllerBuilder mSimpleDraweeControllerBuilder;
  
  public SimpleDraweeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext, paramAttributeSet);
  }
  
  public SimpleDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext, paramGenericDraweeHierarchy);
    init(paramContext, null);
  }
  
  private void init(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (isInEditMode()) {}
    do
    {
      return;
      Preconditions.checkNotNull(sDraweeControllerBuilderSupplier, "SimpleDraweeView was not initialized!");
      this.mSimpleDraweeControllerBuilder = ((SimpleDraweeControllerBuilder)sDraweeControllerBuilderSupplier.get());
    } while (paramAttributeSet == null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleDraweeView);
    try
    {
      if (paramContext.hasValue(R.styleable.SimpleDraweeView_actualImageUri)) {
        setImageURI(Uri.parse(paramContext.getString(R.styleable.SimpleDraweeView_actualImageUri)), null);
      }
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static void initialize(Supplier<? extends SimpleDraweeControllerBuilder> paramSupplier)
  {
    sDraweeControllerBuilderSupplier = paramSupplier;
  }
  
  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
  }
  
  protected SimpleDraweeControllerBuilder getControllerBuilder()
  {
    return this.mSimpleDraweeControllerBuilder;
  }
  
  public void setImageURI(Uri paramUri)
  {
    setImageURI(paramUri, null);
  }
  
  public void setImageURI(Uri paramUri, @Nullable Object paramObject)
  {
    setController(this.mSimpleDraweeControllerBuilder.setCallerContext(paramObject).setUri(paramUri).setOldController(getController()).build());
  }
  
  public void setImageURI(@Nullable String paramString)
  {
    setImageURI(paramString, null);
  }
  
  public void setImageURI(@Nullable String paramString, @Nullable Object paramObject)
  {
    if (paramString != null) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      setImageURI(paramString, paramObject);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/view/SimpleDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */