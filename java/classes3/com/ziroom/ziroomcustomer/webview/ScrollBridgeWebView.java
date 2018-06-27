package com.ziroom.ziroomcustomer.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.freelxl.baselibrary.webview.BridgeWebView;

public class ScrollBridgeWebView
  extends BridgeWebView
{
  private a d;
  
  public ScrollBridgeWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollBridgeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScrollBridgeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d != null) {
      this.d.onScroll(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnScrollChangedCallback(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(MotionEvent paramMotionEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/ScrollBridgeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */