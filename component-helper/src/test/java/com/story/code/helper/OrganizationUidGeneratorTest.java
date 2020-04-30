package com.story.code.helper;

import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
public class OrganizationUidGeneratorTest {

    @Test
    public void test() {

        String maxUid = null, parentUid = "";
        for (int i = 0; i < OrganizationUidGenerator.LETTER_CHARS.length() * 10; i++) {
            System.out.println(maxUid + " -*-- " + i);
            maxUid = OrganizationUidGenerator.generateRoot(maxUid);
        }

        parentUid = "z9";
        maxUid = "";
        for (int i = 0; i < OrganizationUidGenerator.LETTER_CHARS.length() * 10; i++) {

            maxUid = OrganizationUidGenerator.generateChildren(parentUid, maxUid);
            System.out.println(maxUid + " --- " + i);
        }
    }

}
