package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView.a;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebLogTimeListActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  SlideDeleteListView a;
  TextView b;
  private h c;
  private File d;
  private File[] e;
  private Handler f = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if ((!WebLogTimeListActivity.c(WebLogTimeListActivity.this).exists()) || (WebLogTimeListActivity.d(WebLogTimeListActivity.this).length == 0))
      {
        WebLogTimeListActivity.this.b.setVisibility(0);
        WebLogTimeListActivity.this.a.setVisibility(8);
        return;
      }
      WebLogTimeListActivity.this.b.setVisibility(8);
      WebLogTimeListActivity.this.a.setVisibility(0);
      WebLogTimeListActivity.a(WebLogTimeListActivity.this, new h(WebLogTimeListActivity.b(WebLogTimeListActivity.this, WebLogTimeListActivity.a(WebLogTimeListActivity.this, WebLogTimeListActivity.d(WebLogTimeListActivity.this))), WebLogTimeListActivity.this));
      WebLogTimeListActivity.this.a.setAdapter(WebLogTimeListActivity.e(WebLogTimeListActivity.this));
      WebLogTimeListActivity.this.a.setRemoveListener(new SlideDeleteListView.b()
      {
        public void removeItem(SlideDeleteListView.a paramAnonymous2a, int paramAnonymous2Int)
        {
          WebLogTimeListActivity.e(WebLogTimeListActivity.this).updateDataSet(paramAnonymous2Int);
        }
      });
    }
  };
  
  private long a(String paramString)
  {
    return Long.parseLong(paramString.substring(0, paramString.length() - 4).replace("-", "").replace(" ", "").replace(":", ""));
  }
  
  private List<File> a(File[] paramArrayOfFile)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfFile[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.a = ((SlideDeleteListView)findViewById(R.id.web_log_time_list));
    this.b = ((TextView)findViewById(R.id.web_log_time_tv));
    this.a.setOnItemClickListener(this);
  }
  
  private void b()
  {
    this.d = new File(l.a);
    this.e = this.d.listFiles();
  }
  
  private File[] b(File[] paramArrayOfFile)
  {
    int i = 0;
    while (i < paramArrayOfFile.length - 1)
    {
      int j = 0;
      while (j < paramArrayOfFile.length - 1 - i)
      {
        if (a(paramArrayOfFile[j].getName()) < a(paramArrayOfFile[(j + 1)].getName()))
        {
          File localFile = paramArrayOfFile[j];
          paramArrayOfFile[j] = paramArrayOfFile[(j + 1)];
          paramArrayOfFile[(j + 1)] = localFile;
        }
        j += 1;
      }
      i += 1;
    }
    return paramArrayOfFile;
  }
  
  private void c()
  {
    Object localObject = new File(l.a);
    if (!((File)localObject).exists()) {
      return;
    }
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].delete();
      i += 1;
    }
    b();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = paramView.getId();
    if (i == R.id.iv_back) {
      finish();
    }
    while (i != R.id.delete_all) {
      return;
    }
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.web_log_time_list_activity);
    a();
    new Thread(new Runnable()
    {
      public void run()
      {
        WebLogTimeListActivity.a(WebLogTimeListActivity.this);
        Message localMessage = new Message();
        localMessage.what = 19;
        WebLogTimeListActivity.b(WebLogTimeListActivity.this).sendMessage(localMessage);
      }
    }).start();
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = new Intent(this, WebLogHttpListActivity.class);
    paramAdapterView.putExtra("fileName", ((File)this.c.getmFile().get(paramInt)).getName());
    paramAdapterView.putExtra("path", ((File)this.c.getmFile().get(paramInt)).getPath());
    startActivity(paramAdapterView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/WebLogTimeListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */