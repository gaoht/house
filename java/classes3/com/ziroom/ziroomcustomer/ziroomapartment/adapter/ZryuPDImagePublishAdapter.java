package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.model.ZSpaceImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a;
import java.util.ArrayList;
import java.util.List;

public class ZryuPDImagePublishAdapter
  extends BaseAdapter
{
  private List<ZSpaceImageItem> a = new ArrayList();
  private Context b;
  private int c;
  private int d;
  private boolean e = false;
  
  public ZryuPDImagePublishAdapter(Context paramContext, List<ZSpaceImageItem> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
    this.d = ((((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() - n.dip2px(paramContext, 46.0F)) / 3);
    this.c = this.d;
  }
  
  public int getCount()
  {
    if (this.a != null)
    {
      if (this.a.size() > 6)
      {
        this.e = true;
        return 6;
      }
      return this.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ViewHolder"})
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localViewHolder;
    }
    for (;;)
    {
      paramView.ivPdRevisionZspace.getLayoutParams().height = this.c;
      paramView.ivPdRevisionZspace.getLayoutParams().width = this.d;
      paramView.ivPdRevisionZspace.setTag(((ZSpaceImageItem)this.a.get(paramInt)).sourcePath);
      paramView.ivPdRevisionZspace.setController(c.frescoController(((ZSpaceImageItem)this.a.get(paramInt)).sourcePath, new Postprocessor()
      {
        public String getName()
        {
          return null;
        }
        
        public CacheKey getPostprocessorCacheKey()
        {
          return null;
        }
        
        public CloseableReference<Bitmap> process(Bitmap paramAnonymousBitmap, PlatformBitmapFactory paramAnonymousPlatformBitmapFactory)
        {
          ((ZSpaceImageItem)ZryuPDImagePublishAdapter.a(ZryuPDImagePublishAdapter.this).get(paramInt)).localPath = a.saveBitmap(paramAnonymousBitmap);
          return paramAnonymousPlatformBitmapFactory.createBitmap(paramAnonymousBitmap);
        }
      }));
      if ((paramInt != 5) || (!this.e)) {
        break;
      }
      paramView.tvSeeMoreZSpace.setVisibility(0);
      paramView.tvSeeMoreZSpace.getLayoutParams().height = this.c;
      paramView.tvSeeMoreZSpace.getLayoutParams().width = this.d;
      return paramViewGroup;
      paramViewGroup = View.inflate(this.b, 2130904428, null);
      paramView = new ViewHolder(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    paramView.tvSeeMoreZSpace.setVisibility(8);
    return paramViewGroup;
  }
  
  static class ViewHolder
  {
    @BindView(2131695460)
    SimpleDraweeView ivPdRevisionZspace;
    @BindView(2131695529)
    ImageView ivPdRevisionZspaceDefault;
    @BindView(2131695461)
    TextView tvSeeMoreZSpace;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/ZryuPDImagePublishAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */