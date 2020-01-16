package business.service;

import business.model.TestModel;
import data.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class TestService {

    private static TestRepository repo = new TestRepository();

    public static TestModel get(int id) {



        data.model.TestModel entity = repo.get(id);

        if (entity == null) return null;

        TestModel result = new TestModel();
        result.setId(entity.getId());
        result.setValue(entity.getValue());
        return result;
    }

    public static List<TestModel> getAll() {

        List<data.model.TestModel> list = repo.getAll();

        if (list == null || list.size() == 0) return null;

        List<TestModel> result = new ArrayList<>();
        TestModel model;
        for(data.model.TestModel t : list){
            model = new TestModel();
            model.setId(t.getId());
            model.setValue(t.getValue());
            result.add(model);
        }
        return result;

    }

    public static boolean add(TestModel model) {

        data.model.TestModel entity = new data.model.TestModel();
        entity.setId(model.getId());
        entity.setValue(model.getValue());
        return repo.add(entity);

    }

}