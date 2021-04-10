package com.boot.ugo;

import com.boot.ugo.util.PasswordUtils;
import org.junit.jupiter.api.Test;

/**
 * CommonTest
 *
 * @author gnl
 */

public class CommonTest {

    @Test
    public void test1() throws Exception {

        String aesEncoded = PasswordUtils.aesEncoded("gnl000");
        System.out.println("加密:  " + aesEncoded);

        String aesDecoded = PasswordUtils.aesDecoded(aesEncoded);
        System.out.println("解密: " + aesDecoded);

    }

}
