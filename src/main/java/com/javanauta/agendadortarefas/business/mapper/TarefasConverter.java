package com.javanauta.agendadortarefas.business.mapper;

import com.javanauta.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.business.dto.TarefasDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
