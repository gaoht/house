package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class d
{
  private final SparseArray<View> a;
  private int b;
  private View c;
  
  private d(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.a = new SparseArray();
    this.c = LayoutInflater.from(paramContext).inflate(paramInt1, paramViewGroup, false);
    this.c.setTag(this);
  }
  
  public static d get(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return new d(paramContext, paramViewGroup, paramInt1, paramInt2);
    }
    paramContext = (d)paramView.getTag();
    paramContext.b = paramInt2;
    return paramContext;
  }
  
  public View getConvertView()
  {
    return this.c;
  }
  
  public int getPosition()
  {
    return this.b;
  }
  
  public <T extends View> T getView(int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.c.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public d setImageBitmap(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)getView(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }
  
  public d setImageByUrl(int paramInt, String paramString)
  {
    c.getInstance(3, c.c.b).loadImage(paramString, (ImageView)getView(paramInt));
    return this;
  }
  
  public d setImageResource(int paramInt1, int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public d setText(int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */