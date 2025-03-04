package com.induwara.springTest.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRespository;

    public RunController(RunRepository runRespository) {
        this.runRespository = runRespository;
    }

    // @GetMapping("/api/runs")
    @GetMapping("")
    List<Run> fundAll() {
        return runRespository.findAll();
    }

    // @GetMapping("/api/runs/{id}")
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRespository.findById(id);

        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    // display hello world at http://localhost:8080/hello
    @RequestMapping("/hello")
    public String home() {
        return "Hello Wordld";
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRespository.save(run);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRespository.save(run);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRespository.delete(runRespository.findById(id).get());
    }

    // @GetMapping("/api/runs/location/{location}")
    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable String location) {
        return runRespository.findAllByLocation(location);
    }

}
