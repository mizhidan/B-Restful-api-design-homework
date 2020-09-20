package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.GenderType;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Trainee;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.TraineeException;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee addTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
        return trainee;
    }

    public void deleteTrainee(int traineeId) throws TraineeException {
        traineeRepository.deleteById(traineeId);
    }

    public List<Trainee> getTraineeList(GenderType gender) {
        if (gender == null) {
            return traineeRepository.findAll();
        }
        return traineeRepository.findTraineeByGender(gender);
    }
}
