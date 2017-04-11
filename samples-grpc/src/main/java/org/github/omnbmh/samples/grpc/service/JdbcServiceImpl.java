package org.github.omnbmh.samples.grpc.service;

import io.grpc.stub.StreamObserver;
import org.github.omnbmh.samples.grpc.protobuf.GetJdbcGrpc;
import org.github.omnbmh.samples.grpc.protobuf.JdbcRequest;
import org.github.omnbmh.samples.grpc.protobuf.JdbcResponse;

public class JdbcServiceImpl extends GetJdbcGrpc.GetJdbcImplBase {
	public @Override void getJdbc(JdbcRequest request, StreamObserver<JdbcResponse> responseObserver) {
		String name = request.getName();
		System.out.println("will get " + name +" jdbc.");
		//code logic 
		JdbcResponse response = JdbcResponse.newBuilder()
				.setDriverclassname("com.mysql.jdbc.Driver")
				.setJdbcurl("jdbc:mysql://10.100.140.12:3306/blossom_test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true")
				.setUsername("root").setUserpassword("root123").build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
