package com.nicolesiomos.infinitedndserver.logging.util;

import com.google.common.io.Closer;
import com.nicolesiomos.infinitedndserver.logging.MdcKey;
import javax.annotation.Nonnull;
import org.slf4j.MDC;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
public class MdcUtils {
    public static void putInCurrentContext(@Nonnull Closer context, @Nonnull MdcKey key, String value) {
        context.register(MDC.putCloseable(key.toString(), value));
    }
}
