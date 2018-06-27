package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageBucket;
import com.ziroom.ziroomcustomer.ziroomstation.utils.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageBucketChooseActivity
  extends Activity
{
  private String a = ImageBucketChooseActivity.class.getSimpleName();
  private g b;
  private List<ImageBucket> c = new ArrayList();
  private ListView d;
  private b e;
  private int f;
  
  private void a()
  {
    this.c = this.b.getImagesBucketList(false);
    this.f = getIntent().getIntExtra("can_add_image_size", 8);
    d.i(this.a, "getAvailableSize:" + this.f);
  }
  
  private void a(int paramInt)
  {
    int j = this.c.size();
    int i = 0;
    if (i != j)
    {
      ImageBucket localImageBucket = (ImageBucket)this.c.get(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localImageBucket.selected = bool;
        i += 1;
        break;
      }
    }
    this.e.notifyDataSetChanged();
  }
  
  private void b()
  {
    this.d = ((ListView)findViewById(2131690955));
    this.e = new b(this, this.c);
    this.d.setAdapter(this.e);
    ((TextView)findViewById(2131689533)).setText("相册");
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ImageBucketChooseActivity.a(ImageBucketChooseActivity.this, paramAnonymousInt);
        paramAnonymousAdapterView = new Intent(ImageBucketChooseActivity.this, ImageChooseActivity.class);
        paramAnonymousAdapterView.putExtra("image_list", (Serializable)((ImageBucket)ImageBucketChooseActivity.a(ImageBucketChooseActivity.this).get(paramAnonymousInt)).imageList);
        paramAnonymousAdapterView.putExtra("buck_name", ((ImageBucket)ImageBucketChooseActivity.a(ImageBucketChooseActivity.this).get(paramAnonymousInt)).bucketName);
        paramAnonymousAdapterView.putExtra("can_add_image_size", ImageBucketChooseActivity.b(ImageBucketChooseActivity.this));
        paramAnonymousAdapterView.putExtra("orderBid", ImageBucketChooseActivity.this.getIntent().getStringExtra("orderBid"));
        paramAnonymousAdapterView.putExtra("projectBid", ImageBucketChooseActivity.this.getIntent().getStringExtra("projectBid"));
        paramAnonymousAdapterView.putExtra("image_list_selected", ImageBucketChooseActivity.this.getIntent().getSerializableExtra("image_list_selected"));
        ImageBucketChooseActivity.this.startActivity(paramAnonymousAdapterView);
        ImageBucketChooseActivity.this.finish();
      }
    });
    ((TextView)findViewById(2131694457)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ImageBucketChooseActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903216);
    this.b = g.getInstance(getApplicationContext());
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ImageBucketChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */