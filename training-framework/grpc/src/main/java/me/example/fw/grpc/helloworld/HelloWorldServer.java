package me.example.fw.grpc.helloworld;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author zhoujialiang9
 * @date 2022/4/12 9:25 AM
 **/
public class HelloWorldServer {
    private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

    private Server server;

    private void start() throws IOException {
        int port = 50051;

        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();

        logger.info("server started. listening on port:" + port);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                logger.info("shutdown gRPC server since JVM is shutting down.");

                try {
                    HelloWorldServer.this.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void stop() throws InterruptedException {
        if(server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }


    private void blockUntilShutdown() throws InterruptedException {
        if(server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();

    }

    static  class GreeterImpl extends GreeterGrpc.GreeterImplBase{

        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            HelloReply helloReply = HelloReply.newBuilder().setMessage("from server ： hello " + request.getName()).build();
            responseObserver.onNext(helloReply);
            responseObserver.onCompleted();
        }
    }


}
