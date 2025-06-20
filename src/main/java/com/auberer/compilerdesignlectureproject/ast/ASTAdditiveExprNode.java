package com.auberer.compilerdesignlectureproject.ast;

import com.auberer.compilerdesignlectureproject.lexer.TokenType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class ASTAdditiveExprNode extends ASTNode {

  public enum AdditiveOp {
    PLUS, MINUS
  }

  List<AdditiveOp> opList = new ArrayList<>();

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visitAdditiveExpr(this);
  }

  public static Set<TokenType> getSelectionSet() {
    return ASTMultiplicativeExprNode.getSelectionSet();
  }

  public void addOp(AdditiveOp op) {
    opList.add(op);
  }

  public List<ASTMultiplicativeExprNode> getOperands() {
    return getChildren(ASTMultiplicativeExprNode.class);
  }
}
