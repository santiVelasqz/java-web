/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaPersistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClasesPOJO.Incidencias;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpaPersistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Usuario
 */
public class IncidenciasJpaController implements Serializable {

    public IncidenciasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public IncidenciasJpaController(){
        emf = Persistence.createEntityManagerFactory("empresaUP");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Incidencias incidencias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(incidencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Incidencias incidencias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            incidencias = em.merge(incidencias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = incidencias.getId();
                if (findIncidencias(id) == null) {
                    throw new NonexistentEntityException("The incidencias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Incidencias incidencias;
            try {
                incidencias = em.getReference(Incidencias.class, id);
                incidencias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The incidencias with id " + id + " no longer exists.", enfe);
            }
            em.remove(incidencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Incidencias> findIncidenciasEntities() {
        return findIncidenciasEntities(true, -1, -1);
    }

    public List<Incidencias> findIncidenciasEntities(int maxResults, int firstResult) {
        return findIncidenciasEntities(false, maxResults, firstResult);
    }

    private List<Incidencias> findIncidenciasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Incidencias.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Incidencias findIncidencias(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Incidencias.class, id);
        } finally {
            em.close();
        }
    }

    public int getIncidenciasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Incidencias> rt = cq.from(Incidencias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Incidencias> mostrarIncidenciaEmpleadoOrigen(String nombreCompletoEmpleado) {
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Incidencias> query = em.createQuery("SELECT i FROM Incidencias i WHERE i.empleadoOrigen.nombreCompleto = :nombreCompletoEmpleado", Incidencias.class);
            query.setParameter("nombreCompletoEmpleado", nombreCompletoEmpleado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Incidencias> mostrarIncidenciaEmpleadoDestino(String nombreCompletoEmpleado) {
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Incidencias> query = em.createQuery("SELECT i FROM Incidencias i WHERE i.empleadoDestino.nombreCompleto = :nombreCompletoEmpleado", Incidencias.class);
            query.setParameter("nombreCompletoEmpleado", nombreCompletoEmpleado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
