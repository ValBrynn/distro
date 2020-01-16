
package data.repository;

import data.model.TestModel;
import utilities.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestRepository implements Repository<TestModel> {

    private String unitName;
    private JPAUtil jpaUtil;

    public TestRepository() {
        unitName = "hibernate-unit";
        jpaUtil = new JPAUtil();
    }

    public TestRepository(String unitName) {
        this.unitName = unitName;
        jpaUtil = new JPAUtil();
    }

    @Override
    public boolean add(TestModel entity) {

        EntityManager em = null;

        try{
            em = jpaUtil.getEntityManagerFactory(unitName).createEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e){
            System.out.println("Exception in TestRepository.add: " + e.getMessage());
            if(em != null) em.close();
        }

        return false;
    }

    @Override
    public TestModel delete(int id) {
        return null;
    }

    @Override
    public TestModel get(int id) {

        EntityManager em = null;

        try{
            em = jpaUtil.getEntityManagerFactory(unitName).createEntityManager();
            TestModel result = em.find(TestModel.class, id);
            em.close();
            return result;
        } catch (Exception e){
            System.out.println("Exception in TestRepository.get: " + e.getMessage());
            if(em != null) em.close();
        }

        return null;
    }

    @Override
    public List<TestModel> getAll() {
        EntityManager em = null;

        try{
            em = jpaUtil.getEntityManagerFactory(unitName).createEntityManager();
            List<TestModel> result = em.createQuery("SELECT t FROM TestModel t").getResultList();
            em.close();
            return result;
        } catch (Exception e){
            System.out.println("Exception in TestRepository.getAll: " + e.getMessage());
            if(em != null) em.close();
        }

        return null;
    }

    @Override
    public boolean update() {
        return false;
    }

}

