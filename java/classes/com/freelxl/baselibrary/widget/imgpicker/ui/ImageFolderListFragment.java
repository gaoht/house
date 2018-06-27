package com.freelxl.baselibrary.widget.imgpicker.ui;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.R.id;
import com.freelxl.baselibrary.R.layout;
import com.freelxl.baselibrary.R.string;
import com.freelxl.baselibrary.widget.imgpicker.b.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageFolderListFragment
  extends DialogFragment
{
  RecyclerView a;
  List<b> b = new ArrayList();
  RecyclerView.a c;
  boolean d = true;
  String e;
  
  public static ImageFolderListFragment getInstance()
  {
    return new ImageFolderListFragment();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new Dialog(getActivity());
    Window localWindow = paramBundle.getWindow();
    localWindow.requestFeature(1);
    paramBundle.setContentView(R.layout.fragment_imagefolder_list);
    this.a = ((RecyclerView)paramBundle.findViewById(R.id.rv));
    this.e = getResources().getString(R.string.imgpicker_title_all);
    localWindow.setBackgroundDrawable(new ColorDrawable(0));
    localWindow.setDimAmount(0.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i = localDisplayMetrics.heightPixels * 2 / 3;
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = i;
    localLayoutParams.gravity = 48;
    localLayoutParams.y = ((int)(localDisplayMetrics.density * 57.0F + 0.5F));
    localWindow.setAttributes(localLayoutParams);
    this.c = new a(getActivity(), (c)getActivity());
    this.a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.a.setAdapter(this.c);
    new b(getActivity()).execute(new String[0]);
    return paramBundle;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ((c)getActivity()).onFolderDismiss();
    super.onDismiss(paramDialogInterface);
  }
  
  private class a
    extends RecyclerView.a
  {
    private Context b;
    private com.freelxl.baselibrary.widget.imgpicker.c.a c;
    private ImageFolderListFragment.c d;
    
    public a(Context paramContext, ImageFolderListFragment.c paramc)
    {
      this.b = paramContext;
      this.c = new com.freelxl.baselibrary.widget.imgpicker.c.a(paramContext);
      this.d = paramc;
    }
    
    public int getItemCount()
    {
      if (ImageFolderListFragment.this.b == null) {
        return 0;
      }
      return ImageFolderListFragment.this.b.size();
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
    {
      ImageView localImageView = ((a)paramu).a;
      TextView localTextView1 = ((a)paramu).b;
      TextView localTextView2 = ((a)paramu).c;
      final b localb = (b)ImageFolderListFragment.this.b.get(paramInt);
      this.c.bindBitmap(new com.freelxl.baselibrary.widget.imgpicker.b.a(null, localb.c, null), localImageView, ((a)paramu).d, ((a)paramu).d);
      localTextView1.setText(localb.a);
      localTextView2.setText(localb.d + "");
      paramu.itemView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ImageFolderListFragment.a.a(ImageFolderListFragment.a.this).onFolderSelected(localb.a, localb.b, localb.c, localb.d);
        }
      });
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(this.b).inflate(R.layout.layout_imagefolder_list_item, paramViewGroup, false));
    }
    
    private class a
      extends RecyclerView.u
    {
      ImageView a;
      TextView b;
      TextView c;
      int d = (int)(ImageFolderListFragment.this.getResources().getDisplayMetrics().density * 64.0F + 0.5F);
      
      public a(View paramView)
      {
        super();
        this.a = ((ImageView)paramView.findViewById(R.id.iv));
        this.b = ((TextView)paramView.findViewById(R.id.tv_name));
        this.c = ((TextView)paramView.findViewById(R.id.tv_count));
      }
    }
  }
  
  private class b
    extends AsyncTask<String, Integer, List<b>>
  {
    final String[] a = { "_data" };
    final String b = "mime_type=? or mime_type=?";
    final String c = "date_modified desc";
    private Context e;
    
    public b(Context paramContext)
    {
      this.e = paramContext;
    }
    
    protected List<b> a(String... paramVarArgs)
    {
      ArrayList localArrayList = new ArrayList();
      Cursor localCursor = this.e.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.a, "mime_type=? or mime_type=?", new String[] { "image/jpeg", "image/png" }, "date_modified desc");
      HashSet localHashSet = new HashSet();
      int i = 0;
      paramVarArgs = null;
      while (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(localCursor.getColumnIndex("_data"));
        Object localObject = paramVarArgs;
        if (paramVarArgs == null) {
          localObject = str1;
        }
        File localFile = new File(str1).getParentFile();
        paramVarArgs = (String[])localObject;
        if (localFile != null)
        {
          String str2 = localFile.getAbsolutePath();
          paramVarArgs = (String[])localObject;
          if (!localHashSet.contains(str2))
          {
            localHashSet.add(str2);
            paramVarArgs = (String[])localObject;
            if (localFile.list() != null)
            {
              int j = localFile.list(new FilenameFilter()
              {
                public boolean accept(File paramAnonymousFile, String paramAnonymousString)
                {
                  paramAnonymousFile = paramAnonymousString.toLowerCase();
                  return (paramAnonymousFile.endsWith(".jpg")) || (paramAnonymousFile.endsWith(".png")) || (paramAnonymousFile.endsWith(".jpeg"));
                }
              }).length;
              if (j > 0) {
                localArrayList.add(new b(localFile.getName(), str2, str1, j));
              }
              i += j;
              paramVarArgs = (String[])localObject;
            }
          }
        }
      }
      localCursor.close();
      localArrayList.add(0, new b(ImageFolderListFragment.this.e, "", paramVarArgs, i));
      return localArrayList;
    }
    
    protected void a(List<b> paramList)
    {
      super.onPostExecute(paramList);
      ImageFolderListFragment.this.b = paramList;
      ImageFolderListFragment.this.c.notifyDataSetChanged();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  public static abstract interface c
  {
    public abstract void onFolderDismiss();
    
    public abstract void onFolderSelected(String paramString1, String paramString2, String paramString3, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/ui/ImageFolderListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */