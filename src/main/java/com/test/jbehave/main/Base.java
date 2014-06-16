package com.test.jbehave.main;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;

/**
 * Created by Oleksandr_Kara on 12-Jun-14.
 */
public class Base {
    @BeforeScenario
    public void initialization(){
        Driver.init();
    }

    @AfterScenario
    public void cleanup(){
            Driver.tearDown();
        }
}
