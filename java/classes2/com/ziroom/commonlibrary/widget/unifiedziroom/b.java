package com.ziroom.commonlibrary.widget.unifiedziroom;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class b
  extends a
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = localDisplay.getWidth();
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */