package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView.ScaleType;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(14)
class ch
{
  private final ck a;
  private final List<cc> b;
  private final cj c;
  private final Handler d;
  private final cd e;
  
  public ch(List<cc> paramList, cd paramcd)
  {
    this.b = paramList;
    this.e = paramcd;
    this.d = new Handler(Looper.getMainLooper());
    this.a = new ck();
    this.c = new cj(255);
  }
  
  private void b(JsonWriter paramJsonWriter, View paramView)
  {
    float f2 = 0.0F;
    if ((paramView.getVisibility() == 4) && (a.o)) {
      return;
    }
    int i = paramView.getId();
    Object localObject;
    if (-1 == i)
    {
      localObject = null;
      paramJsonWriter.beginObject();
      paramJsonWriter.name("hashCode").value(paramView.hashCode());
      paramJsonWriter.name("id").value(i);
      paramJsonWriter.name("mp_id_name").value((String)localObject);
      localObject = paramView.getContentDescription();
      if (localObject != null) {
        break label502;
      }
      paramJsonWriter.name("contentDescription").nullValue();
      label99:
      localObject = paramView.getTag();
      if (localObject != null) {
        break label522;
      }
      paramJsonWriter.name("tag").nullValue();
      label120:
      paramJsonWriter.name("top").value(paramView.getTop());
      paramJsonWriter.name("left").value(paramView.getLeft());
      paramJsonWriter.name("width").value(paramView.getWidth());
      paramJsonWriter.name("height").value(paramView.getHeight());
      paramJsonWriter.name("scrollX").value(paramView.getScrollX());
      paramJsonWriter.name("scrollY").value(paramView.getScrollY());
      paramJsonWriter.name("visibility").value(paramView.getVisibility());
      if (Build.VERSION.SDK_INT < 11) {
        break label698;
      }
      f2 = paramView.getTranslationX();
    }
    label502:
    label522:
    label548:
    label628:
    label698:
    for (float f1 = paramView.getTranslationY();; f1 = 0.0F)
    {
      paramJsonWriter.name("translationX").value(f2);
      paramJsonWriter.name("translationY").value(f1);
      paramJsonWriter.name("classes");
      paramJsonWriter.beginArray();
      localObject = paramView.getClass();
      for (;;)
      {
        paramJsonWriter.value((String)this.c.get(localObject));
        localObject = ((Class)localObject).getSuperclass();
        if ((localObject == Object.class) || (localObject == null))
        {
          paramJsonWriter.endArray();
          c(paramJsonWriter, paramView);
          localObject = paramView.getParent();
          if (localObject != null)
          {
            if (!fn.a(localObject)) {
              break label548;
            }
            localObject = (ViewPager)localObject;
            i = fm.a((ViewPager)localObject, paramView);
            if (i != -1) {
              paramJsonWriter.name("index").value(i);
            }
            if (i != ((ViewPager)localObject).getCurrentItem()) {
              paramJsonWriter.name("hidden").value(8L);
            }
          }
          for (;;)
          {
            paramJsonWriter.name("subviews");
            paramJsonWriter.beginArray();
            if (!(paramView instanceof ViewGroup)) {
              break label628;
            }
            localObject = (ViewGroup)paramView;
            j = ((ViewGroup)localObject).getChildCount();
            i = 0;
            while (i < j)
            {
              View localView = ((ViewGroup)localObject).getChildAt(i);
              if (localView != null) {
                paramJsonWriter.value(localView.hashCode());
              }
              i += 1;
            }
            localObject = this.e.a(i);
            break;
            paramJsonWriter.name("contentDescription").value(((CharSequence)localObject).toString());
            break label99;
            if (!(localObject instanceof CharSequence)) {
              break label120;
            }
            paramJsonWriter.name("tag").value(localObject.toString());
            break label120;
            if ((localObject instanceof AbsListView))
            {
              i = ((AbsListView)localObject).getPositionForView(paramView);
              if (i >= 0) {
                paramJsonWriter.name("index").value(i);
              }
            }
            else if (fn.b(localObject))
            {
              i = ((RecyclerView)localObject).getChildLayoutPosition(paramView);
              if (i >= 0) {
                paramJsonWriter.name("index").value(i);
              }
            }
          }
          paramJsonWriter.endArray();
          paramJsonWriter.endObject();
          if (!(paramView instanceof ViewGroup)) {
            break;
          }
          paramView = (ViewGroup)paramView;
          int j = paramView.getChildCount();
          i = 0;
          while (i < j)
          {
            localObject = paramView.getChildAt(i);
            if (localObject != null) {
              b(paramJsonWriter, (View)localObject);
            }
            i += 1;
          }
          break;
        }
      }
    }
  }
  
