package main.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import main.proto.RpcRequest;
import main.proto.RpcResponse;
import main.proto.RpcServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        RpcServiceGrpc.RpcServiceBlockingStub stub
                = RpcServiceGrpc.newBlockingStub(channel);

        RpcResponse helloResponse = stub.greet(RpcRequest.newBuilder()
                .setName("Dickson!")
                .build());

        channel.shutdown();
    }
}
