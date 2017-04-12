package org.github.omnbmh.hprose.examples.client;

import hprose.client.HproseHttpClient;
import hprose.client.HproseTcpClient;

public class HelloClient {
    public static void main(String[] args) throws Throwable {
//        httpReq();
        // 未通
        //webSocketReq();
        //httpEntryReq();
    }


    static void webSocketReq() throws Throwable {
        HproseTcpClient client =  new HproseTcpClient();
        client.useService("http://localhost:8080/server/wshello");
        String result = (String) client.invoke("sayHello", new Object[]{"Hprose"});
        System.out.println(result);
        result = (String) client.invoke("sayHello", new Object[]{"中国"});
        System.out.println(result);

    }

    static void httpReq() throws Throwable {
        HproseHttpClient client = new HproseHttpClient();
        client.useService("http://localhost:8080/server/Hello");
        String result = (String) client.invoke("sayHello", new Object[]{"Hprose"});
        System.out.println(result);
        result = (String) client.invoke("sayHello", new Object[]{"中国"});
        System.out.println(result);

    }
}
