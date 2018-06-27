package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.imageloader;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b.d;
import java.util.List;

public class a
  extends com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b.a<com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a>
{
  private ListView d;
  private a e;
  
  public a(int paramInt1, int paramInt2, List<com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a> paramList, View paramView)
  {
    super(paramView, paramInt1, paramInt2, true, paramList);
  }
  
  protected void a(Object... paramVarArgs) {}
  
  public void init() {}
  
  public void initEvents()
  {
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (a.a(a.this) != null) {
          a.a(a.this).selected((com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a)a.b(a.this).get(paramAnonymousInt));
        }
      }
    });
  }
  
  public void initViews()
  {
    this.d = ((ListView)findViewById(2131696715));
    this.d.setAdapter(new b(this.b, this.c, 2130904851)
    {
      public void convert(d paramAnonymousd, com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a paramAnonymousa)
      {
        paramAnonymousd.setText(2131696717, paramAnonymousa.getName());
        paramAnonymousd.setImageByUrl(2131696716, paramAnonymousa.getFirstImagePath());
        paramAnonymousd.setText(2131696718, paramAnonymousa.getCount() + "张");
      }
    });
  }
  
  public void setOnImageDirSelected(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void selected(com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/imageloader/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */