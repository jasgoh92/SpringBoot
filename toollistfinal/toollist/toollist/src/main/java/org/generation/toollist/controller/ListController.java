package org.generation.toollist.controller;
import org.generation.toollist.controller.dto.ListDTO;
import org.generation.toollist.repository.entity.List;
import org.generation.toollist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;


@RestController
@RequestMapping("/list")
public class ListController {

    private final ListService listService;

    // Dependency injection of the itemservice object so that the controller can call any methods in the itemserviceMySQL class
    public ListController(@Autowired ListService listService) {
        this.listService = listService;
    }

    // API endpoint - to be able to return all products to the front end
    // Frontend will issue a Get http request
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<List> getLists()
    {
        return listService.all();

    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(@RequestParam(name = "title", required = true) String title,
                     @RequestParam(name = "description", required = true) String description,
                     @RequestParam(name = "date", required = true) LocalDate date)  {

        ListDTO listDTO = new ListDTO(title, description, date);
        List list = new List(listDTO);
        this.listService.save(list);

    }

}
