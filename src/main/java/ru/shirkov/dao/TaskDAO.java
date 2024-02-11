package ru.shirkov.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shirkov.entity.Task;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskDAO {
    private final SessionFactory sessionFactory;

    public TaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional(readOnly = true)
    public List<Task> getAll(int offser, int limit) {
        Query<Task> query = getSession().createQuery("select t from Task t", Task.class);
        query.setFirstResult(offser);
        query.setMaxResults(limit);
        return query.getResultList();
    }

        @Transactional(readOnly = true)
        public int getAllCount () throws SQLException {
            Query<Long> query = getSession().createQuery("select count(t) from Task t", Long.class);
            return Math.toIntExact(query.uniqueResult());

        }

        @Transactional()
        public Task getById ( int id) throws SQLException {
            Query<Task> query = getSession().createQuery("select t from Task t where t.id=:ID", Task.class);
            query.setParameter("ID", id);
            return query.uniqueResult();

        }

        @Transactional
        public void edit (Task task) throws SQLException {
            getSession().persist(task);
        }

        @Transactional
        public void delete (Task task){
            getSession().remove(task);
        }
    }
