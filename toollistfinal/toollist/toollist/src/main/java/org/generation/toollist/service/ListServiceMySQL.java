package org.generation.toollist.service;

import org.generation.toollist.repository.ListRepository;
import org.generation.toollist.repository.entity.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.ArrayList;

import java.util.Optional;

@Service
public class ListServiceMySQL implements ListService {
    private final ListRepository listRepository;

    public ListServiceMySQL(@Autowired ListRepository listRepository)
    {
        this.listRepository = listRepository;
    }


    @Override
    public List save(List list)
    {
        //Since we have done the dependency injection of the itemRepository, therefore now we can call any method from the CrudRepository class
        return this.listRepository.save(list);

    }





    @Override
    public ArrayList<List> all()
    {
        // 1. @Query class provide by spring boot : select * from item
        // 2. Repository class provided by spring boot. we do not need to write a single query
        ArrayList<List> result = new ArrayList<>();
        listRepository.findAll().forEach(result::add);
        return result;

    }

    @Override
    public List findById(int listId )
    {
        Optional<List> customer = listRepository.findById(listId);
        List listResponse = customer.get();
        return listResponse;
    }









}
