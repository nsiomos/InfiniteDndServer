package com.nicolesiomos.infinitedndserver.api;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
public class User {

    @Nonnull
    @Nonnegative
    private int id;

    @Nonnull
    private String emailAddress;
}
