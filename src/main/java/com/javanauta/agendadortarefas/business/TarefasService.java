package com.javanauta.agendadortarefas.business;


import com.javanauta.agendadortarefas.Infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.Infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.Infrastructure.repository.tarefasRepository;
import com.javanauta.agendadortarefas.Infrastructure.security.JwtUtil;
import com.javanauta.agendadortarefas.business.dto.TarefasDTO;
import com.javanauta.agendadortarefas.business.mapper.TarefasConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final tarefasRepository tarefaRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.Pendente);
        dto.setEmailUsuario(email);

        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefaRepository.save(entity));
    }
    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefasDTO(
                tarefaRepository.findByDataEventoBetween(dataInicial, dataFinal));

    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefasEntity> listTarefas = tarefaRepository.findByEmailUsuario(email);
        return tarefaConverter.paraListaTarefasDTO(listTarefas);
    }

}
