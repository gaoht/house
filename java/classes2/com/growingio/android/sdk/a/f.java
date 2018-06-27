package com.growingio.android.sdk.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.models.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class f
{
  d a()
  {
    return d.a();
  }
  
  List<com.growingio.android.sdk.models.f> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (byte[])a().a(NetworkConfig.j()).second;
    Object localObject1;
    if (localObject2.length >= 0)
    {
      localObject1 = new JSONArray();
      try
      {
        localObject2 = new JSONArray(new String((byte[])localObject2));
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            int i;
            localObject2 = new com.growingio.android.sdk.models.f(((JSONArray)localObject1).getJSONObject(i));
            if ((!((com.growingio.android.sdk.models.f)localObject2).a) && ("Android".equalsIgnoreCase(((com.growingio.android.sdk.models.f)localObject2).e)) && (!TextUtils.isEmpty(((com.growingio.android.sdk.models.f)localObject2).f.d))) {
              localArrayList.add(localObject2);
            }
            i += 1;
          }
          localJSONException1 = localJSONException1;
          Log.d("GIO.TagAPI", "generate tags error", localJSONException1);
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
      i = 0;
      if (i >= ((JSONArray)localObject1).length()) {}
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */