package com.rpc;

import io.grpc.stub.StreamObserver;
import com.proto.RpcRequest;
import com.proto.RpcResponse;
import com.proto.RpcServiceGrpc;

public class MyServiceImpl extends RpcServiceGrpc.RpcServiceImplBase {

    @Override
    public void greet(
            RpcRequest request, StreamObserver<RpcResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getName())
                .toString();

        RpcResponse response = RpcResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}