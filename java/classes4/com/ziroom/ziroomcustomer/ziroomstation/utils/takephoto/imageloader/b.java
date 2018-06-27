package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.imageloader;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b.d;
import java.util.LinkedList;
import java.util.List;

public class b
  extends com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b.b<String>
{
  public static List<String> a = new LinkedList();
  int b;
  private String g;
  private a h;
  
  public b(Context paramContext, int paramInt1, List<String> paramList, int paramInt2, String paramString)
  {
    super(paramContext, paramList, paramInt2);
    this.g = paramString;
    this.b = paramInt1;
  }
  
  public void convert(final d paramd, final String paramString)
  {
    paramd.setImageResource(2131694453, 2130839300);
    paramd.setImageResource(2131694454, 2130839299);
    paramd.setImageByUrl(2131694453, this.g + "/" + paramString);
    final ImageView localImageView = (ImageView)paramd.getView(2131694453);
    paramd = (ImageView)paramd.getView(2131694454);
    localImageView.setColorFilter(null);
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (b.this.b == b.a.size()) {
          g.textToast(b.a(b.this), "最多可以选择" + b.this.b + "张图片");
        }
        for (;;)
        {
          return;
          if (b.a.contains(b.b(b.this) + "/" + paramString))
          {
            b.a.remove(b.b(b.this) + "/" + paramString);
            paramd.setImageResource(2130839299);
            localImageView.setColorFilter(null);
          }
          while (b.c(b.this) != null)
          {
            b.c(b.this).onImgSelected(b.a);
            return;
            b.a.add(b.b(b.this) + "/" + paramString);
            paramd.setImageResource(2130839301);
            localImageView.setColorFilter(Color.parseColor("#77000000"));
          }
        }
      }
    });
    if (a.contains(this.g + "/" + paramString))
    {
      paramd.setImageResource(2130839301);
      localImageView.setColorFilter(Color.parseColor("#77000000"));
    }
  }
  
  public void setImgSelectesListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onImgSelected(List<String> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/imageloader/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */