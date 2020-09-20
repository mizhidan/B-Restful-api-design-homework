package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.GenderType;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Trainee;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.TraineeException;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.TraineeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping("/trainees")
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/{traineeId}")
    public void deleteTrainee(@PathVariable int traineeId) throws TraineeException {
       traineeService.deleteTrainee(traineeId);
    }

    @GetMapping(path = "/trainees")
    public List<Trainee> getTraineeList(@RequestParam(required = false) GenderType gender) {
        return traineeService.getTraineeList(gender);
    }
}
