package com.gadgetgalaxy.utility;

import java.util.UUID;

/**
 *
 * @author Ganesh
 */
public class IDUtil {

    public static String generateProductId() {
        return "PID-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateTransactionID() {
        return "TXN-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