  private void c(JsonWriter paramJsonWriter, View paramView)
  {
    Class localClass = paramView.getClass();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if ((localcc.b.isAssignableFrom(localClass)) && (localcc.c != null))
      {
        Object localObject1 = null;
        if ((!localcc.a.equals("image")) && (!localcc.a.equals("font")) && (!localcc.a.startsWith("compoundImages")))
        {
          for (;;)
          {
            try
            {
              if (!localcc.a.equals("background")) {
                continue;
              }
              localObject2 = paramView.getBackground();
              localObject1 = localObject2;
            }
            catch (df localdf)
            {
              Object localObject2;
              continue;
            }
            if (localObject1 == null) {
              break;
            }
            if (!(localObject1 instanceof Number)) {
              continue;
            }
            paramJsonWriter.name(localcc.a).value((Number)localObject1);
            break;
            localObject2 = localcc.c.a(paramView);
            localObject1 = localObject2;
          }
          if ((localObject1 instanceof Boolean))
          {
            paramJsonWriter.name(localcc.a).value(((Boolean)localObject1).booleanValue());
          }
          else if ((localObject1 instanceof ColorStateList))
          {
            paramJsonWriter.name(localcc.a).value(Integer.valueOf(((ColorStateList)localObject1).getDefaultColor()));
          }
          else if ((localObject1 instanceof ImageView.ScaleType))
          {
            paramJsonWriter.name(localcc.a).value(((ImageView.ScaleType)localObject1).name());
          }
          else if ((localObject1 instanceof Drawable))
          {
            localObject1 = (Drawable)localObject1;
            if ((localObject1 instanceof ColorDrawable))
            {
              paramJsonWriter.name(localcc.a);
              paramJsonWriter.beginObject();
              paramJsonWriter.name("color").value(((ColorDrawable)localObject1).getColor());
              paramJsonWriter.endObject();
            }
          }
          else
          {
            paramJsonWriter.name(localcc.a).value(localObject1.toString());
          }
        }
      }
    }
  }
  
  void a(JsonWriter paramJsonWriter, View paramView)
  {
    paramJsonWriter.beginArray();
    b(paramJsonWriter, paramView);
    paramJsonWriter.endArray();
  }
  
  public void a(cg<Activity> paramcg, OutputStream paramOutputStream)
  {
    this.a.a(paramcg);
    Object localObject = new FutureTask(this.a);
    this.d.post((Runnable)localObject);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream);
    paramcg = Collections.emptyList();
    localOutputStreamWriter.write("[");
    try
    {
      localObject = (List)((FutureTask)localObject).get(1L, TimeUnit.SECONDS);
      paramcg = (cg<Activity>)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        int j;
        int i;
        Log.d("ViewSnapshot", "Screenshot interrupted, no screenshot will be sent.", localInterruptedException);
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        Log.i("ViewSnapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", localTimeoutException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        Log.e("ViewSnapshot", "Exception thrown during screenshot attempt", localExecutionException);
      }
      localOutputStreamWriter.write("]");
      localOutputStreamWriter.flush();
    }
    j = paramcg.size();
    i = 0;
    while (i < j)
    {
      if (i > 0) {
        localOutputStreamWriter.write(",");
      }
      localObject = (cl)paramcg.get(i);
      localOutputStreamWriter.write("{");
      localOutputStreamWriter.write("\"activity\":");
      localOutputStreamWriter.write(JSONObject.quote(((cl)localObject).a));
      localOutputStreamWriter.write(",");
      localOutputStreamWriter.write("\"scale\":");
      localOutputStreamWriter.write(String.format("%s", new Object[] { Float.valueOf(((cl)localObject).d) }));
      localOutputStreamWriter.write(",");
      localOutputStreamWriter.write("\"serialized_objects\":");
      JsonWriter localJsonWriter = new JsonWriter(localOutputStreamWriter);
      localJsonWriter.beginObject();
      localJsonWriter.name("rootObject").value(((cl)localObject).b.hashCode());
      localJsonWriter.name("objects");
      a(localJsonWriter, ((cl)localObject).b);
      localJsonWriter.endObject();
      localJsonWriter.flush();
      localOutputStreamWriter.write(",");
      localOutputStreamWriter.write("\"screenshot\":");
      localOutputStreamWriter.flush();
      ((cl)localObject).c.a(Bitmap.CompressFormat.PNG, 100, paramOutputStream);
      localOutputStreamWriter.write("}");
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */