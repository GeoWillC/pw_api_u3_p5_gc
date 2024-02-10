package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("ENTRRO");
		List<Materia> lista=this.iMateriaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTO> listTO=new ArrayList<>();
		for(Materia mat:lista) {
			listTO.add(this.convertir(mat));
		}
		return listTO;
	}
	private MateriaTO convertir (Materia mat) {
		MateriaTO matTO=new MateriaTO();
		matTO.setCredito(mat.getCredito());
		matTO.setId(mat.getId());
		matTO.setNombre(mat.getNombre());
		System.out.println(matTO);
		return matTO;
	}
}
