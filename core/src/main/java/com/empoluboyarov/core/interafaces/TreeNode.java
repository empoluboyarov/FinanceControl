package com.empoluboyarov.core.interafaces;

import java.util.List;

/**
 * Created by Evgeniy on 10.05.2016.
 */
public interface TreeNode {

    String getName();

    long getId(); // получение уникального идентификатора элемента

    void add(TreeNode child); // добавление дочернего элемента

    void remove(TreeNode child); // добавление родительского элемента

    List<TreeNode> getChilds(); // получение родительских элементов первого уровня

    TreeNode getChild(long id); //  получение дочернего элемента по id

    TreeNode getParent(); // получение родительского элемента

    void setParent(TreeNode parent); // установка родительского элемента


}
