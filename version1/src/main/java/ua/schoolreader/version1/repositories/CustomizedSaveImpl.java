package ua.schoolreader.version1.repositories;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.transaction.annotation.Transactional;
import ua.schoolreader.version1.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Type;

public class CustomizedSaveImpl<Task> implements CustomizedSave<Task> {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public <S extends Task> S save(S entity) {
        // do your logic here
            entityManager.persist(entity);
            return entity;
    }
}
