package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView.a;
import com.ziroom.ziroomcoloreggs.eggs.widget.SlideDeleteListView.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ErrorLogListActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  SlideDeleteListView a;
  TextView b;
  private ImageView c;
  private b d;
  
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
    this.a = ((SlideDeleteListView)findViewById(R.id.error_log_list));
    this.b = ((TextView)findViewById(R.id.error_log_not_file_tv));
    this.c = ((ImageView)findViewById(R.id.iv_back));
    this.c.setOnClickListener(this);
    this.a.setOnItemClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.iv_back) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.error_log_list_activity);
    a();
    paramBundle = new File(a.c);
    File[] arrayOfFile = paramBundle.listFiles();
    if ((!paramBundle.exists()) || (arrayOfFile.length == 0))
    {
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    this.a.setVisibility(0);
    this.d = new b(a(arrayOfFile), this);
    this.a.setAdapter(this.d);
    this.a.setRemoveListener(new SlideDeleteListView.b()
    {
      public void removeItem(SlideDeleteListView.a paramAnonymousa, int paramAnonymousInt)
      {
        ErrorLogListActivity.a(ErrorLogListActivity.this).updateDataSet(paramAnonymousInt);
      }
    });
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = new Intent(this, ErrorLogInfoActivity.class);
    paramAdapterView.putExtra("fileName", ((File)this.d.getmFile().get(paramInt)).getName());
    paramAdapterView.putExtra("path", ((File)this.d.getmFile().get(paramInt)).getPath());
    startActivity(paramAdapterView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/ErrorLogListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */