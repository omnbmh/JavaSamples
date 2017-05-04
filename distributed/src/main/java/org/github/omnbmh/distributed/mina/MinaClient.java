package org.github.omnbmh.distributed.mina;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.Set;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.service.IoServiceStatistics;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionDataStructureFactory;
import org.apache.mina.core.session.IoSessionInitializer;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/26 上午10:53
 * @since 1.7
 */
public class MinaClient {


  public static void main(String[] args) {
    // 创建一个 线程池大小为 CPU 核数 +1 的 socketconnector 对象
    SocketConnector ioConnector = new SocketConnector() {
      public InetSocketAddress getDefaultRemoteAddress() {
        return null;
      }

      public void setDefaultRemoteAddress(InetSocketAddress inetSocketAddress) {

      }

      public SocketSessionConfig getSessionConfig() {
        return null;
      }

      public int getConnectTimeout() {
        return 0;
      }

      public long getConnectTimeoutMillis() {
        return 0;
      }

      public void setConnectTimeout(int i) {

      }

      public void setConnectTimeoutMillis(long l) {

      }

      public void setDefaultRemoteAddress(SocketAddress socketAddress) {

      }

      public ConnectFuture connect() {
        return null;
      }

      public ConnectFuture connect(IoSessionInitializer<? extends ConnectFuture> ioSessionInitializer) {
        return null;
      }

      public ConnectFuture connect(SocketAddress socketAddress) {
        return null;
      }

      public ConnectFuture connect(SocketAddress socketAddress,
          IoSessionInitializer<? extends ConnectFuture> ioSessionInitializer) {
        return null;
      }

      public ConnectFuture connect(SocketAddress socketAddress, SocketAddress socketAddress1) {
        return null;
      }

      public ConnectFuture connect(SocketAddress socketAddress, SocketAddress socketAddress1,
          IoSessionInitializer<? extends ConnectFuture> ioSessionInitializer) {
        return null;
      }

      public TransportMetadata getTransportMetadata() {
        return null;
      }

      public void addListener(IoServiceListener ioServiceListener) {

      }

      public void removeListener(IoServiceListener ioServiceListener) {

      }

      public boolean isDisposing() {
        return false;
      }

      public boolean isDisposed() {
        return false;
      }

      public void dispose() {

      }

      public void dispose(boolean b) {

      }

      public IoHandler getHandler() {
        return null;
      }

      public void setHandler(IoHandler ioHandler) {

      }

      public Map<Long, IoSession> getManagedSessions() {
        return null;
      }

      public int getManagedSessionCount() {
        return 0;
      }

      public IoFilterChainBuilder getFilterChainBuilder() {
        return null;
      }

      public void setFilterChainBuilder(IoFilterChainBuilder ioFilterChainBuilder) {

      }

      public DefaultIoFilterChainBuilder getFilterChain() {
        return null;
      }

      public boolean isActive() {
        return false;
      }

      public long getActivationTime() {
        return 0;
      }

      public Set<WriteFuture> broadcast(Object o) {
        return null;
      }

      public IoSessionDataStructureFactory getSessionDataStructureFactory() {
        return null;
      }

      public void setSessionDataStructureFactory(
          IoSessionDataStructureFactory ioSessionDataStructureFactory) {

      }

      public int getScheduledWriteBytes() {
        return 0;
      }

      public int getScheduledWriteMessages() {
        return 0;
      }

      public IoServiceStatistics getStatistics() {
        return null;
      }
    };



  }

}
