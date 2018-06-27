package com.ziroom.ziroomcustomer.newmovehouse.widget;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.ziroom.ziroomcustomer.newmovehouse.widget.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class b
  implements a
{
  private final HashSet<LoadingLayout> a = new HashSet();
  
  public void addLayout(LoadingLayout paramLoadingLayout)
  {
    if (paramLoadingLayout != null) {
      this.a.add(paramLoadingLayout);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setTextTypeface(paramTypeface);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */