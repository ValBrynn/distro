package data.repository;

import data.model.UserModel;

import java.util.List;

public interface Repository<E> {

    public boolean add(E entity);
    public E delete(int id);
    public E get(int id);
    public List<E> getAll();
    public boolean update();


}