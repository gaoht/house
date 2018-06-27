package cn.jiguang.c.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

final class d
  extends SQLiteOpenHelper
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "/BV\021@?Q[\r%KY_a%3YJ\0253Kzi4\023\003Oj5\001\037yj5\t\bc";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 96;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "\001`l2\b4cm \024\002cm(\003\030>}#";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\037q{-\005Kzi4\023\003Oj5\001\037yj5\t\bc9(\023Kqu3\005\nt`";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "(B\\\0004.0M\000\"'U9+\020\036cq\036\023\037qm(\023\037yz2@COp%@\"^M\004'.B9\0212\"]X\0239K[\\\030@*EM\016)%SK\004-.^MaL\030dF2\017\031dF*\005\0220m$\030\0370w.\024K~l-\fGcm\036\016\016d95\005\023d9/\017\0370w4\f\007<j5?\bw/?\002`95\005\023d9/\017\0370w4\f\007<j5?\007z \f4tw2@\037ua5L\030dF2\017\036bz$@\002~m$\007\016b9/\017\0370w4\f\007<j5?\rqp-\005\0170p/\024\016w|3@\005ma\016\036|um\023\037Om.\024\n|9(\016\037u~$\022K~v5@\005eu-L\030dF\"\017\036~m\036QKyw5\005\fukm\023\037Oz.\025\005dFp?X0p/\024\016w|3L\030dF\"\017\036~m\036S4!)a\t\005d|&\005\031<j5?\bl/\0244!)a\t\005d|&\005\0319\"";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "8dx5\t\030dp\"\023/R";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 107;
        break label91;
        i = 16;
        break label91;
        i = 25;
        break label91;
        i = 65;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public d(Context paramContext)
  {
    this(paramContext, z[1], null, 1);
  }
  
  private d(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(z[3]);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      cn.jiguang.d.d.a(z[4], z[2]);
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL(z[0]);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */