package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.view.widget.a;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinsuLocalAlbumActivity
  extends BaseActivity
{
  ListView a;
  ImageView b;
  a c;
  View d;
  List<String> e;
  int f;
  View.OnClickListener g = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = new Intent("android.media.action.IMAGE_CAPTURE");
      paramAnonymousView.putExtra("output", Uri.fromFile(new File(a.getInstance().setCameraImgPath())));
      MinsuLocalAlbumActivity.this.startActivityForResult(paramAnonymousView, 2);
    }
  };
  
  public void initAdapter()
  {
    this.a.setAdapter(new a(this, this.c.getFolderMap()));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = a.getInstance().getCameraImgPath();
    if (TextUtils.isEmpty(paramIntent))
    {
      showToast("图片获取失败");
      return;
    }
    Object localObject = new File(paramIntent);
    if (((File)localObject).exists())
    {
      localObject = Uri.fromFile((File)localObject);
      a.a locala = new a.a();
      locala.setThumbnailUri(((Uri)localObject).toString());
      locala.setOriginalUri(((Uri)localObject).toString());
      locala.setOrientation(ad.getBitmapDegree(paramIntent));
      a.getInstance().getCheckedItems().add(locala);
      a.getInstance().setResultOk(true);
      new Thread(new Runnable()
      {
        public void run() {}
      });
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          MinsuLocalAlbumActivity.this.finish();
        }
      }, 1000L);
      return;
    }
    showToast("图片获取失败");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904911);
    this.a = ((ListView)findViewById(2131696895));
    this.d = findViewById(2131696894);
    this.d.setOnClickListener(this.g);
    this.d.setVisibility(8);
    this.b = ((ImageView)findViewById(2131692289));
    this.f = getIntent().getIntExtra("picMaxNum", 8);
    this.c = a.getInstance();
    findViewById(2131696892).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLocalAlbumActivity.this.setResult(0);
        MinsuLocalAlbumActivity.this.finish();
      }
    });
    new Thread(new Runnable()
    {
      public void run()
      {
        a.getInstance().initImage();
        MinsuLocalAlbumActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            MinsuLocalAlbumActivity.this.initAdapter();
            MinsuLocalAlbumActivity.this.b.clearAnimation();
            ((View)MinsuLocalAlbumActivity.this.b.getParent()).setVisibility(8);
            MinsuLocalAlbumActivity.this.a.setVisibility(0);
          }
        });
      }
    }).start();
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(MinsuLocalAlbumActivity.this, MinsuLocalAlbumDetailActivity.class);
        paramAnonymousAdapterView.putExtra("local_folder_name", (String)MinsuLocalAlbumActivity.this.e.get(paramAnonymousInt));
        paramAnonymousAdapterView.setFlags(33554432);
        paramAnonymousAdapterView.putExtra("picMaxNum", MinsuLocalAlbumActivity.this.f);
        MinsuLocalAlbumActivity.this.setResult(-1, paramAnonymousAdapterView);
        MinsuLocalAlbumActivity.this.finish();
      }
    });
  }
  
  public class a
    extends BaseAdapter
  {
    Map<String, List<a.a>> a;
    Context b;
    
    a(Map<String, List<a.a>> paramMap)
    {
      String str;
      this.a = str;
      this.b = paramMap;
      MinsuLocalAlbumActivity.this.e = new ArrayList();
      paramMap = str.entrySet().iterator();
      while (paramMap.hasNext())
      {
        str = (String)((Map.Entry)paramMap.next()).getKey();
        MinsuLocalAlbumActivity.this.e.add(str);
      }
      Collections.sort(MinsuLocalAlbumActivity.this.e, new Comparator()
      {
        public int compare(String paramAnonymousString1, String paramAnonymousString2)
        {
          int i = MinsuLocalAlbumActivity.this.c.getFolder(paramAnonymousString1).size();
          return Integer.valueOf(MinsuLocalAlbumActivity.this.c.getFolder(paramAnonymousString2).size()).compareTo(Integer.valueOf(i));
        }
      });
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramViewGroup = new a(null);
        paramView = LayoutInflater.from(this.b).inflate(2130904121, null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694826));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131694579));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        String str = (String)MinsuLocalAlbumActivity.this.e.get(paramInt);
        List localList = (List)this.a.get(str);
        paramViewGroup.b.setText(str + "(" + localList.size() + ")");
        if (localList.size() > 0)
        {
          paramViewGroup.a.setController(c.frescoController(((a.a)localList.get(0)).getThumbnailUri()));
          paramViewGroup.a.setHierarchy(d.getLocalAlbumHierarchy(MinsuLocalAlbumActivity.this));
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLocalAlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */