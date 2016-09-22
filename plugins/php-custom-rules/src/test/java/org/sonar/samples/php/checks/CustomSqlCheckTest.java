/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sonar.samples.php.checks;

import java.io.File;
import org.junit.Test;
import org.sonar.plugins.php.api.tests.PHPCheckTest;

/**
 *
 * @author fangl
 */
public class CustomSqlCheckTest {
    @Test
    public void test() throws Exception {
      PHPCheckTest.check(new CustomSqlCheck(), new File("src/test/resources/checks/CustomSqlCheck.php"));
    }
}
