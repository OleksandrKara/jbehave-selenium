package com.test.jbehave.main;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;

/**
 * Created by Oleksandr_Kara on 12-Jun-14.
 */
public class Base {
    @BeforeStories
    public void initialization(){
        Driver.init();
    }

    @AfterStories
    public void cleanup(){
            Driver.tearDown();
        }
}
