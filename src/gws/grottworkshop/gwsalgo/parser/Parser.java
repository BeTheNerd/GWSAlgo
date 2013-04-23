package gws.grottworkshop.gwsalgo.parser;




import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.leaf.IdentifierElement;
import gws.grottworkshop.gwsalgo.ast.leaf.IntegerElement;
import gws.grottworkshop.gwsalgo.ast.operation.AddOperation;
import gws.grottworkshop.gwsalgo.ast.operation.DivideOperation;
import gws.grottworkshop.gwsalgo.ast.operation.MultiplyOperation;
import gws.grottworkshop.gwsalgo.ast.operation.NegativeOperation;
import gws.grottworkshop.gwsalgo.ast.operation.PowerOperation;
import gws.grottworkshop.gwsalgo.ast.operation.SubtractOperation;
import gws.grottworkshop.gwsalgo.exception.ParseException;
import gws.grottworkshop.gwsalgo.scanner.Scanner;
import gws.grottworkshop.gwsalgo.scanner.Token;
import gws.grottworkshop.gwsalgo.scanner.TokenType;

import static gws.grottworkshop.gwsalgo.scanner.TokenType.*;

/**
 * This is the formal grammar of the language:
 * <pre>
 * Expression         --> MultiplicativeTerm {( "+" | "-" ) MultiplicativeTerm}
 * MultiplicativeTerm --> PowerTerm {( "*" | "/" ) PowerTerm}
 * PowerTerm          --> ParensAndUnaryTerm ["^" PowerTerm]
 * ParensAndUnaryTerm --> ValueTerm | "(" Expression ")" | "-" PowerTerm | "+" PowerTerm
 * </pre>
 */
public class Parser {
  private Scanner scanner;
  private Token currentToken;

  public Parser(String text, boolean ignoreWhitespace) {
    scanner = new Scanner(text, ignoreWhitespace);
    consume();
  }

  public ASTNode parse() {
    ASTNode expression = parseAdditiveExpression();
    match(EOF, "End of expression expected.");
    if (expression != null) {
      setParents(expression, null);
    }
    return expression;
  }

  private void setParents(ASTNode expression, ASTNode parent) {
    expression.setParent(parent);
    for (ASTNode child : expression.getChildren()) {
      setParents(child, expression);
    }
  }

  private ASTNode parseAdditiveExpression() {
    ASTNode expression = parseMultiplicativeExpression();
    TokenType tokenType = currentToken.getType();
    while (tokenType == PLUS || tokenType == MINUS) {
      consume();
      ASTNode expression2 = parseMultiplicativeExpression();
      if (tokenType == PLUS) {
        expression = new AddOperation(expression, expression2);
      } else {
        expression = new SubtractOperation(expression, expression2);
      }
      tokenType = currentToken.getType();
    }
    return expression;
  }

  private ASTNode parseMultiplicativeExpression() {
    ASTNode expression = parsePowerExpression();
    TokenType tokenType = currentToken.getType();
    while (tokenType == TIMES || tokenType == DIVISION) {
      consume();
      ASTNode expression2 = parsePowerExpression();
      if (tokenType == TIMES) {
        expression = new MultiplyOperation(expression, expression2);
      } else {
        expression = new DivideOperation(expression, expression2);
      }
      tokenType = currentToken.getType();
    }
    return expression;
  }

  private ASTNode parsePowerExpression() {
    ASTNode expression = parseParensAndUnaryExpression();
    TokenType tokenType = currentToken.getType();
    if (tokenType == POWER) {
      consume();
      ASTNode expression2 = parsePowerExpression();
      return new PowerOperation(expression, expression2);
    } else {
      return expression;
    }
  }

  private ASTNode parseParensAndUnaryExpression() {
    TokenType tokenType = currentToken.getType();
    switch (tokenType) {
      case IDENTIFIER: {
        IdentifierElement identifierElement = new IdentifierElement(currentToken);
        consume();
        return identifierElement;
      }
      case INTEGER: {
        IntegerElement integerElement = new IntegerElement(currentToken);
        consume();
        return integerElement;
      }
      case LPAREN: {
        consume();
        ASTNode expression = parseAdditiveExpression();
        match(RPAREN, ") expected");
        consume();
        return expression;
      }
      case MINUS: {
        consume();
        ASTNode expression = parsePowerExpression();
        return new NegativeOperation(expression);
      }
      case PLUS: {
        consume();
        ASTNode expression = parsePowerExpression();
        return expression;
      }
    }

    return null;
  }

  private void match(TokenType tokenType, String errorMessage) {
    if (currentToken.getType() != tokenType) {
      throw new ParseException(errorMessage);
    }
  }

  private void consume() {
    currentToken = scanner.nextToken();
  }
}
