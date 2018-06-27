package cn.testin.analysis;

public final class ic
{
  private static final int[] a = { 31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017 };
  private static final ic[] b = f();
  private final int c;
  private final int[] d;
  private final ie[] e;
  private final int f;
  
  private ic(int paramInt, int[] paramArrayOfInt, ie... paramVarArgs)
  {
    this.c = paramInt;
    this.d = paramArrayOfInt;
    this.e = paramVarArgs;
    int k = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].b();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.a();
      i += (paramVarArgs.b() + k) * j;
      paramInt += 1;
    }
    this.f = i;
  }
  
  public static ic a(int paramInt)
  {
    if (paramInt % 4 != 1) {
      throw ft.a();
    }
    try
    {
      ic localic = b((paramInt - 17) / 4);
      return localic;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw ft.a();
    }
  }
  
  public static ic b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return b[(paramInt - 1)];
  }
  
  static ic c(int paramInt)
  {
    int i = 0;
    int j = Integer.MAX_VALUE;
    int m = 0;
    while (i < a.length)
    {
      int k = a[i];
      if (k == paramInt) {
        return b(i + 7);
      }
      int n = hz.a(paramInt, k);
      k = j;
      if (n < j)
      {
        m = i + 7;
        k = n;
      }
      i += 1;
      j = k;
    }
    if (j <= 3) {
      return b(m);
    }
    return null;
  }
  
  private static ic[] f()
  {
    Object localObject1 = new ie(7, new id[] { new id(1, 19) });
    Object localObject2 = new ie(10, new id[] { new id(1, 16) });
    Object localObject3 = new ie(13, new id[] { new id(1, 13) });
    Object localObject4 = new ie(17, new id[] { new id(1, 9) });
    localObject1 = new ic(1, new int[0], new ie[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new ie(10, new id[] { new id(1, 34) });
    localObject3 = new ie(16, new id[] { new id(1, 28) });
    localObject4 = new ie(22, new id[] { new id(1, 22) });
    Object localObject5 = new ie(28, new id[] { new id(1, 16) });
    localObject2 = new ic(2, new int[] { 6, 18 }, new ie[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new ie(15, new id[] { new id(1, 55) });
    localObject4 = new ie(26, new id[] { new id(1, 44) });
    localObject5 = new ie(18, new id[] { new id(2, 17) });
    Object localObject6 = new ie(22, new id[] { new id(2, 13) });
    localObject3 = new ic(3, new int[] { 6, 22 }, new ie[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new ie(20, new id[] { new id(1, 80) });
    localObject5 = new ie(18, new id[] { new id(2, 32) });
    localObject6 = new ie(26, new id[] { new id(2, 24) });
    Object localObject7 = new ie(16, new id[] { new id(4, 9) });
    localObject4 = new ic(4, new int[] { 6, 26 }, new ie[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new ie(26, new id[] { new id(1, 108) });
    localObject6 = new ie(24, new id[] { new id(2, 43) });
    localObject7 = new ie(18, new id[] { new id(2, 15), new id(2, 16) });
    Object localObject8 = new ie(22, new id[] { new id(2, 11), new id(2, 12) });
    localObject5 = new ic(5, new int[] { 6, 30 }, new ie[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new ie(18, new id[] { new id(2, 68) });
    localObject7 = new ie(16, new id[] { new id(4, 27) });
    localObject8 = new ie(24, new id[] { new id(4, 19) });
    Object localObject9 = new ie(28, new id[] { new id(4, 15) });
    localObject6 = new ic(6, new int[] { 6, 34 }, new ie[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new ie(20, new id[] { new id(2, 78) });
    localObject8 = new ie(18, new id[] { new id(4, 31) });
    localObject9 = new ie(18, new id[] { new id(2, 14), new id(4, 15) });
    Object localObject10 = new ie(26, new id[] { new id(4, 13), new id(1, 14) });
    localObject7 = new ic(7, new int[] { 6, 22, 38 }, new ie[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new ie(24, new id[] { new id(2, 97) });
    localObject9 = new ie(22, new id[] { new id(2, 38), new id(2, 39) });
    localObject10 = new ie(22, new id[] { new id(4, 18), new id(2, 19) });
    Object localObject11 = new ie(26, new id[] { new id(4, 14), new id(2, 15) });
    localObject8 = new ic(8, new int[] { 6, 24, 42 }, new ie[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new ie(30, new id[] { new id(2, 116) });
    localObject10 = new ie(22, new id[] { new id(3, 36), new id(2, 37) });
    localObject11 = new ie(20, new id[] { new id(4, 16), new id(4, 17) });
    Object localObject12 = new ie(24, new id[] { new id(4, 12), new id(4, 13) });
    localObject9 = new ic(9, new int[] { 6, 26, 46 }, new ie[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new ie(18, new id[] { new id(2, 68), new id(2, 69) });
    localObject11 = new ie(26, new id[] { new id(4, 43), new id(1, 44) });
    localObject12 = new ie(24, new id[] { new id(6, 19), new id(2, 20) });
    Object localObject13 = new ie(28, new id[] { new id(6, 15), new id(2, 16) });
    localObject10 = new ic(10, new int[] { 6, 28, 50 }, new ie[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new ie(20, new id[] { new id(4, 81) });
    localObject12 = new ie(30, new id[] { new id(1, 50), new id(4, 51) });
    localObject13 = new ie(28, new id[] { new id(4, 22), new id(4, 23) });
    Object localObject14 = new ie(24, new id[] { new id(3, 12), new id(8, 13) });
    localObject11 = new ic(11, new int[] { 6, 30, 54 }, new ie[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new ie(24, new id[] { new id(2, 92), new id(2, 93) });
    localObject13 = new ie(22, new id[] { new id(6, 36), new id(2, 37) });
    localObject14 = new ie(26, new id[] { new id(4, 20), new id(6, 21) });
    Object localObject15 = new ie(28, new id[] { new id(7, 14), new id(4, 15) });
    localObject12 = new ic(12, new int[] { 6, 32, 58 }, new ie[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new ie(26, new id[] { new id(4, 107) });
    localObject14 = new ie(22, new id[] { new id(8, 37), new id(1, 38) });
    localObject15 = new ie(24, new id[] { new id(8, 20), new id(4, 21) });
    Object localObject16 = new ie(22, new id[] { new id(12, 11), new id(4, 12) });
    localObject13 = new ic(13, new int[] { 6, 34, 62 }, new ie[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new ie(30, new id[] { new id(3, 115), new id(1, 116) });
    localObject15 = new ie(24, new id[] { new id(4, 40), new id(5, 41) });
    localObject16 = new ie(20, new id[] { new id(11, 16), new id(5, 17) });
    Object localObject17 = new ie(24, new id[] { new id(11, 12), new id(5, 13) });
    localObject14 = new ic(14, new int[] { 6, 26, 46, 66 }, new ie[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new ie(22, new id[] { new id(5, 87), new id(1, 88) });
    localObject16 = new ie(24, new id[] { new id(5, 41), new id(5, 42) });
    localObject17 = new ie(30, new id[] { new id(5, 24), new id(7, 25) });
    Object localObject18 = new ie(24, new id[] { new id(11, 12), new id(7, 13) });
    localObject15 = new ic(15, new int[] { 6, 26, 48, 70 }, new ie[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new ie(24, new id[] { new id(5, 98), new id(1, 99) });
    localObject17 = new ie(28, new id[] { new id(7, 45), new id(3, 46) });
    localObject18 = new ie(24, new id[] { new id(15, 19), new id(2, 20) });
    Object localObject19 = new ie(30, new id[] { new id(3, 15), new id(13, 16) });
    localObject16 = new ic(16, new int[] { 6, 26, 50, 74 }, new ie[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new ie(28, new id[] { new id(1, 107), new id(5, 108) });
    localObject18 = new ie(28, new id[] { new id(10, 46), new id(1, 47) });
    localObject19 = new ie(28, new id[] { new id(1, 22), new id(15, 23) });
    Object localObject20 = new ie(28, new id[] { new id(2, 14), new id(17, 15) });
    localObject17 = new ic(17, new int[] { 6, 30, 54, 78 }, new ie[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new ie(30, new id[] { new id(5, 120), new id(1, 121) });
    localObject19 = new ie(26, new id[] { new id(9, 43), new id(4, 44) });
    localObject20 = new ie(28, new id[] { new id(17, 22), new id(1, 23) });
    Object localObject21 = new ie(28, new id[] { new id(2, 14), new id(19, 15) });
    localObject18 = new ic(18, new int[] { 6, 30, 56, 82 }, new ie[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new ie(28, new id[] { new id(3, 113), new id(4, 114) });
    localObject20 = new ie(26, new id[] { new id(3, 44), new id(11, 45) });
    localObject21 = new ie(26, new id[] { new id(17, 21), new id(4, 22) });
    Object localObject22 = new ie(26, new id[] { new id(9, 13), new id(16, 14) });
    localObject19 = new ic(19, new int[] { 6, 30, 58, 86 }, new ie[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new ie(28, new id[] { new id(3, 107), new id(5, 108) });
    localObject21 = new ie(26, new id[] { new id(3, 41), new id(13, 42) });
    localObject22 = new ie(30, new id[] { new id(15, 24), new id(5, 25) });
    Object localObject23 = new ie(28, new id[] { new id(15, 15), new id(10, 16) });
    localObject20 = new ic(20, new int[] { 6, 34, 62, 90 }, new ie[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new ie(28, new id[] { new id(4, 116), new id(4, 117) });
    localObject22 = new ie(26, new id[] { new id(17, 42) });
    localObject23 = new ie(28, new id[] { new id(17, 22), new id(6, 23) });
    Object localObject24 = new ie(30, new id[] { new id(19, 16), new id(6, 17) });
    localObject21 = new ic(21, new int[] { 6, 28, 50, 72, 94 }, new ie[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new ie(28, new id[] { new id(2, 111), new id(7, 112) });
    localObject23 = new ie(28, new id[] { new id(17, 46) });
    localObject24 = new ie(30, new id[] { new id(7, 24), new id(16, 25) });
    Object localObject25 = new ie(24, new id[] { new id(34, 13) });
    localObject22 = new ic(22, new int[] { 6, 26, 50, 74, 98 }, new ie[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new ie(30, new id[] { new id(4, 121), new id(5, 122) });
    localObject24 = new ie(28, new id[] { new id(4, 47), new id(14, 48) });
    localObject25 = new ie(30, new id[] { new id(11, 24), new id(14, 25) });
    Object localObject26 = new ie(30, new id[] { new id(16, 15), new id(14, 16) });
    localObject23 = new ic(23, new int[] { 6, 30, 54, 78, 102 }, new ie[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new ie(30, new id[] { new id(6, 117), new id(4, 118) });
    localObject25 = new ie(28, new id[] { new id(6, 45), new id(14, 46) });
    localObject26 = new ie(30, new id[] { new id(11, 24), new id(16, 25) });
    Object localObject27 = new ie(30, new id[] { new id(30, 16), new id(2, 17) });
    localObject24 = new ic(24, new int[] { 6, 28, 54, 80, 106 }, new ie[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new ie(26, new id[] { new id(8, 106), new id(4, 107) });
    localObject26 = new ie(28, new id[] { new id(8, 47), new id(13, 48) });
    localObject27 = new ie(30, new id[] { new id(7, 24), new id(22, 25) });
    Object localObject28 = new ie(30, new id[] { new id(22, 15), new id(13, 16) });
    localObject25 = new ic(25, new int[] { 6, 32, 58, 84, 110 }, new ie[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new ie(28, new id[] { new id(10, 114), new id(2, 115) });
    localObject27 = new ie(28, new id[] { new id(19, 46), new id(4, 47) });
    localObject28 = new ie(28, new id[] { new id(28, 22), new id(6, 23) });
    Object localObject29 = new ie(30, new id[] { new id(33, 16), new id(4, 17) });
    localObject26 = new ic(26, new int[] { 6, 30, 58, 86, 114 }, new ie[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new ie(30, new id[] { new id(8, 122), new id(4, 123) });
    localObject28 = new ie(28, new id[] { new id(22, 45), new id(3, 46) });
    localObject29 = new ie(30, new id[] { new id(8, 23), new id(26, 24) });
    Object localObject30 = new ie(30, new id[] { new id(12, 15), new id(28, 16) });
    localObject27 = new ic(27, new int[] { 6, 34, 62, 90, 118 }, new ie[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new ie(30, new id[] { new id(3, 117), new id(10, 118) });
    localObject29 = new ie(28, new id[] { new id(3, 45), new id(23, 46) });
    localObject30 = new ie(30, new id[] { new id(4, 24), new id(31, 25) });
    Object localObject31 = new ie(30, new id[] { new id(11, 15), new id(31, 16) });
    localObject28 = new ic(28, new int[] { 6, 26, 50, 74, 98, 122 }, new ie[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new ie(30, new id[] { new id(7, 116), new id(7, 117) });
    localObject30 = new ie(28, new id[] { new id(21, 45), new id(7, 46) });
    localObject31 = new ie(30, new id[] { new id(1, 23), new id(37, 24) });
    Object localObject32 = new ie(30, new id[] { new id(19, 15), new id(26, 16) });
    localObject29 = new ic(29, new int[] { 6, 30, 54, 78, 102, 126 }, new ie[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new ie(30, new id[] { new id(5, 115), new id(10, 116) });
    localObject31 = new ie(28, new id[] { new id(19, 47), new id(10, 48) });
    localObject32 = new ie(30, new id[] { new id(15, 24), new id(25, 25) });
    Object localObject33 = new ie(30, new id[] { new id(23, 15), new id(25, 16) });
    localObject30 = new ic(30, new int[] { 6, 26, 52, 78, 104, 130 }, new ie[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new ie(30, new id[] { new id(13, 115), new id(3, 116) });
    localObject32 = new ie(28, new id[] { new id(2, 46), new id(29, 47) });
    localObject33 = new ie(30, new id[] { new id(42, 24), new id(1, 25) });
    Object localObject34 = new ie(30, new id[] { new id(23, 15), new id(28, 16) });
    localObject31 = new ic(31, new int[] { 6, 30, 56, 82, 108, 134 }, new ie[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new ie(30, new id[] { new id(17, 115) });
    localObject33 = new ie(28, new id[] { new id(10, 46), new id(23, 47) });
    localObject34 = new ie(30, new id[] { new id(10, 24), new id(35, 25) });
    Object localObject35 = new ie(30, new id[] { new id(19, 15), new id(35, 16) });
    localObject32 = new ic(32, new int[] { 6, 34, 60, 86, 112, 138 }, new ie[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new ie(30, new id[] { new id(17, 115), new id(1, 116) });
    localObject34 = new ie(28, new id[] { new id(14, 46), new id(21, 47) });
    localObject35 = new ie(30, new id[] { new id(29, 24), new id(19, 25) });
    Object localObject36 = new ie(30, new id[] { new id(11, 15), new id(46, 16) });
    localObject33 = new ic(33, new int[] { 6, 30, 58, 86, 114, 142 }, new ie[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new ie(30, new id[] { new id(13, 115), new id(6, 116) });
    localObject35 = new ie(28, new id[] { new id(14, 46), new id(23, 47) });
    localObject36 = new ie(30, new id[] { new id(44, 24), new id(7, 25) });
    Object localObject37 = new ie(30, new id[] { new id(59, 16), new id(1, 17) });
    localObject34 = new ic(34, new int[] { 6, 34, 62, 90, 118, 146 }, new ie[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new ie(30, new id[] { new id(12, 121), new id(7, 122) });
    localObject36 = new ie(28, new id[] { new id(12, 47), new id(26, 48) });
    localObject37 = new ie(30, new id[] { new id(39, 24), new id(14, 25) });
    Object localObject38 = new ie(30, new id[] { new id(22, 15), new id(41, 16) });
    localObject35 = new ic(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new ie[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new ie(30, new id[] { new id(6, 121), new id(14, 122) });
    localObject37 = new ie(28, new id[] { new id(6, 47), new id(34, 48) });
    localObject38 = new ie(30, new id[] { new id(46, 24), new id(10, 25) });
    Object localObject39 = new ie(30, new id[] { new id(2, 15), new id(64, 16) });
    localObject36 = new ic(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new ie[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new ie(30, new id[] { new id(17, 122), new id(4, 123) });
    localObject38 = new ie(28, new id[] { new id(29, 46), new id(14, 47) });
    localObject39 = new ie(30, new id[] { new id(49, 24), new id(10, 25) });
    ie localie1 = new ie(30, new id[] { new id(24, 15), new id(46, 16) });
    localObject37 = new ic(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new ie[] { localObject37, localObject38, localObject39, localie1 });
    localObject38 = new ie(30, new id[] { new id(4, 122), new id(18, 123) });
    localObject39 = new ie(28, new id[] { new id(13, 46), new id(32, 47) });
    localie1 = new ie(30, new id[] { new id(48, 24), new id(14, 25) });
    ie localie2 = new ie(30, new id[] { new id(42, 15), new id(32, 16) });
    localObject38 = new ic(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new ie[] { localObject38, localObject39, localie1, localie2 });
    localObject39 = new ie(30, new id[] { new id(20, 117), new id(4, 118) });
    localie1 = new ie(28, new id[] { new id(40, 47), new id(7, 48) });
    localie2 = new ie(30, new id[] { new id(43, 24), new id(22, 25) });
    ie localie3 = new ie(30, new id[] { new id(10, 15), new id(67, 16) });
    localObject39 = new ic(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new ie[] { localObject39, localie1, localie2, localie3 });
    localie1 = new ie(30, new id[] { new id(19, 118), new id(6, 119) });
    localie2 = new ie(28, new id[] { new id(18, 47), new id(31, 48) });
    localie3 = new ie(30, new id[] { new id(34, 24), new id(34, 25) });
    ie localie4 = new ie(30, new id[] { new id(20, 15), new id(61, 16) });
    return new ic[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new ic(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new ie[] { localie1, localie2, localie3, localie4 }) };
  }
  
  public int a()
  {
    return this.c;
  }
  
  public ie a(hy paramhy)
  {
    return this.e[paramhy.ordinal()];
  }
  
  public int[] b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.c * 4 + 17;
  }
  
  gt e()
  {
    int k = d();
    gt localgt = new gt(k);
    localgt.a(0, 0, 9, 9);
    localgt.a(k - 8, 0, 8, 9);
    localgt.a(0, k - 8, 9, 8);
    int m = this.d.length;
    int i = 0;
    while (i < m)
    {
      int n = this.d[i];
      int j = 0;
      if (j < m)
      {
        if (((i == 0) && ((j == 0) || (j == m - 1))) || ((i == m - 1) && (j == 0))) {}
        for (;;)
        {
          j += 1;
          break;
          localgt.a(this.d[j] - 2, n - 2, 5, 5);
        }
      }
      i += 1;
    }
    localgt.a(6, 9, 1, k - 17);
    localgt.a(9, 6, k - 17, 1);
    if (this.c > 6)
    {
      localgt.a(k - 11, 0, 3, 6);
      localgt.a(0, k - 11, 6, 3);
    }
    return localgt;
  }
  
  public String toString()
  {
    return String.valueOf(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */