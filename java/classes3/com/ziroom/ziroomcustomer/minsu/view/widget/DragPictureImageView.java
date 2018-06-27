package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

public class DragPictureImageView
  extends SimpleDraweeView
{
  private String a;
  private String b;
  private int c;
  private String d;
  private a.a.a e;
  private String f;
  private String g;
  private int h;
  private int i;
  private int j;
  
  public DragPictureImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragPictureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DragPictureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public DragPictureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public String getFid()
  {
    return this.f;
  }
  
  public String getHousePicType()
  {
    return this.g;
  }
  
  public int getIsDefault()
  {
    return this.h;
  }
  
  public int getOrientation()
  {
    return this.c;
  }
  
  public int getOriginHeight()
  {
    return this.i;
  }
  
  public int getOriginWidth()
  {
    return this.j;
  }
  
  public String getOriginalUri()
  {
    return this.a;
  }
  
  public a.a.a getPicType()
  {
    return this.e;
  }
  
  public String getPicUrl()
  {
    return this.d;
  }
  
  public String getThumbnailUri()
  {
    return this.b;
  }
  
  public void setFid(String paramString)
  {
    this.f = paramString;
  }
  
  public void setHousePicType(String paramString)
  {
    this.g = paramString;
  }
  
  public void setIsDefault(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOriginHeight(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setOriginWidth(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setOriginalUri(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPicType(a.a.a parama)
  {
    this.e = parama;
  }
  
  public void setPicUrl(String paramString)
  {
    this.d = paramString;
  }
  
  public void setThumbnailUri(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/DragPictureImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */