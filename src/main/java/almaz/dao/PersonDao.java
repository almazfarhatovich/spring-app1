package almaz.dao;

import almaz.config.Config;
import almaz.model.Person;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDao implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory = Config.createEntityManagerFactory();

    public void save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Person> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Person> people = entityManager.createQuery("select p from Person p", Person.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return people;
    }


    public Person findById(long personId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.createQuery("select c from Person c where c.id=?1", Person.class).setParameter(1, personId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;

    }

    public void deleteById(Long personId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Person p where p.id = ?1").setParameter(1, personId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(long id, Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Person p set p.name=?1, p.age=?2, p.email=?3 where p.id=?4").
                setParameter(1, person.getName()).
                setParameter(2, person.getAge()).
                setParameter(3, person.getEmail()).
                setParameter(4, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }


}

