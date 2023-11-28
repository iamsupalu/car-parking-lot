package org.repositories;

import org.models.Gate;
import org.models.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    Map<Integer,Gate> gates=new HashMap<>();


    public Optional<Gate> findGateById(int gateId){
        if(gates.containsKey(gateId)) return Optional.of(gates.get(gateId));
        else {
            return Optional.empty();
//            gates.put(gateId,new Gate());
//            return Optional.of(gates.get(gateId));
        }
    }
}

