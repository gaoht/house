package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class d
{
  private int a;
  private Context b;
  private String c;
  private Drawable d;
  private Drawable e;
  private int f;
  private int g;
  private int h;
  
  public d(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public Drawable getBackground()
  {
    return this.e;
  }
  
  public Drawable getIcon()
  {
    return this.d;
  }
  
  public int getId()
  {
    return this.a;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  public int getTitleColor()
  {
    return this.f;
  }
  
  public int getTitleSize()
  {
    return this.g;
  }
  
  public int getWidth()
  {
    return this.h;
  }
  
  public void setBackground(int paramInt)
  {
    this.e = this.b.getResources().getDrawable(paramInt);
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    this.e = paramDrawable;
  }
  
  public void setIcon(int paramInt)
  {
    this.d = this.b.getResources().getDrawable(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.d = paramDrawable;
  }
  
  public void setId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.b.getString(paramInt));
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTitleColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTitleSize(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */