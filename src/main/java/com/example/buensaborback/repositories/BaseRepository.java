package com.example.buensaborback.repositories;


import com.example.buensaborback.domain.entities.Base;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
    Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    @Override
    @Transactional
    default void delete(E entity) {
        logger.info("EJECUTANDO DELETE SOBREESCRITO");
        entity.setEliminado(true);
        save(entity);
    }

    default E getEliminadoById(ID id) {
        logger.info("EJECUTANDO GEY BY ID SOBREESCRITO");
        var optionalEntity = findById(id);

        if (optionalEntity.isEmpty()) {
            String errMsg = "La entidad con el id " + id + "no se encuentra borrada logicamente";
            logger.error(errMsg);
            throw new RuntimeException(errMsg);
        }

        var entity = optionalEntity.get();
        if (!entity.isEliminado()) {
            String errMsg = "La entidad del tipo " + entity.getClass().getSimpleName() + " con el id " + id + "no se encuentra borrada logicamente";
            logger.error(errMsg);
            throw new RuntimeException(errMsg);
        }
        return entity;
    }

    @Override
    default E getById(ID id) {
        logger.info("EJECUTANDO GEY BY ID SOBREESCRITO");
        var optionalEntity = findById(id);

        if (optionalEntity.isEmpty()) {
            String errMsg = "La entidad con el id " + id + " se encuentra borrada logicamente";
            logger.error(errMsg);
            throw new RuntimeException(errMsg);
        }

        var entity = optionalEntity.get();
        if (entity.isEliminado()) {
            String errMsg = "La entidad del tipo " + entity.getClass().getSimpleName() + " con el id " + id + " se encuentra borrada logicamente";
            logger.error(errMsg);
            throw new RuntimeException(errMsg);
        }
        return entity;
    }

    default List<E> getAll() {
        logger.info("EJECUTANDO GET ALL SIN FILTRO");
        var entities = findAll().stream().toList();
        return entities;
    }

}
