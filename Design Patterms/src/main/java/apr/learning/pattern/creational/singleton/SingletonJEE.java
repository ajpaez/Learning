package apr.learning.pattern.creational.singleton;

import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
// @DependsOn({"PrimaryBean", "SecondaryBean"})
public class SingletonJEE {

    // FUENTE: http://docs.oracle.com/javaee/6/tutorial/doc/gipvi.html

    private ConcurrentHashMap<Integer, String> miColeccion = null;

    @PostConstruct
    public void initialize() {
	this.miColeccion = new ConcurrentHashMap<Integer, String>();
    }
    // cache accessors omitted

    @PreDestroy
    private void shutdown() {
	this.miColeccion.clear();

    }
}
