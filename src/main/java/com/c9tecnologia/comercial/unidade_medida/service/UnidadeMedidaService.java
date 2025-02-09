package com.c9tecnologia.comercial.unidade_medida.service;

import com.c9tecnologia.comercial.unidade_medida.dto.UnidadeMedidaInputDTO;
import com.c9tecnologia.comercial.unidade_medida.dto.UnidadeMedidaOutputDTO;
import com.c9tecnologia.comercial.unidade_medida.model.UnidadeMedida;
import com.c9tecnologia.comercial.unidade_medida.repository.UnidadeMedidaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeMedidaService {
    private UnidadeMedidaRepository unidadeMedidaRepository;
    private ModelMapper modelMapper;

    public UnidadeMedidaService(UnidadeMedidaRepository unidadeMedidaRepository, ModelMapper modelMapper){
        this.unidadeMedidaRepository = unidadeMedidaRepository;
        this.modelMapper = modelMapper;
    }

    public List<UnidadeMedidaOutputDTO> listarUnidadeMedidas(){
        List<UnidadeMedida> unidadeMedidaList = unidadeMedidaRepository.findAll();
        return unidadeMedidaList.stream()
                .map(unidadeMedida -> modelMapper.map(unidadeMedida, UnidadeMedidaOutputDTO.class))
                .toList();
    }

    @Transactional
    public UnidadeMedidaOutputDTO criarUnidadeMedida(UnidadeMedidaInputDTO unidadeInput){
        UnidadeMedida unidadeMapper = modelMapper.map(unidadeInput, UnidadeMedida.class);
        UnidadeMedida unidadeSalvo = unidadeMedidaRepository.save(unidadeMapper);
        return modelMapper.map(unidadeSalvo, UnidadeMedidaOutputDTO.class);
    }

    public UnidadeMedidaOutputDTO buscarUnidadePorId(Long id){
        UnidadeMedida unidadeMedida = unidadeMedidaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Não foi encontrado Unidade de Medida"));

        return modelMapper.map(unidadeMedida, UnidadeMedidaOutputDTO.class);
    }

    @Transactional
    public UnidadeMedidaOutputDTO atualiarUnidadeMedida(Long id, UnidadeMedidaInputDTO unidadeMedidaInput){
        UnidadeMedida unidadeMedida = unidadeMedidaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Não foi encontrado Unidade de Medida" + unidadeMedidaInput.getNome()));

        modelMapper.map(unidadeMedidaInput, unidadeMedida);

        UnidadeMedida unidadeMedidaAtualizada = unidadeMedidaRepository.save(unidadeMedida);
        return modelMapper.map(unidadeMedidaAtualizada, UnidadeMedidaOutputDTO.class);
    }

    public void deleteUnidade(Long id){
        if(!unidadeMedidaRepository.existsById(id)){
            throw new EntityNotFoundException("Unidade de Medida não encontrada!");
        }
        unidadeMedidaRepository.deleteById(id);
    }
}
