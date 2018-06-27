package com.freelxl.baselibrary.widget.imgpicker;

import android.content.Context;
import android.content.Intent;
import com.freelxl.baselibrary.widget.imgpicker.a.b;
import com.freelxl.baselibrary.widget.imgpicker.a.c;
import com.freelxl.baselibrary.widget.imgpicker.ui.PickerActivity;

public class a
{
  private static a a;
  private com.freelxl.baselibrary.widget.imgpicker.a.a b = new c();
  private com.freelxl.baselibrary.widget.imgpicker.a.a c;
  
  private a(Context paramContext)
  {
    this.c = new b(paramContext);
  }
  
  public static a getInstance(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public static Intent getPickerIntent(Context paramContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    return getPickerIntent(paramContext, paramBoolean1, paramInt1, paramBoolean2, paramInt2, paramInt3, 1, 1);
  }
  
  public static Intent getPickerIntent(Context paramContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = new Intent(paramContext, PickerActivity.class);
    paramContext.putExtra("isMulti", paramBoolean1);
    paramContext.putExtra("multiNum", paramInt1);
    paramContext.putExtra("isCrop", paramBoolean2);
    paramContext.putExtra("cropWidth", paramInt2);
    paramContext.putExtra("cropHeight", paramInt3);
    paramContext.putExtra("aspectWidth", paramInt4);
    paramContext.putExtra("aspectHeight", paramInt5);
    return paramContext;
  }
  
  public com.freelxl.baselibrary.widget.imgpicker.a.a getDiskCache()
  {
    return this.c;
  }
  
  public com.freelxl.baselibrary.widget.imgpicker.a.a getMemoryCache()
  {
    return this.b;
  }
  
  public void setDiskCache(com.freelxl.baselibrary.widget.imgpicker.a.a parama)
  {
    this.c = parama;
  }
  
  public void setMemoryCache(com.freelxl.baselibrary.widget.imgpicker.a.a parama)
  {
    this.b = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */