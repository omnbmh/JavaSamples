package org.github.omnbmh.samples.grpc.impl;

import io.grpc.stub.StreamObserver;
import org.github.omnbmh.commons.codec.DESCoder;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextCodecGrpc.TextCodecImplBase;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/7/31 下午1:34
 */
public class WorkAssistImpl extends TextCodecImplBase {

  @Override
  public void encryptText(TextRequest request, StreamObserver<TextResponse> responseObserver) {
//    super.encryptText(request, responseObserver);
    String key = request.getKey();
    String text = request.getText();
    String encryptText = "";
    try {
      encryptText = DESCoder.encrypt(text, key);
    } catch (Exception e) {
      e.printStackTrace();
    }
    TextResponse response = TextResponse.newBuilder().setText(text).setEncryptText(encryptText)
        .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
