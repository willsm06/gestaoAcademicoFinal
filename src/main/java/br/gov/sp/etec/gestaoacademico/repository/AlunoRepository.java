package br.gov.sp.etec.gestaoacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etec.gestaoacademico.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	
}
