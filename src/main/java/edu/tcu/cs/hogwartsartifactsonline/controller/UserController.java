package edu.tcu.cs.hogwartsartifactsonline.controller;

import edu.tcu.cs.hogwartsartifactsonline.domain.Result;
import edu.tcu.cs.hogwartsartifactsonline.domain.StatusCode;
import edu.tcu.cs.hogwartsartifactsonline.domain.User;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import edu.tcu.cs.hogwartsartifactsonline.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public Result findAll(){
        List<User> all = service.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(id));
    }

    @PostMapping()
    public Result save(@RequestBody User user){
        service.save(user);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody User user){
        service.update(id, user);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
