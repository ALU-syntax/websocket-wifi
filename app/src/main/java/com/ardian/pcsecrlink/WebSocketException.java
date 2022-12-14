package com.ardian.pcsecrlink;

import java.io.IOException;

/**
 * Created by Ardian Iqbal Yusmartito on 26/09/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
public class WebSocketException extends IOException {
    private WebSocketFrame.CloseCode code;
    private String reason;

    public WebSocketException(Exception cause) {
        this(WebSocketFrame.CloseCode.InternalServerError, cause.toString(), cause);
    }

    public WebSocketException(WebSocketFrame.CloseCode code, String reason) {
        this(code, reason, null);
    }

    public WebSocketException(WebSocketFrame.CloseCode code, String reason, Exception cause) {
        super(code + ": " + reason, cause);
        this.code = code;
        this.reason = reason;
    }

    public WebSocketFrame.CloseCode getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
