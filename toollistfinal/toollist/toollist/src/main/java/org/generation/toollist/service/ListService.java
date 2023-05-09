package org.generation.toollist.service;

import org.generation.toollist.repository.entity.List;
import java.util.ArrayList;
public interface ListService {
    //save method is for 2 purposes - Create new item & Update existing item
    List save(List list);

    //Read all item from database
    ArrayList<List> all();

    List findById(int listId);
}


