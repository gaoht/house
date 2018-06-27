package cn.testin.analysis;

import java.util.List;
import org.json.JSONArray;

public class br
{
  public final cm a;
  public final List<String> b;
  public final String c;
  public final JSONArray d;
  
  private br(cm paramcm, String paramString, JSONArray paramJSONArray)
  {
    this(paramcm, paramString, paramJSONArray, null);
  }
  
  private br(cm paramcm, String paramString, JSONArray paramJSONArray, List<String> paramList)
  {
    this.a = paramcm;
    this.b = paramList;
    this.c = paramString;
    this.d = paramJSONArray;
  }
  
  public String a()
  {
    return this.c + ":" + this.d.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */