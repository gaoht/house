package com.mato.sdk.proxy;

import android.net.Uri;
import android.text.TextUtils;
import com.mato.android.matoid.service.mtunnel.a.a;
import com.mato.android.matoid.service.mtunnel.a.c;
import com.mato.android.matoid.service.mtunnel.a.f;
import com.mato.android.matoid.service.mtunnel.a.i;
import com.mato.android.matoid.service.mtunnel.a.j;
import com.mato.android.matoid.service.mtunnel.a.k;
import com.mato.android.matoid.service.mtunnel.a.l;
import com.mato.sdk.b.e;
import com.mato.sdk.c.b.f;
import com.mato.sdk.d.i;
import com.mato.sdk.d.j;
import com.mato.sdk.d.j.a;
import com.mato.sdk.d.m;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

public final class h
  extends l
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final d b;
  private final int c;
  
  public h(d paramd, int paramInt)
  {
    this.b = paramd;
    this.c = paramInt;
  }
  
  private static String a(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = paramString.getHost();
    } while (str == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    int i = paramString.getPort();
    if (i != -1) {
      localStringBuilder.append(":").append(i);
    }
    return localStringBuilder.toString();
  }
  
  private List<l.a> a(com.mato.sdk.d.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b.u();
    if (localObject == null) {
      return localArrayList;
    }
    Iterator localIterator = ((com.mato.sdk.e.d.d)localObject).a().iterator();
    if (localIterator.hasNext())
    {
      com.mato.sdk.e.d.g localg = (com.mato.sdk.e.d.g)localIterator.next();
      l.a locala = new l.a();
      locala.a = "maa";
      locala.b = d(paramg.r());
      locala.f = ".*";
      locala.d = "";
      locala.c = localg.f();
      locala.e = localg.g();
      label177:
      label253:
      int j;
      switch (localg.h())
      {
      default: 
        localObject = a.a.a;
        locala.g = ((a.a)localObject);
        locala.i = a.i.c;
        locala.j = localg.a();
        switch (localg.i())
        {
        default: 
          localObject = a.c.a;
          locala.k = ((a.c)localObject);
          locala.l = localg.d();
          locala.m = localg.j();
          int i = localg.i();
          j = this.c;
          switch (i)
          {
          default: 
            localObject = a.k.a;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        locala.o = ((a.k)localObject);
        localArrayList.add(locala);
        break;
        localObject = a.a.c;
        break label177;
        localObject = a.a.d;
        break label177;
        localObject = a.a.e;
        break label177;
        localObject = a.a.f;
        break label177;
        localObject = a.a.g;
        break label177;
        localObject = a.a.h;
        break label177;
        localObject = a.a.i;
        break label177;
        localObject = a.c.a;
        break label253;
        localObject = a.c.b;
        break label253;
        localObject = a.c.c;
        break label253;
        localObject = a.c.d;
        break label253;
        localObject = a.k.a;
        continue;
        localObject = l.e(j);
      }
    }
    return localArrayList;
  }
  
  private List<l.a> a(com.mato.sdk.d.g paramg, i parami, boolean paramBoolean, a.k paramk, a.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    com.mato.sdk.e.b.b localb = this.b.a(0);
    l.a locala;
    if ((localb != null) && (localb.a()))
    {
      locala = new l.a();
      locala.a = "maa";
      locala.f = localb.a;
      locala.c = localb.b;
      locala.e = parami.g();
      locala.d = "";
      locala.b = d(paramg.r());
      locala.g = a(parami.d(), parami.j());
      locala.i = a.i.c;
      locala.j = 1;
      locala.k = paramc;
      locala.l = 0L;
      locala.m = parami.h();
      locala.n = paramBoolean;
      locala.o = paramk;
      localArrayList.add(locala);
    }
    localb = this.b.a(1);
    if ((localb != null) && (localb.a()))
    {
      locala = new l.a();
      locala.a = "maa";
      locala.f = localb.a;
      locala.c = localb.b;
      locala.e = parami.g();
      locala.d = "";
      locala.b = d(paramg.r());
      locala.g = a(parami.d(), parami.j());
      locala.i = a.i.c;
      locala.j = 2;
      locala.k = paramc;
      locala.l = 0L;
      locala.m = parami.h();
      locala.n = paramBoolean;
      locala.o = paramk;
      localArrayList.add(locala);
    }
    return localArrayList;
  }
  
  private List<l.a> a(i parami, boolean paramBoolean, a.k paramk, a.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    com.mato.sdk.d.g localg = this.b.i();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.a(0);
    if ((localObject2 != null) && (((com.mato.sdk.e.b.b)localObject2).a()))
    {
      localObject3 = new l.a();
      ((l.a)localObject3).a = "maa";
      ((l.a)localObject3).f = ((com.mato.sdk.e.b.b)localObject2).a;
      ((l.a)localObject3).c = ((com.mato.sdk.e.b.b)localObject2).b;
      ((l.a)localObject3).e = parami.g();
      ((l.a)localObject3).d = "";
      ((l.a)localObject3).b = d(localg.r());
      ((l.a)localObject3).g = a(parami.d(), parami.j());
      ((l.a)localObject3).i = a.i.c;
      ((l.a)localObject3).j = 1;
      ((l.a)localObject3).k = paramc;
      ((l.a)localObject3).l = 0L;
      ((l.a)localObject3).m = parami.h();
      ((l.a)localObject3).n = paramBoolean;
      ((l.a)localObject3).o = paramk;
      ((List)localObject1).add(localObject3);
    }
    localObject2 = this.b.a(1);
    if ((localObject2 != null) && (((com.mato.sdk.e.b.b)localObject2).a()))
    {
      localObject3 = new l.a();
      ((l.a)localObject3).a = "maa";
      ((l.a)localObject3).f = ((com.mato.sdk.e.b.b)localObject2).a;
      ((l.a)localObject3).c = ((com.mato.sdk.e.b.b)localObject2).b;
      ((l.a)localObject3).e = parami.g();
      ((l.a)localObject3).d = "";
      ((l.a)localObject3).b = d(localg.r());
      ((l.a)localObject3).g = a(parami.d(), parami.j());
      ((l.a)localObject3).i = a.i.c;
      ((l.a)localObject3).j = 2;
      ((l.a)localObject3).k = paramc;
      ((l.a)localObject3).l = 0L;
      ((l.a)localObject3).m = parami.h();
      ((l.a)localObject3).n = paramBoolean;
      ((l.a)localObject3).o = paramk;
      ((List)localObject1).add(localObject3);
    }
    localArrayList.addAll((Collection)localObject1);
    Object localObject3 = this.b.i().b();
    localObject2 = null;
    localObject1 = localObject2;
    label412:
    label517:
    int i;
    label569:
    label600:
    int j;
    label655:
    Object localObject4;
    label703:
    j.a locala;
    l.a locala1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = Uri.parse((String)localObject3);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label1015;
        }
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      localObject3 = String.format(Locale.US, "%s.*", new Object[] { "mauth.chinanetcenter.com".replaceAll("\\.", "\\\\\\.") });
      if (localObject1 == null) {
        break label1047;
      }
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(")");
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      ((StringBuilder)localObject2).toString();
      localArrayList.add(l.a.a(((StringBuilder)localObject2).toString(), a.i.a, paramc, 0L, parami.h(), paramBoolean, paramk));
      localObject1 = localg.J();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1058;
      }
      i = 1;
      if (i == 0) {
        break label1064;
      }
      localArrayList.add(l.a.a((String)localObject1, true, a.i.a, paramc, 0L, parami.h(), paramBoolean, paramk));
      localObject1 = localg.t();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(l.a.a((String)localObject1, a.i.c, paramc, 0L, parami.h(), paramBoolean, paramk));
      }
      localObject1 = localg.D();
      if (localObject1 == null) {
        break label1108;
      }
      j = 1;
      if (j == 0) {
        break label1194;
      }
      localObject2 = ((List)localObject1).iterator();
      do
      {
        while (!((Iterator)localObject4).hasNext())
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (j)((Iterator)localObject2).next();
          localObject4 = ((j)localObject3).e().iterator();
        }
        locala = (j.a)((Iterator)localObject4).next();
      } while ((locala.a()) && (i != 0));
      locala1 = new l.a();
      locala1.a = ((j)localObject3).c();
      locala1.f = locala.c();
      locala1.c = ((j)localObject3).a();
      locala1.d = ((j)localObject3).b();
      locala1.e = locala.d();
      locala1.b = d(((j)localObject3).d());
      switch (locala.e())
      {
      case 8: 
      default: 
        localObject1 = a.a.a;
      }
    }
    for (;;)
    {
      locala1.g = ((a.a)localObject1);
      locala1.i = c(locala.b());
      locala1.k = paramc;
      locala1.l = 0L;
      locala1.m = parami.h();
      locala1.n = paramBoolean;
      locala1.o = paramk;
      localArrayList.add(locala1);
      break label703;
      localObject3 = ((Uri)localObject1).getHost();
      if (localObject3 == null)
      {
        localObject1 = null;
        break;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      i = ((Uri)localObject1).getPort();
      if (i != -1) {
        ((StringBuilder)localObject4).append(":").append(i);
      }
      localObject1 = ((StringBuilder)localObject4).toString();
      break;
      label1015:
      localObject1 = String.format(Locale.US, "%s.*", new Object[] { ((String)localObject1).replaceAll("\\.", "\\\\\\.") });
      break label412;
      label1047:
      ((StringBuilder)localObject2).append((String)localObject3);
      break label517;
      label1058:
      i = 0;
      break label569;
      label1064:
      localObject1 = localg.z();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label600;
      }
      localArrayList.add(l.a.a((String)localObject1, false, a.i.c, paramc, 0L, parami.h(), paramBoolean, paramk));
      break label600;
      label1108:
      j = 0;
      break label655;
      localObject1 = a.a.b;
      continue;
      localObject1 = a.a.c;
      continue;
      localObject1 = a.a.d;
      continue;
      localObject1 = a.a.e;
      continue;
      localObject1 = a.a.f;
      continue;
      localObject1 = a.a.g;
      continue;
      localObject1 = a.a.h;
      continue;
      localObject1 = a.a.j;
      continue;
      localObject1 = a.a.i;
      continue;
      localObject1 = a.a.k;
    }
    label1194:
    localObject1 = localg.g();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localArrayList.add(l.a.a((String)localObject1, c(localg.v()), paramc, 0L, parami.h(), paramBoolean, paramk));
    }
    localObject2 = localg.h();
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ".*";
    }
    localObject2 = new l.a();
    ((l.a)localObject2).a = "maa";
    ((l.a)localObject2).f = ((String)localObject1);
    ((l.a)localObject2).c = parami.f();
    ((l.a)localObject2).d = parami.a();
    ((l.a)localObject2).e = parami.g();
    ((l.a)localObject2).b = d(localg.r());
    ((l.a)localObject2).g = a(parami.d(), parami.j());
    ((l.a)localObject2).i = c(localg.u());
    ((l.a)localObject2).k = paramc;
    ((l.a)localObject2).l = 0L;
    ((l.a)localObject2).m = parami.h();
    ((l.a)localObject2).n = paramBoolean;
    ((l.a)localObject2).o = paramk;
    localArrayList.add(localObject2);
    localArrayList.addAll(a(localg));
    return localArrayList;
  }
  
  private void a(a.j paramj)
  {
    Object localObject1 = a.a();
    Object localObject2 = ((e)localObject1).j();
    com.mato.sdk.d.g localg = this.b.i();
    paramj.a(a.l.a);
    paramj.c((String)localObject2);
    paramj.b(((e)localObject1).e());
    paramj.a("127.0.0.1");
    paramj.a(8123);
    paramj.f(this.b.o().c());
    paramj.d(localg.i());
    paramj.b(localg.m());
    Object localObject3 = localg.n();
    if (localObject3 != null) {
      paramj.e((String)localObject3);
    }
    localObject2 = ((String)localObject2).getBytes();
    localObject3 = new CRC32();
    ((CRC32)localObject3).update((byte[])localObject2);
    paramj.d(Long.toHexString(((CRC32)localObject3).getValue()));
    boolean bool;
    int j;
    if (!localg.j())
    {
      bool = true;
      paramj.d(bool);
      paramj.j(localg.p());
      paramj.i(localg.o());
      localObject2 = localg.q();
      i = ((e)localObject1).g();
      j = ((e)localObject1).h();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label250;
      }
    }
    for (int i = 100;; i = new l.b((String)localObject2).a(i))
    {
      paramj.c(i);
      localObject1 = a();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramj.h(localObject1[i]);
        i += 1;
      }
      bool = false;
      break;
      label250:
      i = Math.max(i, j);
    }
    paramj.f(false);
    if (this.b.i().y())
    {
      paramj.a(a.f.a);
      paramj.g(this.b.o().d());
    }
    b(paramj);
    paramj.g(this.b.t());
    localObject1 = this.b.o().b().e();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramj.q((String)localObject1);
    }
    paramj.h(localg.K());
  }
  
  private void a(a.j paramj, i parami)
  {
    a.c localc;
    if (parami.i() == 3) {
      localc = a.c.a;
    }
    for (;;)
    {
      paramj.a(localc);
      paramj.a(parami.b());
      paramj.e(parami.h());
      paramj.b(parami.k());
      a(paramj, parami, this.c);
      return;
      switch (parami.e())
      {
      default: 
        localc = a.c.b;
        break;
      case 1: 
        localc = a.c.b;
        break;
      case 2: 
        localc = a.c.c;
        break;
      case 3: 
        localc = a.c.d;
        break;
      case 4: 
      case 5: 
        localc = a.c.e;
      }
    }
  }
  
  private static void a(com.mato.sdk.d.b paramb, a.j paramj)
  {
    paramj.o(paramb.a);
    if (paramb.b) {}
    StringBuilder localStringBuilder;
    for (int i = 1;; i = 0)
    {
      paramj.f(i);
      localStringBuilder = new StringBuilder();
      paramb = paramb.c.iterator();
      while (paramb.hasNext()) {
        localStringBuilder.append((String)paramb.next()).append(";");
      }
    }
    paramj.p(localStringBuilder.toString());
  }
  
  private void b(a.j paramj)
  {
    Object localObject1 = this.b.i().C();
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label36;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label36:
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.mato.sdk.d.b)((Iterator)localObject1).next();
        paramj.o(((com.mato.sdk.d.b)localObject2).a);
        if (((com.mato.sdk.d.b)localObject2).b) {}
        StringBuilder localStringBuilder;
        for (i = 1;; i = 0)
        {
          paramj.f(i);
          localStringBuilder = new StringBuilder();
          localObject2 = ((com.mato.sdk.d.b)localObject2).c.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localStringBuilder.append((String)((Iterator)localObject2).next()).append(";");
          }
        }
        paramj.p(localStringBuilder.toString());
      }
    }
  }
  
  private boolean d()
  {
    return this.b.i().y();
  }
  
  private String e()
  {
    StringBuilder localStringBuilder1 = null;
    String str = this.b.i().b();
    Object localObject = localStringBuilder1;
    if (!TextUtils.isEmpty(str))
    {
      localObject = Uri.parse(str);
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label211;
        }
        localObject = localStringBuilder1;
      }
    }
    else
    {
      label42:
      localStringBuilder1 = new StringBuilder();
      str = String.format(Locale.US, "%s.*", new Object[] { "mauth.chinanetcenter.com".replaceAll("\\.", "\\\\\\.") });
      if (localObject == null) {
        break label241;
      }
      localStringBuilder1.append("(");
      localStringBuilder1.append(str);
      localStringBuilder1.append(")");
      localStringBuilder1.append("|");
      localStringBuilder1.append("(");
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append(")");
    }
    for (;;)
    {
      localStringBuilder1.toString();
      return localStringBuilder1.toString();
      str = ((Uri)localObject).getHost();
      if (str == null)
      {
        localObject = null;
        break;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      int i = ((Uri)localObject).getPort();
      if (i != -1) {
        localStringBuilder2.append(":").append(i);
      }
      localObject = localStringBuilder2.toString();
      break;
      label211:
      localObject = String.format(Locale.US, "%s.*", new Object[] { ((String)localObject).replaceAll("\\.", "\\\\\\.") });
      break label42;
      label241:
      localStringBuilder1.append(str);
    }
  }
  
  public final byte[] a(int paramInt)
  {
    boolean bool = true;
    int i = 0;
    Object localObject2;
    a.j localj;
    try
    {
      localObject2 = this.b.i().a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localj = new a.j();
      localObject3 = a.a();
      Object localObject4 = ((e)localObject3).j();
      com.mato.sdk.d.g localg = this.b.i();
      localj.a(a.l.a);
      localj.c((String)localObject4);
      localj.b(((e)localObject3).e());
      localj.a("127.0.0.1");
      localj.a(8123);
      localj.f(this.b.o().c());
      localj.d(localg.i());
      localj.b(localg.m());
      Object localObject5 = localg.n();
      if (localObject5 != null) {
        localj.e((String)localObject5);
      }
      localObject4 = ((String)localObject4).getBytes();
      localObject5 = new CRC32();
      ((CRC32)localObject5).update((byte[])localObject4);
      localj.d(Long.toHexString(((CRC32)localObject5).getValue()));
      if (localg.j()) {
        break label785;
      }
      localj.d(bool);
      localj.j(localg.p());
      localj.i(localg.o());
      localObject4 = localg.q();
      paramInt = ((e)localObject3).g();
      int j = ((e)localObject3).h();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {}
      for (paramInt = 100;; paramInt = new l.b((String)localObject4).a(paramInt))
      {
        localj.c(paramInt);
        localObject3 = a();
        j = localObject3.length;
        paramInt = i;
        while (paramInt < j)
        {
          localj.h(localObject3[paramInt]);
          paramInt += 1;
        }
        paramInt = Math.max(paramInt, j);
      }
      localj.f(false);
    }
    catch (Throwable localThrowable)
    {
      f.b().a(localThrowable);
      return null;
    }
    if (this.b.i().y())
    {
      localj.a(a.f.a);
      localj.g(this.b.o().d());
    }
    b(localj);
    localj.g(this.b.t());
    Object localObject3 = this.b.o().b().e();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localj.q((String)localObject3);
    }
    localj.h(localThrowable.K());
    Object localObject1;
    if (((i)localObject2).i() == 3)
    {
      localObject1 = a.c.a;
      label439:
      localj.a((a.c)localObject1);
      localj.a(((i)localObject2).b());
      localj.e(((i)localObject2).h());
      localj.b(((i)localObject2).k());
      a(localj, (i)localObject2, this.c);
      localObject1 = a((i)localObject2, localj.f(), localj.g(), localj.h()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l.a)((Iterator)localObject1).next();
        localj.m(((l.a)localObject2).a);
        localj.a(((l.a)localObject2).b);
        localj.l(((l.a)localObject2).c);
        localj.e(((l.a)localObject2).e);
        localj.a(((l.a)localObject2).g);
        localj.k(((l.a)localObject2).f);
        localj.n(((l.a)localObject2).d);
        localj.g(((l.a)localObject2).h);
        localj.a(((l.a)localObject2).i);
        localj.h(((l.a)localObject2).j);
        localj.b(((l.a)localObject2).k);
        localj.i((int)((l.a)localObject2).l);
        localj.i(((l.a)localObject2).m);
        localj.j(((l.a)localObject2).n);
        localj.b(((l.a)localObject2).o);
      }
    }
    switch (((i)localObject2).e())
    {
    }
    for (;;)
    {
      localObject1 = a.c.b;
      break label439;
      localObject1 = a.c.b;
      break label439;
      localObject1 = a.c.c;
      break label439;
      localObject1 = a.c.d;
      break label439;
      localObject1 = a.c.e;
      break label439;
      localObject1 = localj.e().b();
      return (byte[])localObject1;
      label785:
      bool = false;
      break;
    }
  }
  
  public final String[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MessageFormat.format("MATO-NET: {0},{1}", new Object[] { a.d(), this.b.h().a() }));
    localArrayList.add(MessageFormat.format("MATO-VERSION: {0},{1}", new Object[] { Proxy.getVersion(), Integer.valueOf(this.b.i().c()) }));
    localArrayList.add(MessageFormat.format("x-maa-display-id:{0}", new Object[] { m.b(a.a().e().getBytes()) }));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */