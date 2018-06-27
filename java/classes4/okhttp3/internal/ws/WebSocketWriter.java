package okhttp3.internal.ws;

import d.c;
import d.c.a;
import d.d;
import d.f;
import d.s;
import d.u;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter
{
  boolean activeWriter;
  final c buffer = new c();
  final FrameSink frameSink = new FrameSink();
  final boolean isClient;
  private final c.a maskCursor;
  private final byte[] maskKey;
  final Random random;
  final d sink;
  final c sinkBuffer;
  boolean writerClosed;
  
  WebSocketWriter(boolean paramBoolean, d paramd, Random paramRandom)
  {
    if (paramd == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.isClient = paramBoolean;
    this.sink = paramd;
    this.sinkBuffer = paramd.buffer();
    this.random = paramRandom;
    if (paramBoolean) {}
    for (paramd = new byte[4];; paramd = null)
    {
      this.maskKey = paramd;
      paramd = (d)localObject;
      if (paramBoolean) {
        paramd = new c.a();
      }
      this.maskCursor = paramd;
      return;
    }
  }
  
  private void writeControlFrame(int paramInt, f paramf)
    throws IOException
  {
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i = paramf.size();
    if (i > 125L) {
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
    this.sinkBuffer.writeByte(paramInt | 0x80);
    if (this.isClient)
    {
      this.sinkBuffer.writeByte(i | 0x80);
      this.random.nextBytes(this.maskKey);
      this.sinkBuffer.write(this.maskKey);
      if (i > 0)
      {
        long l = this.sinkBuffer.size();
        this.sinkBuffer.write(paramf);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(l);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    for (;;)
    {
      this.sink.flush();
      return;
      this.sinkBuffer.writeByte(i);
      this.sinkBuffer.write(paramf);
    }
  }
  
  s newMessageSink(int paramInt, long paramLong)
  {
    if (this.activeWriter) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.activeWriter = true;
    this.frameSink.formatOpcode = paramInt;
    this.frameSink.contentLength = paramLong;
    this.frameSink.isFirstFrame = true;
    this.frameSink.closed = false;
    return this.frameSink;
  }
  
  void writeClose(int paramInt, f paramf)
    throws IOException
  {
    Object localObject = f.b;
    if ((paramInt != 0) || (paramf != null))
    {
      if (paramInt != 0) {
        WebSocketProtocol.validateCloseCode(paramInt);
      }
      localObject = new c();
      ((c)localObject).writeShort(paramInt);
      if (paramf != null) {
        ((c)localObject).write(paramf);
      }
      localObject = ((c)localObject).readByteString();
    }
    try
    {
      writeControlFrame(8, (f)localObject);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }
  
  void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i;
    if (paramBoolean1)
    {
      i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(i);
      if (!this.isClient) {
        break label267;
      }
    }
    label82:
    label252:
    label267:
    for (paramInt = 128;; paramInt = 0)
    {
      if (paramLong <= 125L)
      {
        i = (int)paramLong;
        this.sinkBuffer.writeByte(paramInt | i);
        if (!this.isClient) {
          break label252;
        }
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.size();
          this.sinkBuffer.write(this.buffer, paramLong);
          this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(l);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      for (;;)
      {
        this.sink.emit();
        return;
        paramInt = 0;
        break;
        if (paramLong <= 65535L)
        {
          this.sinkBuffer.writeByte(paramInt | 0x7E);
          this.sinkBuffer.writeShort((int)paramLong);
          break label82;
        }
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
        break label82;
        this.sinkBuffer.write(this.buffer, paramLong);
      }
    }
  }
  
  void writePing(f paramf)
    throws IOException
  {
    writeControlFrame(9, paramf);
  }
  
  void writePong(f paramf)
    throws IOException
  {
    writeControlFrame(10, paramf);
  }
  
  final class FrameSink
    implements s
  {
    boolean closed;
    long contentLength;
    int formatOpcode;
    boolean isFirstFrame;
    
    FrameSink() {}
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, true);
      this.closed = true;
      WebSocketWriter.this.activeWriter = false;
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, false);
      this.isFirstFrame = false;
    }
    
    public u timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }
    
    public void write(c paramc, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.buffer.write(paramc, paramLong);
      if ((this.isFirstFrame) && (this.contentLength != -1L) && (WebSocketWriter.this.buffer.size() > this.contentLength - 8192L)) {}
      for (int i = 1;; i = 0)
      {
        paramLong = WebSocketWriter.this.buffer.completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0))
        {
          WebSocketWriter.this.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
          this.isFirstFrame = false;
        }
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/ws/WebSocketWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */