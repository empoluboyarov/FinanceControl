package com.empoluboyarov.core.abstracts;

import com.empoluboyarov.core.interafaces.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 10.05.2016.
 */
public abstract class AbstractTreeNode implements TreeNode {

    private long id;
    private List<TreeNode> childs = new ArrayList<>();
    private TreeNode parent;
    private String name;

    public AbstractTreeNode() {
    }

    public AbstractTreeNode(String name) {
        this.name = name;
    }

    public AbstractTreeNode(String name, long id) {
        this.id = id;
        this.name = name;
    }

    public AbstractTreeNode(List<TreeNode> childs) {
        this.childs = childs;
    }

    public AbstractTreeNode(List<TreeNode> childs, long id, String name, TreeNode parent) {
        this.childs = childs;
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void add(TreeNode child) {
        child.setParent(this);
        childs.add(child);
    }

    @Override
    public void remove(TreeNode child) {
        childs.remove(child);
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public List<TreeNode> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public TreeNode getChild(long id) {
        for (TreeNode child : childs) {
            if (child.getId() == id)
                return child;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTreeNode that = (AbstractTreeNode) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
