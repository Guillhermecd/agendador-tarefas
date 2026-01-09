package com.javanauta.agendadortarefas.Infrastructure.repository;

import com.javanauta.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.Infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface tarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity>
    findByDataEventoBetweenAndStatusNotificacaoEnum(
            LocalDateTime dataInicial, LocalDateTime dataFinal, StatusNotificacaoEnum status);

    List<TarefasEntity> findByEmailUsuario(String email);
}


