package com.empoluboyarov.core.impls;

import com.empoluboyarov.core.abstracts.AbstractTreeNode;
import com.empoluboyarov.core.interafaces.Source;
import com.empoluboyarov.core.interafaces.TreeNode;
import com.empoluboyarov.core.objects.OperationType;

import java.util.List;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public class DefaultSource extends AbstractTreeNode implements Source {

    private OperationType operationType; //тип операции - доход, расход, кредит и прочее

    public DefaultSource() {
    }

    public DefaultSource(List<TreeNode> childs) {
        super(childs);
    }

    public DefaultSource(List<TreeNode> childs, long id, String name, TreeNode parent) {
        super(childs, id, name, parent);
    }

    public DefaultSource(String name) {
        super(name);
    }

    public DefaultSource(String name, long id) {
        super(name, id);
    }

    public DefaultSource(String name, long id, OperationType operationType) {
        super(name, id);
        this.operationType = operationType;
    }

    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    // при добавлении дочернего элемента ему будет автоматически присваиваться тип операции родительского элемента
    @Override
    public void add(TreeNode child) {
        //TODO попробовать применить паттерн
        if (child instanceof DefaultSource)
            ((DefaultSource)child).setOperationType(operationType);
        super.add(child);
    }
}
