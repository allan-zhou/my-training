# IO
- io的4种模型

## io的4中模型
同步阻塞、同步非阻塞、io多路复用、异步io

## OIO

## Input and Output - Source and Destination 数据源和数据目的地
The most typical sources and destinations of data are these:
- Files，文件
- Pipes，管道
- Network Connections，网络连接
- In-memory Buffers (e.g. arrays)，内存缓冲区
- System.in, System.out, System.error

## Stream 流
- A stream is a conceptually endless flow of data. 无穷无尽的数据流
- You can either read from a stream or write to a stream. 可以从流中读取和写入流
- A stream is connected to a data source or a data destination. 流连接到数据源或数据目的地
- Streams in Java IO can be either byte based (reading and writing bytes) or character based (reading and writing characters).基于字节的或基于字符的

## IO的目的、特性
- File Access，文件访问
- Network Access，网络访问
- Internal Memory Buffer Access，内存缓冲区访问
- Inter-Thread Communication (Pipes)，线程间通讯（管道）
- Buffering，缓冲
- Filtering，过滤
- Parsing，解析
- Reading and Writing Text (Readers / Writers)，读写文本
- Reading and Writing Primitive Data (long, int etc.)，读写原始数据
- Reading and Writing Objects，读写对象

## Reference
- https://jenkov.com/tutorials/java-io/overview.html
