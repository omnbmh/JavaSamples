package org.github.omnbmh.hprose.examples.client;

import hprose.client.HproseHttpClient;

import java.io.IOException;

/**
 * Created by chendezhi on 2016/10/24.
 */
public class HelloClient {
    public static void main(String[] args) throws Throwable {
        HproseHttpClient client = new HproseHttpClient();
        client.useService("http://localhost:8080/hprose-examples/Hello");
        String result = (String) client.invoke("sayHello", new Object[] { "Hprose" });
        System.out.println(result);
        result = (String) client.invoke("sayHello", new Object[] { "中国" });
        System.out.println(result);
    }
}
