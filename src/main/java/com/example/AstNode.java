package com.example;

import org.parboiled.trees.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class AstNode implements GraphNode {

    private final List<AstNode> children;
    private final AstType astType;

    public AstNode(AstType astType) {
        this.astType = astType;
        this.children = new ArrayList<AstNode>();
    }

    public AstType getAstType() {
        return astType;
    }

    @Override
    public List getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return astType.toString();
    }

}
