package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.RoomPicListBean;
import java.util.List;

public class LandlordReleasePreviewSelectActivity
  extends BaseActivity
{
  private Context a;
  private LandlordReleasePhotoBean b;
  @BindView(2131690078)
  View btn_cancel;
  @BindView(2131691552)
  ListView lv_room;
  
  private void a()
  {
    this.b = ((LandlordReleasePhotoBean)getIntent().getSerializableExtra("data"));
    if ((this.b != null) && (this.b.getData() != null) && (this.b.getData().getRoomPicList() != null))
    {
      a locala = new a(null);
      this.lv_room.setAdapter(locala);
      this.lv_room.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)LandlordReleasePreviewSelectActivity.a(LandlordReleasePreviewSelectActivity.this).getData().getRoomPicList().get(paramAnonymousInt)).getRoomFid();
          k.toHouseDetail(LandlordReleasePreviewSelectActivity.b(LandlordReleasePreviewSelectActivity.this), paramAnonymousAdapterView, "1", false);
          LandlordReleasePreviewSelectActivity.this.finish();
        }
      });
    }
  }
  
  @OnClick({2131690078})
  public void OnClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903304);
    this.a = this;
    ButterKnife.bind(this);
    a();
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (LandlordReleasePreviewSelectActivity.a(LandlordReleasePreviewSelectActivity.this).getData().getRoomPicList() == null) {
        return 0;
      }
      return LandlordReleasePreviewSelectActivity.a(LandlordReleasePreviewSelectActivity.this).getData().getRoomPicList().size();
    }
    
    public Object getItem(int paramInt)
    {
      return LandlordReleasePreviewSelectActivity.a(LandlordReleasePreviewSelectActivity.this).getData().getRoomPicList().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(LandlordReleasePreviewSelectActivity.b(LandlordReleasePreviewSelectActivity.this)).inflate(2130904326, paramViewGroup, false);
      ((TextView)paramView.findViewById(2131694290)).setText(((LandlordReleasePhotoBean.DataBean.RoomPicListBean)LandlordReleasePreviewSelectActivity.a(LandlordReleasePreviewSelectActivity.this).getData().getRoomPicList().get(paramInt)).getRoomName());
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleasePreviewSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */