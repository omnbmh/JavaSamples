## distributed
正在看 分布式Java应用与实践

### 名词解释

```
读取和写入数据，按照POSIX标准分为同步IO和异步IO两种，其中同步IO中最常用的是BIO（Blocking IO）和NIO（Non-Blocking IO）
另一种异步IO是AIO 简化了程序的编写
```

- TCP/IP+BIO
- TCP/IP+NIO
- UDP/IP+BIO
- UDP/IP+NIO

### SOA平台会带来哪些挑战
- 服务多级调用带来的延时
- 调试/跟踪困难
- 更高的安全/监测要求
  1. 原先只对一台机器即可，拆分后需要每个系统上都有相应的安全及监测
- 现有应用移植
- QoS的支持 Quality of Service
  1. 网络流量 机器资源配置
- 高可用和高度可伸缩
- 多版本和依赖管理


### SCA和ESB
- ESB
  1. 标准的消息通信格式
  2. 消息路由
  3. 支持多种消息交互类型
  4. 支持多种网络协议
  5. 支持多种数据格式并能够支持相互转换
  
- SCA 框架
  1. Tuscany 是 IBM 和 Bea 捐献给Apache的产品
  2. Mule 常用的ESB实现框架之一
    - 通信支持  WebService和JMS
    
### JVM
- class 
  1. 结构信息
  2. 元数据
  3. 方法信息
  
- 类加载异常
  1. ClassNotFoundExcetion
  2. NoClassDefError
  3. LinkageError
  4. ClassCastException
  
### JVM 内存空间
- 方法区 对应持有代（Permanet Generation）-XX:PermSize -XX:MaxPermSize
  1. 类的信息（名称 修饰符）
  2. 类中的静态变量
  3. final类型的常量
  4. Field信息
  5. Method信息
- 堆 存储对象实例和数组 基本上new出得对象都在这 -Xms -Xmx JDK1.2 开始对堆改用分代管理
  1. 新生代 (New Generation) -Xmn
    - 新建的对象 会从新生代 分配内存 
    - Eden Space S0、S1 或者 Eden Space From、To
  2. 旧生代 （Old Generation 或 Tenuring Generation）大小为 -Xmx 减去 -Xmn的值
    - 多次GC仍存活的对象
    - 大对象 超过指定大小 直接在旧生代分配 -XX:PretenureSizeThreshold=1024 (字节 默认为0)
- 本地方法栈
  1. 支持native方法的执行 存储了调用的状态
- PC寄存器 和 JVM方法栈
  1. PC寄存器占用 CPU寄存或者系统内存
  2. JVM方法栈 占用 系统内存 -Xss 指定大小 不足时 throws StackOverFlowError
  
### JVM 内存分配
- 堆空间不足时 会触发GC GC后还不够 throws OutOfMemory

### JVM 内存状况查看和分析工具
- -XX:+PrintGC 简要
- -XX:+PrintGCDetails 详细
- -XX:+PrintGCTimeStamps 时间
- -XX:+PrintGCApplicationStoppedTime 暂停时间
- -Xloggc:gc.log
- -verose:gc
- GC Portal
- JConsole
- JVisualVM JDK6 Update 7 之后的工具 类似 JProfiler
- JMap
  1. jmap -heap [pid] 整个JVM内存的情况 CMS GC 可能导致Java线程被挂起 生产环境 谨慎使用
  2. jmap -histo [pid] JVM堆中对象的详细占用情况
  3. jmap -dump:format=b,file=filename [pid] 导出整个内存情况 
- JHat 用于分析 堆 dumpw文件的工具
  1. jhat -J-Xmx1024M [file]
- JStat JDK自带统计分析JVM运行状况的工具
  1. jstat -gcutil [pid][inteval] 一定频率刷新 JVM各代d的空间占用情况
- Eclipse Memory Analyzer