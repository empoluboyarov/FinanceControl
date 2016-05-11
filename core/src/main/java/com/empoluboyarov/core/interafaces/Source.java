package com.empoluboyarov.core.interafaces;

import com.empoluboyarov.core.objects.OperationType;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public interface Source {

    String getName();

    long getId();

    OperationType getOperationType();

}
