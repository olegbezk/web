package stars.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import stars.entities.Constellation;
import stars.entities.Star;

/**
 *
 * @author Eugeny
 */
@Stateless
public class StarsSessionBean {

    @PersistenceContext(unitName = "StarsWebPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Constellation addConstellation(String latinName, String russianName) {
        Constellation result = new Constellation(0, latinName);
        result.setRussianName(russianName);
        em.persist(result);
        return result;
    }

    public Constellation addConstellation(String latinName) {
        Constellation result = new Constellation(0, latinName);
        em.persist(result);
        return result;
    }

    public Constellation updateConstellation(Constellation cons, String latinName, String russianName) {
        if (latinName.isEmpty()) {
            cons.setRussianName(russianName);
        } else {
            cons.setLatinName(latinName);
            if (!russianName.isEmpty()) {
                cons.setRussianName(russianName);
            }
        }
        em.merge(cons);
        return cons;
    }

    public List listConstellations() {
        return em.createNamedQuery("Constellation.findAll").getResultList();
    }

    public List listStars() {
        return em.createNamedQuery("Star.findAll").getResultList();
    }

    public List listStars(Constellation constellation) {
        return em.createNamedQuery("Star.findByConstellationId").setParameter("constellationId", constellation.getId()).getResultList();
    }    

    public List listStars(int constellationId) {
        return em.createNamedQuery("Star.findByConstellationId").setParameter("constellationId", constellationId).getResultList();
    }

    public Constellation findConstellation(int id) {
        return em.find(Constellation.class, id);
    }
    
    public Star addStar(int constellationId, String latinName, String russianName, long declination, long ascension, int magnitude, int distance) {
        Star s = new Star(0, constellationId);
        s.setLatinName(latinName);
        s.setRussianName(russianName);
        s.setDeclination(declination);
        s.setRightAscension(ascension);
        s.setMagnitude(magnitude);
        s.setDistance(distance);
        s.setConstellation(em.find(Constellation.class, constellationId));
        em.persist(s);
        return s;
    }

    public Star findStar(int id) {
        return (Star) em.createNamedQuery("Star.findById").setParameter("id", id).getSingleResult();
    }

    public Star updateStar(Star star, Constellation constellation, String latinName, String russianName, long declination, long ascension, int magnitude, int distance) {
        star.setConstellation(constellation);
        star.setLatinName(latinName);
        star.setRussianName(russianName);
        star.setDeclination(declination);
        star.setRightAscension(ascension);
        star.setMagnitude(magnitude);
        return em.merge(star);
    }

    public List<Star> findStarsBrighterThan(int magnitude) {
        return em.createQuery("select s from Star s where s.magnitude <= :magnitude").setParameter("magnitude", magnitude).getResultList();
    }
    
    public List<Star> findStarsVisibleIn(int latitude) {
        if (latitude > 0) {
            return em.createQuery("select s from Star s where s.declination >= :value").setParameter("value", latitude-90).getResultList();
        } else {
            return em.createQuery("select s from Star s where s.declination <= :value").setParameter("value", latitude+90).getResultList();
        }
    }
}
