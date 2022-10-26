package com.ardian.pcsecrlink;

import com.ardian.pcsecrlink.httpd.NanoHTTPD;

/**
 * Created by Ardian Iqbal Yusmartito on 26/09/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
public interface WebSocketFactory {
    WebSocket openWebSocket(NanoHTTPD.IHTTPSession handshake);
}
