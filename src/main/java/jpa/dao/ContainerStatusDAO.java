package jpa.dao;

import jpa.ContainerStatus;
import jpa.enums.ContainerStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("containerStatusDao")
@Transactional
public class ContainerStatusDAO {

    @PersistenceContext
    private EntityManager em;

    public Collection<ContainerStatus> listAll() {
        Query query = em.createQuery("select a from ContainerStatus a");
        return query.getResultList();
    }

    public ContainerStatus getContainerStatusById(Long id) {
        return em.find(ContainerStatus.class, id);
    }

    public ContainerStatus getContainerStatusByStatus(ContainerStatusEnum containerStatusEnum) {
        Query query = em.createQuery("select a from ContainerStatus a where a.status = :status");
        query.setParameter("status", containerStatusEnum);
        return (ContainerStatus) query.getSingleResult();
    }
}
