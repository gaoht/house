package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageChooseActivity
  extends Activity
{
  private String a = ImageChooseActivity.class.getSimpleName();
  private List<ImageItem> b = new ArrayList();
  private String c;
  private int d;
  private GridView e;
  private TextView f;
  private TextView g;
  private c h;
  private Button i;
  private HashMap<String, ImageItem> j = new HashMap();
  
  private void a()
  {
    this.f = ((TextView)findViewById(2131689533));
    this.f.setText(this.c);
    this.e = ((GridView)findViewById(2131689486));
    this.e.setSelector(new ColorDrawable(0));
    this.h = new c(this, this.b);
    this.e.setAdapter(this.h);
    this.i = ((Button)findViewById(2131690957));
    this.g = ((TextView)findViewById(2131694457));
    this.i.setText("完成(" + this.j.size() + "/" + this.d + ")");
    this.h.notifyDataSetChanged();
  }
  
  private void b()
  {
    this.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        Intent localIntent = new Intent(ImageChooseActivity.this, StationEvaluateActivity.class);
        List localList = (List)ImageChooseActivity.this.getIntent().getSerializableExtra("image_list_selected");
        paramAnonymousView = localList;
        if (localList == null) {
          paramAnonymousView = new ArrayList();
        }
        paramAnonymousView.addAll(new ArrayList(ImageChooseActivity.a(ImageChooseActivity.this).values()));
        localIntent.putExtra("image_list_selected", (Serializable)paramAnonymousView);
        localIntent.putExtra("orderBid", ImageChooseActivity.this.getIntent().getStringExtra("orderBid"));
        localIntent.putExtra("projectBid", ImageChooseActivity.this.getIntent().getStringExtra("projectBid"));
        ImageChooseActivity.this.startActivity(localIntent);
        ImageChooseActivity.this.finish();
      }
    });
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (ImageItem)ImageChooseActivity.b(ImageChooseActivity.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView.isSelected)
        {
          paramAnonymousAdapterView.isSelected = false;
          ImageChooseActivity.a(ImageChooseActivity.this).remove(paramAnonymousAdapterView.imageId);
        }
        for (;;)
        {
          ImageChooseActivity.d(ImageChooseActivity.this).setText("完成(" + ImageChooseActivity.a(ImageChooseActivity.this).size() + "/" + ImageChooseActivity.c(ImageChooseActivity.this) + ")");
          ImageChooseActivity.e(ImageChooseActivity.this).notifyDataSetChanged();
          return;
          if (ImageChooseActivity.a(ImageChooseActivity.this).size() >= ImageChooseActivity.c(ImageChooseActivity.this))
          {
            g.textToast(ImageChooseActivity.this, "最多只能选择" + ImageChooseActivity.c(ImageChooseActivity.this) + "张图片了哦");
            return;
          }
          paramAnonymousAdapterView.isSelected = true;
          ImageChooseActivity.a(ImageChooseActivity.this).put(paramAnonymousAdapterView.imageId, paramAnonymousAdapterView);
        }
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ImageChooseActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903217);
    this.b = ((List)getIntent().getSerializableExtra("image_list"));
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.c = getIntent().getStringExtra("buck_name");
    if (TextUtils.isEmpty(this.c)) {
      this.c = "请选择";
    }
    this.d = getIntent().getIntExtra("can_add_image_size", 8);
    d.i(this.a, "getAvailableSize:" + this.d);
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ImageChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */