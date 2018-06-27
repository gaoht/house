package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

class e
  extends a
  implements SectionIndexer
{
  SectionIndexer b;
  
  e(Context paramContext, f paramf)
  {
    super(paramContext, paramf);
    this.b = ((SectionIndexer)paramf);
  }
  
  public int getPositionForSection(int paramInt)
  {
    return this.b.getPositionForSection(paramInt);
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return this.b.getSectionForPosition(paramInt);
  }
  
  public Object[] getSections()
  {
    return this.b.getSections();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */