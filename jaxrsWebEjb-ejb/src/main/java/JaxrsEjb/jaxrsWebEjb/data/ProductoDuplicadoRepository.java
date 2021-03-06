/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package JaxrsEjb.jaxrsWebEjb.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import JaxrsEjb.jaxrsWebEjb.model.ProductoDuplicado;
import JaxrsEjb.jaxrsWebEjb.model.Producto;

@ApplicationScoped
public class ProductoDuplicadoRepository {

	@Inject
	private EntityManager em;

	public boolean isExist(Long id) {
		return (null != findById(id));
	}

	public ProductoDuplicado findById(Long id) {
		return em.find(ProductoDuplicado.class, id);
	}

	public ProductoDuplicado findByProducto(String nombreProducto) {
		TypedQuery<ProductoDuplicado> query = em.createQuery("SELECT p FROM ProductoDuplicado p WHERE p.producto.nombre = :nombre", ProductoDuplicado.class);
		List<ProductoDuplicado> p = query.setParameter("nombre", nombreProducto).getResultList();
		
		if(p.size()>0){
			return p.get(0);
		}else{
			System.out.println("No existen Productos Duplicados con este nombre!.");
			return null;
		}
	}
	
	public Producto findProductoByName(String nombre) {

		TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre", Producto.class);
		List<Producto> p = query.setParameter("nombre", nombre.trim()).getResultList();
		
		if(p.size()>0){
			return p.get(0);
		}else{
			System.out.println("No existen Productos con este nombre");
			return null;
		}
		
	}
}
