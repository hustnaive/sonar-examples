package org.sonar.samples.php.checks;

import java.util.regex.Pattern;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.php.api.tree.Tree;
import org.sonar.plugins.php.api.tree.expression.LiteralTree;
import org.sonar.plugins.php.api.visitors.PHPVisitorCheck;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fangl
 */
@Rule(
  key = "S2",
  priority = Priority.MAJOR,
  name = "The Sql must fit with custom rules.",
  tags = {"convention"}
// Description can either be given in this annotation or through HTML name <ruleKey>.html located in package src/resources/org/sonar/l10n/php/rules/<repositoryKey>
// description = "<p>The following functions should not be used:</p> <ul><li>foo</li> <li>bar</li></ul>"
  )
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.DATA_RELIABILITY)
@SqaleConstantRemediation("5min")
public class CustomSqlCheck extends PHPVisitorCheck {
    
    private static final Pattern CUSTOM_SQL_RULE = Pattern.compile("select \\*", Pattern.CASE_INSENSITIVE);
    
    @Override
    public void visitLiteral(LiteralTree literal) {
      if (literal.is(Tree.Kind.REGULAR_STRING_LITERAL) && CUSTOM_SQL_RULE.matcher(literal.token().text()).find()) {
          context().newIssue(this, "use the exact field name instead of *").tree(literal);
      }
      super.visitLiteral(literal);
    }
}
