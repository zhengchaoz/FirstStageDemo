package com.local.datetime;

import com.sun.scenario.effect.Offset;
import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author
 * @date 2021-03-19-9:07
 */
public class InstantTest {

    @Test
    public void now() {
        System.out.println(Instant.now());
    }

    @Test
    public void atOffSet() {
        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }

    @Test
    public void milli() {
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.ofEpochMilli(1616116723604l));
    }

}
