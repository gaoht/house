package com.ziroom.ziroomcustomer.minsu.homecolumn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.homecolumn.a.a.a;
import com.ziroom.ziroomcustomer.minsu.homecolumn.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuArticleColumnActivity
  extends BaseActivity
{
  private a a;
  private List<a.a.a> b;
  @BindView(2131691043)
  BasicZiroomToolBar bztb_title;
  @BindView(2131691646)
  RecyclerView rv_list;
  
  private void a()
  {
    this.rv_list.setLayoutManager(new LinearLayoutManager(this, 1, false));
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.a = new a(new ArrayList(), this, localIntent.getIntExtra("type", 1));
    this.rv_list.setAdapter(this.a);
    switch (localIntent.getIntExtra("type", 1))
    {
    default: 
      return;
    case 1: 
      com.ziroom.ziroomcustomer.minsu.e.a.getRefreshHeartList(this, new com.ziroom.commonlibrary.a.a(this, new d(com.ziroom.ziroomcustomer.minsu.homecolumn.a.a.class))
      {
        public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.minsu.homecolumn.a.a paramAnonymousa)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousa);
          if ((paramAnonymousa != null) && (paramAnonymousa.getData() != null))
          {
            MinsuArticleColumnActivity.a(MinsuArticleColumnActivity.this, paramAnonymousa.getData().getLunbo());
            MinsuArticleColumnActivity.b(MinsuArticleColumnActivity.this).setDatas(MinsuArticleColumnActivity.a(MinsuArticleColumnActivity.this));
          }
        }
      });
      this.bztb_title.setTitle("焕心之旅");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getLandlordStoryList(this, new com.ziroom.commonlibrary.a.a(this, new d(com.ziroom.ziroomcustomer.minsu.homecolumn.a.a.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.minsu.homecolumn.a.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        if ((paramAnonymousa != null) && (paramAnonymousa.getData() != null))
        {
          MinsuArticleColumnActivity.a(MinsuArticleColumnActivity.this, paramAnonymousa.getData().getLunbo());
          MinsuArticleColumnActivity.b(MinsuArticleColumnActivity.this).setDatas(MinsuArticleColumnActivity.a(MinsuArticleColumnActivity.this));
        }
      }
    });
    this.bztb_title.setTitle("旅行者和房东故事");
  }
  
  private void e() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903325);
    ButterKnife.bind(this);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/homecolumn/MinsuArticleColumnActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */