package com.freelxl.baselibrary.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.freelxl.baselibrary.R.id;
import com.freelxl.baselibrary.R.layout;
import com.growingio.android.sdk.agent.VdsAgent;

public class g
{
  private static Toast a;
  private static View b;
  
  public static void imageToast(Context paramContext, int paramInt, String paramString)
  {
    imageToast(paramContext, paramInt, paramString, 0);
  }
  
  public static void imageToast(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if ((f.notNull(paramString)) && (Thread.currentThread() == Looper.getMainLooper().getThread()) && (paramContext != null))
    {
      if (a == null) {
        a = new Toast(paramContext.getApplicationContext());
      }
      a.setGravity(17, 0, 0);
      localObject = a.getView();
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageResource(paramInt1);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.addView(localImageView);
      localLinearLayout.addView((View)localObject);
      a.setView(localLinearLayout);
      localObject = a;
      if ((localObject instanceof Toast)) {
        break label169;
      }
      ((Toast)localObject).show();
    }
    for (;;)
    {
      localObject = a;
      paramContext = Toast.makeText(paramContext, paramString + "", paramInt2);
      if ((paramContext instanceof Toast)) {
        break;
      }
      paramContext.show();
      return;
      label169:
      VdsAgent.showToast((Toast)localObject);
    }
    VdsAgent.showToast((Toast)paramContext);
  }
  
  public static void textToast(Context paramContext, int paramInt)
  {
    textToast(paramContext, paramInt, 0);
  }
  
  public static void textToast(Context paramContext, int paramInt1, int paramInt2)
  {
    textToast(paramContext, paramContext.getResources().getString(paramInt1), 0);
  }
  
  public static void textToast(Context paramContext, String paramString)
  {
    textToast(paramContext, paramString, 0);
  }
  
  public static void textToast(Context paramContext, String paramString, int paramInt)
  {
    if ((f.notNull(paramString)) && (Thread.currentThread() == Looper.getMainLooper().getThread()) && (paramContext != null))
    {
      if (b == null) {
        b = ((LayoutInflater)paramContext.getApplicationContext().getSystemService("layout_inflater")).inflate(R.layout.layout_unified_dialog, null);
      }
      if (a == null)
      {
        a = Toast.makeText(paramContext.getApplicationContext(), paramString, paramInt);
        paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 72.0F);
        a.setGravity(80, 0, paramInt);
      }
      ((TextView)b.findViewById(R.id.tv_message)).setText(paramString);
      a.setView(b);
      paramContext = a;
      if (!(paramContext instanceof Toast)) {
        paramContext.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */