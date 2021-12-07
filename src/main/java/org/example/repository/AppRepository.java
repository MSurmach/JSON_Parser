package org.example.repository;

import org.example.model.AppModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AppRepository {

    private static HashMap<Integer, AppModel> data = new HashMap<Integer, AppModel>();
    private static int sequence = 1;

    public void deleteById(int id) {
        data.remove(id);
    }

    public void add(AppModel model) {
        model.setId(sequence);
        data.put(sequence++, model);
    }

    public List<AppModel> getAllModels() {
        ArrayList<AppModel> allModelsList = new ArrayList<>(data.values());
        Collections.reverse(allModelsList);
        return allModelsList;
    }
}
