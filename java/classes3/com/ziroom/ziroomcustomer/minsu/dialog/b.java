package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.a.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class b<T>
{
  private Dialog a;
  private Context b;
  private a<T> c;
  private a d;
  
  public b(Context paramContext, a<T> parama, String paramString)
  {
    this.b = paramContext;
    this.c = parama;
    a();
    a(paramString);
  }
  
  private void a()
  {
    this.a = new Dialog(this.b, 2131427824);
    this.a.setContentView(2130903831);
    this.a.getWindow().getAttributes().width = (ac.getScreenWidth(this.b) * 2 / 3);
    ListView localListView = (ListView)this.a.findViewById(2131691217);
    localListView.setAdapter(this.c);
    localListView.setOnItemClickListener(new b());
  }
  
  private void a(String paramString)
  {
    if (c.isNull(paramString))
    {
      this.a.findViewById(2131689533).setVisibility(8);
      this.a.findViewById(2131689578).setVisibility(8);
      return;
    }
    ((TextView)this.a.findViewById(2131689533)).setText(paramString);
  }
  
  public void dismiss()
  {
    this.a.dismiss();
  }
  
  public boolean isShow()
  {
    return this.a.isShowing();
  }
  
  public void setCallBack(a parama)
  {
    this.d = parama;
  }
  
  public b setCancelable(boolean paramBoolean)
  {
    this.a.setCancelable(paramBoolean);
    return this;
  }
  
  public void show()
  {
    Dialog localDialog = this.a;
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onSelect(T paramT);
  }
  
  public class b
    implements AdapterView.OnItemClickListener
  {
    public b() {}
    
    @Instrumented
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
      if (!c.isNull(b.a(b.this))) {
        b.a(b.this).onSelect(b.b(b.this).getDatas().get(paramInt));
      }
      b.this.dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */