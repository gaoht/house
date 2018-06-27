package cn.jpush.android.c;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;

public final class b
{
  public static ArrayList<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */