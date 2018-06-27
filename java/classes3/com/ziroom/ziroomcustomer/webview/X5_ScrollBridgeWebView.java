package com.ziroom.ziroomcustomer.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.freelxl.baselibrary.webview.X5_BridgeWebView;

public class X5_ScrollBridgeWebView
  extends X5_BridgeWebView
{
  private ScrollBridgeWebView.a e;
  
  public X5_ScrollBridgeWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public X5_ScrollBridgeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public X5_ScrollBridgeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e != null) {
      this.e.onScroll(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnScrollChangedCallback(ScrollBridgeWebView.a parama)
  {
    this.e = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/X5_ScrollBridgeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */