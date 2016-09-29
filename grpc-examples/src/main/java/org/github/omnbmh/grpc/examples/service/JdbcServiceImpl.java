package org.github.omnbmh.grpc.examples.service;

import org.github.omnbmh.grpc.proto.jdbc.GetJdbcGrpc;
import org.github.omnbmh.grpc.proto.jdbc.JdbcRequest;
import org.github.omnbmh.grpc.proto.jdbc.JdbcResponse;

import io.grpc.stub.StreamObserver;

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
