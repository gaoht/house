package in.srain.cube.views.ptr;

import android.content.Context;
import android.util.AttributeSet;

public class PtrClassicFrameLayout
  extends PtrFrameLayout
{
  private PtrClassicDefaultHeader d;
  
  public PtrClassicFrameLayout(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.d = new PtrClassicDefaultHeader(getContext());
    setHeaderView(this.d);
    addPtrUIHandler(this.d);
  }
  
  public PtrClassicDefaultHeader getHeader()
  {
    return this.d;
  }
  
  public void setLastUpdateTimeKey(String paramString)
  {
    if (this.d != null) {
      this.d.setLastUpdateTimeKey(paramString);
    }
  }
  
  public void setLastUpdateTimeRelateObject(Object paramObject)
  {
    if (this.d != null) {
      this.d.setLastUpdateTimeRelateObject(paramObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/PtrClassicFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */