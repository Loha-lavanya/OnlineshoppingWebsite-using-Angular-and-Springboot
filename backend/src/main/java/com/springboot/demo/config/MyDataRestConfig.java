package com.springboot.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.springboot.demo.entity.Product;
import com.springboot.demo.entity.ProductCategory;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	// JPA entity maanager-------iplements programming lifecycles and lifecycle rules
	
	@Autowired     
	private EntityManager entityManager;   
 
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    	   
    	/*   instead of manually creating rest controller and defines access to GET method
    	 *  use  spring data rest API to disable http methods..
    	 */

   //   call an internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // by default spring  data rest  does not expose entityid..entity is embedded in hateos links
    //	expose entity ids
        

        // - get a list of all entity classes from the entity manager
    	//Retrieves a collection of entities with an associated entity list 
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());       // Return the represented Java type.
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }	


}

      /*
         config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
          EntityManagerFactory instance is to support instantiation of EntityManager instances.
          An EntityManagerFactory is constructed for a specific database, and by managing resources efficiently 
           provides an efficient way to construct multiple EntityManager instances for that database. 
     */
        


