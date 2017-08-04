package org.github.omnbmh.samples.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;
import org.github.omnbmh.samples.grpc.impl.WorkAssistImpl;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/7/31 下午1:30
 */
public class WorkAssistServer {

  private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50010;
    server = ServerBuilder.forPort(port)
        .addService(new WorkAssistImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        WorkAssistServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final WorkAssistServer server = new WorkAssistServer();
    server.start();
    server.blockUntilShutdown();
  }
}
