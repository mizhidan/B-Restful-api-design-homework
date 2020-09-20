package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.GenderType;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Trainee;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.TraineeException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TraineeRepository {
    private static final Map<Integer, Trainee> traineeMap = new LinkedHashMap<>();

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Trainee save(Trainee trainee) {
        trainee.setId(atomicInteger.get());
        traineeMap.put(atomicInteger.get(), trainee);
        atomicInteger.set(atomicInteger.get() + 1);
        return trainee;
    }

    public void deleteById(int traineeId) throws TraineeException {
        if (!traineeMap.containsKey(traineeId)) {
            throw new TraineeException(traineeId);
        }
        traineeMap.remove(traineeId);
    }

    public List<Trainee> findAll() {
        List<Trainee> traineeList = new ArrayList<>();
        traineeMap.forEach((integer, trainee) -> traineeList.add(trainee));
        return traineeList;
    }

    public List<Trainee> findTraineeByGender(GenderType genderType) {
        List<Trainee> traineeList = new ArrayList<>();
        traineeMap.forEach(((integer, trainee) -> {
            if (trainee.getGender() == genderType) {
                traineeList.add(trainee);
            }
        }));
        return traineeList;
    }
}
