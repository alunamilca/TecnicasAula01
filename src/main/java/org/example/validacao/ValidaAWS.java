package org.example.validacao;

import org.example.dominio.Aluno;
import org.example.dominio.InscricaoCurso;

import java.time.LocalDate;
import java.util.List;

public class ValidaAWS implements ValidaInscricaoCurso{
    @Override
    public boolean isvalid(Aluno aluno, String nomeCurso) {
        List<InscricaoCurso> cursos = aluno.getInscricaoCursoList();
        InscricaoCurso inscricaoCurso = null;
        for (InscricaoCurso inscricaoCursoExistente:cursos){
            if (inscricaoCursoExistente.getCurso().getNome().equals(nomeCurso)){
                inscricaoCurso=inscricaoCursoExistente;
                break;
            }
        }
        return null!=inscricaoCurso && inscricaoCurso.getDataInicioDoCurso().isBefore(LocalDate.now());
    }
}
