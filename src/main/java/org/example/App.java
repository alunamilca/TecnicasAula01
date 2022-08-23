package org.example;

import org.example.dominio.Aluno;
import org.example.dominio.Curso;
import org.example.dominio.InscricaoCurso;
import org.example.validacao.ValidaAWS;
import org.example.validacao.ValidaTecnicasProgramacao;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();
        Curso curso = new Curso();
        curso.setNome("Tecnicas de Programação 4");
        curso.setDuraçao(6L);

       InscricaoCurso inscricaoCurso = new InscricaoCurso();
        inscricaoCurso.setCurso(curso);
        inscricaoCurso.setDataInicioDoCurso(LocalDate.now().plusMonths(2L));

        aluno.setInscricaoCursoList(new ArrayList<>());
        aluno.getInscricaoCursoList().add(inscricaoCurso);

        Curso cursoTecnicasProgramacao5 = new Curso("Técnicas de Programação 5", 8L);

        aluno.getInscricaoCursoList()
                        .add(new InscricaoCurso(aluno,cursoTecnicasProgramacao5,LocalDate.now().plusMonths(1L),
                                "Tecnicas de Programação 4",new ValidaTecnicasProgramacao()));

        Curso cursoAWS = new Curso("Serviço Cloud", 3L);

        aluno.getInscricaoCursoList().add(
                new InscricaoCurso(aluno,cursoAWS,LocalDate.now().plusMonths(2L),"Deployment",
                        Aluno a ,String s)-> aluno.containsCurso(s)));



        aluno.setMatricula("qualquer");
        aluno.setNome("Milca");
        LocalDate localDataNascimento = LocalDate.of(2000,9,1);
        aluno.setDataNascimento(
                Date.from(
                        localDataNascimento
                                .atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant())
        );

        System.out.println(aluno.apresentar());
    }
}



