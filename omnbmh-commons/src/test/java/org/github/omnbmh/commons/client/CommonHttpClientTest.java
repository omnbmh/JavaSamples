package org.github.omnbmh.commons.client;

import junit.framework.TestCase;

public class CommonHttpClientTest extends TestCase {


    public void testGetRequest() {
        System.out.println(CommonHttpClient.getRequest("http://2018.ip138.com/ic.asp", "gb2312"));
    }
}
