package com.freelxl.baselibrary.widget.imgpicker.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.freelxl.baselibrary.R.drawable;
import com.freelxl.baselibrary.R.id;
import com.freelxl.baselibrary.R.layout;
import com.freelxl.baselibrary.widget.imgpicker.c.c;
import com.freelxl.baselibrary.widget.imgpicker.ui.view.SquareImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class ImageListFragment
  extends Fragment
{
  RecyclerView a;
  List<com.freelxl.baselibrary.widget.imgpicker.b.a> b;
  RecyclerView.a c;
  boolean d = true;
  int e;
  private final String f = "#camera#";
  
  public static ImageListFragment getInstance(String paramString1, String paramString2)
  {
    ImageListFragment localImageListFragment = new ImageListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("imageDir", paramString1);
    localBundle.putString("folderName", paramString2);
    localImageListFragment.setArguments(localBundle);
    return localImageListFragment;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.e = ((c.getScreenMetrics(getActivity()).widthPixels - (int)c.dp2px(getActivity(), 10.0F)) / 3);
    this.c = new a(getActivity());
    this.a.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    this.a.addItemDecoration(new com.freelxl.baselibrary.widget.imgpicker.ui.view.a(getActivity()));
    this.a.setAdapter(this.c);
    new b(getActivity()).execute(new String[] { getArguments().getString("imageDir"), getArguments().getString("folderName") });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fragment_image_list, paramViewGroup, false);
    this.a = ((RecyclerView)paramLayoutInflater.findViewById(R.id.rv));
    return paramLayoutInflater;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    VdsAgent.onFragmentPause(this);
  }
  
  public void onResume()
  {
    super.onResume();
    VdsAgent.onFragmentResume(this);
  }
  
  public void setImageListInfo(String paramString1, String paramString2)
  {
    new b(getActivity()).execute(new String[] { paramString1, paramString2 });
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
  }
  
  private class a
    extends RecyclerView.a
  {
    private Context b;
    private com.freelxl.baselibrary.widget.imgpicker.c.a c;
    private Drawable d = new ColorDrawable(-1);
    
    public a(Context paramContext)
    {
      this.b = paramContext;
      this.c = new com.freelxl.baselibrary.widget.imgpicker.c.a(paramContext);
    }
    
    public int getItemCount()
    {
      if (ImageListFragment.this.b == null) {
        return 0;
      }
      return ImageListFragment.this.b.size();
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
    {
      paramu = ((a)paramu).a;
      com.freelxl.baselibrary.widget.imgpicker.b.a locala = (com.freelxl.baselibrary.widget.imgpicker.b.a)ImageListFragment.this.b.get(paramInt);
      final String str = ((com.freelxl.baselibrary.widget.imgpicker.b.a)ImageListFragment.this.b.get(paramInt)).b;
      if (!str.equals((String)paramu.getTag())) {
        paramu.setImageDrawable(this.d);
      }
      paramu.setTag(str);
      if ("#camera#".equals(str))
      {
        paramu.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramu.setImageResource(R.drawable.ic_camera);
      }
      for (;;)
      {
        paramu.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if ("#camera#".equals(str))
            {
              ((ImageListFragment.c)ImageListFragment.this.getActivity()).onCameraSelect();
              return;
            }
            ((ImageListFragment.c)ImageListFragment.this.getActivity()).onImageSelect(str);
          }
        });
        return;
        paramu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.bindBitmap(locala, paramu, ImageListFragment.this.e, ImageListFragment.this.e);
      }
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(this.b).inflate(R.layout.layout_image_list_item, paramViewGroup, false));
    }
    
    private class a
      extends RecyclerView.u
    {
      SquareImageView a;
      
      public a(View paramView)
      {
        super();
        this.a = ((SquareImageView)paramView.findViewById(R.id.siv));
      }
    }
  }
  
  private class b
    extends AsyncTask<String, Integer, List<com.freelxl.baselibrary.widget.imgpicker.b.a>>
  {
    final String[] a = { "_id", "_display_name", "_data", "mini_thumb_magic" };
    final String b = "_data like ? and bucket_display_name like ?  and (mime_type=? or mime_type=?)";
    final String c = "mime_type=? or mime_type=?";
    final String d = "date_added desc";
    String[] e = null;
    private Context g;
    
    public b(Context paramContext)
    {
      this.g = paramContext;
    }
    
    protected List<com.freelxl.baselibrary.widget.imgpicker.b.a> a(String... paramVarArgs)
    {
      Object localObject = "";
      String str1;
      if ((paramVarArgs != null) && (paramVarArgs.length > 1))
      {
        str1 = paramVarArgs[0].trim();
        localObject = paramVarArgs[1];
      }
      for (paramVarArgs = str1;; paramVarArgs = "")
      {
        if ((TextUtils.isEmpty(paramVarArgs)) || (TextUtils.isEmpty((CharSequence)localObject)))
        {
          localObject = "mime_type=? or mime_type=?";
          this.e = new String[] { "image/jpeg", "image/png" };
        }
        int i;
        int j;
        int k;
        int m;
        int n;
        for (;;)
        {
          localObject = this.g.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.a, (String)localObject, this.e, "date_added desc");
          i = paramVarArgs.length();
          if (localObject == null) {
            break label402;
          }
          paramVarArgs = new ArrayList();
          j = ((Cursor)localObject).getColumnIndex("_data");
          k = ((Cursor)localObject).getColumnIndex("_display_name");
          m = ((Cursor)localObject).getColumnIndex("_id");
          n = ((Cursor)localObject).getColumnIndex("mini_thumb_magic");
          if (i != 0) {
            break;
          }
          paramVarArgs.add(new com.freelxl.baselibrary.widget.imgpicker.b.a(null, "#camera#", null));
          while (((Cursor)localObject).moveToNext()) {
            paramVarArgs.add(new com.freelxl.baselibrary.widget.imgpicker.b.a(Long.valueOf(((Cursor)localObject).getLong(m)), ((Cursor)localObject).getString(j), Integer.valueOf(((Cursor)localObject).getInt(n))));
          }
          str1 = "_data like ? and bucket_display_name like ?  and (mime_type=? or mime_type=?)";
          this.e = new String[] { paramVarArgs + "%", localObject, "image/jpeg", "image/png" };
          localObject = str1;
        }
        while (((Cursor)localObject).moveToNext())
        {
          str1 = ((Cursor)localObject).getString(j);
          String str2 = ((Cursor)localObject).getString(k);
          if ((str1 != null) && (str2 != null) && (str1.length() == str2.length() + i + 1)) {
            paramVarArgs.add(new com.freelxl.baselibrary.widget.imgpicker.b.a(Long.valueOf(((Cursor)localObject).getLong(m)), str1, Integer.valueOf(((Cursor)localObject).getInt(n))));
          }
        }
        ((Cursor)localObject).close();
        return paramVarArgs;
        label402:
        return null;
      }
    }
    
    protected void a(List<com.freelxl.baselibrary.widget.imgpicker.b.a> paramList)
    {
      super.onPostExecute(paramList);
      ImageListFragment.this.b = paramList;
      ImageListFragment.this.c.notifyDataSetChanged();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  public static abstract interface c
  {
    public abstract void onCameraSelect();
    
    public abstract void onImageSelect(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/ui/ImageListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */