package me.example.fw.grpc.helloworld;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author zhoujialiang9
 * @date 2022/4/12 9:48 AM
 **/
public class HelloWorldClient {
    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloWorldClient(Channel channel) {
        this.blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void greet(String name){
        logger.info("will try to greet " + name);

        HelloRequest helloRequest = HelloRequest.newBuilder().setName(name).build();
        HelloReply helloReply = null;

        try {
            helloReply = blockingStub.sayHello(helloRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Greeting: " +  helloReply.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        String user = "world";
        String target = "localhost:50051";

        // Allow passing in the user and target strings as command line arguments
        if (args.length > 0) {
            if ("--help".equals(args[0])) {
                System.err.println("Usage: [name [target]]");
                System.err.println("");
                System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
                System.err.println("  target  The server to connect to. Defaults to " + target);
                System.exit(1);
            }
            user = args[0];
        }
        if (args.length > 1) {
            target = args[1];
        }

        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        try {
            HelloWorldClient helloWorldClient = new HelloWorldClient(managedChannel);
            helloWorldClient.greet(user);

        } finally {
            managedChannel.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
