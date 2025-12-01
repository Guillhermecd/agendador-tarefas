package com.javanauta.agendadortarefas.Infrastructure.repository;

import com.javanauta.agendadortarefas.Infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends MongoRepository<TarefasEntity, String> {
}
